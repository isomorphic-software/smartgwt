package com.smartgwt.sample.showcase.client.grid.sortfilter;

import com.smartgwt.client.data.Criterion;
import com.smartgwt.client.data.DateRange;
import com.smartgwt.client.data.RelativeDate;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.DateRangeItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.WorldXmlDS;


public class GridDateRangeFilterSample extends ShowcasePanel {
    
    private static final String DESCRIPTION = "<p>Smart GWT provides special widgets for filtering date values, including recognised " +
            "RelativeDate values that cause filtering relative to some other base-date.</p>" +
            "<p>The RelativeDateRangeItem allows selection of dates in three ways: you can select a preset DateRange, like \"Today\" or \"Tomorrow\", " +
            "or a \"ranged\" date-string, such as \"N days from now\" and enter a quantity to associate with it, or you can directly enter a date-string " +
            "in a recognized format. You can also select a date from the DateChooser by click the icon to the right of the widget. <p>" +
            "<p>The first example below demonstrates using a DateRangeItem in a separate DynamicForm to filter a ListGrid. Select start and end values for the range " +
            "using one of the methods described above and click the \"Search\" button to see the data filtered according to the values in the \"Nationhood\" field.</p>" +
            "<p>The second example below demonstrates filtering grid data using a MiniDateRangeItem to filter data when a ListGrid is showing it's FilterEditor. " +
            "In this example, click the Date icon in the header for the Nationhood field to open a popup DateRangeItemDialog. In the dialog, select start and end values " +
            "for the range, as described above, and click Ok to close the Window. Then click the Filter button in the top right of the grid to see the data filtered. " +
            "You can hover the mouse over the Nationhood field-header to see the full date-range string.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            GridDateRangeFilterSample panel = new GridDateRangeFilterSample();
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
        layout.setHeight100();
        layout.setWidth100();
        layout.setMembersMargin(10);

        // ---------------------------------------------------------------------------------------
        // Seperate DynamicForm Example (DateRangeItem)
        Label dateRangeLabel = new Label();
        dateRangeLabel.setWidth(595);
        dateRangeLabel.setHeight(25);
        dateRangeLabel.setContents("External DynamicForm (DateRangeItem)");
        dateRangeLabel.setBaseStyle("exampleSeparator");

        DynamicForm form = new DynamicForm();
        form.setWidth(500);
        form.setTitleOrientation(TitleOrientation.TOP);

        final DateRangeItem rangeItem = new DateRangeItem("independence");
        rangeItem.setWidth("*");
        rangeItem.setShowTitle(false);
        rangeItem.setAllowRelativeDates(true);

        DateRange dateRange = new DateRange();
        dateRange.setRelativeStartDate(new RelativeDate("-1200m"));
        dateRange.setRelativeEndDate(new RelativeDate("-1000m"));
        rangeItem.setValue(dateRange);

        // Create a ListGrid displaying data from the worldDS
        final ListGrid grid1 = new ListGrid();
        grid1.setWidth(595);
        grid1.setDataSource(WorldXmlDS.getInstance());

        ButtonItem searchButtonItem = new ButtonItem("Filter");
        searchButtonItem.setAutoFit(true);
        searchButtonItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
            @Override
            public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent event) {
                Criterion criteria = rangeItem.getCriterion();                
                grid1.fetchData(criteria);
            }
        });
        form.setItems(rangeItem, searchButtonItem);

        // ---------------------------------------------------------------------------------------
        // Inline FilterEditor Example (MiniDateRangeItem)
        Label filterEditorLabel = new Label("FilterEditor (MiniDateRangeItem)");
        filterEditorLabel.setWidth(595);
        filterEditorLabel.setBaseStyle("exampleSeparator");
        filterEditorLabel.setHeight(25);

        // Create a ListGrid displaying data from the worldDS and also displaying a FilterEditor
        final ListGrid grid2 = new ListGrid();
        grid2.setWidth(595);
        grid2.setDataSource(WorldXmlDS.getInstance());
        grid2.setAutoFetchData(true);
        grid2.setShowFilterEditor(true);

        layout.setMembers(dateRangeLabel, form, grid1, filterEditorLabel, grid2);

        layout.addDrawHandler(new DrawHandler() {
            @Override
            public void onDraw(DrawEvent event) {
                Criterion criteria = rangeItem.getCriterion();
                grid1.fetchData(criteria);
            }
        });

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}