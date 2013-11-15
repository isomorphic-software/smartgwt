package com.smartgwt.sample.showcase.client.grid.excel;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.TextImportSettings;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Visibility;
import com.smartgwt.client.types.EscapingMode;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Dialog;
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
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class ExcelToGridSample extends ShowcasePanel 
    implements ClickHandler  {

    private static final String DESCRIPTION = "<p>Open an Excel" +
        " spreadsheet, select some cells, and use Ctrl-C to copy them." +
        " Click the <b>Paste Cells</b> button to open a dialog where" +
        " you can paste the data.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ExcelToGridSample panel = new ExcelToGridSample();
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
            String text = (String) this.textArea.getValue();
            ExcelToGridSample.this.pasteText(text);
            this.removeItem(this.form);
            this.markForDestroy();
            this.hide();
        };

        public MyDialog() {
            
            final int WIDTH = 525;
            final int HEIGHT = 300;

            final String GUIDANCE = "Press Ctrl-V (Command-V on Mac) or right click (Option-click on Mac) to paste values, then hit \"Apply\"";

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
            button.setName("apply");
            button.setAlign(Alignment.CENTER);
            button.setTitle("Apply");
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
            this.setTitle("Paste Cells");
            this.setShowModalMask(true);
            this.setIsModal(true);
            this.addItem(form);
        }
    };

    public void onClick(ClickEvent event) {
        this.new MyDialog().draw();      
    };

    private void pasteText(String text) {
        ArrayList<String> fieldNames = new ArrayList<String>();

        int[][] cells = this.countryList.getCellSelection().getSelectedCells();
        if (cells.length == 0) {
            countryList.getCellSelection().selectCell(0, 0);
            cells = countryList.getCellSelection().getSelectedCells();
        }
        int firstCol = cells[0][1];
        ListGridField[] fields = this.countryList.getFields();
        for (int col = firstCol; col < fields.length; col++) {
            fieldNames.add(this.countryList.getFieldName(col));
        }
        TextImportSettings settings = new TextImportSettings();
        settings.setFieldList(fieldNames.toArray(new String[0]));
        settings.setFieldSeparator("\t");
        settings.setEscapingMode(EscapingMode.DOUBLE);

        DataSource dataSource = this.countryList.getDataSource();
        Record[] records = dataSource.recordsFromText(text, settings);
        this.countryList.applyRecordData(new RecordList(records));
    };

    
    public Canvas getViewPanel() {
        DataSource dataSource = CountryXmlDS.getInstance();

        final ListGrid grid = new ListGrid();
        grid.setCanEdit(true);
        grid.setAutoFetchData(true);
        grid.setCanDragSelect(true);
        grid.setCanSelectCells(true);
        grid.setDataSource(dataSource);
        grid.setAutoFitData(Autofit.VERTICAL);
        grid.fetchData(null, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data,
                    DSRequest dsRequest) {
                grid.getCellSelection().selectCell(0, 0);
            }
        });
        this.countryList = grid;

        Button button = new Button();
        button.setTitle("Paste Cells");
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

