package com.hthyaq.learnadmin.model.vo;

import com.hthyaq.learnadmin.model.bean.Child;
import com.hthyaq.learnadmin.model.entity.Demo;
import com.hthyaq.learnadmin.model.entity.DemoCourse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
@EqualsAndHashCode(callSuper = true)
//demo的页面数据
@Data
@Accessors(chain = false)
public class DemoView extends Demo {
    private Child<DemoCourse> course;
}
