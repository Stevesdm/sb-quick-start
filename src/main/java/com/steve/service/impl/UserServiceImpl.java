package com.steve.service.impl;

import com.steve.dao.UserMapper;
import com.steve.domain.User;
import com.steve.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SteveJobson on 2017/9/21.
 */
@Service
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    public List<User> listUser() {
        return userMapper.selectAll();
    }

    public User getUser(){
        User u = new User();
        u.setId(1);
        return userMapper.selectOne(u);
    }

    @Transactional
    public int addUser(User user){
        int result = userMapper.insertUseGeneratedKeys(user);
        String a = null;
        if (a.equals("0")){}
        return result;
    }
}
