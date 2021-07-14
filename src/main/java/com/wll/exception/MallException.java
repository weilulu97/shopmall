package com.wll.exception;

import com.wll.constant.ExceptionConstant;

/**
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/19
 * @Content:
 */
public class MallException extends RuntimeException {

    private ExceptionConstant constant;

    public MallException(ExceptionConstant constant) {
        this.constant = constant;
    }

    public MallException(Throwable cause, ExceptionConstant constant) {
        super(constant.getMsg(), cause);
        this.constant = constant;
    }

    @Override
    public String toString() {
        return "MallException{" +
                "code=" + constant.getCode() +
                ", msg=" + constant.getMsg() +
                '}';
    }
}
