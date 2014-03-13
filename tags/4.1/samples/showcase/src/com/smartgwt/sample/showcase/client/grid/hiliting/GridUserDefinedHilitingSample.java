package com.smartgwt.sample.showcase.client.grid.hiliting;

import com.google.gwt.i18n.client.NumberFormat;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
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

public class GridUserDefinedHilitingSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>DataBoundComponents allow end-users to create 'hilites' with rules based " +
            "on the values of data. There are two sorts of hilites: simple hilites, which allow a single criterion based on a single " +
            "field to affect a single target field (the same one), and Advanced hilites, which allow very complex criteria, based on multiple fields, " +
            "to affect multiple target fields.</p>" +
            "<p>Click the \"Edit Hilites\" button below to show the HiliteEditor interface. To set up a simple hilite, click on the \"Area (km<sup>2</sup>)\" record in " +
            "the list to the left. When the simple hilite rule appears on the right, select the \"greater than\" operation from the drop-down box, type \"5000000\" " +
            "into the value textBox, select a color from the 'Color' picker widget and click 'Save'. You'll see that all \"Area (km<sup>2</sup>)\" values in the grid that exceed " +
            "5000000 are now hilighted in your chosen color.</p>" +
            "<p>Now, add an Advanced criteria. Again, click the \"Edit Hilites\" button and then click the \"Add Advanced Rule\" button in the top left of the " +
            "HiliteEditor - you'll now see the AdvancedHiliteEditor window. Add a new criterion that specifies <i>GDP ($M) greater than 1000000</i>. Click the green plus " +
            "icon beneath the criterion and add a second one, this time specifying <i>Area (km<sup>2</sup>) less than 500000</i>. In the list below, select both \"GDP ($M)\" and \"Area (km<sup>2</sup>)\" " +
            "and select a background color. Clicking 'Save' now will update the grid, showing both GDP and Area data in your selected background color, when GDP is higher than " +
            "1 million and Area is less than <i>500,000</i>.</p>" +
            "<p>You can easily provide users with the ability to save and restore their hilite information - all you need is the ability to save a string. Click the button below to " +
            "see the grid's hilite state retrieved and serialized, by calling <i>getHiliteState()</i>, the grid destroyed and it's hilite-state restored to another grid via </i>setHiliteState()</i>.</p> ";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridUserDefinedHilitingSample panel = new GridUserDefinedHilitingSample();
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

    private ListGrid countryGrid;

    public Canvas getViewPanel() {
        final VLayout layout = new VLayout(10);
        layout.setAutoHeight();
        
        HLayout hLayout = new HLayout(10);

        countryGrid = createListGrid();

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
                final ListGrid newListGrid = createListGrid();
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

    private ListGrid createListGrid() {

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

        return countryGrid;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}

