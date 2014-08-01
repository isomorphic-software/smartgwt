package com.smartgwt.sample.showcase.client.grid.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class DragCopySample extends ShowcasePanel {
    private static final String DESCRIPTION = "Drag and drop to copy rows between the two lists.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            DragCopySample panel = new DragCopySample();
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

        HStack hStack = new HStack(10);
        hStack.setHeight(160);

        final ListGrid countryGrid1 = new ListGrid();
        countryGrid1.setWidth(300);
        countryGrid1.setHeight(224);
        countryGrid1.setShowAllRecords(true);
        countryGrid1.setCanReorderRecords(true);
        countryGrid1.setCanDragRecordsOut(true);
        countryGrid1.setCanAcceptDroppedRecords(true);
        countryGrid1.setDragDataAction(DragDataAction.COPY);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");

        countryGrid1.setFields(countryCodeField, nameField, capitalField);
        countryGrid1.setData(CountrySampleData.getRecords());

        hStack.addMember(countryGrid1);

        final ListGrid countryGrid2 = new ListGrid();
        countryGrid2.setWidth(200);
        countryGrid2.setHeight(224);
        countryGrid2.setLeft(350);
        countryGrid2.setShowAllRecords(true);
        countryGrid2.setEmptyMessage("Drop Rows Here");
        countryGrid2.setCanReorderRecords(true);
        countryGrid2.setCanAcceptDroppedRecords(true);

        ListGridField countryCodeField2 = new ListGridField("countryCode", "Flag", 50);
        countryCodeField2.setAlign(Alignment.CENTER);
        countryCodeField2.setType(ListGridFieldType.IMAGE);
        countryCodeField2.setImageURLPrefix("flags/16/");
        countryCodeField2.setImageURLSuffix(".png");
        ListGridField nameField2 = new ListGridField("countryName", "Country");
                
        countryGrid2.setFields(countryCodeField2, nameField2);

        TransferImgButton copy = new TransferImgButton(TransferImgButton.RIGHT);
        copy.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid2.transferSelectedData(countryGrid1);
            }
        });

        hStack.addMember(copy);

        hStack.addMember(countryGrid2);

        return hStack;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}
