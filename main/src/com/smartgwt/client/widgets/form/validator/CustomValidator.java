package com.smartgwt.client.widgets.form.validator;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.form.DynamicForm;

import java.util.HashMap;
import java.util.Map;

public abstract class CustomValidator extends Validator {

    public CustomValidator() {
        setAttribute("type", "custom");
        setup(getJsObj());

    }

    protected FormItem formItem;
    protected DataSourceField dataSourceField;
    protected ListGridField listGridField;
    protected Record record;
    protected Map validatorProperties = new HashMap();
    protected Object resultingValue;
    protected DynamicForm dynamicForm;
    protected ListGrid listGrid;
    protected Integer rowNum;
    protected Integer colNum;

    /**
     * Add custom validation logic by overriding this method. Access to the FormItem, ListGridField or DataSourceField on which the validator was
     * declared can be obtained by the {@link #getFormItem()}, {@link #getListGridField()} and {@link #getDataSourceField()} methods respectively.
     * The field values for the record being validated can be obtained by calling {@link #getRecord()}.  The component being validated can be 
     * obtained by calling {@link #getListGrid()} or {@link #getDynamicForm()}.  If the component being validated is a ListGrid, the row and 
     * column numbers identifying the cell being validated are accessible with the {@link #getRowNum()} and {@link #getColNum()} methods.
     *
     * @param value value to validate
     * @return true if valid
     */
    protected abstract boolean condition(Object value);

    /**
     * FormItem on which this validator was declared. May be null if the item is a ListGridField or DataSourceField, in which case 
     * {@link #getListGridField()} or {@link #getDataSourceField()} should be called.
     *
     * NOTE: FormItem will not be available during a save performed without a form (eg programmatic save) or if the field.
     *
     * @return FormItem on which this validator was declared.
     */
    public FormItem getFormItem() {
        return formItem;
    }

    /**
     * ListGridField on which this validator was declared. May be null if the item is a FormItem or DataSourceField, in which case 
     * {@link #getFormItem()} or {@link #getDataSourceField()} should be called.
     *
     * @return ListGridField on which this validator was declared.
     */
    public ListGridField getListGridField() {
        return listGridField;
    }

    /**
     * DataSourceField on which this validator was declared. May be null if the item is a FormItem or ListGridField, in which case 
     * {@link #getFormItem()} or {@link #getListGridField()} should be called.
     *
     * @return DataSourceField on which this validator was declared.
     */
    public DataSourceField getDataSourceField() {
        return dataSourceField;
    }

    /**
     * ListGrid currently being validated.  May be null if the component being validated is a DynamicForm, in which case 
     * {@link #getDynamicForm()} should be called.
     *
     * @return ListGrid currently being validated
     */
    public ListGrid getListGrid() {
        return listGrid;
    }

    /**
     * DynamicForm currently being validated.  May be null if the component being validated is a ListGrid, in which case 
     * {@link #getListGrid()} should be called.
     *
     * @return DynamicForm currently being validated
     */
    public DynamicForm getDynamicForm() {
        return dynamicForm;
    }

    /**
     * The row number of the cell currently being validated, if the component being validated is a ListGrid.  If the component being 
     * validated is a DynamicForm, this will be null
     *
     * @return the row number of the cell currently being validated, or null if the component is not a ListGrid
     */
    public Integer getRowNum() {
        return rowNum;
    }

    /**
     * The column number of the cell currently being validated, if the component being validated is a ListGrid.  If the component being 
     * validated is a DynamicForm, this will be null
     *
     * @return the column number of the cell currently being validated, or null if the component is not a ListGrid
     */
    public Integer getColNum() {
        return colNum;
    }

    /**
     * Return the properties of validator that is defined on the DataSourceField.
     *
     * @return the validator properties
     */
    public Map getValidatorProperties() {
        return validatorProperties;
    }

    /**
     * To transform the incoming value that is validated into a different value or format set this property from Validator.condition() to the desired value.
     *
     * @param resultingValue the resulting value
     */
    protected void setResultingValue(Object resultingValue) {
        this.resultingValue = resultingValue;
    }


    /**
     * @return field values for record being validated
     */
    public Record getRecord() {
        return record;
    }

    private void reset() {
        formItem = null;
        dataSourceField = null;
        record = null;
        validatorProperties.clear();
        resultingValue = null;
    }

    private native void setup(JavaScriptObject jsObj) /*-{
        var self = this;
        jsObj.condition = function(item, validator, value, record, additionalContext) {
            if($wnd.isc.isA.FormItem(item)) {
               self.@com.smartgwt.client.widgets.form.validator.CustomValidator::formItem = @com.smartgwt.client.widgets.form.fields.FormItemFactory::getFormItem(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            } else {
                if (item.__ref && @com.smartgwt.client.widgets.grid.ListGridField::isListGridField(Lcom/google/gwt/core/client/JavaScriptObject;)(item)) {
                    self.@com.smartgwt.client.widgets.form.validator.CustomValidator::listGridField = @com.smartgwt.client.widgets.grid.ListGridField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
                } else if (item.__ref && @com.smartgwt.client.data.DataSourceField::isDataSourceField(Lcom/google/gwt/core/client/JavaScriptObject;)(item)) {
                    self.@com.smartgwt.client.widgets.form.validator.CustomValidator::dataSourceField = @com.smartgwt.client.data.DataSourceField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
                } else {
                    var dataSourceField = $wnd.isc.addProperties({}, item);
                    if (dataSourceField.__ref) {
                        delete dataSourceField.__ref;
                        delete dataSourceField.__module;
                    }
                    self.@com.smartgwt.client.widgets.form.validator.CustomValidator::dataSourceField = @com.smartgwt.client.data.DataSourceField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dataSourceField);
                }
            }
            if(validator) {
                self.@com.smartgwt.client.widgets.form.validator.CustomValidator::validatorProperties = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(validator);
            }
            if(record != null) {
                self.@com.smartgwt.client.widgets.form.validator.CustomValidator::record = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            }
            if(additionalContext != null) {
                if ($wnd.isc.isA.ListGrid(additionalContext.component)) {
                    self.@com.smartgwt.client.widgets.form.validator.CustomValidator::listGrid = @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(additionalContext.component);
                    if (additionalContext.rowNum != null) {
                        self.@com.smartgwt.client.widgets.form.validator.CustomValidator::rowNum =  @java.lang.Integer::new(I)(additionalContext.rowNum);
                    }
                    if (additionalContext.colNum != null) {
                        self.@com.smartgwt.client.widgets.form.validator.CustomValidator::colNum =  @java.lang.Integer::new(I)(additionalContext.colNum);
                    }
                } else if ($wnd.isc.isA.DynamicForm(additionalContext.component)) {
                    self.@com.smartgwt.client.widgets.form.validator.CustomValidator::dynamicForm = @com.smartgwt.client.widgets.form.DynamicForm::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(additionalContext.component);
                }
            }
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            var ret =  self.@com.smartgwt.client.widgets.form.validator.CustomValidator::condition(Ljava/lang/Object;)(valueJ);

            var jsValidatorDefinition = self.@com.smartgwt.client.widgets.form.validator.CustomValidator::getJsObj()();
            var resultingValue = self.@com.smartgwt.client.widgets.form.validator.CustomValidator::resultingValue;
            if(resultingValue != null && validator) {
                validator.resultingValue =  $wnd.SmartGWT.convertToPrimitiveType(resultingValue);
            }

            if (validator && validator != jsValidatorDefinition && jsValidatorDefinition.errorMessage != null) {
                validator.errorMessage = jsValidatorDefinition.errorMessage;
                jsValidatorDefinition.errorMessage = null;
            }
            
            self.@com.smartgwt.client.widgets.form.validator.CustomValidator::reset()();
            return ret;
        };
    }-*/;
}
