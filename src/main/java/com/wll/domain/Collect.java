package com.wll.domain;

import java.util.Date;

/**
 * @Author:wll
 * @Date: 2019/9/25
 * @Content:
 */
public class Collect {

    private int userId;

    private int goodsId;

    private Date collectTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "userId=" + userId +
                ", goodsId=" + goodsId +
                ", collectTime=" + collectTime +
                '}';
    }
}
