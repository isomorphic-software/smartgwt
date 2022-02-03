package com.smartgwt.sample.showcase.client.grid.interaction;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.ListGridFieldType;
import com.smartgwt.client.types.SelectionType;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.HoverCustomizer;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.CountrySampleData;

public class ValueHoverTipsSample extends ShowcasePanel {

    private static String[] governmentDescription = new String[]{
            "<b>Communism</b> - a system of government in which the state plans and controls the economy and a single - often authoritarian - party holds power; state controls are imposed with the elimination of private ownership of property or capital while claiming to make progress toward a higher social order in which all goods are equally shared by the people (i.e., a classless society).",
            "<b>Constitutional monarchy</b> - a system of government in which a monarch is guided by a constitution whereby his/her rights, duties, and responsibilities are spelled out in written law or by custom.",
            "<b>Federal republic</b> - a state in which the powers of the central government are restricted and in which the component parts (states, colonies, or provinces) retain a degree of self-government; ultimate sovereign power rests with the voters who chose their governmental representatives.",
            "<b>Federal (Federative)</b> - a form of government in which sovereign power is formally divided - usually by means of a constitution - between a central authority and a number of constituent regions (states, colonies, or provinces) so that each region retains some management of its internal affairs; differs from a confederacy in that the central government exerts influence directly upon both individuals as well as upon the regional units.",
            "<b>Parliamentary monarchy</b> - a state headed by a monarch who is not actively involved in policy formation or implementation (i.e., the exercise of sovereign powers by a monarch in a ceremonial capacity); true governmental leadership is carried out by a cabinet and its head - a prime minister, premier, or chancellor - who are drawn from a legislature (parliament).",
            "<b>Republic</b> - a representative democracy in which the people's elected deputies (representatives), not the people themselves, vote on legislation."
    };
    private static final String DESCRIPTION = "Move the mouse over a value in the \"Government\" column and pause (hover) for a longer description of that value.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            ValueHoverTipsSample panel = new ValueHoverTipsSample();
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

        Canvas canvas = new Canvas();

        final ListGrid countryGrid = new ListGrid();
        countryGrid.setWidth(500);
        countryGrid.setHeight(224);
        countryGrid.setShowAllRecords(true);
        countryGrid.setWrapCells(true);
        // taller rows to fit 'government' values
        countryGrid.setCellHeight(32);
        countryGrid.setHoverWidth(300);

        ListGridField countryCodeField = new ListGridField("countryCode", "Flag", 50);
        countryCodeField.setAlign(Alignment.CENTER);
        countryCodeField.setType(ListGridFieldType.IMAGE);
        countryCodeField.setImageURLPrefix("flags/16/");
        countryCodeField.setImageURLSuffix(".png");

        ListGridField nameField = new ListGridField("countryName", "Country");
        ListGridField governmentField = new ListGridField("government", "Government", 120);
        governmentField.setShowHover(true);
        governmentField.setHoverCustomizer(new HoverCustomizer() {
            public String hoverHTML(Object value, ListGridRecord record, int rowNum, int colNum) {
                int governmentDesc = record.getAttributeAsInt("government_desc");
                return governmentDescription[governmentDesc];
            }
        });

        countryGrid.setFields(countryCodeField, nameField, governmentField);
        countryGrid.setCanResizeFields(true);
        countryGrid.setData(CountrySampleData.getRecords());
        canvas.addChild(countryGrid);

        IButton everyCell = new IButton("Show Hover on every cell");
        everyCell.setWidth(250);
        everyCell.setTop(250);
        everyCell.setActionType(SelectionType.RADIO);
        everyCell.setRadioGroup("canHover");
        everyCell.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                // When canHover is true on a ListGrid, cells will show hover text unless field.showHover is false
                countryGrid.setCanHover(true);
            }
        });
        canvas.addChild(everyCell);

        IButton governmentCell = new IButton("Show Hover on <i>Government</i> cells only");
        governmentCell.setWidth(250);
        governmentCell.setTop(300);
        governmentCell.setActionType(SelectionType.RADIO);
        governmentCell.setRadioGroup("canHover");
        governmentCell.setSelected(true);
        governmentCell.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                // When canHover is unset on a ListGrid, cells will show hover text if field.showHover is true
                countryGrid.setCanHover(null);
            }
        });
        canvas.addChild(governmentCell);

        IButton noCell = new IButton("Suppress all cell hovers");
        noCell.setWidth(250);
        noCell.setTop(350);
        noCell.setActionType(SelectionType.RADIO);
        noCell.setRadioGroup("canHover");
        noCell.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                // When canHover is false on a ListGrid, cells will not show any hover text
                countryGrid.setCanHover(false);
                //countryGrid.setHoverWidth(5);
            }
        });
        canvas.addChild(noCell);

        return canvas;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}