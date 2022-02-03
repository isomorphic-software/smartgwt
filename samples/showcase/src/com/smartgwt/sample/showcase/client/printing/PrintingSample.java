package com.smartgwt.sample.showcase.client.printing;

import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class PrintingSample extends ShowcasePanel {
    private static final String DESCRIPTION = "" +
            "Smart GWT provides comprehensive support for rendering your UI in a print-friendly " +
            "fashion.  Click the \"Print Preview\" button and note the following things: " +
            "<ul>" +
            "<li>All components have simplified appearance (eg gradients omitted) to be legible in black and white</li>" +
            "<li>The ListGrid had a scrollbar because it wasn't big enough to show all records, " +
            "but the printable view shows all data</li>" +
            "<li>Buttons and other interactive controls that are not meaningful in print view are omitted</li></ul>";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            PrintingSample panel = new PrintingSample();
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

        CountryXmlDS countryDS = CountryXmlDS.getInstance();

        SectionStack printStack = new SectionStack();
        printStack.setVisibilityMode(VisibilityMode.MULTIPLE);
        printStack.setWidth(400);
        printStack.setHeight(455);

        final DetailViewer printViewer = new DetailViewer();
        printViewer.setDataSource(countryDS);
        printViewer.setWidth(380);
        printViewer.setMargin(15);
        printViewer.setEmptyMessage("Select a country to view its details");

        final ListGrid printGrid = new ListGrid();
        printGrid.setHeight(150);

        printGrid.setDataSource(countryDS);

        ListGridField countryCode = new ListGridField("countryCode", "Code", 50);
        ListGridField countryName = new ListGridField("countryName", "Country");
        ListGridField capital = new ListGridField("capital", "Capital");
        ListGridField continent = new ListGridField("continent", "Continent");
        printGrid.setFields(countryCode, countryName, capital, continent);

        printGrid.addRecordClickHandler(new RecordClickHandler() {
            public void onRecordClick(RecordClickEvent event) {
                printViewer.setData(new Record[]{event.getRecord()});
            }
        });

        SectionStackSection countriesSection = new SectionStackSection("Countries");
        countriesSection.setExpanded(true);
        countriesSection.addItem(printGrid);
        printStack.addSection(countriesSection);

        SectionStackSection detailsSection = new SectionStackSection("Country Details");
        detailsSection.setExpanded(true);
        VStack vStack = new VStack();
        vStack.setOverflow(Overflow.AUTO);
        vStack.setWidth100();
        vStack.addMember(printViewer);
        detailsSection.addItem(vStack);
        printStack.addSection(detailsSection);


        final VLayout printContainer = new VLayout(10);


        HLayout printButtonLayout = new HLayout(5);

        IButton newButton = new IButton("New");
        newButton.setDisabled(true);
        IButton changeButton = new IButton("Change");
        changeButton.setDisabled(true);
        IButton printPreviewButton = new IButton("Print Preview");
        printPreviewButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Canvas.showPrintPreview(printContainer);
            }
        });
        printButtonLayout.addMember(newButton);
        printButtonLayout.addMember(changeButton);
        printButtonLayout.addMember(printPreviewButton);

        printContainer.addMember(printStack);
        printContainer.addMember(printButtonLayout);


        // The filter is just to limit the number of records in the ListGrid - we don't want to print them all
        printGrid.filterData(new Criteria("CountryName", "land"), new DSCallback() {
            public void execute(DSResponse response, Object rawData, DSRequest request) {
                printGrid.selectRecord(0);
                printViewer.setData(new Record[]{printGrid.getSelectedRecord()});
            }
        });

        return printContainer;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
