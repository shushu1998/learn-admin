import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
checkDate: {type: "number", required: true, message: '检测时间不能为空'},
checkYear: {type: "number", required: true, message: '检测年份不能为空'},
checkMonth: {type: "number", required: true, message: '检测月份不能为空'},
org: {type: "string", required: true, message: '检测机构不能为空'},
code: {type: "string", required: true, message: '检测机构的社会统一代码不能为空'},
num: {type: "string", required: true, message: '检测报告编号不能为空'},
decideResult: {type: "string", required: true, message: '判定结果不能为空'},
reason: {type: "string", required: true, message: '超标原因不能为空'},
dangerLevel: {type: "string", required: true, message: '危害程度级别不能为空'},

}
class FixCheckOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="检测时间" name="checkDate"><InputNumber/></FormItem>
 <FormItem label="检测年份" name="checkYear"><InputNumber/></FormItem>
 <FormItem label="检测月份" name="checkMonth"><InputNumber/></FormItem>
 <FormItem label="检测机构" name="org"><Input/></FormItem>
 <FormItem label="检测机构的社会统一代码" name="code"><Input/></FormItem>
 <FormItem label="检测报告编号" name="num"><Input/></FormItem>
 <FormItem label="判定结果" name="decideResult"><Input/></FormItem>
 <FormItem label="超标原因" name="reason"><Input/></FormItem>
 <FormItem label="危害程度级别" name="dangerLevel"><Input/></FormItem>
 </Form>
 )
 }
 }
export default FixCheckOfEnterpriseDemoForm
