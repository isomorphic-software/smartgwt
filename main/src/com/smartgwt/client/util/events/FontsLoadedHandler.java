package com.smartgwt.client.util.events;

import com.google.gwt.event.shared.EventHandler;

public interface FontsLoadedHandler extends EventHandler {

    /**
     * @param event the event
     * @see com.com.smartgwt.client.util.Page#addFontsLoadedHandler
     */
    public void onFontsLoaded(FontsLoadedEvent event);
}
