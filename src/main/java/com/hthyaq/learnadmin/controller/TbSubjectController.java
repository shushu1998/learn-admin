package com.hthyaq.learnadmin.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Strings;
import com.hthyaq.learnadmin.common.constants.GlobalConstants;
import com.hthyaq.learnadmin.common.excle.DownloadFile;
import com.hthyaq.learnadmin.common.excle.MyExcelUtil;
import com.hthyaq.learnadmin.model.bean.GlobalResult;
import com.hthyaq.learnadmin.model.entity.TbSubject;
import com.hthyaq.learnadmin.model.excelModel.TbSubjectModel;
import com.hthyaq.learnadmin.service.TbSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        String[] strs = tbsubject.getRightOption().split(",");
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
    public GlobalResult delete(Integer[] id) {
        System.out.println(id);
        if (null == id) {
            return GlobalResult.fail("请至少选择一条记录");
        }
        for (Integer ids : id) {
            QueryWrapper<TbSubject> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", ids);
            tbSubjectService.remove(queryWrapper);
        }
        return GlobalResult.success("成功");
    }

    //导出题目模板
    @GetMapping("/downloadmodle")
    public void downloadmodle(HttpServletResponse response) throws Exception {
        List<TbSubjectModel> dataList = null;
        //learnFile/excel
        String file = GlobalConstants.EXCEL_PATH + "/题目模板.xlsx";
        //先删除
        File fileTmp = new File(file);
        if (fileTmp.exists()) {
            fileTmp.delete();
        }
        MyExcelUtil.writeOneSheetExcel(file, dataList, TbSubjectModel.class);
        new DownloadFile().download(file, response);
    }
    //导出题目模板
    @GetMapping("/download")
    public void download(HttpServletResponse response,@RequestParam("content") String content) throws Exception {
        QueryWrapper<TbSubject> queryWrapper=new QueryWrapper<>();
        if(content.equals("undefined")){
            content="";
        }
        queryWrapper.like("content",content);
        List<TbSubject> list = tbSubjectService.list(queryWrapper);
        List<TbSubjectModel> dataList = new ArrayList<>();
        for (TbSubject tbSubject : list) {
            TbSubjectModel tbSubjectModel=new TbSubjectModel();
            tbSubjectModel.setContent(tbSubject.getContent());
            tbSubjectModel.setOptionA(tbSubject.getOptionA());
            tbSubjectModel.setOptionB(tbSubject.getOptionB());
            tbSubjectModel.setOptionC(tbSubject.getOptionC());
            tbSubjectModel.setOptionD(tbSubject.getOptionD());
            tbSubjectModel.setOptionE(tbSubject.getOptionE());
            tbSubjectModel.setOptionF(tbSubject.getOptionF());
            tbSubjectModel.setRightOption(tbSubject.getRightOption());
            if (tbSubject.getContentType() == 1) {
                tbSubjectModel .setContentType("单选");
            } else {
                tbSubjectModel.setContentType("多选");
            }
            dataList.add(tbSubjectModel);
        }

        //learnFile/excel
        String file = GlobalConstants.EXCEL_PATH + "/题目.xlsx";
        //先删除
        File fileTmp = new File(file);
        if (fileTmp.exists()) {
            fileTmp.delete();
        }
        MyExcelUtil.writeOneSheetExcel(file, dataList, TbSubjectModel.class);
        new DownloadFile().download(file, response);
    }
    @PostMapping("/tableMapInfoExcel")
    public Boolean moreSheetExcel(MultipartFile[] files) {
        boolean flag = true;
        List<Object> list = MyExcelUtil.readOneSheetExcel(files, TbSubjectModel.class);
        Object obj = (Object) list;
        List<TbSubjectModel> dataList = (List<TbSubjectModel>) obj;
        for (TbSubjectModel tbSubjectModel : dataList) {
            TbSubject tbSubject=new TbSubject();
            tbSubject.setContent(tbSubjectModel.getContent());
            tbSubject.setOptionA(tbSubjectModel.getOptionA());
            tbSubject.setOptionB(tbSubjectModel.getOptionB());
            tbSubject.setOptionC(tbSubjectModel.getOptionC());
            tbSubject.setOptionD(tbSubjectModel.getOptionD());
            tbSubject.setOptionE(tbSubjectModel.getOptionE());
            tbSubject.setOptionF(tbSubjectModel.getOptionF());
            tbSubject.setRightOption(tbSubjectModel.getRightOption());
            tbSubject.setContentType(Integer.parseInt(tbSubjectModel.getContentType()));
            flag= tbSubjectService.save(tbSubject);
        }
        return flag;
    }


}
