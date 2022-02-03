package com.smartgwt.sample.showcase.client.combobox;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class DropdownListGridSample extends ShowcasePanel {

    private static final String DESCRIPTION = "The SelectItem displays multiple fields in a ListGrid. You can scroll " +
            "to dynamically load more records. This pattern works with any DataSource.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            DropdownListGridSample panel = new DropdownListGridSample();
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
        form.setWidth(300);

        ListGridField itemField = new ListGridField("itemName");
        ListGridField unitsField = new ListGridField("units");
        ListGridField unitCostField = new ListGridField("unitCost");

        SelectItem item = new SelectItem("itemID");
        item.setWidth(240);
        item.setTitle("Item");
        item.setOptionDataSource(supplyItemDS);
        item.setValueField("SKU");
        item.setDisplayField("itemName");
        item.setPickListWidth(450);
        item.setPickListFields(itemField, unitsField, unitCostField);

        form.setItems(item);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}