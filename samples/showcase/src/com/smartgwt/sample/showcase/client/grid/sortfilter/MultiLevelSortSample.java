package com.smartgwt.sample.showcase.client.grid.sortfilter;

import com.smartgwt.client.data.MultiSortCallback;
import com.smartgwt.client.data.MultiSortDialog;
import com.smartgwt.client.data.SortSpecifier;
import com.smartgwt.client.types.SortDirection;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class MultiLevelSortSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>This grid is displayed pre-sorted on two fields: first by Category ascending and then by " +
            "Item Name descending. As well as the field's title, the header of each field included in the sort configuration displays a " +
            "sort-arrow indicating the direction of sort on that field and, when multiple fields are sorted, a small numeral indicating " +
            "this field's position in the list of fields being sorted. You can hold down SHIFT and click an already sorted column-header " +
            "to reverse it's direction, or an unsorted column- header to add that field to the list of fields being sorted. Clicking a " +
            "column header without holding down SHIFT clears the current sort configuration and initializes a new sort on the selected field.</p>" +
            "<p>Click the \"Multilevel Sort\" button to show a MultiSortDialog. " +
            "Select a set of sort properties and directions and click \"Apply\" to see the grid resorted by those properties.</p>";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            MultiLevelSortSample panel = new MultiLevelSortSample();
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

    protected boolean isTopIntro() {
        return true;
    }

    public Canvas getViewPanel() {
        VLayout layout = new VLayout(10);

        final ListGrid listGrid = new ListGrid();
        listGrid.setWidth(700);
        listGrid.setHeight(300);
        listGrid.setDataSource(ItemSupplyXmlDS.getInstance());
        listGrid.setAutoFetchData(true);
        listGrid.setCanMultiSort(true);
        listGrid.setInitialSort(new SortSpecifier[]{
                new SortSpecifier("category", SortDirection.ASCENDING),
                new SortSpecifier("itemName", SortDirection.DESCENDING)
        });

        IButton button = new IButton("Multilevel Sort");
        button.setIcon("crystal/16/actions/sort_incr.png");
        button.setMinWidth(120);
        button.setAutoFit(true);
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                listGrid.askForSort();
            }
        });

        layout.addMember(button);
        layout.addMember(listGrid);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}