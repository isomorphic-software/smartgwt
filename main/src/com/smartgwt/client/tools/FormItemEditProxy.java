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
 
package com.smartgwt.client.tools;


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
 * {@link com.smartgwt.client.tools.EditProxy} that handles {@link com.smartgwt.client.widgets.form.fields.FormItem}s when
 * editMode is enabled.
 * @see com.smartgwt.client.docs.DevTools DevTools overview and related methods
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("FormItemEditProxy")
public class FormItemEditProxy extends EditProxy {

    public static FormItemEditProxy getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (FormItemEditProxy) obj;
        } else {
            return new FormItemEditProxy(jsObj);
        }
    }


    public FormItemEditProxy(){
        scClassName = "FormItemEditProxy";
    }

    public FormItemEditProxy(JavaScriptObject jsObj){
        scClassName = "FormItemEditProxy";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this FormItem edits the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}, character that should be used as a
     * separator for
     *  entering {@link com.smartgwt.client.types.ValueMap}s that map from a stored value to a user-displayed value.
     *  <p>
     *  With the default of ":", the following input:
     *  <pre>
     *       1:Fixed, 2:Won't Fix, 3:Resolved
     *  </pre>
     *  Would be assumed to be a mapping like this (expressed in JSON):
     *  <pre>
     *    {
     *       "1" : "Fixed",
     *       "2" : "Won't Fix",
     *       "3" : "Resolved"
     *    }
     *  </pre>
     *  <p>
     *  If the input has inconsistent use of the separator char, the input will be assumed
     *  to be stored-to-displayed mapping if the separator char is present in a majority
     *  of values, and any values that lack a separator will use the same value for
     *  storage and display.  For example, for this input:
     *  <pre>
     *        Fixed:Reported Fixed, WontFix:Won't Fix, Resolved
     *  </pre>
     *  The resulting <code>valueMap</code> would be:
     *  <pre>
     *    {
     *       "Fixed" : "Reported Fixed",
     *       "WontFix" : "Won't Fix",
     *       "Resolved" : "Resolved"
     *    }
     *  </pre>
     *  <p>
     * The {@link com.smartgwt.client.tools.FormItemEditProxy#getValueMapEscapeChar valueMapEscapeChar} can be used to enter
     * literal colon characters.
     *  <p>
     *  Set <code>valueMapDisplaySeparatorChar</code> to null to prevent entry of stored
     *  vs displayed values - user input will always be treated as just a list of legal
     *  values.
     *
     * @param valueMapDisplaySeparatorChar  Default value is ":"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValueMapDisplaySeparatorChar(String valueMapDisplaySeparatorChar)  throws IllegalStateException {
        setAttribute("valueMapDisplaySeparatorChar", valueMapDisplaySeparatorChar, false);
    }

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this FormItem edits the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}, character that should be used as a
     * separator for
     *  entering {@link com.smartgwt.client.types.ValueMap}s that map from a stored value to a user-displayed value.
     *  <p>
     *  With the default of ":", the following input:
     *  <pre>
     *       1:Fixed, 2:Won't Fix, 3:Resolved
     *  </pre>
     *  Would be assumed to be a mapping like this (expressed in JSON):
     *  <pre>
     *    {
     *       "1" : "Fixed",
     *       "2" : "Won't Fix",
     *       "3" : "Resolved"
     *    }
     *  </pre>
     *  <p>
     *  If the input has inconsistent use of the separator char, the input will be assumed
     *  to be stored-to-displayed mapping if the separator char is present in a majority
     *  of values, and any values that lack a separator will use the same value for
     *  storage and display.  For example, for this input:
     *  <pre>
     *        Fixed:Reported Fixed, WontFix:Won't Fix, Resolved
     *  </pre>
     *  The resulting <code>valueMap</code> would be:
     *  <pre>
     *    {
     *       "Fixed" : "Reported Fixed",
     *       "WontFix" : "Won't Fix",
     *       "Resolved" : "Resolved"
     *    }
     *  </pre>
     *  <p>
     * The {@link com.smartgwt.client.tools.FormItemEditProxy#getValueMapEscapeChar valueMapEscapeChar} can be used to enter
     * literal colon characters.
     *  <p>
     *  Set <code>valueMapDisplaySeparatorChar</code> to null to prevent entry of stored
     *  vs displayed values - user input will always be treated as just a list of legal
     *  values.
     *
     * @return String
     */
    public String getValueMapDisplaySeparatorChar()  {
        return getAttributeAsString("valueMapDisplaySeparatorChar");
    }
    

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this FormItem edits the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}, character that can be used to enter literal
     * separator chars (such as the {@link com.smartgwt.client.tools.FormItemEditProxy#getValueMapSeparatorChar
     * valueMapSeparatorChar}) or literal leading or trailing whitespace. <p> Repeat this character twice to enter it
     * literally.  For example, with the default of "\", inputting "\\" would result in a literal backslash in the value.
     *
     * @param valueMapEscapeChar  Default value is "\"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValueMapEscapeChar(String valueMapEscapeChar)  throws IllegalStateException {
        setAttribute("valueMapEscapeChar", valueMapEscapeChar, false);
    }

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this FormItem edits the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}, character that can be used to enter literal
     * separator chars (such as the {@link com.smartgwt.client.tools.FormItemEditProxy#getValueMapSeparatorChar
     * valueMapSeparatorChar}) or literal leading or trailing whitespace. <p> Repeat this character twice to enter it
     * literally.  For example, with the default of "\", inputting "\\" would result in a literal backslash in the value.
     *
     * @return String
     */
    public String getValueMapEscapeChar()  {
        return getAttributeAsString("valueMapEscapeChar");
    }
    

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this FormItem edits the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}, character that can be used to mark the
     * default selected
     *  option.  Can appear before or after a value, for example, with this input:
     *  <pre>
     *      Fixed,Won't Fix,Resolved*
     *  </pre>
     *  "Resolved" would be the default selected value.
     *  <p>
     *  If multiple values are marked selected for a SelectItem,
     *  {@link com.smartgwt.client.widgets.form.fields.SelectItem#getMultiple multiple} will automatically be set.
     *  <p>
     * The {@link com.smartgwt.client.tools.FormItemEditProxy#getValueMapEscapeChar valueMapEscapeChar} can be used to allow
     * the
     *  <code>valueMapSelectedChar</code> to appear at the beginning or end of a  
     *  valueMap value.
     *
     * @param valueMapSelectedChar  Default value is "*"
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValueMapSelectedChar(String valueMapSelectedChar)  throws IllegalStateException {
        setAttribute("valueMapSelectedChar", valueMapSelectedChar, false);
    }

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this FormItem edits the
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}, character that can be used to mark the
     * default selected
     *  option.  Can appear before or after a value, for example, with this input:
     *  <pre>
     *      Fixed,Won't Fix,Resolved*
     *  </pre>
     *  "Resolved" would be the default selected value.
     *  <p>
     *  If multiple values are marked selected for a SelectItem,
     *  {@link com.smartgwt.client.widgets.form.fields.SelectItem#getMultiple multiple} will automatically be set.
     *  <p>
     * The {@link com.smartgwt.client.tools.FormItemEditProxy#getValueMapEscapeChar valueMapEscapeChar} can be used to allow
     * the
     *  <code>valueMapSelectedChar</code> to appear at the beginning or end of a  
     *  valueMap value.
     *
     * @return String
     */
    public String getValueMapSelectedChar()  {
        return getAttributeAsString("valueMapSelectedChar");
    }
    

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this FormItem edits the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}, character that should be used as a separator
     * between values, or between pairs of stored vs display values if the user is entering such a {@link
     * com.smartgwt.client.types.ValueMap} using the {@link
     * com.smartgwt.client.tools.FormItemEditProxy#getValueMapDisplaySeparatorChar valueMapDisplaySeparatorChar}. <p> If {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditMultiline inlineEditMultiline} is enabled, newlines will be used as
     * value separators and the <code>valueMapSeparatorChar</code> <p> The {@link
     * com.smartgwt.client.tools.FormItemEditProxy#getValueMapEscapeChar valueMapEscapeChar} can be used to enter the separator
     * char as part of a valueMap value.
     *
     * @param valueMapSeparatorChar  Default value is ","
     * @throws IllegalStateException this property cannot be changed after the underlying component has been created
     */
    public void setValueMapSeparatorChar(String valueMapSeparatorChar)  throws IllegalStateException {
        setAttribute("valueMapSeparatorChar", valueMapSeparatorChar, false);
    }

    /**
     * If {@link com.smartgwt.client.types.InlineEditEvent inline editing} for this FormItem edits the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getValueMap valueMap}, character that should be used as a separator
     * between values, or between pairs of stored vs display values if the user is entering such a {@link
     * com.smartgwt.client.types.ValueMap} using the {@link
     * com.smartgwt.client.tools.FormItemEditProxy#getValueMapDisplaySeparatorChar valueMapDisplaySeparatorChar}. <p> If {@link
     * com.smartgwt.client.tools.EditProxy#getInlineEditMultiline inlineEditMultiline} is enabled, newlines will be used as
     * value separators and the <code>valueMapSeparatorChar</code> <p> The {@link
     * com.smartgwt.client.tools.FormItemEditProxy#getValueMapEscapeChar valueMapEscapeChar} can be used to enter the separator
     * char as part of a valueMap value.
     *
     * @return String
     */
    public String getValueMapSeparatorChar()  {
        return getAttributeAsString("valueMapSeparatorChar");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}


