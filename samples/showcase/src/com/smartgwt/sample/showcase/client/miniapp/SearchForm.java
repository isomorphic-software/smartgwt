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

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;

public class SearchForm extends com.smartgwt.client.widgets.form.SearchForm {
    private ComboBoxItem itemName;
    private ButtonItem findItem;


    public SearchForm(DataSource supplyItemDS) {

        setDataSource(supplyItemDS);
        setTop(20);
        setCellPadding(6);
        setNumCols(7);
        setStyleName("defaultBorder");
        
        findItem = new ButtonItem("Find");
        findItem.setIcon("icons/16/find.png");
        findItem.setWidth(80);
        findItem.setEndRow(false);

        TextItem skuItem = new TextItem("SKU");

        itemName = new ComboBoxItem("itemName");
        itemName.setOptionDataSource(supplyItemDS);
        itemName.setPickListWidth(250);

        CheckboxItem findInCategory = new CheckboxItem("findInCategory");
        findInCategory.setTitle("Use Category");
        findInCategory.setDefaultValue(true);
        findInCategory.setShouldSaveValue(false);

        setItems(findItem, skuItem, itemName, findInCategory);
    }

    public ComboBoxItem getItemNameField() {
        return itemName;
    }

    public void addFindListener(ClickHandler handler) {
        findItem.addClickHandler(handler);
    }

}