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
 * The Img widget class implements a simple widget that displays a single image.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Img")
public class Img extends StatefulCanvas {

    public static Img getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Img(jsObj);
        } else {
            assert refInstance instanceof Img;
            return (Img)refInstance;
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
        $wnd.isc.Img.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.Img.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public Img(){
        scClassName = "Img";
    }

    public Img(JavaScriptObject jsObj){
        scClassName = "Img";
        setJavaScriptObject(jsObj);
    }


    public Img(String src) {
        setSrc(src);
                scClassName = "Img";
    }


    public Img(String src, int width, int height) {
        setSrc(src);
		setWidth(width);
		setHeight(height);
                scClassName = "Img";
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
     * If specified this property will be included as the <code>alt</code> text for the image HMTL element. This is useful for
     * improving application accessibility. <P> <b><code>altText</code> and hover prompt / tooltip behavior:</b> Note that some
     * browsers, including Internet Explorer 9, show a native hover tooltip containing the  img tag's <code>alt</code>
     * attribute. Developers should not rely on this behavior to show the user a hover prompt - instead the {@link
     * com.smartgwt.client.widgets.Img#getPrompt prompt} attribute should be used.<br> To set alt text <i>and</i> ensure a
     * hover prompt shows up in all browsers, developers may set {@link com.smartgwt.client.widgets.Img#getPrompt prompt} and
     * <code>altText</code> to the same value. If both  these attributes are set, the standard Smart GWT prompt behavior will
     * show a hover prompt in most browsers, but will be suppressed for browsers where a native tooltip  is shown for altText.
     * Note that setting <code>altText</code> and <code>prompt</code> to different values is not recommended - the prompt value
     * will be ignored in favor of the altText in this case.
     *
     * @param altText  Default value is null
     * @see com.smartgwt.client.docs.Accessibility Accessibility overview and related methods
     */
    public void setAltText(String altText) {
        setAttribute("altText", altText, true);
    }

    /**
     * If specified this property will be included as the <code>alt</code> text for the image HMTL element. This is useful for
     * improving application accessibility. <P> <b><code>altText</code> and hover prompt / tooltip behavior:</b> Note that some
     * browsers, including Internet Explorer 9, show a native hover tooltip containing the  img tag's <code>alt</code>
     * attribute. Developers should not rely on this behavior to show the user a hover prompt - instead the {@link
     * com.smartgwt.client.widgets.Img#getPrompt prompt} attribute should be used.<br> To set alt text <i>and</i> ensure a
     * hover prompt shows up in all browsers, developers may set {@link com.smartgwt.client.widgets.Img#getPrompt prompt} and
     * <code>altText</code> to the same value. If both  these attributes are set, the standard Smart GWT prompt behavior will
     * show a hover prompt in most browsers, but will be suppressed for browsers where a native tooltip  is shown for altText.
     * Note that setting <code>altText</code> and <code>prompt</code> to different values is not recommended - the prompt value
     * will be ignored in favor of the altText in this case.
     *
     * @return String
     * @see com.smartgwt.client.docs.Accessibility Accessibility overview and related methods
     */
    public String getAltText()  {
        return getAttributeAsString("altText");
    }

    /**
     * Explicit size for the image, for {@link com.smartgwt.client.widgets.Img#getImageType imageType} settings that would
     * normally use the image's natural size (applies to {@link com.smartgwt.client.widgets.Img#getImageType imageType}
     * "center" and "normal" only).
     *
     * @param imageHeight  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setImageHeight(Integer imageHeight)  throws IllegalStateException {
        setAttribute("imageHeight", imageHeight, false);
    }

    /**
     * Explicit size for the image, for {@link com.smartgwt.client.widgets.Img#getImageType imageType} settings that would
     * normally use the image's natural size (applies to {@link com.smartgwt.client.widgets.Img#getImageType imageType}
     * "center" and "normal" only).
     *
     * @return Integer
     */
    public Integer getImageHeight()  {
        return getAttributeAsInt("imageHeight");
    }

    /**
     * Indicates whether the image should be tiled/cropped, stretched, or centered when the          size of this widget does
     * not match the size of the image.           CENTER shows the image in it's natural size, but can't do so while the       
     * transparency fix is active for IE. The transparency fix can be manually disabled          by setting {@link
     * com.smartgwt.client.widgets.Img#getUsePNGFix usePNGFix} to false.          See ImageStyle for further details.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Change the style of image rendering.
     *
     * @param imageType new style of image rendering. Default value is Img.STRETCH
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setImageType(ImageStyle imageType) {
        setAttribute("imageType", imageType == null ? null : imageType.getValue(), true);
    }

    /**
     * Indicates whether the image should be tiled/cropped, stretched, or centered when the          size of this widget does
     * not match the size of the image.           CENTER shows the image in it's natural size, but can't do so while the       
     * transparency fix is active for IE. The transparency fix can be manually disabled          by setting {@link
     * com.smartgwt.client.widgets.Img#getUsePNGFix usePNGFix} to false.          See ImageStyle for further details.
     *
     * @return ImageStyle
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ImageStyle getImageType()  {
        return EnumUtil.getEnum(ImageStyle.values(), getAttribute("imageType"));
    }

    /**
     * Explicit size for the image, for {@link com.smartgwt.client.widgets.Img#getImageType imageType} settings that would
     * normally use the image's natural size (applies to {@link com.smartgwt.client.widgets.Img#getImageType imageType}
     * "center" and "normal" only).
     *
     * @param imageWidth  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setImageWidth(Integer imageWidth)  throws IllegalStateException {
        setAttribute("imageWidth", imageWidth, false);
    }

    /**
     * Explicit size for the image, for {@link com.smartgwt.client.widgets.Img#getImageType imageType} settings that would
     * normally use the image's natural size (applies to {@link com.smartgwt.client.widgets.Img#getImageType imageType}
     * "center" and "normal" only).
     *
     * @return Integer
     */
    public Integer getImageWidth()  {
        return getAttributeAsInt("imageWidth");
    }

    /**
     * The value of this attribute is specified as the value of the 'name' attribute in the resulting HTML. <p> Note: this
     * attribute is ignored if the imageType is set to "tile"
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param name  Default value is "main"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setName(String name)  throws IllegalStateException {
        setAttribute("name", name, false);
    }

    /**
     * Prompt displayed in hover canvas if {@link com.smartgwt.client.widgets.Canvas#getShowHover showHover} is true.
     *
     * @param prompt  Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_hovers" target="examples">Hovers / Tooltips Example</a>
     */
    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt, true);
    }

    /**
     * Prompt displayed in hover canvas if {@link com.smartgwt.client.widgets.Canvas#getShowHover showHover} is true.
     *
     * @return String
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_hovers" target="examples">Hovers / Tooltips Example</a>
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
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
        return getAttributeAsBoolean("showTitle");
    }

    /**
     * Convenience for setting height and width to the same value, at init time only
     *
     * @param size  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setSize(Integer size)  throws IllegalStateException {
        setAttribute("size", size, false);
    }

    /**
     * Convenience for setting height and width to the same value, at init time only
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Integer getSize()  {
        return getAttributeAsInt("size");
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
     * <p>If this method is called after the component has been drawn/initialized:
     * Changes the URL of this image and redraws it. <P> Does nothing if the src has not changed - if <code>src</code> has not changed but other state has changed such that the image needs updating, call {@link com.smartgwt.client.widgets.Img#resetSrc Img.resetSrc} instead.
     *
     * @param src new URL for the image See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} . Default value is "blank.gif"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
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
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    /**
     * If false, never apply the png fix needed in Internet Explorer to make png transparency work correctly.
     *
     * @param usePNGFix  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUsePNGFix(Boolean usePNGFix)  throws IllegalStateException {
        setAttribute("usePNGFix", usePNGFix, false);
    }

    /**
     * If false, never apply the png fix needed in Internet Explorer to make png transparency work correctly.
     *
     * @return Boolean
     */
    public Boolean getUsePNGFix()  {
        return getAttributeAsBoolean("usePNGFix");
    }

    // ********************* Methods ***********************
	/**
     * Refresh the image being shown.  Call this when the {@link com.smartgwt.client.widgets.Img#getSrc src} attribute has not
     * changed, but other state that affects the image URL (such as being selected) has changed.
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public native void resetSrc() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.resetSrc();
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
     * @param imgProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Img imgProperties) /*-{
    	var properties = $wnd.isc.addProperties({},imgProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.Img.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * If <code>this.showHover</code> is true, when the user holds the mouse over this Canvas for long enough to trigger a
     * hover event, a hover canvas is shown by default. This method returns the contents of that hover canvas. <P> Overridden
     * from Canvas: <br> If {@link com.smartgwt.client.widgets.Img#getPrompt prompt} is specified, and {@link
     * com.smartgwt.client.widgets.Img#getAltText altText} is unset, default implementation is unchanged - the prompt text will
     * be displayed in the hover.<br> If {@link com.smartgwt.client.widgets.Img#getAltText altText} and {@link
     * com.smartgwt.client.widgets.Img#getPrompt prompt} are set this method will return null to suppress the standard hover
     * behavior in browsers where the alt attribute on an img tag causes a native tooltip to appear, such as Internet Explorer.
     * On other browsers the altText value will be returned.
     * 
     * @param hoverHTMLCustomizer the customizer to execute.
     */
    public native void setHoverHTMLCustomizer(HoverHTMLCustomizer hoverHTMLCustomizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        self.getHoverHTML = $debox($entry(function() {
            var canvasJ = @com.smartgwt.client.widgets.Canvas::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(this);

        	hoverHTMLCustomizer.@com.smartgwt.client.widgets.HoverHTMLCustomizer::setCanvas(Lcom/smartgwt/client/widgets/Canvas;)(canvasJ);
        
            return hoverHTMLCustomizer.@com.smartgwt.client.widgets.HoverHTMLCustomizer::getHoverHTML()();
        }));
    }-*/;

    public LogicalStructureObject setLogicalStructure(ImgLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.altText = getAttributeAsString("altText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.altText:" + t.getMessage() + "\n";
        }
        try {
            s.imageHeight = getAttributeAsString("imageHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.imageHeight:" + t.getMessage() + "\n";
        }
        try {
            s.imageType = getAttributeAsString("imageType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.imageType:" + t.getMessage() + "\n";
        }
        try {
            s.imageWidth = getAttributeAsString("imageWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.imageWidth:" + t.getMessage() + "\n";
        }
        try {
            s.prompt = getAttributeAsString("prompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.prompt:" + t.getMessage() + "\n";
        }
        try {
            s.showTitle = getAttributeAsString("showTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.showTitle:" + t.getMessage() + "\n";
        }
        try {
            s.size = getAttributeAsString("size");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.size:" + t.getMessage() + "\n";
        }
        try {
            s.src = getAttributeAsString("src");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.src:" + t.getMessage() + "\n";
        }
        try {
            s.usePNGFix = getAttributeAsString("usePNGFix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.usePNGFix:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        ImgLogicalStructure s = new ImgLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

