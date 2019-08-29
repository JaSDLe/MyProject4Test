package com.jason.mycors.controller;

import com.jason.mycors.entity.vo.User;
import com.jason.mycors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CORSController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping("/userc")
    public List<User> findAllUsersWithCORS() {
        return userService.findAllUsers();
    }
}
