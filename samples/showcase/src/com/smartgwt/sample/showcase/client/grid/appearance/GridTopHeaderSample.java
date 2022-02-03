package com.smartgwt.sample.showcase.client.grid.appearance;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridEditEvent;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GridTopHeaderSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>This is an example of a ListGrid with a top level header. This is accomplished easily " +
            "by adding the ListGrid to a non-collapsible SectionStackSection.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridTopHeaderSample panel = new GridTopHeaderSample();
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

        SectionStack sectionStack = new SectionStack();
        sectionStack.setWidth(600);
        sectionStack.setHeight(230);

        String title = Canvas.imgHTML("silk/world.png") + " Countries Visited";
        SectionStackSection section = new SectionStackSection(title);

        section.setCanCollapse(false);
        section.setExpanded(true);

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth("100%");
        countryGrid.setHeight("100%");
        countryGrid.setShowAllRecords(true);
        countryGrid.setDataSource(CountryXmlDS.getInstance());

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 40);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setCanEdit(false);

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField continentField = new ListGridField("continent", "Continent");
        ListGridField memberG8Field = new ListGridField("member_g8", "Member G8");
        ListGridField populationField = new ListGridField("population", "Population");
        populationField.setType(ListGridFieldType.INTEGER);
        ListGridField independenceField = new ListGridField("independence", "Independence", 150);
        countryGrid.setFields(countryCodeField, nameField,continentField, memberG8Field, populationField, independenceField);

        countryGrid.setAutoFetchData(true);
        countryGrid.setCanEdit(true);
        countryGrid.setEditEvent(ListGridEditEvent.CLICK);

        section.setItems(countryGrid);
        sectionStack.setSections(section);
        return sectionStack;
    }


    public String getIntro() {
        return DESCRIPTION;
    }
}
