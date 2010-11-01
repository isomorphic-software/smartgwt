package com.smartgwt.sample.showcase.client.grid.gridform;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyLocalDS;

public class GridFormAddSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "<p>Use the form to create a new stock item. Create an item in the currently shown category to see it appear in the filtered listing automatically.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridFormAddSample panel = new GridFormAddSample();
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

        VLayout layout = new VLayout(15);

        Label label = new Label();
        label.setHeight(10);
        label.setWidth100();
        label.setContents("Showing items in Category 'Rollfix Glue");
        layout.addMember(label);

        final DataSource dataSource = ItemSupplyLocalDS.getInstance();

        ListGrid listGrid = new ListGrid();
        listGrid.setWidth100();
        listGrid.setHeight(200);
        listGrid.setDataSource(dataSource);
        listGrid.setAutoFetchData(true);
        layout.addMember(listGrid);

        final DynamicForm form = new DynamicForm();
        form.setNumCols(4);
        form.setDataSource(dataSource);

        form.setValue("category", "Rollfix Glue");
        form.setValue("itemName", "[Enter Item Name]");
        form.setValue("SKU", "[SKU]");
        form.setValue("unitCoset", "[Enter Price]");

        layout.addMember(form);

        IButton button = new IButton("Save New");
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                form.saveData(new DSCallback() {
                        public void execute(DSResponse response, Object rawData, DSRequest request) {
                              form.editNewRecord();
                        }
                    });
                form.reset();
            }
        });
        layout.addMember(button);

        return layout;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}