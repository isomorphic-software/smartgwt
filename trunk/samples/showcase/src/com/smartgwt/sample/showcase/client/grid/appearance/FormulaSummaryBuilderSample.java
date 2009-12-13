package com.smartgwt.sample.showcase.client.grid.appearance;

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

public class FormulaSummaryBuilderSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p><b>Formula and Summary fields</b> provide built-in wizards for end users " +
            "to define formula fields that can compute values using other fields, or summary fields that can combine other fields with " +
            "intervening / surrounding text. Available in all DataBoundComponents, easy to persist aspreferences.</p>" +
            "<p>The Formula and Summary Builder are accessible from the grid header context menu. They can also be invoked programatically as " +
            "demonstracted by clicking the buttons in this sample</p>" +
            "<p>Launch the Formula Builder and enter the title of the new field, and the desired formula. For example, enter <b>Population Density</b> " +
            "for the field name and in the formula field enter <b>A / B</b>. As indicated in the dialog, A represents the Population field, and B represents the Area field. " +
            "Notice that you can now sort on this newly added <b>Population Density</b> field just like any other field. Click the help icon to view the various supported inbuilt functions.</p>" +
            "<p>Next launch the Summary Builder and enter the title of the new field, and the Summary formulation. For example, enter <b>County (Flag)</b> " +
            "for the field name and enter <b>#B (#A)</b> in the summary field.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FormulaSummaryBuilderSample panel = new FormulaSummaryBuilderSample();
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

        VLayout layout = new VLayout(15);

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

        layout.addMember(countryGrid);

        HLayout buttonLayout = new HLayout(15);

        IButton formulaButton = new IButton("Show Formula Builder");
        formulaButton.setAutoFit(true);
        formulaButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.addFormulaField();
            }
        });

        IButton summaryBuilder = new IButton("Show Summary Builder");
        summaryBuilder.setAutoFit(true);
        summaryBuilder.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                countryGrid.addSummaryField();
            }
        });

        buttonLayout.addMember(formulaButton);
        buttonLayout.addMember(summaryBuilder);

        layout.addMember(buttonLayout);

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}