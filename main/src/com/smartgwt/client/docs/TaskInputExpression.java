	    
package com.smartgwt.client.docs;

/**
 * <h3>Task Input Expressions</h3>
 * In some tasks, the input to the task needs to be passed to a service being called by the
 *  task, to a user-visible form, or other consumers of the input data. 
 *  A TaskInputExpression can be used to do this declaratively.
 *  <P>
 *  A TaskInputExpression is a String prefixed with either "$input" or "$inputRecord",
 *  followed by an optional dot-separated hierarchical path, which can specify either an
 *  atomic data value (String, Number) or Record from the input data.  For example, if the
 *  {@link com.smartgwt.client.util.workflow.Process#getState state} represented in JSON were:
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
 */
public interface TaskInputExpression {
}
