package com.dddd.croom.demo.controller;

import com.dddd.croom.demo.constants.Constants;
import com.dddd.croom.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ClassroomController {

    @RequestMapping(value = "/classroom", method = RequestMethod.GET)
    public String doGet(Model model, HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute(Constants.USER);
        model.addAttribute("userName", user.getName());
        return Constants.CLASS_ROOM;
    }
}