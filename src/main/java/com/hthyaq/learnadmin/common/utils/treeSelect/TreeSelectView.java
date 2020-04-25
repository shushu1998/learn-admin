package com.hthyaq.learnadmin.common.utils.treeSelect;

import lombok.Data;

import java.util.List;

/**
 * antd需要的treedata数据结构
 * https://ant.design/components/tree-select-cn/
 */
@Data
public class TreeSelectView {
    //名称
    private String title;
    //id
    private Integer value;
    //id
    private Integer key;
    private List<TreeSelectView> children;
}