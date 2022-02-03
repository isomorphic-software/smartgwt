package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.widgets.grid.*;

/**
 * This customizer is called to generate the HTML for the sortNumeral displayed next to a field's
 * title when it is included in the current sort specification.
 * 
 */
public abstract class SortNumeralHTMLCustomizer {
	
	/**
	 * 
	 * @param fieldName the name of the field to retrieve the sortNumeralHTML for
	 * @param sortIndex the integer index of this field in the sort specification
	 * @return the HTML string representing the sortNumeral for the passed fieldName
	 */
    public abstract String getSortNumeralHTML(String fieldName, int sortIndex);
}
