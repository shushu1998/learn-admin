package com.hthyaq.learnadmin.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Strings;
import com.hthyaq.learnadmin.common.constants.GlobalConstants;
import com.hthyaq.learnadmin.model.bean.GlobalResult;
import com.hthyaq.learnadmin.model.entity.SysUser;
import com.hthyaq.learnadmin.model.vo.LoginVo;
import com.hthyaq.learnadmin.service.SysUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhangqiang
 * @since 2019-09-12
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    SysUserService sysUserService;


    @PostMapping("/add")
    public boolean add(@RequestBody SysUser sysUser) {
        sysUser.setPassword(DigestUtils.md5Hex(sysUser.getPassword()));
        sysUserService.save(sysUser);
        return true;
    }


    @PostMapping("/login")
    public GlobalResult login(@RequestBody SysUser sysUserForm, HttpSession httpSession) {

        List<SysUser> list = sysUserService.list(new QueryWrapper<SysUser>().eq("username", sysUserForm.getUsername()).eq("password", DigestUtils.md5Hex(sysUserForm.getPassword())));
        if (list.size() != 1) {
            return GlobalResult.fail();
        }
        SysUser sysUserDb = list.get(0);
        httpSession.setAttribute(GlobalConstants.LOGIN_NAME, sysUserDb);

        LoginVo loginVo = new LoginVo();
        //
        loginVo.setObj1(sysUserDb);
        return GlobalResult.success("", loginVo);
    }


    @GetMapping("/getById")
    public SysUser getById(Integer id) {
        //demo
        SysUser sysUser = sysUserService.getById(id);

        return sysUser;
    }

//    @PostMapping("/edit")
//    public SysUser edit(@RequestBody SysUser sysUser) {
//        sysUser.setPassword(DigestUtils.md5Hex(sysUser.getPassword()));
//        sysUserService.updateById(sysUser);
//        return sysUser;
//    }

    @GetMapping("/delete")
    public GlobalResult delete(Integer id) {
        QueryWrapper<SysUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",id);
        //demo
        sysUserService.remove(queryWrapper);

        return GlobalResult.success("");
    }

    @GetMapping("/list")
    public IPage<SysUser> list(String json) {
        //字符串解析成java对象
        JSONObject jsonObject = JSON.parseObject(json);
        jsonObject.getObject("zbry", String.class);
        //从对象中获取值
        Integer currentPage = jsonObject.getInteger("currentPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String email = jsonObject.getString("email");
        String mobile = jsonObject.getString("mobile");
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (!Strings.isNullOrEmpty(email)) {
            queryWrapper.like("email",email );
        }
        if (!Strings.isNullOrEmpty(mobile)) {
            queryWrapper.like("mobile",mobile );
        }

        IPage<SysUser> page = sysUserService.page(new Page<>(currentPage, pageSize), queryWrapper);

        return page;
    }

}

