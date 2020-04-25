package com.hthyaq.learnadmin.common.utils;

public class DoubleUtil {
    //保留double一位小数
    public static double get(double d) {
        //想保留n位小数，就Math.round(a*10的n次方)/10的n次方.n个0
        return Math.round(d * 10) / 10.0;
    }
}
