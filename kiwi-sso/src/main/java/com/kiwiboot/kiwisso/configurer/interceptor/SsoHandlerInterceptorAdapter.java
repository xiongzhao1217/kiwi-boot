package com.kiwiboot.kiwisso.configurer.interceptor;


import com.kiwiboot.kiwisso.configurer.init.AppLoader;
import com.kiwiboot.kiwisso.model.vo.SsoUser;
import com.kiwiboot.kiwisso.utils.JwtUtils;
import com.kiwiframework.core.enums.ResultCode;
import com.kiwiframework.core.exception.AppException;
import com.kiwiframework.core.utils.WebUtil;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Set;

/**
 * 单点登录拦截器
 * @author xiongzhao
 * @date 18/12/2
 */
@Component
public class SsoHandlerInterceptorAdapter extends AppHandlerInterceptorAdapter {

    /**
     * 需要拦截的Path
     *
     * @return
     */
    @Override
    public String[] pathPatterns () {
        return new String[]{"/**"};
    }

    /**
     * 需要忽略的Path
     *
     * @return
     */
    @Override
    public String[] excludePathPatterns() {
        return new String[]{
                "/user/dologin",
                "/user/register",
                "/user/logout"
        };
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 校验登录
        Cookie[] cookies = request.getCookies();
        String token = Arrays.stream(cookies)
                .filter(cookie -> "token".equals(cookie.getName()))
                .map(Cookie::getValue)
                .findFirst()
                .orElseThrow(() -> new AppException(ResultCode.TOKEN_EXPRIED, "token无效"));
        SsoUser user = JwtUtils.parseJWT(token);
        // 保存登录用户信息
        WebUtil.saveSsoUser(user);
        // 校验接口访问权限
        Set<Long> roleIds = AppLoader.CACHE_ACCESS.get(request.getRequestURI());
        if (roleIds == null) {
            return true;
        }
        Set<String> userRoleIds = user.getRoleIds();
        if (CollectionUtils.isEmpty(userRoleIds)) {
            throw new AppException(ResultCode.UNAUTHORIZED);
        }
        roleIds.stream()
                .filter(roleId -> userRoleIds.contains(roleId + ""))
                .findFirst()
                .orElseThrow(() -> new AppException(ResultCode.UNAUTHORIZED));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }
}
