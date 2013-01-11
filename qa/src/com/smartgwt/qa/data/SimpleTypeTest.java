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
import com.smartgwt.client.data.SimpleType;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.types.FieldType;

public class SimpleTypeTest extends TestRunner {
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

    public SimpleTypeTest () {
        super(
            new TestCase("setEditorType(Class)") {
                public void doTest () {
                    DataSource ds = new DataSource();
                    ds.setClientOnly(true);

                    SimpleType type = new SimpleType("CustomText", FieldType.TEXT);
                    type.setEditorType(CustomTextItem.class);

                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(true);
                    textField.setType(type);
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

                    SimpleType type = new SimpleType("CustomText", FieldType.TEXT);
                    type.setEditorType("com.smartgwt.qa.data.SimpleTypeTest$CustomTextItem");

                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(true);
                    textField.setType(type);
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
                    SimpleType type = new SimpleType();
                    boolean exceptionThrown = false;
                    try {
                        type.setEditorType(UnregisteredTextItem.class);
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
                    SimpleType type = new SimpleType();
                    boolean exceptionThrown = false;
                    try {
                        type.setEditorType(CustomCanvas.class.getName());
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

                    SimpleType type = new SimpleType("CustomText", FieldType.TEXT);
                    type.setEditorType(item);
                    
                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(true);
                    textField.setType(type);
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

                    SimpleType type = new SimpleType("CustomText", FieldType.TEXT);
                    type.setEditorProperties(item);
                    
                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(true);
                    textField.setType(type);
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
                    
                    SimpleType type = new SimpleType("CustomText", FieldType.TEXT);
                    type.setReadOnlyEditorType(CustomTextItem.class);

                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(false);
                    textField.setType(type);
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
                    
                    SimpleType type = new SimpleType("CustomText", FieldType.TEXT);
                    type.setReadOnlyEditorType("com.smartgwt.qa.data.SimpleTypeTest$CustomTextItem");

                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(false);
                    textField.setType(type);
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
                    SimpleType type = new SimpleType("CustomText", FieldType.TEXT);
                    boolean exceptionThrown = false;
                    try {
                        type.setReadOnlyEditorType(UnregisteredTextItem.class);
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
                    SimpleType type = new SimpleType("CustomText", FieldType.TEXT);
                    boolean exceptionThrown = false;
                    try {
                        type.setReadOnlyEditorType(CustomCanvas.class.getName());
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

                    SimpleType type = new SimpleType("CustomText", FieldType.TEXT);
                    type.setReadOnlyEditorType(properties);
                    
                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(false);
                    textField.setType(type);
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

                    SimpleType type = new SimpleType("CustomText", FieldType.TEXT);
                    type.setReadOnlyEditorProperties(properties);
                    
                    DataSourceTextField textField = new DataSourceTextField("name", "Name");
                    textField.setCanEdit(false);
                    textField.setType(type);
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
            }
        );
    }
}
