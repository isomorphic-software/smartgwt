
package com.smartgwt.client.docs;

/**
 * ListGrids support automatic validation of edited cells / records. This group is a collection &#010 of APIs related to the validation subsystem.&#010 <p>&#010 Default validation occurs in response to the user navigating between edit cells &#010 (see {@link com.smartgwt.client.widgets.grid.ListGrid#getValidateByCell validateByCell}) or whenever edited values are to be committed to the&#010 server for saving.  Standard validation can also be triggered for a cell or row programatically at&#010 any time.<br>&#010 When standard validation occurs, {@link com.smartgwt.client.widgets.grid.ListGridField#getValidators validators} will be run on each&#010 cell to be validated.<br>&#010 In addition to this standard behavior developers can add custom errors to fields&#010 via {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldError} / {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldError}.
 * @see com.smartgwt.client.widgets.grid.ListGrid#validateRow
 * @see com.smartgwt.client.widgets.grid.ListGrid#validateCell
 * @see com.smartgwt.client.widgets.grid.ListGrid#getRequiredFieldMessage
 * @see com.smartgwt.client.widgets.grid.ListGrid#hasErrors
 * @see com.smartgwt.client.widgets.grid.ListGrid#rowHasErrors
 * @see com.smartgwt.client.widgets.grid.ListGrid#cellHasErrors
 * @see com.smartgwt.client.widgets.grid.ListGrid#getRowErrors
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCellErrors
 * @see com.smartgwt.client.widgets.grid.ListGrid#setFieldError
 * @see com.smartgwt.client.widgets.grid.ListGrid#setRowErrors
 * @see com.smartgwt.client.widgets.grid.ListGrid#clearFieldError
 * @see com.smartgwt.client.widgets.grid.ListGridField#getValidators
 * @see com.smartgwt.client.widgets.grid.ListGridField#getValidateOnChange
 * @see com.smartgwt.client.widgets.grid.ListGridField#getRequired
 * @see com.smartgwt.client.widgets.grid.ListGrid#getValidateByCell
 * @see com.smartgwt.client.widgets.grid.ListGrid#getValidateOnChange
 * @see com.smartgwt.client.widgets.grid.ListGrid#getNeverValidate
 */
public interface GridValidation {
}
