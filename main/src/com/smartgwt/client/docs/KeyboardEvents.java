
package com.smartgwt.client.docs;

/**
 * <h3>Keyboard Events</h3>
 * Smart GWT allows keybaord events to be captured at the page level via  {@link com.smartgwt.client.util.Page#registerKey
 * Page.registerKey} or {@link com.smartgwt.client.util.Page#setEvent Page.setEvent} or at the widget level via {@link
 * com.smartgwt.client.widgets.Canvas#addKeyDownHandler Canvas.addKeyDownHandler}, {@link
 * com.smartgwt.client.widgets.Canvas#addKeyPressHandler Canvas.addKeyPressHandler}, and {@link
 * com.smartgwt.client.widgets.Canvas#keyUp Canvas.keyUp}. <P> Details about the key events can be retrieved via static
 * methods on the EventHandler class including {@link com.smartgwt.client.util.EventHandler#getKey EventHandler.getKey},
 * {@link com.smartgwt.client.util.EventHandler#getKeyEventCharacter EventHandler.getKeyEventCharacter} and {@link
 * com.smartgwt.client.util.EventHandler#getKeyEventCharacterValue EventHandler.getKeyEventCharacterValue}. <P> As with
 * other Smart GWT event handling code, returning <code>false</code> will suppress the default native browser behavior.<br>
 * <b>Note:</b> browsers do not allow cancellation of some keys' default behaviors. These cases vary by browser, and
 * wherever native cancellation is supported, returning false from your event handler should be sufficient to suppress the
 * behavior. <br> Some specific cases where default behavior cancellation is not always possible include: <ul><li>Some
 * function keys (<code>f1, f3, f5,</code> etc) which trigger native browser behavior.         [These can be suppressed in
 * Internet Explorer and Mozilla Firefox but not in some other          browsers such as Safari / Chrome, etc]</li>    
 * <li>Some accelerator key combos such as <code>Alt+f3</code></li>     <li>The "Meta" key (the <code>Windows</code> /
 * <code>Apple</code> key to show OS level menu)     </li> </ul> If you do want to include functionality for these keys in
 * your application, we'd recommend  testing against your expected users' browser types. It is also worth considering
 * whether by changing the functionality of these standard browser keys you may provide an unexpected  user experience (for
 * example a user may press "f5" in an attempt to reload the application and be surprised by this triggering some
 * alternative functionality in your application).
 * @see com.smartgwt.client.util.EventHandler#getKeyEventCharacterValue
 * @see com.smartgwt.client.util.EventHandler#getKeyEventCharacter
 * @see com.smartgwt.client.util.EventHandler#getKey
 * @see com.smartgwt.client.util.EventHandler#shiftKeyDown
 * @see com.smartgwt.client.util.EventHandler#ctrlKeyDown
 * @see com.smartgwt.client.util.EventHandler#altKeyDown
 */
public interface KeyboardEvents {
}
