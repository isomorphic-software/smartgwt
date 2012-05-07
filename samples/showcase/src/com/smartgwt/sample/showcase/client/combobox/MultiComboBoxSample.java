package com.smartgwt.sample.showcase.client.combobox;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.MultiComboBoxLayoutStyle;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.HeaderItem;
import com.smartgwt.client.widgets.form.fields.MultiComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.SubmitItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.EmployeeXmlDS;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class MultiComboBoxSample extends ShowcasePanel {
    private static final String DESCRIPTION = "A few examples of a MultiComboBox";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            MultiComboBoxSample panel = new MultiComboBoxSample();
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
        final int commonHeight = 100;
        final String lighterGrey = "#f0f0f0", darkerGrey = "#e0e0e0";

        final DynamicForm form = new DynamicForm();
        form.setMargin(10);
        form.setCellPadding(4);
        form.setWidth(500);

        HeaderItem bomHeader = new HeaderItem();
        bomHeader.setDefaultValue("Bill of Materials");

        MultiComboBoxItem bom = new MultiComboBoxItem("bom", "Items");
        bom.setOptionDataSource(ItemSupplyXmlDS.getInstance());
        bom.setDisplayField("itemName");
        bom.setValueField("itemID");
        ComboBoxItem bomComboBoxProperties = new ComboBoxItem();
        bomComboBoxProperties.setAutoFetchData(true);
        bom.setComboBoxItemProperties(bomComboBoxProperties);
        bom.setLayoutStyle(MultiComboBoxLayoutStyle.FLOW);
        bom.setShrinkwrapButtonValues(true);
        bom.setHeight(commonHeight);

        SpacerItem spacer = new SpacerItem();

        HeaderItem scheduleHeader = new HeaderItem();
        scheduleHeader.setDefaultValue("Schedule a Meeting");

        DateTimeItem dateTime = new DateTimeItem("dateAndTime", "Date &amp; Time");

        MultiComboBoxItem conferenceRooms = new MultiComboBoxItem("conferenceRooms", "Reserve Conference Rooms");
        ComboBoxItem conferenceRoomsComboBoxProperties = new ComboBoxItem();
        conferenceRoomsComboBoxProperties.setValueMap("Main", "Floor 13", "Basement", "Annex", "Courtyard");
        conferenceRooms.setComboBoxItemProperties(conferenceRoomsComboBoxProperties);
        conferenceRooms.setLayoutStyle(MultiComboBoxLayoutStyle.HORIZONTAL);

        MultiComboBoxItem attendees = new MultiComboBoxItem("employees", "Employees to Attend");
        attendees.setOptionDataSource(EmployeeXmlDS.getInstance());
        attendees.setDisplayField("Name");
        attendees.setValueField("EmployeeId");
        ComboBoxItem attendeesComboBoxProperties = new ComboBoxItem();
        attendeesComboBoxProperties.setAutoFetchData(true);
        attendees.setComboBoxItemProperties(attendeesComboBoxProperties);
        IButton attendeeButtonProperties = new IButton();
        attendeeButtonProperties.setAlign(Alignment.LEFT);
        attendeeButtonProperties.setIcon("[SKIN]actions/ok.png");
        attendeeButtonProperties.setIconAlign("left");
        attendees.setButtonProperties(attendeeButtonProperties);
        attendees.setLayoutStyle(MultiComboBoxLayoutStyle.VERTICAL);
        attendees.setHeight(commonHeight);

        SubmitItem submit = new SubmitItem();
        submit.setTitle("Send");

        form.setFields(bomHeader, bom, spacer, scheduleHeader, dateTime, conferenceRooms, attendees, submit);
        // Ensure that DynamicForm.create() has been called.  This allows us to obtain the
        // canvases of the MultiComboBoxItems via CanvasItem.getCanvas().
        form.getOrCreateJsObj();

        bom.getCanvas().setBackgroundColor(lighterGrey);
        bom.getCanvas().setBorder("1px solid " + darkerGrey);
        conferenceRooms.getCanvas().setBackgroundColor(lighterGrey);
        conferenceRooms.getCanvas().setBorder("1px solid " + darkerGrey);
        attendees.getCanvas().setBackgroundColor(lighterGrey);
        attendees.getCanvas().setBorder("1px solid " + darkerGrey);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
