package com.wll.controller.front;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.domain.Goods;
import com.wll.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content: 分类Controller
 */
@Controller
public class CategoryController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 跳转到category页面
     *
     * @return
     */
    @RequestMapping("/category")
    public String toCategoryView(String cate, Model model) {

        // 开启分页
        PageHelper.startPage(1, 3);

        // 根据分类名称查询商品信息
        List<Goods> goods = goodsService.queryGoodsByDetailCate(cate);

        // 执行分页
        PageInfo pageInfo = new PageInfo(goods);

        model.addAttribute("cate", cate);
        model.addAttribute("pageInfo", pageInfo);

        return "category";
    }

}
