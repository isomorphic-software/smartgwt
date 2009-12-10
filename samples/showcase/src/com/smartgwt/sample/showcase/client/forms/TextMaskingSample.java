package com.smartgwt.sample.showcase.client.forms;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.TimeItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TextMaskingSample extends ShowcasePanel {
    private static final String DESCRIPTION = "<p>TextItems support a masked entry to restrict and format entry.</p>" +
            "<p>Overview of available mask characters <P> <table class=\"normal\"> <tr><th>Character</th><th>Description</th></tr> " +
            "<tr><td>0</td><td>Digit (0 through 9) or plus [+] or minus [-] signs</td></tr> <tr><td>9</td><td>Digit or " +
            "space</td></tr> <tr><td>#</td><td>Digit</td></tr> <tr><td>L</td><td>Letter (A through Z)</td></tr> " +
            "<tr><td>?</td><td>Letter (A through Z) or space</td></tr> <tr><td>A</td><td>Letter or digit</td></tr> " +
            "<tr><td>a</td><td>Letter or digit</td></tr> <tr><td>C</td><td>Any character or space</td></tr> <tr><td>&nbsp;</td></tr> " +
            "<tr><td>&lt;</td><td>Causes all characters that follow to be converted to lowercase</td></tr> <tr><td>&gt;</td><td>Causes " +
            "all characters that follow to be converted to uppercase</td></tr> </table> <P> Any character not matching one of the " +
            "above mask characters or that is escaped with a backslash (\\) is considered to be a literal. <P> Custom mask characters " +
            "can be defined by standard regular expression character set or range. For example, a hexadecimal color code mask could " +
            "be: <UL> <LI>Color: \\#>[0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F][0-9A-F]</LI> </UL></p?";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
        	TextMaskingSample panel = new TextMaskingSample();
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
        DynamicForm form = new DynamicForm();
        form.setWidth(400);

        TextItem firstName = new TextItem("firstName", "First name");
        firstName.setMask(">?<??????????????");
        firstName.setHint("<nobr>&gt;?&lt;??????????????<nobr>");

        TextItem lastName = new TextItem("lastName", "Last name");
        lastName.setMask(">?<??????????????");
        lastName.setHint("<nobr>&gt;?&lt;??????????????<nobr>");

        TextItem stateField = new TextItem("state", "State");
        stateField.setMask(">LL");
        stateField.setHint("<nobr>&gt;LL</nobr>");

        TextItem phoneNumberField = new TextItem("phoneNo", "Phone No.");
        phoneNumberField.setMask("(###) ###-####");
        phoneNumberField.setHint("<nobr>(###)&nbsp;###-####</nobr>");

        DateItem dateField = new DateItem("dateItem", "Date");
        dateField.setUseTextField(true);
        dateField.setUseMask(true);

        DateTimeItem dateTimeField = new DateTimeItem("dateTimeItem", "Date Time");
        dateTimeField.setUseTextField(true);
        dateTimeField.setUseMask(true);

        TimeItem timeField = new TimeItem("timeItem", "Time");
        timeField.setUseMask(true);

        form.setFields(firstName, lastName, stateField, phoneNumberField, dateField, dateTimeField, timeField);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}