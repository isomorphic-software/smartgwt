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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
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
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.FieldPicker.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.FieldPicker.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
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
     * @param addCustomFieldsButtonTitle  Default value is "Add Custom Fields"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAddCustomFieldsButtonTitle(String addCustomFieldsButtonTitle)  throws IllegalStateException {
        setAttribute("addCustomFieldsButtonTitle", addCustomFieldsButtonTitle, false);
    }

    /**
     * The title displayed for the Add Custom Fields Button
     *
     * @return String
     */
    public String getAddCustomFieldsButtonTitle()  {
        return getAttributeAsString("addCustomFieldsButtonTitle");
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.grid.ListGrid ListGrid} showing the list of available fields.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ListGrid
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
     * @param availableFieldsHeaderControls  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAvailableFieldsHeaderControls(Canvas... availableFieldsHeaderControls)  throws IllegalStateException {
        setAttribute("availableFieldsHeaderControls", availableFieldsHeaderControls, false);
    }

    /**
     * Provides a set of controls to appear as  {@link com.smartgwt.client.widgets.layout.SectionHeader#getControls section
     * header controls} above the available fields grid.
     *
     * @return Canvas...
     */
    public Canvas[] getAvailableFieldsHeaderControls()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfCanvas(getAttributeAsJavaScriptObject("availableFieldsHeaderControls"));
    }
    

    /**
     * 
     *
     * @param availableFieldsTitle  Default value is "Available Fields"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAvailableFieldsTitle(String availableFieldsTitle)  throws IllegalStateException {
        setAttribute("availableFieldsTitle", availableFieldsTitle, false);
    }

    /**
     * 
     *
     * @return String
     */
    public String getAvailableFieldsTitle()  {
        return getAttributeAsString("availableFieldsTitle");
    }
    

    /**
     * The title displayed for the title property of the available fields
     *
     * @param availableTitleTitle  Default value is "Name"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAvailableTitleTitle(String availableTitleTitle)  throws IllegalStateException {
        setAttribute("availableTitleTitle", availableTitleTitle, false);
    }

    /**
     * The title displayed for the title property of the available fields
     *
     * @return String
     */
    public String getAvailableTitleTitle()  {
        return getAttributeAsString("availableTitleTitle");
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.layout.HLayout horizontal layout} used to show the  {@link
     * com.smartgwt.client.widgets.FieldPicker#getSaveAndExitButton Save} and {@link
     * com.smartgwt.client.widgets.FieldPicker#getCancelChangesButton Cancel}  buttons.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return HLayout
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public HLayout getButtonLayout() throws IllegalStateException {
        errorIfNotCreated("buttonLayout");
        return (HLayout)HLayout.getByJSObject(getAttributeAsJavaScriptObject("buttonLayout"));
    }
    

    /**
     * The title shown on the Cancel button
     *
     * @param cancelButtonTitle  Default value is "Cancel"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * The title shown on the Cancel button
     *
     * @return String
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * An AutoChild {@link com.smartgwt.client.widgets.IButton button} that saves the current field-set and exits the  Field
     * Picker.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCancelChangesButton() throws IllegalStateException {
        errorIfNotCreated("cancelChangesButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("cancelChangesButton"));
    }
    

    /**
     * 
     *
     * @param confirmText  Default value is "Must save pending changes to proceed. OK?"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setConfirmText(String confirmText)  throws IllegalStateException {
        setAttribute("confirmText", confirmText, false);
    }

    /**
     * 
     *
     * @return String
     */
    public String getConfirmText()  {
        return getAttributeAsString("confirmText");
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.grid.ListGrid ListGrid} showing the list of currently selected fields.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ListGrid
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ListGrid getCurrentFieldsGrid() throws IllegalStateException {
        errorIfNotCreated("currentFieldsGrid");
        return (ListGrid)ListGrid.getByJSObject(getAttributeAsJavaScriptObject("currentFieldsGrid"));
    }
    

    /**
     * 
     *
     * @param currentFieldsTitle  Default value is "Visible Fields"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCurrentFieldsTitle(String currentFieldsTitle)  throws IllegalStateException {
        setAttribute("currentFieldsTitle", currentFieldsTitle, false);
    }

    /**
     * 
     *
     * @return String
     */
    public String getCurrentFieldsTitle()  {
        return getAttributeAsString("currentFieldsTitle");
    }
    

    /**
     * The title displayed for the title property of the current fields
     *
     * @param currentTitleTitle  Default value is "Field Title"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCurrentTitleTitle(String currentTitleTitle)  throws IllegalStateException {
        setAttribute("currentTitleTitle", currentTitleTitle, false);
    }

    /**
     * The title displayed for the title property of the current fields
     *
     * @return String
     */
    public String getCurrentTitleTitle()  {
        return getAttributeAsString("currentTitleTitle");
    }
    

    /**
     * The component whose fields should be edited.
     *
     * @param dataBoundComponent  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataBoundComponent(Canvas dataBoundComponent)  throws IllegalStateException {
        setAttribute("dataBoundComponent", dataBoundComponent == null ? null : dataBoundComponent.getOrCreateJsObj(), false);
    }

    /**
     * The component whose fields should be edited.
     *
     * @return Canvas
     */
    public Canvas getDataBoundComponent()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("dataBoundComponent"));
    }
    

    /**
     * An optional DataSource that is used to create a disposable {@link
     * com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent dataBoundComponent} if none is provided. Has no effect if
     * a {@link com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent dataBoundComponent} is specified.
     *
     * @param dataSource  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDataSource(DataSource dataSource)  throws IllegalStateException {
        setAttribute("dataSource", dataSource == null ? null : dataSource.getOrCreateJsObj(), false);
    }

    /**
     * An optional DataSource that is used to create a disposable {@link
     * com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent dataBoundComponent} if none is provided. Has no effect if
     * a {@link com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent dataBoundComponent} is specified.
     *
     * @return DataSource
     */
    public DataSource getDataSource()  {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }
    

    /**
     * The hint shown when editing a field with no title defined.
     *
     * @param emptyTitleHint  Default value is "[No title specified]"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEmptyTitleHint(String emptyTitleHint)  throws IllegalStateException {
        setAttribute("emptyTitleHint", emptyTitleHint, false);
    }

    /**
     * The hint shown when editing a field with no title defined.
     *
     * @return String
     */
    public String getEmptyTitleHint()  {
        return getAttributeAsString("emptyTitleHint");
    }
    

    /**
     * 
     *
     * @param hilitesText  Default value is "Highlights..."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHilitesText(String hilitesText)  throws IllegalStateException {
        setAttribute("hilitesText", hilitesText, false);
    }

    /**
     * 
     *
     * @return String
     */
    public String getHilitesText()  {
        return getAttributeAsString("hilitesText");
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.Label label} displaying the text assigned as the FieldPicker's {@link
     * com.smartgwt.client.widgets.FieldPicker#getInstructions instructions}.  Shown across the top of the widget.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Label
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Label getInstructionLabel() throws IllegalStateException {
        errorIfNotCreated("instructionLabel");
        return (Label)Label.getByJSObject(getAttributeAsJavaScriptObject("instructionLabel"));
    }
    

    /**
     * 
     *
     * @param instructions  Default value is "Drag and drop or use arrows to move fields.  Drag reorder to change field order."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInstructions(String instructions)  throws IllegalStateException {
        setAttribute("instructions", instructions, false);
    }

    /**
     * 
     *
     * @return String
     */
    public String getInstructions()  {
        return getAttributeAsString("instructions");
    }
    

    /**
     * The title shown on the 'Visible Fields' grid's context menu item, whose click handler puts the selected item back in the
     * 'Available Fields' collection.
     *
     * @param removeItemTitle  Default value is "Remove"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRemoveItemTitle(String removeItemTitle)  throws IllegalStateException {
        setAttribute("removeItemTitle", removeItemTitle, false);
    }

    /**
     * The title shown on the 'Visible Fields' grid's context menu item, whose click handler puts the selected item back in the
     * 'Available Fields' collection.
     *
     * @return String
     */
    public String getRemoveItemTitle()  {
        return getAttributeAsString("removeItemTitle");
    }
    

    /**
     * 
     *
     * @param removeText  Default value is "You are about to remove the field. Are you sure?"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRemoveText(String removeText)  throws IllegalStateException {
        setAttribute("removeText", removeText, false);
    }

    /**
     * 
     *
     * @return String
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
     * @param sampleRecord  Default value is "first"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSampleRecord(Record sampleRecord)  throws IllegalStateException {
        setAttribute("sampleRecord", sampleRecord.getJsObj(), false);
    }

    /**
     * If a <code>sampleRecord</code> is provided, the FieldPicker will show a second column in the Current Fields dialog
     * showing the cell value that will appear for that field given the provided sample record. <br> A value of "first" means
     * the first record.  If the underlying {@link com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent
     * dataBoundComponent} is a {@link com.smartgwt.client.widgets.tree.TreeGrid}, you can specify "firstOpenLeaf" to use the
     * first open leaf as the sampleRecord (this is often desirable in trees where the first record may be a folder that's used
     * for organizational purposes only and hence would have no actual data for columns other than the tree column).
     *
     * @return Record
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
     * @param sampleRecord  Default value is "first"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSampleRecord(DefaultSampleRecord sampleRecord)  throws IllegalStateException {
        setAttribute("sampleRecord", sampleRecord == null ? null : sampleRecord.getValue(), false);
    }

    /**
     * If a <code>sampleRecord</code> is provided, the FieldPicker will show a second column in the Current Fields dialog
     * showing the cell value that will appear for that field given the provided sample record. <br> A value of "first" means
     * the first record.  If the underlying {@link com.smartgwt.client.widgets.FieldPicker#getDataBoundComponent
     * dataBoundComponent} is a {@link com.smartgwt.client.widgets.tree.TreeGrid}, you can specify "firstOpenLeaf" to use the
     * first open leaf as the sampleRecord (this is often desirable in trees where the first record may be a folder that's used
     * for organizational purposes only and hence would have no actual data for columns other than the tree column).
     *
     * @return DefaultSampleRecord
     */
    public DefaultSampleRecord getSampleRecordAsDefaultSampleRecord()  {
        return EnumUtil.getEnum(DefaultSampleRecord.values(), getAttribute("sampleRecord"));
    }
    

    /**
     * The title displayed for the sample value property of the current fields
     *
     * @param sampleValueTitle  Default value is "Sample Value"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSampleValueTitle(String sampleValueTitle)  throws IllegalStateException {
        setAttribute("sampleValueTitle", sampleValueTitle, false);
    }

    /**
     * The title displayed for the sample value property of the current fields
     *
     * @return String
     */
    public String getSampleValueTitle()  {
        return getAttributeAsString("sampleValueTitle");
    }
    

    /**
     * An AutoChild {@link com.smartgwt.client.widgets.IButton button} that saves the current field-set and exits the  Field
     * Picker.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getSaveAndExitButton() throws IllegalStateException {
        errorIfNotCreated("saveAndExitButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("saveAndExitButton"));
    }
    

    /**
     * The title shown on the Save and Exit button
     *
     * @param saveAndExitButtonTitle  Default value is "Apply"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSaveAndExitButtonTitle(String saveAndExitButtonTitle)  throws IllegalStateException {
        setAttribute("saveAndExitButtonTitle", saveAndExitButtonTitle, false);
    }

    /**
     * The title shown on the Save and Exit button
     *
     * @return String
     */
    public String getSaveAndExitButtonTitle()  {
        return getAttributeAsString("saveAndExitButtonTitle");
    }
    

    /**
     * When set to false, hides the right-most set of buttons, used for re-ordering fields in the Visible Fields list.
     *
     * @param showFieldOrderButtons  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowFieldOrderButtons(boolean showFieldOrderButtons)  throws IllegalStateException {
        setAttribute("showFieldOrderButtons", showFieldOrderButtons, false);
    }

    /**
     * When set to false, hides the right-most set of buttons, used for re-ordering fields in the Visible Fields list.
     *
     * @return boolean
     */
    public boolean getShowFieldOrderButtons()  {
        Boolean result = getAttributeAsBoolean("showFieldOrderButtons");
        return result == null ? true : result;
    }
    

    /**
     * Shows a "Highlights..." button that shows an interface for editing hilites in the attached DataBoundComponent.
     *
     * @param showHilitesButton  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowHilitesButton(boolean showHilitesButton)  throws IllegalStateException {
        setAttribute("showHilitesButton", showHilitesButton, false);
    }

    /**
     * Shows a "Highlights..." button that shows an interface for editing hilites in the attached DataBoundComponent.
     *
     * @return boolean
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
     */
    public static native void setDefaultProperties(FieldPicker fieldPickerProperties) /*-{
    	var properties = $wnd.isc.addProperties({},fieldPickerProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
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

    public LogicalStructureObject getLogicalStructure() {
        FieldPickerLogicalStructure s = new FieldPickerLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

