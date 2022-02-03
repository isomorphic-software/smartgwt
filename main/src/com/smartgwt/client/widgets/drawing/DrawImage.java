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
 
package com.smartgwt.client.widgets.drawing;


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
 * DrawItem subclass to render embedded images.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawImage")
public class DrawImage extends DrawItem {

    public static DrawImage getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DrawImage(jsObj);
        } else {
            assert refInstance instanceof DrawImage;
            return (DrawImage)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawImage.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawImage.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawImage.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DrawImage.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;
    /**
     * Changes the defaults for DrawItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults DrawItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, DrawItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawImage.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "DrawItem");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawImage.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public DrawImage(){
        scClassName = "DrawImage";
    }

    public DrawImage(JavaScriptObject jsObj){
        scClassName = "DrawImage";
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
     * Height in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the height of the drawImage.
     *
     * @param height new height. Default value is 16
     * @return {@link com.smartgwt.client.widgets.drawing.DrawImage DrawImage} instance, for chaining setter calls
     */
    public DrawImage setHeight(int height) {
        return (DrawImage)setAttribute("height", height, true);
    }

    /**
     * Height in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current height value. Default value is 16
     */
    public int getHeight()  {
        return (int)Math.round(getAttributeAsDouble("height"));
    }

    /**
     * Height in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current height value. Default value is 16
     */
    public double getHeightAsDouble()  {
        return getAttributeAsDouble("height");
    }
    

    /**
     * Left coordinate in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the left coordinate of the drawImage.
     *
     * @param left new left coordinate. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawImage DrawImage} instance, for chaining setter calls
     */
    public DrawImage setLeft(int left) {
        return (DrawImage)setAttribute("left", left, true);
    }

    /**
     * Left coordinate in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current left value. Default value is 0
     */
    public int getLeft()  {
        return (int)Math.round(getAttributeAsDouble("left"));
    }

    /**
     * Left coordinate in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current left value. Default value is 0
     */
    public double getLeftAsDouble()  {
        return getAttributeAsDouble("left");
    }
    

    /**
     * URL to the image file.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the URL of the image displayed.
     *
     * @param src new URL. Default value is "blank.png"
     * @return {@link com.smartgwt.client.widgets.drawing.DrawImage DrawImage} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.URL URL 
     */
    public DrawImage setSrc(String src) {
        return (DrawImage)setAttribute("src", src, true);
    }

    /**
     * URL to the image file.
     *
     * @return Current src value. Default value is "blank.png"
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }
    

    /**
     * Title (tooltip hover text) for this image.
     *
     * @param title New title value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTitle(String title)  throws IllegalStateException {
        setAttribute("title", title, false);
    }

    /**
     * Title (tooltip hover text) for this image.
     *
     * @return Current title value. Default value is null
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    /**
     * Top coordinate in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the top coordinate of the drawImage.
     *
     * @param top new top coordinate. Default value is 0
     * @return {@link com.smartgwt.client.widgets.drawing.DrawImage DrawImage} instance, for chaining setter calls
     */
    public DrawImage setTop(int top) {
        return (DrawImage)setAttribute("top", top, true);
    }

    /**
     * Top coordinate in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current top value. Default value is 0
     */
    public int getTop()  {
        return (int)Math.round(getAttributeAsDouble("top"));
    }

    /**
     * Top coordinate in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current top value. Default value is 0
     */
    public double getTopAsDouble()  {
        return getAttributeAsDouble("top");
    }
    

    /**
     * Configures whether a Matrix filter is used to render this DrawImage in Internet Explorer 6-8. <p> With the default of
     * <code>null</code>, matrix filters may be used unless {@link com.smartgwt.client.widgets.Canvas#neverUseFilters
     * neverUseFilters} has been set.  When set explicitly to <code>true</code>, matrix filters may be used even if
     * <code>neverUseFilters</code> is <code>true</code>. <p> This setting exists due to platform limitations in Internet
     * Explorer where it is impossible to implement shearing transforms on an image without a matrix filter.  Shear can arise
     * by: <ul> <li>specifying a nonzero {@link com.smartgwt.client.widgets.drawing.DrawItem#getXShearFactor xShearFactor} or
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#getYShearFactor yShearFactor},</li> <li>specifying a nonuniform
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#getScale scale} (where the scale values along the x- and
     * y-dimensions are not equal) and a nonzero {@link com.smartgwt.client.widgets.drawing.DrawItem#getRotation rotation},
     * or</li> <li>using  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs} on a rotated DrawImage. </ul> When prohibited from
     * using a matrix filter, DrawImage will ignore the shearing components of its local transform.  If any of the above
     * conditions are met then the DrawImage might not be drawn correctly.  Setting <code>useMatrixFilter</code> to
     * <code>true</code> avoids this possibility but it also suffers from a range of side-effects mentioned {@link
     * com.smartgwt.client.docs.IEFilters here}.
     *
     * @param useMatrixFilter New useMatrixFilter value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.DrawImage DrawImage} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.IEFilters IEFilters overview and related methods
     */
    public DrawImage setUseMatrixFilter(Boolean useMatrixFilter)  throws IllegalStateException {
        return (DrawImage)setAttribute("useMatrixFilter", useMatrixFilter, false);
    }

    /**
     * Configures whether a Matrix filter is used to render this DrawImage in Internet Explorer 6-8. <p> With the default of
     * <code>null</code>, matrix filters may be used unless {@link com.smartgwt.client.widgets.Canvas#neverUseFilters
     * neverUseFilters} has been set.  When set explicitly to <code>true</code>, matrix filters may be used even if
     * <code>neverUseFilters</code> is <code>true</code>. <p> This setting exists due to platform limitations in Internet
     * Explorer where it is impossible to implement shearing transforms on an image without a matrix filter.  Shear can arise
     * by: <ul> <li>specifying a nonzero {@link com.smartgwt.client.widgets.drawing.DrawItem#getXShearFactor xShearFactor} or
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#getYShearFactor yShearFactor},</li> <li>specifying a nonuniform
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#getScale scale} (where the scale values along the x- and
     * y-dimensions are not equal) and a nonzero {@link com.smartgwt.client.widgets.drawing.DrawItem#getRotation rotation},
     * or</li> <li>using  {@link com.smartgwt.client.types.KnobType#RESIZE} {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getKnobs control knobs} on a rotated DrawImage. </ul> When prohibited from
     * using a matrix filter, DrawImage will ignore the shearing components of its local transform.  If any of the above
     * conditions are met then the DrawImage might not be drawn correctly.  Setting <code>useMatrixFilter</code> to
     * <code>true</code> avoids this possibility but it also suffers from a range of side-effects mentioned {@link
     * com.smartgwt.client.docs.IEFilters here}.
     *
     * @return Current useMatrixFilter value. Default value is null
     * @see com.smartgwt.client.docs.IEFilters IEFilters overview and related methods
     */
    public Boolean getUseMatrixFilter()  {
        return getAttributeAsBoolean("useMatrixFilter");
    }
    

    /**
     * Width in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set the width of the drawImage.
     *
     * @param width new width. Default value is 16
     * @return {@link com.smartgwt.client.widgets.drawing.DrawImage DrawImage} instance, for chaining setter calls
     */
    public DrawImage setWidth(int width) {
        return (DrawImage)setAttribute("width", width, true);
    }

    /**
     * Width in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current width value. Default value is 16
     */
    public int getWidth()  {
        return (int)Math.round(getAttributeAsDouble("width"));
    }

    /**
     * Width in pixels relative to the {@link com.smartgwt.client.widgets.drawing.DrawPane local coordinate system}.
     *
     * @return Current width value. Default value is 16
     */
    public double getWidthAsDouble()  {
        return getAttributeAsDouble("width");
    }
    

    // ********************* Methods ***********************
	/**
     * Get the center point of the image.
     *
     * @return the center point
     */
    public native Point getCenter() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCenter", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCenter();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.drawing.Point::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Move the drawImage by the specified delta
     * @param dX number of pixels to move horizontally
     * @param dY number of pixels to move vertically
     */
    public native void moveBy(int dX, int dY) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveBy", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveBy(dX, dY);
    }-*/;

	/**
     * Move the drawImage to the specified position
     * @param left new left coordinate
     * @param top new top coordinate
     */
    public native void moveTo(Integer left, Integer top) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveTo", "Integer,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveTo(left == null ? null : left.@java.lang.Integer::intValue()(), top == null ? null : top.@java.lang.Integer::intValue()());
    }-*/;

	/**
     * Updates the drawImage to match the specified coordinates and size in  {@link
     * com.smartgwt.client.widgets.drawing.DrawPane local coordinates}.
     * @param left new left coordinate
     * @param top new top coordinate
     * @param width new width
     * @param height new height
     */
    public native void setRect(Integer left, Integer top, Integer width, Integer height) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setRect", "Integer,Integer,Integer,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setRect(left == null ? null : left.@java.lang.Integer::intValue()(), top == null ? null : top.@java.lang.Integer::intValue()(), width == null ? null : width.@java.lang.Integer::intValue()(), height == null ? null : height.@java.lang.Integer::intValue()());
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
     * @param drawImageProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DrawImage drawImageProperties) /*-{
        if (drawImageProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DrawImage.@java.lang.Object::getClass()(), "setDefaultProperties", drawImageProperties.@java.lang.Object::getClass()());
        }
        drawImageProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = drawImageProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.DrawImage.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DrawImageLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.height = getAttributeAsString("height");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawImage.height:" + t.getMessage() + "\n";
        }
        try {
            s.left = getAttributeAsString("left");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawImage.left:" + t.getMessage() + "\n";
        }
        try {
            s.src = getAttributeAsString("src");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawImage.src:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawImage.title:" + t.getMessage() + "\n";
        }
        try {
            s.top = getAttributeAsString("top");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawImage.top:" + t.getMessage() + "\n";
        }
        try {
            s.useMatrixFilter = getAttributeAsString("useMatrixFilter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawImage.useMatrixFilter:" + t.getMessage() + "\n";
        }
        try {
            s.width = getAttributeAsString("width");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawImage.width:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DrawImageLogicalStructure s = new DrawImageLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
