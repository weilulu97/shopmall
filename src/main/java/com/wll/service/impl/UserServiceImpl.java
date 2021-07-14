package com.wll.service.impl;

import com.wll.domain.User;
import com.wll.mapper.UserMapper;
import com.wll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/19
 * @Content:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUser() {

        return userMapper.queryAllUser();
    }

    @Override
    public void deleteUserById(Integer userid) {

        userMapper.deleteUserById(userid);
    }

    @Override
    public User queryUserById(int userId) {
        return userMapper.queryUserById(userId);
    }
}
