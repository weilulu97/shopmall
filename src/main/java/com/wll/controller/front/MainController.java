package com.wll.controller.front;

import com.wll.constant.CategoryConstants;
import com.wll.domain.Goods;
import com.wll.domain.User;
import com.wll.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content: 首页controller
 */
@Controller
public class MainController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 跳转到首页
     *
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String toMainView(Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");

        // 类别为数码的商品信息
        List<Goods> digitalGoods = goodsService.queryGoodsByCategory(CategoryConstants.Digital, user);
        model.addAttribute("digGoods", digitalGoods);

        // 类别为服饰的商品信息
        List<Goods> colGoods = goodsService.queryGoodsByCategory(CategoryConstants.cloth, user);
        model.addAttribute("colGoods", colGoods);

        // 类别为书籍的商品信息
        List<Goods> bookGoods = goodsService.queryGoodsByCategory(CategoryConstants.book, user);
        model.addAttribute("bookGoods", bookGoods);

        // 类别为家电的商品信息
        List<Goods> houseGoods = goodsService.queryGoodsByCategory(CategoryConstants.house, user);
        model.addAttribute("houseGoods", houseGoods);
        return "main";
    }
}