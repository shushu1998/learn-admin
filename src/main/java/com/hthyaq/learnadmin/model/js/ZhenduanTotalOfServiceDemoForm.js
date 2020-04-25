import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
year: {type: "number", required: true, message: '年份不能为空'},
count1: {type: "number", required: true, message: '诊断人数不能为空'},
count2: {type: "number", required: true, message: '诊断职业病企业数不能为空'},
count3: {type: "number", required: true, message: '诊断报告数不能为空'},

}
class ZhenduanTotalOfServiceDemoForm extends PureComponent {
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
 <FormItem label="诊断人数" name="count1"><InputNumber/></FormItem>
 <FormItem label="诊断职业病企业数" name="count2"><InputNumber/></FormItem>
 <FormItem label="诊断报告数" name="count3"><InputNumber/></FormItem>
 </Form>
 )
 }
 }
export default ZhenduanTotalOfServiceDemoForm
