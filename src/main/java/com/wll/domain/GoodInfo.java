package com.wll.domain;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;

/**
 * 添加商品信息请求对象
 *
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content:
 */
public class GoodInfo {

    private int goodsId;

    // 商品名称
    private String goodsName;

    // 单价
    private int price;

    // 商品数量
    private int num;

    // 商品描述
    private String description;

    // 类别id
    private int categoryId;

    // 详细类别
    private String detailCate;

    // 更新时间
    private Date upTime;

    // 上传图片
    private MultipartFile[] fileToUpload;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public MultipartFile[] getFileToUpload() {
        return fileToUpload;
    }

    public void setFileToUpload(MultipartFile[] fileToUpload) {
        this.fileToUpload = fileToUpload;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "GoodInfo{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                ", detailCate='" + detailCate + '\'' +
                ", upTime=" + upTime +
                ", fileToUpload=" + Arrays.toString(fileToUpload) +
                '}';
    }
}
