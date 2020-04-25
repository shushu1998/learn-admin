import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
year: {type: "number", required: true, message: '年份不能为空'},
count1: {type: "string", required: true, message: '职业病危害预评价报告数不能为空'},
count2: {type: "string", required: true, message: '控制效果评价报告数不能为空'},
count3: {type: "string", required: true, message: '现状评价报告数不能为空'},
count4: {type: "string", required: true, message: '检测报告数不能为空'},
count5: {type: "string", required: true, message: '检测点数不能为空'},
count6: {type: "string", required: true, message: '达标点数不能为空'},

}
class JianceTotalOfServiceDemoForm extends PureComponent {
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
 <FormItem label="职业病危害预评价报告数" name="count1"><Input/></FormItem>
 <FormItem label="控制效果评价报告数" name="count2"><Input/></FormItem>
 <FormItem label="现状评价报告数" name="count3"><Input/></FormItem>
 <FormItem label="检测报告数" name="count4"><Input/></FormItem>
 <FormItem label="检测点数" name="count5"><Input/></FormItem>
 <FormItem label="达标点数" name="count6"><Input/></FormItem>
 </Form>
 )
 }
 }
export default JianceTotalOfServiceDemoForm
