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
 * A widget that allows the user to set up complex grouping arrangements by defining a group of {@link
 * com.smartgwt.client.data.GroupSpecifier}s. <P> Each {@link com.smartgwt.client.data.GroupSpecifier} applies to a single
 * property and grouping - so, for instance, in  a grid with two columns, <code>Nationhood</code> and <code>Country</code>,
 * you could group  first by <code>Nationhood</code> with its selected groupingMode and then by  <code>Country</code> with
 * its selected groupingMode.  <i><b>Important Note:</b> this class should not be used directly - it is exposed purely for
 * {@link i18nMessages i18n reasons.}</i>
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("MultiGroupPanel")
public class MultiGroupPanel extends Layout {

    public static MultiGroupPanel getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new MultiGroupPanel(jsObj);
        } else {
            assert refInstance instanceof MultiGroupPanel;
            return (MultiGroupPanel)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MultiGroupPanel.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.MultiGroupPanel.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MultiGroupPanel.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.MultiGroupPanel.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public MultiGroupPanel(){
        scClassName = "MultiGroupPanel";
    }

    public MultiGroupPanel(JavaScriptObject jsObj){
        scClassName = "MultiGroupPanel";
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
     * Automatically generated {@link com.smartgwt.client.widgets.IButton} providing a mechanism for adding new levels to the
     * group configuration. <P> This component is an {@link com.smartgwt.client.types.AutoChild} and as such may be customized
     * via  <code>multiGroupPanel.addLevelButtonProperties</code> and  <code>multiGroupPanel.addLevelButtonDefaults</code>.
     * <p>
     * This component is an AutoChild named "addLevelButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current addLevelButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getAddLevelButton() throws IllegalStateException {
        errorIfNotCreated("addLevelButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("addLevelButton"));
    }
    

    /**
     * The title-text to appear on the addLevelButton
     *
     * @param addLevelButtonTitle New addLevelButtonTitle value. Default value is "Add Level"
     * @return {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupPanel setAddLevelButtonTitle(String addLevelButtonTitle)  throws IllegalStateException {
        return (MultiGroupPanel)setAttribute("addLevelButtonTitle", addLevelButtonTitle, false);
    }

    /**
     * The title-text to appear on the addLevelButton
     *
     * @return Current addLevelButtonTitle value. Default value is "Add Level"
     */
    public String getAddLevelButtonTitle()  {
        return getAttributeAsString("addLevelButtonTitle");
    }
    

    /**
     * Automatically generated {@link com.smartgwt.client.widgets.IButton} providing a mechanism for duplicating levels in the
     * group configuration. <P> This component is an {@link com.smartgwt.client.types.AutoChild} and as such may be customized
     * via  <code>multiGroupPanel.copyLevelButtonProperties</code> and  <code>multiGroupPanel.copyLevelButtonDefaults</code>.
     * <p>
     * This component is an AutoChild named "copyLevelButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current copyLevelButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCopyLevelButton() throws IllegalStateException {
        errorIfNotCreated("copyLevelButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("copyLevelButton"));
    }
    

    /**
     * The title-text to appear on the copyLevelButton
     *
     * @param copyLevelButtonTitle New copyLevelButtonTitle value. Default value is "Copy Level"
     * @return {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupPanel setCopyLevelButtonTitle(String copyLevelButtonTitle)  throws IllegalStateException {
        return (MultiGroupPanel)setAttribute("copyLevelButtonTitle", copyLevelButtonTitle, false);
    }

    /**
     * The title-text to appear on the copyLevelButton
     *
     * @return Current copyLevelButtonTitle value. Default value is "Copy Level"
     */
    public String getCopyLevelButtonTitle()  {
        return getAttributeAsString("copyLevelButtonTitle");
    }
    

    /**
     * Automatically generated {@link com.smartgwt.client.widgets.IButton} providing a mechanism for deleting levels from the
     * group configuration. <P> This component is an {@link com.smartgwt.client.types.AutoChild} and as such may be customized
     * via  <code>multiGroupPanel.deleteLevelButtonProperties</code> and 
     * <code>multiGroupPanel.deleteLevelButtonDefaults</code>.
     * <p>
     * This component is an AutoChild named "deleteLevelButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current deleteLevelButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getDeleteLevelButton() throws IllegalStateException {
        errorIfNotCreated("deleteLevelButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("deleteLevelButton"));
    }
    

    /**
     * The title-text to appear on the deleteLevelButton
     *
     * @param deleteLevelButtonTitle New deleteLevelButtonTitle value. Default value is "Delete Level"
     * @return {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupPanel setDeleteLevelButtonTitle(String deleteLevelButtonTitle)  throws IllegalStateException {
        return (MultiGroupPanel)setAttribute("deleteLevelButtonTitle", deleteLevelButtonTitle, false);
    }

    /**
     * The title-text to appear on the deleteLevelButton
     *
     * @return Current deleteLevelButtonTitle value. Default value is "Delete Level"
     */
    public String getDeleteLevelButtonTitle()  {
        return getAttributeAsString("deleteLevelButtonTitle");
    }
    
    

    /**
     * The title-text to appear in the first column for the first group-level.
     *
     * @param firstGroupLevelTitle New firstGroupLevelTitle value. Default value is "Group by"
     * @return {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupPanel setFirstGroupLevelTitle(String firstGroupLevelTitle)  throws IllegalStateException {
        return (MultiGroupPanel)setAttribute("firstGroupLevelTitle", firstGroupLevelTitle, false);
    }

    /**
     * The title-text to appear in the first column for the first group-level.
     *
     * @return Current firstGroupLevelTitle value. Default value is "Group by"
     */
    public String getFirstGroupLevelTitle()  {
        return getAttributeAsString("firstGroupLevelTitle");
    }
    

    /**
     * The title-text to appear in the header of the "grouping" field.
     *
     * @param groupingFieldTitle New groupingFieldTitle value. Default value is "Grouping"
     * @return {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupPanel setGroupingFieldTitle(String groupingFieldTitle)  throws IllegalStateException {
        return (MultiGroupPanel)setAttribute("groupingFieldTitle", groupingFieldTitle, false);
    }

    /**
     * The title-text to appear in the header of the "grouping" field.
     *
     * @return Current groupingFieldTitle value. Default value is "Grouping"
     */
    public String getGroupingFieldTitle()  {
        return getAttributeAsString("groupingFieldTitle");
    }
    
    

    /**
     * This is a dynamic string - text within <code>&#36;{...}</code> will be evaluated as JS code when the message is
     * displayed. <P> Default value returns <P> <code> <i>Columns may only be used once: <code>[some field's title]</code> is
     * used multiple times</i> </code>
     *
     * @param invalidListPrompt New invalidListPrompt value. Default value is "Columns may only be used once: '${title}' is used multiple times."
     * @return {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public MultiGroupPanel setInvalidListPrompt(String invalidListPrompt)  throws IllegalStateException {
        return (MultiGroupPanel)setAttribute("invalidListPrompt", invalidListPrompt, false);
    }

    /**
     * This is a dynamic string - text within <code>&#36;{...}</code> will be evaluated as JS code when the message is
     * displayed. <P> Default value returns <P> <code> <i>Columns may only be used once: <code>[some field's title]</code> is
     * used multiple times</i> </code>
     *
     * @return Current invalidListPrompt value. Default value is "Columns may only be used once: '${title}' is used multiple times."
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getInvalidListPrompt()  {
        return getAttributeAsString("invalidListPrompt");
    }
    

    /**
     * Automatically generated {@link com.smartgwt.client.widgets.ImgButton} providing a mechanism for moving existing
     * group-levels down in the group configuration. <P> This component is an {@link com.smartgwt.client.types.AutoChild} and
     * as such may be customized via  <code>multiGroupPanel.levelDownButtonProperties</code> and 
     * <code>multiGroupPanel.levelDownButtonDefaults</code>.
     * <p>
     * This component is an AutoChild named "levelDownButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current levelDownButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getLevelDownButton() throws IllegalStateException {
        errorIfNotCreated("levelDownButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("levelDownButton"));
    }
    

    /**
     * The hover-prompt for the Level Down button.
     *
     * @param levelDownButtonTitle New levelDownButtonTitle value. Default value is "Move Level Down"
     * @return {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupPanel setLevelDownButtonTitle(String levelDownButtonTitle)  throws IllegalStateException {
        return (MultiGroupPanel)setAttribute("levelDownButtonTitle", levelDownButtonTitle, false);
    }

    /**
     * The hover-prompt for the Level Down button.
     *
     * @return Current levelDownButtonTitle value. Default value is "Move Level Down"
     */
    public String getLevelDownButtonTitle()  {
        return getAttributeAsString("levelDownButtonTitle");
    }
    

    /**
     * Automatically generated {@link com.smartgwt.client.widgets.ImgButton} providing a mechanism for moving existing
     * group-levels up in the group configuration. <P> This component is an {@link com.smartgwt.client.types.AutoChild} and as
     * such may be customized via  <code>multiGroupPanel.levelUpButtonProperties</code> and 
     * <code>multiGroupPanel.levelUpButtonDefaults</code>.
     * <p>
     * This component is an AutoChild named "levelUpButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current levelUpButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ImgButton getLevelUpButton() throws IllegalStateException {
        errorIfNotCreated("levelUpButton");
        return (ImgButton)ImgButton.getByJSObject(getAttributeAsJavaScriptObject("levelUpButton"));
    }
    

    /**
     * The hover-prompt for the Level Up button.
     *
     * @param levelUpButtonTitle New levelUpButtonTitle value. Default value is "Move Level Up"
     * @return {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupPanel setLevelUpButtonTitle(String levelUpButtonTitle)  throws IllegalStateException {
        return (MultiGroupPanel)setAttribute("levelUpButtonTitle", levelUpButtonTitle, false);
    }

    /**
     * The hover-prompt for the Level Up button.
     *
     * @return Current levelUpButtonTitle value. Default value is "Move Level Up"
     */
    public String getLevelUpButtonTitle()  {
        return getAttributeAsString("levelUpButtonTitle");
    }
    

    /**
     * The maximum number of levels of grouping that can be applied.  Since each group-property or field-name can be used only
     * once in a given multi-group operation, if no maxLevels value or a value larger than the total number of available
     * properties is specified, it will  default to the total number of available properties.
     *
     * @param maxLevels New maxLevels value. Default value is null
     * @return {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupPanel setMaxLevels(Integer maxLevels)  throws IllegalStateException {
        return (MultiGroupPanel)setAttribute("maxLevels", maxLevels, false);
    }

    /**
     * The maximum number of levels of grouping that can be applied.  Since each group-property or field-name can be used only
     * once in a given multi-group operation, if no maxLevels value or a value larger than the total number of available
     * properties is specified, it will  default to the total number of available properties.
     *
     * @return Current maxLevels value. Default value is null
     */
    public Integer getMaxLevels()  {
        return getAttributeAsInt("maxLevels");
    }
    

    /**
     * Automatically generated {@link com.smartgwt.client.widgets.grid.ListGrid} allowing the user to configure a set of 
     * {@link com.smartgwt.client.data.GroupSpecifier}s. <P> This component is an {@link com.smartgwt.client.types.AutoChild}
     * and as such may be customized via  <code>multiGroupPanel.optionsGridProperties</code> and 
     * <code>multiGroupPanel.optionsGridDefaults</code>.
     * <p>
     * This component is an AutoChild named "optionsGrid".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current optionsGrid value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ListGrid getOptionsGrid() throws IllegalStateException {
        errorIfNotCreated("optionsGrid");
        return (ListGrid)ListGrid.getByJSObject(getAttributeAsJavaScriptObject("optionsGrid"));
    }
    

    /**
     * The title-text to appear in the first column for all group-levels other than the first.
     *
     * @param otherGroupLevelTitle New otherGroupLevelTitle value. Default value is "Then by"
     * @return {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupPanel setOtherGroupLevelTitle(String otherGroupLevelTitle)  throws IllegalStateException {
        return (MultiGroupPanel)setAttribute("otherGroupLevelTitle", otherGroupLevelTitle, false);
    }

    /**
     * The title-text to appear in the first column for all group-levels other than the first.
     *
     * @return Current otherGroupLevelTitle value. Default value is "Then by"
     */
    public String getOtherGroupLevelTitle()  {
        return getAttributeAsString("otherGroupLevelTitle");
    }
    

    /**
     * The title-text to appear in the header of the "property" field.
     *
     * @param propertyFieldTitle New propertyFieldTitle value. Default value is "Column"
     * @return {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupPanel setPropertyFieldTitle(String propertyFieldTitle)  throws IllegalStateException {
        return (MultiGroupPanel)setAttribute("propertyFieldTitle", propertyFieldTitle, false);
    }

    /**
     * The title-text to appear in the header of the "property" field.
     *
     * @return Current propertyFieldTitle value. Default value is "Column"
     */
    public String getPropertyFieldTitle()  {
        return getAttributeAsString("propertyFieldTitle");
    }
    

    // ********************* Methods ***********************
	/**
     * Returns all configured grouping levels, as an array of {@link com.smartgwt.client.data.GroupSpecifier}s.
     *
     * @return the GroupSpecifiers for all configured grouping levels
     */
    public native GroupSpecifier[] getGroup() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getGroup", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getGroup();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfGroupSpecifier(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return the number of levels of grouping that have been configured.
     *
     * @return The number of levels of grouping that have been configured
     */
    public native int getNumLevels() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getNumLevels", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNumLevels();
        return ret;
    }-*/;

	/**
     * Fired whenever the group configuration changes.  The single parameter is an array of {@link
     * com.smartgwt.client.data.GroupSpecifier}s that represent the list of group-levels as they appear after  whatever change
     * has occurred.
     * @param groupLevels The current group configuration, after any changes
     */
    public native void groupChanged(GroupSpecifier... groupLevels) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "groupChanged", "GroupSpecifier...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.groupChanged(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(groupLevels));
    }-*/;

	/**
     * Validate that no two {@link com.smartgwt.client.data.GroupSpecifier}s group on the same  {@link
     * com.smartgwt.client.data.GroupSpecifier#getProperty property}.
     *
     * @return True if validation succeeds, false if any property is used twice
     */
    public native boolean validate() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "validate", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.validate();
        return ret == null ? false : ret;
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
     * @param multiGroupPanelProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(MultiGroupPanel multiGroupPanelProperties) /*-{
        if (multiGroupPanelProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(MultiGroupPanel.@java.lang.Object::getClass()(), "setDefaultProperties", multiGroupPanelProperties.@java.lang.Object::getClass()());
        }
        multiGroupPanelProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = multiGroupPanelProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.MultiGroupPanel.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(MultiGroupPanelLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.addLevelButtonTitle = getAttributeAsString("addLevelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupPanel.addLevelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.copyLevelButtonTitle = getAttributeAsString("copyLevelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupPanel.copyLevelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.deleteLevelButtonTitle = getAttributeAsString("deleteLevelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupPanel.deleteLevelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.firstGroupLevelTitle = getAttributeAsString("firstGroupLevelTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupPanel.firstGroupLevelTitle:" + t.getMessage() + "\n";
        }
        try {
            s.groupingFieldTitle = getAttributeAsString("groupingFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupPanel.groupingFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.invalidListPrompt = getAttributeAsString("invalidListPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupPanel.invalidListPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.levelDownButtonTitle = getAttributeAsString("levelDownButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupPanel.levelDownButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.levelUpButtonTitle = getAttributeAsString("levelUpButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupPanel.levelUpButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.maxLevels = getAttributeAsString("maxLevels");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupPanel.maxLevels:" + t.getMessage() + "\n";
        }
        try {
            s.otherGroupLevelTitle = getAttributeAsString("otherGroupLevelTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupPanel.otherGroupLevelTitle:" + t.getMessage() + "\n";
        }
        try {
            s.propertyFieldTitle = getAttributeAsString("propertyFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiGroupPanel.propertyFieldTitle:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        MultiGroupPanelLogicalStructure s = new MultiGroupPanelLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
