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

import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.ace.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * Displays one or more records "horizontally" with one property per line.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DetailViewer")
public class DetailViewer extends Canvas implements DataBoundComponent {

    public static DetailViewer getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DetailViewer(jsObj);
        } else {
            assert refInstance instanceof DetailViewer;
            return (DetailViewer)refInstance;
        }
    }
        


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DetailViewer.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DetailViewer.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DetailViewer.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DetailViewer.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public DetailViewer(){
        scClassName = "DetailViewer";
    }

    public DetailViewer(JavaScriptObject jsObj){
        scClassName = "DetailViewer";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************
    

    /**
     * A string (HTML acceptable) that will be written to a page to separate blocks.
     *
     * @param blockSeparator New blockSeparator value. Default value is "&lt;br&gt;&lt;br&gt;"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewer setBlockSeparator(String blockSeparator) {
        return (DetailViewer)setAttribute("blockSeparator", blockSeparator, true);
    }

    /**
     * A string (HTML acceptable) that will be written to a page to separate blocks.
     *
     * @return Current blockSeparator value. Default value is "&lt;br&gt;&lt;br&gt;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBlockSeparator()  {
        return getAttributeAsString("blockSeparator");
    }
    

    /**
     * CSS style for each block (one record's worth of data).
     *
     * @param blockStyle New blockStyle value. Default value is "detailBlock"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewer setBlockStyle(String blockStyle) {
        return (DetailViewer)setAttribute("blockStyle", blockStyle, true);
    }

    /**
     * CSS style for each block (one record's worth of data).
     *
     * @return Current blockStyle value. Default value is "detailBlock"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBlockStyle()  {
        return getAttributeAsString("blockStyle");
    }
    

    /**
     * If set, right-clicking on the DetailViewer will show a context menu that offers to bring up a {@link
     * com.smartgwt.client.widgets.FieldPicker} for configuring which fields are displayed and their order.
     *
     * @param canPickFields New canPickFields value. Default value is false
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DetailViewer setCanPickFields(Boolean canPickFields)  throws IllegalStateException {
        return (DetailViewer)setAttribute("canPickFields", canPickFields, false);
    }

    /**
     * If set, right-clicking on the DetailViewer will show a context menu that offers to bring up a {@link
     * com.smartgwt.client.widgets.FieldPicker} for configuring which fields are displayed and their order.
     *
     * @return Current canPickFields value. Default value is false
     */
    public Boolean getCanPickFields()  {
        Boolean result = getAttributeAsBoolean("canPickFields");
        return result == null ? false : result;
    }
    

    /**
     * CSS style for a normal value
     *
     * @param cellStyle New cellStyle value. Default value is "detail"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewer setCellStyle(String cellStyle) {
        return (DetailViewer)setAttribute("cellStyle", cellStyle, true);
    }

    /**
     * CSS style for a normal value
     *
     * @return Return the CSS class for a cell. Default implementation calls {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getCellStyle getCellStyle()} on the field if defined, otherwise
     * returns {@link com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle this.cellStyle}. Default value is "detail"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getCellStyle()  {
        return getAttributeAsString("cellStyle");
    }
    

    /**
     * The title for the Configure Fields menu item.
     *
     * @param configureFieldsText New configureFieldsText value. Default value is "Configure Fields..."
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DetailViewer setConfigureFieldsText(String configureFieldsText)  throws IllegalStateException {
        return (DetailViewer)setAttribute("configureFieldsText", configureFieldsText, false);
    }

    /**
     * The title for the Configure Fields menu item.
     *
     * @return Current configureFieldsText value. Default value is "Configure Fields..."
     */
    public String getConfigureFieldsText()  {
        return getAttributeAsString("configureFieldsText");
    }
    

    /**
     * A single record object or an array of them, specifying data. Note that DetailViewers do not detect changes to the data
     * array  (in other words they will not automatically re-draw when the data provided via this property is altered).
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the data displayed by this detail viewer.
     *
     * @param data new data to be displayed. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public DetailViewer setData(DetailViewerRecord[] data) {
        return (DetailViewer)setAttribute("data", data, true);
    }

    /**
     * A single record object or an array of them, specifying data. Note that DetailViewers do not detect changes to the data
     * array  (in other words they will not automatically re-draw when the data provided via this property is altered).
     *
     * @return Current data value. Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public DetailViewerRecord[] getData()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfDetailViewerRecord(getAttributeAsJavaScriptObject("data"));
    }

    /**
     * A single record object or an array of them, specifying data. Note that DetailViewers do not detect changes to the data
     * array  (in other words they will not automatically re-draw when the data provided via this property is altered).
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the data displayed by this detail viewer.
     *
     * @param data new data to be displayed. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public DetailViewer setData(Record[] data) {
        return (DetailViewer)setAttribute("data", data, true);
    }

    /**
     * A single record object or an array of them, specifying data. Note that DetailViewers do not detect changes to the data
     * array  (in other words they will not automatically re-draw when the data provided via this property is altered).
     *
     * @return Current data value. Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public Record[] getDataAsRecordArray()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfRecord(getAttributeAsJavaScriptObject("data"));
    }

    /**
     * A single record object or an array of them, specifying data. Note that DetailViewers do not detect changes to the data
     * array  (in other words they will not automatically re-draw when the data provided via this property is altered).
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the data displayed by this detail viewer.
     *
     * @param data new data to be displayed. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public DetailViewer setData(RecordList data) {
        return (DetailViewer)setAttribute("data", data == null ? null : data.getOrCreateJsObj(), true);
    }

    /**
     * A single record object or an array of them, specifying data. Note that DetailViewers do not detect changes to the data
     * array  (in other words they will not automatically re-draw when the data provided via this property is altered).
     *
     * @return Current data value. Default value is null
     * @see com.smartgwt.client.docs.Basics Basics overview and related methods
     */
    public RecordList getDataAsRecordList()  {
        return RecordList.getOrCreateRef(getAttributeAsJavaScriptObject("data"));
    }
    

    /**
     * DetailViewers do not yet support paging, and will fetch and render all available records.
     *
     * @param dataFetchMode New dataFetchMode value. Default value is "basic"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public DetailViewer setDataFetchMode(FetchMode dataFetchMode) {
        return (DetailViewer)setAttribute("dataFetchMode", dataFetchMode == null ? null : dataFetchMode.getValue(), true);
    }

    /**
     * DetailViewers do not yet support paging, and will fetch and render all available records.
     *
     * @return Current dataFetchMode value. Default value is "basic"
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public FetchMode getDataFetchMode()  {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }
    

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link
     * com.smartgwt.client.data.DSRequest DataSource requests}. <P> Can be specified as either a DataSource instance or the
     * String ID of a DataSource.
     *
     * @param dataSource New dataSource value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_ds_fields" target="examples">DataSource fields Example</a>
     */
    public DetailViewer setDataSource(DataSource dataSource) {
        return (DetailViewer)setAttribute("dataSource", dataSource == null ? null : dataSource.getOrCreateJsObj(), true);
    }

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link
     * com.smartgwt.client.data.DSRequest DataSource requests}. <P> Can be specified as either a DataSource instance or the
     * String ID of a DataSource.
     *
     * @param dataSource New dataSource value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#grid_databinding_ds_fields" target="examples">DataSource fields Example</a>
     */
    public DetailViewer setDataSource(String dataSource) {
        return (DetailViewer)setAttribute("dataSource", dataSource, true);
    }
    

    /**
     * How should Date type values be displayed in this DetailViewer by default? <P> This property specifies the default
     * DateDisplayFormat to apply to Date values displayed in this grid for all fields except those of {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getType type "time"} (See also {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getTimeFormatter timeFormatter}).<br> If {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getDatetimeFormatter datetimeFormatter} is specified, that will be
     * applied by default to fields of type <code>"datetime"</code>. <P> Note that if {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getDateFormatter DetailViewerField.dateFormatter} or {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTimeFormatter DetailViewerField.timeFormatter} are specified
     * those properties will take precedence over the component level settings. <P> If unset, date values will be formatted
     * according to the system wide  {@link com.smartgwt.client.util.DateUtil#setNormalDisplayFormat normal display format}.
     *
     * @param dateFormatter New dateFormatter value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     */
    public DetailViewer setDateFormatter(DateDisplayFormat dateFormatter) {
        return (DetailViewer)setAttribute("dateFormatter", dateFormatter == null ? null : dateFormatter.getValue(), true);
    }

    /**
     * How should Date type values be displayed in this DetailViewer by default? <P> This property specifies the default
     * DateDisplayFormat to apply to Date values displayed in this grid for all fields except those of {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getType type "time"} (See also {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getTimeFormatter timeFormatter}).<br> If {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getDatetimeFormatter datetimeFormatter} is specified, that will be
     * applied by default to fields of type <code>"datetime"</code>. <P> Note that if {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getDateFormatter DetailViewerField.dateFormatter} or {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTimeFormatter DetailViewerField.timeFormatter} are specified
     * those properties will take precedence over the component level settings. <P> If unset, date values will be formatted
     * according to the system wide  {@link com.smartgwt.client.util.DateUtil#setNormalDisplayFormat normal display format}.
     *
     * @return Current dateFormatter value. Default value is null
     */
    public DateDisplayFormat getDateFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("dateFormatter"));
    }
    

    /**
     * Display format to use for fields specified as type 'datetime'.  Default is to use the system-wide default long
     * ("normal") date time format, configured via {@link com.smartgwt.client.util.DateUtil#setNormalDatetimeDisplayFormat
     * DateUtil.setNormalDatetimeDisplayFormat()}.  Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat} to
     * change the display format for datetimes used by this  viewer.  <P> May also be specified at the field level via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getDateFormatter DetailViewerField.dateFormatter}
     *
     * @param datetimeFormatter New datetimeFormatter value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.grid.ListGridField#setDateFormatter
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewer setDatetimeFormatter(DateDisplayFormat datetimeFormatter) {
        return (DetailViewer)setAttribute("datetimeFormatter", datetimeFormatter == null ? null : datetimeFormatter.getValue(), true);
    }

    /**
     * Display format to use for fields specified as type 'datetime'.  Default is to use the system-wide default long
     * ("normal") date time format, configured via {@link com.smartgwt.client.util.DateUtil#setNormalDatetimeDisplayFormat
     * DateUtil.setNormalDatetimeDisplayFormat()}.  Specify any valid {@link com.smartgwt.client.types.DateDisplayFormat} to
     * change the display format for datetimes used by this  viewer.  <P> May also be specified at the field level via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getDateFormatter DetailViewerField.dateFormatter}
     *
     * @return Current datetimeFormatter value. Default value is null
     * @see com.smartgwt.client.widgets.grid.ListGridField#getDateFormatter
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DateDisplayFormat getDatetimeFormatter()  {
        return EnumUtil.getEnum(DateDisplayFormat.values(), getAttribute("datetimeFormatter"));
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "DetailViewerEditProxy"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public DetailViewer setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        return (DetailViewer)setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "DetailViewerEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * Text to show for an empty cell
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param emptyCellValue New emptyCellValue value. Default value is "&amp;nbsp;"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewer setEmptyCellValue(String emptyCellValue) {
        return (DetailViewer)setAttribute("emptyCellValue", emptyCellValue, true);
    }

    /**
     * Text to show for an empty cell
     *
     * @return Current emptyCellValue value. Default value is "&amp;nbsp;"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getEmptyCellValue()  {
        return getAttributeAsString("emptyCellValue");
    }
    

    /**
     * The string to display in the body of a detailViewer with no records.
     *
     * @param emptyMessage New emptyMessage value. Default value is "No items to display."
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public DetailViewer setEmptyMessage(String emptyMessage) {
        return (DetailViewer)setAttribute("emptyMessage", emptyMessage, true);
    }

    /**
     * The string to display in the body of a detailViewer with no records.
     *
     * @return Current emptyMessage value. Default value is "No items to display."
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getEmptyMessage()  {
        return getAttributeAsString("emptyMessage");
    }
    

    /**
     * CSS style to display this message in
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param emptyMessageStyle New emptyMessageStyle value. Default value is "normal"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public DetailViewer setEmptyMessageStyle(String emptyMessageStyle) {
        return (DetailViewer)setAttribute("emptyMessageStyle", emptyMessageStyle, true);
    }

    /**
     * CSS style to display this message in
     *
     * @return Current emptyMessageStyle value. Default value is "normal"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getEmptyMessageStyle()  {
        return getAttributeAsString("emptyMessageStyle");
    }
    

    /**
     * Name of the field in the DetailViewerRecord which specifies the data property for that record.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fieldIdProperty New fieldIdProperty value. Default value is "name"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     */
    public DetailViewer setFieldIdProperty(String fieldIdProperty) {
        return (DetailViewer)setAttribute("fieldIdProperty", fieldIdProperty, true);
    }

    /**
     * Name of the field in the DetailViewerRecord which specifies the data property for that record.
     *
     * @return Current fieldIdProperty value. Default value is "name"
     */
    public String getFieldIdProperty()  {
        return getAttributeAsString("fieldIdProperty");
    }
    

    /**
     * Names of properties on {@link com.smartgwt.client.widgets.viewer.DetailViewerField} for which the {@link
     * com.smartgwt.client.widgets.FieldPicker} should show an editing interface, for convenience. <P> For example, specify
     * ["decimalPad", "decimalPrecision"] to allow end users to modify {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getDecimalPad DetailViewerField.decimalPad} and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getDecimalPrecision DetailViewerField.decimalPrecision}
     * respectively.
     *
     * @param fieldPickerFieldProperties New fieldPickerFieldProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DetailViewer setFieldPickerFieldProperties(String... fieldPickerFieldProperties)  throws IllegalStateException {
        return (DetailViewer)setAttribute("fieldPickerFieldProperties", fieldPickerFieldProperties, false);
    }

    /**
     * Names of properties on {@link com.smartgwt.client.widgets.viewer.DetailViewerField} for which the {@link
     * com.smartgwt.client.widgets.FieldPicker} should show an editing interface, for convenience. <P> For example, specify
     * ["decimalPad", "decimalPrecision"] to allow end users to modify {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getDecimalPad DetailViewerField.decimalPad} and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getDecimalPrecision DetailViewerField.decimalPrecision}
     * respectively.
     *
     * @return Current fieldPickerFieldProperties value. Default value is null
     */
    public String[] getFieldPickerFieldProperties()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("fieldPickerFieldProperties"));
    }
    

    /**
     * Instance of {@link com.smartgwt.client.widgets.FieldPickerWindow} used if {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getCanPickFields canPickFields} is set.
     * <p>
     * This component is an AutoChild named "fieldPickerWindow".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current fieldPickerWindow value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public FieldPickerWindow getFieldPickerWindow() throws IllegalStateException {
        errorIfNotCreated("fieldPickerWindow");
        return (FieldPickerWindow)FieldPickerWindow.getByJSObject(getAttributeAsJavaScriptObject("fieldPickerWindow"));
    }
    

    /**
     * An array of field objects, specifying the order and type of fields to display in this DetailViewer.  In DetailViewers,
     * the fields specify rows.
     *
     * @param fields New fields value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     */
    public DetailViewer setFields(DetailViewerField... fields) {
        return (DetailViewer)setAttribute("fields", fields, true);
    }

    /**
     * An array of field objects, specifying the order and type of fields to display in this DetailViewer.  In DetailViewers,
     * the fields specify rows.
     *
     * @return Current fields value. Default value is null
     */
    public DetailViewerField[] getFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfDetailViewerField(getAttributeAsJavaScriptObject("fields"));
    }
    

    /**
     * CSS style for a header
     *
     * @param headerStyle New headerStyle value. Default value is "detailHeader"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewer setHeaderStyle(String headerStyle) {
        return (DetailViewer)setAttribute("headerStyle", headerStyle, true);
    }

    /**
     * CSS style for a header
     *
     * @return Current headerStyle value. Default value is "detailHeader"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHeaderStyle()  {
        return getAttributeAsString("headerStyle");
    }
    

    /**
     * Height for hilite icons for this listGrid. Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize hiliteIconSize}. Can be overridden at the field level
     *
     * @param hiliteIconHeight New hiliteIconHeight value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewer setHiliteIconHeight(Integer hiliteIconHeight) {
        return (DetailViewer)setAttribute("hiliteIconHeight", hiliteIconHeight, true);
    }

    /**
     * Height for hilite icons for this listGrid. Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize hiliteIconSize}. Can be overridden at the field level
     *
     * @return Current hiliteIconHeight value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconHeight()  {
        return getAttributeAsInt("hiliteIconHeight");
    }
    

    /**
     * How much padding should there be on the left of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons
     * hilite icons} by default? Can be overridden at the field level
     *
     * @param hiliteIconLeftPadding New hiliteIconLeftPadding value. Default value is 2
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewer setHiliteIconLeftPadding(int hiliteIconLeftPadding) {
        return (DetailViewer)setAttribute("hiliteIconLeftPadding", hiliteIconLeftPadding, true);
    }

    /**
     * How much padding should there be on the left of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons
     * hilite icons} by default? Can be overridden at the field level
     *
     * @return Current hiliteIconLeftPadding value. Default value is 2
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public int getHiliteIconLeftPadding()  {
        return getAttributeAsInt("hiliteIconLeftPadding");
    }
    

    /**
     * When {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons hiliteIcons} are present, where the hilite
     * icon will be placed  relative to the field value.  See {@link com.smartgwt.client.types.HiliteIconPosition}. Can be
     * overridden at the field level.
     *
     * @param hiliteIconPosition New hiliteIconPosition value. Default value is "before"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewer setHiliteIconPosition(HiliteIconPosition hiliteIconPosition)  throws IllegalStateException {
        return (DetailViewer)setAttribute("hiliteIconPosition", hiliteIconPosition == null ? null : hiliteIconPosition.getValue(), false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons hiliteIcons} are present, where the hilite
     * icon will be placed  relative to the field value.  See {@link com.smartgwt.client.types.HiliteIconPosition}. Can be
     * overridden at the field level.
     *
     * @return Current hiliteIconPosition value. Default value is "before"
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public HiliteIconPosition getHiliteIconPosition()  {
        return EnumUtil.getEnum(HiliteIconPosition.values(), getAttribute("hiliteIconPosition"));
    }
    

    /**
     * How much padding should there be on the right of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons
     * hilite icons} by default? Can be overridden at the field level
     *
     * @param hiliteIconRightPadding New hiliteIconRightPadding value. Default value is 2
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewer setHiliteIconRightPadding(int hiliteIconRightPadding) {
        return (DetailViewer)setAttribute("hiliteIconRightPadding", hiliteIconRightPadding, true);
    }

    /**
     * How much padding should there be on the right of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons
     * hilite icons} by default? Can be overridden at the field level
     *
     * @return Current hiliteIconRightPadding value. Default value is 2
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public int getHiliteIconRightPadding()  {
        return getAttributeAsInt("hiliteIconRightPadding");
    }
    

    /**
     * Specifies a list of icons that can be used in {@link com.smartgwt.client.widgets.DataBoundComponent#editHilites
     * hilites}. <P> <code>hiliteIcons</code> should be specified as an Array of {@link com.smartgwt.client.docs.SCImgURL}.
     * When present, the hilite editing interface shown when {@link com.smartgwt.client.widgets.DataBoundComponent#editHilites
     * DataBoundComponent.editHilites()} is called  will offer the user a drop down for picking one of these icons when
     * defining either a  simple or advanced hilite rule. <P> If the user picks an icon, the created hiliting rule will have
     * {@link com.smartgwt.client.data.Hilite#getIcon Hilite.icon} set to  the chosen icon.  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteIconPosition DataBoundComponent.hiliteIconPosition} controls
     * where the icon will  appear for that field -- the default is that it appears in front of the normal cell content. This
     * can also be overridden at the field level.
     *
     * @param hiliteIcons New hiliteIcons value. Default value is ["[SKINIMG]/Dialog/notify.png", "[SKINIMG]/Dialog/warn.png", "[SKINIMG]/actions/approve.png"]
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewer setHiliteIcons(String... hiliteIcons)  throws IllegalStateException {
        return (DetailViewer)setAttribute("hiliteIcons", hiliteIcons, false);
    }

    /**
     * Specifies a list of icons that can be used in {@link com.smartgwt.client.widgets.DataBoundComponent#editHilites
     * hilites}. <P> <code>hiliteIcons</code> should be specified as an Array of {@link com.smartgwt.client.docs.SCImgURL}.
     * When present, the hilite editing interface shown when {@link com.smartgwt.client.widgets.DataBoundComponent#editHilites
     * DataBoundComponent.editHilites()} is called  will offer the user a drop down for picking one of these icons when
     * defining either a  simple or advanced hilite rule. <P> If the user picks an icon, the created hiliting rule will have
     * {@link com.smartgwt.client.data.Hilite#getIcon Hilite.icon} set to  the chosen icon.  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getHiliteIconPosition DataBoundComponent.hiliteIconPosition} controls
     * where the icon will  appear for that field -- the default is that it appears in front of the normal cell content. This
     * can also be overridden at the field level.
     *
     * @return Current hiliteIcons value. Default value is ["[SKINIMG]/Dialog/notify.png", "[SKINIMG]/Dialog/warn.png", "[SKINIMG]/actions/approve.png"]
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public String[] getHiliteIcons()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("hiliteIcons"));
    }
    

    /**
     * Default width and height of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons hilite icons} for this
     * component. Can be overridden at the component level via explicit  {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconWidth hiliteIconWidth} and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconHeight hiliteIconHeight}, or at the field level via  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconSize hiliteIconSize}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconWidth hiliteIconWidth} and  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconHeight hiliteIconHeight}
     *
     * @param hiliteIconSize New hiliteIconSize value. Default value is 12
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setHiliteIconWidth
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setHiliteIconHeight
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setHiliteIconSize
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewer setHiliteIconSize(int hiliteIconSize) {
        return (DetailViewer)setAttribute("hiliteIconSize", hiliteIconSize, true);
    }

    /**
     * Default width and height of {@link com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIcons hilite icons} for this
     * component. Can be overridden at the component level via explicit  {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconWidth hiliteIconWidth} and {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconHeight hiliteIconHeight}, or at the field level via  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconSize hiliteIconSize}, {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconWidth hiliteIconWidth} and  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconHeight hiliteIconHeight}
     *
     * @return Current hiliteIconSize value. Default value is 12
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconWidth
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconHeight
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getHiliteIconSize
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public int getHiliteIconSize()  {
        return getAttributeAsInt("hiliteIconSize");
    }
    

    /**
     * Width for hilite icons for this component. Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize hiliteIconSize}. Can be overridden at the field level.
     *
     * @param hiliteIconWidth New hiliteIconWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public DetailViewer setHiliteIconWidth(Integer hiliteIconWidth) {
        return (DetailViewer)setAttribute("hiliteIconWidth", hiliteIconWidth, true);
    }

    /**
     * Width for hilite icons for this component. Overrides {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHiliteIconSize hiliteIconSize}. Can be overridden at the field level.
     *
     * @return Current hiliteIconWidth value. Default value is null
     * @see com.smartgwt.client.docs.Hiliting Hiliting overview and related methods
     */
    public Integer getHiliteIconWidth()  {
        return getAttributeAsInt("hiliteIconWidth");
    }
    
    
    

    /**
     * Horizontal alignment of value-labels in this viewer.  If unspecified, defaults to  <code>"left"</code> when in RTL mode
     * and <code>"right"</code> otherwise.
     *
     * @param labelAlign New labelAlign value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     */
    public DetailViewer setLabelAlign(Alignment labelAlign) {
        return (DetailViewer)setAttribute("labelAlign", labelAlign == null ? null : labelAlign.getValue(), true);
    }

    /**
     * Horizontal alignment of value-labels in this viewer.  If unspecified, defaults to  <code>"left"</code> when in RTL mode
     * and <code>"right"</code> otherwise.
     *
     * @return Current labelAlign value. Default value is null
     */
    public Alignment getLabelAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("labelAlign"));
    }
    

    /**
     * text to put before a label
     *
     * @param labelPrefix New labelPrefix value. Default value is ""
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public DetailViewer setLabelPrefix(String labelPrefix) {
        return (DetailViewer)setAttribute("labelPrefix", labelPrefix, true);
    }

    /**
     * text to put before a label
     *
     * @return Current labelPrefix value. Default value is ""
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getLabelPrefix()  {
        return getAttributeAsString("labelPrefix");
    }
    

    /**
     * CSS style for a normal detail label
     *
     * @param labelStyle New labelStyle value. Default value is "detailLabel"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewer setLabelStyle(String labelStyle) {
        return (DetailViewer)setAttribute("labelStyle", labelStyle, true);
    }

    /**
     * CSS style for a normal detail label
     *
     * @return Current labelStyle value. Default value is "detailLabel"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getLabelStyle()  {
        return getAttributeAsString("labelStyle");
    }
    

    /**
     * text to put after a label
     *
     * @param labelSuffix New labelSuffix value. Default value is ":"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public DetailViewer setLabelSuffix(String labelSuffix) {
        return (DetailViewer)setAttribute("labelSuffix", labelSuffix, true);
    }

    /**
     * text to put after a label
     *
     * @return Current labelSuffix value. Default value is ":"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getLabelSuffix()  {
        return getAttributeAsString("labelSuffix");
    }
    

    /**
     * Property name on a record that will hold the link text for that record. <p> This property is configurable to avoid
     * possible collision with data values in the record. <p> Use {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getLinkTextProperty DetailViewerField.linkTextProperty} if you have
     * more than one link field and the fields' records do not use the same property to store the linkText.
     *
     * @param linkTextProperty New linkTextProperty value. Default value is "linkText"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setLinkText
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#setLinkTextProperty
     */
    public DetailViewer setLinkTextProperty(String linkTextProperty) {
        return (DetailViewer)setAttribute("linkTextProperty", linkTextProperty, true);
    }

    /**
     * Property name on a record that will hold the link text for that record. <p> This property is configurable to avoid
     * possible collision with data values in the record. <p> Use {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getLinkTextProperty DetailViewerField.linkTextProperty} if you have
     * more than one link field and the fields' records do not use the same property to store the linkText.
     *
     * @return Current linkTextProperty value. Default value is "linkText"
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getLinkText
     * @see com.smartgwt.client.widgets.viewer.DetailViewerField#getLinkTextProperty
     */
    public String getLinkTextProperty()  {
        return getAttributeAsString("linkTextProperty");
    }
    

    /**
     * The string to display in the body of a detailViewer which is loading records. Use <code>"&#36;{loadingImage}"</code> to
     * include {@link com.smartgwt.client.widgets.Canvas#loadingImageSrc a loading image}.
     *
     * @param loadingMessage New loadingMessage value. Default value is "&amp;nbsp;${loadingImage}"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public DetailViewer setLoadingMessage(String loadingMessage) {
        return (DetailViewer)setAttribute("loadingMessage", loadingMessage, true);
    }

    /**
     * The string to display in the body of a detailViewer which is loading records. Use <code>"&#36;{loadingImage}"</code> to
     * include {@link com.smartgwt.client.widgets.Canvas#loadingImageSrc a loading image}.
     *
     * @return Current loadingMessage value. Default value is "&amp;nbsp;${loadingImage}"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getLoadingMessage()  {
        return getAttributeAsString("loadingMessage");
    }
    

    /**
     * CSS style to use for the {@link com.smartgwt.client.widgets.viewer.DetailViewer#getLoadingMessage loadingMessage}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param loadingMessageStyle New loadingMessageStyle value. Default value is "normal"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public DetailViewer setLoadingMessageStyle(String loadingMessageStyle) {
        return (DetailViewer)setAttribute("loadingMessageStyle", loadingMessageStyle, true);
    }

    /**
     * CSS style to use for the {@link com.smartgwt.client.widgets.viewer.DetailViewer#getLoadingMessage loadingMessage}.
     *
     * @return Current loadingMessageStyle value. Default value is "normal"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getLoadingMessageStyle()  {
        return getAttributeAsString("loadingMessageStyle");
    }
    

    /**
     * Optional CSS style for a cell in printable HTML for this component. If unset {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle cellStyle} will be used for printing as well as normal
     * presentation.
     *
     * @param printCellStyle New printCellStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public DetailViewer setPrintCellStyle(String printCellStyle) {
        return (DetailViewer)setAttribute("printCellStyle", printCellStyle, true);
    }

    /**
     * Optional CSS style for a cell in printable HTML for this component. If unset {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getCellStyle cellStyle} will be used for printing as well as normal
     * presentation.
     *
     * @return Current printCellStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintCellStyle()  {
        return getAttributeAsString("printCellStyle");
    }
    

    /**
     * Optional CSS style for a header in printable HTML for this component. If unset {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHeaderStyle headerStyle} will be used for printing as well as normal
     * presentation.
     *
     * @param printHeaderStyle New printHeaderStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public DetailViewer setPrintHeaderStyle(String printHeaderStyle) {
        return (DetailViewer)setAttribute("printHeaderStyle", printHeaderStyle, true);
    }

    /**
     * Optional CSS style for a header in printable HTML for this component. If unset {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getHeaderStyle headerStyle} will be used for printing as well as normal
     * presentation.
     *
     * @return Current printHeaderStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintHeaderStyle()  {
        return getAttributeAsString("printHeaderStyle");
    }
    

    /**
     * Optional CSS style for a label cell in printable HTML for this component. If unset {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getLabelStyle labelStyle} will be used for printing as well as normal
     * presentation.
     *
     * @param printLabelStyle New printLabelStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public DetailViewer setPrintLabelStyle(String printLabelStyle) {
        return (DetailViewer)setAttribute("printLabelStyle", printLabelStyle, true);
    }

    /**
     * Optional CSS style for a label cell in printable HTML for this component. If unset {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getLabelStyle labelStyle} will be used for printing as well as normal
     * presentation.
     *
     * @return Current printLabelStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintLabelStyle()  {
        return getAttributeAsString("printLabelStyle");
    }
    

    /**
     * The number of records to display in a block. A block is a horizontal row on a page          containing one or more
     * records, as specified by the value of recordsPerBlock. The          height of a block is equal to the height of a single
     * record. The default setting of          1 causes each record to appear by itself in a vertical row. Setting
     * recordsPerBlock          to 2 would cause records to appear side by side in groups of two.          Use a value of "*"
     * to indicate all records.
     *
     * @param recordsPerBlock New recordsPerBlock value. Default value is 1
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewer setRecordsPerBlock(int recordsPerBlock) {
        return (DetailViewer)setAttribute("recordsPerBlock", recordsPerBlock, true);
    }

    /**
     * The number of records to display in a block. A block is a horizontal row on a page          containing one or more
     * records, as specified by the value of recordsPerBlock. The          height of a block is equal to the height of a single
     * record. The default setting of          1 causes each record to appear by itself in a vertical row. Setting
     * recordsPerBlock          to 2 would cause records to appear side by side in groups of two.          Use a value of "*"
     * to indicate all records.
     *
     * @return Current recordsPerBlock value. Default value is 1
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getRecordsPerBlock()  {
        return getAttributeAsInt("recordsPerBlock");
    }
    

    /**
     * Height of rows rendered by the DetailViewer.  Acts as a minimum - the DetailViewer never clips values. This attribute
     * can be set as null.
     *
     * @param rowHeight New rowHeight value. Default value is 19
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     */
    public DetailViewer setRowHeight(int rowHeight) {
        return (DetailViewer)setAttribute("rowHeight", rowHeight, true);
    }

    /**
     * Height of rows rendered by the DetailViewer.  Acts as a minimum - the DetailViewer never clips values. This attribute
     * can be set as null.
     *
     * @return Current rowHeight value. Default value is 19
     */
    public int getRowHeight()  {
        return getAttributeAsInt("rowHeight");
    }
    

    /**
     * CSS style for a separator
     *
     * @param separatorStyle New separatorStyle value. Default value is "detail"
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewer setSeparatorStyle(String separatorStyle) {
        return (DetailViewer)setAttribute("separatorStyle", separatorStyle, true);
    }

    /**
     * CSS style for a separator
     *
     * @return Current separatorStyle value. Default value is "detail"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSeparatorStyle()  {
        return getAttributeAsString("separatorStyle");
    }
    

    /**
     * Whether to show fields marked <code>detail:true</code> when a DataBoundComponent is  given a DataSource but no
     * <code>component.fields</code>. <p> The <code>detail</code> property is used on DataSource fields to mark fields that 
     * shouldn't appear by default in a view that tries to show many records in a small space.
     *
     * @param showDetailFields New showDetailFields value. Default value is true
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public DetailViewer setShowDetailFields(Boolean showDetailFields)  throws IllegalStateException {
        return (DetailViewer)setAttribute("showDetailFields", showDetailFields, false);
    }

    /**
     * Whether to show fields marked <code>detail:true</code> when a DataBoundComponent is  given a DataSource but no
     * <code>component.fields</code>. <p> The <code>detail</code> property is used on DataSource fields to mark fields that 
     * shouldn't appear by default in a view that tries to show many records in a small space.
     *
     * @return Current showDetailFields value. Default value is true
     * @see com.smartgwt.client.docs.Databinding Databinding overview and related methods
     */
    public Boolean getShowDetailFields()  {
        Boolean result = getAttributeAsBoolean("showDetailFields");
        return result == null ? true : result;
    }
    

    /**
     * Whether to show the field when the value is null
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showEmptyField New showEmptyField value. Default value is true
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewer setShowEmptyField(Boolean showEmptyField) {
        return (DetailViewer)setAttribute("showEmptyField", showEmptyField, true);
    }

    /**
     * Whether to show the field when the value is null
     *
     * @return Current showEmptyField value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getShowEmptyField()  {
        Boolean result = getAttributeAsBoolean("showEmptyField");
        return result == null ? true : result;
    }
    

    /**
     * Show {@link com.smartgwt.client.widgets.viewer.DetailViewer#getEmptyMessage emptyMessage} when there is no data to
     * display?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showEmptyMessage New showEmptyMessage value. Default value is true
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setEmptyMessage
     */
    public DetailViewer setShowEmptyMessage(Boolean showEmptyMessage) {
        return (DetailViewer)setAttribute("showEmptyMessage", showEmptyMessage, true);
    }

    /**
     * Show {@link com.smartgwt.client.widgets.viewer.DetailViewer#getEmptyMessage emptyMessage} when there is no data to
     * display?
     *
     * @return Current showEmptyMessage value. Default value is true
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#getEmptyMessage
     */
    public Boolean getShowEmptyMessage()  {
        Boolean result = getAttributeAsBoolean("showEmptyMessage");
        return result == null ? true : result;
    }
    

    /**
     * CSS style for the component as a whole.
     *
     * @param styleName New styleName value. Default value is "detailViewer"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * CSS style for the component as a whole.
     *
     * @return Current styleName value. Default value is "detailViewer"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * Display format to use for fields specified as type 'time'.  May also be specified at  the field level via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTimeFormatter DetailViewerField.timeFormatter}.<br> If unset,
     * time fields will be formatted based on the system wide  String
     *
     * @param timeFormatter New timeFormatter value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public DetailViewer setTimeFormatter(TimeDisplayFormat timeFormatter) {
        return (DetailViewer)setAttribute("timeFormatter", timeFormatter == null ? null : timeFormatter.getValue(), true);
    }

    /**
     * Display format to use for fields specified as type 'time'.  May also be specified at  the field level via {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getTimeFormatter DetailViewerField.timeFormatter}.<br> If unset,
     * time fields will be formatted based on the system wide  String
     *
     * @return Current timeFormatter value. Default value is null
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public TimeDisplayFormat getTimeFormatter()  {
        return EnumUtil.getEnum(TimeDisplayFormat.values(), getAttribute("timeFormatter"));
    }
    

    /**
     * Horizontal alignment of values in this viewer.  If unspecified, defaults to  <code>"right"</code> when in RTL mode and
     * <code>"left"</code> otherwise.
     *
     * @param valueAlign New valueAlign value. Default value is null
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     */
    public DetailViewer setValueAlign(Alignment valueAlign) {
        return (DetailViewer)setAttribute("valueAlign", valueAlign == null ? null : valueAlign.getValue(), true);
    }

    /**
     * Horizontal alignment of values in this viewer.  If unspecified, defaults to  <code>"right"</code> when in RTL mode and
     * <code>"left"</code> otherwise.
     *
     * @return Current valueAlign value. Default value is null
     */
    public Alignment getValueAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("valueAlign"));
    }
    

    /**
     * Should the label be allowed to wrap, or be fixed to one line no matter how long
     *
     * @param wrapLabel New wrapLabel value. Default value is false
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     */
    public DetailViewer setWrapLabel(Boolean wrapLabel) {
        return (DetailViewer)setAttribute("wrapLabel", wrapLabel, true);
    }

    /**
     * Should the label be allowed to wrap, or be fixed to one line no matter how long
     *
     * @return Current wrapLabel value. Default value is false
     */
    public Boolean getWrapLabel()  {
        Boolean result = getAttributeAsBoolean("wrapLabel");
        return result == null ? false : result;
    }
    

    /**
     * Whether values should be allowed to wrap by default, or should be shown on one line regardless of length.
     *
     * @param wrapValues New wrapValues value. Default value is true
     * @return {@link com.smartgwt.client.widgets.viewer.DetailViewer DetailViewer} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public DetailViewer setWrapValues(Boolean wrapValues)  throws IllegalStateException {
        return (DetailViewer)setAttribute("wrapValues", wrapValues, false);
    }

    /**
     * Whether values should be allowed to wrap by default, or should be shown on one line regardless of length.
     *
     * @return Current wrapValues value. Default value is true
     */
    public Boolean getWrapValues()  {
        Boolean result = getAttributeAsBoolean("wrapValues");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Return the message to show if the component has no data. Default implementation returns a  centered {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getEmptyMessage emptyMessage} or "&amp;nbsp;" if showEmptyMessage is
     * false.  If the component has no data because the browser is offline, we instead display the  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getOfflineMessage DataBoundComponent.offlineMessage} or "&amp;nbsp;" if
     * showOfflineMessage is false
     *
     * @return HTML output
     */
    public native String emptyMessageHTML() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "emptyMessageHTML", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.emptyMessageHTML();
        return ret;
    }-*/;

	/**
     * Exports this component's data with client-side formatters applied, so is suitable for direct display to users.  See
     * {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData()} for details of the
     * general  requirements and restrictions when exporting client data. <p> The following notes apply when exporting client
     * data from DetailViewers:<ul> <li>Data is exported in "grid" format, with each record shown in a single row and each     
     * column representing a single field. This is quite different from the way DetailViewers     display records in the
     * browser</li> </ul> <P> If your detailViewer has custom formatters, formatted values will be exported by default, with
     * HTML normalized to text where possible.  Since some levels of HTML normalizing aren't  possible, this may result in
     * missing or incorrect export values.  In this case, you have  two possible approaches:<ul> <li>Set {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getExportRawValues exportRawValues} on the field.  This will export
     * the raw underlying value of the field; your formatter will not be called</li> <li>Have your formatter call {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#isExportingClientData isExportingClientData()}     and perform whatever
     * alternative formatting you require if that method returns true</li> </ul>
     * @see com.smartgwt.client.widgets.grid.ListGrid#exportClientData
     */
    public native void exportClientData() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportClientData", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData();
    }-*/;

    /**
     * @see DetailViewer#exportClientData
     */
    public void exportClientData(DSRequest requestProperties){
        exportClientData(requestProperties, null);
    }

	/**
     * Exports this component's data with client-side formatters applied, so is suitable for direct display to users.  See
     * {@link com.smartgwt.client.widgets.grid.ListGrid#exportClientData ListGrid.exportClientData()} for details of the
     * general  requirements and restrictions when exporting client data. <p> The following notes apply when exporting client
     * data from DetailViewers:<ul> <li>Data is exported in "grid" format, with each record shown in a single row and each     
     * column representing a single field. This is quite different from the way DetailViewers     display records in the
     * browser</li> </ul> <P> If your detailViewer has custom formatters, formatted values will be exported by default, with
     * HTML normalized to text where possible.  Since some levels of HTML normalizing aren't  possible, this may result in
     * missing or incorrect export values.  In this case, you have  two possible approaches:<ul> <li>Set {@link
     * com.smartgwt.client.widgets.viewer.DetailViewerField#getExportRawValues exportRawValues} on the field.  This will export
     * the raw underlying value of the field; your formatter will not be called</li> <li>Have your formatter call {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#isExportingClientData isExportingClientData()}     and perform whatever
     * alternative formatting you require if that method returns true</li> </ul>
     * @param requestProperties Request properties for the export.  Note that specifying {@link com.smartgwt.client.data.DSRequest#getExportData
     * exportData} on the request properties  allows the developer to pass in an explicit data set to export.
     * @param callback Optional callback.  If  you specify {@link com.smartgwt.client.data.DSRequest#getExportToClient exportToClient}: false
     * in the request  properties, this callback will fire after export completes.  Otherwise the callback will  fire right
     * before the download request is made to the server.
     * @see com.smartgwt.client.widgets.grid.ListGrid#exportClientData
     */
    public native void exportClientData(DSRequest requestProperties, RPCCallback callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportClientData", "DSRequest,RPCCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportClientData(requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()(), 
			$entry( function(response, rawData, request) { 
				if(callback!=null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(
					@com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(response), 
					rawData, 
					@com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(request)
				);
			}));
    }-*/;
	
	/**
     * Based on the relationship between the DataSource this component is bound to and the DataSource specified as the "schema"
     * argument, call fetchData() to retrieve records in this data set that are related to the passed-in record. <P>
     * Relationships between DataSources are declared via {@link com.smartgwt.client.data.DataSourceField#getForeignKey
     * DataSourceField.foreignKey}. <P> For example, given two related DataSources "orders" and "orderItems", where we want to
     * fetch the "orderItems" that belong to a given "order".  "orderItems" should declare a field that is a {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} to the "orders" table (for example, it might be named
     * "orderId" with foreignKey="orders.id").  Then, to load the records related to a given "order", call fetchRelatedData()
     * on the component bound to "orderItems", pass the "orders" DataSource as the "schema" and pass a record from the "orders"
     * DataSource as the "record" argument. <p> <b>Note:</b> When you expect a large number of records to be returned it is not
     * recommended to display these in the DetailViewer as it doesn't have the same level of support for large datasets as the
     * {@link com.smartgwt.client.widgets.grid.ListGrid}.
     * @param record DataSource record
     * @param schema schema of the DataSource record, or                            DataBoundComponent already bound to that schema
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void fetchRelatedData(ListGridRecord record, Canvas schema) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fetchRelatedData", "ListGridRecord,Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchRelatedData(record.@com.smartgwt.client.core.DataClass::getJsObj()(), schema == null ? null : schema.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    /**
     * @see DetailViewer#fetchRelatedData
     */
    public void fetchRelatedData(ListGridRecord record, Canvas schema, DSCallback callback){
        fetchRelatedData(record, schema, callback, null);
    }

	/**
     * Based on the relationship between the DataSource this component is bound to and the DataSource specified as the "schema"
     * argument, call fetchData() to retrieve records in this data set that are related to the passed-in record. <P>
     * Relationships between DataSources are declared via {@link com.smartgwt.client.data.DataSourceField#getForeignKey
     * DataSourceField.foreignKey}. <P> For example, given two related DataSources "orders" and "orderItems", where we want to
     * fetch the "orderItems" that belong to a given "order".  "orderItems" should declare a field that is a {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} to the "orders" table (for example, it might be named
     * "orderId" with foreignKey="orders.id").  Then, to load the records related to a given "order", call fetchRelatedData()
     * on the component bound to "orderItems", pass the "orders" DataSource as the "schema" and pass a record from the "orders"
     * DataSource as the "record" argument. <p> <b>Note:</b> When you expect a large number of records to be returned it is not
     * recommended to display these in the DetailViewer as it doesn't have the same level of support for large datasets as the
     * {@link com.smartgwt.client.widgets.grid.ListGrid}.
     * @param record DataSource record
     * @param schema schema of the DataSource record, or                            DataBoundComponent already bound to that schema
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void fetchRelatedData(ListGridRecord record, Canvas schema, DSCallback callback, DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fetchRelatedData", "ListGridRecord,Canvas,DSCallback,DSRequest");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchRelatedData(record.@com.smartgwt.client.core.DataClass::getJsObj()(), schema == null ? null : schema.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), 
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Check whether a field is currently visible
     * @param field field to be checked
     *
     * @return true if the field is currently visible, false otherwise.
     */
    public native boolean fieldIsVisible(String field) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fieldIsVisible", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.fieldIsVisible(field);
        return ret == null ? false : ret;
    }-*/;

	/**
     * Returns a snapshot of the current view state of this DetailViewer.<br> This includes the field state of the
     * DetailViewer, returned as a {@link com.smartgwt.client.docs.DetailViewerViewState} object.<br> This object can be passed
     * to {@link com.smartgwt.client.widgets.viewer.DetailViewer#setViewState setViewState()} to reset this detail  viewer's
     * view state to the current state (assuming the same data / fields are present in  the detail viewer).
     *
     * @return current view state for the detail viewer.
     * See {@link com.smartgwt.client.docs.DetailViewerViewState DetailViewerViewState}
     * @see com.smartgwt.client.docs.DetailViewerViewState
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#setViewState
     */
    public native String getViewState() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getViewState", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getViewState();
        return ret;
    }-*/;

	/**
     * Returns true if this component is currently  {@link com.smartgwt.client.widgets.viewer.DetailViewer#exportClientData
     * exporting client data}.  This method can be called from custom cell formatters if you need to return a different
     * formatted value for an export than for a live detailViewer
     *
     * @return returns true if this component is currently exporting client data
     * @see com.smartgwt.client.widgets.grid.ListGrid#exportClientData
     */
    public native boolean isExportingClientData() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "isExportingClientData", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.isExportingClientData();
        return ret == null ? false : ret;
    }-*/;

	/**
     * Reset this detail viewer's view state to match the {@link com.smartgwt.client.docs.DetailViewerViewState} object passed
     * in.<br> Used to restore previous state retrieved from the detail viewer by a call to  {@link
     * com.smartgwt.client.widgets.viewer.DetailViewer#getViewState getViewState()}.
     * @param viewState Object describing the desired view state for the detail viewer.
     * See {@link com.smartgwt.client.docs.DetailViewerViewState DetailViewerViewState}
     * @see com.smartgwt.client.widgets.viewer.DetailViewer#getViewState
     * @see com.smartgwt.client.docs.DetailViewerViewState DetailViewerViewState
     */
    public native void setViewState(String viewState) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setViewState", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setViewState(viewState);
    }-*/;


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
     * @param detailViewerProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DetailViewer detailViewerProperties) /*-{
        if (detailViewerProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DetailViewer.@java.lang.Object::getClass()(), "setDefaultProperties", detailViewerProperties.@java.lang.Object::getClass()());
        }
        detailViewerProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = detailViewerProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.DetailViewer.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * If true, the set of fields given by the "default binding" (see DataBoundComponent.fields) is used, with any
     * fields specified in component.fields acting as overrides that can suppress or modify the display of individual
     * fields, without having to list the entire set of fields that should be shown.
     * <p/>
     * If component.fields contains fields that are not found in the DataSource, they will be shown after the most
     * recently referred to DataSource field. If the new fields appear first, they will be shown first.
     *
     * @param useAllDataSourceFields useAllDataSourceFields
     */
    public void setUseAllDataSourceFields(boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    /**
     * Displays the currently selected record(s) of the ListGrid in the detailViewer.
     *
     * @param selectionComponent the ListGrid whose currently selected record(s) is/are to be edited
     */
    public native void viewSelectedData(ListGrid selectionComponent) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var selectionComponentJS = selectionComponent.@com.smartgwt.client.widgets.grid.ListGrid::getJsObj()();
        self.viewSelectedData(selectionComponentJS);
    }-*/;

    /**
     * Displays the currently selected record(s) of the ListGrid in the detailViewer.
     *
     * @param selectionComponentID the ID of a ListGrid whose currently selected record(s) is/are to be edited
     */
    public native void viewSelectedData(String selectionComponentID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.viewSelectedData(selectionComponentID);
    }-*/;

    /**
     * Bind to a DataSource.
     * <P>
     * Binding to a DataSource means that the component will use the DataSource to provide default data for 
     * its fields.
     * <P>
     * When binding to a new DataSource, if the component has any existing "fields" or has a dataset, 
     * these will be discarded by default, since it is assumed the new DataSource may represent a completely 
     * unrelated set of objects. If the old "fields" are still relevant, pass them to setDataSource(). 
     * @param dataSource
     * @param fields
     */
    public void setDataSource(DataSource dataSource, DetailViewerField... fields) {
        if (!isCreated()) {
            setFields(fields);
            setDataSource(dataSource);
        } else {
            JavaScriptObject jsFields = null;
            if (fields != null) {
                jsFields = JSOHelper.createJavaScriptArray();
                for (int i = 0; i < fields.length; i++) {
                    JSOHelper.setArrayValue(jsFields, i, fields[i].getJsObj());
                }
            }
            setDataSourceJS(dataSource.getOrCreateJsObj(), jsFields);
        }
    }
    private native void setDataSourceJS(JavaScriptObject dataSource, JavaScriptObject fields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setDataSource(dataSource, fields);
    }-*/;

    /**
     * See {@link #getDataAsRecordArray}.
     * @deprecated in favor of {@link #getDataAsRecordArray}.
     */
    public Record[] getDataAsRecord()  {
        return getDataAsRecordArray();
    }




    // ********************* DataBoundComponent Properties / Attributes ***********************

    public DetailViewer setDataPageSize(int dataPageSize) {
        return (DetailViewer)setAttribute("dataPageSize", dataPageSize, true);
    }

    public int getDataPageSize() {
        Integer dataPageSize = getAttributeAsInt("dataPageSize");
        return dataPageSize == null ? 0 : dataPageSize;
    }

    public DetailViewer setUseAllDataSourceFields(Boolean useAllDataSourceFields) {
        return (DetailViewer)setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    public Boolean getUseAllDataSourceFields() {
        return getAttributeAsBoolean("useAllDataSourceFields");
    }

    public DetailViewer setShowHiddenFields(Boolean showHiddenFields) {
        return (DetailViewer)setAttribute("showHiddenFields", showHiddenFields, true);
    }

    public Boolean getShowHiddenFields() {
        return getAttributeAsBoolean("showHiddenFields");
    }

    public DetailViewer setShowComplexFields(Boolean showComplexFields) {
        return (DetailViewer)setAttribute("showComplexFields", showComplexFields, true);
    }

    public Boolean getShowComplexFields() {
        return getAttributeAsBoolean("showComplexFields");
    }

    public DetailViewer setFetchOperation(String fetchOperation) {
        return (DetailViewer)setAttribute("fetchOperation", fetchOperation, true);
    }

    public String getFetchOperation() {
        return getAttributeAsString("fetchOperation");
    }

    public DetailViewer setUpdateOperation(String updateOperation) {
        return (DetailViewer)setAttribute("updateOperation", updateOperation, true);
    }

    public String getUpdateOperation() {
        return getAttributeAsString("updateOperation");
    }

    public DetailViewer setAddOperation(String addOperation) {
        return (DetailViewer)setAttribute("addOperation", addOperation, true);
    }

    public String getAddOperation() {
        return getAttributeAsString("addOperation");
    }

    public DetailViewer setRemoveOperation(String removeOperation) {
        return (DetailViewer)setAttribute("removeOperation", removeOperation, true);
    }

    public String getRemoveOperation() {
        return getAttributeAsString("removeOperation");
    }

    public DetailViewer setExportFields(String[] exportFields) {
        return (DetailViewer)setAttribute("exportFields", exportFields, true);
    }

    public String[] getExportFields() {
        return getAttributeAsStringArray("exportFields");
    }

    public DetailViewer setExportAll(Boolean exportAll) {
        return (DetailViewer)setAttribute("exportAll", exportAll, true);
    }

    public Boolean getExportAll() {
        return getAttributeAsBoolean("exportAll");
    }

    public DetailViewer setExportIncludeSummaries(Boolean exportIncludeSummaries) {
        return (DetailViewer)setAttribute("exportIncludeSummaries", exportIncludeSummaries, true);
    }

    public Boolean getExportIncludeSummaries() {
        return getAttributeAsBoolean("exportIncludeSummaries");
    }

    public DetailViewer setPreventDuplicates(Boolean preventDuplicates) throws IllegalStateException {
        return (DetailViewer)setAttribute("preventDuplicates", preventDuplicates, false);
    }

    public Boolean getPreventDuplicates() {
        return getAttributeAsBoolean("preventDuplicates");
    }

    public DetailViewer setDuplicateDragMessage(String duplicateDragMessage) throws IllegalStateException {
        return (DetailViewer)setAttribute("duplicateDragMessage", duplicateDragMessage, false);
    }

    public String getDuplicateDragMessage() {
        return getAttributeAsString("duplicateDragMessage");
    }

    public DetailViewer setAddDropValues(Boolean addDropValues) {
        return (DetailViewer)setAttribute("addDropValues", addDropValues, true);
    }

    public Boolean getAddDropValues() {
        return getAttributeAsBoolean("addDropValues");
    }

    public DetailViewer setDropValues(Map dropValues) {
        return (DetailViewer)setAttribute("dropValues", dropValues, true);
    }

    public Map getDropValues() {
        return getAttributeAsMap("dropValues");
    }

    /**
     * Indicates whether or not this component will load its data
     * {@link DataSource#setProgressiveLoading() progressively}
     * 
     * @see com.smartgwt.client.docs.ProgressiveLoading  
     * @see com.smartgwt.client.data.DataSource#setProgressiveLoading
     * @param progressiveLoading
     * @return {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponent}
     * instance, for chaining setter calls
     */
    public DetailViewer setProgressiveLoading(Boolean progressiveLoading) {
        return (DetailViewer)setAttribute("progressiveLoading", progressiveLoading, false);
    }

    /**
     * Indicates whether or not this component will load its data {@link DataSource#getProgressiveLoading() progressively}
     * 
     * @see com.smartgwt.client.docs.ProgressiveLoading
     * @see com.smartgwt.client.data.DataSource#getProgressiveLoading
     * @return
     */
    public Boolean getProgressiveLoading() {
        return getAttributeAsBoolean("progressiveLoading");
    }

    public DetailViewer setUseFlatFields(Boolean useFlatFields) throws IllegalStateException {
        return (DetailViewer)setAttribute("useFlatFields", useFlatFields, false);
    }

    public Boolean getUseFlatFields() {
        return getAttributeAsBoolean("useFlatFields");
    }

    public DetailViewer setHiliteProperty(String hiliteProperty) {
        return (DetailViewer)setAttribute("hiliteProperty", hiliteProperty, true);
    }

    public String getHiliteProperty() {
        return getAttributeAsString("hiliteProperty");
    }

    /** 
     * Shows a FieldPicker interface allowing end-users to rearrange the order and visibiility
     * of the fields in the associated DataBoundComponent.
     */
    public native void editFields() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editFields();
    }-*/;

    public native void editHilites() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editHilites();
    }-*/;

    public native String getHiliteState()  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getHiliteState();
    }-*/;

    public native DetailViewer setHiliteState(String hiliteState)  /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setHiliteState(hiliteState);
        return this;
    }-*/;

    public native DetailViewer setHilites(Hilite[] hilites)/*-{
        var isCreated = this.@com.smartgwt.client.widgets.BaseWidget::isCreated()();
        var hilitesJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(hilites);
        if (isCreated) {
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            self.setHilites(hilitesJS);
        } else {
            var obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.hilites = hilitesJS;
        }
        return this;
    }-*/;

    public native Hilite[] getHilites()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var hilitesJS = self.getHilites();
        return @com.smartgwt.client.util.ConvertTo::arrayOfHilite(Lcom/google/gwt/core/client/JavaScriptObject;)(hilitesJS);
    }-*/;

    public DetailViewer setDragDataAction(DragDataAction dragDataAction) {
        return (DetailViewer)setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }

    public DragDataAction getDragDataAction() {
        return EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    public DetailViewer setDragTrackerStyle(String dragTrackerStyle) {
        return (DetailViewer)setAttribute("dragTrackerStyle", dragTrackerStyle, true);
    }

    public String getDragTrackerStyle() {
        return getAttributeAsString("dragTrackerStyle");
    }

    public DetailViewer setCanAddFormulaFields(Boolean canAddFormulaFields) {
        return (DetailViewer)setAttribute("canAddFormulaFields", canAddFormulaFields, true);
    }

    public native void addSummaryField() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.addSummaryField();
     }-*/;

    public native void addFormulaField() /*-{
       var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
       self.addFormulaField();
    }-*/;

    public Boolean getCanAddFormulaFields() {
        return getAttributeAsBoolean("canAddFormulaFields");
    }

    public DetailViewer setAddFormulaFieldText(String addFormulaFieldText) {
        return (DetailViewer)setAttribute("addFormulaFieldText", addFormulaFieldText, true);
    }

    public String getAddFormulaFieldText() {
        return getAttributeAsString("addFormulaFieldText");
    }

    public DetailViewer setEditFormulaFieldText(String editFormulaFieldText) {
        return (DetailViewer)setAttribute("editFormulaFieldText", editFormulaFieldText, true);
    }

    public String getEditFormulaFieldText() {
        return getAttributeAsString("editFormulaFieldText");
    }

    public DetailViewer setCanAddSummaryFields(Boolean canAddSummaryFields) {
        return (DetailViewer)setAttribute("canAddSummaryFields", canAddSummaryFields, true);
    }

    public Boolean getCanAddSummaryFields() {
        return getAttributeAsBoolean("canAddSummaryFields");
    }

    public DetailViewer setAddSummaryFieldText(String addSummaryFieldText) {
        return (DetailViewer)setAttribute("addSummaryFieldText", addSummaryFieldText, true);
    }

    public String getAddSummaryFieldText() {
        return getAttributeAsString("addSummaryFieldText");
    }

    public DetailViewer setEditSummaryFieldText(String editSummaryFieldText) {
        return (DetailViewer)setAttribute("editSummaryFieldText", editSummaryFieldText, true);
    }

    public String getEditSummaryFieldText() {
        return getAttributeAsString("editSummaryFieldText");
    }

    // ********************* Methods ***********************
    /**
     * Filters all objects according to the AdvancedCriteria passed
     *
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = self.findAll(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return recordsJS == null ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;
    
    /**
     * Filters all objects according to the AdvancedCriteria passed and returns the first matching object or null if not found
     *
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return first matching object or null if not found
     */
    public native Record find(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = self.find(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return recordJS == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;
    
    /**
     * Finds the index of the first Record that matches with the AdvacendCriteria passed.
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return self.findIndex(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
    
    /**
     * Like {@link RecordList#findIndex}, but considering the startIndex and endIndex parameters.
     * @param startIndex first index to consider
     * @param adCriteria AdvancedCriteria to use to filter results
     * @param endIndex last index to consider
     * 
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, AdvancedCriteria adCriteria, int endIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return self.findNextIndex(startIndex, adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), null, endIndex);
    }-*/;
    
    /**
     * Like {@link RecordList#findIndex}, but considering the startIndex parameter.
     * @param startIndex first index to consider
     * @param adCriteria AdvancedCriteria to use to filter results
     * 
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(adCriteria)){
    		var criteriaJ = adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        return self.findNextIndex(startIndex, adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public native void selectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS);
     }-*/;

    public native void selectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
     }-*/;

    public native void selectRecord(int record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record, newState);
     }-*/;

    public native void selectRecord(Record record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS, newState);
     }-*/;

    public native void selectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecord(recordsJS);
     }-*/;

    public native void selectRecords(int[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void selectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS);
     }-*/;

    public native void selectRecords(Record[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void deselectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.deselectRecord(recordJS);
     }-*/;

    public native void deselectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.deselectRecord(record);
     }-*/;

    public native void deselectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void deselectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void selectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.selectAllRecords();
     }-*/;

    public native void deselectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.deselectAllRecords();
     }-*/;

    public native Boolean anySelected() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var retVal =self.anySelected();
         if(retVal == null) {
             return null;
         } else {
             return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
         }
     }-*/;

    public native void enableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID);
     }-*/;

    public native void enableHilite(String hiliteID, boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID, enable);
     }-*/;

    public native void disableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHilite(hiliteID);
     }-*/;

    public native void enableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting();
     }-*/;

    public native void enableHiliting(boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting(enable);
     }-*/;

    public native void disableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHiliting();
     }-*/;

    public native Record[] getDragData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = self.getDragData();
        return @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
     }-*/;

    public native void transferSelectedData(DataBoundComponent source) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
     }-*/;

    public native void transferSelectedData(DataBoundComponent source, int index) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index);
     }-*/;

    public native int getRecordIndex(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getRecordIndex(record.@com.smartgwt.client.core.DataClass::getJsObj()());
     }-*/;

    public native String getTitleFieldValue(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getTitleFieldValue(record);
     }-*/;

    public DetailViewer setTitleField(String titleField) {
        return (DetailViewer)setAttribute("titleField", titleField, true);
    }

    public String getTitleField() {
        return getAttributeAsString("titleField");
    }

    public native DataSource getDataSource() /*-{
        var dataSourceJS = this.@com.smartgwt.client.widgets.grid.ListGrid::getAttributeAsJavaScriptObject(Ljava/lang/String;)("dataSource");
        if ($wnd.isc.isA.String(dataSourceJS)) dataSourceJS = $wnd.isc.DataSource.get(dataSourceJS);
        return @com.smartgwt.client.data.DataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataSourceJS);
    }-*/;

    public DetailViewer setAutoFetchData(Boolean autoFetchData) throws IllegalStateException {
        return (DetailViewer)setAttribute("autoFetchData", autoFetchData, false);
    }

    public Boolean getAutoFetchData() {
        return getAttributeAsBoolean("autoFetchData");
    }

    public DetailViewer setAutoFetchTextMatchStyle(TextMatchStyle autoFetchTextMatchStyle) throws IllegalStateException {
        return (DetailViewer)setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle.getValue(), false);
    }

    public TextMatchStyle getAutoFetchTextMatchStyle() {
        return TextMatchStyle.valueOf(getAttributeAsString("autoFetchTextMatchStyle"));
    }

    public DetailViewer setAutoFetchAsFilter(Boolean autoFetchAsFilter) throws IllegalStateException {
        return (DetailViewer)setAttribute("autoFetchAsFilter", autoFetchAsFilter, false);
    }

    public Boolean getAutoFetchAsFilter() {
        return getAttributeAsBoolean("autoFetchAsFilter");
    }

    public DetailViewer setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        return (DetailViewer)setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }

    public Criteria getInitialCriteria() {
        return new Criteria(getAttributeAsJavaScriptObject("initialCriteria"));
    }

    public DetailViewer setImplicitCriteria(Criteria implicitCriteria) {
        if (implicitCriteria instanceof Criterion) {
            implicitCriteria.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (DetailViewer)setAttribute("implicitCriteria", implicitCriteria == null ?
                            null : implicitCriteria.getJsObj(), true);
    }

    public Criteria getImplicitCriteria()  {
        return new Criteria(getAttributeAsJavaScriptObject("implicitCriteria"));
    }
    
    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
    	if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native void filterData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData();
    }-*/;

    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        if(@com.smartgwt.client.data.Criterion::instanceOf(Ljava/lang/Object;)(criteria)){
    		var criteriaJ = criteria.@com.smartgwt.client.core.DataClass::getJsObj()();
	    	@com.smartgwt.client.util.JSOHelper::setAttribute(Lcom/google/gwt/core/client/JavaScriptObject;Ljava/lang/String;Ljava/lang/String;)(criteriaJ,"_constructor","AdvancedCriteria");
	    }
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native void invalidateCache() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.invalidateCache();
    }-*/;

    public ResultSet getResultSet() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        if(dataJS == null) return null;
        if(!ResultSet.isResultSet(dataJS)) {
            SC.logWarn("getResultSet(): data is not a ResultSet; returning null " +
                "(if grouped, use getOriginalResultSet(); if unbound, use getRecordList(); " +
                "can only be called on DataBoundComponents after initial data has been fetched)");
            return null;
        }
        return ResultSet.getOrCreateRef(dataJS);
    }

    public native RecordList getRecordList() /*-{
        var dataJS = this.@com.smartgwt.client.widgets.DataBoundComponent::getDataAsJSList()();
        if (dataJS == null) return null;
        if ($wnd.isc.isA.ResultSet(dataJS)) {
            return this.@com.smartgwt.client.widgets.DataBoundComponent::getResultSet()();
        } else if ($wnd.isc.isA.ResultTree(dataJS)) {
            return @com.smartgwt.client.widgets.tree.ResultTree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
        } else if ($wnd.isc.isA.Tree(dataJS)) {
            return @com.smartgwt.client.widgets.tree.Tree::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
        }
        return @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dataJS);
    }-*/;

    public native JavaScriptObject getDataAsJSList() /*-{
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
    	if (self == null) return null;
    	return self.getDataAsList();
    	
    }-*/;

    public void exportData() {
        exportData(null);
    }

    public native void exportData(DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportData", "DSRequest,RPCCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


    public native void exportData(DSRequest requestProperties, RPCCallback callback) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "exportData", "DSRequest,RPCCallback");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.exportData(requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()(),
			$entry( function(response, rawData, request) {
				if(callback!=null) callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(
					@com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(response), 
					rawData, 
					@com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(request)
				);
			}));
    }-*/;

    /**
     * Add a fetchData handler.
     * <p>
     * Notification function fired on fetchData() or filterData()
     *
     * @param handler the filterData handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFetchDataHandler(FetchDataHandler handler) {
        if(getHandlerCount(FetchDataEvent.getType()) == 0) setupFetchDataEvent();
        return doAddHandler(handler, FetchDataEvent.getType());
    }

    private native void setupFetchDataEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({onFetchData:$debox($entry(function(){
                    var param = {"_this": this, "criteria" : arguments[0], "requestProperties" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.onFetchData = $debox($entry(function(){
                var param = {"_this": this, "criteria" : arguments[0], "requestProperties" : arguments[1]};
                var event = @com.smartgwt.client.widgets.events.FetchDataEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    /**
     * Add a {@link com.smartgwt.client.widgets.DropCompleteHandler}.  See that class's documentation for a definition of "drop complete",
     * and how it differs from "drag complete" ({@link com.smartgwt.client.widgets.DragCompleteHandler}).
     *
     * @param handler the DropCompleteHandler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDropCompleteHandler(DropCompleteHandler handler) {
        if(getHandlerCount(DropCompleteEvent.getType()) == 0) setupDropCompleteEvent();
        return doAddHandler(handler, DropCompleteEvent.getType());
    }

    private native void setupDropCompleteEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dropComplete:$debox($entry(function(){
                    var param = {"_this": this, "transferredRecords" : arguments[0]};
                    var event = @com.smartgwt.client.widgets.events.DropCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dropComplete = $debox($entry(function(){
                var param = {"_this": this, "transferredRecords" : arguments[0]};
                var event = @com.smartgwt.client.widgets.events.DropCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    /**
     * Add a {@link com.smartgwt.client.widgets.DragCompleteHandler}.  See that class's documentation for a definition of "drag complete",
     * and how it differs from "drop complete" ({@link com.smartgwt.client.widgets.DropCompleteHandler}).
     *
     * @param handler the DropCompleteHandler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDragCompleteHandler(DragCompleteHandler handler) {
        if(getHandlerCount(DragCompleteEvent.getType()) == 0) setupDragCompleteEvent();
        return doAddHandler(handler, DragCompleteEvent.getType());
    }

    private native void setupDragCompleteEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dragComplete:$debox($entry(function(){
                    var param = {"_this": this};
                    var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                }))
            });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dragComplete = $debox($entry(function(){
                var param = {"_this": this, "transferredRecords" : arguments[0]};
                var event = @com.smartgwt.client.widgets.events.DragCompleteEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            }));
        }
    }-*/;

    public native Alignment[] getFieldAlignments()/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var alignJS = self.getFieldAlignments();
        return @com.smartgwt.client.util.ConvertTo::arrayOfAlignment(Lcom/google/gwt/core/client/JavaScriptObject;)(alignJS);
    }-*/;

    public Boolean getDeepCloneOnEdit() {
        return getAttributeAsBoolean("deepCloneOnEdit");
    }

    public DetailViewer setDeepCloneOnEdit(Boolean deepCloneOnEdit) {
        return (DetailViewer)setAttribute("deepCloneOnEdit", deepCloneOnEdit, true);
    }

    public DetailViewer setFields(JavaScriptObject... fields) {
        if (fields != null) for(int i = 0; i < fields.length; i++) {
            fields[i] = duplicateFieldConfig(JSOHelper.cleanProperties(fields[i], false));
        }
        return (DetailViewer)setAttribute("fields", fields, true);
    }

    private native JavaScriptObject duplicateFieldConfig(JavaScriptObject config) /*-{
        return $wnd.isc.shallowClone(config);
    }-*/;

    public JavaScriptObject[] getFieldsAsJavaScriptObjects() {
        JavaScriptObject fieldsJsArray = getAttributeAsJavaScriptObject("fields");
        return JSOHelper.isArray(fieldsJsArray) ? JSOHelper.toArray(fieldsJsArray) : null;
    }

    public int getFieldCount() {
        JavaScriptObject[] fields = getFieldsAsJavaScriptObjects();
        return fields != null ? fields.length : 0;
    }
    
    public native void transferRecords(Record[] records, Record targetRecord, Integer index, Canvas sourceWidget, TransferRecordsCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        var targetRecordJS = targetRecord == null ? null : targetRecord.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        var indexJS = index == null ? null : index.@java.lang.Integer::intValue()();
        var sourceWidgetJS = sourceWidget == null ? null : sourceWidget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.transferRecords(recordsJS, targetRecordJS, indexJS, sourceWidgetJS, $entry(function(records) {
            if(callback != null) {
	    		var convertedArray = [];
	    		for (var i = 0; i < records.length; i++) {
	    			convertedArray[i] =  @com.smartgwt.client.data.Record::new(Lcom/google/gwt/core/client/JavaScriptObject;)(records[i]);
	    		}
                var recordsJ = @com.smartgwt.client.util.JSOHelper::convertToJavaObjectArray(Lcom/google/gwt/core/client/JavaScriptObject;)(convertedArray);
                callback.@com.smartgwt.client.widgets.TransferRecordsCallback::execute([Lcom/smartgwt/client/data/Record;)(recordsJ);
            }
        }));
    }-*/;

	/**
     * During a drag-and-drop interaction, this method returns the set of records being dragged
     * out of the component.  In the default implementation, this is the list of currently
     * selected records.<p>
     * This method is consulted by
     * {@link com.smartgwt.client.widgets.grid.ListGrid#willAcceptDrop willAcceptDrop()}.
     * @param DragDataCustomizer customizer
     * @return {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponent}
     * instance, for chaining setter calls
     */
    public native DetailViewer setDragDataCustomizer(DragDataCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        var componentJ = this;
        self.getDragData = $debox($entry(function() {
        	var returnJ = customizer.@com.smartgwt.client.widgets.DragDataCustomizer::getDragData(Lcom/smartgwt/client/widgets/DataBoundComponent;)(componentJ);
        	return @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(returnJ);
    	}));
        return this;
    }-*/;

    public native SortSpecifier[] getSort() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSort", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        if(self == null) return null
        var ret = self.getSort();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfSortSpecifier(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
    
    public native DetailViewer setSort(SortSpecifier... sortSpecifiers) /*-{
        var sortSpecifiersJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(sortSpecifiers);
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSort(sortSpecifiersJS);
        return this;
    }-*/;


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DetailViewerLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.blockSeparator = getAttributeAsString("blockSeparator");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.blockSeparator:" + t.getMessage() + "\n";
        }
        try {
            s.blockStyle = getAttributeAsString("blockStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.blockStyle:" + t.getMessage() + "\n";
        }
        try {
            s.canPickFields = getAttributeAsString("canPickFields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.canPickFields:" + t.getMessage() + "\n";
        }
        try {
            s.cellStyle = getAttributeAsString("cellStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.cellStyle:" + t.getMessage() + "\n";
        }
        try {
            s.configureFieldsText = getAttributeAsString("configureFieldsText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.configureFieldsText:" + t.getMessage() + "\n";
        }
        try {
            s.dataFetchMode = getAttributeAsString("dataFetchMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.dataFetchMode:" + t.getMessage() + "\n";
        }
        try {
            s.dateFormatter = getAttributeAsString("dateFormatter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.dateFormatter:" + t.getMessage() + "\n";
        }
        try {
            s.datetimeFormatter = getAttributeAsString("datetimeFormatter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.datetimeFormatter:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.emptyCellValue = getAttributeAsString("emptyCellValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.emptyCellValue:" + t.getMessage() + "\n";
        }
        try {
            s.emptyMessage = getAttributeAsString("emptyMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.emptyMessage:" + t.getMessage() + "\n";
        }
        try {
            s.emptyMessageStyle = getAttributeAsString("emptyMessageStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.emptyMessageStyle:" + t.getMessage() + "\n";
        }
        try {
            s.fieldIdProperty = getAttributeAsString("fieldIdProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.fieldIdProperty:" + t.getMessage() + "\n";
        }
        try {
            s.fieldPickerFieldProperties = getAttributeAsStringArray("fieldPickerFieldProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.fieldPickerFieldPropertiesArray:" + t.getMessage() + "\n";
        }
        try {
            s.headerStyle = getAttributeAsString("headerStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.headerStyle:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteIconHeight = getAttributeAsString("hiliteIconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.hiliteIconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteIconLeftPadding = getAttributeAsString("hiliteIconLeftPadding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.hiliteIconLeftPadding:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteIconPosition = getAttributeAsString("hiliteIconPosition");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.hiliteIconPosition:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteIconRightPadding = getAttributeAsString("hiliteIconRightPadding");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.hiliteIconRightPadding:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteIcons = getAttributeAsStringArray("hiliteIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.hiliteIconsArray:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteIconSize = getAttributeAsString("hiliteIconSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.hiliteIconSize:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteIconWidth = getAttributeAsString("hiliteIconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.hiliteIconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.labelAlign = getAttributeAsString("labelAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.labelAlign:" + t.getMessage() + "\n";
        }
        try {
            s.labelPrefix = getAttributeAsString("labelPrefix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.labelPrefix:" + t.getMessage() + "\n";
        }
        try {
            s.labelStyle = getAttributeAsString("labelStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.labelStyle:" + t.getMessage() + "\n";
        }
        try {
            s.labelSuffix = getAttributeAsString("labelSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.labelSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.linkTextProperty = getAttributeAsString("linkTextProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.linkTextProperty:" + t.getMessage() + "\n";
        }
        try {
            s.loadingMessage = getAttributeAsString("loadingMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.loadingMessage:" + t.getMessage() + "\n";
        }
        try {
            s.loadingMessageStyle = getAttributeAsString("loadingMessageStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.loadingMessageStyle:" + t.getMessage() + "\n";
        }
        try {
            s.printCellStyle = getAttributeAsString("printCellStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.printCellStyle:" + t.getMessage() + "\n";
        }
        try {
            s.printHeaderStyle = getAttributeAsString("printHeaderStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.printHeaderStyle:" + t.getMessage() + "\n";
        }
        try {
            s.printLabelStyle = getAttributeAsString("printLabelStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.printLabelStyle:" + t.getMessage() + "\n";
        }
        try {
            s.recordsPerBlock = getAttributeAsString("recordsPerBlock");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.recordsPerBlock:" + t.getMessage() + "\n";
        }
        try {
            s.rowHeight = getAttributeAsString("rowHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.rowHeight:" + t.getMessage() + "\n";
        }
        try {
            s.separatorStyle = getAttributeAsString("separatorStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.separatorStyle:" + t.getMessage() + "\n";
        }
        try {
            s.showDetailFields = getAttributeAsString("showDetailFields");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.showDetailFields:" + t.getMessage() + "\n";
        }
        try {
            s.showEmptyField = getAttributeAsString("showEmptyField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.showEmptyField:" + t.getMessage() + "\n";
        }
        try {
            s.showEmptyMessage = getAttributeAsString("showEmptyMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.showEmptyMessage:" + t.getMessage() + "\n";
        }
        try {
            s.styleName = getAttributeAsString("styleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.styleName:" + t.getMessage() + "\n";
        }
        try {
            s.timeFormatter = getAttributeAsString("timeFormatter");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.timeFormatter:" + t.getMessage() + "\n";
        }
        try {
            s.valueAlign = getAttributeAsString("valueAlign");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.valueAlign:" + t.getMessage() + "\n";
        }
        try {
            s.wrapLabel = getAttributeAsString("wrapLabel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.wrapLabel:" + t.getMessage() + "\n";
        }
        try {
            s.wrapValues = getAttributeAsString("wrapValues");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DetailViewer.wrapValues:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DetailViewerLogicalStructure s = new DetailViewerLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
