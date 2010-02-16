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
 
package com.smartgwt.client.widgets.form;



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
import com.smartgwt.client.widgets.layout.*;
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
 * The DynamicForm manages a collection of FormItems which represent user input controls.  The&#010 DynamicForm provides
 * layout, value management, validation and databinding for the controls&#010 it manages.&#010 <P>&#010 To create a
 * DynamicForm, set {@link com.smartgwt.client.widgets.form.DynamicForm#getFields fields} to an Array of Objects describing
 * the&#010 FormItems you want to use.  For example:&#010 <pre>&#010    isc.DynamicForm.create({&#010        fields:[&#010 
 * {name:"userName", type:"text"},  // creates a TextItem&#010            {name:"usState", type:"select"}  // creates a
 * SelectItem&#010        ]&#010    })&#010 </pre>&#010 The item <code>name</code> is an identifier for the item that must
 * be unique just within&#010 this form.  It is used:&#010 <ul>&#010 <li> as the property name under which the item's value
 * is stored in the form (the form's&#010      current values are accessible as {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getValues}&#010 <li> when retrieving the FormItem's current value (via&#010
 * {@link com.smartgwt.client.widgets.form.DynamicForm#getValue}) &#010 <li> to retrieve the item itself via {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getItem}&#010 </ul>&#010 The item <code>type</code> controls what kind of
 * FormItem is created.  See&#010 {@link com.smartgwt.client.types.FormItemType}.&#010 <P>&#010 The {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getTitle 'title'} and {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue 'defaultValue'} are also&#010 commonly specified.  All
 * FormItems share a common set of properties for controlling&#010 {@link com.smartgwt.client.docs.FormLayout 'form
 * layout'}.  Other properties common to all FormItems are&#010 documented on the {@link
 * com.smartgwt.client.widgets.form.fields.FormItem} class, and properties specific to particular FormItems are&#010
 * documented on the respective FormItems.  &#010 <P>&#010 NOTE: For very simple forms consisting of exactly one item, you
 * still use a DynamicForm.&#010 See the "fontSelector" form in the ${isc.DocUtils.linkForExampleId('toolstrip', 'Toolstrip
 * example')}.
 */
public class DynamicForm extends Canvas  implements DataBoundComponent, com.smartgwt.client.widgets.form.events.HasSubmitValuesHandlers, com.smartgwt.client.widgets.form.events.HasItemChangeHandlers, com.smartgwt.client.widgets.form.events.HasItemChangedHandlers, com.smartgwt.client.widgets.form.events.HasItemKeyPressHandlers, com.smartgwt.client.widgets.form.events.HasFormSubmitFailedHandlers {

    public static DynamicForm getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (DynamicForm) obj;
        } else {
            return new DynamicForm(jsObj);
        }
    }

    public DynamicForm(){
        scClassName = "DynamicForm";
    }

    public DynamicForm(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.DynamicForm.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************
             
    /**
     * Layout style to use with this form.   <P> The default of "table" uses a tabular layout similar to HTML tables, but with
     * much more powerful control over sizing, item visibility and reflow, overflow handling, etc. <P>
     * <code>itemLayout:"absolute"</code> allows absolute positioning of every form item.  This provides maximum flexibility in
     * placement, with the following limitations:<ul> <li> titles, which normally take up an adjacent cell, are not shown.  Use
     * StaticTextItems to show titles <li> no automatic reflow when showing or hiding items.  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setLeft}      and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setTop} can be used for manual reflow. <li> only pixel and percent
     * sizes are allowed, no "*".  Percent widths mean percentage      of the overall form size rather than the column size
     * <li> with different font styling or internationalized titles, items may overlap that did      not overlap in the skin
     * used at design time </ul>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param itemLayout itemLayout Default value is "table"
     */
    public void setItemLayout(FormLayoutType itemLayout) {
        setAttribute("itemLayout", itemLayout.getValue(), true);
    }

    /**
     * Layout style to use with this form.   <P> The default of "table" uses a tabular layout similar to HTML tables, but with
     * much more powerful control over sizing, item visibility and reflow, overflow handling, etc. <P>
     * <code>itemLayout:"absolute"</code> allows absolute positioning of every form item.  This provides maximum flexibility in
     * placement, with the following limitations:<ul> <li> titles, which normally take up an adjacent cell, are not shown.  Use
     * StaticTextItems to show titles <li> no automatic reflow when showing or hiding items.  {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setLeft}      and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#setTop} can be used for manual reflow. <li> only pixel and percent
     * sizes are allowed, no "*".  Percent widths mean percentage      of the overall form size rather than the column size
     * <li> with different font styling or internationalized titles, items may overlap that did      not overlap in the skin
     * used at design time </ul>
     *
     *
     * @return FormLayoutType
     */
    public FormLayoutType getItemLayout()  {
        return EnumUtil.getEnum(FormLayoutType.values(), getAttribute("itemLayout"));
    }

    /**
     * The number of columns of titles and items in this form's layout grid. A title and corresponding item each have their own
     * column, so to display two form elements per row (each having a title and item), you would set this property to 4.
     *
     * @param numCols numCols Default value is 2
     */
    public void setNumCols(int numCols) {
        setAttribute("numCols", numCols, true);
    }

    /**
     * The number of columns of titles and items in this form's layout grid. A title and corresponding item each have their own
     * column, so to display two form elements per row (each having a title and item), you would set this property to 4.
     *
     *
     * @return int
     */
    public int getNumCols()  {
        return getAttributeAsInt("numCols");
    }

    /**
     * If true, we ensure that column widths are at least as large as you specify them.  This means that if any single column
     * overflows (due to, eg, a long unbreakable title), the form as a whole overflows. <P> If false, columns will have their
     * specified sizes as long as no column overflows.  If any column overflows, space will be taken from any other columns
     * that aren't filling the available room, until there is no more free space, in which case the form as a whole overflows.
     *
     * @param fixedColWidths fixedColWidths Default value is false
     */
    public void setFixedColWidths(Boolean fixedColWidths) {
        setAttribute("fixedColWidths", fixedColWidths, true);
    }

    /**
     * If true, we ensure that column widths are at least as large as you specify them.  This means that if any single column
     * overflows (due to, eg, a long unbreakable title), the form as a whole overflows. <P> If false, columns will have their
     * specified sizes as long as no column overflows.  If any column overflows, space will be taken from any other columns
     * that aren't filling the available room, until there is no more free space, in which case the form as a whole overflows.
     *
     *
     * @return Boolean
     */
    public Boolean getFixedColWidths()  {
        return getAttributeAsBoolean("fixedColWidths");
    }

    /**
     * Minimum width of a form column.
     *
     * @param minColWidth minColWidth Default value is 20
     */
    public void setMinColWidth(int minColWidth) {
        setAttribute("minColWidth", minColWidth, true);
    }

    /**
     * Minimum width of a form column.
     *
     *
     * @return int
     */
    public int getMinColWidth()  {
        return getAttributeAsInt("minColWidth");
    }

    /**
     * The amount of empty space, in pixels, surrounding each form item within its cell in the layout grid.
     *
     * @param cellPadding cellPadding Default value is 2
     */
    public void setCellPadding(int cellPadding) {
        setAttribute("cellPadding", cellPadding, true);
    }

    /**
     * The amount of empty space, in pixels, surrounding each form item within its cell in the layout grid.
     *
     *
     * @return int
     */
    public int getCellPadding()  {
        return getAttributeAsInt("cellPadding");
    }

    /**
     * Width of border for the table that form is drawn in. This is primarily used for debugging form layout.
     *
     * @param cellBorder cellBorder Default value is 0
     */
    public void setCellBorder(int cellBorder) {
        setAttribute("cellBorder", cellBorder, true);
    }

    /**
     * Width of border for the table that form is drawn in. This is primarily used for debugging form layout.
     *
     *
     * @return int
     */
    public int getCellBorder()  {
        return getAttributeAsInt("cellBorder");
    }
             
    /**
     * If the form has sections, [implemented as {@link com.smartgwt.client.widgets.form.fields.SectionItem}s], this attribute
     * controls whether multiple sections can be expanded at once.
     *
     * @param sectionVisibilityMode sectionVisibilityMode Default value is "multiple"
     */
    public void setSectionVisibilityMode(VisibilityMode sectionVisibilityMode) {
        setAttribute("sectionVisibilityMode", sectionVisibilityMode.getValue(), true);
    }

    /**
     * If the form has sections, [implemented as {@link com.smartgwt.client.widgets.form.fields.SectionItem}s], this attribute
     * controls whether multiple sections can be expanded at once.
     *
     *
     * @return VisibilityMode
     */
    public VisibilityMode getSectionVisibilityMode()  {
        return EnumUtil.getEnum(VisibilityMode.values(), getAttribute("sectionVisibilityMode"));
    }

    /**
     * When creating form items for fields with text type data, if the specified length of the field exceeds this threshold we
     * will create form item of type  <code>this.longTextEditorType</code> (a TextAreaItem by default), rather than a simple
     * text item.  Overridden by explicitly specifying <code>editorType</code> for the field.
     *
     * @param longTextEditorThreshold longTextEditorThreshold Default value is 255
     */
    public void setLongTextEditorThreshold(int longTextEditorThreshold) {
        setAttribute("longTextEditorThreshold", longTextEditorThreshold, true);
    }

    /**
     * When creating form items for fields with text type data, if the specified length of the field exceeds this threshold we
     * will create form item of type  <code>this.longTextEditorType</code> (a TextAreaItem by default), rather than a simple
     * text item.  Overridden by explicitly specifying <code>editorType</code> for the field.
     *
     *
     * @return int
     */
    public int getLongTextEditorThreshold()  {
        return getAttributeAsInt("longTextEditorThreshold");
    }

    /**
     * Name of the Form Item class to use for text fields which exceed the  longTextEditorThreshold for this form.
     *
     * @param longTextEditorType longTextEditorType Default value is "textArea"
     */
    public void setLongTextEditorType(String longTextEditorType) {
        setAttribute("longTextEditorType", longTextEditorType, true);
    }

    /**
     * Name of the Form Item class to use for text fields which exceed the  longTextEditorThreshold for this form.
     *
     *
     * @return String
     */
    public String getLongTextEditorType()  {
        return getAttributeAsString("longTextEditorType");
    }
             
    /**
     * Default orientation for titles for items in this form.  {@link com.smartgwt.client.types.TitleOrientation} lists valid
     * options. <P> Note that titles on the left or right take up a cell in tabular {@link com.smartgwt.client.docs.FormLayout
     * 'form layouts'}, but titles on top do not.
     *
     * @param titleOrientation titleOrientation Default value is "left"
     */
    public void setTitleOrientation(TitleOrientation titleOrientation) {
        setAttribute("titleOrientation", titleOrientation.getValue(), true);
    }

    /**
     * Default orientation for titles for items in this form.  {@link com.smartgwt.client.types.TitleOrientation} lists valid
     * options. <P> Note that titles on the left or right take up a cell in tabular {@link com.smartgwt.client.docs.FormLayout
     * 'form layouts'}, but titles on top do not.
     *
     *
     * @return Return the orientation of the title for a specific item or the default title orientation if no item is passed.
     */
    public TitleOrientation getTitleOrientation()  {
        return EnumUtil.getEnum(TitleOrientation.values(), getAttribute("titleOrientation"));
    }

    /**
     * The string prepended to the title of every item in this form.
     *
     * @param titlePrefix titlePrefix Default value is ""
     */
    public void setTitlePrefix(String titlePrefix) {
        setAttribute("titlePrefix", titlePrefix, true);
    }

    /**
     * The string prepended to the title of every item in this form.
     *
     *
     * @return String
     */
    public String getTitlePrefix()  {
        return getAttributeAsString("titlePrefix");
    }

    /**
     * The string prepended to the title of an item in this form if its          titleOrientation property is set to "right".
     *
     * @param rightTitlePrefix rightTitlePrefix Default value is ":&nbsp;"
     */
    public void setRightTitlePrefix(String rightTitlePrefix) {
        setAttribute("rightTitlePrefix", rightTitlePrefix, true);
    }

    /**
     * The string prepended to the title of an item in this form if its          titleOrientation property is set to "right".
     *
     *
     * @return String
     */
    public String getRightTitlePrefix()  {
        return getAttributeAsString("rightTitlePrefix");
    }

    /**
     * The string appended to the title of every item in this form.
     *
     * @param titleSuffix titleSuffix Default value is "&nbsp;:"
     */
    public void setTitleSuffix(String titleSuffix) {
        setAttribute("titleSuffix", titleSuffix, true);
    }

    /**
     * The string appended to the title of every item in this form.
     *
     *
     * @return String
     */
    public String getTitleSuffix()  {
        return getAttributeAsString("titleSuffix");
    }

    /**
     * The string appended to the title of an item in this form if its titleOrientation          property is set to "right".
     *
     * @param rightTitleSuffix rightTitleSuffix Default value is ""
     */
    public void setRightTitleSuffix(String rightTitleSuffix) {
        setAttribute("rightTitleSuffix", rightTitleSuffix, true);
    }

    /**
     * The string appended to the title of an item in this form if its titleOrientation          property is set to "right".
     *
     *
     * @return String
     */
    public String getRightTitleSuffix()  {
        return getAttributeAsString("rightTitleSuffix");
    }

    /**
     * Whether titles for form items should wrap.  If not specified, titles will wrap by default.  Can be overridden for
     * individual items via {@link com.smartgwt.client.widgets.form.fields.FormItem#getWrapTitle wrapTitle}
     *
     * @param wrapItemTitles wrapItemTitles Default value is null
     */
    public void setWrapItemTitles(Boolean wrapItemTitles) {
        setAttribute("wrapItemTitles", wrapItemTitles, true);
    }

    /**
     * Whether titles for form items should wrap.  If not specified, titles will wrap by default.  Can be overridden for
     * individual items via {@link com.smartgwt.client.widgets.form.fields.FormItem#getWrapTitle wrapTitle}
     *
     *
     * @return Boolean
     */
    public Boolean getWrapItemTitles()  {
        return getAttributeAsBoolean("wrapItemTitles");
    }

    /**
     * If true, field errors are written into the form next to the item(s) where the errors occurred.  Errors may appear as
     * text or just an icon (via {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}:false).
     * <P> If false, errors are written at the top of the form. <P> To do some other kind of error display, override {@link
     * com.smartgwt.client.widgets.form.DynamicForm#showErrors}.
     *
     * @param showInlineErrors showInlineErrors Default value is true
     */
    public void setShowInlineErrors(Boolean showInlineErrors) {
        setAttribute("showInlineErrors", showInlineErrors, true);
    }

    /**
     * If true, field errors are written into the form next to the item(s) where the errors occurred.  Errors may appear as
     * text or just an icon (via {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}:false).
     * <P> If false, errors are written at the top of the form. <P> To do some other kind of error display, override {@link
     * com.smartgwt.client.widgets.form.DynamicForm#showErrors}.
     *
     *
     * @return Boolean
     */
    public Boolean getShowInlineErrors()  {
        return getAttributeAsBoolean("showInlineErrors");
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons 'showErrorIcons'},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText 'showErrorText'}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle 'showErrorStyle'} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set ${isc.DocUtils.linkForRef('showInlineErrors:false')}. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML}.
     * The default implementation of that method respects <code>showErrorIcons</code> and <code>showErrorText</code> as
     * follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem level controls whether an error
     * icon should appear next to fields which have validation errors.  The icon's appearance is governed by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. See {@link
     * com.smartgwt.client..FormItemBaseStyle} for a  discussion for how error styling is calculated.
     *
     * @param showErrorIcons showErrorIcons Default value is true
     */
    public void setShowErrorIcons(Boolean showErrorIcons) {
        setAttribute("showErrorIcons", showErrorIcons, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons 'showErrorIcons'},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText 'showErrorText'}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle 'showErrorStyle'} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set ${isc.DocUtils.linkForRef('showInlineErrors:false')}. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML}.
     * The default implementation of that method respects <code>showErrorIcons</code> and <code>showErrorText</code> as
     * follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem level controls whether an error
     * icon should appear next to fields which have validation errors.  The icon's appearance is governed by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. See {@link
     * com.smartgwt.client..FormItemBaseStyle} for a  discussion for how error styling is calculated.
     *
     *
     * @return Boolean
     */
    public Boolean getShowErrorIcons()  {
        return getAttributeAsBoolean("showErrorIcons");
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons 'showErrorIcons'},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText 'showErrorText'}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle 'showErrorStyle'} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set ${isc.DocUtils.linkForRef('showInlineErrors:false')}. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML}.
     * The default implementation of that method respects <code>showErrorIcons</code> and <code>showErrorText</code> as
     * follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem level controls whether an error
     * icon should appear next to fields which have validation errors.  The icon's appearance is governed by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. See {@link
     * com.smartgwt.client..FormItemBaseStyle} for a  discussion for how error styling is calculated.
     *
     * @param showErrorText showErrorText Default value is false
     */
    public void setShowErrorText(Boolean showErrorText) {
        setAttribute("showErrorText", showErrorText, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons 'showErrorIcons'},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText 'showErrorText'}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle 'showErrorStyle'} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set ${isc.DocUtils.linkForRef('showInlineErrors:false')}. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML}.
     * The default implementation of that method respects <code>showErrorIcons</code> and <code>showErrorText</code> as
     * follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem level controls whether an error
     * icon should appear next to fields which have validation errors.  The icon's appearance is governed by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. See {@link
     * com.smartgwt.client..FormItemBaseStyle} for a  discussion for how error styling is calculated.
     *
     *
     * @return Boolean
     */
    public Boolean getShowErrorText()  {
        return getAttributeAsBoolean("showErrorText");
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons 'showErrorIcons'},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText 'showErrorText'}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle 'showErrorStyle'} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set ${isc.DocUtils.linkForRef('showInlineErrors:false')}. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML}.
     * The default implementation of that method respects <code>showErrorIcons</code> and <code>showErrorText</code> as
     * follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem level controls whether an error
     * icon should appear next to fields which have validation errors.  The icon's appearance is governed by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. See {@link
     * com.smartgwt.client..FormItemBaseStyle} for a  discussion for how error styling is calculated.
     *
     * @param showErrorStyle showErrorStyle Default value is true
     */
    public void setShowErrorStyle(Boolean showErrorStyle) {
        setAttribute("showErrorStyle", showErrorStyle, true);
    }

    /**
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getShowErrorIcons 'showErrorIcons'},  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText 'showErrorText'}, and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorStyle 'showErrorStyle'} control how validation errors are
     * displayed when they are displayed inline in the form (next to the form item where there is a validation error).  To
     * instead display all errors at the top of the form, set ${isc.DocUtils.linkForRef('showInlineErrors:false')}. <P>
     * <code>showErrorIcons</code>, <code>showErrorText</code> and <code>showErrorStyle</code> are all boolean properties, and
     * can be set on a DynamicForm to control the behavior form-wide, or set on individual FormItems.   <P> The HTML displayed
     * next to a form item with errors is generated by  {@link com.smartgwt.client.widgets.form.fields.FormItem#getErrorHTML}.
     * The default implementation of that method respects <code>showErrorIcons</code> and <code>showErrorText</code> as
     * follows: <P> <code>showErrorIcons</code>, or <code>showErrorIcon</code> at the FormItem level controls whether an error
     * icon should appear next to fields which have validation errors.  The icon's appearance is governed by {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconSrc errorIconSrc}, {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconWidth errorIconWidth} and {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getErrorIconHeight errorIconHeight} <P> <code>showErrorText</code>
     * determines whether the text of the validation error should be displayed next to fields which have validation errors. The
     * attribute {@link com.smartgwt.client.widgets.form.DynamicForm#getShowTitlesWithErrorMessages
     * showTitlesWithErrorMessages} may be set to prefix error messages with the  form item's title + <code>":"</code> (may be
     * desired if the item has  {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowTitle showTitle} set to false).
     * <P> {@link com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation} controls where the error
     * HTML should appear relative  to form items. Therefore the combination of {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getShowErrorText showErrorText}<code>:false</code> and {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation errorOrientation}<code>:"left"</code> creates a compact
     * validation error display consisting of just an icon, to the left of the item with the error message available via a
     * hover (similar appearance to ListGrid validation error display).   <P> In addition to this, <code>showErrorStyle</code>
     * determines whether fields  with validation errors should have special styling applied to them. See {@link
     * com.smartgwt.client..FormItemBaseStyle} for a  discussion for how error styling is calculated.
     *
     *
     * @return Boolean
     */
    public Boolean getShowErrorStyle()  {
        return getAttributeAsBoolean("showErrorStyle");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is false we show all errors
     * for the form item in  a single item rendered at the top of the form.<br> This attribute specifies the cellStyle to apply
     * to this item.
     *
     * @param errorItemCellStyle errorItemCellStyle Default value is "formCellError"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setErrorItemCellStyle(String errorItemCellStyle)  throws IllegalStateException {
        setAttribute("errorItemCellStyle", errorItemCellStyle, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is false we show all errors
     * for the form item in  a single item rendered at the top of the form.<br> This attribute specifies the cellStyle to apply
     * to this item.
     *
     *
     * @return String
     */
    public String getErrorItemCellStyle()  {
        return getAttributeAsString("errorItemCellStyle");
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is false we show all errors
     * for the form item in  a single item rendered at the top of the form.<br> This attribute specifies an introductory string
     * rendered out before the individual error messages.
     *
     * @param errorsPreamble errorsPreamble Default value is "The following errors were found"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setErrorsPreamble(String errorsPreamble)  throws IllegalStateException {
        setAttribute("errorsPreamble", errorsPreamble, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors showInlineErrors} is false we show all errors
     * for the form item in  a single item rendered at the top of the form.<br> This attribute specifies an introductory string
     * rendered out before the individual error messages.
     *
     *
     * @return String
     */
    public String getErrorsPreamble()  {
        return getAttributeAsString("errorsPreamble");
    }

    /**
     * Indicates whether on validation failure, the error message displayed to the          user should be prepended with the
     * title for the item.
     *
     * @param showTitlesWithErrorMessages showTitlesWithErrorMessages Default value is false
     */
    public void setShowTitlesWithErrorMessages(Boolean showTitlesWithErrorMessages) {
        setAttribute("showTitlesWithErrorMessages", showTitlesWithErrorMessages, true);
    }

    /**
     * Indicates whether on validation failure, the error message displayed to the          user should be prepended with the
     * title for the item.
     *
     *
     * @return Boolean
     */
    public Boolean getShowTitlesWithErrorMessages()  {
        return getAttributeAsBoolean("showTitlesWithErrorMessages");
    }

    /**
     * Indicates whether the titles of required items in this form should use the special prefix and suffix specified by the
     * next two properties, instead of the standard prefix and suffix.
     *
     * @param hiliteRequiredFields hiliteRequiredFields Default value is true
     */
    public void setHiliteRequiredFields(Boolean hiliteRequiredFields) {
        setAttribute("hiliteRequiredFields", hiliteRequiredFields, true);
    }

    /**
     * Indicates whether the titles of required items in this form should use the special prefix and suffix specified by the
     * next two properties, instead of the standard prefix and suffix.
     *
     *
     * @return Boolean
     */
    public Boolean getHiliteRequiredFields()  {
        return getAttributeAsBoolean("hiliteRequiredFields");
    }

    /**
     * The string prepended to the title of every required item in this form if highlightRequiredFields is true.
     *
     * @param requiredTitlePrefix requiredTitlePrefix Default value is "<B>"
     */
    public void setRequiredTitlePrefix(String requiredTitlePrefix) {
        setAttribute("requiredTitlePrefix", requiredTitlePrefix, true);
    }

    /**
     * The string prepended to the title of every required item in this form if highlightRequiredFields is true.
     *
     *
     * @return String
     */
    public String getRequiredTitlePrefix()  {
        return getAttributeAsString("requiredTitlePrefix");
    }

    /**
     * The string prepended to the title of every required item in this form if highlightRequiredFields is true and the
     * titleOrientation property is set to "right".
     *
     * @param requiredRightTitlePrefix requiredRightTitlePrefix Default value is "<B>:&nbsp;"
     */
    public void setRequiredRightTitlePrefix(String requiredRightTitlePrefix) {
        setAttribute("requiredRightTitlePrefix", requiredRightTitlePrefix, true);
    }

    /**
     * The string prepended to the title of every required item in this form if highlightRequiredFields is true and the
     * titleOrientation property is set to "right".
     *
     *
     * @return String
     */
    public String getRequiredRightTitlePrefix()  {
        return getAttributeAsString("requiredRightTitlePrefix");
    }

    /**
     * The string appended to the title of every required item in this form if highlightRequiredFields is true.
     *
     * @param requiredTitleSuffix requiredTitleSuffix Default value is " :</B>"
     */
    public void setRequiredTitleSuffix(String requiredTitleSuffix) {
        setAttribute("requiredTitleSuffix", requiredTitleSuffix, true);
    }

    /**
     * The string appended to the title of every required item in this form if highlightRequiredFields is true.
     *
     *
     * @return String
     */
    public String getRequiredTitleSuffix()  {
        return getAttributeAsString("requiredTitleSuffix");
    }

    /**
     * The string appended to the title of every required item in this form if highlightRequiredFields is true and the
     * titleOrientation property is set to "right".
     *
     * @param requiredRightTitleSuffix requiredRightTitleSuffix Default value is "</B>"
     */
    public void setRequiredRightTitleSuffix(String requiredRightTitleSuffix) {
        setAttribute("requiredRightTitleSuffix", requiredRightTitleSuffix, true);
    }

    /**
     * The string appended to the title of every required item in this form if highlightRequiredFields is true and the
     * titleOrientation property is set to "right".
     *
     *
     * @return String
     */
    public String getRequiredRightTitleSuffix()  {
        return getAttributeAsString("requiredRightTitleSuffix");
    }

    /**
     * The required message for required field errors.
     *
     * @param requiredMessage requiredMessage Default value is null
     */
    public void setRequiredMessage(String requiredMessage) {
        setAttribute("requiredMessage", requiredMessage, true);
    }

    /**
     * The required message for required field errors.
     *
     *
     * @return String
     */
    public String getRequiredMessage()  {
        return getAttributeAsString("requiredMessage");
    }

    /**
     * If the user rolls over an item, how long a delay before we fire any hover action / show a hover for that item?
     *
     * @param itemHoverDelay itemHoverDelay Default value is 500
     */
    public void setItemHoverDelay(int itemHoverDelay) {
        setAttribute("itemHoverDelay", itemHoverDelay, true);
    }

    /**
     * If the user rolls over an item, how long a delay before we fire any hover action / show a hover for that item?
     *
     *
     * @return int
     */
    public int getItemHoverDelay()  {
        return getAttributeAsInt("itemHoverDelay");
    }

    /**
     * A default width for hovers shown for items
     *
     * @param itemHoverWidth itemHoverWidth Default value is null
     */
    public void setItemHoverWidth(Integer itemHoverWidth) {
        setAttribute("itemHoverWidth", itemHoverWidth, true);
    }

    /**
     * A default width for hovers shown for items
     *
     *
     * @return Integer
     */
    public Integer getItemHoverWidth()  {
        return getAttributeAsInt("itemHoverWidth");
    }

    /**
     * A default height for hovers shown for items
     *
     * @param itemHoverHeight itemHoverHeight Default value is null
     */
    public void setItemHoverHeight(Integer itemHoverHeight) {
        setAttribute("itemHoverHeight", itemHoverHeight, true);
    }

    /**
     * A default height for hovers shown for items
     *
     *
     * @return Integer
     */
    public Integer getItemHoverHeight()  {
        return getAttributeAsInt("itemHoverHeight");
    }
             
    /**
     * Text alignment for hovers shown for items
     *
     * @param itemHoverAlign itemHoverAlign Default value is null
     */
    public void setItemHoverAlign(Alignment itemHoverAlign) {
        setAttribute("itemHoverAlign", itemHoverAlign.getValue(), true);
    }

    /**
     * Text alignment for hovers shown for items
     *
     *
     * @return Alignment
     */
    public Alignment getItemHoverAlign()  {
        return EnumUtil.getEnum(Alignment.values(), getAttribute("itemHoverAlign"));
    }

    /**
     * Vertical text alignment for hovers shown for items
     *
     * @param itemHoverVAlign itemHoverVAlign Default value is null
     */
    public void setItemHoverVAlign(Integer itemHoverVAlign) {
        setAttribute("itemHoverVAlign", itemHoverVAlign, true);
    }

    /**
     * Vertical text alignment for hovers shown for items
     *
     *
     * @return Integer
     */
    public Integer getItemHoverVAlign()  {
        return getAttributeAsInt("itemHoverVAlign");
    }

    /**
     * CSS Style for hovers shown for items
     *
     * @param itemHoverStyle itemHoverStyle Default value is "formHover"
     */
    public void setItemHoverStyle(String itemHoverStyle) {
        setAttribute("itemHoverStyle", itemHoverStyle, true);
    }

    /**
     * CSS Style for hovers shown for items
     *
     *
     * @return String
     */
    public String getItemHoverStyle()  {
        return getAttributeAsString("itemHoverStyle");
    }

    /**
     * Opacity for hovers shown for items
     *
     * @param itemHoverOpacity itemHoverOpacity Default value is null
     */
    public void setItemHoverOpacity(Integer itemHoverOpacity) {
        setAttribute("itemHoverOpacity", itemHoverOpacity, true);
    }

    /**
     * Opacity for hovers shown for items
     *
     *
     * @return Integer
     */
    public Integer getItemHoverOpacity()  {
        return getAttributeAsInt("itemHoverOpacity");
    }

    /**
     * If true, form fields will be validated when each item's "change" handler is fired  as well as when the entire form is
     * submitted or validated.<br>      Note that this property can also be set at the item level to enable finer granularity  
     *    validation in response to user interaction - if true at either level, validation      will occur on change.
     *
     * @param validateOnChange validateOnChange Default value is false
     */
    public void setValidateOnChange(Boolean validateOnChange) {
        setAttribute("validateOnChange", validateOnChange, true);
    }

    /**
     * If true, form fields will be validated when each item's "change" handler is fired  as well as when the entire form is
     * submitted or validated.<br>      Note that this property can also be set at the item level to enable finer granularity  
     *    validation in response to user interaction - if true at either level, validation      will occur on change.
     *
     *
     * @return Boolean
     */
    public Boolean getValidateOnChange()  {
        return getAttributeAsBoolean("validateOnChange");
    }

    /**
     * If validateOnChange is true, and validation fails for an item on change, with no suggested value, should we revert to
     * the previous value, or continue to display the bad value entered by the user. May be set at the item or form level.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param rejectInvalidValueOnChange rejectInvalidValueOnChange Default value is null
     */
    public void setRejectInvalidValueOnChange(Boolean rejectInvalidValueOnChange) {
        setAttribute("rejectInvalidValueOnChange", rejectInvalidValueOnChange, true);
    }

    /**
     * If validateOnChange is true, and validation fails for an item on change, with no suggested value, should we revert to
     * the previous value, or continue to display the bad value entered by the user. May be set at the item or form level.
     *
     *
     * @return Boolean
     */
    public Boolean getRejectInvalidValueOnChange()  {
        return getAttributeAsBoolean("rejectInvalidValueOnChange");
    }

    /**
     * The error message for a failed validator that does not specify its own errorMessage.
     *
     * @param unknownErrorMessage unknownErrorMessage Default value is "Invalid value"
     */
    public void setUnknownErrorMessage(String unknownErrorMessage) {
        setAttribute("unknownErrorMessage", unknownErrorMessage, true);
    }

    /**
     * The error message for a failed validator that does not specify its own errorMessage.
     *
     *
     * @return String
     */
    public String getUnknownErrorMessage()  {
        return getAttributeAsString("unknownErrorMessage");
    }

    /**
     * If true, form items will be validated when each item's "editorExit" handler is fired as well as when the entire form is
     * submitted or validated. <P> Note that this property can also be set at the item level to enable finer granularity
     * validation in response to user interaction - if true at either level, validation will occur on editorExit.
     *
     * @param validateOnExit validateOnExit Default value is false
     */
    public void setValidateOnExit(Boolean validateOnExit) {
        setAttribute("validateOnExit", validateOnExit, true);
    }

    /**
     * If true, form items will be validated when each item's "editorExit" handler is fired as well as when the entire form is
     * submitted or validated. <P> Note that this property can also be set at the item level to enable finer granularity
     * validation in response to user interaction - if true at either level, validation will occur on editorExit.
     *
     *
     * @return Boolean
     */
    public Boolean getValidateOnExit()  {
        return getAttributeAsBoolean("validateOnExit");
    }

    /**
     * If true, when the form is drawn, focus will automatically be put into the first focusable element in the form.<br> Note
     * that to put focus in a different item you can explicitly call  <code>dynamicForm.focusInItem(<i>itemName</i>)</code>
     *
     * @param autoFocus autoFocus Default value is false
     */
    public void setAutoFocus(Boolean autoFocus) {
        setAttribute("autoFocus", autoFocus, true);
    }

    /**
     * If true, when the form is drawn, focus will automatically be put into the first focusable element in the form.<br> Note
     * that to put focus in a different item you can explicitly call  <code>dynamicForm.focusInItem(<i>itemName</i>)</code>
     *
     *
     * @return Boolean
     */
    public Boolean getAutoFocus()  {
        return getAttributeAsBoolean("autoFocus");
    }

    /**
     * If this property is set to true, whenever a text-based field in this form  ({@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, {@link com.smartgwt.client.widgets.form.fields.TextAreaItem}) is
     * given focus programmatically  (see {@link com.smartgwt.client.widgets.form.DynamicForm#focusInItem}), all text within
     * the item will be selected. <P> Note that this flag affects only programmatic focus.  It's the normal behavior of text
     * fields to select all text if the user navigates into them via keyboard, or if the user navigates via mouse, to place the
     * text insertion point at the mouse click, and Smart GWT preserves these behaviors.  <code>selectOnFocus</code> if only
     * needed for cases like a form within a pop-up dialog that should have the first field selected. <P> If
     * <code>selectOnFocus</code> is false, the selection is not modified on focus - any previous selection within the item
     * will be maintained. <P> May be overridden at the form item level via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSelectOnFocus selectOnFocus}.
     *
     * @param selectOnFocus selectOnFocus Default value is false
     */
    public void setSelectOnFocus(Boolean selectOnFocus) {
        setAttribute("selectOnFocus", selectOnFocus, true);
    }

    /**
     * If this property is set to true, whenever a text-based field in this form  ({@link
     * com.smartgwt.client.widgets.form.fields.TextItem}, {@link com.smartgwt.client.widgets.form.fields.TextAreaItem}) is
     * given focus programmatically  (see {@link com.smartgwt.client.widgets.form.DynamicForm#focusInItem}), all text within
     * the item will be selected. <P> Note that this flag affects only programmatic focus.  It's the normal behavior of text
     * fields to select all text if the user navigates into them via keyboard, or if the user navigates via mouse, to place the
     * text insertion point at the mouse click, and Smart GWT preserves these behaviors.  <code>selectOnFocus</code> if only
     * needed for cases like a form within a pop-up dialog that should have the first field selected. <P> If
     * <code>selectOnFocus</code> is false, the selection is not modified on focus - any previous selection within the item
     * will be maintained. <P> May be overridden at the form item level via {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getSelectOnFocus selectOnFocus}.
     *
     *
     * @return Boolean
     */
    public Boolean getSelectOnFocus()  {
        return getAttributeAsBoolean("selectOnFocus");
    }

    /**
     * DynamicForms are considered to have focus if any of their form items have focus. Note that setting
     * <code>dynamicForm.canFocus</code> to false will have no effect on whether form items within the form may receive focus.
     * This property will only govern whether the form may receive focus if the form contains no focusable items.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canFocus canFocus Default value is true
     */
    public void setCanFocus(Boolean canFocus) {
        setAttribute("canFocus", canFocus, true);
    }

    /**
     * DynamicForms are considered to have focus if any of their form items have focus. Note that setting
     * <code>dynamicForm.canFocus</code> to false will have no effect on whether form items within the form may receive focus.
     * This property will only govern whether the form may receive focus if the form contains no focusable items.
     *
     *
     * @return Boolean
     */
    public Boolean getCanFocus()  {
        return getAttributeAsBoolean("canFocus");
    }

    /**
     * validationURL can be set to do server-side validation against a different URL from where the form will ultimately save,
     * as part of an incremental upgrade strategy for Struts and Struts-like applications.   <P> If set, calling {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit} causes an RPC to be sent to this URL to perform server-side
     * validation of the form values.  If the validation fails, the validation errors returned by the server are rendered in
     * the form.  If the validation succeeds, the form is submitted to the URL specified by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAction action}. <p> The form values are available on the server as
     * request parameters (just like a normal form submit) and also as the values of a DSRequest sent as an RPC alongside the
     * normal submit. <p> The expected response to this request is a DSResponse sent via the RPC mechanism.  If validation is
     * successful, an empty response with the STATUS_SUCCESS status code is sufficient.  If there are validation errors, the
     * DSResponse should have the status set to  STATUS_VALIDATION_ERROR and the errors should be set on the response via the
     * addError()/setErrorReport() API on DSResponse.  See the javadoc for DSResponse for details. <P> See the Struts examples
     * in <code>[webroot]/examples/struts</code> for usage examples.
     *
     * @param validationURL validationURL Default value is null
     */
    public void setValidationURL(String validationURL) {
        setAttribute("validationURL", validationURL, true);
    }

    /**
     * validationURL can be set to do server-side validation against a different URL from where the form will ultimately save,
     * as part of an incremental upgrade strategy for Struts and Struts-like applications.   <P> If set, calling {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit} causes an RPC to be sent to this URL to perform server-side
     * validation of the form values.  If the validation fails, the validation errors returned by the server are rendered in
     * the form.  If the validation succeeds, the form is submitted to the URL specified by {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAction action}. <p> The form values are available on the server as
     * request parameters (just like a normal form submit) and also as the values of a DSRequest sent as an RPC alongside the
     * normal submit. <p> The expected response to this request is a DSResponse sent via the RPC mechanism.  If validation is
     * successful, an empty response with the STATUS_SUCCESS status code is sufficient.  If there are validation errors, the
     * DSResponse should have the status set to  STATUS_VALIDATION_ERROR and the errors should be set on the response via the
     * addError()/setErrorReport() API on DSResponse.  See the javadoc for DSResponse for details. <P> See the Struts examples
     * in <code>[webroot]/examples/struts</code> for usage examples.
     *
     *
     * @return String
     */
    public String getValidationURL()  {
        return getAttributeAsString("validationURL");
    }

    /**
     * If set to true, client-side validators will not run on the form when validate() is called.  Server-side validators (if
     * any) will still run on attempted save.
     *
     * @param disableValidation disableValidation Default value is null
     */
    public void setDisableValidation(Boolean disableValidation) {
        setAttribute("disableValidation", disableValidation, true);
    }

    /**
     * If set to true, client-side validators will not run on the form when validate() is called.  Server-side validators (if
     * any) will still run on attempted save.
     *
     *
     * @return Boolean
     */
    public Boolean getDisableValidation()  {
        return getAttributeAsBoolean("disableValidation");
    }

    /**
     * The name of the special field sent to the server as part of {@link com.smartgwt.client.widgets.form.DynamicForm#cancel}
     *
     * @param cancelParamName cancelParamName Default value is "org.apache.struts.taglib.html.CANCEL"
     */
    public void setCancelParamName(String cancelParamName) {
        setAttribute("cancelParamName", cancelParamName, true);
    }

    /**
     * The name of the special field sent to the server as part of {@link com.smartgwt.client.widgets.form.DynamicForm#cancel}
     *
     *
     * @return String
     */
    public String getCancelParamName()  {
        return getAttributeAsString("cancelParamName");
    }

    /**
     * The value of the special field sent to the server as part of {@link com.smartgwt.client.widgets.form.DynamicForm#cancel}
     *
     * @param cancelParamValue cancelParamValue Default value is "cancel"
     */
    public void setCancelParamValue(String cancelParamValue) {
        setAttribute("cancelParamValue", cancelParamValue, true);
    }

    /**
     * The value of the special field sent to the server as part of {@link com.smartgwt.client.widgets.form.DynamicForm#cancel}
     *
     *
     * @return String
     */
    public String getCancelParamValue()  {
        return getAttributeAsString("cancelParamValue");
    }

    /**
     * The URL to which the form will submit its values. <p> <b>NOTE:</b> this is used only in the very rare case that a form
     * is used to submit data directly to a URL.  Normal server contact is through RPCManager.<br> See {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit canSubmit} for more on this.
     * Sets the {@link com.smartgwt.client.widgets.form.DynamicForm#getAction 'action'} for this form.
     *
     * @param action New action URL. Default value is "#"
     */
    public void setAction(String action) {
        setAttribute("action", action, true);
    }

    /**
     * The URL to which the form will submit its values. <p> <b>NOTE:</b> this is used only in the very rare case that a form
     * is used to submit data directly to a URL.  Normal server contact is through RPCManager.<br> See {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit canSubmit} for more on this.
     *
     *
     * @return String
     */
    public String getAction()  {
        return getAttributeAsString("action");
    }

    /**
     * The name of a window or frame that will receive the results returned by the form's action. The default null indicates to
     * use the current frame. <p> <b>NOTE:</b> this is used only in the very rare case that a form is used to submit data
     * directly to a URL.  Normal server contact is through {@link com.smartgwt.client.docs.DataBoundComponentMethods
     * 'DataBound Component Methods'}.
     * Sets the {@link com.smartgwt.client.widgets.form.DynamicForm#getTarget 'target'} for this form.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param target New submission target. Default value is null
     */
    public void setTarget(String target) {
        setAttribute("target", target, true);
    }

    /**
     * The name of a window or frame that will receive the results returned by the form's action. The default null indicates to
     * use the current frame. <p> <b>NOTE:</b> this is used only in the very rare case that a form is used to submit data
     * directly to a URL.  Normal server contact is through {@link com.smartgwt.client.docs.DataBoundComponentMethods
     * 'DataBound Component Methods'}.
     *
     *
     * @return String
     */
    public String getTarget()  {
        return getAttributeAsString("target");
    }
             
    /**
     * The mechanism by which form data is sent to the action URL. See FormMethod type for details. <p> <b>NOTE:</b> this is
     * used only in the very rare case that a form is used to submit data directly to a URL.  Normal server contact is through 
     * {@link com.smartgwt.client.docs.DataBoundComponentMethods 'DataBound Component Methods'}.
     * Sets the {@link com.smartgwt.client.widgets.form.DynamicForm#getMethod 'method'} for this form.
     *
     * @param method html form submission method (get or post). Default value is DynamicForm.POST
     */
    public void setMethod(FormMethod method) {
        setAttribute("method", method.getValue(), true);
    }

    /**
     * The mechanism by which form data is sent to the action URL. See FormMethod type for details. <p> <b>NOTE:</b> this is
     * used only in the very rare case that a form is used to submit data directly to a URL.  Normal server contact is through 
     * {@link com.smartgwt.client.docs.DataBoundComponentMethods 'DataBound Component Methods'}.
     *
     *
     * @return FormMethod
     */
    public FormMethod getMethod()  {
        return EnumUtil.getEnum(FormMethod.values(), getAttribute("method"));
    }
             
    /**
     * encoding for the form, use MULTIPART_ENCODING for file upload forms
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param encoding encoding Default value is DynamicForm.NORMAL
     */
    public void setEncoding(Encoding encoding) {
        setAttribute("encoding", encoding.getValue(), true);
    }

    /**
     * encoding for the form, use MULTIPART_ENCODING for file upload forms
     *
     *
     * @return Encoding
     */
    public Encoding getEncoding()  {
        return EnumUtil.getEnum(Encoding.values(), getAttribute("encoding"));
    }

    /**
     * Governs whether this form will be used to perform a standard HTML form submission. Note that if true, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit} will perform a native HTML submission to the specified {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAction action} URL.<br> Wherever possible we strongly recommend using
     * the  {@link com.smartgwt.client.docs.DataBoundComponentMethods 'DataBound Component Methods'} to send data to the server
     * as they provide a far more sophisticated interface, with built in  options for server validation, required fields,
     * etc.<br>
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canSubmit canSubmit Default value is false
     */
    public void setCanSubmit(Boolean canSubmit) {
        setAttribute("canSubmit", canSubmit, true);
    }

    /**
     * Governs whether this form will be used to perform a standard HTML form submission. Note that if true, {@link
     * com.smartgwt.client.widgets.form.DynamicForm#submit} will perform a native HTML submission to the specified {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getAction action} URL.<br> Wherever possible we strongly recommend using
     * the  {@link com.smartgwt.client.docs.DataBoundComponentMethods 'DataBound Component Methods'} to send data to the server
     * as they provide a far more sophisticated interface, with built in  options for server validation, required fields,
     * etc.<br>
     *
     *
     * @return Boolean
     */
    public Boolean getCanSubmit()  {
        return getAttributeAsBoolean("canSubmit");
    }

    /**
     * If <code>true</code>, when the user hits the Enter key while focused in a text-item in this form, we automatically
     * submit the form to the server using the  {@link com.smartgwt.client.widgets.form.DynamicForm#submit} method.
     *
     * @param saveOnEnter saveOnEnter Default value is false
     */
    public void setSaveOnEnter(Boolean saveOnEnter) {
        setAttribute("saveOnEnter", saveOnEnter, true);
    }

    /**
     * If <code>true</code>, when the user hits the Enter key while focused in a text-item in this form, we automatically
     * submit the form to the server using the  {@link com.smartgwt.client.widgets.form.DynamicForm#submit} method.
     *
     *
     * @return Boolean
     */
    public Boolean getSaveOnEnter()  {
        return getAttributeAsBoolean("saveOnEnter");
    }

    /**
     * If set, this <code>DynamicForm</code> will set both  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowComplexFields 'showComplexFields'} and 
     * <code>showComplexFieldsRecursively</code> on any nested component used for showing/editing a complex field.  Thus any of
     * this form's items that handle complex fields will themselves also show complex fields.  This allows for handling of
     * field structures of any complexity. <p> If set, this value automatically sets {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowComplexFields 'showComplexFields'} as well.
     *
     * @param showComplexFieldsRecursively showComplexFieldsRecursively Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowComplexFieldsRecursively(Boolean showComplexFieldsRecursively)  throws IllegalStateException {
        setAttribute("showComplexFieldsRecursively", showComplexFieldsRecursively, false);
    }

    /**
     * If set, this <code>DynamicForm</code> will set both  {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowComplexFields 'showComplexFields'} and 
     * <code>showComplexFieldsRecursively</code> on any nested component used for showing/editing a complex field.  Thus any of
     * this form's items that handle complex fields will themselves also show complex fields.  This allows for handling of
     * field structures of any complexity. <p> If set, this value automatically sets {@link
     * com.smartgwt.client.widgets.DataBoundComponent#getShowComplexFields 'showComplexFields'} as well.
     *
     *
     * @return Boolean
     */
    public Boolean getShowComplexFieldsRecursively()  {
        return getAttributeAsBoolean("showComplexFieldsRecursively");
    }

    /**
     * Warning to display to the user if an attempt to {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm} a form
     * is unable to submit to the server. The most common cause for this failure is that the user has typed an invalid
     * file-path into an upload type field.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param formSubmitFailedWarning formSubmitFailedWarning Default value is "Form was unable to be submitted. The most likely cause for this is an invalid value in an upload field."
     */
    public void setFormSubmitFailedWarning(String formSubmitFailedWarning) {
        setAttribute("formSubmitFailedWarning", formSubmitFailedWarning, true);
    }

    /**
     * Warning to display to the user if an attempt to {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm} a form
     * is unable to submit to the server. The most common cause for this failure is that the user has typed an invalid
     * file-path into an upload type field.
     *
     *
     * @return String
     */
    public String getFormSubmitFailedWarning()  {
        return getAttributeAsString("formSubmitFailedWarning");
    }
             
    /**
     * Default {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData} is called. This property is automatically set on a call to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editRecord} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editNewRecord}, or may be set directly via  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType}. <P> If <code>saveOperationType</code> is unset, the
     * form will heuristically determine whether an "add" or "update" operation is intended based on whether the primaryKey
     * field is present and editable.
     * Setter for the default {@link com.smartgwt.client.types.DSOperationType} when {@link com.smartgwt.client.widgets.form.DynamicForm#saveData} is called. Note that this property can also be set by calling {@link com.smartgwt.client.widgets.form.DynamicForm#editRecord} or  {@link com.smartgwt.client.widgets.form.DynamicForm#editNewRecord}
     *
     * @param saveOperationType Operation type to use as a default. Valid values are  <code>"add"</code> or <code>"update"</code>.. Default value is null
     */
    public void setSaveOperationType(DSOperationType saveOperationType) {
        setAttribute("saveOperationType", saveOperationType.getValue(), true);
    }

    /**
     * Default {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData} is called. This property is automatically set on a call to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editRecord} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#editNewRecord}, or may be set directly via  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setSaveOperationType}. <P> If <code>saveOperationType</code> is unset, the
     * form will heuristically determine whether an "add" or "update" operation is intended based on whether the primaryKey
     * field is present and editable.
     *
     *
     * @return Returns the {@link com.smartgwt.client.types.DSOperationType} to be performed when {@link
     * com.smartgwt.client.widgets.form.DynamicForm#saveData} is called. Valid options are <code>"add"</code> or
     * <code>"update"</code>. <P> If a {@link com.smartgwt.client.data.DSRequest} configuration object is passed in containing
     * an explicit operationType this will be returned. Otherwise {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType} will be returned.
     */
    public DSOperationType getSaveOperationType()  {
        return EnumUtil.getEnum(DSOperationType.values(), getAttribute("saveOperationType"));
    }
             
    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getAutoFetchData autoFetchData} is <code>true</code>, this
     * attribute allows the developer to specify a textMatchStyle for the initial {@link
     * com.smartgwt.client.widgets.form.DynamicForm#fetchData} call.
     *
     * @param autoFetchTextMatchStyle autoFetchTextMatchStyle Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAutoFetchTextMatchStyle(TextMatchStyle autoFetchTextMatchStyle)  throws IllegalStateException {
        setAttribute("autoFetchTextMatchStyle", autoFetchTextMatchStyle.getValue(), false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.form.DynamicForm#getAutoFetchData autoFetchData} is <code>true</code>, this
     * attribute allows the developer to specify a textMatchStyle for the initial {@link
     * com.smartgwt.client.widgets.form.DynamicForm#fetchData} call.
     *
     *
     * @return TextMatchStyle
     */
    public TextMatchStyle getAutoFetchTextMatchStyle()  {
        return EnumUtil.getEnum(TextMatchStyle.values(), getAttribute("autoFetchTextMatchStyle"));
    }

    // ********************* Methods ***********************
            
    /**
     * Same as {@link com.smartgwt.client.widgets.form.DynamicForm#reset}.
     */
    public native void resetValues() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.resetValues();
    }-*/;
            
    /**
     * Reset to default form values and clear errors
     */
    public native void clearValues() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearValues();
    }-*/;
            
    /**
     * Compares the current set of values with the values stored by the call to the          <code>rememberValues()</code>
     * method. Returns true if the values have changed, and false          otherwise.
     *
     * @return true if current values do not match remembered values
     */
    public native Boolean valuesHaveChanged() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.valuesHaveChanged();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Return an AdvancedCriteria object based on the current set of values within this form. <p> Similar to {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getValuesAsCriteria}, except the returned criteria object is guaranteed to
     * be an AdvancedCriteria object, even if none of the form's fields has a specified {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator}
     *
     * @return a ${isc.DocUtils.linkForRef('object:AdvancedCriteria')} based on the form's current values
     */
    public native AdvancedCriteria getValuesAsAdvancedCriteria() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getValuesAsAdvancedCriteria();
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.AdvancedCriteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
            
    /**
     * Sets the value for some field
     * @param fieldName Name of the field being updated. A {@link com.smartgwt.client..dataPath} may                           be passed to set
     * nested values
     * @param value New value.
     */
    public native void setValue(String fieldName, String value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setValue(fieldName, value);
    }-*/;
            
    /**
     * Clears the value for some field via a call to {@link com.smartgwt.client.widgets.form.fields.FormItem#clearValue} if
     * appropriate. If there is no item associated with the field name, the field will just be cleared within our stored set of
     * values.
     * @param fieldName Name of the field being cleared. A {@link com.smartgwt.client..dataPath} may be used for  clearing details of nested
     * data structures.
     */
    public native void clearValue(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearValue(fieldName);
    }-*/;
            
    /**
     * Show a form item via {@link com.smartgwt.client.widgets.form.fields.FormItem#show}
     * @param itemName Name of the item to show
     */
    public native void showItem(String itemName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showItem(itemName);
    }-*/;
            
    /**
     * Hide a form item via {@link com.smartgwt.client.widgets.form.fields.FormItem#hide}
     * @param itemName Name of the item to show
     */
    public native void hideItem(String itemName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.hideItem(itemName);
    }-*/;
            
    /**
     * Clear any validation errors on the field passed in.
     * @param fieldName field to clear errors from
     * @param show If true this method will fall through to {@link com.smartgwt.client.widgets.form.DynamicForm#showFieldErrors}  to update
     * the display
     */
    public native void clearFieldErrors(String fieldName, boolean show) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearFieldErrors(fieldName, show);
    }-*/;
            
    /**
     * Clears all errors for this DynamicForm.
     * @param show If true, redraw the form to clear any visible error messages.
     */
    public native void clearErrors(boolean show) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.clearErrors(show);
    }-*/;
            
    /**
     * Return whether this form currently has any validation errors.<br> Validation errors are set up automatically by
     * validation, or may be explicitly set via {@link com.smartgwt.client.widgets.form.DynamicForm#setErrors} or {@link
     * com.smartgwt.client.widgets.form.DynamicForm#setFieldErrors}.
     *
     * @return true == form currently has validation errors.
     */
    public native Boolean hasErrors() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.hasErrors();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Does this form currently h ave any validation errors on the field passed in?<br> Validation errors are set up
     * automatically by validation, or may be explicitly set via {@link com.smartgwt.client.widgets.form.DynamicForm#setErrors}
     * or {@link com.smartgwt.client.widgets.form.DynamicForm#setFieldErrors}.
     * @param fieldName field to test for validation errors
     *
     * @return true if the form has outstanding errors for the field in question.
     */
    public native Boolean hasFieldErrors(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.hasFieldErrors(fieldName);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * Submits the form to the URL defined by {@link com.smartgwt.client.widgets.form.DynamicForm#getAction action}, 
     * identically to how a plain HTML &lt;form&gt; element would submit data, as either an HTTP GET or POST as specified by
     * {@link com.smartgwt.client.widgets.form.DynamicForm#getMethod method}. <P> <b>Notes:</b> <ul> <li>this is used only in
     * the very rare case that a form is used to submit data directly to a URL.  Normal server contact is through  {@link
     * com.smartgwt.client.docs.DataBoundComponentMethods 'DataBound Component Methods'}.</li> <li>For this method to reliably
     * include values for every field in the grid,       {@link com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit
     * canSubmit} must be set to <code>true</code></li> <li>To submit values for fields that do not have an editor, use {@link
     * com.smartgwt.client.widgets.form.fields.HiddenItem}  with a {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getDefaultValue defaultValue} set.  This is analogous to &lt;input
     * type="hidden"&gt; in HTML forms. </ul>
     */
    public native void submitForm() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.submitForm();
    }-*/;
    /**
     * Add a formSubmitFailed handler.
     * <p>
     * Method called when an attempt to {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm} a form is unable to
     * submit to the server. Default behavior is to display the {@link
     * com.smartgwt.client.widgets.form.DynamicForm#getFormSubmitFailedWarning formSubmitFailedWarning} in a warning dialog.
     * The most common cause for this failure is that the user has typed an invalid file-path into an upload type field.
     *
     * @param handler the formSubmitFailed handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addFormSubmitFailedHandler(com.smartgwt.client.widgets.form.events.FormSubmitFailedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.FormSubmitFailedEvent.getType()) == 0) setupFormSubmitFailedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.FormSubmitFailedEvent.getType());
    }

    private native void setupFormSubmitFailedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({formSubmitFailed:$entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.form.events.FormSubmitFailedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.formSubmitFailed = $entry(function(){
                   var param = {};
                   var event = @com.smartgwt.client.widgets.form.events.FormSubmitFailedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * Validates the form without submitting it, and redraws the form to display error messages if there are any validation
     * errors. Returns true if validation succeeds, or false if validation fails.<br> For databound forms, any Datasource field
     * validators will be run even if there is no  associated item in the form.<br> Validators will also be run on hidden form
     * items<br> In both these cases, validation failure can be handled via  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#handleHiddenValidationErrors}
     * @param validateHiddenFields Should validators be processed for non-visible fields         such as dataSource fields with no associated item or
     * fields with visibility set to         <code>"hidden"</code>?
     *
     * @return true if validation succeeds, or false if validation fails.
     */
    public native Boolean validate(boolean validateHiddenFields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.validate(validateHiddenFields);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;
            
    /**
     * If this form has any outstanding validation errors for the field passed in, show them now. Called when field errors are
     * set directly via {@link com.smartgwt.client.widgets.form.DynamicForm#setFieldErrors} /  {@link
     * com.smartgwt.client.widgets.form.DynamicForm#addFieldErrors} / {@link
     * com.smartgwt.client.widgets.form.DynamicForm#clearFieldErrors}.<br> Default implementation simply falls through to
     * {@link com.smartgwt.client.widgets.form.DynamicForm#showErrors}.
     * @param fieldName field to show errors for
     */
    public native void showFieldErrors(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.showFieldErrors(fieldName);
    }-*/;
    /**
     * Add a itemChanged handler.
     * <p>
     * Handler fired when there is a changed() event fired on a FormItem within this form. <P> Fires after the change() handler
     * on the FormItem itself, and only if the item did not cancel the change event and chooses to allow it to propagate to the
     * form as a whole.
     *
     * @param handler the itemChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addItemChangedHandler(com.smartgwt.client.widgets.form.events.ItemChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.ItemChangedEvent.getType()) == 0) setupItemChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.ItemChangedEvent.getType());
    }

    private native void setupItemChangedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({itemChanged:$entry(function(){
                        var param = {"item" : arguments[0], "newValue" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.form.events.ItemChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.itemChanged = $entry(function(){
                   var param = {"item" : arguments[0], "newValue" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.form.events.ItemChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
    /**
     * Add a itemChange handler.
     * <p>
     * Handler fired when there is a change() event fired on a FormItem within this form. <P> Fires after the change() handler
     * on the FormItem itself, and only if the item did not cancel the change event and chooses to allow it to propagate to the
     * form as a whole.
     *
     * @param handler the itemChange handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addItemChangeHandler(com.smartgwt.client.widgets.form.events.ItemChangeHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.ItemChangeEvent.getType()) == 0) setupItemChangeEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.ItemChangeEvent.getType());
    }

    private native void setupItemChangeEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({itemChange:$entry(function(){
                        var param = {"item" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.form.events.ItemChangeEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.itemChange = $entry(function(){
                   var param = {"item" : arguments[0], "newValue" : arguments[1], "oldValue" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.form.events.ItemChangeEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               });
        }
   }-*/;
    /**
     * Add a itemKeyPress handler.
     * <p>
     * Handler fired when a FormItem within this form receives a keypress event. <P> Fires after the keyPress handler on the
     * FormItem itself, and only if the item did not cancel the event and chooses to allow it to propagate to the form as a
     * whole.
     *
     * @param handler the itemKeyPress handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addItemKeyPressHandler(com.smartgwt.client.widgets.form.events.ItemKeyPressHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.ItemKeyPressEvent.getType()) == 0) setupItemKeyPressEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.ItemKeyPressEvent.getType());
    }

    private native void setupItemKeyPressEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({itemKeyPress:$entry(function(){
                        var param = {"item" : arguments[0], "keyName" : arguments[1], "characterValue" : arguments[2]};
                        var event = @com.smartgwt.client.widgets.form.events.ItemKeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                        var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                        return !ret;
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.itemKeyPress = $entry(function(){
                   var param = {"item" : arguments[0], "keyName" : arguments[1], "characterValue" : arguments[2]};
                   var event = @com.smartgwt.client.widgets.form.events.ItemKeyPressEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                   var ret = event.@com.smartgwt.client.event.Cancellable::isCancelled()();
                   return !ret;
               });
        }
   }-*/;
    /**
     * Add a submitValues handler.
     * <p>
     * Triggered when a SubmitItem is included in the form is submitted and gets pressed.
     *
     * @param handler the submitValues handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addSubmitValuesHandler(com.smartgwt.client.widgets.form.events.SubmitValuesHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.form.events.SubmitValuesEvent.getType()) == 0) setupSubmitValuesEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.form.events.SubmitValuesEvent.getType());
    }

    private native void setupSubmitValuesEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({submitValues:$entry(function(){
                        var param = {"values" : arguments[0], "form" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.form.events.SubmitValuesEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.submitValues = $entry(function(){
                   var param = {"values" : arguments[0], "form" : arguments[1]};
                   var event = @com.smartgwt.client.widgets.form.events.SubmitValuesEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * Perform validation on the client and the server.
     */
    public native void validateData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.validateData();
    }-*/;
            
    /**
     * Resets values to the state it was the last time <code>setValues()</code> or <code>rememberValues()</code> was called. If
     * neither of those methods has been called, values will be set back to their initial values at init time.
     */
    public native void reset() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reset();
    }-*/;
            
    /**
     * &#010 This method exists for clean integration with existing server frameworks that have a 'cancel'&#010 feature which
     * typically clears session state associated with the form.  When this method is&#010 called, an RPC is sent to the server
     * with a parameter named&#010 {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamName cancelParamName} with
     * the value&#010 {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamValue cancelParamValue}.<p>&#010&#010
     * Note that no other form data is sent.  By default the current top-level page is replaced with the&#010 reply.  If you
     * wish to ignore the server reply instead, call this method like this:&#010 <pre>&#010
     * dynamicFormInstance.cancel({ignoreTimeout: true, target: null});&#010 </pre>&#010&#010
     */
    public native void cancel() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancel();
    }-*/;

    /**
     * &#010 This method exists for clean integration with existing server frameworks that have a 'cancel'&#010 feature which
     * typically clears session state associated with the form.  When this method is&#010 called, an RPC is sent to the server
     * with a parameter named&#010 {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamName cancelParamName} with
     * the value&#010 {@link com.smartgwt.client.widgets.form.DynamicForm#getCancelParamValue cancelParamValue}.<p>&#010&#010
     * Note that no other form data is sent.  By default the current top-level page is replaced with the&#010 reply.  If you
     * wish to ignore the server reply instead, call this method like this:&#010 <pre>&#010
     * dynamicFormInstance.cancel({ignoreTimeout: true, target: null});&#010 </pre>&#010&#010
     * @param requestProperties additional properties to set on the RPCRequest                                          that will be issued
     */
    public native void cancel(DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancel(requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
            
    /**
     * Returns true if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType} is currently
     * "add".  See {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOperationType saveOperationType}.
     *
     * @return whether this form will use an "add" operation when saving
     */
    public native Boolean isNewRecord() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var retVal =self.isNewRecord();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    // ********************* Static Methods ***********************



    private FormItem[] fields;

    protected native void onInit() /*-{
        this.@com.smartgwt.client.widgets.form.DynamicForm::linkFields()();
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self._showErrors = self.showErrors;
        self.showErrors = $entry(function() {
            var jObj = this.__ref;
            return jObj.@com.smartgwt.client.widgets.form.DynamicForm::showErrors()();
        });
    }-*/;


    /**
     * If this form has any outstanding validation errors, show them now.<br>&#010 This method is called when the set of errors are
     * changed by {@link com.smartgwt.client.widgets.form.DynamicForm#setErrors} or&#010 {@link com.smartgwt.client.widgets.form.DynamicForm#validate}.
     * <br>&#010 Default implementation will redraw the form to display error messages and call&#010
     * {@link com.smartgwt.client.widgets.form.DynamicForm#handleHiddenValidationErrors} to&#010 display errors with no visible field.
     * <p/>
     * <br>
     * <p/>
     * <p><b>Note: This is an override point</b>.&#010 This method may be overridden to perform custom display of validation errors.
     */
    public native void showErrors() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self._showErrors();
    }-*/;

    private void linkFields() {
        if (fields != null) {
            for (FormItem field : fields) {
                JavaScriptObject fieldJS = getFieldJS(field.getName());
                field.setJsObj(fieldJS);
            }
        }
    }

    private native JavaScriptObject getFieldJS(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var fieldJS = self.getField(fieldName);
        return fieldJS;
    }-*/;

    /**
     * If set at init time, this dynamicForm will be created as a member form for the specified valuesManager.  To
     * update the valuesManager to which a form belongs after init use <code>valuesManager.addMember(form)</code> and
     * <code>valuesManager.removeMember(form)</code> <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param valuesManager valuesManager Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setValuesManager(ValuesManager valuesManager) throws IllegalStateException {
        setAttribute("valuesManager", valuesManager.getOrCreateJsObj(), false);
    }

    /**
     * Return the ValuesManager for this form.
     *
     * @return the ValuesManager
     */
    public ValuesManager getValuesManager() {
        return ValuesManager.getOrCreateRef(getAttributeAsJavaScriptObject("valuesManager"));
    }

    /**
     * Set the cellSpacing.
     *
     * @param cellSpacing the cellSpacing
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCellSpacing(int cellSpacing) throws IllegalStateException {
        setAttribute("cellSpacing", cellSpacing, false);
    }

    /**
     * Return the cellSpacing.
     *
     * @return the cellSpacing
     */
    public int getCellSpacing() {
        return getAttributeAsInt("cellSpacing");
    }

    /**
     * If true, the set of fields given by the "default binding" (see DataBoundComponent.fields) is used, with any
     * fields specified in component.fields acting as overrides that can suppress or modify the display of individual
     * fields, without having to list the entire set of fields that should be shown.
     * <p/>
     * If component.fields contains fields that are not found in the DataSource, they will be shown after the most
     * recently referred to DataSource field. If the new fields appear first, they will be shown first.
     *
     * @param useAllDataSourceFields useAllDataSourceFields
     */
    public void setUseAllDataSourceFields(boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    /**
     * et the values for this DynamicForm. Member forms will be updated as required by this change. Note that pre-existant values in other fields are cleared out by this. .
     *
     * @param values the values
     */
    public void setValues(Map values) {
        setAttribute("values", values, true);
    }

    /**
     * Returns the current set of values where each propertyName is the name of a form item in the form, and each property
     * value is the value held by that form item.
     *
     * @return the values
     */
    public native Map getValues() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getValues();
        if(value == null) return null;
        var valueJ = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
        return valueJ;
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, double value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setValue(fieldName, value);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, boolean value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setValue(fieldName, value);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, Map value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(value);
        self.setValue(fieldName, valueJS);
    }-*/;
    
    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, JavaScriptObject value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setValue(fieldName, value);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, Record value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = value.@com.smartgwt.client.data.Record::getJsObj()();
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, DataClass value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = value.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, Record[] value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(value);
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Set the value for some field.
     *
     * @param fieldName Name of the field being updated
     * @param value New value.
     */
    public native void setValue(String fieldName, DataClass[] value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var valueJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(value);
        self.setValue(fieldName, valueJS);
    }-*/;

    /**
     * Synonym for {@link #setFields(com.smartgwt.client.widgets.form.fields.FormItem[])}.
     *
     * @param items the items
     */
    public void setItems(FormItem... items) {
        setFields(items);
    }


    /**
     * When {@link com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator} has been set for any {@link
     * com.smartgwt.client.widgets.form.fields.FormItem} in this form, what logical operator should be applied across
     * the ${isc.DocUtils.linkForRef('object:Criterion','criteria')} produced by the form items?  Only applicable to
     * forms that have a {@link com.smartgwt.client..DataBoundComponent#getDataSource dataSource}.
     *
     * @param operator operator Default value is "and"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setOperator(OperatorId operator) throws IllegalStateException {
        setAttribute("operator", operator, false);
    }

    /**
     * When {@link com.smartgwt.client.widgets.form.fields.FormItem#getOperator operator} has been set for any {@link
     * com.smartgwt.client.widgets.form.fields.FormItem} in this form, what logical operator should be applied across
     * the ${isc.DocUtils.linkForRef('object:Criterion','criteria')} produced by the form items?  Only applicable to
     * forms that have a {@link com.smartgwt.client..DataBoundComponent#getDataSource dataSource}.
     *
     * @return OperationId
     */
    public OperatorId getOperator() {
        return EnumUtil.getEnum(OperatorId.values(), getAttribute("operator"));
    }

    /**
     * An array of field objects, specifying the order, layout, and types of each field in the DynamicForm. When both
     * {@link #setFields fields} and {@link #setDataSource dataSource} are set, {@link #setFields fields} acts as a set
     * of overrides as explained in DataBoundComponent fields.
     * <p/>
     * See Form Layout for information about how flags specified on the FormItems control how the form is laid out.
     *
     * @param fields form item fields
     */
    public void setFields(FormItem... fields) {
        setAttribute("fields", fields, true);
        this.fields = fields;
        if(isCreated()) {
            linkFields();
        }
    }

    /**
     * Return thhe form fields
     *
     * @return the form fields
     */
    public FormItem[] getFields() {
        if(fields == null || getDataSource() != null) {
            return convertToFormItemArray(getAttributeAsJavaScriptObject("fields"));
        } else {
            return fields;
        }
    }

    private static FormItem[] convertToFormItemArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new FormItem[]{};
        }
        JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
        FormItem[] objects = new FormItem[componentsj.length];
        for (int i = 0; i < componentsj.length; i++) {
            JavaScriptObject fieldJS = componentsj[i];
            objects[i] = FormItemFactory.getFormItem(fieldJS);
        }
        return objects;
    }

    public FormItem getItem(String name) {
        return getField(name);
    }

    public FormItem getField(String name) {
        if (fields != null) {
            for (FormItem field : fields) {
                if (name.equals(field.getName())) {
                    return field;
                }
            }
        } else {
            JavaScriptObject fieldJS = getFieldJS(name);
            if(fieldJS != null) {
                return FormItemFactory.getFormItem(fieldJS);
            } else {
                return null;
            }
        }
        return null;
    }

    public native String getValueAsString(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var val = self.getValue(fieldName);
        return val == null || val === undefined ? null : val.toString();
    }-*/;

    public native Object getValue(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var val = self.getValue(fieldName);
        return val == null || val === undefined ? null : $wnd.SmartGWT.convertToJavaType(val);
    }-*/;
    
    /**
     * Validates the form without submitting it, and redraws the form to display error messages if there are any
     * validation errors. Returns true if validation succeeds, or false if validation fails.<br> For databound forms,
     * any Datasource field validators will be run even if there is no  associated item in the form.<br> Validators will
     * also be run on hidden form items<br> In both these cases, validation failure can be handled via {@link
     * com.smartgwt.client.widgets.form.DynamicForm#handleHiddenValidationErrors}
     *
     * @return true if validation succeeds, or false if validation fails.
     */
    public native boolean validate() /*-{
            var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
            return self.validate();
    }-*/;

    /**
     * Prepare to edit a new record by clearing the current set of values (or replacing them with initialValues if specified).
     * Subsequent calls to saveData() will use an add rather than an update operation.
     */
    public native void editNewRecord() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.editNewRecord();
    }-*/;

    /**
     * Prepare to edit a new record by clearing the current set of values (or replacing them with initialValues if specified).
     * Subsequent calls to saveData() will use an add rather than an update operation.
     *
     * @param initialValues initial set of values for the editor as a map of field names to their corresponding values
     */
    public native void editNewRecord(Map initialValues) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var initialValuesJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(initialValues);
        return self.editNewRecord(initialValuesJS);
    }-*/;



    public native void editSelectedData(ListGrid selectionComponent) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var selectionComponentJS = selectionComponent.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editSelectedData(selectionComponentJS);
    }-*/;

    public native void editSelectedData(String listGridID) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editSelectedData(listGridID);
    }-*/;

    public native Criteria getValuesAsCriteria() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = self.getValuesAsCriteria();
        return @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(critJS);
    }-*/;
    

    /**
     * Return the current set of values within this form as a Record.
     *
     * @return a Record object containing the form's current values
     */
    public Record getValuesAsRecord() {
    	Map values = getValues();
    	return new Record(JSOHelper.convertMapToJavascriptObject(values));
    }


    /**
     * An array of widths for the columns of items in this form's layout grid. <p> If specified, these widths should sum
     * to the total width of the form (form.width). If not specified, we assume every other column will contain form item
     * titles, and so should have <code>form.titleWidth</code>, and all other columns should share the remaining space.
     * <p>
     * Acceptable values for each element in the array are:<br>
     * <ul>
     * <li>A number (e.g. 100) representing the number of pixel widths to allocate to a column.</li>
     * <li>A percent (e.g. 20%) representing the percentage of the total form.width to allocate to a column.</li>
     * <li> &quot;*&quot; (all) to allocate remaining width (form.width minus all specified column widths). Multiple columns
     * can use &quot;*&quot;, in which case remaining width is divided between all columns marked </li>
     * </ul>
     * @param colWidths the column widths
     */
    public void setColWidths(Object... colWidths) {
        setAttribute("colWidths", colWidths, true);
    }

    /**
     * The width in pixels allocated to the title of every item in this form. If you don't specify explicit {@link DynamicForm#setColWidths(Object...) colWidths},
     * you can set this value to the string "*" to divide the usable space evenly between titles and fields.
     *
     * @param titleWidth the title width
     */
    public void setTitleWidth(int titleWidth) {
        setAttribute("titleWidth", titleWidth, true);
    }

    /**
     * The width in pixels allocated to the title of every item in this form. If you don't specify explicit {@link DynamicForm#setColWidths(Object...) colWidths},
     * you can set this value to the string "*" to divide the usable space evenly between titles and fields.
     *
     * @param titleWidth the title width
     */
    public void setTitleWidth(String titleWidth) {
        setAttribute("titleWidth", titleWidth, true);
    }

    /**
     * If DynamicForm.showInlineErrors is true, where should the error icon and text appear relative to form items? Valid options are "top",
     * "bottom", "left" or "right".
     * <p>
     * May be overridden at the item level via {@link FormItem#setErrorOrientation(com.smartgwt.client.types.FormErrorOrientation)}.
     *
     * @param errorOrientation the error orientation
     */
    public void setErrorOrientation(FormErrorOrientation errorOrientation) {
        setAttribute("errorOrientation", errorOrientation, true);
    }

    public native void saveData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveData();
    }-*/;

    public native void saveData(DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.saveData($entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void saveData(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.saveData($entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;


    /**
     * <code>submit()</code> is automatically called when a {@link com.smartgwt.client.widgets.form.fields.SubmitItem}
     * included in the form is clicked, or, if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter
     * saveOnEnter} is set, when the "Enter" key is pressed in a text input.  Submit can also be manually called. <P> If
     * {@link com.smartgwt.client.widgets.form.DynamicForm#submitValues} exists, it will be called, then immediately
     * return. <P> Otherwise, default behavior varies based on {@link com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit
     * canSubmit}: if <code>canSubmit</code> is false, {@link com.smartgwt.client.widgets.form.DynamicForm#saveData}
     * will be called to handle saving via Smart GWT databinding.   <P> If <code>canSubmit</code> is true, the form
     * will be submitted like an ordinary HTML form via {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm}.
     * <P> The parameters to <code>submit()</code> apply only if <code>submit()</code> will be calling {@link
     * com.smartgwt.client.widgets.form.ValuesManager#saveData}.  If you override <code>submit()</code>, you can safely
     * ignore the parameters as Smart GWT framework code does not pass them.
     */
    public native void submit() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.submit();
    }-*/;

    /**
     * <code>submit()</code> is automatically called when a {@link com.smartgwt.client.widgets.form.fields.SubmitItem}
     * included in the form is clicked, or, if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter
     * saveOnEnter} is set, when the "Enter" key is pressed in a text input.  Submit can also be manually called. <P> If
     * {@link com.smartgwt.client.widgets.form.DynamicForm#submitValues} exists, it will be called, then immediately
     * return. <P> Otherwise, default behavior varies based on {@link com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit
     * canSubmit}: if <code>canSubmit</code> is false, {@link com.smartgwt.client.widgets.form.DynamicForm#saveData}
     * will be called to handle saving via Smart GWT databinding.   <P> If <code>canSubmit</code> is true, the form
     * will be submitted like an ordinary HTML form via {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm}.
     * <P> The parameters to <code>submit()</code> apply only if <code>submit()</code> will be calling {@link
     * com.smartgwt.client.widgets.form.ValuesManager#saveData}.  If you override <code>submit()</code>, you can safely
     * ignore the parameters as Smart GWT framework code does not pass them.
     *
     * @param callback callback to invoke on completion. [Ignored if canSubmit is true]
     */
    public native void submit(DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.submit($entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    /**
     * <code>submit()</code> is automatically called when a {@link com.smartgwt.client.widgets.form.fields.SubmitItem}
     * included in the form is clicked, or, if {@link com.smartgwt.client.widgets.form.DynamicForm#getSaveOnEnter
     * saveOnEnter} is set, when the "Enter" key is pressed in a text input.  Submit can also be manually called. <P> If
     * {@link com.smartgwt.client.widgets.form.DynamicForm#submitValues} exists, it will be called, then immediately
     * return. <P> Otherwise, default behavior varies based on {@link com.smartgwt.client.widgets.form.DynamicForm#getCanSubmit
     * canSubmit}: if <code>canSubmit</code> is false, {@link com.smartgwt.client.widgets.form.DynamicForm#saveData}
     * will be called to handle saving via Smart GWT databinding.   <P> If <code>canSubmit</code> is true, the form
     * will be submitted like an ordinary HTML form via {@link com.smartgwt.client.widgets.form.DynamicForm#submitForm}.
     * <P> The parameters to <code>submit()</code> apply only if <code>submit()</code> will be calling {@link
     * com.smartgwt.client.widgets.form.ValuesManager#saveData}.  If you override <code>submit()</code>, you can safely
     * ignore the parameters as Smart GWT framework code does not pass them.
     *
     * @param callback          callback to invoke on completion.                                          [Ignored if
     *                          this.canSubmit is true]
     * @param requestProperties additional properties to set on the DSRequest
     *                          that will be issued                                          [Ignored if this.canSubmit
     *                          is true]
     */
    public native void submit(DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.saveData($entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    /**
     * Edit an existing record.  Updates this editors values to match the values of the record  passed in. <P> Subsequent calls to <code>saveData()</code> will use an <code>update</code> rather than an <code>add</code> operation.
     * @param record the record to be edited as a map of field names to their corresponding values
     */
    public native void editRecord(Record record) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.editRecord(record.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Move the keyboard focus into a particular item.
     *
     * @param itemNumber the item number
     */
    public native void focusInItem(int itemNumber) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.focusInItem(itemNumber);
    }-*/;

    /**
     * Move the keyboard focus into a particular item.
     *
     * @param itemName the item name
     */
    public native void focusInItem(String itemName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.focusInItem(itemName);
    }-*/;

    /**
     * Move the keyboard focus into a particular item.
     *
     * @param formItem the form item
     */
    public native void focusInItem(FormItem formItem) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var formItemJS = formItem.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.focusInItem(formItemJS);
    }-*/;

    /**
     * Setter for validation errors on this form. Errors passed in should be a Map in the format
     * {fieldName1:errors, fieldName2:errors}
     *
     * Where the errors value may be either a string (single error message) or an array of strings (if multiple errors should be applied to the field in question).

     * @param errors  list of errors as a map with the field names as keys
     * @param showErrors If true redraw form to display errors now. Otherwise errors can be displayed by calling
     *      {@link DynamicForm#showErrors} <b>Note</b>: When the errors are shown, handleHiddenValidationErrors() will be fired for errors
     *      on hidden fields, or with no associated formItem.
     */
    public native void setErrors(Map errors, boolean showErrors) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var errorsJS = @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(errors);
        return self.setErrors(errorsJS, showErrors);
    }-*/;

    /**
     * Returns the set of errors.
     *
     * @return errors. key is field name, value is error. Returns null if no errors are present
     */
    public native Map getErrors() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getErrors();
        if(value == null) return null;
        var valueJ = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
        return valueJ;
    }-*/;

    /**
     * Set field validation error for some field. The showErrors parameter allows the errors to be displayed immediately.
     * Alternatively, an explicit call to {@link DynamicForm#showFieldErrors} will display the errors for this field.
     * 
     * @param fieldName field to apply the new errors to
     * @param error error to apply to the field in question
     * @param showErrors If true this method will fall through to DynamicForm.showFieldErrors() to update the display
     */
    public native void setFieldErrors(String fieldName, String error, boolean showErrors) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.setFieldErrors(fieldName, error, showErrors);
    }-*/;

    /**
     * Set field validation errors for some field. The showErrors parameter allows the errors to be displayed immediately.
     * Alternatively, an explicit call to {@link DynamicForm#showFieldErrors} will display the errors for this field.
     *
     * @param fieldName field to apply the new errors to
     * @param errors errors to apply to the field in question
     * @param showErrors If true this method will fall through to DynamicForm.showFieldErrors() to update the display
     */
    public native void setFieldErrors(String fieldName, String[] errors, boolean showErrors) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var errorsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(errors);
        return self.setFieldErrors(fieldName, errorsJS, showErrors);
    }-*/;

    /**
     * Returns any validation errors for some field in this valuesManager. If no errors are present, will return null.
     *
     * @param fieldName the field name
     * @return error messages for the field.
     */
    public native String[] getFieldErrors(String fieldName) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var value = self.getFieldErrors(fieldName);
        if(value == null) return null;
        if(!@com.smartgwt.client.util.JSOHelper::isArray(Lcom/google/gwt/core/client/JavaScriptObject;)(data)) {
            value = [value];
        }
        return @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(value);
    }-*/;

    /**
     * Make a snapshot of the current set of values, so we can reset to them later. Creates a new object, then adds all
     * non-method properties of values to the new object. Use resetValues() to revert to these values. Note that this
     * method is automatically called when the values for this form are set programmatically via a call to
     * DynamicForm.setValues().
     *
     * @return copy of current form values
     */
    public native JavaScriptObject rememberValues() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.rememberValues();
    }-*/;

    /**
     * Method to determine whether the current form values would pass validation. This method will run validators on the
     * form's values and return a value indicating whether validation was successful.
     *
     * <p>
     * Unlike DynamicForm.validate() this method will not store the errors on the DynamicForm or display them to the user.
     * 
     * @param validateHiddenFields Should validators be processed for non-visible fields such as dataSource fields with no
     * associated item or fields with visibility set to "hidden"?
     * @return boolean value indicating success or failure of validation
     */
    public native boolean valuesAreValid(boolean validateHiddenFields) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.valuesAreValid(validateHiddenFields);
    }-*/;
    
   /**
    * The FormItemHoverFormatter should return the HTML to display in a hover canvas when the user holds the mousepointer over this item.
    * Return null to suppress the hover canvas altogether.
    *
    * @param hoverFormatter the hover formatter
    */
    public native void setItemHoverFormatter(FormItemHoverFormatter hoverFormatter) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var formJ = this;
        self.itemHoverHTML = $entry(function(item) {
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            return hoverFormatter.@com.smartgwt.client.widgets.form.FormItemHoverFormatter::getHoverHTML(Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/widgets/form/DynamicForm;)(itemJ, formJ);
        });
    }-*/;

   /**
    * The FormItemHoverFormatter should return the HTML to display in a hover canvas when the user holds the mousepointer over the item's title.
    * Return null to suppress the hover canvas altogether.
    *
    * @param hoverFormatter the hover formatter
    */
    public native void setItemTitleHoverFormatter(FormItemHoverFormatter hoverFormatter) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var formJ = this;
        self.titleHoverHTML = $entry(function(item) {
            var itemJ = @com.smartgwt.client.widgets.form.fields.FormItem::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            return hoverFormatter.@com.smartgwt.client.widgets.form.FormItemHoverFormatter::getHoverHTML(Lcom/smartgwt/client/widgets/form/fields/FormItem;Lcom/smartgwt/client/widgets/form/DynamicForm;)(itemJ, formJ);
        });
    }-*/;



    // ********************* DataBoundComponent Properties / Attributes ***********************

    public void setDataFetchMode(FetchMode fetchMode) {
        setAttribute("dataFetchMode", fetchMode, true);
    }

    public FetchMode getDataFetchMode() {
        return EnumUtil.getEnum(FetchMode.values(), getAttribute("dataFetchMode"));
    }
    
    public void setDataPageSize(int dataPageSize) {
        setAttribute("dataPageSize", dataPageSize, true);
    }

    public int getDataPageSize() {
        return getAttributeAsInt("dataPageSize");
    }

    public void setUseAllDataSourceFields(Boolean useAllDataSourceFields) {
        setAttribute("useAllDataSourceFields", useAllDataSourceFields, true);
    }

    public Boolean getUseAllDataSourceFields() {
        return getAttributeAsBoolean("useAllDataSourceFields");
    }

    public void setShowHiddenFields(Boolean showHiddenFields) {
        setAttribute("showHiddenFields", showHiddenFields, true);
    }

    public Boolean getShowHiddenFields() {
        return getAttributeAsBoolean("showHiddenFields");
    }

    public void setShowDetailFields(Boolean showDetailFields) {
        setAttribute("showDetailFields", showDetailFields, true);
    }

    public Boolean getShowDetailFields() {
        return getAttributeAsBoolean("showDetailFields");
    }

    public void setShowComplexFields(Boolean showComplexFields) {
        setAttribute("showComplexFields", showComplexFields, true);
    }

    public Boolean getShowComplexFields() {
        return getAttributeAsBoolean("showComplexFields");
    }

    public void setFetchOperation(String fetchOperation) {
        setAttribute("fetchOperation", fetchOperation, true);
    }

    public String getFetchOperation() {
        return getAttributeAsString("fetchOperation");
    }

    public void setUpdateOperation(String updateOperation) {
        setAttribute("updateOperation", updateOperation, true);
    }

    public String getUpdateOperation() {
        return getAttributeAsString("updateOperation");
    }

    public void setAddOperation(String addOperation) {
        setAttribute("addOperation", addOperation, true);
    }

    public String getAddOperation() {
        return getAttributeAsString("addOperation");
    }

    public void setRemoveOperation(String removeOperation) {
        setAttribute("removeOperation", removeOperation, true);
    }

    public String getRemoveOperation() {
        return getAttributeAsString("removeOperation");
    }

    public void setExportFields(String[] exportFields) {
        setAttribute("exportFields", exportFields, true);
    }

    public String[] getExportFields() {
        return getAttributeAsStringArray("exportFields");
    }

    public void setExportAll(Boolean exportAll) {
        setAttribute("exportAll", exportAll, true);
    }

    public Boolean getExportAll() {
        return getAttributeAsBoolean("exportAll");
    }

    public void setPreventDuplicates(Boolean preventDuplicates) throws IllegalStateException {
        setAttribute("preventDuplicates", preventDuplicates, false);
    }

    public Boolean getPreventDuplicates() {
        return getAttributeAsBoolean("preventDuplicates");
    }

    public void setDuplicateDragMessage(String duplicateDragMessage) throws IllegalStateException {
        setAttribute("duplicateDragMessage", duplicateDragMessage, false);
    }

    public String getDuplicateDragMessage() {
        return getAttributeAsString("duplicateDragMessage");
    }

    public void setAddDropValues(Boolean addDropValues) {
        setAttribute("addDropValues", addDropValues, true);
    }

    public Boolean getAddDropValues() {
        return getAttributeAsBoolean("addDropValues");
    }

    public void setDropValues(Map dropValues) {
        setAttribute("dropValues", dropValues, true);
    }

    public Map getDropValues() {
        return getAttributeAsMap("dropValues");
    }

    public void setUseFlatFields(Boolean useFlatFields) throws IllegalStateException {
        setAttribute("useFlatFields", useFlatFields, false);
    }

    public Boolean getUseFlatFields() {
        return getAttributeAsBoolean("useFlatFields");
    }

    public void setHiliteProperty(String hiliteProperty) {
        setAttribute("hiliteProperty", hiliteProperty, true);
    }

    public String getHiliteProperty() {
        return getAttributeAsString("hiliteProperty");
    }

    public void setDragDataAction(DragDataAction dragDataAction) {
        setAttribute("dragDataAction", dragDataAction.getValue(), true);
    }

    public DragDataAction getDragDataAction() {
        return EnumUtil.getEnum(DragDataAction.values(), getAttribute("dragDataAction"));
    }

    public void setDragTrackerStyle(String dragTrackerStyle) {
        setAttribute("dragTrackerStyle", dragTrackerStyle, true);
    }

    public String getDragTrackerStyle() {
        return getAttributeAsString("dragTrackerStyle");
    }

    public void setCanAddFormulaFields(Boolean canAddFormulaFields) {
        setAttribute("canAddFormulaFields", canAddFormulaFields, true);
    }

    public native void addSummaryField() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.addSummaryField();
     }-*/;

    public native void addFormulaField() /*-{
       var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
       self.addFormulaField();
    }-*/;

    public Boolean getCanAddFormulaFields() {
        return getAttributeAsBoolean("canAddFormulaFields");
    }

    public void setAddFormulaFieldText(String addFormulaFieldText) {
        setAttribute("addFormulaFieldText", addFormulaFieldText, true);
    }

    public String getAddFormulaFieldText() {
        return getAttributeAsString("addFormulaFieldText");
    }

    public void setEditFormulaFieldText(String editFormulaFieldText) {
        setAttribute("editFormulaFieldText", editFormulaFieldText, true);
    }

    public String getEditFormulaFieldText() {
        return getAttributeAsString("editFormulaFieldText");
    }

    public void setCanAddSummaryFields(Boolean canAddSummaryFields) {
        setAttribute("canAddSummaryFields", canAddSummaryFields, true);
    }

    public Boolean getCanAddSummaryFields() {
        return getAttributeAsBoolean("canAddSummaryFields");
    }

    public void setAddSummaryFieldText(String addSummaryFieldText) {
        setAttribute("addSummaryFieldText", addSummaryFieldText, true);
    }

    public String getAddSummaryFieldText() {
        return getAttributeAsString("addSummaryFieldText");
    }

    public void setEditSummaryFieldText(String editSummaryFieldText) {
        setAttribute("editSummaryFieldText", editSummaryFieldText, true);
    }

    public String getEditSummaryFieldText() {
        return getAttributeAsString("editSummaryFieldText");
    }

    // ********************* Methods ***********************


    public native void selectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS);
     }-*/;

    public native void selectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
     }-*/;

    public native void selectRecord(int record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record, newState);
     }-*/;

    public native void selectRecord(Record record, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.selectRecord(recordJS, newState);
     }-*/;

    public native void selectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecord(recordsJS);
     }-*/;

    public native void selectRecords(int[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void selectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS);
     }-*/;

    public native void selectRecords(Record[] records, boolean newState)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.selectRecords(recordsJS, newState);
     }-*/;

    public native void deselectRecord(Record record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordJS = record.@com.smartgwt.client.data.Record::getJsObj()();
        self.deselectRecord(recordJS);
     }-*/;

    public native void deselectRecord(int record)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.selectRecord(record);
     }-*/;

    public native void deselectRecords(int[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void deselectRecords(Record[] records)/*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(records);
        self.deselectRecords(recordsJS);
     }-*/;

    public native void selectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.selectAllRecords();
     }-*/;

    public native void deselectAllRecords() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.deselectAllRecords();
     }-*/;

    public native Boolean anySelected() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         var retVal =self.anySelected();
         if(retVal == null || retVal === undefined) {
             return null;
         } else {
             return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
         }
     }-*/;

    public native void enableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID);
     }-*/;

    public native void enableHilite(String hiliteID, boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHilite(hiliteID, enable);
     }-*/;

    public native void disableHilite(String hiliteID) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHilite(hiliteID);
     }-*/;

    public native void enableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting();
     }-*/;

    public native void enableHiliting(boolean enable) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.enableHiliting(enable);
     }-*/;

    public native void disableHiliting() /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         self.disableHiliting();
     }-*/;

    public native Record[] getDragData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var recordsJS = self.getDragData();
        return @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
     }-*/;

    public native void transferSelectedData(DataBoundComponent source) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
     }-*/;

    public native void transferSelectedData(DataBoundComponent source, int index) /*-{
         var self = this.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
         self.transferSelectedData(source.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), index);
     }-*/;

    public native int getRecordIndex(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getRecordIndex(record.@com.smartgwt.client.core.DataClass::getJsObj()());
     }-*/;

    public native String getTitleFieldValue(Record record) /*-{
         var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
         return self.getTitleFieldValue(record);
     }-*/;

    public void setTitleField(String titleField) {
        setAttribute("titleField", titleField, true);
    }

    public String getTitleField() {
        return getAttributeAsString("titleField");
    }

    public void setDataSource(DataSource dataSource) {
        setAttribute("dataSource", dataSource.getOrCreateJsObj(), true);
    }

    public DataSource getDataSource() {
        return DataSource.getOrCreateRef(getAttributeAsJavaScriptObject("dataSource"));
    }

    public void setAutoFetchData(Boolean autoFetchData) throws IllegalStateException {
        setAttribute("autoFetchData", autoFetchData, false);
    }

    public Boolean getAutoFetchData() {
        return getAttributeAsBoolean("autoFetchData");
    }

    public void setAutoFetchAsFilter(Boolean autoFetchAsFilter) throws IllegalStateException {
        setAttribute("autoFetchAsFilter", autoFetchAsFilter, false);
    }

    public Boolean getAutoFetchAsFilter() {
        return getAttributeAsBoolean("autoFetchAsFilter");
    }

    public void setInitialCriteria(Criteria initialCriteria) throws IllegalStateException {
        setAttribute("initialCriteria", initialCriteria.getJsObj(), false);
    }

    public Criteria getInitialCriteria() {
        return new Criteria(getAttributeAsJavaScriptObject("initialCriteria"));
    }

    public native void fetchData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData();
    }-*/;

    public native void fetchData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void fetchData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.fetchData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native void filterData() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData();
    }-*/;

    public native void filterData(Criteria criteria) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.filterData(criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()());
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }));
    }-*/;

    public native void filterData(Criteria criteria, DSCallback callback, DSRequest requestProperties) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var critJS = criteria == null ? null : criteria.@com.smartgwt.client.data.Criteria::getJsObj()();
        var requestPropertiesJS = requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()();
        self.filterData(critJS, $entry(function (dsResponse, data, dsRequest) {
            var responseJ = @com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse);
            var requestJ = @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest);
            if(callback != null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(responseJ, data, requestJ);
        }), requestPropertiesJS);
    }-*/;

    public native void invalidateCache() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.invalidateCache();
    }-*/;

    public ResultSet getResultSet() throws IllegalStateException {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        if(dataJS == null) return null;
        if(!ResultSet.isResultSet(dataJS)) {
            throw new IllegalStateException("getResultSet() can only be called on DataBoundComponents after initial data has been fetched");
        }
        return new ResultSet(dataJS);
    }

    public RecordList getRecordList() {
        JavaScriptObject dataJS = getAttributeAsJavaScriptObject("data");
        if(dataJS == null) return null;

        if(ResultSet.isResultSet(dataJS)) {
            return getResultSet();
        }
        return new RecordList(dataJS);
    }

}



