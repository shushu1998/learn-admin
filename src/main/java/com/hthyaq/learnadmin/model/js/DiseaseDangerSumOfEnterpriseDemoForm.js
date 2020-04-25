import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
total: {type: "number", required: true, message: '接触职业病危害总人数不能为空'},
dust: {type: "number", required: true, message: '接触粉尘人数不能为空'},
chemistry : {type: "number", required: true, message: '接触化学因素人数不能为空'},
physical : {type: "number", required: true, message: '接触物理因素人数不能为空'},
radioactivity: {type: "number", required: true, message: '接触放射性因素人数不能为空'},
biology: {type: "number", required: true, message: '接触生物因素人数不能为空'},
year: {type: "number", required: true, message: '年份不能为空'},
month: {type: "number", required: true, message: '月份不能为空'},

}
class DiseaseDangerSumOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="接触职业病危害总人数" name="total"><InputNumber/></FormItem>
 <FormItem label="接触粉尘人数" name="dust"><InputNumber/></FormItem>
 <FormItem label="接触化学因素人数" name="chemistry "><InputNumber/></FormItem>
 <FormItem label="接触物理因素人数" name="physical "><InputNumber/></FormItem>
 <FormItem label="接触放射性因素人数" name="radioactivity"><InputNumber/></FormItem>
 <FormItem label="接触生物因素人数" name="biology"><InputNumber/></FormItem>
 <FormItem label="年份" name="year"><InputNumber/></FormItem>
 <FormItem label="月份" name="month"><InputNumber/></FormItem>
 </Form>
 )
 }
 }
export default DiseaseDangerSumOfEnterpriseDemoForm
