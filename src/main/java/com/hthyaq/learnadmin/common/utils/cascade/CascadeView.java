package com.hthyaq.learnadmin.common.utils.cascade;

import lombok.Data;

import java.util.List;

/**
 * antd需要的Cascader数据结构
 * https://ant.design/components/cascader-cn/
 */
@Data
public class CascadeView {
    //名称
    private String label;
    //id
    private Integer value;
    private List<CascadeView> children;
}
