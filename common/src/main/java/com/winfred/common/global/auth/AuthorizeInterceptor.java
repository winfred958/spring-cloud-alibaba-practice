package com.winfred.common.global.auth;

import com.winfred.common.global.constant.AuthConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * 基于注解的拦截
 * 1. 服务间调用拦截 (当前类)
 * 2. 外部访问的拦截 (业务网关)
 */
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Authorize annotation = handlerMethod.getMethod().getDeclaredAnnotation(Authorize.class);
        if (annotation == null) {
            // no annotation, no auth
            return true;
        }
        String[] values = annotation.values();

        String tokenName = AuthConstant.TOKEN_NAME.getName();
        Cookie cookie = Arrays
                .stream(request.getCookies())
                .filter(e -> {
                    return StringUtils.equals(e.getName(), tokenName);
                })
                .findFirst()
                .orElse(null);
        if (cookie == null) {
            // FIXME: Permission Denied
            throw new RuntimeException();
        }
        String cookieValue = cookie.getValue();
        // FIXME: JWT cookie decode -> roles annotation
        /**
         * 方案一: Controller + annotation 标识 (静态)
         * 方案二: DB(cache) 获取 role & mapping 关系 (动态)
         */
        request.getRequestURI();

        return true;
    }
}
