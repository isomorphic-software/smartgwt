
package com.smartgwt.client.docs;

/**
 * <h3>Task Input Expressions</h3>
 * In some tasks, the input to the task needs to be passed to a service being called by the
 *  task, to a user-visible form, or other consumers of the input data. 
 *  A TaskInputExpression can be used to do this declaratively.
 *  <P>
 *  A TaskInputExpression is a String prefixed with "$input", "$inputRecord", "$ruleScope",
 *  "$state" or "$last" followed by an optional dot-separated hierarchical path,
 *  which can specify either an atomic data value (String, Number) or Record from the
 * input data. For example, if the {@link com.smartgwt.client.util.workflow.Process#getState
 * Process.state} represented in JSON were:
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
 * "$ruleScope" can be used to pull values from a {@link
 * com.smartgwt.client.widgets.Canvas#getRuleScope ruleScope}
 * {@link com.smartgwt.client.widgets.Canvas#getRuleContext ruleContext} when configured in {@link
 * com.smartgwt.client.util.workflow.Process#getRuleScope Process.ruleScope}.
 *  <ul>
 *  <li>$ruleScope.property references the ruleContext "property" field
 *  </ul>
 *  <p>
 *  The other two sources of input are "$state" and "$last". The former references the
 * contents of the {@link com.smartgwt.client.util.workflow.Process#getState Process.state} and
 * the latter the
 *  {@link com.smartgwt.client.util.workflow.Process#getState transient state}.
 *  <ul>
 *  <li>$state is the full contents of the process state
 *  <li>$state.orderId is the "orderId" field of the process state (5 from the example above)
 *  <li>$last is the full output of the previous task executed in the process
 *  <li>$last.property is the "property" field of the previous task executed in the process
 *  <li>$last[service].property or $last[ServiceTask].property references the last "ServiceTask"
 *      output in the "property" field
 *  <li>$ruleScope.property references the ruleScope "property" field
 *  </ul>
 *  <p>
 *  <h4>Transient state outputs</h4>
 *  Most tasks pass the output from the <i>previous</i> task as their output (i.e. passed
 *  through) making it easy to refer to earlier output without referencing the task type.
 *  Tasks that work with records or interact with the user, however, typically provide
 *  task-specific output as detailed below:
 *  <ul>
 *  <li><b>ServiceTask</b>: the contents of dsResponse.data.
 * <li><b>ScriptTask</b>: the result of {@link
 * com.smartgwt.client.util.workflow.ScriptTask#execute execute()} or,
 *      for an asynchronous task, the value passed to
 *      {@link com.smartgwt.client.util.workflow.ScriptTask#setOutputRecord setOutputRecord()} or 
 *      {@link com.smartgwt.client.util.workflow.ScriptTask#setOutputData setOutputData()}.
 *  <li><b>StateTask</b>: the value assigned to the outputField.
 *  <li><b>UserTask</b>: the values of the targetForm or targetVM when the task completes.
 *  <li><b>AskForValueTask</b>: an object with "value" and "canceled" properties.
 *  <li><b>FetchRelatedDataTask</b>: the first fetched record.
 *  <li><b>GridFetchDataTask</b>: the contents of dsResponse.data.
 *  <li><b>GridTransferSelectedTask</b>: the first transfered record.
 *  <li><b>GridSelectRecordsTask</b>: on a select, the set of newly selected records,
 *      even if other records are also selected. On a deselect, the entire set of
 *      de-selected records.
 *  <li><b>FetchRelatedDataTask</b>: the first fetched related record.
 *  <li><b>FormSaveDataTask</b>: an object with "valuesValid" and "errors" properties.
 *  <li><b>FormValidateValuesTask</b>: an object with "valuesValid" and "errors" properties.
 *  <li><b>GetPropertiesTask</b>: an object with selected properties and values retrieved.
 *  </ul>
 */
public interface TaskInputExpression {
}
