package com.jason.mycors.service.impl;

import com.jason.mycors.entity.vo.User;
import com.jason.mycors.mapper.UserMapper;
import com.jason.mycors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }
}
