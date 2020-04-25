import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
name: {type: "string", required: true, message: '姓名不能为空'},
idNum: {type: "string", required: true, message: '身份证号不能为空'},
gender: {type: "string", required: true, message: '性别不能为空'},
birth: {type: "number", required: true, message: '出生日期不能为空'},
startDate: {type: "number", required: true, message: '上岗时间不能为空'},
leaveDate: {type: "number", required: true, message: '离岗时间不能为空'},
touchYear: {type: "number", required: true, message: '接害工龄不能为空'},
isBuy: {type: "string", required: true, message: '是否缴纳工伤保险不能为空'},
isSign: {type: "string", required: true, message: '是否签订劳动合同不能为空'},
isPractice: {type: "string", required: true, message: '是否参加职业卫生培训不能为空'},

}
class TouchPersonOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="姓名" name="name"><Input/></FormItem>
 <FormItem label="身份证号" name="idNum"><Input/></FormItem>
 <FormItem label="性别" name="gender"><Input/></FormItem>
 <FormItem label="出生日期" name="birth"><InputNumber/></FormItem>
 <FormItem label="上岗时间" name="startDate"><InputNumber/></FormItem>
 <FormItem label="离岗时间" name="leaveDate"><InputNumber/></FormItem>
 <FormItem label="接害工龄" name="touchYear"><InputNumber/></FormItem>
 <FormItem label="是否缴纳工伤保险" name="isBuy"><Input/></FormItem>
 <FormItem label="是否签订劳动合同" name="isSign"><Input/></FormItem>
 <FormItem label="是否参加职业卫生培训" name="isPractice"><Input/></FormItem>
 </Form>
 )
 }
 }
export default TouchPersonOfEnterpriseDemoForm
