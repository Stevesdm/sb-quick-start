package com.steve.service;

import com.steve.domain.User;

import java.util.List;

/**
 * Created by SteveJobson on 2017/7/28.
 */

public interface UserService {


    public List<User> listUser();

    public User getUser();

    public int addUser(User user);

}
