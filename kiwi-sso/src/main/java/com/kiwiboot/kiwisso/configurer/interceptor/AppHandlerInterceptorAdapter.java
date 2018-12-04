package com.kiwiboot.kiwisso.configurer.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 拦截器基类
 * @author xiongzhao
 * @date 18/12/2
 */
public abstract class AppHandlerInterceptorAdapter implements HandlerInterceptor {

    /**
     * 需要拦截的Path
     *
     * @return
     */
    public abstract String[] pathPatterns();

    /**
     * 需要忽略的Path
     *
     * @return
     */
    public String[] excludePathPatterns() {
        return null;
    }
}
