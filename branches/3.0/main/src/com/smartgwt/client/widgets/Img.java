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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * The Img widget class implements a simple widget that displays a single image.
 */
public class Img extends StatefulCanvas {

    public static Img getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Img) obj;
        } else {
            return new Img(jsObj);
        }
    }

    public Img(){
        scClassName = "Img";
    }

    public Img(JavaScriptObject jsObj){
        super(jsObj);
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
     * @param altText altText Default value is null
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
     * @param imageHeight imageHeight Default value is null
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
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the style of image rendering.
     *
     * @param imageType new style of image rendering. Default value is Img.STRETCH
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setImageType(ImageStyle imageType) {
        setAttribute("imageType", imageType.getValue(), true);
    }

    /**
     * Indicates whether the image should be tiled/cropped, stretched, or centered when the          size of this widget does
     * not match the size of the image.           CENTER shows the image in it's natural size, but can't do so while the       
     * transparency fix is active for IE. The transparency fix can be manually disabled          by setting {@link
     * com.smartgwt.client.widgets.Img#getUsePNGFix usePNGFix} to false.          See ImageStyle for further details.
     *
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
     * @param imageWidth imageWidth Default value is null
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
     * @param name name Default value is "main"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setName(String name)  throws IllegalStateException {
        setAttribute("name", name, false);
    }

    /**
     * Prompt displayed in hover canvas if {@link com.smartgwt.client.widgets.Canvas#getShowHover showHover} is true.
     *
     * @param prompt prompt Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_interaction_hovers" target="examples">Hovers / Tooltips Example</a>
     */
    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt, true);
    }

    /**
     * Prompt displayed in hover canvas if {@link com.smartgwt.client.widgets.Canvas#getShowHover showHover} is true.
     *
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
     * Convenience for setting height and width to the same value, at init time only
     *
     * @param size size Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setSize(Integer size)  throws IllegalStateException {
        setAttribute("size", size, false);
    }

    /**
     * Convenience for setting height and width to the same value, at init time only
     *
     *
     * @return Integer
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Integer getSize()  {
        return getAttributeAsInt("size");
    }

    /**
     * The base filename for the image. <P> If <code>img.state</code> is set, it's value will be appended to the URL before the
     * file extension.   <P> For example, given an <code>src</code> of "findIcon.gif" and a state of "Disabled", the resulting
     * image name would be "findIcon_Disabled.gif".  Compound states such as "Selected", "Focused" and "Over" or "Down" will
     * have an intervening underscore, resulting in, for example, <code>"findIcon_Selected_Down.gif"</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Changes the URL of this image and redraws it. <P> Does nothing if the src has not changed - if <code>src</code> has not changed but other state has changed such that the image needs updating, call {@link com.smartgwt.client.widgets.Img#resetSrc Img.resetSrc} instead.
     *
     * @param src new URL for the image. Default value is "blank.gif"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
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
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    /**
     * If false, never apply the png fix needed in Internet Explorer to make png transparency work correctly.
     *
     * @param usePNGFix usePNGFix Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUsePNGFix(Boolean usePNGFix)  throws IllegalStateException {
        setAttribute("usePNGFix", usePNGFix, false);
    }

    /**
     * If false, never apply the png fix needed in Internet Explorer to make png transparency work correctly.
     *
     *
     * @return Boolean
     */
    public Boolean getUsePNGFix()  {
        return getAttributeAsBoolean("usePNGFix");
    }

    // ********************* Methods ***********************
            
    /**
     * If <code>this.showHover</code> is true, when the user holds the mouse over this Canvas for long enough to trigger a
     * hover event, a hover canvas is shown by default. This method returns the contents of that hover canvas. <P> Overridden
     * from Canvas: <br> If {@link com.smartgwt.client.widgets.Img#getPrompt prompt} is specified, and {@link
     * com.smartgwt.client.widgets.Img#getAltText altText} is unset, default implementation is unchanged - the prompt text will
     * be displayed in the hover.<br> If {@link com.smartgwt.client.widgets.Img#getAltText altText} and {@link
     * com.smartgwt.client.widgets.Img#getPrompt prompt} are set this method will return null to suppress the standard hover
     * behavior in browsers where the alt attribute on an img tag causes a native tooltip to appear, such as Internet Explorer.
     * On other browsers the altText value will be returned.
     */
    public native void getHoverHTML() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.getHoverHTML();
    }-*/;
            
    /**
     * Refresh the image being shown.  Call this when the {@link com.smartgwt.client.widgets.Img#getSrc src} attribute has not
     * changed, but other state that affects the image URL (such as being selected) has changed.
     */
    public native void resetSrc() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.resetSrc();
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
     * @param imgProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Img imgProperties) /*-{
    	var properties = $wnd.isc.addProperties({},imgProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.Img.addProperties(properties);
    }-*/;
        
    // ***********************************************************        

}





