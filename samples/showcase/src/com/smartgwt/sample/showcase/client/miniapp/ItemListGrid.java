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

package com.smartgwt.sample.showcase.client.miniapp;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.bean.BeanFactory;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridFieldIfFunction;
import com.smartgwt.client.widgets.grid.ListGridRecord;

@BeanFactory.Generate({SpinnerItem.class})
public class ItemListGrid extends ListGrid {

    public ItemListGrid(DataSource supplyItemDS) {

        setDataSource(supplyItemDS);
        setUseAllDataSourceFields(true);


        ListGridField itemName = new ListGridField("itemName", "Name");
        itemName.setShowHover(true);
        
        ListGridField units = new ListGridField("units");
        units.setWidth(100);
        units.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
        units.setAutoFitWidth(true);
        
        ListGridField unitCost = new ListGridField("unitCost");
        unitCost.setWidth(100);
        unitCost.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
        unitCost.setAutoFitWidth(true);
        unitCost.setFormat("¤,0.00");

        unitCost.setEditorType(SpinnerItem.class);
        SpinnerItem spinnerItem = new SpinnerItem();
        spinnerItem.setStep(0.01);
        unitCost.setEditorProperties(spinnerItem);

        ListGridField sku = new ListGridField("SKU");
        sku.setCanEdit(false);
        sku.setAutoFitWidthApproach(AutoFitWidthApproach.VALUE);
        sku.setAutoFitWidth(true);

        ListGridField description = new ListGridField("description");
        description.setWidth(150);
        description.setShowHover(true);

        ListGridField category = new ListGridField("category");
        category.setCanEdit(false);
        category.setAutoFitWidthApproach(AutoFitWidthApproach.VALUE);
        category.setAutoFitWidth(true);

        ListGridField inStock = new ListGridField("inStock");
        inStock.setWidth(70);
        inStock.setAlign(Alignment.CENTER);

        ListGridField nextShipment = new ListGridField("nextShipent", 150);
        nextShipment.setShowIfCondition(new ListGridFieldIfFunction() {
            public boolean execute(ListGrid grid, ListGridField field, int fieldNum) {
                return false;
            }
        });

        setFields(itemName, units, unitCost, sku, description, category, inStock);
        setCanEdit(true);
        setCanDragRecordsOut(true);
        setHoverWidth(200);
        setHoverHeight(20);
        setSelectionType(SelectionStyle.SINGLE);
    }
}