package com.smartgwt.sample.showcase.client.grid.sortfilter;

import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.WorldXmlDS;

public class GridInlineOperatorFilterSample extends ShowcasePanel {
    private static final String DESCRIPTION = "By default, a ListGrid with <code>showFilterEditor</code> "+
        "set to true will generate "+
        "criteria with a default search operator, according to the grid's <code>textMatchStyle</code>. "+
        "However, if <code>allowFilterOperators</code> is also set to true, users are permitted "+
        "to alter the search operator for any ListGrid field, if its filterEditor field is "+
        "based on regular text input, rather than a picker of some sort."+
        "<p>"+
        "This example shows a grid with <code>allowFilterOperators</code> set to true and "+
        "pre-specified criteria that applies non-standard search operators to two fields - "+
        "<i>Country Name</i> must not contain any 'i' characters and <i>Capital</i> must not "+
        "begin with a 'p'.  You can see that those two fields display an <code>operatorIcon</code> "+
        "that shows the symbol for the corresponding search expression.  You can change the search "+
        "operator either by clicking this icon, if it's visible (otherwise by right-clicking in "+
        "the field), or by using the <code>headerContextMenu</code> to show the \"Filter using\" menu."+
        "<p>"+
        "Try adding a third filter value - right-click the <i>Area</i> field in the filterEditor "+
        "and select \"greater than\" from the \"Filter using\" menu.  Now, enter <code>1001450</code> "+
        "into the search field and press enter.  Click the icon again, select \"less than\" and "+
        "press enter again to enforce the opposite filter.  Click the icon again and select the "+
        "first entry, labelled <i>equals (default)</i> - this reverts the field to using "+
        "its default search operator, and hides the operatorIcon.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridInlineOperatorFilterSample panel = new GridInlineOperatorFilterSample();
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
        countryGrid.setWidth(700);
        countryGrid.setHeight(300);
        countryGrid.setAlternateRecordStyles(true);
        countryGrid.setDataSource(WorldXmlDS.getInstance());

        ListGridField countryCodeField = new ListGridField("countryCode", "Code", 50);
        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField capitalField = new ListGridField("capital", "Capital");
        ListGridField continentField = new ListGridField("continent", "Continent");
        ListGridField areaField = new ListGridField("area", "Area (km²)");
        ListGridField populationField = new ListGridField("population", "Population");

        countryGrid.setFields(countryCodeField, nameField, capitalField, continentField, areaField, populationField);

        countryGrid.setAutoFetchData(true);
        countryGrid.setShowFilterEditor(true);

        AdvancedCriteria criteria = new AdvancedCriteria(OperatorId.AND, new AdvancedCriteria[] {  
            new AdvancedCriteria("countryName", OperatorId.INOT_CONTAINS, "i"),  
            new AdvancedCriteria("capital", OperatorId.INOT_STARTS_WITH, "p")  
        });
        countryGrid.setAllowFilterOperators(true);
        countryGrid.setCriteria(criteria);
    
        return countryGrid;
    }

    protected boolean isTopIntro() {
        return true;
    }
    
    public String getIntro() {
        return DESCRIPTION;
    }
}