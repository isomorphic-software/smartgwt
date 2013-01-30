package com.smartgwt.client.widgets.grid;

public interface CellEditValueFormatter {

    Object format(Object value, ListGridRecord record, int rowNum, int colNum);
}
