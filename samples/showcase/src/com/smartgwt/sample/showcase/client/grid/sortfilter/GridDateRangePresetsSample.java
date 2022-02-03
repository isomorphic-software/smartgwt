package com.smartgwt.sample.showcase.client.grid.sortfilter;

import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.Criterion;
import com.smartgwt.client.data.Operator;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.types.OperatorValueType;
import com.smartgwt.client.types.FieldType;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.FilterBuilder;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.PresetDateRangeXmlDS;
import com.smartgwt.sample.showcase.client.data.RecentDateRangeItem;



public class GridDateRangePresetsSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "SmartClient provides a <code>PresetCriteriaItem</code>, which allows a user to select " +
        "criteria from a SelectItem using a recognizable display-name, from a list of options " +
        "provided to it. The item can also include a \"Custom...\" entry which, when selected, " +
        "calls the <code>getCustomCriteria()</code> override point, allowing the developer to provide a " +
        "custom interface for selecting criteria. There's also a simple subclass of this item, " +
        "<code>PresetDateRangeItem</code>, which has custom code to show a DateRangeDialog for " +
        "collecting custom-criteria." +
        "<p>This example demonstrates using a subclass of the second example in both a ListGrid's " +
        "FilterEditor, and in a stand-alone FilterBuilder. A simple subclass of " +
        "<code>PresetDateRangeItem</code> is created, called <i>RecentDateRangeItem</i>, that lists a number of " +
        "common options for filtering by recent date ranges. This is then used as an editor in " +
        "both UIs. In the first example, select an option in the \"Order Date\" field and click " +
        "the 'Filter' icon to see the filter applied. In the second example, choose " +
        "a named-range in the \"value\" field to the right of the FilterBuilder and click the " + 
        "'Filter' button below to have the selected criteria applied to the bottom grid.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            GridDateRangePresetsSample panel = new GridDateRangePresetsSample();
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
        VLayout layout = new VLayout(8);
        layout.setWidth100();
        layout.setHeight100();
        layout.setMembersMargin(10);

        // ---------------------------------------------------------------------------------------
        // Date Range (Presets)
        Label dateRangeLabel = new Label();
        dateRangeLabel.setWidth(650);
        dateRangeLabel.setHeight(25);
        dateRangeLabel.setContents("RecentDateRangeItem (ListGrid FilterEditor)");
        dateRangeLabel.setBaseStyle("exampleSeparator");

        PresetDateRangeXmlDS dataSource = PresetDateRangeXmlDS.getInstance();
        
        // Create a ListGrid displaying data from the worldDS  
        final ListGrid grid1 = new ListGrid();
        grid1.setWidth(650);
        grid1.setDataSource(dataSource);
        grid1.setShowFilterEditor(true);

        RecentDateRangeItem rangeItem = new RecentDateRangeItem();
        rangeItem.setWidth("*");
        rangeItem.setShowTitle(false);

        Operator operator = new Operator();
        operator.setID("recentDateRange");
        operator.setTitle("in recent date range");
        operator.setValueType(OperatorValueType.CUSTOM);
        operator.setEditorType("com.smartgwt.sample.showcase.client.data.RecentDateRangeItem");
        
        FieldType[] types = new FieldType[1];
        types[0] = FieldType.DATE;
        dataSource.addSearchOperator(operator, types);

        ListGridField orderDate = new ListGridField("orderDate", "Order Date");
        orderDate.setFilterEditorProperties(rangeItem);
        orderDate.setCanFilter(true);
        grid1.setUseAllDataSourceFields(true);
        grid1.setFields(orderDate);
        grid1.setAutoFetchData(true);

        // ---------------------------------------------------------------------------------------
        // FilterBuilder Example 
        Label filterBuilderLabel = new Label();
        filterBuilderLabel.setWidth(650);
        filterBuilderLabel.setHeight(25);
        filterBuilderLabel.setContents("RecentDateRangeItem (FilterBuilder)");
        filterBuilderLabel.setBaseStyle("exampleSeparator");

        final FilterBuilder filterBuilder = new FilterBuilder();
        filterBuilder.setWidth(650);
        filterBuilder.setDataSource(dataSource);
        AdvancedCriteria ac = new AdvancedCriteria(OperatorId.AND);
        Criterion c = new Criterion();
        c.setFieldName("orderDate");
        ac.addCriteria(c);
        filterBuilder.setCriteria(ac);

        final ListGrid grid2 = new ListGrid();

        Button searchButton = new Button("Filter");
        searchButton.setAutoFit(true);
        searchButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				AdvancedCriteria criteria = filterBuilder.getCriteria();
				grid2.fetchData(criteria);
			}
		});

        grid2.setWidth(650);
        grid2.setDataSource(dataSource);
        grid2.setAutoFetchData(true);
        grid2.setShowFilterEditor(false);
        grid2.setUseAllDataSourceFields(true);
        
        layout.setMembers(dateRangeLabel, grid1, filterBuilderLabel, filterBuilder, searchButton, grid2);
        return layout;
    }

    @Override
    protected boolean shouldWrapViewPanel() {
        return true;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
