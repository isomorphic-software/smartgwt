package com.smartgwt.sample.showcase.client.forms.dependencies;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.HeaderItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SubmitItem;
import com.smartgwt.client.widgets.UserFormula;
import com.smartgwt.client.widgets.UserSummary;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.types.CharacterCasing;
import com.smartgwt.client.types.ReadOnlyDisplayAppearance;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.StockItemDS;

public class FormFormulaFieldsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>This example demonstrates various formula fields. "+
        "Select an item and edit the purchase quantity to see "+
        "adjusted extended amount. Enter ship-to details to see a text area filled with label facsimile. Finally "+
        "enter the expected number of ship days to recalculate the estimated delivery date. Each of these dynamic "+
        "values is computed on the fly with either a \"formula\" or \"textFormula\" property definition.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            FormFormulaFieldsSample panel = new FormFormulaFieldsSample();
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

        DataSource stockItemDS = StockItemDS.getInstance();
        
        final DynamicForm formOrder = new DynamicForm();
        formOrder.setID("order");
        
        HeaderItem header = new HeaderItem();
        header.setDefaultValue("Select an item for your Order");
        ComboBoxItem itemId  = new ComboBoxItem("itemID");
        itemId.setTitle("Item");
        itemId.setWidth(300);
        itemId.setOptionDataSource(stockItemDS);
        itemId.setValueField("itemID");
        itemId.setDisplayField("description");
        itemId.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                ListGridRecord record = event.getItem().getSelectedRecord();
                if (record != null) formOrder.setValue("price", record.getAttributeAsFloat("price"));
            }
        });
        IntegerItem quantity = new IntegerItem();
        quantity.setName("quantity");
        quantity.setTitle("Quantity");
        quantity.setDefaultValue(1);
        quantity.setValidateOnExit(true);
        FloatItem price = new FloatItem();
        price.setTitle("Price");
        price.setName("price");
        price.setCanEdit(false);
        price.setReadOnlyDisplay(ReadOnlyDisplayAppearance.STATIC);
        price.setFormat("$,##0.00");
        FloatItem extended = new FloatItem();
        extended.setTitle("Extended");
        extended.setName("extended");
        extended.setCanEdit(false);
        extended.setReadOnlyDisplay(ReadOnlyDisplayAppearance.STATIC);
        extended.setFormat("$,##0.00");
        UserFormula formula = new UserFormula();
        formula.setText("price*quantity");
        extended.setFormula(formula);
        
        HeaderItem header1 = new HeaderItem();
        header1.setDefaultValue("Enter ship to details");
        TextItem firstName = new TextItem("firstName");
        firstName.setTitle("First Name");
        TextItem lastName = new TextItem("lastName");
        lastName.setTitle("Last Name");
        TextItem address = new TextItem("address");
        address.setTitle("Address");
        TextItem city = new TextItem("city");
        city.setTitle("City");
        TextItem state = new TextItem("state");
        state.setTitle("State");
        state.setCharacterCasing(CharacterCasing.UPPER);
        state.setLength(2);
        state.setWidth(40);
        IntegerItem zip = new IntegerItem("zip");
        zip.setTitle("Zip Code");
        zip.setLength(5);
        TextAreaItem label = new TextAreaItem();
        label.setTitle("Shipping label");
        label.setWidth(300);
        label.setCanEdit(false);
        UserSummary formulaSummary = new UserSummary();
        formulaSummary.setText("#{firstName} #{lastName}\\n#{address}\\n#{city} #{state} #{zip}");
        label.setTextFormula(formulaSummary);
        
        HeaderItem header2 = new HeaderItem();
        header2.setDefaultValue("Select shipping time");
        IntegerItem shipDays = new IntegerItem("shipDays");
        shipDays.setTitle("Ship Days");
        shipDays.setDefaultValue(2);
        DateItem estDelivery = new DateItem("estDelivery");
        estDelivery.setTitle("Est. Delivery");
        estDelivery.setCanEdit(false);
        estDelivery.setUseTextField(true);
        UserFormula formula1 = new UserFormula();
        formula1.setText("DateAdd(new Date(),'d',shipDays)");
        estDelivery.setFormula(formula1);
        SubmitItem submit = new SubmitItem();
        submit.setTitle("Submit Order");
        
        formOrder.setFields(header, itemId, quantity, price, extended, header1, firstName, 
                            lastName, address, city, state, zip, label, header2, shipDays, estDelivery,
                            submit);
        
        return formOrder;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}