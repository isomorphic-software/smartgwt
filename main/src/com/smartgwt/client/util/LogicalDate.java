package com.smartgwt.client.util;

import com.google.gwt.core.client.JsDate;

import java.util.Date;

public class LogicalDate extends Date {

    private LogicalDate() {
        super();
    }

    LogicalDate(long time) {
        super(time);
    }

    LogicalDate(double time) {
        super((long)time);
    }

    public final double getTimeAsDouble() {
        return (double)getTime();
    }

    public native final JsDate toJavaScriptDate() /*-{
        // Use $wnd.isc.DateUtil.create() instead of JsDate.create() so that instance methods
        // like duplicate() are added to the resulting JavaScript date object.
        var jsD = $wnd.isc.DateUtil.create();
        jsD.setTime(this.@com.smartgwt.client.util.LogicalDate::getTimeAsDouble()());
        jsD.logicalDate = true;
        return jsD;
    }-*/;
}
