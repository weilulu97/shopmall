package com.wll.domain;

/**
 * 类别实体类
 *
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content:
 */
public class Category {

    // 类别id
    private int cateId;

    // 类别名称
    private String cateName;

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cateId=" + cateId +
                ", cateName='" + cateName + '\'' +
                '}';
    }
}
