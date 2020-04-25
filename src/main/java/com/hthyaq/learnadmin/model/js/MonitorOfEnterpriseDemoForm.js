import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
cycle: {type: "string", required: true, message: '监测周期不能为空'},
monitorTime: {type: "number", required: true, message: '监测时间不能为空'},
monitorResult: {type: "number", required: true, message: '监测结果不能为空'},
unit: {type: "string", required: true, message: '单位不能为空'},
decideResult: {type: "string", required: true, message: '判定结果不能为空'},

}
class MonitorOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="监测周期" name="cycle"><Input/></FormItem>
 <FormItem label="监测时间" name="monitorTime"><InputNumber/></FormItem>
 <FormItem label="监测结果" name="monitorResult"><InputNumber/></FormItem>
 <FormItem label="单位" name="unit"><Input/></FormItem>
 <FormItem label="判定结果" name="decideResult"><Input/></FormItem>
 </Form>
 )
 }
 }
export default MonitorOfEnterpriseDemoForm
