package com.hthyaq.learnadmin.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Strings;
import com.hthyaq.learnadmin.model.bean.GlobalResult;
import com.hthyaq.learnadmin.model.entity.TbSubject;
import com.hthyaq.learnadmin.service.TbSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 * 前端控制器 题库
 * </p>
 *
 * @author ssq
 * @since 2020-04-23
 */
@RestController
@RequestMapping("/tbSubject")
public class TbSubjectController {
    @Autowired
    TbSubjectService tbSubjectService;

    @GetMapping("/list")
    public IPage<TbSubject> list(String json) {
        //字符串解析成java对象
        JSONObject jsonObject = JSON.parseObject(json);
        jsonObject.getObject("zbry", String.class);
        //从对象中获取值
        Integer currentPage = jsonObject.getInteger("currentPage");
        Integer pageSize = jsonObject.getInteger("pageSize");
        String content = jsonObject.getString("content");
        QueryWrapper<TbSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        if (!Strings.isNullOrEmpty(content)) {
            queryWrapper.like("content", content);
        }

        IPage<TbSubject> page = tbSubjectService.page(new Page<>(currentPage, pageSize), queryWrapper);
        int i = 0;
        for (TbSubject record : page.getRecords()) {
            if (record.getContentType() != null) {
                if (record.getContentType() == 1) {
                    page.getRecords().get(i).setContentTypestr("单选");
                } else {
                    page.getRecords().get(i).setContentTypestr("多选");
                }
            }
            i++;
        }
//        for (TbUser record : page.getRecords()) {
//            if (record.getAnswerTime() != null) {
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                String AnswerTime = sdf.format(record.getAnswerTime());
//                Date AnswerTimedate = java.sql.Date.valueOf(AnswerTime);
//                page.getRecords().get(i).setAnswerTime(AnswerTime);
//            }
//            i++;
//        }
        return page;
    }

    @PostMapping("/add")
    public boolean add(@RequestBody TbSubject tbSubject) {

        String join = String.join(",", tbSubject.getRightOptions());
        tbSubject.setRightOption(join);
        System.out.println(tbSubject);
        tbSubjectService.save(tbSubject);
        return true;
    }

    @GetMapping("/getById")
    public TbSubject getById(Integer id) {
        //tbsubject
        TbSubject tbsubject = tbSubjectService.getById(id);
        String[] strs=tbsubject.getRightOption().split(",");
        tbsubject.setRightOptions(Arrays.asList(strs));
        System.out.println(tbsubject);
        return tbsubject;
    }
    @PostMapping("/edit")
    public boolean edit(@RequestBody TbSubject tbSubject) {
        String join = String.join(",", tbSubject.getRightOptions());
        tbSubject.setRightOption(join);

        return tbSubjectService.updateById(tbSubject);
    }

    @GetMapping("/delete")
    public GlobalResult delete(Integer id) {
        QueryWrapper<TbSubject> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        //demo
        tbSubjectService.remove(queryWrapper);

        return GlobalResult.success("");
    }
}
