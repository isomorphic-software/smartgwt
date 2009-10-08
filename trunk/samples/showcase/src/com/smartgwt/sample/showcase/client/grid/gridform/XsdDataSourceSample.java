package com.smartgwt.sample.showcase.client.grid.gridform;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.SchemaSet;
import com.smartgwt.client.data.XMLTools;
import com.smartgwt.client.data.XSDLoadCallback;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemRecord;

public class XsdDataSourceSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "<p>Click \"Load Schema\" to load a supplyItem DataSource from XML Schema (XSD) format, then extend that schema with " +
                    "Smart GWT-specific presentation attributes, and bind the Grid and Form to it.</p>" +
                    "<p>Note that the internal \"itemId\" field has been hidden from the user, some fields have been retitled, " +
                    "and default editors overriden.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            XsdDataSourceSample panel = new XsdDataSourceSample();
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

        final ListGrid listGrid = new ListGrid();
        listGrid.setCanEdit(true);

        final DynamicForm dynamicForm = new DynamicForm();

        final IButton validateButton = new IButton("Validate");
        validateButton.setDisabled(true);

        validateButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                dynamicForm.validate();

            }
        });

        IButton loadButton = new IButton("Load Schema");
        loadButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                XMLTools.loadXMLSchema("data/dataIntegration/xml/supplyItem.xsd", new XSDLoadCallback() {
                    public void execute(SchemaSet schemaSet) {
                        loadXMLSchemaReply(schemaSet, listGrid, dynamicForm, validateButton);
                    }
                });
            }
        });

        VLayout layout = new VLayout(15);
        layout.addMember(loadButton);
        layout.addMember(listGrid);
        layout.addMember(dynamicForm);
        layout.addMember(validateButton);

        return layout;
    }

    private void loadXMLSchemaReply(SchemaSet schemaSet, ListGrid listGrid, DynamicForm dynamicForm, IButton validateButton) {
        DataSource schemaDS = schemaSet.getSchema("supplyItem");

        DataSource dataSource = new DataSource();
        dataSource.setInheritsFrom(schemaDS);
        dataSource.setUseParentFieldOrder(true);

        DataSourceTextField itemID = new DataSourceTextField("itemId");
        itemID.setHidden(true);
        itemID.setPrimaryKey(true);

        DataSourceTextField itemName = new DataSourceTextField("itemName", "item name");
        DataSourceDateField nextShipment = new DataSourceDateField("nextShipment", "next shipment");
        nextShipment.setUseTextField(true);

        dataSource.setFields(itemID, itemName, nextShipment);

        listGrid.setDataSource(dataSource);
        dynamicForm.setDataSource(dataSource);

        // to demonstrate grid editors, add sample data and start editing

        listGrid.setData(new ItemRecord[]{new ItemRecord(123, "Sample Item", "1091600", null, "Rollfix Glue", "Ea", 3.73, null, null)});
        listGrid.startEditing();

        // to demonstrate validation, use values that will fail validation
        dynamicForm.setValue("unitCost", -1.234);
        dynamicForm.setValue("SKU", "thisSkuIsWayTooLong");
        validateButton.enable();

    }


    public String getIntro() {
        return DESCRIPTION;
    }
}