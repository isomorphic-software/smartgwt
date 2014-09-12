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
 * A Img that behaves like a button, going through up/down/over state transitions in response to user events.  Supports an
 * optional title, and will auto-size to accommodate the title text if <code>overflow</code> is set to "visible". <P>
 * Example uses are Window minimize/close buttons.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ImgButton")
public class ImgButton extends Img implements com.smartgwt.client.widgets.events.HasTitleHoverHandlers {

    public static ImgButton getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new ImgButton(jsObj);
        } else {
            assert refInstance instanceof ImgButton;
            return (ImgButton)refInstance;
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
        $wnd.isc.ImgButton.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.ImgButton.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

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
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#buttons_category_toggle" target="examples">Radio / Toggle Behavior Example</a>
     */
    public void setActionType(SelectionType actionType) {
        setAttribute("actionType", actionType == null ? null : actionType.getValue(), true);
    }

    /**
     * Behavior on state changes -- BUTTON, RADIO or CHECKBOX
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
     * @param baseStyle new base style See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "imgButton"
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
     * If set to true, if the {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title} of this button contains the
     * specified {@link com.smartgwt.client.widgets.Canvas#getAccessKey accessKey}, when the title is displayed to the user it
     * will be modified to include HTML to underline the accessKey.<br> Note that this property may cause titles that include
     * HTML (rather than simple strings) to be inappropriately modified, so should be disabled if your title string includes
     * HTML characters.
     *
     * @param hiliteAccessKey  Default value is null
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
     * If this button is showing an icon should it be right or left aligned?
     *
     * @param iconAlign  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconAlign(String iconAlign)  throws IllegalStateException {
        setAttribute("iconAlign", iconAlign, false);
    }

    /**
     * If this button is showing an icon should it be right or left aligned?
     *
     * @return String
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public String getIconAlign()  {
        return getAttributeAsString("iconAlign");
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
     * Pixels between icon and title text.
     *
     * @param iconSpacing  Default value is 6
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconSpacing(int iconSpacing)  throws IllegalStateException {
        setAttribute("iconSpacing", iconSpacing, false);
    }

    /**
     * Pixels between icon and title text.
     *
     * @return int
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public int getIconSpacing()  {
        return getAttributeAsInt("iconSpacing");
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
     * Horizontal padding to be applied to this widget's label. If this value is null,  the label will be given a horizontal
     * padding of zero. <p> The specified amount of padding is applied to the left and right edges of the button, so the total
     * amount of padding is 2x the specified value.
     *
     * @param labelHPad  Default value is null
     */
    public void setLabelHPad(Integer labelHPad) {
        setAttribute("labelHPad", labelHPad, true);
    }

    /**
     * Horizontal padding to be applied to this widget's label. If this value is null,  the label will be given a horizontal
     * padding of zero. <p> The specified amount of padding is applied to the left and right edges of the button, so the total
     * amount of padding is 2x the specified value.
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
     * @param labelVPad  Default value is null
     */
    public void setLabelVPad(Integer labelVPad) {
        setAttribute("labelVPad", labelVPad, true);
    }

    /**
     * Vertical padding to be applied to this widget's label. If this value is null,  the label will be given a vertial padding
     * of zero. <p> The specified amount of padding is applied to the top and bottom edges of the button, so the total amount
     * of padding is 2x the specified value.
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
     * @param radioGroup  Default value is null
     * @see com.smartgwt.client.docs.State State overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#buttons_category_toggle" target="examples">Radio / Toggle Behavior Example</a>
     */
    public void setRadioGroup(String radioGroup) {
        setAttribute("radioGroup", radioGroup, true);
    }

    /**
     * String identifier for this canvas's mutually exclusive selection group.
     *
     * @return String
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
     * @param selected  Default value is false
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
        Boolean result = getAttributeAsBoolean("selected");
        return result == null ? false : result;
    }
    

    /**
     * If true and the title is clipped, then a hover containing the full title of this button is enabled.
     *
     * @param showClippedTitleOnHover  Default value is false
     */
    public void setShowClippedTitleOnHover(Boolean showClippedTitleOnHover) {
        setAttribute("showClippedTitleOnHover", showClippedTitleOnHover, true);
    }

    /**
     * If true and the title is clipped, then a hover containing the full title of this button is enabled.
     *
     * @return Boolean
     */
    public Boolean getShowClippedTitleOnHover()  {
        Boolean result = getAttributeAsBoolean("showClippedTitleOnHover");
        return result == null ? false : result;
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
        Boolean result = getAttributeAsBoolean("showDisabled");
        return result == null ? true : result;
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
        Boolean result = getAttributeAsBoolean("showDisabledIcon");
        return result == null ? true : result;
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
        Boolean result = getAttributeAsBoolean("showDown");
        return result == null ? false : result;
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
        Boolean result = getAttributeAsBoolean("showDownIcon");
        return result == null ? false : result;
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
        Boolean result = getAttributeAsBoolean("showFocused");
        return result == null ? false : result;
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
        Boolean result = getAttributeAsBoolean("showFocusedIcon");
        return result == null ? false : result;
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
        Boolean result = getAttributeAsBoolean("showRollOver");
        return result == null ? false : result;
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
        Boolean result = getAttributeAsBoolean("showRollOverIcon");
        return result == null ? false : result;
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
        Boolean result = getAttributeAsBoolean("showSelectedIcon");
        return result == null ? false : result;
    }
    

    /**
     * Determines whether any specified {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title} will be  displayed
     * for this component.<br> Applies to Image-based components only, where the title will be rendered out in a label floating
     * over the component
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTitle  Default value is false
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle, true);
    }

    /**
     * Determines whether any specified {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title} will be  displayed
     * for this component.<br> Applies to Image-based components only, where the title will be rendered out in a label floating
     * over the component
     *
     * @return Boolean
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle");
        return result == null ? false : result;
    }
    

    /**
     * The base filename for the image. <P> This value will be combined with any specified {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getState state} to form a combined URL, changing the appearance of the
     * component as the state changes. <P> The following table lists out the standard set of combined URLs that  may be
     * generated. Subclasses may support additional state-derived media of course. Note that the src URL will be split such
     * that the extension is always applied to the end of the combined string. For example in the following table, if
     * <code>src</code> was set to <code>"blank.gif"</code>, the Selected+Focused URL would be 
     * <code>"blank_Selected_Focused.gif"</code>. <table> <tr><td><b>URL for Img
     * source</b></td><td><b>Description</b></td></tr> <tr><td><code><i>src</i>+<i>extension</i></code></td><td>Default
     * URL</td></tr> <tr><td><code><i>src</i>+"_Selected"+<i>extension</i></code></td>      <td>Applied when {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} is set to true</td></tr>
     * <tr><td><code><i>src</i>+"_Focused"+<i>extension</i></code></td>      <td>Applied when the component has keyboard focus,
     * if       {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocused showFocused} is true, and       {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is not true.</td></tr>
     * <tr><td><code><i>src</i>+"_Over"+<i>extension</i></code></td>      <td>Applied when the user rolls over the component if
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver showRollOver} is set to true</td></tr>
     * <tr><td><code><i>src</i>+"_Down"+<i>extension</i></code></td>      <td>Applied when the user presses the mouse button
     * over over the component if          {@link com.smartgwt.client.widgets.StatefulCanvas#getShowDown showDown} is set to
     * true</td></tr> <tr><td><code><i>src</i>+"_Disabled"+<i>extension</i></code></td>      <td>Applied to {@link
     * com.smartgwt.client.widgets.Canvas#getDisabled disabled} component       if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDisabled showDisabled} is true.</td></tr> <tr><td
     * colspan=2><i>Combined states</i></td></tr> <tr><td><code><i>src</i>+"_Selected_Focused"+<i>extension</i></code></td>    
     * <td>Combined Selected and focused state</td></tr> <tr><td><code><i>src</i>+"_Selected_Over"+<i>extension</i></code></td>
     * <td>Combined Selected and rollOver state</td></tr> <tr><td><code><i>src</i>+"_Focused_Over"+<i>extension</i></code></td>
     * <td>Combined Focused and rollOver state</td></tr>
     * <tr><td><code><i>src</i>+"_Selected_Focused_Over"+<i>extension</i></code></td>      <td>Combined Selected, Focused and
     * rollOver state</td></tr> <tr><td><code><i>src</i>+"_Selected_Down"+<i>extension</i></code></td>      <td>Combined
     * Selected and mouse-down state</td></tr> <tr><td><code><i>src</i>+"_Focused_Down"+<i>extension</i></code></td>     
     * <td>Combined Focused and mouse-down state</td></tr>
     * <tr><td><code><i>src</i>+"_Selected_Focused_Down"+<i>extension</i></code></td>      <td>Combined Selected, Focused and
     * mouse-down state</td></tr> <tr><td><code><i>src</i>+"_Selected_Disabled"+<i>extension</i></code></td>      <td>Combined
     * Selected and Disabled state</td></tr> </table>
     *
     * @param src  See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} . Default value is "[SKIN]/ImgButton/button.png"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#buttons_category_appearance" target="examples">Appearance Example</a>
     */
    public void setSrc(String src) {
        setAttribute("src", src, true);
    }

    /**
     * The base filename for the image. <P> This value will be combined with any specified {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getState state} to form a combined URL, changing the appearance of the
     * component as the state changes. <P> The following table lists out the standard set of combined URLs that  may be
     * generated. Subclasses may support additional state-derived media of course. Note that the src URL will be split such
     * that the extension is always applied to the end of the combined string. For example in the following table, if
     * <code>src</code> was set to <code>"blank.gif"</code>, the Selected+Focused URL would be 
     * <code>"blank_Selected_Focused.gif"</code>. <table> <tr><td><b>URL for Img
     * source</b></td><td><b>Description</b></td></tr> <tr><td><code><i>src</i>+<i>extension</i></code></td><td>Default
     * URL</td></tr> <tr><td><code><i>src</i>+"_Selected"+<i>extension</i></code></td>      <td>Applied when {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} is set to true</td></tr>
     * <tr><td><code><i>src</i>+"_Focused"+<i>extension</i></code></td>      <td>Applied when the component has keyboard focus,
     * if       {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocused showFocused} is true, and       {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is not true.</td></tr>
     * <tr><td><code><i>src</i>+"_Over"+<i>extension</i></code></td>      <td>Applied when the user rolls over the component if
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver showRollOver} is set to true</td></tr>
     * <tr><td><code><i>src</i>+"_Down"+<i>extension</i></code></td>      <td>Applied when the user presses the mouse button
     * over over the component if          {@link com.smartgwt.client.widgets.StatefulCanvas#getShowDown showDown} is set to
     * true</td></tr> <tr><td><code><i>src</i>+"_Disabled"+<i>extension</i></code></td>      <td>Applied to {@link
     * com.smartgwt.client.widgets.Canvas#getDisabled disabled} component       if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDisabled showDisabled} is true.</td></tr> <tr><td
     * colspan=2><i>Combined states</i></td></tr> <tr><td><code><i>src</i>+"_Selected_Focused"+<i>extension</i></code></td>    
     * <td>Combined Selected and focused state</td></tr> <tr><td><code><i>src</i>+"_Selected_Over"+<i>extension</i></code></td>
     * <td>Combined Selected and rollOver state</td></tr> <tr><td><code><i>src</i>+"_Focused_Over"+<i>extension</i></code></td>
     * <td>Combined Focused and rollOver state</td></tr>
     * <tr><td><code><i>src</i>+"_Selected_Focused_Over"+<i>extension</i></code></td>      <td>Combined Selected, Focused and
     * rollOver state</td></tr> <tr><td><code><i>src</i>+"_Selected_Down"+<i>extension</i></code></td>      <td>Combined
     * Selected and mouse-down state</td></tr> <tr><td><code><i>src</i>+"_Focused_Down"+<i>extension</i></code></td>     
     * <td>Combined Focused and mouse-down state</td></tr>
     * <tr><td><code><i>src</i>+"_Selected_Focused_Down"+<i>extension</i></code></td>      <td>Combined Selected, Focused and
     * mouse-down state</td></tr> <tr><td><code><i>src</i>+"_Selected_Disabled"+<i>extension</i></code></td>      <td>Combined
     * Selected and Disabled state</td></tr> </table>
     *
     * @return  See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#buttons_category_appearance" target="examples">Appearance Example</a>
     */
    public String getSrc()  {
        return getAttributeAsString("src");
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
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public native void addToRadioGroup(String groupID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addToRadioGroup(groupID);
    }-*/;


	/**
     * Select this object.
     * @see com.smartgwt.client.docs.State State overview and related methods
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



	/**
     * Enable or disable this object
     * @param disabled true if this widget is to be disabled
     * @see com.smartgwt.client.docs.Enable Enable overview and related methods
     */
    public native void setDisabled(boolean disabled) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setDisabled(disabled == null ? false : disabled);
    }-*/;


	/**
     * Is the title of this button clipped?
     *
     * @return whether the title is clipped.
     */
    public native boolean titleClipped() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.titleClipped();
        return ret;
    }-*/;

    /**
     * Add a titleHover handler.
     * <p>
     * Optional stringMethod to fire when the user hovers over this button and the title is clipped. If {@link
     * com.smartgwt.client.widgets.ImgButton#getShowClippedTitleOnHover showClippedTitleOnHover} is true, the default behavior
     * is to show a hover canvas containing the HTML returned by {@link com.smartgwt.client.widgets.ImgButton#titleHoverHTML
     * ImgButton.titleHoverHTML}. Call {@link com.smartgwt.client.widgets.events.TitleHoverEvent#cancel()} from within {@link
     * com.smartgwt.client.widgets.events.TitleHoverHandler#onTitleHover} to suppress this default behavior.
     *
     * @param handler the titleHover handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addTitleHoverHandler(com.smartgwt.client.widgets.events.TitleHoverHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.TitleHoverEvent.getType()) == 0) setupTitleHoverEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.TitleHoverEvent.getType());
    }

    private native void setupTitleHoverEvent() /*-{
        var obj = null;
        var selfJ = this;
        var titleHover = $debox($entry(function(param){
                var event = @com.smartgwt.client.widgets.events.TitleHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                return !ret;
            }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({titleHover: 
                function () {
                    var param = {};
                    return titleHover(param) == true;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.titleHover = 
                function () {
                    var param = {};
                    return titleHover(param) == true;
                }
            ;
        }
   }-*/;


	/**
     * Returns the HTML that is displayed by the default {@link com.smartgwt.client.widgets.ImgButton#addTitleHoverHandler
     * titleHover} handler. Return null or an empty string to cancel the hover. <p>Use <code>setTitleHoverFormatter()</code> to
     * provide a custom implementation.
     * @param defaultHTML the HTML that would have been displayed by default. See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     *
     * @return HTML to be displayed in the hover. If null or an empty string, then the hover is canceled.
     */
    public native String titleHoverHTML(String defaultHTML) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.titleHoverHTML(defaultHTML);
        return ret;
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
     * @param imgButtonProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(ImgButton imgButtonProperties) /*-{
    	var properties = $wnd.isc.addProperties({},imgButtonProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.ImgButton.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Provide a custom implementation of {@link #titleHoverHTML(java.lang.String)}.
     */
    public native void setTitleHoverFormatter(TitleHoverFormatter formatter) /*-{
        var self;
        if (this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        var newTitleHoverHTMLFun;
        if (formatter == null) {
            newTitleHoverHTMLFun = $wnd.isc[this.@com.smartgwt.client.widgets.BaseWidget::scClassName].getInstanceProperty("titleHoverHTML");
        } else {
            newTitleHoverHTMLFun = $entry(function (defaultHTML) {
                return formatter.@com.smartgwt.client.widgets.TitleHoverFormatter::getHoverHTML(Ljava/lang/String;)(defaultHTML);
            });
        }
        self.titleHoverHTML = newTitleHoverHTMLFun;
    }-*/;

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
            s.showClippedTitleOnHover = getAttributeAsString("showClippedTitleOnHover");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgButton.showClippedTitleOnHover:" + t.getMessage() + "\n";
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

