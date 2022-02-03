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
 * A widget that allows the user to set up complex sorting arrangements by defining a group of {@link
 * com.smartgwt.client.data.SortSpecifier}s. <P> Each {@link com.smartgwt.client.data.SortSpecifier} applies to a single
 * property and direction - so, for instance, in  a grid with two columns, <code>year</code> and <code>monthNumber</code>,
 * you could sort first  by <code>year</code> in descending order and then by <code>monthNumber</code> in ascending  order.
 * This would producing a grid sorted by year from largest (most  recent) to smallest (least recent) and, within each year,
 * by monthNumber from smallest  (January) to largest (December).
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("MultiSortPanel")
public class MultiSortPanel extends Layout {

    public static MultiSortPanel getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new MultiSortPanel(jsObj);
        } else {
            assert refInstance instanceof MultiSortPanel;
            return (MultiSortPanel)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MultiSortPanel.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.MultiSortPanel.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MultiSortPanel.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.MultiSortPanel.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public MultiSortPanel(){
        scClassName = "MultiSortPanel";
    }

    public MultiSortPanel(JavaScriptObject jsObj){
        scClassName = "MultiSortPanel";
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
     * sort configuration. <P> This component is an {@link com.smartgwt.client.types.AutoChild} and as such may be customized
     * via  <code>multiSortPanel.addLevelButtonProperties</code> and  <code>multiSortPanel.addLevelButtonDefaults</code>.
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
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setAddLevelButtonTitle(String addLevelButtonTitle)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("addLevelButtonTitle", addLevelButtonTitle, false);
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
     * The title-text to appear in the "direction" field's SelectItem for an "ascending" sort
     *
     * @param ascendingTitle New ascendingTitle value. Default value is "Ascending"
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setAscendingTitle(String ascendingTitle)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("ascendingTitle", ascendingTitle, false);
    }

    /**
     * The title-text to appear in the "direction" field's SelectItem for an "ascending" sort
     *
     * @return Current ascendingTitle value. Default value is "Ascending"
     */
    public String getAscendingTitle()  {
        return getAttributeAsString("ascendingTitle");
    }
    

    /**
     * Automatically generated {@link com.smartgwt.client.widgets.IButton} providing a mechanism for duplicating levels in the
     * sort configuration. <P> This component is an {@link com.smartgwt.client.types.AutoChild} and as such may be customized
     * via  <code>multiSortPanel.copyLevelButtonProperties</code> and  <code>multiSortPanel.copyLevelButtonDefaults</code>.
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
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setCopyLevelButtonTitle(String copyLevelButtonTitle)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("copyLevelButtonTitle", copyLevelButtonTitle, false);
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
     * sort configuration. <P> This component is an {@link com.smartgwt.client.types.AutoChild} and as such may be customized
     * via  <code>multiSortPanel.deleteLevelButtonProperties</code> and  <code>multiSortPanel.deleteLevelButtonDefaults</code>.
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
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setDeleteLevelButtonTitle(String deleteLevelButtonTitle)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("deleteLevelButtonTitle", deleteLevelButtonTitle, false);
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
     * The title-text to appear in the "direction" field's SelectItem for a "descending" sort
     *
     * @param descendingTitle New descendingTitle value. Default value is "Descending"
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setDescendingTitle(String descendingTitle)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("descendingTitle", descendingTitle, false);
    }

    /**
     * The title-text to appear in the "direction" field's SelectItem for a "descending" sort
     *
     * @return Current descendingTitle value. Default value is "Descending"
     */
    public String getDescendingTitle()  {
        return getAttributeAsString("descendingTitle");
    }
    

    /**
     * The title-text to appear in the header of the "direction" field.
     *
     * @param directionFieldTitle New directionFieldTitle value. Default value is "Order"
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setDirectionFieldTitle(String directionFieldTitle)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("directionFieldTitle", directionFieldTitle, false);
    }

    /**
     * The title-text to appear in the header of the "direction" field.
     *
     * @return Current directionFieldTitle value. Default value is "Order"
     */
    public String getDirectionFieldTitle()  {
        return getAttributeAsString("directionFieldTitle");
    }
    

    /**
     * The list of fields which the user can choose to sort by.
     *
     * @param fields New fields value. Default value is null
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setFields(DataSourceField... fields)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("fields", fields, false);
    }

    /**
     * The list of fields which the user can choose to sort by.
     *
     * @return Current fields value. Default value is null
     */
    public DataSourceField[] getFields()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfDataSourceField(getAttributeAsJavaScriptObject("fields"));
    }
    

    /**
     * The title-text to appear in the first column for the first sort-level.
     *
     * @param firstSortLevelTitle New firstSortLevelTitle value. Default value is "Sort by"
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setFirstSortLevelTitle(String firstSortLevelTitle)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("firstSortLevelTitle", firstSortLevelTitle, false);
    }

    /**
     * The title-text to appear in the first column for the first sort-level.
     *
     * @return Current firstSortLevelTitle value. Default value is "Sort by"
     */
    public String getFirstSortLevelTitle()  {
        return getAttributeAsString("firstSortLevelTitle");
    }
    

    /**
     * The initial sort configuration to show in the  {@link com.smartgwt.client.widgets.MultiSortPanel#getOptionsGrid
     * optionsGrid}.
     *
     * @param initialSort New initialSort value. Default value is null
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setInitialSort(SortSpecifier... initialSort)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("initialSort", initialSort, false);
    }

    /**
     * The initial sort configuration to show in the  {@link com.smartgwt.client.widgets.MultiSortPanel#getOptionsGrid
     * optionsGrid}.
     *
     * @return Current initialSort value. Default value is null
     */
    public SortSpecifier[] getInitialSort()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfSortSpecifier(getAttributeAsJavaScriptObject("initialSort"));
    }
    

    /**
     * This is a dynamic string - text within <code>&#36;{...}</code> will be evaluated as JS code when the message is
     * displayed. <P> Default value returns <P> <code> <i>Columns may only be used once: <code>[some field's title]</code> is
     * used multiple times</i> </code>
     *
     * @param invalidListPrompt New invalidListPrompt value. Default value is "Columns may only be used once: '${title}' is used multiple times."
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public MultiSortPanel setInvalidListPrompt(String invalidListPrompt)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("invalidListPrompt", invalidListPrompt, false);
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
     * sort-levels down in the sort configuration. <P> This component is an {@link com.smartgwt.client.types.AutoChild} and as
     * such may be customized via  <code>multiSortPanel.levelDownButtonProperties</code> and 
     * <code>multiSortPanel.levelDownButtonDefaults</code>.
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
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setLevelDownButtonTitle(String levelDownButtonTitle)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("levelDownButtonTitle", levelDownButtonTitle, false);
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
     * sort-levels up in the sort configuration. <P> This component is an {@link com.smartgwt.client.types.AutoChild} and as
     * such may be customized via  <code>multiSortPanel.levelUpButtonProperties</code> and 
     * <code>multiSortPanel.levelUpButtonDefaults</code>.
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
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setLevelUpButtonTitle(String levelUpButtonTitle)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("levelUpButtonTitle", levelUpButtonTitle, false);
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
     * The maximum number of levels of sorting that can be applied.  Since each sort-property or field-name can be used only
     * once in a given multi-sort operation, if no maxLevels value or a value larger than the total number of available
     * properties is specified, it will  default to the total number of available properties.
     *
     * @param maxLevels New maxLevels value. Default value is null
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setMaxLevels(Integer maxLevels)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("maxLevels", maxLevels, false);
    }

    /**
     * The maximum number of levels of sorting that can be applied.  Since each sort-property or field-name can be used only
     * once in a given multi-sort operation, if no maxLevels value or a value larger than the total number of available
     * properties is specified, it will  default to the total number of available properties.
     *
     * @return Current maxLevels value. Default value is null
     */
    public Integer getMaxLevels()  {
        return getAttributeAsInt("maxLevels");
    }
    

    /**
     * Automatically generated {@link com.smartgwt.client.widgets.grid.ListGrid} allowing the user to configure a set of 
     * {@link com.smartgwt.client.data.SortSpecifier}s. <P> This component is an {@link com.smartgwt.client.types.AutoChild}
     * and as such may be customized via  <code>multiSortPanel.optionsGridProperties</code> and 
     * <code>multiSortPanel.optionsGridDefaults</code>.
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
     * The title-text to appear in the first column for all sort-levels other than the first.
     *
     * @param otherSortLevelTitle New otherSortLevelTitle value. Default value is "Then by"
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setOtherSortLevelTitle(String otherSortLevelTitle)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("otherSortLevelTitle", otherSortLevelTitle, false);
    }

    /**
     * The title-text to appear in the first column for all sort-levels other than the first.
     *
     * @return Current otherSortLevelTitle value. Default value is "Then by"
     */
    public String getOtherSortLevelTitle()  {
        return getAttributeAsString("otherSortLevelTitle");
    }
    

    /**
     * The title-text to appear in the header of the "property" field.
     *
     * @param propertyFieldTitle New propertyFieldTitle value. Default value is "Column"
     * @return {@link com.smartgwt.client.widgets.MultiSortPanel MultiSortPanel} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiSortPanel setPropertyFieldTitle(String propertyFieldTitle)  throws IllegalStateException {
        return (MultiSortPanel)setAttribute("propertyFieldTitle", propertyFieldTitle, false);
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
     * Return the number of levels of sorting that have been configured.
     *
     * @return The number of levels of sorting that have been configured
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
     * Returns all configured sorting levels, as an array of {@link com.smartgwt.client.data.SortSpecifier}s.
     *
     * @return the SortSpecifiers for all configured sorting levels
     */
    public native SortSpecifier[] getSort() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSort", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSort();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfSortSpecifier(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Return a {@link com.smartgwt.client.data.SortSpecifier} object for the requested levelNum.
     * @param levelNum The index of the level to return a SortSpecifier for
     *
     * @return A SortSpecifier representing the requested levelNum
     */
    public native SortSpecifier getSortLevel(int levelNum) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getSortLevel", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSortLevel(levelNum);
        if(ret == null) return null;
        return @com.smartgwt.client.data.SortSpecifier::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Fired whenever the sort configuration changes.  The single parameter is an array of {@link
     * com.smartgwt.client.data.SortSpecifier}s that represent the list of sort-levels as they appear after  whatever change
     * has occurred.
     * @param sortLevels The current sort configuration, after any changes
     */
    public native void sortChanged(SortSpecifier... sortLevels) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "sortChanged", "SortSpecifier...");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.sortChanged(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(sortLevels));
    }-*/;

	/**
     * Validate that no two {@link com.smartgwt.client.data.SortSpecifier}s sort on the same  {@link
     * com.smartgwt.client.data.SortSpecifier#getProperty property}.
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
     * @param multiSortPanelProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(MultiSortPanel multiSortPanelProperties) /*-{
        if (multiSortPanelProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(MultiSortPanel.@java.lang.Object::getClass()(), "setDefaultProperties", multiSortPanelProperties.@java.lang.Object::getClass()());
        }
        multiSortPanelProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = multiSortPanelProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.MultiSortPanel.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(MultiSortPanelLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.addLevelButtonTitle = getAttributeAsString("addLevelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.addLevelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.ascendingTitle = getAttributeAsString("ascendingTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.ascendingTitle:" + t.getMessage() + "\n";
        }
        try {
            s.copyLevelButtonTitle = getAttributeAsString("copyLevelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.copyLevelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.deleteLevelButtonTitle = getAttributeAsString("deleteLevelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.deleteLevelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.descendingTitle = getAttributeAsString("descendingTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.descendingTitle:" + t.getMessage() + "\n";
        }
        try {
            s.directionFieldTitle = getAttributeAsString("directionFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.directionFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.fields = getFields();
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.fieldsArray:" + t.getMessage() + "\n";
        }
        try {
            s.firstSortLevelTitle = getAttributeAsString("firstSortLevelTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.firstSortLevelTitle:" + t.getMessage() + "\n";
        }
        try {
            s.initialSort = getInitialSort();
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.initialSortArray:" + t.getMessage() + "\n";
        }
        try {
            s.invalidListPrompt = getAttributeAsString("invalidListPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.invalidListPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.levelDownButtonTitle = getAttributeAsString("levelDownButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.levelDownButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.levelUpButtonTitle = getAttributeAsString("levelUpButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.levelUpButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.maxLevels = getAttributeAsString("maxLevels");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.maxLevels:" + t.getMessage() + "\n";
        }
        try {
            s.otherSortLevelTitle = getAttributeAsString("otherSortLevelTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.otherSortLevelTitle:" + t.getMessage() + "\n";
        }
        try {
            s.propertyFieldTitle = getAttributeAsString("propertyFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "MultiSortPanel.propertyFieldTitle:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        MultiSortPanelLogicalStructure s = new MultiSortPanelLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
