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
 
package com.smartgwt.client.widgets.grid;


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
 * Component for editing a single record.<br>  RecordEditors are implemented as a subclass of ListGrid, showing no header
 * and a single   row always drawn in the editable state, allowing the user to modify the values at any time.  The {@link
 * com.smartgwt.client.widgets.grid.RecordEditor#getActionButton actionButton} is automatically shown as a way for the user
 * to act   upon the edited values.  <P>  The RecordEditor class exists as a helper class for ListGrids, used to provide 
 * an interface for editing criteria when {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor
 * filterEditor}   is set to true.
 * @see com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor
 * @see com.smartgwt.client.widgets.grid.ListGrid#getFilterEditor
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("RecordEditor")
public class RecordEditor extends ListGrid {

    public static RecordEditor getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new RecordEditor(jsObj);
        } else {
            assert refInstance instanceof RecordEditor;
            return (RecordEditor)refInstance;
        }
    }

    private static final RecordEditor TEST_INSTANCE = new RecordEditor();
    static {
        TEST_INSTANCE.setID("isc_RecordEditor_testInstance");
    }

    @Override
    protected RecordEditor getTestInstance() {
        return TEST_INSTANCE;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RecordEditor.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.RecordEditor.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RecordEditor.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.RecordEditor.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public RecordEditor(){
        scClassName = "RecordEditor";
    }

    public RecordEditor(JavaScriptObject jsObj){
        scClassName = "RecordEditor";
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
     * Properties to apply to the automatically generated {@link com.smartgwt.client.widgets.grid.RecordEditor#getActionButton
     * actionButton}. <P> Note that for a recordEditor being used as a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFilterEditor ListGrid.filterEditor}, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFilterButtonProperties ListGrid.filterButtonProperties} can be used to
     * specify actionButton properties directly at the grid level.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param actionButtonProperties New actionButtonProperties value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public void setActionButtonProperties(Button actionButtonProperties)  throws IllegalStateException {
        if (actionButtonProperties != null) {
            if (actionButtonProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(RecordEditor.class, "setActionButtonProperties", "Button");
            }                                                                       
            actionButtonProperties.setConfigOnly(true);
        }
        JavaScriptObject config = actionButtonProperties == null ? null : actionButtonProperties.getConfig();
        setAttribute("actionButtonProperties", JSOHelper.cleanProperties(config, true), false);
    }

    /**
     * Properties to apply to the automatically generated {@link com.smartgwt.client.widgets.grid.RecordEditor#getActionButton
     * actionButton}. <P> Note that for a recordEditor being used as a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFilterEditor ListGrid.filterEditor}, the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFilterButtonProperties ListGrid.filterButtonProperties} can be used to
     * specify actionButton properties directly at the grid level.
     *
     * @return Current actionButtonProperties value. Default value is null
     */
    public Button getActionButtonProperties()  {
        Button properties = new Button();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("actionButtonProperties"));
        return properties;
    }
    

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the {@link
     * com.smartgwt.client.widgets.grid.RecordEditor#getActionButton actionButton}
     *
     * @param actionButtonStyle New actionButtonStyle value. Default value is "normal"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setActionButtonStyle(String actionButtonStyle)  throws IllegalStateException {
        setAttribute("actionButtonStyle", actionButtonStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getBaseStyle baseStyle} for the {@link
     * com.smartgwt.client.widgets.grid.RecordEditor#getActionButton actionButton}
     *
     * @return Current actionButtonStyle value. Default value is "normal"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getActionButtonStyle()  {
        return getAttributeAsString("actionButtonStyle");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.grid.GridRenderer#getBaseStyle base cell style} for this listGrid. If this property
     * is unset, base style may be derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle
     * ListGrid.normalBaseStyle} or {@link com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle ListGrid.tallBaseStyle}
     * as described in {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.getBaseStyle()}. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @param baseStyle New baseStyle value. Default value is "recordEditorCell"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBaseStyle(String baseStyle)  throws IllegalStateException {
        setAttribute("baseStyle", baseStyle, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.grid.GridRenderer#getBaseStyle base cell style} for this listGrid. If this property
     * is unset, base style may be derived from {@link com.smartgwt.client.widgets.grid.ListGrid#getNormalBaseStyle
     * ListGrid.normalBaseStyle} or {@link com.smartgwt.client.widgets.grid.ListGrid#getTallBaseStyle ListGrid.tallBaseStyle}
     * as described in {@link com.smartgwt.client.widgets.grid.ListGrid#getBaseStyle ListGrid.getBaseStyle()}. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles.
     *
     * @return Current baseStyle value. Default value is "recordEditorCell"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.Button#getIcon Icon} to show on the {@link
     * com.smartgwt.client.widgets.grid.RecordEditor#getActionButton actionButton} if this  component is being used as a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFilterEditor ListGrid.filterEditor}. <P> Note that this {@link
     * com.smartgwt.client.docs.SCImgURL} will be resolved using the {@link
     * com.smartgwt.client.widgets.grid.RecordEditor#getSkinImgDir skinImgDir} defined for the RecordEditor.
     *
     * @param filterImg New filterImg value. Default value is "[SKIN]filter.png"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setFilterImg(String filterImg)  throws IllegalStateException {
        setAttribute("filterImg", filterImg, false);
    }

    /**
     * {@link com.smartgwt.client.widgets.Button#getIcon Icon} to show on the {@link
     * com.smartgwt.client.widgets.grid.RecordEditor#getActionButton actionButton} if this  component is being used as a {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getFilterEditor ListGrid.filterEditor}. <P> Note that this {@link
     * com.smartgwt.client.docs.SCImgURL} will be resolved using the {@link
     * com.smartgwt.client.widgets.grid.RecordEditor#getSkinImgDir skinImgDir} defined for the RecordEditor.
     *
     * @return Current filterImg value. Default value is "[SKIN]filter.png"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getFilterImg()  {
        return getAttributeAsString("filterImg");
    }
    

    /**
     * Where do 'skin' images (those provided with the class) live?
     *
     * @param skinImgDir New skinImgDir value. Default value is "images/RecordEditor/"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setSkinImgDir(String skinImgDir)  throws IllegalStateException {
        setAttribute("skinImgDir", skinImgDir, false);
    }

    /**
     * Where do 'skin' images (those provided with the class) live?
     *
     * @return Current skinImgDir value. Default value is "images/RecordEditor/"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }
    

    // ********************* Methods ***********************
	/**
     * Fired when the user clicks the {@link com.smartgwt.client.widgets.grid.RecordEditor#getActionButton actionButton} for
     * this RecordEditor. May also be triggered from other user interaction with edit values (for example filter-editor change
     * - see {@link com.smartgwt.client.widgets.grid.ListGrid#getFilterOnKeypress ListGrid.filterOnKeypress}). <P> This is the
     * method which initiates a filter in a listGrid {@link com.smartgwt.client.widgets.grid.ListGrid#getShowFilterEditor
     * filter editor}. Note that for custom filtering behavior, developers can use the {@link
     * com.smartgwt.client.widgets.grid.ListGrid#addFilterEditorSubmitHandler ListGrid.filterEditorSubmit()} notification
     * method rather than overriding this method directly.
     */
    public native void performAction() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "performAction", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.performAction();
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
     * @param recordEditorProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(RecordEditor recordEditorProperties) /*-{
        if (recordEditorProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(RecordEditor.@java.lang.Object::getClass()(), "setDefaultProperties", recordEditorProperties.@java.lang.Object::getClass()());
        }
        recordEditorProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = recordEditorProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.RecordEditor.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * See {@link #getActionCanvas}.
     * @deprecated in favor of {@link #getActionCanvas}
     */
    @Deprecated
    public Button getActionButton() throws IllegalStateException {
        errorIfNotCreated("actionButton");
        StatefulCanvas button = (StatefulCanvas)StatefulCanvas.
            getByJSObject(getAttributeAsJavaScriptObject("actionButton"));
        Button.assertIsButton(button, "Instead of getActionButton(), which has been " +
            "deprecated, try getActionCanvas(), which returns a StatefulCanvas.");
        return (Button)button;
    }

    /**
     * Automatically created Button auto-child shown at the edge of the recordEditor. For a
     * recordEditor acting as a 
     * {@link com.smartgwt.client.widgets.grid.ListGrid#getFilterEditor ListGrid.filterEditor},
     * this button will show the 
     * {@link com.smartgwt.client.widgets.grid.RecordEditor#getFilterImg filterImg} as an
     * {@link com.smartgwt.client.widgets.Button#getIcon Button.icon} by default. <P> Clicking
     * this button will call 
     * {@link com.smartgwt.client.widgets.grid.RecordEditor#performAction performAction()}
     * on the editor. <P> May be customized using
     * the standard {@link com.smartgwt.client.types.AutoChild} pattern, by overriding 
     * {@link com.smartgwt.client.widgets.grid.RecordEditor#getActionButtonProperties actionButtonProperties}.
     * <p>
     * This component is an AutoChild named "actionButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current actionButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public StatefulCanvas getActionCanvas() throws IllegalStateException {
        errorIfNotCreated("actionButton");
        return (StatefulCanvas)StatefulCanvas.
            getByJSObject(getAttributeAsJavaScriptObject("actionButton"));
    }
    

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(RecordEditorLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.actionButtonStyle = getAttributeAsString("actionButtonStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RecordEditor.actionButtonStyle:" + t.getMessage() + "\n";
        }
        try {
            s.baseStyle = getAttributeAsString("baseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RecordEditor.baseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.filterImg = getAttributeAsString("filterImg");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RecordEditor.filterImg:" + t.getMessage() + "\n";
        }
        try {
            s.skinImgDir = getAttributeAsString("skinImgDir");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RecordEditor.skinImgDir:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        RecordEditorLogicalStructure s = new RecordEditorLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
