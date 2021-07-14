package com.wll.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/19
 * @Content:
 */
@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

    @RequestMapping("/send")
    public String show() {
        return "adminAllOrder";
    }
}
