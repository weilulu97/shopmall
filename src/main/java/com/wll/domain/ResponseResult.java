package com.wll.domain;

import java.util.Map;

/**
 * 统一响应体
 *
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/19
 * @Content:
 */
public class ResponseResult {

    /**
     * 100:成功
     * 200:失败
     */
    private int code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应内容
     */
    private Map<String, Object> info;

    public ResponseResult() {
    }

    public ResponseResult(int code, String msg, Map<String, Object> info) {
        this.code = code;
        this.msg = msg;
        this.info = info;
    }

    public static ResponseResult success(String msg, Map<String, Object> info) {

        return new ResponseResult(100, msg, info);
    }

    public static ResponseResult fail(String msg, Map<String, Object> info) {

        return new ResponseResult(200, msg, info);
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Map<String, Object> getInfo() {
        return info;
    }
}
