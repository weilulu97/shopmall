package com.wll.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/25
 * @Content: 注册controller
 */
@Controller
public class RegisterController {

    @RequestMapping("/register")
    public String toRegisterView() {

        return "register";
    }


}
