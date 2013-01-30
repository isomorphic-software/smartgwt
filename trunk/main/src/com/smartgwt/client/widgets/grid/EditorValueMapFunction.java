package com.smartgwt.client.widgets.grid;

import java.util.LinkedHashMap;
import java.util.Map;

public interface EditorValueMapFunction {

    /**
     * 
     * @param values Field values for record being edited. Note that this will include the current edit values for fields that have not yet been saved. May be null, if editing a new record.
     * @param field the ListGridField
     * @param grid the ListGrid instance
     * @return value map for the field (stored value --> user displayable value)
     */
    Map getEditorValueMap(Map values, ListGridField field, ListGrid grid);

}
