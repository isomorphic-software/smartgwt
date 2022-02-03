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

package com.smartgwt.sample.showcase.client.layout;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ImageStyle;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.HTMLFlow;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.data.CountryData;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class LayoutMinsMaxsSample extends ShowcasePanel {
    private static final String DESCRIPTION =
        "<p>Click the \"Longer text\" button to show longer text - note how the ListGrid shrinks. Now "+
        "click \"Longest text\", note how scrolling is introduced so that the ListGrid doesn't get "+
        "too small to be usable.  The <code>minHeight</code> setting on the ListGrid prevents it "+
        "from shrinking too far."+
        "<p>"+
        "Now click \"Show Input Dialog\".  Try resizing your browser window with the input dialog "+
        "showing: observe how it is set to take up 80% of your screen width, but refuses to shrink "+
        "to be either too small or ridiculously large.  A combination of <code>minWidth</code> and "+
        "<code>maxWidth</code> settings on the Window component create this behavior.</p>";
        
    public static class Factory implements PanelFactory {
        private String id;
        public ShowcasePanel create() {
            LayoutMinsMaxsSample panel = new LayoutMinsMaxsSample();
            id = panel.getID();
            return panel;
        }
        public String getID() { return id; }
        public String getDescription() { return DESCRIPTION; }
    }

    public Canvas getViewPanel() {
		ListGrid countryGrid = new ListGrid();  
        countryGrid.setWidth(500);  
        countryGrid.setMinHeight(90);  
        countryGrid.setAlternateRecordStyles(true);
        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);  
        countryCodeField.setAlign(Alignment.CENTER);  
        countryCodeField.setType(ListGridFieldType.IMAGE);  
        countryCodeField.setImageURLPrefix("flags/16/");  
        countryCodeField.setImageURLSuffix(".png");  
  
        ListGridField nameField = new ListGridField("countryName", "Country");  
        ListGridField capitalField = new ListGridField("capital", "Capital");  
        ListGridField continentField = new ListGridField("continent", "Continent");  
        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField);  
        countryGrid.setCanResizeFields(true);  
        
        ListGridRecord[] records = CountryData.getRecords();
        ListGridRecord[] recordsAsia = new ListGridRecord[5];
        int cont = 0;
        for (int i = 0; i < records.length; i++) {
        	if ("Asia".equalsIgnoreCase(records[i].getAttributeAsString("continent"))) {
        		recordsAsia[cont] = records[i];
        		cont++;
        	}
        }
        countryGrid.setData(recordsAsia);
        
        
        final HTMLFlow htmlFlow = new HTMLFlow();
        htmlFlow.setWidth(500);
        htmlFlow.setPadding(10);
        htmlFlow.setContents("<h2>Asia</h2> <span style='font-size:12px;'> "+
                "Asia is the Earth's largest and most populous continent, "+
                "located primarily in the eastern and northern hemispheres.<p>"+
        		"Below are some details about various countries in Asia.</span>");
        
        VLayout vLayout = new VLayout();
        vLayout.setWidth(530);
        vLayout.setHeight(320);
        vLayout.setBorder("1px solid blue");
        vLayout.setOverflow(Overflow.AUTO);
        vLayout.setLayoutMargin(5);
        vLayout.addMember(htmlFlow);
        vLayout.addMember(countryGrid);
		
        VLayout vLayoutButtons = new VLayout();
        vLayoutButtons.setMembersMargin(15);
        
        IButton buttonLongerText = new IButton();
        buttonLongerText.setWidth(140);
        buttonLongerText.setTitle("Longer text");
        buttonLongerText.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				htmlFlow.setContents("<h2>Asia</h2> <span style='font-size:12px;'> "+
                    "Asia is the Earth's largest and most populous continent, "+
                    "located primarily in the eastern and northern hemispheres. <p> "+
                    "Asia covers an area of "+
                    "44,579,000 square kilometers, about 30% of Earth's total land "+
                    "area and 8.7% of the Earth's total surface area. It has "+
                    "historically been home to the world's first modern civilizations "+
                    "and has always hosted the bulk of the planet's human population. "+
                    "<p>"+
                    "Below are some details about various countries in Asia.</span>");
			}
        });
        IButton buttonLongestText = new IButton();
        buttonLongestText.setWidth(140);
        buttonLongestText.setTitle("Longest text");
        buttonLongestText.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				htmlFlow.setContents("<h2>Asia</h2> <span style='font-size:12px;'> "+
                    "Asia is the Earth's largest and most populous continent, "+
                    "located primarily in the eastern and northern hemispheres. <p>"+
                    "Asia covers an area of 44,579,000 square kilometers, about 30% "+
                    "of Earth's total land area and 8.7% of the Earth's total surface "+
                    "area. It has historically been home to the world's first "+
                    "modern civilizations and has always hosted the bulk of the "+
                    "planet's human population. "+
                    "<p>"+
                    " Asia is notable for not only overall large size and population, "+
                    "but unusually dense and large settlements as well as vast barely "+
                    "populated regions within the continent of 4.4 billion people. "+
                    "The boundaries of Asia are traditionally determined as that of "+
                    "Eurasia, as there is no significant geographical separation "+
                    "between Asia and Europe."+
                    "<p>"+
                    "Below are some details about various countries in Asia.</span>");
			}
        });        
        IButton buttonInputDialog = new IButton();
        buttonInputDialog.setWidth(140);
        buttonInputDialog.setTitle("Show Input Dialog");
        buttonInputDialog.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				HLayout hLayout = new HLayout();
				hLayout.setLayoutTopMargin(15);
				hLayout.setMargin(5);
				
				Img img = new Img();
				img.setWidth(32);
				img.setHeight(32);
				img.setImageType(ImageStyle.NORMAL);
				img.setSrc("[SKIN]/Dialog/say.png");
				
				DynamicForm form = new DynamicForm();
				form.setWidth100();
                form.setNumCols(3);
                form.setColWidths(100,"*",40);
				
				TextItem textItem = new TextItem();
				textItem.setTitle("Enter your name");
				textItem.setWidth("*");
                textItem.setWrapTitle(false);
				
				form.setFields(textItem, new SpacerItem());
				
				hLayout.addMember(img);
				hLayout.addMember(form);
				
				Window window = new Window();
                window.setTitle("Sample Input Dialog");
				window.setWidth("80%");
				window.setAutoCenter(true);
                window.setHeight(110);
				window.setMinWidth(400);
				window.setMaxWidth(800);
				window.addItem(hLayout);
				
				window.show();
			}
        });        
        vLayoutButtons.addMember(buttonLongerText);
        vLayoutButtons.addMember(buttonLongestText);
        vLayoutButtons.addMember(buttonInputDialog);
        
        HLayout mainHLayout = new HLayout();
        mainHLayout.setWidth100();
        mainHLayout.setMembersMargin(15);
        mainHLayout.addMember(vLayout);
        mainHLayout.addMember(vLayoutButtons);
        
        return mainHLayout;
    }

    public String getIntro() { return DESCRIPTION; }
    protected boolean isTopIntro() { return true; }
}