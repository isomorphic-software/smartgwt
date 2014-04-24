package com.smartgwt.sample.showcase.client.mobile;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class MobileSelectListSample extends ShowcasePanel {
    private static final String DESCRIPTION = "The SelectItem supports a full screen mode to make best use of the limited space "+
    "available on mobile devices.  This mode is automatically enabled for handset / phone-sized devices, "+
    "but can be enabled for any size device, and is enabled for every kind of device in this sample. "+
    "<p>"+
    "Full screen mode supports all the same features as normal select - binding to DataSources, "+
    "data paging, multi-field display and search, etc.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            MobileSelectListSample panel = new MobileSelectListSample();
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

		SelectItem filteredSelect = new SelectItem();
		filteredSelect.setName("filteredSelect");
		filteredSelect.setTitle("Select Item");
		filteredSelect.setOptionDataSource(ItemSupplyXmlDS.getInstance());
		filteredSelect.setDisplayField("itemName");
		filteredSelect.setValueField("SKU");
		filteredSelect.setPickListPlacement("fillScreen");
		filteredSelect.setPickListWidth(300);
		ListGrid pickListGridProperties = new ListGrid();
		pickListGridProperties.setShowFilterEditor(true);
		filteredSelect.setPickListProperties(pickListGridProperties);
		ListGridField skuField = new ListGridField("SKU", "SKU");
     	ListGridField itemNameField = new ListGridField("itemName", "Item Name");
     	filteredSelect.setPickListFields(skuField, itemNameField);
        
        form.setFields(filteredSelect);
        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
