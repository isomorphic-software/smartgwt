package com.smartgwt.client.widgets.form.validator;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.form.fields.FormItem;

public abstract class CustomValidator extends Validator {

    public CustomValidator() {
        setAttribute("type", "custom");
        setup(getJsObj());

    }

    protected FormItem formItem;
    protected DataSourceField dataSourceField;
    protected Record record;

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
     * @return field values for record being validated
     */
    public Record getRecord() {
        return record;
    }

    private void reset() {
        formItem = null;
        dataSourceField = null;
        record = null;
    }

    private native void setup(JavaScriptObject jsObj) /*-{
        var self = this;
        jsObj.condition = function(item, validator, value, record) {
            if($wnd.isc.isA.FormItem(item)) {
               self.@com.smartgwt.client.widgets.form.validator.CustomValidator::formItem = @com.smartgwt.client.widgets.form.fields.FormItemFactory::getFormItem(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
            } else {
                if (item.__ref && @com.smartgwt.client.data.DataSourceField::isDataSourceField(Lcom/google/gwt/core/client/JavaScriptObject;)(item)) {
                    return @com.smartgwt.client.data.DataSourceField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(item);
                } else {
                    var dataSourceField = isc.addProperties({}, item);
                    if (dataSourceField.__ref) delete dataSourceField.__ref;
                    self.@com.smartgwt.client.widgets.form.validator.CustomValidator::dataSourceField = @com.smartgwt.client.data.DataSourceField::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dataSourceField);
                }
                self.@com.smartgwt.client.widgets.form.validator.CustomValidator::dataSourceField = @com.smartgwt.client.data.DataSourceField::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dataSourceField);
            }
            if(record != null) {
                self.@com.smartgwt.client.widgets.form.validator.CustomValidator::record = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
            }
            var valueJ = $wnd.SmartGWT.convertToJavaType(value);
            var ret =  self.@com.smartgwt.client.widgets.form.validator.CustomValidator::condition(Ljava/lang/Object;)(valueJ);
            self.@com.smartgwt.client.widgets.form.validator.CustomValidator::reset()();
            return ret;
        };
    }-*/;
}
