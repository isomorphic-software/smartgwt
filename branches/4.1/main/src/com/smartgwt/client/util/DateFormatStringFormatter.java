package com.smartgwt.client.util;

import java.util.Date;

import com.smartgwt.client.types.DateDisplayFormat;

public class DateFormatStringFormatter implements DateDisplayFormatter {

    private String formatString;

    public DateFormatStringFormatter(String formatString) {
        this.formatString = formatString;
    }

    @Override
    public native String format(Date date) /*-{
        if (date == null) {
            return null;
        } else {
            var formatString = this.@com.smartgwt.client.util.DateFormatStringFormatter::formatString;
            var dateJS = @com.smartgwt.client.util.JSOHelper::toDateJS(Ljava/util/Date;)(date);
            return dateJS.format(formatString);
        }
    }-*/;

    public String getFormatString() {
        return formatString;
    }
}
