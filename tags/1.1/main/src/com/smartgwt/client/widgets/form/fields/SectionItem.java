/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.client.widgets.form.fields;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * Header item for a collapsable section in a {@link com.smartgwt.client.widgets.form.DynamicForm}.  Each <code>SectionItem</code>&#010 is associated with a number of other <code>item</code>s in the form, which will be shown or&#010 hidden as a group when the section is expanded or collapsed.  Clicking on a&#010 <code>SectionItem</code> will expand or collapse the section.&#010 <P>&#010 To make a form where only one section is expanded at a time, set&#010 {@link com.smartgwt.client.widgets.form.DynamicForm#getSectionVisibilityMode sectionVisibilityMode} to "mutex".

    */
public class SectionItem extends CanvasItem {

    public static SectionItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if(obj != null) {
            obj.setJsObj(jsObj);
            return (SectionItem) obj;
        } else {
            return new SectionItem(jsObj);
        }
    }


    public SectionItem(){
        setType("SectionItem");
    }

    public SectionItem(JavaScriptObject jsObj){
        super(jsObj);
    }

    public SectionItem(String name) {
        setName(name);
        setType("SectionItem");
    }

    public SectionItem(String name, String title) {
        setName(name);
		setTitle(title);
        setType("SectionItem");
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Whether this form section should be initially collapsed. Can be set programatically&#010 via {@link com.smartgwt.client.widgets.form.fields.SectionItem#expandSection} and {@link com.smartgwt.client.widgets.form.fields.SectionItem#collapseSection}.
    *
    * @param sectionExpanded sectionExpanded Default value is true
    */
    public void setSectionExpanded(Boolean sectionExpanded) {
        setAttribute("sectionExpanded", sectionExpanded);
    }
    /**
     * Whether this form section should be initially collapsed. Can be set programatically&#010 via {@link com.smartgwt.client.widgets.form.fields.SectionItem#expandSection} and {@link com.smartgwt.client.widgets.form.fields.SectionItem#collapseSection}.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getSectionExpanded()  {
        return getAttributeAsBoolean("sectionExpanded");
    }

    /**
    * Name of the Canvas subclass to use as a header that labels the section and allows&#010 showing and hiding.  The default class be skinned, or trivial subclasses created to&#010 allow different appearances for SectionItems in different forms.&#010 Very advanced developers can use the following information to create custom header&#010 classes.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param sectionHeaderClass sectionHeaderClass Default value is "SectionHeader"
    */
    public void setSectionHeaderClass(String sectionHeaderClass) {
        setAttribute("sectionHeaderClass", sectionHeaderClass);
    }
    /**
     * Name of the Canvas subclass to use as a header that labels the section and allows&#010 showing and hiding.  The default class be skinned, or trivial subclasses created to&#010 allow different appearances for SectionItems in different forms.&#010 Very advanced developers can use the following information to create custom header&#010 classes.
     *
     *
     * @return String
     *
     */
    public String getSectionHeaderClass()  {
        return getAttributeAsString("sectionHeaderClass");
    }

    /**
    * Whether this section header can be collapsed.  If set false, suppresses open/close state&#010 icon
    *
    * @param canCollapse canCollapse Default value is true
    */
    public void setCanCollapse(Boolean canCollapse) {
        setAttribute("canCollapse", canCollapse);
    }
    /**
     * Whether this section header can be collapsed.  If set false, suppresses open/close state&#010 icon
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanCollapse()  {
        return getAttributeAsBoolean("canCollapse");
    }

    // ********************* Methods ***********************

        /**
         * Expands a section, showing all the items contained within the section.&#010
         */
        public native void expandSection() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.expandSection();
        }-*/;

        /**
         * Collapse a sectionItem, and hide all the items within the section (not including&#010 the header).&#010
         */
        public native void collapseSection() /*-{
            var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
            self.collapseSection();
        }-*/;

    // ********************* Static Methods ***********************




    /**
     * IDs of the items that should be considered a member of this section.
     *
     * @param itemIds itemIds Default value is null
     */
    public void setItemIds(String... itemIds) {
        setAttribute("itemIds", itemIds);
    }

}



