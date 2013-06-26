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
 
package com.smartgwt.client.widgets;


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
 * PrintCanvas is a subclass of canvas which renders printable content HTML and  provides APIs for printing this content as
 * a separate document.
 * @see com.smartgwt.client.docs.Printing Printing overview and related methods
 */
public class PrintCanvas extends Canvas {

    public native static PrintCanvas getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("PrintCanvas",jsObj);
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
        $wnd.isc["PrintCanvas"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc["PrintCanvas"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public PrintCanvas(){
        scClassName = "PrintCanvas";
    }

    public PrintCanvas(JavaScriptObject jsObj){
        scClassName = "PrintCanvas";
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
     * Setting this property will cause the specified stylesheet to be loaded in this print canvas's frame. The stylesheet
     * should be specified as a URL to load.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param externalStylesheet . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setExternalStylesheet(String externalStylesheet) {
        setAttribute("externalStylesheet", externalStylesheet, true);
    }

    /**
     * Setting this property will cause the specified stylesheet to be loaded in this print canvas's frame. The stylesheet
     * should be specified as a URL to load.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getExternalStylesheet()  {
        return getAttributeAsString("externalStylesheet");
    }


    /**
     * Location of the special printFrame html file provided as part of the Smart GWT libraries. This file must be present at
     * the specified location for the printCanvas printing APIs.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param printFrameURL . See {@link com.smartgwt.client.docs.String String}. Default value is "[HELPERS]printFrame.html"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPrintFrameURL(String printFrameURL)  throws IllegalStateException {
        setAttribute("printFrameURL", printFrameURL, false);
    }

    /**
     * Location of the special printFrame html file provided as part of the Smart GWT libraries. This file must be present at
     * the specified location for the printCanvas printing APIs.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getPrintFrameURL()  {
        return getAttributeAsString("printFrameURL");
    }

    // ********************* Methods ***********************
	/**
     * Show the native print dialog and allow the user to print the current HTML for this printCanvas. Note that the
     * PrintCanvas must be drawn to be printed.
     */
    public native void print() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.print();
    }-*/;
	/**
     * Update the HTML content displayed in this print canvas. If the printCanvas is not yet drawn the HTML will be displayed
     * when the canvas is drawn.
     * @param HTML HTML to show in this print canvas
     * @param callback callback function to fire when the HTML is displayed. The  callback will be passed a pointer to this print canvas as the
     * first parameter with the  name <code>printPreview</code>. If this canvas is not drawn when this method is called,  the
     * callback will not be fired until the canvas is drawn and the HTML rendered out into  the page.
     */
    public native void setHTML(String HTML, PrintCanvasCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setHTML(HTML, 
			$entry( function(printCanvas) { 
				if(callback!=null) callback.@com.smartgwt.client.util.PrintCanvasCallback::execute(Lcom/smartgwt/client/widgets/PrintCanvas;)(
					@com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(printCanvas)
				);
			}));
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
     * @param printCanvasProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(PrintCanvas printCanvasProperties) /*-{
    	var properties = $wnd.isc.addProperties({},printCanvasProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.PrintCanvas.addProperties(properties);
    }-*/;

    // ***********************************************************

    public LogicalStructureObject setLogicalStructure(PrintCanvasLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.externalStylesheet = getAttributeAsString("externalStylesheet");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PrintCanvas.externalStylesheet:" + t.getMessage() + "\n";
        }
        try {
            s.printFrameURL = getAttributeAsString("printFrameURL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PrintCanvas.printFrameURL:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        PrintCanvasLogicalStructure s = new PrintCanvasLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

