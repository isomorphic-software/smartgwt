package com.smartgwt.client.widgets.form.validator;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.fields.FormItem;

import java.util.HashMap;
import java.util.Map;

public abstract class CustomValidator extends Validator {

    public CustomValidator() {
        setAttribute("type", "custom");
        setup(getJsObj());

    }

    protected FormItem formItem;
    protected DataSourceField dataSourceField;
    protected Record record;
    protected Map validatorProperties = new HashMap();
    protected Object resultingValue;

    /**
     * Add custom validation logic by overriding this method. Access to the FormItem or DataSourceField on which the validator was
     * declared can be obtained by the {@link #getFormItem()} and {@link #getDataSourceField()} methods respectively and the field values for
     * record being validated can be obtained by calling {@link #getRecord()}.
     *
     * @param value value to validate
     * @return true if valid
     */
    protected abstract boolean condition(Object value);

    /**
     * FormItem on which this validator was declared. May be null if the item is a DataSourceField in which case {@link #getDataSourceField()} should be called.
     *
     * NOTE: FormItem will not be available during a save performed without a form (eg programmatic save) or if the field.
     *
     * @return FormItem on which this validator was declared.
     */
    public FormItem getFormItem() {
        return formItem;
    }

    /**
     * DataSourceField on which this validator was declared. May be null if the item is a FormItem in which case {@link #getFormItem()} should be called.
     *
     * @return DataSourceField on which this validator was declared.
     */
    public DataSourceField getDataSourceField() {
        return dataSourceField;
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
        jsObj.condition = function(item, validator, value, record) {
            if($wnd.isc.isA.FormItem(item)) {
               self.@com.smartgwt.client.widgets.form.validator.CustomValidator::formItem = @com.smartgwt.client.widgets.form.fields.FormItemFactory::getFormItem(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            } else {
                if (item.__ref && @com.smartgwt.client.data.DataSourceField::isDataSourceField(Lcom/google/gwt/core/client/JavaScriptObject;)(item)) {
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
