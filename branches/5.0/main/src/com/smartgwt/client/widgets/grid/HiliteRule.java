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
 
package com.smartgwt.client.widgets.grid;


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
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * A widget for editing the criteria of a single {@link com.smartgwt.client.widgets.DataBoundComponent} hilite.   The
 * default implementation presents a series of {@link com.smartgwt.client.widgets.form.fields.FormItem formItems} for
 * selecting the various elements of a simple criterion and a foreground or background color.  To specify more complex
 * criteria, specify both foreground and background colors or to apply the hilite to multiple fields, you can create an 
 * {@link com.smartgwt.client.widgets.grid.AdvancedHiliteEditor advanced hilite rule}. <P> <i><b>Important Note:</b> this
 * class should not be used directly - it is exposed purely for {@link i18nMessages i18n reasons.}</i>
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("HiliteRule")
public class HiliteRule extends HLayout {

    public static HiliteRule getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new HiliteRule(jsObj);
        } else {
            assert refInstance instanceof HiliteRule;
            return (HiliteRule)refInstance;
        }
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
        $wnd.isc.HiliteRule.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.HiliteRule.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public HiliteRule(){
        scClassName = "HiliteRule";
    }

    public HiliteRule(JavaScriptObject jsObj){
        scClassName = "HiliteRule";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************
    
    

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle title} of the 'Background' color picker.
     *
     * @param backgroundColorTitle  Default value is "Background"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setBackgroundColorTitle(String backgroundColorTitle)  throws IllegalStateException {
        setAttribute("backgroundColorTitle", backgroundColorTitle, false);
    }

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle title} of the 'Background' color picker.
     *
     * @return String
     */
    public String getBackgroundColorTitle()  {
        return getAttributeAsString("backgroundColorTitle");
    }
    
    

    /**
     * The title for the Color picker field.
     *
     * @param colorFieldTitle  Default value is "Color"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setColorFieldTitle(String colorFieldTitle)  throws IllegalStateException {
        setAttribute("colorFieldTitle", colorFieldTitle, false);
    }

    /**
     * The title for the Color picker field.
     *
     * @return String
     */
    public String getColorFieldTitle()  {
        return getAttributeAsString("colorFieldTitle");
    }
    

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle title} of the 'Text' color picker.
     *
     * @param foregroundColorTitle  Default value is "Text"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setForegroundColorTitle(String foregroundColorTitle)  throws IllegalStateException {
        setAttribute("foregroundColorTitle", foregroundColorTitle, false);
    }

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle title} of the 'Text' color picker.
     *
     * @return String
     */
    public String getForegroundColorTitle()  {
        return getAttributeAsString("foregroundColorTitle");
    }
    
    

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle title} of the 'Icon' picker.
     *
     * @param iconFieldTitle  Default value is "Icon"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIconFieldTitle(String iconFieldTitle)  throws IllegalStateException {
        setAttribute("iconFieldTitle", iconFieldTitle, false);
    }

    /**
     * The {@link com.smartgwt.client.widgets.form.fields.FormItem#getTitle title} of the 'Icon' picker.
     *
     * @return String
     */
    public String getIconFieldTitle()  {
        return getAttributeAsString("iconFieldTitle");
    }
    
    

    /**
     * The hover prompt text for the {@link com.smartgwt.client.widgets.grid.HiliteRule#getRemoveButton remove button}.
     *
     * @param removeButtonPrompt  Default value is "Remove"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRemoveButtonPrompt(String removeButtonPrompt)  throws IllegalStateException {
        setAttribute("removeButtonPrompt", removeButtonPrompt, false);
    }

    /**
     * The hover prompt text for the {@link com.smartgwt.client.widgets.grid.HiliteRule#getRemoveButton remove button}.
     *
     * @return String
     */
    public String getRemoveButtonPrompt()  {
        return getAttributeAsString("removeButtonPrompt");
    }
    

    /**
     * If true, show a {@link com.smartgwt.client.widgets.grid.HiliteRule#getRemoveButton button} for this HiliteRule, allowing
     * it  to be removed.
     *
     * @param showRemoveButton  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowRemoveButton(boolean showRemoveButton)  throws IllegalStateException {
        setAttribute("showRemoveButton", showRemoveButton, false);
    }

    /**
     * If true, show a {@link com.smartgwt.client.widgets.grid.HiliteRule#getRemoveButton button} for this HiliteRule, allowing
     * it  to be removed.
     *
     * @return boolean
     */
    public boolean getShowRemoveButton()  {
        Boolean result = getAttributeAsBoolean("showRemoveButton");
        return result == null ? true : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Return the hilite definition being edited, including criteria and hilite properties.
     *
     * @return the hilite
     */
    public native Hilite getHilite() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getHilite();
        if(ret == null) return null;
        return @com.smartgwt.client.data.Hilite::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Remove this HiliteRule.  Default implementation calls markForDestroy().
     */
    public native void remove() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.remove();
    }-*/;


    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param hiliteRuleProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(HiliteRule hiliteRuleProperties) /*-{
    	var properties = $wnd.isc.addProperties({},hiliteRuleProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.HiliteRule.addProperties(properties);
    }-*/;

    // ***********************************************************

    public LogicalStructureObject setLogicalStructure(HiliteRuleLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.backgroundColorTitle = getAttributeAsString("backgroundColorTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteRule.backgroundColorTitle:" + t.getMessage() + "\n";
        }
        try {
            s.colorFieldTitle = getAttributeAsString("colorFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteRule.colorFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.foregroundColorTitle = getAttributeAsString("foregroundColorTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteRule.foregroundColorTitle:" + t.getMessage() + "\n";
        }
        try {
            s.iconFieldTitle = getAttributeAsString("iconFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteRule.iconFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.removeButtonPrompt = getAttributeAsString("removeButtonPrompt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteRule.removeButtonPrompt:" + t.getMessage() + "\n";
        }
        try {
            s.showRemoveButton = getAttributeAsString("showRemoveButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HiliteRule.showRemoveButton:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        HiliteRuleLogicalStructure s = new HiliteRuleLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

