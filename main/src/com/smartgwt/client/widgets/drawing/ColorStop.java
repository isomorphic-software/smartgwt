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


/**
 * An object containing properties that is used in Gradient types
 */
@BeanFactory.FrameworkClass
public class ColorStop extends RefDataClass {

    public static ColorStop getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof ColorStop) {
            existingObj.setJsObj(jsObj);
            return (ColorStop)existingObj;
        } else

        {
            return new ColorStop(jsObj);
        }
    }
        


    public ColorStop(){
        
    }

    public ColorStop(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public ColorStop(String color, float offset) {
        setColor(color);
		setOffset(offset);
                
    }


    // ********************* Properties / Attributes ***********************

    /**
     * eg #ff0000 or red or rgb(255,0,0)
     *
     * @param color New color value. Default value is null
     * @return {@link com.smartgwt.client.widgets.drawing.ColorStop ColorStop} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public ColorStop setColor(String color) {
        return (ColorStop)setAttribute("color", color);
    }

    /**
     * eg #ff0000 or red or rgb(255,0,0)
     *
     * @return Current color value. Default value is null
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getColor()  {
        return getAttributeAsString("color");
    }
    

    /**
     * The relative offset for the color.
     *
     * @param offset New offset value. Default value is 0.0
     * @return {@link com.smartgwt.client.widgets.drawing.ColorStop ColorStop} instance, for chaining setter calls
     */
    public ColorStop setOffset(float offset) {
        return (ColorStop)setAttribute("offset", offset);
    }

    /**
     * The relative offset for the color.
     *
     * @return Current offset value. Default value is 0.0
     */
    public float getOffset()  {
        return getAttributeAsFloat("offset");
    }
    

    /**
     * 0 is transparent, 1 is fully opaque
     *
     * @param opacity New opacity value. Default value is 1.0
     * @return {@link com.smartgwt.client.widgets.drawing.ColorStop ColorStop} instance, for chaining setter calls
     */
    public ColorStop setOpacity(float opacity) {
        return (ColorStop)setAttribute("opacity", opacity);
    }

    /**
     * 0 is transparent, 1 is fully opaque
     *
     * @return Current opacity value. Default value is 1.0
     */
    public float getOpacity()  {
        return getAttributeAsFloat("opacity");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
