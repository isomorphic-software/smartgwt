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
 
package com.smartgwt.client.widgets.layout;


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


/**
 * Properties for a navigation item in a {@link com.smartgwt.client.widgets.layout.NavPanel}.
 */
@BeanFactory.FrameworkClass
public class NavItem extends TreeNode {

    public static NavItem getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new NavItem(jsObj);
    }
        


    public NavItem(){
        
    }

    public NavItem(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * CSS style name used for this <code>NavItem</code>.  If set and this <code>NavItem</code> is a {@link
     * com.smartgwt.client.widgets.layout.NavItem#getIsHeader header}, this overrides the <code>NavPanel</code>'s {@link
     * com.smartgwt.client.widgets.layout.NavPanel#getHeaderStyle NavPanel.headerStyle}.
     *
     * @param customStyle New customStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavItem NavItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public NavItem setCustomStyle(String customStyle) {
        return (NavItem)setAttribute("customStyle", customStyle);
    }

    /**
     * CSS style name used for this <code>NavItem</code>.  If set and this <code>NavItem</code> is a {@link
     * com.smartgwt.client.widgets.layout.NavItem#getIsHeader header}, this overrides the <code>NavPanel</code>'s {@link
     * com.smartgwt.client.widgets.layout.NavPanel#getHeaderStyle NavPanel.headerStyle}.
     *
     * @return Current customStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getCustomStyle()  {
        return getAttributeAsString("customStyle");
    }
    

    /**
     * Icon to show for this <code>NavItem</code>.  If not specified, the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon navGrid's folderIcon} is used.
     *
     * @param icon New icon value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavItem NavItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public NavItem setIcon(String icon) {
        return (NavItem)setAttribute("icon", icon);
    }

    /**
     * Icon to show for this <code>NavItem</code>.  If not specified, the {@link
     * com.smartgwt.client.widgets.tree.TreeGrid#getFolderIcon navGrid's folderIcon} is used.
     *
     * @return Current icon value. Default value is null
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getIcon()  {
        return getAttributeAsString("icon");
    }
    

    /**
     * An optional ID for this <code>NavItem</code>.  If specified, this must be unique within the <code>NavPanel</code>.
     *
     * @param id New id value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavItem NavItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public NavItem setId(String id) {
        return (NavItem)setAttribute("id", id);
    }

    /**
     * An optional ID for this <code>NavItem</code>.  If specified, this must be unique within the <code>NavPanel</code>.
     *
     * @return Current id value. Default value is null
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public String getId()  {
        return getAttributeAsString("id");
    }
    

    /**
     * If set, this <code>NavItem</code> will be styled like a header.  In this case {@link
     * com.smartgwt.client.widgets.layout.NavItem#getPane pane} is ignored and nothing happens when the header is clicked. 
     * However, {@link com.smartgwt.client.widgets.layout.NavItem#getItems items} can still be configured to place items
     * hierarchically under the header.
     *
     * @param isHeader New isHeader value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavItem NavItem} instance, for chaining setter calls
     */
    public NavItem setIsHeader(Boolean isHeader) {
        return (NavItem)setAttribute("isHeader", isHeader);
    }

    /**
     * If set, this <code>NavItem</code> will be styled like a header.  In this case {@link
     * com.smartgwt.client.widgets.layout.NavItem#getPane pane} is ignored and nothing happens when the header is clicked. 
     * However, {@link com.smartgwt.client.widgets.layout.NavItem#getItems items} can still be configured to place items
     * hierarchically under the header.
     *
     * @return Current isHeader value. Default value is null
     */
    public Boolean getIsHeader()  {
        return getAttributeAsBoolean("isHeader", true);
    }
    

    /**
     * If set, this <code>NavItem</code> will be styled as a separator.  A separator does not have a {@link
     * com.smartgwt.client.widgets.layout.NavItem#getPane pane} and nothing happens when the separator is clicked.
     *
     * @param isSeparator New isSeparator value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavItem NavItem} instance, for chaining setter calls
     */
    public NavItem setIsSeparator(Boolean isSeparator) {
        return (NavItem)setAttribute("isSeparator", isSeparator);
    }

    /**
     * If set, this <code>NavItem</code> will be styled as a separator.  A separator does not have a {@link
     * com.smartgwt.client.widgets.layout.NavItem#getPane pane} and nothing happens when the separator is clicked.
     *
     * @return Current isSeparator value. Default value is null
     */
    public Boolean getIsSeparator()  {
        return getAttributeAsBoolean("isSeparator", true);
    }
    

    /**
     * Optional subitems of this <code>NavItem</code>.
     *
     * @param items New items value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavItem NavItem} instance, for chaining setter calls
     */
    public NavItem setItems(NavItem... items) {
        return (NavItem)setAttribute("items", items);
    }

    /**
     * Optional subitems of this <code>NavItem</code>.
     *
     * @return Current items value. Default value is null
     */
    public NavItem[] getItems()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfNavItem(getAttributeAsJavaScriptObject("items"));
    }
    

    /**
     * Component to display in the {@link com.smartgwt.client.widgets.layout.NavPanel#getNavDeck NavPanel.navDeck} when this
     * <code>NavItem</code> is selected. <p> A component can be provided directly, or its ID can be provided.
     *
     * @param pane New pane value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavItem NavItem} instance, for chaining setter calls
     */
    public NavItem setPane(Canvas pane) {
        return (NavItem)setAttribute("pane", pane == null ? null : pane.getOrCreateJsObj());
    }

    /**
     * Component to display in the {@link com.smartgwt.client.widgets.layout.NavPanel#getNavDeck NavPanel.navDeck} when this
     * <code>NavItem</code> is selected. <p> A component can be provided directly, or its ID can be provided.
     *
     * @return Current pane value. Default value is null
     */
    public Canvas getPane()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("pane"));
    }

    /**
     * Component to display in the {@link com.smartgwt.client.widgets.layout.NavPanel#getNavDeck NavPanel.navDeck} when this
     * <code>NavItem</code> is selected. <p> A component can be provided directly, or its ID can be provided.
     *
     * @param pane New pane value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavItem NavItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public NavItem setPane(String pane) {
        return (NavItem)setAttribute("pane", pane);
    }

    /**
     * Component to display in the {@link com.smartgwt.client.widgets.layout.NavPanel#getNavDeck NavPanel.navDeck} when this
     * <code>NavItem</code> is selected. <p> A component can be provided directly, or its ID can be provided.
     *
     * @return Current pane value. Default value is null
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public String getPaneAsString()  {
        return getAttributeAsString("pane");
    }
    

    /**
     * Title to show for this <code>NavItem</code>.
     *
     * @param title New title value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.NavItem NavItem} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public NavItem setTitle(String title) {
        return (NavItem)setAttribute("title", title);
    }

    /**
     * Title to show for this <code>NavItem</code>.
     *
     * @return Current title value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getTitle()  {
        return getAttributeAsString("title");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
