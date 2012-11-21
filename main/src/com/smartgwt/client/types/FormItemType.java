package com.smartgwt.client.types;


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
 
/**
 * DynamicForms automatically choose the FormItem type for a field based on the <code>type</code> property of the field. 
 * The table below describes the default FormItem chosen for various values of the <code>type</code> property. <P> You can
 * also set {@link com.smartgwt.client.widgets.form.fields.FormItem#getEditorType field.editorType} to the classname of a
 * {@link com.smartgwt.client.widgets.form.fields.FormItem} to override this default mapping.  You can alternatively
 * override {@link com.smartgwt.client.widgets.form.DynamicForm#getEditorType DynamicForm.getEditorType} to create a form
 * with different rules for which FormItems are chosen. <P>
 */
public enum FormItemType implements ValueEnum {

    /**
     * Rendered as a {@link com.smartgwt.client.widgets.form.fields.TextItem}, unless the lenght of the field (as specified by
     * {@link com.smartgwt.client.data.DataSourceField#setLength(Integer) length}  attribute) is larger than the value&#010 specified by
     * {@link com.smartgwt.client.widgets.form.DynamicForm#setLongTextEditorThreshold(int) longTextEditorThreshold} , a&#010
     * {@link com.smartgwt.client.widgets.form.fields.TextAreaItem} is shown.
     */
    TEXT("text"),
    /**
     * Rendered as a {@link com.smartgwt.client.widgets.form.fields.CheckboxItem}
     */
    BOOLEAN("boolean"),
    /**
     * Same as <code>text</code> by default.                     Consider setting editorType: {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}
     */
    INTEGER("integer"),
    /**
     * Same as <code>text</code> by default.                     Consider setting editorType: {@link com.smartgwt.client.widgets.form.fields.SpinnerItem}.
     */
    FLOAT("float"),
    /**
     * Rendered as a {@link com.smartgwt.client.widgets.form.fields.DateItem}
     */
    DATE("date"),
    /**
     * Rendered as a {@link com.smartgwt.client.widgets.form.fields.TimeItem}
     */
    TIME("time"),
    /**
     * Rendered as a {@link com.smartgwt.client.widgets.form.fields.SelectItem}.  Also true for any field that specifies a
     * {@link com.smartgwt.client.widgets.form.fields.FormItem#setValueMap(String[])}    &#010                   Consider setting
     * editorType: {@link com.smartgwt.client.widgets.form.fields.ComboBoxItem}.
     */
    ENUM("enum"),
    /**
     * Same as <code>text</code>
     */
    SEQUENCE("sequence"),
    /**
     * If {@link com.smartgwt.client.data.DataSourceField#setCanEdit(Boolean) canEdit} <code>:false</code> is set on the field, the value
     * is rendered as a {@link com.smartgwt.client.widgets.form.fields.LinkItem}.  Otherwise the field is rendered as a&#010
     * {@link com.smartgwt.client.widgets.form.fields.TextItem}.
     */
    LINK("link"),
    IMAGE("image"),
    CHECKBOX("checkbox"),
    STATIC_TEXT("staticText"),
    BLOB("blob"),
    MULTI_FILE("multifile"),
    MULTI_UPLOAD("multiupload"),
    UPLOAD("upload"),
    FILE("file"),
    BASE64_BINARY("base64Binary"),
    CYCLE_ITEM("CycleItem"),
    SELECT_OTHER("selectOther"),
    RELATION("relation"),

    SELECT_ITEM("SelectItem"),
    HIDDEN_ITEM("HiddenItem"),
    HEADER_ITEM("HeaderItem"),
    DATE_ITEM("DateItem"),
    BLURB_ITEM("BlurbItem"),
    COMBOBOX_ITEM("ComboBoxItem"),
    MULTICOMBOBOX_ITEM("MultiComboBoxItem"),
    SPACER_ITEM("SpacerItem"),
    ROWSPACER_ITEM("RowSpacerItem"),
    CHECKBOX_ITEM("CheckboxItem"),
    STATICTEXT_ITEM("StaticTextItem"),
    LINK_ITEM("LinkItem"),
    CANVAS_ITEM("CanvasItem"),
    PICKTREE_ITEM("PickTreeItem"),
    BUTTON_ITEM("ButtonItem"),
    SUBMIT_ITEM("SubmitItem"),
    RESET_ITEM("ResetItem"),
    RICHTEXT_ITEM("RichTextItem"),
    FILE_ITEM("FileItem"),
    SLIDER_ITEM("SliderItem"),
    TOOLBAR_ITEM("ToolbarItem"),
    SECTION_ITEM("SectionItem"),
    TEXTAREA_ITEM("TextAreaItem"),
    TEXT_ITEM("TextItem"),
    UPLOAD_ITEM("UploadItem"),
    PASSWORD_ITEM("PasswordItem"),
    SPINNER_ITEM("SpinnerItem"),
    TIME_ITEM("TimeItem"),
    NATIVE_CHECKBOX_ITEM("NativeCheckboxItem"),
    RADIOGROUP_ITEM("radioGroup"),

    IMAGEFILE("imagefile"),
    /**
     * Rendered as a {@link com.smartgwt.client.widgets.form.fields.UploadItem}
     */
    BINARY("binary");
    private String value;

    FormItemType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
        
