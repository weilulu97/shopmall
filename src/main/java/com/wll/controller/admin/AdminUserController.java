package com.wll.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.domain.ResponseResult;
import com.wll.domain.User;
import com.wll.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理controller
 *
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/19
 * @Content:
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);

    @Autowired
    private UserService userService;

    /**
     * 跳转到用户页面
     *
     * @return
     */
    @RequestMapping("/show")
    public String show() {

        return "userManage";
    }


    /**
     * 分页展示用户信息
     * ajax请求, 页面不跳转, 只是展示数据必须加@ResponseBody
     *
     * @param page
     * @return
     */
    @RequestMapping("/showjson")
    @ResponseBody
    public ResponseResult showUserInfo(@RequestParam(defaultValue = "1") Integer page) {

        logger.info("分页展示用户信息 start, page={}", page);

        // 开启分页功能
        // 当前页, 每页展示的条数
        PageHelper.startPage(page, 3);

        // 调用userService执行分页查询数据
        List<User> users = userService.queryAllUser();

        // 第二个参数为显示多少页
        PageInfo pageInfo = new PageInfo(users);

        // 此处必须这样写, 前端js已经要求
        Map<String, Object> info = new HashMap<>();
        info.put("pageInfo", pageInfo);
        logger.info("分页展示用户信息 end, info={}", info);
        return ResponseResult.success("用户信息查询成功", info);
    }

    @RequestMapping(value = "/delete/{userid}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult deleteUser(@PathVariable("userid") Integer userid) {

        userService.deleteUserById(userid);

        return ResponseResult.success("删除用户信息成功", null);
    }


}
