package com.smartgwt.sample.showcase.client.combobox;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class MultiFieldSearchSample extends ShowcasePanel {
    private static final String DESCRIPTION =
    	"<p>Click on the SelectItem on the left to see the full set of data. "+
    	"You can enter filter criteria directly on the drop-down list in either field "+
    	"to filter the set of options down to a managable size.</p>"+
    	"<p>Now move focus to the ComboBoxItem and start typing. The set of options "+
    	"displayed are automatically filtered against both fields as you type. "+
    	"Tab or Enter keypress will complete selection.</p>";

    public static class Factory implements PanelFactory {
    	private String id;

		public Canvas create() {
			MultiFieldSearchSample panel = new MultiFieldSearchSample();
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
    
    public boolean isTopIntro() {
    	return true;
    }

    public Canvas getViewPanel() {
		DataSource supplyItemDS = ItemSupplyXmlDS.getInstance();
		
		final DynamicForm form = new DynamicForm();
		form.setWidth(500);
		form.setNumCols(4);
		
		ListGrid pickListProperties = new ListGrid();
		pickListProperties.setShowFilterEditor(true);
		
		ListGridField skuField = new ListGridField("SKU");
		ListGridField itemNameField = new ListGridField("itemName");
		
		SelectItem filteredSelect = new SelectItem("filteredSelect");
		filteredSelect.setTitle("Item (Select)");
		filteredSelect.setOptionDataSource(supplyItemDS);
		filteredSelect.setDisplayField("itemName");
		filteredSelect.setValueField("SKU");
		filteredSelect.setPickListWidth(300);
		filteredSelect.setPickListFields(skuField, itemNameField);
		filteredSelect.setPickListProperties(pickListProperties);
		
		ComboBoxItem filteredCombo = new ComboBoxItem("filteredCombo");
		filteredCombo.setTitle("Item (ComboBox)");
		filteredCombo.setAddUnknownValues(true);
		filteredCombo.setOptionDataSource(supplyItemDS);
		filteredCombo.setDisplayField("itemName");
		filteredCombo.setValueField("SKU");
		filteredCombo.setPickListWidth(300);
		filteredCombo.setPickListFields(skuField, itemNameField);
		filteredCombo.setPickListProperties(pickListProperties);
		
		form.setItems(filteredSelect, filteredCombo);
		return form;
    }

    public String getIntro() {
    	return DESCRIPTION;
    }
}
