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
 * A widget for defining and editing a set of {@link com.smartgwt.client.widgets.grid.HiliteRule hilite rules} for use by 
 * {@link com.smartgwt.client.widgets.DataBoundComponent dataBoundComponents}.  Presents a list of available fields  and
 * allows editing of simple hilites directly and more complex hilites via   {@link
 * com.smartgwt.client.widgets.grid.AdvancedHiliteEditor}s.  <P> <i><b>Important Note:</b> this class should not be used
 * directly - it is exposed purely for {@link i18nMessages i18n reasons.}</i>
 */
public class HiliteEditor extends VLayout {

    public native static HiliteEditor getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("HiliteEditor",jsObj);
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
        $wnd.isc["HiliteEditor"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc["HiliteEditor"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public HiliteEditor(){
        scClassName = "HiliteEditor";
    }

    public HiliteEditor(JavaScriptObject jsObj){
        scClassName = "HiliteEditor";
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
     * The title text for the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getAddAdvancedRuleButton add advanced rule}
     * button.
     *
     * @param addAdvancedRuleButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Add Advanced Rule"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAddAdvancedRuleButtonTitle(String addAdvancedRuleButtonTitle)  throws IllegalStateException {
        setAttribute("addAdvancedRuleButtonTitle", addAdvancedRuleButtonTitle, false);
    }

    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getAddAdvancedRuleButton add advanced rule}
     * button.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getAddAdvancedRuleButtonTitle()  {
        return getAttributeAsString("addAdvancedRuleButtonTitle");
    }


    /**
     * The title for the 'Available Fields' column in the  {@link com.smartgwt.client.widgets.grid.HiliteEditor#getFieldList
     * fieldList}.
     *
     * @param availableFieldsColumnTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Available Fields"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAvailableFieldsColumnTitle(String availableFieldsColumnTitle)  throws IllegalStateException {
        setAttribute("availableFieldsColumnTitle", availableFieldsColumnTitle, false);
    }

    /**
     * The title for the 'Available Fields' column in the  {@link com.smartgwt.client.widgets.grid.HiliteEditor#getFieldList
     * fieldList}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getAvailableFieldsColumnTitle()  {
        return getAttributeAsString("availableFieldsColumnTitle");
    }


    /**
     * The callback to fire when {@link com.smartgwt.client.widgets.grid.HiliteEditor#saveHilites HiliteEditor.saveHilites} is
     * called.
     *
     * @param callback . See {@link com.smartgwt.client.docs.Callback Callback}. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCallback(String callback)  throws IllegalStateException {
        setAttribute("callback", callback, false);
    }

    /**
     * The callback to fire when {@link com.smartgwt.client.widgets.grid.HiliteEditor#saveHilites HiliteEditor.saveHilites} is
     * called.
     *
     * @return . See {@link com.smartgwt.client.docs.Callback Callback}
     */
    public String getCallback()  {
        return getAttributeAsString("callback");
    }



    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getCancelButton cancel button}.
     *
     * @param cancelButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Cancel"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCancelButtonTitle(String cancelButtonTitle)  throws IllegalStateException {
        setAttribute("cancelButtonTitle", cancelButtonTitle, false);
    }

    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getCancelButton cancel button}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }



    /**
     * Specifies a list of icons that can be used in {@link com.smartgwt.client.widgets.grid.HiliteEditor#getEditHilites
     * hilites}. <P> <code>hiliteIcons</code> should be specified as an Array of SCImgURL. When present, {@link
     * com.smartgwt.client.widgets.grid.HiliteRule}s will offer the user a drop down for picking one of these icons. <P> If the
     * user picks an icon, the created hiliting rule will have {@link com.smartgwt.client.data.Hilite#getIcon icon} set to  the
     * chosen icon.  {@link com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconPosition hiliteIconPosition} controls
     * where the icon will  appear for that field -- the default is that it appears in front of the normal cell content.
     *
     * @param hiliteIcons . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is null
     */
    public void setHiliteIcons(String... hiliteIcons) {
        setAttribute("hiliteIcons", hiliteIcons, true);
    }

    /**
     * Specifies a list of icons that can be used in {@link com.smartgwt.client.widgets.grid.HiliteEditor#getEditHilites
     * hilites}. <P> <code>hiliteIcons</code> should be specified as an Array of SCImgURL. When present, {@link
     * com.smartgwt.client.widgets.grid.HiliteRule}s will offer the user a drop down for picking one of these icons. <P> If the
     * user picks an icon, the created hiliting rule will have {@link com.smartgwt.client.data.Hilite#getIcon icon} set to  the
     * chosen icon.  {@link com.smartgwt.client.widgets.grid.ListGridField#getHiliteIconPosition hiliteIconPosition} controls
     * where the icon will  appear for that field -- the default is that it appears in front of the normal cell content.
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     */
    public String[] getHiliteIcons()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("hiliteIcons"));
    }




    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getSaveButton saveButton}.
     *
     * @param saveButtonTitle . See {@link com.smartgwt.client.docs.String String}. Default value is "Save"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSaveButtonTitle(String saveButtonTitle)  throws IllegalStateException {
        setAttribute("saveButtonTitle", saveButtonTitle, false);
    }

    /**
     * The title text for the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getSaveButton saveButton}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getSaveButtonTitle()  {
        return getAttributeAsString("saveButtonTitle");
    }

    // ********************* Methods ***********************
	/**
     * Clear all Hilites from the editor.
     */
    public native void clearHilites() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearHilites();
    }-*/;
	/**
     * Removes the passed {@link com.smartgwt.client.widgets.grid.HiliteRule HiliteRule} from this editor.
     * @param hiliteRule the hiliteRule to remove
     */
    public native void removeRule(HiliteRule hiliteRule) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeRule(hiliteRule.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;
	/**
     * Save the set of Hilites and fire the {@link com.smartgwt.client.widgets.grid.HiliteEditor#getCallback callback}.
     * @param callback the function to call when saving is complete. See {@link com.smartgwt.client.docs.Callback Callback}
     */
    public native void saveHilites(String callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveHilites(callback);
    }-*/;
	/**
     * Initialize this editor with a set of Hilites.
     * @param hilites the array of hilite objects to apply
     */
    public native void setHilites(Hilite... hilites) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setHilites(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(hilites));
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
     * @param hiliteEditorProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(HiliteEditor hiliteEditorProperties) /*-{
    	var properties = $wnd.isc.addProperties({},hiliteEditorProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.HiliteEditor.addProperties(properties);
    }-*/;

    // ***********************************************************

    public LogicalStructureObject setLogicalStructure(HiliteEditorLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.addAdvancedRuleButtonTitle = getAttributeAsString("addAdvancedRuleButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteEditor.addAdvancedRuleButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.availableFieldsColumnTitle = getAttributeAsString("availableFieldsColumnTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteEditor.availableFieldsColumnTitle:" + t.getMessage() + "\n";
        }
        try {
            s.callback = getAttributeAsString("callback");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteEditor.callback:" + t.getMessage() + "\n";
        }
        try {
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteEditor.cancelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.hiliteIcons = getAttributeAsStringArray("hiliteIcons");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteEditor.hiliteIconsArray:" + t.getMessage() + "\n";
        }
        try {
            s.saveButtonTitle = getAttributeAsString("saveButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteEditor.saveButtonTitle:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        HiliteEditorLogicalStructure s = new HiliteEditorLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

