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
 * An ordinary JavaScript object containing properties that describe a radial gradient
 */
public class RadialGradient extends Gradient {

    public static RadialGradient getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new RadialGradient(jsObj);
    }

    public RadialGradient(){
        
    }

    public RadialGradient(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
     * x coordinate of outer radial
     *
     * @param cx cx Default value is null
     */
    public void setCx(String cx) {
        setAttribute("cx", cx);
    }

    /**
     * x coordinate of outer radial
     *
     *
     * @return String
     */
    public String getCx()  {
        return getAttributeAsString("cx");
    }

    /**
     * y coordinate of outer radial
     *
     * @param cy cy Default value is null
     */
    public void setCy(String cy) {
        setAttribute("cy", cy);
    }

    /**
     * y coordinate of outer radial
     *
     *
     * @return String
     */
    public String getCy()  {
        return getAttributeAsString("cy");
    }

    /**
     * x coordinate of inner radial
     *
     * @param fx fx Default value is null
     */
    public void setFx(String fx) {
        setAttribute("fx", fx);
    }

    /**
     * x coordinate of inner radial
     *
     *
     * @return String
     */
    public String getFx()  {
        return getAttributeAsString("fx");
    }

    /**
     * y coordinate of inner radial
     *
     * @param fy fy Default value is 0
     */
    public void setFy(String fy) {
        setAttribute("fy", fy);
    }

    /**
     * y coordinate of inner radial
     *
     *
     * @return String
     */
    public String getFy()  {
        return getAttributeAsString("fy");
    }

    /**
     * radius
     *
     * @param r r Default value is null
     */
    public void setR(String r) {
        setAttribute("r", r);
    }

    /**
     * radius
     *
     *
     * @return String
     */
    public String getR()  {
        return getAttributeAsString("r");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}





