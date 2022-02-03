package com.smartgwt.sample.showcase.client.tiling;

import java.util.HashMap;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.types.DragAppearance;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tile.TileGrid;
import com.smartgwt.client.widgets.viewer.DetailViewerField;
import com.smartgwt.sample.showcase.client.data.AnimalXmlDS;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class RecategorizeTilingSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Drag and drop animals between the grids "+
        "in either direction, and the status of the dropped tile will change to match the "+
        "filtered status of the TileGrid in which it was dropped. Select different values "+
        "in the drop down lists above each TileGrid to change the animals that will appear in each grid.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            RecategorizeTilingSample panel = new RecategorizeTilingSample();
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
        final TileGrid boundList1 = new TileGrid();
        boundList1.setWidth(400);
        boundList1.setHeight(400);
        boundList1.setTileWidth(150);
        boundList1.setTileHeight(185);
        boundList1.setHeight(400);
        boundList1.setShowAllRecords(true);
        boundList1.setDataSource(AnimalXmlDS.getInstance());
        boundList1.setAutoFetchData(true);
        Criteria initialCriteria1 = new Criteria();
        initialCriteria1.addCriteria("status", "Endangered");
        boundList1.setInitialCriteria(initialCriteria1);
        boundList1.setAutoFetchTextMatchStyle(TextMatchStyle.EXACT);
        boundList1.setAnimateTileChange(true);
        boundList1.setCanAcceptDroppedRecords(true);
        boundList1.setCanDragTilesOut(true);
        boundList1.setTileDragAppearance(DragAppearance.TARGET);
    	
        DetailViewerField pictureField1 = new DetailViewerField("picture");
        DetailViewerField commonNameField1 = new DetailViewerField("commonName");
        DetailViewerField statusField1 = new DetailViewerField("status");
    	
        boundList1.setFields(pictureField1, commonNameField1, statusField1);        		
    	
        SelectItem statusItem1 = new SelectItem();
        statusItem1.setName("status");
        statusItem1.setTitle("<b>Status</b>");
        statusItem1.setDefaultValue("Endangered");
        HashMap map1 = new HashMap();
        map1.put("Threatened", "Threatened");
        map1.put("Endangered", "Endangered");
        map1.put("Not Endangered", "Not Endangered");
        map1.put("Not currently listed", "Not currently listed");
        map1.put("May become threatened", "May become threatened");
        map1.put("Protected", "Protected");
        statusItem1.setValueMap(map1);

        final DynamicForm form1 = new DynamicForm();
        form1.setFields(statusItem1);
        form1.addItemChangedHandler(new ItemChangedHandler() {
            @Override
            public void onItemChanged(ItemChangedEvent event) {
                boundList1.fetchData(form1.getValuesAsCriteria());
            }
        });

        final TileGrid boundList2 = new TileGrid();
        boundList2.setWidth(400);
        boundList2.setHeight(400);
        boundList2.setTileWidth(150);
        boundList2.setTileHeight(185);
        boundList2.setHeight(400);
        boundList2.setShowAllRecords(true);
        boundList2.setDataSource(AnimalXmlDS.getInstance());
        boundList2.setAutoFetchData(true);
        Criteria initialCriteria2 = new Criteria();
        initialCriteria2.addCriteria("status", "Threatened");
        boundList2.setInitialCriteria(initialCriteria2);
        boundList2.setAutoFetchTextMatchStyle(TextMatchStyle.EXACT);
        boundList2.setAnimateTileChange(true);
        boundList2.setCanAcceptDroppedRecords(true);
        boundList2.setCanDragTilesOut(true);
        boundList2.setTileDragAppearance(DragAppearance.TARGET);
    	
        DetailViewerField pictureField2 = new DetailViewerField("picture");
        DetailViewerField commonNameField2 = new DetailViewerField("commonName");
        DetailViewerField statusField2 = new DetailViewerField("status");
    	
        boundList2.setFields(pictureField2, commonNameField2, statusField2);  
    	
        SelectItem statusItem2 = new SelectItem();
        statusItem2.setName("status");
        statusItem2.setTitle("<b>Status</b>");
        statusItem2.setDefaultValue("Threatened");
        HashMap map2 = new HashMap();
        map2.put("Threatened", "Threatened");
        map2.put("Endangered", "Endangered");
        map2.put("Not Endangered", "Not Endangered");
        map2.put("Not currently listed", "Not currently listed");
        map2.put("May become threatened", "May become threatened");
        map2.put("Protected", "Protected");
        statusItem2.setValueMap(map2);

        final DynamicForm form2 = new DynamicForm();
        form2.setFields(statusItem2);
        form2.addItemChangedHandler(new ItemChangedHandler() {
            @Override
            public void onItemChanged(ItemChangedEvent event) {
                boundList2.fetchData(form2.getValuesAsCriteria());
            }
        });
        VLayout vLayout1 = new VLayout();
        vLayout1.addMember(form1);
        vLayout1.addMember(boundList1);
    	
        VLayout vLayout2 = new VLayout();
        vLayout2.addMember(form2);
        vLayout2.addMember(boundList2);

        HLayout hLayout = new HLayout();
        hLayout.setMembersMargin(10);
        hLayout.addMember(vLayout1);
        hLayout.addMember(vLayout2);
        
        return hLayout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}