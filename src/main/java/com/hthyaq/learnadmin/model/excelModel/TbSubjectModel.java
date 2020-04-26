package com.hthyaq.learnadmin.model.excelModel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TbSubjectModel extends BaseRowModel {

    @ExcelProperty(value = {"题目"},index=0)
    private String content;

    /**
     * 选项
     */
    @ExcelProperty(value = {"A选项"},index=1)
    private String optionA;

    @ExcelProperty(value = {"B选项"},index=2)
    private String optionB;

    @ExcelProperty(value = {"C选项"},index=3)
    private String optionC;

    @ExcelProperty(value = {"D选项"},index=4)
    private String optionD;

    @ExcelProperty(value = {"E选项"},index=5)
    private String optionE;

    @ExcelProperty(value = {"F选项"},index=6)
    private String optionF;

    /**
     * 正确答案
     */
    @ExcelProperty(value = {"正确答案"},index=7)
    private String rightOption;

    /**
     * 选项类型
     */
    @ExcelProperty(value = {"选项类型(1为单选，2为多选)"},index=8)
    private String contentType;

}
