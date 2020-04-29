package com.jason.mycors.service;

import com.jason.mycors.entity.vo.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();
}
