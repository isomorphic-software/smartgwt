package com.smartgwt.client.widgets;

public interface TitleHoverFormatter {

    /**
     * Returns the HTML to display in the standard hover when the user holds the mouse pointer over
     * the component and the title is clipped. Return null to suppress the hover canvas altogether.
     *
     * @return HTML to be displayed in the hover
     */
    public String getHoverHTML();
}
