package com.dddd.croom.demo.controller;

import com.dddd.croom.demo.constants.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    protected String doGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(Constants.USER);
        return Constants.LOGIN;
    }
}
