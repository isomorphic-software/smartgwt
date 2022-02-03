/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * is published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.sample.showcase.client.grid.autofit;

import com.smartgwt.client.types.AutoFitWidthApproach;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class AutofitMinsMaxsSample extends ShowcasePanel {
    private static final String DESCRIPTION =
        "<p>Here we have a set of records where most records have short descriptions, but some "+
        "have very long ones.  By setting <code>autoFitWidth</code> and <code>maxWidth</code>, "+
        "we will auto-fit to descriptions when only short ones are present (press \"All Short "+
        "Descriptions\" button), but avoid a huge field when a long description is present (press "+
        "One Long Description\" button). "+
        "<p>"+
        "Similarly, sometimes none of the visible records have descriptions.  In this case we'd "+
        "like the field to shrink so that only \"Desc\" is visible.  We do this with a "+
        "<code>minWidth</code> setting - press the \"All Blank Descriptions\" button to see this.</p>";
        
    public static class Factory implements PanelFactory {
        private String id;
        public ShowcasePanel create() {
            AutofitMinsMaxsSample panel = new AutofitMinsMaxsSample();
            id = panel.getID();
            return panel;
        }
        public String getID() { return id; }
        public String getDescription() { return DESCRIPTION; }
    }

    private Record[] records = null;
    
    public Canvas getViewPanel() {
		HLayout hLayout = new HLayout();
		hLayout.setWidth100();
        hLayout.setHeight(250);
		hLayout.setMembersMargin(20);
				
		DataSource dataSource = ItemSupplyXmlDS.getInstance();  
		
        final ListGrid listGrid = new ListGrid();  
        listGrid.setWidth(700);
        listGrid.setDataPageSize(250);
        listGrid.setAlternateRecordStyles(true);
        listGrid.setDataSource(dataSource);  
        listGrid.setAutoFetchData(false);
        
        ListGridField itemNameField = new ListGridField("itemName", "Name");
        ListGridField skuField = new ListGridField("SKU", "SKU");
        ListGridField categoryField = new ListGridField("category", "Category");
        categoryField.setAutoFitWidth(true);
        ListGridField unitCostField = new ListGridField("unitCost", "Unit Cost");
        unitCostField.setAutoFitWidth(true);
        unitCostField.setAutoFitWidthApproach(AutoFitWidthApproach.BOTH);
        ListGridField descriptionField = new ListGridField("description", "Description");
        descriptionField.setMinWidth(47);
        descriptionField.setMaxWidth(270);
        descriptionField.setAutoFitWidth(true);
        
        listGrid.setFields(itemNameField, skuField, categoryField, unitCostField, descriptionField);

        listGrid.fetchData(null, new DSCallback() {
			@Override
			public void execute(DSResponse dsResponse, Object data,
					DSRequest dsRequest) {
				records = dsResponse.getData();
			}
        });
		
        VLayout vLayoutButtons = new VLayout();
        vLayoutButtons.setMembersMargin(15);
        
        IButton buttonShortDesc = new IButton();
        buttonShortDesc.setWidth(160);
        buttonShortDesc.setTitle("All Short Descriptions");
        buttonShortDesc.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record[] recordsShortDesc = new Record[5];
				int cont = 0;
				for (int i = 0; i < records.length; i++) {
		        	if ("4044000".equalsIgnoreCase(records[i].getAttributeAsString("SKU")) ||
		        		"5935000".equalsIgnoreCase(records[i].getAttributeAsString("SKU")) ||
		        		"5753100".equalsIgnoreCase(records[i].getAttributeAsString("SKU")) ||
		        		"5617200".equalsIgnoreCase(records[i].getAttributeAsString("SKU")) ||
		        		"10328400".equalsIgnoreCase(records[i].getAttributeAsString("SKU")))
		        	{
		        		recordsShortDesc[cont] = records[i];
		        		cont++;
		        	}
		        }
                listGrid.resizeField(0, 300);
                listGrid.setData(recordsShortDesc);
			}
        });
        IButton buttonLongDesc = new IButton();
        buttonLongDesc.setWidth(160);
        buttonLongDesc.setTitle("One Long Description");
        buttonLongDesc.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record[] recordsLongDesc = new Record[5];
				int cont = 0;
				for (int i = 0; i < records.length; i++) {
					if ("4044000".equalsIgnoreCase(records[i].getAttributeAsString("SKU")) ||
		        		"5935000".equalsIgnoreCase(records[i].getAttributeAsString("SKU")) ||
		        		"5753100".equalsIgnoreCase(records[i].getAttributeAsString("SKU")) ||
		        		"5617200".equalsIgnoreCase(records[i].getAttributeAsString("SKU")) ||
		        		"10193600".equalsIgnoreCase(records[i].getAttributeAsString("SKU")))
                    {
						recordsLongDesc[cont] = records[i];
						cont++;
					}
				}
                listGrid.resizeField(0, 180);
	        	listGrid.setData(recordsLongDesc);
			}
        });        
        IButton buttonBlankDesc = new IButton();
        buttonBlankDesc.setWidth(160);
        buttonBlankDesc.setTitle("All Blank Descriptions");
        buttonBlankDesc.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Record[] recordsBlankDesc = new Record[5];
				int cont = 0;
				for (int i = 0; i < records.length; i++) {
					if ("45300".equalsIgnoreCase(records[i].getAttributeAsString("SKU")) ||
			        	"135900".equalsIgnoreCase(records[i].getAttributeAsString("SKU")) ||
			        	"951300".equalsIgnoreCase(records[i].getAttributeAsString("SKU")) ||
			        	"1089400".equalsIgnoreCase(records[i].getAttributeAsString("SKU")) ||
			        	"1090500".equalsIgnoreCase(records[i].getAttributeAsString("SKU")))
					{
						recordsBlankDesc[cont] = records[i];
						cont++;
					}
				}
                listGrid.resizeField(0, 340);
	        	listGrid.setData(recordsBlankDesc);
			}
        });        
        vLayoutButtons.addMember(buttonShortDesc);
        vLayoutButtons.addMember(buttonLongDesc);
        vLayoutButtons.addMember(buttonBlankDesc);
        
        hLayout.addMember(listGrid);
        hLayout.addMember(vLayoutButtons);
        
        return hLayout;
    }

    public String getIntro() { return DESCRIPTION; }
    protected boolean isTopIntro() { return true; }
}