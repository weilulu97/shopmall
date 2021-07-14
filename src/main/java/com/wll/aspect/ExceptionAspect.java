package com.wll.aspect;

import com.wll.constant.ExceptionConstant;
import com.wll.exception.MallException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常统一捕获类, controller发生异常都会执行该类
 *
 * @Version 1.0
 * @Author:wll
 * @Date:2019/9/19
 * @Content:
 */
@ControllerAdvice
public class ExceptionAspect {

    /**
     * 日志组件
     */
    private static final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);


    /**
     * 拦截MallException业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MallException.class)
    public String handleException(HttpServletRequest request, MallException e) {
        logger.error("uri = [{}]", request.getRequestURI(), e.getMessage(), e);

        request.setAttribute("errorMsg", e.getMessage());
        return "error";
    }

    /**
     * 拦截Exception系统异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Exception e) {
        logger.error("uri = [{}]", request.getRequestURI(), e.getMessage(), e);

        request.setAttribute("errorMsg", ExceptionConstant.SYSTEM_ERROR.getMsg());
        return "error";
    }
}
