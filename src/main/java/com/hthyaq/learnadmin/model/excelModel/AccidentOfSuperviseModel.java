package com.hthyaq.learnadmin.model.excelModel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccidentOfSuperviseModel extends BaseRowModel {
	@ExcelProperty(value = {"年份 "},index=0)
	private Integer year;

	@ExcelProperty(value = {"尘肺病事故数"},index=1)
	private Integer dustCount;

	@ExcelProperty(value = {"中毒事故数"},index=2)
	private Integer poisonCount;

	@ExcelProperty(value = {"其它事故数"},index=3)
	private Integer otherCount;

	@ExcelProperty(value = {"尘肺病事故人数"},index=4)
	private Integer dustPersonCount;

	@ExcelProperty(value = {"中毒事故人数"},index=5)
	private Integer poisonPersonCount;

	@ExcelProperty(value = {"其它事故人数"},index=6)
	private Integer otherPersonCount;

	@ExcelProperty(value = {"尘肺病事故死亡人数"},index=7)
	private String dustDieCount;

	@ExcelProperty(value = {"中毒事故死亡人数"},index=8)
	private String poisonDieCount;

	@ExcelProperty(value = {"其它事故死亡人数"},index=9)
	private Integer otherDieCount;

	@ExcelProperty(value = {"直接经济损失"},index=10)
	private Double loseMoney;

}
