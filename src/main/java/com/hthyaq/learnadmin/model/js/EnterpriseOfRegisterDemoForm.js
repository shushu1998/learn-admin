import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
name: {type: "string", required: true, message: '企业名称不能为空'},
code: {type: "string", required: true, message: '统一社会信用代码不能为空'},
provinceName: {type: "string", required: true, message: '省的名称不能为空'},
provinceCode: {type: "string", required: true, message: '省的代码不能为空'},
cityName: {type: "string", required: true, message: '市的名称不能为空'},
cityCode: {type: "string", required: true, message: '市的代码不能为空'},
districtName: {type: "string", required: true, message: '区的名称不能为空'},
districtCode: {type: "string", required: true, message: '区的代码不能为空'},
productionCapacity: {type: "string", required: true, message: '核定生产能力不能为空'},
unitType: {type: "string", required: true, message: '生产能力单位类型不能为空'},
regiterMoney: {type: "string", required: true, message: '注册资本不能为空'},
registerAddress: {type: "string", required: true, message: '注册地址不能为空'},
registerDate: {type: "string", required: true, message: '注册时间不能为空'},
startDate: {type: "string", required: true, message: '投产时间不能为空'},
propertyMoney: {type: "string", required: true, message: '资产总额不能为空'},
email: {type: "string", required: true, message: '电子邮箱不能为空'},
mobile: {type: "string", required: true, message: '手机号码不能为空'},

}
class EnterpriseOfRegisterDemoForm extends PureComponent {
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
 <FormItem label="企业名称" name="name"><Input/></FormItem>
 <FormItem label="统一社会信用代码" name="code"><Input/></FormItem>
 <FormItem label="省的名称" name="provinceName"><Input/></FormItem>
 <FormItem label="省的代码" name="provinceCode"><Input/></FormItem>
 <FormItem label="市的名称" name="cityName"><Input/></FormItem>
 <FormItem label="市的代码" name="cityCode"><Input/></FormItem>
 <FormItem label="区的名称" name="districtName"><Input/></FormItem>
 <FormItem label="区的代码" name="districtCode"><Input/></FormItem>
 <FormItem label="核定生产能力" name="productionCapacity"><Input/></FormItem>
 <FormItem label="生产能力单位类型" name="unitType"><Input/></FormItem>
 <FormItem label="注册资本" name="regiterMoney"><Input/></FormItem>
 <FormItem label="注册地址" name="registerAddress"><Input/></FormItem>
 <FormItem label="注册时间" name="registerDate"><Input/></FormItem>
 <FormItem label="投产时间" name="startDate"><Input/></FormItem>
 <FormItem label="资产总额" name="propertyMoney"><Input/></FormItem>
 <FormItem label="电子邮箱" name="email"><Input/></FormItem>
 <FormItem label="手机号码" name="mobile"><Input/></FormItem>
 </Form>
 )
 }
 }
export default EnterpriseOfRegisterDemoForm
