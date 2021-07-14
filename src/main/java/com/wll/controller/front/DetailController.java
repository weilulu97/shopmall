package com.wll.controller.front;

import com.wll.domain.*;
import com.wll.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:wll
 * @Date: 2019/9/25
 * @Content: 商品明细controller
 */
@Controller
public class DetailController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping("/detail")
    public String showDetail(Integer goodsId, Model model) {

        Map<String, Object> map = new HashMap<>();

        // 商品信息
        Goods goods = goodsService.queryGoodById(goodsId);

        int categoryId = goods.getCategoryId();

        // 根据分类id查询category表
        Category category = categoryService.queryCategoryById(categoryId);

        // 根据goodsId查询图片路径
        List<ImagePath> imagePaths = imageService.queryPathByGoodId(goodsId);

        // 根据goodsId查询评价
        List<Comment> comments = commentService.queryCommentByGoodsId(goodsId);

        // 根据userId查询userName
        for (Comment comment : comments) {

            int userId = comment.getUserId();
            User user = userService.queryUserById(userId);
            comment.setUserName(user.getUserName());
        }

        map.put("goods", goods);
        map.put("cate", category);
        map.put("image", imagePaths);

        model.addAttribute("goodsInfo", map);
        model.addAttribute("commentList", comments);
        return "detail";
    }

}
