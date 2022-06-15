package com.xinqiu.user.service.impl;

import com.xinqiu.api.entity.User;
import com.xinqiu.user.mapper.userMapper;
import com.xinqiu.user.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class userServiceImpl implements userService {

    @Autowired
    private userMapper userMapper;

    @Override
    public User get(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
}
