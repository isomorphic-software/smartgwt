package com.smartgwt.sample.showcase.client.grid.sortfilter;

import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.Criterion;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.WorldXmlDS;

public class GridExpressionFilter extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>DynamicForms and FormItems are capable of parsing simple expressions " +
            "entered as part of their values, when allowExpressions is true on either entity. ListGrids use this facility, " +
            "when showFilterEditor and allowFilterExpressions are true, to allow expressions to be entered directly into the FormItems displayed in the filterEditor.</p>" +
            "<p>Below is a ListGrid with a FilterEditor and allowFilterExpressions: true. Some expression-based filter-criteria have been applied via initialCriteria: " +
            "the list displays countries with no 'i's in the country name, with a Capital that starts with a letter &quot;A&quot; through &quot;F&quot; and with a population less than " +
            "1 million or more than 100 million.</p>" +
            "<p>See the table on the right for the supported expression-symbols. Note that logical &quot;and&quot; and &quot;or&quot; expressions are treated as text in text-based fields and ignored.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridExpressionFilter panel = new GridExpressionFilter();
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
        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(500);
        countryGrid.setHeight(300);
        countryGrid.setDataSource(WorldXmlDS.getInstance());

        ListGridField countryCodeField = new ListGridField("countryCode", "Code", 50);
        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        ListGridField areaField = new ListGridField("area", "Area (km&sup2;)");
        ListGridField populationField = new ListGridField("population", "Population");

        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField, areaField, populationField);

        countryGrid.setAutoFetchData(true);
        countryGrid.setShowFilterEditor(true);
        countryGrid.setAllowFilterExpressions(true);

        AdvancedCriteria initialCriteria = new AdvancedCriteria(OperatorId.AND, new Criterion[]{
                new Criterion("countryName", OperatorId.INOT_CONTAINS, "i"),
                new Criterion("capital", OperatorId.BETWEEN_INCLUSIVE, new String[] {"A", "F"}),

                new AdvancedCriteria(OperatorId.OR, new Criterion[]{
                        new Criterion("population", OperatorId.LESS_THAN, 1000000),
                        new Criterion("population", OperatorId.GREATER_THAN, 100000000)
                })
        });

        countryGrid.setInitialCriteria(initialCriteria);


        Label label = new Label();
        label.setAutoHeight();
        label.setContents("<table style='font-size:12;font-family:Arial,Verdana'>" +
                "<tr><td><b>Prefix</b></td><td><b>Operator</b></td></tr>" +
                "<tr><td>&lt;</td><td>lessThan</td></tr>" +
                "<tr><td>&gt;</td><td>greaterThan</td></tr>" +
                "<tr><td>&lt;=</td><td>lessThanOrEqual</td></tr>" +
                "<tr><td>&gt;=</td><td>greaterThanOrEqual</td></tr>" +
                "<tr><td>someValue...someValue</td><td>betweenInclusive</td></tr>" +
                "<tr><td>!</td><td>notEqual</td></tr>" +
                "<tr><td>^</td><td>startsWith</td></tr>" +
                "<tr><td>|</td><td>endsWith</td></tr>" +
                "<tr><td>!^</td><td>notStartsWith</td></tr>" +
                "<tr><td>!@</td><td>notEndsWith</td></tr>" +
                "<tr><td>~</td><td>contains</td></tr>" +
                "<tr><td>!~</td><td>notContains</td></tr>" +
                "<tr><td>=(value1|value2)</td><td>inSet</td></tr>" +
                "<tr><td>!=(value1|value2)</td><td>notInSet</td></tr>" +
                "<tr><td>#</td><td>isNull</td></tr>" +
                "<tr><td>!#</td><td>isNotNull</td></tr>" +
                "<tr><td>==</td><td>exact match (for fields where 'contains' is the default)</td></tr>" +
                "<tr><td>=.</td><td>matches other field-name or title</td></tr>" +
                "</table>");


        HLayout layout = new HLayout(20);
        layout.setMembers(countryGrid, label);

        return layout;
    }

    protected boolean isTopIntro() {
        return true;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}

