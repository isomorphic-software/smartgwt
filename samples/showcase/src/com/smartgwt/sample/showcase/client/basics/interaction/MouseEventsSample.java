package com.smartgwt.sample.showcase.client.basics.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class MouseEventsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>Mouse over the blue square to see the color respond to your position. Click and hold to see a fade. " +
            "If you have a mousewheel, roll up and down to change size.<p><p>Smart GWT components support the standard " +
            "mouse events in addition to custom events like \"mouseStillDown\".</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            MouseEventsSample panel = new MouseEventsSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }

    public Canvas getViewPanel() {

        Canvas canvas = new Canvas();

        final TrackerLabel eventTrackerLabel = new TrackerLabel();
        eventTrackerLabel.setContents("<nobr>Last event: (mouse over the canvas below...)</nobr>");
        eventTrackerLabel.setHeight(20);

        final MouserLabel label = new MouserLabel();
        label.setContents("<b>Mouse Me</b>");
        label.setAlign(Alignment.CENTER);
        label.setOverflow(Overflow.HIDDEN);
        label.setShowEdges(true);
        label.setBackgroundColor("lightblue");
        label.setWidth(200);
        label.setHeight(200);
        label.setTop(40);
        label.addMouseWheelHandler(new MouseWheelHandler() {
            public void onMouseWheel(MouseWheelEvent event) {
                float wheelDelta = EventHandler.getWheelDelta();

                int newSize = (int)(label.getWidth() + wheelDelta * label.getZoomMultiplier());
                if (newSize < label.getMinSize()) {
                    newSize = label.getMinSize();
                } else if (newSize > label.getMaxSize()) {
                    newSize = label.getMaxSize();
                }
                label.setWidth(newSize);
                label.setHeight(newSize);
                eventTrackerLabel.setLastEvent("mouseWheel", label);
            }
        });

        label.addMouseStillDownHandler(new MouseStillDownHandler() {
            public void onMouseStillDown(MouseStillDownEvent event) {
                Integer opacity = label.getOpacity();
                if (opacity == null) opacity = 100;
                label.setOpacity(Math.max(0, opacity - 5));
                eventTrackerLabel.setLastEvent("mouseStillDown", label);
            }
        });

        label.addMouseUpHandler(new MouseUpHandler() {
            public void onMouseUp(MouseUpEvent event) {
                label.setOpacity(100);
                eventTrackerLabel.setLastEvent("mouseUp", label);
            }
        });

        label.addMouseMoveHandler(new MouseMoveHandler() {
            public void onMouseMove(MouseMoveEvent event) {
                //scale to 1
                float xScale = (label.getOffsetX() * 1f) / label.getWidth();
                float yScale = (label.getOffsetY() * 1f) / label.getHeight();

                // increasing red intensity on the x axis, green on the y axis.  Blue stays at zero.
                label.setBackgroundColor("rgb(0," + Math.round(255 * xScale) + "," + Math.round(255 * yScale) + ")");
                eventTrackerLabel.setLastEvent("mouseMove", label);
            }
        });

        label.addMouseOutHandler(new MouseOutHandler() {
            public void onMouseOut(MouseOutEvent event) {
                //restore settings
                label.setBackgroundColor("lightblue");
                label.setOpacity(100);
                eventTrackerLabel.setLastEvent("mouseOut", label);
            }
        });

        canvas.addChild(eventTrackerLabel);
        canvas.addChild(label);
        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    class TrackerLabel extends Label {

        public void setLastEvent(String eventName, MouserLabel label) {
            int localX = label.getOffsetX();
            int localY = label.getOffsetY();
            setContents("<nobr>Last event: <b>" + eventName + "</b> (" + localX + ", " + localY + ")</nobr>");
        }
    }


    class MouserLabel extends Label {
        private int minSize = 40;
        private int maxSize = 400;
        private int zoomMultiplier = 15;

        public int getMinSize() {
            return minSize;
        }

        public void setMinSize(int minSize) {
            this.minSize = minSize;
        }

        public int getMaxSize() {
            return maxSize;
        }

        public void setMaxSize(int maxSize) {
            this.maxSize = maxSize;
        }

        public int getZoomMultiplier() {
            return zoomMultiplier;
        }

        public void setZoomMultiplier(int zoomMultiplier) {
            this.zoomMultiplier = zoomMultiplier;
        }
    }
}
