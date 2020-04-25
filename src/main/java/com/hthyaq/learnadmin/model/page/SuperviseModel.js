import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input} from 'nowrapper/lib/antd'

const validate = {
	id: {type: "number", required: true, message: '主键不能为空'},
	year: {type: "number", required: true, message: '申报年份不能为空'},
	provinceName: {type: "string", required: true, message: '省的名称不能为空'},
	provinceCode: {type: "string", required: true, message: '省的代码不能为空'},
	cityName: {type: "string", required: true, message: '市的名称不能为空'},
	cityCode: {type: "string", required: true, message: '市的代码不能为空'},
	districtName: {type: "string", required: true, message: '区的名称不能为空'},
	districtCode: {type: "string", required: true, message: '区的代码不能为空'},
	registerAddress: {type: "string", required: true, message: '注册地址不能为空'},
	name: {type: "string", required: true, message: '单位名称不能为空'},
	isSet: {type: "string", required: true, message: '是否独立设置职业健康监管部门不能为空'},
	markCount: {type: "number", required: true, message: '职业健康监管人员编制数不能为空'},
	manageCount: {type: "number", required: true, message: '在岗职业健康监管人员数不能为空'},
}

 class Supervise extends PureComponent {
	state = {}

	constructor(props) {
	super(props);
	 this.core = new FormCore({validateConfig: validate});
	 }

	 componentWillMount() {

	}

	 render() {
	return (
	<Form core={this.core} layout={{label: 4, control: 20}}>
	 <FormItem style={{display: 'none'}} name="id"><Input/></FormItem>
	<FormItem label="主键" name="id"><Input/></FormItem>
	<FormItem label="申报年份" name="year"><Input/></FormItem>
	<FormItem label="省的名称" name="provinceName"><Input/></FormItem>
	<FormItem label="省的代码" name="provinceCode"><Input/></FormItem>
	<FormItem label="市的名称" name="cityName"><Input/></FormItem>
	<FormItem label="市的代码" name="cityCode"><Input/></FormItem>
	<FormItem label="区的名称" name="districtName"><Input/></FormItem>
	<FormItem label="区的代码" name="districtCode"><Input/></FormItem>
	<FormItem label="注册地址" name="registerAddress"><Input/></FormItem>
	<FormItem label="单位名称" name="name"><Input/></FormItem>
	<FormItem label="是否独立设置职业健康监管部门" name="isSet"><Input/></FormItem>
	<FormItem label="职业健康监管人员编制数" name="markCount"><Input/></FormItem>
	<FormItem label="在岗职业健康监管人员数" name="manageCount"><Input/></FormItem>
	 </Form>
	)
	}
}

 export default Supervise
