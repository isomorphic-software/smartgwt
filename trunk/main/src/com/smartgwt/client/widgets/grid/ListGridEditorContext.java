package com.smartgwt.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.fields.FormItem;

/**
 * Context object holding information about the cell being edited as part of a listGrid edit event.
 */
public class ListGridEditorContext {

    private int rowNum;
    private ListGridField editField;
    private ListGridRecord editedRecord;
    private FormItem defaultProperties;
    
    ListGridEditorContext (JavaScriptObject jsContext) {
        
        FormItem item = FormItem.getOrCreateRef(JSOHelper.getAttributeAsJavaScriptObject(jsContext, "editProperties"));
        setDefaultProperties(item);
        
        setRowNum(JSOHelper.getAttributeAsInt(jsContext, "rowNum"));
        
        ListGridField editField = ListGridField.getOrCreateRef(JSOHelper.getAttributeAsJavaScriptObject(jsContext, "editField"));
        setEditField(editField);
        
        ListGridRecord record = ListGridRecord.getOrCreateRef(JSOHelper.getAttributeAsJavaScriptObject(jsContext, "editedRecord"));
        setEditedRecord(record);
         
    }
    
    /**
     * Default FormItem properties to apply to the editor for this cell. These properties are derived automatically
     * from {@link ListGridField#setEditorType()}
     * @return
     */
    public FormItem getDefaultProperties() {
        return defaultProperties;
    }
    public void setDefaultProperties(FormItem item) {
        defaultProperties = item;
    }
    
    /**
     * Returns the rowNum being edited
     * @return
     */
    public int getRowNum() {
        return rowNum;
    }
    
    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }
    
    /**
     * Returns the field in which the editor will be displayed
     * @return
     */
    public ListGridField getEditField() {
        return editField;
    }
    public void setEditField(ListGridField field) {
        editField = field;
    }
    
    /**
     * Similar to {@link ListGrid#getEditedRecord()}, this method returns a copy of the 
     * record being edited, with unsaved edit values applied.
     * @return
     */
    public ListGridRecord getEditedRecord() {
        return editedRecord;
    }
    public void setEditedRecord(ListGridRecord record) {
        editedRecord = record;
    }

}
