package com.wll.domain;

import java.util.Date;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/19
 * @Content:
 */
public class User {

    private Integer userId;

    private String userName;

    private String password;

    // 注册时间
    private Date regTime;

    private String email;

    private String telephone;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", regTime=" + regTime +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
