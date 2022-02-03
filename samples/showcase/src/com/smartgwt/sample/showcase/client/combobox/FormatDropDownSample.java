package com.smartgwt.sample.showcase.client.combobox;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;

public class FormatDropDownSample extends ShowcasePanel {

    private static final String DESCRIPTION = "The SelectItem displays multiple fields in a ListGrid. You can scroll " +
            "to dynamically load more records. This pattern works with any DataSource.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
        	FormatDropDownSample panel = new FormatDropDownSample();
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
        DataSource ds = EmployeeXmlDS.getInstance();

        final DynamicForm form = new DynamicForm();
        form.setWidth(300);
        
        SelectItem item = new SelectItem();
        item.setTitle("Employee");
        item.setOptionDataSource(ds);
        item.setValueField("EmployeeId");
        item.setDisplayField("Name");
        
        ListGridField f = new ListGridField("Name");
        f.setCellFormatter(new CellFormatter() {
        	public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
        		return record.getAttribute("Name") + " (" + record.getAttribute("Email") + ")";
        	}
        });
        item.setPickListFields(f);
        
        item.setWidth(250);
        item.setPickListWidth(250);
        form.setItems(item);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}