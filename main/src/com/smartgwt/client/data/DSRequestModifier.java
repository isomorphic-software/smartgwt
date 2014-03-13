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
 
package com.smartgwt.client.data;


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
 * <b>Some elements of this feature are only available with Power or better licenses.</b> See  <a
 * href=http://smartclient.com/product>smartclient.com/product</a> for details. <p> An object that modifies a dsRequest
 * based on several available  values, including preceding responses from the same queue. You provide a list of 
 * DSRequestModifiers as the {@link com.smartgwt.client.docs.serverds.OperationBinding#criteria criteria} or {@link
 * com.smartgwt.client.docs.serverds.OperationBinding#values values} of an {@link
 * com.smartgwt.client.data.OperationBinding}. <P> A DSRequestModifier consists of a {@link
 * com.smartgwt.client.data.DSRequestModifier#getFieldName fieldName}, usually a {@link
 * com.smartgwt.client.data.DSRequestModifier#getValue value} and possibly an {@link
 * com.smartgwt.client.data.DSRequestModifier#getOperator operator} and {@link
 * com.smartgwt.client.data.DSRequestModifier#getStart start} and/or {@link
 * com.smartgwt.client.data.DSRequestModifier#getEnd end} values  (applicable to advanced criteria only).  The value, start
 * and end settings can be static, or -  with Power or better licenses - they can be expressions in the Velocity template
 * language,  which will be resolved at runtime, immediately before the DSRequest is executed.
 */
@BeanFactory.FrameworkClass
public class DSRequestModifier extends DataClass {

    public static DSRequestModifier getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new DSRequestModifier(jsObj);
    }


    public DSRequestModifier(){
        
    }

    public DSRequestModifier(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}


