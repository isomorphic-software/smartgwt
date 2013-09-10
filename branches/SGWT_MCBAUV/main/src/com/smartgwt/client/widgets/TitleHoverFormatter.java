package com.smartgwt.client.widgets;

public interface TitleHoverFormatter {

    /**
     * Returns the HTML that is displayed by default if a registered
     * {@link com.smartgwt.client.widgets.events.TitleHoverHandler} does not cancel a
     * {@link com.smartgwt.client.widgets.events.TitleHoverEvent}. Return null or an empty string
     * to cancel the hover.
     *
     * @param defaultHTML the HTML that would have been displayed by default.
     * @return HTML to be displayed in the hover. If null or an empty string, then the hover is canceled.
     */
    public String getHoverHTML(String defaultHTML);
}
