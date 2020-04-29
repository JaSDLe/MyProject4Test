package com.jason.mycors.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.mycors.entity.dto.QueryPageDTO;
import com.jason.mycors.entity.vo.User;
import com.jason.mycors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PageController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/page")
    public PageInfo<User> page(QueryPageDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return new PageInfo<>(userService.findAllUsers());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/pagec")
    public PageInfo<User> pagec(QueryPageDTO dto) {
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return new PageInfo<>(userService.findAllUsers());
    }
}
