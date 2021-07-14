package com.wll.domain;

import java.util.Date;

/**
 * @Author:wll
 * @Date: 2019/9/25
 * @Content:
 */
public class Comment {

    private int commentId;

    private int userId;

    private int goodsId;

    private int point;

    private String content;

    private Date commentTime;

    private String userName;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", point=" + point +
                ", content='" + content + '\'' +
                ", commentTime=" + commentTime +
                ", userName='" + userName + '\'' +
                '}';
    }
}
