package com.dddd.croom.demo.service;

import com.dddd.croom.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> listAll();
    void save(User user);
    void delete(User user);
    void deleteByName(String name);
    void setHand_upByName(String name, boolean hand);
}
