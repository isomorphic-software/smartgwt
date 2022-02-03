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
 
package com.smartgwt.client.widgets.viewer;


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
 * A DetailViewerRecord is an object literal with properties that define the values for the
 *  various fields of a {@link com.smartgwt.client.widgets.viewer.DetailViewer}.
 *  <p>
 *  For example a DetailViewer that defines the following fields:
 *  <pre>
 *  fields : [
 *      {name: "field1"},
 *      {name: "field2"}
 *  ],
 *  </pre>
 *  Might have the following data:
 *  <pre>
 *  data : [
 *      {field1: "foo", field2: "bar"},
 *      {field1: "field1 value", field2: "field2 value"}
 *  ]
 *  </pre>
 *  Each element in the data array above is an instance of DetailViewerRecord - notice that
 *  these are specified simply as object literals with properties.
 */
@BeanFactory.FrameworkClass
public class DetailViewerRecord extends Record {

    public static DetailViewerRecord getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof DetailViewerRecord) {
            existingObj.setJsObj(jsObj);
            return (DetailViewerRecord)existingObj;
        } else

        {
            return new DetailViewerRecord(jsObj);
        }
    }
        


    public DetailViewerRecord(){
        
    }

    public DetailViewerRecord(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * The HTML to display in this record for fields with type set to "link". This overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getLinkText DetailViewerField.linkText}.
     *
     * @param linkText New linkText value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewerRecord DetailViewerRecord} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setType
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setLinkText
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setLinkTextProperty
     */
    public DetailViewerRecord setLinkText(String linkText) {
        return (DetailViewerRecord)setAttribute("linkText", linkText);
    }

    /**
     * The HTML to display in this record for fields with type set to "link". This overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getLinkText DetailViewerField.linkText}.
     *
     * @return Current linkText value. Default value is null
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getType
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getLinkText
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#getLinkTextProperty
     */
    public String getLinkText()  {
        return getAttributeAsString("linkText");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
