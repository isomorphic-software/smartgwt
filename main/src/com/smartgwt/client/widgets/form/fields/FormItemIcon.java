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
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;


/**
 * Form item icon descriptor objects used by Form Items to specify the appearance and  behavior of icons displayed after
 * the item in the page flow.
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getIcons
 */
@BeanFactory.FrameworkClass
public class FormItemIcon extends DataClass implements com.smartgwt.client.widgets.form.fields.events.HasFormItemClickHandlers {

    public static FormItemIcon getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new FormItemIcon(jsObj);
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
     * disabled, and "Focused". In addition, if {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowRTL showRTL}
     * is enabled, then an "RTL" suffix will be added.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param baseStyle New baseStyle value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public FormItemIcon setBaseStyle(String baseStyle) {
        return (FormItemIcon)setAttribute("baseStyle", baseStyle);
    }

    /**
     * Base CSS style. If set, as the component changes state and/or is focused, suffixes will be added to the base style.
     * Possible suffixes include "Over" if the user mouses over the icon and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOver this.showOver} is true, "Disabled" if the icon is
     * disabled, and "Focused". In addition, if {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowRTL showRTL}
     * is enabled, then an "RTL" suffix will be added.
     *
     * @return Current baseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseStyle()  {
        return getAttributeAsString("baseStyle");
    }
    

    /**
     * Set to false to suppress all focus features for this icon. Clicking the icon will not apply focus to the icon or to the
     * form item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canFocus New canFocus value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     */
    public FormItemIcon setCanFocus(Boolean canFocus) {
        return (FormItemIcon)setAttribute("canFocus", canFocus);
    }

    /**
     * Set to false to suppress all focus features for this icon. Clicking the icon will not apply focus to the icon or to the
     * form item.
     *
     * @return Current canFocus value. Default value is null
     */
    public Boolean getCanFocus()  {
        return getAttributeAsBoolean("canFocus", true);
    }
    

    /**
     * Specifies the cursor image to display when the mouse pointer is over this icon. It corresponds to the CSS cursor
     * attribute. See Cursor type for different cursors. <p> See also {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getDisabledCursor disabledCursor}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param cursor New cursor value. Default value is Canvas.POINTER
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Cues Cues overview and related methods
     */
    public FormItemIcon setCursor(Cursor cursor) {
        return (FormItemIcon)setAttribute("cursor", cursor == null ? null : cursor.getValue());
    }

    /**
     * Specifies the cursor image to display when the mouse pointer is over this icon. It corresponds to the CSS cursor
     * attribute. See Cursor type for different cursors. <p> See also {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getDisabledCursor disabledCursor}.
     *
     * @return Current cursor value. Default value is Canvas.POINTER
     * @see com.smartgwt.client.docs.Cues Cues overview and related methods
     */
    public Cursor getCursor()  {
        return EnumUtil.getEnum(Cursor.values(), getAttribute("cursor"));
    }
    

    /**
     * Whether this icon is disabled.  Can be updated at runtime via the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setIconDisabled FormItem.setIconDisabled()} method.  Note that if the
     * formItem containing this icon is disabled, the icon will behave in a disabled manner regardless of the setting of the
     * icon.disabled property.
     *
     * @param disabled New disabled value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setIconDisabled
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public FormItemIcon setDisabled(Boolean disabled) {
        return (FormItemIcon)setAttribute("disabled", disabled);
    }

    /**
     * Whether this icon is disabled.  Can be updated at runtime via the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setIconDisabled FormItem.setIconDisabled()} method.  Note that if the
     * formItem containing this icon is disabled, the icon will behave in a disabled manner regardless of the setting of the
     * icon.disabled property.
     *
     * @return Current disabled value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setIconDisabled
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getDisabled()  {
        return getAttributeAsBoolean("disabled", true);
    }
    

    /**
     * Specifies the cursor image to display when the mouse pointer is over this icon if this icon is disabled. It corresponds
     * to the CSS cursor attribute. See Cursor type for different cursors.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param disabledCursor New disabledCursor value. Default value is Canvas.DEFAULT
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Cues Cues overview and related methods
     */
    public FormItemIcon setDisabledCursor(Cursor disabledCursor) {
        return (FormItemIcon)setAttribute("disabledCursor", disabledCursor == null ? null : disabledCursor.getValue());
    }

    /**
     * Specifies the cursor image to display when the mouse pointer is over this icon if this icon is disabled. It corresponds
     * to the CSS cursor attribute. See Cursor type for different cursors.
     *
     * @return Current disabledCursor value. Default value is Canvas.DEFAULT
     * @see com.smartgwt.client.docs.Cues Cues overview and related methods
     */
    public Cursor getDisabledCursor()  {
        return EnumUtil.getEnum(Cursor.values(), getAttribute("disabledCursor"));
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit FormItem.canEdit} is set to false, should this
     * icon be disabled. If unset this is determined by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisableIconsOnReadOnly FormItem.disableIconsOnReadOnly}. Note that
     * if {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getNeverDisable neverDisable} is set to true, the icons
     * will be rendered enabled regardless of this setting and whether the item is editable.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param disableOnReadOnly New disableOnReadOnly value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     */
    public FormItemIcon setDisableOnReadOnly(Boolean disableOnReadOnly) {
        return (FormItemIcon)setAttribute("disableOnReadOnly", disableOnReadOnly);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit FormItem.canEdit} is set to false, should this
     * icon be disabled. If unset this is determined by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDisableIconsOnReadOnly FormItem.disableIconsOnReadOnly}. Note that
     * if {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getNeverDisable neverDisable} is set to true, the icons
     * will be rendered enabled regardless of this setting and whether the item is editable.
     *
     * @return Current disableOnReadOnly value. Default value is null
     */
    public Boolean getDisableOnReadOnly()  {
        return getAttributeAsBoolean("disableOnReadOnly", true);
    }
    

    /**
     * Criteria to be evaluated to determine whether this icon should appear enabled. <p> Criteria are evaluated against the
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form's current values} as well as  the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.  Criteria are re-evaluated every time form values or the
     * rule context changes, whether by end user action or by programmatic calls. <P> A basic criteria uses
     * textMatchStyle:"exact". When specified in {@link com.smartgwt.client.docs.ComponentXML Component XML} this property
     * allows {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining criteria. <p> Note: A
     * FormItemIcon using enableWhen must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined
     * on its FormItem.
     *
     * @param enableWhen New enableWhen value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.RuleCriteria RuleCriteria overview and related methods
     */
    public FormItemIcon setEnableWhen(AdvancedCriteria enableWhen) {
        if (enableWhen instanceof Criterion) {
            enableWhen.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (FormItemIcon)setAttribute("enableWhen", enableWhen == null ? null : enableWhen.getJsObj());
    }

    /**
     * Criteria to be evaluated to determine whether this icon should appear enabled. <p> Criteria are evaluated against the
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getValues form's current values} as well as  the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.  Criteria are re-evaluated every time form values or the
     * rule context changes, whether by end user action or by programmatic calls. <P> A basic criteria uses
     * textMatchStyle:"exact". When specified in {@link com.smartgwt.client.docs.ComponentXML Component XML} this property
     * allows {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining criteria. <p> Note: A
     * FormItemIcon using enableWhen must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined
     * on its FormItem.
     *
     * @return Current enableWhen value. Default value is null
     * @see com.smartgwt.client.docs.RuleCriteria RuleCriteria overview and related methods
     */
    public AdvancedCriteria getEnableWhen()  {
        return new AdvancedCriteria(getAttributeAsJavaScriptObject("enableWhen"));
    }
    

    /**
     * If set, this property determines the height of this icon in px.      If unset the form item's <code>iconHeight</code>
     * property will be used instead.
     *
     * @param height New height value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setIconHeight
     */
    public FormItemIcon setHeight(Integer height) {
        return (FormItemIcon)setAttribute("height", height);
    }

    /**
     * If set, this property determines the height of this icon in px.      If unset the form item's <code>iconHeight</code>
     * property will be used instead.
     *
     * @return Current height value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getIconHeight
     */
    public Integer getHeight()  {
        return getAttributeAsInt("height");
    }
    

    /**
     * If set, this property determines the number of pixels space to be displayed on  the left of this form item icon, or for
     * {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getInline inline} icons whose {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getInlineIconAlign inlineIconAlign} is  {@link
     * com.smartgwt.client.types.Alignment#LEFT}, on the right of this form item icon. Must be non-negative. If unset, the form
     * item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconHSpace iconHSpace} will be used instead.
     *
     * @param hspace New hspace value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     */
    public FormItemIcon setHspace(Integer hspace) {
        return (FormItemIcon)setAttribute("hspace", hspace);
    }

    /**
     * If set, this property determines the number of pixels space to be displayed on  the left of this form item icon, or for
     * {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getInline inline} icons whose {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getInlineIconAlign inlineIconAlign} is  {@link
     * com.smartgwt.client.types.Alignment#LEFT}, on the right of this form item icon. Must be non-negative. If unset, the form
     * item's {@link com.smartgwt.client.widgets.form.fields.FormItem#getIconHSpace iconHSpace} will be used instead.
     *
     * @return Current hspace value. Default value is null
     */
    public Integer getHspace()  {
        return getAttributeAsInt("hspace");
    }
    

    /**
     * For PickList items with {@link com.smartgwt.client.types.PickListItemIconPlacement} set such that the pickList does not
     * render near-origin, should this icon be rendered inline within the formItem itself, or within the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerNavigationBar ComboBoxItem.pickerNavigationBar}. <P> If
     * not explicitly specified at the icon level, this will be picked up from  PickList.iconPlacement. <P> For mobile browsing
     * with limited available screen space, icons rendered in the navigation bar may be easier for the user to interact with.
     *
     * @param iconPlacement New iconPlacement value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     */
    public FormItemIcon setIconPlacement(PickListItemIconPlacement iconPlacement) {
        return (FormItemIcon)setAttribute("iconPlacement", iconPlacement == null ? null : iconPlacement.getValue());
    }

    /**
     * For PickList items with {@link com.smartgwt.client.types.PickListItemIconPlacement} set such that the pickList does not
     * render near-origin, should this icon be rendered inline within the formItem itself, or within the {@link
     * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickerNavigationBar ComboBoxItem.pickerNavigationBar}. <P> If
     * not explicitly specified at the icon level, this will be picked up from  PickList.iconPlacement. <P> For mobile browsing
     * with limited available screen space, icons rendered in the navigation bar may be easier for the user to interact with.
     *
     * @return Current iconPlacement value. Default value is null
     */
    public PickListItemIconPlacement getIconPlacement()  {
        return EnumUtil.getEnum(PickListItemIconPlacement.values(), getAttribute("iconPlacement"));
    }
    

    /**
     * When set, this icon is rendered inside the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextBoxStyle
     * textBox} area of the <code>FormItem</code> (where input occurs in a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, {@link com.smartgwt.client.widgets.form.fields.TextAreaItem} or
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}) as opposed to as a trailing icon. <p> Use {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getInlineIconAlign inlineIconAlign} to control alignment of the
     * icon.  Multiple icons can be inlined on both the left and right side of the <code>textBox</code> area.  {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getHspace hspace} is honored for spacing between multiple adjacent
     * icons. <p> Inline icons are not supported in Internet Explorer 6, or when the <code>FormItem</code> is not a
     * <code>TextItem</code>, <code>TextAreaItem</code> or <code>ComboBoxItem</code>. When unsupported, the icon will fall back
     * to non-inline mode. <p> The {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon}, if
     * any, cannot be inlined. <p> As an alternative to displaying an image, an inline icon may display a string of HTML
     * instead. See {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getText text}.
     *
     * @param inline New inline value. Default value is false
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * 
     */
    public FormItemIcon setInline(Boolean inline) {
        return (FormItemIcon)setAttribute("inline", inline);
    }

    /**
     * When set, this icon is rendered inside the {@link com.smartgwt.client.widgets.form.fields.FormItem#getTextBoxStyle
     * textBox} area of the <code>FormItem</code> (where input occurs in a {@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, {@link com.smartgwt.client.widgets.form.fields.TextAreaItem} or
     * {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}) as opposed to as a trailing icon. <p> Use {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getInlineIconAlign inlineIconAlign} to control alignment of the
     * icon.  Multiple icons can be inlined on both the left and right side of the <code>textBox</code> area.  {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getHspace hspace} is honored for spacing between multiple adjacent
     * icons. <p> Inline icons are not supported in Internet Explorer 6, or when the <code>FormItem</code> is not a
     * <code>TextItem</code>, <code>TextAreaItem</code> or <code>ComboBoxItem</code>. When unsupported, the icon will fall back
     * to non-inline mode. <p> The {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon}, if
     * any, cannot be inlined. <p> As an alternative to displaying an image, an inline icon may display a string of HTML
     * instead. See {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getText text}.
     *
     * @return Current inline value. Default value is false
     * 
     */
    public Boolean getInline()  {
        Boolean result = getAttributeAsBoolean("inline", true);
        return result == null ? false : result;
    }
    

    /**
     * Horizontal alignment for icons marked {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getInline inline}. <p>
     * By default, the first icon that specifies inline is aligned left, and the second and all subsequent icons to the right. 
     * <code>"center"</code> alignment is invalid and will be ignored. <p> In RTL mode, the alignment is automatically
     * mirrored; <code>inlineIconAlign:"left"</code> results in the icon being placed on the right and
     * <code>inlineIconAlign:"right"</code> results in the icon being placed on the left.
     *
     * @param inlineIconAlign New inlineIconAlign value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     */
    public FormItemIcon setInlineIconAlign(Alignment inlineIconAlign) {
        return (FormItemIcon)setAttribute("inlineIconAlign", inlineIconAlign == null ? null : inlineIconAlign.getValue());
    }

    /**
     * Horizontal alignment for icons marked {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getInline inline}. <p>
     * By default, the first icon that specifies inline is aligned left, and the second and all subsequent icons to the right. 
     * <code>"center"</code> alignment is invalid and will be ignored. <p> In RTL mode, the alignment is automatically
     * mirrored; <code>inlineIconAlign:"left"</code> results in the icon being placed on the right and
     * <code>inlineIconAlign:"right"</code> results in the icon being placed on the left.
     *
     * @return Current inlineIconAlign value. Default value is null
     */
    public Alignment getInlineIconAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("inlineIconAlign"));
    }
    

    /**
     * Identifier for this form item icon. This identifier (if set) should be unique within this form item and may be used to
     * get a pointer to the icon object via {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcon
     * FormItem.getIcon()}.
     *
     * @param name New name value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Identifier Identifier 
     */
    public FormItemIcon setName(String name) {
        return (FormItemIcon)setAttribute("name", name);
    }

    /**
     * Identifier for this form item icon. This identifier (if set) should be unique within this form item and may be used to
     * get a pointer to the icon object via {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcon
     * FormItem.getIcon()}.
     *
     * @return Current name value. Default value is null
     * @see com.smartgwt.client.docs.Identifier Identifier 
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
     * FormItem.disableIconsOnReadOnly} and {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getDisableOnReadOnly
     * disableOnReadOnly}
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param neverDisable New neverDisable value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     */
    public FormItemIcon setNeverDisable(Boolean neverDisable) {
        return (FormItemIcon)setAttribute("neverDisable", neverDisable);
    }

    /**
     * If <code>icon.neverDisable</code> is true, when this form item is disabled, the  icon will remain enabled.  Note that
     * disabling the entire form will disable all items, together with their  icons including those marked as neverDisable -
     * this property only has an effect  if the form is enabled and a specific item is disabled within it. <P> If this property
     * is true, the icons will also remain enabled if a form item  is marked as {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getCanEdit canEdit:false}. For finer grained control over whether icons
     * are enabled for read-only icons see {@link com.smartgwt.client.widgets.form.fields.FormItem#getDisableIconsOnReadOnly
     * FormItem.disableIconsOnReadOnly} and {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getDisableOnReadOnly
     * disableOnReadOnly}
     *
     * @return Current neverDisable value. Default value is null
     */
    public Boolean getNeverDisable()  {
        return getAttributeAsBoolean("neverDisable", true);
    }
    

    /**
     * If set, this property will be displayed as a prompt (and tooltip text) for this form item icon. <P> If unset the form
     * item's <code>iconPrompt</code> property will be used instead.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param prompt New prompt value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setIconPrompt
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public FormItemIcon setPrompt(String prompt) {
        return (FormItemIcon)setAttribute("prompt", prompt);
    }

    /**
     * If set, this property will be displayed as a prompt (and tooltip text) for this form item icon. <P> If unset the form
     * item's <code>iconPrompt</code> property will be used instead.
     *
     * @return Current prompt value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getIconPrompt
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getPrompt()  {
        return getAttributeAsString("prompt");
    }
    

    /**
     * If show-on-focus behavior is enabled for this icon via {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOnFocus showOnFocus} or related properties at the item
     * level, and this icon is marked as disabled, should it be shown on focus? If unset, will be derived from the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabledIconsOnFocus FormItem.showDisabledIconsOnFocus} or 
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabledPickerIconOnFocus
     * FormItem.showDisabledPickerIconOnFocus} settings.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showDisabledOnFocus New showDisabledOnFocus value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     */
    public FormItemIcon setShowDisabledOnFocus(Boolean showDisabledOnFocus) {
        return (FormItemIcon)setAttribute("showDisabledOnFocus", showDisabledOnFocus);
    }

    /**
     * If show-on-focus behavior is enabled for this icon via {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOnFocus showOnFocus} or related properties at the item
     * level, and this icon is marked as disabled, should it be shown on focus? If unset, will be derived from the {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabledIconsOnFocus FormItem.showDisabledIconsOnFocus} or 
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabledPickerIconOnFocus
     * FormItem.showDisabledPickerIconOnFocus} settings.
     *
     * @return Current showDisabledOnFocus value. Default value is null
     */
    public Boolean getShowDisabledOnFocus()  {
        return getAttributeAsBoolean("showDisabledOnFocus", true);
    }
    

    /**
     * Should this icon's image and/or {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle}
     * switch to the appropriate "Focused" value when the user puts focus on the form item or icon?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showFocused New showFocused value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowFocusedIcons
     * @see com.smartgwt.client.widgets.form.fields.FormItemIcon#setShowFocusedWithItem
     */
    public FormItemIcon setShowFocused(Boolean showFocused) {
        return (FormItemIcon)setAttribute("showFocused", showFocused);
    }

    /**
     * Should this icon's image and/or {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle}
     * switch to the appropriate "Focused" value when the user puts focus on the form item or icon?
     *
     * @return Current showFocused value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowFocusedIcons
     * @see com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowFocusedWithItem
     */
    public Boolean getShowFocused()  {
        return getAttributeAsBoolean("showFocused", true);
    }
    

    /**
     * If this icon will be updated to show focus (see {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowFocused showFocused},  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowFocusedIcons FormItem.showFocusedIcons}), this property governs
     * whether the focused state should be shown when the item as a whole receives focus or just if the icon receives focus. If
     * this property is unset, default behavior is to show focused state when the item receives focus.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showFocusedWithItem New showFocusedWithItem value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowFocusedIcons
     * @see com.smartgwt.client.widgets.form.fields.FormItemIcon#setShowFocused
     */
    public FormItemIcon setShowFocusedWithItem(Boolean showFocusedWithItem) {
        return (FormItemIcon)setAttribute("showFocusedWithItem", showFocusedWithItem);
    }

    /**
     * If this icon will be updated to show focus (see {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowFocused showFocused},  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowFocusedIcons FormItem.showFocusedIcons}), this property governs
     * whether the focused state should be shown when the item as a whole receives focus or just if the icon receives focus. If
     * this property is unset, default behavior is to show focused state when the item receives focus.
     *
     * @return Current showFocusedWithItem value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowFocusedIcons
     * @see com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowFocused
     */
    public Boolean getShowFocusedWithItem()  {
        return getAttributeAsBoolean("showFocusedWithItem", true);
    }
    

    /**
     * Show this icon when its item gets focus, and hide it when it loses focus.  If non-null, overrides the default behavior
     * specified by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowIconsOnFocus FormItem.showIconsOnFocus} or
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIconOnFocus FormItem.showPickerIconOnFocus}, as
     * appropriate.  This feature allows space to be saved in the form for items not being interacted with, and helps draw
     * attention to the item currently in focus.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOnFocus New showOnFocus value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setIconShowOnFocus
     */
    public FormItemIcon setShowOnFocus(Boolean showOnFocus) {
        return (FormItemIcon)setAttribute("showOnFocus", showOnFocus);
    }

    /**
     * Show this icon when its item gets focus, and hide it when it loses focus.  If non-null, overrides the default behavior
     * specified by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowIconsOnFocus FormItem.showIconsOnFocus} or
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIconOnFocus FormItem.showPickerIconOnFocus}, as
     * appropriate.  This feature allows space to be saved in the form for items not being interacted with, and helps draw
     * attention to the item currently in focus.
     *
     * @return Current showOnFocus value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setIconShowOnFocus
     */
    public Boolean getShowOnFocus()  {
        return getAttributeAsBoolean("showOnFocus", true);
    }
    

    /**
     * Should this icon's image and/or {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle}
     * switch to the appropriate "Over" value when the user rolls over or focuses on the icon? <P> Note if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowOver FormItem.showOver} is true and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOverWhen showOverWhen} is set to "textBox", this icon will
     * show over state when the user rolls over the text box (or control table, if visible) for the item. This is most commonly
     * used for {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getInline inline} icons.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOver New showOver value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setShowOverIcons
     */
    public FormItemIcon setShowOver(Boolean showOver) {
        return (FormItemIcon)setAttribute("showOver", showOver);
    }

    /**
     * Should this icon's image and/or {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle}
     * switch to the appropriate "Over" value when the user rolls over or focuses on the icon? <P> Note if {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowOver FormItem.showOver} is true and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOverWhen showOverWhen} is set to "textBox", this icon will
     * show over state when the user rolls over the text box (or control table, if visible) for the item. This is most commonly
     * used for {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getInline inline} icons.
     *
     * @return Current showOver value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowOverIcons
     */
    public Boolean getShowOver()  {
        return getAttributeAsBoolean("showOver", true);
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOver showOver} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowOverIcons FormItem.showOverIcons} is true, this property may be
     * set to customize when the 'over' styling is applied to the item. If unset, rollover styling will be applied when the
     * user is over the icon only.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showOverWhen New showOverWhen value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     */
    public FormItemIcon setShowOverWhen(IconOverTrigger showOverWhen) {
        return (FormItemIcon)setAttribute("showOverWhen", showOverWhen == null ? null : showOverWhen.getValue());
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowOver showOver} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getShowOverIcons FormItem.showOverIcons} is true, this property may be
     * set to customize when the 'over' styling is applied to the item. If unset, rollover styling will be applied when the
     * user is over the icon only.
     *
     * @return Current showOverWhen value. Default value is null
     */
    public IconOverTrigger getShowOverWhen()  {
        return EnumUtil.getEnum(IconOverTrigger.values(), getAttribute("showOverWhen"));
    }
    

    /**
     * Should this icon's {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} and/or {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle} switch to the appropriate RTL value when
     * the FormItem is in RTL mode? If true, then the image URL for all states will have "_rtl" added before the extension.
     * Also, if baseStyle is set, all style names will have an "RTL" suffix. This should only be enabled if RTL media is
     * available. <p> For example, if an icon's src is "[SKINIMG]formItemIcons/myFormIcon.png" and the baseStyle is
     * "myFormIcon", then in the "Down" state, Smart GWT will use "[SKINIMG]formItemIcons/myFormIcon_Down_rtl.png" for the
     * image source and "myFormIconDownRTL" for the style name.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showRTL New showRTL value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     */
    public FormItemIcon setShowRTL(Boolean showRTL) {
        return (FormItemIcon)setAttribute("showRTL", showRTL);
    }

    /**
     * Should this icon's {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} and/or {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle} switch to the appropriate RTL value when
     * the FormItem is in RTL mode? If true, then the image URL for all states will have "_rtl" added before the extension.
     * Also, if baseStyle is set, all style names will have an "RTL" suffix. This should only be enabled if RTL media is
     * available. <p> For example, if an icon's src is "[SKINIMG]formItemIcons/myFormIcon.png" and the baseStyle is
     * "myFormIcon", then in the "Down" state, Smart GWT will use "[SKINIMG]formItemIcons/myFormIcon_Down_rtl.png" for the
     * image source and "myFormIconDownRTL" for the style name.
     *
     * @return Current showRTL value. Default value is null
     */
    public Boolean getShowRTL()  {
        return getAttributeAsBoolean("showRTL", true);
    }
    

    /**
     * If set, this property determines this icon's image source. If unset the form item's <code>defaultIconSrc</code> property
     * will be used instead.<br> As with <code>defaultIconSrc</code> this URL will be modified by adding "_Over" or "_Disabled"
     * if appropriate to show the icon's over or disabled state. If {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowRTL showRTL} is enabled, then "_rtl" will be added to the
     * source URL before the extension. <p> The special value "blank" means that no image will be shown for this icon. This is
     * particularly useful together with {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle} to
     * implement spriting of the different icon states. <p> For an {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getInline inline} <code>FormItemIcon</code>, {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getText text} may be specified to show a string of HTML instead of
     * an image. <P> {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting this property to
     * a {@link com.smartgwt.client.docs.SCSpriteConfig} formatted string.
     *
     * @param src New src value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setDefaultIconSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_details_icons" target="examples">Icons Example</a>
     */
    public FormItemIcon setSrc(String src) {
        return (FormItemIcon)setAttribute("src", src);
    }

    /**
     * If set, this property determines this icon's image source. If unset the form item's <code>defaultIconSrc</code> property
     * will be used instead.<br> As with <code>defaultIconSrc</code> this URL will be modified by adding "_Over" or "_Disabled"
     * if appropriate to show the icon's over or disabled state. If {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getShowRTL showRTL} is enabled, then "_rtl" will be added to the
     * source URL before the extension. <p> The special value "blank" means that no image will be shown for this icon. This is
     * particularly useful together with {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle} to
     * implement spriting of the different icon states. <p> For an {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getInline inline} <code>FormItemIcon</code>, {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getText text} may be specified to show a string of HTML instead of
     * an image. <P> {@link com.smartgwt.client.docs.Skinning Spriting} can be used for this image, by setting this property to
     * a {@link com.smartgwt.client.docs.SCSpriteConfig} formatted string.
     *
     * @return Current src value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getDefaultIconSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
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
     * FormItem.globalTabIndex}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param tabIndex New tabIndex value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     */
    public FormItemIcon setTabIndex(Integer tabIndex) {
        return (FormItemIcon)setAttribute("tabIndex", tabIndex);
    }

    /**
     * TabIndex for this formItemIcon. <P> Set to -1 to remove the icon from the tab order, but be cautious doing so: if the
     * icon triggers important application functionality that cannot otherwise be accessed via the keyboard, it would be a
     * violation of accessibility standard to remove the icon from the tab order. <P> Any usage other than setting to -1 is
     * extremely advanced in the same way as using {@link com.smartgwt.client.widgets.form.fields.FormItem#getGlobalTabIndex
     * FormItem.globalTabIndex}.
     *
     * @return Current tabIndex value. Default value is null
     */
    public Integer getTabIndex()  {
        return getAttributeAsInt("tabIndex");
    }
    

    /**
     * As an alternative to displaying an image, an {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getInline
     * inline} <code>FormItemIcon</code> can display a string of HTML where the icon's image would have appeared. This enables
     * advanced customizations such as using text, icon font symbols, Unicode dingbats and emoji, and/or SVG in place of an
     * image. <p> Setting an inline icon's text property will cause the HTML to be used instead of an image, as long as the
     * browser and form item support inline icons. <p> This property only has an effect on inline icons.  If the inline
     * property is false, or the browser or form item does not support inline icons, then the image specified by {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} (or the form item's {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultIconSrc defaultIconSrc}) will be used. <p> Typically, the
     * HTML is styled via {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle}. <p> Auto-sizing
     * of the HTML is not supported; the HTML will be clipped to the icon's {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getWidth width} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getHeight height}.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param text New text value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_details_text_icons" target="examples">Text Icons Example</a>
     */
    public FormItemIcon setText(String text) {
        return (FormItemIcon)setAttribute("text", text);
    }

    /**
     * As an alternative to displaying an image, an {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getInline
     * inline} <code>FormItemIcon</code> can display a string of HTML where the icon's image would have appeared. This enables
     * advanced customizations such as using text, icon font symbols, Unicode dingbats and emoji, and/or SVG in place of an
     * image. <p> Setting an inline icon's text property will cause the HTML to be used instead of an image, as long as the
     * browser and form item support inline icons. <p> This property only has an effect on inline icons.  If the inline
     * property is false, or the browser or form item does not support inline icons, then the image specified by {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc src} (or the form item's {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultIconSrc defaultIconSrc}) will be used. <p> Typically, the
     * HTML is styled via {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle baseStyle}. <p> Auto-sizing
     * of the HTML is not supported; the HTML will be clipped to the icon's {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getWidth width} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItemIcon#getHeight height}.
     *
     * @return Current text value. Default value is null
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#form_details_text_icons" target="examples">Text Icons Example</a>
     */
    public String getText()  {
        return getAttributeAsString("text");
    }
    

    /**
     * Criteria to be evaluated to determine whether this icon should be visible. <p> Criteria are evaluated against the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form's current values} as well as  the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.  Criteria are re-evaluated every time form values or the
     * rule context changes, whether by end user action or by programmatic calls. <P> A basic criteria uses
     * textMatchStyle:"exact". When specified in {@link com.smartgwt.client.docs.ComponentXML Component XML} this property
     * allows {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining criteria. <p> Note: A
     * FormItemIcon using visibleWhen must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined
     * on its FormItem.
     *
     * @param visibleWhen New visibleWhen value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.RuleCriteria RuleCriteria overview and related methods
     */
    public FormItemIcon setVisibleWhen(AdvancedCriteria visibleWhen) {
        if (visibleWhen instanceof Criterion) {
            visibleWhen.setAttribute("_constructor", "AdvancedCriteria");
        }
        return (FormItemIcon)setAttribute("visibleWhen", visibleWhen == null ? null : visibleWhen.getJsObj());
    }

    /**
     * Criteria to be evaluated to determine whether this icon should be visible. <p> Criteria are evaluated against the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValues form's current values} as well as  the current {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope rule context}.  Criteria are re-evaluated every time form values or the
     * rule context changes, whether by end user action or by programmatic calls. <P> A basic criteria uses
     * textMatchStyle:"exact". When specified in {@link com.smartgwt.client.docs.ComponentXML Component XML} this property
     * allows {@link com.smartgwt.client.docs.XmlCriteriaShorthand shorthand formats} for defining criteria. <p> Note: A
     * FormItemIcon using visibleWhen must have a {@link com.smartgwt.client.widgets.form.fields.FormItem#getName name} defined
     * on its FormItem.
     *
     * @return Current visibleWhen value. Default value is null
     * @see com.smartgwt.client.docs.RuleCriteria RuleCriteria overview and related methods
     */
    public AdvancedCriteria getVisibleWhen()  {
        return new AdvancedCriteria(getAttributeAsJavaScriptObject("visibleWhen"));
    }
    

    /**
     * If set, this property determines the width of this icon in px.      If unset the form item's <code>iconWidth</code>
     * property will be used instead.
     *
     * @param width New width value. Default value is null
     * @return {@link com.smartgwt.client.widgets.form.fields.FormItemIcon FormItemIcon} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.form.fields.FormItem#setIconWidth
     */
    public FormItemIcon setWidth(Integer width) {
        return (FormItemIcon)setAttribute("width", width);
    }

    /**
     * If set, this property determines the width of this icon in px.      If unset the form item's <code>iconWidth</code>
     * property will be used instead.
     *
     * @return Current width value. Default value is null
     * @see com.smartgwt.client.widgets.form.fields.FormItem#getIconWidth
     */
    public Integer getWidth()  {
        return getAttributeAsInt("width");
    }
    

    // ********************* Methods ***********************
    /**
     * Add a formItemClick handler.
     * <p>
     * Click handler for this icon. <P>   This event may be cancelled.   If this event is not cancelled by the icon-level click
     * handler, it may also be handled at the FormItem level via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#addPickerIconClickHandler FormItem.pickerIconClick()} [for the picker
     * icon only], and then {@link com.smartgwt.client.widgets.form.fields.FormItem#addIconClickHandler FormItem.iconClick()}
     *
     * @param handler the formItemClick handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFormItemClickHandler(com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent.getType()) == 0) setupFormItemClickEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent.getType());
    }

    private native void setupFormItemClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        var selfJ = this;
        var click = $debox($entry(function(param){
            var event = @com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.DataClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.form.fields.FormItemIcon::handleTearDownFormItemClickEvent()();
            var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
            return !ret;
            }));
        obj.click = 
            function () {
                var param = {"_this": this, "form" : arguments[0], "item" : arguments[1], "icon" : arguments[2]};
                return click(param) == true;
            }
        ;
    }-*/;

    private void handleTearDownFormItemClickEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent.getType()) == 0) tearDownFormItemClickEvent();
    }

    private native void tearDownFormItemClickEvent() /*-{
        var obj;
        obj = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        if (obj && "click" in obj) delete obj.click;
    }-*/;

	/**
     * StringMethod action to fire when this icon has focus and receives a keypress      event.      If unset the form item's
     * <code>iconKeyPress</code> method will be fired instead       (if specified).
     * @param keyName Name of the key pressed.
     * See {@link com.smartgwt.client.docs.KeyName KeyName}
     * @param character character produced by the keypress
     * @param form The Dynamic Form to which this icon's item belongs.
     * @param item The Form Item containing this icon
     * @param icon A pointer to the form item icon
     */
    public native void keyPress(String keyName, char character, DynamicForm form, FormItem item, FormItemIcon icon) /*-{
        var self = this.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.keyPress(keyName, character, form == null ? null : form.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), item.@com.smartgwt.client.core.DataClass::getJsObj()(), icon.@com.smartgwt.client.core.DataClass::getJsObj()());
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
