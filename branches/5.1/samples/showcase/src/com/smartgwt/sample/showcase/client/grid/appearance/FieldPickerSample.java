package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FieldPickerSample extends ShowcasePanel {
    private static final String DESCRIPTION = 
        "   Some grids show a small subset of 100s of available fields.  With this many fields, " +
        "it becomes awkward to choose and arrange fields by drag reordering of " +
        "headers and picking fields from a menu, " + 
        "<P>" + 
        "Enabling the Advanced Field Picker for a grid causes an alternative field " +
        "picking and ordering interface to be used, shown below.  Drag fields from " +
        "<i>Available Fields</i> to <i>Visible Fields</i> to display them.  Use drag and drop to " + 
        "reorder fields as well. " +
        "<P>" +
        "This interface also allows you to search for fields by name, and optionally to choose " +
        "which are frozen. " +
        "<P>" +
        "The end user can open this dialog via the \"Columns..\" menu item in the header menu.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FieldPickerSample panel = new FieldPickerSample();
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

    private ListGridField[] createFields(int fieldCount) {

        ListGridField[] fields = new ListGridField[fieldCount];

        for (int i = 0; i < fields.length; i++) {
            fields[i]= new ListGridField("field" + (i+1), "Field " + (i+1));
        }
        
        return fields;
    }

    private ListGridRecord[] createRecords(int recordCount, ListGridField[] fields) {
        ListGridRecord[] records = new ListGridRecord[recordCount];
        for (int i =0; i < recordCount; i++) {
            ListGridRecord record = new ListGridRecord();
            for (int j = 0; j < fields.length; j++) {
                record.setAttribute("field" + (j+1), "Row " + i + ", Value " + (j+1));
            }
            records[i] = record;
        }
        return records;
    }

    private ListGridField[] getOrderedFields(ListGridField[] fields) {

        ListGridField[] orderedFields = new ListGridField[fields.length];

        int initialFieldIndices[] = { 20, 5, 197, 59, 17, 120, 152, 91, 
                                      37, 101, 40, 9, 174, 29, 163 };
        int oldIndex, newIndex;

        for (newIndex = 0; newIndex < initialFieldIndices.length; newIndex++) {
            int fieldIndex = initialFieldIndices[newIndex] - 1;
            orderedFields[newIndex] = fields[fieldIndex];
            fields[fieldIndex] = null;
        }

        for (oldIndex = 0; oldIndex < fields.length; oldIndex++) {
            ListGridField field = fields[oldIndex];
            if (field != null) {
                orderedFields[newIndex++] = field;
                field.setHidden(true);
            }
        }
        
        return orderedFields;
    }

    public class MyListGrid extends ListGrid {

        public MyListGrid() {
            super();
            
            setID("pickableFields");
            
            setAutoFitData(Autofit.BOTH);
            setAutoFitMaxColumns(8);
            setAutoFitMaxRecords(20);
            setAutoFitFieldWidths(true);
            
            setUseAdvancedFieldPicker(true);
            setFieldPickerFieldProperties("frozen");

            ListGridField[] fields = createFields(200);
            setFields(getOrderedFields(fields));
            setData(createRecords(20, fields));

            Record windowProps = new Record();
            windowProps.setAttribute("isModal", false);
            setAttribute("fieldPickerWindowProperties", windowProps.getJsObj(), true);
        }

        protected String getBaseStyle(ListGridRecord record, int rowNum, int colNum) {
            return colNum % 2 == 0 ? "myEvenGridCell" : "myOddGridCell";
        }
    }

    public Canvas getViewPanel() {

        MyListGrid grid = new MyListGrid();

        Canvas canvas = new Canvas();
        canvas.addChild(grid);
        canvas.draw();

        grid.editFields();

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
