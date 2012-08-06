package com.smartgwt.sample.showcase.client.grid.excel;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.TextExportSettings;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.types.EscapingMode;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Dialog;
import com.smartgwt.client.widgets.menu.Menu;
import com.smartgwt.client.widgets.menu.MenuItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.CellSelection;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.grid.events.CellContextClickEvent;
import com.smartgwt.client.widgets.menu.events.MenuItemClickEvent;

import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GridToExcelSample extends ShowcasePanel 

    implements ClickHandler,
               com.smartgwt.client.widgets.menu.events.ClickHandler {

    private static final String DESCRIPTION = "<p>Click and drag to select cells," +
        " then either right-click or press the <b>Copy</b> button to bring up a" +
        " dialog that can be used to copy and paste values to an Excel spreadsheet</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridToExcelSample panel = new GridToExcelSample();
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

    private ListGrid countryList;

    private class MyDialog extends Dialog implements 

        com.smartgwt.client.widgets.form.fields.events.ClickHandler {

        private DynamicForm form;

        private TextAreaItem textArea;

        public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
            this.removeItem(this.form);
            this.markForDestroy();
            this.hide();
        };

        public MyDialog() {
            
            final int WIDTH = 525;
            final int HEIGHT = 300;

            final String GUIDANCE = "Press Ctrl-C (Command-C on Mac) or right click (Option-click on Mac) on the selected text to copy values, then paste into Excel.  Note that values in columns that are dates or numbers are correctly understood as dates and numbers in Excel.";

            int[][] cells = countryList.getCellSelection().getSelectedCells();
            if (cells == null || cells.length == 0) return;

            ArrayList<String> fieldNames = new ArrayList<String>();

            int firstRow = cells[0][0];
            for (int i = 0; i < cells.length; i++) {
                if (cells[i][0] != firstRow) break;
                fieldNames.add(countryList.getFieldName(cells[i][1]));
            }

            TextExportSettings settings = new TextExportSettings();
            settings.setFieldList(fieldNames.toArray(new String[0]));
            settings.setFieldSeparator("\t");
            settings.setEscapingMode(EscapingMode.DOUBLE);

            StaticTextItem label = new StaticTextItem();
            label.setName("label");
            label.setShowTitle(false);
            label.setValue(GUIDANCE);

            TextAreaItem area = new TextAreaItem();
            area.setName("textArea");
            area.setShowTitle(false);
            area.setCanEdit(true);
            area.setHeight("*");
            area.setWidth("*");
            this.textArea = area;

            ButtonItem button = new ButtonItem();
            button.setName("done");
            button.setAlign(Alignment.CENTER);
            button.setTitle("Done");
            button.addClickHandler(this);
        
            DynamicForm form = new DynamicForm();
            form.setNumCols(1);
            form.setWidth(WIDTH);
            form.setHeight(HEIGHT);
            form.setAutoFocus(true);
            form.setFields(new FormItem[]{ label, this.textArea, button });
            this.form = form;

            this.setAutoSize(true);
            this.setShowToolbar(false);
            this.setCanDragReposition(true);
            this.setTitle("Copy Cells");
            this.setShowModalMask(true);
            this.setIsModal(true);
            this.addItem(form);

            DataSource dataSource = countryList.getDataSource();
            Record[] records = countryList.getSelectedRecords();
            String text = dataSource.recordsAsText(records, settings);

            this.textArea.setValue(text);
            this.textArea.selectValue();
        }
    };

    public void onClick(ClickEvent event) {
        this.new MyDialog().draw();
    }
    public void onClick(MenuItemClickEvent event) {
        this.new MyDialog().draw();
    }

    public void onCellContextClick(CellContextClickEvent event) {
        Menu menu = this.countryList.getContextMenu();
        menu.showContextMenu();
    }

    public Canvas getViewPanel() {
        DataSource dataSource = CountryXmlDS.getInstance();

        MenuItem item = new MenuItem("Copy");
        item.addClickHandler(this);

        Menu menu = new Menu();
        menu.setWidth(150);
        menu.addItem(item);

        ListGrid grid = new ListGrid();
        grid.setCanEdit(true);
        grid.setAutoFetchData(true);
        grid.setCanDragSelect(true);
        grid.setCanSelectCells(true);
        grid.setDataSource(dataSource);
        grid.setAutoFitData(Autofit.VERTICAL);
        grid.setContextMenu(menu);

        this.countryList = grid;

        Button button = new Button();
        button.setTitle("Copy Cells");
        button.addClickHandler(this);

        VLayout layout = new VLayout(15);
        layout.addMember(grid);
        layout.addMember(button);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
};

