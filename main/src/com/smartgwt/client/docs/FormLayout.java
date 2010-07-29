
package com.smartgwt.client.docs;

/**
 * <h3>Form Layout</h3>
 * <b>FormItem Placement in Columns and Rows</b> <P> With the default tabular layout mechanism, items are laid out in rows
 * from left to right until the number of columns, specified by {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getNumCols form.numCols}, is filled, then a new row is begun.  Flags on
 * FormItems, including {@link com.smartgwt.client.widgets.form.fields.FormItem#getStartRow startRow}, {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getEndRow endRow}, {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getColSpan colSpan} and {@link
 * com.smartgwt.client.widgets.form.fields.FormItem#getRowSpan rowSpan}, control row and column placement and spanning.  
 * <P> Note that the most common form items (TextItem, SelectItem, etc) take up <b>two</b> columns by default: one for the
 * form control itself, and one for it's title.  The default setting of {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getNumCols form.numCols:2} will result in one TextItem or SelectItem per
 * row. <P> Note also that ButtonItems have both startRow:true and endRow:true by default.  You must set startRow and/or
 * endRow to <code>false</code> on a ButtonItem in order to place a button in the same row as any other item. <P> The log
 * category "tablePlacement" can be enabled from the Developer Console to watch items being placed.  You can also set
 * {@link com.smartgwt.client.widgets.form.DynamicForm#getCellBorder form.cellBorder:1} to reveal the table structure for
 * layout troubleshooting purposes. <P> <b>Row and Column Sizing</b> <P> {@link
 * com.smartgwt.client.widgets.form.DynamicForm#getColWidths colWidths} controls the widths of form columns.  FormItems
 * that have "*" for {@link com.smartgwt.client.widgets.form.fields.FormItem#getWidth width} will fill the column. 
 * FormItems with a numeric width will have that width in pixels regardless of the column's specified width, which may
 * cause the column to overflow as described under {@link com.smartgwt.client.widgets.form.DynamicForm#getFixedColWidths
 * fixedColWidths}. <P> For row heights, the largest pixel height specified on any item in the row is taken as a minimum
 * size for the row.  Then, any rows that have "*" or "%" height items will share any height not taken up by fixed-sized
 * items. <P> <b>Managing Overflow</b> <P> Forms often contain labels, data values, or instructional text which can vary in
 * size based on the skin, data values, or internationalization settings.  There are a few ways to deal with a form
 * potentially varying in size: <ol> <li> Allow scrolling when necessary, using {@link
 * com.smartgwt.client.widgets.Canvas#getOverflow overflow:auto}, either on the immediate form, or on some parent. <li>
 * Place the form in a Layout along with a component that can render any specified size, such as a {@link
 * com.smartgwt.client.widgets.grid.ListGrid}.  In this case, the Layout will automatically shrink the grid in order to
 * accommodate the form. <li> Ensure that the form can always render at a designed minimum size by reducing the number of
 * cases of variable-sized text, and testing remaining cases across all supported skins.  For example, move help text into
 * hovers on help icons, or clip  long text values at a maximum length and provide a hover to see the rest. </ol> Several
 * examples of Form Layout are available @see <a href="http://www.smartclient.com/smartgwtee/showcase/#formsLayout"
 * target="examples">here</a>.
 * @see com.smartgwt.client.widgets.form.DynamicForm#getItemLayout
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getWidth
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getHeight
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getColSpan
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getRowSpan
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getStartRow
 * @see com.smartgwt.client.widgets.form.fields.FormItem#getEndRow
 * @see com.smartgwt.client.widgets.form.fields.ButtonItem#getStartRow
 * @see com.smartgwt.client.widgets.form.fields.ButtonItem#getEndRow
 */
public interface FormLayout {
}
