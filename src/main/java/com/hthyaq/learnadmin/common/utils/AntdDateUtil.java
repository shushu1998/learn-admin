package com.hthyaq.learnadmin.common.utils;

public class AntdDateUtil {
//    public static void main(String[] args) {
//        String str = "2019-10-01";
//        int i = getInteger(str);
//        String s = getString(i);
//        System.out.println(i);
//        System.out.println(s);
//    }

    //2019-10-01转为20191001
    public static Integer getInteger(String strDate) {
        return Integer.parseInt(strDate.replaceAll("-", ""));
    }

    //20191001转为2019-10-01
    public static String getString(Integer intDate) {
        String tmp = intDate + "";
        String year = tmp.substring(0, 4);
        String month = tmp.substring(4, 6);
        String day = tmp.substring(6);
        return year + "-" + month + "-" + day;
    }
}
