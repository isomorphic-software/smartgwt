/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
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
import com.smartgwt.client.widgets.layout.*;
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
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * A StretchImg that behaves like a button, going through up/down/over state transitions in response&#010 to user events.  Supports an optional title, and will auto-size to accomodate the title text if&#010 <code>overflow</code> is set to "visible".&#010 <P>&#010 Examples of use include fancy buttons, poplist headers, and tabs.

    */

public class StretchImgButton extends StretchImg  implements com.smartgwt.client.widgets.events.HasIconClickHandlers {

    public static StretchImgButton getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (StretchImgButton) obj;
        } else {
            return new StretchImgButton(jsObj);
        }
    }


    public StretchImgButton(){
        
    }

    public StretchImgButton(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.StretchImgButton.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * The text title to display in this button.
    * Set the title.&#010
    *
    * @param title new title. Default value is varies
    */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }
    /**
     * The text title to display in this button.
     *
     *
     * @return Return the title - text/HTML drawn inside the component.&#010 <p>&#010 Default is to simply return this.title.&#010
     *
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
    * Should the title for this button wrap? If unset, default behavior is to allow wrapping&#010 if this.vertical is true, otherwise disallow wrapping
    *
    * @param wrap wrap Default value is null
    */
    public void setWrap(Boolean wrap) {
        setAttribute("wrap", wrap, true);
    }
    /**
     * Should the title for this button wrap? If unset, default behavior is to allow wrapping&#010 if this.vertical is true, otherwise disallow wrapping
     *
     *
     * @return Boolean
     *
     */
    public Boolean getWrap()  {
        return getAttributeAsBoolean("wrap");
    }

    /**
    * Optional icon to be shown with the button title text.  &#010 <P>&#010 Specify as the partial URL to an image, relative to the imgDir of this component.
    * Change the icon being shown next to the title text.&#010
    *
    * @param icon URL of new icon. Default value is null
    */
    public void setIcon(String icon) {
        setAttribute("icon", icon, true);
    }
    /**
     * Optional icon to be shown with the button title text.  &#010 <P>&#010 Specify as the partial URL to an image, relative to the imgDir of this component.
     *
     *
     * @return String
     *
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }

    /**
    * Size in pixels of the icon image.&#010 <P>&#010 The <code>iconWidth</code> and <code>iconHeight</code> properties can be used to&#010 configure width and height separately.
    *
    * @param iconSize iconSize Default value is 16
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setIconSize(int iconSize)  throws IllegalStateException {
        setAttribute("iconSize", iconSize, false);
    }
    /**
     * Size in pixels of the icon image.&#010 <P>&#010 The <code>iconWidth</code> and <code>iconHeight</code> properties can be used to&#010 configure width and height separately.
     *
     *
     * @return int
     *
     */
    public int getIconSize()  {
        return getAttributeAsInt("iconSize");
    }

    /**
    * Width in pixels of the icon image.&#010 <P>&#010 If unset, defaults to <code>iconSize</code>
    *
    * @param iconWidth iconWidth Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setIconWidth(Integer iconWidth)  throws IllegalStateException {
        setAttribute("iconWidth", iconWidth, false);
    }
    /**
     * Width in pixels of the icon image.&#010 <P>&#010 If unset, defaults to <code>iconSize</code>
     *
     *
     * @return Integer
     *
     */
    public Integer getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }

    /**
    * Height in pixels of the icon image.&#010 <P>&#010 If unset, defaults to <code>iconSize</code>
    *
    * @param iconHeight iconHeight Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setIconHeight(Integer iconHeight)  throws IllegalStateException {
        setAttribute("iconHeight", iconHeight, false);
    }
    /**
     * Height in pixels of the icon image.&#010 <P>&#010 If unset, defaults to <code>iconSize</code>
     *
     *
     * @return Integer
     *
     */
    public Integer getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }

    /**
    * If this button is showing an icon should it appear to the left or right of the title?&#010 valid options are <code>"left"</code> and <code>"right"</code>.
    * Changes the orientation of the icon relative to the text of the button.&#010&#010
    *
    * @param iconOrientation The new orientation of the icon relative to the text of the button.. Default value is "left"
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setIconOrientation(String iconOrientation)  throws IllegalStateException {
        setAttribute("iconOrientation", iconOrientation, false);
    }
    /**
     * If this button is showing an icon should it appear to the left or right of the title?&#010 valid options are <code>"left"</code> and <code>"right"</code>.
     *
     *
     * @return String
     *
     */
    public String getIconOrientation()  {
        return getAttributeAsString("iconOrientation");
    }

    /**
    * If this button is showing an icon should it be right or left aligned?
    *
    * @param iconAlign iconAlign Default value is null
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setIconAlign(String iconAlign)  throws IllegalStateException {
        setAttribute("iconAlign", iconAlign, false);
    }
    /**
     * If this button is showing an icon should it be right or left aligned?
     *
     *
     * @return String
     *
     */
    public String getIconAlign()  {
        return getAttributeAsString("iconAlign");
    }

    /**
    * Optional icon to be shown with the button title text.  &#010 <P>&#010 Specify as the partial URL to an image, relative to the imgDir of this component.
    *
    * @param iconSpacing iconSpacing Default value is null
    */
    public void setIconSpacing(String iconSpacing) {
        setAttribute("iconSpacing", iconSpacing, true);
    }
    /**
     * Optional icon to be shown with the button title text.  &#010 <P>&#010 Specify as the partial URL to an image, relative to the imgDir of this component.
     *
     *
     * @return String
     *
     */
    public String getIconSpacing()  {
        return getAttributeAsString("iconSpacing");
    }

    /**
    * If using an icon for this button, whether to switch the icon image if the button becomes&#010 disabled.
    *
    * @param showDisabledIcon showDisabledIcon Default value is true
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowDisabledIcon(Boolean showDisabledIcon)  throws IllegalStateException {
        setAttribute("showDisabledIcon", showDisabledIcon, false);
    }
    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes&#010 disabled.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDisabledIcon()  {
        return getAttributeAsBoolean("showDisabledIcon");
    }

    /**
    * If using an icon for this button, whether to switch the icon image on mouse rollover.
    *
    * @param showRollOverIcon showRollOverIcon Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowRollOverIcon(Boolean showRollOverIcon)  throws IllegalStateException {
        setAttribute("showRollOverIcon", showRollOverIcon, false);
    }
    /**
     * If using an icon for this button, whether to switch the icon image on mouse rollover.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowRollOverIcon()  {
        return getAttributeAsBoolean("showRollOverIcon");
    }

    /**
    * If using an icon for this button, whether to switch the icon image when the button&#010 recieves focus.&#010 <P>&#010 If {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is true, the <code>"Over"</code> icon will be&#010 displayed when the canvas has focus, otherwise a seperate <code>"Focused"</code> icon&#010 will be displayed
    *
    * @param showFocusedIcon showFocusedIcon Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowFocusedIcon(Boolean showFocusedIcon)  throws IllegalStateException {
        setAttribute("showFocusedIcon", showFocusedIcon, false);
    }
    /**
     * If using an icon for this button, whether to switch the icon image when the button&#010 recieves focus.&#010 <P>&#010 If {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is true, the <code>"Over"</code> icon will be&#010 displayed when the canvas has focus, otherwise a seperate <code>"Focused"</code> icon&#010 will be displayed
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowFocusedIcon()  {
        return getAttributeAsBoolean("showFocusedIcon");
    }

    /**
    * If using an icon for this button, whether to switch the icon image when the mouse goes&#010 down on the button.
    *
    * @param showDownIcon showDownIcon Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowDownIcon(Boolean showDownIcon)  throws IllegalStateException {
        setAttribute("showDownIcon", showDownIcon, false);
    }
    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes&#010 down on the button.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDownIcon()  {
        return getAttributeAsBoolean("showDownIcon");
    }

    /**
    * If using an icon for this button, whether to switch the icon image when the button&#010 becomes selected.
    *
    * @param showSelectedIcon showSelectedIcon Default value is false
    * @throws IllegalStateException this property cannot be changed after the component has been created
    */
    public void setShowSelectedIcon(Boolean showSelectedIcon)  throws IllegalStateException {
        setAttribute("showSelectedIcon", showSelectedIcon, false);
    }
    /**
     * If using an icon for this button, whether to switch the icon image when the button&#010 becomes selected.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowSelectedIcon()  {
        return getAttributeAsBoolean("showSelectedIcon");
    }

    /**
    * If true, ignore the specified size of this widget and always size just large&#010 enough to accomodate the title.  If <code>setWidth()</code> is explicitly called on an&#010 autoFit:true button, autoFit will be reset to <code>false</code>.&#010 <P>&#010 Note that for StretchImgButton instances, autoFit will occur horizontally only, as &#010 unpredictable vertical sizing is likely to distort the media. If you do want vertical &#010 auto-fit, this can be achieved by simply setting a small height, and having &#010 overflow:"visible"
    * Setter method for the {@link com.smartgwt.client.widgets.StatefulCanvas#getAutoFit autoFit} property. Pass in true or false to turn&#010 autoFit on or off. When autoFit is set to <code>false</code>, canvas will be resized to&#010 it's previously specified size.&#010
    *
    * @param autoFit New autoFit setting.. Default value is null
    */
    public void setAutoFit(Boolean autoFit) {
        setAttribute("autoFit", autoFit, true);
    }
    /**
     * If true, ignore the specified size of this widget and always size just large&#010 enough to accomodate the title.  If <code>setWidth()</code> is explicitly called on an&#010 autoFit:true button, autoFit will be reset to <code>false</code>.&#010 <P>&#010 Note that for StretchImgButton instances, autoFit will occur horizontally only, as &#010 unpredictable vertical sizing is likely to distort the media. If you do want vertical &#010 auto-fit, this can be achieved by simply setting a small height, and having &#010 overflow:"visible"
     *
     *
     * @return Boolean
     *
     */
    public Boolean getAutoFit()  {
        return getAttributeAsBoolean("autoFit");
    }

    /**
    * Base CSS style.  As the component changes state and/or is selected, suffixes will be&#010 added to the base style.&#010 <P>&#010 When the component changes state (eg becomes disabled), a suffix will be appended to this&#010 style name, reflecting the following states: "Over", "Down", or "Disabled".&#010 <P>&#010 If the widget is selected, the suffixes will be "Selected", "SelectedOver", etc.&#010 <P>&#010 If the widget has focus and {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocused showFocused} is true, and&#010 {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is false, the suffixes will be "Focused",&#010 "FocusedOver", etc, or if the widget is both selected and focused, "SelectedFocused",&#010 "SelectedFocusedOver", etc.&#010 <P>&#010 For example, if <code>baseStyle</code> is set to "button", this component is&#010 {@link com.smartgwt.client.widgets.StretchImgButton#isSelected} and the mouse cursor is over this component, the style&#010 "buttonSelectedOver" will be used.
    * Sets the base CSS style.  As the component changes state and/or is selected, suffixes will be&#010 added to the base style.&#010
    *
    * @param baseStyle new base style. Default value is "stretchImgButton"
    */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle, true);
    }
    /**
     * Base CSS style.  As the component changes state and/or is selected, suffixes will be&#010 added to the base style.&#010 <P>&#010 When the component changes state (eg becomes disabled), a suffix will be appended to this&#010 style name, reflecting the following states: "Over", "Down", or "Disabled".&#010 <P>&#010 If the widget is selected, the suffixes will be "Selected", "SelectedOver", etc.&#010 <P>&#010 If the widget has focus and {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocused showFocused} is true, and&#010 {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is false, the suffixes will be "Focused",&#010 "FocusedOver", etc, or if the widget is both selected and focused, "SelectedFocused",&#010 "SelectedFocusedOver", etc.&#010 <P>&#010 For example, if <code>baseStyle</code> is set to "button", this component is&#010 {@link com.smartgwt.client.widgets.StretchImgButton#isSelected} and the mouse cursor is over this component, the style&#010 "buttonSelectedOver" will be used.
     *
     *
     * @return String
     *
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }

    /**
    * CSS style applied to the title text only.  Defaults to {@link com.smartgwt.client.widgets.StretchImgButton#getBaseStyle baseStyle} when unset.&#010 <P>&#010 With a separate <code>titleStyle</code> and {@link com.smartgwt.client.widgets.StretchImgButton#getBaseStyle baseStyle} set, you can provide a&#010 backgroundColor via <code>baseStyle</code> that will allow translucent .png media to be&#010 "tinted" by the underlying background color, so that a single set of media can provide&#010 range of color options.  In this usage, the <code>titleStyle</code> should generally not&#010 specify a background color as this would block out the media that appears behind the&#010 title.
    * Sets the {@link com.smartgwt.client.widgets.StretchImgButton#getTitleStyle titleStyle}, which is applied to the title text.&#010
    *
    * @param titleStyle new title style. Default value is null
    */
    public void setTitleStyle(String titleStyle) {
        setAttribute("titleStyle", titleStyle, true);
    }
    /**
     * CSS style applied to the title text only.  Defaults to {@link com.smartgwt.client.widgets.StretchImgButton#getBaseStyle baseStyle} when unset.&#010 <P>&#010 With a separate <code>titleStyle</code> and {@link com.smartgwt.client.widgets.StretchImgButton#getBaseStyle baseStyle} set, you can provide a&#010 backgroundColor via <code>baseStyle</code> that will allow translucent .png media to be&#010 "tinted" by the underlying background color, so that a single set of media can provide&#010 range of color options.  In this usage, the <code>titleStyle</code> should generally not&#010 specify a background color as this would block out the media that appears behind the&#010 title.
     *
     *
     * @return String
     *
     */
    public String getTitleStyle()  {
        return getAttributeAsString("titleStyle");
    }

    /**
    * Whether this component is selected.  For some components, selection affects appearance.
    * Select this object.&#010
    *
    * @param selected selected Default value is false
    */
    public void setSelected(Boolean selected) {
        setAttribute("selected", selected, true);
    }
    /**
     * Whether this component is selected.  For some components, selection affects appearance.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSelected()  {
        return getAttributeAsBoolean("selected");
    }

    /**
    * String identifier for this canvas's mutually exclusive selection group.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param radioGroup radioGroup Default value is null
    */
    public void setRadioGroup(String radioGroup) {
        setAttribute("radioGroup", radioGroup, true);
    }
    /**
     * String identifier for this canvas's mutually exclusive selection group.
     *
     *
     * @return String
     *
     */
    public String getRadioGroup()  {
        return getAttributeAsString("radioGroup");
    }
             
    /**
    * Behavior on state changes -- BUTTON, RADIO or CHECKBOX
    * Update the 'actionType' for this canvas (radio / checkbox / button)&#010 If the canvas is currently selected, and the passed in actionType is 'button'&#010 this method will deselect the canvas.&#010
    *
    * @param actionType actionType Default value is "button"
    */
    public void setActionType(SelectionType actionType) {
        setAttribute("actionType", actionType.getValue(), true);
    }
    /**
     * Behavior on state changes -- BUTTON, RADIO or CHECKBOX
     *
     *
     * @return Return the 'actionType' for this canvas (radio / checkbox / button)&#010
     *
     */
    public SelectionType getActionType()  {
        return (SelectionType) EnumUtil.getEnum(SelectionType.values(), getAttribute("actionType"));
    }
             
    /**
    * Current "state" of this widget. StatefulCanvases will have a different appearance based&#010 on their current state. By default this is handled by changing the css className applied to&#010 the StatefulCanvas - see {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle baseStyle} for a description of how this is&#010 done.<P>&#010 For {@link com.smartgwt.client.widgets.Img} or {@link com.smartgwt.client.widgets.StretchImg} based subclasses of StatefulCanvas, the &#010 appearance may also be updated by changing the src of the rendered image. See&#010 {@link com.smartgwt.client.widgets.Img#getSrc src} and {@link com.smartgwt.client.widgets.StretchImgButton#getSrc src} for a description of how the URL &#010 is modified to reflect the state of the widget in this case.
    * Set the 'state' of this object, this changes it's appearance.&#010&#010
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param state new state. Default value is ""
    */
    public void setState(State state) {
        setAttribute("state", state.getValue(), true);
    }
    /**
     * Current "state" of this widget. StatefulCanvases will have a different appearance based&#010 on their current state. By default this is handled by changing the css className applied to&#010 the StatefulCanvas - see {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle baseStyle} for a description of how this is&#010 done.<P>&#010 For {@link com.smartgwt.client.widgets.Img} or {@link com.smartgwt.client.widgets.StretchImg} based subclasses of StatefulCanvas, the &#010 appearance may also be updated by changing the src of the rendered image. See&#010 {@link com.smartgwt.client.widgets.Img#getSrc src} and {@link com.smartgwt.client.widgets.StretchImgButton#getSrc src} for a description of how the URL &#010 is modified to reflect the state of the widget in this case.
     *
     *
     * @return Return the state of this StatefulCanvas&#010
     *
     */
    public State getState()  {
        return (State) EnumUtil.getEnum(State.values(), getAttribute("state"));
    }

    /**
    * Should we visibly change state when disabled?
    *
    * @param showDisabled showDisabled Default value is true
    */
    public void setShowDisabled(Boolean showDisabled) {
        setAttribute("showDisabled", showDisabled, true);
    }
    /**
     * Should we visibly change state when disabled?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDisabled()  {
        return getAttributeAsBoolean("showDisabled");
    }

    /**
    * Should we visibly change state when the mouse goes down in this object?
    *
    * @param showDown showDown Default value is false
    */
    public void setShowDown(Boolean showDown) {
        setAttribute("showDown", showDown, true);
    }
    /**
     * Should we visibly change state when the mouse goes down in this object?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowDown()  {
        return getAttributeAsBoolean("showDown");
    }

    /**
    * Should we visibly change state when the canvas recieves focus?  If&#010 {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is <code>true</code>, the <b><code>"over"</code></b>&#010 will be used to indicate focus. Otherwise a separate <b><code>"focused"</code></b> state&#010 will be used.
    *
    * @param showFocused showFocused Default value is false
    */
    public void setShowFocused(Boolean showFocused) {
        setAttribute("showFocused", showFocused, true);
    }
    /**
     * Should we visibly change state when the canvas recieves focus?  If&#010 {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is <code>true</code>, the <b><code>"over"</code></b>&#010 will be used to indicate focus. Otherwise a separate <b><code>"focused"</code></b> state&#010 will be used.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowFocused()  {
        return getAttributeAsBoolean("showFocused");
    }

    /**
    * Should we visibly change state when the mouse goes over this object?
    *
    * @param showRollOver showRollOver Default value is false
    */
    public void setShowRollOver(Boolean showRollOver) {
        setAttribute("showRollOver", showRollOver, true);
    }
    /**
     * Should we visibly change state when the mouse goes over this object?
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowRollOver()  {
        return getAttributeAsBoolean("showRollOver");
    }
             
    /**
    * Horizontal alignment of this component's title.
    *
    * @param align align Default value is Canvas.CENTER
    */
    public void setAlign(Alignment align) {
        setAttribute("align", align.getValue(), true);
    }
    /**
     * Horizontal alignment of this component's title.
     *
     *
     * @return Alignment
     *
     */
    public Alignment getAlign()  {
        return (Alignment) EnumUtil.getEnum(Alignment.values(), getAttribute("align"));
    }
             
    /**
    * Vertical alignment of this component's title.
    *
    * @param valign valign Default value is Canvas.CENTER
    */
    public void setValign(VerticalAlignment valign) {
        setAttribute("valign", valign.getValue(), true);
    }
    /**
     * Vertical alignment of this component's title.
     *
     *
     * @return VerticalAlignment
     *
     */
    public VerticalAlignment getValign()  {
        return (VerticalAlignment) EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("valign"));
    }

    /**
    * Determines whether any specified {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle} will be &#010 displayed for this component.<br>&#010 Applies to Image-based components only, where the title will be rendered out in a label&#010 floating over the component
    *
    * @param showTitle showTitle Default value is true
    */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle, true);
    }
    /**
     * Determines whether any specified {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle} will be &#010 displayed for this component.<br>&#010 Applies to Image-based components only, where the title will be rendered out in a label&#010 floating over the component
     *
     *
     * @return Boolean
     *
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }

    /**
    * The padding for a StretchImgButton's label is determined as follows.&#010 <P>&#010 If <code>labelHPad</code> is set it will specify the horizontal padding applied to the&#010 label. Similarly if <code>labelVPad</code> is set it will specify the vertical padding&#010 for the label, regardless of the button's {@link com.smartgwt.client.widgets.StretchImgButton#getVertical 'vertical'} setting.&#010 <P>&#010 Otherwise <code>labelLengthPad</code> can be set to specify the label padding along the&#010 length axis (ie: horizontal padding if {@link com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false,&#010 otherwise vertical padding), and &#010 <code>labelBreadthPad</code> can be set to specify the label padding along the other axis.&#010 <P>&#010 Otherwise the padding on the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and&#010 will be set to zero on the breadth axis.&#010 <P>&#010 So by default the label will be sized to match the center image of the StretchImgButton, but&#010 these settings allow the label to partially or wholly overlap the caps.
    *
    * @param labelHPad labelHPad Default value is null
    */
    public void setLabelHPad(Integer labelHPad) {
        setAttribute("labelHPad", labelHPad, true);
    }
    /**
     * The padding for a StretchImgButton's label is determined as follows.&#010 <P>&#010 If <code>labelHPad</code> is set it will specify the horizontal padding applied to the&#010 label. Similarly if <code>labelVPad</code> is set it will specify the vertical padding&#010 for the label, regardless of the button's {@link com.smartgwt.client.widgets.StretchImgButton#getVertical 'vertical'} setting.&#010 <P>&#010 Otherwise <code>labelLengthPad</code> can be set to specify the label padding along the&#010 length axis (ie: horizontal padding if {@link com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false,&#010 otherwise vertical padding), and &#010 <code>labelBreadthPad</code> can be set to specify the label padding along the other axis.&#010 <P>&#010 Otherwise the padding on the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and&#010 will be set to zero on the breadth axis.&#010 <P>&#010 So by default the label will be sized to match the center image of the StretchImgButton, but&#010 these settings allow the label to partially or wholly overlap the caps.
     *
     *
     * @return Integer
     *
     */
    public Integer getLabelHPad()  {
        return getAttributeAsInt("labelHPad");
    }

    /**
    * The padding for a StretchImgButton's label is determined as follows.&#010 <P>&#010 If <code>labelHPad</code> is set it will specify the horizontal padding applied to the&#010 label. Similarly if <code>labelVPad</code> is set it will specify the vertical padding&#010 for the label, regardless of the button's {@link com.smartgwt.client.widgets.StretchImgButton#getVertical 'vertical'} setting.&#010 <P>&#010 Otherwise <code>labelLengthPad</code> can be set to specify the label padding along the&#010 length axis (ie: horizontal padding if {@link com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false,&#010 otherwise vertical padding), and &#010 <code>labelBreadthPad</code> can be set to specify the label padding along the other axis.&#010 <P>&#010 Otherwise the padding on the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and&#010 will be set to zero on the breadth axis.&#010 <P>&#010 So by default the label will be sized to match the center image of the StretchImgButton, but&#010 these settings allow the label to partially or wholly overlap the caps.
    *
    * @param labelVPad labelVPad Default value is null
    */
    public void setLabelVPad(Integer labelVPad) {
        setAttribute("labelVPad", labelVPad, true);
    }
    /**
     * The padding for a StretchImgButton's label is determined as follows.&#010 <P>&#010 If <code>labelHPad</code> is set it will specify the horizontal padding applied to the&#010 label. Similarly if <code>labelVPad</code> is set it will specify the vertical padding&#010 for the label, regardless of the button's {@link com.smartgwt.client.widgets.StretchImgButton#getVertical 'vertical'} setting.&#010 <P>&#010 Otherwise <code>labelLengthPad</code> can be set to specify the label padding along the&#010 length axis (ie: horizontal padding if {@link com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false,&#010 otherwise vertical padding), and &#010 <code>labelBreadthPad</code> can be set to specify the label padding along the other axis.&#010 <P>&#010 Otherwise the padding on the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and&#010 will be set to zero on the breadth axis.&#010 <P>&#010 So by default the label will be sized to match the center image of the StretchImgButton, but&#010 these settings allow the label to partially or wholly overlap the caps.
     *
     *
     * @return Integer
     *
     */
    public Integer getLabelVPad()  {
        return getAttributeAsInt("labelVPad");
    }

    /**
    * The padding for a StretchImgButton's label is determined as follows.&#010 <P>&#010 If <code>labelHPad</code> is set it will specify the horizontal padding applied to the&#010 label. Similarly if <code>labelVPad</code> is set it will specify the vertical padding&#010 for the label, regardless of the button's {@link com.smartgwt.client.widgets.StretchImgButton#getVertical 'vertical'} setting.&#010 <P>&#010 Otherwise <code>labelLengthPad</code> can be set to specify the label padding along the&#010 length axis (ie: horizontal padding if {@link com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false,&#010 otherwise vertical padding), and &#010 <code>labelBreadthPad</code> can be set to specify the label padding along the other axis.&#010 <P>&#010 Otherwise the padding on the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and&#010 will be set to zero on the breadth axis.&#010 <P>&#010 So by default the label will be sized to match the center image of the StretchImgButton, but&#010 these settings allow the label to partially or wholly overlap the caps.
    *
    * @param labelLengthPad labelLengthPad Default value is null
    */
    public void setLabelLengthPad(Integer labelLengthPad) {
        setAttribute("labelLengthPad", labelLengthPad, true);
    }
    /**
     * The padding for a StretchImgButton's label is determined as follows.&#010 <P>&#010 If <code>labelHPad</code> is set it will specify the horizontal padding applied to the&#010 label. Similarly if <code>labelVPad</code> is set it will specify the vertical padding&#010 for the label, regardless of the button's {@link com.smartgwt.client.widgets.StretchImgButton#getVertical 'vertical'} setting.&#010 <P>&#010 Otherwise <code>labelLengthPad</code> can be set to specify the label padding along the&#010 length axis (ie: horizontal padding if {@link com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false,&#010 otherwise vertical padding), and &#010 <code>labelBreadthPad</code> can be set to specify the label padding along the other axis.&#010 <P>&#010 Otherwise the padding on the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and&#010 will be set to zero on the breadth axis.&#010 <P>&#010 So by default the label will be sized to match the center image of the StretchImgButton, but&#010 these settings allow the label to partially or wholly overlap the caps.
     *
     *
     * @return Integer
     *
     */
    public Integer getLabelLengthPad()  {
        return getAttributeAsInt("labelLengthPad");
    }

    /**
    * The padding for a StretchImgButton's label is determined as follows.&#010 <P>&#010 If <code>labelHPad</code> is set it will specify the horizontal padding applied to the&#010 label. Similarly if <code>labelVPad</code> is set it will specify the vertical padding&#010 for the label, regardless of the button's {@link com.smartgwt.client.widgets.StretchImgButton#getVertical 'vertical'} setting.&#010 <P>&#010 Otherwise <code>labelLengthPad</code> can be set to specify the label padding along the&#010 length axis (ie: horizontal padding if {@link com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false,&#010 otherwise vertical padding), and &#010 <code>labelBreadthPad</code> can be set to specify the label padding along the other axis.&#010 <P>&#010 Otherwise the padding on the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and&#010 will be set to zero on the breadth axis.&#010 <P>&#010 So by default the label will be sized to match the center image of the StretchImgButton, but&#010 these settings allow the label to partially or wholly overlap the caps.
    *
    * @param labelBreadthPad labelBreadthPad Default value is null
    */
    public void setLabelBreadthPad(Integer labelBreadthPad) {
        setAttribute("labelBreadthPad", labelBreadthPad, true);
    }
    /**
     * The padding for a StretchImgButton's label is determined as follows.&#010 <P>&#010 If <code>labelHPad</code> is set it will specify the horizontal padding applied to the&#010 label. Similarly if <code>labelVPad</code> is set it will specify the vertical padding&#010 for the label, regardless of the button's {@link com.smartgwt.client.widgets.StretchImgButton#getVertical 'vertical'} setting.&#010 <P>&#010 Otherwise <code>labelLengthPad</code> can be set to specify the label padding along the&#010 length axis (ie: horizontal padding if {@link com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false,&#010 otherwise vertical padding), and &#010 <code>labelBreadthPad</code> can be set to specify the label padding along the other axis.&#010 <P>&#010 Otherwise the padding on the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and&#010 will be set to zero on the breadth axis.&#010 <P>&#010 So by default the label will be sized to match the center image of the StretchImgButton, but&#010 these settings allow the label to partially or wholly overlap the caps.
     *
     *
     * @return Integer
     *
     */
    public Integer getLabelBreadthPad()  {
        return getAttributeAsInt("labelBreadthPad");
    }

    /**
    * If set to true, if the {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle 'title'} of this button contains the&#010 specified {@link com.smartgwt.client.widgets.Canvas#getAccessKey 'accessKey'}, when the title is displayed to the user&#010 it will be modified to include HTML to underline the accessKey.<br>&#010 Note that this property may cause titles that include HTML (rather than simple strings)&#010 to be inappropriately modified, so should be disabled if your title string includes&#010 HTML characters.
    *
    * @param hiliteAccessKey hiliteAccessKey Default value is true
    */
    public void setHiliteAccessKey(Boolean hiliteAccessKey) {
        setAttribute("hiliteAccessKey", hiliteAccessKey, true);
    }
    /**
     * If set to true, if the {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle 'title'} of this button contains the&#010 specified {@link com.smartgwt.client.widgets.Canvas#getAccessKey 'accessKey'}, when the title is displayed to the user&#010 it will be modified to include HTML to underline the accessKey.<br>&#010 Note that this property may cause titles that include HTML (rather than simple strings)&#010 to be inappropriately modified, so should be disabled if your title string includes&#010 HTML characters.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getHiliteAccessKey()  {
        return getAttributeAsBoolean("hiliteAccessKey");
    }

    /**
    * Base URL for the image.  By default, StretchImgButtons consist of three image parts: A&#010 start image (displayed at the top or left), a scaleable central image and an end image&#010 displayed at the bottom or right.&#010 <P>&#010 The images displayed in the stretchImgButton are derived from this property in the &#010 following way:&#010 <P>&#010 <ul>&#010 <li> When the button is in its standard state the suffixes "_start", "_end" and &#010      "_stretch" are applied to the src (before the file extension), so by default &#010      the images displayed will be "button_start.gif" (sized to be &#010      <code>this.capSize</code> by the specified width of the stretchImgButton), &#010      "button_stretch.gif" (stretched to the necessary width) and "button_end.gif" &#010      (sized the same as the start image).&#010 <li> As the button's state changes, the images will have suffixes appended <b>before</b>&#010      the "_start" / "_end" / "_stretch" to represent the button state. Possible states &#010      are "Down", "Over", "Selected" "Focused" and "Disabled". Note that "Selected" and&#010      "Focused" are compound states which may be applied in addition to "Down" etc.&#010 </ul>&#010 For example the center piece of a selected stretchImgButton with the mouse hovering&#010 over it might have the URL: <code>"button_Selected_Down_stretch.gif"</code>.&#010 <P>&#010 Media should be present for each possible state of the _start, _end and _stretch images.
    *
    * @param src src Default value is "button.gif"
    */
    public void setSrc(String src) {
        setAttribute("src", src, true);
    }
    /**
     * Base URL for the image.  By default, StretchImgButtons consist of three image parts: A&#010 start image (displayed at the top or left), a scaleable central image and an end image&#010 displayed at the bottom or right.&#010 <P>&#010 The images displayed in the stretchImgButton are derived from this property in the &#010 following way:&#010 <P>&#010 <ul>&#010 <li> When the button is in its standard state the suffixes "_start", "_end" and &#010      "_stretch" are applied to the src (before the file extension), so by default &#010      the images displayed will be "button_start.gif" (sized to be &#010      <code>this.capSize</code> by the specified width of the stretchImgButton), &#010      "button_stretch.gif" (stretched to the necessary width) and "button_end.gif" &#010      (sized the same as the start image).&#010 <li> As the button's state changes, the images will have suffixes appended <b>before</b>&#010      the "_start" / "_end" / "_stretch" to represent the button state. Possible states &#010      are "Down", "Over", "Selected" "Focused" and "Disabled". Note that "Selected" and&#010      "Focused" are compound states which may be applied in addition to "Down" etc.&#010 </ul>&#010 For example the center piece of a selected stretchImgButton with the mouse hovering&#010 over it might have the URL: <code>"button_Selected_Down_stretch.gif"</code>.&#010 <P>&#010 Media should be present for each possible state of the _start, _end and _stretch images.
     *
     *
     * @return String
     *
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    /**
    * Default is a horizontal button.  Vertical StretchImgButtons are allowed, but title text,&#010 if any, will not be automatically rotated.
    *
    * @param vertical vertical Default value is false
    */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical, true);
    }
    /**
     * Default is a horizontal button.  Vertical StretchImgButtons are allowed, but title text,&#010 if any, will not be automatically rotated.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }

    /**
    * How big are the end pieces by default
    *
    * @param capSize capSize Default value is 12
    */
    public void setCapSize(int capSize) {
        setAttribute("capSize", capSize, true);
    }
    /**
     * How big are the end pieces by default
     *
     *
     * @return int
     *
     */
    public int getCapSize()  {
        return getAttributeAsInt("capSize");
    }

    // ********************* Methods ***********************








        /**
         * Select this object.&#010
         */
        public native void select() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.select();
        }-*/;

        /**
         * Select this object.&#010
         */
        public native void deselect() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.deselect();
        }-*/;

        /**
         * Find out if this object is selected&#010
         *
         * @return 
         */
        public native Boolean isSelected() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            var retVal =self.isSelected();
            if(retVal == null || retVal === undefined) {
                return null;
            } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
            }
        }-*/;


        /**
         * Add this widget to the specified mutually exclusive selection group with the ID&#010 passed in.&#010 Selecting this widget will then deselect any other StatefulCanvases with the same&#010 radioGroup ID.&#010 StatefulCanvases can belong to only one radioGroup, so this method will remove from &#010 any other radiogroup of which this button is already a member.&#010
         * @param groupID - ID of the radiogroup to which this widget should be added
         */
        public native void addToRadioGroup(String groupID) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.addToRadioGroup(groupID);
        }-*/;

        /**
         * Remove this widget from the specified mutually exclusive selection group with the ID&#010 passed in.&#010 No-op's if this widget is not a member of the groupID passed in.&#010 If no groupID is passed in, defaults to removing from whatever radioGroup this widget&#010 is a member of.&#010
         */
        public native void removeFromRadioGroup() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.removeFromRadioGroup();
        }-*/;

        /**
         * Remove this widget from the specified mutually exclusive selection group with the ID&#010 passed in.&#010 No-op's if this widget is not a member of the groupID passed in.&#010 If no groupID is passed in, defaults to removing from whatever radioGroup this widget&#010 is a member of.&#010
         * @param groupID - optional radio group ID (to ensure the widget is removed                                        from the appropriate group.
         */
        public native void removeFromRadioGroup(String groupID) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.removeFromRadioGroup(groupID);
        }-*/;




        /**
         * Enable or disable this object&#010
         * @param disabled true if this widget is to be disabled
         */
        public native void setDisabled(boolean disabled) /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setDisabled(disabled);
        }-*/;


        /**
         * This property contains the default 'action' for the Button to fire when activated.&#010
         */
        public native void action() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.action();
        }-*/;

        /**
         * Add a iconClick handler.
         * <p>
         * If this button is showing an {@link com.smartgwt.client.widgets.StretchImgButton#getIcon 'icon'}, a separate click&#010 handler for the icon may be defined as <code>this.iconClick</code>.&#010 Returning false will suppress the standard button click handling code.&#010
         *
         * @param handler the iconClick handler
         * @return {@link HandlerRegistration} used to remove this handler
         */
        public HandlerRegistration addIconClickHandler(com.smartgwt.client.widgets.events.IconClickHandler handler) {
            if(getHandlerCount(com.smartgwt.client.widgets.events.IconClickEvent.getType()) == 0) setupIconClickEvent();
            return doAddHandler(handler, com.smartgwt.client.widgets.events.IconClickEvent.getType());
        }
        private native void setupIconClickEvent() /*-{
            var obj = null;
            var selfJ = this;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({iconClick:function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.IconClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.iconClick = function(){
                    var param = {};
                    var event = @com.smartgwt.client.widgets.events.IconClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

    // ********************* Static Methods ***********************

}





