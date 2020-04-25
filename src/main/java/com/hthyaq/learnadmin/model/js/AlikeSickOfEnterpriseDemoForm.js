import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
name: {type: "string", required: true, message: '姓名不能为空'},
idNum: {type: "string", required: true, message: '身份证号不能为空'},
org: {type: "string", required: true, message: '检查机构不能为空'},
checkDate: {type: "number", required: true, message: '检查日期不能为空'},
checkYear: {type: "number", required: true, message: '检查年份不能为空'},
checkMonth: {type: "number", required: true, message: '检查月份不能为空'},
sickYear: {type: "number", required: true, message: '发病工龄不能为空'},
isReport: {type: "string", required: true, message: '是否进行了疑似职业病病人报告不能为空'},

}
class AlikeSickOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="检查机构" name="org"><Input/></FormItem>
 <FormItem label="检查日期" name="checkDate"><InputNumber/></FormItem>
 <FormItem label="检查年份" name="checkYear"><InputNumber/></FormItem>
 <FormItem label="检查月份" name="checkMonth"><InputNumber/></FormItem>
 <FormItem label="发病工龄" name="sickYear"><InputNumber/></FormItem>
 <FormItem label="是否进行了疑似职业病病人报告" name="isReport"><Input/></FormItem>
 </Form>
 )
 }
 }
export default AlikeSickOfEnterpriseDemoForm
