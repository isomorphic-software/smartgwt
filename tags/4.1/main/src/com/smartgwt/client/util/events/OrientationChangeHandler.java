package com.smartgwt.client.util.events;

import com.google.gwt.event.shared.EventHandler;

public interface OrientationChangeHandler extends EventHandler {

    /**
     * Method called when {@link com.smartgwt.client.util.Page#getOrientation()} changes due
     * to browser window resize or rotation of a mobile device.
     *
     * @param event the event
     * @see com.com.smartgwt.client.util.Page#addOrientationChangeHandler(com.smartgwt.client.util.events.OrientationChangeHandler)
     */
    public void onOrientationChange(OrientationChangeEvent event);
}
