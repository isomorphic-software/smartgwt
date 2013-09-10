package com.smartgwt.client.widgets.grid;

public interface CellValueHoverFormatter {

    public String getHoverHTML(ListGridRecord record, int rowNum, int colNum, String defaultHTML);
}
