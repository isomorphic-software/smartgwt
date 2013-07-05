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
 
package com.smartgwt.client.widgets.drawing;


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
 * Container for DrawLine, DrawOval, DrawPath, and other DrawItem-based components. These components provide consistent
 * cross-browser APIs for rendering shapes using using the browsers' built in vector graphics capabilities. These include
 * <code>SVG (Scalable Vector Graphics)</code> where available, <code>VML (Vector Markup Language)</code> for Microsoft
 * browsers, and the HTML5 <code>&lt;canvas&gt;</code> tag. <P> You can use any of the following approaches to create
 * DrawPanes and DrawItems: <P> <dl> <dt>DrawPane only</dt> <dd> Create a DrawPane with drawItems set to an array of
 * DrawItem instances or DrawItem declaration objects, and it will manage those DrawItems. </dd> <dt>DrawItem only</dt>
 * <dd> Create and draw a DrawItem, and it will use a default DrawPane, which you can      access via the drawPane
 * property, eg myDrawItem.drawPane.bringToFront().</dd> <dt>Both</dt> <dd>Create DrawPanes with or without initial
 * drawItems, then create DrawItems     with their drawPane property set to an existing DrawPane instance.</dd> </dl> <p>To
 * use DrawPane in SmartGWT, include the Drawing module in your application by including <code>&lt;inherits
 * name="com.smartgwt.Drawing"/&gt;</code> in your GWT module XML. </p>
 */
public class DrawPane extends Canvas {

    public native static DrawPane getOrCreateRef(JavaScriptObject jsObj) /*-{
        if (jsObj == null) return null;
        var instance = jsObj["__ref"];
        if (instance == null) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("DrawPane",jsObj);
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
        $wnd.isc["DrawPane"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc["DrawPane"].changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public DrawPane(){
        scClassName = "DrawPane";
    }

    public DrawPane(JavaScriptObject jsObj){
        scClassName = "DrawPane";
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
     * In order to enable dragging of drawItems, this property must be set to true, in addition to {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag}.
     *
     * @param canDrag canDrag Default value is false
     */
    public void setCanDrag(Boolean canDrag) {
        setAttribute("canDrag", canDrag, true);
    }

    /**
     * In order to enable dragging of drawItems, this property must be set to true, in addition to {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getCanDrag canDrag}.
     *
     * @return Boolean
     */
    public Boolean getCanDrag()  {
        return getAttributeAsBoolean("canDrag");
    }


    /**
     * Array of DrawItems to initially display in this DrawPane.
     *
     * @param drawItems drawItems Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDrawItems(DrawItem... drawItems)  throws IllegalStateException {
        setAttribute("drawItems", drawItems, false);
    }

    /**
     * Array of DrawItems to initially display in this DrawPane.
     *
     * @return DrawItem
     */
    public DrawItem[] getDrawItems()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfDrawItem(getAttributeAsJavaScriptObject("drawItems"));
    }


    /**
     * Rotation for the DrawPane as a whole, in degrees.  Applied to all DrawItems.
     *
     * @param rotation rotation Default value is 0
     */
    public void setRotation(float rotation) {
        setAttribute("rotation", rotation, true);
    }

    /**
     * Rotation for the DrawPane as a whole, in degrees.  Applied to all DrawItems.
     *
     * @return float
     */
    public float getRotation()  {
        return getAttributeAsFloat("rotation");
    }


    /**
     * Zoom for the drawPane as a whole, where 1 is normal size.  Applied to all DrawItems.
     *
     * @param zoomLevel zoomLevel Default value is 1
     */
    public void setZoomLevel(float zoomLevel) {
        setAttribute("zoomLevel", zoomLevel, true);
    }

    /**
     * Zoom for the drawPane as a whole, where 1 is normal size.  Applied to all DrawItems.
     *
     * @return float
     */
    public float getZoomLevel()  {
        return getAttributeAsFloat("zoomLevel");
    }

    // ********************* Methods ***********************
	/**
     * Add a drawItem to this drawPane (if necessary removing it from any other drawPanes)
     * @param item drawItem to add
     * @param autoDraw If explicitly set to false, and this drawPane is drawn, don't draw   the newly added item
     */
    public native void addDrawItem(DrawItem item, boolean autoDraw) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addDrawItem(item.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()(), autoDraw == null ? false : autoDraw);
    }-*/;
	/**
     * Creates a linear gradient which can be used within any DrawItem  Any DrawItems fillGradient can reference this gradient
     * by the given name.
     * @param id the name of the linear gradient
     * @param linearGradient the linear gradient
     *
     * @return id
     */
    public native String createLinearGradient(String id, LinearGradient linearGradient) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.createLinearGradient(id, linearGradient.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	/**
     * Creates a radial gradient which can be used within any DrawItem  Any DrawItems fillGradient can reference this gradient
     * by the given name.
     * @param id the name of the radial gradient
     * @param radialGradient the radial gradient
     *
     * @return id
     */
    public native String createRadialGradient(String id, RadialGradient radialGradient) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.createRadialGradient(id, radialGradient.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	/**
     * Creates a simple linear gradient which can be used within any DrawItem  Any DrawItems fillGradient can reference this
     * gradient by the given name.
     * @param id the name of the linear gradient
     * @param simple 
     *
     * @return id
     */
    public native String createSimpleGradient(String id, SimpleGradient simple) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.createSimpleGradient(id, simple.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	/**
     * Permanently {@link com.smartgwt.client.widgets.drawing.DrawItem#destroy destroy} all DrawItems currently associated with
     * this DrawPane, leaving the DrawPane itself intact
     */
    public native void destroyItems() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.destroyItems();
    }-*/;
	/**
     * Call {@link com.smartgwt.client.widgets.drawing.DrawItem#erase DrawItem.erase} on all DrawItems currently associated
     * with the DrawPane.   <P> The DrawItems will continue to exist, and you can call draw() on them to make them appear
     * again, or {@link com.smartgwt.client.widgets.drawing.DrawItem#destroy destroy} to get rid of them permanetly.  Use
     * {@link com.smartgwt.client.widgets.drawing.DrawPane#destroyItems DrawPane.destroyItems} to permanently get rid of all
     * DrawItems.
     */
    public native void erase() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.erase();
    }-*/;
	/**
     * Get a "data:" URL encoding the current contents of the DrawPane as a PNG file. <p> The returned "data:" URLs can be used
     * anywhere a URL to an image is valid, for example, {@link com.smartgwt.client.widgets.Img#getSrc src}. <p> This method
     * will directly return the data URL on modern browsers when using &lt;canvas&gt;-style rendering (the default). <p> On
     * legacy browers (any version of IE in "quirks" mode, all versions of IE prior to 9.0), data URL generation requires a
     * server trip and requires the Smart GWT Server to be installed with the same set of {@link
     * com.smartgwt.client.docs.JavaModuleDependencies required .jars} as are required for PDF export of charts in legacy IE. 
     * The method will return null and a callback must be passed, which fires when the data URL has been retrieved from the
     * server. <p> If the callback is passed but no server trip is required, the callback is fired immediately. <p> For
     * obtaining PNG or other image data for use in server-side processing (such as attaching to automated emails or saving to
     * a database), see also the server-side APIs in com.isomorphic.contentexport.ImageExport.
     *
     * @return the data URL (on modern browsers)
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#chart_image_export" target="examples">Chart Image Export Example</a>
     */
    public native String getDataURL() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDataURL();
        return ret;
    }-*/;
	/**
     * Get a "data:" URL encoding the current contents of the DrawPane as a PNG file. <p> The returned "data:" URLs can be used
     * anywhere a URL to an image is valid, for example, {@link com.smartgwt.client.widgets.Img#getSrc src}. <p> This method
     * will directly return the data URL on modern browsers when using &lt;canvas&gt;-style rendering (the default). <p> On
     * legacy browers (any version of IE in "quirks" mode, all versions of IE prior to 9.0), data URL generation requires a
     * server trip and requires the Smart GWT Server to be installed with the same set of {@link
     * com.smartgwt.client.docs.JavaModuleDependencies required .jars} as are required for PDF export of charts in legacy IE. 
     * The method will return null and a callback must be passed, which fires when the data URL has been retrieved from the
     * server. <p> If the callback is passed but no server trip is required, the callback is fired immediately. <p> For
     * obtaining PNG or other image data for use in server-side processing (such as attaching to automated emails or saving to
     * a database), see also the server-side APIs in com.isomorphic.contentexport.ImageExport.
     * @param callback callback to fire when data url is available
     *
     * @return the data URL (on modern browsers)
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#chart_image_export" target="examples">Chart Image Export Example</a>
     */
    public native String getDataURL(DataURLCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getDataURL(
			$entry( function(dataURL) { 
				if(callback!=null) callback.@com.smartgwt.client.widgets.drawing.DataURLCallback::execute(Ljava/lang/String;)(
					dataURL
				);
			}));
        return ret;
    }-*/;
	/**
     * Converts this DrawPane to the source of an <code>&lt;svg&gt;</code> element equivalent to the current drawing. <p> In
     * Pro edition and above, the returned string can be used with {@link com.smartgwt.client.rpc.RPCManager#exportImage
     * RPCManager.exportImage} to download an image, or with server-side APIs in com.isomorphic.contentexport.ImageExport to
     * obtain various kinds of images for further server-side processing.
     *
     * @return the source of an <code>&lt;svg&gt;</code> element.
     * @see <a href="http://www.smartclient.com/smartgwtee/showcase/#chart_image_export" target="examples">Chart Image Export Example</a>
     */
    public native String getSvgString() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSvgString();
        return ret;
    }-*/;
	/**
     * Zoom this drawPane to the specified magnification, maintaining the current viewport position
     * @param zoom Desired zoom level as a float where <code>1.0</code> is equivalent to 100%  magnification.
     */
    public native void zoom(float zoom) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.zoom(zoom);
    }-*/;

	/**
     * Zoom this drawPane to the specified magnification, maintaining the current viewport position
     * @param zoom Desired zoom level as a float where <code>1.0</code> is equivalent to 100%  magnification.
     */
    public native void zoom(double zoom) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.zoom(zoom);
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
     * @param drawPaneProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(DrawPane drawPaneProperties) /*-{
    	var properties = $wnd.isc.addProperties({},drawPaneProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.DrawPane.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * Retrieves printable HTML for this component and all printable subcomponents.
     * <p>
     * By default any Canvas with children will simply collect the printable HTML of its
     * children by calling getPrintHTML() on each child that is considered
     * {@link com.smartgwt.client.widgets.Canvas#getShouldPrint printable}.
     * <p>
     * If overriding this method for a custom component, you should <b>either</b> return a String of
     * printable HTML string directly <b>or</b> return null, and fire the callback (if provided).
     * <p>
     * To return an empty print representation, return an empty string ("") rather than null.
     * <p>
     * The <code>printProperties</code> argument, if passed, must be passed to any subcomponents on
     * which <code>getPrintHTML()</code> is called.
     * <p>
     * <b>Notes on printing</b>
     * <p>
     * To print a <code>DrawPane</code> for export on IE8 and earlier, it is 
     * {@link com.smartgwt.client.util.PrintProperties} with {@link com.smartgwt.client.util.PrintProperties#getPrintForExport
     * printForExport}:true:
     * <pre>
     * final PrintProperties pp = new PrintProperties();
     * pp.setPrintForExport(true);
     * final String exportHTML = drawPane.getPrintHTML(pp, null);
     * </pre>
     * <p>
     * <b>Note: this is an override point.</b>
     * @param printProperties properties to configure printing behavior - may be null.
     * @param callback optional callback to fire. Generated HTML should be passed to the
     * {@link com.smartgwt.client.util.PrintHTMLCallback#setHTML(String)} method of the callback.
     * @see com.smartgwt.client.docs.Printing Printing overview and related methods
     */
    public String getPrintHTML(PrintProperties printProperties, PrintHTMLCallback callback) {
        return super.getPrintHTML(printProperties, callback);
    }

    public LogicalStructureObject setLogicalStructure(DrawPaneLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.canDrag = getAttributeAsString("canDrag");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPane.canDrag:" + t.getMessage() + "\n";
        }
        try {
            s.drawItems = getDrawItems();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPane.drawItemsArray:" + t.getMessage() + "\n";
        }
        try {
            s.rotation = getAttributeAsString("rotation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPane.rotation:" + t.getMessage() + "\n";
        }
        try {
            s.zoomLevel = getAttributeAsString("zoomLevel");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawPane.zoomLevel:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        DrawPaneLogicalStructure s = new DrawPaneLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

