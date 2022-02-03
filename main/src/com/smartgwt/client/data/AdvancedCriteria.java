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
 * AdvancedCriteria is a format for representing search criteria which may include
 *  operators on field values such as "less than", or may include sub-clauses such as several 
 *  criteria applied to fields joined by an "OR" operator.
 *  <P>
 *  Smart GWT DataSources can use AdvancedCriteria to search a list of {@link com.smartgwt.client.data.Record}s, and
 *  the Smart GWT Java Server can translate AdvancedCriteria to either SQL or Hibernate
 *  queries (<b>Note:</b> The server-side AdvancedCriteria handling feature is only available 
 *  with the <b>Power</b> and <b>Enterprise</b> Editions of Smart GWT; the Pro Edition is 
 *  limited to ordinary criteria handling on the server side).<p>
 *  If the entire dataset is cached locally, Smart GWT can perform AdvancedCriteria filtering 
 *  on the client, avoiding a server call.
 *  <P>
 *  
 *  
 *  AdvancedCriteria objects can be created directly in java. For example:
 *  <pre>
 *  AdvancedCriteria criteria = new AdvancedCriteria(OperatorId.AND, new Criterion[]{
 *      new Criterion("salary", OperatorId.LESS_THAN, 80000),
 *      new AdvancedCriteria(OperatorId.OR, new Criterion[]{
 *          new Criterion("title", OperatorId.ICONTAINS, "Manager"),
 *          new Criterion("reports", OperatorId.NOT_NULL)
 *      })
 *  });
 *  </pre>
 *  
 *  AdvancedCriteria can also be specified in {@link com.smartgwt.client.docs.ComponentXML Component XML}:
 *  <pre>
 *  &lt;AdvancedCriteria operator="and" _constructor="AdvancedCriteria"&gt;
 *      &lt;criteria&gt;
 *          &lt;Criterion fieldName="salary" operator="lessThan"&gt;
 *              &lt;value xsi:type="xsd:float"&gt;80000&lt;/value&gt;
 *          &lt;/Criterion&gt;
 *          &lt;Criterion operator="or"&gt;
 *              &lt;criteria&gt;
 *                  &lt;Criterion fieldName="title" operator="iContains"&gt;
 *                      &lt;value xsi:type="xsd:text"&gt;Manager&lt;/value&gt;
 *                  &lt;/Criterion&gt;
 *                  &lt;Criterion fieldName="reports" operator="notNull"/&gt;
 *              &lt;/criteria&gt;
 *          &lt;/Criterion&gt;
 *          &lt;Criterion fieldName="startDate" operator="greaterThan"&gt;
 *              &lt;value xsi:type="xsd:datetime"&gt;2014-01-01T05:00:00.000&lt;/value&gt;
 *          &lt;/Criterion&gt;
 *      &lt;/criteria&gt;
 *  &lt;/AdvancedCriteria&gt;
 *  </pre>
 *  An AdvancedCriteria is in effect a {@link com.smartgwt.client.data.Criterion} that has been marked with 
 *  _constructor:"AdvancedCriteria" to mark it as complete criteria.
 *  <P>
 *  In addition to directly creating an AdvancedCriteria object as described above, the
 * {@link com.smartgwt.client.data.DataSource#convertCriteria DataSource.convertCriteria()} and {@link
 * com.smartgwt.client.data.DataSource#combineCriteria DataSource.combineCriteria()} methods
 *  may be used to create and modify criteria based on simple fieldName / value mappings.
 *  <P>
 *  When passed to the Smart GWT Server, a server-side AdvancedCriteria instance (in the
 *  package com.isomorphic.criteria) can be retrieved from a DSRequest via
 *  com.isomorphic.datasource.DSRequest.getAdvancedCriteria().  These same AdvancedCriteria
 *  objects can be directly created server side, and applied to a DSRequest via
 *  setAdvancedCriteria().
 *  <P>
 *  {@link com.smartgwt.client.data.RestDataSource}, the recommended way of integration with servers that are not running
 *  the Smart GWT Server Framework, defines a standard XML and JSON serialization of
 *  <code>AdvancedCriteria</code>. Date, DateTime and Time values use the same XML Schema
 *  representation used for other XML serialization like RestDataSource. Further details can
 *  be found at {@link com.smartgwt.client.docs.DateFormatAndStorage}.
 *  <P>
 *  It's a best practice for XML representation to have <code>&lt;value&gt;</code> as a subelement
 *  with <code>xsi:type</code>. Although most systems will auto-convert criteria explicitly
 *  setting type leaves the least room for error or ambiguity.
 *  <P>
 *  For other servers, you can translate <code>AdvancedCriteria</code> into whatever format is
 * expected by the server, typically by implementing {@link com.smartgwt.client.data.DataSource#transformRequest
 * DataSource.transformRequest()}.
 *  <P>
 *  
 *  The internal representation of AdvancedCriteria is a simple JavaScript structure, available
 *  via AdvancedCriteria.getJsObj():
 *  <pre>
 *  // an AdvancedCriteria
 *  {
 *      _constructor:"AdvancedCriteria",
 *      operator:"and",
 *      criteria:[
 *          // this is a Criterion
 *          { fieldName:"salary", operator:"lessThan", value:"80000" },
 *          { operator:"or", criteria:[
 *              { fieldName:"title", operator:"iContains", value:"Manager" },
 *              { fieldName:"reports", operator:"notNull" }
 *            ]  
 *          }
 *      ]
 *  }
 *  </pre>
 *  And an AdvancedCriteria can also be created from a JavaScriptObject.  This makes
 *  AdvancedCriteria very easy to store and retrieve as JSON strings, using
 *  {@link com.smartgwt.client.util.JSON#encode JSONEncoder}.
 *  
 *  See {@link com.smartgwt.client.docs.CriteriaEditing Criteria Editing} for information about
 *  editing AdvancedCriteria in a DynamicForm.
 *  <P>
 *  When using the Smart GWT Server, AdvancedCriteria created on the client and stored 
 *  as JSON can be used directly by server code (without involvement of the browser and client-side system).
 *  Use the server-side API AdvancedCriteria.decodeClientCriteria() to obtain an AdvancedCriteria that can 
 *  then be used with a server-created DSRequest object.  Note that the client must be serialized by the 
 * {@link com.smartgwt.client.util.JSONEncoder} class, using {@link com.smartgwt.client.util.JSONEncoder#getDateFormat
 * JSONEncoder.dateFormat} "logicalDateConstructor".
 * @see com.smartgwt.client.widgets.tree.ResultTree#getUseSimpleCriteriaLOD
 */
@BeanFactory.FrameworkClass
public class AdvancedCriteria extends Criterion {

    public static AdvancedCriteria getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new AdvancedCriteria(jsObj);
    }
        


    public AdvancedCriteria(){
        markAdvancedCriteria();
    }

    public AdvancedCriteria(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * When set to true, causes filtering using this criteria object to follow SQL99 behavior for  dealing with NULL values. 
     * See {@link com.smartgwt.client.data.DataSource#getStrictSQLFiltering this discussion} for more detail.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param strictSQLFiltering New strictSQLFiltering value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public void setStrictSQLFiltering(Boolean strictSQLFiltering) {
        setAttribute("strictSQLFiltering", strictSQLFiltering);
    }

    /**
     * When set to true, causes filtering using this criteria object to follow SQL99 behavior for  dealing with NULL values. 
     * See {@link com.smartgwt.client.data.DataSource#getStrictSQLFiltering this discussion} for more detail.
     *
     * @return Current strictSQLFiltering value. Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public Boolean getStrictSQLFiltering()  {
        return getAttributeAsBoolean("strictSQLFiltering", true);
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************


    public AdvancedCriteria(Criterion c) {
        super(c);
        markAdvancedCriteria();
    }
    
    public AdvancedCriteria(OperatorId operator, Criterion[] criterias) {
        super(operator, criterias);
        markAdvancedCriteria();
    }
    
    public AdvancedCriteria(OperatorId operator) {
        super(operator);
        markAdvancedCriteria();
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator) {
        super(fieldName, operator);
        markAdvancedCriteria();
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, Integer value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    } 
    
    public AdvancedCriteria(String fieldName, OperatorId operator, String value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Float value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Date value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Boolean value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Integer[] value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }
    
    public AdvancedCriteria(String fieldName, OperatorId operator, String[] value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Float[] value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Date[] value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Boolean[] value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Date start, Date end) {
        super(fieldName, operator, start, end);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Float start, Float end) {
        super(fieldName, operator, start, end);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Integer start, Integer end) {
        super(fieldName, operator, start, end);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Long value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Long[] value) {
        super(fieldName, operator, value);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, Long start, Long end) {
        super(fieldName, operator, start, end);
        markAdvancedCriteria();
    }

    public AdvancedCriteria(String fieldName, OperatorId operator, String start, String end) {
        super(fieldName, operator, start, end);
        markAdvancedCriteria();
    }
    
    /**
    * Creates an AdvancedCriteria from a JavaScriptObject with the format described in {@link com.smartgwt.client.data.AdvancedCriteria}
     * 
     * @param jsObj the passed JavaScriptObject object
     * @return AdvancedCriteria
     */
    public static AdvancedCriteria fromJSObject (JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        return new AdvancedCriteria(jsObj);
    }
    
    /**
    * Creates an AdvancedCriteria from a JSON String in the format described in {@link com.smartgwt.client.data.AdvancedCriteria}.
    * Note that dates will not round-trip perfectly because JSON has no way of accurately representing 
    * date values, nor a method of differentiating between dates, times and datetimes.
    * 
    * To have dates, times and datetimes round-trip correctly, use asString() and fromString(), 
    * which serialize via the LOGICAL_DATE_CONSTRUCTOR mode of JSONEncoder.
    *
    * @param json the passed JSON string
    * @return AdvancedCriteria
    */
    public static AdvancedCriteria fromJSON (String json) {
        if (json == null) return null;
        return new AdvancedCriteria(JSON.decode(json));
    }
    
    /**
    * Gets a JSON encoding of an AdvancedCriteria object.  Note that dates will not round-trip
    * perfectly because JSON has no way of representing date values, nor a method of 
    * differentiating between dates, times and datetimes.
    * 
    * To have dates, times and datetimes round-trip correctly, use asString() and fromString(), 
    * which serialize via the LOGICAL_DATE_CONSTRUCTOR mode of JSONEncoder.
    * 
    * @return String    A JSON string of this AdvancedCriteria object 
    */
    public String toJSON () {
        return JSON.encode(this.getJsObj());
    }

    /**
    * Creates an AdvancedCriteria from a String in the format described in {@link com.smartgwt.client.data.AdvancedCriteria}
    * 
    * Unlike fromJSON(), dates, times and datetimes round-trip correctly, because they
    * serialize via the LOGICAL_DATE_CONSTRUCTOR mode of JSONEncoder.
    *
    * @param json the passed JSON string
    * @return AdvancedCriteria
    */
    public static AdvancedCriteria fromString (String json) {
        if (json == null) return null;
        JSONEncoder encoder = new JSONEncoder();
        encoder.setDateFormat(JSONDateFormat.LOGICAL_DATE_CONSTRUCTOR);
        return new AdvancedCriteria(encoder.decode(json));
    }
    
    /**
    * Gets a string encoding of an AdvancedCriteria object.  The return value is a JSON string,
    * except for date values, which JSON has no way of representing.
    * 
    * Unlike toJSON(), dates, times and datetimes round-trip correctly, because they
    * serialize via the LOGICAL_DATE_CONSTRUCTOR mode of JSONEncoder.
    * 
    * @return String    A string similar to JSON but containing calls to framework APIs that provide accurate round-tripping of date values
    */
    public String asString () {
        JSONEncoder encoder = new JSONEncoder();
        encoder.setDateFormat(JSONDateFormat.LOGICAL_DATE_CONSTRUCTOR);
        return encoder.encode(this.getJsObj());
    }

}
