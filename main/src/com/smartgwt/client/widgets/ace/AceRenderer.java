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
 
package com.smartgwt.client.widgets.ace;


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

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Internal use only.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("AceRenderer")
public class AceRenderer extends BaseClass {

    public static AceRenderer getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (AceRenderer) obj;
        } else {
            return new AceRenderer(jsObj);
        }
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        internalSetID(jsObj);
        JSOHelper.setObjectAttribute(jsObj, SC.REF, this);
        JSOHelper.setObjectAttribute(jsObj, SC.MODULE, BeanFactory.getSGWTModule());
        if (!JSOHelper.isScClassInstance(jsObj)) {
            setConfig(jsObj);
            return;
        }
        JSOHelper.setObjectAttribute(getConfig(), SC.REF, this);
        JSOHelper.setObjectAttribute(getConfig(), SC.MODULE, BeanFactory.getSGWTModule());
        this.jsObj = jsObj;
        onBind();
    }
        


    public AceRenderer(){
        scClassName = "AceRenderer";
    }

    public AceRenderer(JavaScriptObject jsObj){
        scClassName = "AceRenderer";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    private JavaScriptObject jsObj;
    
    @Override
    public boolean isCreated(){
        return this.jsObj != null;
    }

    @Override
    public JavaScriptObject getJsObj(){
        return this.jsObj;
    }

    @Override
    public JavaScriptObject getOrCreateJsObj() {
        if (!isCreated()) {
            this.jsObj = createJsObj();
            doInit();
        }
        return this.jsObj;
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Internal use only.
     */
    public void setShowGutter(Boolean showGutter) {
        setAttribute("showGutter", showGutter, true);
    }

    /**
     * Internal use only.
     */
    public Boolean getShowGutter()  {
        Boolean result = getAttributeAsBoolean("showGutter");
        return result == null ? true : result;
    }
    

    /**
     * Internal use only.
     */
    public void setShowPrintMargin(Boolean showPrintMargin) {
        setAttribute("showPrintMargin", showPrintMargin, true);
    }

    /**
     * Internal use only.
     */
    public Boolean getShowPrintMargin()  {
        Boolean result = getAttributeAsBoolean("showPrintMargin");
        return result == null ? true : result;
    }
    

    /**
     * Internal use only.
     */
    public void setTheme(String theme) {
        setAttribute("theme", theme, true);
    }

    /**
     * Internal use only.
     */
    public String getTheme()  {
        return getAttributeAsString("theme");
    }
    

    // ********************* Methods ***********************
	/**
     * Internal use only.
     */
    public native void hideCursor() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "hideCursor", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.hideCursor();
    }-*/;

	/**
     * Internal use only.
     */
    public native void showCursor() /*-{
        if (this.@com.smartgwt.client.core.BaseClass::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "showCursor", "");
        }
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.showCursor();
    }-*/;


    // ********************* Static Methods ***********************

    // ***********************************************************

}
