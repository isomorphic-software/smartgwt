package com.smartgwt.sample.showcase.client.forms.dependencies;

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.data.SupplyCategoryXmlDS;

public class FormDataboundDependentSelectsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>This example demonstrates two select items, both of which load data on the fly from a DataSource, " +
            "where the \"Category\" drop-down controls the list of available items in the \"Item\" drop-down.</p>" +
            "<p>Try selecting a value in the \"Category\" drop-down list to change the set of options available in the \"Item\" drop-down.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FormDataboundDependentSelectsSample panel = new FormDataboundDependentSelectsSample();
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

        final DynamicForm form = new DynamicForm();
        form.setWidth(500);
        form.setNumCols(4);

        DataSource itemSupplyDS = ItemSupplyXmlDS.getInstance();
        DataSource supplyCategoryDS = SupplyCategoryXmlDS.getInstance();

        final SelectItem categoryItem = new SelectItem();
        categoryItem.setName("categoryName");
        categoryItem.setPickListWidth(210);
        categoryItem.setTitle("Category");
        categoryItem.setOptionDataSource(supplyCategoryDS);

        categoryItem.addChangedHandler(new ChangedHandler() {
            public void onChanged(ChangedEvent event) {
                form.clearValue("itemName");
            }
        });

        SelectItem itemName = new SelectItem() {
            @Override
            protected Criteria getPickListFilterCriteria() {
                String category = (String) categoryItem.getValue();
                Criteria criteria = new Criteria("category", category);
                return criteria;
            }
        };
        itemName.setName("itemName");
        itemName.setTitle("Item");
        itemName.setPickListWidth(250);        
        itemName.setOptionDataSource(itemSupplyDS);

        

        form.setItems(categoryItem, itemName);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}