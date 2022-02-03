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

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class OrderMessagesXmlDS extends DataSource {
	private static OrderMessagesXmlDS instance = null;
	  
    public static OrderMessagesXmlDS getInstance() {
        if (instance == null) {
            instance = new OrderMessagesXmlDS("orderMessagesXmlDS");
        }
        return instance;
    }
  
    public OrderMessagesXmlDS(String id) {
        setID(id);  
        
        setRecordXPath("/List/order");
        
        DataSourceTextField orderIDField = new DataSourceTextField("orderID", "Order Number");
        orderIDField.setPrimaryKey(true);
        orderIDField.setHidden(true);
        orderIDField.setForeignKey("presetDateRangeDS.orderID");
          
        DataSourceTextField loggedByField = new DataSourceTextField("loggedBy", "Logged By", 70);
        loggedByField.setRequired(true);
        
        DataSourceDateField loggedDateField = new DataSourceDateField("loggedDate", "Message Date", 80);
        loggedDateField.setRequired(true);
        
        DataSourceTextField orderMessageField = new DataSourceTextField("orderMessage", "Message");
        
        setFields(orderIDField, loggedByField, loggedDateField,	orderMessageField);
  
        setTestData(CustomerOrderMessagesData.getNewRecords());
        setClientOnly(true);
    }
}
