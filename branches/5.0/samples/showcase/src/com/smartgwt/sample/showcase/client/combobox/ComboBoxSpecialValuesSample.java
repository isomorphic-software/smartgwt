package com.smartgwt.sample.showcase.client.combobox;

import java.util.LinkedHashMap;

import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.Canvas;

import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class ComboBoxSpecialValuesSample extends ShowcasePanel {
    private static final String DESCRIPTION = " Sometimes a list of options needs to contain special values like \"All\", \"None\" "
        + " or \"Not Applicable\" that aren't present in the data stored in a DataSource. "
        + "<p>"
        + "Open the ComboBoxItem and SelectItem below to see special values shown in a separate area above the options list. "
        + "The normal supplyItem sample DataSource is being used here as the source or options, and the special values did not "
        + "need to be added to the DataSource data. Also, loading data on demand works as normal - just scroll to load more rows."
        + "<p>"
        + "Type a search string into the ComboBox and note that the special values remain visible at the top of the list. ";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ComboBoxSpecialValuesSample panel = new ComboBoxSpecialValuesSample();
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
		form.setNumCols(4);
		
		SelectItem selectItem = new SelectItem();
		selectItem.setOptionDataSource(ItemSupplyXmlDS.getInstance());
		selectItem.setDisplayField("itemName");
		selectItem.setValueField("itemID");
		selectItem.setPickListWidth(300);
		selectItem.setName("filteredSelect");
		selectItem.setTitle("Choose an item (Select)");
		
		ListGrid pickListProperties = new ListGrid();
		pickListProperties.setShowFilterEditor(true);
		selectItem.setPickListProperties(pickListProperties);
		ListGridField skuField = new ListGridField("SKU");
		ListGridField itemNameField = new ListGridField("itemName");
		selectItem.setPickListFields(skuField, itemNameField);
		LinkedHashMap<String,String> hashMap = new LinkedHashMap<String,String>();
		hashMap.put("**EmptyValue**", "None");
		hashMap.put("-1", "Not Applicable");
		selectItem.setSpecialValues(hashMap);
		selectItem.setSeparateSpecialValues(true);

		ComboBoxItem comboBoxItem = new ComboBoxItem();
		comboBoxItem.setName("filteredCombo");
		comboBoxItem.setTitle("Choose an item (ComboBox)");
		comboBoxItem.setAddUnknownValues(false);
		comboBoxItem.setOptionDataSource(ItemSupplyXmlDS.getInstance());
		comboBoxItem.setDisplayField("itemName");
		comboBoxItem.setValueField("itemID");
		comboBoxItem.setPickListWidth(300);
		comboBoxItem.setPickListFields(skuField, itemNameField);
		comboBoxItem.setSpecialValues(hashMap);
		comboBoxItem.setSeparateSpecialValues(true);
		
		form.setFields(selectItem, comboBoxItem);
		
		return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}

