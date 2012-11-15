package com.smartgwt.client.util;

import com.google.gwt.core.client.JsDate;

import java.util.Date;

public class LogicalDate extends Date {

    private LogicalDate() {
        super();
    }

    private LogicalDate(long time) {
        super(time);
    }

    private LogicalDate(double time) {
        super((long)time);
    }

    public final double getTimeAsDouble() {
        return (double)getTime();
    }

    public native final JsDate toJavaScriptDate() /*-{
        // Use $wnd.Date.create() instead of JsDate.create() so that instance methods like
        // duplicate() are added to the resulting JavaScript date object.
        var jsD = $wnd.Date.create();
        jsD.setTime(this.@com.smartgwt.client.util.LogicalDate::getTimeAsDouble()());
        jsD.logicalDate = true;
        return jsD;
    }-*/;
}
