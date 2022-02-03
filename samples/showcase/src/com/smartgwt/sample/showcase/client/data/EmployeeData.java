package com.smartgwt.sample.showcase.client.data;

public class EmployeeData {

    private static EmployeeRecord[] records;

    public static EmployeeRecord[] getRecords() {
        if (records == null) {
            records = getNewRecords();
        }
        return records;
    }

    public static EmployeeRecord[] getNewRecords() {
        return new EmployeeRecord[]{
                new EmployeeRecord("Richard Smith", "Marketing", "Community Relations"),
                new EmployeeRecord("Sam Edwards", "Services", "Support")
        };
    }
}