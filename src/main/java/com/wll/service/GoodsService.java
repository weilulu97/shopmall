package com.wll.service;

import com.wll.domain.GoodInfo;
import com.wll.domain.Goods;
import com.wll.domain.User;

import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content:
 */
public interface GoodsService {

    /**
     * 查询所有商品信息
     *
     * @return
     */
    List<Goods> queryAllGoods();

    void insert(GoodInfo goodInfo);

    /**
     * 根据分类查询商品信息
     *
     * @param categoryName
     * @return
     */
    List<Goods> queryGoodsByCategory(String categoryName, User user);

    List<Goods> queryGoodsByDetailCate(String cate);

    Goods queryGoodById(Integer goodsId);

    List<Goods> queryGoodsByCondition(String keyword);
}
