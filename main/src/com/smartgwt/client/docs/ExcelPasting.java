
package com.smartgwt.client.docs;

/**
 * <h3>Copy and Paste with Excel</h3>
 * {@link com.smartgwt.client.data.DataSource#recordsAsText DataSource.recordsAsText} can export a
 * set of DataSource records in tab-separated-values format so that it can be copied and pasted
 * into a Microsoft Excel spreadsheet.   <P> However, be aware that Excel does a bunch of type
 * guessing on pasted data: <ul> <li> values that look like dates (eg 1-2-2011 and even just 1-2)
 * will become true date-valued      cells (as indicated by Excel rendering them as eg 2-Jan). 
 * Note that the month-day-year      interpretation is <b>locale-dependent</b> so be sure text is
 * exported  <li> values that look numeric, eg "5.0" become true number values (as indicated by
 * Excel      showing just "5") <li> values that look like times, eg "5:30", will be converted to
 * times (as indicated by      Excel showing 5:30:00 AM when editing the value) <li> values with a
 * leading "=" will be treated as formulas </ul> Unfortunately, when these behaviors are
 * undesirable, there is no means of turning them off that doesn't have any drawbacks.  You can:
 * <ul> <li> adding a leading space or other char (but this changes the cell value). <li> turning
 * the cell into a trivial formula, eg ="literal value".  But this means that when     the cell is
 * edited, it's value is a formula. <li> format the cells as text in Excel before pasting data
 * onto them </ul> The first or second approach can be enabled when exporting text - see {@link
 * com.smartgwt.client.data.DataSource#recordsAsText DataSource.recordsAsText} and {@link
 * com.smartgwt.client.data.DataSourceField#getForceText forceText}.
 */
public interface ExcelPasting {
}
