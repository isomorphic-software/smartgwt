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
 
package com.smartgwt.client.widgets.tableview;


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
import com.smartgwt.logicalstructure.widgets.tour.*;

/**
 * Shows a listing of records with one or more fields from each record, with built-in support for navigation and editing of
 * lists of records. <p/> The TableView provides built-in controls such as {@link
 * com.smartgwt.client.widgets.tableview.TableView#getShowNavigation navigation arrows} and shows fields from the provided
 * records in one of several built-in {@link com.smartgwt.client.types.RecordLayout}s. <p/> NOTE: This widget is intended
 * primarily for creating handset/phone-sized interfaces and does not have an appearance in any skin other than Mobile.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("TableView")
public class TableView extends ListGrid implements com.smartgwt.client.widgets.tableview.events.HasImageClickHandlers, com.smartgwt.client.widgets.tableview.events.HasRecordNavigationClickHandlers {

    public static TableView getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new TableView(jsObj);
        } else {
            assert refInstance instanceof TableView;
            return (TableView)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TableView.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.TableView.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(TableView.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.TableView.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public TableView(){
        scClassName = "TableView";
    }

    public TableView(JavaScriptObject jsObj){
        scClassName = "TableView";
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
     * Option to save searches is disabled for TableView
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canSaveSearches New canSaveSearches value. Default value is false
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TableView setCanSaveSearches(boolean canSaveSearches)  throws IllegalStateException {
        return (TableView)setAttribute("canSaveSearches", canSaveSearches, false);
    }

    /**
     * Option to save searches is disabled for TableView
     *
     * @return Current canSaveSearches value. Default value is false
     */
    public boolean getCanSaveSearches()  {
        Boolean result = getAttributeAsBoolean("canSaveSearches");
        return result == null ? false : result;
    }
    

    /**
     * Option to show filter editor is disabled for TableView
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canShowFilterEditor New canShowFilterEditor value. Default value is false
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public TableView setCanShowFilterEditor(boolean canShowFilterEditor)  throws IllegalStateException {
        return (TableView)setAttribute("canShowFilterEditor", canShowFilterEditor, false);
    }

    /**
     * Option to show filter editor is disabled for TableView
     *
     * @return Current canShowFilterEditor value. Default value is false
     */
    public boolean getCanShowFilterEditor()  {
        Boolean result = getAttributeAsBoolean("canShowFilterEditor");
        return result == null ? false : result;
    }
    

    /**
     * Field to display as part of individual record in "summary" {@link com.smartgwt.client.types.RecordLayout}s.
     *
     * @param dataField New dataField value. Default value is "data"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     */
    public TableView setDataField(String dataField) {
        return (TableView)setAttribute("dataField", dataField, true);
    }

    /**
     * Field to display as part of individual record in "summary" {@link com.smartgwt.client.types.RecordLayout}s.
     *
     * @return Current dataField value. Default value is "data"
     */
    public String getDataField()  {
        return getAttributeAsString("dataField");
    }
    

    /**
     * Field to display as part of individual record in all {@link com.smartgwt.client.types.RecordLayout}s  except
     * "titleOnly".
     *
     * @param descriptionField New descriptionField value. Default value is "description"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     */
    public TableView setDescriptionField(String descriptionField) {
        return (TableView)setAttribute("descriptionField", descriptionField, true);
    }

    /**
     * Field to display as part of individual record in all {@link com.smartgwt.client.types.RecordLayout}s  except
     * "titleOnly".
     *
     * @return Current descriptionField value. Default value is "description"
     */
    public String getDescriptionField()  {
        return getAttributeAsString("descriptionField");
    }
    

    /**
     * This property allows the developer to specify the icon displayed next to a record. Set
     * <code>record[tableView.iconField]</code> to the URL of the desired icon to display. Only applies if {@link
     * com.smartgwt.client.widgets.tableview.TableView#getShowIconField showIconField} is <code>true</code>.
     *
     * @param iconField New iconField value. Default value is "icon"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     */
    public TableView setIconField(String iconField) {
        return (TableView)setAttribute("iconField", iconField, true);
    }

    /**
     * This property allows the developer to specify the icon displayed next to a record. Set
     * <code>record[tableView.iconField]</code> to the URL of the desired icon to display. Only applies if {@link
     * com.smartgwt.client.widgets.tableview.TableView#getShowIconField showIconField} is <code>true</code>.
     *
     * @return Current iconField value. Default value is "icon"
     */
    public String getIconField()  {
        return getAttributeAsString("iconField");
    }
    

    /**
     * Field to display as part of individual record in "summary" {@link com.smartgwt.client.types.RecordLayout}s.
     *
     * @param infoField New infoField value. Default value is "info"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     * @see com.smartgwt.client.types.RecordLayout
     */
    public TableView setInfoField(String infoField) {
        return (TableView)setAttribute("infoField", infoField, true);
    }

    /**
     * Field to display as part of individual record in "summary" {@link com.smartgwt.client.types.RecordLayout}s.
     *
     * @return Current infoField value. Default value is "info"
     * @see com.smartgwt.client.types.RecordLayout
     */
    public String getInfoField()  {
        return getAttributeAsString("infoField");
    }
    

    /**
     * The navigation icon shown next to records when {@link com.smartgwt.client.widgets.tableview.TableView#getShowNavigation
     * showNavigation} is true and {@link com.smartgwt.client.types.NavigationMode} is set to "navIconOny".
     *
     * @param navIcon New navIcon value. Default value is "[SKINIMG]/iOS/listArrow_button.png"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public TableView setNavIcon(String navIcon) {
        return (TableView)setAttribute("navIcon", navIcon, true);
    }

    /**
     * The navigation icon shown next to records when {@link com.smartgwt.client.widgets.tableview.TableView#getShowNavigation
     * showNavigation} is true and {@link com.smartgwt.client.types.NavigationMode} is set to "navIconOny".
     *
     * @return Current navIcon value. Default value is "[SKINIMG]/iOS/listArrow_button.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getNavIcon()  {
        return getAttributeAsString("navIcon");
    }
    

    /**
     * Set navigation mode for this TableView.
     *
     * @param navigationMode New navigationMode value. Default value is "wholeRecord"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     */
    public TableView setNavigationMode(NavigationMode navigationMode) {
        return (TableView)setAttribute("navigationMode", navigationMode == null ? null : navigationMode.getValue(), true);
    }

    /**
     * Set navigation mode for this TableView.
     *
     * @return Current navigationMode value. Default value is "wholeRecord"
     */
    public NavigationMode getNavigationMode()  {
        return EnumUtil.getEnum(NavigationMode.values(), getAttribute("navigationMode"));
    }
    

    /**
     * Default style for data field.
     *
     * @param recordDataStyle New recordDataStyle value. Default value is "recordData"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public TableView setRecordDataStyle(String recordDataStyle) {
        return (TableView)setAttribute("recordDataStyle", recordDataStyle, true);
    }

    /**
     * Default style for data field.
     *
     * @return Current recordDataStyle value. Default value is "recordData"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getRecordDataStyle()  {
        return getAttributeAsString("recordDataStyle");
    }
    

    /**
     * Default style for description.
     *
     * @param recordDescriptionStyle New recordDescriptionStyle value. Default value is "recordDescription"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public TableView setRecordDescriptionStyle(String recordDescriptionStyle) {
        return (TableView)setAttribute("recordDescriptionStyle", recordDescriptionStyle, true);
    }

    /**
     * Default style for description.
     *
     * @return Current recordDescriptionStyle value. Default value is "recordDescription"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getRecordDescriptionStyle()  {
        return getAttributeAsString("recordDescriptionStyle");
    }
    

    /**
     * Default style for info field.
     *
     * @param recordInfoStyle New recordInfoStyle value. Default value is "recordInfo"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public TableView setRecordInfoStyle(String recordInfoStyle) {
        return (TableView)setAttribute("recordInfoStyle", recordInfoStyle, true);
    }

    /**
     * Default style for info field.
     *
     * @return Current recordInfoStyle value. Default value is "recordInfo"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getRecordInfoStyle()  {
        return getAttributeAsString("recordInfoStyle");
    }
    

    /**
     * Sets the arrangement of data fields from the record. <p/> Note that controls supported by the TableView itself, such as
     * navigation icons, are implicitly added to the data fields described in the RecordLayout.  If an {@link
     * com.smartgwt.client.widgets.tableview.TableView#getIconField iconField} has been configured, it too is an implicitly
     * shown field, to the left of the area controlled by RecordLayout.
     *
     * @param recordLayout New recordLayout value. Default value is "titleOnly"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     */
    public TableView setRecordLayout(RecordLayout recordLayout) {
        return (TableView)setAttribute("recordLayout", recordLayout == null ? null : recordLayout.getValue(), true);
    }

    /**
     * Sets the arrangement of data fields from the record. <p/> Note that controls supported by the TableView itself, such as
     * navigation icons, are implicitly added to the data fields described in the RecordLayout.  If an {@link
     * com.smartgwt.client.widgets.tableview.TableView#getIconField iconField} has been configured, it too is an implicitly
     * shown field, to the left of the area controlled by RecordLayout.
     *
     * @return Current recordLayout value. Default value is "titleOnly"
     */
    public RecordLayout getRecordLayout()  {
        return EnumUtil.getEnum(RecordLayout.values(), getAttribute("recordLayout"));
    }
    

    /**
     * Boolean property on each record that controls whether navigation controls are shown for that record. If property is not
     * defined on the record a navigation icon is shown if {@link
     * com.smartgwt.client.widgets.tableview.TableView#getShowNavigation showNavigation} is <code>true</code>.
     *
     * @param recordNavigationProperty New recordNavigationProperty value. Default value is "_navigate"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     */
    public TableView setRecordNavigationProperty(String recordNavigationProperty) {
        return (TableView)setAttribute("recordNavigationProperty", recordNavigationProperty, true);
    }

    /**
     * Boolean property on each record that controls whether navigation controls are shown for that record. If property is not
     * defined on the record a navigation icon is shown if {@link
     * com.smartgwt.client.widgets.tableview.TableView#getShowNavigation showNavigation} is <code>true</code>.
     *
     * @return Current recordNavigationProperty value. Default value is "_navigate"
     */
    public String getRecordNavigationProperty()  {
        return getAttributeAsString("recordNavigationProperty");
    }
    

    /**
     * Default style for title.
     *
     * @param recordTitleStyle New recordTitleStyle value. Default value is "recordTitle"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public TableView setRecordTitleStyle(String recordTitleStyle) {
        return (TableView)setAttribute("recordTitleStyle", recordTitleStyle, true);
    }

    /**
     * Default style for title.
     *
     * @return Current recordTitleStyle value. Default value is "recordTitle"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getRecordTitleStyle()  {
        return getAttributeAsString("recordTitleStyle");
    }
    

    /**
     * Should an icon field be shown for each record? A column in the table is set aside for an icon as specified on each
     * record in the {@link com.smartgwt.client.widgets.tableview.TableView#getIconField iconField}.
     *
     * @param showIconField New showIconField value. Default value is true
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     */
    public TableView setShowIconField(Boolean showIconField) {
        return (TableView)setAttribute("showIconField", showIconField, true);
    }

    /**
     * Should an icon field be shown for each record? A column in the table is set aside for an icon as specified on each
     * record in the {@link com.smartgwt.client.widgets.tableview.TableView#getIconField iconField}.
     *
     * @return Current showIconField value. Default value is true
     */
    public Boolean getShowIconField()  {
        Boolean result = getAttributeAsBoolean("showIconField");
        return result == null ? true : result;
    }
    

    /**
     * Whether to show navigation controls by default on all records.  Can also be configured per-record with {@link
     * com.smartgwt.client.widgets.tableview.TableView#getRecordNavigationProperty recordNavigationProperty}.
     *
     * @param showNavigation New showNavigation value. Default value is null
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     */
    public TableView setShowNavigation(Boolean showNavigation) {
        return (TableView)setAttribute("showNavigation", showNavigation, true);
    }

    /**
     * Whether to show navigation controls by default on all records.  Can also be configured per-record with {@link
     * com.smartgwt.client.widgets.tableview.TableView#getRecordNavigationProperty recordNavigationProperty}.
     *
     * @return Current showNavigation value. Default value is null
     */
    public Boolean getShowNavigation()  {
        return getAttributeAsBoolean("showNavigation");
    }
    

    /**
     * The display mode of the table.
     *
     * @param tableMode New tableMode value. Default value is "plain"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     */
    public TableView setTableMode(TableMode tableMode) {
        return (TableView)setAttribute("tableMode", tableMode == null ? null : tableMode.getValue(), true);
    }

    /**
     * The display mode of the table.
     *
     * @return Current tableMode value. Default value is "plain"
     */
    public TableMode getTableMode()  {
        return EnumUtil.getEnum(TableMode.values(), getAttribute("tableMode"));
    }
    

    /**
     * Field to display for an individual record as the main title.
     *
     * @param titleField New titleField value. Default value is "title"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     */
    public TableView setTitleField(String titleField) {
        return (TableView)setAttribute("titleField", titleField, true);
    }

    /**
     * Field to display for an individual record as the main title.
     *
     * @return Current titleField value. Default value is "title"
     */
    public String getTitleField()  {
        return getAttributeAsString("titleField");
    }
    

    /**
     * The navigation icon shown next to records when {@link com.smartgwt.client.widgets.tableview.TableView#getShowNavigation
     * showNavigation} is true and {@link com.smartgwt.client.types.NavigationMode} is set to "wholeRecord".
     *
     * @param wholeRecordNavIcon New wholeRecordNavIcon value. Default value is "[SKINIMG]/iOS/listArrow.png"
     * @return {@link com.smartgwt.client.widgets.tableview.TableView TableView} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public TableView setWholeRecordNavIcon(String wholeRecordNavIcon) {
        return (TableView)setAttribute("wholeRecordNavIcon", wholeRecordNavIcon, true);
    }

    /**
     * The navigation icon shown next to records when {@link com.smartgwt.client.widgets.tableview.TableView#getShowNavigation
     * showNavigation} is true and {@link com.smartgwt.client.types.NavigationMode} is set to "wholeRecord".
     *
     * @return Current wholeRecordNavIcon value. Default value is "[SKINIMG]/iOS/listArrow.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getWholeRecordNavIcon()  {
        return getAttributeAsString("wholeRecordNavIcon");
    }
    

    // ********************* Methods ***********************
    /**
     * Add a imageClick handler.
     * <p>
     * Executed when the user clicks on the image displayed in a record if {@link
     * com.smartgwt.client.widgets.tableview.TableView#getIconField TableView.iconField} has been specified.
     *
     * @param handler the imageClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addImageClickHandler(com.smartgwt.client.widgets.tableview.events.ImageClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tableview.events.ImageClickEvent.getType()) == 0) setupImageClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tableview.events.ImageClickEvent.getType());
    }

    private native void setupImageClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var imageClick = $entry(function(){
            var param = {"_this": this, "record" : arguments[0]};
            var event = @com.smartgwt.client.widgets.tableview.events.ImageClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tableview.TableView::handleTearDownImageClickEvent()();
            if (hasDefaultHandler) this.Super("imageClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("imageClick"));
            obj.addProperties({imageClick:  imageClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("imageClick"));
            obj.imageClick =  imageClick             ;
        }
    }-*/;

    private void handleTearDownImageClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tableview.events.ImageClickEvent.getType()) == 0) tearDownImageClickEvent();
    }

    private native void tearDownImageClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("imageClick")) delete obj.imageClick;
    }-*/;

    /**
     * Add a recordNavigationClick handler.
     * <p>
     * Executed when the user clicks on a record, or on the navigate icon for a record depending on {@link
     * com.smartgwt.client.types.NavigationMode}.
     *
     * @param handler the recordNavigationClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addRecordNavigationClickHandler(com.smartgwt.client.widgets.tableview.events.RecordNavigationClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tableview.events.RecordNavigationClickEvent.getType()) == 0) setupRecordNavigationClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tableview.events.RecordNavigationClickEvent.getType());
    }

    private native void setupRecordNavigationClickEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var recordNavigationClick = $entry(function(){
            var param = {"_this": this, "record" : arguments[0]};
            var event = @com.smartgwt.client.widgets.tableview.events.RecordNavigationClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.tableview.TableView::handleTearDownRecordNavigationClickEvent()();
            if (hasDefaultHandler) this.Super("recordNavigationClick", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("recordNavigationClick"));
            obj.addProperties({recordNavigationClick:  recordNavigationClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("recordNavigationClick"));
            obj.recordNavigationClick =  recordNavigationClick             ;
        }
    }-*/;

    private void handleTearDownRecordNavigationClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.tableview.events.RecordNavigationClickEvent.getType()) == 0) tearDownRecordNavigationClickEvent();
    }

    private native void tearDownRecordNavigationClickEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("recordNavigationClick")) delete obj.recordNavigationClick;
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
     * @param tableViewProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(TableView tableViewProperties) /*-{
        if (tableViewProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(TableView.@java.lang.Object::getClass()(), "setDefaultProperties", tableViewProperties.@java.lang.Object::getClass()());
        }
        tableViewProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = tableViewProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.TableView.addProperties(properties);
    }-*/;

    // ***********************************************************


	
    public native void setRecordFormatter(RecordFormatter formatter) /*-{
	    var self;
	    if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
	        self =  this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
	    } else {
	         self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
	    }
	    self.formatRecord = $debox($entry(function(record) {
	    	
	        var recordJ = record == null ? null :
	        				@com.smartgwt.client.widgets.grid.ListGridRecord::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
	        return formatter.@com.smartgwt.client.widgets.tableview.RecordFormatter::format(Lcom/smartgwt/client/widgets/grid/ListGridRecord;)(recordJ);
	    }));
	}-*/;



    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(TableViewLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.canSaveSearches = getAttributeAsString("canSaveSearches");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.canSaveSearches:" + t.getMessage() + "\n";
        }
        try {
            s.canShowFilterEditor = getAttributeAsString("canShowFilterEditor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.canShowFilterEditor:" + t.getMessage() + "\n";
        }
        try {
            s.dataField = getAttributeAsString("dataField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.dataField:" + t.getMessage() + "\n";
        }
        try {
            s.descriptionField = getAttributeAsString("descriptionField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.descriptionField:" + t.getMessage() + "\n";
        }
        try {
            s.iconField = getAttributeAsString("iconField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.iconField:" + t.getMessage() + "\n";
        }
        try {
            s.infoField = getAttributeAsString("infoField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.infoField:" + t.getMessage() + "\n";
        }
        try {
            s.navIcon = getAttributeAsString("navIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.navIcon:" + t.getMessage() + "\n";
        }
        try {
            s.navigationMode = getAttributeAsString("navigationMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.navigationMode:" + t.getMessage() + "\n";
        }
        try {
            s.recordDataStyle = getAttributeAsString("recordDataStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.recordDataStyle:" + t.getMessage() + "\n";
        }
        try {
            s.recordDescriptionStyle = getAttributeAsString("recordDescriptionStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.recordDescriptionStyle:" + t.getMessage() + "\n";
        }
        try {
            s.recordInfoStyle = getAttributeAsString("recordInfoStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.recordInfoStyle:" + t.getMessage() + "\n";
        }
        try {
            s.recordLayout = getAttributeAsString("recordLayout");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.recordLayout:" + t.getMessage() + "\n";
        }
        try {
            s.recordNavigationProperty = getAttributeAsString("recordNavigationProperty");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.recordNavigationProperty:" + t.getMessage() + "\n";
        }
        try {
            s.recordTitleStyle = getAttributeAsString("recordTitleStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.recordTitleStyle:" + t.getMessage() + "\n";
        }
        try {
            s.showIconField = getAttributeAsString("showIconField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.showIconField:" + t.getMessage() + "\n";
        }
        try {
            s.showNavigation = getAttributeAsString("showNavigation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.showNavigation:" + t.getMessage() + "\n";
        }
        try {
            s.tableMode = getAttributeAsString("tableMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.tableMode:" + t.getMessage() + "\n";
        }
        try {
            s.titleField = getAttributeAsString("titleField");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.titleField:" + t.getMessage() + "\n";
        }
        try {
            s.wholeRecordNavIcon = getAttributeAsString("wholeRecordNavIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "TableView.wholeRecordNavIcon:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        TableViewLogicalStructure s = new TableViewLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
