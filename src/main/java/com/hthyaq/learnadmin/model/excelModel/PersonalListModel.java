package com.hthyaq.learnadmin.model.excelModel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PersonalListModel extends BaseRowModel {
    @ExcelProperty(value = {"名次"},index=0)
    private Integer ranking;

    @ExcelProperty(value = {"姓名"},index=1)
    private String username;

    @ExcelProperty(value = {"电话"},index=2)
    private String mobile;

    @ExcelProperty(value = {"所在单位"},index=3)
    private String companyName;

    @ExcelProperty(value = {"答对题数 "},index=4)
    private Integer num;

    @ExcelProperty(value = {"时间(秒) "},index=5)
    private String dur;
}
