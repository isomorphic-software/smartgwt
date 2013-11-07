package com.smartgwt.sample.showcase.client.combobox;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.FormItemValueFormatter;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;

public class FormatRelatedValueSample extends ShowcasePanel {

    private static final String DESCRIPTION = "The SelectItem displays multiple fields in a ListGrid. "+
    	"You can scroll to dynamically load more records. This pattern works with any DataSource. " + 
        "When a value formatter is installed on a ComboBoxItem, setFormatOnBlur(true) causes the " + 
        "formatting to be applied only when the item does not have focus - formatting is removed when the item receives focus.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	FormatRelatedValueSample panel = new FormatRelatedValueSample();
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
        item.setPickListFields(new ListGridField("Name"), new ListGridField("Email"));
        item.setWidth(250);
        item.setPickListWidth(250);
        item.setValueFormatter(new FormItemValueFormatter() {
        	public String formatValue(Object value, Record record, DynamicForm form, FormItem item) {
        		ListGridRecord r = item.getSelectedRecord();
        		if (r == null) return "";
        		return r.getAttribute("Name") + " (" + r.getAttribute("Email") + ")";
        	}
        });
        
        ComboBoxItem otherItem = new ComboBoxItem();
        otherItem.setTitle("Employee");
        otherItem.setOptionDataSource(ds);
        otherItem.setValueField("EmployeeId");
        otherItem.setDisplayField("Name");
        otherItem.setPickListFields(new ListGridField("Name"), new ListGridField("Email"));
        otherItem.setWidth(250);
        otherItem.setPickListWidth(350);
        otherItem.setFormatOnBlur(true);
        otherItem.setValueFormatter(new FormItemValueFormatter() {
        	public String formatValue(Object value, Record record, DynamicForm form, FormItem item) {
        		ListGridRecord r = item.getSelectedRecord();
        		if (r == null) return "";
        		return r.getAttribute("Name") + " (" + r.getAttribute("Email") + ")";
        	}
        });
        form.setItems(item, otherItem);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}