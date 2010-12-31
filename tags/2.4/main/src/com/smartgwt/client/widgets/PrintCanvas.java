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

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * PrintCanvas is a subclass of canvas which renders printable content HTML and  provides APIs for printing this content as
 * a separate document.
 * @see com.smartgwt.client.docs.Printing Printing overview and related methods
 */
public class PrintCanvas extends Canvas {

    public static PrintCanvas getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (PrintCanvas) obj;
        } else {
            return new PrintCanvas(jsObj);
        }
    }

    public PrintCanvas(){
        scClassName = "PrintCanvas";
    }

    public PrintCanvas(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Location of the special printFrame html file provided as part of the Smart GWT libraries. This file must be present at
     * the specified location for the printCanvas printing APIs.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param printFrameURL printFrameURL Default value is "[HELPERS]printFrame.html"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPrintFrameURL(String printFrameURL)  throws IllegalStateException {
        setAttribute("printFrameURL", printFrameURL, false);
    }

    /**
     * Location of the special printFrame html file provided as part of the Smart GWT libraries. This file must be present at
     * the specified location for the printCanvas printing APIs.
     *
     *
     * @return String
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

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes. 
     *
     * @param printCanvasProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(PrintCanvas printCanvasProperties) /*-{
        $wnd.isc.PrintCanvas.addProperties(printCanvasProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    }-*/;
        
    // ***********************************************************        


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
        $entry(function (printCanvas) {
        	var canvasJ = @com.smartgwt.client.widgets.PrintCanvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(printCanvas);
        	callback.@com.smartgwt.client.util.PrintCanvasCallback::execute(Lcom/smartgwt/client/widgets/PrintCanvas;)(canvasJ);
        })
         );
    }-*/;

}



