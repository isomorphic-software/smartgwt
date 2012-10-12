package com.smartgwt.sample.showcase.client.grid.sortfilter;

import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.FilterBuilder;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class GridBigFilterSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>When a FilterBuilder must work with a very large number of fields, you can set " +
            "FilterBuilder.fieldDataSource to a DataSource containing records that represent the fields to display in the " +
            "FieldPickers in each clause. The FilterBuilder below is created without a normal DataSource, but specifies a " +
            "fieldDataSource and the FieldPicker items in each clause are populated dynamically with it's records. " +
            "In this mode, the FieldPickers are represented by ComboBoxItems, rather than SelectItems, and have default settings " +
            "that provide type-ahead auto-completion.<p>" +
            "<p>Note also that, when fieldDataSource is specified and the operator for a clause is of a type that uses a field-lookup, " +
            "the valueField is also populated dynamically by the fieldDataSource.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridBigFilterSample panel = new GridBigFilterSample();
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

        ListGridRecord testData[] = new ListGridRecord[200];

        for(int i=0;i<200;i++)
        {
            ListGridRecord record = new ListGridRecord();
            record.setAttribute("name", "field" + i);
            record.setAttribute("title", "Field " + i);
            record.setAttribute("type", "text");
            testData[i] = record;
        }

        DataSource bigFilterDS = new DataSource();
        bigFilterDS.setClientOnly(true);

        DataSourceTextField nameField = new DataSourceTextField("name");
        DataSourceTextField titleField = new DataSourceTextField("title");
        DataSourceTextField typeField = new DataSourceTextField("type");

        bigFilterDS.setFields(nameField, titleField, typeField);
        bigFilterDS.setTestData(testData);

        FilterBuilder filterBuilder = new FilterBuilder();
        filterBuilder.setFieldDataSource(bigFilterDS);


        AdvancedCriteria criteria = new AdvancedCriteria(OperatorId.AND, new AdvancedCriteria[] {
                new AdvancedCriteria("field2", OperatorId.ISTARTS_WITH, "C"),
                new AdvancedCriteria(OperatorId.OR, new AdvancedCriteria[] {
                    new AdvancedCriteria("field73", OperatorId.NOT_EQUAL_FIELD, "field191"),
                    new AdvancedCriteria("field130", OperatorId.ICONTAINS, "B")
                })
        });

        filterBuilder.setCriteria(criteria);

        SelectItem formItemProperties = new SelectItem();

        formItemProperties.setShowPickerIcon(false);
        //filterBuilder.setFieldPickerProperties(formItemProperties);

        return filterBuilder;

    }

    public String getIntro() {
        return DESCRIPTION;
    }
}