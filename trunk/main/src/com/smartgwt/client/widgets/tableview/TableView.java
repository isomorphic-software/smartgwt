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
 
package com.smartgwt.client.widgets.tableview;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Shows a listing of records with one or more fields from each record, with built-in support for navigation and editing of
 * lists of records. <p/> The TableView provides built-in controls such as {@link
 * com.smartgwt.client.widgets.tableview.TableView#getShowNavigation navigation arrows} and shows fields from the provided
 * records in one of several built-in {@link com.smartgwt.client.types.RecordLayout}s. <p/> NOTE: This widget is intended
 * primarily for creating handset/phone-sized interfaces and does not have an appearance in any skin other than Mobile.
 */
public class TableView extends ListGrid  implements com.smartgwt.client.widgets.tableview.events.HasImageClickHandlers, com.smartgwt.client.widgets.tableview.events.HasRecordNavigationClickHandlers {

    public static TableView getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (TableView) obj;
        } else {
            return new TableView(jsObj);
        }
    }

    public TableView(){
        scClassName = "TableView";
    }

    public TableView(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Field to display as part of individual record in "summary" {@link com.smartgwt.client.types.RecordLayout}s.
     *
     * @param dataField dataField Default value is "data"
     */
    public void setDataField(String dataField) {
        setAttribute("dataField", dataField, true);
    }

    /**
     * Field to display as part of individual record in "summary" {@link com.smartgwt.client.types.RecordLayout}s.
     *
     *
     * @return String
     */
    public String getDataField()  {
        return getAttributeAsString("dataField");
    }

    /**
     * Field to display as part of individual record in all {@link com.smartgwt.client.types.RecordLayout}s  except
     * "titleOnly".
     *
     * @param descriptionField descriptionField Default value is "description"
     */
    public void setDescriptionField(String descriptionField) {
        setAttribute("descriptionField", descriptionField, true);
    }

    /**
     * Field to display as part of individual record in all {@link com.smartgwt.client.types.RecordLayout}s  except
     * "titleOnly".
     *
     *
     * @return String
     */
    public String getDescriptionField()  {
        return getAttributeAsString("descriptionField");
    }

    /**
     * This property allows the developer to specify the icon displayed next to a record. Set
     * <code>record[tableView.iconField]</code> to the URL of the desired icon to display. Only applies if {@link
     * com.smartgwt.client.widgets.tableview.TableView#getShowIconField showIconField} is <code>true</code>.
     *
     * @param iconField iconField Default value is "icon"
     */
    public void setIconField(String iconField) {
        setAttribute("iconField", iconField, true);
    }

    /**
     * This property allows the developer to specify the icon displayed next to a record. Set
     * <code>record[tableView.iconField]</code> to the URL of the desired icon to display. Only applies if {@link
     * com.smartgwt.client.widgets.tableview.TableView#getShowIconField showIconField} is <code>true</code>.
     *
     *
     * @return String
     */
    public String getIconField()  {
        return getAttributeAsString("iconField");
    }

    /**
     * Field to display as part of individual record in "summary" {@link com.smartgwt.client.types.RecordLayout}s.
     *
     * @param infoField infoField Default value is "info"
     * @see com.smartgwt.client.types.RecordLayout
     */
    public void setInfoField(String infoField) {
        setAttribute("infoField", infoField, true);
    }

    /**
     * Field to display as part of individual record in "summary" {@link com.smartgwt.client.types.RecordLayout}s.
     *
     *
     * @return String
     * @see com.smartgwt.client.types.RecordLayout
     */
    public String getInfoField()  {
        return getAttributeAsString("infoField");
    }

    /**
     * The navigation icon shown next to records when {@link com.smartgwt.client.widgets.tableview.TableView#getShowNavigation
     * showNavigation} is true and {@link com.smartgwt.client.types.NavigationMode} is set to "navIconOny".
     *
     * @param navIcon navIcon Default value is "[SKINIMG]/iOS/listArrow_button.png"
     */
    public void setNavIcon(String navIcon) {
        setAttribute("navIcon", navIcon, true);
    }

    /**
     * The navigation icon shown next to records when {@link com.smartgwt.client.widgets.tableview.TableView#getShowNavigation
     * showNavigation} is true and {@link com.smartgwt.client.types.NavigationMode} is set to "navIconOny".
     *
     *
     * @return String
     */
    public String getNavIcon()  {
        return getAttributeAsString("navIcon");
    }

    /**
     * Set navigation mode for this TableView.
     *
     * @param navigationMode navigationMode Default value is "wholeRecord"
     */
    public void setNavigationMode(NavigationMode navigationMode) {
        setAttribute("navigationMode", navigationMode.getValue(), true);
    }

    /**
     * Set navigation mode for this TableView.
     *
     *
     * @return NavigationMode
     */
    public NavigationMode getNavigationMode()  {
        return EnumUtil.getEnum(NavigationMode.values(), getAttribute("navigationMode"));
    }

    /**
     * Default style for data field.
     *
     * @param recordDataStyle recordDataStyle Default value is "recordData"
     */
    public void setRecordDataStyle(String recordDataStyle) {
        setAttribute("recordDataStyle", recordDataStyle, true);
    }

    /**
     * Default style for data field.
     *
     *
     * @return String
     */
    public String getRecordDataStyle()  {
        return getAttributeAsString("recordDataStyle");
    }

    /**
     * Default style for description.
     *
     * @param recordDescriptionStyle recordDescriptionStyle Default value is "recordDescription"
     */
    public void setRecordDescriptionStyle(String recordDescriptionStyle) {
        setAttribute("recordDescriptionStyle", recordDescriptionStyle, true);
    }

    /**
     * Default style for description.
     *
     *
     * @return String
     */
    public String getRecordDescriptionStyle()  {
        return getAttributeAsString("recordDescriptionStyle");
    }

    /**
     * Default style for info field.
     *
     * @param recordInfoStyle recordInfoStyle Default value is "recordInfo"
     */
    public void setRecordInfoStyle(String recordInfoStyle) {
        setAttribute("recordInfoStyle", recordInfoStyle, true);
    }

    /**
     * Default style for info field.
     *
     *
     * @return String
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
     * @param recordLayout recordLayout Default value is "titleOnly"
     */
    public void setRecordLayout(RecordLayout recordLayout) {
        setAttribute("recordLayout", recordLayout.getValue(), true);
    }

    /**
     * Sets the arrangement of data fields from the record. <p/> Note that controls supported by the TableView itself, such as
     * navigation icons, are implicitly added to the data fields described in the RecordLayout.  If an {@link
     * com.smartgwt.client.widgets.tableview.TableView#getIconField iconField} has been configured, it too is an implicitly
     * shown field, to the left of the area controlled by RecordLayout.
     *
     *
     * @return RecordLayout
     */
    public RecordLayout getRecordLayout()  {
        return EnumUtil.getEnum(RecordLayout.values(), getAttribute("recordLayout"));
    }

    /**
     * Boolean property on each record that controls whether navigation controls are shown for that record. If property is not
     * defined on the record a navigation icon is shown if {@link
     * com.smartgwt.client.widgets.tableview.TableView#getShowNavigation showNavigation} is <code>true</code>.
     *
     * @param recordNavigationProperty recordNavigationProperty Default value is "_navigate"
     */
    public void setRecordNavigationProperty(String recordNavigationProperty) {
        setAttribute("recordNavigationProperty", recordNavigationProperty, true);
    }

    /**
     * Boolean property on each record that controls whether navigation controls are shown for that record. If property is not
     * defined on the record a navigation icon is shown if {@link
     * com.smartgwt.client.widgets.tableview.TableView#getShowNavigation showNavigation} is <code>true</code>.
     *
     *
     * @return String
     */
    public String getRecordNavigationProperty()  {
        return getAttributeAsString("recordNavigationProperty");
    }

    /**
     * Default style for title.
     *
     * @param recordTitleStyle recordTitleStyle Default value is "recordTitle"
     */
    public void setRecordTitleStyle(String recordTitleStyle) {
        setAttribute("recordTitleStyle", recordTitleStyle, true);
    }

    /**
     * Default style for title.
     *
     *
     * @return String
     */
    public String getRecordTitleStyle()  {
        return getAttributeAsString("recordTitleStyle");
    }

    /**
     * Should an icon field be shown for each record? A column in the table is set aside for an icon as specified on each
     * record in the {@link com.smartgwt.client.widgets.tableview.TableView#getIconField iconField}.
     *
     * @param showIconField showIconField Default value is true
     */
    public void setShowIconField(Boolean showIconField) {
        setAttribute("showIconField", showIconField, true);
    }

    /**
     * Should an icon field be shown for each record? A column in the table is set aside for an icon as specified on each
     * record in the {@link com.smartgwt.client.widgets.tableview.TableView#getIconField iconField}.
     *
     *
     * @return Boolean
     */
    public Boolean getShowIconField()  {
        return getAttributeAsBoolean("showIconField");
    }

    /**
     * Whether to show navigation controls by default on all records.  Can also be configured per-record with {@link
     * com.smartgwt.client.widgets.tableview.TableView#getRecordNavigationProperty recordNavigationProperty}.
     *
     * @param showNavigation showNavigation Default value is null
     */
    public void setShowNavigation(Boolean showNavigation) {
        setAttribute("showNavigation", showNavigation, true);
    }

    /**
     * Whether to show navigation controls by default on all records.  Can also be configured per-record with {@link
     * com.smartgwt.client.widgets.tableview.TableView#getRecordNavigationProperty recordNavigationProperty}.
     *
     *
     * @return Boolean
     */
    public Boolean getShowNavigation()  {
        return getAttributeAsBoolean("showNavigation");
    }

    /**
     * The display mode of the table.
     *
     * @param tableMode tableMode Default value is "plain"
     */
    public void setTableMode(TableMode tableMode) {
        setAttribute("tableMode", tableMode.getValue(), true);
    }

    /**
     * The display mode of the table.
     *
     *
     * @return TableMode
     */
    public TableMode getTableMode()  {
        return EnumUtil.getEnum(TableMode.values(), getAttribute("tableMode"));
    }

    /**
     * Field to display for an individual record as the main title.
     *
     * @param titleField titleField Default value is "title"
     */
    public void setTitleField(String titleField) {
        setAttribute("titleField", titleField, true);
    }

    /**
     * Field to display for an individual record as the main title.
     *
     *
     * @return String
     */
    public String getTitleField()  {
        return getAttributeAsString("titleField");
    }

    /**
     * The navigation icon shown next to records when {@link com.smartgwt.client.widgets.tableview.TableView#getShowNavigation
     * showNavigation} is true and {@link com.smartgwt.client.types.NavigationMode} is set to "wholeRecord".
     *
     * @param wholeRecordNavIcon wholeRecordNavIcon Default value is "[SKINIMG]/iOS/listArrow.png"
     */
    public void setWholeRecordNavIcon(String wholeRecordNavIcon) {
        setAttribute("wholeRecordNavIcon", wholeRecordNavIcon, true);
    }

    /**
     * The navigation icon shown next to records when {@link com.smartgwt.client.widgets.tableview.TableView#getShowNavigation
     * showNavigation} is true and {@link com.smartgwt.client.types.NavigationMode} is set to "wholeRecord".
     *
     *
     * @return String
     */
    public String getWholeRecordNavIcon()  {
        return getAttributeAsString("wholeRecordNavIcon");
    }

    // ********************* Methods ***********************
    /**
     * Add a imageClick handler.
     * <p>
     * Executed when the user clicks on the image displayed in a record if {@link
     * com.smartgwt.client.widgets.tableview.TableView#getIconField iconField} has been specified.
     *
     * @param handler the imageClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addImageClickHandler(com.smartgwt.client.widgets.tableview.events.ImageClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.tableview.events.ImageClickEvent.getType()) == 0) setupImageClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.tableview.events.ImageClickEvent.getType());
    }

    private native void setupImageClickEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({imageClick:$entry(function(){
                        var param = {"record" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.tableview.events.ImageClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.imageClick = $entry(function(){
                   var param = {"record" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.tableview.events.ImageClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
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
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({recordNavigationClick:$entry(function(){
                        var param = {"record" : arguments[0]};
                        var event = @com.smartgwt.client.widgets.tableview.events.RecordNavigationClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.recordNavigationClick = $entry(function(){
                   var param = {"record" : arguments[0]};
                   var event = @com.smartgwt.client.widgets.tableview.events.RecordNavigationClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript). 
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param tableViewProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(TableView tableViewProperties) /*-{
    	var properties = $wnd.isc.addProperties({},tableViewProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
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



}



