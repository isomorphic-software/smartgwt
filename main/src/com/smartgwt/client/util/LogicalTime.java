package com.smartgwt.client.util;

import com.google.gwt.core.client.JsDate;

import java.util.Date;

public class LogicalTime extends Date {

    private LogicalTime() {
        super();
    }

    LogicalTime(long time) {
        super(time);
    }

    LogicalTime(double time) {
        super((long)time);
    }

    public final double getTimeAsDouble() {
        return (double)getTime();
    }

    public native final JsDate toJavaScriptDate() /*-{
        // Use $wnd.Date.create() instead of JsDate.create() so that instance methods like
        // duplicate() are added to the resulting JavaScript date object.
        var jsD = $wnd.Date.create();
        jsD.setTime(this.@com.smartgwt.client.util.LogicalTime::getTimeAsDouble()());
        jsD.logicalTime = true;
        return jsD;
    }-*/;
}
