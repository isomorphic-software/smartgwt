package com.smartgwt.sample.showcase.client.autotest.effects.dragdrop;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.DragDataAction;
import com.smartgwt.client.util.EventHandler;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.DragStartEvent;
import com.smartgwt.client.widgets.events.DragStartHandler;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.PartData;
import com.smartgwt.sample.showcase.client.effects.dragdrop.PartsListGrid;

public class TestableRecordsAcrossWindowsSample extends ShowcasePanel {

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            final TestableRecordsAcrossWindowsSample panel = new TestableRecordsAcrossWindowsSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return null;
        }
    }

    @Override
    public Canvas getViewPanel() {
        final PartsListGrid myList1 = new PartsListGrid();
        myList1.setID("myList1");
        myList1.setWidth100();
        myList1.setHeight("50%");
        Record[] data = PartData.getRecords();
        myList1.setData(data);
        myList1.setCanDragRecordsOut(true);
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
        myList2.setWidth100();
        myList2.setHeight("50%");
        myList2.setCanAcceptDroppedRecords(true);

        final Layout mainLayout = new VStack(15);
        mainLayout.setWidth100();
        mainLayout.setHeight100();
        mainLayout.setMembers(myList1, myList2);
        return mainLayout;
    }
}
