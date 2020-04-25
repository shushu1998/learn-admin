import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
year: {type: "number", required: true, message: '年份不能为空'},
isAccept: {type: "string", required: true, message: '是否接受过相关部门检查不能为空'},
checkDate: {type: "number", required: true, message: '检查时间不能为空'},
org: {type: "string", required: true, message: '检查部门不能为空'},
content: {type: "string", required: true, message: '检查内容不能为空'},
question: {type: "string", required: true, message: '发现问题不能为空'},
isPunish: {type: "string", required: true, message: '是否被行政处罚不能为空'},
type: {type: "string", required: true, message: '行政处罚类别不能为空'},
money: {type: "number", required: true, message: '罚款金额不能为空'},
isChange: {type: "string", required: true, message: '是否落实整改不能为空'},

}
class CheckOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="年份" name="year"><InputNumber/></FormItem>
 <FormItem label="是否接受过相关部门检查" name="isAccept"><Input/></FormItem>
 <FormItem label="检查时间" name="checkDate"><InputNumber/></FormItem>
 <FormItem label="检查部门" name="org"><Input/></FormItem>
 <FormItem label="检查内容" name="content"><Input/></FormItem>
 <FormItem label="发现问题" name="question"><Input/></FormItem>
 <FormItem label="是否被行政处罚" name="isPunish"><Input/></FormItem>
 <FormItem label="行政处罚类别" name="type"><Input/></FormItem>
 <FormItem label="罚款金额" name="money"><InputNumber/></FormItem>
 <FormItem label="是否落实整改" name="isChange"><Input/></FormItem>
 </Form>
 )
 }
 }
export default CheckOfEnterpriseDemoForm
