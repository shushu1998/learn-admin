import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
year: {type: "number", required: true, message: '年份不能为空'},
count1: {type: "number", required: true, message: '体检报告数不能为空'},
count2: {type: "number", required: true, message: '体检人数不能为空'},
count3: {type: "number", required: true, message: '职业禁忌证人数不能为空'},
count4: {type: "number", required: true, message: '疑似职业病人数不能为空'},

}
class TijianTotalOfServiceDemoForm extends PureComponent {
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
 <FormItem label="体检报告数" name="count1"><InputNumber/></FormItem>
 <FormItem label="体检人数" name="count2"><InputNumber/></FormItem>
 <FormItem label="职业禁忌证人数" name="count3"><InputNumber/></FormItem>
 <FormItem label="疑似职业病人数" name="count4"><InputNumber/></FormItem>
 </Form>
 )
 }
 }
export default TijianTotalOfServiceDemoForm
