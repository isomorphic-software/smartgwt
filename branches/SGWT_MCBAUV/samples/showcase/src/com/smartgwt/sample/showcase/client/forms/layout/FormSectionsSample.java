package com.smartgwt.sample.showcase.client.forms.layout;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormSectionsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Click on \"Stock\" to reveal fields relating to stock on hand."; 

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	FormSectionsSample panel = new FormSectionsSample();
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
        form.setWidth(300);
        
        TextItem itemName = new TextItem();
        itemName.setName("itemName");
        itemName.setTitle("Item");

        TextAreaItem descriptionItem = new TextAreaItem();
        descriptionItem.setName("descriptionItem");
        descriptionItem.setTitle("Description");

        TextItem priceItem = new TextItem();
        priceItem.setType("float");
        priceItem.setName("priceItem");
        priceItem.setTitle("Price");
        priceItem.setDefaultValue("low");

        SectionItem section1 = new SectionItem();
        section1.setDefaultValue("Item");
        section1.setSectionExpanded(true);
        section1.setItemIds("itemName", "descriptionItem", "priceItem");
        
        CheckboxItem inStock = new CheckboxItem();
        inStock.setName("inStock");
        inStock.setTitle("In Stock");
        
        DateItem nextShipment = new DateItem();
        nextShipment.setName("nextShipment");
        nextShipment.setTitle("Next Shipment");
        nextShipment.setUseTextField(true);
        nextShipment.setDefaultValue(256);
        
        SectionItem section2 = new SectionItem();
        section2.setDefaultValue("Stock");
        section2.setSectionExpanded(false);
        section2.setItemIds("inStock", "nextShipment");
        
        form.setFields(section1, itemName, descriptionItem, priceItem, section2, inStock, nextShipment);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}