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
 
package com.smartgwt.client.widgets.form.fields;


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

/**
 * Header item for a collapsible section in a {@link com.smartgwt.client.widgets.form.DynamicForm}.  Each
 * <code>SectionItem</code> is associated with a number of other <code>item</code>s in the form, which will be shown or
 * hidden as a group when the section is expanded or collapsed.  Clicking on a <code>SectionItem</code> will expand or
 * collapse the section. <P> To make a form where only one section is expanded at a time, set {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getSectionVisibilityMode sectionVisibilityMode} to "mutex".
 * @see com.smartgwt.client.widgets.form.DynamicForm#getSectionVisibilityMode
 */
@BeanFactory.FrameworkClass
public class SectionItem extends CanvasItem {

    public static SectionItem getOrCreateRef(JavaScriptObject jsObj) {

        if(jsObj == null) return null;

        RefDataClass obj = RefDataClass.getRef(jsObj);

		if(obj != null && JSOHelper.getAttribute(jsObj,"__ref")==null) {
            return com.smartgwt.client.util.ObjectFactory.createFormItem("SectionItem",jsObj);

        } else
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (SectionItem) obj;
        } else {
            return new SectionItem(jsObj);
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
        $wnd.isc.SectionItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.SectionItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;
    /**
     * Changes the defaults for DrawItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults DrawItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, DrawItem defaults) /*-{
        $wnd.isc.SectionItem.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.drawing.DrawItem::getJsObj()());
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.SectionItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public SectionItem(){
        setAttribute("editorType", "SectionItem");
    }

    public SectionItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    public SectionItem(String name) {
        setName(name);
                setAttribute("editorType", "SectionItem");
    }


    public SectionItem(String name, String title) {
        setName(name);
		setTitle(title);
                setAttribute("editorType", "SectionItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Whether this section header can be collapsed.  If set false, suppresses open/close state icon
     *
     * @param canCollapse  Default value is true
     */
    public void setCanCollapse(Boolean canCollapse) {
        setAttribute("canCollapse", canCollapse);
    }

    /**
     * Whether this section header can be collapsed.  If set false, suppresses open/close state icon
     *
     * @return Boolean
     */
    public Boolean getCanCollapse()  {
        return getAttributeAsBoolean("canCollapse");
    }
    

    /**
     * If true, the header for this Section will be included in the page's tab order for accessibility. May also be set at the
     * {@link com.smartgwt.client.widgets.form.DynamicForm} level via  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanTabToSectionHeaders canTabToSectionHeaders}. <P> See {@link
     * com.smartgwt.client.docs.Accessibility}.
     *
     * @param canTabToHeader  Default value is null
     */
    public void setCanTabToHeader(Boolean canTabToHeader) {
        setAttribute("canTabToHeader", canTabToHeader);
    }

    /**
     * If true, the header for this Section will be included in the page's tab order for accessibility. May also be set at the
     * {@link com.smartgwt.client.widgets.form.DynamicForm} level via  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanTabToSectionHeaders canTabToSectionHeaders}. <P> See {@link
     * com.smartgwt.client.docs.Accessibility}.
     *
     * @return Boolean
     */
    public Boolean getCanTabToHeader()  {
        return getAttributeAsBoolean("canTabToHeader");
    }
    
    

    /**
     * IDs of the items that should be considered a member of this section.
     *
     * @param itemIds  Default value is null
     */
    public void setItemIds(String... itemIds) {
        setAttribute("itemIds", itemIds);
    }
    

    /**
     * Whether this form section should be initially collapsed. Can be set programmatically via {@link
     * com.smartgwt.client.widgets.form.fields.SectionItem#expandSection SectionItem.expandSection} and {@link
     * com.smartgwt.client.widgets.form.fields.SectionItem#collapseSection SectionItem.collapseSection}.
     *
     * @param sectionExpanded  Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_sections" target="examples">Sections Example</a>
     */
    public void setSectionExpanded(Boolean sectionExpanded) {
        setAttribute("sectionExpanded", sectionExpanded);
    }

    /**
     * Whether this form section should be initially collapsed. Can be set programmatically via {@link
     * com.smartgwt.client.widgets.form.fields.SectionItem#expandSection SectionItem.expandSection} and {@link
     * com.smartgwt.client.widgets.form.fields.SectionItem#collapseSection SectionItem.collapseSection}.
     *
     * @return Boolean
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#layout_form_sections" target="examples">Sections Example</a>
     */
    public Boolean getSectionExpanded()  {
        return getAttributeAsBoolean("sectionExpanded");
    }
    

    /**
     * Name of the Canvas subclass to use as a header that labels the section and allows showing and hiding.  The default class
     * be skinned, or trivial subclasses created to allow different appearances for SectionItems in different forms. Very
     * advanced developers can use the following information to create custom header classes.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param sectionHeaderClass  Default value is "SectionHeader"
     */
    public void setSectionHeaderClass(String sectionHeaderClass) {
        setAttribute("sectionHeaderClass", sectionHeaderClass);
    }

    /**
     * Name of the Canvas subclass to use as a header that labels the section and allows showing and hiding.  The default class
     * be skinned, or trivial subclasses created to allow different appearances for SectionItems in different forms. Very
     * advanced developers can use the following information to create custom header classes.
     *
     * @return String
     */
    public String getSectionHeaderClass()  {
        return getAttributeAsString("sectionHeaderClass");
    }
    
    

    // ********************* Methods ***********************
	/**
     * Collapse a sectionItem, and hide all the items within the section (not including the header).
     */
    public native void collapseSection() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!$wnd.isc.isA.FormItem(self)) { self.sectionExpanded = false; return; }
        self.collapseSection();
    }-*/;

	/**
     * Expands a section, showing all the items contained within the section.
     */
    public native void expandSection() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (!$wnd.isc.isA.FormItem(self)) { self.sectionExpanded = true; return; }
        self.expandSection();
    }-*/;

	/**
     * Returns a boolean indicating whether this SectionItem is expanded.
     *
     * @return true if the section is expanded false if not
     */
    public native Boolean isExpanded() /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var ret = self.isExpanded();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties of the class instance passed to this function.
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
     * @param sectionItemProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(SectionItem sectionItemProperties) /*-{
    	var properties = $wnd.isc.addProperties({},sectionItemProperties.@com.smartgwt.client.core.RefDataClass::getJsObj()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.SectionItem.addProperties(properties);
    }-*/;

    // ***********************************************************

}


