package com.jason.mycors.controller;

import com.jason.mycors.entity.vo.User;
import com.jason.mycors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CORSController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/userc")
    public List<User> findAllUsersWithCORS() {
        return userService.findAllUsers();
    }
}
