package com.hthyaq.learnadmin.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Strings;
import com.hthyaq.learnadmin.model.bean.GlobalResult;
import com.hthyaq.learnadmin.model.dto.UserDTO;
import com.hthyaq.learnadmin.model.dto.UserView;
import com.hthyaq.learnadmin.model.entity.Company;
import com.hthyaq.learnadmin.model.entity.TbUser;
import com.hthyaq.learnadmin.service.CompanyService;
import com.hthyaq.learnadmin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author ssq
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/tbUser")
public class TbUserController {
    @Autowired
    TbUserService tbUserService;
    @Autowired
    CompanyService companyService;

    //查询小程序用户
    @GetMapping("/list")
    public IPage<TbUser> list(String json) {
        //字符串解析成java对象
        JSONObject jsonObject = JSON.parseObject(json);
        jsonObject.getObject("zbry", String.class);
        //从对象中获取值
        Integer currentPage = jsonObject.getInteger("currentPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String username = jsonObject.getString("username");
        String mobile = jsonObject.getString("mobile");
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("user_id");
        if (!Strings.isNullOrEmpty(username)) {
            queryWrapper.like("username",username);
        }
        if (!Strings.isNullOrEmpty(mobile)) {
            queryWrapper.like("mobile",mobile );
        }
        IPage<TbUser> page = tbUserService.page(new Page<>(currentPage, pageSize), queryWrapper);
        for (TbUser record : page.getRecords()) {

            Company company = companyService.getById(record.getSecret());
            if (company!=null){
                record.setSecret(company.getCompanyName());
            }else {
                record.setSecret("无");
            }
        }

        return page;
    }
    //查询未授权过的人
    @GetMapping("/select")
    public List<UserView> select(Integer id) {
        List<UserView> arrayList=new ArrayList<>();
        QueryWrapper<TbUser> queryWrapper=new QueryWrapper();
        queryWrapper.eq("secret",id);
        List<TbUser> list = tbUserService.list(queryWrapper);
        for (TbUser tbUser : list) {
            UserView userView=new UserView();
            userView.setValue(tbUser.getUserId());
            userView.setTitle(tbUser.getUsername());
            arrayList.add(userView);
        }
        return arrayList;
    }

    //查询已授权过的人
    @GetMapping("/selectrecommend")
    public List<UserView> selectrecommend(Integer id) {
        List<UserView> arrayList=new ArrayList<>();
        QueryWrapper<TbUser> queryWrapper=new QueryWrapper();
        queryWrapper.eq("is_recommend",1);
        queryWrapper.eq("secret",id);
        List<TbUser> list = tbUserService.list(queryWrapper);
        for (TbUser tbUser : list) {
            UserView userView=new UserView();
            userView.setValue(tbUser.getUserId());
            userView.setTitle(tbUser.getUsername());
            arrayList.add(userView);
        }
        return arrayList;
    }

//授权团队
    @PostMapping("/editrecommend")
    public GlobalResult editrecommend(@RequestBody UserView userView) {
        System.out.println(userView);
        QueryWrapper<TbUser> queryWrapper=new QueryWrapper();
        queryWrapper.eq("is_recommend",1);
        List<TbUser> list = tbUserService.list(queryWrapper);
        if(list.size()>3){
            return GlobalResult.fail("人数已满");
        }
        QueryWrapper<TbUser> queryWrapper3=new QueryWrapper();
        queryWrapper3.eq("secret",userView.getId());
        List<TbUser> list2 = tbUserService.list(queryWrapper3);
        for (TbUser tbUser : list2) {
            tbUser.setIsRecommend(0);
            tbUserService.updateById(tbUser);
        }
        for (Object targetKey : userView.getTargetKeys()) {
            QueryWrapper<TbUser> queryWrapper2=new QueryWrapper();
            queryWrapper2.eq("user_id",targetKey);
            List<TbUser> list1 = tbUserService.list(queryWrapper2);
            for (TbUser tbUser : list1) {
                   tbUser.setIsRecommend(1);
                   tbUserService.updateById(tbUser);
            }
        }
        return GlobalResult.success("操作成功");

    }

    //查询个人排行用户
    @GetMapping("/listRanking")
    public IPage<TbUser> listRanking(String json) {
        //字符串解析成java对象
        JSONObject jsonObject = JSON.parseObject(json);
        jsonObject.getObject("zbry", String.class);
        //从对象中获取值
        Integer currentPage = jsonObject.getInteger("currentPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String username = jsonObject.getString("username");
        String mobile = jsonObject.getString("mobile");
        String companyName = jsonObject.getString("secret");
        IPage<TbUser> page1=new Page<>(currentPage, pageSize);

        List<TbUser> page = tbUserService.pages((currentPage-1)*pageSize,pageSize,username,mobile,companyName);
        int i=1;
        for (TbUser tbUser : page) {
            tbUser.setRanking(i);
            Company company = companyService.getById(tbUser.getSecret());
            if (company!=null){
                tbUser.setSecret(company.getCompanyName());
            }else {
                tbUser.setSecret("无");
            }
            i++;
        }
        page1.setRecords(page);
        page1.setTotal(tbUserService.count());
        return page1;
    }

    //查询团队排行用户
    @GetMapping("/listGroup")
    public IPage<UserDTO> listGroup(String json) {
        //字符串解析成java对象
        JSONObject jsonObject = JSON.parseObject(json);
        jsonObject.getObject("zbry", String.class);
        //从对象中获取值
        Integer currentPage = jsonObject.getInteger("currentPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String companyName = jsonObject.getString("companyName");


        IPage<UserDTO> page1=new Page<>(currentPage, pageSize);

        List<UserDTO> page = tbUserService.pageGroup((currentPage-1)*pageSize,pageSize,companyName);
        int i=1;
        for (UserDTO userDTO : page) {
            userDTO.setRanking(i);
            if(userDTO.getCompanyName()==null){
                userDTO.setCompanyName("无");
            }
            i++;
        }
        page1.setRecords(page);
        page1.setTotal(tbUserService.count());
        return page1;
    }



    @GetMapping("/getById")
    public TbUser getById(Integer id) {
        //demo
        TbUser tbUser = tbUserService.getById(id);

        return tbUser;
    }
}
