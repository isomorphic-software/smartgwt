package com.smartgwt.client.widgets;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.smartgwt.client.types.Overflow;

public class WidgetCanvas extends Canvas {
    private Widget widget;

    public WidgetCanvas(Widget widget) {
        this.widget = widget;

        // The double-div setup causes the container div with size set to 100% x 100%
        // to not expand to fill all available space vertically with the HTML5 doctype enabled.
        JSOHelper.setAttribute(getConfig(), "useClipDiv", false);

        setRedrawOnResize(false);
        setAttribute("_redrawWithParent", false, false);
        setAttribute("_clearWithRemoveChild", true, false);
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
        //if this canvas is being redrawn, detach underlying gwt widget so that onDraw()
        //can correctly reassociate it with container div
        if(widget.isAttached()) widget.removeFromParent();

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
