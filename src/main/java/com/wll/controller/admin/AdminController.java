package com.wll.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理Controller
 *
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/19
 * @Content:
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String admin() {

        return "admin";
    }
}
