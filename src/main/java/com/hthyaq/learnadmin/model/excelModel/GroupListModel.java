package com.hthyaq.learnadmin.model.excelModel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GroupListModel extends BaseRowModel {
    @ExcelProperty(value = {"名次 "},index=0)
    private Integer ranking;

    @ExcelProperty(value = {"名称 "},index=1)
    private String companyName;

    @ExcelProperty(value = {"答对题数"},index=2)
    private Integer num;

    @ExcelProperty(value = {"总耗时间(秒)"},index=3)
    private Integer dur;
}
