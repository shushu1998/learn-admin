import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
name: {type: "string", required: true, message: '机构名称不能为空'},
code: {type: "string", required: true, message: '社会统一代码不能为空'},
year: {type: "number", required: true, message: '申报年份不能为空'},
provinceName: {type: "string", required: true, message: '省的名称不能为空'},
provinceCode: {type: "string", required: true, message: '省的代码不能为空'},
cityName: {type: "string", required: true, message: '市的名称不能为空'},
cityCode: {type: "string", required: true, message: '市的代码不能为空'},
districtName: {type: "string", required: true, message: '区的名称不能为空'},
districtCode: {type: "string", required: true, message: '区的代码不能为空'},
registerAddress: {type: "string", required: true, message: '注册地址不能为空'},
registerBigName: {type: "string", required: true, message: '登记注册类型的大类名称不能为空'},
registerSmallName: {type: "string", required: true, message: '登记注册类型的小类名称不能为空'},
count1: {type: "number", required: true, message: '医护人员数量不能为空'},
count2: {type: "number", required: true, message: '取证人员数量不能为空'},
projectCount: {type: "number", required: true, message: '检查项目数量不能为空'},
scope: {type: "string", required: true, message: '体检能力不能为空'},
hospitalLevel: {type: "string", required: true, message: '医院等级不能为空'},

}
class TijianBasicOfServiceDemoForm extends PureComponent {
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
 <FormItem label="机构名称" name="name"><Input/></FormItem>
 <FormItem label="社会统一代码" name="code"><Input/></FormItem>
 <FormItem label="申报年份" name="year"><InputNumber/></FormItem>
 <FormItem label="省的名称" name="provinceName"><Input/></FormItem>
 <FormItem label="省的代码" name="provinceCode"><Input/></FormItem>
 <FormItem label="市的名称" name="cityName"><Input/></FormItem>
 <FormItem label="市的代码" name="cityCode"><Input/></FormItem>
 <FormItem label="区的名称" name="districtName"><Input/></FormItem>
 <FormItem label="区的代码" name="districtCode"><Input/></FormItem>
 <FormItem label="注册地址" name="registerAddress"><Input/></FormItem>
 <FormItem label="登记注册类型的大类名称" name="registerBigName"><Input/></FormItem>
 <FormItem label="登记注册类型的小类名称" name="registerSmallName"><Input/></FormItem>
 <FormItem label="医护人员数量" name="count1"><InputNumber/></FormItem>
 <FormItem label="取证人员数量" name="count2"><InputNumber/></FormItem>
 <FormItem label="检查项目数量" name="projectCount"><InputNumber/></FormItem>
 <FormItem label="体检能力" name="scope"><Input/></FormItem>
 <FormItem label="医院等级" name="hospitalLevel"><Input/></FormItem>
 </Form>
 )
 }
 }
export default TijianBasicOfServiceDemoForm
