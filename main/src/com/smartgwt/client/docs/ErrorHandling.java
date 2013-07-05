
package com.smartgwt.client.docs;

/**
 * <h3>Error Handling Overview</h3>
 * {@link com.smartgwt.client.rpc.RPCResponse} and {@link com.smartgwt.client.data.DSResponse}
 * objects have an integer status field that the 
 *  RPCManager inspects when the response is received from the server. If the value of this 
 *  field is less than zero, the request is considered to have failed.  Otherwise it is 
 *  considered to have succeeded.  This value is settable via the setStatus() method call 
 *  on the server-side DSResponse and RPCResponse objects.
 *  <p>
 *  Errors in a Smart GWT application fall into two main categories:<ul>
 *  <li>Validation errors, which arise as a result of rules in the application's business logic
 *  being broken.  These are part of the normal operation of the system.  A response with 
 * validation errors has a status of {@link
 * com.smartgwt.client.rpc.RPCResponse#STATUS_VALIDATION_ERROR STATUS_VALIDATION_ERROR}</li>
 *  <li>Unrecoverable errors, which are errors with the system itself.  These are not part of 
 *  the normal operation of the system</li>
 *  </ul>
 *  <b>Validation errors</b> are treated differently from other errors, precisely because they
 *  are an expected part of the normal operation of the system.  If 
 * {@link com.smartgwt.client.widgets.form.DynamicForm#validate validation} of a form results in
 * errors, the form is redrawn to
 *  display those errors to the user.  How the user sees those errors is completely configurable -
 * for example, see the DynamicForm properties {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons showErrorIcons},
 *  {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}, 
 * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors}, and
 * indeed most DynamicForm properties
 *  that contain the workd "Error" - but the default in most skins is to highlight the field 
 *  with some kind of error icon, and provide the actual error text message in a floating box 
 *  when the user hovers over the field.
 *  <p>
 *  The remainder of this article concerns <b>unrecoverable errors</b>.  These are errors with
 *  the system itself, for example:<ul>
 *  <li>A network transport problem</li>
 *  <li>A server-side crash</li>
 *  <li>An update failed because a transaction was rolled back</li>
 *  </ul>
 *  Errors like this can either be handled centrally, or you can choose to handle them in your
 * regular callback code.  {@link com.smartgwt.client.data.DSRequest} calls default to centralized
 * handling; 
 * {@link com.smartgwt.client.rpc.RPCRequest} calls default to user error handling in the
 * callback.
 *  <p>
 *  <b>Centralized Error Handling</b><br>
 *  If the status field shows a failure, the RPCManager will invoke 
 * {@link com.smartgwt.client.rpc.RPCManager#handleError RPCManager.handleError}.  By default,
 * this logs a warning and shows a dialog 
 * with the contents of the response's {@link com.smartgwt.client.rpc.RPCResponse#getData data}
 * field (which is assumed 
 *  to contain a meaningful description of the error that occurred).  If you specified a 
 *  callback in your request, it will <b>not</b> be called if the status shows a failure 
 *  (see the section on custom error handling below for how to change this).  This default 
 *  arrangement means that any Smart GWT application has a basic handling mechanism for 
 *  unrecoverable errors, without any code to write.
 *  <p>
 *  You can customize centralized error handling at two levels:<ul>
 *  <li>
 *  
 *  Use 
 * {@link
 * com.smartgwt.client.rpc.RPCManager#setHandleErrorCallback(com.smartgwt.client.rpc.HandleErrorCallback)}
 *  to provide your own error handling logic (note
 *  that customization takes place at the static class level, not per-instance)</li>
 *  <li>
 *  
 *  Use 
 * {@link
 * com.smartgwt.client.rpc.RPCManager#setHandleTransportErrorCallback(com.smartgwt.client.rpc.HandleTransportErrorCallback)}.
 *  This logic is called earlier than
 *  handleError, and it is called even when you are using custom error handling (discussed
 *  below).  It is intended to allow your code to inspect the failed response early in the 
 *  handling flow, to see if it is really unrecoverable.  For example, a failure might have 
 *  happened because of a temporary network problem, so resubmitting the request may be a valid
 *  thing to do to try to resolve the error.  Note, as with handleError, this is a static 
 *  class-level customization</li>
 *  </ul>
 *  <p>
 *  <b>Custom Error Handling</b><br>
 *  As an alternative to handling errors centrally, you can handle them in your regular callback
 * methods.  To do this, specify {@link com.smartgwt.client.rpc.RPCRequest#getWillHandleError
 * willHandleError} as a 
 *  request property.  When you do this, centralized error handling is bypassed (as mentioned 
 *  above, <code>handleTransportError()</code> will still be called) and your callback is 
 *  invoked as normal.  Your callback code determines that it is in error state by inspecting
 *  the status property on the response - if it is negative, there has been an error.  Note 
 *  that validation errors are treated specially, in that your callback is invoked, but the 
 *  normal behavior of populating the field errors onto the form and redrawing it <b>also</b>
 *  takes place.
 *  <p>
 *  Note, when you are handling errors in user callbacks, a negative status in the response 
 *  indicates some sort of serious, unrecoverable error (except in the case of 
 * {@link com.smartgwt.client.rpc.RPCResponse#STATUS_VALIDATION_ERROR STATUS_VALIDATION_ERROR}). 
 * Therefore, ensure that your error handling 
 *  code does not assume that the response will be properly formed or contain particular 
 *  elements.
 *  <p>
 *  You can specify <code>willHandleError</code> (or any other DSRequest/RPCRequest property)
 *  on a component request by providing the DSRequest Properties parameter.  For example, on
 *  a {@link com.smartgwt.client.widgets.grid.ListGrid#fetchData ListGrid.fetchData}:
 *  
 *  <pre>
 *      DSRequest properties = new DSRequest();
 *      properties.setWillHandleError(true);
 *      listGrid.fetchData(new Criteria(), new DSCallback() {
 *          public void execute(DSResponse response, Object rawData, DSRequest request) {
 *              if (response.getStatus() < 0) {
 *                  // Error handling here
 *              } else {
 *                  // Normal processing here
 *              }
 *          }
 *      }, <b>properties</b>);
 *  </pre>
 *  </code>
 *  
 *  <b>Error Status Codes</b><br>
 *  The error status codes used by the framework are documented as class variables of the 
 * {@link com.smartgwt.client.rpc.RPCRequest RPCRequest class}.  Status codes in the range -1 to
 * -100 are 
 *  reserved for use by the framework; if you wish to introduce new custom error statuses for 
 *  your own use, avoid this range.
 *  <p>
 *  <b>Errors indicating login is required</b><br>
 *  Some of the framework error statuses indicate that login is required, typically because a 
 *  user's HTTP session has timed out.  The best way to handle this situation is to use the 
 * built-in {@link com.smartgwt.client.docs.Relogin re-login flow} to automatically prompt users
 * to log back
 *  in as required, and then resubmit the requests that triggered the login required response.
 * @see com.smartgwt.client.data.events.ErrorEvent
 * @see com.smartgwt.client.data.DataSource#getSimpleErrors
 * @see com.smartgwt.client.rpc.RPCManager#handleError
 * @see com.smartgwt.client.rpc.RPCManager#handleTransportError
 * @see com.smartgwt.client.data.DSResponse#getStatus
 * @see com.smartgwt.client.data.DSResponse#getQueueStatus
 * @see com.smartgwt.client.data.DSResponse#getErrors
 * @see com.smartgwt.client.data.DSRequest#getCallback
 * @see com.smartgwt.client.rpc.RPCRequest#getCallback
 * @see com.smartgwt.client.rpc.RPCRequest#getWillHandleError
 */
public interface ErrorHandling {
}
