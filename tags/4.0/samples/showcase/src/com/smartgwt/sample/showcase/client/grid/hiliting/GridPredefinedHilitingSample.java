package com.smartgwt.sample.showcase.client.grid.hiliting;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.Criterion;
import com.smartgwt.client.data.Hilite;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.CellFormatter;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountryXmlDS;

public class GridPredefinedHilitingSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>This example demonstrates producing hilites in code. The hilites applied " +
            "to the grid below match those suggested in the User Defined hilites example. Additionally, the Advanced Hilite in " +
            "this example also demonstrates using <i>Canvas.imgHTML()</i> and the <i>htmlAfter</i> attribute of hilite-objects to " +
            "append a warning icon to the end of each field value, as part of the hilite. </p>" +            
            "<p>Hilite-objects also support an htmlBefore attribute - you can use these before and after properties to extend " +
            "color-based hilites to format values, for instance, as bold or italic text using HTML tags. </p> ";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridPredefinedHilitingSample panel = new GridPredefinedHilitingSample();
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
    protected boolean isTopIntro() {
        return true;
    }

    private static Hilite[] hilites = new Hilite[] {
            new Hilite() {{
                setFieldNames("area");
                setCriteria(new Criterion("area", OperatorId.GREATER_THAN, 5000000));
                setCssText("color:#FF0000");
            }},
            new Hilite() {{
                setFieldNames("area", "gdp");
                setCriteria(new AdvancedCriteria(OperatorId.AND, new Criterion[] {
                                new Criterion("gdp", OperatorId.GREATER_THAN, 1000000),
                                new Criterion("area", OperatorId.LESS_THAN, 500000)}));
                setCssText("color:#3333FF;background-color:#CDEB8B;");
                setHtmlAfter("&nbsp;" + Canvas.imgHTML("[SKIN]/actions/back.png"));
            }}
    };

    private ListGrid countryGrid;

    public Canvas getViewPanel() {

        final VLayout layout = new VLayout(10);
        layout.setAutoHeight();

        HLayout hLayout = new HLayout(10);

        countryGrid = createListGrid(true);

        IButton editHilitesButton = new IButton("Edit Hilites");
        editHilitesButton.setAutoFit(true);
        editHilitesButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                countryGrid.editHilites();
            }
        });

        IButton stateButton = new IButton("Recreate from State");
        stateButton.setAutoFit(true);
        stateButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                final String hiliteState = countryGrid.getHiliteState();
                countryGrid.destroy();

                //recreate the ListGrid
                //don't include the hilite array in the create statement to demonstrate
                //re-application from state via setHiliteState()
                final ListGrid newListGrid = createListGrid(false);

                layout.addMember(newListGrid);

                //apply the previous hilite state
                newListGrid.setHiliteState(hiliteState);
            }
        });

        hLayout.addMember(editHilitesButton);
        hLayout.addMember(stateButton);

        layout.addMember(hLayout);


        layout.addMember(countryGrid);
        return layout;

    }

    private ListGrid createListGrid(boolean includeHilites) {

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setLeaveScrollbarGap(true);

        countryGrid.setWidth(750);
        countryGrid.setHeight(224);
        countryGrid.setDataSource(CountryXmlDS.getInstance());
        countryGrid.setAutoFetchData(true);

        //allow users to add formula and summary fields
        //accessible in the grid header context menu
        countryGrid.setCanAddFormulaFields(true);
        countryGrid.setCanAddSummaryFields(true);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");
        countryCodeField.setCanSort(false);

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");

        ListGridField populationField = new ListGridField("population", "Population");
        populationField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (value == null) return null;
                try {
                    NumberFormat nf = NumberFormat.getFormat("0,000");
                    return nf.format(((Number) value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
            }
        });

        ListGridField areaField = new ListGridField("area", "Area (km&sup2;)");
        areaField.setType(ListGridFieldType.INTEGER);
        areaField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (value == null) return null;
                String val = null;
                try {
                    NumberFormat nf = NumberFormat.getFormat("0,000");
                    val = nf.format(((Number) value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
                return val + "km&sup2";
            }
        });

        ListGridField gdpField = new ListGridField("gdp", "GDP");
        gdpField.setAlign(Alignment.RIGHT);
        gdpField.setCellFormatter(new CellFormatter() {
            public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
                if (value == null) return null;
                try {
                    NumberFormat nf = NumberFormat.getFormat("0,000");
                    return "$" + nf.format(((Number) value).longValue());
                } catch (Exception e) {
                    return value.toString();
                }
            }
        });

        countryGrid.setFields(countryCodeField, nameField, capitalField, populationField, areaField, gdpField);

        if(includeHilites) {
            countryGrid.setHilites(hilites);
        }
        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}

