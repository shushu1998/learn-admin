package com.hthyaq.learnadmin.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//前端页面的子表的数据结构
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Child<T> {
    private List<T> dataSource;
}
