import React, {PureComponent} from 'react'
import Form, {FormItem, FormCore} from 'noform'
import {Input,InputNumber} from 'nowrapper/lib/antd'
const validate = {
postBigName: {type: "string", required: true, message: '岗位的大类名称不能为空'},
postSmallName: {type: "string", required: true, message: '岗位的小类名称不能为空'},

}
class PostOfEnterpriseDemoForm extends PureComponent {
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
 <FormItem label="岗位的大类名称" name="postBigName"><Input/></FormItem>
 <FormItem label="岗位的小类名称" name="postSmallName"><Input/></FormItem>
 </Form>
 )
 }
 }
export default PostOfEnterpriseDemoForm
