package com.wll.mapper;

import com.wll.domain.Collect;

/**
 * @Author:wll
 * @Date: 2019/9/25
 * @Content:
 */
public interface CollectionMapper {

    Collect queryCollectionByUserIdAndGoodsId(Integer userId, int goodsId);

}
