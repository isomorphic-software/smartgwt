package com.smartgwt.sample.showcase.client.forms.layout;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

import java.util.HashMap;

public class FormSplittingSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click \"Submit\" to jump to a validation error in " + 
    		"the \"Stock\" tab. Forms which are split for layout purposes can behave like a " + 
    		"single logical form for validation and saves.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FormSplittingSample panel = new FormSplittingSample();
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
        final ValuesManager vm = new ValuesManager();


        
        final TabSet theTabs = new TabSet();
        theTabs.setWidth(400);
        theTabs.setHeight(250);
        
        Tab item = new Tab();
        item.setTitle("Item");
        
        final DynamicForm form0 = new DynamicForm();
        form0.setID("form0");
        form0.setValuesManager(vm);
        
        TextItem itemName = new TextItem();
        itemName.setName("itemName");
        itemName.setTitle("Item");
        
        TextAreaItem description = new TextAreaItem();
        description.setName("description");
        description.setTitle("Description");
        
        FloatItem price = new FloatItem();
        price.setName("price");
        price.setTitle("Price");
        price.setDefaultValue("low");
        
        form0.setFields(itemName, description, price);
        item.setPane(form0);

        Tab stock = new Tab();
        stock.setTitle("Stock");
        
        final DynamicForm form1 = new DynamicForm();
        form1.setID("form1");
        form1.setValuesManager(vm);
        
        CheckboxItem inStock = new CheckboxItem();
        inStock.setName("inStock");
        inStock.setTitle("In Stock");
        
        DateItem nextShipment = new DateItem();
        nextShipment.setName("nextShipment");
        nextShipment.setTitle("Next Shipment");
        nextShipment.setUseTextField(true);
        
        form1.setFields(inStock, nextShipment);
        stock.setPane(form1);
        
        theTabs.setTabs(item, stock);
        
        IButton submit = new IButton();
        submit.setTitle("Submit");
        submit.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				vm.validate();
				if (form1.hasErrors()) {
					theTabs.selectTab(1);
				} else {
					theTabs.selectTab(0);
				}
			}
        });
        
        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(10);
        vLayout.addMember(theTabs);
        vLayout.addMember(submit);

        vm.setValues(new HashMap<String,String>() {{
            put("price", "low");
            put("nextShipment", "256");
        }});
        return vLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}