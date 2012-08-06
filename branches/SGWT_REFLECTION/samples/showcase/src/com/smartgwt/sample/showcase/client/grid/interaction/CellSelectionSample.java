package com.smartgwt.sample.showcase.client.grid.interaction;


import com.google.gwt.core.client.EntryPoint;


import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.CellSelection;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.grid.events.CellSelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.CellSelectionChangedEvent;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.layout.VLayout;

import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryData;

public class CellSelectionSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Grids support cell-level selection.  Click " + 
        "and drag to select a contiguous block of cells.  Use Ctrl-Click (Option-Click on Mac) " +
        "to select or deselect individual cells.  Shift-clicking will extend the current " + 
        "selection to include the target cell.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            CellSelectionSample panel = new CellSelectionSample();
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

    public DynamicForm form;    
    public Canvas getViewPanel() {
    
        Canvas canvas = new Canvas();

        final DynamicForm displayForm = new DynamicForm();
        displayForm.setWidth(250);
        displayForm.setHeight(100);

        TextAreaItem countriesItem = new TextAreaItem("countries", "Selected Cells");
        countriesItem.setWidth("*");
        countriesItem.setColSpan("*");
        countriesItem.setTitleOrientation(TitleOrientation.TOP);

        displayForm.setItems(countriesItem);
        form = displayForm;

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(500);
        countryGrid.setHeight(224);
        countryGrid.setTop(150);
        countryGrid.setShowAllRecords(true);
        countryGrid.setSelectionType(SelectionStyle.MULTIPLE);
        countryGrid.setCanDragSelect(true);
        countryGrid.setCanSelectCells(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);

        countryGrid.setData(CountryData.getRecords());

        countryGrid.addCellSelectionChangedHandler(new CellSelectionChangedHandler() {
            public void onCellSelectionChanged(CellSelectionChangedEvent event) {
                CellSelection selection = countryGrid.getCellSelection();
                int[][] selectedCells = selection.getSelectedCells();
                String cells = "[";
                for (int i = 0; i < selectedCells.length; i++) {
                    cells += "[" + selectedCells[i][0] + ", " + selectedCells[i][1] + "],";
                }
                cells += "]";
                form.setValue("countries", cells);
            }
        });

        canvas.addChild(form);
        canvas.addChild(countryGrid);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}