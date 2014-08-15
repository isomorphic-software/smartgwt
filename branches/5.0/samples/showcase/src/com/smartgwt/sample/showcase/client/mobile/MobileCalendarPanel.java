package com.smartgwt.sample.showcase.client.mobile;

import com.smartgwt.client.widgets.calendar.Calendar;
import com.smartgwt.sample.showcase.client.data.CalendarData;

public class MobileCalendarPanel extends Calendar {

    public MobileCalendarPanel() {
        setData(CalendarData.getRecords());
    }


}
