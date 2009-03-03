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

package com.smartgwt.client.widgets;


import com.smartgwt.client.data.DataSource;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A DataBoundComponent is a widget that can configure itself for viewing or editing objects which share a certain schema by "binding" to the schema for that object (called a "DataSource"). <P> A schema (or DataSource) describes an object as consisting of a set of properties (or "fields"). <P> DataBoundComponents have a {@link com.smartgwt.client.widgets.DataBoundComponent#getDataSource dataSource} for dealing with binding to DataSources,  {@link com.smartgwt.client.widgets.DataBoundComponent#getFields fields} the schema information provided by a DataSource, and manipulating objects or sets of object from the DataSource. <P> The following visual components currently support databinding:<pre>   {@link com.smartgwt.client.widgets.form.DynamicForm}   {@link com.smartgwt.client.widgets.viewer.DetailViewer}   {@link com.smartgwt.client.widgets.grid.ListGrid}   {@link com.smartgwt.client.widgets.tree.TreeGrid}   {@link com.smartgwt.client.widgets.tile.TileGrid}   {@link com.smartgwt.client.widgets.grid.ColumnTree}   {@link com.smartgwt.client..CubeGrid} </pre> The following non-visual components also support databinding:<pre>   {@link com.smartgwt.client.widgets.form.ValuesManager}   {@link com.smartgwt.client.data.ResultSet}   {@link com.smartgwt.client..ResultTree} </pre>
 */
public interface DataBoundComponent {


    // ********************* Properties / Attributes ***********************

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link com.smartgwt.client.data.DSRequest}. <P> Can be specified as either a DataSource instance or the String ID of a DataSource.
     * Bind to a new DataSource. <P> Like passing the "dataSource" property on creation, binding to a DataSource means that the component will use the DataSource to provide default data for its fields. <P> When binding to a new DataSource, if the component has any existing "fields" or has a dataset, these will be discarded by default, since it is assumed the new DataSource may represent a completely unrelated set of objects.  If the old "fields" are still relevant, pass them to setDataSource().
     *
     * @param dataSource DataSource to bind to. Default value is null
     */
    void setDataSource(DataSource dataSource);

    /**
     * The DataSource that this component should bind to for default fields and for performing {@link com.smartgwt.client.data.DSRequest}. <P> Can be specified as either a DataSource instance or the String ID of a DataSource.
     *
     * @return DataSource
     */
    DataSource getDataSource();

    JavaScriptObject getOrCreateJsObj();


}



