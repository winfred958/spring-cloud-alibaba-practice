package com.winfred.auth.controller;

import com.winfred.auth.entity.TestEntity;
import com.winfred.auth.entity.UserInfo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String toLoginPage(HttpServletRequest request, HttpServletResponse response, Map<String, Object> parameter) {
    TestEntity testEntity = new TestEntity();
    testEntity.setName("啦啦啦");
    testEntity.setMessage("请登录");

    parameter.put("testEntity", testEntity);

    parameter.put("userInfo", new UserInfo());
    return "login.html";
  }


  @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public String login(
          HttpServletRequest request,
          HttpServletResponse response,
          @Valid UserInfo userInfo,
          Model model
  ) {

    TestEntity testEntity = new TestEntity();
    testEntity.setName(userInfo.getUserName());
    testEntity.setMessage("你好呀");

    model.addAttribute("testEntity", testEntity);

    return "loginSuccess.html";
  }
}
