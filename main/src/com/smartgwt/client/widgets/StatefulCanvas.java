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
/* sgwtgen */
 
package com.smartgwt.client.widgets;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
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
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * A component that has a set of possible states, and which presents itself differently according to which state it is in. 
 * An example is a button, which can be "up", "down", "over" or "disabled".
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("StatefulCanvas")
public class StatefulCanvas extends Canvas {

    public static StatefulCanvas getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new StatefulCanvas(jsObj);
        } else {
            assert refInstance instanceof StatefulCanvas;
            return (StatefulCanvas)refInstance;
        }
    }


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.StatefulCanvas.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc.StatefulCanvas.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public StatefulCanvas(){
        scClassName = "StatefulCanvas";
    }

    public StatefulCanvas(JavaScriptObject jsObj){
        scClassName = "StatefulCanvas";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Behavior on state changes -- BUTTON, RADIO or CHECKBOX
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the 'actionType' for this canvas (radio / checkbox / button) If the canvas is currently selected, and the passed in actionType is 'button' this method will deselect the canvas.
     *
     * @param actionType  Default value is "button"
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setActionType(SelectionType actionType) {
        setAttribute("actionType", actionType == null ? null : actionType.getValue(), true);
    }

    /**
     * Behavior on state changes -- BUTTON, RADIO or CHECKBOX
     *
     * @return Return the 'actionType' for this canvas (radio / checkbox / button)
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public SelectionType getActionType()  {
        return EnumUtil.getEnum(SelectionType.values(), getAttribute("actionType"));
    }
    

    /**
     * Horizontal alignment of this component's title.
     *
     * @param align  Default value is Canvas.CENTER
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align == null ? null : align.getValue(), true);
    }

    /**
     * Horizontal alignment of this component's title.
     *
     * @return Alignment
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Alignment getAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }
    

    /**
     * If true, ignore the specified size of this widget and always size just large enough to accommodate the title.  If
     * <code>setWidth()</code> is explicitly called on an autoFit:true button, autoFit will be reset to <code>false</code>. <P>
     * Note that for StretchImgButton instances, autoFit will occur horizontally only, as  unpredictable vertical sizing is
     * likely to distort the media. If you do want vertical  auto-fit, this can be achieved by simply setting a small height,
     * and having  overflow:"visible"
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter method for the {@link com.smartgwt.client.widgets.StatefulCanvas#getAutoFit autoFit} property. Pass in true or false to turn autoFit on or off. When autoFit is set to <code>false</code>, canvas will be resized to it's previously specified size.
     *
     * @param autoFit New autoFit setting.. Default value is null
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setAutoFit(Boolean autoFit) {
        setAttribute("autoFit", autoFit, true);
    }

    /**
     * If true, ignore the specified size of this widget and always size just large enough to accommodate the title.  If
     * <code>setWidth()</code> is explicitly called on an autoFit:true button, autoFit will be reset to <code>false</code>. <P>
     * Note that for StretchImgButton instances, autoFit will occur horizontally only, as  unpredictable vertical sizing is
     * likely to distort the media. If you do want vertical  auto-fit, this can be achieved by simply setting a small height,
     * and having  overflow:"visible"
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Boolean getAutoFit()  {
        return getAttributeAsBoolean("autoFit");
    }
    

    /**
     * Base CSS style className applied to the component.  <P> As the component changes {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getState state} and/or is selected,  suffixes will be added to the base
     * style. In some cases more than one suffix will  be appended to reflect a combined state ("Selected" + "Disabled", for
     * example). <P> See {@link com.smartgwt.client.widgets.StatefulCanvas#getStateSuffix StatefulCanvas.getStateSuffix} for a
     * description of the default set of suffixes which may be applied to the baseStyle
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the base CSS style.  As the component changes state and/or is selected, suffixes will be added to the base style.
     *
     * @param baseStyle new base style See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * Base CSS style className applied to the component.  <P> As the component changes {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getState state} and/or is selected,  suffixes will be added to the base
     * style. In some cases more than one suffix will  be appended to reflect a combined state ("Selected" + "Disabled", for
     * example). <P> See {@link com.smartgwt.client.widgets.StatefulCanvas#getStateSuffix StatefulCanvas.getStateSuffix} for a
     * description of the default set of suffixes which may be applied to the baseStyle
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * Optional icon to be shown with the button title text.   <P> Specify as the partial URL to an image, relative to the
     * imgDir of this component.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the icon being shown next to the title text.
     *
     * @param icon URL of new icon See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} . Default value is null
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon, true);
    }

    /**
     * Optional icon to be shown with the button title text.   <P> Specify as the partial URL to an image, relative to the
     * imgDir of this component.
     *
     * @return  See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} 
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * Height in pixels of the icon image. <P> If unset, defaults to {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize}.
     *
     * @param iconHeight  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconHeight(Integer iconHeight)  throws IllegalStateException {
        setAttribute("iconHeight", iconHeight, false);
    }

    /**
     * Height in pixels of the icon image. <P> If unset, defaults to {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize}.
     *
     * @return Integer
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Integer getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }
    

    /**
     * If this button is showing an icon should it appear to the left or right of the title? valid options are
     * <code>"left"</code> and <code>"right"</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Changes the orientation of the icon relative to the text of the button.
     *
     * @param iconOrientation The new orientation of the icon relative to the text of the button.. Default value is "left"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconOrientation(String iconOrientation)  throws IllegalStateException {
        setAttribute("iconOrientation", iconOrientation, false);
    }

    /**
     * If this button is showing an icon should it appear to the left or right of the title? valid options are
     * <code>"left"</code> and <code>"right"</code>.
     *
     * @return String
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public String getIconOrientation()  {
        return getAttributeAsString("iconOrientation");
    }
    

    /**
     * Size in pixels of the icon image. <P> The {@link com.smartgwt.client.widgets.StatefulCanvas#getIconWidth iconWidth} and
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getIconHeight iconHeight} properties can be used to configure width
     * and height separately. <P> Note: When configuring the properties of a <code>StatefulCanvas</code> (or derivative) {@link
     * com.smartgwt.client.types.AutoChild AutoChild}, it is best to set the <code>iconWidth</code> and <code>iconHeight</code>
     * to the same value rather than setting an <code>iconSize</code>. This is because certain skins or customizations thereto
     * might set the <code>iconWidth</code> and <code>iconHeight</code>, making the customization of the AutoChild's
     * <code>iconSize</code> ineffective.
     *
     * @param iconSize  Default value is 16
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconSize(int iconSize)  throws IllegalStateException {
        setAttribute("iconSize", iconSize, false);
    }

    /**
     * Size in pixels of the icon image. <P> The {@link com.smartgwt.client.widgets.StatefulCanvas#getIconWidth iconWidth} and
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getIconHeight iconHeight} properties can be used to configure width
     * and height separately. <P> Note: When configuring the properties of a <code>StatefulCanvas</code> (or derivative) {@link
     * com.smartgwt.client.types.AutoChild AutoChild}, it is best to set the <code>iconWidth</code> and <code>iconHeight</code>
     * to the same value rather than setting an <code>iconSize</code>. This is because certain skins or customizations thereto
     * might set the <code>iconWidth</code> and <code>iconHeight</code>, making the customization of the AutoChild's
     * <code>iconSize</code> ineffective.
     *
     * @return int
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public int getIconSize()  {
        return getAttributeAsInt("iconSize");
    }
    
    

    /**
     * Base CSS style applied to the icon image. If set, as the <code>StatefulCanvas</code> changes {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getState state} and/or is {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getSelected selected}, suffixes will be appended to <code>iconStyle</code> to
     * form the className set on the image element. <p> The following table lists out the standard set of suffixes which may be
     * appended: <table border=1> <tr><th>CSS Class Applied</th><th>Description</th></tr>
     * <tr><td><code><i>iconStyle</i></code></td><td>Default CSS style</td></tr>
     * <tr><td><code><i>iconStyle</i>+Selected</code></td>      <td>Applied when {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} and {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowSelectedIcon showSelectedIcon}      are true.</td></tr>
     * <tr><td><code><i>iconStyle</i>+Focused</code></td>      <td>Applied when the component has keyboard focus, if     
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedIcon showFocusedIcon} is true, and      {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is not true.</td></tr>
     * <tr><td><code><i>iconStyle</i>+Over</code></td>      <td>Applied when {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOverIcon showRollOverIcon} is set to true and either      the user
     * rolls over the component or {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is
     * true      and the component has keyboard focus.</td></tr> <tr><td><code><i>iconStyle</i>+Down</code></td>     
     * <td>Applied when the user presses the mouse button on the component if          {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDownIcon showDownIcon} is set to true</td></tr>
     * <tr><td><code><i>iconStyle</i>+Disabled</code></td>      <td>Applied when the component is {@link
     * com.smartgwt.client.widgets.Canvas#getDisabled disabled}       if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDisabledIcon showDisabledIcon} is true.</td></tr> <tr><td
     * colspan=2><i>Combined styles</i></td></tr> <tr><td><code><i>iconStyle</i>+SelectedFocused</code></td>      <td>Combined
     * Selected and focused styling</td></tr> <tr><td><code><i>iconStyle</i>+SelectedOver</code></td>      <td>Combined
     * Selected and rollOver styling</td></tr> <tr><td><code><i>iconStyle</i>+FocusedOver</code></td>      <td>Combined Focused
     * and rollOver styling</td></tr> <tr><td><code><i>iconStyle</i>+SelectedFocusedOver</code></td>      <td>Combined
     * Selected, Focused and rollOver styling</td></tr> <tr><td><code><i>iconStyle</i>+SelectedDown</code></td>     
     * <td>Combined Selected and mouse-down styling</td></tr> <tr><td><code><i>iconStyle</i>+FocusedDown</code></td>     
     * <td>Combined Focused and mouse-down styling</td></tr> <tr><td><code><i>iconStyle</i>+SelectedFocusedDown</code></td>    
     * <td>Combined Selected, Focused and mouse-down styling</td></tr>
     * <tr><td><code><i>iconStyle</i>+SelectedDisabled</code></td>      <td>Combined Selected and Disabled styling</td></tr>
     * </table> <p> In addition, if {@link com.smartgwt.client.widgets.StatefulCanvas#getShowRTLIcon showRTLIcon} is true, then
     * in RTL mode, a final "RTL" suffix will be appended.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.StatefulCanvas#getIconStyle iconStyle}.
     *
     * @param iconStyle the new <code>iconStyle</code> (may be <code>null</code> to remove the className on the image). See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconStyle(String iconStyle) {
        setAttribute("iconStyle", iconStyle, true);
    }

    /**
     * Base CSS style applied to the icon image. If set, as the <code>StatefulCanvas</code> changes {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getState state} and/or is {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getSelected selected}, suffixes will be appended to <code>iconStyle</code> to
     * form the className set on the image element. <p> The following table lists out the standard set of suffixes which may be
     * appended: <table border=1> <tr><th>CSS Class Applied</th><th>Description</th></tr>
     * <tr><td><code><i>iconStyle</i></code></td><td>Default CSS style</td></tr>
     * <tr><td><code><i>iconStyle</i>+Selected</code></td>      <td>Applied when {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} and {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowSelectedIcon showSelectedIcon}      are true.</td></tr>
     * <tr><td><code><i>iconStyle</i>+Focused</code></td>      <td>Applied when the component has keyboard focus, if     
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedIcon showFocusedIcon} is true, and      {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is not true.</td></tr>
     * <tr><td><code><i>iconStyle</i>+Over</code></td>      <td>Applied when {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOverIcon showRollOverIcon} is set to true and either      the user
     * rolls over the component or {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is
     * true      and the component has keyboard focus.</td></tr> <tr><td><code><i>iconStyle</i>+Down</code></td>     
     * <td>Applied when the user presses the mouse button on the component if          {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDownIcon showDownIcon} is set to true</td></tr>
     * <tr><td><code><i>iconStyle</i>+Disabled</code></td>      <td>Applied when the component is {@link
     * com.smartgwt.client.widgets.Canvas#getDisabled disabled}       if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDisabledIcon showDisabledIcon} is true.</td></tr> <tr><td
     * colspan=2><i>Combined styles</i></td></tr> <tr><td><code><i>iconStyle</i>+SelectedFocused</code></td>      <td>Combined
     * Selected and focused styling</td></tr> <tr><td><code><i>iconStyle</i>+SelectedOver</code></td>      <td>Combined
     * Selected and rollOver styling</td></tr> <tr><td><code><i>iconStyle</i>+FocusedOver</code></td>      <td>Combined Focused
     * and rollOver styling</td></tr> <tr><td><code><i>iconStyle</i>+SelectedFocusedOver</code></td>      <td>Combined
     * Selected, Focused and rollOver styling</td></tr> <tr><td><code><i>iconStyle</i>+SelectedDown</code></td>     
     * <td>Combined Selected and mouse-down styling</td></tr> <tr><td><code><i>iconStyle</i>+FocusedDown</code></td>     
     * <td>Combined Focused and mouse-down styling</td></tr> <tr><td><code><i>iconStyle</i>+SelectedFocusedDown</code></td>    
     * <td>Combined Selected, Focused and mouse-down styling</td></tr>
     * <tr><td><code><i>iconStyle</i>+SelectedDisabled</code></td>      <td>Combined Selected and Disabled styling</td></tr>
     * </table> <p> In addition, if {@link com.smartgwt.client.widgets.StatefulCanvas#getShowRTLIcon showRTLIcon} is true, then
     * in RTL mode, a final "RTL" suffix will be appended.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public String getIconStyle()  {
        return getAttributeAsString("iconStyle");
    }
    

    /**
     * Width in pixels of the icon image. <P> If unset, defaults to {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize}.
     *
     * @param iconWidth  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconWidth(Integer iconWidth)  throws IllegalStateException {
        setAttribute("iconWidth", iconWidth, false);
    }

    /**
     * Width in pixels of the icon image. <P> If unset, defaults to {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize}.
     *
     * @return Integer
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Integer getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }
    

    /**
     * Should horizontal alignment-related attributes {@link com.smartgwt.client.widgets.StatefulCanvas#getAlign align} and
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getIconOrientation iconOrientation} be mirrored in RTL mode? This is
     * the default behavior unless ignoreRTL is set to true.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.StatefulCanvas#getIgnoreRTL ignoreRTL}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param ignoreRTL new value for ignoreRTL.. Default value is false
     */
    public void setIgnoreRTL(boolean ignoreRTL) {
        setAttribute("ignoreRTL", ignoreRTL, true);
    }

    /**
     * Should horizontal alignment-related attributes {@link com.smartgwt.client.widgets.StatefulCanvas#getAlign align} and
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getIconOrientation iconOrientation} be mirrored in RTL mode? This is
     * the default behavior unless ignoreRTL is set to true.
     *
     * @return boolean
     */
    public boolean getIgnoreRTL()  {
        return getAttributeAsBoolean("ignoreRTL");
    }
    

    /**
     * Auto generated child widget to be shown when the user rolls over this canvas if  {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowOverCanvas showOverCanvas} is true. See documentation for {@link
     * com.smartgwt.client.types.AutoChild} for information on how to customize this canvas.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Canvas
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Canvas getOverCanvas() throws IllegalStateException {
        errorIfNotCreated("overCanvas");
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("overCanvas"));
    }
    

    /**
     * Constructor class name for this widget's {@link com.smartgwt.client.widgets.StatefulCanvas#getOverCanvas overCanvas}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param overCanvasConstructor  Default value is "Canvas"
     */
    public void setOverCanvasConstructor(String overCanvasConstructor) {
        setAttribute("overCanvasConstructor", overCanvasConstructor, true);
    }

    /**
     * Constructor class name for this widget's {@link com.smartgwt.client.widgets.StatefulCanvas#getOverCanvas overCanvas}
     *
     * @return String
     */
    public String getOverCanvasConstructor()  {
        return getAttributeAsString("overCanvasConstructor");
    }
    
    

    /**
     * String identifier for this canvas's mutually exclusive selection group.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param radioGroup  Default value is null
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setRadioGroup(String radioGroup) {
        setAttribute("radioGroup", radioGroup, true);
    }

    /**
     * String identifier for this canvas's mutually exclusive selection group.
     *
     * @return String
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public String getRadioGroup()  {
        return getAttributeAsString("radioGroup");
    }
    

    /**
     * Whether this widget needs to redraw to reflect state change
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param redrawOnStateChange  Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setRedrawOnStateChange(Boolean redrawOnStateChange) {
        setAttribute("redrawOnStateChange", redrawOnStateChange, true);
    }

    /**
     * Whether this widget needs to redraw to reflect state change
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getRedrawOnStateChange()  {
        return getAttributeAsBoolean("redrawOnStateChange");
    }
    

    /**
     * Whether this component is selected.  For some components, selection affects appearance.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set this object to be selected or deselected.
     *
     * @param selected new boolean value of whether or not the object is                                          selected.. Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setSelected(Boolean selected) {
        setAttribute("selected", selected, true);
    }

    /**
     * Whether this component is selected.  For some components, selection affects appearance.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getSelected()  {
        return getAttributeAsBoolean("selected");
    }
    

    /**
     * Should we visibly change state when disabled?
     *
     * @param showDisabled  Default value is true
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setShowDisabled(Boolean showDisabled) {
        setAttribute("showDisabled", showDisabled, true);
    }

    /**
     * Should we visibly change state when disabled?
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowDisabled()  {
        return getAttributeAsBoolean("showDisabled");
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes disabled.
     *
     * @param showDisabledIcon  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowDisabledIcon(Boolean showDisabledIcon)  throws IllegalStateException {
        setAttribute("showDisabledIcon", showDisabledIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes disabled.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowDisabledIcon()  {
        return getAttributeAsBoolean("showDisabledIcon");
    }
    

    /**
     * Should we visibly change state when the mouse goes down in this object?
     *
     * @param showDown  Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setShowDown(Boolean showDown) {
        setAttribute("showDown", showDown, true);
    }

    /**
     * Should we visibly change state when the mouse goes down in this object?
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowDown()  {
        return getAttributeAsBoolean("showDown");
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes down on the button.
     *
     * @param showDownIcon  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowDownIcon(Boolean showDownIcon)  throws IllegalStateException {
        setAttribute("showDownIcon", showDownIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes down on the button.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowDownIcon()  {
        return getAttributeAsBoolean("showDownIcon");
    }
    
    

    /**
     * Should we visibly change state when the canvas receives focus?  If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is <code>true</code>, the
     * <b><code>"over"</code></b> will be used to indicate focus. Otherwise a separate <b><code>"focused"</code></b> state will
     * be used.
     *
     * @param showFocused  Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setShowFocused(Boolean showFocused) {
        setAttribute("showFocused", showFocused, true);
    }

    /**
     * Should we visibly change state when the canvas receives focus?  If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is <code>true</code>, the
     * <b><code>"over"</code></b> will be used to indicate focus. Otherwise a separate <b><code>"focused"</code></b> state will
     * be used.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowFocused()  {
        return getAttributeAsBoolean("showFocused");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocused showFocused} is true for this widget, should the
     * <code>"over"</code> state be used to indicate the widget as focused. If set to false, a separate <code>"focused"</code>
     * state will be used.
     *
     * @param showFocusedAsOver  Default value is true
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setShowFocusedAsOver(Boolean showFocusedAsOver) {
        setAttribute("showFocusedAsOver", showFocusedAsOver, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocused showFocused} is true for this widget, should the
     * <code>"over"</code> state be used to indicate the widget as focused. If set to false, a separate <code>"focused"</code>
     * state will be used.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowFocusedAsOver()  {
        return getAttributeAsBoolean("showFocusedAsOver");
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image when the button receives focus. <P> If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is true, the <code>"Over"</code> icon
     * will be displayed when the canvas has focus, otherwise a separate <code>"Focused"</code> icon will be displayed
     *
     * @param showFocusedIcon  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowFocusedIcon(Boolean showFocusedIcon)  throws IllegalStateException {
        setAttribute("showFocusedIcon", showFocusedIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button receives focus. <P> If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is true, the <code>"Over"</code> icon
     * will be displayed when the canvas has focus, otherwise a separate <code>"Focused"</code> icon will be displayed
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowFocusedIcon()  {
        return getAttributeAsBoolean("showFocusedIcon");
    }
    

    /**
     * When this property is set to true, this widget will create and show the {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getOverCanvas overCanvas} on user rollover.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOverCanvas  Default value is false
     */
    public void setShowOverCanvas(Boolean showOverCanvas) {
        setAttribute("showOverCanvas", showOverCanvas, true);
    }

    /**
     * When this property is set to true, this widget will create and show the {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getOverCanvas overCanvas} on user rollover.
     *
     * @return Boolean
     */
    public Boolean getShowOverCanvas()  {
        return getAttributeAsBoolean("showOverCanvas");
    }
    

    /**
     * Should we visibly change state when the mouse goes over this object?
     *
     * @param showRollOver  Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setShowRollOver(Boolean showRollOver) {
        setAttribute("showRollOver", showRollOver, true);
    }

    /**
     * Should we visibly change state when the mouse goes over this object?
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowRollOver()  {
        return getAttributeAsBoolean("showRollOver");
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image on mouse rollover.
     *
     * @param showRollOverIcon  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowRollOverIcon(Boolean showRollOverIcon)  throws IllegalStateException {
        setAttribute("showRollOverIcon", showRollOverIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image on mouse rollover.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowRollOverIcon()  {
        return getAttributeAsBoolean("showRollOverIcon");
    }
    

    /**
     * Is {@link com.smartgwt.client.util.Page#isRTL RTL} media available for the icon? If true, then in RTL mode, the image's
     * src will have "_rtl" inserted immediately before the file extension. For example, if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIcon icon} is "myIcon.png" and showRTLIcon is true, then in RTL mode, the
     * image's src will be set to "myIcon_rtl.png".
     *
     * @param showRTLIcon  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowRTLIcon(boolean showRTLIcon)  throws IllegalStateException {
        setAttribute("showRTLIcon", showRTLIcon, false);
    }

    /**
     * Is {@link com.smartgwt.client.util.Page#isRTL RTL} media available for the icon? If true, then in RTL mode, the image's
     * src will have "_rtl" inserted immediately before the file extension. For example, if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIcon icon} is "myIcon.png" and showRTLIcon is true, then in RTL mode, the
     * image's src will be set to "myIcon_rtl.png".
     *
     * @return boolean
     */
    public boolean getShowRTLIcon()  {
        return getAttributeAsBoolean("showRTLIcon");
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     * @param showSelectedIcon  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowSelectedIcon(Boolean showSelectedIcon)  throws IllegalStateException {
        setAttribute("showSelectedIcon", showSelectedIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowSelectedIcon()  {
        return getAttributeAsBoolean("showSelectedIcon");
    }
    

    /**
     * Current "state" of this widget. The state setting is automatically updated as the  user interacts with the component
     * (see {@link com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver showRollOver},  {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown showDown}, {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDisabled showDisabled}). <P> StatefulCanvases will have a different
     * appearance based on their current state.  By default this is handled by changing the css className applied to the
     * StatefulCanvas - see {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle baseStyle} and  {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getStateSuffix StatefulCanvas.getStateSuffix} for a description of how this
     * is done. <P> For {@link com.smartgwt.client.widgets.Img} or {@link com.smartgwt.client.widgets.StretchImg} based
     * subclasses of StatefulCanvas, the  appearance may also be updated by changing the src of the rendered image. See {@link
     * com.smartgwt.client.widgets.Img#getSrc src} and {@link com.smartgwt.client.widgets.StretchImgButton#getSrc src} for a
     * description of how the URL  is modified to reflect the state of the widget in this case.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.StatefulCanvas#getState state} of this object, changing its appearance. Note: <code>newState</code> cannot be  {@link com.smartgwt.client.types.State#STATE_DISABLED} if {@link com.smartgwt.client.widgets.StatefulCanvas#getShowDisabled this.showDisabled} is <code>false</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param state the new state.. Default value is ""
     * @see com.smartgwt.client.types.State
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setState(State state) {
        setAttribute("state", state == null ? null : state.getValue(), true);
    }

    /**
     * Current "state" of this widget. The state setting is automatically updated as the  user interacts with the component
     * (see {@link com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver showRollOver},  {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown showDown}, {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDisabled showDisabled}). <P> StatefulCanvases will have a different
     * appearance based on their current state.  By default this is handled by changing the css className applied to the
     * StatefulCanvas - see {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle baseStyle} and  {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getStateSuffix StatefulCanvas.getStateSuffix} for a description of how this
     * is done. <P> For {@link com.smartgwt.client.widgets.Img} or {@link com.smartgwt.client.widgets.StretchImg} based
     * subclasses of StatefulCanvas, the  appearance may also be updated by changing the src of the rendered image. See {@link
     * com.smartgwt.client.widgets.Img#getSrc src} and {@link com.smartgwt.client.widgets.StretchImgButton#getSrc src} for a
     * description of how the URL  is modified to reflect the state of the widget in this case.
     *
     * @return Return the state of this StatefulCanvas
     * @see com.smartgwt.client.types.State
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public State getState()  {
        return EnumUtil.getEnum(State.values(), getAttribute("state"));
    }
    

    /**
     * The title HTML to display in this button.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for the {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title}.
     *
     * @param title the new title HTML. See {@link com.smartgwt.client.docs.HTMLString HTMLString} . Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * The title HTML to display in this button.
     *
     * @return Return the title - HTML drawn inside the component. <p> Default is to simply return this.title. See {@link com.smartgwt.client.docs.HTMLString HTMLString} 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Vertical alignment of this component's title.
     *
     * @param valign  Default value is Canvas.CENTER
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setValign(VerticalAlignment valign) {
        setAttribute("valign", valign == null ? null : valign.getValue(), true);
    }

    /**
     * Vertical alignment of this component's title.
     *
     * @return VerticalAlignment
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public VerticalAlignment getValign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("valign"));
    }
    

    // ********************* Methods ***********************

	/**
     * Add this widget to the specified mutually exclusive selection group with the ID passed in. Selecting this widget will
     * then deselect any other StatefulCanvases with the same radioGroup ID. StatefulCanvases can belong to only one
     * radioGroup, so this method will remove from  any other radiogroup of which this button is already a member.
     * @param groupID - ID of the radiogroup to which this widget should be added
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public native void addToRadioGroup(String groupID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addToRadioGroup(groupID);
    }-*/;


	/**
     * Deselect this object.
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public native void deselect() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselect();
    }-*/;

	/**
     * Returns the suffix that will be appended to the {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle
     * baseStyle}   as the component changes {@link com.smartgwt.client.widgets.StatefulCanvas#getState state} and/or is
     * selected / focused. <P> The following table lists out the standard set of suffixes which may be applied  to the base
     * style: <table border=1> <tr><td><b>CSS Class Applied</b></td><td><b>Description</b></td></tr>
     * <tr><td><code><i>baseStyle</i></code></td><td>Default css style</td></tr>
     * <tr><td><code><i>baseStyle</i>+Selected</code></td>      <td>Applied when {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} is set to true</td></tr>
     * <tr><td><code><i>baseStyle</i>+Focused</code></td>      <td>Applied when the component has keyboard focus, if      
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocused showFocused} is true, and       {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is not true.</td></tr>
     * <tr><td><code><i>baseStyle</i>+Over</code></td>      <td>Applied when {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver showRollOver} is set to true and either the user      rolls
     * over the component or {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is true
     * and the      component has keyboard focus.</td></tr> <tr><td><code><i>baseStyle</i>+Down</code></td>      <td>Applied
     * when the user presses the mouse button on the component if          {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown showDown} is set to true</td></tr>
     * <tr><td><code><i>baseStyle</i>+Disabled</code></td>      <td>Applied when the component is {@link
     * com.smartgwt.client.widgets.Canvas#getDisabled disabled}       if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDisabled showDisabled} is true.</td></tr> <tr><td
     * colspan=2><i>Combined styles</i></td></tr> <tr><td><code><i>baseStyle</i>+SelectedFocused</code></td>      <td>Combined
     * Selected and focused styling</td></tr> <tr><td><code><i>baseStyle</i>+SelectedOver</code></td>      <td>Combined
     * Selected and rollOver styling</td></tr> <tr><td><code><i>baseStyle</i>+FocusedOver</code></td>      <td>Combined Focused
     * and rollOver styling</td></tr> <tr><td><code><i>baseStyle</i>+SelectedFocusedOver</code></td>      <td>Combined
     * Selected, Focused and rollOver styling</td></tr> <tr><td><code><i>baseStyle</i>+SelectedDown</code></td>     
     * <td>Combined Selected and mouse-down styling</td></tr> <tr><td><code><i>baseStyle</i>+FocusedDown</code></td>     
     * <td>Combined Focused and mouse-down styling</td></tr> <tr><td><code><i>baseStyle</i>+SelectedFocusedDown</code></td>    
     * <td>Combined Selected, Focused and mouse-down styling</td></tr>
     * <tr><td><code><i>baseStyle</i>+SelectedDisabled</code></td>      <td>Combined Selected and Disabled styling</td></tr>
     * </table>
     *
     * @return suffix to be appended to the baseStyle
     */
    public native String getStateSuffix() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getStateSuffix();
        return ret;
    }-*/;

	/**
     * Find out if this object is selected
     *
     * @return 
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public native Boolean isSelected() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isSelected();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Remove this widget from the specified mutually exclusive selection group with the ID passed in. No-op's if this widget
     * is not a member of the groupID passed in. If no groupID is passed in, defaults to removing from whatever radioGroup this
     * widget is a member of.
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public native void removeFromRadioGroup() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeFromRadioGroup();
    }-*/;

	/**
     * Remove this widget from the specified mutually exclusive selection group with the ID passed in. No-op's if this widget
     * is not a member of the groupID passed in. If no groupID is passed in, defaults to removing from whatever radioGroup this
     * widget is a member of.
     * @param groupID - optional radio group ID (to ensure the widget is removed                                        from the appropriate
     * group.
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public native void removeFromRadioGroup(String groupID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeFromRadioGroup(groupID);
    }-*/;
	
	/**
     * Select this object.
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public native void select() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.select();
    }-*/;


    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param statefulCanvasProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(StatefulCanvas statefulCanvasProperties) /*-{
    	var properties = $wnd.isc.addProperties({},statefulCanvasProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.StatefulCanvas.addProperties(properties);
    }-*/;

    // ***********************************************************


    public void setTitleStyle(String titleStyle) {
        setAttribute("titleStyle", titleStyle, true);
    }

    public LogicalStructureObject setLogicalStructure(StatefulCanvasLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.actionType = getAttributeAsString("actionType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.actionType:" + t.getMessage() + "\n";
        }
        try {
            s.align = getAttributeAsString("align");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.align:" + t.getMessage() + "\n";
        }
        try {
            s.autoFit = getAttributeAsString("autoFit");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.autoFit:" + t.getMessage() + "\n";
        }
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.icon = getAttributeAsString("icon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.icon:" + t.getMessage() + "\n";
        }
        try {
            s.iconHeight = getAttributeAsString("iconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.iconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.iconOrientation = getAttributeAsString("iconOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.iconOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.iconSize = getAttributeAsString("iconSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.iconSize:" + t.getMessage() + "\n";
        }
        try {
            s.iconStyle = getAttributeAsString("iconStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.iconStyle:" + t.getMessage() + "\n";
        }
        try {
            s.iconWidth = getAttributeAsString("iconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.iconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.ignoreRTL = getAttributeAsString("ignoreRTL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.ignoreRTL:" + t.getMessage() + "\n";
        }
        try {
            s.overCanvasConstructor = getAttributeAsString("overCanvasConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.overCanvasConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.radioGroup = getAttributeAsString("radioGroup");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.radioGroup:" + t.getMessage() + "\n";
        }
        try {
            s.redrawOnStateChange = getAttributeAsString("redrawOnStateChange");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.redrawOnStateChange:" + t.getMessage() + "\n";
        }
        try {
            s.selected = getAttributeAsString("selected");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.selected:" + t.getMessage() + "\n";
        }
        try {
            s.showDisabled = getAttributeAsString("showDisabled");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.showDisabled:" + t.getMessage() + "\n";
        }
        try {
            s.showDisabledIcon = getAttributeAsString("showDisabledIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.showDisabledIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showDown = getAttributeAsString("showDown");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.showDown:" + t.getMessage() + "\n";
        }
        try {
            s.showDownIcon = getAttributeAsString("showDownIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.showDownIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showFocused = getAttributeAsString("showFocused");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.showFocused:" + t.getMessage() + "\n";
        }
        try {
            s.showFocusedAsOver = getAttributeAsString("showFocusedAsOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.showFocusedAsOver:" + t.getMessage() + "\n";
        }
        try {
            s.showFocusedIcon = getAttributeAsString("showFocusedIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.showFocusedIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showOverCanvas = getAttributeAsString("showOverCanvas");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.showOverCanvas:" + t.getMessage() + "\n";
        }
        try {
            s.showRollOver = getAttributeAsString("showRollOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.showRollOver:" + t.getMessage() + "\n";
        }
        try {
            s.showRollOverIcon = getAttributeAsString("showRollOverIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.showRollOverIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showRTLIcon = getAttributeAsString("showRTLIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.showRTLIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showSelectedIcon = getAttributeAsString("showSelectedIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.showSelectedIcon:" + t.getMessage() + "\n";
        }
        try {
            s.state = getAttributeAsString("state");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.state:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.title:" + t.getMessage() + "\n";
        }
        try {
            s.valign = getAttributeAsString("valign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StatefulCanvas.valign:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        StatefulCanvasLogicalStructure s = new StatefulCanvasLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

