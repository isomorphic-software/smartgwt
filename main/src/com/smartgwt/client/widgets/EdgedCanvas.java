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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process

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
 * EdgedCanvas acts as a decorative, image-based frame around another single Canvas.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("EdgedCanvas")
public class EdgedCanvas extends Canvas {

    public static EdgedCanvas getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new EdgedCanvas(jsObj);
        } else {
            assert refInstance instanceof EdgedCanvas;
            return (EdgedCanvas)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(EdgedCanvas.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.EdgedCanvas.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(EdgedCanvas.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.EdgedCanvas.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public EdgedCanvas(){
        scClassName = "EdgedCanvas";
    }

    public EdgedCanvas(JavaScriptObject jsObj){
        scClassName = "EdgedCanvas";
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
     * If specified, the {@link com.smartgwt.client.widgets.EdgedCanvas#getEdgeStyleName edgeStyleName} will be treated as a
     * base style name and appended with following suffixes to support separate styling per cell: <P> <code>_TL</code> (top
     * left cell)<br> <code>_T</code> (top center cell)<br> <code>_TR</code> (top right cell)<br> <code>_L</code> (middle left
     * cell)<br> <code>_C</code> (center cell)<br> <code>_R</code> (middle right cell)<br> <code>_BL</code> (bottom left
     * cell)<br> <code>_B</code> (bottom center cell)<br> <code>_BR</code> (bottom right cell)
     *
     * @param addEdgeStyleSuffix New addEdgeStyleSuffix value. Default value is false
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     */
    public EdgedCanvas setAddEdgeStyleSuffix(Boolean addEdgeStyleSuffix) {
        return (EdgedCanvas)setAttribute("addEdgeStyleSuffix", addEdgeStyleSuffix, true);
    }

    /**
     * If specified, the {@link com.smartgwt.client.widgets.EdgedCanvas#getEdgeStyleName edgeStyleName} will be treated as a
     * base style name and appended with following suffixes to support separate styling per cell: <P> <code>_TL</code> (top
     * left cell)<br> <code>_T</code> (top center cell)<br> <code>_TR</code> (top right cell)<br> <code>_L</code> (middle left
     * cell)<br> <code>_C</code> (center cell)<br> <code>_R</code> (middle right cell)<br> <code>_BL</code> (bottom left
     * cell)<br> <code>_B</code> (bottom center cell)<br> <code>_BR</code> (bottom right cell)
     *
     * @return Current addEdgeStyleSuffix value. Default value is false
     */
    public Boolean getAddEdgeStyleSuffix()  {
        Boolean result = getAttributeAsBoolean("addEdgeStyleSuffix");
        return result == null ? false : result;
    }
    

    /**
     * Background color for the center section only.  Can be used as a surrogate background color for the decorated Canvas, if
     * the Canvas is set to partially overlap the edges and hence can't show a background color itself without occluding media.
     *
     * @param centerBackgroundColor New centerBackgroundColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public EdgedCanvas setCenterBackgroundColor(String centerBackgroundColor)  throws IllegalStateException {
        return (EdgedCanvas)setAttribute("centerBackgroundColor", centerBackgroundColor, false);
    }

    /**
     * Background color for the center section only.  Can be used as a surrogate background color for the decorated Canvas, if
     * the Canvas is set to partially overlap the edges and hence can't show a background color itself without occluding media.
     *
     * @return Current centerBackgroundColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getCenterBackgroundColor()  {
        return getAttributeAsString("centerBackgroundColor");
    }
    
    

    /**
     * Height in pixels for bottom corners and edges.  Defaults to edgeSize when unset.
     *
     * @param edgeBottom New edgeBottom value. Default value is null
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public EdgedCanvas setEdgeBottom(Integer edgeBottom)  throws IllegalStateException {
        return (EdgedCanvas)setAttribute("edgeBottom", edgeBottom, false);
    }

    /**
     * Height in pixels for bottom corners and edges.  Defaults to edgeSize when unset.
     *
     * @return Current edgeBottom value. Default value is null
     */
    public Integer getEdgeBottom()  {
        return getAttributeAsInt("edgeBottom");
    }
    

    /**
     * CSS color (WITHOUT "#") for the edges.  If specified, will be used as part of image names.  Example:
     * "edge_88FF88_TL.gif".
     *
     * @param edgeColor New edgeColor value. Default value is null
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public EdgedCanvas setEdgeColor(String edgeColor)  throws IllegalStateException {
        return (EdgedCanvas)setAttribute("edgeColor", edgeColor, false);
    }

    /**
     * CSS color (WITHOUT "#") for the edges.  If specified, will be used as part of image names.  Example:
     * "edge_88FF88_TL.gif".
     *
     * @return Current edgeColor value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getEdgeColor()  {
        return getAttributeAsString("edgeColor");
    }
    

    /**
     * Base name of images for edges.  Extensions for each corner or edge piece will be added to this image URL, before the
     * extension.  For example, with the default base name of "edge.gif", the top-left corner image will be "edge_TL.gif". <P>
     * The full list of extensions is: "_TL", "_TR", "_BL", "_BR", "_T", "_L", "_B", "_R", "_center".
     *
     * @param edgeImage New edgeImage value. Default value is "[SKIN]/rounded/frame/FFFFFF/6.png"
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public EdgedCanvas setEdgeImage(String edgeImage)  throws IllegalStateException {
        return (EdgedCanvas)setAttribute("edgeImage", edgeImage, false);
    }

    /**
     * Base name of images for edges.  Extensions for each corner or edge piece will be added to this image URL, before the
     * extension.  For example, with the default base name of "edge.gif", the top-left corner image will be "edge_TL.gif". <P>
     * The full list of extensions is: "_TL", "_TR", "_BL", "_BR", "_T", "_L", "_B", "_R", "_center".
     *
     * @return Current edgeImage value. Default value is "[SKIN]/rounded/frame/FFFFFF/6.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getEdgeImage()  {
        return getAttributeAsString("edgeImage");
    }
    

    /**
     * Height in pixels for left corners and edges.  Defaults to edgeSize when unset.
     *
     * @param edgeLeft New edgeLeft value. Default value is null
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public EdgedCanvas setEdgeLeft(Integer edgeLeft)  throws IllegalStateException {
        return (EdgedCanvas)setAttribute("edgeLeft", edgeLeft, false);
    }

    /**
     * Height in pixels for left corners and edges.  Defaults to edgeSize when unset.
     *
     * @return Current edgeLeft value. Default value is null
     */
    public Integer getEdgeLeft()  {
        return getAttributeAsInt("edgeLeft");
    }
    
    

    /**
     * Amount the contained Canvas should be offset from the bottom.  Defaults to the size for the bottom edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and corner media.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param edgeOffsetBottom New edgeOffsetBottom value. Default value is null
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public EdgedCanvas setEdgeOffsetBottom(Integer edgeOffsetBottom)  throws IllegalStateException {
        return (EdgedCanvas)setAttribute("edgeOffsetBottom", edgeOffsetBottom, false);
    }

    /**
     * Amount the contained Canvas should be offset from the bottom.  Defaults to the size for the bottom edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and corner media.
     *
     * @return Current edgeOffsetBottom value. Default value is null
     */
    public Integer getEdgeOffsetBottom()  {
        return getAttributeAsInt("edgeOffsetBottom");
    }
    

    /**
     * Amount the contained Canvas should be offset from the left.  Defaults to the size for the left edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and corner media.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param edgeOffsetLeft New edgeOffsetLeft value. Default value is null
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public EdgedCanvas setEdgeOffsetLeft(Integer edgeOffsetLeft)  throws IllegalStateException {
        return (EdgedCanvas)setAttribute("edgeOffsetLeft", edgeOffsetLeft, false);
    }

    /**
     * Amount the contained Canvas should be offset from the left.  Defaults to the size for the left edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and corner media.
     *
     * @return Current edgeOffsetLeft value. Default value is null
     */
    public Integer getEdgeOffsetLeft()  {
        return getAttributeAsInt("edgeOffsetLeft");
    }
    

    /**
     * Amount the contained Canvas should be offset from the right.  Defaults to the size for the right edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and corner media.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param edgeOffsetRight New edgeOffsetRight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public EdgedCanvas setEdgeOffsetRight(Integer edgeOffsetRight)  throws IllegalStateException {
        return (EdgedCanvas)setAttribute("edgeOffsetRight", edgeOffsetRight, false);
    }

    /**
     * Amount the contained Canvas should be offset from the right.  Defaults to the size for the right edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and corner media.
     *
     * @return Current edgeOffsetRight value. Default value is null
     */
    public Integer getEdgeOffsetRight()  {
        return getAttributeAsInt("edgeOffsetRight");
    }
    

    /**
     * Amount the contained Canvas should be offset from the top.  Defaults to the size for  the top edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and  corner media.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param edgeOffsetTop New edgeOffsetTop value. Default value is null
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public EdgedCanvas setEdgeOffsetTop(Integer edgeOffsetTop)  throws IllegalStateException {
        return (EdgedCanvas)setAttribute("edgeOffsetTop", edgeOffsetTop, false);
    }

    /**
     * Amount the contained Canvas should be offset from the top.  Defaults to the size for  the top edge.  Set smaller to
     * allow the contained Canvas to overlap the edge and  corner media.
     *
     * @return Current edgeOffsetTop value. Default value is null
     */
    public Integer getEdgeOffsetTop()  {
        return getAttributeAsInt("edgeOffsetTop");
    }
    

    /**
     * Height in pixels for right corners and edges.  Defaults to edgeSize when unset.
     *
     * @param edgeRight New edgeRight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public EdgedCanvas setEdgeRight(Integer edgeRight)  throws IllegalStateException {
        return (EdgedCanvas)setAttribute("edgeRight", edgeRight, false);
    }

    /**
     * Height in pixels for right corners and edges.  Defaults to edgeSize when unset.
     *
     * @return Current edgeRight value. Default value is null
     */
    public Integer getEdgeRight()  {
        return getAttributeAsInt("edgeRight");
    }
    
    

    /**
     * Optional property specifying the CSS ClassName to apply to the various parts of this edged canvas (top, bottom, corners,
     * sides and center). To apply separate styles for each part, use {@link
     * com.smartgwt.client.widgets.EdgedCanvas#getAddEdgeStyleSuffix addEdgeStyleSuffix}.
     *
     * @param edgeStyleName New edgeStyleName value. Default value is null
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public EdgedCanvas setEdgeStyleName(String edgeStyleName) {
        return (EdgedCanvas)setAttribute("edgeStyleName", edgeStyleName, true);
    }

    /**
     * Optional property specifying the CSS ClassName to apply to the various parts of this edged canvas (top, bottom, corners,
     * sides and center). To apply separate styles for each part, use {@link
     * com.smartgwt.client.widgets.EdgedCanvas#getAddEdgeStyleSuffix addEdgeStyleSuffix}.
     *
     * @return Current edgeStyleName value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getEdgeStyleName()  {
        return getAttributeAsString("edgeStyleName");
    }
    

    /**
     * Height in pixels for top corners and edges.  Defaults to edgeSize when unset.
     *
     * @param edgeTop New edgeTop value. Default value is null
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public EdgedCanvas setEdgeTop(Integer edgeTop)  throws IllegalStateException {
        return (EdgedCanvas)setAttribute("edgeTop", edgeTop, false);
    }

    /**
     * Height in pixels for top corners and edges.  Defaults to edgeSize when unset.
     *
     * @return Current edgeTop value. Default value is null
     */
    public Integer getEdgeTop()  {
        return getAttributeAsInt("edgeTop");
    }
    

    /**
     * Whether to show media in the center section, that is, behind the decorated Canvas.
     *
     * @param showCenter New showCenter value. Default value is false
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public EdgedCanvas setShowCenter(Boolean showCenter)  throws IllegalStateException {
        return (EdgedCanvas)setAttribute("showCenter", showCenter, false);
    }

    /**
     * Whether to show media in the center section, that is, behind the decorated Canvas.
     *
     * @return Current showCenter value. Default value is false
     */
    public Boolean getShowCenter()  {
        Boolean result = getAttributeAsBoolean("showCenter");
        return result == null ? false : result;
    }
    

    /**
     * Standard skin directory for edge images (sides and corners).
     *
     * @param skinImgDir New skinImgDir value. Default value is "images/edges/"
     * @return {@link com.smartgwt.client.widgets.EdgedCanvas EdgedCanvas} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public EdgedCanvas setSkinImgDir(String skinImgDir)  throws IllegalStateException {
        return (EdgedCanvas)setAttribute("skinImgDir", skinImgDir, false);
    }

    /**
     * Standard skin directory for edge images (sides and corners).
     *
     * @return Current skinImgDir value. Default value is "images/edges/"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }
    

    // ********************* Methods ***********************

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
     * @param edgedCanvasProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(EdgedCanvas edgedCanvasProperties) /*-{
        if (edgedCanvasProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(EdgedCanvas.@java.lang.Object::getClass()(), "setDefaultProperties", edgedCanvasProperties.@java.lang.Object::getClass()());
        }
        edgedCanvasProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = edgedCanvasProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
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

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(EdgedCanvasLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.addEdgeStyleSuffix = getAttributeAsString("addEdgeStyleSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.addEdgeStyleSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.centerBackgroundColor = getAttributeAsString("centerBackgroundColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.centerBackgroundColor:" + t.getMessage() + "\n";
        }
        try {
            s.edgeBottom = getAttributeAsString("edgeBottom");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.edgeBottom:" + t.getMessage() + "\n";
        }
        try {
            s.edgeColor = getAttributeAsString("edgeColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.edgeColor:" + t.getMessage() + "\n";
        }
        try {
            s.edgeImage = getAttributeAsString("edgeImage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.edgeImage:" + t.getMessage() + "\n";
        }
        try {
            s.edgeLeft = getAttributeAsString("edgeLeft");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.edgeLeft:" + t.getMessage() + "\n";
        }
        try {
            s.edgeOffsetBottom = getAttributeAsString("edgeOffsetBottom");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.edgeOffsetBottom:" + t.getMessage() + "\n";
        }
        try {
            s.edgeOffsetLeft = getAttributeAsString("edgeOffsetLeft");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.edgeOffsetLeft:" + t.getMessage() + "\n";
        }
        try {
            s.edgeOffsetRight = getAttributeAsString("edgeOffsetRight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.edgeOffsetRight:" + t.getMessage() + "\n";
        }
        try {
            s.edgeOffsetTop = getAttributeAsString("edgeOffsetTop");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.edgeOffsetTop:" + t.getMessage() + "\n";
        }
        try {
            s.edgeRight = getAttributeAsString("edgeRight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.edgeRight:" + t.getMessage() + "\n";
        }
        try {
            s.edgeStyleName = getAttributeAsString("edgeStyleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.edgeStyleName:" + t.getMessage() + "\n";
        }
        try {
            s.edgeTop = getAttributeAsString("edgeTop");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.edgeTop:" + t.getMessage() + "\n";
        }
        try {
            s.showCenter = getAttributeAsString("showCenter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.showCenter:" + t.getMessage() + "\n";
        }
        try {
            s.skinImgDir = getAttributeAsString("skinImgDir");
        } catch (Throwable t) {
            s.logicalStructureErrors += "EdgedCanvas.skinImgDir:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        EdgedCanvasLogicalStructure s = new EdgedCanvasLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
