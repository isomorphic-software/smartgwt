
package com.smartgwt.client.docs;

/**
 * <h3>Including custom elements in the tab order</h3>
 * Non-Smart GWT user interface components which can receive focus, such as native HTML elements
 * or third party widgets may be included the tab order of a Smart GWT page.<br> For example, if a
 * native HTML <code>&lt;input&gt;</code> element is written into  some Canvas as part of its
 * contents, a developer would likely want this element to be included in the tab sequence for the
 * page in its intuitive spot (between the canvas it is embedded in and any subsequent canvases on
 * the page). <P> To achieve this a developer needs to take several steps: <ul> <li>A new (unique)
 * entry for the focusable component should be added to     the TabIndexManager, at the desired
 * location in the tab sequence tree. In the case     of an <code>&lt;input&gt;</code> element
 * written into a Canvas, the developer      would choose an arbitrary identifying string for the
 * input element, and call the      {@link com.smartgwt.client.widgets.TabIndexManager#addTarget
 * TabIndexManager.addTarget()} API, passing in the      {@link
 * com.smartgwt.client.widgets.Canvas#getID ID of the canvas in which it is embedded}      as the
 * parentID parameter.</li> <li>Once the entry has been registered, the developer may call     
 * {@link com.smartgwt.client.widgets.TabIndexManager#getTabIndex TabIndexManager.getTabIndex()}
 * to retrieve a a numeric tabIndex to apply to the     element. This can be used when generating
 * the HTML to write out for the element.</li> <li>The generated numeric tabIndex for this entry
 * will not be static. Various actions,     such as {@link
 * com.smartgwt.client.widgets.Canvas#addChild moving the canvas containing the item to a new
 * parent}     would cause this value to change. The <code>tabIndexUpdated</code> callback
 * parameter     of the {@link com.smartgwt.client.widgets.TabIndexManager#addTarget
 * TabIndexManager.addTarget()} method is a notification which will be     called when this
 * occurs, and may be used to update the element's tab index if     it has already been written
 * into the DOM when the value changes.</li> </ul> In some situations, the Smart GWT framework
 * will intercept Tab keystroke events and explicitly manage focus navigation between elements.
 * Cases where this occurs include moving between unmasked components when a {@link
 * com.smartgwt.client.widgets.Canvas#showClickMask click mask} is up, using the Tab key to
 * navigate between editors embedded in a ListGrid during {@link com.smartgwt.client.docs.Editing
 * grid editing}, and for any focusable UI embedded in a canvas where {@link
 * com.smartgwt.client.widgets.Canvas#getAlwaysManageFocusNavigation
 * Canvas.alwaysManageFocusNavigation} has been explicitly set to true.<br> To have focusable,
 * non-Smart GWT elements participate in this explicit tab navigation, a couple of additional
 * steps are required: <ul> <li>The <code>shiftFocusCallback</code> parameter should be passed to 
 * {@link com.smartgwt.client.widgets.TabIndexManager#addTarget TabIndexManager.addTarget()} when
 * registering an ID for the custom element.      This is a callback developers should implement
 * to     put native focus into the target (or return false if this is not currently possible    
 * for some reason). It will be invoked automatically by the system when focus is being    
 * shifted programmatically</li> <li>Developers should also explicitly intercept the keydown event
 * on the element     they write out, and for Tab (or Shift+Tab) keystrokes, check whether
 * explicit     focus navigation is currently required (by calling      {@link
 * com.smartgwt.client.widgets.TabIndexManager#useExplicitFocusNavigation
 * TabIndexManager.useExplicitFocusNavigation()}, passing in the ID that was     registered via
 * {@link com.smartgwt.client.widgets.TabIndexManager#addTarget TabIndexManager.addTarget()}), and
 * if that returns true     explicitly calling {@link
 * com.smartgwt.client.widgets.TabIndexManager#shiftFocus TabIndexManager.shiftFocus()}, and
 * preventing default     native behavior by invoking     <a
 * href='https://developer.mozilla.org/en-US/docs/Web/API/Event/preventDefault'
 * target='_blank'>preventDefault()</a>     on the native event object.</li> </ul>
 */
public interface CustomTabElements {
}
