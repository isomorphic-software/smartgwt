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
 
package com.smartgwt.client.widgets.cube;


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
 * An object mapping {@link com.smartgwt.client.widgets.cube.Facet#getId facet ids} to {@link
 * com.smartgwt.client.widgets.cube.FacetValue#getId facetValue ids} within a facet  <P> The facetId -> facetValueId
 * mappings in a FacetValueMap describe a specific slice of the dataset.  If mappings are included for all facets, a
 * FacetValueMap describes a unique cell.  If some facets are omitted, it describes a row, column, or set of rectangular
 * areas, or equivalently, a particular row or column header (if all facetIds in the map are displayed on the same axis)
 * <P> FacetValueMaps are used in various contexts to describe headers, datasets to be loaded, screen regions, etc.
 */
@BeanFactory.FrameworkClass
public class FacetValueMap extends DataClass {

    public static FacetValueMap getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new FacetValueMap(jsObj);
    }


    public FacetValueMap(){
        
    }

    public FacetValueMap(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************


	
	/**
	 * Add a facet id -&gt; facetValue id mapping to this facetValueMap
	 * @param facetId
	 * @param facetValueId
	 */
	public void addMapping(String facetId, String facetValueId) {
		setAttribute(facetId, facetValueId);
	}
	
	/**
	 * Get the facetValue id for some facet id within this facet valueMap
	 * @param facetId
	 */
	public String getMapping(String facetId) {
		return getAttributeAsString(facetId);
	}
	
	/**
	 * Remove a facet id -&gt; facetValue id mapping from this facetValueMap
	 * @param facetId
	 */
	public void removeMapping (String facetId) {
		setAttribute(facetId, (String)null);
	}
	
	/**
	 * Returns the array of all facet ids for which this facetValueMap currently contains mapping
	 * @return
	 */
	public String[] getFacetIds () {
		return getAttributes();
	}


}


