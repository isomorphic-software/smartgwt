package com.smartgwt.sample.showcase.client.grid.gridform;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyLocalDS;

public class GridFormUpdateSample extends ShowcasePanel {

    private static final String DESCRIPTION =
            "<p>Select an item and use the form to change its price. The list updates automatically.</p>" ;

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridFormUpdateSample panel = new GridFormUpdateSample();
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

        final DynamicForm form = new DynamicForm();
        form.setIsGroup(true);
        form.setGroupTitle("Update");
        form.setNumCols(4);
        form.setDataSource(dataSource);


        final ListGrid listGrid = new ListGrid();
        listGrid.setWidth100();
        listGrid.setHeight(200);
        listGrid.setDataSource(dataSource);
        listGrid.setAutoFetchData(true);
        listGrid.addRecordClickHandler(new RecordClickHandler() {
            public void onRecordClick(RecordClickEvent event) {
                form.reset();
                form.editSelectedData(listGrid);
            }
        });

        layout.addMember(listGrid);
        layout.addMember(form);

        IButton button = new IButton("Save");
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                form.saveData();                
            }
        });
        layout.addMember(button);

        return layout;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}