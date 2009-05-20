package com.smartgwt.client.widgets.grid;

import java.util.LinkedHashMap;
import java.util.Map;

public interface EditorValueMapFunction {

    String[] getEditorValueMap(Map values, ListGridField field, ListGrid grid);

}
