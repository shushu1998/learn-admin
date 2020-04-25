import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
accidentNum: {type: "string", required: true, message: '职业病危害事故编号不能为空'},
name: {type: "string", required: true, message: '姓名不能为空'},
idNum: {type: "string", required: true, message: '身份证号不能为空'},
gender: {type: "string", required: true, message: '性别不能为空'},
age: {type: "number", required: true, message: '年龄不能为空'},
isDie: {type: "string", required: true, message: '是否死亡不能为空'},
dieDate: {type: "number", required: true, message: '死亡日期不能为空'},

}
class AccidentPersonOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="姓名" name="name"><Input/></FormItem>
 <FormItem label="身份证号" name="idNum"><Input/></FormItem>
 <FormItem label="性别" name="gender"><Input/></FormItem>
 <FormItem label="年龄" name="age"><InputNumber/></FormItem>
 <FormItem label="是否死亡" name="isDie"><Input/></FormItem>
 <FormItem label="死亡日期" name="dieDate"><InputNumber/></FormItem>
 </Form>
 )
 }
 }
export default AccidentPersonOfEnterpriseDemoForm
