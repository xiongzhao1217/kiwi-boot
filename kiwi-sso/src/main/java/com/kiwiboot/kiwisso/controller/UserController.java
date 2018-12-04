package com.kiwiboot.kiwisso.controller;
import com.kiwiboot.kiwisso.constant.ValidatedGroup;
import com.kiwiboot.kiwisso.model.vo.SsoUser;
import com.kiwiboot.kiwisso.service.MenuService;
import com.kiwiboot.kiwisso.utils.JwtUtils;
import com.kiwiframework.core.enums.ResultCode;
import com.kiwiframework.core.exception.AppException;
import com.kiwiframework.core.utils.Checker;
import com.kiwiframework.core.utils.WebUtil;
import com.kiwiframework.easycoding.api.ApiResult;
import com.kiwiframework.easycoding.api.ResultGenerator;
import com.kiwiboot.kiwisso.model.User;
import com.kiwiboot.kiwisso.service.UserService;
import com.kiwiframework.easycoding.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
/**
 * UserController created on 2018/11/04.
 * @author xiongzhao.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private MenuService menuService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult add(User user) {
        userService.insertSelective(user);
        return ResultGenerator.success();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult delete(@RequestParam Integer id) {
        userService.deleteById(id);
        return ResultGenerator.success();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult update(User user) {
        userService.updateSelective(user);
        return ResultGenerator.success();
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult detail(@RequestParam Integer id) {
        User user = userService.selectById(id);
        return ResultGenerator.success(user);
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public ApiResult list(PageBean pageBean, User query) {
        PageHelper.startPage(pageBean).setOrderBy(pageBean.getOrderBy());
        List<User> list = userService.find(query);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.success(pageInfo);
    }

    /**
     * 登录
     * @param loginUser
     * @param response
     * @return
     */
    @PostMapping(value = "/dologin")
    @ResponseBody
    public ApiResult<String> dologin(@Validated(ValidatedGroup.User.class) User loginUser, HttpServletResponse response) {
        String token = userService.doLogin(loginUser);
        // 写入token到cookie
        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(24 * 3600);
        cookie.setPath("/");
        response.addCookie(cookie);
        return ResultGenerator.success(token);
    }

    /**
     * 获取登录用户信息
     * @param token
     * @return
     */
    @GetMapping("/getUserInfo")
    @ResponseBody
    public ApiResult<User> getUserInfo(@CookieValue(value = "token", required = false) String token, Long appsId, SsoUser ssoUser) {
        Checker.notNull(appsId, "应用id不能为空");
        SsoUser user = (SsoUser) WebUtil.getSsoUser();
        user.setMenuList(menuService.findByUser(user.getId(), appsId));
        return ResultGenerator.success(user);
    }

    /**
     * 用户注册
     * @param registerUser
     * @return
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public ApiResult<User> register(@Validated({
            ValidatedGroup.User.class,
            ValidatedGroup.UserSelf.class
    }) User registerUser) {
        try {
            userService.register(registerUser);
        } catch (DuplicateKeyException dupExp) {
            throw new AppException(ResultCode.FAIL, "手机号或邮箱已经被使用,请更换其他账号");
        }
        return ResultGenerator.success();
    }

    /**
     * 管理员创建用户
     * @param user
     * @return
     */
    @PostMapping(value = "/adminAddUser")
    @ResponseBody
    public ApiResult<User> adminAddUser(@Validated(ValidatedGroup.User.class) User user) {
        try {
            Checker.notBlank(user.getNickName(), "姓名不能为空");
            userService.adminAddUser(user);
        } catch (DuplicateKeyException dupExp) {
            throw new AppException(ResultCode.FAIL, "手机号或邮箱已经被使用,请更换其他账号");
        }
        return ResultGenerator.success();
    }
}
