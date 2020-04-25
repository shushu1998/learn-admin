import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
upDate: {type: "number", required: true, message: '申报时间不能为空'},
upYear: {type: "number", required: true, message: '申报年份不能为空'},
upMonth: {type: "number", required: true, message: '申报月份不能为空'},
dangerBigName: {type: "string", required: true, message: '职业病危害因素大类名称不能为空'},
dangerSmallName: {type: "string", required: true, message: '职业病危害因素小类名称不能为空'},
sickBigName: {type: "string", required: true, message: '可能导致的职业病大类名称不能为空'},
sickSmallName: {type: "string", required: true, message: '可能导致的职业病小类名称不能为空'},
hurt: {type: "string", required: true, message: '可能引起的急性职业伤害不能为空'},
touchNum: {type: "number", required: true, message: '接害人数不能为空'},
workTime: {type: "number", required: true, message: '工作时间不能为空'},
touchTime: {type: "number", required: true, message: '接触时间不能为空'},
touchFrequency: {type: "number", required: true, message: '接触频次不能为空'},
touchMode: {type: "string", required: true, message: '作业方式不能为空'},

}
class PostDangerOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="申报时间" name="upDate"><InputNumber/></FormItem>
 <FormItem label="申报年份" name="upYear"><InputNumber/></FormItem>
 <FormItem label="申报月份" name="upMonth"><InputNumber/></FormItem>
 <FormItem label="职业病危害因素大类名称" name="dangerBigName"><Input/></FormItem>
 <FormItem label="职业病危害因素小类名称" name="dangerSmallName"><Input/></FormItem>
 <FormItem label="可能导致的职业病大类名称" name="sickBigName"><Input/></FormItem>
 <FormItem label="可能导致的职业病小类名称" name="sickSmallName"><Input/></FormItem>
 <FormItem label="可能引起的急性职业伤害" name="hurt"><Input/></FormItem>
 <FormItem label="接害人数" name="touchNum"><InputNumber/></FormItem>
 <FormItem label="工作时间" name="workTime"><InputNumber/></FormItem>
 <FormItem label="接触时间" name="touchTime"><InputNumber/></FormItem>
 <FormItem label="接触频次" name="touchFrequency"><InputNumber/></FormItem>
 <FormItem label="作业方式" name="touchMode"><Input/></FormItem>
 </Form>
 )
 }
 }
export default PostDangerOfEnterpriseDemoForm
