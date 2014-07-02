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

/**
 * DrawItem subclass to render a single-line text label.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawLabel")
public class DrawLabel extends DrawItem {

    public static DrawLabel getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (DrawLabel) obj;
        } else {
            return new DrawLabel(jsObj);
        }
    }


    public DrawLabel(){
        scClassName = "DrawLabel";
    }

    public DrawLabel(JavaScriptObject jsObj){
        scClassName = "DrawLabel";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Sets the text alignment from the x position. Similar to html5 context.textAlign, eg "start", "center", "end"
     *
     * @param alignment  Default value is "start"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setAlignment(String alignment)  throws IllegalStateException {
        setAttribute("alignment", alignment, false);
    }

    /**
     * Sets the text alignment from the x position. Similar to html5 context.textAlign, eg "start", "center", "end"
     *
     * @return String
     */
    public String getAlignment()  {
        return getAttributeAsString("alignment");
    }
    

    /**
     * This is the content that will exist as the label.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets this DrawLabel's {@link com.smartgwt.client.widgets.drawing.DrawLabel#getContents contents}.
     *
     * @param contents the new contents.. Default value is null
     */
    public void setContents(String contents) {
        setAttribute("contents", contents, true);
    }

    /**
     * This is the content that will exist as the label.
     *
     * @return String
     */
    public String getContents()  {
        return getAttributeAsString("contents");
    }
    

    /**
     * Font family name, similar to the CSS font-family attribute.
     *
     * @param fontFamily  Default value is "Tahoma"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFontFamily(String fontFamily)  throws IllegalStateException {
        setAttribute("fontFamily", fontFamily, false);
    }

    /**
     * Font family name, similar to the CSS font-family attribute.
     *
     * @return String
     */
    public String getFontFamily()  {
        return getAttributeAsString("fontFamily");
    }
    

    /**
     * Font size in pixels, similar to the CSS font-size attribute.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets this DrawLabel's {@link com.smartgwt.client.widgets.drawing.DrawLabel#getFontSize fontSize}.
     *
     * @param fontSize the new font size in pixels.. Default value is 18
     */
    public void setFontSize(int fontSize) {
        setAttribute("fontSize", fontSize, true);
    }

    /**
     * Font size in pixels, similar to the CSS font-size attribute.
     *
     * @return int
     */
    public int getFontSize()  {
        return getAttributeAsInt("fontSize");
    }
    

    /**
     * Font style, similar to the CSS font-style attribute, eg "normal", "italic".
     *
     * @param fontStyle  Default value is "normal"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFontStyle(String fontStyle)  throws IllegalStateException {
        setAttribute("fontStyle", fontStyle, false);
    }

    /**
     * Font style, similar to the CSS font-style attribute, eg "normal", "italic".
     *
     * @return String
     */
    public String getFontStyle()  {
        return getAttributeAsString("fontStyle");
    }
    

    /**
     * Font weight, similar to the CSS font-weight attribute, eg "normal", "bold".
     *
     * @param fontWeight  Default value is "bold"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFontWeight(String fontWeight)  throws IllegalStateException {
        setAttribute("fontWeight", fontWeight, false);
    }

    /**
     * Font weight, similar to the CSS font-weight attribute, eg "normal", "bold".
     *
     * @return String
     */
    public String getFontWeight()  {
        return getAttributeAsString("fontWeight");
    }
    

    /**
     * DrawLabel only supports the  {@link com.smartgwt.client.types.KnobType#MOVE} knob type.
     *
     * @param knobs  Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setKnobs
     * 
     * 
     */
    public void setKnobs(KnobType... knobs)  throws IllegalStateException {
        setAttribute("knobs", knobs, false);
    }

    /**
     * DrawLabel only supports the  {@link com.smartgwt.client.types.KnobType#MOVE} knob type.
     *
     * @return KnobType...
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * 
     * 
     */
    public KnobType[] getKnobs()  {
        final String[] strings = getAttributeAsStringArray("knobs");
        return EnumUtil.getEnums(KnobType.values(), strings, strings == null ? null : new KnobType[strings.length]);
    }
    

    /**
     * Sets the amount from the left of its positioning that the element should be placed.
     *
     * @param left  Default value is 0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setLeft(int left)  throws IllegalStateException {
        setAttribute("left", left, false);
    }

    /**
     * Sets the amount from the left of its positioning that the element should be placed.
     *
     * @return int
     */
    public int getLeft()  {
        return getAttributeAsInt("left");
    }
    

    /**
     * The text color of the label.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the text color of the label.
     *
     * @param lineColor new text color. See {@link com.smartgwt.client.docs.CSSColor CSSColor} . Default value is "#808080"
     */
    public void setLineColor(String lineColor) {
        setAttribute("lineColor", lineColor, true);
    }

    /**
     * The text color of the label.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSColor CSSColor} 
     */
    public String getLineColor()  {
        return getAttributeAsString("lineColor");
    }
    

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawLabel#getTop top} {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getLeft left} corner.  The positive direction is clockwise. <p>
     * <b>NOTE:</b> In Internet Explorer 8 and earlier, only rotation by 0 or 90 degrees is supported.
     *
     * @param rotation  Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public void setRotation(float rotation)  throws IllegalStateException {
        setAttribute("rotation", rotation, false);
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawLabel#getTop top} {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getLeft left} corner.  The positive direction is clockwise. <p>
     * <b>NOTE:</b> In Internet Explorer 8 and earlier, only rotation by 0 or 90 degrees is supported.
     *
     * @return float
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getRotation()  {
        return getAttributeAsFloat("rotation");
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawLabel#getTop top} {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getLeft left} corner.  The positive direction is clockwise. <p>
     * <b>NOTE:</b> In Internet Explorer 8 and earlier, only rotation by 0 or 90 degrees is supported.
     *
     * @param rotation  Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRotation(double rotation)  throws IllegalStateException {
        setAttribute("rotation", rotation, false);
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawLabel#getTop top} {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getLeft left} corner.  The positive direction is clockwise. <p>
     * <b>NOTE:</b> In Internet Explorer 8 and earlier, only rotation by 0 or 90 degrees is supported.
     *
     * @return double
     */
    public double getRotationAsDouble()  {
        return getAttributeAsDouble("rotation");
    }
    

    /**
     * Sets the amount from the top of its positioning that the element should be placed.
     *
     * @param top  Default value is 0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setTop(int top)  throws IllegalStateException {
        setAttribute("top", top, false);
    }

    /**
     * Sets the amount from the top of its positioning that the element should be placed.
     *
     * @return int
     */
    public int getTop()  {
        return getAttributeAsInt("top");
    }
    

    // ********************* Methods ***********************
	/**
     * Get the center point of the label.
     *
     * @return the center point
     */
    public native Point getCenter() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.getCenter();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.drawing.Point::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Change the label's {@link com.smartgwt.client.widgets.drawing.DrawLabel#getLeft left} and {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getTop top} by the specified amounts.
     * @param dX number of pixels to move horizontally
     * @param dY number of pixels to move vertically
     */
    public native void moveBy(int dX, int dY) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveBy(dX, dY);
    }-*/;



	/**
     * Move the label to the absolute x, y coordinates
     * @param left new startLeft coordinate in pixels
     * @param top new startTop coordinate in pixels
     */
    public native void moveTo(Integer left, Integer top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveTo(left == null ? null : left.@java.lang.Integer::intValue()(), top == null ? null : top.@java.lang.Integer::intValue()());
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
     * @param drawLabelProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DrawLabel drawLabelProperties) /*-{
    	var properties = $wnd.isc.addProperties({},drawLabelProperties.@com.smartgwt.client.core.BaseClass::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.DrawLabel.addProperties(properties);
    }-*/;

    // ***********************************************************

}


