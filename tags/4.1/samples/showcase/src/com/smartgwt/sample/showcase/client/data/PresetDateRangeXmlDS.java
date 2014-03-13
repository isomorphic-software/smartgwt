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

public class PresetDateRangeXmlDS extends DataSource {
	private static PresetDateRangeXmlDS instance = null;
	  
    public static PresetDateRangeXmlDS getInstance() {
        if (instance == null) {
            instance = new PresetDateRangeXmlDS("presetDateRangeDS");
        }
        return instance;
    }
  
    public PresetDateRangeXmlDS(String id) {
        setID(id);  
        
        setRecordXPath("/List/order");
        
        DataSourceTextField customerIDField = new DataSourceTextField("customerID", "Customer ID");
        customerIDField.setRequired(true);
          
        DataSourceTextField customerNameField = new DataSourceTextField("customerName", "Customer Name");
        customerNameField.setRequired(true);
        
        DataSourceTextField orderIDField = new DataSourceTextField("orderID", "Order ID");
        orderIDField.setPrimaryKey(true);

        DataSourceDateField orderDateField = new DataSourceDateField("orderDate", "Order Date");
        orderDateField.setRequired(true);
        
        DataSourceTextField orderDescriptionField = new DataSourceTextField("orderDescription", "Order Description");
        orderDescriptionField.setRequired(true);

        DataSourceIntegerField orderQtyField = new DataSourceIntegerField("orderQty", "Order Qty");
        orderQtyField.setRequired(true);
        
        setFields(customerIDField, customerNameField, orderIDField,
        		orderDateField, orderDescriptionField, orderQtyField);
  
        setTestData(PresetDateRangeData.getNewRecords());
        setClientOnly(true);
    }
}
