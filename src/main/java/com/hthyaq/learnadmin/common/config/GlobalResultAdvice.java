package com.hthyaq.learnadmin.common.config;

import com.hthyaq.learnadmin.model.bean.GlobalResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

@ControllerAdvice
public class GlobalResultAdvice implements ResponseBodyAdvice {
    private static final String PACKAGE = "com.hthyaq.learnadmin";

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        System.out.println(methodParameter.getDeclaringClass().getSimpleName()+"--"+methodParameter.getMethod().getName());
        String packageName = methodParameter.getDeclaringClass().getPackage().getName();
        if (packageName.contains(PACKAGE) && GlobalResult.class != Objects.requireNonNull(methodParameter.getMethod()).getReturnType()) {
            if (obj instanceof Boolean && !((Boolean) obj)) {
                return GlobalResult.fail("请联系-系统管理员！");
            }
            return GlobalResult.success(obj);
        }
        return obj;
    }
}
