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
import com.smartgwt.client.callbacks.*;
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
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * Shows a listing of records with one or more fields from each record, with built-in support for navigation and editing of
 * lists of records. <p/> The TableView provides built-in controls such as {@link
 * com.smartgwt.client.widgets.tableview.TableView#getShowNavigation navigation arrows} and shows fields from the provided
 * records in one of several built-in {@link com.smartgwt.client.types.RecordLayout}s. <p/> NOTE: This widget is intended
 * primarily for creating handset/phone-sized interfaces and does not have an appearance in any skin other than Mobile.
 */
public class TableView extends ListGrid  implements com.smartgwt.client.widgets.tableview.events.HasImageClickHandlers, com.smartgwt.client.widgets.tableview.events.HasRecordNavigationClickHandlers {

    public native static TableView getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("TableView",jsObj);
        } else {
            return instance;
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }



    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc["TableView"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc["TableView"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
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
        this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Ljava/lang/String;Z)(widget.getID(), true);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************


    /**
     * Field to display as part of individual record in "summary" {@link com.smartgwt.client.types.RecordLayout}s.
     *
     * @param dataField . See {@link com.smartgwt.client.docs.String String}. Default value is "data"
     */
    public void setDataField(String dataField) {
        setAttribute("dataField", dataField, true);
    }

    /**
     * Field to display as part of individual record in "summary" {@link com.smartgwt.client.types.RecordLayout}s.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getDataField()  {
        return getAttributeAsString("dataField");
    }


    /**
     * Field to display as part of individual record in all {@link com.smartgwt.client.types.RecordLayout}s  except
     * "titleOnly".
     *
     * @param descriptionField . See {@link com.smartgwt.client.docs.String String}. Default value is "description"
     */
    public void setDescriptionField(String descriptionField) {
        setAttribute("descriptionField", descriptionField, true);
    }

    /**
     * Field to display as part of individual record in all {@link com.smartgwt.client.types.RecordLayout}s  except
     * "titleOnly".
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getDescriptionField()  {
        return getAttributeAsString("descriptionField");
    }


    /**
     * This property allows the developer to specify the icon displayed next to a record. Set
     * <code>record[tableView.iconField]</code> to the URL of the desired icon to display. Only applies if {@link
     * com.smartgwt.client.widgets.tableview.TableView#getShowIconField showIconField} is <code>true</code>.
     *
     * @param iconField . See {@link com.smartgwt.client.docs.String String}. Default value is "icon"
     */
    public void setIconField(String iconField) {
        setAttribute("iconField", iconField, true);
    }

    /**
     * This property allows the developer to specify the icon displayed next to a record. Set
     * <code>record[tableView.iconField]</code> to the URL of the desired icon to display. Only applies if {@link
     * com.smartgwt.client.widgets.tableview.TableView#getShowIconField showIconField} is <code>true</code>.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getIconField()  {
        return getAttributeAsString("iconField");
    }


    /**
     * Field to display as part of individual record in "summary" {@link com.smartgwt.client.types.RecordLayout}s.
     *
     * @param infoField . See {@link com.smartgwt.client.docs.String String}. Default value is "info"
     * @see com.smartgwt.client.types.RecordLayout
     */
    public void setInfoField(String infoField) {
        setAttribute("infoField", infoField, true);
    }

    /**
     * Field to display as part of individual record in "summary" {@link com.smartgwt.client.types.RecordLayout}s.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.types.RecordLayout
     */
    public String getInfoField()  {
        return getAttributeAsString("infoField");
    }


    /**
     * The navigation icon shown next to records when {@link com.smartgwt.client.widgets.tableview.TableView#getShowNavigation
     * showNavigation} is true and {@link com.smartgwt.client.types.NavigationMode} is set to "navIconOny".
     *
     * @param navIcon . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is "[SKINIMG]/iOS/listArrow_button.png"
     */
    public void setNavIcon(String navIcon) {
        setAttribute("navIcon", navIcon, true);
    }

    /**
     * The navigation icon shown next to records when {@link com.smartgwt.client.widgets.tableview.TableView#getShowNavigation
     * showNavigation} is true and {@link com.smartgwt.client.types.NavigationMode} is set to "navIconOny".
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
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
        setAttribute("navigationMode", navigationMode == null ? null : navigationMode.getValue(), true);
    }

    /**
     * Set navigation mode for this TableView.
     *
     * @return NavigationMode
     */
    public NavigationMode getNavigationMode()  {
        return EnumUtil.getEnum(NavigationMode.values(), getAttribute("navigationMode"));
    }


    /**
     * Default style for data field.
     *
     * @param recordDataStyle . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}. Default value is "recordData"
     */
    public void setRecordDataStyle(String recordDataStyle) {
        setAttribute("recordDataStyle", recordDataStyle, true);
    }

    /**
     * Default style for data field.
     *
     * @return . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public String getRecordDataStyle()  {
        return getAttributeAsString("recordDataStyle");
    }


    /**
     * Default style for description.
     *
     * @param recordDescriptionStyle . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}. Default value is "recordDescription"
     */
    public void setRecordDescriptionStyle(String recordDescriptionStyle) {
        setAttribute("recordDescriptionStyle", recordDescriptionStyle, true);
    }

    /**
     * Default style for description.
     *
     * @return . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public String getRecordDescriptionStyle()  {
        return getAttributeAsString("recordDescriptionStyle");
    }


    /**
     * Default style for info field.
     *
     * @param recordInfoStyle . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}. Default value is "recordInfo"
     */
    public void setRecordInfoStyle(String recordInfoStyle) {
        setAttribute("recordInfoStyle", recordInfoStyle, true);
    }

    /**
     * Default style for info field.
     *
     * @return . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
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
        setAttribute("recordLayout", recordLayout == null ? null : recordLayout.getValue(), true);
    }

    /**
     * Sets the arrangement of data fields from the record. <p/> Note that controls supported by the TableView itself, such as
     * navigation icons, are implicitly added to the data fields described in the RecordLayout.  If an {@link
     * com.smartgwt.client.widgets.tableview.TableView#getIconField iconField} has been configured, it too is an implicitly
     * shown field, to the left of the area controlled by RecordLayout.
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
     * @param recordNavigationProperty . See {@link com.smartgwt.client.docs.String String}. Default value is "_navigate"
     */
    public void setRecordNavigationProperty(String recordNavigationProperty) {
        setAttribute("recordNavigationProperty", recordNavigationProperty, true);
    }

    /**
     * Boolean property on each record that controls whether navigation controls are shown for that record. If property is not
     * defined on the record a navigation icon is shown if {@link
     * com.smartgwt.client.widgets.tableview.TableView#getShowNavigation showNavigation} is <code>true</code>.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getRecordNavigationProperty()  {
        return getAttributeAsString("recordNavigationProperty");
    }


    /**
     * Default style for title.
     *
     * @param recordTitleStyle . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}. Default value is "recordTitle"
     */
    public void setRecordTitleStyle(String recordTitleStyle) {
        setAttribute("recordTitleStyle", recordTitleStyle, true);
    }

    /**
     * Default style for title.
     *
     * @return . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
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
        setAttribute("tableMode", tableMode == null ? null : tableMode.getValue(), true);
    }

    /**
     * The display mode of the table.
     *
     * @return TableMode
     */
    public TableMode getTableMode()  {
        return EnumUtil.getEnum(TableMode.values(), getAttribute("tableMode"));
    }


    /**
     * Field to display for an individual record as the main title.
     *
     * @param titleField . See {@link com.smartgwt.client.docs.String String}. Default value is "title"
     */
    public void setTitleField(String titleField) {
        setAttribute("titleField", titleField, true);
    }

    /**
     * Field to display for an individual record as the main title.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getTitleField()  {
        return getAttributeAsString("titleField");
    }


    /**
     * The navigation icon shown next to records when {@link com.smartgwt.client.widgets.tableview.TableView#getShowNavigation
     * showNavigation} is true and {@link com.smartgwt.client.types.NavigationMode} is set to "wholeRecord".
     *
     * @param wholeRecordNavIcon . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is "[SKINIMG]/iOS/listArrow.png"
     */
    public void setWholeRecordNavIcon(String wholeRecordNavIcon) {
        setAttribute("wholeRecordNavIcon", wholeRecordNavIcon, true);
    }

    /**
     * The navigation icon shown next to records when {@link com.smartgwt.client.widgets.tableview.TableView#getShowNavigation
     * showNavigation} is true and {@link com.smartgwt.client.types.NavigationMode} is set to "wholeRecord".
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
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
        var imageClick = $entry(function(){
            var param = {"record" : arguments[0]};

                var event = @com.smartgwt.client.widgets.tableview.events.ImageClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({imageClick:  imageClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.imageClick =  imageClick             ;
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
        var recordNavigationClick = $entry(function(){
            var param = {"record" : arguments[0]};

                var event = @com.smartgwt.client.widgets.tableview.events.RecordNavigationClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({recordNavigationClick:  recordNavigationClick              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.recordNavigationClick =  recordNavigationClick             ;
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



    public LogicalStructureObject setLogicalStructure(TableViewLogicalStructure s) {
        super.setLogicalStructure(s);
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

    public LogicalStructureObject getLogicalStructure() {
        TableViewLogicalStructure s = new TableViewLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

