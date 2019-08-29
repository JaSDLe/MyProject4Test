package com.jason.mycors.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jason.mycors.entity.dto.QueryPageDTO;
import com.jason.mycors.entity.vo.User;
import com.jason.mycors.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public PageInfo<User> page(QueryPageDTO dto) {
        System.out.println(dto.getPageNum());
        System.out.println(dto.getPageSize());
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return new PageInfo<>(userService.findAllUsers());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pagec", method = RequestMethod.GET)
    public PageInfo<User> pagec(QueryPageDTO dto) {
        System.out.println(dto.getPageNum());
        System.out.println(dto.getPageSize());
        PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
        return new PageInfo<>(userService.findAllUsers());
    }
}
