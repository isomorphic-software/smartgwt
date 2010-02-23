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
 * The StretchImg widget class implements a widget type that displays a list of multiple images  that make up a single
 * image.
 */
public class StretchImg extends StatefulCanvas {

    public static StretchImg getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (StretchImg) obj;
        } else {
            return new StretchImg(jsObj);
        }
    }

    public StretchImg(){
        scClassName = "StretchImg";
    }

    public StretchImg(JavaScriptObject jsObj){
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
     * If the default items are used, capSize is the size in pixels of the first and last          images in this stretchImg.
     *
     * @param capSize capSize Default value is 2
     */
    public void setCapSize(int capSize) {
        setAttribute("capSize", capSize, true);
    }

    /**
     * If the default items are used, capSize is the size in pixels of the first and last          images in this stretchImg.
     *
     *
     * @return int
     */
    public int getCapSize()  {
        return getAttributeAsInt("capSize");
    }

    /**
     * Suffix used the 'grip' image if {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param gripImgSuffix gripImgSuffix Default value is "grip"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGripImgSuffix(String gripImgSuffix)  throws IllegalStateException {
        setAttribute("gripImgSuffix", gripImgSuffix, false);
    }

    /**
     * Suffix used the 'grip' image if {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true.
     *
     *
     * @return String
     */
    public String getGripImgSuffix()  {
        return getAttributeAsString("gripImgSuffix");
    }

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is false and  {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} is unset.
     *
     * @param hSrc hSrc Default value is null
     */
    public void setHSrc(String hSrc) {
        setAttribute("hSrc", hSrc, true);
    }

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is false and  {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} is unset.
     *
     *
     * @return String
     */
    public String getHSrc()  {
        return getAttributeAsString("hSrc");
    }
 
    /**
     * Indicates whether the image should be tiled/cropped, stretched, or centered when the          size of this widget does
     * not match the size of the image. See ImageStyle for          details.
     *
     * @param imageType imageType Default value is Img.STRETCH
     */
    public void setImageType(ImageStyle imageType) {
        setAttribute("imageType", imageType.getValue(), true);
    }

    /**
     * Indicates whether the image should be tiled/cropped, stretched, or centered when the          size of this widget does
     * not match the size of the image. See ImageStyle for          details.
     *
     *
     * @return ImageStyle
     */
    public ImageStyle getImageType()  {
        return EnumUtil.getEnum(ImageStyle.values(), getAttribute("imageType"));
    }

    /**
     * If specified this css class will be applied to the individual item images within this StretchImg. May be overridden by
     * specifying item-specific base styles to each object in the {@link com.smartgwt.client.widgets.StretchImg#getItems 'items
     * array'}. This base style will have standard stateful suffixes appended to indicate the state of this component (as
     * described in  {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle baseStyle}).
     *
     * @param itemBaseStyle itemBaseStyle Default value is null
     */
    public void setItemBaseStyle(String itemBaseStyle) {
        setAttribute("itemBaseStyle", itemBaseStyle, true);
    }

    /**
     * If specified this css class will be applied to the individual item images within this StretchImg. May be overridden by
     * specifying item-specific base styles to each object in the {@link com.smartgwt.client.widgets.StretchImg#getItems 'items
     * array'}. This base style will have standard stateful suffixes appended to indicate the state of this component (as
     * described in  {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle baseStyle}).
     *
     *
     * @return String
     */
    public String getItemBaseStyle()  {
        return getAttributeAsString("itemBaseStyle");
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Down' state on the grip image when the user mousedown's on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown showDown} is false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showDownGrip showDownGrip Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDownGrip(Boolean showDownGrip)  throws IllegalStateException {
        setAttribute("showDownGrip", showDownGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Down' state on the grip image when the user mousedown's on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown showDown} is false.
     *
     *
     * @return Boolean
     */
    public Boolean getShowDownGrip()  {
        return getAttributeAsBoolean("showDownGrip");
    }

    /**
     * Should we show a "grip" image floating above the center of this widget?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showGrip showGrip Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowGrip(Boolean showGrip)  throws IllegalStateException {
        setAttribute("showGrip", showGrip, false);
    }

    /**
     * Should we show a "grip" image floating above the center of this widget?
     *
     *
     * @return Boolean
     */
    public Boolean getShowGrip()  {
        return getAttributeAsBoolean("showGrip");
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Over' state on the grip image when the user rolls over on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver showRollOver} is false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showRollOverGrip showRollOverGrip Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowRollOverGrip(Boolean showRollOverGrip)  throws IllegalStateException {
        setAttribute("showRollOverGrip", showRollOverGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Over' state on the grip image when the user rolls over on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver showRollOver} is false.
     *
     *
     * @return Boolean
     */
    public Boolean getShowRollOverGrip()  {
        return getAttributeAsBoolean("showRollOverGrip");
    }

    /**
     * Determines whether any specified {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle} will be  displayed for this
     * component.<br> Applies to Image-based components only, where the title will be rendered out in a label floating over the
     * component
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTitle showTitle Default value is false
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle, true);
    }

    /**
     * Determines whether any specified {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle} will be  displayed for this
     * component.<br> Applies to Image-based components only, where the title will be rendered out in a label floating over the
     * component
     *
     *
     * @return Boolean
     */
    public Boolean getShowTitle()  {
        return getAttributeAsBoolean("showTitle");
    }

    /**
     * The base URL for the image.  <P> As with {@link com.smartgwt.client.widgets.Img#getSrc src}, the {@link
     * com.smartgwt.client.types.State} of the component is added to this URL.  Then, the image segment name as specified by
     * {@link com.smartgwt.client.widgets.StretchImg#getItems items} is added. <P> For example, for a stretchImg in "Over"
     * state with a <code>src</code> of "button.png" and a segment name of "stretch", the resulting URL would be
     * "button_Over_stretch.png".
     * Changes the base {@link com.smartgwt.client.widgets.StretchImg#getSrc src} for this stretchImg, redrawing if necessary.
     *
     * @param src new URL for the image. Default value is null
     */
    public void setSrc(String src) {
        setAttribute("src", src, true);
    }

    /**
     * The base URL for the image.  <P> As with {@link com.smartgwt.client.widgets.Img#getSrc src}, the {@link
     * com.smartgwt.client.types.State} of the component is added to this URL.  Then, the image segment name as specified by
     * {@link com.smartgwt.client.widgets.StretchImg#getItems items} is added. <P> For example, for a stretchImg in "Over"
     * state with a <code>src</code> of "button.png" and a segment name of "stretch", the resulting URL would be
     * "button_Over_stretch.png".
     *
     *
     * @return String
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    /**
     * Indicates whether the list of images is drawn vertically from top to bottom (true), or horizontally from left to right
     * (false).
     *
     * @param vertical vertical Default value is true
     */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical, true);
    }

    /**
     * Indicates whether the list of images is drawn vertically from top to bottom (true), or horizontally from left to right
     * (false).
     *
     *
     * @return Boolean
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is true and  {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} is unset.
     *
     * @param vSrc vSrc Default value is null
     */
    public void setVSrc(String vSrc) {
        setAttribute("vSrc", vSrc, true);
    }

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is true and  {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} is unset.
     *
     *
     * @return String
     */
    public String getVSrc()  {
        return getAttributeAsString("vSrc");
    }

    // ********************* Methods ***********************
            
    /**
     * Set the specified image's state to newState and update the displayed image given by whichPart, or set the state for all
     * images to newState and update the displayed images if whichPart is not provided.
     * @param newState name for the new state ("off", "down", etc)
     */
    public native void setState(String newState) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setState(newState);
    }-*/;

    /**
     * Set the specified image's state to newState and update the displayed image given by whichPart, or set the state for all
     * images to newState and update the displayed images if whichPart is not provided.
     * @param newState name for the new state ("off", "down", etc)
     * @param whichPart name of the piece to set ("start", "stretch" or "end")           if not specified, sets them all
     */
    public native void setState(String newState, String whichPart) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setState(newState, whichPart);
    }-*/;

    // ********************* Static Methods ***********************

}



