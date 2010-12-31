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
 
package com.smartgwt.client.widgets.layout;



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
 * SectionHeader class based on an HLayout with {@link com.smartgwt.client.widgets.StretchImg} background.
 */
public class ImgSectionHeader extends HLayout {

    public static ImgSectionHeader getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (ImgSectionHeader) obj;
        } else {
            return new ImgSectionHeader(jsObj);
        }
    }

    public ImgSectionHeader(){
        scClassName = "ImgSectionHeader";
    }

    public ImgSectionHeader(JavaScriptObject jsObj){
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

    // ********************* Methods ***********************
            
    /**
     * For a SectionHeader embedded in a SectionStack, this method will return  a pointer to the {@link
     * com.smartgwt.client.widgets.layout.SectionStack} in which this section header is embedded.
     *
     * @return Section Stack containing this section header
     */
    public native SectionStack getSectionStack() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getSectionStack();
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.layout.SectionStack::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes. 
     *
     * @param imgSectionHeaderProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(ImgSectionHeader imgSectionHeaderProperties) /*-{
        $wnd.isc.ImgSectionHeader.addProperties(imgSectionHeaderProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    }-*/;
        
    // ***********************************************************        


    /**
     * Set the controls.
     *
     * @param controls the controls
     * @throws IllegalStateException
     */
    public void setControls(Canvas... controls) throws IllegalStateException {
        setAttribute("controls", controls, false);
    }

    /**
     * Retrieve the SectionStackSection associated with this header
     * @return the SectionStackSection for the section header
     */
    public native SectionStackSection getSection () /*-{
    	var jsObj = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
    	if (jsObj == null) return null;
    	var section = jsObj.getSectionConfig != null ? jsObj.getSectionConfig() : null;
	    if (section == null) return null;
	    return @com.smartgwt.client.widgets.layout.SectionStackSection::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(section);
    }-*/;

}




