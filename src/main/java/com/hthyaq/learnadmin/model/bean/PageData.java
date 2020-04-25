package com.hthyaq.learnadmin.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageData<T> {
    //当前页码
    private Integer currentPage;
    //每页显示多少条记录
    private Integer pageSize;
    //总记录数
    private Integer total;
    //总页数
    private Integer totalPage;
    //具体记录数
    private List<T> dataList;
}
