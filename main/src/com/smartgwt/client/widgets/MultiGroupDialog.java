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
 * A dialog that allows the user to set up complex grouping arrangements by defining a group of {@link
 * com.smartgwt.client.data.GroupSpecifier}s. <P> Each {@link com.smartgwt.client.data.GroupSpecifier} applies to a single
 * property and grouping - so, for instance, in  a grid with two columns, <code>Nationhood</code> and <code>Country</code>,
 * you could group first  by <code>Nationhood</code> with its selected groupingMode and then by <code>Country</code> with
 * its selected groupingMode. <P> <i><b>Important Note:</b> this class should not be used directly - it is exposed purely
 * for {@link i18nMessages i18n reasons.}</i>
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("MultiGroupDialog")
public class MultiGroupDialog extends Window {

    public static MultiGroupDialog getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new MultiGroupDialog(jsObj);
        } else {
            assert refInstance instanceof MultiGroupDialog;
            return (MultiGroupDialog)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MultiGroupDialog.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.MultiGroupDialog.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(MultiGroupDialog.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.MultiGroupDialog.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
     * The title-text to appear on the addLevelButton.   <P> Note, this is a passthrough property which, when set, is passed
     * through to the  {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} contained in this dialog.  You only
     * need to consider the properties on the MultiGroupPanel for i18n.
     *
     * @param addLevelButtonTitle New addLevelButtonTitle value. Default value is "Add Level"
     * @return {@link com.smartgwt.client.widgets.MultiGroupDialog MultiGroupDialog} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupDialog setAddLevelButtonTitle(String addLevelButtonTitle)  throws IllegalStateException {
        return (MultiGroupDialog)setAttribute("addLevelButtonTitle", addLevelButtonTitle, false);
    }

    /**
     * The title-text to appear on the addLevelButton.   <P> Note, this is a passthrough property which, when set, is passed
     * through to the  {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} contained in this dialog.  You only
     * need to consider the properties on the MultiGroupPanel for i18n.
     *
     * @return Current addLevelButtonTitle value. Default value is "Add Level"
     */
    public String getAddLevelButtonTitle()  {
        return getAttributeAsString("addLevelButtonTitle");
    }
    

    /**
     * Automatically generated {@link com.smartgwt.client.widgets.IButton} providing the mechanism for accepting the current
     * group configuration.  Fires the passed callback with a single parameter, groupLevels, representing the current group
     * configuration as an array of  {@link com.smartgwt.client.data.GroupSpecifier}s. <P> This component is an {@link
     * com.smartgwt.client.types.AutoChild} and as such may be customized via 
     * <code>multiGroupPanel.applyButtonProperties</code> and  <code>multiGroupPanel.applyButtonDefaults</code>.
     * <p>
     * This component is an AutoChild named "applyButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current applyButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getApplyButton() throws IllegalStateException {
        errorIfNotCreated("applyButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("applyButton"));
    }
    

    /**
     * The title-text to appear on the applyButton
     *
     * @param applyButtonTitle New applyButtonTitle value. Default value is "Apply"
     * @return {@link com.smartgwt.client.widgets.MultiGroupDialog MultiGroupDialog} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupDialog setApplyButtonTitle(String applyButtonTitle)  throws IllegalStateException {
        return (MultiGroupDialog)setAttribute("applyButtonTitle", applyButtonTitle, false);
    }

    /**
     * The title-text to appear on the applyButton
     *
     * @return Current applyButtonTitle value. Default value is "Apply"
     */
    public String getApplyButtonTitle()  {
        return getAttributeAsString("applyButtonTitle");
    }
    

    /**
     * Automatically generated {@link com.smartgwt.client.widgets.IButton} providing the mechanism for closing this Dialog
     * without accepting the current group configuration.  The passed callback is fired  with a single null parameter,
     * indicating that the operation was cancelled. <P> This component is an {@link com.smartgwt.client.types.AutoChild} and as
     * such may be customized via  <code>multiGroupPanel.cancelButtonProperties</code> and 
     * <code>multiGroupPanel.cancelButtonDefaults</code>.
     * <p>
     * This component is an AutoChild named "cancelButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current cancelButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCancelButton() throws IllegalStateException {
        errorIfNotCreated("cancelButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("cancelButton"));
    }
    

    /**
     * The title-text to appear on the cancelButton
     *
     * @param cancelButtonTitle New cancelButtonTitle value. Default value is "Cancel"
     * @return {@link com.smartgwt.client.widgets.MultiGroupDialog MultiGroupDialog} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupDialog setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        return (MultiGroupDialog)setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * The title-text to appear on the cancelButton
     *
     * @return Current cancelButtonTitle value. Default value is "Cancel"
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
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
     * The title-text to appear on the copyLevelButton <P> Note, this is a passthrough property which, when set, is passed
     * through to the  {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} contained in this dialog.  You only
     * need to consider the properties on the MultiGroupPanel for i18n.
     *
     * @param copyLevelButtonTitle New copyLevelButtonTitle value. Default value is "Copy Level"
     * @return {@link com.smartgwt.client.widgets.MultiGroupDialog MultiGroupDialog} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupDialog setCopyLevelButtonTitle(String copyLevelButtonTitle)  throws IllegalStateException {
        return (MultiGroupDialog)setAttribute("copyLevelButtonTitle", copyLevelButtonTitle, false);
    }

    /**
     * The title-text to appear on the copyLevelButton <P> Note, this is a passthrough property which, when set, is passed
     * through to the  {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} contained in this dialog.  You only
     * need to consider the properties on the MultiGroupPanel for i18n.
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
     * The title-text to appear on the deleteLevelButton <P> Note, this is a passthrough property which, when set, is passed
     * through to the  {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} contained in this dialog.  You only
     * need to consider the properties on the MultiGroupPanel for i18n.
     *
     * @param deleteLevelButtonTitle New deleteLevelButtonTitle value. Default value is "Delete Level"
     * @return {@link com.smartgwt.client.widgets.MultiGroupDialog MultiGroupDialog} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupDialog setDeleteLevelButtonTitle(String deleteLevelButtonTitle)  throws IllegalStateException {
        return (MultiGroupDialog)setAttribute("deleteLevelButtonTitle", deleteLevelButtonTitle, false);
    }

    /**
     * The title-text to appear on the deleteLevelButton <P> Note, this is a passthrough property which, when set, is passed
     * through to the  {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} contained in this dialog.  You only
     * need to consider the properties on the MultiGroupPanel for i18n.
     *
     * @return Current deleteLevelButtonTitle value. Default value is "Delete Level"
     */
    public String getDeleteLevelButtonTitle()  {
        return getAttributeAsString("deleteLevelButtonTitle");
    }
    
    

    /**
     * The title-text to appear in the header of the "property" field. <P> Note, this is a passthrough property which, when
     * set, is passed through to the  {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} contained in this
     * dialog.  You only need to consider the properties on the MultiGroupPanel for i18n.
     *
     * @param groupingFieldTitle New groupingFieldTitle value. Default value is "Grouping"
     * @return {@link com.smartgwt.client.widgets.MultiGroupDialog MultiGroupDialog} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupDialog setGroupingFieldTitle(String groupingFieldTitle)  throws IllegalStateException {
        return (MultiGroupDialog)setAttribute("groupingFieldTitle", groupingFieldTitle, false);
    }

    /**
     * The title-text to appear in the header of the "property" field. <P> Note, this is a passthrough property which, when
     * set, is passed through to the  {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} contained in this
     * dialog.  You only need to consider the properties on the MultiGroupPanel for i18n.
     *
     * @return Current groupingFieldTitle value. Default value is "Grouping"
     */
    public String getGroupingFieldTitle()  {
        return getAttributeAsString("groupingFieldTitle");
    }
    
    

    /**
     * This is a dynamic string - text within <code>&#36;{...}</code> will be evaluated as JS code when the message is
     * displayed. <P> Default value returns <P> <code> <i>Columns may only be used once: <code>[some field's title]</code> is
     * used multiple times</i> </code> <P> Note, this is a passthrough property which, when set, is passed through to the 
     * {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} contained in this dialog.  You only need to consider
     * the properties on the MultiGroupPanel for i18n.
     *
     * @param invalidListPrompt New invalidListPrompt value. Default value is "Columns may only be used once: '${title}' is used multiple times."
     * @return {@link com.smartgwt.client.widgets.MultiGroupDialog MultiGroupDialog} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public MultiGroupDialog setInvalidListPrompt(String invalidListPrompt)  throws IllegalStateException {
        return (MultiGroupDialog)setAttribute("invalidListPrompt", invalidListPrompt, false);
    }

    /**
     * This is a dynamic string - text within <code>&#36;{...}</code> will be evaluated as JS code when the message is
     * displayed. <P> Default value returns <P> <code> <i>Columns may only be used once: <code>[some field's title]</code> is
     * used multiple times</i> </code> <P> Note, this is a passthrough property which, when set, is passed through to the 
     * {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} contained in this dialog.  You only need to consider
     * the properties on the MultiGroupPanel for i18n.
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
     * @return {@link com.smartgwt.client.widgets.MultiGroupDialog MultiGroupDialog} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupDialog setLevelDownButtonTitle(String levelDownButtonTitle)  throws IllegalStateException {
        return (MultiGroupDialog)setAttribute("levelDownButtonTitle", levelDownButtonTitle, false);
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
     * @return {@link com.smartgwt.client.widgets.MultiGroupDialog MultiGroupDialog} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupDialog setLevelUpButtonTitle(String levelUpButtonTitle)  throws IllegalStateException {
        return (MultiGroupDialog)setAttribute("levelUpButtonTitle", levelUpButtonTitle, false);
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
     * properties is specified, it will  default to the total number of available properties. <P> Note, this is a passthrough
     * property which, when set, is passed through to the  {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel}
     * contained in this dialog.
     *
     * @param maxLevels New maxLevels value. Default value is null
     * @return {@link com.smartgwt.client.widgets.MultiGroupDialog MultiGroupDialog} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupDialog setMaxLevels(Integer maxLevels)  throws IllegalStateException {
        return (MultiGroupDialog)setAttribute("maxLevels", maxLevels, false);
    }

    /**
     * The maximum number of levels of grouping that can be applied.  Since each group-property or field-name can be used only
     * once in a given multi-group operation, if no maxLevels value or a value larger than the total number of available
     * properties is specified, it will  default to the total number of available properties. <P> Note, this is a passthrough
     * property which, when set, is passed through to the  {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel}
     * contained in this dialog.
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
     * The title-text to appear in the header of the "property" field. <P> Note, this is a passthrough property which, when
     * set, is passed through to the  {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} contained in this
     * dialog.  You only need to consider the properties on the MultiGroupPanel for i18n.
     *
     * @param propertyFieldTitle New propertyFieldTitle value. Default value is "Column"
     * @return {@link com.smartgwt.client.widgets.MultiGroupDialog MultiGroupDialog} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public MultiGroupDialog setPropertyFieldTitle(String propertyFieldTitle)  throws IllegalStateException {
        return (MultiGroupDialog)setAttribute("propertyFieldTitle", propertyFieldTitle, false);
    }

    /**
     * The title-text to appear in the header of the "property" field. <P> Note, this is a passthrough property which, when
     * set, is passed through to the  {@link com.smartgwt.client.widgets.MultiGroupPanel MultiGroupPanel} contained in this
     * dialog.  You only need to consider the properties on the MultiGroupPanel for i18n.
     *
     * @return Current propertyFieldTitle value. Default value is "Column"
     */
    public String getPropertyFieldTitle()  {
        return getAttributeAsString("propertyFieldTitle");
    }
    

    /**
     * The title-text to appear in this Dialog's Header-bar.
     *
     * @param title New title value. Default value is "Group"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTitle(String title)  throws IllegalStateException {
        setAttribute("title", title, false);
    }

    /**
     * The title-text to appear in this Dialog's Header-bar.
     *
     * @return Current title value. Default value is "Group"
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getNumLevels", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getNumLevels();
        return ret;
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
     * @param multiGroupDialogProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(MultiGroupDialog multiGroupDialogProperties) /*-{
        if (multiGroupDialogProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(MultiGroupDialog.@java.lang.Object::getClass()(), "setDefaultProperties", multiGroupDialogProperties.@java.lang.Object::getClass()());
        }
        multiGroupDialogProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = multiGroupDialogProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.MultiGroupDialog.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
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

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        MultiGroupDialogLogicalStructure s = new MultiGroupDialogLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
