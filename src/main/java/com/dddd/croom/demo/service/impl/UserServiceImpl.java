package com.dddd.croom.demo.service.impl;

import com.dddd.croom.demo.model.User;
import com.dddd.croom.demo.repository.UserRepository;
import com.dddd.croom.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteByName(String name) {
        userRepository.deleteByName(name);
    }

    @Override
    public void setHand_upByName(String name, boolean hand) {
        userRepository.setHand_upByName(name, hand);
    }


}
