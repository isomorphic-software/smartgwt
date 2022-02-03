package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.widgets.calendar.Lane;

import java.util.Date;

public class TimelineLaneData {

    private static Lane[] records;

    public static Lane[] getRecords() {
        if (records == null) {
            records = getNewRecords();
        }
        return records;
    }

    public TimelineLaneData() {
    }

    public static Lane[] getNewRecords() {
        Lane[] lanes = new Lane[]{
            getLane("charlesMadigen", "Charles Madigen", "Managers"),
            getLane("tamaraKane", "Tamara Kane", "Developers"),
            getLane("darcyFeeney", "Darcy Feeney", "Managers"),
            getLane("kaiKong", "Kai Kong", "Developers"),
            getLane("shelleyFewel", "Shelley Fewel", "Managers"),
            getLane("garretMonroe", "Garret Monroe", "Developers")
        };
        return lanes;
    }
    
	private static Lane getLane(String name, String title, String devGroup) {
		Lane lane = new Lane(name, title);
		lane.setAttribute("devGroup", devGroup);
		return lane;
	}


}