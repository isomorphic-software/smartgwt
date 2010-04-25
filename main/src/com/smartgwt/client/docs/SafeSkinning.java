
package com.smartgwt.client.docs;

/**
 * <h3>Safe Skinning</h3>
 * The skinning mechanism is extremely powerful and gives you the ability to change internal functionality of components. 
 * While this is useful for workarounds, you should think through any properties you override, considering what will happen
 * with future versions of Smart GWT, where the defaults may change or be expanded. <P> The following kinds of overrides
 * are generally very safe: <ul> <li> Change {@link com.smartgwt.client.widgets.Canvas#getStyleName 'styleName'} or {@link
 * com.smartgwt.client.widgets.Button#getBaseStyle 'baseStyle'} to provide a custom CSS style or series of styles <li>
 * Change a media path such as the {@link com.smartgwt.client.widgets.Img#getSrc 'src'} of the  {@link
 * com.smartgwt.client.widgets.Window#getMinimizeButton minimizeButton}. <li> Change the size of any part of the UI that
 * has a fixed pixel size, such as the height and width of the {@link com.smartgwt.client.widgets.Window#getMinimizeButton
 * minimizeButton}, especially when this is done to match the size of media you have created <li> Set properties such as
 * {@link com.smartgwt.client.widgets.Button#getShowRollOver showRollOver} that cause a component to visually react to more
 * or fewer UI states (disabled, over, down, etc) </ul> The following should be very carefully considered: <ul> <li> Adding
 * custom behaviors by passing in event handlers such as  (eg {@link
 * com.smartgwt.client.widgets.Canvas#addShowContextMenuHandler Canvas.addShowContextMenuHandler}).  If future versions of
 * the component add more functionality, you may prevent new features from functioning, cause them to function only
 * partially, or break. <P> If you want to ensure that you do not break new functionality added in future Smart GWT
 * versions, be sure to call {@link com.smartgwt.client..Class#Super Class.Super} for methods you override, and do not
 * prevent events from bubbling. <P> If you want to ensure that <b>only</b> your custom behavior is used if a future
 * version of a Smart GWT component adds functionality, override all methods involved in the interaction, even if your
 * methods do nothing.  For example, for a custom drop interaction, override dropOver, dropMove, dropOut and drop, even if
 * you do nothing on dropMove().  Then, do not call Super() if there is no superclass behavior required for the interaction
 * you've implemented.  Also, for any event handlers (such as drop()) return false if you consider your code to have
 * completely handled the event (no parent component should react). </ul> The following are not recommended: <ul> <li>
 * Providing a global {@link com.smartgwt.client.widgets.Canvas#getID 'ID'} to a subcomponent (only works once). <li>
 * Overriding {@link com.smartgwt.client.widgets.Canvas#getBackgroundColor backgroundColor}, {@link
 * com.smartgwt.client.widgets.Canvas#getBorder 'border'}, {@link com.smartgwt.client.widgets.Canvas#getMargin 'margin'},
 * {@link com.smartgwt.client.widgets.Canvas#getPadding 'padding'}, or in general any single attribute otherwise controlled
 * by CSS.  Future Smart GWT versions may change the base CSS style, rendering your single-property customization
 * senseless.  Change the entire CSS style via {@link com.smartgwt.client.widgets.Canvas#getStyleName 'styleName'} instead.
 * </ul>
 */
public interface SafeSkinning {
}
