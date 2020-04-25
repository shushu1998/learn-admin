package com.hthyaq.learnadmin.common.constants;

public class GlobalConstants {
    //分页时，显示的数据条数
    public static final Integer PAGE_SIZE = 10;
    public static final Boolean TRUE = true;
    public static final Boolean FALSE = false;
    //状态码
    public static final Integer SUCCESS = 0;
    public static final String SUCCESS_MSG = "操作成功！";
    public static final Integer FAIL = 1;
    public static final String FAIL_MSG = "操作失败！";
    //换行符
    public static final String NEWLINE = System.getProperty("line.separator");
    //路径分隔符
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    //db的操作类型
    public static final String DB_OPERATE_INSERT = "insert";
    public static final String DB_OPERATE_UPDATE = "update";
    public static final String DB_OPERATE_DELETE = "update";
    //用户[注册/登录]的id、没有登录的提示信息
    public static final String LOGIN_NAME = "loginName";
    public static final String USER_NO_LOGIN = "当前用户没有登录";
    //excel路径
    public static final String EXCEL_PATH = "D:/learnFile/excel";

}
