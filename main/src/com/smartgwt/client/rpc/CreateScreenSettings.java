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
 
package com.smartgwt.client.rpc;


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


/**
 * Controls what class and instance substitutions, if any, are applied during a call to {@link
 * com.smartgwt.client.rpc.RPCManager#createScreen RPCManager.createScreen()}.  Classes and instances can be mapped
 * (constructed as) other classes, and existing widget instances can be returned for new ones.
 * @see com.smartgwt.client.rpc.CreateScreenSettings#getClassSubstitutions
 * @see com.smartgwt.client.rpc.CreateScreenSettings#getComponentSubstitutions
 */
@BeanFactory.FrameworkClass
public class CreateScreenSettings extends DataClass {

    public static CreateScreenSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new CreateScreenSettings(jsObj);
    }
        


    public CreateScreenSettings(){
        
    }

    public CreateScreenSettings(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Maps class names of widgets in the screen to new class names, so that if a widget would normally be constructed as an
     * instance of a class, and that class is in the map, it's instead constructed as an instance of the new class.
     *
     * @param classSubstitutions New classSubstitutions value. Default value is null
     * @return {@link com.smartgwt.client.rpc.CreateScreenSettings CreateScreenSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#createScreen
     */
    public CreateScreenSettings setClassSubstitutions(Map classSubstitutions) {
        return (CreateScreenSettings)setAttribute("classSubstitutions", classSubstitutions);
    }

    /**
     * Maps class names of widgets in the screen to new class names, so that if a widget would normally be constructed as an
     * instance of a class, and that class is in the map, it's instead constructed as an instance of the new class.
     *
     * @return Current classSubstitutions value. Default value is null
     * @see com.smartgwt.client.rpc.RPCManager#createScreen
     */
    public Map getClassSubstitutions()  {
        return getAttributeAsMap("classSubstitutions");
    }
    

    /**
     * Defines the map of new widget  ids to existing class instances, or to new instances that will be of a different class. 
     * A substituted class instance is returned immediately from  Class.create() without modification.  Otherwise, the
     * constructor for the new instance is run, but targeting the substituted class rather than the original. <P> Note that
     * where we return an existing instance, not even its {@link com.smartgwt.client.widgets.Canvas#getID Canvas.ID} will be
     * changed.  An alternative is programmtic replacement using {@link com.smartgwt.client.widgets.layout.Layout#replaceMember
     * Layout.replaceMember()}.
     *
     * @param componentSubstitutions New componentSubstitutions value. Default value is null
     * @return {@link com.smartgwt.client.rpc.CreateScreenSettings CreateScreenSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#createScreen
     */
    public CreateScreenSettings setComponentSubstitutions(Map componentSubstitutions) {
        return (CreateScreenSettings)setAttribute("componentSubstitutions", componentSubstitutions);
    }

    /**
     * Defines the map of new widget  ids to existing class instances, or to new instances that will be of a different class. 
     * A substituted class instance is returned immediately from  Class.create() without modification.  Otherwise, the
     * constructor for the new instance is run, but targeting the substituted class rather than the original. <P> Note that
     * where we return an existing instance, not even its {@link com.smartgwt.client.widgets.Canvas#getID Canvas.ID} will be
     * changed.  An alternative is programmtic replacement using {@link com.smartgwt.client.widgets.layout.Layout#replaceMember
     * Layout.replaceMember()}.
     *
     * @return Current componentSubstitutions value. Default value is null
     * @see com.smartgwt.client.rpc.RPCManager#createScreen
     */
    public Map getComponentSubstitutions()  {
        return getAttributeAsMap("componentSubstitutions");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
