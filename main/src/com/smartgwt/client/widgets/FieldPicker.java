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
 
package com.smartgwt.client.widgets;


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
 * FieldPicker provides a configuration dialog that displays, side-by-side, the available and currently-displayed fields of
 * a {@link com.smartgwt.client.widgets.DataBoundComponent}. It allows for easy customization  of the order in which the
 * fields of a {@link com.smartgwt.client.widgets.DataBoundComponent} are displayed, and of which are visible.  If so
 * configured, it also allows for convenient launching of the HiliteEditor, FormulaBuilder, and SummaryBuilder.  A
 * FieldPicker instance runs in its own window,  a {@link com.smartgwt.client.widgets.FieldPickerWindow}
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("FieldPicker")
public class FieldPicker extends VLayout {

    public static FieldPicker getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new FieldPicker(jsObj);
        } else {
            assert refInstance instanceof FieldPicker;
            return (FieldPicker)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(FieldPicker.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.FieldPicker.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(FieldPicker.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.FieldPicker.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public FieldPicker(){
        scClassName = "FieldPicker";
    }

    public FieldPicker(JavaScriptObject jsObj){
        scClassName = "FieldPicker";
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
     * The title displayed for the Add Custom Fields Button
     *
     * @param addCustomFieldsButtonTitle New addCustomFieldsButtonTitle value. Default value is "Add Custom Fields"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setAddCustomFieldsButtonTitle(String addCustomFieldsButtonTitle)  throws IllegalStateException {
        return (FieldPicker)setAttribute("addCustomFieldsButtonTitle", addCustomFieldsButtonTitle, false);
    }

    /**
     * The title displayed for the Add Custom Fields Button
     *
     * @return Current addCustomFieldsButtonTitle value. Default value is "Add Custom Fields"
     */
    public String getAddCustomFieldsButtonTitle()  {
        return getAttributeAsString("addCustomFieldsButtonTitle");
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.grid.ListGrid ListGrid} showing the list of available fields.
     * <p>
     * This component is an AutoChild named "availableFieldsGrid".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current availableFieldsGrid value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ListGrid getAvailableFieldsGrid() throws IllegalStateException {
        errorIfNotCreated("availableFieldsGrid");
        return (ListGrid)ListGrid.getByJSObject(getAttributeAsJavaScriptObject("availableFieldsGrid"));
    }
    

    /**
     * Provides a set of controls to appear as  {@link com.smartgwt.client.widgets.layout.SectionHeader#getControls section
     * header controls} above the available fields grid.
     *
     * @param availableFieldsHeaderControls New availableFieldsHeaderControls value. Default value is null
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setAvailableFieldsHeaderControls(Canvas... availableFieldsHeaderControls)  throws IllegalStateException {
        return (FieldPicker)setAttribute("availableFieldsHeaderControls", availableFieldsHeaderControls, false);
    }

    /**
     * Provides a set of controls to appear as  {@link com.smartgwt.client.widgets.layout.SectionHeader#getControls section
     * header controls} above the available fields grid.
     *
     * @return Current availableFieldsHeaderControls value. Default value is null
     */
    public Canvas[] getAvailableFieldsHeaderControls()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCanvas(getAttributeAsJavaScriptObject("availableFieldsHeaderControls"));
    }
    

    /**
     * 
     *
     * @param availableFieldsTitle New availableFieldsTitle value. Default value is "Available Fields"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setAvailableFieldsTitle(String availableFieldsTitle)  throws IllegalStateException {
        return (FieldPicker)setAttribute("availableFieldsTitle", availableFieldsTitle, false);
    }

    /**
     * 
     *
     * @return Current availableFieldsTitle value. Default value is "Available Fields"
     */
    public String getAvailableFieldsTitle()  {
        return getAttributeAsString("availableFieldsTitle");
    }
    

    /**
     * The title displayed for the title property of the available fields
     *
     * @param availableTitleTitle New availableTitleTitle value. Default value is "Name"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setAvailableTitleTitle(String availableTitleTitle)  throws IllegalStateException {
        return (FieldPicker)setAttribute("availableTitleTitle", availableTitleTitle, false);
    }

    /**
     * The title displayed for the title property of the available fields
     *
     * @return Current availableTitleTitle value. Default value is "Name"
     */
    public String getAvailableTitleTitle()  {
        return getAttributeAsString("availableTitleTitle");
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.layout.HLayout horizontal layout} used to show the  {@link
     * com.smartgwt.client.widgets.FieldPicker#getSaveAndExitButton Save} and {@link
     * com.smartgwt.client.widgets.FieldPicker#getCancelChangesButton Cancel}  buttons.
     * <p>
     * This component is an AutoChild named "buttonLayout".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current buttonLayout value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public HLayout getButtonLayout() throws IllegalStateException {
        errorIfNotCreated("buttonLayout");
        return (HLayout)HLayout.getByJSObject(getAttributeAsJavaScriptObject("buttonLayout"));
    }
    

    /**
     * The title shown on the Cancel button
     *
     * @param cancelButtonTitle New cancelButtonTitle value. Default value is "Cancel"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        return (FieldPicker)setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * The title shown on the Cancel button
     *
     * @return Current cancelButtonTitle value. Default value is "Cancel"
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * An AutoChild {@link com.smartgwt.client.widgets.IButton button} that saves the current field-set and exits the  Field
     * Picker.
     * <p>
     * This component is an AutoChild named "cancelChangesButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current cancelChangesButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCancelChangesButton() throws IllegalStateException {
        errorIfNotCreated("cancelChangesButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("cancelChangesButton"));
    }
    

    /**
     * Whether the current fields' filter row allows the sample value column to be filtered.
     *
     * @param canFilterSampleValue New canFilterSampleValue value. Default value is false
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.FieldPicker#setSampleValueTitle
     * @see com.smartgwt.client.widgets.FieldPicker#setSampleRecord
     */
    public FieldPicker setCanFilterSampleValue(Boolean canFilterSampleValue)  throws IllegalStateException {
        return (FieldPicker)setAttribute("canFilterSampleValue", canFilterSampleValue, false);
    }

    /**
     * Whether the current fields' filter row allows the sample value column to be filtered.
     *
     * @return Current canFilterSampleValue value. Default value is false
     * @see com.smartgwt.client.widgets.FieldPicker#getSampleValueTitle
     * @see com.smartgwt.client.widgets.FieldPicker#getSampleRecord
     */
    public Boolean getCanFilterSampleValue()  {
        Boolean result = getAttributeAsBoolean("canFilterSampleValue");
        return result == null ? false : result;
    }
    

    /**
     * 
     *
     * @param confirmText New confirmText value. Default value is "Must save pending changes to proceed. OK?"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setConfirmText(String confirmText)  throws IllegalStateException {
        return (FieldPicker)setAttribute("confirmText", confirmText, false);
    }

    /**
     * 
     *
     * @return Current confirmText value. Default value is "Must save pending changes to proceed. OK?"
     */
    public String getConfirmText()  {
        return getAttributeAsString("confirmText");
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.grid.ListGrid ListGrid} showing the list of currently selected fields.
     * <p>
     * This component is an AutoChild named "currentFieldsGrid".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current currentFieldsGrid value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ListGrid getCurrentFieldsGrid() throws IllegalStateException {
        errorIfNotCreated("currentFieldsGrid");
        return (ListGrid)ListGrid.getByJSObject(getAttributeAsJavaScriptObject("currentFieldsGrid"));
    }
    

    /**
     * 
     *
     * @param currentFieldsTitle New currentFieldsTitle value. Default value is "Visible Fields"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setCurrentFieldsTitle(String currentFieldsTitle)  throws IllegalStateException {
        return (FieldPicker)setAttribute("currentFieldsTitle", currentFieldsTitle, false);
    }

    /**
     * 
     *
     * @return Current currentFieldsTitle value. Default value is "Visible Fields"
     */
    public String getCurrentFieldsTitle()  {
        return getAttributeAsString("currentFieldsTitle");
    }
    

    /**
     * The title displayed for the title property of the current fields
     *
     * @param currentTitleTitle New currentTitleTitle value. Default value is "Field Title"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setCurrentTitleTitle(String currentTitleTitle)  throws IllegalStateException {
        return (FieldPicker)setAttribute("currentTitleTitle", currentTitleTitle, false);
    }

    /**
     * The title displayed for the title property of the current fields
     *
     * @return Current currentTitleTitle value. Default value is "Field Title"
     */
    public String getCurrentTitleTitle()  {
        return getAttributeAsString("currentTitleTitle");
    }
    

    /**
     * The component whose fields should be edited. <P> Note that if {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getUseAllDataSourceFields DataBoundComponent.useAllDataSourceFields} is
     * set on the component, it will be cleared when the FieldPicker applies the requested ordering since that setting imposes
     * a fixed ordering on the fields.
     *
     * @param dataBoundComponent New dataBoundComponent value. Default value is null
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setDataBoundComponent(Canvas dataBoundComponent)  throws IllegalStateException {
        return (FieldPicker)setAttribute("dataBoundComponent", dataBoundComponent == null ? null : dataBoundComponent.getOrCreateJsObj(), false);
    }

    /**
     * The component whose fields should be edited. <P> Note that if {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getUseAllDataSourceFields DataBoundComponent.useAllDataSourceFields} is
     * set on the component, it will be cleared when the FieldPicker applies the requested ordering since that setting imposes
     * a fixed ordering on the fields.
     *
     * @return Current dataBoundComponent value. Default value is null
     */
    public Canvas getDataBoundComponent()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("dataBoundComponent"));
    }
    

    /**
     * An optional DataSource that is used to create a disposable {@link
     * com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent dataBoundComponent} if none is provided. Has no effect if
     * a {@link com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent dataBoundComponent} is specified.
     *
     * @param dataSource New dataSource value. Default value is null
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setDataSource(DataSource dataSource)  throws IllegalStateException {
        return (FieldPicker)setAttribute("dataSource", dataSource == null ? null : dataSource.getOrCreateJsObj(), false);
    }

    /**
     * An optional DataSource that is used to create a disposable {@link
     * com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent dataBoundComponent} if none is provided. Has no effect if
     * a {@link com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent dataBoundComponent} is specified.
     *
     * @return Current dataSource value. Default value is null
     */
    public DataSource getDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }
    

    /**
     * The hint shown when editing a field with no title defined.
     *
     * @param emptyTitleHint New emptyTitleHint value. Default value is "[No title specified]"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setEmptyTitleHint(String emptyTitleHint)  throws IllegalStateException {
        return (FieldPicker)setAttribute("emptyTitleHint", emptyTitleHint, false);
    }

    /**
     * The hint shown when editing a field with no title defined.
     *
     * @return Current emptyTitleHint value. Default value is "[No title specified]"
     */
    public String getEmptyTitleHint()  {
        return getAttributeAsString("emptyTitleHint");
    }
    

    /**
     * 
     *
     * @param hilitesText New hilitesText value. Default value is "Highlights..."
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setHilitesText(String hilitesText)  throws IllegalStateException {
        return (FieldPicker)setAttribute("hilitesText", hilitesText, false);
    }

    /**
     * 
     *
     * @return Current hilitesText value. Default value is "Highlights..."
     */
    public String getHilitesText()  {
        return getAttributeAsString("hilitesText");
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.Label label} displaying the text assigned as the FieldPicker's {@link
     * com.smartgwt.client.widgets.FieldPicker#getInstructions instructions}.  Shown across the top of the widget.
     * <p>
     * This component is an AutoChild named "instructionLabel".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current instructionLabel value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Label getInstructionLabel() throws IllegalStateException {
        errorIfNotCreated("instructionLabel");
        return (Label)Label.getByJSObject(getAttributeAsJavaScriptObject("instructionLabel"));
    }
    

    /**
     * 
     *
     * @param instructions New instructions value. Default value is "Drag and drop or use arrows to move fields.  Drag reorder to change field order."
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public FieldPicker setInstructions(String instructions)  throws IllegalStateException {
        return (FieldPicker)setAttribute("instructions", instructions, false);
    }

    /**
     * 
     *
     * @return Current instructions value. Default value is "Drag and drop or use arrows to move fields.  Drag reorder to change field order."
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getInstructions()  {
        return getAttributeAsString("instructions");
    }
    

    /**
     * The title shown on the 'Visible Fields' grid's context menu item, whose click handler puts the selected item back in the
     * 'Available Fields' collection.
     *
     * @param removeItemTitle New removeItemTitle value. Default value is "Remove"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setRemoveItemTitle(String removeItemTitle)  throws IllegalStateException {
        return (FieldPicker)setAttribute("removeItemTitle", removeItemTitle, false);
    }

    /**
     * The title shown on the 'Visible Fields' grid's context menu item, whose click handler puts the selected item back in the
     * 'Available Fields' collection.
     *
     * @return Current removeItemTitle value. Default value is "Remove"
     */
    public String getRemoveItemTitle()  {
        return getAttributeAsString("removeItemTitle");
    }
    

    /**
     * 
     *
     * @param removeText New removeText value. Default value is "You are about to remove the field. Are you sure?"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setRemoveText(String removeText)  throws IllegalStateException {
        return (FieldPicker)setAttribute("removeText", removeText, false);
    }

    /**
     * 
     *
     * @return Current removeText value. Default value is "You are about to remove the field. Are you sure?"
     */
    public String getRemoveText()  {
        return getAttributeAsString("removeText");
    }
    

    /**
     * If a <code>sampleRecord</code> is provided, the FieldPicker will show a second column in the Current Fields dialog
     * showing the cell value that will appear for that field given the provided sample record. <br> A value of "first" means
     * the first record.  If the underlying {@link com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent
     * dataBoundComponent} is a {@link com.smartgwt.client.widgets.tree.TreeGrid}, you can specify "firstOpenLeaf" to use the
     * first open leaf as the sampleRecord (this is often desirable in trees where the first record may be a folder that's used
     * for organizational purposes only and hence would have no actual data for columns other than the tree column).
     *
     * @param sampleRecord New sampleRecord value. Default value is "first"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setSampleRecord(Record sampleRecord)  throws IllegalStateException {
        return (FieldPicker)setAttribute("sampleRecord", sampleRecord == null ? null : sampleRecord.getJsObj(), false);
    }

    /**
     * If a <code>sampleRecord</code> is provided, the FieldPicker will show a second column in the Current Fields dialog
     * showing the cell value that will appear for that field given the provided sample record. <br> A value of "first" means
     * the first record.  If the underlying {@link com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent
     * dataBoundComponent} is a {@link com.smartgwt.client.widgets.tree.TreeGrid}, you can specify "firstOpenLeaf" to use the
     * first open leaf as the sampleRecord (this is often desirable in trees where the first record may be a folder that's used
     * for organizational purposes only and hence would have no actual data for columns other than the tree column).
     *
     * @return Current sampleRecord value. Default value is "first"
     */
    public Record getSampleRecord()  {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject("sampleRecord"));
    }

    /**
     * If a <code>sampleRecord</code> is provided, the FieldPicker will show a second column in the Current Fields dialog
     * showing the cell value that will appear for that field given the provided sample record. <br> A value of "first" means
     * the first record.  If the underlying {@link com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent
     * dataBoundComponent} is a {@link com.smartgwt.client.widgets.tree.TreeGrid}, you can specify "firstOpenLeaf" to use the
     * first open leaf as the sampleRecord (this is often desirable in trees where the first record may be a folder that's used
     * for organizational purposes only and hence would have no actual data for columns other than the tree column).
     *
     * @param sampleRecord New sampleRecord value. Default value is "first"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setSampleRecord(DefaultSampleRecord sampleRecord)  throws IllegalStateException {
        return (FieldPicker)setAttribute("sampleRecord", sampleRecord == null ? null : sampleRecord.getValue(), false);
    }

    /**
     * If a <code>sampleRecord</code> is provided, the FieldPicker will show a second column in the Current Fields dialog
     * showing the cell value that will appear for that field given the provided sample record. <br> A value of "first" means
     * the first record.  If the underlying {@link com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent
     * dataBoundComponent} is a {@link com.smartgwt.client.widgets.tree.TreeGrid}, you can specify "firstOpenLeaf" to use the
     * first open leaf as the sampleRecord (this is often desirable in trees where the first record may be a folder that's used
     * for organizational purposes only and hence would have no actual data for columns other than the tree column).
     *
     * @return Current sampleRecord value. Default value is "first"
     */
    public DefaultSampleRecord getSampleRecordAsDefaultSampleRecord()  {
        return EnumUtil.getEnum(DefaultSampleRecord.values(), getAttribute("sampleRecord"));
    }
    

    /**
     * The title displayed for the sample value property of the current fields
     *
     * @param sampleValueTitle New sampleValueTitle value. Default value is "Sample Value"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setSampleValueTitle(String sampleValueTitle)  throws IllegalStateException {
        return (FieldPicker)setAttribute("sampleValueTitle", sampleValueTitle, false);
    }

    /**
     * The title displayed for the sample value property of the current fields
     *
     * @return Current sampleValueTitle value. Default value is "Sample Value"
     */
    public String getSampleValueTitle()  {
        return getAttributeAsString("sampleValueTitle");
    }
    

    /**
     * An AutoChild {@link com.smartgwt.client.widgets.IButton button} that saves the current field-set and exits the  Field
     * Picker.
     * <p>
     * This component is an AutoChild named "saveAndExitButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current saveAndExitButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getSaveAndExitButton() throws IllegalStateException {
        errorIfNotCreated("saveAndExitButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("saveAndExitButton"));
    }
    

    /**
     * The title shown on the Save and Exit button
     *
     * @param saveAndExitButtonTitle New saveAndExitButtonTitle value. Default value is "Apply"
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setSaveAndExitButtonTitle(String saveAndExitButtonTitle)  throws IllegalStateException {
        return (FieldPicker)setAttribute("saveAndExitButtonTitle", saveAndExitButtonTitle, false);
    }

    /**
     * The title shown on the Save and Exit button
     *
     * @return Current saveAndExitButtonTitle value. Default value is "Apply"
     */
    public String getSaveAndExitButtonTitle()  {
        return getAttributeAsString("saveAndExitButtonTitle");
    }
    

    /**
     * When set to false, hides the right-most set of buttons, used for re-ordering fields in the Visible Fields list.
     *
     * @param showFieldOrderButtons New showFieldOrderButtons value. Default value is true
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setShowFieldOrderButtons(boolean showFieldOrderButtons)  throws IllegalStateException {
        return (FieldPicker)setAttribute("showFieldOrderButtons", showFieldOrderButtons, false);
    }

    /**
     * When set to false, hides the right-most set of buttons, used for re-ordering fields in the Visible Fields list.
     *
     * @return Current showFieldOrderButtons value. Default value is true
     */
    public boolean getShowFieldOrderButtons()  {
        Boolean result = getAttributeAsBoolean("showFieldOrderButtons");
        return result == null ? true : result;
    }
    

    /**
     * Shows a "Highlights..." button that shows an interface for editing hilites in the attached DataBoundComponent.
     *
     * @param showHilitesButton New showHilitesButton value. Default value is true
     * @return {@link com.smartgwt.client.widgets.FieldPicker FieldPicker} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public FieldPicker setShowHilitesButton(boolean showHilitesButton)  throws IllegalStateException {
        return (FieldPicker)setAttribute("showHilitesButton", showHilitesButton, false);
    }

    /**
     * Shows a "Highlights..." button that shows an interface for editing hilites in the attached DataBoundComponent.
     *
     * @return Current showHilitesButton value. Default value is true
     */
    public boolean getShowHilitesButton()  {
        Boolean result = getAttributeAsBoolean("showHilitesButton");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Provides a new set of available fields.
     * @param newFields 
     */
    public native void setAvailableFields(DataSourceField... newFields) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setAvailableFields", "DataSourceField...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setAvailableFields(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(newFields));
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
     * @param fieldPickerProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(FieldPicker fieldPickerProperties) /*-{
        if (fieldPickerProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(FieldPicker.@java.lang.Object::getClass()(), "setDefaultProperties", fieldPickerProperties.@java.lang.Object::getClass()());
        }
        fieldPickerProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = fieldPickerProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.FieldPicker.addProperties(properties);
    }-*/;

    // ***********************************************************


    /**
     * This method is called during rendering for all events in the visible range - those which
     * would be rendered by default.  The customizer should return false to prevent the passed 
     * event from appearing in the passed view.
     * 
     * @param customizer the customizer to execute.
     */
    public native void setCallbackCustomizer(FieldPickerCallbackCustomizer customizer) /*-{
        var self;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            self = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }

        self.callback = $debox($entry(function(fields, hilites) {
            var fieldsJ = @com.smartgwt.client.util.ConvertTo::arrayOfListGridField(Lcom/google/gwt/core/client/JavaScriptObject;)(fields);
            var hilitesJ = @com.smartgwt.client.util.ConvertTo::arrayOfHilite(Lcom/google/gwt/core/client/JavaScriptObject;)(hilites);

            customizer.@com.smartgwt.client.widgets.grid.FieldPickerCallbackCustomizer::callback([Lcom/smartgwt/client/widgets/grid/ListGridField;[Lcom/smartgwt/client/data/Hilite;)(fieldsJ, hilitesJ);
            return;
        }));
    }-*/;


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(FieldPickerLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.addCustomFieldsButtonTitle = getAttributeAsString("addCustomFieldsButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.addCustomFieldsButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.availableFieldsHeaderControls = getAvailableFieldsHeaderControls();
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.availableFieldsHeaderControlsArray:" + t.getMessage() + "\n";
        }
        try {
            s.availableFieldsTitle = getAttributeAsString("availableFieldsTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.availableFieldsTitle:" + t.getMessage() + "\n";
        }
        try {
            s.availableTitleTitle = getAttributeAsString("availableTitleTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.availableTitleTitle:" + t.getMessage() + "\n";
        }
        try {
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.cancelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.canFilterSampleValue = getAttributeAsString("canFilterSampleValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.canFilterSampleValue:" + t.getMessage() + "\n";
        }
        try {
            s.confirmText = getAttributeAsString("confirmText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.confirmText:" + t.getMessage() + "\n";
        }
        try {
            s.currentFieldsTitle = getAttributeAsString("currentFieldsTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.currentFieldsTitle:" + t.getMessage() + "\n";
        }
        try {
            s.currentTitleTitle = getAttributeAsString("currentTitleTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.currentTitleTitle:" + t.getMessage() + "\n";
        }
        try {
            s.dataBoundComponent = getDataBoundComponent();
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.dataBoundComponent:" + t.getMessage() + "\n";
        }
        try {
            s.dataSource = getDataSource();
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.dataSource:" + t.getMessage() + "\n";
        }
        try {
            s.emptyTitleHint = getAttributeAsString("emptyTitleHint");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.emptyTitleHint:" + t.getMessage() + "\n";
        }
        try {
            s.hilitesText = getAttributeAsString("hilitesText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.hilitesText:" + t.getMessage() + "\n";
        }
        try {
            s.instructions = getAttributeAsString("instructions");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.instructions:" + t.getMessage() + "\n";
        }
        try {
            s.removeItemTitle = getAttributeAsString("removeItemTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.removeItemTitle:" + t.getMessage() + "\n";
        }
        try {
            s.removeText = getAttributeAsString("removeText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.removeText:" + t.getMessage() + "\n";
        }
        try {
            s.sampleRecordAsRecord = getSampleRecord();
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.sampleRecordAsRecord:" + t.getMessage() + "\n";
        }
        try {
            s.sampleRecordAsString = getAttributeAsString("sampleRecord");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.sampleRecordAsString:" + t.getMessage() + "\n";
        }
        try {
            s.sampleValueTitle = getAttributeAsString("sampleValueTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.sampleValueTitle:" + t.getMessage() + "\n";
        }
        try {
            s.saveAndExitButtonTitle = getAttributeAsString("saveAndExitButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.saveAndExitButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.showFieldOrderButtons = getAttributeAsString("showFieldOrderButtons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.showFieldOrderButtons:" + t.getMessage() + "\n";
        }
        try {
            s.showHilitesButton = getAttributeAsString("showHilitesButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "FieldPicker.showHilitesButton:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        FieldPickerLogicalStructure s = new FieldPickerLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
