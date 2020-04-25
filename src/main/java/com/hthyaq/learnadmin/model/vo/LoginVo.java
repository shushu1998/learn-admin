package com.hthyaq.learnadmin.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class LoginVo {
    //用户
    private Object obj1;
    //注册的政府监管部门、企业、技术服务机构
    private Object obj2;
    //省市区
    private List<String> areaNameList;
    //企业的名称、技术服务机构的名称
    private String name;
}
