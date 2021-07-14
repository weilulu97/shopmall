package com.wll.mapper;

import com.wll.domain.User;

import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/19
 * @Content:
 */
public interface UserMapper {

    List<User> queryAllUser();

    void deleteUserById(Integer userid);

    User queryUserById(int userId);
}
