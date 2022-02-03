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
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceSequenceField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class OrderItemLocalDS extends DataSource {

    private static OrderItemLocalDS instance = null;

    public static OrderItemLocalDS getInstance() {
        if (instance == null) {
            instance = new OrderItemLocalDS("orderItemLocalDS");
        }
        return instance;
    }

    public OrderItemLocalDS(String id) {

        setID(id);

        DataSourceSequenceField pkField = new DataSourceSequenceField("pk");
        pkField.setHidden(true);
        pkField.setPrimaryKey(true);

        DataSourceIntegerField orderIdField = new DataSourceIntegerField("orderID", "Order ID");
        orderIdField.setCanEdit(false);
        orderIdField.setPluralTitle("Orders");

        DataSourceTextField itemDescriptionField = new DataSourceTextField("itemDescription", "Description");
        DataSourceTextField categoryField = new DataSourceTextField("category", "Category");

        DataSourceDateField shipDateField = new DataSourceDateField("shipDate", "Ship Date");
        DataSourceIntegerField quantityField = new DataSourceIntegerField("quantity", "Quantity");
        DataSourceFloatField unitPriceField = new DataSourceFloatField("unitPrice", "Price");
        unitPriceField.setFormat("0.00");

        setFields(pkField, orderIdField, itemDescriptionField, categoryField, shipDateField, quantityField, unitPriceField);

        setTestData(OrderItemData.getRecords());
        setClientOnly(true);        
    }
}