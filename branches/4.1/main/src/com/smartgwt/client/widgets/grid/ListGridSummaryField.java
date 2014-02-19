/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.types.ListGridFieldType;

/**
 * This class represents a List Grid field that is used as a Summary Field.
 */
public class ListGridSummaryField extends ListGridField {

    public ListGridSummaryField() {
        setType(ListGridFieldType.SUMMARY);
    }

    public ListGridSummaryField(JavaScriptObject jsObj) {
        super(jsObj);
        setType(ListGridFieldType.SUMMARY);
    }

    public ListGridSummaryField(String name) {
        super(name);
        setType(ListGridFieldType.SUMMARY);
    }

    public ListGridSummaryField(String name, int width) {
        super(name, width);
        setType(ListGridFieldType.SUMMARY);
    }

    public ListGridSummaryField(String name, String title) {
        super(name, title);
        setType(ListGridFieldType.SUMMARY);
    }

    public ListGridSummaryField(String name, String title, int width) {
        super(name, title, width);
        setType(ListGridFieldType.SUMMARY);
    }
}
