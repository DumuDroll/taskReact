package com.dddd.croom.demo.controller;

import com.dddd.croom.demo.constants.Constants;
import com.dddd.croom.demo.model.User;
import com.dddd.croom.demo.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    private final UserServiceImpl userServiceImpl;

    public LoginController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void redirect(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect(Constants.LOGIN_METHOD);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doPost(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String name = request.getParameter(Constants.NAME);
        User user = new User(name);
        userServiceImpl.save(user);
        session.setAttribute(Constants.USER, user);
        String redirect = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + request.getContextPath() + Constants.CLASSROOM;
        return "redirect:" + redirect;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String doGet() {
        return Constants.LOGIN;
    }
}
