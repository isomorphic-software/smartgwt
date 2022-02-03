package com.smartgwt.sample.showcase.client.combobox;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.HeaderItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.form.fields.events.ChangeEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangeHandler;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class SelectedValueComboBoxSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Open the picker in either form to select the item you want to order from the \"supplyItem\" DataSource.</p>" +
            "<p>The picker on the left stores the \"itemId\" from the related \"supplyItem\" records. The picker on the right stores the \"SKU\" while displaying multiple fields. You can scroll to dynamically load more records. This pattern works with any DataSource.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            SelectedValueComboBoxSample panel = new SelectedValueComboBoxSample();
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

        final Label label = new Label();
        label.setAlign(Alignment.CENTER);
        label.setBorder("1px solid #287fd6");
        label.setHeight(50);
        label.setWidth(250);
        label.setMargin(10);
        label.setContents("Select an item to order");

        DynamicForm form = new DynamicForm();

        HeaderItem headerItem = new HeaderItem();
        headerItem.setDefaultValue("Order Supply Item");

        SelectItem selectItem = new SelectItem();
        selectItem.setDefaultToFirstOption(true); 
        selectItem.setTitle("Item");
        selectItem.setName("itemID");
        selectItem.setDisplayField("itemName");
        selectItem.setPickListWidth(250);
        selectItem.setOptionDataSource(supplyItemDS);
        selectItem.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                label.setContents("Selected itemID : " + event.getValue());
            }
        });

        SpinnerItem spinnerItem = new SpinnerItem();
        spinnerItem.setName("Quantity");
        spinnerItem.setDefaultValue(1);
        spinnerItem.setMin(1);

        form.setItems(headerItem, selectItem, spinnerItem);
        
        VStack vStack1 = new VStack();
        vStack1.setMembersMargin(5);
        vStack1.addMember(form);
        vStack1.addMember(label);
        
        final Label label2 = new Label();
        label2.setAlign(Alignment.CENTER);
        label2.setBorder("1px solid #287fd6");
        label2.setHeight(50);
        label2.setWidth(250);
        label2.setMargin(10);
        label2.setContents("Select an item to order");

        DynamicForm form2 = new DynamicForm();

        HeaderItem headerItem2 = new HeaderItem();
        headerItem2.setDefaultValue("Order Supply Item");

        ListGridField itemField = new ListGridField("itemName");
        ListGridField unitsField = new ListGridField("units");
        ListGridField unitCostField = new ListGridField("unitCost");

        SelectItem selectItem2 = new SelectItem();
        selectItem2.setTitle("Item");
        selectItem2.setOptionDataSource(supplyItemDS);
        selectItem2.setDisplayField("itemName");
        selectItem2.setValueField("SKU");
        selectItem2.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                label2.setContents("Selected Item SKU: " + event.getValue());
            }
        });
        selectItem2.setPickListWidth(450);
        selectItem2.setPickListFields(itemField, unitsField, unitCostField);

        SpinnerItem spinnerItem2 = new SpinnerItem();
        spinnerItem2.setName("Quantity");
        spinnerItem2.setDefaultValue(1);
        spinnerItem2.setMin(1);

        form2.setItems(headerItem2, selectItem2, spinnerItem2);
        
        VStack vStack2 = new VStack();
        vStack2.setMembersMargin(5);
        vStack2.addMember(form2);
        vStack2.addMember(label2);		
        
        LayoutSpacer layoutSpacer = new LayoutSpacer();
        layoutSpacer.setWidth(50);
        
        HStack hStack = new HStack();
        hStack.addMember(vStack1);
        hStack.addMember(layoutSpacer);
        hStack.addMember(vStack2);

        return hStack;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
