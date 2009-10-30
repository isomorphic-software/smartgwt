package com.smartgwt.client.widgets.viewer;

import com.smartgwt.client.data.Record;

public interface DetailFormatter {

    String format(Object value, Record record, DetailViewerField field);
}
