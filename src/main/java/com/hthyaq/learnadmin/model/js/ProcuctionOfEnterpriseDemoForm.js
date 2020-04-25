import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
name: {type: "string", required: true, message: '产品名称不能为空'},
status: {type: "string", required: true, message: '产品状态不能为空'},
yearNumber: {type: "number", required: true, message: '产品年产量不能为空'},
productionType: {type: "string", required: true, message: '产量类型不能为空'},
middleName: {type: "string", required: true, message: '中间品名称不能为空'},
middleStatus: {type: "string", required: true, message: '中间品状态不能为空'},
middleYearNumber: {type: "number", required: true, message: '中间品年产量不能为空'},
materialName: {type: "string", required: true, message: '原辅料名称不能为空'},
materialStatus: {type: "string", required: true, message: '原辅料状态不能为空'},
materialYearNumber: {type: "number", required: true, message: '原辅料年用量不能为空'},
materialType: {type: "string", required: true, message: '用量类型不能为空'},
describe: {type: "string", required: true, message: '主要生产工艺描述不能为空'},
isExist: {type: "string", required: true, message: '是否存在职业病危害工艺岗位不能为空'},
isFisrt: {type: "string", required: true, message: '是否优先采用有利于职业病防治和保护劳动者健康的新技术、新工艺和新材料不能为空'},
isUse: {type: "string", required: true, message: '是否使用国家明令禁止的可能产生职业病危害的设备和材料不能为空'},
isHave: {type: "string", required: true, message: '可能产生职业病危害的设备、化学品是否有中文说明书不能为空'},

}
class ProcuctionOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="产品名称" name="name"><Input/></FormItem>
 <FormItem label="产品状态" name="status"><Input/></FormItem>
 <FormItem label="产品年产量" name="yearNumber"><InputNumber/></FormItem>
 <FormItem label="产量类型" name="productionType"><Input/></FormItem>
 <FormItem label="中间品名称" name="middleName"><Input/></FormItem>
 <FormItem label="中间品状态" name="middleStatus"><Input/></FormItem>
 <FormItem label="中间品年产量" name="middleYearNumber"><InputNumber/></FormItem>
 <FormItem label="原辅料名称" name="materialName"><Input/></FormItem>
 <FormItem label="原辅料状态" name="materialStatus"><Input/></FormItem>
 <FormItem label="原辅料年用量" name="materialYearNumber"><InputNumber/></FormItem>
 <FormItem label="用量类型" name="materialType"><Input/></FormItem>
 <FormItem label="主要生产工艺描述" name="describe"><Input/></FormItem>
 <FormItem label="是否存在职业病危害工艺岗位" name="isExist"><Input/></FormItem>
 <FormItem label="是否优先采用有利于职业病防治和保护劳动者健康的新技术、新工艺和新材料" name="isFisrt"><Input/></FormItem>
 <FormItem label="是否使用国家明令禁止的可能产生职业病危害的设备和材料" name="isUse"><Input/></FormItem>
 <FormItem label="可能产生职业病危害的设备、化学品是否有中文说明书" name="isHave"><Input/></FormItem>
 </Form>
 )
 }
 }
export default ProcuctionOfEnterpriseDemoForm
