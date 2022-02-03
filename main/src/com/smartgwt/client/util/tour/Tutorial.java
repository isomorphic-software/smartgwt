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
 
package com.smartgwt.client.util.tour;


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
 * The Tutorial class is a specialized version of the Tour class with {@link com.smartgwt.client.util.tour.Tour#getMode
 * Tour.mode} set to "tutorial".
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Tutorial")
public class Tutorial extends Tour {

    public static Tutorial getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (Tutorial) obj;
        } else {
            return new Tutorial(jsObj);
        }
    }
        


    public Tutorial(){
        if("LGPL".equals(SC.getLicenseType()) || "Pro".equals(SC.getLicenseType())) {
                
						throw new java.lang.IllegalStateException("Tutorial is a part the Tour Module which comes with Power Edition or better. Please see smartclient.com/product for details on licensing.");
					
					} else if(SC.hasTour()==false || SC.hasWorkflow()==false || SC.hasDrawing()==false) {
					
						throw new java.lang.IllegalStateException("The standard DataBinding / Drawing and optional Tour modules are required to use the Tutorial class.  See the LoadingOptionalModules overview in the \"docs\" package of JavaDoc for instructions.");
			        }
        		scClassName = "Tutorial";
    }

    public Tutorial(JavaScriptObject jsObj){
        scClassName = "Tutorial";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * The tour mode allows step configuration to be simplified by using the context to apply appropriate defaults.
     *
     * @param mode New mode value. Default value is "tutorial"
     * @return {@link com.smartgwt.client.util.tour.Tutorial Tutorial} instance, for chaining setter calls
     */
    public Tutorial setMode(TourMode mode) {
        return (Tutorial)setAttribute("mode", mode == null ? null : mode.getValue(), true);
    }

    /**
     * The tour mode allows step configuration to be simplified by using the context to apply appropriate defaults.
     *
     * @return Current mode value. Default value is "tutorial"
     */
    public TourMode getMode()  {
        return EnumUtil.getEnum(TourMode.values(), getAttribute("mode"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
