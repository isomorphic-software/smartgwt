package com.smartgwt.client.widgets.calendar;

import java.util.Date;

/**
 * Called to determine the CSS class name for a given event in a given view
 */
public abstract class EventCanvasGripperIconCustomizer {
    /**
     * getGripperIcon() should be implemented and return the SCImgURL for the icon to use as
     * the gripper for the passed EventCanvas
     * To access the Calendar itself, use canvas.getCalendar().
     * @param eventCanvas the eventCanvas being rendered
     * @return SCImgURL for the icon to use as a gripper for the passed canvas
     */
    public abstract String getGripperIcon(EventCanvas canvas);
}
