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
 
package com.smartgwt.client.widgets;


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
 * A dialog that allows the user to set up complex grouping arrangements by defining a group of GroupSpecifiers. <P> Each
 * GroupSpecifier applies to a single property and grouping - so, for instance, in  a grid with two columns,
 * <code>Nationhood</code> and <code>Country</code>, you could group first  by <code>Nationhood</code> with its selected
 * groupingMode and then by <code>Country</code> with its selected groupingMode. <P> <i><b>Important Note:</b> this class
 * should not be used directly - it is exposed purely for {@link i18nMessages i18n reasons.}</i>
 */
public class MultiGroupDialog extends Window {

    public native static MultiGroupDialog getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("MultiGroupDialog",jsObj);
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
        $wnd.isc["MultiGroupDialog"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc["MultiGroupDialog"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public MultiGroupDialog(){
        scClassName = "MultiGroupDialog";
    }

    public MultiGroupDialog(JavaScriptObject jsObj){
        scClassName = "MultiGroupDialog";
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
     * Automatically generated {@link com.smartgwt.client.widgets.IButton} providing a mechanism for adding new levels to the
     * group configuration. <P> This component is an AutoChild and as such may be customized via 
     * <code>multiGroupPanel.addLevelButtonProperties</code> and  <code>multiGroupPanel.addLevelButtonDefaults</code>.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getAddLevelButton() throws IllegalStateException {
        errorIfNotCreated("addLevelButton");
        return IButton.getOrCreateRef(getAttributeAsJavaScriptObject("addLevelButton"));
    }


    /**
     * The title-text to appear on the addLevelButton.   <P> Note, this is a passthrough property which, when set, is passed
     * through to the   MultiGroupPanel contained in this dialog.  You only need to consider the properties on the
     * MultiGroupPanel for i18n.
     *
     * @param addLevelButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Add Level"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAddLevelButtonTitle(String addLevelButtonTitle)  throws IllegalStateException {
        setAttribute("addLevelButtonTitle", addLevelButtonTitle, false);
    }

    /**
     * The title-text to appear on the addLevelButton.   <P> Note, this is a passthrough property which, when set, is passed
     * through to the   MultiGroupPanel contained in this dialog.  You only need to consider the properties on the
     * MultiGroupPanel for i18n.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getAddLevelButtonTitle()  {
        return getAttributeAsString("addLevelButtonTitle");
    }


    /**
     * Automatically generated {@link com.smartgwt.client.widgets.IButton} providing the mechanism for accepting the current
     * group configuration.  Fires the passed callback with a single parameter, groupLevels, representing the current group
     * configuration as an array of  GroupSpecifiers. <P> This component is an AutoChild and as such may be customized via 
     * <code>multiGroupPanel.applyButtonProperties</code> and  <code>multiGroupPanel.applyButtonDefaults</code>.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getApplyButton() throws IllegalStateException {
        errorIfNotCreated("applyButton");
        return IButton.getOrCreateRef(getAttributeAsJavaScriptObject("applyButton"));
    }


    /**
     * The title-text to appear on the applyButton
     *
     * @param applyButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Apply"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setApplyButtonTitle(String applyButtonTitle)  throws IllegalStateException {
        setAttribute("applyButtonTitle", applyButtonTitle, false);
    }

    /**
     * The title-text to appear on the applyButton
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getApplyButtonTitle()  {
        return getAttributeAsString("applyButtonTitle");
    }


    /**
     * Automatically generated {@link com.smartgwt.client.widgets.IButton} providing the mechanism for closing this Dialog
     * without accepting the current group configuration.  The passed callback is fired  with a single null parameter,
     * indicating that the operation was cancelled. <P> This component is an AutoChild and as such may be customized via 
     * <code>multiGroupPanel.cancelButtonProperties</code> and  <code>multiGroupPanel.cancelButtonDefaults</code>.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCancelButton() throws IllegalStateException {
        errorIfNotCreated("cancelButton");
        return IButton.getOrCreateRef(getAttributeAsJavaScriptObject("cancelButton"));
    }


    /**
     * The title-text to appear on the cancelButton
     *
     * @param cancelButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Cancel"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * The title-text to appear on the cancelButton
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }


    /**
     * Automatically generated {@link com.smartgwt.client.widgets.IButton} providing a mechanism for duplicating levels in the
     * group configuration. <P> This component is an AutoChild and as such may be customized via 
     * <code>multiGroupPanel.copyLevelButtonProperties</code> and  <code>multiGroupPanel.copyLevelButtonDefaults</code>.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCopyLevelButton() throws IllegalStateException {
        errorIfNotCreated("copyLevelButton");
        return IButton.getOrCreateRef(getAttributeAsJavaScriptObject("copyLevelButton"));
    }


    /**
     * The title-text to appear on the copyLevelButton <P> Note, this is a passthrough property which, when set, is passed
     * through to the   MultiGroupPanel contained in this dialog.  You only need to consider the properties on the
     * MultiGroupPanel for i18n.
     *
     * @param copyLevelButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Copy Level"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCopyLevelButtonTitle(String copyLevelButtonTitle)  throws IllegalStateException {
        setAttribute("copyLevelButtonTitle", copyLevelButtonTitle, false);
    }

    /**
     * The title-text to appear on the copyLevelButton <P> Note, this is a passthrough property which, when set, is passed
     * through to the   MultiGroupPanel contained in this dialog.  You only need to consider the properties on the
     * MultiGroupPanel for i18n.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getCopyLevelButtonTitle()  {
        return getAttributeAsString("copyLevelButtonTitle");
    }


    /**
     * Automatically generated {@link com.smartgwt.client.widgets.IButton} providing a mechanism for deleting levels from the
     * group configuration. <P> This component is an AutoChild and as such may be customized via 
     * <code>multiGroupPanel.deleteLevelButtonProperties</code> and  <code>multiGroupPanel.deleteLevelButtonDefaults</code>.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getDeleteLevelButton() throws IllegalStateException {
        errorIfNotCreated("deleteLevelButton");
        return IButton.getOrCreateRef(getAttributeAsJavaScriptObject("deleteLevelButton"));
    }


    /**
     * The title-text to appear on the deleteLevelButton <P> Note, this is a passthrough property which, when set, is passed
     * through to the   MultiGroupPanel contained in this dialog.  You only need to consider the properties on the
     * MultiGroupPanel for i18n.
     *
     * @param deleteLevelButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Delete Level"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDeleteLevelButtonTitle(String deleteLevelButtonTitle)  throws IllegalStateException {
        setAttribute("deleteLevelButtonTitle", deleteLevelButtonTitle, false);
    }

    /**
     * The title-text to appear on the deleteLevelButton <P> Note, this is a passthrough property which, when set, is passed
     * through to the   MultiGroupPanel contained in this dialog.  You only need to consider the properties on the
     * MultiGroupPanel for i18n.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getDeleteLevelButtonTitle()  {
        return getAttributeAsString("deleteLevelButtonTitle");
    }



    /**
     * The title-text to appear in the header of the "property" field. <P> Note, this is a passthrough property which, when
     * set, is passed through to the   MultiGroupPanel contained in this dialog.  You only need to consider the properties on
     * the MultiGroupPanel for i18n.
     *
     * @param groupingFieldTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Grouping"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGroupingFieldTitle(String groupingFieldTitle)  throws IllegalStateException {
        setAttribute("groupingFieldTitle", groupingFieldTitle, false);
    }

    /**
     * The title-text to appear in the header of the "property" field. <P> Note, this is a passthrough property which, when
     * set, is passed through to the   MultiGroupPanel contained in this dialog.  You only need to consider the properties on
     * the MultiGroupPanel for i18n.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getGroupingFieldTitle()  {
        return getAttributeAsString("groupingFieldTitle");
    }



    /**
     * This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code when the message is displayed.
     * <P> Default value returns <P> <code> <i>Columns may only be used once: <code>[some field's title]</code> is used
     * multiple times</i> </code> <P> Note, this is a passthrough property which, when set, is passed through to the  
     * MultiGroupPanel contained in this dialog.  You only need to consider the properties on the MultiGroupPanel for i18n.
     *
     * @param invalidListPrompt . See {@link com.smartgwt.client.docs.String String}. Default value is "Columns may only be used once: '\${title}' is used multiple times."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInvalidListPrompt(String invalidListPrompt)  throws IllegalStateException {
        setAttribute("invalidListPrompt", invalidListPrompt, false);
    }

    /**
     * This is a dynamic string - text within <code>\${...}</code> will be evaluated as JS code when the message is displayed.
     * <P> Default value returns <P> <code> <i>Columns may only be used once: <code>[some field's title]</code> is used
     * multiple times</i> </code> <P> Note, this is a passthrough property which, when set, is passed through to the  
     * MultiGroupPanel contained in this dialog.  You only need to consider the properties on the MultiGroupPanel for i18n.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getInvalidListPrompt()  {
        return getAttributeAsString("invalidListPrompt");
    }


    /**
     * Automatically generated {@link com.smartgwt.client.widgets.ImgButton} providing a mechanism for moving existing
     * group-levels down in the group configuration. <P> This component is an AutoChild and as such may be customized via 
     * <code>multiGroupPanel.levelDownButtonProperties</code> and  <code>multiGroupPanel.levelDownButtonDefaults</code>.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ImgButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getLevelDownButton() throws IllegalStateException {
        errorIfNotCreated("levelDownButton");
        return ImgButton.getOrCreateRef(getAttributeAsJavaScriptObject("levelDownButton"));
    }


    /**
     * The hover-prompt for the Level Down button.
     *
     * @param levelDownButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Move Level Down"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLevelDownButtonTitle(String levelDownButtonTitle)  throws IllegalStateException {
        setAttribute("levelDownButtonTitle", levelDownButtonTitle, false);
    }

    /**
     * The hover-prompt for the Level Down button.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getLevelDownButtonTitle()  {
        return getAttributeAsString("levelDownButtonTitle");
    }


    /**
     * Automatically generated {@link com.smartgwt.client.widgets.ImgButton} providing a mechanism for moving existing
     * group-levels up in the group configuration. <P> This component is an AutoChild and as such may be customized via 
     * <code>multiGroupPanel.levelUpButtonProperties</code> and  <code>multiGroupPanel.levelUpButtonDefaults</code>.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ImgButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getLevelUpButton() throws IllegalStateException {
        errorIfNotCreated("levelUpButton");
        return ImgButton.getOrCreateRef(getAttributeAsJavaScriptObject("levelUpButton"));
    }


    /**
     * The hover-prompt for the Level Up button.
     *
     * @param levelUpButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Move Level Up"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLevelUpButtonTitle(String levelUpButtonTitle)  throws IllegalStateException {
        setAttribute("levelUpButtonTitle", levelUpButtonTitle, false);
    }

    /**
     * The hover-prompt for the Level Up button.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getLevelUpButtonTitle()  {
        return getAttributeAsString("levelUpButtonTitle");
    }


    /**
     * The maximum number of levels of grouping that can be applied.  Since each group-property or field-name can be used only
     * once in a given multi-group operation, if no maxLevels value or a value larger than the total number of available
     * properties is specified, it will  default to the total number of available properties. <P> Note, this is a passthrough
     * property which, when set, is passed through to the   MultiGroupPanel contained in this dialog.
     *
     * @param maxLevels maxLevels Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMaxLevels(Integer maxLevels)  throws IllegalStateException {
        setAttribute("maxLevels", maxLevels, false);
    }

    /**
     * The maximum number of levels of grouping that can be applied.  Since each group-property or field-name can be used only
     * once in a given multi-group operation, if no maxLevels value or a value larger than the total number of available
     * properties is specified, it will  default to the total number of available properties. <P> Note, this is a passthrough
     * property which, when set, is passed through to the   MultiGroupPanel contained in this dialog.
     *
     * @return Integer
     */
    public Integer getMaxLevels()  {
        return getAttributeAsInt("maxLevels");
    }


    /**
     * Automatically generated {@link com.smartgwt.client.widgets.grid.ListGrid} allowing the user to configure a set of 
     * GroupSpecifiers. <P> This component is an AutoChild and as such may be customized via 
     * <code>multiGroupPanel.optionsGridProperties</code> and  <code>multiGroupPanel.optionsGridDefaults</code>.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ListGrid
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ListGrid getOptionsGrid() throws IllegalStateException {
        errorIfNotCreated("optionsGrid");
        return ListGrid.getOrCreateRef(getAttributeAsJavaScriptObject("optionsGrid"));
    }


    /**
     * The title-text to appear in the header of the "property" field. <P> Note, this is a passthrough property which, when
     * set, is passed through to the   MultiGroupPanel contained in this dialog.  You only need to consider the properties on
     * the MultiGroupPanel for i18n.
     *
     * @param propertyFieldTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Column"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPropertyFieldTitle(String propertyFieldTitle)  throws IllegalStateException {
        setAttribute("propertyFieldTitle", propertyFieldTitle, false);
    }

    /**
     * The title-text to appear in the header of the "property" field. <P> Note, this is a passthrough property which, when
     * set, is passed through to the   MultiGroupPanel contained in this dialog.  You only need to consider the properties on
     * the MultiGroupPanel for i18n.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getPropertyFieldTitle()  {
        return getAttributeAsString("propertyFieldTitle");
    }


    /**
     * The title-text to appear in this Dialog's Header-bar.
     *
     * @param title . See {@link com.smartgwt.client.docs.String String}. Default value is "Group"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTitle(String title)  throws IllegalStateException {
        setAttribute("title", title, false);
    }

    /**
     * The title-text to appear in this Dialog's Header-bar.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    // ********************* Methods ***********************
	/**
     * Return the number of levels of grouping that have been configured.
     *
     * @return The number of levels of grouping that have been configured
     */
    public native int getNumLevels() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNumLevels();
        return ret;
    }-*/;
	/**
     * Validate that no two GroupSpecifiers group on the same   property.
     *
     * @return True if validation succeeds, false if any property is used twice
     */
    public native boolean validate() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.validate();
        return ret;
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
     * @param multiGroupDialogProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(MultiGroupDialog multiGroupDialogProperties) /*-{
    	var properties = $wnd.isc.addProperties({},multiGroupDialogProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.MultiGroupDialog.addProperties(properties);
    }-*/;

    // ***********************************************************

    public LogicalStructureObject setLogicalStructure(MultiGroupDialogLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.addLevelButtonTitle = getAttributeAsString("addLevelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupDialog.addLevelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.applyButtonTitle = getAttributeAsString("applyButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupDialog.applyButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupDialog.cancelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.copyLevelButtonTitle = getAttributeAsString("copyLevelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupDialog.copyLevelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.deleteLevelButtonTitle = getAttributeAsString("deleteLevelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupDialog.deleteLevelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.groupingFieldTitle = getAttributeAsString("groupingFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupDialog.groupingFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.invalidListPrompt = getAttributeAsString("invalidListPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupDialog.invalidListPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.levelDownButtonTitle = getAttributeAsString("levelDownButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupDialog.levelDownButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.levelUpButtonTitle = getAttributeAsString("levelUpButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupDialog.levelUpButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.maxLevels = getAttributeAsString("maxLevels");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupDialog.maxLevels:" + t.getMessage() + "\n";
        }
        try {
            s.propertyFieldTitle = getAttributeAsString("propertyFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupDialog.propertyFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupDialog.title:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        MultiGroupDialogLogicalStructure s = new MultiGroupDialogLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

