package com.smartgwt.sample.showcase.client.forms.controls;

import com.smartgwt.client.data.DateRange;
import com.smartgwt.client.data.RelativeDate;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class DateControlsSample extends ShowcasePanel {

    private static final String DESCRIPTION = "<p>Demonstration of various Date related controls.</p>" +
            "<p>The RelativeDateRangeItem allows selection of dates in three ways: you can select a preset date-string, like \"Today\" or \"Tomorrow\", " +
            "or a \"ranged\" date-string, such as \"N days from now\" and enter a quantity to associate with it, or you can directly enter a date-string " +
            "in a recognized format. You can also select a date from the DateChooser by click the icon to the right of the widget. <p>";


    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            DateControlsSample panel = new DateControlsSample();
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

        DynamicForm dateForm = new DynamicForm();
        dateForm.setWidth(450);
        dateForm.setHeight(300);
        dateForm.setCellPadding(5);
        dateForm.setIsGroup(true);
        dateForm.setGroupTitle("Date Controls");

        DateItem dateItem = new DateItem();
        dateItem.setTitle("Date");
        dateItem.setHint("<nobr>Picklist based date input</nobr>");

        DateItem dateItem2 = new DateItem();
        dateItem2.setTitle("Date");
        dateItem2.setUseTextField(true);
        dateItem2.setHint("<nobr>Direct date input</nobr>");

        TimeItem timeItem = new TimeItem("timeItem", "Time");

        DateRangeItem dateRangeItem = new DateRangeItem("dri", "Date Range");
        dateRangeItem.setAllowRelativeDates(true);
        DateRange dateRange = new DateRange();
        dateRange.setRelativeStartDate(RelativeDate.TODAY);
        dateRange.setRelativeEndDate(new RelativeDate("-1m"));
        dateRangeItem.setValue(dateRange);

        MiniDateRangeItem miniDateRangeItem = new MiniDateRangeItem("mdri", "Mini Date Range");

        RelativeDateItem relativeDateItem = new RelativeDateItem("rdi", "Relative Date");

        dateForm.setItems(dateItem, dateItem2, timeItem, dateRangeItem, miniDateRangeItem, relativeDateItem);

        return dateForm;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

    @Override
    protected boolean isTopIntro() {
        return true;
    }
}