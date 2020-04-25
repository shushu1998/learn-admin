package com.hthyaq.learnadmin.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Strings;
import com.hthyaq.learnadmin.model.entity.Company;
import com.hthyaq.learnadmin.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ssq
 * @since 2020-04-24
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @GetMapping("/list")
    public IPage<Company> list(String json) {
        //字符串解析成java对象
        JSONObject jsonObject = JSON.parseObject(json);
        jsonObject.getObject("zbry", String.class);
        //从对象中获取值
        Integer currentPage = jsonObject.getInteger("currentPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String companyName = jsonObject.getString("companyName");

        QueryWrapper<Company> queryWrapper = new QueryWrapper<>();
        if (!Strings.isNullOrEmpty(companyName)) {
            queryWrapper.like("email",companyName );
        }


        IPage<Company> page = companyService.page(new Page<>(currentPage, pageSize), queryWrapper);

        return page;
    }
}
