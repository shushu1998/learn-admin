package com.hthyaq.learnadmin;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionDemo {

//    //设置session
////    @GetMapping("/user/login")
//    public GlobalResult set(HttpSession httpSession) {
//        SysUser sysUser=new SysUser();
//        sysUser.setUsername("uname");
//        sysUser.setPassword("pwd");
//        httpSession.setAttribute(GlobalConstants.LOGIN_NAME, sysUser);
//        return GlobalResult.success("设置session", httpSession.getId());
//    }
//
//    //获取session
////    @GetMapping("/get")
//    public GlobalResult get(HttpSession httpSession) {
////        String data = httpSession.getId() + "," + httpSession.getAttribute("a");
//        return GlobalResult.success("获取session", httpSession.getAttribute(GlobalConstants.LOGIN_NAME));
//    }
}
