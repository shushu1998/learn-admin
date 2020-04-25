import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
name: {type: "string", required: true, message: '姓名不能为空'},
idNum: {type: "string", required: true, message: '身份证号不能为空'},
type: {type: "string", required: true, message: '体检类别不能为空'},
result: {type: "string", required: true, message: '体检结果不能为空'},
note: {type: "string", required: true, message: '处理意见不能为空'},
implement: {type: "string", required: true, message: '落实情况不能为空'},

}
class TestOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="体检类别" name="type"><Input/></FormItem>
 <FormItem label="体检结果" name="result"><Input/></FormItem>
 <FormItem label="处理意见" name="note"><Input/></FormItem>
 <FormItem label="落实情况" name="implement"><Input/></FormItem>
 </Form>
 )
 }
 }
export default TestOfEnterpriseDemoForm
