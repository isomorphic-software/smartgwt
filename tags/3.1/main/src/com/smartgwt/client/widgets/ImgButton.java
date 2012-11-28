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
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * A Img that behaves like a button, going through up/down/over state transitions in response to user events.  Supports an
 * optional title, and will auto-size to accommodate the title text if <code>overflow</code> is set to "visible". <P> An
 * examples of use is Window minimize/close buttons.
 */
public class ImgButton extends Img {

    public native static ImgButton getOrCreateRef(JavaScriptObject jsObj) /*-{

    	if(jsObj == null) return null;
    	
    	var instance = jsObj["__ref"];
    	
    	if(instance==undefined) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("ImgButton",jsObj);
        } else if(instance != null) {
            return instance;
        //} else {
        //    return @com.smartgwt.client.widgets.ImgButton::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }


    public ImgButton(){
        scClassName = "ImgButton";
    }

    public ImgButton(JavaScriptObject jsObj){
        scClassName = "ImgButton";
        setJavaScriptObject(jsObj);
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
     * Behavior on state changes -- BUTTON, RADIO or CHECKBOX
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the 'actionType' for this canvas (radio / checkbox / button) If the canvas is currently selected, and the passed in actionType is 'button' this method will deselect the canvas.
     *
     * @param actionType actionType Default value is "button"
     * @see com.smartgwt.client.docs.State State overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#buttons_category_toggle" target="examples">Radio / Toggle Behavior Example</a>
     */
    public void setActionType(SelectionType actionType) {
        setAttribute("actionType", actionType == null ? null : actionType.getValue(), true);
    }

    /**
     * Behavior on state changes -- BUTTON, RADIO or CHECKBOX
     *
     *
     * @return Return the 'actionType' for this canvas (radio / checkbox / button)
     * @see com.smartgwt.client.docs.State State overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#buttons_category_toggle" target="examples">Radio / Toggle Behavior Example</a>
     */
    public SelectionType getActionType()  {
        return EnumUtil.getEnum(SelectionType.values(), getAttribute("actionType"));
    }

    /**
     * Horizontal alignment of this component's title.
     *
     * @param align align Default value is Canvas.CENTER
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align == null ? null : align.getValue(), true);
    }

    /**
     * Horizontal alignment of this component's title.
     *
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
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Boolean getAutoFit()  {
        return getAttributeAsBoolean("autoFit");
    }

    /**
     * Base CSS style.  As the component changes state and/or is selected, suffixes will be added to the base style. <P> When
     * the component changes state (eg becomes disabled), a suffix will be appended to this style name, reflecting the
     * following states: "Over", "Down", or "Disabled". <P> If the widget is selected, the suffixes will be "Selected",
     * "SelectedOver", etc. <P> If the widget has focus and {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocused
     * showFocused} is true, and {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is
     * false, the suffixes will be "Focused", "FocusedOver", etc, or if the widget is both selected and focused,
     * "SelectedFocused", "SelectedFocusedOver", etc. <P> For example, if <code>baseStyle</code> is set to "button", this
     * component is {@link com.smartgwt.client.widgets.ImgButton#isSelected selected} and the mouse cursor is over this
     * component, the style "buttonSelectedOver" will be used.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the base CSS style.  As the component changes state and/or is selected, suffixes will be added to the base style.
     *
     * @param baseStyle new base style. See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}. Default value is "imgButton"
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * Base CSS style.  As the component changes state and/or is selected, suffixes will be added to the base style. <P> When
     * the component changes state (eg becomes disabled), a suffix will be appended to this style name, reflecting the
     * following states: "Over", "Down", or "Disabled". <P> If the widget is selected, the suffixes will be "Selected",
     * "SelectedOver", etc. <P> If the widget has focus and {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocused
     * showFocused} is true, and {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is
     * false, the suffixes will be "Focused", "FocusedOver", etc, or if the widget is both selected and focused,
     * "SelectedFocused", "SelectedFocusedOver", etc. <P> For example, if <code>baseStyle</code> is set to "button", this
     * component is {@link com.smartgwt.client.widgets.ImgButton#isSelected selected} and the mouse cursor is over this
     * component, the style "buttonSelectedOver" will be used.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }

    /**
     * If set to true, if the {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title} of this button contains the
     * specified {@link com.smartgwt.client.widgets.Canvas#getAccessKey accessKey}, when the title is displayed to the user it
     * will be modified to include HTML to underline the accessKey.<br> Note that this property may cause titles that include
     * HTML (rather than simple strings) to be inappropriately modified, so should be disabled if your title string includes
     * HTML characters.
     *
     * @param hiliteAccessKey hiliteAccessKey Default value is null
     */
    public void setHiliteAccessKey(Boolean hiliteAccessKey) {
        setAttribute("hiliteAccessKey", hiliteAccessKey, true);
    }

    /**
     * If set to true, if the {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title} of this button contains the
     * specified {@link com.smartgwt.client.widgets.Canvas#getAccessKey accessKey}, when the title is displayed to the user it
     * will be modified to include HTML to underline the accessKey.<br> Note that this property may cause titles that include
     * HTML (rather than simple strings) to be inappropriately modified, so should be disabled if your title string includes
     * HTML characters.
     *
     *
     * @return Boolean
     */
    public Boolean getHiliteAccessKey()  {
        return getAttributeAsBoolean("hiliteAccessKey");
    }

    /**
     * Optional icon to be shown with the button title text.   <P> Specify as the partial URL to an image, relative to the
     * imgDir of this component.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the icon being shown next to the title text.
     *
     * @param icon URL of new icon. See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is null
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon, true);
    }

    /**
     * Optional icon to be shown with the button title text.   <P> Specify as the partial URL to an image, relative to the
     * imgDir of this component.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }

    /**
     * If this button is showing an icon should it be right or left aligned?
     *
     * @param iconAlign . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconAlign(String iconAlign)  throws IllegalStateException {
        setAttribute("iconAlign", iconAlign, false);
    }

    /**
     * If this button is showing an icon should it be right or left aligned?
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public String getIconAlign()  {
        return getAttributeAsString("iconAlign");
    }

    /**
     * Height in pixels of the icon image. <P> If unset, defaults to <code>iconSize</code>
     *
     * @param iconHeight iconHeight Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconHeight(Integer iconHeight)  throws IllegalStateException {
        setAttribute("iconHeight", iconHeight, false);
    }

    /**
     * Height in pixels of the icon image. <P> If unset, defaults to <code>iconSize</code>
     *
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
     * @param iconOrientation The new orientation of the icon relative to the text of the button.. See {@link com.smartgwt.client.docs.String String}. Default value is "left"
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
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public String getIconOrientation()  {
        return getAttributeAsString("iconOrientation");
    }

    /**
     * Size in pixels of the icon image. <P> The <code>iconWidth</code> and <code>iconHeight</code> properties can be used to
     * configure width and height separately.
     *
     * @param iconSize iconSize Default value is 16
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconSize(int iconSize)  throws IllegalStateException {
        setAttribute("iconSize", iconSize, false);
    }

    /**
     * Size in pixels of the icon image. <P> The <code>iconWidth</code> and <code>iconHeight</code> properties can be used to
     * configure width and height separately.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public int getIconSize()  {
        return getAttributeAsInt("iconSize");
    }

    /**
     * Pixels between icon and title text.
     *
     * @param iconSpacing iconSpacing Default value is 6
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconSpacing(int iconSpacing)  throws IllegalStateException {
        setAttribute("iconSpacing", iconSpacing, false);
    }

    /**
     * Pixels between icon and title text.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public int getIconSpacing()  {
        return getAttributeAsInt("iconSpacing");
    }

    /**
     * Width in pixels of the icon image. <P> If unset, defaults to <code>iconSize</code>
     *
     * @param iconWidth iconWidth Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconWidth(Integer iconWidth)  throws IllegalStateException {
        setAttribute("iconWidth", iconWidth, false);
    }

    /**
     * Width in pixels of the icon image. <P> If unset, defaults to <code>iconSize</code>
     *
     *
     * @return Integer
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Integer getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }

    /**
     * Horizontal padding to be applied to this widget's label. If this value is null,  the label will be given a horizontal
     * padding of zero. <p> The specified amount of padding is applied to the left and right edges of the button, so the total
     * amount of padding is 2x the specified value.
     *
     * @param labelHPad labelHPad Default value is null
     */
    public void setLabelHPad(Integer labelHPad) {
        setAttribute("labelHPad", labelHPad, true);
    }

    /**
     * Horizontal padding to be applied to this widget's label. If this value is null,  the label will be given a horizontal
     * padding of zero. <p> The specified amount of padding is applied to the left and right edges of the button, so the total
     * amount of padding is 2x the specified value.
     *
     *
     * @return Integer
     */
    public Integer getLabelHPad()  {
        return getAttributeAsInt("labelHPad");
    }

    /**
     * Vertical padding to be applied to this widget's label. If this value is null,  the label will be given a vertial padding
     * of zero. <p> The specified amount of padding is applied to the top and bottom edges of the button, so the total amount
     * of padding is 2x the specified value.
     *
     * @param labelVPad labelVPad Default value is null
     */
    public void setLabelVPad(Integer labelVPad) {
        setAttribute("labelVPad", labelVPad, true);
    }

    /**
     * Vertical padding to be applied to this widget's label. If this value is null,  the label will be given a vertial padding
     * of zero. <p> The specified amount of padding is applied to the top and bottom edges of the button, so the total amount
     * of padding is 2x the specified value.
     *
     *
     * @return Integer
     */
    public Integer getLabelVPad()  {
        return getAttributeAsInt("labelVPad");
    }

    /**
     * String identifier for this canvas's mutually exclusive selection group.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param radioGroup . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.docs.State State overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#buttons_category_toggle" target="examples">Radio / Toggle Behavior Example</a>
     */
    public void setRadioGroup(String radioGroup) {
        setAttribute("radioGroup", radioGroup, true);
    }

    /**
     * String identifier for this canvas's mutually exclusive selection group.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.docs.State State overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#buttons_category_toggle" target="examples">Radio / Toggle Behavior Example</a>
     */
    public String getRadioGroup()  {
        return getAttributeAsString("radioGroup");
    }

    /**
     * Whether this component is selected.  For some components, selection affects appearance.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Select this object.
     *
     * @param selected selected Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setSelected(Boolean selected) {
        setAttribute("selected", selected, true);
    }

    /**
     * Whether this component is selected.  For some components, selection affects appearance.
     *
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
     * @param showDisabled showDisabled Default value is true
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setShowDisabled(Boolean showDisabled) {
        setAttribute("showDisabled", showDisabled, true);
    }

    /**
     * Should we visibly change state when disabled?
     *
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
     * @param showDisabledIcon showDisabledIcon Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowDisabledIcon(Boolean showDisabledIcon)  throws IllegalStateException {
        setAttribute("showDisabledIcon", showDisabledIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes disabled.
     *
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
     * @param showDown showDown Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setShowDown(Boolean showDown) {
        setAttribute("showDown", showDown, true);
    }

    /**
     * Should we visibly change state when the mouse goes down in this object?
     *
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
     * @param showDownIcon showDownIcon Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowDownIcon(Boolean showDownIcon)  throws IllegalStateException {
        setAttribute("showDownIcon", showDownIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes down on the button.
     *
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
     * @param showFocused showFocused Default value is false
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
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowFocused()  {
        return getAttributeAsBoolean("showFocused");
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button receives focus. <P> If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is true, the <code>"Over"</code> icon
     * will be displayed when the canvas has focus, otherwise a separate <code>"Focused"</code> icon will be displayed
     *
     * @param showFocusedIcon showFocusedIcon Default value is false
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
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowFocusedIcon()  {
        return getAttributeAsBoolean("showFocusedIcon");
    }

    /**
     * Should we visibly change state when the mouse goes over this object?
     *
     * @param showRollOver showRollOver Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setShowRollOver(Boolean showRollOver) {
        setAttribute("showRollOver", showRollOver, true);
    }

    /**
     * Should we visibly change state when the mouse goes over this object?
     *
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
     * @param showRollOverIcon showRollOverIcon Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowRollOverIcon(Boolean showRollOverIcon)  throws IllegalStateException {
        setAttribute("showRollOverIcon", showRollOverIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image on mouse rollover.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowRollOverIcon()  {
        return getAttributeAsBoolean("showRollOverIcon");
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     * @param showSelectedIcon showSelectedIcon Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowSelectedIcon(Boolean showSelectedIcon)  throws IllegalStateException {
        setAttribute("showSelectedIcon", showSelectedIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowSelectedIcon()  {
        return getAttributeAsBoolean("showSelectedIcon");
    }

    /**
     * Determines whether any specified {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title} will be  displayed
     * for this component.<br> Applies to Image-based components only, where the title will be rendered out in a label floating
     * over the component
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTitle showTitle Default value is false
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle, true);
    }

    /**
     * Determines whether any specified {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title} will be  displayed
     * for this component.<br> Applies to Image-based components only, where the title will be rendered out in a label floating
     * over the component
     *
     *
     * @return Boolean
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }

    /**
     * The base filename for the image. <P> If <code>img.state</code> is set, it's value will be appended to the URL before the
     * file extension.   <P> For example, given an <code>src</code> of "findIcon.gif" and a state of "Disabled", the resulting
     * image name would be "findIcon_Disabled.gif".  Compound states such as "Selected", "Focused" and "Over" or "Down" will
     * have an intervening underscore, resulting in, for example, <code>"findIcon_Selected_Down.gif"</code>.
     *
     * @param src . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is "[SKIN]/ImgButton/button.png"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#buttons_category_appearance" target="examples">Appearance Example</a>
     */
    public void setSrc(String src) {
        setAttribute("src", src, true);
    }

    /**
     * The base filename for the image. <P> If <code>img.state</code> is set, it's value will be appended to the URL before the
     * file extension.   <P> For example, given an <code>src</code> of "findIcon.gif" and a state of "Disabled", the resulting
     * image name would be "findIcon_Disabled.gif".  Compound states such as "Selected", "Focused" and "Over" or "Down" will
     * have an intervening underscore, resulting in, for example, <code>"findIcon_Selected_Down.gif"</code>.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#buttons_category_appearance" target="examples">Appearance Example</a>
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    /**
     * Current "state" of this widget. StatefulCanvases will have a different appearance based on their current state. By
     * default this is handled by changing the css className applied to the StatefulCanvas - see {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle baseStyle} for a description of how this is done.<P> For {@link
     * com.smartgwt.client.widgets.Img} or {@link com.smartgwt.client.widgets.StretchImg} based subclasses of StatefulCanvas,
     * the  appearance may also be updated by changing the src of the rendered image. See {@link
     * com.smartgwt.client.widgets.Img#getSrc src} and {@link com.smartgwt.client.widgets.StretchImgButton#getSrc src} for a
     * description of how the URL  is modified to reflect the state of the widget in this case.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the 'state' of this object, this changes it's appearance.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param state new state. Default value is ""
     * @see com.smartgwt.client.types.State
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setState(State state) {
        setAttribute("state", state == null ? null : state.getValue(), true);
    }

    /**
     * Current "state" of this widget. StatefulCanvases will have a different appearance based on their current state. By
     * default this is handled by changing the css className applied to the StatefulCanvas - see {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle baseStyle} for a description of how this is done.<P> For {@link
     * com.smartgwt.client.widgets.Img} or {@link com.smartgwt.client.widgets.StretchImg} based subclasses of StatefulCanvas,
     * the  appearance may also be updated by changing the src of the rendered image. See {@link
     * com.smartgwt.client.widgets.Img#getSrc src} and {@link com.smartgwt.client.widgets.StretchImgButton#getSrc src} for a
     * description of how the URL  is modified to reflect the state of the widget in this case.
     *
     *
     * @return Return the state of this StatefulCanvas
     * @see com.smartgwt.client.types.State
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public State getState()  {
        return EnumUtil.getEnum(State.values(), getAttribute("state"));
    }

    /**
     * The text title to display in this button.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the title.
     *
     * @param title new title. See {@link com.smartgwt.client.docs.HTMLString HTMLString}. Default value is varies
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * The text title to display in this button.
     *
     *
     * @return Return the title - text/HTML drawn inside the component. <p> Default is to simply return this.title.. See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    /**
     * Vertical alignment of this component's title.
     *
     * @param valign valign Default value is Canvas.CENTER
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setValign(VerticalAlignment valign) {
        setAttribute("valign", valign == null ? null : valign.getValue(), true);
    }

    /**
     * Vertical alignment of this component's title.
     *
     *
     * @return VerticalAlignment
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public VerticalAlignment getValign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("valign"));
    }

    // ********************* Methods ***********************

    /**
     * This property contains the default 'action' for the Button to fire when activated.
     */
    public native void action() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.action();
    }-*/;

    /**
     * Add this widget to the specified mutually exclusive selection group with the ID passed in. Selecting this widget will
     * then deselect any other StatefulCanvases with the same radioGroup ID. StatefulCanvases can belong to only one
     * radioGroup, so this method will remove from  any other radiogroup of which this button is already a member.
     * @param groupID - ID of the radiogroup to which this widget should be added
     */
    public native void addToRadioGroup(String groupID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addToRadioGroup(groupID);
    }-*/;

    /**
     * Select this object.
     */
    public native void deselect() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselect();
    }-*/;

    /**
     * Find out if this object is selected
     *
     * @return 
     * @see com.smartgwt.client.docs.State State overview and related methods
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
     * Remove this widget from the specified mutually exclusive selection group with the ID passed in. No-op's if this widget
     * is not a member of the groupID passed in. If no groupID is passed in, defaults to removing from whatever radioGroup this
     * widget is a member of.
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
     */
    public native void select() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.select();
    }-*/;

    /**
     * Enable or disable this object
     * @param disabled true if this widget is to be disabled
     */
    public native void setDisabled(boolean disabled) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setDisabled(disabled);
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript). 
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param imgButtonProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(ImgButton imgButtonProperties) /*-{
    	var properties = $wnd.isc.addProperties({},imgButtonProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.ImgButton.addProperties(properties);
    }-*/;
        
    // ***********************************************************        

    public LogicalStructureObject setLogicalStructure(ImgButtonLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.actionType = getAttributeAsString("actionType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.actionType:" + t.getMessage() + "\n";
        }
        try {
            s.align = getAttributeAsString("align");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.align:" + t.getMessage() + "\n";
        }
        try {
            s.autoFit = getAttributeAsString("autoFit");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.autoFit:" + t.getMessage() + "\n";
        }
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteAccessKey = getAttributeAsString("hiliteAccessKey");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.hiliteAccessKey:" + t.getMessage() + "\n";
        }
        try {
            s.icon = getAttributeAsString("icon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.icon:" + t.getMessage() + "\n";
        }
        try {
            s.iconAlign = getAttributeAsString("iconAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.iconAlign:" + t.getMessage() + "\n";
        }
        try {
            s.iconHeight = getAttributeAsString("iconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.iconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.iconOrientation = getAttributeAsString("iconOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.iconOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.iconSize = getAttributeAsString("iconSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.iconSize:" + t.getMessage() + "\n";
        }
        try {
            s.iconSpacing = getAttributeAsString("iconSpacing");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.iconSpacing:" + t.getMessage() + "\n";
        }
        try {
            s.iconWidth = getAttributeAsString("iconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.iconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.labelHPad = getAttributeAsString("labelHPad");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.labelHPad:" + t.getMessage() + "\n";
        }
        try {
            s.labelVPad = getAttributeAsString("labelVPad");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.labelVPad:" + t.getMessage() + "\n";
        }
        try {
            s.radioGroup = getAttributeAsString("radioGroup");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.radioGroup:" + t.getMessage() + "\n";
        }
        try {
            s.selected = getAttributeAsString("selected");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.selected:" + t.getMessage() + "\n";
        }
        try {
            s.showDisabled = getAttributeAsString("showDisabled");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.showDisabled:" + t.getMessage() + "\n";
        }
        try {
            s.showDisabledIcon = getAttributeAsString("showDisabledIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.showDisabledIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showDown = getAttributeAsString("showDown");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.showDown:" + t.getMessage() + "\n";
        }
        try {
            s.showDownIcon = getAttributeAsString("showDownIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.showDownIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showFocused = getAttributeAsString("showFocused");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.showFocused:" + t.getMessage() + "\n";
        }
        try {
            s.showFocusedIcon = getAttributeAsString("showFocusedIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.showFocusedIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showRollOver = getAttributeAsString("showRollOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.showRollOver:" + t.getMessage() + "\n";
        }
        try {
            s.showRollOverIcon = getAttributeAsString("showRollOverIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.showRollOverIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showSelectedIcon = getAttributeAsString("showSelectedIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.showSelectedIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showTitle = getAttributeAsString("showTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.showTitle:" + t.getMessage() + "\n";
        }
        try {
            s.src = getAttributeAsString("src");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.src:" + t.getMessage() + "\n";
        }
        try {
            s.state = getAttributeAsString("state");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.state:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.title:" + t.getMessage() + "\n";
        }
        try {
            s.valign = getAttributeAsString("valign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.valign:" + t.getMessage() + "\n";
        }
        return s;
    }
    
    public LogicalStructureObject getLogicalStructure() {
        ImgButtonLogicalStructure s = new ImgButtonLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

