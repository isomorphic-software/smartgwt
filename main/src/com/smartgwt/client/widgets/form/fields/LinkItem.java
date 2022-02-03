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
 
package com.smartgwt.client.widgets.form.fields;


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
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
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
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A form item that displays a URL. In the default read-only mode ({@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is <code>false</code>) the URL is shown as a link;
 * in editable mode the URL is shown in a textbox. <P> The link to open is specified as the item value with {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#setValue FormItem.setValue()} or  {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue FormItem.defaultValue}. The link title defaults to the
 * URL unless {@link com.smartgwt.client.widgets.form.fields.LinkItem#getLinkTitle linkTitle} is specified. <P>
 * Additionally, a custom action can be triggered when the link is clicked: see {@link
 * com.smartgwt.client.widgets.form.fields.LinkItem#getTarget target} for details.
 */
@BeanFactory.FrameworkClass
public class LinkItem extends StaticTextItem {

    public static LinkItem getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof LinkItem) {
            existingObj.setJsObj(jsObj);
            return (LinkItem)existingObj;
        } else

        {
            return new LinkItem(jsObj);
        }
    }
        


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(LinkItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.LinkItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(LinkItem.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.LinkItem.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public static native void changePickerIconDefaults(FormItemIcon defaults) /*-{
        $wnd.isc.LinkItem.changeDefaults("pickerIconDefaults", defaults.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    public LinkItem(){
        setAttribute("editorType", "LinkItem");
    }

    public LinkItem(JavaScriptObject jsObj){
        super(jsObj);
    }


    public LinkItem(String name) {
        setName(name);
                setAttribute("editorType", "LinkItem");
    }


    // ********************* Properties / Attributes ***********************

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit FormItem.canEdit} is set to false, should {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} be disabled by default? <P> This may also be specified
     * at the icon level. See {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getDisableOnReadOnly
     * FormItemIcon.disableOnReadOnly}.
     *
     * @param disableIconsOnReadOnly New disableIconsOnReadOnly value. Default value is false
     */
    public void setDisableIconsOnReadOnly(Boolean disableIconsOnReadOnly) {
        setAttribute("disableIconsOnReadOnly", disableIconsOnReadOnly);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit FormItem.canEdit} is set to false, should {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} be disabled by default? <P> This may also be specified
     * at the icon level. See {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getDisableOnReadOnly
     * FormItemIcon.disableOnReadOnly}.
     *
     * @return Current disableIconsOnReadOnly value. Default value is false
     */
    public Boolean getDisableIconsOnReadOnly()  {
        Boolean result = getAttributeAsBoolean("disableIconsOnReadOnly", true);
        return result == null ? false : result;
    }
    

    /**
     * How should icons be aligned vertically for this form item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param iconVAlign New iconVAlign value. Default value is "center"
     */
    public void setIconVAlign(VerticalAlignment iconVAlign) {
        setAttribute("iconVAlign", iconVAlign == null ? null : iconVAlign.getValue());
    }

    /**
     * How should icons be aligned vertically for this form item.
     *
     * @return Current iconVAlign value. Default value is "center"
     */
    public VerticalAlignment getIconVAlign()  {
        return EnumUtil.getEnum(VerticalAlignment.values(), getAttribute("iconVAlign"));
    }
    

    /**
     * Optional title HTML to display for this item's link. If unset, the <code>LinkItem</code>'s value (the URL) will be used
     * for the link's title.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.form.fields.LinkItem#getLinkTitle linkTitle}.
     *
     * @param linkTitle new <code>linkTitle</code> HTML. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setLinkTitle(String linkTitle) {
        setAttribute("linkTitle", linkTitle);
    }

    /**
     * Optional title HTML to display for this item's link. If unset, the <code>LinkItem</code>'s value (the URL) will be used
     * for the link's title.
     *
     * @return Current linkTitle value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getLinkTitle()  {
        return getAttributeAsString("linkTitle");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is set to <code>false</code>, how should
     * this <code>LinkItem</code> be displayed to the user? <p> Link items are, by default, canEdit:false. Note that the link
     * remains active regardless of the <code>readOnlyDisplay</code> setting.
     *
     * @param readOnlyDisplay New readOnlyDisplay value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#setReadOnlyDisplay
     */
    public void setReadOnlyDisplay(ReadOnlyDisplayAppearance readOnlyDisplay) {
        setAttribute("readOnlyDisplay", readOnlyDisplay == null ? null : readOnlyDisplay.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is set to <code>false</code>, how should
     * this <code>LinkItem</code> be displayed to the user? <p> Link items are, by default, canEdit:false. Note that the link
     * remains active regardless of the <code>readOnlyDisplay</code> setting.
     *
     * @return Current readOnlyDisplay value. Default value is null
     * @see com.smartgwt.client.widgets.form.DynamicForm#getReadOnlyDisplay
     */
    public ReadOnlyDisplayAppearance getReadOnlyDisplay()  {
        return EnumUtil.getEnum(ReadOnlyDisplayAppearance.values(), getAttribute("readOnlyDisplay"));
    }
    

    /**
     * By default, clicking a link rendered by this item opens it in a new browser window.  You  can alter this behavior by
     * setting this property.  The value of this property will be  passed as the value to the <code>target</code> attribute of
     * the anchor tag used to render  the link. <P> If you set linkItem.target to "javascript", the default behaviour is to
     * catch and consume mouse-clicks that would result in the link being followed.  Instead, the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addClickHandler FormItem.click()} event is fired.
     *
     * @param target New target value. Default value is "_blank"
     */
    public void setTarget(String target) {
        setAttribute("target", target);
    }

    /**
     * By default, clicking a link rendered by this item opens it in a new browser window.  You  can alter this behavior by
     * setting this property.  The value of this property will be  passed as the value to the <code>target</code> attribute of
     * the anchor tag used to render  the link. <P> If you set linkItem.target to "javascript", the default behaviour is to
     * catch and consume mouse-clicks that would result in the link being followed.  Instead, the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addClickHandler FormItem.click()} event is fired.
     *
     * @return Current target value. Default value is "_blank"
     */
    public String getTarget()  {
        return getAttributeAsString("target");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties of the class instance passed to this function.
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
     * @param linkItemProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(LinkItem linkItemProperties) /*-{
        if (linkItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(LinkItem.@java.lang.Object::getClass()(), "setDefaultProperties", linkItemProperties.@java.lang.Object::getClass()());
        }
        linkItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var properties = linkItemProperties.@com.smartgwt.client.widgets.form.fields.FormItem::getConfig()();
        $wnd.isc.LinkItem.addProperties(properties);
    }-*/;

    // ***********************************************************


    public HandlerRegistration addClickHandler(com.smartgwt.client.widgets.form.fields.events.ClickHandler handler) {
        setTarget("javascript");
        return super.addClickHandler(handler);
    }

}
