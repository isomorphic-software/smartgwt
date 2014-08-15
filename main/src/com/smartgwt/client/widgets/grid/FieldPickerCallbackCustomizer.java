package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.data.Hilite;

/**
 * Customizer called when the settings in a FieldPicker are accepted.
 * 
 */
public abstract class FieldPickerCallbackCustomizer {
	
	/**
	 * @param fields the array of Fields from the FieldPicker
	 * @param hilites the array of Hilites from the FieldPicker
	 */
    public abstract void callback(ListGridField[] fields, Hilite[] hilites);
}
