package com.wll.service.impl;

import com.wll.domain.*;
import com.wll.mapper.CategoryMapper;
import com.wll.mapper.CollectionMapper;
import com.wll.mapper.GoodsMapper;
import com.wll.mapper.ImageMapper;
import com.wll.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content:
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ImageMapper imageMapper;

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public List<Goods> queryAllGoods() {

        return goodsMapper.queryAllGoods();
    }

    @Override
    public void insert(GoodInfo goodInfo) {

        goodInfo.setUpTime(new Date());
        goodsMapper.insert(goodInfo);
    }

    @Override
    public List<Goods> queryGoodsByCategory(String categoryName, User user) {

        // 1. 根据分类名称找到分类id
        List<Category> categories = categoryMapper.queryCategoryByName(categoryName);
        if (categories == null || categories.size() == 0) {
            return Collections.emptyList();
        }

        // 类别id集合
        List<Integer> categoryIds = new ArrayList<>();
        for (Category category : categories) {
            categoryIds.add(category.getCateId());
        }
        // 2. 查询goods表category在该类别范围的商品
        List<Goods> goods = goodsMapper.queryGoodsByCategoryId(categoryIds);
        if (goods == null || goods.size() == 0) {
            return Collections.emptyList();
        }

        // 3. 遍历商品, 获取商品的图片path, 查询imagePath表根据goodid
        for (Goods good : goods) {

            if (user == null) {
                good.setFav(false);
            } else {
                // 说明已经登陆
                Collect collect = collectionMapper.queryCollectionByUserIdAndGoodsId(user.getUserId(), good.getGoodsId());

                if (collect == null) {
                    // 说明用户没有收藏过这个商品
                    good.setFav(false);
                } else {
                    good.setFav(true);
                }
            }

            int goodsId = good.getGoodsId();
            // 根据goodsId查询path
            List<ImagePath> imagePaths = imageMapper.queryPathByGoodId(goodsId);
            good.setImagePaths(imagePaths);
        }
        return goods;
    }

    @Override
    public List<Goods> queryGoodsByDetailCate(String cate) {
        // 2. 查询goods表category在该类别范围的商品
        List<Goods> goods = goodsMapper.queryGoodsByDetailCate(cate);
        if (goods == null || goods.size() == 0) {
            return Collections.emptyList();
        }

        // 3. 遍历商品, 获取商品的图片path, 查询imagePath表根据goodid
        for (Goods good : goods) {
            int goodsId = good.getGoodsId();
            // 根据goodsId查询path
            List<ImagePath> imagePaths = imageMapper.queryPathByGoodId(goodsId);
            good.setImagePaths(imagePaths);
        }
        return goods;
    }

    @Override
    public Goods queryGoodById(Integer goodsId) {

        return goodsMapper.queryGoodById(goodsId);
    }

    @Override
    public List<Goods> queryGoodsByCondition(String keyword) {
        return goodsMapper.queryGoodsByCondition(keyword);
    }

}
