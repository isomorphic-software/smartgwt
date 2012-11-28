	    
package com.smartgwt.client.docs;

/**
 * <h3>Task Input / Output</h3>
 * Each task has inputs, which can be thought of as copied from the  {@link
 * com.smartgwt.client.util.workflow.Process#getState Process state} when the task is started, and
 * outputs, which can be thought of as atomically applied to the Process state when a task is
 * completed. <P> Task can use {@link com.smartgwt.client.util.workflow.Task#getInputField
 * inputField} to specify the field from the Process state that should be used as inputs, and
 * {@link com.smartgwt.client.util.workflow.Task#getOutputField outputField} to specify the field
 * from the Process state that the task should output to. <P> More complex tasks can take multiple
 * fields from the process state via {@link
 * com.smartgwt.client.util.workflow.Task#getInputFieldList inputFieldList} and write to multiple
 * fields of the process state via {@link
 * com.smartgwt.client.util.workflow.Task#getOutputFieldList outputFieldList}. In this case, the
 * task is said to have an "input Record" and/or "output Record", which can be thought of as a
 * copy of the process state Record with only the fields listed in the <code>inputFieldList</code>
 * are copied. <P> When both <code>inputField</code> and <code>inputFieldList</code> are
 * specified, the inputField is considered the "primary" input field and will be used
 * automatically by various Task subclasses.
 * @see com.smartgwt.client.util.workflow.ScriptTask#getInputData
 * @see com.smartgwt.client.util.workflow.ScriptTask#setOutputData
 * @see com.smartgwt.client.util.workflow.ScriptTask#getInputRecord
 * @see com.smartgwt.client.util.workflow.ScriptTask#setOutputRecord
 * @see com.smartgwt.client.util.workflow.ServiceTask#getCriteria
 */
public interface TaskIO {
}
