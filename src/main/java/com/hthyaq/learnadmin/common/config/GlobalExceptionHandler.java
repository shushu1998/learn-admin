package com.hthyaq.learnadmin.common.config;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Throwables;
import com.hthyaq.learnadmin.model.bean.GlobalResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public GlobalResult handleException(HttpServletRequest request, Exception e) {
        //记录异常信息到日志
        log.error("url={}", request.getRequestURL());
        log.error("method={}", request.getMethod());
        log.error("params={}", JSON.toJSONString(request.getParameterMap()));
        log.error("error={}", Throwables.getStackTraceAsString(e));

        return GlobalResult.fail(e.getMessage().length() > 50 ? "请联系-系统管理员!" : e.getMessage());

    }
}
