package com.wll.controller.front;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.domain.Goods;
import com.wll.domain.ImagePath;
import com.wll.service.GoodsService;
import com.wll.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/25
 * @Content: 搜索controller
 */
@Controller
public class SearchController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ImageService imageService;

    /**
     * 执行模糊查询, 跳转到search页面
     *
     * @param page    页码
     * @param keyword 查询条件
     * @return
     */
    @RequestMapping("/search")
    public String search(@RequestParam(defaultValue = "1") Integer page, String keyword, Model model) {

        // 开启分页
        PageHelper.startPage(page, 3);

        // 根据条件模糊查询
        String keyWord = "%" + keyword + "%";
        List<Goods> goodsList = goodsService.queryGoodsByCondition(keyWord);

        // 根据goodsId查询图片路径
        for (Goods goods : goodsList) {
            int goodsId = goods.getGoodsId();
            List<ImagePath> imagePaths = imageService.queryPathByGoodId(goodsId);
            goods.setImagePaths(imagePaths);
        }
        PageInfo pageInfo = new PageInfo(goodsList);
        // 响应数据
        model.addAttribute("keyword", keyword);
        model.addAttribute("pageInfo", pageInfo);
        return "search";
    }
}
