import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
isSet: {type: "string", required: true, message: '是否配备个人防护用品不能为空'},
name: {type: "string", required: true, message: '个人防护用品名称不能为空'},
modelNum: {type: "string", required: true, message: '防护用品型号不能为空'},
count: {type: "string", required: true, message: '发放数量不能为空'},
cycle: {type: "number", required: true, message: '发放周期不能为空'},
isCorrect: {type: "string", required: true, message: '劳动者是否正确佩戴使用防护用品不能为空'},
isReplace: {type: "string", required: true, message: '是否定期更换个人防护用品不能为空'},

}
class PersonProtectOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="是否配备个人防护用品" name="isSet"><Input/></FormItem>
 <FormItem label="个人防护用品名称" name="name"><Input/></FormItem>
 <FormItem label="防护用品型号" name="modelNum"><Input/></FormItem>
 <FormItem label="发放数量" name="count"><Input/></FormItem>
 <FormItem label="发放周期" name="cycle"><InputNumber/></FormItem>
 <FormItem label="劳动者是否正确佩戴使用防护用品" name="isCorrect"><Input/></FormItem>
 <FormItem label="是否定期更换个人防护用品" name="isReplace"><Input/></FormItem>
 </Form>
 )
 }
 }
export default PersonProtectOfEnterpriseDemoForm
