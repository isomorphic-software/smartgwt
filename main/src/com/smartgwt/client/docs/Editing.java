
package com.smartgwt.client.docs;

/**
 * <h3>Grid Editing</h3>
 * Data being displayed by a grid may be edited within the grid, by showing editing interfaces embedded inside the cells of
 * the grid. <P> <b>Enabling editing</b> <P> Editing is enabled when {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit canEdit} is <code>true</code>.  When enabled, the user can begin
 * editing via the  {@link com.smartgwt.client.widgets.grid.ListGrid#getEditEvent editEvent}, typically click or
 * double-click.  Editing can also be triggered programmatically by a call to {@link
 * com.smartgwt.client.widgets.grid.ListGrid#startEditing startEditing()} or {@link
 * com.smartgwt.client.widgets.grid.ListGrid#startEditingNew startEditingNew()}. <P> <b>New record creation</b> <P> By
 * default, editing is restricted to existing records.  Setting {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getListEndEditAction listEndEditAction} to "next" allows the user to create
 * new records by simply navigating off the end of the dataset with the keyboard.  Editing of new records can also be
 * initiated with  {@link com.smartgwt.client.widgets.grid.ListGrid#startEditingNew ListGrid.startEditingNew}, for example,
 * from a button outside the grid. <P> <b>Saving changes</b> <P> Saving of changes is triggered automatically when the user
 * navigates out of the row or cell being edited (based on {@link com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell
 * saveByCell}) or when the user ends editing.   For a "mass update" interface, automatic saving of changes can be disabled
 * entirely via  {@link com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits autoSaveEdits:false}, in which case a
 * manual call to  {@link com.smartgwt.client.widgets.grid.ListGrid#saveEdits saveEdits()} or {@link
 * com.smartgwt.client.widgets.grid.ListGrid#saveAllEdits saveAllEdits()} is required to trigger saving.  <P> If a grid has
 * no DataSource, saving means that the properties of the {@link com.smartgwt.client.widgets.grid.ListGridRecord}s in
 * {@link com.smartgwt.client.widgets.grid.ListGrid#getData grid.data} are directly changed. <P> For a grid with a
 * DataSource, saving will be accomplished by using DataSource "update" operations for existing records, and DataSource
 * "add" operations for new records.  If multiple records have been edited and {@link
 * com.smartgwt.client.widgets.grid.ListGrid#saveAllEdits saveAllEdits()} is called,  {@link
 * com.smartgwt.client.rpc.RPCManager#startQueue request queuing} will be automatically used to enable all edits to be
 * saved in one HTTP turnaround (if using the Smart GWT Server). <P> By default, a grid will send only updated fields and
 * the primaryKey field as part of  {@link com.smartgwt.client.data.DSRequest#getData data} so that the server can discern
 * which fields the user actually changed. However, the grid always includes the original field values in the dsRequest as
 * {@link com.smartgwt.client.data.DSRequest#getOldValues oldValues}. <P> Note that although it is possible to load
 * DataSource data without actually declaring a {@link com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey
 * field}, a primaryKey must be declared for editing and saving.  The primaryKey value is how Smart GWT identifies the
 * changed record to the server. <P> <b>Validation</b> <P> Any time saving is attempted, validation is automatically
 * triggered.  Values entered by the user will be checked against the {@link
 * com.smartgwt.client.widgets.grid.ListGridField#getValidators validators} and the {@link
 * com.smartgwt.client.data.DataSourceField#getValidators validators}. Any invalid values abort an attempted save. <P>
 * Similar to editing and saving, validation can be done on row transitions or on cell transitions by setting {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getValidateByCell validateByCell}, or can be disabled entirely via {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getNeverValidate neverValidate:true}. <P> <b>Editability of cells</b> <P>
 * Editors will either be shown for the complete row or for a single cell based on  {@link
 * com.smartgwt.client.widgets.grid.ListGrid editByCell,editByCell}.  Whether a cell can be edited can be controlled on a
 * per field basis by setting {@link com.smartgwt.client.widgets.grid.ListGridField#getCanEdit field.canEdit}, or on a
 * per-record basis by setting {@link com.smartgwt.client.widgets.grid.ListGrid#getRecordEditProperty recordEditProperty}
 * on a  {@link com.smartgwt.client.widgets.grid.ListGridRecord record}, or can be controlled on an arbitrary, programmatic
 * basis via an override of {@link com.smartgwt.client.widgets.grid.ListGrid#canEditCell ListGrid.canEditCell}. <P> Cells
 * which are not editable just display the cell's current value. <P> <b>Keyboard Navigation</b> <P> Full keyboard
 * navigation is supported by default, including Tab and Shift-Tab to navigate between cells in a row, and Up Arrow and
 * Down Arrow to traverse rows.  Several properties on both grids and fields, all named *EditAction, control navigation
 * behavior of certain keys (eg Enter). <P> You can use {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing
 * startEditing(<i>rowNum</i>, <i>colNum</i>)} to  programmatically move editing to a particular cell, for example, during
 * a  {@link com.smartgwt.client.widgets.grid.ListGridField#addChangedHandler field.changed()} event. <P> <b>editValues
 * (unsaved changes)</b> <P> The term "editValues" means changes that the user has made to the dataset which have not been
 * saved.  The grid manages and stores editValues separately from the data itself in order to allow the user to revert to
 * original values, and in order to enable to grid to send only updated fields to the server.   <P> Because editValues are
 * stored separately, if you directly access the dataset (eg via  <code>grid.data.get()</code>) you will see the records
 * without the user's unsaved changes. Many APIs exist for retrieving and managing editValues (search for editValue). For
 * the common case of needing to access the record-as-edited, you can call  {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getEditedRecord grid.getEditedRecord(rowNum)}. <P> When accessing and
 * manipulating edited data, you should think carefully about whether you want to be working with the original data or with
 * the edited version.  Values entered by the user may not have been validated yet, or may have failed validation, hence
 * you may find a String value in a field of type "date" or "int", which could cause naive formatters or totaling functions
 * to crash. <P> Setting editValues is fully equivalent to the user making changes to data via the editing UI. If you
 * <i>also</i> allow editing external to the grid, setting editValues is one way to  combine changes from external editors
 * into the grid's edits, so that you can do a single  save. <P> <b>Customizing Cell Editors</b> <P> When a cell is being
 * edited, the editor displayed in the cell will be a {@link com.smartgwt.client.widgets.form.fields.FormItem}. The editor
 * type for the cell will be determined by {@link com.smartgwt.client.widgets.grid.ListGrid#getEditorType
 * ListGrid.getEditorType} based on the specified {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorType
 * editorType} or {@link com.smartgwt.client.widgets.grid.ListGridField#getType data type} for the field in question. <P>
 * You can customize the editor by setting {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorProperties
 * editorProperties} to a set of properties that is valid for that FormItem type.  Custom FormItem classes are also
 * allowed, for example, you may use {@link com.smartgwt.client.widgets.form.fields.FormItem#getIcons icons} to create an
 * icon that launches a separate {@link com.smartgwt.client.widgets.Dialog} in order to provide an arbitrary interface that
 * allows the user to select the value for a field. <P> <b>Events</b> <P> Editing triggers several events which you can
 * provide handlers for in order to customize editing behavior.  Some of the most popular are {@link
 * com.smartgwt.client.widgets.grid.ListGridField#addChangeHandler field.change()}, {@link
 * com.smartgwt.client.widgets.grid.ListGridField#addChangedHandler field.changed()} for detecting changes made by the
 * user, {@link com.smartgwt.client.widgets.grid.ListGrid#addCellChangedHandler ListGrid.cellChanged} for detecting changes
 * that have been successfully saved, and {@link com.smartgwt.client.widgets.grid.ListGrid#addEditorEnterHandler
 * ListGrid.editorEnter} and {@link com.smartgwt.client.widgets.grid.ListGrid#addEditorExitHandler editorExit()} for
 * detecting user navigation during editing. <P> You can also install event handlers directly on the FormItem-based editors
 * used in the grid via {@link com.smartgwt.client.widgets.grid.ListGridField#getEditorProperties editorProperties} as
 * mentioned above.  When handling events on items, or which involve items, be aware that in addition to standard  {@link
 * com.smartgwt.client.widgets.form.fields.FormItem} APIs, editors have the following properties: <P> -
 * <code>rowNum</code>: The rowNum of the record being edited.<br> - <code>colNum</code>: The colNum of the cell being
 * edited.<br> - <code>grid</code>: A pointer back to the listGrid containing the record.
 * @see #setEditValue
 * @see #getEditValue
 * @see #getEditedRecord
 * @see #getEditedCell
 * @see #getEditValues
 * @see #clearEditValue
 * @see #saveEdits
 * @see #getAllEditCells
 * @see #discardAllEdits
 * @see #recordHasChanges
 * @see #hasChanges
 * @see #saveAllEdits
 * @see com.smartgwt.client.widgets.form.DynamicForm#getEditorType
 * @see com.smartgwt.client.widgets.grid.ListGridField#defaultDynamicValue
 * @see com.smartgwt.client.widgets.grid.ListGridField#editorEnter
 * @see com.smartgwt.client.widgets.grid.ListGridField#editorExit
 * @see com.smartgwt.client.widgets.grid.ListGridField#cellChanged
 * @see com.smartgwt.client.widgets.grid.ListGridField#formatEditorValue
 * @see com.smartgwt.client.widgets.grid.ListGridField#parseEditorValue
 * @see com.smartgwt.client.widgets.grid.ListGridField#change
 * @see com.smartgwt.client.widgets.grid.ListGridField#changed
 * @see com.smartgwt.client.widgets.grid.ListGrid#canEditCell
 * @see com.smartgwt.client.widgets.grid.ListGrid#startEditing
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEditorValueMap
 * @see com.smartgwt.client.widgets.grid.ListGrid#setEditorValueMap
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEditorType
 * @see com.smartgwt.client.widgets.grid.ListGrid#startEditingNew
 * @see com.smartgwt.client.widgets.grid.ListGrid#getAllEditRows
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEditValues
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEditedRecord
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEditedCell
 * @see com.smartgwt.client.widgets.grid.ListGrid#setEditValue
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEditValue
 * @see com.smartgwt.client.widgets.grid.ListGrid#clearEditValue
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEditRow
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEditCol
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEditField
 * @see com.smartgwt.client.widgets.grid.ListGrid#cancelEditing
 * @see com.smartgwt.client.widgets.grid.ListGrid#endEditing
 * @see com.smartgwt.client.widgets.grid.ListGrid#discardAllEdits
 * @see com.smartgwt.client.widgets.grid.ListGrid#discardEdits
 * @see com.smartgwt.client.widgets.grid.ListGrid#saveEdits
 * @see com.smartgwt.client.widgets.grid.ListGrid#rowHasChanges
 * @see com.smartgwt.client.widgets.grid.ListGrid#hasChanges
 * @see com.smartgwt.client.widgets.grid.ListGrid#cellHasChanges
 * @see com.smartgwt.client.widgets.grid.ListGrid#saveAllEdits
 * @see com.smartgwt.client.widgets.grid.ListGrid#cellChanged
 * @see com.smartgwt.client.widgets.grid.ListGrid#editComplete
 * @see com.smartgwt.client.widgets.grid.ListGrid#editFailed
 * @see com.smartgwt.client.widgets.grid.ListGrid#editorEnter
 * @see com.smartgwt.client.widgets.grid.ListGrid#rowEditorEnter
 * @see com.smartgwt.client.widgets.grid.ListGrid#editorExit
 * @see com.smartgwt.client.widgets.grid.ListGrid#rowEditorExit
 * @see com.smartgwt.client.widgets.grid.ListGrid#formatEditorValue
 * @see com.smartgwt.client.widgets.grid.ListGrid#parseEditorValue
 * @see com.smartgwt.client.widgets.calendar.Calendar#getEventSnapGap
 * @see com.smartgwt.client.widgets.calendar.Calendar#getShowQuickEventDialog
 * @see com.smartgwt.client.widgets.calendar.Calendar#getEventEditorFields
 * @see com.smartgwt.client.widgets.calendar.Calendar#getEventDialogFields
 * @see com.smartgwt.client.widgets.grid.ListGridField#getEditorImageURLPrefix
 * @see com.smartgwt.client.widgets.grid.ListGridField#getEditorImageURLSuffix
 * @see com.smartgwt.client.widgets.grid.ListGridField#getIcons
 * @see com.smartgwt.client.widgets.grid.ListGridField#getEditorIconWidth
 * @see com.smartgwt.client.widgets.grid.ListGridField#getEditorIconHeight
 * @see com.smartgwt.client.widgets.grid.ListGridField#getDefaultIconSrc
 * @see com.smartgwt.client.widgets.grid.ListGridField#getIconVAlign
 * @see com.smartgwt.client.widgets.grid.ListGridField#getCanEdit
 * @see com.smartgwt.client.widgets.grid.ListGridField#getDefaultValue
 * @see com.smartgwt.client.widgets.grid.ListGridField#getEnterKeyEditAction
 * @see com.smartgwt.client.widgets.grid.ListGridField#getEscapeKeyEditAction
 * @see com.smartgwt.client.widgets.grid.ListGridField#getEditorType
 * @see com.smartgwt.client.widgets.grid.ListGridField#getEditorProperties
 * @see com.smartgwt.client.widgets.grid.ListGrid#getModalEditing
 * @see com.smartgwt.client.widgets.grid.ListGridField#getEditorValueMap
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCanEdit
 * @see com.smartgwt.client.widgets.grid.ListGrid#getRecordEditProperty
 * @see com.smartgwt.client.widgets.grid.ListGrid#getAlwaysShowEditors
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEditByCell
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSaveByCell
 * @see com.smartgwt.client.widgets.grid.ListGrid#getWaitForSave
 * @see com.smartgwt.client.widgets.grid.ListGrid#getStopOnErrors
 * @see com.smartgwt.client.widgets.grid.ListGrid#getAutoSaveEdits
 * @see com.smartgwt.client.widgets.grid.ListGrid#getConfirmCancelEditing
 * @see com.smartgwt.client.widgets.grid.ListGrid#getCancelEditingConfirmationMessage
 * @see com.smartgwt.client.widgets.grid.ListGrid#getConfirmDiscardEdits
 * @see com.smartgwt.client.widgets.grid.ListGrid#getConfirmDiscardEditsMessage
 * @see com.smartgwt.client.widgets.grid.ListGrid#getDiscardEditsSaveButtonTitle
 * @see com.smartgwt.client.widgets.grid.ListGrid#getRowEndEditAction
 * @see com.smartgwt.client.widgets.grid.ListGrid#getListEndEditAction
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEnterKeyEditAction
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEscapeKeyEditAction
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEditEvent
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEditOnFocus
 * @see com.smartgwt.client.widgets.grid.ListGrid#getSelectOnEdit
 * @see com.smartgwt.client.widgets.grid.ListGridField#getCanToggle
 * @see com.smartgwt.client.widgets.grid.ListGrid#getEnumCriteriaAsInitialValues
 * @see com.smartgwt.client.widgets.grid.ListGrid#getLongTextEditorThreshold
 * @see com.smartgwt.client.widgets.grid.ListGrid#getLongTextEditorType
 * @see com.smartgwt.client.types.RowEndEditAction
 * @see com.smartgwt.client.types.EnterKeyEditAction
 * @see com.smartgwt.client.types.EscapeKeyEditAction
 * @see com.smartgwt.client.types.EditCompletionEvent
 * @see com.smartgwt.client.types.ListGridEditEvent
 */
public interface Editing {
}
