package com.mycompany.client;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Timer;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.Layout;

class MyContactsImplSafari extends MyContactsImpl {

    private static native Style getStyleHandle(Canvas canvas) /*-{
        var jsObj = canvas.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        return jsObj.getStyleHandle();
    }-*/;

    @Override
    void slideTransition(MyContacts self, final Layout oldPane, final Layout newPane, final Layout container, final boolean right) {
        final int viewportWidth = container.getViewportWidth();

        newPane.hide();
        container.addChild(newPane);
        if (!newPane.isDrawn()) {
            newPane.draw();
        }

        final Style oldStyle = getStyleHandle(oldPane),
                newStyle = getStyleHandle(newPane);

        // place the new element off screen (instantly)
        newStyle.setProperty("webkitTransition", "none");
        final String translation = "translateX(" + (right ? "-" : "") + viewportWidth + "px)";
        newStyle.setProperty("webkitTransform", translation);

        final Overflow oldOverflow = container.getOverflow();
        container.setOverflow(Overflow.HIDDEN);
        // will be initially invisible since clipped
        newPane.show();

        new Timer() {
            @Override
            public void run() {
                // set both to animate
                oldStyle.setProperty("webkitTransition", "-webkit-transform 0.3s ease-in-out");
                newStyle.setProperty("webkitTransition", "-webkit-transform 0.3s ease-in-out");

                // move old off screen
                final String translation = "translateX(" + (right ? "" : "-") + viewportWidth + "px)";
                oldStyle.setProperty("webkitTransform", translation);

                // undo translation on new
                newStyle.setProperty("webkitTransform", "translateX(0px)");

                new Timer() {

                    @Override
                    public void run() {
                        oldPane.hide();
                        container.setOverflow(oldOverflow);
                    }
                }.schedule(350);
            }
        }.schedule(1);
    }
}
