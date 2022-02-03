
package com.smartgwt.client.docs;

/**
 * <h3>Task Input Expressions</h3>
 * In some tasks, the input to the task needs to be passed to a service being called by the
 *  task, to a user-visible form, or other consumers of the input data. 
 *  A TaskInputExpression can be used to do this declaratively.
 *  <P>
 *  A TaskInputExpression is a String prefixed with "$input", "$inputRecord", "$last",
 *  or "$ruleScope" followed by an optional dot-separated hierarchical path, which can
 *  specify either an atomic data value (String, Number) or Record from the input data.
 * For example, if the {@link com.smartgwt.client.util.workflow.Process#getState Process.state}
 * represented in JSON were:
 *  <pre>
 *  {
 *     orderId:5,
 *     orderItems: [
 *        {name:"Pencils", quantity:3, itemId:2344}
 *     ],
 *     orderUser: { name:"Henry Winkle", address:"...", ... }
 *  }
 *  </pre>
 *  .. and a task specified an <code>inputField</code> of "orderId" and an inputFieldList of
 *  "orderItems","orderUser", then:
 *  <ul>
 *  <li>$input is the value 5
 *  <li>$inputRecord.orderUser.name is "Henry Winkle"
 *  <li>$inputRecord.orderItems[0] is the first orderItems Record ({name:"Pencils", ... })
 *  </ul>
 *  <p>
 *  The other two sources of input are "$last" and "$ruleScope". The former references the
 * contents of the {@link com.smartgwt.client.util.workflow.Process#getState transient state}.
 * Finally, "$ruleScope" can be used
 * to pull values from a {@link com.smartgwt.client.widgets.Canvas#getRuleScope ruleScope} when
 * configured in {@link com.smartgwt.client.util.workflow.Process#getRuleScope Process.ruleScope}.
 *  <ul>
 *  <li>$last is the full output of the previous task executed in the process
 *  <li>$last[service].property or $last[ServiceTask].property references the last "ServiceTask"
 *      output in the "property" field
 *  <li>$ruleScope.property references the ruleScope "property" field
 *  </ul>
 *  <p>
 *  <h4>Transient state outputs</h4>
 *  The transient state outputs of each task type referenced by "$last" above:
 *  <ul>
 *  <li><b>DecisionGateway</b>: the output from the <i>previous</i> task (passed through).
 * <li><b>ScriptTask</b>: the result of {@link
 * com.smartgwt.client.util.workflow.ScriptTask#execute execute()} or, for an asynchronous task,
 * the value passed to {@link com.smartgwt.client.util.workflow.ScriptTask#setOutputRecord
 * setOutputRecord()} or 
 *      {@link com.smartgwt.client.util.workflow.ScriptTask#setOutputData setOutputData()}.
 *  <li><b>ServiceTask</b>: the contents of dsResponse.data.
 *  <li><b>StateTask</b>: the value assigned to the outputField.
 *  <li><b>UserTask</b>: the values of the targetForm or targetVM when the task completes.
 *  <li><b>XORGateway</b>: the output from the <i>previous</i> task (passed through).
 *  </ul>
 */
public interface TaskInputExpression {
}
