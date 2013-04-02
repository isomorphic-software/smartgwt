package com.smartgwt.client.widgets.grid;

public interface HeaderHoverFormatter {

    /**
     * Returns the HTML to display in a hover canvas when the user holds the mouse pointer over
     * a field's header button and the title is clipped. Return null to suppress the hover canvas
     * altogether.
     *
     * @param fieldNum field number for the header that was hovered
     * @return HTML to be displayed in the hover
     */
    public String getHoverHTML(int fieldNum);
}
