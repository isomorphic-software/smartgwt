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
 
package com.smartgwt.client.widgets.grid;


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
 * A widget for editing a single, advanced {@link com.smartgwt.client.widgets.grid.HiliteRule hilite rule} for use by  
 * {@link com.smartgwt.client.widgets.DataBoundComponent dataBoundComponents}.  Where a simple hilite provides  
 * configuration of a single criterion and either foreground or background color for   application to a single field, an
 * advanced hilite can specify more complex criteria which can  both test and affect multiple fields and allow both
 * background and foreground colors to  be specified in a single rule.  <P> <i><b>Important Note:</b> this class should not
 * be used directly - it is exposed purely for {@link i18nMessages i18n reasons.}</i>
 */
public class AdvancedHiliteEditor extends VLayout {

    public native static AdvancedHiliteEditor getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("AdvancedHiliteEditor",jsObj);
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
        $wnd.isc["AdvancedHiliteEditor"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc["AdvancedHiliteEditor"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public AdvancedHiliteEditor(){
        scClassName = "AdvancedHiliteEditor";
    }

    public AdvancedHiliteEditor(JavaScriptObject jsObj){
        scClassName = "AdvancedHiliteEditor";
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
     * The title for the Appearance group.
     *
     * @param appearanceGroupTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Appearance"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAppearanceGroupTitle(String appearanceGroupTitle)  throws IllegalStateException {
        setAttribute("appearanceGroupTitle", appearanceGroupTitle, false);
    }

    /**
     * The title for the Appearance group.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getAppearanceGroupTitle()  {
        return getAttributeAsString("appearanceGroupTitle");
    }


    /**
     * The callback to fire when the {@link com.smartgwt.client.widgets.grid.AdvancedHiliteEditor#getSaveButton saveButton} is
     * clicked.
     *
     * @param callback . See {@link com.smartgwt.client.docs.Callback Callback}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCallback(String callback)  throws IllegalStateException {
        setAttribute("callback", callback, false);
    }

    /**
     * The callback to fire when the {@link com.smartgwt.client.widgets.grid.AdvancedHiliteEditor#getSaveButton saveButton} is
     * clicked.
     *
     * @return . See {@link com.smartgwt.client.docs.Callback Callback}
     */
    public String getCallback()  {
        return getAttributeAsString("callback");
    }



    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.AdvancedHiliteEditor#getCancelButton cancelButton}.
     *
     * @param cancelButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Cancel"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.AdvancedHiliteEditor#getCancelButton cancelButton}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }



    /**
     * The title for the Filter group.
     *
     * @param filterGroupTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Filter"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setFilterGroupTitle(String filterGroupTitle)  throws IllegalStateException {
        setAttribute("filterGroupTitle", filterGroupTitle, false);
    }

    /**
     * The title for the Filter group.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getFilterGroupTitle()  {
        return getAttributeAsString("filterGroupTitle");
    }



    /**
     * Specifies a list of icons that can be used in hilites. <P> <code>hiliteIcons</code> should be specified as an Array of
     * SCImgURL. When present, {@link com.smartgwt.client.widgets.grid.HiliteRule hilite rules} will offer the user a drop down
     * for picking one of these icons. <P> If the user picks an icon, the created hiliting rule will have {@link
     * com.smartgwt.client.data.Hilite#getIcon icon} set to  the chosen icon.  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconPosition hiliteIconPosition} controls where the icon will 
     * appear for that field -- the default is that it appears in front of the normal cell content.
     *
     * @param hiliteIcons . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is null
     */
    public void setHiliteIcons(String... hiliteIcons) {
        setAttribute("hiliteIcons", hiliteIcons, true);
    }

    /**
     * Specifies a list of icons that can be used in hilites. <P> <code>hiliteIcons</code> should be specified as an Array of
     * SCImgURL. When present, {@link com.smartgwt.client.widgets.grid.HiliteRule hilite rules} will offer the user a drop down
     * for picking one of these icons. <P> If the user picks an icon, the created hiliting rule will have {@link
     * com.smartgwt.client.data.Hilite#getIcon icon} set to  the chosen icon.  {@link
     * com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconPosition hiliteIconPosition} controls where the icon will 
     * appear for that field -- the default is that it appears in front of the normal cell content.
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     */
    public String[] getHiliteIcons()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("hiliteIcons"));
    }


    /**
     * The message to show when the user clicks "Save" without entering any criteria.
     *
     * @param invalidHilitePrompt . See {@link com.smartgwt.client.docs.String String}. Default value is "Enter at least one rule, a color or icon, and a target field, or press 'Cancel' to abandon changes."
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setInvalidHilitePrompt(String invalidHilitePrompt)  throws IllegalStateException {
        setAttribute("invalidHilitePrompt", invalidHilitePrompt, false);
    }

    /**
     * The message to show when the user clicks "Save" without entering any criteria.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getInvalidHilitePrompt()  {
        return getAttributeAsString("invalidHilitePrompt");
    }



    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.AdvancedHiliteEditor#getSaveButton saveButton}.
     *
     * @param saveButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Save"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSaveButtonTitle(String saveButtonTitle)  throws IllegalStateException {
        setAttribute("saveButtonTitle", saveButtonTitle, false);
    }

    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.AdvancedHiliteEditor#getSaveButton saveButton}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getSaveButtonTitle()  {
        return getAttributeAsString("saveButtonTitle");
    }


    /**
     * The title for the Target Field(s) picker.
     *
     * @param targetFieldsItemTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Target Field(s)"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTargetFieldsItemTitle(String targetFieldsItemTitle)  throws IllegalStateException {
        setAttribute("targetFieldsItemTitle", targetFieldsItemTitle, false);
    }

    /**
     * The title for the Target Field(s) picker.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getTargetFieldsItemTitle()  {
        return getAttributeAsString("targetFieldsItemTitle");
    }


    /**
     * The title text shown in the header bar of this editor's dialog.
     *
     * @param title . See {@link com.smartgwt.client.docs.String String}. Default value is "Advanced Hilite Editor"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTitle(String title)  throws IllegalStateException {
        setAttribute("title", title, false);
    }

    /**
     * The title text shown in the header bar of this editor's dialog.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }

    // ********************* Methods ***********************
	/**
     * Discard changes and fire the {@link com.smartgwt.client.widgets.grid.AdvancedHiliteEditor#getCallback callback} with a
     * null  parameter.
     */
    public native void cancelEditing() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancelEditing();
    }-*/;
	/**
     * Save changes and fire the {@link com.smartgwt.client.widgets.grid.AdvancedHiliteEditor#getCallback callback}.
     */
    public native void saveHilite() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveHilite();
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
     * @param advancedHiliteEditorProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(AdvancedHiliteEditor advancedHiliteEditorProperties) /*-{
    	var properties = $wnd.isc.addProperties({},advancedHiliteEditorProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.AdvancedHiliteEditor.addProperties(properties);
    }-*/;

    // ***********************************************************

    public LogicalStructureObject setLogicalStructure(AdvancedHiliteEditorLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.appearanceGroupTitle = getAttributeAsString("appearanceGroupTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdvancedHiliteEditor.appearanceGroupTitle:" + t.getMessage() + "\n";
        }
        try {
            s.callback = getAttributeAsString("callback");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdvancedHiliteEditor.callback:" + t.getMessage() + "\n";
        }
        try {
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdvancedHiliteEditor.cancelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.filterGroupTitle = getAttributeAsString("filterGroupTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdvancedHiliteEditor.filterGroupTitle:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteIcons = getAttributeAsStringArray("hiliteIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdvancedHiliteEditor.hiliteIconsArray:" + t.getMessage() + "\n";
        }
        try {
            s.invalidHilitePrompt = getAttributeAsString("invalidHilitePrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdvancedHiliteEditor.invalidHilitePrompt:" + t.getMessage() + "\n";
        }
        try {
            s.saveButtonTitle = getAttributeAsString("saveButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdvancedHiliteEditor.saveButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.targetFieldsItemTitle = getAttributeAsString("targetFieldsItemTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdvancedHiliteEditor.targetFieldsItemTitle:" + t.getMessage() + "\n";
        }
        try {
            s.title = getAttributeAsString("title");
        } catch (Throwable t) {
            s.logicalStructureErrors += "AdvancedHiliteEditor.title:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        AdvancedHiliteEditorLogicalStructure s = new AdvancedHiliteEditorLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

