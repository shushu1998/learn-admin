import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
checkDate: {type: "number", required: true, message: '体检时间不能为空'},
checkYear: {type: "number", required: true, message: '体检年份不能为空'},
checkMonth: {type: "number", required: true, message: '体检月份不能为空'},
num: {type: "string", required: true, message: '体检报告编号不能为空'},
enterpriseName: {type: "string", required: true, message: '企业名称不能为空'},
enterpriseCode: {type: "string", required: true, message: '统一社会信用代码不能为空'},
provinceName: {type: "string", required: true, message: '省的名称不能为空'},
provinceCode: {type: "string", required: true, message: '省的代码不能为空'},
cityName: {type: "string", required: true, message: '市的名称不能为空'},
cityCode: {type: "string", required: true, message: '市的代码不能为空'},
districtName: {type: "string", required: true, message: '区的名称不能为空'},
districtCode: {type: "string", required: true, message: '区的代码不能为空'},
registerAddress: {type: "string", required: true, message: '注册地址不能为空'},
registerBigName: {type: "string", required: true, message: '登记注册类型的大类名称不能为空'},
registerSmallName: {type: "string", required: true, message: '登记注册类型的小类名称不能为空'},
industryBigName: {type: "string", required: true, message: '所属行业的大类名称不能为空'},
industrySmallName: {type: "string", required: true, message: '所属行业的小类名称不能为空'},
workAddress: {type: "string", required: true, message: '工作场所地址不能为空'},
workplaceName: {type: "string", required: true, message: '工作场所名称不能为空'},
workplaceCode: {type: "number", required: true, message: '工作场所编码不能为空'},
postBigName: {type: "string", required: true, message: '岗位的大类名称不能为空'},
postSmallName: {type: "string", required: true, message: '岗位的小类名称不能为空'},
name: {type: "string", required: true, message: '姓名不能为空'},
idNum: {type: "string", required: true, message: '身份证号不能为空'},
gender: {type: "string", required: true, message: '性别不能为空'},
age: {type: "number", required: true, message: '年龄不能为空'},
workYear: {type: "number", required: true, message: '工龄不能为空'},
tijianType: {type: "string", required: true, message: '体检类别不能为空'},
result: {type: "string", required: true, message: '体检结果不能为空'},

}
class TijianDetail1OfServiceDemoForm extends PureComponent {
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
 <FormItem label="体检时间" name="checkDate"><InputNumber/></FormItem>
 <FormItem label="体检年份" name="checkYear"><InputNumber/></FormItem>
 <FormItem label="体检月份" name="checkMonth"><InputNumber/></FormItem>
 <FormItem label="体检报告编号" name="num"><Input/></FormItem>
 <FormItem label="企业名称" name="enterpriseName"><Input/></FormItem>
 <FormItem label="统一社会信用代码" name="enterpriseCode"><Input/></FormItem>
 <FormItem label="省的名称" name="provinceName"><Input/></FormItem>
 <FormItem label="省的代码" name="provinceCode"><Input/></FormItem>
 <FormItem label="市的名称" name="cityName"><Input/></FormItem>
 <FormItem label="市的代码" name="cityCode"><Input/></FormItem>
 <FormItem label="区的名称" name="districtName"><Input/></FormItem>
 <FormItem label="区的代码" name="districtCode"><Input/></FormItem>
 <FormItem label="注册地址" name="registerAddress"><Input/></FormItem>
 <FormItem label="登记注册类型的大类名称" name="registerBigName"><Input/></FormItem>
 <FormItem label="登记注册类型的小类名称" name="registerSmallName"><Input/></FormItem>
 <FormItem label="所属行业的大类名称" name="industryBigName"><Input/></FormItem>
 <FormItem label="所属行业的小类名称" name="industrySmallName"><Input/></FormItem>
 <FormItem label="工作场所地址" name="workAddress"><Input/></FormItem>
 <FormItem label="工作场所名称" name="workplaceName"><Input/></FormItem>
 <FormItem label="工作场所编码" name="workplaceCode"><InputNumber/></FormItem>
 <FormItem label="岗位的大类名称" name="postBigName"><Input/></FormItem>
 <FormItem label="岗位的小类名称" name="postSmallName"><Input/></FormItem>
 <FormItem label="姓名" name="name"><Input/></FormItem>
 <FormItem label="身份证号" name="idNum"><Input/></FormItem>
 <FormItem label="性别" name="gender"><Input/></FormItem>
 <FormItem label="年龄" name="age"><InputNumber/></FormItem>
 <FormItem label="工龄" name="workYear"><InputNumber/></FormItem>
 <FormItem label="体检类别" name="tijianType"><Input/></FormItem>
 <FormItem label="体检结果" name="result"><Input/></FormItem>
 </Form>
 )
 }
 }
export default TijianDetail1OfServiceDemoForm
