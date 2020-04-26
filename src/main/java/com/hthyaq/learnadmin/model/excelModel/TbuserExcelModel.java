package com.hthyaq.learnadmin.model.excelModel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TbuserExcelModel extends BaseRowModel {

    @ExcelProperty(value = {"编号"},index=0)
    private Long userId;

    @ExcelProperty(value = {"姓名"},index=1)
    private String username;

    @ExcelProperty(value = {"手机号"},index=2)
    private String mobile;

    @ExcelProperty(value = {"单位名称"},index=3)
    private String secret;

    @ExcelProperty(value = {"答题时间(秒)"},index=4)
    private String answerTime;

    @ExcelProperty(value = {"答对数量"},index=5)
    private Integer answerNum;

    @ExcelProperty(value = {"答题时长"},index=6)
    private String answerDuration;


}
