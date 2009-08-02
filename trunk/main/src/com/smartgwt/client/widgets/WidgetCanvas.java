package com.smartgwt.client.widgets;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.types.Overflow;

public class WidgetCanvas extends Canvas {
    private Widget widget;

    public WidgetCanvas(Widget widget) {
        this.widget = widget;
        setRedrawOnResize(false);
        setAttribute("_redrawWithParent", false, false);
        setOverflow(Overflow.VISIBLE);
        String width = DOM.getStyleAttribute(widget.getElement(), "width");
        String height = DOM.getStyleAttribute(widget.getElement(), "height");
        if (width != null && !width.equals("")) {
            setWidth(width);
        }
        if (height != null && !height.equals("")) {
            setHeight(height);
        }
    }

    public String getInnerHTML() {
        return "<DIV STYLE='width:100%;height:100%' ID=" + this.getID() + "_widget></DIV>";
    }

    protected void onDraw() {
        //a GWT widget must be attached to a GWT Panel for its events to fire.
        boolean attached = widget.isAttached();
        if (!attached) {
            RootPanel rp = RootPanel.get(this.getID() + "_widget");
            rp.add(widget);
            String width = DOM.getStyleAttribute(widget.getElement(), "width");
            if (width != null && !width.equals("")) {
                setWidth(width);
            }
            String height = DOM.getStyleAttribute(widget.getElement(), "height");
            if (height != null && !height.equals("")) {
                setHeight(height);
            }
        }
    }
}
