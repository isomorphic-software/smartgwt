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
 
package com.smartgwt.client.widgets.tree;



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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * An object literal with a particular set of properties used to configure the display of and interaction with the columns
 * of a {@link com.smartgwt.client.widgets.tree.TreeGrid}. {@link com.smartgwt.client.widgets.tree.TreeGrid} is a subclass
 * of {@link com.smartgwt.client.widgets.grid.ListGrid} and as a result, for all fields except the field containing the
 * {@link com.smartgwt.client.widgets.tree.Tree} itself (specified by {@link
 * com.smartgwt.client.widgets.tree.TreeGridField#getTreeField treeField}, all properties settable on {@link
 * com.smartgwt.client.widgets.grid.ListGridField} apply to TreeGridField as well. <p> This class documents just those
 * properties that are specific to TreeGridFields - see {@link com.smartgwt.client.widgets.grid.ListGridField} for the set
 * of inherited properties.
 * @see com.smartgwt.client.widgets.grid.ListGridField
 * @see com.smartgwt.client.widgets.tree.TreeGrid#getFields
 * @see com.smartgwt.client.widgets.grid.ListGrid#setFields
 */
public class TreeGridField extends ListGridField {

    public static TreeGridField getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new TreeGridField(jsObj);
    }

    public TreeGridField(){
        
    }

    public TreeGridField(JavaScriptObject jsObj){
        super(jsObj);
    }

    public TreeGridField(String name) {
        super(name);
        
    }

    public TreeGridField(String name, int width) {
        super(name, width);
        
    }

    public TreeGridField(String name, String title) {
        super(name, title);
        
    }

    public TreeGridField(String name, String title, int width) {
        super(name, title, width);
        
    }

    // ********************* Properties / Attributes ***********************

    /**
     * Dictates whether the data in this field be exported.  Explicitly set this  to false to prevent exporting.  Has no effect
     * if the underlying   {@link com.smartgwt.client.data.DataSourceField#getCanExport dataSourceField} is explicitly set to  
     * canExport: false.
     *
     * @param canExport canExport Default value is null
     */
    public void setCanExport(Boolean canExport) {
        setAttribute("canExport", canExport);
    }

    /**
     * Dictates whether the data in this field be exported.  Explicitly set this  to false to prevent exporting.  Has no effect
     * if the underlying   {@link com.smartgwt.client.data.DataSourceField#getCanExport dataSourceField} is explicitly set to  
     * canExport: false.
     *
     *
     * @return Boolean
     */
    public Boolean getCanExport()  {
        return getAttributeAsBoolean("canExport");
    }

    /**
     * The field containing <code>treeField: true</code> will display the {@link com.smartgwt.client.widgets.tree.Tree}.  If no
     * field specifies this property, if a field named after the {@link com.smartgwt.client.widgets.tree.Tree#getTitleProperty
     * titleProperty} of the Tree is present in {@link com.smartgwt.client.widgets.tree.TreeGrid#getFields fields}, that field
     * will show the tree.  Note that when using a DataSource, you typically define the title field via {@link
     * com.smartgwt.client.data.DataSource#getTitleField titleField} and the generated ResultTree automatically uses this
     * field. If none of the above rules apply, the first field in {@link com.smartgwt.client.widgets.tree.TreeGrid#getFields
     * fields} is assigned to display the {@link com.smartgwt.client.widgets.tree.Tree}.
     *
     * @param treeField treeField Default value is see below
     */
    public void setTreeField(Boolean treeField) {
        setAttribute("treeField", treeField);
    }

    /**
     * The field containing <code>treeField: true</code> will display the {@link com.smartgwt.client.widgets.tree.Tree}.  If no
     * field specifies this property, if a field named after the {@link com.smartgwt.client.widgets.tree.Tree#getTitleProperty
     * titleProperty} of the Tree is present in {@link com.smartgwt.client.widgets.tree.TreeGrid#getFields fields}, that field
     * will show the tree.  Note that when using a DataSource, you typically define the title field via {@link
     * com.smartgwt.client.data.DataSource#getTitleField titleField} and the generated ResultTree automatically uses this
     * field. If none of the above rules apply, the first field in {@link com.smartgwt.client.widgets.tree.TreeGrid#getFields
     * fields} is assigned to display the {@link com.smartgwt.client.widgets.tree.Tree}.
     *
     *
     * @return Boolean
     */
    public Boolean getTreeField()  {
        return getAttributeAsBoolean("treeField");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************
        
    // ***********************************************************        

}



