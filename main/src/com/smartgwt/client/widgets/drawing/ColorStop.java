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
 * An object containing properties that is used in Gradient types
 */
public class ColorStop extends RefDataClass {

    public static ColorStop getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new ColorStop(jsObj);
    }

    public ColorStop(){
        
    }

    public ColorStop(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
     * eg #ff0000 or red or rgb(255,0,0)
     *
     * @param color color Default value is null
     */
    public void setColor(String color) {
        setAttribute("color", color);
    }

    /**
     * eg #ff0000 or red or rgb(255,0,0)
     *
     *
     * @return String
     */
    public String getColor()  {
        return getAttributeAsString("color");
    }

    /**
     * The relative offset for the color.
     *
     * @param offset offset Default value is 0.0
     */
    public void setOffset(float offset) {
        setAttribute("offset", offset);
    }

    /**
     * The relative offset for the color.
     *
     *
     * @return float
     */
    public float getOffset()  {
        return getAttributeAsFloat("offset");
    }

    /**
     * 0 is transparent, 1 is fully opaque
     *
     * @param opacity opacity Default value is 1.0
     */
    public void setOpacity(float opacity) {
        setAttribute("opacity", opacity);
    }

    /**
     * 0 is transparent, 1 is fully opaque
     *
     *
     * @return float
     */
    public float getOpacity()  {
        return getAttributeAsFloat("opacity");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        



    public static ColorStop[] convertToColorStopArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new ColorStop[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        ColorStop[] objects = new ColorStop[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject componentJS = componentsj[i];
            ColorStop obj = (ColorStop) RefDataClass.getRef(componentJS);
            if (obj == null) obj = new ColorStop(componentJS);
            objects[i] = obj;
        }
        return objects;
    }

}



