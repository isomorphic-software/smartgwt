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

package com.smartgwt.sample.showcase.client.grid.editing;

import java.util.Date;

import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.MultipleAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Slider;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SliderItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridEditorContext;
import com.smartgwt.client.widgets.grid.ListGridEditorCustomizer;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class GridCellEditorCustomizerSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p><b>Click</b> on any cell of the &quot;Value Field&quot; column to start editing. This example illustrates how cell editors can be customized for the <b>same</b> ListGridField, but " +
            "different records using ListGrid.setEditorCustomizer(..)</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridCellEditorCustomizerSample panel = new GridCellEditorCustomizerSample();
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

    public Canvas getViewPanel() {

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(300);
        countryGrid.setHeight(340);
        countryGrid.setShowAllRecords(true);

        ListGridField nameField = new ListGridField("name", "Name");
        nameField.setWidth("*");
        nameField.setCanEdit(false);

        ListGridField valueField = new ListGridField("value", "Value Field", 170);

        countryGrid.setFields(nameField, valueField);

        countryGrid.setData(getData());
        countryGrid.setEditorCustomizer(new ListGridEditorCustomizer() {
            public FormItem getEditor(ListGridEditorContext context) {
                ListGridField field = context.getEditField();
                if (field.getName().equals("value")) {
                    NameValueRecord record = (NameValueRecord) context.getEditedRecord();
                    int id = record.getID();
                    switch (id) {
                        case 1:
                            TextItem textItem = new TextItem();
                            textItem.setShowHint(true);
                            textItem.setShowHintInField(true);
                            textItem.setHint("Some Hint");
                            return textItem;
                        case 2:
                            return new PasswordItem();
                        case 3:
                            return new DateItem();
                        case 4:
                            CheckboxItem cbi = new CheckboxItem();
                            cbi.setShowLabel(false);
                            return cbi;
                        case 5:
                            IntegerItem integerItem = new IntegerItem();
                            integerItem.setMask("###");
                            return integerItem;
                        case 6:
                            SelectItem selectItemMultipleGrid = new SelectItem();
                            selectItemMultipleGrid.setShowTitle(false);
                            selectItemMultipleGrid.setMultiple(true);
                            selectItemMultipleGrid.setMultipleAppearance(MultipleAppearance.PICKLIST);
                            selectItemMultipleGrid.setValueMap("Cat", "Dog", "Giraffe", "Goat", "Marmoset", "Mouse");
                            return selectItemMultipleGrid;
                        case 7:
                            Slider sliderProperties = new Slider();
                            sliderProperties.setMargin(2);
                            SliderItem sliderItem = new SliderItem();
                            sliderItem.setMaxValue(10);
                            sliderItem.setWidth(170);
                            sliderItem.setAutoChildProperties("slider", sliderProperties);
                            return sliderItem;
                        default:
                            return context.getDefaultProperties();
                    }
                }
                return context.getDefaultProperties();
            }
        });

        countryGrid.setCanEdit(true);
        countryGrid.setEditEvent(ListGridEditEvent.CLICK);
        countryGrid.setEditByCell(true);

        return countryGrid;
    }

    private ListGridRecord[] getData() {
        return new ListGridRecord[]{
                new NameValueRecord(1, "String Editor", "some string"),
                new NameValueRecord(2, "Password Editor", "donkeykong"),
                new NameValueRecord(3, "Date Editor", new Date()),
                new NameValueRecord(4, "Boolean Editor", Boolean.FALSE),
                new NameValueRecord(5, "Masked Int Editor", 5),
                new NameValueRecord(6, "SelectItem Editor", "Dog"),
                new NameValueRecord(7, "Slider Editor", 7)
        };
    }

    public static class NameValueRecord extends ListGridRecord {

        public NameValueRecord(int id, String name, Object value) {
            setID(id);
            setName(name);
            setValue(value);
        }

        public void setID(int id) {
            setAttribute("ID", id);
        }

        public int getID() {
            return getAttributeAsInt("ID");
        }

        public void setValue(Object value) {
            setAttribute("value", value);
        }

        public Object getValue() {
            return getAttributeAsObject("value");
        }

        public void setName(String name) {
            setAttribute("name", name);
        }

        public String getName() {
            return getAttribute("name");
        }

    }

    public String getIntro() {
        return DESCRIPTION;
    }


}