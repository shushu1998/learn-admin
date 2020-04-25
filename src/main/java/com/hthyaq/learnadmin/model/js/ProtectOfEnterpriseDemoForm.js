import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
isSet: {type: "string", required: true, message: '是否设置防护设施不能为空'},
name: {type: "string", required: true, message: '防护设施名称不能为空'},
type: {type: "string", required: true, message: '防护设施类别不能为空'},
status: {type: "string", required: true, message: '运行状态不能为空'},
isFix: {type: "string", required: true, message: '是否定期进行维护检修保养不能为空'},
protectEffect: {type: "string", required: true, message: '工程防护效果不能为空'},

}
class ProtectOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="是否设置防护设施" name="isSet"><Input/></FormItem>
 <FormItem label="防护设施名称" name="name"><Input/></FormItem>
 <FormItem label="防护设施类别" name="type"><Input/></FormItem>
 <FormItem label="运行状态" name="status"><Input/></FormItem>
 <FormItem label="是否定期进行维护检修保养" name="isFix"><Input/></FormItem>
 <FormItem label="工程防护效果" name="protectEffect"><Input/></FormItem>
 </Form>
 )
 }
 }
export default ProtectOfEnterpriseDemoForm
