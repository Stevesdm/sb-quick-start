package com.steve.controller;

import com.steve.domain.User;
import com.steve.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by SteveJobson on 2017/7/28.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", produces = "application/json")
    public List<User> listUser() {
        return userService.listUser();
    }

    @RequestMapping(value = "/get", produces = "application/json")
    public User geUser(){
        return userService.getUser();
    }
}
