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
 * EdgedCanvas acts as a decorative, image-based frame around another single Canvas.
 */
public class EdgedCanvas extends Canvas {

    public static EdgedCanvas getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (EdgedCanvas) obj;
        } else {
            return new EdgedCanvas(jsObj);
        }
    }

    public EdgedCanvas(){
        scClassName = "EdgedCanvas";
    }

    public EdgedCanvas(JavaScriptObject jsObj){
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
     * If specified, the {@link com.smartgwt.client.widgets.EdgedCanvas#getEdgeStyleName edgeStyleName} will be treated as a
     * base style name and appended with following suffixes to support separate styling per cell: <P> <code>_TL</code> (top
     * left cell)<br> <code>_T</code> (top center cell)<br> <code>_TR</code> (top right cell)<br> <code>_L</code> (middle left
     * cell)<br> <code>_C</code> (center cell)<br> <code>_R</code> (middle right cell)<br> <code>_BL</code> (bottom left
     * cell)<br> <code>_B</code> (bottom center cell)<br> <code>_BR</code> (bottom right cell)
     *
     * @param addEdgeStyleSuffix addEdgeStyleSuffix Default value is false
     */
    public void setAddEdgeStyleSuffix(Boolean addEdgeStyleSuffix) {
        setAttribute("addEdgeStyleSuffix", addEdgeStyleSuffix, true);
    }

    /**
     * If specified, the {@link com.smartgwt.client.widgets.EdgedCanvas#getEdgeStyleName edgeStyleName} will be treated as a
     * base style name and appended with following suffixes to support separate styling per cell: <P> <code>_TL</code> (top
     * left cell)<br> <code>_T</code> (top center cell)<br> <code>_TR</code> (top right cell)<br> <code>_L</code> (middle left
     * cell)<br> <code>_C</code> (center cell)<br> <code>_R</code> (middle right cell)<br> <code>_BL</code> (bottom left
     * cell)<br> <code>_B</code> (bottom center cell)<br> <code>_BR</code> (bottom right cell)
     *
     *
     * @return Boolean
     */
    public Boolean getAddEdgeStyleSuffix()  {
        return getAttributeAsBoolean("addEdgeStyleSuffix");
    }

    /**
     * Background color for the center section only.  Can be used as a surrogate background color for the decorated Canvas, if
     * the Canvas is set to partially overlap the edges and hence can't show a background color itself without occluding media.
     *
     * @param centerBackgroundColor centerBackgroundColor Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCenterBackgroundColor(String centerBackgroundColor)  throws IllegalStateException {
        setAttribute("centerBackgroundColor", centerBackgroundColor, false);
    }

    /**
     * Background color for the center section only.  Can be used as a surrogate background color for the decorated Canvas, if
     * the Canvas is set to partially overlap the edges and hence can't show a background color itself without occluding media.
     *
     *
     * @return String
     */
    public String getCenterBackgroundColor()  {
        return getAttributeAsString("centerBackgroundColor");
    }

    /**
     * Height in pixels for bottom corners and edges.  Defaults to edgeSize when unset.
     *
     * @param edgeBottom edgeBottom Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEdgeBottom(Integer edgeBottom)  throws IllegalStateException {
        setAttribute("edgeBottom", edgeBottom, false);
    }

    /**
     * Height in pixels for bottom corners and edges.  Defaults to edgeSize when unset.
     *
     *
     * @return Integer
     */
    public Integer getEdgeBottom()  {
        return getAttributeAsInt("edgeBottom");
    }

    /**
     * CSS color (WITHOUT "#") for the edges.  If specified, will be used as part of image names.  Example:
     * "edge_88FF88_TL.gif".
     *
     * @param edgeColor edgeColor Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEdgeColor(String edgeColor)  throws IllegalStateException {
        setAttribute("edgeColor", edgeColor, false);
    }

    /**
     * CSS color (WITHOUT "#") for the edges.  If specified, will be used as part of image names.  Example:
     * "edge_88FF88_TL.gif".
     *
     *
     * @return String
     */
    public String getEdgeColor()  {
        return getAttributeAsString("edgeColor");
    }

    /**
     * Base name of images for edges.  Extensions for each corner or edge piece will be added to this image URL, before the
     * extension.  For example, with the default base name of "edge.gif", the top-left corner image will be "edge_TL.gif". <P>
     * The full list of extensions is: "_TL", "_TR", "_BL", "_BR", "_T", "_L", "_B", "_R", "_center".
     *
     * @param edgeImage edgeImage Default value is "[SKIN]/rounded/frame/FFFFFF/6.png"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEdgeImage(String edgeImage)  throws IllegalStateException {
        setAttribute("edgeImage", edgeImage, false);
    }

    /**
     * Base name of images for edges.  Extensions for each corner or edge piece will be added to this image URL, before the
     * extension.  For example, with the default base name of "edge.gif", the top-left corner image will be "edge_TL.gif". <P>
     * The full list of extensions is: "_TL", "_TR", "_BL", "_BR", "_T", "_L", "_B", "_R", "_center".
     *
     *
     * @return String
     */
    public String getEdgeImage()  {
        return getAttributeAsString("edgeImage");
    }

    /**
     * Height in pixels for left corners and edges.  Defaults to edgeSize when unset.
     *
     * @param edgeLeft edgeLeft Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEdgeLeft(Integer edgeLeft)  throws IllegalStateException {
        setAttribute("edgeLeft", edgeLeft, false);
    }

    /**
     * Height in pixels for left corners and edges.  Defaults to edgeSize when unset.
     *
     *
     * @return Integer
     */
    public Integer getEdgeLeft()  {
        return getAttributeAsInt("edgeLeft");
    }

    /**
     * Amount the contained Canvas should be offset from the bottom.  Defaults to the size for the bottom edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and corner media.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param edgeOffsetBottom edgeOffsetBottom Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEdgeOffsetBottom(Integer edgeOffsetBottom)  throws IllegalStateException {
        setAttribute("edgeOffsetBottom", edgeOffsetBottom, false);
    }

    /**
     * Amount the contained Canvas should be offset from the bottom.  Defaults to the size for the bottom edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and corner media.
     *
     *
     * @return Integer
     */
    public Integer getEdgeOffsetBottom()  {
        return getAttributeAsInt("edgeOffsetBottom");
    }

    /**
     * Amount the contained Canvas should be offset from the left.  Defaults to the size for the left edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and corner media.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param edgeOffsetLeft edgeOffsetLeft Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEdgeOffsetLeft(Integer edgeOffsetLeft)  throws IllegalStateException {
        setAttribute("edgeOffsetLeft", edgeOffsetLeft, false);
    }

    /**
     * Amount the contained Canvas should be offset from the left.  Defaults to the size for the left edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and corner media.
     *
     *
     * @return Integer
     */
    public Integer getEdgeOffsetLeft()  {
        return getAttributeAsInt("edgeOffsetLeft");
    }

    /**
     * Amount the contained Canvas should be offset from the right.  Defaults to the size for the right edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and corner media.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param edgeOffsetRight edgeOffsetRight Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEdgeOffsetRight(Integer edgeOffsetRight)  throws IllegalStateException {
        setAttribute("edgeOffsetRight", edgeOffsetRight, false);
    }

    /**
     * Amount the contained Canvas should be offset from the right.  Defaults to the size for the right edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and corner media.
     *
     *
     * @return Integer
     */
    public Integer getEdgeOffsetRight()  {
        return getAttributeAsInt("edgeOffsetRight");
    }

    /**
     * Amount the contained Canvas should be offset from the top.  Defaults to the size for  the top edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and  corner media.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param edgeOffsetTop edgeOffsetTop Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEdgeOffsetTop(Integer edgeOffsetTop)  throws IllegalStateException {
        setAttribute("edgeOffsetTop", edgeOffsetTop, false);
    }

    /**
     * Amount the contained Canvas should be offset from the top.  Defaults to the size for  the top edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and  corner media.
     *
     *
     * @return Integer
     */
    public Integer getEdgeOffsetTop()  {
        return getAttributeAsInt("edgeOffsetTop");
    }

    /**
     * Height in pixels for right corners and edges.  Defaults to edgeSize when unset.
     *
     * @param edgeRight edgeRight Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEdgeRight(Integer edgeRight)  throws IllegalStateException {
        setAttribute("edgeRight", edgeRight, false);
    }

    /**
     * Height in pixels for right corners and edges.  Defaults to edgeSize when unset.
     *
     *
     * @return Integer
     */
    public Integer getEdgeRight()  {
        return getAttributeAsInt("edgeRight");
    }

    /**
     * Optional property specifying the CSS ClassName to apply to the various parts of this edged canvas (top, bottom, corners,
     * sides and center). To apply separate styles for each part, use {@link
     * com.smartgwt.client.widgets.EdgedCanvas#getAddEdgeStyleSuffix addEdgeStyleSuffix}.
     *
     * @param edgeStyleName edgeStyleName Default value is null
     */
    public void setEdgeStyleName(String edgeStyleName) {
        setAttribute("edgeStyleName", edgeStyleName, true);
    }

    /**
     * Optional property specifying the CSS ClassName to apply to the various parts of this edged canvas (top, bottom, corners,
     * sides and center). To apply separate styles for each part, use {@link
     * com.smartgwt.client.widgets.EdgedCanvas#getAddEdgeStyleSuffix addEdgeStyleSuffix}.
     *
     *
     * @return String
     */
    public String getEdgeStyleName()  {
        return getAttributeAsString("edgeStyleName");
    }

    /**
     * Height in pixels for top corners and edges.  Defaults to edgeSize when unset.
     *
     * @param edgeTop edgeTop Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEdgeTop(Integer edgeTop)  throws IllegalStateException {
        setAttribute("edgeTop", edgeTop, false);
    }

    /**
     * Height in pixels for top corners and edges.  Defaults to edgeSize when unset.
     *
     *
     * @return Integer
     */
    public Integer getEdgeTop()  {
        return getAttributeAsInt("edgeTop");
    }

    /**
     * Whether to show media in the center section, that is, behind the decorated Canvas.
     *
     * @param showCenter showCenter Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowCenter(Boolean showCenter)  throws IllegalStateException {
        setAttribute("showCenter", showCenter, false);
    }

    /**
     * Whether to show media in the center section, that is, behind the decorated Canvas.
     *
     *
     * @return Boolean
     */
    public Boolean getShowCenter()  {
        return getAttributeAsBoolean("showCenter");
    }

    /**
     * Standard skin directory for edge images (sides and corners).
     *
     * @param skinImgDir skinImgDir Default value is "images/edges/"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSkinImgDir(String skinImgDir)  throws IllegalStateException {
        setAttribute("skinImgDir", skinImgDir, false);
    }

    /**
     * Standard skin directory for edge images (sides and corners).
     *
     *
     * @return String
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }

    // ********************* Methods ***********************

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
     * @param edgedCanvasProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(EdgedCanvas edgedCanvasProperties) /*-{
    	var properties = $wnd.isc.addProperties({},edgedCanvasProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.EdgedCanvas.addProperties(properties);
    }-*/;
        
    // ***********************************************************        


    /**
     * Preload primary EdgedCanvas images.
     */
    public static native void preloadImages() /*-{
        var skinImgDir = $wnd.isc.EdgedCanvas.getInstanceProperty('skinImgDir');
        var edgeEdgeImage = $wnd.isc.EdgedCanvas.getInstanceProperty('edgeImage');
        @com.smartgwt.client.util.FileLoader::cacheEdgeImages(Ljava/lang/String;Ljava/lang/String;)(skinImgDir,edgeEdgeImage);
    }-*/;

}




