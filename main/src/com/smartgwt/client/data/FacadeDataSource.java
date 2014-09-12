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
 
package com.smartgwt.client.data;


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
 * Extends an arbitrary {@link com.smartgwt.client.data.DataSource} with the ability to queue requests made on it and
 * dispatch the queued requests on demand. To use, create a FacadeDataSource instance with the {@link
 * com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom} property set to the DataSource that you wish to
 * extend. <p> This advanced class is intended to be used for testing data-bound components. This should not be used in
 * production code.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("FacadeDataSource")
public class FacadeDataSource extends DataSource {

    public static FacadeDataSource getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (FacadeDataSource) obj;
        } else {
            return new FacadeDataSource(jsObj);
        }
    }


    public FacadeDataSource(){
        scClassName = "FacadeDataSource";
    }

    public FacadeDataSource(JavaScriptObject jsObj){
        scClassName = "FacadeDataSource";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * An array of derived DS requests that are queued to be {@link com.smartgwt.client.data.DataSource#execute executed} on
     * the underlying {@link com.smartgwt.client.data.DataSource#getInheritsFrom inherited} DataSource. <p> When a DS request
     * is made on this FacadeDataSource, if {@link com.smartgwt.client.data.FacadeDataSource#getQueueRequests queueRequests} is
     * true, then a new DS request is created based on the given DS request and added to this queue. <p> To clear the queue,
     * set {@link com.smartgwt.client.data.FacadeDataSource#getQueueRequests queueRequests} to false or call {@link
     * com.smartgwt.client.data.FacadeDataSource#clearQueue clearQueue()}.
     * <p>
     * <b>Note :</b> This method should be called only after the underlying component has been created.
     *
     * @return DSRequest...
     * @throws IllegalStateException if the underlying component has not yet been created.
     */
    public DSRequest[] getQueuedRequests() throws IllegalStateException {
        errorIfNotCreated("queuedRequests");
        return com.smartgwt.client.util.ConvertTo.arrayOfDSRequest(getAttributeAsJavaScriptObject("queuedRequests"));
    }
    

    /**
     * Should requests be queued? <p> When DS requests are made on the FacadeDataSource, a new, derived DS request on the
     * underlying {@link com.smartgwt.client.data.DataSource#getInheritsFrom inherited} DataSource is created. If queueRequests
     * is true, then the derived DS request is added to the {@link com.smartgwt.client.data.FacadeDataSource#getQueuedRequests
     * queuedRequests} array. If false, then the derived DS request is {@link com.smartgwt.client.data.DataSource#execute
     * executed} immediately on the inherited DataSource.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.data.FacadeDataSource#getQueueRequests queueRequests}.
     *
     * @param queueRequests  Default value is false
     */
    public void setQueueRequests(boolean queueRequests) {
        setAttribute("queueRequests", queueRequests, true);
    }

    /**
     * Should requests be queued? <p> When DS requests are made on the FacadeDataSource, a new, derived DS request on the
     * underlying {@link com.smartgwt.client.data.DataSource#getInheritsFrom inherited} DataSource is created. If queueRequests
     * is true, then the derived DS request is added to the {@link com.smartgwt.client.data.FacadeDataSource#getQueuedRequests
     * queuedRequests} array. If false, then the derived DS request is {@link com.smartgwt.client.data.DataSource#execute
     * executed} immediately on the inherited DataSource.
     *
     * @return boolean
     */
    public boolean getQueueRequests()  {
        Boolean result = getAttributeAsBoolean("queueRequests");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Shorthand to clear the {@link com.smartgwt.client.data.FacadeDataSource#getQueuedRequests request queue} without
     * changing the value of {@link com.smartgwt.client.data.FacadeDataSource#getQueueRequests queueRequests}.
     */
    public native void clearQueue() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.clearQueue();
    }-*/;


    // ********************* Static Methods ***********************

    // ***********************************************************

}





