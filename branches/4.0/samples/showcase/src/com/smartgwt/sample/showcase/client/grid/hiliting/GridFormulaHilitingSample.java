package com.smartgwt.sample.showcase.client.grid.hiliting;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.data.AdvancedCriteria;
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

public class GridFormulaHilitingSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Hiliting can be applied to any field in a DataBoundComponent, including custom formula and summary fields.</p>" +
            "<p>Launch the Formula Builder and enter the title of the new field, and the desired formula. In this case, enter Population Density for the field title " +
            "and in the formula field enter <b>A / B</b>. As indicated in the dialog, <b>A</b> represents the Population field, and <b>B</b> represents the Area field. Notice that you can now " +
            "sort on this newly added Population Density field just like any other field. Click the help icon to view the various supported inbuilt functions.</p>" +
            "<p>Now, click the \"Edit Hilites\" button to show the HiliteEditor interface. To set up a simple hilite on the custom <b>Population Density</b> field, select it " +
            "in the list to the left. When the simple hilite rule appears on the right, select the \"greater than\" operation from the drop-down box, type \"300\" into the " +
            "value textBox, select a color from the 'Color' picker widget and click 'Save'. You'll see that all the grid-values in the <b>Population Density</b> field that exceed 300 " +
            "are now hilighted in your chosen color. </p> ";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridFormulaHilitingSample panel = new GridFormulaHilitingSample();
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

    
    public Canvas getViewPanel() {

        final VLayout layout = new VLayout(10);
        layout.setAutoHeight();

        HLayout hLayout = new HLayout(10);

        IButton formulaButton = new IButton("Show Formula Builder");
        formulaButton.setAutoFit(true);
        formulaButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ListGrid listGrid = (ListGrid) Canvas.getById("countryListFB");
                listGrid.addFormulaField();
            }
        });

        IButton editHilitesButton = new IButton("Edit Hilites");
        editHilitesButton.setAutoFit(true);
        editHilitesButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ListGrid listGrid = (ListGrid) Canvas.getById("countryListFB");
                listGrid.editHilites();
            }
        });

        IButton stateButton = new IButton("Recreate from State");
        stateButton.setAutoFit(true);
        stateButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                ListGrid listGrid = (ListGrid) Canvas.getById("countryListFB");
                final String hiliteState = listGrid.getHiliteState();
                listGrid.destroy();

                //recreate the ListGrid
                //don't include the hilite array in the create statement to demonstrate
                //re-application from state via setHiliteState()
                final ListGrid newListGrid = createListGrid(false);

                layout.addMember(newListGrid);

                //apply the previous hilite state
                newListGrid.setHiliteState(hiliteState);
            }
        });

        hLayout.addMember(formulaButton);
        hLayout.addMember(editHilitesButton);
        hLayout.addMember(stateButton);

        layout.addMember(hLayout);

        ListGrid countryGrid = createListGrid(true);
        layout.addMember(countryGrid);
        return layout;

    }

    private ListGrid createListGrid(boolean includeHilites) {

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setID("countryListFB");
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
        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}

