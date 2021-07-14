package com.wll.domain;

import java.util.Date;
import java.util.List;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content:
 */
public class Goods {

    private int goodsId;

    private String goodsName;

    private int price;

    private int num;

    private Date upTime;

    private int categoryId;

    private String detailCate;

    private String description;

    private int activityId;

    // 是否被收藏
    private boolean fav;

    private List<ImagePath> imagePaths;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDetailCate() {
        return detailCate;
    }

    public void setDetailCate(String detailCate) {
        this.detailCate = detailCate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public List<ImagePath> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<ImagePath> imagePaths) {
        this.imagePaths = imagePaths;
    }


    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", upTime=" + upTime +
                ", categoryId=" + categoryId +
                ", detailCate='" + detailCate + '\'' +
                ", description='" + description + '\'' +
                ", activityId=" + activityId +
                ", fav=" + fav +
                ", imagePaths=" + imagePaths +
                '}';
    }
}
