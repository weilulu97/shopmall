package com.wll.constant;

/**
 * 异常枚举类
 *
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/19
 * @Content:
 */
public enum ExceptionConstant {

    SYSTEM_ERROR("0001", "系统异常"),
    ;

    private String code;

    private String msg;

    ExceptionConstant(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
