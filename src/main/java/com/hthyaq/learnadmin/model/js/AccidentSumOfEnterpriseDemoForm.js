import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
accidentNum: {type: "string", required: true, message: '职业病危害事故编号不能为空'},
startTime: {type: "number", required: true, message: '事故发生时间不能为空'},
place: {type: "string", required: true, message: '事故发生地点不能为空'},
dangerBigName: {type: "string", required: true, message: '导致事故的职业病危害因素大类名称不能为空'},
dangerSmallName: {type: "string", required: true, message: '导致事故的职业病危害因素小类名称不能为空'},
sickCount: {type: "number", required: true, message: '发病人数不能为空'},
treatCount: {type: "number", required: true, message: '送医院治疗人数不能为空'},
dieCount: {type: "number", required: true, message: '死亡人数不能为空'},
directLose: {type: "number", required: true, message: '直接经济损失不能为空'},
indirectLose: {type: "number", required: true, message: '间接经济损失不能为空'},
reason: {type: "string", required: true, message: '事故原因不能为空'},
process: {type: "string", required: true, message: '事故经过不能为空'},
isReport: {type: "string", required: true, message: '是否向有关部门报告不能为空'},

}
class AccidentSumOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="职业病危害事故编号" name="accidentNum"><Input/></FormItem>
 <FormItem label="事故发生时间" name="startTime"><InputNumber/></FormItem>
 <FormItem label="事故发生地点" name="place"><Input/></FormItem>
 <FormItem label="导致事故的职业病危害因素大类名称" name="dangerBigName"><Input/></FormItem>
 <FormItem label="导致事故的职业病危害因素小类名称" name="dangerSmallName"><Input/></FormItem>
 <FormItem label="发病人数" name="sickCount"><InputNumber/></FormItem>
 <FormItem label="送医院治疗人数" name="treatCount"><InputNumber/></FormItem>
 <FormItem label="死亡人数" name="dieCount"><InputNumber/></FormItem>
 <FormItem label="直接经济损失" name="directLose"><InputNumber/></FormItem>
 <FormItem label="间接经济损失" name="indirectLose"><InputNumber/></FormItem>
 <FormItem label="事故原因" name="reason"><Input/></FormItem>
 <FormItem label="事故经过" name="process"><Input/></FormItem>
 <FormItem label="是否向有关部门报告" name="isReport"><Input/></FormItem>
 </Form>
 )
 }
 }
export default AccidentSumOfEnterpriseDemoForm
