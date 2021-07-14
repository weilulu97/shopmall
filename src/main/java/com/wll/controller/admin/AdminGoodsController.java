package com.wll.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wll.constant.ShopMallConstants;
import com.wll.domain.Category;
import com.wll.domain.GoodInfo;
import com.wll.domain.Goods;
import com.wll.domain.ResponseResult;
import com.wll.service.CategoryService;
import com.wll.service.GoodsService;
import com.wll.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品管理Controller
 *
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/19
 * @Content:
 */
@Controller
@RequestMapping("/admin/goods")
public class AdminGoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ImageService imageService;

    @RequestMapping("/show")
    public String show() {
        return "adminAllGoods";
    }

    /**
     * 分页查询商品信息列表
     *
     * @param page
     * @return
     */
    @RequestMapping("/showjson")
    @ResponseBody
    public ResponseResult showJson(@RequestParam(defaultValue = "1") Integer page) {

        // 开启分页, TODO 此处后续可采用redis优化
        PageHelper.startPage(page, 3);

        // TODO 此处信息后续也可采用redis缓存优化
        List<Goods> goods = goodsService.queryAllGoods();

        PageInfo pageInfo = new PageInfo(goods);

        Map<String, Object> info = new HashMap<>();
        info.put(ShopMallConstants.pageInfo, pageInfo);

        return ResponseResult.success("查询商品信息成功", info);
    }

    /**
     * 跳转到addGoods商品添加页面
     *
     * @return
     */
    @RequestMapping("/toAddGoodsView")
    public String toAddView(Model model) {

        // addGoods的72行需要展示categoryList
        List<Category> categories = categoryService.queryAllCategory();
        model.addAttribute("categoryList", categories);

        return "addGoods";
    }

    /**
     * 跳转到addCategory分类页面
     *
     * @return
     */
    @RequestMapping("/toAddCategoryView")
    public String toAddCategoryView() {
        return "addCategory";
    }

    @RequestMapping("/addGoodInfo")
    public String addGoodInfo(GoodInfo goodInfo) {

        // 添加商品信息
        // 必须在goodMapper.xml的insert方法中配置 useGeneratedKeys="true" keyProperty="goodsId", 返回插入后的主键
        // 此时返回对象中的goodsId属性为插入后的主键
        goodsService.insert(goodInfo);

        // 保存商品对应的图片
        // TODO 图片保存在硬盘的指定目录下, 后续可优化,
        imageService.insertImage(goodInfo.getGoodsId(), goodInfo.getFileToUpload());

        // 重定向到商品列表页面
        return "redirect:/admin/goods/show";
    }

}
