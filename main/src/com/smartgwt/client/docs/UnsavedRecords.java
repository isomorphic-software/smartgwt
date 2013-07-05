
package com.smartgwt.client.docs;

/**
 * <h3>Handling Unsaved Records</h3>
 * APIs such as {@link com.smartgwt.client.widgets.grid.ListGrid#startEditingNew
 * startEditingNew()} or  {@link com.smartgwt.client.widgets.grid.ListGrid#getListEndEditAction
 * listEndEditAction:"next"} allow editing records that have not been saved to the server.  These
 * unsaved records are special in several ways: <ul>  <li> there is no actual Record object in the
 * dataset for them: <code>getRecord(rowNum)</code> will return null, instead,
 * <code>getEditValues(rowNum)</code> allows access to field values for the unsaved record  <li>
 * rows for editing these records always appear at the end of the grid and do not sort with other
 * rows <li> because unsaved records lack an actual Record object and lack a {@link
 * com.smartgwt.client.data.DataSourceField#getPrimaryKey primaryKey} value, they have limited
 * functionality: they cannot be selected, and do not support {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getShowRecordComponents showRecordComponents} and
 * certain other features. </ul> <P> If you need to work with unsaved records and have all
 * ListGrid features apply to them, this is usually a sign that you should re-think your UI for
 * adding new records.  Consider the following approaches - which works best will depend on the
 * application: <ul> <li> actually save a new record to persistent storage, then start editing it.
 * This has the advantage that the user will never lose data by exiting the application with
 * unsaved records, which can be important if there is a lot of data entry before the record is
 * ready to save (for example, a new issue report in an issue-tracking applications, or a new blog
 * entry). This is also a good approach if the user may want to get a unique ID for the new record
 * right away (again useful for a new issue report or blog entry). <P> If values for several
 * fields are required before the record should be visible on other screens or to other users, you
 * can add a field to the record to flag it as incomplete so that it is not shown on other
 * screens.  Alternatively, require certain fields to be entered via an external form or dialog
 * before the record is added to the grid.   <P> Saving a new record and editing it can be done
 * via {@link com.smartgwt.client.data.DataSource#addData DataSource.addData} followed by a call
 * to {@link com.smartgwt.client.widgets.grid.ListGrid#startEditing ListGrid.startEditing} once
 * the record has been saved. <li> edit new records via a separate {@link
 * com.smartgwt.client.docs.Form DynamicForm} instead, possibly in a modal {@link
 * com.smartgwt.client.widgets.Window} - then unsaved records never need to be shown in the grid. 
 * Similar to the approach above, this modal form might have only certain minimum fields to make a
 * valid new record, then further editing could continue in the grid. <li> use a {@link
 * com.smartgwt.client.data.DataSource#getClientOnly clientOnly DataSource} so that records can be
 * saved immediately without contacting the server.  This is a good approach if several unsaved
 * records need to be manipulated by multiple components before they are finally saved. <li> use
 * {@link com.smartgwt.client.data.DataSource#updateCaches DataSource.updateCaches} with an "add"
 * DSResponse to cause a new record to be added to the grid due to {@link
 * com.smartgwt.client.data.ResultSet automatic cache synchronization}.  At this point the grid
 * will believe the record exists on the server and it will be treated like any other saved
 * record.  This means your server code will need to handle the fact that the ListGrid will submit
 * "update" DSRequests for any subsequent edits. </ul> <b>NOTE about validation:</b> by design,
 * Smart GWT assumes that any record that has been saved is valid and does not validate field
 * values that appear in records loaded from the server.  This includes records added to a
 * clientOnly DataSource via {@link com.smartgwt.client.data.DataSource#setCacheData
 * DataSource.setCacheData} as well as records added due to a call to {@link
 * com.smartgwt.client.data.DataSource#updateCaches DataSource.updateCaches}.   <P> Usually the
 * best approach is to avoid this situation by editing such records in a form or other control
 * until they are valid rather than showing invalid records in a grid.  However, if such records
 * need to be considered invalid, one approach is to take field values and add them as editValues
 * via {@link com.smartgwt.client.widgets.grid.ListGrid#setEditValues ListGrid.setEditValues}.  At
 * this point the ListGrid will consider the values as user edits and will validate them.
 */
public interface UnsavedRecords {
}
