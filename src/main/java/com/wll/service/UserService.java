package com.wll.service;

import com.wll.domain.User;

import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/19
 * @Content:
 */
public interface UserService {

    List<User> queryAllUser();

    void deleteUserById(Integer userid);

    User queryUserById(int userId);
}
