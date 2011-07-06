package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.widgets.form.fields.FormItem;

/**
 * Customizer for the edit FormItem shown in a ListGrid cell
 */
public interface ListGridEditorCustomizer {
    /**
     * This method fires when the editor for a cell in an editable grid is being displayed, and allows
     * developers to customize the FormItem displayed to the user dynamically depending on the row being edited
     * as well as just the field. The FormItem returned will be used as
     * a template (properties block) for the item displayed to the user - as with {@link ListGridField#setEditorType()} 
     * if applying event handlers to the item, the live item should be retrieved from the event object.
     * <P>
     * Any properties specified on the returned form item will be applied on top of the default form item properties
     * derived from {@link ListGridField#getType()}, {@link ListGridField#setEditorType(FormItem)} etc. For default
     * behavior, simply return null.
     * 
     * @param context context object containing details of the cell being edited.
     * @return template FormItem.
     */
    public FormItem getEditor(ListGridEditorContext context);

}
