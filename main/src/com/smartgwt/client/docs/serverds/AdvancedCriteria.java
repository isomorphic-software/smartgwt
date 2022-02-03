
/*
 * Isomorphic Smart GWT web presentation layer
 * Copyright 2000 and beyond Isomorphic Software, Inc.
 *
 * OWNERSHIP NOTICE
 * Isomorphic Software owns and reserves all rights not expressly granted in this source code,
 * including all intellectual property rights to the structure, sequence, and format of this code
 * and to all designs, interfaces, algorithms, schema, protocols, and inventions expressed herein.
 *
 *  If you have any questions, please email <sourcecode@isomorphic.com>.
 *
 *  This entire comment must accompany any portion of Isomorphic Software source code that is
 *  copied or moved from this file.
 */
/* sgwtgen */
package com.smartgwt.client.docs.serverds;

import com.smartgwt.client.types.*;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.docs.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.widgets.form.fields.FormItem;
import java.util.List;
import java.util.Map;

/**
 * AdvancedCriteria is a format for representing search criteria which may include
 *  operators on field values such as "less than", or may include sub-clauses such as several 
 *  criteria applied to fields joined by an "OR" operator.<p>
 * <b>This class is not meant to be created and used, it is actually documentation of settings
 * allowed in a DataSource descriptor (.ds.xml file), for use with Smart GWT Pro Edition and
 * above.
 * See {@link com.smartgwt.client.docs.serverds} for how to use this documentation.</b>
 * <p>
 *  <P>
 * Smart GWT DataSources can use AdvancedCriteria to search a list of {@link
 * com.smartgwt.client.data.Record}s, and
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
 * AdvancedCriteria can also be specified in {@link com.smartgwt.client.docs.ComponentXML
 * Component XML}:
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
 * An AdvancedCriteria is in effect a {@link com.smartgwt.client.docs.serverds.Criterion} that has
 * been marked with
 *  _constructor:"AdvancedCriteria" to mark it as complete criteria.
 *  <P>
 *  In addition to directly creating an AdvancedCriteria object as described above, the
 * {@link com.smartgwt.client.data.DataSource#convertCriteria DataSource.convertCriteria()} and
 * {@link com.smartgwt.client.data.DataSource#combineCriteria DataSource.combineCriteria()}
 * methods
 *  may be used to create and modify criteria based on simple fieldName / value mappings.
 *  <P>
 * {@link com.smartgwt.client.docs.XmlCriteriaShorthand Shorthand formats are allowed} when
 * defining AdvancedCriteria.
 *  <P>
 *  When passed to the Smart GWT Server, a server-side AdvancedCriteria instance (in the
 *  package com.isomorphic.criteria) can be retrieved from a DSRequest via
 *  com.isomorphic.datasource.DSRequest.getAdvancedCriteria().  These same AdvancedCriteria
 *  objects can be directly created server side, and applied to a DSRequest via
 *  setAdvancedCriteria().
 *  <P>
 * {@link com.smartgwt.client.data.RestDataSource}, the recommended way of integration with
 * servers that are not running
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
 * expected by the server, typically by implementing {@link
 * com.smartgwt.client.data.DataSource#transformRequest DataSource.transformRequest()}.
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
 * as JSON can be used directly by server code (without involvement of the browser and client-side
 * system).
 * Use the server-side API AdvancedCriteria.decodeClientCriteria() to obtain an AdvancedCriteria
 * that can 
 * then be used with a server-created DSRequest object.  Note that the client must be serialized
 * by the 
 * {@link com.smartgwt.client.util.JSONEncoder} class, using {@link
 * com.smartgwt.client.util.JSONEncoder#getDateFormat JSONEncoder.dateFormat}
 * "logicalDateConstructor".
 * @see com.smartgwt.client.widgets.tree.ResultTree#getUseSimpleCriteriaLOD
 */
public class AdvancedCriteria {

    /**
     * When set to true, causes filtering using this criteria object to follow SQL99 behavior for 
     * dealing with NULL values.  See {@link
     * com.smartgwt.client.docs.serverds.DataSource#strictSQLFiltering this discussion} for more
     * detail.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.AdvancedFilter AdvancedFilter overview and related methods
     */
    public Boolean strictSQLFiltering;

}
