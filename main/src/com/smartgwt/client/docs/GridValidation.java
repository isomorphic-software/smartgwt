
package com.smartgwt.client.docs;

/**
 * ListGrids support automatic validation of edited cells / records. This group is a collection  of APIs related to the
 * validation subsystem. <p> Default validation occurs in response to the user navigating between edit cells  (see {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getValidateByCell validateByCell}) or whenever edited values are to be
 * committed to the server for saving.  Standard validation can also be triggered for a cell or row programmatically at any
 * time.<br> When standard validation occurs, {@link com.smartgwt.client.widgets.grid.ListGridField#getValidators
 * validators} will be run on each cell to be validated.<br> In addition to this standard behavior developers can add
 * custom errors to fields via {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldError ListGrid.setFieldError} /
 * {@link com.smartgwt.client.widgets.grid.ListGrid#setFieldError ListGrid.setFieldError}.
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
