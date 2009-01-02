package com.smartgwt.client.widgets.grid;

public interface CellFormatter {

    String format(Object value, ListGridRecord record, int rowNum, int colNum);
}
