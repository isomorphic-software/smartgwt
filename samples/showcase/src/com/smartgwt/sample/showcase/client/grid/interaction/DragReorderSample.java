package com.smartgwt.sample.showcase.client.grid.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class DragReorderSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Drag and drop to change the order of countries in this list.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            DragReorderSample panel = new DragReorderSample();
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

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(300);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setCanReorderRecords(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");

        countryGrid.setFields(countryCodeField, nameField, capitalField);
        countryGrid.setData(CountrySampleData.getRecords());

        hStack.addMember(countryGrid);

        VStack modifyStack = new VStack(3);
        modifyStack.setWidth(20);
        modifyStack.setLayoutAlign(VerticalAlignment.CENTER);
        modifyStack.setHeight(74);

        TransferImgButton up = new TransferImgButton(TransferImgButton.UP);
        up.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ListGridRecord[] selectedRecords = countryGrid.getSelectedRecords();
                for (int i=0; i<selectedRecords.length; i++) {
                    ListGridRecord selectedRecord = selectedRecords[i];
                    if(selectedRecord != null) {
                        int idx = countryGrid.getRecordIndex(selectedRecord);
                        if(idx > 0) {
                            RecordList rs = countryGrid.getRecordList();
                            rs.removeAt(idx);
                            rs.addAt(selectedRecord, idx - 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        });

        TransferImgButton upFirst = new TransferImgButton(TransferImgButton.UP_FIRST);
        upFirst.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ListGridRecord[] selectedRecords = countryGrid.getSelectedRecords();
                for (int i=0; i<selectedRecords.length; i++) {
                    ListGridRecord selectedRecord = selectedRecords[i];
                    if(selectedRecord != null) {
                        int idx = countryGrid.getRecordIndex(selectedRecord);
                        if(idx > 0) {
                            RecordList rs = countryGrid.getRecordList();
                            rs.removeAt(idx);
                            rs.addAt(selectedRecord, i);
                        }
                    }
                }
            }
        });

        TransferImgButton down = new TransferImgButton(TransferImgButton.DOWN);
        down.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ListGridRecord[] selectedRecords = countryGrid.getSelectedRecords();
                for (int i=selectedRecords.length-1; i>=0; i--) {
                    ListGridRecord selectedRecord = selectedRecords[i];
                    if(selectedRecord != null) {
                        RecordList rs = countryGrid.getRecordList();
                        int numRecords = rs.getLength();
                        int idx = countryGrid.getRecordIndex(selectedRecord);
                        if(idx < numRecords - 1) {
                            rs.removeAt(idx);
                            rs.addAt(selectedRecord, idx + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        });

        TransferImgButton downLast = new TransferImgButton(TransferImgButton.DOWN_LAST);
        downLast.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                ListGridRecord[] selectedRecords = countryGrid.getSelectedRecords();
                for (int i=0; i<selectedRecords.length; i++) {
                    ListGridRecord selectedRecord = selectedRecords[i];
                    if(selectedRecord != null) {
                        RecordList rs = countryGrid.getRecordList();
                        int numRecords = rs.getLength();
                        int idx = countryGrid.getRecordIndex(selectedRecord);
                        if(idx < numRecords - 1) {
                            rs.removeAt(idx);
                            rs.addAt(selectedRecord, rs.getLength());
                        }
                    }
                }
            }
        });
        modifyStack.addMember(upFirst);
        modifyStack.addMember(up);
        modifyStack.addMember(down);
        modifyStack.addMember(downLast);

        hStack.addMember(modifyStack);

        return hStack;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    @Override
    protected boolean shouldWrapViewPanel() {
        return true;
    }
}
