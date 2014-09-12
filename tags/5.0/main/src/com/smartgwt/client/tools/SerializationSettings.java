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
 
package com.smartgwt.client.tools;


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
 * Settings to control {@link com.smartgwt.client.tools.EditContext} serialization.
 */
@BeanFactory.FrameworkClass
public class SerializationSettings extends DataClass {

    public static SerializationSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new SerializationSettings(jsObj);
    }


    public SerializationSettings(){
        
    }

    public SerializationSettings(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Overrides the default indention setting during serialization. XML defaults to indented and JSON defaults to
     * non-indented.
     *
     * @param indent  Default value is null
     */
    public void setIndent(Boolean indent) {
        setAttribute("indent", indent);
    }

    /**
     * Overrides the default indention setting during serialization. XML defaults to indented and JSON defaults to
     * non-indented.
     *
     * @return Boolean
     */
    public Boolean getIndent()  {
        return getAttributeAsBoolean("indent", true);
    }
    

    /**
     * Overrides the default component output setting during serialization. By default Canvas and DrawItem components are
     * serialized individually and referenced by their containers.
     *
     * @param outputComponentsIndividually  Default value is true
     */
    public void setOutputComponentsIndividually(Boolean outputComponentsIndividually) {
        setAttribute("outputComponentsIndividually", outputComponentsIndividually);
    }

    /**
     * Overrides the default component output setting during serialization. By default Canvas and DrawItem components are
     * serialized individually and referenced by their containers.
     *
     * @return Boolean
     */
    public Boolean getOutputComponentsIndividually()  {
        Boolean result = getAttributeAsBoolean("outputComponentsIndividually", true);
        return result == null ? true : result;
    }
    

    /**
     * When true specify DataSources in full rather than assuming they can be downloaded from the server.
     *
     * @param serverless  Default value is null
     */
    public void setServerless(Boolean serverless) {
        setAttribute("serverless", serverless);
    }

    /**
     * When true specify DataSources in full rather than assuming they can be downloaded from the server.
     *
     * @return Boolean
     */
    public Boolean getServerless()  {
        return getAttributeAsBoolean("serverless", true);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}


