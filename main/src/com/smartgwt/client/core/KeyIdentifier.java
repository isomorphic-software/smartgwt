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
 
package com.smartgwt.client.core;


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
 * Identifier for a key pressed by the user, optionally specifying whether the Shift, Control, and/or Alt keys should be
 * held or not held when the key is pressed, used by various methods.
 */
@BeanFactory.FrameworkClass
public class KeyIdentifier extends DataClass {

    public static KeyIdentifier getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new KeyIdentifier(jsObj);
    }
        


    public KeyIdentifier(){
        
    }

    public KeyIdentifier(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * If set, whether the Alt key must be held down.
     *
     * @param altKey New altKey value. Default value is null
     * @see com.smartgwt.client.util.EventHandler#altKeyDown
     */
    public void setAltKey(Boolean altKey) {
        setAttribute("altKey", altKey);
    }

    /**
     * If set, whether the Alt key must be held down.
     *
     * @return Current altKey value. Default value is null
     * @see com.smartgwt.client.util.EventHandler#altKeyDown
     */
    public Boolean getAltKey()  {
        return getAttributeAsBoolean("altKey", true);
    }
    

    /**
     * If set, whether the Control key must be held down.
     *
     * @param ctrlKey New ctrlKey value. Default value is null
     * @see com.smartgwt.client.util.EventHandler#ctrlKeyDown
     */
    public void setCtrlKey(Boolean ctrlKey) {
        setAttribute("ctrlKey", ctrlKey);
    }

    /**
     * If set, whether the Control key must be held down.
     *
     * @return Current ctrlKey value. Default value is null
     * @see com.smartgwt.client.util.EventHandler#ctrlKeyDown
     */
    public Boolean getCtrlKey()  {
        return getAttributeAsBoolean("ctrlKey", true);
    }
    

    /**
     * Name of the key.
     *
     * @param keyName New keyName value. Default value is null
     * @see com.smartgwt.client.docs.KeyName KeyName 
     */
    public void setKeyName(String keyName) {
        setAttribute("keyName", keyName);
    }

    /**
     * Name of the key.
     *
     * @return Current keyName value. Default value is null
     * @see com.smartgwt.client.docs.KeyName KeyName 
     */
    public String getKeyName()  {
        return getAttributeAsString("keyName");
    }
    

    /**
     * If set, whether the Shift key must be held down.
     *
     * @param shiftKey New shiftKey value. Default value is null
     * @see com.smartgwt.client.util.EventHandler#shiftKeyDown
     */
    public void setShiftKey(Boolean shiftKey) {
        setAttribute("shiftKey", shiftKey);
    }

    /**
     * If set, whether the Shift key must be held down.
     *
     * @return Current shiftKey value. Default value is null
     * @see com.smartgwt.client.util.EventHandler#shiftKeyDown
     */
    public Boolean getShiftKey()  {
        return getAttributeAsBoolean("shiftKey", true);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
