package com.smartgwt.client.widgets.calendar;

import java.util.Date;
import com.smartgwt.client.widgets.Canvas;

/**
 * Called to create and update the components shown in EventCanvas instances when 
 * Calendar.showEventCanvasComponents is true.
 */
public abstract class EventCanvasComponentCustomizer {
    
    /**
     * createEventCanvasComponent() should be implemented and return the Canvas component to 
     * display in the passed eventCanvas
     * @param eventCanvas the eventCanvas needing a component
     * @return the canvas to show in the passed eventCanvas
     */
    public abstract Canvas createEventCanvasComponent(EventCanvas eventCanvas);
    
    /**
     * updateEventCanvasComponent() should be implemented and should update the component
     * passed in directly
     * @param eventCanvas the eventCanvas needing a component
     * @param component the component to update
     * @return the canvas to show in the passed eventCanvas
     */
    public abstract void updateEventCanvasComponent(EventCanvas eventCanvas, Canvas component);
}
