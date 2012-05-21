package com.smartgwt.sample.showcase.client.combobox;

import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.types.MultiComboBoxLayoutStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.MultiComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SpacerItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class MultiComboBoxSample extends ShowcasePanel {
    private static final String DESCRIPTION = "An example of a MultiComboBox";

    private static final Map<String, MultiComboBoxLayoutStyle> layoutStyles;
    static {
        final MultiComboBoxLayoutStyle[] values = MultiComboBoxLayoutStyle.values();
        layoutStyles = new HashMap<String, MultiComboBoxLayoutStyle>(values.length);

        for (MultiComboBoxLayoutStyle value : values) {
            layoutStyles.put(value.getValue(), value);
        }
    }

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

        final MultiComboBoxLayoutStyle initialLayoutStyle = MultiComboBoxLayoutStyle.VERTICAL;

        final DynamicForm form = new DynamicForm();
        form.setMargin(10);
        form.setNumCols(2);
        form.setColWidths(500, 120);
        form.setCellPadding(15);
        form.setTitleOrientation(TitleOrientation.TOP);

        final MultiComboBoxItem supplies = new MultiComboBoxItem("supplies", "Items");
        supplies.setOptionDataSource(ItemSupplyXmlDS.getInstance());
        supplies.setDisplayField("itemName");
        supplies.setValueField("itemID");
        supplies.setAutoFetchData(true);
        supplies.setLayoutStyle(initialLayoutStyle);

        final SpacerItem spacer1 = new SpacerItem(), spacer2 = new SpacerItem();

        final SelectItem layoutStyleSelector = new SelectItem();
        layoutStyleSelector.setTitle("Change layout style");
        layoutStyleSelector.setDefaultValue(initialLayoutStyle.getValue());
        layoutStyleSelector.setValueMap(layoutStyles.keySet().toArray(new String[0]));
        layoutStyleSelector.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                String value = (String) event.getValue();
                supplies.setLayoutStyle(layoutStyles.get(value));
            }
            
        });

        form.setFields(supplies, spacer1, spacer2, layoutStyleSelector);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
