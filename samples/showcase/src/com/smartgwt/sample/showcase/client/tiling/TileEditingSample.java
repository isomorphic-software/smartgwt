package com.smartgwt.sample.showcase.client.tiling;

import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.SortSpecifier;
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.tile.events.RecordClickEvent;
import com.smartgwt.client.widgets.tile.events.RecordClickHandler;
import com.smartgwt.client.widgets.viewer.CellStyleHandler;
import com.smartgwt.client.widgets.viewer.DetailFormatter;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.AnimalXmlDS;

public class TileEditingSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Tiled views can be connected to editors. The TiledView automatically reacts to changes to the underlying dataset. Change the life span of Gazelle to 2 to see it animate to the beginning of the list.";

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            TileEditingSample panel = new TileEditingSample();
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

        VStack vStack = new VStack(20);
        vStack.setWidth100();

        final TileGrid tileGrid = new TileGrid();
        tileGrid.setTileWidth(150);
        tileGrid.setTileHeight(205);
        tileGrid.setHeight(400);
        tileGrid.setSelectionType(SelectionStyle.SINGLE);
        tileGrid.setCanReorderTiles(true);
        tileGrid.setShowAllRecords(true);
        tileGrid.setTileDragAppearance(DragAppearance.OUTLINE);
        tileGrid.setDataSource(AnimalXmlDS.getInstance());

        tileGrid.setAnimateTileChange(true);

        DetailViewerField pictureField = new DetailViewerField("picture");
        DetailViewerField commonNameField = new DetailViewerField("commonName");
        commonNameField.setCellStyle("commonName");

        DetailViewerField lifeSpanField = new DetailViewerField("lifeSpan");
        lifeSpanField.setCellStyle("lifeSpan");
        lifeSpanField.setDetailFormatter(new DetailFormatter() {
            public String format(Object value, Record record, DetailViewerField field) {
                return "Lifespan: " + value;
            }
        });

        DetailViewerField statusField = new DetailViewerField("status");
        statusField.setCellStyleHandler(new CellStyleHandler() {
            public String execute(Object value, DetailViewerField field, Record record) {
                if ("Endangered".equals(value)) {
                    return "endangered";
                } else if ("Threatened".equals(value)) {
                    return "threatened";
                } else if ("Not Endangered".equals(value)) {
                    return "notEndangered";
                } else {
                    return null;
                }
            }
        });
        tileGrid.setFields(pictureField, commonNameField, lifeSpanField, statusField);
        vStack.addMember(tileGrid);


        final DynamicForm boundForm = new DynamicForm();
        boundForm.setNumCols(6);
        boundForm.setDataSource(AnimalXmlDS.getInstance());
        boundForm.setAutoFocus(false);

        TextItem commonNameItem = new TextItem("commonName");
        TextItem lifeSpanItem = new TextItem("lifeSpan");

        SelectItem statusItem = new SelectItem("status");

        boundForm.setFields(commonNameItem, lifeSpanItem, statusItem);

        vStack.addMember(boundForm);

        tileGrid.addRecordClickHandler(new RecordClickHandler() {
            public void onRecordClick(RecordClickEvent event) {
                boundForm.editRecord(event.getRecord());
            }
        });

        HLayout hLayout = new HLayout(10);
        hLayout.setHeight(22);

        IButton button = new IButton("Save");
        button.setAutoFit(true);
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                boundForm.saveData();
                boundForm.clearValues();
            }
        });
        hLayout.addMember(button);
        vStack.addMember(hLayout);

        tileGrid.fetchData(null, new DSCallback() {
            public void execute(DSResponse response, Object rawData, DSRequest request) {
                SortSpecifier specifier = new SortSpecifier("lifeSpan", SortDirection.ASCENDING);
                tileGrid.getResultSet().setSort(new SortSpecifier[] { specifier });
            }
        });
        return vStack;

    }

    public String getIntro() {
        return DESCRIPTION;
    }

}