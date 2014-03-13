package com.smartgwt.sample.showcase.client.gwtintegration;

import com.google.gwt.user.client.ui.*;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class GwtShowcaseSample extends ShowcasePanel {

    private static final String DESCRIPTION = "This is an example of integrating GWT Widgets with Smart GWT components.";

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            GwtShowcaseSample panel = new GwtShowcaseSample();
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
        TabSet tabSet = new TabSet();
        tabSet.setWidth(580);
        tabSet.setHeight(400);

        Tab smartTab1 = new Tab("Smart GWT Tab &nbsp;", "pieces/16/pawn_blue.png");
        Canvas tabPane1 = new Canvas();
        tabPane1.setWidth100();
        tabPane1.setHeight100();
        tabPane1.addChild(getGwtTab());
        smartTab1.setPane(tabPane1);

        Tab smartTab2 = new Tab("Another Tab &nbsp;", "pieces/16/pawn_blue.png");
        smartTab2.setPane(new CountryListGrid());
        tabSet.setTabs(smartTab1, smartTab2);

        return tabSet;
    }

    private Widget getGwtTab() {
        DecoratedTabPanel tabPanel = new DecoratedTabPanel();
        tabPanel.setWidth("550px");
        tabPanel.setAnimationEnabled(true);
        
        VerticalPanel vPanel0 = new VerticalPanel();
        vPanel0.setStyleName("vpDotted");
        vPanel0.setHeight("500px");
        vPanel0.setSpacing(15);
        HTML homeText = new HTML("I am a GWT 'HTML' Widget. Click one of the tabs to see more content.");
        vPanel0.add(homeText);


        tabPanel.add(vPanel0, "GWT Tabs");

        // Add a tab with an image
        VerticalPanel vPanel = new VerticalPanel();
        Image gwtImage = new Image("images/gwt/logo.png");
        gwtImage.setTitle("I am a GWT Image Widget");
        vPanel.add(gwtImage);

        VerticalPanel vPanel2 = new VerticalPanel();
        vPanel2.setSpacing(15);
        vPanel2.setHeight("500px");
        Button gwtButton = new Button("GWT  Button",
                new ClickListener() {
                    public void onClick(Widget sender) {
                        SC.say("Smart GWT Dialog");
                    }
                });
        vPanel2.add(gwtButton);

        tabPanel.add(vPanel2, "GWT Button");

        tabPanel.add(vPanel, "GWT Logo");

        // Add a tab
        HTML moreInfo = new HTML("Tabs are highly customizable using CSS.");
        tabPanel.add(moreInfo, "More Info");

        // Return the content
        tabPanel.selectTab(0);
        tabPanel.ensureDebugId("cwTabPanel");
        return tabPanel;
    }


    public String getIntro() {
        return DESCRIPTION;
    }

    class CountryListGrid extends ListGrid {
        CountryListGrid() {
            setWidth(500);
            setHeight(184);
            setShowAllRecords(true);
            setCanDragSelect(true);

            ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
            countryCodeField.setAlign(Alignment.CENTER);
            countryCodeField.setType(ListGridFieldType.IMAGE);
            countryCodeField.setImageURLPrefix("flags/16/");
            countryCodeField.setImageURLSuffix(".png");

            ListGridField nameField = new ListGridField("countryName", "Country");
            ListGridField capitalField = new ListGridField("capital", "Capital");
            ListGridField continentField = new ListGridField("continent", "Continent");
            setFields(countryCodeField, nameField, capitalField, continentField);

            setData(CountrySampleData.getRecords());
        }
    }

}