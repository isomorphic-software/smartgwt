package com.smartgwt.sample.showcase.client.grid.gridform;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyLocalDS;

public class GridRecordRemoveSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "<p>Click the \"Remove\" button to remove the selected item.</p>" ;

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridRecordRemoveSample panel = new GridRecordRemoveSample();
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

        final ListGrid listGrid = new ListGrid();
        listGrid.setWidth100();
        listGrid.setHeight(200);
        listGrid.setDataSource(dataSource);
        listGrid.setAutoFetchData(true);

        layout.addMember(listGrid);

        IButton button = new IButton("Remove");
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                listGrid.removeSelectedData();
            }
        });
        layout.addMember(button);

        return layout;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}