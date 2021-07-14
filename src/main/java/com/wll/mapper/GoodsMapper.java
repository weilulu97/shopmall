package com.wll.mapper;

import com.wll.domain.GoodInfo;
import com.wll.domain.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content:
 */
public interface GoodsMapper {

    List<Goods> queryAllGoods();

    void insert(GoodInfo goodInfo);

    List<Goods> queryGoodsByCategoryId(@Param("categoryIds") List<Integer> categoryIds);

    List<Goods> queryGoodsByDetailCate(String cate);

    Goods queryGoodById(Integer goodsId);

    List<Goods> queryGoodsByCondition(String keyword);
}
