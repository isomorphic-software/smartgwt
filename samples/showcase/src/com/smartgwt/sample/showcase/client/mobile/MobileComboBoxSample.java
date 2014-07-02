package com.smartgwt.sample.showcase.client.mobile;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class MobileComboBoxSample extends ShowcasePanel {
    private static final String DESCRIPTION = "The ComboBoxItem supports a full screen mode to make best use " +
    "of the limited space available on mobile devices. This mode is automatically enabled for handset / phone-sized " +
    "devices, but can be enabled for any size device, and is enabled for every kind of device in this sample. " +
    "<p>" +
    "Full screen mode supports all the same features as normal ComboBoxItem - binding to DataSources, "+
    "data paging, multi-field display and search, etc.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            MobileComboBoxSample panel = new MobileComboBoxSample();
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
        DynamicForm form = new DynamicForm();
		form.setWidth(500);

		ComboBoxItem filteredCombo = new ComboBoxItem();
		filteredCombo.setName("filteredCombo");
		filteredCombo.setTitle("Select Item");
		filteredCombo.setAddUnknownValues(false);
		filteredCombo.setOptionDataSource(ItemSupplyXmlDS.getInstance());
		filteredCombo.setDisplayField("itemName");
		filteredCombo.setValueField("SKU");
		filteredCombo.setPickListPlacement("fillScreen");
		filteredCombo.setPickListWidth(300);
		ListGridField skuField = new ListGridField("SKU", "SKU");
     	ListGridField itemNameField = new ListGridField("itemName", "Item Name");
     	filteredCombo.setPickListFields(skuField, itemNameField);
        
        form.setFields(filteredCombo);
        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
