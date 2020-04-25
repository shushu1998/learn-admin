import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
isA: {type: "string", required: true, message: '是否制定职业病防治计划和实施方案不能为空'},
isB: {type: "string", required: true, message: '是否建立职业病防治责任制度不能为空'},
isC: {type: "string", required: true, message: '是否建立职业病危害警示与告知制度不能为空'},
isD: {type: "string", required: true, message: '是否建立职业病危害项目申报制度不能为空'},
isE: {type: "string", required: true, message: '是否建立职业病防治宣传教育培训制度不能为空'},
isF: {type: "string", required: true, message: '是否建立职业病防护设施维护检修制度不能为空'},
isG: {type: "string", required: true, message: '是否建立职业病防护用品管理制度不能为空'},
isH: {type: "string", required: true, message: '是否建立职业病危害监测及评价管理制度不能为空'},
isI: {type: "string", required: true, message: '是否建立建设项目职业病防护设施“三同时”管理制度不能为空'},
isJ: {type: "string", required: true, message: '是否建立劳动者职业健康监护及其档案管理制度不能为空'},
isK: {type: "string", required: true, message: '是否建立职业病危害事故处置与报告制度不能为空'},
isL: {type: "string", required: true, message: '是否建立职业病危害应急救援与管理制度不能为空'},
isM: {type: "string", required: true, message: '是否建立岗位职业卫生操作规程不能为空'},
isN: {type: "string", required: true, message: '是否设置或指定职业卫生管理机构不能为空'},
isO: {type: "string", required: true, message: '是否配备了专职或兼职职业卫生管理人员不能为空'},
isP: {type: "string", required: true, message: '单位负责人是否培训合格不能为空'},
isQ: {type: "string", required: true, message: '职业卫生管理人员是否培训合格不能为空'},
isR: {type: "string", required: true, message: '接触职业病危害员工是否培训合格不能为空'},
isS: {type: "string", required: true, message: '是否建立健全职业卫生档案不能为空'},
isT: {type: "string", required: true, message: '是否进行了职业病危害项目申报不能为空'},
isU: {type: "string", required: true, message: '是否落实了建设项目职业病防护设施“三同时”不能为空'},
isV: {type: "string", required: true, message: '是否在醒目位置设置公告栏公布职业病防治相关信息不能为空'},
isW: {type: "string", required: true, message: '是否在存在职业病危害作业场所、岗位、设备的醒目位置设置了警示标识不能为空'},
isX: {type: "string", required: true, message: '是否实施了职业病危害因素日常监测不能为空'},
isY: {type: "string", required: true, message: '是否实施工作场所职业病危害因素定期检测不能为空'},
isZ: {type: "string", required: true, message: '是否与劳动者签订合同并进行危害告知不能为空'},

}
class HealthOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="是否制定职业病防治计划和实施方案" name="isA"><Input/></FormItem>
 <FormItem label="是否建立职业病防治责任制度" name="isB"><Input/></FormItem>
 <FormItem label="是否建立职业病危害警示与告知制度" name="isC"><Input/></FormItem>
 <FormItem label="是否建立职业病危害项目申报制度" name="isD"><Input/></FormItem>
 <FormItem label="是否建立职业病防治宣传教育培训制度" name="isE"><Input/></FormItem>
 <FormItem label="是否建立职业病防护设施维护检修制度" name="isF"><Input/></FormItem>
 <FormItem label="是否建立职业病防护用品管理制度" name="isG"><Input/></FormItem>
 <FormItem label="是否建立职业病危害监测及评价管理制度" name="isH"><Input/></FormItem>
 <FormItem label="是否建立建设项目职业病防护设施“三同时”管理制度" name="isI"><Input/></FormItem>
 <FormItem label="是否建立劳动者职业健康监护及其档案管理制度" name="isJ"><Input/></FormItem>
 <FormItem label="是否建立职业病危害事故处置与报告制度" name="isK"><Input/></FormItem>
 <FormItem label="是否建立职业病危害应急救援与管理制度" name="isL"><Input/></FormItem>
 <FormItem label="是否建立岗位职业卫生操作规程" name="isM"><Input/></FormItem>
 <FormItem label="是否设置或指定职业卫生管理机构" name="isN"><Input/></FormItem>
 <FormItem label="是否配备了专职或兼职职业卫生管理人员" name="isO"><Input/></FormItem>
 <FormItem label="单位负责人是否培训合格" name="isP"><Input/></FormItem>
 <FormItem label="职业卫生管理人员是否培训合格" name="isQ"><Input/></FormItem>
 <FormItem label="接触职业病危害员工是否培训合格" name="isR"><Input/></FormItem>
 <FormItem label="是否建立健全职业卫生档案" name="isS"><Input/></FormItem>
 <FormItem label="是否进行了职业病危害项目申报" name="isT"><Input/></FormItem>
 <FormItem label="是否落实了建设项目职业病防护设施“三同时”" name="isU"><Input/></FormItem>
 <FormItem label="是否在醒目位置设置公告栏公布职业病防治相关信息" name="isV"><Input/></FormItem>
 <FormItem label="是否在存在职业病危害作业场所、岗位、设备的醒目位置设置了警示标识" name="isW"><Input/></FormItem>
 <FormItem label="是否实施了职业病危害因素日常监测" name="isX"><Input/></FormItem>
 <FormItem label="是否实施工作场所职业病危害因素定期检测" name="isY"><Input/></FormItem>
 <FormItem label="是否与劳动者签订合同并进行危害告知" name="isZ"><Input/></FormItem>
 </Form>
 )
 }
 }
export default HealthOfEnterpriseDemoForm
