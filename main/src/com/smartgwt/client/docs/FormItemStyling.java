
package com.smartgwt.client.docs;

/**
 * <h3>FormItem Styling</h3>
 * Different FormItem types are rendered using different DOM structures. This is an overview
 * explaining the various elements that may be produced and how they can be styled: <P> Form items
 * written out by a DynamicForm with  {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getItemLayout itemLayout:"table"} are written into
 * table cells. A formItem can govern the appearance of these cells using properties such as 
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle FormItem.cellStyle},
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#getCellHeight FormItem.cellHeight}.
 * These properties have no effect for formItems rendered outside a form (for example the during
 * {@link com.smartgwt.client.widgets.grid.ListGrid#getCanEdit grid editing}), or if
 * <code>itemLayout</code> is "absolute". <P> If a formItem is showing a {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon}, the picker
 * icon and text box will be written into an element referred to as the control table. Styling
 * applied to this element (via {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getControlStyle FormItem.controlStyle}) will
 * extend around both the text box and the picker (but not other icons, hints, etc). The control
 * table is not written out if the pickerIcon is not visible except in the case where the {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIconOnFocus
 * FormItem.showPickerIconOnFocus} is true, and the item does not have focus, or if a developer
 * explicitly sets {@link com.smartgwt.client.widgets.form.fields.FormItem#getAlwaysShowControlBox
 * FormItem.alwaysShowControlBox} to true. <P> The textBox of an item is the area containing its
 * main textual content. This may natively be achieved as a data element (such as an &lt;input
 * ...&gt;), or a static DOM element. See {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getTextBoxStyle FormItem.textBoxStyle}, and
 * related {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyTextBoxStyle
 * FormItem.readOnlyTextBoxStyle} and {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getPrintTextBoxStyle
 * FormItem.printTextBoxStyle} for styling options.  See also {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#shouldApplyHeightToTextBox
 * FormItem.shouldApplyHeightToTextBox()} for a discussion on sizing the text box. <P> Any visible
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#getValueIcons valueIcon} will be
 * rendered inside the text box for  static items, or adjacent to it for items where the text is
 * editable (such as {@link com.smartgwt.client.widgets.form.fields.TextItem}). Explicit styling
 * for the valueIcon can be specified via the {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getValueIconStyle
 * FormItem.getValueIconStyle()} method. <P> FormItems can also show explicitly defined {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getIcons FormItem.icons}. By default these 
 * show up next to the item, outside its text box and control table / after the {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShowPickerIcon picker icon} (if present),
 * though {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getInline inline
 * positioning} is also supported for some cases. Their appearance and behavior are heavily
 * customizable - see {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getBaseStyle
 * FormItemIcon.baseStyle}, {@link com.smartgwt.client.widgets.form.fields.FormItemIcon#getSrc
 * FormItemIcon.src} and related properties. <P> {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getHint FormItem hints} may be written out as
 * static text after any icons, and styled according to the {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getHintStyle FormItem.hintStyle} - or where
 * supported, written directly into the text box with styling derived from the textBoxStyle plus a
 * suffix of <code>"Hint"</code>. (See {@link
 * com.smartgwt.client.widgets.form.fields.TextItem#getShowHintInField TextItem.showHintInField}).
 * <P> In addition to this, form items may show validation error icons or text  (see {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getShowInlineErrors DynamicForm.showInlineErrors},
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorIcon
 * FormItem.showErrorIcon} and {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorText FormItem.showErrorText}). The
 * position of these error indicators is controlled by {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getErrorOrientation DynamicForm.errorOrientation}.
 * <P> Most formItem user-interface elements support stateful styling - showing a different
 * apperance for {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowFocused focused},
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowOver over}, {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabled FormItem.showDisabled} and
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#getShowErrorStyle error} state. <P>
 * Default styling for items will vary by skin, and note that subclasses of  FormItem may have
 * additional styling properties not explicitly called out here.<br> Developers performing global
 * styling modifications for formItems should also be aware of compound items (such as {@link
 * com.smartgwt.client.widgets.form.fields.DateItem}) which achieve their user interface by
 * embedding simpler items in an outer structure. See {@link
 * com.smartgwt.client.docs.CompoundFormItem_skinning}.
 * @see com.smartgwt.client.docs.FormItemBaseStyle
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowFocused
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowOver
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getUpdateTextBoxOnOver
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getUpdateControlOnOver
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getUpdatePickerIconOnOver
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getShowDisabled
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getCellStyle
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getHintStyle
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getTextBoxStyle
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getPrintTextBoxStyle
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getPickerIconStyle
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getControlStyle
 * @see com.smartgwt.client.widgets.form.fields.SelectItem#getPickerIconStyle
 * @see com.smartgwt.client.widgets.form.fields.SelectItem#getShowFocused
 * @see com.smartgwt.client.widgets.form.fields.SelectItem#getShowOver
 * @see com.smartgwt.client.widgets.form.fields.SelectItem#getUpdateTextBoxOnOver
 * @see com.smartgwt.client.widgets.form.fields.SelectItem#getUpdateControlOnOver
 * @see com.smartgwt.client.widgets.form.fields.UploadItem#getTextBoxStyle
 * @see com.smartgwt.client.widgets.form.fields.MiniDateRangeItem#getTextBoxStyle
 */
public interface FormItemStyling {
}
