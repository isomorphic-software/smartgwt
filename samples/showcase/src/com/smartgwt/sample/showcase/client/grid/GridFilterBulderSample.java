package com.smartgwt.sample.showcase.client.grid;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.TopOperatorAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.FilterBuilder;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.WorldXmlDS;

public class GridFilterBulderSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "<p>Use the FilterBuilder to construct custom queries that combine multiple " +
            "criteria across any field in your DataSource.</p><p>Note that the operator select list only shows operators suitable " +
            "for the field selected, and the comparison field changes to suit the type of the selected field (for example, " +
            "select field \"independence\" and note that the comparison field changes to a date).</p><p>Add clauses to your " +
            "query with the \"+\" icon. Click \"Filter\" to see the result in the ListGrid.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridFilterBulderSample panel = new GridFilterBulderSample();
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

        DataSource worldDS = WorldXmlDS.getInstance();

        final FilterBuilder filterBuilder = new FilterBuilder();        
        filterBuilder.setDataSource(worldDS);
        filterBuilder.setTopOperatorAppearance(TopOperatorAppearance.RADIO);

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(550);
        countryGrid.setHeight(224);
        countryGrid.setDataSource(worldDS);
        countryGrid.setAutoFetchData(true);

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField continentField = new ListGridField("continent", "Continent");
        ListGridField memberG8Field = new ListGridField("member_g8", "Member G8");
        memberG8Field.setCanEdit(false);

        ListGridField populationField = new ListGridField("population", "Population");
        populationField.setType(ListGridFieldType.INTEGER);
        populationField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if(value == null) return null;
                try {
                    NumberFormat nf = NumberFormat.getFormat("0,000");
                    return nf.format(((Number) value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
            }
        });
        ListGridField independenceField = new ListGridField("independence", "Independence");
        countryGrid.setFields(nameField,continentField, memberG8Field, populationField, independenceField);

        IButton filterButton = new IButton("Filter");
        filterButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.filterData(filterBuilder.getCriteria());
            }
        });

        VStack vStack = new VStack(10);
        vStack.addMember(filterBuilder);
        vStack.addMember(filterButton);
        vStack.addMember(countryGrid);

        return vStack;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
    
    @Override
    protected boolean shouldWrapViewPanel() {
        return true;
    }
}