package com.wll.domain;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/24
 * @Content:
 */
public class ImagePath {

    private int pathId;

    private int goodId;

    private String path;

    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ImagePath{" +
                "pathId=" + pathId +
                ", goodId=" + goodId +
                ", path='" + path + '\'' +
                '}';
    }
}
