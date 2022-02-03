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
 * A special kind of {@link com.smartgwt.client.data.DataSource#getClientOnly client-only DataSource} that can be
 * configured with {@link com.smartgwt.client.data.MockDataSource#getMockData "mock data"} - a simple text format for table
 * or tree data. <p> MockDataSources are produced by the Reify Mockup Importer when starting from mockup formats that use
 * the mock data format.  The docs for the  {@link com.smartgwt.client.docs.BalsamiqImport Reify Mockup Importer} explain
 * various steps for converting a <code>MockDataSource</code> to a real DataSource. <p> <code>MockDataSource</code> is
 * primarily intended as a temporary form of DataSource used during the process of converting a mockup into a real
 * application.  Generally, if creating a client-only DataSource in  Java, there is no reason to use the mock data format,
 * as the mock data is not especially readable when written as a String literal.  The mock data format <i>can</i> be a
 * slightly more compact and readable as compared to declaring {@link com.smartgwt.client.data.DataSource#getCacheData
 * DataSource.cacheData} in XML.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("MockDataSource")
public class MockDataSource extends DataSource {

    public static MockDataSource getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (MockDataSource) obj;
        } else {
            return new MockDataSource(jsObj);
        }
    }
        


    public MockDataSource(){
        scClassName = "MockDataSource";
    }

    public MockDataSource(JavaScriptObject jsObj){
        scClassName = "MockDataSource";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * Data intended for a {@link com.smartgwt.client.widgets.grid.ListGrid} or {@link
     * com.smartgwt.client.widgets.tree.TreeGrid}, expressed in a simple text format popularized by mockup tools such as <a
     * href='http://balsamiq.com' target='_blank'>http://balsamiq.com</a> and now commonly supported in a variety of mockup
     * tools. <p> Balsamiq publishes documentation of the grid format  <a
     * href='http://support.balsamiq.com/customer/portal/articles/110188-working-with-data-grids-tables'
     * target='_blank'>here</a>, with a simple example of using tree-specific formatting <a
     * href='https://support.mybalsamiq.com/projects/uilibrary/Tree%20Pane' target='_blank'>here</a>. <p> An alternative format
     * of data consisting of an array of {@link com.smartgwt.client.data.Record Records} can also be provided. In this case the
     * records are converted to "grid" {@link com.smartgwt.client.types.MockDataType format}.
     *
     * @param mockData New mockData value. Default value is "md"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setMockData(String mockData)  throws IllegalStateException {
        setAttribute("mockData", mockData, false);
    }

    /**
     * Data intended for a {@link com.smartgwt.client.widgets.grid.ListGrid} or {@link
     * com.smartgwt.client.widgets.tree.TreeGrid}, expressed in a simple text format popularized by mockup tools such as <a
     * href='http://balsamiq.com' target='_blank'>http://balsamiq.com</a> and now commonly supported in a variety of mockup
     * tools. <p> Balsamiq publishes documentation of the grid format  <a
     * href='http://support.balsamiq.com/customer/portal/articles/110188-working-with-data-grids-tables'
     * target='_blank'>here</a>, with a simple example of using tree-specific formatting <a
     * href='https://support.mybalsamiq.com/projects/uilibrary/Tree%20Pane' target='_blank'>here</a>. <p> An alternative format
     * of data consisting of an array of {@link com.smartgwt.client.data.Record Records} can also be provided. In this case the
     * records are converted to "grid" {@link com.smartgwt.client.types.MockDataType format}.
     *
     * @return Current mockData value. Default value is "md"
     */
    public String getMockData()  {
        return getAttributeAsString("mockData");
    }

    /**
     * Data intended for a {@link com.smartgwt.client.widgets.grid.ListGrid} or {@link
     * com.smartgwt.client.widgets.tree.TreeGrid}, expressed in a simple text format popularized by mockup tools such as <a
     * href='http://balsamiq.com' target='_blank'>http://balsamiq.com</a> and now commonly supported in a variety of mockup
     * tools. <p> Balsamiq publishes documentation of the grid format  <a
     * href='http://support.balsamiq.com/customer/portal/articles/110188-working-with-data-grids-tables'
     * target='_blank'>here</a>, with a simple example of using tree-specific formatting <a
     * href='https://support.mybalsamiq.com/projects/uilibrary/Tree%20Pane' target='_blank'>here</a>. <p> An alternative format
     * of data consisting of an array of {@link com.smartgwt.client.data.Record Records} can also be provided. In this case the
     * records are converted to "grid" {@link com.smartgwt.client.types.MockDataType format}.
     *
     * @param mockData New mockData value. Default value is "md"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setMockData(Record... mockData)  throws IllegalStateException {
        setAttribute("mockData", mockData, false);
    }

    /**
     * Data intended for a {@link com.smartgwt.client.widgets.grid.ListGrid} or {@link
     * com.smartgwt.client.widgets.tree.TreeGrid}, expressed in a simple text format popularized by mockup tools such as <a
     * href='http://balsamiq.com' target='_blank'>http://balsamiq.com</a> and now commonly supported in a variety of mockup
     * tools. <p> Balsamiq publishes documentation of the grid format  <a
     * href='http://support.balsamiq.com/customer/portal/articles/110188-working-with-data-grids-tables'
     * target='_blank'>here</a>, with a simple example of using tree-specific formatting <a
     * href='https://support.mybalsamiq.com/projects/uilibrary/Tree%20Pane' target='_blank'>here</a>. <p> An alternative format
     * of data consisting of an array of {@link com.smartgwt.client.data.Record Records} can also be provided. In this case the
     * records are converted to "grid" {@link com.smartgwt.client.types.MockDataType format}.
     *
     * @return Current mockData value. Default value is "md"
     */
    public Record[] getMockDataAsRecordArray()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfRecord(getAttributeAsJavaScriptObject("mockData"));
    }
    

    /**
     * Whether {@link com.smartgwt.client.data.MockDataSource#getMockData mockData} is in the "grid" or "tree" format.  See
     * {@link com.smartgwt.client.types.MockDataType}.
     *
     * @param mockDataType New mockDataType value. Default value is "grid"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setMockDataType(MockDataType mockDataType)  throws IllegalStateException {
        setAttribute("mockDataType", mockDataType == null ? null : mockDataType.getValue(), false);
    }

    /**
     * Whether {@link com.smartgwt.client.data.MockDataSource#getMockData mockData} is in the "grid" or "tree" format.  See
     * {@link com.smartgwt.client.types.MockDataType}.
     *
     * @return Current mockDataType value. Default value is "grid"
     */
    public MockDataType getMockDataType()  {
        return EnumUtil.getEnum(MockDataType.values(), getAttribute("mockDataType"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param mockDataSourceProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(MockDataSource mockDataSourceProperties) /*-{
        if (mockDataSourceProperties.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(MockDataSource.@java.lang.Object::getClass()(), "setDefaultProperties", mockDataSourceProperties.@java.lang.Object::getClass()());
        }
        mockDataSourceProperties.@com.smartgwt.client.core.BaseClass::setConfigOnly(Z)(true);
    	var properties = mockDataSourceProperties.@com.smartgwt.client.core.BaseClass::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.MockDataSource.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * See {@link #getMockDataAsRecordArray}.
     * @deprecated in favor of {@link #getMockDataAsRecordArray}.
     */
    public Record[] getMockDataAsRecord()  {
        return getMockDataAsRecordArray();
    }


}
