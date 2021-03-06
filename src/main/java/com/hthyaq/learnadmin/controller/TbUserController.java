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
import com.hthyaq.learnadmin.model.dto.UserDTO;
import com.hthyaq.learnadmin.model.dto.UserView;
import com.hthyaq.learnadmin.model.entity.Company;
import com.hthyaq.learnadmin.model.entity.TbUser;
import com.hthyaq.learnadmin.model.excelModel.GroupListModel;
import com.hthyaq.learnadmin.model.excelModel.PersonalListModel;
import com.hthyaq.learnadmin.model.excelModel.TbuserExcelModel;
import com.hthyaq.learnadmin.service.CompanyService;
import com.hthyaq.learnadmin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        String companyName1 = jsonObject.getString("secret");

        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("user_id");
        if (!Strings.isNullOrEmpty(username)) {
            queryWrapper.like("username",username);
        }
        if (!Strings.isNullOrEmpty(mobile)) {
            queryWrapper.like("mobile",mobile );
        }
        if (!Strings.isNullOrEmpty(companyName1)) {
            String[] strs=companyName1.split("-");
            String secret=strs[0];
            queryWrapper.like("secret",secret );
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
//        QueryWrapper<TbUser> queryWrapper=new QueryWrapper();
//        queryWrapper.eq("is_recommend",1);
//        queryWrapper.eq("secret",userView.getId());
//        List<TbUser> list = tbUserService.list(queryWrapper);
//        if(list.size()>=3){
//            return GlobalResult.fail("人数已满");
//        }
        if(userView.getTargetKeys().size()>3){
            return GlobalResult.fail("已大于3人");
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
        String companyName1 = jsonObject.getString("secret");
        if(companyName1!=null){
            String[] strs=companyName1.split("-");
            String companyName=strs[0];
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
            page1.setTotal(tbUserService.countpages(username,mobile,companyName).size());
            return page1;
        }
        String companyName=null;
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
        page1.setTotal(tbUserService.countpages(username,mobile,companyName).size());
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
        String companyName1 = jsonObject.getString("companyName");
        if(companyName1!=null){
            String[] strs=companyName1.split("-");
            String companyName=strs[0];
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
            page1.setTotal( tbUserService.countGroup(companyName).size());
            return page1;
        }
        String companyName=null;
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
        page1.setTotal( tbUserService.countGroup(companyName).size());
        return page1;
    }



    @GetMapping("/getById")
    public TbUser getById(Integer id) {
        //demo
        TbUser tbUser = tbUserService.getById(id);

        return tbUser;
    }

    //导出团队排行excel

    @GetMapping("/GroupListExcel")
    public void GroupListExcel(HttpServletResponse response,@RequestParam("companyName") String companyName) throws Exception {

        if(companyName.equals("undefined")){
            companyName="";
        }
        List<UserDTO> page = tbUserService.listGlobal(companyName);
        List<GroupListModel> dataList = new ArrayList<>();
        int i=1;
        for (UserDTO userDTO : page) {
            GroupListModel groupListModel=new GroupListModel();
            if(userDTO.getCompanyName()==null){
                groupListModel.setCompanyName("无");
            }else {
                groupListModel.setCompanyName(userDTO.getCompanyName());
            }
            groupListModel.setDur(userDTO.getDur());
            groupListModel.setNum(userDTO.getNum());
            groupListModel.setRanking(i);

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            groupListModel.setNewtime(df.format( new Date()));
            dataList.add(groupListModel);
            i++;
        }
                //learnFile/excel
                String file = GlobalConstants.EXCEL_PATH +"/团队排榜.xlsx";
                //先删除
                File fileTmp = new File(file);
                if (fileTmp.exists()) {
                    fileTmp.delete();
                }
                MyExcelUtil.writeOneSheetExcel(file, dataList, GroupListModel.class);
                new DownloadFile().download(file, response);
    }



    //导出个人排行excel
    @GetMapping("/PersonalListExcel")
    public void PersonalListExcel(HttpServletResponse response,@RequestParam("username") String username,@RequestParam("mobile") String mobile,@RequestParam("secret") String secret1) throws Exception {

        if(username.equals("undefined")){
            username="";
        }
        if(secret1.equals("undefined")){
            secret1="";
        }
        if(mobile.equals("undefined")){
            mobile="";
        }
            String[] strs=secret1.split("-");
            String secret=strs[0];

            List<TbUser> page = tbUserService.personalList(username,secret,mobile);
        List<PersonalListModel> dataList = new ArrayList<>();
        int i=1;
        for (TbUser tbUser : page) {
            PersonalListModel personalListModel=new PersonalListModel();
            Company company = companyService.getById(tbUser.getSecret());
            if (company!=null){
                personalListModel.setCompanyName(company.getCompanyName());
            }else {
                personalListModel.setCompanyName("无");
            }
            personalListModel.setDur(tbUser.getAnswerDuration());
            personalListModel.setNum(tbUser.getAnswerNum());
            personalListModel.setMobile(tbUser.getMobile());
            personalListModel.setRanking(i);
            personalListModel.setUsername(tbUser.getUsername());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            personalListModel.setNewtime(df.format( new Date()));
            dataList.add(personalListModel);
            i++;
        }
        if(!secret1.equals("")){
            String[] strs2=secret1.split("-");
            String secret2=strs2[1];
            //learnFile/excel
            String file = GlobalConstants.EXCEL_PATH +"/"+secret2+"个人排榜.xlsx";
            //先删除
            File fileTmp = new File(file);
            if (fileTmp.exists()) {
                fileTmp.delete();
            }
            MyExcelUtil.writeOneSheetExcel(file, dataList, PersonalListModel.class);
            new DownloadFile().download(file, response);
        }else {
            //learnFile/excel
            String file = GlobalConstants.EXCEL_PATH +"/个人排榜.xlsx";
            //先删除
            File fileTmp = new File(file);
            if (fileTmp.exists()) {
                fileTmp.delete();
            }
            MyExcelUtil.writeOneSheetExcel(file, dataList, PersonalListModel.class);
            new DownloadFile().download(file, response);
        }

    }
    //导出小程序用户excel
    @GetMapping("/tbuserExcel")
    public void tbuserExcel(HttpServletResponse response,@RequestParam("secret") String secret,@RequestParam("username") String username,@RequestParam("mobile") String mobile) throws Exception {
        QueryWrapper<TbUser> queryWrapper=new QueryWrapper<>();
        if(username.equals("undefined")){
            username="";
        }
        if(mobile.equals("undefined")){
            mobile="";
        }
        if(secret.equals("undefined")){
            secret="";
        }
        if(!secret.equals("")){
            String[] strs=secret.split("-");
            String secret1=strs[0];
            queryWrapper.like("secret",secret1 );
        }
        queryWrapper.like("username",username);
        queryWrapper.like("mobile",mobile);
        List<TbUser> list = tbUserService.list(queryWrapper);
        List<TbuserExcelModel> dataList = new ArrayList<>();
        for (TbUser tbUser : list) {
            TbuserExcelModel tbuserExcelModel = new TbuserExcelModel();
            Company company = companyService.getById(tbUser.getSecret());
            if (company != null) {
                tbuserExcelModel.setSecret(company.getCompanyName());
            } else {
                tbuserExcelModel.setSecret("无");
            }
            tbuserExcelModel.setUserId(tbUser.getUserId());
            tbuserExcelModel.setAnswerDuration(tbUser.getAnswerDuration());
            tbuserExcelModel.setAnswerNum(tbUser.getAnswerNum());
            if (tbUser.getAnswerTime()!= null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String AnswerTime = sdf.format(tbUser.getAnswerTime());
                tbuserExcelModel.setAnswerTime(AnswerTime);
            }
            tbuserExcelModel.setMobile(tbUser.getMobile());
            tbuserExcelModel.setUsername(tbUser.getUsername());
            dataList.add(tbuserExcelModel);
        }
        if(!secret.equals("")){
            String[] strs=secret.split("-");
            String secret1=strs[1];
            //learnFile/excel
            String file = GlobalConstants.EXCEL_PATH +"/"+secret1+".xlsx";
            //先删除
            File fileTmp = new File(file);
            if (fileTmp.exists()) {
                fileTmp.delete();
            }
            MyExcelUtil.writeOneSheetExcel(file, dataList, TbuserExcelModel.class);
            new DownloadFile().download(file, response);
        }else {
            //learnFile/excel
            String file = GlobalConstants.EXCEL_PATH +"/小程序用户数据.xlsx";
            //先删除
            File fileTmp = new File(file);
            if (fileTmp.exists()) {
                fileTmp.delete();
            }
            MyExcelUtil.writeOneSheetExcel(file, dataList, TbuserExcelModel.class);
            new DownloadFile().download(file, response);
        }
    }
}
