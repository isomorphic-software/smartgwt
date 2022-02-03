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
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;

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
import com.smartgwt.logicalstructure.widgets.tour.*;

/**
 * The Img widget class implements a simple widget that displays a single image.
 * @see com.smartgwt.client.docs.StatefulImages StatefulImages overview and related methods
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
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Img.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Img.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Img.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Img.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
     * @param altText New altText value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Accessibility Accessibility overview and related methods
     */
    public Img setAltText(String altText) {
        return (Img)setAttribute("altText", altText, true);
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
     * @return Current altText value. Default value is null
     * @see com.smartgwt.client.docs.Accessibility Accessibility overview and related methods
     */
    public String getAltText()  {
        return getAttributeAsString("altText");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "ImgEditProxy"
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public Img setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (Img)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "ImgEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Explicit size for the image, for {@link com.smartgwt.client.widgets.Img#getImageType imageType} settings that would
     * normally use the image's natural size (applies to {@link com.smartgwt.client.widgets.Img#getImageType imageType}
     * "center" and "normal" only).
     *
     * @param imageHeight New imageHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Img setImageHeight(Integer imageHeight)  throws IllegalStateException {
        return (Img)setAttribute("imageHeight", imageHeight, false);
    }

    /**
     * Explicit size for the image, for {@link com.smartgwt.client.widgets.Img#getImageType imageType} settings that would
     * normally use the image's natural size (applies to {@link com.smartgwt.client.widgets.Img#getImageType imageType}
     * "center" and "normal" only).
     *
     * @return Current imageHeight value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
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
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the style of image rendering.
     *
     * @param imageType new style of image rendering. Default value is Img.STRETCH
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Img setImageType(ImageStyle imageType) {
        return (Img)setAttribute("imageType", imageType == null ? null : imageType.getValue(), true);
    }

    /**
     * Indicates whether the image should be tiled/cropped, stretched, or centered when the          size of this widget does
     * not match the size of the image.           CENTER shows the image in it's natural size, but can't do so while the       
     * transparency fix is active for IE. The transparency fix can be manually disabled          by setting {@link
     * com.smartgwt.client.widgets.Img#getUsePNGFix usePNGFix} to false.          See ImageStyle for further details.
     *
     * @return Current imageType value. Default value is Img.STRETCH
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
     * @param imageWidth New imageWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Img setImageWidth(Integer imageWidth)  throws IllegalStateException {
        return (Img)setAttribute("imageWidth", imageWidth, false);
    }

    /**
     * Explicit size for the image, for {@link com.smartgwt.client.widgets.Img#getImageType imageType} settings that would
     * normally use the image's natural size (applies to {@link com.smartgwt.client.widgets.Img#getImageType imageType}
     * "center" and "normal" only).
     *
     * @return Current imageWidth value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Integer getImageWidth()  {
        return getAttributeAsInt("imageWidth");
    }
    

    /**
     * The value of this attribute is specified as the value of the 'name' attribute in the resulting HTML. <p> Note: this
     * attribute is ignored if the imageType is set to "tile"
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param name New name value. Default value is "main"
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Img setName(String name)  throws IllegalStateException {
        return (Img)setAttribute("name", name, false);
    }
    

    /**
     * Prompt displayed in hover canvas if {@link com.smartgwt.client.widgets.Canvas#getShowHover showHover} is true.
     *
     * @param prompt New prompt value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_hovers" target="examples">Hovers / Tooltips Example</a>
     */
    public Img setPrompt(String prompt) {
        return (Img)setAttribute("prompt", prompt, true);
    }

    /**
     * Prompt displayed in hover canvas if {@link com.smartgwt.client.widgets.Canvas#getShowHover showHover} is true.
     *
     * @return Current prompt value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_hovers" target="examples">Hovers / Tooltips Example</a>
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }
    

    /**
     * Should we visibly change state when disabled? <P> This will impact the {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle styling} of the component  when disabled. It may also impact the
     * {@link com.smartgwt.client.widgets.Img#getSrc image being displayed} - see also {@link
     * com.smartgwt.client.widgets.Img#getShowImageDisabled showImageDisabled}.
     *
     * @param showDisabled New showDisabled value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Img setShowDisabled(Boolean showDisabled) {
        return (Img)setAttribute("showDisabled", showDisabled, true);
    }

    /**
     * Should we visibly change state when disabled? <P> This will impact the {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle styling} of the component  when disabled. It may also impact the
     * {@link com.smartgwt.client.widgets.Img#getSrc image being displayed} - see also {@link
     * com.smartgwt.client.widgets.Img#getShowImageDisabled showImageDisabled}.
     *
     * @return Current showDisabled value. Default value is true
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowDisabled()  {
        Boolean result = getAttributeAsBoolean("showDisabled");
        return result == null ? true : result;
    }
    

    /**
     * Should we visibly change state when the mouse goes down in this object? This will impact the {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle styling} of the component on mouse down. It may also impact the
     * {@link com.smartgwt.client.widgets.Img#getSrc image being displayed} - see also {@link
     * com.smartgwt.client.widgets.Img#getShowImageDown showImageDown}.
     *
     * @param showDown New showDown value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Img setShowDown(Boolean showDown) {
        return (Img)setAttribute("showDown", showDown, true);
    }

    /**
     * Should we visibly change state when the mouse goes down in this object? This will impact the {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle styling} of the component on mouse down. It may also impact the
     * {@link com.smartgwt.client.widgets.Img#getSrc image being displayed} - see also {@link
     * com.smartgwt.client.widgets.Img#getShowImageDown showImageDown}.
     *
     * @return Current showDown value. Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowDown()  {
        Boolean result = getAttributeAsBoolean("showDown");
        return result == null ? false : result;
    }
    

    /**
     * Should we visibly change state when the canvas receives focus?  If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver StatefulCanvas.showFocusedAsOver} is <code>true</code>,
     * then <b><code>"over"</code></b> will be used to indicate focus. Otherwise a separate <b><code>"focused"</code></b> state
     * will be used. <P> This will impact the {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle styling} of the
     * component on focus. It may also impact the {@link com.smartgwt.client.widgets.Img#getSrc image being displayed} - see
     * also {@link com.smartgwt.client.widgets.Img#getShowImageFocused showImageFocused}.
     *
     * @param showFocused New showFocused value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Img setShowFocused(Boolean showFocused) {
        return (Img)setAttribute("showFocused", showFocused, true);
    }

    /**
     * Should we visibly change state when the canvas receives focus?  If {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver StatefulCanvas.showFocusedAsOver} is <code>true</code>,
     * then <b><code>"over"</code></b> will be used to indicate focus. Otherwise a separate <b><code>"focused"</code></b> state
     * will be used. <P> This will impact the {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle styling} of the
     * component on focus. It may also impact the {@link com.smartgwt.client.widgets.Img#getSrc image being displayed} - see
     * also {@link com.smartgwt.client.widgets.Img#getShowImageFocused showImageFocused}.
     *
     * @return Current showFocused value. Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowFocused()  {
        Boolean result = getAttributeAsBoolean("showFocused");
        return result == null ? false : result;
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocused showFocused} is true for this widget, should the
     * <code>"over"</code> state be used to indicate the widget as focused. If set to false, a separate <code>"focused"</code>
     * state will be used. <P> This property effects the css styling for the focused state.<br> If {@link
     * com.smartgwt.client.widgets.Img#getSrc src} is specified as a string it will also cause the "Over" media to be displayed
     * to indicate focus, unless explicitly overridden by  {@link com.smartgwt.client.widgets.Img#getShowImageFocusedAsOver
     * showImageFocusedAsOver}. Note that this has no impact on the image to be displayed if {@link
     * com.smartgwt.client.widgets.Img#getSrc src} is specified as a {@link com.smartgwt.client.widgets.SCStatefulImgConfig}.
     *
     * @param showFocusedAsOver New showFocusedAsOver value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Img setShowFocusedAsOver(Boolean showFocusedAsOver) {
        return (Img)setAttribute("showFocusedAsOver", showFocusedAsOver, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocused showFocused} is true for this widget, should the
     * <code>"over"</code> state be used to indicate the widget as focused. If set to false, a separate <code>"focused"</code>
     * state will be used. <P> This property effects the css styling for the focused state.<br> If {@link
     * com.smartgwt.client.widgets.Img#getSrc src} is specified as a string it will also cause the "Over" media to be displayed
     * to indicate focus, unless explicitly overridden by  {@link com.smartgwt.client.widgets.Img#getShowImageFocusedAsOver
     * showImageFocusedAsOver}. Note that this has no impact on the image to be displayed if {@link
     * com.smartgwt.client.widgets.Img#getSrc src} is specified as a {@link com.smartgwt.client.widgets.SCStatefulImgConfig}.
     *
     * @return Current showFocusedAsOver value. Default value is true
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowFocusedAsOver()  {
        Boolean result = getAttributeAsBoolean("showFocusedAsOver");
        return result == null ? true : result;
    }
    

    /**
     * Should the image be updated when disabled as described in {@link com.smartgwt.client.docs.StatefulImages}? <P> If not
     * explicitly set, behavior is as follows:<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a
     * string, {@link com.smartgwt.client.widgets.Img#getShowDisabled showDisabled} will be used to  determine whether to show
     * a disabled image.<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig}, the appropriate  {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig#getDisabled SCStatefulImgConfig.Disabled} state image will be displayed
     * if defined.
     *
     * @param showImageDisabled New showImageDisabled value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Img setShowImageDisabled(Boolean showImageDisabled) {
        return (Img)setAttribute("showImageDisabled", showImageDisabled, true);
    }

    /**
     * Should the image be updated when disabled as described in {@link com.smartgwt.client.docs.StatefulImages}? <P> If not
     * explicitly set, behavior is as follows:<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a
     * string, {@link com.smartgwt.client.widgets.Img#getShowDisabled showDisabled} will be used to  determine whether to show
     * a disabled image.<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig}, the appropriate  {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig#getDisabled SCStatefulImgConfig.Disabled} state image will be displayed
     * if defined.
     *
     * @return Current showImageDisabled value. Default value is null
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowImageDisabled()  {
        return getAttributeAsBoolean("showImageDisabled");
    }
    

    /**
     * Should the image be updated on mouse down as described in {@link com.smartgwt.client.docs.StatefulImages}? <P> If not
     * explicitly set, behavior is as follows:<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a
     * string, {@link com.smartgwt.client.widgets.Img#getShowDown showDown} will be used to  determine whether to show a mouse
     * down image.<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig}, the appropriate  {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig#getDown SCStatefulImgConfig.Down} state image will be displayed if
     * defined.
     *
     * @param showImageDown New showImageDown value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Img setShowImageDown(Boolean showImageDown) {
        return (Img)setAttribute("showImageDown", showImageDown, true);
    }

    /**
     * Should the image be updated on mouse down as described in {@link com.smartgwt.client.docs.StatefulImages}? <P> If not
     * explicitly set, behavior is as follows:<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a
     * string, {@link com.smartgwt.client.widgets.Img#getShowDown showDown} will be used to  determine whether to show a mouse
     * down image.<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig}, the appropriate  {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig#getDown SCStatefulImgConfig.Down} state image will be displayed if
     * defined.
     *
     * @return Current showImageDown value. Default value is null
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowImageDown()  {
        return getAttributeAsBoolean("showImageDown");
    }
    

    /**
     * Should the image be updated on focus as described in {@link com.smartgwt.client.docs.StatefulImages}? <P> If not
     * explicitly set, behavior is as follows:<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a
     * string, {@link com.smartgwt.client.widgets.Img#getShowFocused showFocused} will be used to determine whether to show a
     * focused image.<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig}, the appropriate  {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig#getOver SCStatefulImgConfig.Over} state image will be displayed if
     * defined. <P> Note that if {@link com.smartgwt.client.widgets.Img#getSrc src} is defined as a string, the "Over" media
     * may be used  to indicate a focused state. See {@link com.smartgwt.client.widgets.Img#getShowFocusedAsOver
     * showFocusedAsOver} and {@link com.smartgwt.client.widgets.Img#getShowImageFocusedAsOver showImageFocusedAsOver}.<br>
     * This is not the case for components with {@link com.smartgwt.client.widgets.Img#getSrc src} defined as a {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig} configuration.
     *
     * @param showImageFocused New showImageFocused value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Img setShowImageFocused(Boolean showImageFocused) {
        return (Img)setAttribute("showImageFocused", showImageFocused, true);
    }

    /**
     * Should the image be updated on focus as described in {@link com.smartgwt.client.docs.StatefulImages}? <P> If not
     * explicitly set, behavior is as follows:<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a
     * string, {@link com.smartgwt.client.widgets.Img#getShowFocused showFocused} will be used to determine whether to show a
     * focused image.<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig}, the appropriate  {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig#getOver SCStatefulImgConfig.Over} state image will be displayed if
     * defined. <P> Note that if {@link com.smartgwt.client.widgets.Img#getSrc src} is defined as a string, the "Over" media
     * may be used  to indicate a focused state. See {@link com.smartgwt.client.widgets.Img#getShowFocusedAsOver
     * showFocusedAsOver} and {@link com.smartgwt.client.widgets.Img#getShowImageFocusedAsOver showImageFocusedAsOver}.<br>
     * This is not the case for components with {@link com.smartgwt.client.widgets.Img#getSrc src} defined as a {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig} configuration.
     *
     * @return Current showImageFocused value. Default value is null
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowImageFocused()  {
        return getAttributeAsBoolean("showImageFocused");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.Img#getSrc src} is defined as a string, and this component is configured to {@link
     * com.smartgwt.client.widgets.Img#getShowImageFocused show focused state images}, this property will cause the 
     * <code>"over"</code> state image to be used to indicate focused state. (If unset, {@link
     * com.smartgwt.client.widgets.Img#getShowFocusedAsOver showFocusedAsOver} will be consulted instead). <P> Note that this
     * has no impact on the image to be displayed if {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a
     * {@link com.smartgwt.client.widgets.SCStatefulImgConfig}.
     *
     * @param showImageFocusedAsOver New showImageFocusedAsOver value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Img setShowImageFocusedAsOver(Boolean showImageFocusedAsOver) {
        return (Img)setAttribute("showImageFocusedAsOver", showImageFocusedAsOver, true);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Img#getSrc src} is defined as a string, and this component is configured to {@link
     * com.smartgwt.client.widgets.Img#getShowImageFocused show focused state images}, this property will cause the 
     * <code>"over"</code> state image to be used to indicate focused state. (If unset, {@link
     * com.smartgwt.client.widgets.Img#getShowFocusedAsOver showFocusedAsOver} will be consulted instead). <P> Note that this
     * has no impact on the image to be displayed if {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a
     * {@link com.smartgwt.client.widgets.SCStatefulImgConfig}.
     *
     * @return Current showImageFocusedAsOver value. Default value is null
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowImageFocusedAsOver()  {
        return getAttributeAsBoolean("showImageFocusedAsOver");
    }
    

    /**
     * Should the image be updated on rollOver as described in {@link com.smartgwt.client.docs.StatefulImages}? <P> If not
     * explicitly set, behavior is as follows:<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a
     * string, {@link com.smartgwt.client.widgets.Img#getShowRollOver showRollOver} will be used to  determine whether to show
     * a roll-over image.<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig}, the appropriate  {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig#getOver SCStatefulImgConfig.Over} state image will be displayed if
     * defined.
     *
     * @param showImageRollOver New showImageRollOver value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Img setShowImageRollOver(Boolean showImageRollOver) {
        return (Img)setAttribute("showImageRollOver", showImageRollOver, true);
    }

    /**
     * Should the image be updated on rollOver as described in {@link com.smartgwt.client.docs.StatefulImages}? <P> If not
     * explicitly set, behavior is as follows:<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a
     * string, {@link com.smartgwt.client.widgets.Img#getShowRollOver showRollOver} will be used to  determine whether to show
     * a roll-over image.<br> If {@link com.smartgwt.client.widgets.Img#getSrc src} is specified as a {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig}, the appropriate  {@link
     * com.smartgwt.client.widgets.SCStatefulImgConfig#getOver SCStatefulImgConfig.Over} state image will be displayed if
     * defined.
     *
     * @return Current showImageRollOver value. Default value is null
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowImageRollOver()  {
        return getAttributeAsBoolean("showImageRollOver");
    }
    

    /**
     * Should we visibly change state when the mouse goes over this object? <P> This will impact the {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle styling} of the component on roll over. It may also impact the
     * {@link com.smartgwt.client.widgets.Img#getSrc image being displayed} - see also {@link
     * com.smartgwt.client.widgets.Img#getShowImageRollOver showImageRollOver}.
     *
     * @param showRollOver New showRollOver value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Img setShowRollOver(Boolean showRollOver) {
        return (Img)setAttribute("showRollOver", showRollOver, true);
    }

    /**
     * Should we visibly change state when the mouse goes over this object? <P> This will impact the {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle styling} of the component on roll over. It may also impact the
     * {@link com.smartgwt.client.widgets.Img#getSrc image being displayed} - see also {@link
     * com.smartgwt.client.widgets.Img#getShowImageRollOver showImageRollOver}.
     *
     * @return Current showRollOver value. Default value is false
     * @see com.smartgwt.client.docs.State State overview and related methods
     */
    public Boolean getShowRollOver()  {
        Boolean result = getAttributeAsBoolean("showRollOver");
        return result == null ? false : result;
    }
    

    /**
     * Determines whether any specified {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title} will be  displayed
     * for this component.<br> Applies to Image-based components only, where the title will be rendered out in a label floating
     * over the component
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTitle New showTitle value. Default value is false
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     */
    public Img setShowTitle(Boolean showTitle) {
        return (Img)setAttribute("showTitle", showTitle, true);
    }

    /**
     * Determines whether any specified {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title} will be  displayed
     * for this component.<br> Applies to Image-based components only, where the title will be rendered out in a label floating
     * over the component
     *
     * @return Current showTitle value. Default value is false
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle");
        return result == null ? false : result;
    }
    

    /**
     * Convenience for setting height and width to the same value, at init time only
     *
     * @param size New size value. Default value is null
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Img setSize(Integer size)  throws IllegalStateException {
        return (Img)setAttribute("size", size, false);
    }

    /**
     * Convenience for setting height and width to the same value, at init time only
     *
     * @return Current size value. Default value is null
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Integer getSize()  {
        return getAttributeAsInt("size");
    }
    

    /**
     * The base filename or stateful image configuration for the image.  Note that as the {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getState state}  of the component changes, the image displayed will be
     * updated as described in {@link com.smartgwt.client.docs.StatefulImages}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Changes the URL of this image and redraws it. <P> Does nothing if the src has not changed - if <code>src</code> has not changed but other state has changed such that the image needs updating, call {@link com.smartgwt.client.widgets.Img#resetSrc resetSrc()} instead.
     *
     * @param src new URL for the image. Default value is "blank.gif"
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Img setSrc(String src) {
        return (Img)setAttribute("src", src, true);
    }

    /**
     * The base filename or stateful image configuration for the image.  Note that as the {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getState state}  of the component changes, the image displayed will be
     * updated as described in {@link com.smartgwt.client.docs.StatefulImages}.
     *
     * @return Current src value. Default value is "blank.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    /**
     * The base filename or stateful image configuration for the image.  Note that as the {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getState state}  of the component changes, the image displayed will be
     * updated as described in {@link com.smartgwt.client.docs.StatefulImages}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Changes the URL of this image and redraws it. <P> Does nothing if the src has not changed - if <code>src</code> has not changed but other state has changed such that the image needs updating, call {@link com.smartgwt.client.widgets.Img#resetSrc resetSrc()} instead.
     *
     * @param src new URL for the image. Default value is "blank.gif"
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Img setSrc(SCStatefulImgConfig src) {
        return (Img)setAttribute("src", src == null ? null : src.getJsObj(), true);
    }

    /**
     * The base filename or stateful image configuration for the image.  Note that as the {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getState state}  of the component changes, the image displayed will be
     * updated as described in {@link com.smartgwt.client.docs.StatefulImages}.
     *
     * @return Current src value. Default value is "blank.gif"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public SCStatefulImgConfig getSrcAsSCStatefulImgConfig()  {
        return new SCStatefulImgConfig(getAttributeAsJavaScriptObject("src"));
    }
    

    /**
     * If false, never apply the png fix needed in Internet Explorer to make png transparency work correctly.
     *
     * @param usePNGFix New usePNGFix value. Default value is true
     * @return {@link com.smartgwt.client.widgets.Img Img} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public Img setUsePNGFix(Boolean usePNGFix)  throws IllegalStateException {
        return (Img)setAttribute("usePNGFix", usePNGFix, false);
    }

    /**
     * If false, never apply the png fix needed in Internet Explorer to make png transparency work correctly.
     *
     * @return Current usePNGFix value. Default value is true
     */
    public Boolean getUsePNGFix()  {
        Boolean result = getAttributeAsBoolean("usePNGFix");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Refresh the image being shown.  Call this when the {@link com.smartgwt.client.widgets.Img#getSrc src} attribute has not
     * changed, but other state that affects the image URL (such as being selected) has changed.
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public native void resetSrc() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "resetSrc", "");
        }
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
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Img imgProperties) /*-{
        if (imgProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Img.@java.lang.Object::getClass()(), "setDefaultProperties", imgProperties.@java.lang.Object::getClass()());
        }
        imgProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = imgProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
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

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(ImgLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.altText = getAttributeAsString("altText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.altText:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.editProxyConstructor:" + t.getMessage() + "\n";
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
            s.showDisabled = getAttributeAsString("showDisabled");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.showDisabled:" + t.getMessage() + "\n";
        }
        try {
            s.showDown = getAttributeAsString("showDown");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.showDown:" + t.getMessage() + "\n";
        }
        try {
            s.showFocused = getAttributeAsString("showFocused");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.showFocused:" + t.getMessage() + "\n";
        }
        try {
            s.showFocusedAsOver = getAttributeAsString("showFocusedAsOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.showFocusedAsOver:" + t.getMessage() + "\n";
        }
        try {
            s.showImageDisabled = getAttributeAsString("showImageDisabled");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.showImageDisabled:" + t.getMessage() + "\n";
        }
        try {
            s.showImageDown = getAttributeAsString("showImageDown");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.showImageDown:" + t.getMessage() + "\n";
        }
        try {
            s.showImageFocused = getAttributeAsString("showImageFocused");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.showImageFocused:" + t.getMessage() + "\n";
        }
        try {
            s.showImageFocusedAsOver = getAttributeAsString("showImageFocusedAsOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.showImageFocusedAsOver:" + t.getMessage() + "\n";
        }
        try {
            s.showImageRollOver = getAttributeAsString("showImageRollOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.showImageRollOver:" + t.getMessage() + "\n";
        }
        try {
            s.showRollOver = getAttributeAsString("showRollOver");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.showRollOver:" + t.getMessage() + "\n";
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
            s.usePNGFix = getAttributeAsString("usePNGFix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Img.usePNGFix:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        ImgLogicalStructure s = new ImgLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
