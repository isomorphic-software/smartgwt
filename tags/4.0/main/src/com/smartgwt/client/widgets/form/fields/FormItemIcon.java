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
 
package com.smartgwt.client.widgets.form.fields;


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
 * Form item icon descriptor objects used by Form Items to specify the appearance and  behavior of icons displayed after
 * the item in the page flow.
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getIcons
 */
public class FormItemIcon extends DataClass  implements com.smartgwt.client.widgets.form.fields.events.HasFormItemClickHandlers {

    public static FormItemIcon getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new FormItemIcon(jsObj);
    }

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }



    public FormItemIcon(){
        
    }

    public FormItemIcon(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
        
    }


    // ********************* Properties / Attributes ***********************


    /**
     * Base CSS style. If set, as the component changes state and/or is focused, suffixes will be added to the base style.
     * Possible suffixes include "Over" if the user mouses over the icon and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOver this.showOver} is true, "Disabled" if the icon is
     * disabled, and "Focused".
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param baseStyle . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}. Default value is null
     */
    public void setBaseStyle(String baseStyle) {
        setAttribute("baseStyle", baseStyle);
    }

    /**
     * Base CSS style. If set, as the component changes state and/or is focused, suffixes will be added to the base style.
     * Possible suffixes include "Over" if the user mouses over the icon and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOver this.showOver} is true, "Disabled" if the icon is
     * disabled, and "Focused".
     *
     * @return . See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName}
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }


    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is set to false, should this icon be
     * disabled. If unset this is determined by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisableIconsOnReadOnly disableIconsOnReadOnly}. Note that if {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getNeverDisable neverDisable} is set to true, the icons will be
     * rendered enabled regardless of this setting and whether the item is editable.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param disableOnReadOnly disableOnReadOnly Default value is null
     */
    public void setDisableOnReadOnly(Boolean disableOnReadOnly) {
        setAttribute("disableOnReadOnly", disableOnReadOnly);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit} is set to false, should this icon be
     * disabled. If unset this is determined by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisableIconsOnReadOnly disableIconsOnReadOnly}. Note that if {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getNeverDisable neverDisable} is set to true, the icons will be
     * rendered enabled regardless of this setting and whether the item is editable.
     *
     * @return Boolean
     */
    public Boolean getDisableOnReadOnly()  {
        return getAttributeAsBoolean("disableOnReadOnly");
    }


    /**
     * If set, this property determines the height of this icon in px.      If unset the form item's <code>iconHeight</code>
     * property will be used instead.
     *
     * @param height height Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setIconHeight
     */
    public void setHeight(Integer height) {
        setAttribute("height", height);
    }

    /**
     * If set, this property determines the height of this icon in px.      If unset the form item's <code>iconHeight</code>
     * property will be used instead.
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getIconHeight
     */
    public Integer getHeight()  {
        return getAttributeAsInt("height");
    }


    /**
     * If set, this property determines the number of pixels space to be displayed on       the left of this form item
     * icon.<br>      If unset the form item's <code>iconHSpace</code> property will be used instead.
     *
     * @param hspace hspace Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setIconHSpace
     */
    public void setHspace(Integer hspace) {
        setAttribute("hspace", hspace);
    }

    /**
     * If set, this property determines the number of pixels space to be displayed on       the left of this form item
     * icon.<br>      If unset the form item's <code>iconHSpace</code> property will be used instead.
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getIconHSpace
     */
    public Integer getHspace()  {
        return getAttributeAsInt("hspace");
    }


    /**
     * Identifier for this form item icon. This identifier (if set) should be unique within this form item and may be used to
     * get a pointer to the icon object via {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcon FormItem.getIcon}.
     *
     * @param name . See {@link com.smartgwt.client.docs.String String}. Default value is null
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * Identifier for this form item icon. This identifier (if set) should be unique within this form item and may be used to
     * get a pointer to the icon object via {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcon FormItem.getIcon}.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     */
    public String getName()  {
        return getAttributeAsString("name");
    }


    /**
     * If <code>icon.neverDisable</code> is true, when this form item is disabled, the  icon will remain enabled.  Note that
     * disabling the entire form will disable all items, together with their  icons including those marked as neverDisable -
     * this property only has an effect  if the form is enabled and a specific item is disabled within it. <P> If this property
     * is true, the icons will also remain enabled if a form item  is marked as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit:false}. For finer grained control over whether icons
     * are enabled for read-only icons see {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisableIconsOnReadOnly
     * disableIconsOnReadOnly} and {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getDisableOnReadOnly
     * disableOnReadOnly}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param neverDisable neverDisable Default value is null
     */
    public void setNeverDisable(Boolean neverDisable) {
        setAttribute("neverDisable", neverDisable);
    }

    /**
     * If <code>icon.neverDisable</code> is true, when this form item is disabled, the  icon will remain enabled.  Note that
     * disabling the entire form will disable all items, together with their  icons including those marked as neverDisable -
     * this property only has an effect  if the form is enabled and a specific item is disabled within it. <P> If this property
     * is true, the icons will also remain enabled if a form item  is marked as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit:false}. For finer grained control over whether icons
     * are enabled for read-only icons see {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisableIconsOnReadOnly
     * disableIconsOnReadOnly} and {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getDisableOnReadOnly
     * disableOnReadOnly}
     *
     * @return Boolean
     */
    public Boolean getNeverDisable()  {
        return getAttributeAsBoolean("neverDisable");
    }


    /**
     * If set, this property will be displayed as a prompt (and tooltip text) for this form item icon. <P> If unset the form
     * item's <code>iconPrompt</code> property will be used instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param prompt . See {@link com.smartgwt.client.docs.String String}. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setIconPrompt
     */
    public void setPrompt(String prompt) {
        setAttribute("prompt", prompt);
    }

    /**
     * If set, this property will be displayed as a prompt (and tooltip text) for this form item icon. <P> If unset the form
     * item's <code>iconPrompt</code> property will be used instead.
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getIconPrompt
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }


    /**
     * Should this icon's image and/or {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle}
     * switch to the appropriate "Focused" value when the user puts focus on the form item or icon?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showFocused showFocused Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowFocusedIcons
     * @see com.smartgwt.client.widgets.form.fields.FormItemIcon#setShowFocusedWithItem
     */
    public void setShowFocused(Boolean showFocused) {
        setAttribute("showFocused", showFocused);
    }

    /**
     * Should this icon's image and/or {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle}
     * switch to the appropriate "Focused" value when the user puts focus on the form item or icon?
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowFocusedIcons
     * @see com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowFocusedWithItem
     */
    public Boolean getShowFocused()  {
        return getAttributeAsBoolean("showFocused");
    }


    /**
     * If this icon will be updated to show focus (see {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowFocused showFocused},  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowFocusedIcons showFocusedIcons}), this property governs whether
     * the focused state should be shown when the item as a whole receives focus or just if the icon receives focus. If this
     * property is unset, default behavior is to show focused state when the item receives focus.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showFocusedWithItem showFocusedWithItem Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowFocusedIcons
     * @see com.smartgwt.client.widgets.form.fields.FormItemIcon#setShowFocused
     */
    public void setShowFocusedWithItem(Boolean showFocusedWithItem) {
        setAttribute("showFocusedWithItem", showFocusedWithItem);
    }

    /**
     * If this icon will be updated to show focus (see {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowFocused showFocused},  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowFocusedIcons showFocusedIcons}), this property governs whether
     * the focused state should be shown when the item as a whole receives focus or just if the icon receives focus. If this
     * property is unset, default behavior is to show focused state when the item receives focus.
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowFocusedIcons
     * @see com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowFocused
     */
    public Boolean getShowFocusedWithItem()  {
        return getAttributeAsBoolean("showFocusedWithItem");
    }


    /**
     * Should this icon's image and/or {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle}
     * switch to the appropriate "Over" value when the user rolls over or focuses on the icon?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOver showOver Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowOverIcons
     */
    public void setShowOver(Boolean showOver) {
        setAttribute("showOver", showOver);
    }

    /**
     * Should this icon's image and/or {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle}
     * switch to the appropriate "Over" value when the user rolls over or focuses on the icon?
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowOverIcons
     */
    public Boolean getShowOver()  {
        return getAttributeAsBoolean("showOver");
    }


    /**
     * If set, this property determines this icon's image source. If unset the form item's <code>defaultIconSrc</code> property
     * will be used instead.<br> As with <code>defaultIconSrc</code> this URL will be modified by adding "_Over" or "_Disabled"
     * if appropriate to show the icons over or disabled state. <p> The special value "blank" means that no image will be shown
     * for this icon. This is particularly useful together with {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle} to implement spriting of the different icon
     * states.
     *
     * @param src . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setDefaultIconSrc
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_details_icons" target="examples">Icons Example</a>
     */
    public void setSrc(String src) {
        setAttribute("src", src);
    }

    /**
     * If set, this property determines this icon's image source. If unset the form item's <code>defaultIconSrc</code> property
     * will be used instead.<br> As with <code>defaultIconSrc</code> this URL will be modified by adding "_Over" or "_Disabled"
     * if appropriate to show the icons over or disabled state. <p> The special value "blank" means that no image will be shown
     * for this icon. This is particularly useful together with {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle} to implement spriting of the different icon
     * states.
     *
     * @return . See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDefaultIconSrc
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_details_icons" target="examples">Icons Example</a>
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }


    /**
     * TabIndex for this formItemIcon. <P> Set to -1 to remove the icon from the tab order, but be cautious doing so: if the
     * icon triggers important application functionality that cannot otherwise be accessed via the keyboard, it would be a
     * violation of accessibility standard to remove the icon from the tab order. <P> Any usage other than setting to -1 is
     * extremely advanced in the same way as using {@link com.smartgwt.client.widgets.form.fields.FormItem#getGlobalTabIndex
     * globalTabIndex}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param tabIndex tabIndex Default value is null
     */
    public void setTabIndex(Integer tabIndex) {
        setAttribute("tabIndex", tabIndex);
    }

    /**
     * TabIndex for this formItemIcon. <P> Set to -1 to remove the icon from the tab order, but be cautious doing so: if the
     * icon triggers important application functionality that cannot otherwise be accessed via the keyboard, it would be a
     * violation of accessibility standard to remove the icon from the tab order. <P> Any usage other than setting to -1 is
     * extremely advanced in the same way as using {@link com.smartgwt.client.widgets.form.fields.FormItem#getGlobalTabIndex
     * globalTabIndex}.
     *
     * @return Integer
     */
    public Integer getTabIndex()  {
        return getAttributeAsInt("tabIndex");
    }


    /**
     * If set, this property determines the width of this icon in px.      If unset the form item's <code>iconWidth</code>
     * property will be used instead.
     *
     * @param width width Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setIconWidth
     */
    public void setWidth(Integer width) {
        setAttribute("width", width);
    }

    /**
     * If set, this property determines the width of this icon in px.      If unset the form item's <code>iconWidth</code>
     * property will be used instead.
     *
     * @return Integer
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth
     */
    public Integer getWidth()  {
        return getAttributeAsInt("width");
    }

    // ********************* Methods ***********************
    /**
     * Add a formItemClick handler.
     * <p>
     * StringMethod action to fire when this icon is clicked      If unset the form item's <code>iconClick</code> method will
     * be fired instead (if      specified).
     *
     * @param handler the formItemClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFormItemClickHandler(com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent.getType()) == 0) setupFormItemClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent.getType());
    }

    private native void setupFormItemClickEvent() /*-{
        var obj = null;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var click = $entry(function(){
            var param = {"form" : arguments[0], "item" : arguments[1], "icon" : arguments[2]};
            var event = @com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        obj.click =  click 
        ;
   }-*/;
	/**
     * StringMethod action to fire when this icon has focus and receives a keypress      event.      If unset the form item's
     * <code>iconKeyPress</code> method will be fired instead       (if specified).
     * @param keyName Name of the key pressed
     * @param character character produced by the keypress
     * @param form The Dynamic Form to which this icon's item belongs.
     * @param item The Form Item containing this icon
     * @param icon A pointer to the form item icon
     */
    public native void keyPress(String keyName, char character, DynamicForm form, FormItem item, FormItemIcon icon) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.keyPress(keyName, character, form.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), item.@com.smartgwt.client.core.DataClass::getJsObj()(), icon.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    // ********************* Static Methods ***********************

    // ***********************************************************


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FormItemIcon that = (FormItemIcon) o;

        if (getSrc() != null ? !getSrc().equals(that.getSrc()) : that.getSrc() != null) return false;

        return true;
    }

    public int hashCode() {
        return getSrc() != null ? getSrc().hashCode() : 0;
    }
    
    /**
     * Set showIf condition.
     * <p>
     * If specified, <code>icon.showIf</code> will be evaluated when the form item is drawn or redrawn. Return true if the icon
     * should be visible, or false if it should be hidden. Note that if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#showIcon FormItem.showIcon} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#hideIcon FormItem.hideIcon} is called, this method will be overridden.
     *
     * @param handler the showIf handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public native void setShowIfCondition(FormItemIfFunction showIf) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.showIf = $debox($entry(function(form, item) {
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            var valueJ =  $wnd.SmartGWT.convertToJavaType(item.getValue());
            var formJ = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(form);
            return showIf.@com.smartgwt.client.widgets.form.FormItemIfFunction::execute(Lcom/smartgwt/client/widgets/form/fields/FormItem;Ljava/lang/Object;Lcom/smartgwt/client/widgets/form/DynamicForm;)(itemJ, valueJ, formJ);
        }));
    }-*/;


}


