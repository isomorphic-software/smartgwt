package com.smartgwt.sample.showcase.client.combobox;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

import java.util.LinkedHashMap;

public class LocalAndDataboundComboBoxSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Start typing in either field to see a list of matching options. The field labelled \"Item Name\" retrieves options dynamically from the SupplyItem DataSource";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            LocalAndDataboundComboBoxSample panel = new LocalAndDataboundComboBoxSample();
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

        DataSource supplyItemDS = ItemSupplyXmlDS.getInstance();

        final DynamicForm form = new DynamicForm();
        form.setWidth(500);
        form.setNumCols(4);

        ComboBoxItem bugStatusItem = new ComboBoxItem("bugStatus");
        bugStatusItem.setTitle("Bug Status");

        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
        valueMap.put("new", "New");
        valueMap.put("active", "Active");
        valueMap.put("revisit", "Revisit");
        valueMap.put("fixed", "Fixed");
        valueMap.put("delivered", "Delivered");
        valueMap.put("resolved", "Resolved");
        valueMap.put("reopened", "Reopened");

        bugStatusItem.setValueMap(valueMap);


        ComboBoxItem itemName = new ComboBoxItem("itemName");
        itemName.setTitle("Item Name");
        itemName.setPickListWidth(250);
        itemName.setOptionDataSource(supplyItemDS);
        form.setItems(bugStatusItem, itemName);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}