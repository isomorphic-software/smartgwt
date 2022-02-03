/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.sample.showcase.client.data;

import java.util.Date;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class PresetDateRangeData {

    private static ListGridRecord[] records;
    static Date today = new Date();
    static int start = today.getDate();
    static int month = today.getMonth();
    static int year = today.getYear();

    public static ListGridRecord[] getRecords() {
        if (records == null) {
            records = getNewRecords();
        }
        return records;
    }

    public static ListGridRecord[] getNewRecords() {
        return new ListGridRecord[]{
                createRecord("C000001", "Bobs Tools Inc", "1108776", new Date(year, month, start), "Self Adhesive A4 address labels", 10000),
                createRecord("C000001", "Bobs Tools Inc", "1108777", new Date(year, month, start-1), "A3/A4/A5 stationary pack", 2000),
                createRecord("C000001", "Bobs Tools Inc", "1108778", new Date(year, month, start-3), "multi-coloured ringbinder pack", 150),
                createRecord("C000002", "The Finance Shop", "1108779", new Date(year, month, start-6), "5 X standard black A4 binder pack", 250),
                createRecord("C000002", "The Finance Shop", "1108780", new Date(year, month, start-9), "100 page A4 lined pads", 500),
                createRecord("C000002", "The Finance Shop", "1108781", new Date(year, month, start-16), "Magenta Printer cartridges for HPO230", 50),
                createRecord("C000003", "The Office at Home Ltd", "1108782", new Date(year, month, start-21), "Yellow Printer cartridges for HPO230", 50),
                createRecord("C000003", "The Office at Home Ltd", "1108783", new Date(year, month, start-60), "Black Printer cartridges for HPO230", 50000)
       };
    }
    
    public static ListGridRecord createRecord(String customerId,
    										  String customerName,
    										  String orderId,
    										  Date orderDate,
    										  String orderDescription,
    										  int orderQty) {
        ListGridRecord record = new ListGridRecord();
        record.setAttribute("customerID", customerId);
        record.setAttribute("customerName", customerName);
        record.setAttribute("orderID", orderId);
        record.setAttribute("orderDate", orderDate);
        record.setAttribute("orderDescription", orderDescription);
        record.setAttribute("orderQty", orderQty);
        return record;
     }
}