package com.smartgwt.sample.showcase.client.combobox;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS; 

public class DropdownTreeSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Dropdowns support tree data models, including load-on-demand as "+
        "users explore the tree.<p>Tree dropdowns can also support multiple columns.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            DropdownTreeSample panel = new DropdownTreeSample();
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
        form.setWidth(500);

        ListGridField nameField = new ListGridField("Name");
        ListGridField emailField = new ListGridField("Email");

        ListGrid pickListProperties = new ListGrid();
        pickListProperties.setAutoFitFieldWidths(true);
        
        SelectItem item = new SelectItem("manager");
        item.setTitle("Choose Manager");
        item.setOptionDataSource(ds);
        item.setDataSetType("tree");
        item.setAutoOpenTree("all");
        item.setValueField("Name");
        item.setWrapTitle(false);
        item.setPickListWidth(350);
        item.setPickListFields(nameField, emailField);
        item.setPickListProperties(pickListProperties); 

        form.setItems(item);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}