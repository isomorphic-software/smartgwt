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

public class StockItemDS extends DataSource {

    private static StockItemDS instance = null;

    public static StockItemDS getInstance() {
        if (instance == null) {
            instance = new StockItemDS("stockItemDS");
        }
        return instance;
    }

    public StockItemDS(String id) {

        setID(id);

        DataSourceSequenceField pkField = new DataSourceSequenceField("itemID");
        pkField.setHidden(true);
        pkField.setPrimaryKey(true);

        DataSourceTextField stockCodeField = new DataSourceTextField("stockCode", "Stock Code");
        DataSourceTextField descriptionField = new DataSourceTextField("description", "Description");
        DataSourceFloatField priceField = new DataSourceFloatField("price", "Unit Price");
        DataSourceIntegerField quantityField = new DataSourceIntegerField("quantity", "Quantity");
                
        setFields(pkField, stockCodeField, descriptionField, priceField, quantityField);

        setTestData(StockItemData.getRecords());
        setClientOnly(true);        
    }
}