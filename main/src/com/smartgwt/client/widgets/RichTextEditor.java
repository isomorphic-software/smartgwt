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
 * RichTextEditing component.  Provides a rich-text editing area along with UI for executing rich-text commands on selected
 * content. <p> The HTML generated from this component may vary by browser, and, as with any HTML  value created on the
 * client, we recommend values be sanitized on the server before  storing and displaying to other users.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("RichTextEditor")
public class RichTextEditor extends VLayout {

    public static RichTextEditor getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new RichTextEditor(jsObj);
        } else {
            assert refInstance instanceof RichTextEditor;
            return (RichTextEditor)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RichTextEditor.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.RichTextEditor.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(RichTextEditor.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.RichTextEditor.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public RichTextEditor(){
        scClassName = "RichTextEditor";
    }

    public RichTextEditor(JavaScriptObject jsObj){
        scClassName = "RichTextEditor";
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
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName alignCenter} control.
     *
     * @param alignCenterPrompt New alignCenterPrompt value. Default value is "Center selection"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setAlignCenterPrompt(String alignCenterPrompt) {
        return (RichTextEditor)setAttribute("alignCenterPrompt", alignCenterPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName alignCenter} control.
     *
     * @return Current alignCenterPrompt value. Default value is "Center selection"
     */
    public String getAlignCenterPrompt()  {
        return getAttributeAsString("alignCenterPrompt");
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName alignLeft} control.
     *
     * @param alignLeftPrompt New alignLeftPrompt value. Default value is "Left align selection"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setAlignLeftPrompt(String alignLeftPrompt) {
        return (RichTextEditor)setAttribute("alignLeftPrompt", alignLeftPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName alignLeft} control.
     *
     * @return Current alignLeftPrompt value. Default value is "Left align selection"
     */
    public String getAlignLeftPrompt()  {
        return getAttributeAsString("alignLeftPrompt");
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName alignRight} control.
     *
     * @param alignRightPrompt New alignRightPrompt value. Default value is "Right align selection"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setAlignRightPrompt(String alignRightPrompt) {
        return (RichTextEditor)setAttribute("alignRightPrompt", alignRightPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName alignRight} control.
     *
     * @return Current alignRightPrompt value. Default value is "Right align selection"
     */
    public String getAlignRightPrompt()  {
        return getAttributeAsString("alignRightPrompt");
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName backgroundColor} control.
     *
     * @param backgroundColorPrompt New backgroundColorPrompt value. Default value is "Set selection background color"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setBackgroundColorPrompt(String backgroundColorPrompt) {
        return (RichTextEditor)setAttribute("backgroundColorPrompt", backgroundColorPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName backgroundColor} control.
     *
     * @return Current backgroundColorPrompt value. Default value is "Set selection background color"
     */
    public String getBackgroundColorPrompt()  {
        return getAttributeAsString("backgroundColorPrompt");
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName boldSelection} control.
     *
     * @param boldSelectionPrompt New boldSelectionPrompt value. Default value is "Make selection bold"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setBoldSelectionPrompt(String boldSelectionPrompt) {
        return (RichTextEditor)setAttribute("boldSelectionPrompt", boldSelectionPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName boldSelection} control.
     *
     * @return Current boldSelectionPrompt value. Default value is "Make selection bold"
     */
    public String getBoldSelectionPrompt()  {
        return getAttributeAsString("boldSelectionPrompt");
    }
    

    /**
     * Default HTML list control group. Consists of an array of {@link com.smartgwt.client.types.ControlName}s and/or {@link
     * com.smartgwt.client.widgets.Canvas} instances. To display this group of controls for some RichTextEditor, include
     * <code>"bulletControls"</code> in the {@link com.smartgwt.client.widgets.RichTextEditor#getControlGroups controlGroups}
     * array.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param bulletControls New bulletControls value. Default value is ["indent", "outdent", "orderedList", "unorderedList", "listProperties"]
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RichTextEditor setBulletControls(ControlName... bulletControls)  throws IllegalStateException {
        return (RichTextEditor)setAttribute("bulletControls", bulletControls, false);
    }
    

    /**
     * Control group for modifying text color / background color.  Consists of an array of {@link
     * com.smartgwt.client.types.ControlName}s and/or {@link com.smartgwt.client.widgets.Canvas} instances. To display this
     * group of controls for some RichTextEditor, include <code>"formatControls"</code> in the {@link
     * com.smartgwt.client.widgets.RichTextEditor#getControlGroups controlGroups} array.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param colorControls New colorControls value. Default value is ["color", "backgroundColor"]
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RichTextEditor setColorControls(ControlName... colorControls)  throws IllegalStateException {
        return (RichTextEditor)setAttribute("colorControls", colorControls, false);
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName color} control.
     *
     * @param colorPrompt New colorPrompt value. Default value is "Set selection text color"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setColorPrompt(String colorPrompt) {
        return (RichTextEditor)setAttribute("colorPrompt", colorPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName color} control.
     *
     * @return Current colorPrompt value. Default value is "Set selection text color"
     */
    public String getColorPrompt()  {
        return getAttributeAsString("colorPrompt");
    }
    
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName copySelection} control.
     *
     * @param copySelectionPrompt New copySelectionPrompt value. Default value is "Copy Selection"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setCopySelectionPrompt(String copySelectionPrompt) {
        return (RichTextEditor)setAttribute("copySelectionPrompt", copySelectionPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName copySelection} control.
     *
     * @return Current copySelectionPrompt value. Default value is "Copy Selection"
     */
    public String getCopySelectionPrompt()  {
        return getAttributeAsString("copySelectionPrompt");
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName cutSelection} control.
     *
     * @param cutSelectionPrompt New cutSelectionPrompt value. Default value is "Cut Selection"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setCutSelectionPrompt(String cutSelectionPrompt) {
        return (RichTextEditor)setAttribute("cutSelectionPrompt", cutSelectionPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName cutSelection} control.
     *
     * @return Current cutSelectionPrompt value. Default value is "Cut Selection"
     */
    public String getCutSelectionPrompt()  {
        return getAttributeAsString("cutSelectionPrompt");
    }
    

    /**
     * The edit canvas created automatically for this RichTextEditor.
     * <p>
     * This component is an AutoChild named "editArea".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current editArea value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Canvas getEditArea() throws IllegalStateException {
        errorIfNotCreated("editArea");
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("editArea"));
    }
    

    /**
     * Background color for the {@link com.smartgwt.client.widgets.RichTextEditor#getEditArea edit canvas}.
     *
     * @param editAreaBackgroundColor New editAreaBackgroundColor value. Default value is "white"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RichTextEditor setEditAreaBackgroundColor(String editAreaBackgroundColor)  throws IllegalStateException {
        return (RichTextEditor)setAttribute("editAreaBackgroundColor", editAreaBackgroundColor, false);
    }

    /**
     * Background color for the {@link com.smartgwt.client.widgets.RichTextEditor#getEditArea edit canvas}.
     *
     * @return Current editAreaBackgroundColor value. Default value is "white"
     */
    public String getEditAreaBackgroundColor()  {
        return getAttributeAsString("editAreaBackgroundColor");
    }
    

    /**
     * Default font control group. Consists of an array of {@link com.smartgwt.client.types.ControlName}s and/or {@link
     * com.smartgwt.client.widgets.Canvas} instances. To display this group of controls for some RichTextEditor, include
     * <code>"fontControls"</code> in the {@link com.smartgwt.client.widgets.RichTextEditor#getControlGroups controlGroups}
     * array.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fontControls New fontControls value. Default value is ["fontSelector", "fontSizeSelector"]
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RichTextEditor setFontControls(ControlName... fontControls)  throws IllegalStateException {
        return (RichTextEditor)setAttribute("fontControls", fontControls, false);
    }
    
    

    /**
     * The {@link com.smartgwt.client.types.AutoChild} {@link com.smartgwt.client.widgets.form.fields.SelectItem} used for
     * choosing the font to apply to the current selection.
     * <p>
     * This component is an AutoChild named "fontSelectorItem".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current fontSelectorItem value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public SelectItem getFontSelectorItem() throws IllegalStateException {
        errorIfNotCreated("fontSelectorItem");
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("fontSelectorItem"));
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.widgets.RichTextEditor#getFontSelectorItem font selector}.
     *
     * @param fontSelectorPrompt New fontSelectorPrompt value. Default value is "Set Font..."
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setFontSelectorPrompt(String fontSelectorPrompt) {
        return (RichTextEditor)setAttribute("fontSelectorPrompt", fontSelectorPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.widgets.RichTextEditor#getFontSelectorItem font selector}.
     *
     * @return Current fontSelectorPrompt value. Default value is "Set Font..."
     */
    public String getFontSelectorPrompt()  {
        return getAttributeAsString("fontSelectorPrompt");
    }
    
    

    /**
     * The {@link com.smartgwt.client.types.AutoChild} {@link com.smartgwt.client.widgets.form.fields.SelectItem} used for
     * choosing the font-size to  apply to the current selection.
     * <p>
     * This component is an AutoChild named "fontSizeSelectorItem".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current fontSizeSelectorItem value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public SelectItem getFontSizeSelectorItem() throws IllegalStateException {
        errorIfNotCreated("fontSizeSelectorItem");
        return SelectItem.getOrCreateRef(getAttributeAsJavaScriptObject("fontSizeSelectorItem"));
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.widgets.RichTextEditor#getFontSizeSelectorItem font-size
     * selector}.
     *
     * @param fontSizeSelectorPrompt New fontSizeSelectorPrompt value. Default value is "Set Font Size..."
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setFontSizeSelectorPrompt(String fontSizeSelectorPrompt) {
        return (RichTextEditor)setAttribute("fontSizeSelectorPrompt", fontSizeSelectorPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.widgets.RichTextEditor#getFontSizeSelectorItem font-size
     * selector}.
     *
     * @return Current fontSizeSelectorPrompt value. Default value is "Set Font Size..."
     */
    public String getFontSizeSelectorPrompt()  {
        return getAttributeAsString("fontSizeSelectorPrompt");
    }
    

    /**
     * Default text formatting control group. Consists of an array of {@link com.smartgwt.client.types.ControlName}s and/or
     * {@link com.smartgwt.client.widgets.Canvas} instances. To display this group of controls for some RichTextEditor, include
     * <code>"formatControls"</code> in the {@link com.smartgwt.client.widgets.RichTextEditor#getControlGroups controlGroups}
     * array.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param formatControls New formatControls value. Default value is ["alignLeft", "alignRight", "alignCenter", "justify"]
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RichTextEditor setFormatControls(ControlName... formatControls)  throws IllegalStateException {
        return (RichTextEditor)setAttribute("formatControls", formatControls, false);
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName indent} control.
     *
     * @param indentPrompt New indentPrompt value. Default value is "Increase Indent"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setIndentPrompt(String indentPrompt) {
        return (RichTextEditor)setAttribute("indentPrompt", indentPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName indent} control.
     *
     * @return Current indentPrompt value. Default value is "Increase Indent"
     */
    public String getIndentPrompt()  {
        return getAttributeAsString("indentPrompt");
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName italicSelection} control.
     *
     * @param italicSelectionPrompt New italicSelectionPrompt value. Default value is "Make selection italic"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setItalicSelectionPrompt(String italicSelectionPrompt) {
        return (RichTextEditor)setAttribute("italicSelectionPrompt", italicSelectionPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName italicSelection} control.
     *
     * @return Current italicSelectionPrompt value. Default value is "Make selection italic"
     */
    public String getItalicSelectionPrompt()  {
        return getAttributeAsString("italicSelectionPrompt");
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName justify} control.
     *
     * @param justifyPrompt New justifyPrompt value. Default value is "Full justify selection"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setJustifyPrompt(String justifyPrompt) {
        return (RichTextEditor)setAttribute("justifyPrompt", justifyPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName justify} control.
     *
     * @return Current justifyPrompt value. Default value is "Full justify selection"
     */
    public String getJustifyPrompt()  {
        return getAttributeAsString("justifyPrompt");
    }
    

    /**
     * Dialog shown when the {@link com.smartgwt.client.types.ControlName "listProperties" control} is pressed. Provides
     * options for the user to control formatting of lists.
     * <p>
     * This component is an AutoChild named "listPropertiesDialog".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current listPropertiesDialog value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ListPropertiesDialog getListPropertiesDialog() throws IllegalStateException {
        errorIfNotCreated("listPropertiesDialog");
        return (ListPropertiesDialog)ListPropertiesDialog.getByJSObject(getAttributeAsJavaScriptObject("listPropertiesDialog"));
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName listProperties} control.
     *
     * @param listPropertiesPrompt New listPropertiesPrompt value. Default value is "Configure the list"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setListPropertiesPrompt(String listPropertiesPrompt) {
        return (RichTextEditor)setAttribute("listPropertiesPrompt", listPropertiesPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName listProperties} control.
     *
     * @return Current listPropertiesPrompt value. Default value is "Configure the list"
     */
    public String getListPropertiesPrompt()  {
        return getAttributeAsString("listPropertiesPrompt");
    }
    

    /**
     * The warning message displayed in a dialog when a user tries to configure a list without first putting the cursor in an
     * appropriate place.
     *
     * @param listPropertiesWarningText New listPropertiesWarningText value. Default value is "Place the cursor within a list to configure it"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setListPropertiesWarningText(String listPropertiesWarningText) {
        return (RichTextEditor)setAttribute("listPropertiesWarningText", listPropertiesWarningText, true);
    }

    /**
     * The warning message displayed in a dialog when a user tries to configure a list without first putting the cursor in an
     * appropriate place.
     *
     * @return Current listPropertiesWarningText value. Default value is "Place the cursor within a list to configure it"
     */
    public String getListPropertiesWarningText()  {
        return getAttributeAsString("listPropertiesWarningText");
    }
    

    /**
     * If the user presses the "Tab" key, should focus be taken from this editor? If set to <code>false</code> a "Tab" keypress
     * will cause a Tab character to be inserted into the text, and focus will be left in the edit area.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.RichTextEditor#getMoveFocusOnTab moveFocusOnTab}.
     *
     * @param moveFocusOnTab new value for moveFocusOnTab. Default value is true
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setMoveFocusOnTab(boolean moveFocusOnTab) {
        return (RichTextEditor)setAttribute("moveFocusOnTab", moveFocusOnTab, true);
    }

    /**
     * If the user presses the "Tab" key, should focus be taken from this editor? If set to <code>false</code> a "Tab" keypress
     * will cause a Tab character to be inserted into the text, and focus will be left in the edit area.
     *
     * @return Current moveFocusOnTab value. Default value is true
     */
    public boolean getMoveFocusOnTab()  {
        Boolean result = getAttributeAsBoolean("moveFocusOnTab");
        return result == null ? true : result;
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName orderedList} control.
     *
     * @param orderedListPrompt New orderedListPrompt value. Default value is "Convert to a numbered list"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setOrderedListPrompt(String orderedListPrompt) {
        return (RichTextEditor)setAttribute("orderedListPrompt", orderedListPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName orderedList} control.
     *
     * @return Current orderedListPrompt value. Default value is "Convert to a numbered list"
     */
    public String getOrderedListPrompt()  {
        return getAttributeAsString("orderedListPrompt");
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName outdent} control.
     *
     * @param outdentPrompt New outdentPrompt value. Default value is "Decrease Indent"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setOutdentPrompt(String outdentPrompt) {
        return (RichTextEditor)setAttribute("outdentPrompt", outdentPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName outdent} control.
     *
     * @return Current outdentPrompt value. Default value is "Decrease Indent"
     */
    public String getOutdentPrompt()  {
        return getAttributeAsString("outdentPrompt");
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName pasteSelection} control.
     *
     * @param pasteSelectionPrompt New pasteSelectionPrompt value. Default value is "Paste"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setPasteSelectionPrompt(String pasteSelectionPrompt) {
        return (RichTextEditor)setAttribute("pasteSelectionPrompt", pasteSelectionPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName pasteSelection} control.
     *
     * @return Current pasteSelectionPrompt value. Default value is "Paste"
     */
    public String getPasteSelectionPrompt()  {
        return getAttributeAsString("pasteSelectionPrompt");
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName strikethroughSelection} control.
     *
     * @param strikethroughSelectionPrompt New strikethroughSelectionPrompt value. Default value is "Strike through selection"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setStrikethroughSelectionPrompt(String strikethroughSelectionPrompt) {
        return (RichTextEditor)setAttribute("strikethroughSelectionPrompt", strikethroughSelectionPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName strikethroughSelection} control.
     *
     * @return Current strikethroughSelectionPrompt value. Default value is "Strike through selection"
     */
    public String getStrikethroughSelectionPrompt()  {
        return getAttributeAsString("strikethroughSelectionPrompt");
    }
    

    /**
     * Default text styling control group. Consists of an array of {@link com.smartgwt.client.types.ControlName}s and/or {@link
     * com.smartgwt.client.widgets.Canvas} instances. To display this group of controls for some RichTextEditor, include
     * <code>"styleControls"</code> in the {@link com.smartgwt.client.widgets.RichTextEditor#getControlGroups controlGroups}
     * array.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param styleControls New styleControls value. Default value is ["boldSelection", "italicSelection", "underlineSelection"]
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RichTextEditor setStyleControls(ControlName... styleControls)  throws IllegalStateException {
        return (RichTextEditor)setAttribute("styleControls", styleControls, false);
    }
    

    /**
     * When true, applies style attributes in markup instead of presentation elements.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param styleWithCSS New styleWithCSS value. Default value is null
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RichTextEditor setStyleWithCSS(Boolean styleWithCSS)  throws IllegalStateException {
        return (RichTextEditor)setAttribute("styleWithCSS", styleWithCSS, false);
    }

    /**
     * When true, applies style attributes in markup instead of presentation elements.
     *
     * @return Current styleWithCSS value. Default value is null
     */
    public Boolean getStyleWithCSS()  {
        return getAttributeAsBoolean("styleWithCSS");
    }
    

    /**
     * Layout used to contain all of the {@link com.smartgwt.client.widgets.RichTextEditor#getToolbar toolbar} AutoChildren 
     * that contain the {@link com.smartgwt.client.widgets.RichTextEditor#getControlGroups controlGroups}.
     * <p>
     * This component is an AutoChild named "toolArea".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current toolArea value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Layout getToolArea() throws IllegalStateException {
        errorIfNotCreated("toolArea");
        return (Layout)Layout.getByJSObject(getAttributeAsJavaScriptObject("toolArea"));
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * Layout used to contain each of the {@link com.smartgwt.client.widgets.RichTextEditor#getControlGroups controlGroups}.
     *
     * @return null
     */
    public Layout getToolbar()  {
        return null;
    }
    

    /**
     * The background color for the toolbar.
     *
     * @param toolbarBackgroundColor New toolbarBackgroundColor value. Default value is "#CCCCCC"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RichTextEditor setToolbarBackgroundColor(String toolbarBackgroundColor)  throws IllegalStateException {
        return (RichTextEditor)setAttribute("toolbarBackgroundColor", toolbarBackgroundColor, false);
    }

    /**
     * The background color for the toolbar.
     *
     * @return Current toolbarBackgroundColor value. Default value is "#CCCCCC"
     */
    public String getToolbarBackgroundColor()  {
        return getAttributeAsString("toolbarBackgroundColor");
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName underlineSelection} control.
     *
     * @param underlineSelectionPrompt New underlineSelectionPrompt value. Default value is "Make selection underlined"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setUnderlineSelectionPrompt(String underlineSelectionPrompt) {
        return (RichTextEditor)setAttribute("underlineSelectionPrompt", underlineSelectionPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName underlineSelection} control.
     *
     * @return Current underlineSelectionPrompt value. Default value is "Make selection underlined"
     */
    public String getUnderlineSelectionPrompt()  {
        return getAttributeAsString("underlineSelectionPrompt");
    }
    

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName unorderedList} control.
     *
     * @param unorderedListPrompt New unorderedListPrompt value. Default value is "Convert to a bullet list"
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setUnorderedListPrompt(String unorderedListPrompt) {
        return (RichTextEditor)setAttribute("unorderedListPrompt", unorderedListPrompt, true);
    }

    /**
     * The prompt for the built-in {@link com.smartgwt.client.types.ControlName unorderedList} control.
     *
     * @return Current unorderedListPrompt value. Default value is "Convert to a bullet list"
     */
    public String getUnorderedListPrompt()  {
        return getAttributeAsString("unorderedListPrompt");
    }
    

    /**
     * Should this editor use a separate IFRAME with special cross-browser support for editing  HTML content?  In Smart GWT
     * versions 13.0 and later, this feature is switched off on account of better modern browser support for contentEditable
     * containers.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param useDesignMode New useDesignMode value. Default value is false
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public RichTextEditor setUseDesignMode(Boolean useDesignMode)  throws IllegalStateException {
        return (RichTextEditor)setAttribute("useDesignMode", useDesignMode, false);
    }

    /**
     * Should this editor use a separate IFRAME with special cross-browser support for editing  HTML content?  In Smart GWT
     * versions 13.0 and later, this feature is switched off on account of better modern browser support for contentEditable
     * containers.
     *
     * @return Current useDesignMode value. Default value is false
     */
    public Boolean getUseDesignMode()  {
        Boolean result = getAttributeAsBoolean("useDesignMode");
        return result == null ? false : result;
    }
    

    /**
     * Initial value for the edit area.    Use <code>getValue()</code> and  <code>setValue()</code> to update at runtime.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Updates the current value of the edit area.
     *
     * @param value New value value. Default value is ""
     * @return {@link com.smartgwt.client.widgets.RichTextEditor RichTextEditor} instance, for chaining setter calls
     */
    public RichTextEditor setValue(String value) {
        return (RichTextEditor)setAttribute("value", value, true);
    }

    /**
     * Initial value for the edit area.    Use <code>getValue()</code> and  <code>setValue()</code> to update at runtime.
     *
     * @return Retrieves the current value of the edit area. Default value is ""
     */
    public String getValue()  {
        return getAttributeAsString("value");
    }
    

    // ********************* Methods ***********************
	/**
     * Display a warning if Rich Text Editing is not fully supported in this browser. Default behavior logs a warning to the
     * developer console - Override this if a user-visible warning is required
     */
    public native void doWarn() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "doWarn", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.doWarn();
    }-*/;

	/**
     * Does this browser support the full RichTextEditor feature set. Returns false for browsers in which some features are not
     * natively supported (Safari before version 3.1 and Opera before version 9.50).
     *
     * @return false if this browser doesn't fully support RichTextEditing
     */
    public native Boolean richEditorSupported() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "richEditorSupported", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.richEditorSupported();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
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
     * @param richTextEditorProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(RichTextEditor richTextEditorProperties) /*-{
        if (richTextEditorProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(RichTextEditor.@java.lang.Object::getClass()(), "setDefaultProperties", richTextEditorProperties.@java.lang.Object::getClass()());
        }
        richTextEditorProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = richTextEditorProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.RichTextEditor.addProperties(properties);
    }-*/;

    // ***********************************************************



    private static boolean areControlTypesValid(Object... controls) {
        if (controls == null) return true;
        for (final Object control : controls) {
            if (!(control instanceof String) &&
                !(control instanceof ControlName) &&
                !(control instanceof Canvas))
            {
                return false;
            }
        }
        return true;
    }

    private static boolean areControlGroupTypesValid(Object... controlGroups) {
        if (controlGroups == null) return true;
        for (final Object controlGroup : controlGroups) {
            if (!(controlGroup instanceof String) &&
                !(controlGroup instanceof StandardControlGroup) &&
                !(controlGroup instanceof Canvas))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * An array of control group names specifying which groups of controls should be included in the editor tool area.
     * The special string "break" may also be included in this array to cause the subsequent
     * control groups to continue onto a new line.
     *
     * @param controlGroups the control groups. Default is ["fontControls", "formatControls", "styleControls",
     *                      "colorControls"]
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setControlGroups(String... controlGroups) {
        setAttribute("controlGroups", controlGroups, false);
    }

    /**
     * An array of control groups specifying which groups of controls should be included in the
     * editor tool area. The values of this array may be a {@link com.smartgwt.client.types.StandardControlGroup} enum value,
     * the name of a control group (String), a {@link com.smartgwt.client.widgets.Canvas}, or
     * the special string "break" which causes the subsequent control groups to continue onto
     * a new line.
     *
     * @param controlGroups the control groups. Default is [
     * {@link com.smartgwt.client.types.StandardControlGroup#FONTCONTROLS FONTCONTROLS},
     * {@link com.smartgwt.client.types.StandardControlGroup#FORMATCONTROLS FORMATCONTROLS},
     * {@link com.smartgwt.client.types.StandardControlGroup#STYLECONTROLS STYLECONTROLS},
     * {@link com.smartgwt.client.types.StandardControlGroup#COLORCONTROLS COLORCONTROLS}].
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setControlGroups(Object... controlGroups) throws IllegalStateException {
        assert areControlGroupTypesValid(controlGroups) : "Illegal controlGroups array. The controlGroups array can only consist of Strings, StandardControlGroup values, and Canvas instances.";
        setAttribute("controlGroups", controlGroups, false);
    }

	/**
	 * Use this signature if you plan to pass a mixture of standard ControlNames and custom
     * widgets (any subclass of Canvas is allowed):
	 * {@link com.smartgwt.client.widgets.RichTextEditor#setBulletControls(com.smartgwt.client.types.ControlName...) setBulletControls(ControlName... bulletControls)}
	 */
    public void setBulletControls(Object... bulletControls) throws IllegalStateException {
        assert areControlTypesValid(bulletControls) : "Illegal bulletControls array. The bulletControls array can only consist of Strings, ControlName values, and Canvas instances.";
        setAttribute("bulletControls", bulletControls, false);
    }

	/**
	 * Use this signature if you plan to pass a mixture of standard ControlNames and custom
     * widgets (any subclass of Canvas is allowed):
	 * {@link com.smartgwt.client.widgets.RichTextEditor#setColorControls(com.smartgwt.client.types.ControlName...) setColorControls(ControlName... colorControls)}
	 */
    public void setColorControls(Object... colorControls) throws IllegalStateException {
        assert areControlTypesValid(colorControls) : "Illegal colorControls array. The colorControls array can only consist of Strings, ControlName values, and Canvas instances.";
        setAttribute("colorControls", colorControls, false);
    }

	/**
	 * Use this signature if you plan to pass a mixture of standard ControlNames and custom
     * widgets (any subclass of Canvas is allowed):
	 * {@link com.smartgwt.client.widgets.RichTextEditor#setFontControls(com.smartgwt.client.types.ControlName...) setFontControls(ControlName... fontControls)}
	 */
    public void setFontControls(Object... fontControls) throws IllegalStateException {
        assert areControlTypesValid(fontControls) : "Illegal fontControls array. The fontControls array can only consist of Strings, ControlName values, and Canvas instances.";
        setAttribute("fontControls", fontControls, false);
    }

	/**
	 * Use this signature if you plan to pass a mixture of standard ControlNames and custom
     * widgets (any subclass of Canvas is allowed):
	 * {@link com.smartgwt.client.widgets.RichTextEditor#setFormatControls(com.smartgwt.client.types.ControlName...) setFormatControls(ControlName... formatControls)}
	 */
    public void setFormatControls(Object... formatControls) throws IllegalStateException {
        assert areControlTypesValid(formatControls) : "Illegal formatControls array. The formatControls array can only consist of Strings, ControlName values, and Canvas instances.";
        setAttribute("formatControls", formatControls, false);
    }

	/**
	 * Use this signature if you plan to pass a mixture of standard ControlNames and custom
     * widgets (any subclass of Canvas is allowed):
	 * {@link com.smartgwt.client.widgets.RichTextEditor#setStyleControls(com.smartgwt.client.types.ControlName...) setStyleControls(ControlName... styleControls)}
	 */
    public void setStyleControls(Object... styleControls) throws IllegalStateException {
        assert areControlTypesValid(styleControls) : "Illegal styleControls array. The styleControls array can only consist of Strings, ControlName values, and Canvas instances.";
        setAttribute("styleControls", styleControls, false);
    }

    /**
     * ValueMap of CSS fontName properties to font name titles to display in the font selector
     * for the {@link com.smartgwt.client.types.ControlName#FONTSELECTOR FONTSELECTOR} control.
     * @return the current fontNames valueMap
     */
    @SuppressWarnings("unchecked")
    public final Map<String, String> getFontNames() {
        return (Map<String, String>)getAttributeAsMap("fontNames");
    }

    /**
     * ValueMap of CSS fontName properties to font name titles to display in the font selector
     * for the {@link com.smartgwt.client.types.ControlName#FONTSELECTOR FONTSELECTOR} control.
     * @param fontNames the new ValueMap
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFontNames(LinkedHashMap<String, String> fontNames) throws IllegalStateException {
        setAttribute("fontNames", fontNames, false);
    }

    /**
     * ValueMap of CSS font size property values to font size titles to display in the font size selector
     * for the {@link com.smartgwt.client.types.ControlName#FONTSIZESELECTOR FONTSIZESELECTOR} control.
     * @return the current fontNames valueMap
     */
    @SuppressWarnings("unchecked")
    public final Map<String, String> getFontSizes() {
        return (Map<String, String>)getAttributeAsMap("fontSizes");
    }

    /**
     * ValueMap of CSS font size property values to font size titles to display in the font size selector
     * for the {@link com.smartgwt.client.types.ControlName#FONTSIZESELECTOR FONTSIZESELECTOR} control.
     * @param fontSizes the new ValueMap
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFontSizes(LinkedHashMap<String, String> fontSizes) throws IllegalStateException {
        setAttribute("fontSizes", fontSizes, false);
    }

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(RichTextEditorLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.alignCenterPrompt = getAttributeAsString("alignCenterPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.alignCenterPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.alignLeftPrompt = getAttributeAsString("alignLeftPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.alignLeftPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.alignRightPrompt = getAttributeAsString("alignRightPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.alignRightPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.backgroundColorPrompt = getAttributeAsString("backgroundColorPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.backgroundColorPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.boldSelectionPrompt = getAttributeAsString("boldSelectionPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.boldSelectionPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.colorPrompt = getAttributeAsString("colorPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.colorPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.copySelectionPrompt = getAttributeAsString("copySelectionPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.copySelectionPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.cutSelectionPrompt = getAttributeAsString("cutSelectionPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.cutSelectionPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.editAreaBackgroundColor = getAttributeAsString("editAreaBackgroundColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.editAreaBackgroundColor:" + t.getMessage() + "\n";
        }
        try {
            s.fontSelectorPrompt = getAttributeAsString("fontSelectorPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.fontSelectorPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.fontSizeSelectorPrompt = getAttributeAsString("fontSizeSelectorPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.fontSizeSelectorPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.indentPrompt = getAttributeAsString("indentPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.indentPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.italicSelectionPrompt = getAttributeAsString("italicSelectionPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.italicSelectionPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.justifyPrompt = getAttributeAsString("justifyPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.justifyPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.listPropertiesPrompt = getAttributeAsString("listPropertiesPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.listPropertiesPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.listPropertiesWarningText = getAttributeAsString("listPropertiesWarningText");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.listPropertiesWarningText:" + t.getMessage() + "\n";
        }
        try {
            s.moveFocusOnTab = getAttributeAsString("moveFocusOnTab");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.moveFocusOnTab:" + t.getMessage() + "\n";
        }
        try {
            s.orderedListPrompt = getAttributeAsString("orderedListPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.orderedListPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.outdentPrompt = getAttributeAsString("outdentPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.outdentPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.pasteSelectionPrompt = getAttributeAsString("pasteSelectionPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.pasteSelectionPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.strikethroughSelectionPrompt = getAttributeAsString("strikethroughSelectionPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.strikethroughSelectionPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.styleWithCSS = getAttributeAsString("styleWithCSS");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.styleWithCSS:" + t.getMessage() + "\n";
        }
        try {
            s.toolbarBackgroundColor = getAttributeAsString("toolbarBackgroundColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.toolbarBackgroundColor:" + t.getMessage() + "\n";
        }
        try {
            s.underlineSelectionPrompt = getAttributeAsString("underlineSelectionPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.underlineSelectionPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.unorderedListPrompt = getAttributeAsString("unorderedListPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.unorderedListPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.useDesignMode = getAttributeAsString("useDesignMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.useDesignMode:" + t.getMessage() + "\n";
        }
        try {
            s.value = getAttributeAsString("value");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.value:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        RichTextEditorLogicalStructure s = new RichTextEditorLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
