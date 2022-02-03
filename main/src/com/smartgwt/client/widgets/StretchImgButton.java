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
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
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
import com.smartgwt.client.util.events.*;
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
import com.smartgwt.logicalstructure.widgets.ace.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * A StretchImg that behaves like a button, going through up/down/over state transitions in response to user events. 
 * Supports an optional title, and will auto-size to accommodate the title text if <code>overflow</code> is set to
 * "visible". <P> Examples of use include fancy buttons, poplist headers, and tabs.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("StretchImgButton")
public class StretchImgButton extends StretchImg implements com.smartgwt.client.widgets.events.HasIconClickHandlers, com.smartgwt.client.widgets.events.HasTitleHoverHandlers {

    public static StretchImgButton getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new StretchImgButton(jsObj);
        } else {
            assert refInstance instanceof StretchImgButton;
            return (StretchImgButton)refInstance;
        }
    }
        


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(StretchImgButton.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.StretchImgButton.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(StretchImgButton.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.StretchImgButton.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public StretchImgButton(){
        scClassName = "StretchImgButton";
    }

    public StretchImgButton(JavaScriptObject jsObj){
        scClassName = "StretchImgButton";
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
     * @param actionType New actionType value. Default value is "button"
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setActionType(SelectionType actionType) {
        setAttribute("actionType", actionType == null ? null : actionType.getValue(), true);
    }

    /**
     * Behavior on state changes -- BUTTON, RADIO or CHECKBOX
     *
     * @return Return the 'actionType' for this canvas (radio / checkbox / button). Default value is "button"
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public SelectionType getActionType()  {
        return EnumUtil.getEnum(SelectionType.values(), getAttribute("actionType"));
    }
    

    /**
     * Horizontal alignment of this component's title.
     *
     * @param align New align value. Default value is Canvas.CENTER
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align == null ? null : align.getValue(), true);
    }

    /**
     * Horizontal alignment of this component's title.
     *
     * @return Current align value. Default value is Canvas.CENTER
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
     * Setter method for the {@link com.smartgwt.client.widgets.StatefulCanvas#getAutoFit StatefulCanvas.autoFit} property. Pass in true or false to turn autoFit on or off. When autoFit is set to <code>false</code>, canvas will be resized to it's previously specified size.
     *
     * @param autoFit New autoFit setting. Default value is null
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
     * @return Current autoFit value. Default value is null
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Boolean getAutoFit()  {
        return getAttributeAsBoolean("autoFit");
    }
    

    /**
     * Base CSS style className applied to the component. 
     *  <P>
     * As the component changes {@link com.smartgwt.client.widgets.StatefulCanvas#getState StatefulCanvas.state} and/or is
     * selected, 
     *  suffixes will be added to the base style. In some cases more than one suffix will 
     *  be appended to reflect a combined state ("Selected" + "Disabled", for example).
     *  <P>
     * See {@link com.smartgwt.client.widgets.StatefulCanvas#getStateSuffix StatefulCanvas.getStateSuffix()} for a description
     * of the default set
     *  of suffixes which may be applied to the baseStyle
     *  <P>
     *  <h4>Rotated Titles</h4>
     *  <p>
     *  The Framework doesn't have built-in support for rotating button titles in a fashion
     * similar to {@link com.smartgwt.client.widgets.chart.FacetChart#getRotateLabels FacetChart.rotateLabels}.  However, you
     * can manually configure
     *  a button to render with a rotated title by applying custom CSS via this property.
     *  <P>
     *  For example, given a button with a height of 120 and a width of 48, if you
     *  copied the existing buttonXXX style declarations from skin_styles.css as new,
     *  rotatedTitleButtonXXX declarations, and then added the lines:
     *  <pre>
     *      -ms-transform:     translate(-38px,0px) rotate(270deg);
     *      -webkit-transform: translate(-38px,0px) rotate(270deg);
     *      transform:         translate(-38px,0px) rotate(270deg);
     *      overflow: hidden;
     *      text-overflow: ellipsis;
     *      width:116px;</pre>
     *  in the declaration section beginning:
     *  <pre>
     *  .rotatedTitleButton,
     *  .rotatedTitleButtonSelected,
     *  .rotatedTitleButtonSelectedOver,
     *  .rotatedTitleButtonSelectedDown,
     *  .rotatedTitleButtonSelectedDisabled,
     *  .rotatedTitleButtonOver,
     *  .rotatedTitleButtonDown,
     *  .rotatedTitleButtonDisabled {</pre>
     *  then applying that style to the button with {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow}: "clip_h"
     *  would yield a vertically-rendered title with overflow via ellipsis as expected, and also
     *  wrap with {@link com.smartgwt.client.widgets.Button#getWrap Button.wrap}.
     *  
     *  Note that:<ul>
     *  <li> The explicit width applied via CSS is needed because rotated
     *  elements don't inherit dimensions in their new orientation from the DOM - 
     *  the transform/rotation occurs independently of layout.
     *  <li> The translation transform required along the x-axis is roughly
     *  (width - height) / 2, but may need slight offsetting for optimal centering.
     *  <li>We've explicitly avoided describing an approach based on CSS "writing-mode", since
     *  support is incomplete and bugs are present in popular browsers such as Firefox and
     *  Safari that would prevent it from being used without Framework assistance.</ul>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the base CSS style.  As the component changes state and/or is selected, suffixes will be added to the base style.
     *
     * @param baseStyle new base style. Default value is "stretchImgButton"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle, true);
    }

    /**
     * Base CSS style className applied to the component. 
     *  <P>
     * As the component changes {@link com.smartgwt.client.widgets.StatefulCanvas#getState StatefulCanvas.state} and/or is
     * selected, 
     *  suffixes will be added to the base style. In some cases more than one suffix will 
     *  be appended to reflect a combined state ("Selected" + "Disabled", for example).
     *  <P>
     * See {@link com.smartgwt.client.widgets.StatefulCanvas#getStateSuffix StatefulCanvas.getStateSuffix()} for a description
     * of the default set
     *  of suffixes which may be applied to the baseStyle
     *  <P>
     *  <h4>Rotated Titles</h4>
     *  <p>
     *  The Framework doesn't have built-in support for rotating button titles in a fashion
     * similar to {@link com.smartgwt.client.widgets.chart.FacetChart#getRotateLabels FacetChart.rotateLabels}.  However, you
     * can manually configure
     *  a button to render with a rotated title by applying custom CSS via this property.
     *  <P>
     *  For example, given a button with a height of 120 and a width of 48, if you
     *  copied the existing buttonXXX style declarations from skin_styles.css as new,
     *  rotatedTitleButtonXXX declarations, and then added the lines:
     *  <pre>
     *      -ms-transform:     translate(-38px,0px) rotate(270deg);
     *      -webkit-transform: translate(-38px,0px) rotate(270deg);
     *      transform:         translate(-38px,0px) rotate(270deg);
     *      overflow: hidden;
     *      text-overflow: ellipsis;
     *      width:116px;</pre>
     *  in the declaration section beginning:
     *  <pre>
     *  .rotatedTitleButton,
     *  .rotatedTitleButtonSelected,
     *  .rotatedTitleButtonSelectedOver,
     *  .rotatedTitleButtonSelectedDown,
     *  .rotatedTitleButtonSelectedDisabled,
     *  .rotatedTitleButtonOver,
     *  .rotatedTitleButtonDown,
     *  .rotatedTitleButtonDisabled {</pre>
     *  then applying that style to the button with {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow}: "clip_h"
     *  would yield a vertically-rendered title with overflow via ellipsis as expected, and also
     *  wrap with {@link com.smartgwt.client.widgets.Button#getWrap Button.wrap}.
     *  
     *  Note that:<ul>
     *  <li> The explicit width applied via CSS is needed because rotated
     *  elements don't inherit dimensions in their new orientation from the DOM - 
     *  the transform/rotation occurs independently of layout.
     *  <li> The translation transform required along the x-axis is roughly
     *  (width - height) / 2, but may need slight offsetting for optimal centering.
     *  <li>We've explicitly avoided describing an approach based on CSS "writing-mode", since
     *  support is incomplete and bugs are present in popular browsers such as Firefox and
     *  Safari that would prevent it from being used without Framework assistance.</ul>
     *
     * @return Current baseStyle value. Default value is "stretchImgButton"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * How big are the end pieces by default
     *
     * @param capSize New capSize value. Default value is 12
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setCapSize(int capSize) {
        setAttribute("capSize", capSize, true);
    }

    /**
     * How big are the end pieces by default
     *
     * @return Current capSize value. Default value is 12
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getCapSize()  {
        return getAttributeAsInt("capSize");
    }
    

    /**
     * If set to true, if the {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title} of this button contains the
     * specified {@link com.smartgwt.client.widgets.Canvas#getAccessKey accessKey}, when the title is displayed to the user it
     * will be modified to include HTML to underline the accessKey.<br> Note that this property may cause titles that include
     * HTML (rather than simple strings) to be inappropriately modified, so should be disabled if your title string includes
     * HTML characters.
     *
     * @param hiliteAccessKey New hiliteAccessKey value. Default value is true
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
     * @return Current hiliteAccessKey value. Default value is true
     */
    public Boolean getHiliteAccessKey()  {
        Boolean result = getAttributeAsBoolean("hiliteAccessKey");
        return result == null ? true : result;
    }
    

    /**
     * Optional icon to be shown with the button title text.   <P> Specify as the partial URL to an image, relative to the
     * imgDir of this component. A sprited image can be specified using the {@link com.smartgwt.client.docs.SCSpriteConfig}
     * format. <P> Note that the string "blank" is a valid setting for this attribute and will always  result in the system
     * blank image, with no state suffixes applied.  Typically, this  might be used when an iconStyle is also specified and the
     * iconStyle renders the icon via  a stateful background-image or other CSS approach.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the icon being shown next to the title text.
     *
     * @param icon URL of new icon. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon, true);
    }

    /**
     * Optional icon to be shown with the button title text.   <P> Specify as the partial URL to an image, relative to the
     * imgDir of this component. A sprited image can be specified using the {@link com.smartgwt.client.docs.SCSpriteConfig}
     * format. <P> Note that the string "blank" is a valid setting for this attribute and will always  result in the system
     * blank image, with no state suffixes applied.  Typically, this  might be used when an iconStyle is also specified and the
     * iconStyle renders the icon via  a stateful background-image or other CSS approach.
     *
     * @return Current icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * If this button is showing an icon should it be right or left aligned?
     *
     * @param iconAlign New iconAlign value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconAlign(String iconAlign)  throws IllegalStateException {
        setAttribute("iconAlign", iconAlign, false);
    }

    /**
     * If this button is showing an icon should it be right or left aligned?
     *
     * @return Current iconAlign value. Default value is null
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public String getIconAlign()  {
        return getAttributeAsString("iconAlign");
    }
    

    /**
     * Height in pixels of the icon image. <P> If unset, defaults to {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize}.
     *
     * @param iconHeight New iconHeight value. Default value is null
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
     * @return Current iconHeight value. Default value is null
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
     * @param iconOrientation The new orientation of the icon relative to the text of the button. Default value is "left"
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
     * @return Current iconOrientation value. Default value is "left"
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
     * @param iconSize New iconSize value. Default value is 16
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
     * @return Current iconSize value. Default value is 16
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public int getIconSize()  {
        return getAttributeAsInt("iconSize");
    }
    

    /**
     * Pixels between icon and title text.
     *
     * @param iconSpacing New iconSpacing value. Default value is 6
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setIconSpacing(int iconSpacing)  throws IllegalStateException {
        setAttribute("iconSpacing", iconSpacing, false);
    }

    /**
     * Pixels between icon and title text.
     *
     * @return Current iconSpacing value. Default value is 6
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public int getIconSpacing()  {
        return getAttributeAsInt("iconSpacing");
    }
    

    /**
     * Width in pixels of the icon image. <P> If unset, defaults to {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getIconSize iconSize}.
     *
     * @param iconWidth New iconWidth value. Default value is null
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
     * @return Current iconWidth value. Default value is null
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Integer getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }
    

    /**
     * The padding for a StretchImgButton's label is determined as follows. <P> If <code>labelHPad</code> is set it will
     * specify the horizontal padding applied to the label. Similarly if <code>labelVPad</code> is set it will specify the
     * vertical padding for the label, regardless of the button's {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} setting. <P> Otherwise <code>labelLengthPad</code>
     * can be set to specify the label padding along the length axis (ie: horizontal padding if {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false, otherwise vertical padding), and 
     * <code>labelBreadthPad</code> can be set to specify the label padding along the other axis. <P> Otherwise the padding on
     * the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and will be set
     * to zero on the breadth axis. <P> So by default the label will be sized to match the center image of the
     * StretchImgButton, but these settings allow the label to partially or wholly overlap the caps.
     *
     * @param labelBreadthPad New labelBreadthPad value. Default value is null
     */
    public void setLabelBreadthPad(Integer labelBreadthPad) {
        setAttribute("labelBreadthPad", labelBreadthPad, true);
    }

    /**
     * The padding for a StretchImgButton's label is determined as follows. <P> If <code>labelHPad</code> is set it will
     * specify the horizontal padding applied to the label. Similarly if <code>labelVPad</code> is set it will specify the
     * vertical padding for the label, regardless of the button's {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} setting. <P> Otherwise <code>labelLengthPad</code>
     * can be set to specify the label padding along the length axis (ie: horizontal padding if {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false, otherwise vertical padding), and 
     * <code>labelBreadthPad</code> can be set to specify the label padding along the other axis. <P> Otherwise the padding on
     * the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and will be set
     * to zero on the breadth axis. <P> So by default the label will be sized to match the center image of the
     * StretchImgButton, but these settings allow the label to partially or wholly overlap the caps.
     *
     * @return Current labelBreadthPad value. Default value is null
     */
    public Integer getLabelBreadthPad()  {
        return getAttributeAsInt("labelBreadthPad");
    }
    

    /**
     * The padding for a StretchImgButton's label is determined as follows. <P> If <code>labelHPad</code> is set it will
     * specify the horizontal padding applied to the label. Similarly if <code>labelVPad</code> is set it will specify the
     * vertical padding for the label, regardless of the button's {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} setting. <P> Otherwise <code>labelLengthPad</code>
     * can be set to specify the label padding along the length axis (ie: horizontal padding if {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false, otherwise vertical padding), and 
     * <code>labelBreadthPad</code> can be set to specify the label padding along the other axis. <P> Otherwise the padding on
     * the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and will be set
     * to zero on the breadth axis. <P> So by default the label will be sized to match the center image of the
     * StretchImgButton, but these settings allow the label to partially or wholly overlap the caps.
     *
     * @param labelHPad New labelHPad value. Default value is null
     */
    public void setLabelHPad(Integer labelHPad) {
        setAttribute("labelHPad", labelHPad, true);
    }

    /**
     * The padding for a StretchImgButton's label is determined as follows. <P> If <code>labelHPad</code> is set it will
     * specify the horizontal padding applied to the label. Similarly if <code>labelVPad</code> is set it will specify the
     * vertical padding for the label, regardless of the button's {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} setting. <P> Otherwise <code>labelLengthPad</code>
     * can be set to specify the label padding along the length axis (ie: horizontal padding if {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false, otherwise vertical padding), and 
     * <code>labelBreadthPad</code> can be set to specify the label padding along the other axis. <P> Otherwise the padding on
     * the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and will be set
     * to zero on the breadth axis. <P> So by default the label will be sized to match the center image of the
     * StretchImgButton, but these settings allow the label to partially or wholly overlap the caps.
     *
     * @return Current labelHPad value. Default value is null
     */
    public Integer getLabelHPad()  {
        return getAttributeAsInt("labelHPad");
    }
    

    /**
     * The padding for a StretchImgButton's label is determined as follows. <P> If <code>labelHPad</code> is set it will
     * specify the horizontal padding applied to the label. Similarly if <code>labelVPad</code> is set it will specify the
     * vertical padding for the label, regardless of the button's {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} setting. <P> Otherwise <code>labelLengthPad</code>
     * can be set to specify the label padding along the length axis (ie: horizontal padding if {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false, otherwise vertical padding), and 
     * <code>labelBreadthPad</code> can be set to specify the label padding along the other axis. <P> Otherwise the padding on
     * the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and will be set
     * to zero on the breadth axis. <P> So by default the label will be sized to match the center image of the
     * StretchImgButton, but these settings allow the label to partially or wholly overlap the caps.
     *
     * @param labelLengthPad New labelLengthPad value. Default value is null
     */
    public void setLabelLengthPad(Integer labelLengthPad) {
        setAttribute("labelLengthPad", labelLengthPad, true);
    }

    /**
     * The padding for a StretchImgButton's label is determined as follows. <P> If <code>labelHPad</code> is set it will
     * specify the horizontal padding applied to the label. Similarly if <code>labelVPad</code> is set it will specify the
     * vertical padding for the label, regardless of the button's {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} setting. <P> Otherwise <code>labelLengthPad</code>
     * can be set to specify the label padding along the length axis (ie: horizontal padding if {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false, otherwise vertical padding), and 
     * <code>labelBreadthPad</code> can be set to specify the label padding along the other axis. <P> Otherwise the padding on
     * the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and will be set
     * to zero on the breadth axis. <P> So by default the label will be sized to match the center image of the
     * StretchImgButton, but these settings allow the label to partially or wholly overlap the caps.
     *
     * @return Current labelLengthPad value. Default value is null
     */
    public Integer getLabelLengthPad()  {
        return getAttributeAsInt("labelLengthPad");
    }
    

    /**
     * Specifies a skinImgDir to apply to the label containing the title of this  StretchImgButton. May be null in which case
     * <code>this.skinImgDir</code> will be applied to the label as well. <P> Note that icons displayed in the title may make
     * use of the skin img dir set here
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * setter for {@link com.smartgwt.client.widgets.StretchImgButton#getLabelSkinImgDir labelSkinImgDir}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param labelSkinImgDir new skin img dir to apply to the label holding title text for   this widget. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setLabelSkinImgDir(String labelSkinImgDir) {
        setAttribute("labelSkinImgDir", labelSkinImgDir, true);
    }

    /**
     * Specifies a skinImgDir to apply to the label containing the title of this  StretchImgButton. May be null in which case
     * <code>this.skinImgDir</code> will be applied to the label as well. <P> Note that icons displayed in the title may make
     * use of the skin img dir set here
     *
     * @return Current labelSkinImgDir value. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getLabelSkinImgDir()  {
        return getAttributeAsString("labelSkinImgDir");
    }
    

    /**
     * The padding for a StretchImgButton's label is determined as follows. <P> If <code>labelHPad</code> is set it will
     * specify the horizontal padding applied to the label. Similarly if <code>labelVPad</code> is set it will specify the
     * vertical padding for the label, regardless of the button's {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} setting. <P> Otherwise <code>labelLengthPad</code>
     * can be set to specify the label padding along the length axis (ie: horizontal padding if {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false, otherwise vertical padding), and 
     * <code>labelBreadthPad</code> can be set to specify the label padding along the other axis. <P> Otherwise the padding on
     * the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and will be set
     * to zero on the breadth axis. <P> So by default the label will be sized to match the center image of the
     * StretchImgButton, but these settings allow the label to partially or wholly overlap the caps.
     *
     * @param labelVPad New labelVPad value. Default value is null
     */
    public void setLabelVPad(Integer labelVPad) {
        setAttribute("labelVPad", labelVPad, true);
    }

    /**
     * The padding for a StretchImgButton's label is determined as follows. <P> If <code>labelHPad</code> is set it will
     * specify the horizontal padding applied to the label. Similarly if <code>labelVPad</code> is set it will specify the
     * vertical padding for the label, regardless of the button's {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} setting. <P> Otherwise <code>labelLengthPad</code>
     * can be set to specify the label padding along the length axis (ie: horizontal padding if {@link
     * com.smartgwt.client.widgets.StretchImgButton#getVertical vertical} is false, otherwise vertical padding), and 
     * <code>labelBreadthPad</code> can be set to specify the label padding along the other axis. <P> Otherwise the padding on
     * the length axis will match the {@link com.smartgwt.client.widgets.StretchImgButton#getCapSize capSize} and will be set
     * to zero on the breadth axis. <P> So by default the label will be sized to match the center image of the
     * StretchImgButton, but these settings allow the label to partially or wholly overlap the caps.
     *
     * @return Current labelVPad value. Default value is null
     */
    public Integer getLabelVPad()  {
        return getAttributeAsInt("labelVPad");
    }
    

    /**
     * String identifier for this canvas's mutually exclusive selection group.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param radioGroup New radioGroup value. Default value is null
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setRadioGroup(String radioGroup) {
        setAttribute("radioGroup", radioGroup, true);
    }

    /**
     * String identifier for this canvas's mutually exclusive selection group.
     *
     * @return Current radioGroup value. Default value is null
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public String getRadioGroup()  {
        return getAttributeAsString("radioGroup");
    }
    
    

    /**
     * If true and the title is clipped, then a hover containing the full title of this button is enabled.
     *
     * @param showClippedTitleOnHover New showClippedTitleOnHover value. Default value is false
     */
    public void setShowClippedTitleOnHover(Boolean showClippedTitleOnHover) {
        setAttribute("showClippedTitleOnHover", showClippedTitleOnHover, true);
    }

    /**
     * If true and the title is clipped, then a hover containing the full title of this button is enabled.
     *
     * @return Current showClippedTitleOnHover value. Default value is false
     */
    public Boolean getShowClippedTitleOnHover()  {
        Boolean result = getAttributeAsBoolean("showClippedTitleOnHover");
        return result == null ? false : result;
    }
    

    /**
     * Should we visibly change state when disabled?
     *
     * @param showDisabled New showDisabled value. Default value is true
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setShowDisabled(Boolean showDisabled) {
        setAttribute("showDisabled", showDisabled, true);
    }

    /**
     * Should we visibly change state when disabled?
     *
     * @return Current showDisabled value. Default value is true
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowDisabled()  {
        Boolean result = getAttributeAsBoolean("showDisabled");
        return result == null ? true : result;
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes disabled.
     *
     * @param showDisabledIcon New showDisabledIcon value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowDisabledIcon(Boolean showDisabledIcon)  throws IllegalStateException {
        setAttribute("showDisabledIcon", showDisabledIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes disabled.
     *
     * @return Current showDisabledIcon value. Default value is true
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowDisabledIcon()  {
        Boolean result = getAttributeAsBoolean("showDisabledIcon");
        return result == null ? true : result;
    }
    

    /**
     * Should we visibly change state when the mouse goes down in this object?
     *
     * @param showDown New showDown value. Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setShowDown(Boolean showDown) {
        setAttribute("showDown", showDown, true);
    }

    /**
     * Should we visibly change state when the mouse goes down in this object?
     *
     * @return Current showDown value. Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowDown()  {
        Boolean result = getAttributeAsBoolean("showDown");
        return result == null ? false : result;
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes down on the button.
     *
     * @param showDownIcon New showDownIcon value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowDownIcon(Boolean showDownIcon)  throws IllegalStateException {
        setAttribute("showDownIcon", showDownIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes down on the button.
     *
     * @return Current showDownIcon value. Default value is false
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowDownIcon()  {
        Boolean result = getAttributeAsBoolean("showDownIcon");
        return result == null ? false : result;
    }
    
    

    /**
     * Should we visibly change state when the canvas receives focus?  If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver StatefulCanvas.showFocusedAsOver} is <code>true</code>,
     * then <b><code>"over"</code></b> will be used to indicate focus. Otherwise a separate <b><code>"focused"</code></b> state
     * will be used.
     *
     * @param showFocused New showFocused value. Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setShowFocused(Boolean showFocused) {
        setAttribute("showFocused", showFocused, true);
    }

    /**
     * Should we visibly change state when the canvas receives focus?  If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver StatefulCanvas.showFocusedAsOver} is <code>true</code>,
     * then <b><code>"over"</code></b> will be used to indicate focus. Otherwise a separate <b><code>"focused"</code></b> state
     * will be used.
     *
     * @return Current showFocused value. Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowFocused()  {
        Boolean result = getAttributeAsBoolean("showFocused");
        return result == null ? false : result;
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image when the button receives focus. <P> If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver StatefulCanvas.showFocusedAsOver} is true, the
     * <code>"Over"</code> icon will be displayed when the canvas has focus, otherwise a separate <code>"Focused"</code> icon
     * will be displayed
     *
     * @param showFocusedIcon New showFocusedIcon value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowFocusedIcon(Boolean showFocusedIcon)  throws IllegalStateException {
        setAttribute("showFocusedIcon", showFocusedIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button receives focus. <P> If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver StatefulCanvas.showFocusedAsOver} is true, the
     * <code>"Over"</code> icon will be displayed when the canvas has focus, otherwise a separate <code>"Focused"</code> icon
     * will be displayed
     *
     * @return Current showFocusedIcon value. Default value is false
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowFocusedIcon()  {
        Boolean result = getAttributeAsBoolean("showFocusedIcon");
        return result == null ? false : result;
    }
    

    /**
     * Should we visibly change state when the mouse goes over this object?
     *
     * @param showRollOver New showRollOver value. Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setShowRollOver(Boolean showRollOver) {
        setAttribute("showRollOver", showRollOver, true);
    }

    /**
     * Should we visibly change state when the mouse goes over this object?
     *
     * @return Current showRollOver value. Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowRollOver()  {
        Boolean result = getAttributeAsBoolean("showRollOver");
        return result == null ? false : result;
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image on mouse rollover.
     *
     * @param showRollOverIcon New showRollOverIcon value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowRollOverIcon(Boolean showRollOverIcon)  throws IllegalStateException {
        setAttribute("showRollOverIcon", showRollOverIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image on mouse rollover.
     *
     * @return Current showRollOverIcon value. Default value is false
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public Boolean getShowRollOverIcon()  {
        Boolean result = getAttributeAsBoolean("showRollOverIcon");
        return result == null ? false : result;
    }
    

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     * @param showSelectedIcon New showSelectedIcon value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.ButtonIcon ButtonIcon overview and related methods
     */
    public void setShowSelectedIcon(Boolean showSelectedIcon)  throws IllegalStateException {
        setAttribute("showSelectedIcon", showSelectedIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     * @return Current showSelectedIcon value. Default value is false
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
     *
     * @param showTitle New showTitle value. Default value is true
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle, true);
    }

    /**
     * Determines whether any specified {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title} will be  displayed
     * for this component.<br> Applies to Image-based components only, where the title will be rendered out in a label floating
     * over the component
     *
     * @return Current showTitle value. Default value is true
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle");
        return result == null ? true : result;
    }
    

    /**
     * Base URL for the image.  By default, StretchImgButtons consist of three image parts: A start image (displayed at the top
     * or left), a scalable central image and an end image displayed at the bottom or right. <P> The images displayed in the
     * stretchImgButton are derived from this property in the  following way: <P> <ul> <li> When the button is in its standard
     * state the suffixes "_start", "_end" and       "_stretch" are applied to the src (before the file extension), so by
     * default       the images displayed will be "button_start.gif" (sized to be       <code>this.capSize</code> by the
     * specified width of the stretchImgButton),       "button_stretch.gif" (stretched to the necessary width) and
     * "button_end.gif"       (sized the same as the start image). <li> As the button's state changes, the images will have
     * suffixes appended <b>before</b>      the "_start" / "_end" / "_stretch" to represent the button state.      See {@link
     * com.smartgwt.client.widgets.Img#getSrc Img.src} for an overview of how states are combined into a compound      URL.
     * </ul> For example the center piece of a selected stretchImgButton with the mouse hovering over it might have the URL:
     * <code>"button_Selected_Down_stretch.gif"</code>. <P> Media should be present for each possible state of the _start, _end
     * and _stretch images.
     *
     * @param src New src value. Default value is "button.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setSrc(String src) {
        setAttribute("src", src, true);
    }

    /**
     * Base URL for the image.  By default, StretchImgButtons consist of three image parts: A start image (displayed at the top
     * or left), a scalable central image and an end image displayed at the bottom or right. <P> The images displayed in the
     * stretchImgButton are derived from this property in the  following way: <P> <ul> <li> When the button is in its standard
     * state the suffixes "_start", "_end" and       "_stretch" are applied to the src (before the file extension), so by
     * default       the images displayed will be "button_start.gif" (sized to be       <code>this.capSize</code> by the
     * specified width of the stretchImgButton),       "button_stretch.gif" (stretched to the necessary width) and
     * "button_end.gif"       (sized the same as the start image). <li> As the button's state changes, the images will have
     * suffixes appended <b>before</b>      the "_start" / "_end" / "_stretch" to represent the button state.      See {@link
     * com.smartgwt.client.widgets.Img#getSrc Img.src} for an overview of how states are combined into a compound      URL.
     * </ul> For example the center piece of a selected stretchImgButton with the mouse hovering over it might have the URL:
     * <code>"button_Selected_Down_stretch.gif"</code>. <P> Media should be present for each possible state of the _start, _end
     * and _stretch images.
     *
     * @return Current src value. Default value is "button.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }
    

    /**
     * Current "state" of this widget. The state setting is automatically updated as the  user interacts with the component
     * (see {@link com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver StatefulCanvas.showRollOver},  {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown StatefulCanvas.showDown}, {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDisabled StatefulCanvas.showDisabled}). <P> StatefulCanvases will have
     * a different appearance based on their current state.  By default this is handled by changing the css className applied
     * to the StatefulCanvas - see {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle StatefulCanvas.baseStyle} and
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getStateSuffix StatefulCanvas.getStateSuffix()} for a description of
     * how this is done. <P> For {@link com.smartgwt.client.widgets.Img} or {@link com.smartgwt.client.widgets.StretchImg}
     * based subclasses of StatefulCanvas, the  appearance may also be updated by changing the src of the rendered image. See
     * {@link com.smartgwt.client.widgets.Img#getSrc Img.src} and {@link com.smartgwt.client.widgets.StretchImgButton#getSrc
     * src} for a description of how the URL  is modified to reflect the state of the widget in this case.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.StatefulCanvas#getState state} of this object, changing its appearance. Note: <code>newState</code> cannot be  {@link com.smartgwt.client.types.State#STATE_DISABLED} if {@link com.smartgwt.client.widgets.StatefulCanvas#getShowDisabled this.showDisabled} is <code>false</code>.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param state the new state. Default value is ""
     * @see com.smartgwt.client.types.State
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public void setState(State state) {
        setAttribute("state", state == null ? null : state.getValue(), true);
    }

    /**
     * Current "state" of this widget. The state setting is automatically updated as the  user interacts with the component
     * (see {@link com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver StatefulCanvas.showRollOver},  {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown StatefulCanvas.showDown}, {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDisabled StatefulCanvas.showDisabled}). <P> StatefulCanvases will have
     * a different appearance based on their current state.  By default this is handled by changing the css className applied
     * to the StatefulCanvas - see {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle StatefulCanvas.baseStyle} and
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getStateSuffix StatefulCanvas.getStateSuffix()} for a description of
     * how this is done. <P> For {@link com.smartgwt.client.widgets.Img} or {@link com.smartgwt.client.widgets.StretchImg}
     * based subclasses of StatefulCanvas, the  appearance may also be updated by changing the src of the rendered image. See
     * {@link com.smartgwt.client.widgets.Img#getSrc Img.src} and {@link com.smartgwt.client.widgets.StretchImgButton#getSrc
     * src} for a description of how the URL  is modified to reflect the state of the widget in this case.
     *
     * @return Return the state of this StatefulCanvas. Default value is ""
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
     * @param title the new title HTML. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public void setTitle(String title) {
        setAttribute("title", title, true);
    }

    /**
     * The title HTML to display in this button.
     *
     * @return Return the title - HTML drawn inside the component. <p> Default is to simply return this.title. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * CSS style applied to the title text only.  Defaults to {@link com.smartgwt.client.widgets.StretchImgButton#getBaseStyle
     * baseStyle} when unset. <P> With a separate <code>titleStyle</code> and {@link
     * com.smartgwt.client.widgets.StretchImgButton#getBaseStyle baseStyle} set, you can provide a backgroundColor via
     * <code>baseStyle</code> that will allow translucent .png media to be "tinted" by the underlying background color, so that
     * a single set of media can provide range of color options.  In this usage, the <code>titleStyle</code> should generally
     * not specify a background color as this would block out the media that appears behind the title.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.StretchImgButton#getTitleStyle titleStyle}, which is applied to the title text.
     *
     * @param titleStyle new title style. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setTitleStyle(String titleStyle) {
        setAttribute("titleStyle", titleStyle, true);
    }

    /**
     * CSS style applied to the title text only.  Defaults to {@link com.smartgwt.client.widgets.StretchImgButton#getBaseStyle
     * baseStyle} when unset. <P> With a separate <code>titleStyle</code> and {@link
     * com.smartgwt.client.widgets.StretchImgButton#getBaseStyle baseStyle} set, you can provide a backgroundColor via
     * <code>baseStyle</code> that will allow translucent .png media to be "tinted" by the underlying background color, so that
     * a single set of media can provide range of color options.  In this usage, the <code>titleStyle</code> should generally
     * not specify a background color as this would block out the media that appears behind the title.
     *
     * @return Current titleStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getTitleStyle()  {
        return getAttributeAsString("titleStyle");
    }
    

    /**
     * Vertical alignment of this component's title.
     *
     * @param valign New valign value. Default value is Canvas.CENTER
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setValign(VerticalAlignment valign) {
        setAttribute("valign", valign == null ? null : valign.getValue(), true);
    }

    /**
     * Vertical alignment of this component's title.
     *
     * @return Current valign value. Default value is Canvas.CENTER
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public VerticalAlignment getValign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("valign"));
    }
    

    /**
     * Default is a horizontal button.  Vertical StretchImgButtons are allowed, but title text, if any, will not be
     * automatically rotated.
     *
     * @param vertical New vertical value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical, true);
    }

    /**
     * Default is a horizontal button.  Vertical StretchImgButtons are allowed, but title text, if any, will not be
     * automatically rotated.
     *
     * @return Current vertical value. Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getVertical()  {
        Boolean result = getAttributeAsBoolean("vertical");
        return result == null ? false : result;
    }
    

    /**
     * Should the title for this button wrap? If unset, default behavior is to allow wrapping if this.vertical is true,
     * otherwise disallow wrapping
     *
     * @param wrap New wrap value. Default value is null
     */
    public void setWrap(Boolean wrap) {
        setAttribute("wrap", wrap, true);
    }

    /**
     * Should the title for this button wrap? If unset, default behavior is to allow wrapping if this.vertical is true,
     * otherwise disallow wrapping
     *
     * @return Current wrap value. Default value is null
     */
    public Boolean getWrap()  {
        return getAttributeAsBoolean("wrap");
    }
    

    // ********************* Methods ***********************
	/**
     * This property contains the default 'action' for the Button to fire when activated.
     */
    public native void action() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "action", "");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addToRadioGroup", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addToRadioGroup(groupID);
    }-*/;

	/**
     * Select this object.
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public native void deselect() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "deselect", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselect();
    }-*/;

    /**
     * Add a iconClick handler.
     * <p>
     * If this button is showing an {@link com.smartgwt.client.widgets.StretchImgButton#getIcon icon}, a separate click handler
     * for the icon may be defined as <code>this.iconClick</code>. Returning false will suppress the standard button click
     * handling code.
     *
     * @param handler the iconClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addIconClickHandler(com.smartgwt.client.widgets.events.IconClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.IconClickEvent.getType()) == 0) setupIconClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.IconClickEvent.getType());
    }

    private native void setupIconClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var iconClick = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.events.IconClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.StretchImgButton::handleTearDownIconClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("iconClick"));
            obj.addProperties({iconClick: 
                function () {
                    var param = {"_this": this};
                    var ret = iconClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("iconClick", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("iconClick"));
            obj.iconClick = 
                function () {
                    var param = {"_this": this};
                    var ret = iconClick(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("iconClick", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownIconClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.events.IconClickEvent.getType()) == 0) tearDownIconClickEvent();
    }

    private native void tearDownIconClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("iconClick")) delete obj.iconClick;
    }-*/;

	/**
     * Remove this widget from the specified mutually exclusive selection group with the ID passed in. No-op's if this widget
     * is not a member of the groupID passed in. If no groupID is passed in, defaults to removing from whatever radioGroup this
     * widget is a member of.
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public native void removeFromRadioGroup() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeFromRadioGroup", "");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeFromRadioGroup", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeFromRadioGroup(groupID);
    }-*/;
	
	/**
     * Select this object.
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public native void select() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "select", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.select();
    }-*/;

	/**
     * Is the title of this button clipped?
     *
     * @return whether the title is clipped.
     */
    public native boolean titleClipped() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "titleClipped", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.titleClipped();
        return ret == null ? false : ret;
    }-*/;

    /**
     * Add a titleHover handler.
     * <p>
     * Optional stringMethod to fire when the user hovers over this button and the title is clipped. If {@link
     * com.smartgwt.client.widgets.StretchImgButton#getShowClippedTitleOnHover StretchImgButton.showClippedTitleOnHover} is
     * true, the default behavior is to show a hover canvas containing the HTML returned by {@link
     * com.smartgwt.client.widgets.StretchImgButton#titleHoverHTML StretchImgButton.titleHoverHTML()}. Call {@link
     * com.smartgwt.client.widgets.events.TitleHoverEvent#cancel()} from within {@link
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
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var titleHover = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.events.TitleHoverEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.StretchImgButton::handleTearDownTitleHoverEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
        }));
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("titleHover"));
            obj.addProperties({titleHover: 
                function () {
                    var param = {"_this": this};
                    var ret = titleHover(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("titleHover", arguments);
                    }
                    return ret;
                }
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("titleHover"));
            obj.titleHover = 
                function () {
                    var param = {"_this": this};
                    var ret = titleHover(param) == true;
                    if (ret && hasDefaultHandler) {
                        ret = this.Super("titleHover", arguments);
                    }
                    return ret;
                }
            ;
        }
    }-*/;

    private void handleTearDownTitleHoverEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.events.TitleHoverEvent.getType()) == 0) tearDownTitleHoverEvent();
    }

    private native void tearDownTitleHoverEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("titleHover")) delete obj.titleHover;
    }-*/;

	/**
     * Returns the HTML that is displayed by the default {@link
     * com.smartgwt.client.widgets.StretchImgButton#addTitleHoverHandler titleHover} handler. Return null or an empty string to
     * cancel the hover. <p>Use <code>setTitleHoverFormatter()</code> to provide a custom implementation.
     * @param defaultHTML the HTML that would have been displayed by default.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     *
     * @return HTML to be displayed in the hover. If null or an empty string, then the hover is canceled.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.HTMLString HTMLString
     */
    public native String titleHoverHTML(String defaultHTML) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "titleHoverHTML", "String");
        }
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
     * @param stretchImgButtonProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(StretchImgButton stretchImgButtonProperties) /*-{
        if (stretchImgButtonProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(StretchImgButton.@java.lang.Object::getClass()(), "setDefaultProperties", stretchImgButtonProperties.@java.lang.Object::getClass()());
        }
        stretchImgButtonProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = stretchImgButtonProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.StretchImgButton.addProperties(properties);
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

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(StretchImgButtonLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.actionType = getAttributeAsString("actionType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.actionType:" + t.getMessage() + "\n";
        }
        try {
            s.align = getAttributeAsString("align");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.align:" + t.getMessage() + "\n";
        }
        try {
            s.autoFit = getAttributeAsString("autoFit");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.autoFit:" + t.getMessage() + "\n";
        }
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.capSize = getAttributeAsString("capSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.capSize:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteAccessKey = getAttributeAsString("hiliteAccessKey");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.hiliteAccessKey:" + t.getMessage() + "\n";
        }
        try {
            s.icon = getAttributeAsString("icon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.icon:" + t.getMessage() + "\n";
        }
        try {
            s.iconAlign = getAttributeAsString("iconAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.iconAlign:" + t.getMessage() + "\n";
        }
        try {
            s.iconHeight = getAttributeAsString("iconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.iconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.iconOrientation = getAttributeAsString("iconOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.iconOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.iconSize = getAttributeAsString("iconSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.iconSize:" + t.getMessage() + "\n";
        }
        try {
            s.iconSpacing = getAttributeAsString("iconSpacing");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.iconSpacing:" + t.getMessage() + "\n";
        }
        try {
            s.iconWidth = getAttributeAsString("iconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.iconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.labelBreadthPad = getAttributeAsString("labelBreadthPad");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.labelBreadthPad:" + t.getMessage() + "\n";
        }
        try {
            s.labelHPad = getAttributeAsString("labelHPad");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.labelHPad:" + t.getMessage() + "\n";
        }
        try {
            s.labelLengthPad = getAttributeAsString("labelLengthPad");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.labelLengthPad:" + t.getMessage() + "\n";
        }
        try {
            s.labelSkinImgDir = getAttributeAsString("labelSkinImgDir");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.labelSkinImgDir:" + t.getMessage() + "\n";
        }
        try {
            s.labelVPad = getAttributeAsString("labelVPad");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.labelVPad:" + t.getMessage() + "\n";
        }
        try {
            s.radioGroup = getAttributeAsString("radioGroup");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.radioGroup:" + t.getMessage() + "\n";
        }
        try {
            s.showClippedTitleOnHover = getAttributeAsString("showClippedTitleOnHover");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.showClippedTitleOnHover:" + t.getMessage() + "\n";
        }
        try {
            s.showDisabled = getAttributeAsString("showDisabled");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.showDisabled:" + t.getMessage() + "\n";
        }
        try {
            s.showDisabledIcon = getAttributeAsString("showDisabledIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.showDisabledIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showDown = getAttributeAsString("showDown");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.showDown:" + t.getMessage() + "\n";
        }
        try {
            s.showDownIcon = getAttributeAsString("showDownIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.showDownIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showFocused = getAttributeAsString("showFocused");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.showFocused:" + t.getMessage() + "\n";
        }
        try {
            s.showFocusedIcon = getAttributeAsString("showFocusedIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.showFocusedIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showRollOver = getAttributeAsString("showRollOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.showRollOver:" + t.getMessage() + "\n";
        }
        try {
            s.showRollOverIcon = getAttributeAsString("showRollOverIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.showRollOverIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showSelectedIcon = getAttributeAsString("showSelectedIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.showSelectedIcon:" + t.getMessage() + "\n";
        }
        try {
            s.showTitle = getAttributeAsString("showTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.showTitle:" + t.getMessage() + "\n";
        }
        try {
            s.src = getAttributeAsString("src");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.src:" + t.getMessage() + "\n";
        }
        try {
            s.state = getAttributeAsString("state");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.state:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.title:" + t.getMessage() + "\n";
        }
        try {
            s.titleStyle = getAttributeAsString("titleStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.titleStyle:" + t.getMessage() + "\n";
        }
        try {
            s.valign = getAttributeAsString("valign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.valign:" + t.getMessage() + "\n";
        }
        try {
            s.vertical = getAttributeAsString("vertical");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.vertical:" + t.getMessage() + "\n";
        }
        try {
            s.wrap = getAttributeAsString("wrap");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImgButton.wrap:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        StretchImgButtonLogicalStructure s = new StretchImgButtonLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
