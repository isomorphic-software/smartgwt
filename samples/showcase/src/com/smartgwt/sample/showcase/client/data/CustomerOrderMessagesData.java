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

public class CustomerOrderMessagesData {

    private static ListGridRecord[] records;
    static Date today = new Date();
    static int year = today.getYear() - 1;

    public static ListGridRecord[] getRecords() {
        if (records == null) {
            records = getNewRecords();
        }
        return records;
    }

    public static ListGridRecord[] getNewRecords() {
        return new ListGridRecord[]{
                createRecord("1108776", "Customer Support", new Date(year, 10, 17), "The customer has called to complain about late delivery of this order. A verbal promise was given that the goods would be shipped within 3 days of order placement. It has now been 5"),
                createRecord("1108776", "Sales", new Date(year, 10, 19), "That's not what we promised the customer, we said 3 days to ship to us, then 5 days to them"),
                createRecord("1108776", "Customer Support", new Date(year, 10, 19), "can you call the customer as they disagree with this"),
                createRecord("1108778", "Logistics", new Date(year, 10, 14), "Goods have been received today will be despatched on the 21st"),
                createRecord("1108779", "Finance", new Date(year, 10, 17), "This customers aged debt has now reached maximum, please contact credit control before placing any new orders"),
                createRecord("1108779", "Sales", new Date(year, 10, 17), "Can we honor existing order placement?"),
                createRecord("1108779", "Finance", new Date(year, 10, 17), "Yes, but please inform credit control of any changes in this account activity"),
                createRecord("1108780", "Logistics", new Date(year, 10, 12), "Customer has been informed of a 3 week delay in receiving goods"),
                createRecord("1108781", "Logistics", new Date(year, 10, 12), "Please delay shipping this order until atleast the 15th November, Customer Request"),
                createRecord("1108782", "Finance", new Date(year, 10, 10), "Customer is disputing this order, please advise contact type and order acknowledgment"),
                createRecord("1108782", "Sales", new Date(year, 10, 14), "Customer ordered via fax. Fax has been scanned and lodged in Sales order respository"),
                createRecord("1108783", "Sales", new Date(year, 10, 22), "Customer order Quantity seems very high. Can you please confirm the numbers with the Customer")
       };
    }
    
    public static ListGridRecord createRecord(String orderID,
    										  String loggedBy,
    										  Date loggedDate,
    										  String orderMessage) {
        ListGridRecord record = new ListGridRecord();
        record.setAttribute("orderID", orderID);
        record.setAttribute("loggedBy", loggedBy);
        record.setAttribute("loggedDate", loggedDate);
        record.setAttribute("orderMessage", orderMessage);
        return record;
     }
}
