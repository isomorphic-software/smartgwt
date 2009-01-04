package com.smartgwt.sample.showcase.client.combobox;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

import java.util.LinkedHashMap;

public class ComboBoxStyledSample extends ShowcasePanel {
    private static final String DESCRIPTION = "A few examples of styled ComboBox and SelectItems";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            ComboBoxStyledSample panel = new ComboBoxStyledSample();
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

        final DynamicForm form = new DynamicForm();
        form.setWidth(250);       

        ComboBoxItem cbItem = new ComboBoxItem();
        cbItem.setTitle("Select");
        cbItem.setHint("<nobr>A simple ComboBoxItem</nobr>");
        cbItem.setType("comboBox");
        cbItem.setValueMap("Cat", "Dog", "Giraffe", "Goat", "Marmoset", "Mouse");

        SelectItem selectItem = new SelectItem();
        selectItem.setTitle("Select");
        selectItem.setHint("<nobr>A SelectItem with icons</nobr>");
        LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
        valueMap.put("US", "<b>United States</b>");
        valueMap.put("CH", "China");
        valueMap.put("JA", "<b>Japan</b>");
        valueMap.put("IN", "India");
        valueMap.put("GM", "Germany");
        valueMap.put("FR", "France");
        valueMap.put("IT", "Italy");
        valueMap.put("RS", "Russia");
        valueMap.put("BR", "<b>Brazil</b>");
        valueMap.put("CA", "Canada");
        valueMap.put("MX", "Mexico");
        valueMap.put("SP", "Spain");
        selectItem.setValueMap(valueMap);
        selectItem.setImageURLPrefix("flags/16/");
        selectItem.setImageURLSuffix(".png");

        LinkedHashMap<String, String> valueIcons = new LinkedHashMap<String, String>();
        valueIcons.put("US", "US");
        valueIcons.put("CH", "CH");
        valueIcons.put("JA", "JA");
        valueIcons.put("IN", "IN");
        valueIcons.put("GM", "GM");
        valueIcons.put("FR", "FR");
        valueIcons.put("IT", "IT");
        valueIcons.put("RS", "RS");
        valueIcons.put("BR", "BR");
        valueIcons.put("CA", "CA");
        valueIcons.put("MX", "MX");
        valueIcons.put("SP", "SP");
        selectItem.setValueIcons(valueIcons);

        SelectItem selectItem2 = new SelectItem();
        selectItem2.setTitle("Select");
        selectItem2.setHint("<nobr>A SelectItem with styled entries</nobr>");
        selectItem2.setValueMap("<span style='color:#FF0000;'>Red</span>",
                "<span style='color:#00FF00;'>Green</span>",
                "<span style='color:#0000FF;'>Blue</span>");

        form.setFields(cbItem, selectItem, selectItem2);
        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }

}