/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.qa.widgets.grid;

import com.google.gwt.core.client.GWT;

import com.smartgwt.qa.TestRunner;
import com.smartgwt.qa.TestCase;

import com.smartgwt.client.bean.BeanFactory;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.SimpleType;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.types.FieldType;

public class ListGridFieldTest extends TestRunner {
    public static class CustomTextItem extends TextItem {
        CustomTextItem () {
            setHeight(36);
        }
    }

    // This one is deliberately unregistered with BeanFactory, so
    // we can test that.
    public static class UnregisteredTextItem extends TextItem {

    }

    public static class CustomCanvas extends Canvas {

    }
    
    static interface MyBeanFactories extends BeanFactory.MetaFactory {
        BeanFactory<CustomTextItem> getCustomTextItemFactory();
        BeanFactory<CustomCanvas> getCustomCanvasFactory();
    }
    
    static {
        // Actually generates the factories. We do it here as an example ...
        // you could create all of them in code that initializes the
        // application, rather than near the point of use like this. It
        // would be slightly more efficient to create them all at once.
        GWT.create(MyBeanFactories.class);
    }

    public ListGridFieldTest () {
        super(
            new TestCase("setEditorType(Class)") {
                public void doTest () {
                    ListGrid grid = new ListGrid();
                    grid.setCanEdit(true);

                    ListGridField field = new ListGridField("name", "Name");
                    field.setEditorType(CustomTextItem.class);
                    grid.setFields(field);
                    
                    grid.draw();
                    
                    Record r = new Record();
                    r.setAttribute("name", "Text to edit");
                    grid.startEditingNew(r);

                    this.assertGreaterThan(grid.getDrawnRowHeight(0), 36, "drawnRowHeight should be greater than 36");
                    setResult();
                }
            },
            new TestCase("setEditorType(String)") {
                public void doTest () {
                    ListGrid grid = new ListGrid();
                    grid.setCanEdit(true);

                    ListGridField field = new ListGridField("name", "Name");
                    field.setEditorType("com.smartgwt.qa.widgets.grid.ListGridFieldTest$CustomTextItem");
                    grid.setFields(field);
                    
                    grid.draw();
                    
                    Record r = new Record();
                    r.setAttribute("name", "Text to edit");
                    grid.startEditingNew(r);

                    this.assertGreaterThan(grid.getDrawnRowHeight(0), 36, "drawnRowHeight should be greater than 36");
                    setResult();
                }
            },
            new TestCase("setEditorType() when not registered for reflection") {
                public void doTest () {
                    ListGridField field = new ListGridField("name", "Name");
                    boolean exceptionThrown = false;
                    try {
                        field.setEditorType(UnregisteredTextItem.class);
                    }
                    catch (IllegalArgumentException ex) {
                        exceptionThrown = true;
                    }

                    this.assertTrue(exceptionThrown, "should have thrown IllegalArgumentException");
                    this.setResult();
                }
            },
            new TestCase("setEditorType() when not FormItem subclass") {
                public void doTest () {
                    ListGridField field = new ListGridField("name", "Name");
                    boolean exceptionThrown = false;
                    try {
                        field.setEditorType(CustomCanvas.class.getName());
                    }
                    catch (IllegalArgumentException ex) {
                        exceptionThrown = true;
                    }

                    this.assertTrue(exceptionThrown, "should have thrown IllegalArgumentException");
                    this.setResult();
                }
            },
            new TestCase("setEditorType(FormItem) still works") {
                public void doTest () {
                    FormItem item = new FormItem();
                    item.setHeight(36);

                    ListGrid grid = new ListGrid();
                    grid.setCanEdit(true);

                    ListGridField field = new ListGridField("name", "Name");
                    field.setEditorType(item);
                    grid.setFields(field);
                    
                    grid.draw();
                    
                    Record r = new Record();
                    r.setAttribute("name", "Text to edit");
                    grid.startEditingNew(r);

                    this.assertGreaterThan(grid.getDrawnRowHeight(0), 36, "drawnRowHeight should be greater than 36");
                    setResult();
                }
            },
            new TestCase("setEditorProperties(FormItem)") {
                public void doTest () {
                    FormItem item = new FormItem();
                    item.setHeight(36);

                    ListGrid grid = new ListGrid();
                    grid.setCanEdit(true);

                    ListGridField field = new ListGridField("name", "Name");
                    field.setEditorProperties(item);
                    grid.setFields(field);
                    
                    grid.draw();
                    
                    Record r = new Record();
                    r.setAttribute("name", "Text to edit");
                    grid.startEditingNew(r);

                    this.assertGreaterThan(grid.getDrawnRowHeight(0), 36, "drawnRowHeight should be greater than 36");
                    setResult();
                }
            }
        );
    }
}
