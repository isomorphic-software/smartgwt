package com.smartgwt.sample.showcase.client.combobox;

import java.util.LinkedHashMap;

import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.PickListMenu;
import com.smartgwt.client.widgets.toolbar.ToolStrip;
import com.smartgwt.client.widgets.toolbar.ToolStripButton;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.types.ListGridComponent;

import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class SelectCustomInlineControlsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click to open the drop-down and notice the \"Check All\" "+
        "and \"Uncheck All\" buttons that have been incorporated above the list of values. "+
        "<p>"+
        "SelectItem and ComboBoxItem both allow additional controls to be added to the drop-down list.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            SelectCustomInlineControlsSample panel = new SelectCustomInlineControlsSample();
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
		
		SelectItem multipleSelect = new SelectItem("multipleSelect");
		multipleSelect.setTitle("Select items");
		multipleSelect.setOptionDataSource(ItemSupplyXmlDS.getInstance());

		Criteria criteria = new Criteria();
		criteria.addCriteria("units", "Set");
		multipleSelect.setOptionCriteria(criteria);
		multipleSelect.setDisplayField("SKU");
		multipleSelect.setValueField("itemID");
		multipleSelect.setPickListWidth(400);
		
		ListGridField skuField = new ListGridField("SKU", "SKU");
		ListGridField itemNameField = new ListGridField("itemName", "Item Name");
		multipleSelect.setPickListFields(skuField, itemNameField);
		multipleSelect.setMultiple(true);
		
		ToolStrip toolStrip = new ToolStrip();
		toolStrip.setHeight(30);
		toolStrip.setWidth100();
		
		ToolStripButton checkAllButton = new ToolStripButton();
		checkAllButton.setWidth("50%");
		checkAllButton.setTitle("Check All");
		checkAllButton.setIcon("[SKIN]/actions/approve.png");
		checkAllButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SelectItem selectItem = (SelectItem)form.getField("multipleSelect");
				ListGridRecord records[] = selectItem.getClientPickListData();
				String[] values = new String[records.length];
				for (int i = 0; i < records.length; i++) {
				    values[i] = records[i].getAttributeAsString("itemID");
				}
				selectItem.setValues(values);
				PickListMenu pickList = (PickListMenu)selectItem.getCanvasAutoChild("pickList");
				pickList.hide();
			}
		});
		ToolStripButton checkNoneButton = new ToolStripButton();
		checkNoneButton.setWidth("50%");
		checkNoneButton.setTitle("Uncheck All");
		checkNoneButton.setIcon("[SKIN]/actions/close.png");
		checkNoneButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SelectItem selectItem = (SelectItem)form.getField("multipleSelect");
				selectItem.setValues(new String[0]);
				PickListMenu pickList = (PickListMenu)selectItem.getCanvasAutoChild("pickList");
				pickList.hide();
			}
		});
		toolStrip.addMember(checkAllButton);
		toolStrip.addMember(checkNoneButton);
		
		ListGrid pickListProperties = new ListGrid();
		pickListProperties.setGridComponents(toolStrip, ListGridComponent.HEADER, ListGridComponent.BODY);
		multipleSelect.setPickListProperties(pickListProperties);

		form.setFields(multipleSelect);

		return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}

