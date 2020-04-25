import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
loginName: {type: "string", required: true, message: '登录名不能为空'},
loginPassword: {type: "string", required: true, message: '登录密码不能为空'},
email: {type: "string", required: true, message: '电子邮箱不能为空'},
mobile: {type: "string", required: true, message: '手机号码不能为空'},
type: {type: "string", required: true, message: '用户类型不能为空'},

}
class SysUserDemoForm extends PureComponent {
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
 <FormItem label="登录名" name="loginName"><Input/></FormItem>
 <FormItem label="登录密码" name="loginPassword"><Input/></FormItem>
 <FormItem label="电子邮箱" name="email"><Input/></FormItem>
 <FormItem label="手机号码" name="mobile"><Input/></FormItem>
 <FormItem label="用户类型" name="type"><Input/></FormItem>
 </Form>
 )
 }
 }
export default SysUserDemoForm
