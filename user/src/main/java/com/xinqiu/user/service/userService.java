package com.xinqiu.user.service;

import com.xinqiu.api.entity.User;

import java.util.List;

public interface userService {

    User get(String id);

    List<User> getAllUser();


}
