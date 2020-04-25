import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
year: {type: "number", required: true, message: '检测年份不能为空'},
month: {type: "number", required: true, message: '检测月份不能为空'},
shouldNum: {type: "number", required: true, message: '应检点数不能为空'},
realNum: {type: "number", required: true, message: '实检点数不能为空'},
passNum: {type: "number", required: true, message: '达标点数不能为空'},
checkRate: {type: "number", required: true, message: '检测率不能为空'},
passRate: {type: "number", required: true, message: '达标率不能为空'},
isInclude: {type: "string", required: true, message: '是否包含存在的全部职业病危害因素不能为空'},

}
class EnterpriseCheckSumOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="检测年份" name="year"><InputNumber/></FormItem>
 <FormItem label="检测月份" name="month"><InputNumber/></FormItem>
 <FormItem label="应检点数" name="shouldNum"><InputNumber/></FormItem>
 <FormItem label="实检点数" name="realNum"><InputNumber/></FormItem>
 <FormItem label="达标点数" name="passNum"><InputNumber/></FormItem>
 <FormItem label="检测率" name="checkRate"><InputNumber/></FormItem>
 <FormItem label="达标率" name="passRate"><InputNumber/></FormItem>
 <FormItem label="是否包含存在的全部职业病危害因素" name="isInclude"><Input/></FormItem>
 </Form>
 )
 }
 }
export default EnterpriseCheckSumOfEnterpriseDemoForm
