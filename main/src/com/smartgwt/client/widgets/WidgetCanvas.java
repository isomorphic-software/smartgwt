package com.smartgwt.client.widgets;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.dom.client.Element;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.widgets.events.ClearEvent;
import com.smartgwt.client.widgets.events.ClearHandler;

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
        
    	
		addClearHandler(new ClearHandler() {
			
			@Override
			public void onClear(ClearEvent event) {
				removeWidget();			
			}
		});
    }
    
    private void removeWidget() {

        if (widget.isAttached()) {
            // Sanity check: GWT.isAttached can return true even if the widget has been
            // removed from the DOM. We've seen this come in some cases where the WidgetCanvas
            // has been cleared.
            // If we go ahead and call removeFromParent() in this case, IE will throw an
            // error.
            // Therefore check for the case where the widget was embedded in our inner 
            // element, but we've been cleared and skip the removeFromParent call in this case.
            Widget widgetParent = widget.getParent();
            Element widgetParentElement = widgetParent == null ? null : widgetParent.getElement();
            String parentID = widgetParentElement == null ? null : widgetParentElement.getId();
            String innerElementID = this.getID() + "_widget";
            if (parentID != null && parentID.equals(innerElementID)) {
                if (this.isDrawn()) {
                    widget.removeFromParent();
                }
            } else {
                widget.removeFromParent();
            }
        }

    }

    public String getInnerHTML() {
    	//if this canvas is being redrawn, detach underlying gwt widget so that onDraw()
        //can correctly reassociate it with container div
        String innerElementID = this.getID() + "_widget";
    
        removeWidget();

        return "<DIV STYLE='width:100%;height:100%' ID='" + innerElementID + "'></DIV>";
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
