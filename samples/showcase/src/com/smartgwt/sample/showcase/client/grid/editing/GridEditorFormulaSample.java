package com.smartgwt.sample.showcase.client.grid.editing;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FloatItem;
import com.smartgwt.client.widgets.UserFormula;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.OrderItemLocalDS;

public class GridEditorFormulaSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>This example demonstrates a grid editorFormula "+
        "field. Select an item and edit the cost to see the price calculated from the cost and separate "+
        "markup percent. Price can also be entered to override the calculation. Note that the cost is not saved.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridEditorFormulaSample panel = new GridEditorFormulaSample();
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

        DataSource itemLocalDS = OrderItemLocalDS.getInstance();
        
        DynamicForm form = new DynamicForm();
        form.setID("form");
        form.setWidth(500);
        
        FloatItem markupItem = new FloatItem("markup");
        markupItem.setTitle("Markup percent");
        markupItem.setWrapTitle(false);
        markupItem.setFormat("0.0#%");
        markupItem.setDefaultValue(0.10);
        
        form.setFields(markupItem);
		
        ListGrid itemList = new ListGrid();
        itemList.setWidth(600);
        itemList.setHeight(525);
        itemList.setAlternateRecordStyles(true);
        itemList.setAutoFetchData(true);
        itemList.setDataSource(itemLocalDS);
        itemList.setCanEdit(true);
        itemList.setEditEvent(ListGridEditEvent.CLICK);
        itemList.setShowAllRecords(true);
		
        ListGridField orderID = new ListGridField("orderID", "Order ID");
        orderID.setIncludeInRecordSummary(false);
        ListGridField itemDescription = new ListGridField("itemDescription");
        ListGridField category = new ListGridField("category");
        ListGridField shipDate = new ListGridField("shipDate");
        ListGridField quantity = new ListGridField("quantity");
        ListGridField unitCost = new ListGridField("unitCost", "Cost");
        unitCost.setType(ListGridFieldType.FLOAT);
        ListGridField unitPrice = new ListGridField("unitPrice", "Price");
        unitPrice.setType(ListGridFieldType.FLOAT);
        unitPrice.setFormat("$,0.00");
        UserFormula formula = new UserFormula();
        formula.setText("unitCost+unitCost*form.values.markup");
        unitPrice.setEditorFormula(formula);

        itemList.setFields(orderID,itemDescription,category,shipDate,quantity,unitCost,unitPrice);
		
        VLayout vLayout = new VLayout();
        vLayout.setMembersMargin(15);
        vLayout.addMember(form);
        vLayout.addMember(itemList);
		
        return vLayout;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}