/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A general purpose Window class for implementing dialogs, portlets, alerts, prompts, wizards and desktop-like windowing
 * interfaces. <P> Windows can contain arbitrary Smart GWT components, configured via the {@link
 * com.smartgwt.client.widgets.Window#getItems items} property.  Windows may be {@link
 * com.smartgwt.client.widgets.Window#getIsModal modal} or non-modal. <P> Windows provide a series of highly configurable
 * and skinnable  autoChildren including a header, various header controls, footer, and corner resizer. <P> The more
 * specialized {@link com.smartgwt.client.widgets.Dialog} subclass of Window has additional functionality targetted at
 * simple prompts and confirmations, such as buttons with default actions, and single-method {@link
 * com.smartgwt.client.util.isc#warn shortcuts} for common application dialogs.
 */
public class Window extends VLayout  implements com.smartgwt.client.widgets.events.HasMaximizeClickHandlers, com.smartgwt.client.widgets.events.HasMinimizeClickHandlers, com.smartgwt.client.widgets.events.HasRestoreClickHandlers, com.smartgwt.client.widgets.events.HasCloseClickHandlers {

    public static Window getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Window) obj;
        } else {
            return new Window(jsObj);
        }
    }

    public Window(){
        setShowHeaderIcon(false);scClassName = "Window";
    }

    public Window(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Should this window minimize, maximize, and restore as an animation, or as a  simple 1-step transition?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param animateMinimize animateMinimize Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_minimize" target="examples">Window Minimize Example</a>
     */
    public void setAnimateMinimize(Boolean animateMinimize) {
        setAttribute("animateMinimize", animateMinimize, true);
    }

    /**
     * Should this window minimize, maximize, and restore as an animation, or as a  simple 1-step transition?
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_minimize" target="examples">Window Minimize Example</a>
     */
    public Boolean getAnimateMinimize()  {
        return getAttributeAsBoolean("animateMinimize");
    }

    /**
     * If true, this Window widget will automatically be centered on the page when shown.      If false, it will show up in the
     * last position it was placed (either programmatically,      or by user interaction).
     *
     * @param autoCenter autoCenter Default value is autoCenter
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAutoCenter(Boolean autoCenter) {
        setAttribute("autoCenter", autoCenter, true);
    }

    /**
     * If true, this Window widget will automatically be centered on the page when shown.      If false, it will show up in the
     * last position it was placed (either programmatically,      or by user interaction).
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getAutoCenter()  {
        return getAttributeAsBoolean("autoCenter");
    }

    /**
     * If true, the window is resized automatically to accommodate the contents   of the body, if they would otherwise require
     * scrolling.
     * Setter for {@link com.smartgwt.client.widgets.Window#getAutoSize autoSize}
     *
     * @param autoSize true if the window should auto-size to its content. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_windows_autosize" target="examples">Auto Size Example</a>
     */
    public void setAutoSize(Boolean autoSize) {
        setAttribute("autoSize", autoSize, true);
    }

    /**
     * If true, the window is resized automatically to accommodate the contents   of the body, if they would otherwise require
     * scrolling.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_windows_autosize" target="examples">Auto Size Example</a>
     */
    public Boolean getAutoSize()  {
        return getAttributeAsBoolean("autoSize");
    }

    /**
     * Color of the Window body. Overrides the background color specified in the style.
     *
     * @param bodyColor bodyColor Default value is "#FFFFFF"
     * @see com.smartgwt.client.widgets.Window#flash
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBodyColor(String bodyColor) {
        setAttribute("bodyColor", bodyColor, true);
    }

    /**
     * Color of the Window body. Overrides the background color specified in the style.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.Window#flash
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBodyColor()  {
        return getAttributeAsString("bodyColor");
    }

    /**
     * Style of the Window body.
     *
     * @param bodyStyle bodyStyle Default value is "windowBody"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBodyStyle(String bodyStyle) {
        setAttribute("bodyStyle", bodyStyle, true);
    }

    /**
     * Style of the Window body.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBodyStyle()  {
        return getAttributeAsString("bodyStyle");
    }

    /**
     * If true, this Window may be moved around by the user by dragging on the Window header.   Note that if the header is not
     * showing, the Window can't be drag-repositioned regardless of this setting.
     *
     * @param canDragReposition canDragReposition Default value is true
     * @see com.smartgwt.client.widgets.Window#setShowHeader
     */
    public void setCanDragReposition(Boolean canDragReposition) {
        setAttribute("canDragReposition", canDragReposition, true);
    }

    /**
     * If true, this Window may be moved around by the user by dragging on the Window header.   Note that if the header is not
     * showing, the Window can't be drag-repositioned regardless of this setting.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.Window#getShowHeader
     */
    public Boolean getCanDragReposition()  {
        return getAttributeAsBoolean("canDragReposition");
    }

    /**
     * Can the window be drag-resized? If true the window may be drag resized from its edges, and if showing, via the resizer
     * icon in the footer.
     *
     * @param canDragResize canDragResize Default value is false
     * @see com.smartgwt.client.widgets.Window#setShowResizer
     */
    public void setCanDragResize(Boolean canDragResize) {
        setAttribute("canDragResize", canDragResize, true);
    }

    /**
     * Can the window be drag-resized? If true the window may be drag resized from its edges, and if showing, via the resizer
     * icon in the footer.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.Window#getShowResizer
     */
    public Boolean getCanDragResize()  {
        return getAttributeAsBoolean("canDragResize");
    }

    /**
     * If true, the user can give the header buttons keyboard focus (by clicking on      them and including them in the
     * tabOrder)
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canFocusInHeaderButtons canFocusInHeaderButtons Default value is false
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public void setCanFocusInHeaderButtons(Boolean canFocusInHeaderButtons) {
        setAttribute("canFocusInHeaderButtons", canFocusInHeaderButtons, true);
    }

    /**
     * If true, the user can give the header buttons keyboard focus (by clicking on      them and including them in the
     * tabOrder)
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Focus Focus overview and related methods
     */
    public Boolean getCanFocusInHeaderButtons()  {
        return getAttributeAsBoolean("canFocusInHeaderButtons");
    }

    /**
     * The layout policy that should be used for widgets within the Window body. <P> Valid values are "vertical", "horizontal",
     * "none".  If the body is a Layout, this controls how the items are stacked in the body by setting {@link
     * com.smartgwt.client.widgets.layout.Layout#getVertical vertical}.   See {@link
     * com.smartgwt.client.widgets.Window#getBodyConstructor bodyConstructor} for details.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param contentLayout contentLayout Default value is "vertical"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setContentLayout(String contentLayout) {
        setAttribute("contentLayout", contentLayout, true);
    }

    /**
     * The layout policy that should be used for widgets within the Window body. <P> Valid values are "vertical", "horizontal",
     * "none".  If the body is a Layout, this controls how the items are stacked in the body by setting {@link
     * com.smartgwt.client.widgets.layout.Layout#getVertical vertical}.   See {@link
     * com.smartgwt.client.widgets.Window#getBodyConstructor bodyConstructor} for details.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getContentLayout()  {
        return getAttributeAsString("contentLayout");
    }

    /**
     * If this window has {@link com.smartgwt.client.widgets.Window#getSrc src} specified, this property can be used to
     * indicate whether the source is a standalone HTML page or an HTML fragment. <P> This is similar to the {@link
     * com.smartgwt.client.widgets.HTMLFlow#getContentsType contentsType} property - be sure to read the HTMLFlow documentation
     * to understand circumstances where contentsType:"page" is <b>unsafe and not recommended</b>.
     *
     * @param contentsType contentsType Default value is "page"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.Window#setSrc
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setContentsType(String contentsType)  throws IllegalStateException {
        setAttribute("contentsType", contentsType, false);
    }

    /**
     * If this window has {@link com.smartgwt.client.widgets.Window#getSrc src} specified, this property can be used to
     * indicate whether the source is a standalone HTML page or an HTML fragment. <P> This is similar to the {@link
     * com.smartgwt.client.widgets.HTMLFlow#getContentsType contentsType} property - be sure to read the HTMLFlow documentation
     * to understand circumstances where contentsType:"page" is <b>unsafe and not recommended</b>.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.Window#getSrc
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getContentsType()  {
        return getAttributeAsString("contentsType");
    }

    /**
     * If {@link com.smartgwt.client.widgets.Window#getMinimizeHeight minimizeHeight} is unset, by the window will shrink to
     * the height of the header when minimized. <BR> If there is no header, the <code>defaultMinimizeHeight</code> will be used
     * instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param defaultMinimizeHeight defaultMinimizeHeight Default value is 16
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setDefaultMinimizeHeight(int defaultMinimizeHeight) {
        setAttribute("defaultMinimizeHeight", defaultMinimizeHeight, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Window#getMinimizeHeight minimizeHeight} is unset, by the window will shrink to
     * the height of the header when minimized. <BR> If there is no header, the <code>defaultMinimizeHeight</code> will be used
     * instead.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getDefaultMinimizeHeight()  {
        return getAttributeAsInt("defaultMinimizeHeight");
    }

    /**
     * Should this window be dismissed (same effect as pressing the "Cancel" button) when the  user presses the "Escape" key?
     * Behavior will only occur while the window or one of its descendants has focus, and does not cancel the Escape keypress.
     * <P> If unset default behavior depends on whether a close / cancel button is visible for this item.
     *
     * @param dismissOnEscape dismissOnEscape Default value is null
     * @see com.smartgwt.client.widgets.Window#shouldDismissOnEscape
     */
    public void setDismissOnEscape(Boolean dismissOnEscape) {
        setAttribute("dismissOnEscape", dismissOnEscape, true);
    }

    /**
     * Should this window be dismissed (same effect as pressing the "Cancel" button) when the  user presses the "Escape" key?
     * Behavior will only occur while the window or one of its descendants has focus, and does not cancel the Escape keypress.
     * <P> If unset default behavior depends on whether a close / cancel button is visible for this item.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.Window#shouldDismissOnEscape
     */
    public Boolean getDismissOnEscape()  {
        return getAttributeAsBoolean("dismissOnEscape");
    }

    /**
     * If true, a click outside the bounds of the Window will have the same effect as      pressing its cancel button.<br>     
     * <b>Note:</b> Applies only to modal windows.
     *
     * @param dismissOnOutsideClick dismissOnOutsideClick Default value is false
     * @see com.smartgwt.client.widgets.Window#setIsModal
     */
    public void setDismissOnOutsideClick(Boolean dismissOnOutsideClick) {
        setAttribute("dismissOnOutsideClick", dismissOnOutsideClick, true);
    }

    /**
     * If true, a click outside the bounds of the Window will have the same effect as      pressing its cancel button.<br>     
     * <b>Note:</b> Applies only to modal windows.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.Window#getIsModal
     */
    public Boolean getDismissOnOutsideClick()  {
        return getAttributeAsBoolean("dismissOnOutsideClick");
    }

    /**
     * The height of the footer, in pixels.
     *
     * @param footerHeight footerHeight Default value is 18
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setFooterHeight(int footerHeight)  throws IllegalStateException {
        setAttribute("footerHeight", footerHeight, false);
    }

    /**
     * The height of the footer, in pixels.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getFooterHeight()  {
        return getAttributeAsInt("footerHeight");
    }

    /**
     * If {@link com.smartgwt.client.widgets.Window#getShowHeaderBackground showHeaderBackground} is <code>true</code>, this
     * property provides the URL of the background image for the header.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param headerSrc headerSrc Default value is "[SKIN]Window/headerGradient.gif" | null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeaderSrc(String headerSrc) {
        setAttribute("headerSrc", headerSrc, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Window#getShowHeaderBackground showHeaderBackground} is <code>true</code>, this
     * property provides the URL of the background image for the header.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHeaderSrc()  {
        return getAttributeAsString("headerSrc");
    }

    /**
     * Style for the Window header.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param headerStyle headerStyle Default value is "WindowHeader"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHeaderStyle(String headerStyle) {
        setAttribute("headerStyle", headerStyle, true);
    }

    /**
     * Style for the Window header.
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHeaderStyle()  {
        return getAttributeAsString("headerStyle");
    }

    /**
     * Highlight color for the Window body (shown when the body is flashed).
     *
     * @param hiliteBodyColor hiliteBodyColor Default value is "#EEEEEE"
     * @see com.smartgwt.client.widgets.Window#flash
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHiliteBodyColor(String hiliteBodyColor) {
        setAttribute("hiliteBodyColor", hiliteBodyColor, true);
    }

    /**
     * Highlight color for the Window body (shown when the body is flashed).
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.Window#flash
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHiliteBodyColor()  {
        return getAttributeAsString("hiliteBodyColor");
    }

    /**
     * If {@link com.smartgwt.client.widgets.Window#getShowHeaderBackground showHeaderBackground} is true, this governs the URL
     * of the image to  use in the header's highlighted state when the window is {@link
     * com.smartgwt.client.widgets.Window#flash flashed}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param hiliteHeaderSrc hiliteHeaderSrc Default value is "[SKIN]Window/headerGradient_hilite.gif" | null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHiliteHeaderSrc(String hiliteHeaderSrc) {
        setAttribute("hiliteHeaderSrc", hiliteHeaderSrc, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Window#getShowHeaderBackground showHeaderBackground} is true, this governs the URL
     * of the image to  use in the header's highlighted state when the window is {@link
     * com.smartgwt.client.widgets.Window#flash flashed}
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHiliteHeaderSrc()  {
        return getAttributeAsString("hiliteHeaderSrc");
    }

    /**
     * Highlight style for the Window header. Displayed when a window  is {@link com.smartgwt.client.widgets.Window#flash
     * flashed}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param hiliteHeaderStyle hiliteHeaderStyle Default value is "WindowHeader"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHiliteHeaderStyle(String hiliteHeaderStyle) {
        setAttribute("hiliteHeaderStyle", hiliteHeaderStyle, true);
    }

    /**
     * Highlight style for the Window header. Displayed when a window  is {@link com.smartgwt.client.widgets.Window#flash
     * flashed}
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHiliteHeaderStyle()  {
        return getAttributeAsString("hiliteHeaderStyle");
    }

    /**
     * If true, when shown this Window will intercept and block events to all other existing components on the page. <P> Use
     * {@link com.smartgwt.client.widgets.Window#getShowModalMask showModalMask} to darken all other elements on the screen
     * when a modal dialog is showing. <P> Chained modal windows - that is, modal windows that launch other modal windows - are
     * allowed.  You can accomplish this by simply creating a second modal Window while a modal Window is showing. <P> Note
     * only top-level Windows (Windows without parents) can be modal.
     *
     * @param isModal isModal Default value is false
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_windows_modality" target="examples">Modality Example</a>
     */
    public void setIsModal(Boolean isModal) {
        setAttribute("isModal", isModal, true);
    }

    /**
     * If true, when shown this Window will intercept and block events to all other existing components on the page. <P> Use
     * {@link com.smartgwt.client.widgets.Window#getShowModalMask showModalMask} to darken all other elements on the screen
     * when a modal dialog is showing. <P> Chained modal windows - that is, modal windows that launch other modal windows - are
     * allowed.  You can accomplish this by simply creating a second modal Window while a modal Window is showing. <P> Note
     * only top-level Windows (Windows without parents) can be modal.
     *
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_windows_modality" target="examples">Modality Example</a>
     */
    public Boolean getIsModal()  {
        return getAttributeAsBoolean("isModal");
    }

    /**
     * Is this window maximized. If true at init time, the window will be drawn maximized. To set this property at runtime use
     * {@link com.smartgwt.client.widgets.Window#maximize Window.maximize} or {@link com.smartgwt.client.widgets.Window#restore
     * Window.restore}.
     *
     * @param maximized maximized Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setMaximized(Boolean maximized) {
        setAttribute("maximized", maximized, true);
    }

    /**
     * Is this window maximized. If true at init time, the window will be drawn maximized. To set this property at runtime use
     * {@link com.smartgwt.client.widgets.Window#maximize Window.maximize} or {@link com.smartgwt.client.widgets.Window#restore
     * Window.restore}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getMaximized()  {
        return getAttributeAsBoolean("maximized");
    }

    /**
     * Default acceleration function for performing an animated minimize / maximize.  If unset, 
     * <code>this.animateAcceleration</code> will be used by default instead
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param minimizeAcceleration minimizeAcceleration Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setMinimizeAcceleration(AnimationAcceleration minimizeAcceleration) {
        setAttribute("minimizeAcceleration", minimizeAcceleration.getValue(), true);
    }

    /**
     * Default acceleration function for performing an animated minimize / maximize.  If unset, 
     * <code>this.animateAcceleration</code> will be used by default instead
     *
     *
     * @return AnimationAcceleration
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public AnimationAcceleration getMinimizeAcceleration()  {
        return EnumUtil.getEnum(AnimationAcceleration.values(), getAttribute("minimizeAcceleration"));
    }

    /**
     * Is this window minimized. If true at init time, the window will be drawn minimized. To set this property at runtime use
     * {@link com.smartgwt.client.widgets.Window#minimize Window.minimize} or {@link com.smartgwt.client.widgets.Window#restore
     * Window.restore}.
     *
     * @param minimized minimized Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setMinimized(Boolean minimized) {
        setAttribute("minimized", minimized, true);
    }

    /**
     * Is this window minimized. If true at init time, the window will be drawn minimized. To set this property at runtime use
     * {@link com.smartgwt.client.widgets.Window#minimize Window.minimize} or {@link com.smartgwt.client.widgets.Window#restore
     * Window.restore}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getMinimized()  {
        return getAttributeAsBoolean("minimized");
    }

    /**
     * Height for the window when minimized. If unset the window will shrink to the height of the header, if present, otherwise
     * {@link com.smartgwt.client.widgets.Window#getDefaultMinimizeHeight this.defaultMinimizeHeight}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param minimizeHeight minimizeHeight Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setMinimizeHeight(Integer minimizeHeight) {
        setAttribute("minimizeHeight", minimizeHeight, true);
    }

    /**
     * Height for the window when minimized. If unset the window will shrink to the height of the header, if present, otherwise
     * {@link com.smartgwt.client.widgets.Window#getDefaultMinimizeHeight this.defaultMinimizeHeight}
     *
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getMinimizeHeight()  {
        return getAttributeAsInt("minimizeHeight");
    }

    /**
     * If this window is minimizeable, and animateMinimize is true, what should the duration of  the minimize / maximize be (in
     * ms)? If unset defaults to <code>canvas.animationTime</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param minimizeTime minimizeTime Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_minimize" target="examples">Window Minimize Example</a>
     */
    public void setMinimizeTime(Integer minimizeTime) {
        setAttribute("minimizeTime", minimizeTime, true);
    }

    /**
     * If this window is minimizeable, and animateMinimize is true, what should the duration of  the minimize / maximize be (in
     * ms)? If unset defaults to <code>canvas.animationTime</code>.
     *
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#effects_animation_minimize" target="examples">Window Minimize Example</a>
     */
    public Integer getMinimizeTime()  {
        return getAttributeAsInt("minimizeTime");
    }

    /**
     * Controls the opacity of the modal mask displayed behind modal windows.
     *
     * @param modalMaskOpacity modalMaskOpacity Default value is 50
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.Window#setModalMask
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setModalMaskOpacity(int modalMaskOpacity)  throws IllegalStateException {
        setAttribute("modalMaskOpacity", modalMaskOpacity, false);
    }

    /**
     * Controls the opacity of the modal mask displayed behind modal windows.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.Window#getModalMask
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getModalMaskOpacity()  {
        return getAttributeAsInt("modalMaskOpacity");
    }

    /**
     * Specifies the CSS style for the modal mask.
     *
     * @param modalMaskStyle modalMaskStyle Default value is "modalMask"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.Window#setModalMask
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setModalMaskStyle(String modalMaskStyle)  throws IllegalStateException {
        setAttribute("modalMaskStyle", modalMaskStyle, false);
    }

    /**
     * Specifies the CSS style for the modal mask.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.Window#getModalMask
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getModalMaskStyle()  {
        return getAttributeAsString("modalMaskStyle");
    }

    /**
     * If true, draw the body contents when this Window is drawn.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showBody showBody Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowBody(Boolean showBody) {
        setAttribute("showBody", showBody, true);
    }

    /**
     * If true, draw the body contents when this Window is drawn.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowBody()  {
        return getAttributeAsBoolean("showBody");
    }

    /**
     * If true, show a close button in the header, which will dismiss this window by  calling {@link
     * com.smartgwt.client.widgets.Window#addCloseClickHandler Window.closeClick}.
     * Dynamically update {@link com.smartgwt.client.widgets.Window#getShowCloseButton showCloseButton} to show / hide the closeButton
     *
     * @param showCloseButton showCloseButton Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowCloseButton(Boolean showCloseButton) {
        setAttribute("showCloseButton", showCloseButton, true);
    }

    /**
     * If true, show a close button in the header, which will dismiss this window by  calling {@link
     * com.smartgwt.client.widgets.Window#addCloseClickHandler Window.closeClick}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowCloseButton()  {
        return getAttributeAsBoolean("showCloseButton");
    }

    /**
     * If true, show a footer for this Window, including resizer, statusBar, etc. This setting is commonly overridden for
     * skinning purposes.
     *
     * @param showFooter showFooter Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_windows_footer" target="examples">Footer Example</a>
     */
    public void setShowFooter(Boolean showFooter) {
        setAttribute("showFooter", showFooter, true);
    }

    /**
     * If true, show a footer for this Window, including resizer, statusBar, etc. This setting is commonly overridden for
     * skinning purposes.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_windows_footer" target="examples">Footer Example</a>
     */
    public Boolean getShowFooter()  {
        return getAttributeAsBoolean("showFooter");
    }

    /**
     * If true, show a {@link com.smartgwt.client.widgets.Window#getHeader header} for this Window. &#010 <P>&#010 Note that in
     * certain Smartclient skins {@link com.smartgwt.client.widgets.Window#getShowHeaderBackground showHeaderBackground} may be
     * set to&#010 <code>false</code> and the header's appearance implemented as part of the&#010 window's {@link
     * com.smartgwt.client.widgets.Canvas#getShowEdges edge media}. In this case suppressing the header can be achieved&#010 by
     * overriding the edge media as well as setting this property to false. For example, to&#010 create a headerless window
     * with a similar appearance to a {@link com.smartgwt.client.widgets.menu.Menu} in the&#010 <code><i>TreeFrog</i></code>
     * skin, the following attributes could be used:&#010 <pre>&#010      showHeader:false,&#010     
     * edgeImage:"[SKIN]/Menu/m.png",&#010      edgeSize:10, edgeTop:17, edgeBottom:17,&#010     
     * edgeCenterBackgroundColor:"#F7F7F7"&#010 </pre>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showHeader showHeader Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowHeader(Boolean showHeader) {
        setAttribute("showHeader", showHeader, true);
    }

    /**
     * If true, show a {@link com.smartgwt.client.widgets.Window#getHeader header} for this Window. &#010 <P>&#010 Note that in
     * certain Smartclient skins {@link com.smartgwt.client.widgets.Window#getShowHeaderBackground showHeaderBackground} may be
     * set to&#010 <code>false</code> and the header's appearance implemented as part of the&#010 window's {@link
     * com.smartgwt.client.widgets.Canvas#getShowEdges edge media}. In this case suppressing the header can be achieved&#010 by
     * overriding the edge media as well as setting this property to false. For example, to&#010 create a headerless window
     * with a similar appearance to a {@link com.smartgwt.client.widgets.menu.Menu} in the&#010 <code><i>TreeFrog</i></code>
     * skin, the following attributes could be used:&#010 <pre>&#010      showHeader:false,&#010     
     * edgeImage:"[SKIN]/Menu/m.png",&#010      edgeSize:10, edgeTop:17, edgeBottom:17,&#010     
     * edgeCenterBackgroundColor:"#F7F7F7"&#010 </pre>
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowHeader()  {
        return getAttributeAsBoolean("showHeader");
    }

    /**
     * Should the window header show a background image? Default value is true for all browsers except for Internet
     * Explorer.<br> If set to true the image source is derived from {@link com.smartgwt.client.widgets.Window#getHeaderSrc
     * headerSrc} and  {@link com.smartgwt.client.widgets.Window#getHiliteHeaderSrc hiliteHeaderSrc}, otherwise the background
     * will be styled according to  {@link com.smartgwt.client.widgets.Window#getHeaderStyle headerStyle} / {@link
     * com.smartgwt.client.widgets.Window#getHiliteHeaderStyle hiliteHeaderStyle}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showHeaderBackground showHeaderBackground Default value is varies
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowHeaderBackground(Boolean showHeaderBackground)  throws IllegalStateException {
        setAttribute("showHeaderBackground", showHeaderBackground, false);
    }

    /**
     * Should the window header show a background image? Default value is true for all browsers except for Internet
     * Explorer.<br> If set to true the image source is derived from {@link com.smartgwt.client.widgets.Window#getHeaderSrc
     * headerSrc} and  {@link com.smartgwt.client.widgets.Window#getHiliteHeaderSrc hiliteHeaderSrc}, otherwise the background
     * will be styled according to  {@link com.smartgwt.client.widgets.Window#getHeaderStyle headerStyle} / {@link
     * com.smartgwt.client.widgets.Window#getHiliteHeaderStyle hiliteHeaderStyle}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowHeaderBackground()  {
        return getAttributeAsBoolean("showHeaderBackground");
    }

    /**
     * If true, we show an icon on the left in the header.
     * Dynamically update {@link com.smartgwt.client.widgets.Window#getShowHeaderIcon showHeaderIcon} to show / hide the headerIcon
     *
     * @param showHeaderIcon showHeaderIcon Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowHeaderIcon(Boolean showHeaderIcon) {
        setAttribute("showHeaderIcon", showHeaderIcon, true);
    }

    /**
     * If true, we show an icon on the left in the header.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowHeaderIcon()  {
        return getAttributeAsBoolean("showHeaderIcon");
    }

    /**
     * If true, show a maximize button in the header - clicking it maximizes the Window
     * Dynamically update {@link com.smartgwt.client.widgets.Window#getShowMaximizeButton showMaximizeButton} to show / hide the maximizeButton
     *
     * @param showMaximizeButton showMaximizeButton Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowMaximizeButton(Boolean showMaximizeButton) {
        setAttribute("showMaximizeButton", showMaximizeButton, true);
    }

    /**
     * If true, show a maximize button in the header - clicking it maximizes the Window
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowMaximizeButton()  {
        return getAttributeAsBoolean("showMaximizeButton");
    }

    /**
     * If true, show a minimize button in the header--clicking it minimizes the Window.
     * Dynamically update {@link com.smartgwt.client.widgets.Window#getShowMinimizeButton showMinimizeButton} to show / hide the minimizeButton
     *
     * @param showMinimizeButton showMinimizeButton Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowMinimizeButton(Boolean showMinimizeButton) {
        setAttribute("showMinimizeButton", showMinimizeButton, true);
    }

    /**
     * If true, show a minimize button in the header--clicking it minimizes the Window.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowMinimizeButton()  {
        return getAttributeAsBoolean("showMinimizeButton");
    }

    /**
     * If true, displays a translucent mask over the rest of the page when a modal window is displayed.
     *
     * @param showModalMask showModalMask Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.Window#setModalMask
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowModalMask(Boolean showModalMask)  throws IllegalStateException {
        setAttribute("showModalMask", showModalMask, false);
    }

    /**
     * If true, displays a translucent mask over the rest of the page when a modal window is displayed.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.Window#getModalMask
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowModalMask()  {
        return getAttributeAsBoolean("showModalMask");
    }

    /**
     * If true, show a button in the lower right corner that allows users to resize the Window. Note that the resizer will only
     * be displayed if the footer is showing for the window ({@link com.smartgwt.client.widgets.Window#getShowFooter
     * showFooter}) and {@link com.smartgwt.client.widgets.Window#getCanDragResize canDragResize} is true.
     *
     * @param showResizer showResizer Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowResizer(Boolean showResizer) {
        setAttribute("showResizer", showResizer, true);
    }

    /**
     * If true, show a button in the lower right corner that allows users to resize the Window. Note that the resizer will only
     * be displayed if the footer is showing for the window ({@link com.smartgwt.client.widgets.Window#getShowFooter
     * showFooter}) and {@link com.smartgwt.client.widgets.Window#getCanDragResize canDragResize} is true.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowResizer()  {
        return getAttributeAsBoolean("showResizer");
    }

    /**
     * If true, show a statusBar for this Window, including resizer.
     *
     * @param showStatusBar showStatusBar Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowStatusBar(Boolean showStatusBar) {
        setAttribute("showStatusBar", showStatusBar, true);
    }

    /**
     * If true, show a statusBar for this Window, including resizer.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowStatusBar()  {
        return getAttributeAsBoolean("showStatusBar");
    }

    /**
     * Show a title (typically just text) on the header for this window.
     *
     * @param showTitle showTitle Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle, true);
    }

    /**
     * Show a title (typically just text) on the header for this window.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }

    /**
     * A URL to load as content for the Window's body.  If specified, this attribute will take precedence over the items
     * attribute. <P> Note that setting window.src is essentially a shortcut for setting {@link
     * com.smartgwt.client.widgets.Window#getItems items} to a single HTMLflow with a specified {@link
     * com.smartgwt.client.widgets.HTMLFlow#getContentsURL contentsURL}.
     * Sets the URL of the contents to display in the body of the window, redrawing if necessary.
     *
     * @param src URL of new contents to be displayed in the window body. Default value is null
     * @see com.smartgwt.client.widgets.Window#setContentsType
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSrc(String src) {
        setAttribute("src", src, true);
    }

    /**
     * A URL to load as content for the Window's body.  If specified, this attribute will take precedence over the items
     * attribute. <P> Note that setting window.src is essentially a shortcut for setting {@link
     * com.smartgwt.client.widgets.Window#getItems items} to a single HTMLflow with a specified {@link
     * com.smartgwt.client.widgets.HTMLFlow#getContentsURL contentsURL}.
     *
     *
     * @return String
     * @see com.smartgwt.client.widgets.Window#getContentsType
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    /**
     * Text to show in the status bar of the window (if one is visible)
     * Sets the text in the status bar of the window, redrawing if necessary.
     *
     * @param status new text for the status bar. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStatus(String status) {
        setAttribute("status", status, true);
    }

    /**
     * Text to show in the status bar of the window (if one is visible)
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStatus()  {
        return getAttributeAsString("status");
    }

    /**
     * title for this Window, shown in the header (if drawn)
     * Sets the title text that appears in the window header; the header will be redrawn          if necessary.
     *
     * @param title new title. Default value is "Untitled Window"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * title for this Window, shown in the header (if drawn)
     *
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    // ********************* Methods ***********************
            
    /**
     * Same as {@link com.smartgwt.client.widgets.layout.Layout#addMember Layout.addMember}.  Note that in order to add items
     * to {@link com.smartgwt.client.widgets.Window#getBody body}, you use {@link com.smartgwt.client.widgets.Window#addItem
     * Window.addItem} rather than <code>addMember</code>.  Adding a member to  a Window adds the member as a sibling to the
     * header, body and other built-in Window subcomponents.
     * @param newMember the canvas object to be added to the layout
     */
    public native void addMember(Canvas newMember) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addMember(newMember.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    /**
     * Same as {@link com.smartgwt.client.widgets.layout.Layout#addMember Layout.addMember}.  Note that in order to add items
     * to {@link com.smartgwt.client.widgets.Window#getBody body}, you use {@link com.smartgwt.client.widgets.Window#addItem
     * Window.addItem} rather than <code>addMember</code>.  Adding a member to  a Window adds the member as a sibling to the
     * header, body and other built-in Window subcomponents.
     * @param newMember the canvas object to be added to the layout
     * @param position the position in the layout to place newMember (starts with 0);                                  if omitted, it will be
     * added at the last position
     * @see com.smartgwt.client.widgets.Window#addMembers
     */
    public native void addMember(Canvas newMember, int position) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addMember(newMember.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), position);
    }-*/;
            
    /**
     * Centers the Window in the page. This is called automatically in window.show() if Window.autoCenter is true. Note - if
     * the Window is a child of another widget, we center in the parent widget rather than centering in the page.
     */
    public native void centerInPage() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.centerInPage();
    }-*/;
    /**
     * Add a closeClick handler.
     * <p>
     * Handles a click on the close button of this window. The default implementation hides the window and returns false to
     * cancel bubbling.  Override this method if you want other actions to be taken.
     *
     * @param handler the closeClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addCloseClickHandler(com.smartgwt.client.widgets.events.CloseClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.CloseClientEvent.getType()) == 0) setupCloseClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.CloseClientEvent.getType());
    }

    private native void setupCloseClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({closeClick:$entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.CloseClientEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.closeClick = $entry(function(){
                   var param = {};
                   var event = @com.smartgwt.client.widgets.events.CloseClientEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * Makes the window header flash if it's visible; if there's no header, or the header          is hidden, makes the window
     * body flash instead.          <p>   This method is executed when users click outside the bounds of a modal window   so
     * they'll notice that they have to do something with the window.
     */
    public native void flash() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.flash();
    }-*/;
            
    /**
     * Maximize the window. Fired when the user clicks the maximize button if  {@link
     * com.smartgwt.client.widgets.Window#getShowMaximizeButton this.showMaximizeButton} is true.<br> Default implementation
     * moves the window to <code>0, 0</code> and resizes the window to  <code>"100%"</code> on both axes, so it will fill the
     * browser window (or the parentElement of the Window instance, if appropriate).<br> If {@link
     * com.smartgwt.client.widgets.Window#getAnimateMinimize animateMinimize} is true, the maximize will be animated. A restore
     * button will be displayed in place of the maximize button when the window is  maximized.
     */
    public native void maximize() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.maximize();
    }-*/;
            
    /**
     * Minimize the window. Fired when the user clicks the minimize button if  {@link
     * com.smartgwt.client.widgets.Window#getShowMinimizeButton this.showMinimizeButton} is true.<br> Default implementation
     * shrinks the window to just the height of the header bar, hiding the body. If {@link
     * com.smartgwt.client.widgets.Window#getAnimateMinimize animateMinimize} is true, the resize will be animated. A restore
     * button will be displayed in place of the minimize button when the window is  minimized.
     */
    public native void minimize() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.minimize();
    }-*/;
            
    /**
     * Restores the window to its specified height and width after a call to {@link com.smartgwt.client.widgets.Window#minimize
     * Window.minimize} or  {@link com.smartgwt.client.widgets.Window#maximize Window.maximize}. Called from a click on the
     * restore button shown in place of the  minimize or maximize button when the window is minimized or maximized.<br>
     * Resizing will occur as an animation if {@link com.smartgwt.client.widgets.Window#getAnimateMinimize animateMinimize} is
     * true.
     */
    public native void restore() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.restore();
    }-*/;
            
    /**
     * Should this window be dismissed (same effect as pressing the "Cancel" button) when the  user presses the "Escape"
     * key?<br> Default behavior: if {@link com.smartgwt.client.widgets.Window#getDismissOnEscape dismissOnEscape} is set, just
     * return it. Otherwise return true if this window is showing a "close" control in the header  (see {@link
     * com.smartgwt.client.widgets.Window#getHeaderControls headerControls}).
     *
     * @return true if the window should be dismissed when the user hits escape
     */
    public native Boolean shouldDismissOnEscape() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.shouldDismissOnEscape();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes. 
     *
     * @param windowProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Window windowProperties) /*-{
        $wnd.isc.Window.addProperties(windowProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    }-*/;
        
    // ***********************************************************        


    /**
     * Adds a widget to the window.
     *
     * @param widget the widget to be added
     */
    public void addItem(Widget widget) {
        if (widget instanceof Canvas) {
            addItem((Canvas) widget);
        } else {
            addItem(new WidgetCanvas(widget));
        }
    }

    /**
     * Adds a widget to the window.
     *
     * @param component the widget to be added
     */
    public void addItem(Canvas component) {
        JavaScriptObject componentJS = component.getOrCreateJsObj();
        if (isCreated()) {
            addItemPostCreate(componentJS);

        } else {
            addItemPreCreate(componentJS);
        }
    }

    private native void addItemPreCreate(JavaScriptObject componentJS) /*-{
		var config = this.@com.smartgwt.client.widgets.BaseWidget::config;

        if(!config.items) {
            config.items = @com.smartgwt.client.util.JSOHelper::createJavaScriptArray()();
        }
        config.items.push(componentJS);
    }-*/;

    private native void addItemPostCreate(JavaScriptObject componentJS) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.addItem(componentJS);
    }-*/;

    /**
     * Removes a widget from the window.
     *
     * @param component the widget to be removed
     */
    public native void removeItem(Canvas component) /*-{
        var container = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var componentJS = component.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        container.removeItem(componentJS);
    }-*/;

    /**
     * If Window.canDragReposition or Window.canDragResize is true, should the windows size and position be constrained
     * such that it remains within the viewport of its parent element (or for top level windows, within the viewport of
     * the browser window)?
     * <p/>
     * <br> Note: keepInParentRect affects only user drag interactions, not programmatic moves.
     *
     * @param keepInParentRect true to keepInParentRect
     */
    public void setKeepInParentRect(Boolean keepInParentRect) {
        setAttribute("keepInParentRect", keepInParentRect, true);
    }

    /**
     * Default properties for the body of the Window<br> <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param bodyDefaults bodyDefaults
     */
    public void setBodyDefaults(Map bodyDefaults) {
        setAttribute("bodyDefaults", bodyDefaults, true);
    }

    /**
     * This is an object literal property block specifying the various properties of the headerIcon - the icon that
     * appears at the top left of the window and is by default the Isomorphic logo.  Overrideable defaults are as
     * follows: <ul> <li>width - default to <code>16</code> and specifies the width of the headerIcon. <li>height -
     * default to <code>14</code> and specifies the height of the headerIcon. <li>src - defaults to
     * <code>"[SKIN]/Window/minimize.gif"</code> and specifies the image for the headerIcon.
     * <p/>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param headerIconDefaults headerIconDefaults
     */
    public void setHeaderIconDefaults(Map headerIconDefaults) {
        setAttribute("headerIconDefaults", headerIconDefaults, true);
        setShowHeaderIcon(true);
    }

    public void setHeaderIconProperties(Map headerIconProperties) {
        setAttribute("headerIconProperties", headerIconProperties, true);
        setShowHeaderIcon(true);
    }

    /**
     * Sets the Window header icon.
     *
     * @param imgSrc the icon image source
     */
    public void setHeaderIcon(String imgSrc) {
        Map map = new HashMap();
        map.put("src", imgSrc);
        setHeaderIconProperties(map);
    }

    /**
     * Sets the Window header icon.
     *
     * @param imgSrc the icon image source
     * @param width  the icon width. default 16
     * @param height the icon height. default 14
     */
    public void setHeaderIcon(String imgSrc, int width, int height) {
        Map map = new HashMap();
        map.put("src", imgSrc);
        map.put("width", width);
        map.put("height", height);
        setHeaderIconProperties(map);
    }

    /**
     * Array of members to show in the Window header. <pb> The default value of headerControls is an Array of {@link
     * com.smartgwt.client.types.HeaderControls} listing the standard header controls in their default order: <br>
     * headerControls : [HeaderControls.HEADER_ICON, HeaderControls.HEADER_LABEL, HeaderControls.MINIMIZE_BUTTON,
     * HeaderControls.MAXIMIZE_BUTTON, HeaderControls.CLOSE_BUTTON] <br>
     * <p/>
     * You can set headerControls to change the order of standard controls in the header. You can also omit standard
     * controls this way, although it more efficient to use the related "show" property if available (eg
     * Window.showMinimizeButton). <br> By embedding a Canvas directly in this list you can add arbitrary additional
     * controls to the header, for example, an additional button (eg return to dock) or a DynamicForm with various kinds
     * of input controls. Tip: custom controls need to set layoutAlign:"center" to appear vertically centered.
     *
     * @param headerControls an array containing either HeaderControl enums values or Canvas instances
     * @see com.smartgwt.client.types.HeaderControls
     */
    public void setHeaderControls(Object... headerControls) {
        setAttribute("headerControls", headerControls, false);
    }
    /**
     * Array of members to show in the Window footer. <pb> The default value of headerControls is an Array of {@link
     * com.smartgwt.client.types.FooterControls} listing the standard footer controls in their default order: <br>
     * headerControls : [HeaderControls.SPACER, HeaderControls.RESIZER] <br>
     * <p/>
     * You can set footerControls to change the order of standard controls in the footer. You can also omit standard
     * controls this way, although it more efficient to use the related "show" property if available (eg
     * Window.showResizer). <br> By embedding a Canvas directly in this list you can add arbitrary additional
     * controls to the footer.<br> Note that the statusBar is not part of the set of footer controls - it is a
     * separate canvas rendered behind all footer controls. If you include some custom status bar
     * directly in the footerControls you may want to set +link{window.showFooter} to false.
     * Tip: custom controls need to set layoutAlign:"center" to appear vertically centered.
     *
     * @param footerControls an array containing either FooterControl enums values or Canvas instances
     * @see com.smartgwt.client.types.FooterControls
     */
    public void setFooterControls(Object... footerControls) {
        setAttribute("footerControls", footerControls, false);
    }

    /**
     * If Window.canDragReposition or Window.canDragRShowcaseDataesize is true, should the windows size and position be
     * constrained such that it remains within the viewport of its parent element (or for top level windows, within the
     * viewport of the browser window)? Can also be set to an array denoting an arbitrary Rectangle beyond which the
     * window cannot be moved. <br> Note: keepInParentRect affects only user drag interactions, not programmatic moves.
     *
     * @param rectangle the rectangle bounds
     */
    public void setKeepInParentRect(Rectangle rectangle) {
        setAttribute("keepInParentRect", rectangle.getAsJSArray(), true);
    }

    /**
     * The contents of the Window body. Can be specified three different ways: <ul>
     * <li>an Array of Canvases that will become the children of the Window's body when it is initialized; the canvases in this array should be created, but not drawn (autodraw: false).</li>
     * <li>a single canvas that will become a child of the Window body.</li>
     * <li>a string that will be set as the body's contents.</li>
     * </ul>
     *
     * @return items
     */
    public Canvas[] getItems() {
      return Canvas.convertToCanvasArray(getAttributeAsJavaScriptObject("items"));
    }

    /**
     * Add a onMaximizeClick handler.
     * <p>
     * Notification method fired when the user clicks the 'maximize' button.&#010
     *
     * @param handler the onMaximizeClick handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addMaximizeClickHandler(com.smartgwt.client.widgets.events.MaximizeClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.MaximizeClickEvent.getType()) == 0) setupMaximizeClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.MaximizeClickEvent.getType());
    }
    private native void setupMaximizeClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onMaximizeClick:$debox($entry(function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.MaximizeClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onMaximizeClick = $debox($entry(function(){
                var param = {};
                var event = @com.smartgwt.client.widgets.events.MaximizeClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        }
    }-*/;

    /**
     * Add a onMinimizeClick handler.
     * <p>
     * Notification method fired when the user clicks the 'minimize' button.&#010
     *
     * @param handler the onMinimizeClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addMinimizeClickHandler(com.smartgwt.client.widgets.events.MinimizeClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.MinimizeClickEvent.getType()) == 0) setupMinimizeClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.MinimizeClickEvent.getType());
    }
    private native void setupMinimizeClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onMinimizeClick:$debox($entry(function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.MinimizeClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onMinimizeClick = $debox($entry(function(){
                var param = {};
                var event = @com.smartgwt.client.widgets.events.MinimizeClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        }
    }-*/;

    /**
     * Add a onRestoreClick handler.
     * <p>
     * Notification method fired when the user clicks the 'restore' button.&#010
     *
     * @param handler the onRestoreClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRestoreClickHandler(com.smartgwt.client.widgets.events.RestoreClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.RestoreClickEvent.getType()) == 0) setupRestoreClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.RestoreClickEvent.getType());
    }
    
    private native void setupRestoreClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onRestoreClick:$debox($entry(function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.RestoreClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                    return !ret;
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onRestoreClick = $debox($entry(function(){
                var param = {};
                var event = @com.smartgwt.client.widgets.events.RestoreClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        }
    }-*/;

    /**
     * Preload primary window skin images
     */
    public static native void preloadImages() /*-{
        var skinImgDir = $wnd.isc.Window.getInstanceProperty('skinImgDir');
        var canvasSkinImgDir = $wnd.isc.Canvas.getInstanceProperty('skinImgDir');
        if($wnd.isc.Window.getInstanceProperty('showEdges')) {
            var edgeEdgeImage = $wnd.isc.Window.getInstanceProperty('edgeImage');
            @com.smartgwt.client.util.FileLoader::cacheEdgeImages(Ljava/lang/String;Ljava/lang/String;)(skinImgDir,edgeEdgeImage)
        }
        if($wnd.isc.Window.getInstanceProperty('headerIconDefaults').src) {
            @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir, $wnd.isc.Window.getInstanceProperty('headerIconDefaults').src);
        }
        if($wnd.isc.Window.getInstanceProperty('restoreButtonDefaults').src) {
            @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir,$wnd.isc.Window.getInstanceProperty('restoreButtonDefaults').src);
        }
        if($wnd.isc.Window.getInstanceProperty('closeButtonDefaults').src) {
            @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir,$wnd.isc.Window.getInstanceProperty('closeButtonDefaults').src);
        }
        if($wnd.isc.Window.getInstanceProperty('maximizeButtonDefaults').src) {
            @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir,$wnd.isc.Window.getInstanceProperty('maximizeButtonDefaults').src);
        }
        if($wnd.isc.Window.getInstanceProperty('minimizeButtonDefaults').src) {
            @com.smartgwt.client.util.FileLoader::cacheImg(Ljava/lang/String;Ljava/lang/String;)(canvasSkinImgDir,$wnd.isc.Window.getInstanceProperty('minimizeButtonDefaults').src);
        }
    }-*/;

}



