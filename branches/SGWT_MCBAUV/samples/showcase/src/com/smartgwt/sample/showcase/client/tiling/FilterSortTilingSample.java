package com.smartgwt.sample.showcase.client.tiling;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SliderItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.viewer.CellStyleHandler;
import com.smartgwt.client.widgets.viewer.DetailFormatter;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.AnimalXmlDS;

import java.util.LinkedHashMap;

public class FilterSortTilingSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Tiled views can be filtered and sorted just like ListGrids. Use the \"Search\" form to " +
            "eliminate some tiles and watch remaining tiles animate to new positions.</p>" +
            "<p>Use the \"Sort\" form to change the sort direction.</p>";

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            FilterSortTilingSample panel = new FilterSortTilingSample();
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
        tileGrid.setTileWidth(158);
        tileGrid.setTileHeight(205);
        tileGrid.setHeight(400);
        tileGrid.setID("boundList");
        tileGrid.setCanReorderTiles(true);
        tileGrid.setShowAllRecords(true);
        tileGrid.setDataSource(AnimalXmlDS.getInstance());
        tileGrid.setAutoFetchData(true);
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
                if("Endangered".equals(value)) {
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

        final DynamicForm filterForm = new DynamicForm();
        filterForm.setIsGroup(true);
        filterForm.setGroupTitle("Search");
        filterForm.setNumCols(6);
        filterForm.setDataSource(AnimalXmlDS.getInstance());
        filterForm.setAutoFocus(false);

        TextItem commonNameItem = new TextItem("commonName");
        SliderItem lifeSpanItem = new SliderItem("lifeSpan");
        lifeSpanItem.setTitle("Max Life Span");
        lifeSpanItem.setMinValue(1);
        lifeSpanItem.setMaxValue(60);
        lifeSpanItem.setDefaultValue(60);
        lifeSpanItem.setHeight(50);
        lifeSpanItem.setOperator(OperatorId.LESS_THAN);

        SelectItem statusItem = new SelectItem("status");
        statusItem.setOperator(OperatorId.EQUALS);
        statusItem.setAllowEmptyValue(true);

        filterForm.setFields(commonNameItem, lifeSpanItem, statusItem);

        filterForm.addItemChangedHandler(new ItemChangedHandler() {
            public void onItemChanged(ItemChangedEvent event) {
                tileGrid.fetchData(filterForm.getValuesAsCriteria());
            }
        });

        vStack.addMember(filterForm);

        final DynamicForm sortForm = new DynamicForm();
        sortForm.setIsGroup(true);
        sortForm.setGroupTitle("Sort");
        sortForm.setAutoFocus(false);
        sortForm.setID("sortForm");
        sortForm.setNumCols(6);

        SelectItem sortItem = new SelectItem();
        sortItem.setName("sortBy");
        sortItem.setTitle("Sort by");

        LinkedHashMap valueMap = new LinkedHashMap();
        valueMap.put("commonName", "Animal");
        valueMap.put("lifeSpan", "Life Span");
        valueMap.put("status", "Endangered Status");

        sortItem.setValueMap(valueMap);

        final CheckboxItem ascendingItem = new CheckboxItem("chkSortDir");
        ascendingItem.setTitle("Ascending");

        sortForm.setFields(sortItem, ascendingItem);

        sortForm.addItemChangedHandler(new ItemChangedHandler() {
            public void onItemChanged(ItemChangedEvent event) {
                String sortVal = sortForm.getValueAsString("sortBy");
                Boolean sortDir = (Boolean) ascendingItem.getValue();
                if(sortDir == null) sortDir = false;
                if(sortVal != null) {
                   tileGrid.sortByProperty(sortVal, sortDir);
                }
            }
        });
        vStack.addMember(sortForm);

        HLayout hLayout = new HLayout(10);
        hLayout.setHeight(22);

        IButton filterButton = new IButton("Filter");
        filterButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                tileGrid.fetchData(filterForm.getValuesAsCriteria());
            }
        });
        filterButton.setAutoFit(true);

        IButton clearButton = new IButton("Clear");
        clearButton.setAutoFit(true);
        clearButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                tileGrid.fetchData();
                filterForm.clearValues();
                sortForm.clearValues();
            }
        });

        hLayout.addMember(filterButton);
        hLayout.addMember(clearButton);
        vStack.addMember(hLayout);

        return vStack;

    }

    @Override
    protected boolean shouldWrapViewPanel() {
        return true;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}