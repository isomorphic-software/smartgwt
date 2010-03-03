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
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Labels display a small amount of {@link com.smartgwt.client.widgets.Label#getAlign 'alignable'} {@link
 * com.smartgwt.client.widgets.Label#getContents 'text'} with optional {@link com.smartgwt.client.widgets.Label#getIcon
 * 'icon'} and {@link com.smartgwt.client.widgets.Label#getAutoFit 'autoFit'}. <P> For a general-purpose container for HTML
 * content, use {@link com.smartgwt.client.widgets.HTMLFlow} or {@link com.smartgwt.client.widgets.HTMLPane} instead.
 */
public class Label extends Button {

    public static Label getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Label) obj;
        } else {
            return new Label(jsObj);
        }
    }

    public Label(){
        scClassName = "Label";
    }

    public Label(JavaScriptObject jsObj){
        super(jsObj);
    }

    public Label(String contents) {
        setContents(contents);
        scClassName = "Label";
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
     * Horizontal alignment of label text. See Alignment type for details.
     *
     * @param align align Default value is Canvas.LEFT
     */
    public void setAlign(Alignment align) {
        setAttribute("align", align.getValue(), true);
    }

    /**
     * Horizontal alignment of label text. See Alignment type for details.
     *
     *
     * @return Alignment
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
     * @param autoFit autoFit Default value is null
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
     */
    public Boolean getAutoFit()  {
        return getAttributeAsBoolean("autoFit");
    }

    /**
     * The contents of a canvas or label widget. Any HTML string is acceptable.
     * Changes the contents of a widget to newContents, an HTML string. <P> When {@link com.smartgwt.client.widgets.Canvas#getDynamicContents 'dynamicContents'} is set, <code>setContents()</code> can also be called with no arguments to cause contents to be re-evaluated.
     *
     * @param contents an HTML string to be set as the contents of this widget. Default value is "&nbsp;"
     */
    public void setContents(String contents) {
        setAttribute("contents", contents, true);
    }

    /**
     * The contents of a canvas or label widget. Any HTML string is acceptable.
     *
     *
     * @return String
     */
    public String getContents()  {
        return getAttributeAsString("contents");
    }

    /**
     * Dynamic contents allows the contents string to be treated as a simple, but powerful&#010 template.  When this attribute
     * is set to true, expressions of the form \${arbitrary JS&#010 here} are replaced by the result of the evaluation of the
     * JS code inside the curly&#010 brackets.  This evaluation happens at draw time.  If you want to trigger a
     * re-evaluation&#010 of the expressions in the contents string you can call markForRedraw() on the canvas.&#010 <p>&#010
     * You can use this feature to build some simple custom components. For example, let's say&#010 you want to show the value
     * of a Slider in a Canvas somewhere on the screen.  You can do&#010 this by observing the valueChanged() method on the
     * slider and calling setContents() on&#010 your canvas with the new string or you can set the contents of the canvas to
     * something&#010 like:&#010 <p><code>&#010 "The slider value is \${sliderInstance.getValue()}."&#010 </code><p>&#010 Next
     * you set dynamicContents: true on the canvas, observe valueChanged() on the slider&#010 and call canvas.markForRedraw()
     * in that observation.  This approach is cleaner than&#010 setContents() when the Canvas is aggregating several values or
     * dynamic expressions.&#010 Like so:&#010 <p>&#010 <pre>&#010 Slider.create({&#010     ID: "mySlider"&#010 });&#010&#010
     * Canvas.create({&#010     ID: "myCanvas",&#010     dynamicContents: true,&#010     contents: "The slider value is
     * \${mySlider.getValue()}."&#010 });&#010     &#010 myCanvas.observe(mySlider, "valueChanged", &#010                 
     * "observer.markForRedraw()");&#010 </pre>&#010 You can embed an arbitrary number of dynamic expressions in the contents
     * string.  The&#010 search and replace is optimized for speed.&#010 <p>&#010 If an error occurs during the evaluation of
     * one of the expressions, a warning is logged&#010 to the ISC Developer Console and the error string is embedded in place
     * of the expected&#010 value in the Canvas.&#010 <p>&#010 The value of a function is its return value.  The value of any
     * variable is the same as&#010 that returned by its toString() representation.&#010 <p>&#010 Inside the evaluation
     * contentext, <code>this</code> points to the canvas instance that&#010 has the dynamicContents string as its contents -
     * in other words the canvas instance on&#010 which the template is declared.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dynamicContents dynamicContents Default value is false
     */
    public void setDynamicContents(Boolean dynamicContents) {
        setAttribute("dynamicContents", dynamicContents, true);
    }

    /**
     * Dynamic contents allows the contents string to be treated as a simple, but powerful&#010 template.  When this attribute
     * is set to true, expressions of the form \${arbitrary JS&#010 here} are replaced by the result of the evaluation of the
     * JS code inside the curly&#010 brackets.  This evaluation happens at draw time.  If you want to trigger a
     * re-evaluation&#010 of the expressions in the contents string you can call markForRedraw() on the canvas.&#010 <p>&#010
     * You can use this feature to build some simple custom components. For example, let's say&#010 you want to show the value
     * of a Slider in a Canvas somewhere on the screen.  You can do&#010 this by observing the valueChanged() method on the
     * slider and calling setContents() on&#010 your canvas with the new string or you can set the contents of the canvas to
     * something&#010 like:&#010 <p><code>&#010 "The slider value is \${sliderInstance.getValue()}."&#010 </code><p>&#010 Next
     * you set dynamicContents: true on the canvas, observe valueChanged() on the slider&#010 and call canvas.markForRedraw()
     * in that observation.  This approach is cleaner than&#010 setContents() when the Canvas is aggregating several values or
     * dynamic expressions.&#010 Like so:&#010 <p>&#010 <pre>&#010 Slider.create({&#010     ID: "mySlider"&#010 });&#010&#010
     * Canvas.create({&#010     ID: "myCanvas",&#010     dynamicContents: true,&#010     contents: "The slider value is
     * \${mySlider.getValue()}."&#010 });&#010     &#010 myCanvas.observe(mySlider, "valueChanged", &#010                 
     * "observer.markForRedraw()");&#010 </pre>&#010 You can embed an arbitrary number of dynamic expressions in the contents
     * string.  The&#010 search and replace is optimized for speed.&#010 <p>&#010 If an error occurs during the evaluation of
     * one of the expressions, a warning is logged&#010 to the ISC Developer Console and the error string is embedded in place
     * of the expected&#010 value in the Canvas.&#010 <p>&#010 The value of a function is its return value.  The value of any
     * variable is the same as&#010 that returned by its toString() representation.&#010 <p>&#010 Inside the evaluation
     * contentext, <code>this</code> points to the canvas instance that&#010 has the dynamicContents string as its contents -
     * in other words the canvas instance on&#010 which the template is declared.
     *
     *
     * @return Boolean
     */
    public Boolean getDynamicContents()  {
        return getAttributeAsBoolean("dynamicContents");
    }

    /**
     * Optional icon to be shown with the button title text.   <P> Specify as the partial URL to an image, relative to the
     * imgDir of this component.
     * Change the icon being shown next to the title text.
     *
     * @param icon URL of new icon. Default value is null
     */
    public void setIcon(String icon) {
        setAttribute("icon", icon, true);
    }

    /**
     * Optional icon to be shown with the button title text.   <P> Specify as the partial URL to an image, relative to the
     * imgDir of this component.
     *
     *
     * @return String
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
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
     */
    public String getIconAlign()  {
        return getAttributeAsString("iconAlign");
    }

    /**
     * Height in pixels of the icon image. <P> If unset, defaults to <code>iconSize</code>
     *
     * @param iconHeight iconHeight Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIconHeight(Integer iconHeight)  throws IllegalStateException {
        setAttribute("iconHeight", iconHeight, false);
    }

    /**
     * Height in pixels of the icon image. <P> If unset, defaults to <code>iconSize</code>
     *
     *
     * @return Integer
     */
    public Integer getIconHeight()  {
        return getAttributeAsInt("iconHeight");
    }

    /**
     * If this button is showing an icon should it appear to the left or right of the title? valid options are
     * <code>"left"</code> and <code>"right"</code>.
     * Changes the orientation of the icon relative to the text of the button.
     *
     * @param iconOrientation The new orientation of the icon relative to the text of the button.. Default value is "left"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIconOrientation(String iconOrientation)  throws IllegalStateException {
        setAttribute("iconOrientation", iconOrientation, false);
    }

    /**
     * If this button is showing an icon should it appear to the left or right of the title? valid options are
     * <code>"left"</code> and <code>"right"</code>.
     *
     *
     * @return String
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
     */
    public int getIconSize()  {
        return getAttributeAsInt("iconSize");
    }

    /**
     * Pixels between icon and title text.
     *
     * @param iconSpacing iconSpacing Default value is 6
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIconSpacing(int iconSpacing)  throws IllegalStateException {
        setAttribute("iconSpacing", iconSpacing, false);
    }

    /**
     * Pixels between icon and title text.
     *
     *
     * @return int
     */
    public int getIconSpacing()  {
        return getAttributeAsInt("iconSpacing");
    }

    /**
     * Width in pixels of the icon image. <P> If unset, defaults to <code>iconSize</code>
     *
     * @param iconWidth iconWidth Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIconWidth(Integer iconWidth)  throws IllegalStateException {
        setAttribute("iconWidth", iconWidth, false);
    }

    /**
     * Width in pixels of the icon image. <P> If unset, defaults to <code>iconSize</code>
     *
     *
     * @return Integer
     */
    public Integer getIconWidth()  {
        return getAttributeAsInt("iconWidth");
    }

    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes disabled.
     *
     * @param showDisabledIcon showDisabledIcon Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDisabledIcon(Boolean showDisabledIcon)  throws IllegalStateException {
        setAttribute("showDisabledIcon", showDisabledIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image if the button becomes disabled.
     *
     *
     * @return Boolean
     */
    public Boolean getShowDisabledIcon()  {
        return getAttributeAsBoolean("showDisabledIcon");
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes down on the button.
     *
     * @param showDownIcon showDownIcon Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDownIcon(Boolean showDownIcon)  throws IllegalStateException {
        setAttribute("showDownIcon", showDownIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the mouse goes down on the button.
     *
     *
     * @return Boolean
     */
    public Boolean getShowDownIcon()  {
        return getAttributeAsBoolean("showDownIcon");
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button receives focus. <P> If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is true, the <code>"Over"</code> icon
     * will be displayed when the canvas has focus, otherwise a separate <code>"Focused"</code> icon will be displayed
     *
     * @param showFocusedIcon showFocusedIcon Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
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
     */
    public Boolean getShowFocusedIcon()  {
        return getAttributeAsBoolean("showFocusedIcon");
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
     */
    public Boolean getShowRollOverIcon()  {
        return getAttributeAsBoolean("showRollOverIcon");
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     * @param showSelectedIcon showSelectedIcon Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowSelectedIcon(Boolean showSelectedIcon)  throws IllegalStateException {
        setAttribute("showSelectedIcon", showSelectedIcon, false);
    }

    /**
     * If using an icon for this button, whether to switch the icon image when the button becomes selected.
     *
     *
     * @return Boolean
     */
    public Boolean getShowSelectedIcon()  {
        return getAttributeAsBoolean("showSelectedIcon");
    }

    /**
     * Vertical alignment of label text. See VerticalAlignment type for details.
     *
     * @param valign valign Default value is Canvas.CENTER
     */
    public void setValign(VerticalAlignment valign) {
        setAttribute("valign", valign.getValue(), true);
    }

    /**
     * Vertical alignment of label text. See VerticalAlignment type for details.
     *
     *
     * @return VerticalAlignment
     */
    public VerticalAlignment getValign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("valign"));
    }

    /**
     * If false, the label text will not be wrapped to the next line.
     *
     * @param wrap wrap Default value is true
     */
    public void setWrap(Boolean wrap) {
        setAttribute("wrap", wrap, true);
    }

    /**
     * If false, the label text will not be wrapped to the next line.
     *
     *
     * @return Boolean
     */
    public Boolean getWrap()  {
        return getAttributeAsBoolean("wrap");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

}




