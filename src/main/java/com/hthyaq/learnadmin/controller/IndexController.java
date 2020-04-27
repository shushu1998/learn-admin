package com.hthyaq.learnadmin.controller;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {
//    @GetMapping({"/","/user/**","/**/index"})
//    @GetMapping({"/","/user/**","/subject/index","/sysuser/index","/groupList/index","/personalList/index","/tbUser/index","/company/index","/company/DemoForm"})
    public String index() {
        return "index";
    }

}
