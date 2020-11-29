package com.winfred.auth.controller;

import com.winfred.auth.entity.TestEntity;
import com.winfred.auth.entity.request.LoginInfo;
import com.winfred.auth.entity.response.TokenResponse;
import com.winfred.auth.service.AuthToken;
import com.winfred.common.global.constant.AuthConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private AuthToken authToken;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String toLoginPage(HttpServletRequest request, HttpServletResponse response, Map<String, Object> parameter) {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("啦啦啦");
        testEntity.setMessage("请登录");

        parameter.put("testEntity", testEntity);

        parameter.put("userInfo", new LoginInfo());
        return "login.html";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody LoginInfo loginInfo,
            Model model
    ) {
        // 认证
        TokenResponse authorizationToken = authToken.getAuthorizationToken(loginInfo);
        String token = authorizationToken.getToken();

        // FIXME: 登陆成功设置 cookie
        // 设置 cookie
        Cookie cookie = new Cookie(AuthConstant.TOKEN_NAME.getName(), token);
        cookie.setPath("/");
        cookie.setMaxAge(-1);
        // 禁止js操作cookie, 防止 xss攻击
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        TestEntity testEntity = new TestEntity();
        testEntity.setName(loginInfo.getUserName());
        testEntity.setMessage("你好呀");

        model.addAttribute("testEntity", testEntity);

        return "loginSuccess.html";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestBody LoginInfo userInfo
    ) {
        String header = request.getHeader("referer");
        // 设置 cookie, 清除
        Cookie cookie = new Cookie(AuthConstant.TOKEN_NAME.getName(), "");
        cookie.setPath("/");
        cookie.setMaxAge(-1);
        // 禁止js操作cookie, 防止 xss攻击
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        try {
            response.sendRedirect(header);
        } catch (IOException e) {
            log.error("", e);
        }
    }
}
