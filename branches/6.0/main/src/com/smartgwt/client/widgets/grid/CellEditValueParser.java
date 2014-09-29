package com.smartgwt.client.widgets.grid;

public interface CellEditValueParser {

    Object parse(Object value, ListGridRecord record, int rowNum, int colNum);
}
