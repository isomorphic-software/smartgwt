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
 
package com.smartgwt.client.widgets.drawing;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
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
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * DrawItem subclass to render a single-line text label.
 */
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

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
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
     * @param alignment . See {@link com.smartgwt.client.docs.String String}. Default value is "start"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setAlignment(String alignment)  throws IllegalStateException {
        setAttribute("alignment", alignment, false);
    }

    /**
     * Sets the text alignment from the x position. Similar to html5 context.textAlign, eg "start", "center", "end"
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getAlignment()  {
        return getAttributeAsString("alignment");
    }


    /**
     * This is the content that will exist as the label.
     *
     * @param contents . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setContents(String contents)  throws IllegalStateException {
        setAttribute("contents", contents, false);
    }

    /**
     * This is the content that will exist as the label.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getContents()  {
        return getAttributeAsString("contents");
    }


    /**
     * Font family name, similar to the CSS font-family attribute.
     *
     * @param fontFamily . See {@link com.smartgwt.client.docs.String String}. Default value is "Tahoma"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFontFamily(String fontFamily)  throws IllegalStateException {
        setAttribute("fontFamily", fontFamily, false);
    }

    /**
     * Font family name, similar to the CSS font-family attribute.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getFontFamily()  {
        return getAttributeAsString("fontFamily");
    }


    /**
     * Font size, similar to the CSS font-size attribute.
     *
     * @param fontSize fontSize Default value is 18
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFontSize(int fontSize)  throws IllegalStateException {
        setAttribute("fontSize", fontSize, false);
    }

    /**
     * Font size, similar to the CSS font-size attribute.
     *
     * @return int
     */
    public int getFontSize()  {
        return getAttributeAsInt("fontSize");
    }


    /**
     * Font style, similar to the CSS font-style attribute, eg "normal", "italic".
     *
     * @param fontStyle . See {@link com.smartgwt.client.docs.String String}. Default value is "normal"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFontStyle(String fontStyle)  throws IllegalStateException {
        setAttribute("fontStyle", fontStyle, false);
    }

    /**
     * Font style, similar to the CSS font-style attribute, eg "normal", "italic".
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getFontStyle()  {
        return getAttributeAsString("fontStyle");
    }


    /**
     * Font weight, similar to the CSS font-weight attribute, eg "normal", "bold".
     *
     * @param fontWeight . See {@link com.smartgwt.client.docs.String String}. Default value is "bold"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setFontWeight(String fontWeight)  throws IllegalStateException {
        setAttribute("fontWeight", fontWeight, false);
    }

    /**
     * Font weight, similar to the CSS font-weight attribute, eg "normal", "bold".
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getFontWeight()  {
        return getAttributeAsString("fontWeight");
    }


    /**
     * Sets the amount from the left of its positioning that the element should be placed.
     *
     * @param left left Default value is 0
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
     * Rotation in degrees. <p><b>NOTE:</b> For best results, only use rotation values 0, 90, 180, and 270 with DrawLabels.
     *
     * @param rotation rotation Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setRotation(float rotation)  throws IllegalStateException {
        setAttribute("rotation", rotation, false);
    }

    /**
     * Rotation in degrees. <p><b>NOTE:</b> For best results, only use rotation values 0, 90, 180, and 270 with DrawLabels.
     *
     * @return float
     */
    public float getRotation()  {
        return getAttributeAsFloat("rotation");
    }


    /**
     * Sets the amount from the top of its positioning that the element should be placed.
     *
     * @param top top Default value is 0
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
     * Move both the start and end points of the line by a relative amount.
     * @param left change to left coordinate in pixels
     * @param top change to top coordinate in pixels
     */
    public native void moveBy(int left, int top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveBy(left, top);
    }-*/;
	/**
     * Move the label to the absolute x, y coordinates
     * @param left new startLeft coordinate in pixels
     * @param top new startTop coordinate in pixels
     */
    public native void moveTo(int left, int top) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.moveTo(left, top);
    }-*/;
	/**
     * Rotate the label by the absolute rotation in degrees
     * @param degrees number of degrees to rotate
     */
    public native void rotateTo(float degrees) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.rotateTo(degrees);
    }-*/;

	/**
     * Rotate the label by the absolute rotation in degrees
     * @param degrees number of degrees to rotate
     */
    public native void rotateTo(double degrees) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.rotateTo(degrees);
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
     * @param drawLabelProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DrawLabel drawLabelProperties) /*-{
    	var properties = $wnd.isc.addProperties({},drawLabelProperties.@com.smartgwt.client.core.BaseClass::getConfig()());
    	delete properties.ID;
        $wnd.isc.DrawLabel.addProperties(properties);
    }-*/;

    // ***********************************************************

}



