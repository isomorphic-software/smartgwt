package com.smartgwt.sample.showcase.client.grid.appearance;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.types.Autofit;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.SuperCarData;

public class RotatedTitlesSample extends ShowcasePanel {
    private static final String DESCRIPTION = 
        "ListGrid field titles may be rotated to optimize the use of screen space.  Note " + 
        "how in the grid, many fields with long titles can be shown at once without " + 
        "scrolling the grid or clipping the titles.  This may be appropriate whenever titles " +
        "are much longer than values (i.e. long titles or short values).";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            RotatedTitlesSample panel = new RotatedTitlesSample();
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

    private static final String GRID_TITLE =
        "<span style='font-size:20px'><b>Supercar Model Feature Overview</b></span>";

    public Canvas getViewPanel() {
        VLayout layout = new VLayout();

        Label title = new Label(GRID_TITLE);
        title.setWidth(500);
        title.setHeight(40);
        layout.addMember(title);

        ListGrid optionsGrid = new ListGrid();

        optionsGrid.setCanEdit(true);
        optionsGrid.setHeaderHeight(170);
        optionsGrid.setAutoFitData(Autofit.BOTH);
        optionsGrid.setRotateHeaderTitles(true);
        optionsGrid.setFields(SuperCarData.getFields());
        optionsGrid.setData(SuperCarData.getRecords());
        layout.addMember(optionsGrid);

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
