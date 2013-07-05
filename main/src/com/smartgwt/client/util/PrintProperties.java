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
 
package com.smartgwt.client.util;


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
 * Settings for generating printable HTML for components.
 */
public class PrintProperties extends DataClass {

    public static PrintProperties getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new PrintProperties(jsObj);
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }



    public PrintProperties(){
        
    }

    public PrintProperties(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
    }


    // ********************* Properties / Attributes ***********************




    /**
     * If true, generates HTML for export. <P> Some components, specifically {@link
     * com.smartgwt.client.widgets.drawing.DrawPane} and {@link com.smartgwt.client.widgets.chart.FacetChart} on IE8 and
     * earlier, need to generate different HTML for export versus in-browser print preview. When using {@link
     * com.smartgwt.client.rpc.RPCManager#exportContent RPCManager.exportContent} the printForExport property is set to true
     * automatically. If not using RPCManager.exportContent(), but the generated HTML will be sent for export, the
     * <code>PrintProperties</code> passed to {@link com.smartgwt.client.widgets.Canvas#getPrintHTML Canvas.getPrintHTML} must
     * have printForExport:true.
     *
     * @param printForExport printForExport Default value is null
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public void setPrintForExport(Boolean printForExport) {
        setAttribute("printForExport", printForExport);
    }

    /**
     * If true, generates HTML for export. <P> Some components, specifically {@link
     * com.smartgwt.client.widgets.drawing.DrawPane} and {@link com.smartgwt.client.widgets.chart.FacetChart} on IE8 and
     * earlier, need to generate different HTML for export versus in-browser print preview. When using {@link
     * com.smartgwt.client.rpc.RPCManager#exportContent RPCManager.exportContent} the printForExport property is set to true
     * automatically. If not using RPCManager.exportContent(), but the generated HTML will be sent for export, the
     * <code>PrintProperties</code> passed to {@link com.smartgwt.client.widgets.Canvas#getPrintHTML Canvas.getPrintHTML} must
     * have printForExport:true.
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public Boolean getPrintForExport()  {
        return getAttributeAsBoolean("printForExport");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************




	/**
     * An array of Strings indicating the classNames of controls that should be omitted from printing.  By default,
     * <code>omitControls</code> includes all button-based controls, menus and similar interactive controls that are typically
     * useless in printed output. <P> All subclasses of the specified classes are also omitted. <P> See also {@link
     * com.smartgwt.client.widgets.util.PrintProperties#getIncludeControls includeControls}.
     *
     * @param omitControls omitControls Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOmitControls(String[] omitControls)  throws IllegalStateException {
    	JavaScriptObject ocJS = JSOHelper.convertToJavaScriptArray(omitControls);
    	setAttribute("omitControls", ocJS);
    }

    /**
     * An array of Strings indicating the classNames of controls that should be omitted from printing.  By default,
     * <code>omitControls</code> includes all button-based controls, menus and similar interactive controls that are typically
     * useless in printed output. <P> All subclasses of the specified classes are also omitted. <P> See also {@link
     * com.smartgwt.client.widgets.util.PrintProperties#getIncludeControls includeControls}.
     *
     *
     * @return Unhandled-Array of String
     */
    public String[] getOmitControls()  {
    	
        return JSOHelper.convertToJavaStringArray(getAttributeAsJavaScriptObject("omitControls"));
    }
 
    /**
     * An array of Strings indicating the classNames of controls that should be specifically included when printing, even if a
     * superclass is listed in {@link com.smartgwt.client.widgets.util.PrintProperties#getOmitControls omitControls}.
     *
     * @param includeControls includeControls Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIncludeControls(String[] includeControls)  throws IllegalStateException {
    	JavaScriptObject icJS = JSOHelper.convertToJavaScriptArray(includeControls);
        setAttribute("includeControls", icJS);
    }

    /**
     * An array of Strings indicating the classNames of controls that should be specifically included when printing, even if a
     * superclass is listed in {@link com.smartgwt.client.widgets.util.PrintProperties#getOmitControls omitControls}.
     *
     *
     * @return Unhandled-Array of String
     */
    public String[] getIncludeControls()  {
        return JSOHelper.convertToJavaStringArray(getAttributeAsJavaScriptObject("includeControls"));
    }


}


