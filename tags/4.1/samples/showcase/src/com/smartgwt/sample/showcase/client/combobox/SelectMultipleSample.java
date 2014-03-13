package com.smartgwt.sample.showcase.client.combobox;

import com.smartgwt.client.types.MultipleAppearance;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

import java.util.LinkedHashMap;

public class SelectMultipleSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Demonstration of Select items with multiple selections";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            SelectMultipleSample panel = new SelectMultipleSample();
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

        DynamicForm selectComboForm = new DynamicForm();
        selectComboForm.setWidth(450);


        final SelectItem selectItemMultipleGrid = new SelectItem();
        selectItemMultipleGrid.setTitle("Select Multiple (Grid)");
        selectItemMultipleGrid.setMultiple(true);
        selectItemMultipleGrid.setMultipleAppearance(MultipleAppearance.GRID);
        selectItemMultipleGrid.setValueMap("Cat", "Dog", "Giraffe", "Goat", "Marmoset", "Mouse");

        final SelectItem selectItemMultiplePickList = new SelectItem();
        selectItemMultiplePickList.setTitle("Select Multiple (PickList)");
        selectItemMultiplePickList.setMultiple(true);
        selectItemMultiplePickList.setMultipleAppearance(MultipleAppearance.PICKLIST);
        selectItemMultiplePickList.setValueMap("Cat", "Dog", "Giraffe", "Goat", "Marmoset", "Mouse");

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

        final SelectItem selectItemWithIcons = new SelectItem();
        selectItemWithIcons.setMultiple(true);
        selectItemWithIcons.setTitle("Select");
        selectItemWithIcons.setHint("<nobr>Multi Select with icons</nobr>");
        selectItemWithIcons.setValueMap(valueMap);
        selectItemWithIcons.setImageURLPrefix("flags/16/");
        selectItemWithIcons.setImageURLSuffix(".png");
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
        selectItemWithIcons.setValueIcons(valueIcons);


        selectComboForm.setItems(selectItemMultipleGrid, selectItemMultiplePickList, selectItemWithIcons);

        return selectComboForm;

    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
