
package com.smartgwt.client.docs;

/**
 * <h3>Task Input / Output</h3>
 * Each task has "inputs", which are copied from the {@link
 * com.smartgwt.client.util.workflow.Process#getState Process state}
 *  when the task is started, and "outputs", which are atomically applied to the Process
 *  state when a task is completed.
 *  <P>
 * Tasks can use {@link com.smartgwt.client.util.workflow.Task#getInputField Task.inputField} to
 * specify the field from the Process state that
 * should be used as inputs, and {@link com.smartgwt.client.util.workflow.Task#getOutputField
 * Task.outputField} to specify the field in the
 *  Process state that the task should write output.
 *  <P>
 *  More complex tasks can take multiple fields from the process state via
 * {@link com.smartgwt.client.util.workflow.Task#getInputFieldList Task.inputFieldList} and write
 * to multiple fields of the process state via
 * {@link com.smartgwt.client.util.workflow.Task#getOutputFieldList Task.outputFieldList}. In this
 * case, the task is said to have an "input Record"
 *  and/or "output Record", which is a copy of the process state Record
 *  with only the fields listed in the <code>inputFieldList</code> copied.
 *  <P>
 *  When both <code>inputField</code> and <code>inputFieldList</code> are specified, the
 *  inputField is considered the "primary" input field and will be used automatically by
 *  various Task subclasses.
 *  <P>
 * An additional option for output is provided in {@link
 * com.smartgwt.client.util.workflow.Task#getOutputExpression Task.outputExpression} to write
 * task output directly into another {@link com.smartgwt.client.widgets.DataBoundComponent}
 * instead of or in addition
 *  to the process state. See details below.
 *  <P>
 *  <h4>inputField and inputFieldList examples</h4>
 *  <code>inputData</code> represents the result of the <code>inputField</code> processing
 *  and <code>inputRecord</code> represents the result of the <code>inputFieldList</code>.
 *  <P>
 * If the {@link com.smartgwt.client.util.workflow.Process#getState Process.state} represented in
 * JSON is:
 *  <pre>
 *  {
 *     orderId:5,
 *     orderItems: [
 *        {name:"Pencils", quantity:3, itemId:2344}
 *     ],
 *     orderUser: { name:"Henry Winkle", address:"...", ... }
 *  }
 *  </pre>
 * Consider these input definitions and resulting <code>inputData</code> and
 * <code>inputRecord</code>:
 *  <ul>
 *  <li>inputField: orderId
 *    <ul>
 *      <li>inputData: 5
 *      <li>inputRecord: { orderId: 5 }
 *    </ul>
 *  <li>inputField: orderUser.name, inputFieldList: [ "orderUser" ]
 *    <ul>
 *      <li>inputData: "Henry Winkle"
 *      <li>inputRecord: { name: "Henry Winkle", orderUser: { name: "Henry Winkle", address: ... }
 *    </ul>
 *  <li>inputField: orderUser
 *    <ul>
 *      <li>inputData: { name: "Henry Winkle", address: ... }
 *      <li>inputRecord: { orderUser: { name: "Henry Winkle", address: ... } }
 *    </ul>
 *  <li>inputFieldList: [ "orderUser" ]
 *    <ul>
 *      <li>inputData: null
 *      <li>inputRecord: { orderUser: { name: "Henry Winkle", address: ... } }
 *    </ul>
 *  </ul>
 *  Notice that <code>inputField</code> is implicitly added to the <code>inputRecord</code>
 *  as a field with the same name.
 *  <P>
 *  <h4>Field paths</h4>
 *  Specifying an input or output field as a dataPath allows a hierarchical process state
 *  to be flattened into the task input or expanded from the task output.
 *  <P>
 *  <h4>Output expressions</h4>
 * An {@link com.smartgwt.client.util.workflow.Task#getOutputExpression Task.outputExpression} can
 * be specified to write task output directly into
 * another {@link com.smartgwt.client.widgets.DataBoundComponent} instead of or in addition to the
 * process state.
 *  <P>
 *  An output expression is a String prefixed with "$" followed by the DataBoundComponent
 *  ID and optionally followed by a dot-separated field name. When no optional field name
 *  is specified the task output is written to the target component using setValues() or
 *  setData(). With the optional field name, the task output is written to the target
 *  with setFieldValue() or setEditValue(). For a ListGrid the row is either the current
 *  edit row or the one selected row.
 *  <P>
 *  As an example, consider a DynamicForm with ID of "orderHeader". By specifying an
 *  <code>outputExpression</code> as "$orderHeader" for a fetch ServiceTask the response
 *  record will be assigned directly to the DynamicForm.
 * @see com.smartgwt.client.util.workflow.ScriptTask#getInputData
 * @see com.smartgwt.client.util.workflow.ScriptTask#setOutputData
 * @see com.smartgwt.client.util.workflow.ScriptTask#getInputRecord
 * @see com.smartgwt.client.util.workflow.ScriptTask#setOutputRecord
 * @see com.smartgwt.client.util.workflow.Task#getInputField
 * @see com.smartgwt.client.util.workflow.Task#getInputFieldList
 * @see com.smartgwt.client.util.workflow.Task#getOutputField
 * @see com.smartgwt.client.util.workflow.Task#getOutputFieldList
 * @see com.smartgwt.client.util.workflow.Task#getOutputExpression
 * @see com.smartgwt.client.util.workflow.ServiceTask#getCriteria
 * @see com.smartgwt.client.util.workflow.ServiceTask#getOutputField
 * @see com.smartgwt.client.util.workflow.ServiceTask#getOutputFieldList
 */
public interface TaskIO {
}
