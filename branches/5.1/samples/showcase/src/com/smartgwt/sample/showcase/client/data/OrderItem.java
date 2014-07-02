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

import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public class OrderItem extends ListGridRecord {

    public OrderItem(int pk, int orderID, String itemDescription, String category, Date shipDate, int quantity, float unitPrice) {
        setPk(pk);
        setOrderID(orderID);
        setItemDescription(itemDescription);
        setCategory(category);
        setShipDate(shipDate);
        setQuantity(quantity);
        setUnitPrice(unitPrice);
    }

    public OrderItem(Record record) {
        super(record.getJsObj());
    }

    public int getPk() {
        return getAttributeAsInt("pk");
    }

    public void setPk(int pk) {
        setAttribute("pk", pk);
    }

    public int getOrderID() {
        return getAttributeAsInt("orderID");
    }

    public void setOrderID(int orderID) {
        setAttribute("orderID", orderID);
    }

    public String getItemDescription() {
        return getAttribute("itemDescription");
    }

    public void setItemDescription(String itemDescription) {
        setAttribute("itemDescription", itemDescription);
    }

    public String getCategory() {
        return getAttribute("category");
    }

    public void setCategory(String category) {
        setAttribute("category", category);
    }

    public Date getShipDate() {
        return getAttributeAsDate("shipDate");
    }

    public void setShipDate(Date shipDate) {
        setAttribute("shipDate", shipDate);
    }

    public int getQuantity() {
        return getAttributeAsInt("quantity");
    }

    public void setQuantity(int quantity) {
        setAttribute("quantity", quantity);
    }

    public float getUnitPrice() {
        return getAttributeAsFloat("unitPrice");
    }

    public void setUnitPrice(float unitPrice) {
        setAttribute("unitPrice", unitPrice);
    }
}
