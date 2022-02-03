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
 
package com.smartgwt.client.util;


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
 * Settings used to control the export or serialization of a {@link com.smartgwt.client.data.DataSource} by {@link
 * com.smartgwt.client.tools.Reify#getMockDS Reify.getMockDS()}.
 */
@BeanFactory.FrameworkClass
public class MockDSExportSettings extends DataClass {

    public static MockDSExportSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new MockDSExportSettings(jsObj);
    }
        


    public MockDSExportSettings(){
        
    }

    public MockDSExportSettings(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * The {@link com.smartgwt.client.data.Criteria criteria} used to fetch the records returned as part of the export or
     * serialization.
     *
     * @param criteria New criteria value. Default value is null
     * @return {@link com.smartgwt.client.util.MockDSExportSettings MockDSExportSettings} instance, for chaining setter calls
     */
    public MockDSExportSettings setCriteria(Criteria criteria) {
        if (criteria instanceof Criterion) {
            criteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (MockDSExportSettings)setAttribute("criteria", criteria == null ? null : criteria.getJsObj());
    }

    /**
     * The {@link com.smartgwt.client.data.Criteria criteria} used to fetch the records returned as part of the export or
     * serialization.
     *
     * @return Current criteria value. Default value is null
     */
    public Criteria getCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("criteria"));
    }
    

    /**
     * Determines the format emitted by {@link com.smartgwt.client.tools.Reify#getMockDS Reify.getMockDS()}.
     *
     * @param format New format value. Default value is "xmlMockDS"
     * @return {@link com.smartgwt.client.util.MockDSExportSettings MockDSExportSettings} instance, for chaining setter calls
     */
    public MockDSExportSettings setFormat(MockDSExportFormat format) {
        return (MockDSExportSettings)setAttribute("format", format == null ? null : format.getValue());
    }

    /**
     * Determines the format emitted by {@link com.smartgwt.client.tools.Reify#getMockDS Reify.getMockDS()}.
     *
     * @return Current format value. Default value is "xmlMockDS"
     */
    public MockDSExportFormat getFormat()  {
        return EnumUtil.getEnum(MockDSExportFormat.values(), getAttribute("format"));
    }
    

    /**
     * Whether to include custom-defined {@link com.smartgwt.client.data.SimpleType SimpleTypes}.
     *
     * @param includeCustomSimpleTypes New includeCustomSimpleTypes value. Default value is false
     * @return {@link com.smartgwt.client.util.MockDSExportSettings MockDSExportSettings} instance, for chaining setter calls
     */
    public MockDSExportSettings setIncludeCustomSimpleTypes(boolean includeCustomSimpleTypes) {
        return (MockDSExportSettings)setAttribute("includeCustomSimpleTypes", includeCustomSimpleTypes);
    }

    /**
     * Whether to include custom-defined {@link com.smartgwt.client.data.SimpleType SimpleTypes}.
     *
     * @return Current includeCustomSimpleTypes value. Default value is false
     */
    public boolean getIncludeCustomSimpleTypes()  {
        Boolean result = getAttributeAsBoolean("includeCustomSimpleTypes", true);
        return result == null ? false : result;
    }
    

    /**
     * Should {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreign key} relationships be included in the
     * export or serialization of the {@link com.smartgwt.client.data.DataSource}?
     *
     * @param includeFKs New includeFKs value. Default value is true
     * @return {@link com.smartgwt.client.util.MockDSExportSettings MockDSExportSettings} instance, for chaining setter calls
     */
    public MockDSExportSettings setIncludeFKs(boolean includeFKs) {
        return (MockDSExportSettings)setAttribute("includeFKs", includeFKs);
    }

    /**
     * Should {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreign key} relationships be included in the
     * export or serialization of the {@link com.smartgwt.client.data.DataSource}?
     *
     * @return Current includeFKs value. Default value is true
     */
    public boolean getIncludeFKs()  {
        Boolean result = getAttributeAsBoolean("includeFKs", true);
        return result == null ? true : result;
    }
    

    /**
     * Should {@link com.smartgwt.client.types.FieldType image fields} be included in the export or serialization of the {@link
     * com.smartgwt.client.data.DataSource}?  They are excluded by default since the stored paths are unlikely to be correct
     * when placed in any other environment, such as Reify.
     *
     * @param includeImageFields New includeImageFields value. Default value is false
     * @return {@link com.smartgwt.client.util.MockDSExportSettings MockDSExportSettings} instance, for chaining setter calls
     */
    public MockDSExportSettings setIncludeImageFields(boolean includeImageFields) {
        return (MockDSExportSettings)setAttribute("includeImageFields", includeImageFields);
    }

    /**
     * Should {@link com.smartgwt.client.types.FieldType image fields} be included in the export or serialization of the {@link
     * com.smartgwt.client.data.DataSource}?  They are excluded by default since the stored paths are unlikely to be correct
     * when placed in any other environment, such as Reify.
     *
     * @return Current includeImageFields value. Default value is false
     */
    public boolean getIncludeImageFields()  {
        Boolean result = getAttributeAsBoolean("includeImageFields", true);
        return result == null ? false : result;
    }
    

    /**
     * The number of levels of nodes to include, for DataSources that define a {@link com.smartgwt.client.docs.TreeDataBinding
     * tree relationship} between fields by declaring a {@link com.smartgwt.client.data.DataSourceField#getForeignKey
     * foreignKey} on one field that refers to another from that same DataSource.
     *
     * @param numLevels New numLevels value. Default value is 3
     * @return {@link com.smartgwt.client.util.MockDSExportSettings MockDSExportSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.util.MockDSExportSettings#setRootCriteriaOnly
     */
    public MockDSExportSettings setNumLevels(int numLevels) {
        return (MockDSExportSettings)setAttribute("numLevels", numLevels);
    }

    /**
     * The number of levels of nodes to include, for DataSources that define a {@link com.smartgwt.client.docs.TreeDataBinding
     * tree relationship} between fields by declaring a {@link com.smartgwt.client.data.DataSourceField#getForeignKey
     * foreignKey} on one field that refers to another from that same DataSource.
     *
     * @return Current numLevels value. Default value is 3
     * @see com.smartgwt.client.util.MockDSExportSettings#getRootCriteriaOnly
     */
    public int getNumLevels()  {
        return getAttributeAsInt("numLevels");
    }
    

    /**
     * The number of rows of data to include, if more meet the {@link com.smartgwt.client.util.MockDSExportSettings#getCriteria
     * criteria}.
     *
     * @param numRows New numRows value. Default value is 20
     * @return {@link com.smartgwt.client.util.MockDSExportSettings MockDSExportSettings} instance, for chaining setter calls
     */
    public MockDSExportSettings setNumRows(int numRows) {
        return (MockDSExportSettings)setAttribute("numRows", numRows);
    }

    /**
     * The number of rows of data to include, if more meet the {@link com.smartgwt.client.util.MockDSExportSettings#getCriteria
     * criteria}.
     *
     * @return Current numRows value. Default value is 20
     */
    public int getNumRows()  {
        return getAttributeAsInt("numRows");
    }
    

    /**
     * If including {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreign key} relationships, those
     * relationships to skip.  This can be used to avoid dangling references to  {@link com.smartgwt.client.data.DataSource
     * DataSources} that are not being exported or serialized.
     *
     * @param omitRelations New omitRelations value. Default value is null
     * @return {@link com.smartgwt.client.util.MockDSExportSettings MockDSExportSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.util.MockDSExportSettings#setIncludeFKs
     */
    public MockDSExportSettings setOmitRelations(String... omitRelations) {
        return (MockDSExportSettings)setAttribute("omitRelations", omitRelations);
    }

    /**
     * If including {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreign key} relationships, those
     * relationships to skip.  This can be used to avoid dangling references to  {@link com.smartgwt.client.data.DataSource
     * DataSources} that are not being exported or serialized.
     *
     * @return Current omitRelations value. Default value is null
     * @see com.smartgwt.client.util.MockDSExportSettings#getIncludeFKs
     */
    public String[] getOmitRelations()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("omitRelations"));
    }
    

    /**
     * The properties that will be specified on the {@link com.smartgwt.client.data.DSRequest} when fetching records. You can
     * pass an array of different request properties matching the length of the <code>dsNames</code> param of {@link
     * com.smartgwt.client.tools.Reify#getMockDS Reify.getMockDS()} or {@link com.smartgwt.client.tools.Reify#showMockDS
     * Reify.showMockDS()} if you want the fetch for each {@link com.smartgwt.client.data.DataSource} made with different
     * properties.
     *
     * @param requestProperties New requestProperties value. Default value is null
     * @return {@link com.smartgwt.client.util.MockDSExportSettings MockDSExportSettings} instance, for chaining setter calls
     */
    public MockDSExportSettings setRequestProperties(DSRequest... requestProperties) {
        return (MockDSExportSettings)setAttribute("requestProperties", requestProperties);
    }

    /**
     * The properties that will be specified on the {@link com.smartgwt.client.data.DSRequest} when fetching records. You can
     * pass an array of different request properties matching the length of the <code>dsNames</code> param of {@link
     * com.smartgwt.client.tools.Reify#getMockDS Reify.getMockDS()} or {@link com.smartgwt.client.tools.Reify#showMockDS
     * Reify.showMockDS()} if you want the fetch for each {@link com.smartgwt.client.data.DataSource} made with different
     * properties.
     *
     * @return Current requestProperties value. Default value is null
     */
    public DSRequest[] getRequestProperties()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfDSRequest(getAttributeAsJavaScriptObject("requestProperties"));
    }

    /**
     * The properties that will be specified on the {@link com.smartgwt.client.data.DSRequest} when fetching records. You can
     * pass an array of different request properties matching the length of the <code>dsNames</code> param of {@link
     * com.smartgwt.client.tools.Reify#getMockDS Reify.getMockDS()} or {@link com.smartgwt.client.tools.Reify#showMockDS
     * Reify.showMockDS()} if you want the fetch for each {@link com.smartgwt.client.data.DataSource} made with different
     * properties.
     *
     * @param requestProperties New requestProperties value. Default value is null
     * @return {@link com.smartgwt.client.util.MockDSExportSettings MockDSExportSettings} instance, for chaining setter calls
     */
    public MockDSExportSettings setRequestProperties(DSRequest requestProperties) {
        JavaScriptObject config = JSOHelper.createObject();
        if (requestProperties != null) {
            JSOHelper.addProperties(config, requestProperties.getJsObj());
        }
        return (MockDSExportSettings)setAttribute("requestProperties", requestProperties == null ? null : config);
    }

    /**
     * The properties that will be specified on the {@link com.smartgwt.client.data.DSRequest} when fetching records. You can
     * pass an array of different request properties matching the length of the <code>dsNames</code> param of {@link
     * com.smartgwt.client.tools.Reify#getMockDS Reify.getMockDS()} or {@link com.smartgwt.client.tools.Reify#showMockDS
     * Reify.showMockDS()} if you want the fetch for each {@link com.smartgwt.client.data.DataSource} made with different
     * properties.
     *
     * @return Current requestProperties value. Default value is null
     */
    public DSRequest getRequestPropertiesAsDSRequest()  {
        return new DSRequest(getAttributeAsJavaScriptObject("requestProperties"));
    }
    

    /**
     * For DataSources that define a {@link com.smartgwt.client.docs.TreeDataBinding tree relationship} between fields by
     * declaring a {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} on one field that refers to
     * another from that same DataSource, should {@link com.smartgwt.client.util.MockDSExportSettings#getCriteria criteria} be
     * applied only to the root node?  If false, the criteria will be applied to all nodes.
     *
     * @param rootCriteriaOnly New rootCriteriaOnly value. Default value is false
     * @return {@link com.smartgwt.client.util.MockDSExportSettings MockDSExportSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.util.MockDSExportSettings#setNumLevels
     */
    public MockDSExportSettings setRootCriteriaOnly(boolean rootCriteriaOnly) {
        return (MockDSExportSettings)setAttribute("rootCriteriaOnly", rootCriteriaOnly);
    }

    /**
     * For DataSources that define a {@link com.smartgwt.client.docs.TreeDataBinding tree relationship} between fields by
     * declaring a {@link com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} on one field that refers to
     * another from that same DataSource, should {@link com.smartgwt.client.util.MockDSExportSettings#getCriteria criteria} be
     * applied only to the root node?  If false, the criteria will be applied to all nodes.
     *
     * @return Current rootCriteriaOnly value. Default value is false
     * @see com.smartgwt.client.util.MockDSExportSettings#getNumLevels
     */
    public boolean getRootCriteriaOnly()  {
        Boolean result = getAttributeAsBoolean("rootCriteriaOnly", true);
        return result == null ? false : result;
    }
    

    /**
     * Controls which {@link com.smartgwt.client.widgets.form.validator.Validator validators}, if any, to include in the fields
     * of the exported {@link com.smartgwt.client.data.MockDataSource}.  Since MockDataSources are client-only, server-only
     * validators are not exported.  Auto-generated validators are also not exported, since they will be recreated based on the
     * type of the field during the import process.
     *
     * @param validatorMode New validatorMode value. Default value is "standard"
     * @return {@link com.smartgwt.client.util.MockDSExportSettings MockDSExportSettings} instance, for chaining setter calls
     */
    public MockDSExportSettings setValidatorMode(MockDSExportValidatorMode validatorMode) {
        return (MockDSExportSettings)setAttribute("validatorMode", validatorMode == null ? null : validatorMode.getValue());
    }

    /**
     * Controls which {@link com.smartgwt.client.widgets.form.validator.Validator validators}, if any, to include in the fields
     * of the exported {@link com.smartgwt.client.data.MockDataSource}.  Since MockDataSources are client-only, server-only
     * validators are not exported.  Auto-generated validators are also not exported, since they will be recreated based on the
     * type of the field during the import process.
     *
     * @return Current validatorMode value. Default value is "standard"
     */
    public MockDSExportValidatorMode getValidatorMode()  {
        return EnumUtil.getEnum(MockDSExportValidatorMode.values(), getAttribute("validatorMode"));
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
