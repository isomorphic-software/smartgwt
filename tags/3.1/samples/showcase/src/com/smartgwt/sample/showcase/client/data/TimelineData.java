package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.widgets.calendar.CalendarEvent;

import java.util.Date;

public class TimelineData {

    private static CalendarEvent[] records;
    private static Date today = new Date(112, 5, 2);
    private static int year = today.getYear();
    private static int month = today.getMonth();
    private static int start = today.getDate();

    public static CalendarEvent[] getRecords() {
        if (records == null) {
            records = getNewRecords();
        }
        return records;
    }

    public static CalendarEvent[] getNewRecords() {
        return new CalendarEvent[]{
                new CalendarEvent(1, "Add new Timeline view", "Add a new calendar Timeline component", new Date(year, month, start + 2), new Date(year, month, start + 8, 23, 59, 59), "darcyFeeney"),
                new CalendarEvent(2, "ListGrid field autoSize", "Complex field-autosizing in ListGrid", new Date(year, month, start), new Date(year, month, start, 23, 59, 59), "kaiKong"),
                new CalendarEvent(3, "PDF Import/Export", "Implement native PDF import/export", new Date(year, month, start + 1), new Date(year, month, start + 6, 23, 59, 59), "garretMonroe"),
                new CalendarEvent(4, "Calculated Fields", "Formula and Summary fields for ListGrid", new Date(year, month, start), new Date(year, month, start + 4, 23, 59, 59), "charlesMadigan"),
                new CalendarEvent(5, "ListGrid cell-level selection", "Implement spreadsheet-like selection in ListGrid", new Date(year, month, start + 7), new Date(year, month, start + 14, 23, 59, 59), "charlesMadigan"),
                new CalendarEvent(6, "Text import", "Server text-import", new Date(year, month, start + 16), new Date(year, month, start + 20, 23, 59, 59), "charlesMadigan"),
                new CalendarEvent(7, "TabIndex enhancements", "Enhance formItem tabindex handling", new Date(year, month, start + 9), new Date(year, month, start + 11, 23, 59, 59), "kaiKong"),
                new CalendarEvent(8, "Visual Builder skin", "Skinning changes", new Date(year, month, start), new Date(year, month, start + 3, 23, 59, 59), "shelleyFewel"),
                
                new CalendarEvent(9, "DataSource Transaction-handling", "New transaction features", new Date(year, month, start), new Date(year, month, start + 2, 23, 59, 59), "tamaraKane"),
                new CalendarEvent(10, "New Samples", "Add 20 samples for the following new features: ...", new Date(year, month, start + 4), new Date(year, month, start + 20, 23, 59, 59), "tamaraKane"),
                new CalendarEvent(11, "Localization", "Extend i18n support", new Date(year, month, start + 9), new Date(year, month, start + 14, 23, 59, 59), "darcyFeeney"),
                new CalendarEvent(12, "New Language Packs", "Add these 4 new language packs: ...", new Date(year, month, start + 16), new Date(year, month, start + 18, 23, 59, 59), "darcyFeeney"),
                
                new CalendarEvent(13, "ComponentXML", "Add the following features and update documentation: ...", new Date(year, month, start + 5), new Date(year, month, start + 11, 23, 59, 59), "shelleyFewel"),
                new CalendarEvent(14, "TileGrid", "Change styling on builtin tiles as follows: ...", new Date(year, month, start + 14), new Date(year, month, start + 19, 23, 59, 59), "shelleyFewel"),
                new CalendarEvent(15, "Dev Meeting", "Weekly dev meeting", new Date(year, month, start + 1), new Date(year, month, start + 1, 23, 59, 59), false, "testStyle", "charlesMadigen"),
                new CalendarEvent(16, "Dev Meeting", "Weekly dev meeting", new Date(year, month, start + 8), new Date(year, month, start + 8, 23, 59, 59), false, "testStyle", "charlesMadigen"),
                new CalendarEvent(17, "Dev Meeting", "Weekly dev meeting", new Date(year, month, start + 15), new Date(year, month, start + 15, 23, 59, 59), false, "testStyle", "charlesMadigen"),

                new CalendarEvent(18, "Oracle enhancements", "Add the following 11g-specific enhancements: ...", new Date(year, month, start + 7), new Date(year, month, start + 9, 23, 59, 59), "garretMonroe"),
                new CalendarEvent(19, "Client export", "Excel export alterations", new Date(year, month, start + 11), new Date(year, month, start + 14, 23, 59, 59), "garretMonroe"),
                new CalendarEvent(20, "Record Components", "New ListGrid recordComponent modes: ...", new Date(year, month, start + 16), new Date(year, month, start + 20, 23, 59, 59), "garretMonroe"),
                new CalendarEvent(21, "SQLDataSource", "Enhancements to customSQL support", new Date(year, month, start + 2), new Date(year, month, start + 4, 23, 59, 59), "kaiKong"),
                new CalendarEvent(22, "includeFrom", "Update support via includeFrom", new Date(year, month, start + 6), new Date(year, month, start + 8, 23, 59, 59), "kaiKong"),
                new CalendarEvent(23, "FileItem", "Add milti-file upload support", new Date(year, month, start + 14), new Date(year, month, start + 16, 23, 59, 59), "kaiKong"),
                new CalendarEvent(24, "Doc viewer", "Enhance documentation viewer with these additional syntax-hilites: ...", new Date(year, month, start + 18), new Date(year, month, start + 19, 23, 59, 59), "kaiKong")
        };
    }
}