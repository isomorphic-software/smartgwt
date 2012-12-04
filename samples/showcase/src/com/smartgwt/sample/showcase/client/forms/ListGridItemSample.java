/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.sample.showcase.client.forms;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.Window;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemInitHandler;
import com.smartgwt.client.widgets.form.fields.events.ShowValueEvent;
import com.smartgwt.client.widgets.form.fields.events.ShowValueHandler;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.CanvasItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.DataArrivedEvent;
import com.smartgwt.client.widgets.grid.events.DataArrivedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedEvent;
import com.smartgwt.client.widgets.grid.events.SelectionUpdatedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class ListGridItemSample extends ShowcasePanel {
    private static final String DESCRIPTION =
        "<p>A special type of form control called a CanvasItem allows any kind of " +
        "SmartClient widget to participate in form layout and values management.</p>" +
        "<p>Drag resize the form &mdash; notice how the embedded ListGrid fills the available " +
        "space.</p>" +
        "<p>The embedded ListGrid starts out showing the initial value provided to the form " +
        "(\"Germany\"). Click the button titled \"Set Value: France\" to provide a new " +
        "value to the form, causing the CanvasItem to display this value.</p>" +
        "<p>Click on any country in the list &mdash; the form picks up the value and fires " +
        "standard change events, causing new values to be displayed in a Label.</p>" +
        "<p>This CanvasItem provides functionality similar to an HTML &lt;select&gt;, " +
        "however, because it's based on a ListGrid, any ListGrid behavior could be added: " +
        "data paging, drag and drop, hovers, inline search, inline editing, grouping, etc.</p>";
        
    public static class Factory implements PanelFactory {
        private String id;
        public Canvas create() {
            ListGridItemSample panel = new ListGridItemSample();
            id = panel.getID();
            return panel;
        }
        
        public String getID() {
            return id;
        }
        
        public String getDescription() {
            return DESCRIPTION;
        }
    }
    
    protected boolean isTopIntro() {
        return true;
    }
    
    public class ListGridItem extends CanvasItem {
        ListGridItem (String name) {
            super(name);
            
            setHeight100();
            setWidth100();
            setEndRow(true);
            setStartRow(true);
            setColSpan("*");
            setShowTitle(false);
            
            // this is going to be an editable data item
            setShouldSaveValue(true);
            
            addShowValueHandler(new ShowValueHandler() {
                @Override
                public void onShowValue(ShowValueEvent event) {
                    CanvasItem item = (CanvasItem) event.getSource();
                    
                    ListGrid grid = (ListGrid)item.getCanvas();
                    if (grid==null) return;
                    
                    grid.deselectAllRecords();
                    String value = (String) event.getDisplayValue();
                    if (value==null) return;
                    
                    RecordList recordList = grid.getDataAsRecordList();
                    int index = recordList.findIndex(item.getFieldName(), value);
                    grid.selectRecord(index);
                }
            });
            
            setInitHandler(new FormItemInitHandler () {
                @Override
                public void onInit(FormItem item) {
                    ListGrid grid = new ListGrid();
                    grid.setWidth("*");
                    grid.setHeight("*");
                    grid.setLeaveScrollbarGap(false);
                    grid.setFields(((ListGridItem) item).getGridFields());
                    grid.setData(((ListGridItem)item).getGridData());
                    grid.setAutoFetchData(true);
                    
                    grid.addDrawHandler(new DrawHandler() {
                        @Override
                        public void onDraw(DrawEvent event) {
                            ListGrid grid = (ListGrid)event.getSource();
                            RecordList data = grid.getDataAsRecordList();
                            CanvasItem item = grid.getCanvasItem();
                            String value = (String)item.getValue();
                            String fieldName = item.getFieldName();
                            if (value != null) grid.selectRecord(data.find(fieldName, value));                            
                        }
                    });
                    
                    grid.addSelectionUpdatedHandler(new SelectionUpdatedHandler() {
                        @Override
                        public void onSelectionUpdated(SelectionUpdatedEvent event) {
                            ListGrid grid = (ListGrid) event.getSource();
                            CanvasItem item = grid.getCanvasItem();
                            ListGridRecord record = grid.getSelectedRecord();
                            if (record != null) {
                                item.storeValue(record.getAttribute(item.getFieldName()));
                            } else {
                                item.storeValue((com.smartgwt.client.data.Record)null);
                            }
                        }
                    });
                    
                    ((CanvasItem) item).setCanvas(grid);
                }
            });
        }
        
        private ListGridRecord[] gridData;
        public void setGridData(ListGridRecord[] gridData) {
            this.gridData = gridData;
        }
        
        public ListGridRecord[] getGridData() {
            return gridData;
        }
        
        private ListGridField[] gridFields;
        public void setGridFields(ListGridField... gridFields) {
            this.gridFields = gridFields;
        }
        
        public ListGridField[] getGridFields() {
            return gridFields;
        }        
    };
    
    public Canvas getViewPanel() {
        final DynamicForm exampleForm = new DynamicForm();
        exampleForm.setLeft(200);
        exampleForm.setCanDragResize(true);
        exampleForm.setBorder("3px solid #0083ff");
        
        TextItem nameField = new TextItem("Name");
        
        ListGridItem countryField = new ListGridItem("countryName");
        countryField.setGridData(CountrySampleData.getRecords());
        countryField.setGridFields(new ListGridField("countryName"), 
                                   new ListGridField("capital"));
        
        TextItem emailField = new TextItem("Email");
        
        exampleForm.setFields(nameField, countryField, emailField);
        
        Map initialValues = new HashMap();
        initialValues.put("Name", "Bob");
        initialValues.put("countryName", "Germany");
        initialValues.put("Email", "bob@isomorphic.com");
        exampleForm.setValues(initialValues);
        
        final Label valuesLabel = new Label();
        valuesLabel.setContents("Initial Values:<br>" + initialValues.toString());
        
        exampleForm.addItemChangedHandler(new ItemChangedHandler() {
            @Override
            public void onItemChanged(ItemChangedEvent event) {
                valuesLabel.setContents("Current Values:<br>" 
                                        + exampleForm.getValues().toString());
            }
        });
        
        IButton setValueButton = new IButton("Set Value: France");
        setValueButton.setAutoFit(true);
        setValueButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                exampleForm.setValue("countryName", "France");
                valuesLabel.setContents("Current Values:<br>" 
                                        + exampleForm.getValues().toString());
            }
        });

        HLayout panel = new HLayout();
        
        VLayout leftStack = new VLayout();
        leftStack.setMembers(setValueButton, valuesLabel);
        
        panel.setMembers(leftStack, exampleForm);
        return panel;
    }
    
    public String getIntro() {
        return DESCRIPTION;
    }
}