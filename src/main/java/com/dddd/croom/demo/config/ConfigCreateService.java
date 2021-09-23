package com.dddd.croom.demo.config;

import com.dddd.croom.demo.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Configuration;



@Configuration
public class ConfigCreateService {
    private static UserServiceImpl userService;

    public ConfigCreateService(UserServiceImpl userService) {
        ConfigCreateService.userService = userService;
    }

    public static UserServiceImpl service() {
        return userService;
    }
}
