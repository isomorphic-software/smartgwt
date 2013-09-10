package com.smartgwt.sample.showcase.client.effects.dragdrop;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.TransferImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DragStartEvent;
import com.smartgwt.client.widgets.events.DragStartHandler;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.PartData;

public class RecordsAcrossWindowsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This sample demonstrates dragging data between two different browser windows." +
            "<p>" +
            "Open a second browser window (or browser tab) with this same sample running.  Drag " +
            "records from the grid and drop them on the grid shown in the other browser." +
            "<p>" +
            "Depending on your browser and operating system, it may be necessary to hover over the " +
            "second browser tab or over an application icon to cause the tab or browser to come to " +
            "the front so you can drop on it." +
            "<p>" +
            "Data is transferred directly from one browser instance to another using HTML5 " +
            "techniques.  This allows you to build applications that span multiple browser windows or " +
            "tabs, and makes it easier to take advantage of multiple physical screens.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            final RecordsAcrossWindowsSample panel = new RecordsAcrossWindowsSample();
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

    @Override
    public Canvas getViewPanel() {
        final PartsListGrid myList1 = new PartsListGrid();
        myList1.setID("myList1");
        Record[] data = PartData.getRecords();
        myList1.setData(data);
        myList1.setCanDragRecordsOut(true);
        myList1.setCanReorderRecords(true);
        myList1.setUseNativeDrag(true);
        myList1.setDragDataAction(DragDataAction.COPY);
        myList1.setDragType("partsListRecord");
        myList1.addDragStartHandler(new DragStartHandler() {
            @Override
            public void onDragStart(DragStartEvent event) {
                final Record[] dragData = myList1.getDragData();
                if (dragData != null && dragData.length != 0) {
                    final Record record = dragData[0];
                    EventHandler.setDragTrackerImage("pieces/16/" + record.getAttributeAsString("partSrc"), 12, 12);
                }
            }
        });

        final PartsListGrid myList2 = new PartsListGrid();
        myList2.setID("myList2");
        myList2.setCanAcceptDroppedRecords(true);
        myList2.setCanReorderRecords(true);

        final TransferImgButton transferImgButton = new TransferImgButton(TransferImgButton.RIGHT);
        transferImgButton.setID("transferButton");
        transferImgButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                myList2.transferSelectedData(myList1);
            }
        });

        final HStack hstack = new HStack(10);
        hstack.setHeight(160);
        hstack.setMembers(myList1, transferImgButton, myList2);
        return hstack;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
