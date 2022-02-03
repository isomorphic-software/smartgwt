package com.smartgwt.client.util.events;

import com.google.gwt.event.shared.EventHandler;

public interface FontLoadingFailedHandler extends EventHandler {

    /**
     * @param event the event
     * @see com.com.smartgwt.client.util.Page#addFontLoadingFailedHandler
     */
    public void onFontLoadingFailed(FontLoadingFailedEvent event);
}
