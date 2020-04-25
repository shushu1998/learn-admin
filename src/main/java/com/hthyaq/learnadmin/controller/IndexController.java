package com.hthyaq.learnadmin.controller;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {
//    @GetMapping({"/","/visual/**","/user/**", "/*supervise", "/*Supervise", "/*Service", "/*enterprise", "/*Enterprise","/*Management","/opinion*"})
    public String index() {
        System.out.println("index");
        return "index";
    }

}
