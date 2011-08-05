package com.smartgwt.client.widgets.form;


/**
 * Formatter to customize the error message of a FormItem
 */
public interface FormItemErrorFormatter {

    /**
     * Output the HTML for an error message in a form element. Default behavior respects {@link com.smartgwt.client.widgets.form.fields.FormItem#setShowErrorIcon(Boolean) showErrorIcon}
     * and {@link com.smartgwt.client.widgets.form.fields.FormItem#setShowErrorText(Boolean) showErrorText} as described in the documentation for those
     * properties.
     *
     * @param errors the error messages
     * @return the HTML to display the error
     */
    String getErrorHTML(String[] errors);
}
