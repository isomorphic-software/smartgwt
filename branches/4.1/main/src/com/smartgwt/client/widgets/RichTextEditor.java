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
 * RichTextEditing component.  Provides a rich-text editing area along with UI for executing rich-text commands on the
 * text.<br> The HTML generated from this component may vary by browser, and, as with any HTML  value created on the
 * client, we recommend values be sanitized on the server before  storing and displaying to other users.<br> Note: This
 * component has limited support on the Safari browser.
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
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.RichTextEditor.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.RichTextEditor.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
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
     * Default HTML list control group. Consists of an array of {@link com.smartgwt.client.types.ControlName}s and/or {@link
     * com.smartgwt.client.widgets.Canvas} instances. To display this group of controls for some RichTextEditor, include
     * <code>"bulletControls"</code> in the {@link com.smartgwt.client.widgets.RichTextEditor#getControlGroups controlGroups}
     * array.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param bulletControls  Default value is ["indent", "outdent", "orderedList", "unorderedList", "listProperties"]
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBulletControls(ControlName... bulletControls)  throws IllegalStateException {
        setAttribute("bulletControls", bulletControls, false);
    }

    /**
     * Control group for modifying text color / background color.  Consists of an array of {@link
     * com.smartgwt.client.types.ControlName}s and/or {@link com.smartgwt.client.widgets.Canvas} instances. To display this
     * group of controls for some RichTextEditor, include <code>"formatControls"</code> in the {@link
     * com.smartgwt.client.widgets.RichTextEditor#getControlGroups controlGroups} array.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param colorControls  Default value is ["color", "backgroundColor"]
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setColorControls(ControlName... colorControls)  throws IllegalStateException {
        setAttribute("colorControls", colorControls, false);
    }

    /**
     * Default font control group. Consists of an array of {@link com.smartgwt.client.types.ControlName}s and/or {@link
     * com.smartgwt.client.widgets.Canvas} instances. To display this group of controls for some RichTextEditor, include
     * <code>"fontControls"</code> in the {@link com.smartgwt.client.widgets.RichTextEditor#getControlGroups controlGroups}
     * array.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param fontControls  Default value is ["fontSelector", "fontSizeSelector"]
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFontControls(ControlName... fontControls)  throws IllegalStateException {
        setAttribute("fontControls", fontControls, false);
    }

    /**
     * Default text formatting control group. Consists of an array of {@link com.smartgwt.client.types.ControlName}s and/or
     * {@link com.smartgwt.client.widgets.Canvas} instances. To display this group of controls for some RichTextEditor, include
     * <code>"formatControls"</code> in the {@link com.smartgwt.client.widgets.RichTextEditor#getControlGroups controlGroups}
     * array.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param formatControls  Default value is ["alignLeft", "alignRight", "alignCenter", "justify"]
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFormatControls(ControlName... formatControls)  throws IllegalStateException {
        setAttribute("formatControls", formatControls, false);
    }

    /**
     * Dialog shown when the {@link com.smartgwt.client.types.ControlName "listProperties" control} is pressed. Provides
     * options for the user to control formatting of lists.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return ListPropertiesDialog
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public ListPropertiesDialog getListPropertiesDialog() throws IllegalStateException {
        errorIfNotCreated("listPropertiesDialog");
        return (ListPropertiesDialog)ListPropertiesDialog.getByJSObject(getAttributeAsJavaScriptObject("listPropertiesDialog"));
    }

    /**
     * If the user presses the "Tab" key, should focus be taken from this editor? If set to <code>false</code> a "Tab" keypress
     * will cause a Tab character to be inserted into the text, and focus will be left in the edit area.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.RichTextEditor#getMoveFocusOnTab moveFocusOnTab}.
     *
     * @param moveFocusOnTab new value for moveFocusOnTab. Default value is true
     */
    public void setMoveFocusOnTab(boolean moveFocusOnTab) {
        setAttribute("moveFocusOnTab", moveFocusOnTab, true);
    }

    /**
     * If the user presses the "Tab" key, should focus be taken from this editor? If set to <code>false</code> a "Tab" keypress
     * will cause a Tab character to be inserted into the text, and focus will be left in the edit area.
     *
     * @return boolean
     */
    public boolean getMoveFocusOnTab()  {
        return getAttributeAsBoolean("moveFocusOnTab");
    }

    /**
     * Default text styling control group. Consists of an array of {@link com.smartgwt.client.types.ControlName}s and/or {@link
     * com.smartgwt.client.widgets.Canvas} instances. To display this group of controls for some RichTextEditor, include
     * <code>"styleControls"</code> in the {@link com.smartgwt.client.widgets.RichTextEditor#getControlGroups controlGroups}
     * array.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param styleControls  Default value is ["boldSelection", "italicSelection", "underlineSelection"]
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStyleControls(ControlName... styleControls)  throws IllegalStateException {
        setAttribute("styleControls", styleControls, false);
    }

    /**
     * The background color for the toolbar.
     *
     * @param toolbarBackgroundColor  Default value is "#CCCCCC"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setToolbarBackgroundColor(String toolbarBackgroundColor)  throws IllegalStateException {
        setAttribute("toolbarBackgroundColor", toolbarBackgroundColor, false);
    }

    /**
     * The background color for the toolbar.
     *
     * @return String
     */
    public String getToolbarBackgroundColor()  {
        return getAttributeAsString("toolbarBackgroundColor");
    }

    /**
     * Initial value for the edit area.    Use <code>getValue()</code> and  <code>setValue()</code> to update at runtime.
     *
     * <p>If this method is called after the component has been drawn/initialized:
     * Updates the current value of the edit area.
     *
     * @param value  Default value is ""
     */
    public void setValue(String value) {
        setAttribute("value", value, true);
    }

    /**
     * Initial value for the edit area.    Use <code>getValue()</code> and  <code>setValue()</code> to update at runtime.
     *
     * @return Retrieves the current value of the edit area.
     */
    public String getValue()  {
        return getAttributeAsString("value");
    }

    // ********************* Methods ***********************
	/**
     * Display a warning if Rich Text Editing is not fully supported in this browser. Default behavior logs a warning to the
     * devloper console - Override this if a user-visible warning is required
     */
    public native void doWarn() /*-{
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
     */
    public static native void setDefaultProperties(RichTextEditor richTextEditorProperties) /*-{
    	var properties = $wnd.isc.addProperties({},richTextEditorProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
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

    public void setBulletControls(Object... bulletControls) throws IllegalStateException {
        assert areControlTypesValid(bulletControls) : "Illegal bulletControls array. The bulletControls array can only consist of Strings, ControlName values, and Canvas instances.";
        setAttribute("bulletControls", bulletControls, false);
    }

    public void setColorControls(Object... colorControls) throws IllegalStateException {
        assert areControlTypesValid(colorControls) : "Illegal colorControls array. The colorControls array can only consist of Strings, ControlName values, and Canvas instances.";
        setAttribute("colorControls", colorControls, false);
    }

    public void setFontControls(Object... fontControls) throws IllegalStateException {
        assert areControlTypesValid(fontControls) : "Illegal fontControls array. The fontControls array can only consist of Strings, ControlName values, and Canvas instances.";
        setAttribute("fontControls", fontControls, false);
    }

    public void setFormatControls(Object... formatControls) throws IllegalStateException {
        assert areControlTypesValid(formatControls) : "Illegal formatControls array. The formatControls array can only consist of Strings, ControlName values, and Canvas instances.";
        setAttribute("formatControls", formatControls, false);
    }

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

    public LogicalStructureObject setLogicalStructure(RichTextEditorLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.moveFocusOnTab = getAttributeAsString("moveFocusOnTab");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.moveFocusOnTab:" + t.getMessage() + "\n";
        }
        try {
            s.toolbarBackgroundColor = getAttributeAsString("toolbarBackgroundColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.toolbarBackgroundColor:" + t.getMessage() + "\n";
        }
        try {
            s.value = getAttributeAsString("value");
        } catch (Throwable t) {
            s.logicalStructureErrors += "RichTextEditor.value:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        RichTextEditorLogicalStructure s = new RichTextEditorLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

