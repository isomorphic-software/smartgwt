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
 
package com.smartgwt.qa.data;

import com.google.gwt.core.client.GWT;

import com.smartgwt.qa.TestRunner;
import com.smartgwt.qa.TestCase;

import com.smartgwt.client.bean.BeanFactory;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.fields.events.FocusHandler;
import com.smartgwt.client.widgets.form.fields.events.FocusEvent;

public class DataSourceFieldTest extends TestRunner {
    public static class CustomTextItem extends TextItem {
        public String customVariable;

        CustomTextItem () {
            setHeight(36);

            customVariable = "Focus event handled correctly with 'this'";

            addFocusHandler(new FocusHandler () {
                public void onFocus(FocusEvent focus) {
                    CustomTextItem item = CustomTextItem.this;
                    item.setValue(item.customVariable);
                }
            });
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

    public DataSourceFieldTest () {
        super(
            new TestCase("setEditorType(Class)") {
                public void doTest () {
                    DataSource ds = new DataSource();
                    ds.setClientOnly(true);

                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(true);
                    textField.setEditorType(CustomTextItem.class);
                    ds.setFields(textField);

                    ListGrid grid = new ListGrid(ds);
                    grid.setCanEdit(true);
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
                    DataSource ds = new DataSource();
                    ds.setClientOnly(true);

                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(true);
                    textField.setEditorType("com.smartgwt.qa.data.DataSourceFieldTest$CustomTextItem");
                    ds.setFields(textField);

                    ListGrid grid = new ListGrid(ds);
                    grid.setCanEdit(true);
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
                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    boolean exceptionThrown = false;
                    try {
                        textField.setEditorType(UnregisteredTextItem.class);
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
                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    boolean exceptionThrown = false;
                    try {
                        textField.setEditorType(CustomCanvas.class.getName());
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
                    DataSource ds = new DataSource();
                    ds.setClientOnly(true);

                    FormItem item = new FormItem();
                    item.setHeight(36);

                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(true);
                    textField.setEditorType(item);
                    ds.setFields(textField);

                    ListGrid grid = new ListGrid(ds);
                    grid.setCanEdit(true);
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
                    DataSource ds = new DataSource();
                    ds.setClientOnly(true);

                    FormItem item = new FormItem();
                    item.setHeight(36);

                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(true);
                    textField.setEditorProperties(item);
                    ds.setFields(textField);

                    ListGrid grid = new ListGrid(ds);
                    grid.setCanEdit(true);
                    grid.draw();
                    
                    Record r = new Record();
                    r.setAttribute("name", "Text to edit");
                    grid.startEditingNew(r);

                    this.assertGreaterThan(grid.getDrawnRowHeight(0), 36, "drawnRowHeight should be greater than 36");
                    setResult();
                }
            },
            new TestCase("setReadOnlyEditorType(Class)") {
                public void doTest () {
                    DataSource ds = new DataSource();
                    ds.setClientOnly(true);

                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(false);
                    textField.setReadOnlyEditorType(CustomTextItem.class);
                    ds.setFields(textField);

                    DynamicForm form = new DynamicForm();
                    form.setDataSource(ds);
                    form.draw();

                    Record r = new Record();
                    r.setAttribute("name", "Text to edit");
                    form.editRecord(r);

                    FormItem item = form.getItem("name");
                    this.assertEqual(item.getHeight(), 36, "height should be 36");
                    setResult();
                }
            },
            new TestCase("setReadOnlyEditorType(String)") {
                public void doTest () {
                    DataSource ds = new DataSource();
                    ds.setClientOnly(true);

                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(false);
                    textField.setReadOnlyEditorType("com.smartgwt.qa.data.DataSourceFieldTest$CustomTextItem");
                    ds.setFields(textField);

                    DynamicForm form = new DynamicForm();
                    form.setDataSource(ds);
                    form.draw();

                    Record r = new Record();
                    r.setAttribute("name", "Text to edit");
                    form.editRecord(r);

                    FormItem item = form.getItem("name");
                    this.assertEqual(item.getHeight(), 36, "height should be 36");
                    setResult();
                }
            },
            new TestCase("setReadOnlyEditorType() when not registered for reflection") {
                public void doTest () {
                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    boolean exceptionThrown = false;
                    try {
                        textField.setReadOnlyEditorType(UnregisteredTextItem.class);
                    }
                    catch (IllegalArgumentException ex) {
                        exceptionThrown = true;
                    }

                    this.assertTrue(exceptionThrown, "should have thrown IllegalArgumentException");
                    this.setResult();
                }
            },
            new TestCase("setReadOnlyEditorType() when not FormItem subclass") {
                public void doTest () {
                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    boolean exceptionThrown = false;
                    try {
                        textField.setReadOnlyEditorType(CustomCanvas.class.getName());
                    }
                    catch (IllegalArgumentException ex) {
                        exceptionThrown = true;
                    }

                    this.assertTrue(exceptionThrown, "should have thrown IllegalArgumentException");
                    this.setResult();
                }
            },
            new TestCase("setReadOnlyEditorType(FormItem) still works") {
                public void doTest () {
                    DataSource ds = new DataSource();
                    ds.setClientOnly(true);

                    FormItem properties = new FormItem();
                    properties.setHeight(36);

                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(false);
                    textField.setReadOnlyEditorType(properties);
                    ds.setFields(textField);

                    DynamicForm form = new DynamicForm();
                    form.setDataSource(ds);
                    form.draw();

                    Record r = new Record();
                    r.setAttribute("name", "Text to edit");
                    form.editRecord(r);

                    FormItem item = form.getItem("name");
                    this.assertEqual(item.getHeight(), 36, "height should be 36");
                    setResult();
                }
            },
            new TestCase("setReadOnlyEditorProperties(FormItem)") {
                public void doTest () {
                    DataSource ds = new DataSource();
                    ds.setClientOnly(true);

                    FormItem properties = new FormItem();
                    properties.setHeight(36);

                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(false);
                    textField.setReadOnlyEditorProperties(properties);
                    ds.setFields(textField);

                    DynamicForm form = new DynamicForm();
                    form.setDataSource(ds);
                    form.draw();

                    Record r = new Record();
                    r.setAttribute("name", "Text to edit");
                    form.editRecord(r);

                    FormItem item = form.getItem("name");
                    this.assertEqual(item.getHeight(), 36, "height should be 36");
                    setResult();
                }
            },
            new TestCase("checkHandlersForSettingThis") {
                public void doTest () {
                    DataSource ds = new DataSource();
                    ds.setClientOnly(true);

                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setEditorType(CustomTextItem.class);
                    ds.setFields(textField);

                    DynamicForm form = new DynamicForm();
                    form.setDataSource(ds);
                    form.draw();

                    Record r = new Record();
                    r.setAttribute("name", "Text to edit");
                    form.editRecord(r);

                    FormItem item = form.getItem("name");
                    form.focusInItem(item);
                    this.assertEqual(item.getValue(), "Focus event handled correctly with 'this'", "Check for 'this' in handler");
                    setResult();
                }
            }
        );
    }
}
