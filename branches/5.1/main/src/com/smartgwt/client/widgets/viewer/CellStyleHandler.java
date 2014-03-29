package com.smartgwt.client.widgets.viewer;

import com.smartgwt.client.data.Record;

public interface CellStyleHandler {

    String execute(Object value, DetailViewerField field, Record record);
}
