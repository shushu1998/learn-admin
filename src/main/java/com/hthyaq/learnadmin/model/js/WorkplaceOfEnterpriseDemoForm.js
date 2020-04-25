import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
name: {type: "string", required: true, message: '工作场所名称不能为空'},
code: {type: "number", required: true, message: '工作场所编码不能为空'},

}
class WorkplaceOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="工作场所名称" name="name"><Input/></FormItem>
 <FormItem label="工作场所编码" name="code"><InputNumber/></FormItem>
 </Form>
 )
 }
 }
export default WorkplaceOfEnterpriseDemoForm
