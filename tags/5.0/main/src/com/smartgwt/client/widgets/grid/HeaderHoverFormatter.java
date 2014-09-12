package com.smartgwt.client.widgets.grid;

/**
 * Formatter object for providing a custom implementation of {@link com.smartgwt.client.widgets.grid.ListGrid#headerHoverHTML(int,java.lang.String)}.
 */
public interface HeaderHoverFormatter {

    /**
     * Returns the HTML that is displayed by default if a registered
     * {@link com.smartgwt.client.widgets.grid.events.HeaderHoverHandler} does not cancel a
     * {@link com.smartgwt.client.widgets.grid.events.HeaderHoverEvent}. Return null or an empty string
     * to cancel the hover.
     *
     * @param fieldNum field number for the header that was hovered
     * @param defaultHTML the HTML that would have been displayed by default.
     * @return HTML to be displayed in the hover. If null or an empty string, then the hover is canceled.
     */
    public String getHoverHTML(int fieldNum, String defaultHTML);
}
