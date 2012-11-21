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
 * The Progressbar widget class extends the StretchImg class to implement image-based progress bars (graphical bars whose
 * lengths represent percentages, typically of task completion).
 */
public class Progressbar extends StretchImg  implements com.smartgwt.client.widgets.events.HasPercentChangedHandlers {

    public native static Progressbar getOrCreateRef(JavaScriptObject jsObj) /*-{

    	if(jsObj == null) return null;
    	
    	var instance = jsObj["__ref"];
    	
    	if(instance==undefined) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("Progressbar",jsObj);
        } else if(instance != null) {
            return instance;
        //} else {
        //    return @com.smartgwt.client.widgets.Progressbar::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }


    public Progressbar(){
        scClassName = "Progressbar";
    }

    public Progressbar(JavaScriptObject jsObj){
        scClassName = "Progressbar";
        setJavaScriptObject(jsObj);
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
     * Thickness of the progressbar in pixels. This is effectively width for a vertical progressbar, or height for a horizontal
     * progressbar. <P> This property must be set instead of setting <code>width</code> or <code>height</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the breadth of the progressbar to newLength. This is the height of a horizontal progressbar, or the width of a vertical progressbar.
     *
     * @param breadth the new breadth of the progressbar. Default value is 20
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setBreadth(int breadth) {
        setAttribute("breadth", breadth, true);
    }

    /**
     * Thickness of the progressbar in pixels. This is effectively width for a vertical progressbar, or height for a horizontal
     * progressbar. <P> This property must be set instead of setting <code>width</code> or <code>height</code>.
     *
     *
     * @return Returns the current height of a horizontal progressbar, or width of a vertical progressbar.
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getBreadth()  {
        return getAttributeAsInt("breadth");
    }

    /**
     * Length of the progressbar in pixels. This is effectively height for a vertical progressbar, or width for a horizontal
     * progressbar. <P> This property must be set instead of setting <code>width</code> or <code>height</code>.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the length of the progressbar to newLength. This is the width of a horizontal progressbar, or the height of a vertical progressbar.
     *
     * @param length the new length of the progressbar. Default value is 100
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setLength(int length) {
        setAttribute("length", length, true);
    }

    /**
     * Length of the progressbar in pixels. This is effectively height for a vertical progressbar, or width for a horizontal
     * progressbar. <P> This property must be set instead of setting <code>width</code> or <code>height</code>.
     *
     *
     * @return Returns the current width of a horizontal progressbar, or height of a vertical progressbar.
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getLength()  {
        return getAttributeAsInt("length");
    }

    /**
     * Number from 0 to 100, inclusive, for the percentage to be displayed graphically in this progressbar.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets percentDone to newPercent.
     *
     * @param percentDone percent to show as done (0-100). Default value is 0
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setPercentDone(int percentDone) {
        setAttribute("percentDone", percentDone, true);
    }

    /**
     * Number from 0 to 100, inclusive, for the percentage to be displayed graphically in this progressbar.
     *
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getPercentDone()  {
        return getAttributeAsInt("percentDone");
    }

    /**
     * The base file name for the progressbar image.
     *
     * @param src . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is "[SKIN]progressbar.gif"
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSrc(String src) {
        setAttribute("src", src, true);
    }

    /**
     * The base file name for the progressbar image.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    /**
     * Indicates whether this is a vertical or horizontal progressbar.
     *
     * @param vertical vertical Default value is false
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical, true);
    }

    /**
     * Indicates whether this is a vertical or horizontal progressbar.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }

    // ********************* Methods ***********************
    /**
     * Add a percentChanged handler.
     * <p>
     * This method is called when the percentDone value changes. Observe this method to be notified upon a change to the
     * percentDone value.
     *
     * @param handler the percentChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addPercentChangedHandler(com.smartgwt.client.widgets.events.PercentChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.PercentChangedEvent.getType()) == 0) setupPercentChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.PercentChangedEvent.getType());
    }

    private native void setupPercentChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
        var percentChanged = $entry(function(){
            var param = {};

                var event = @com.smartgwt.client.widgets.events.PercentChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({percentChanged:  percentChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.percentChanged =  percentChanged             ;
        }
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
     * @param progressbarProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Progressbar progressbarProperties) /*-{
    	var properties = $wnd.isc.addProperties({},progressbarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.Progressbar.addProperties(properties);
    }-*/;
        
    // ***********************************************************        

    public LogicalStructureObject setLogicalStructure(ProgressbarLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.breadth = getAttributeAsString("breadth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Progressbar.breadth:" + t.getMessage() + "\n";
        }
        try {
            s.length = getAttributeAsString("length");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Progressbar.length:" + t.getMessage() + "\n";
        }
        try {
            s.percentDone = getAttributeAsString("percentDone");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Progressbar.percentDone:" + t.getMessage() + "\n";
        }
        try {
            s.src = getAttributeAsString("src");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Progressbar.src:" + t.getMessage() + "\n";
        }
        try {
            s.vertical = getAttributeAsString("vertical");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Progressbar.vertical:" + t.getMessage() + "\n";
        }
        return s;
    }
    
    public LogicalStructureObject getLogicalStructure() {
        ProgressbarLogicalStructure s = new ProgressbarLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

