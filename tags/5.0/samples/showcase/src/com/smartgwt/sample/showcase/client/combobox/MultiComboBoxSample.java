package com.smartgwt.sample.showcase.client.combobox;

import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.types.MultiComboBoxLayoutStyle;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.MultiComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;
import com.smartgwt.sample.showcase.client.data.ItemSupplyXmlDS;

public class MultiComboBoxSample extends ShowcasePanel {
    private static final String DESCRIPTION = "A <code>MultiComboBoxItem</code> displays a selection of multiple values as " + 
            "buttons along with a combo box that is used to select additional values. " + 
            "Clicking on a button removes the value from the selection." + 
            "<p>" + 
            "Pressing the Enter/Return key within the combo box selects the first matching value " + 
            "without leaving the field, allowing several values to be selected using only the " + 
            "keyboard. Pressing the Tab key within the combo box selects the first matching value " + 
            "and then leaves the field normally, taking focus to the next focusable item.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
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

    private static final Map<String, MultiComboBoxLayoutStyle> LAYOUT_STYLES;
    static {
        final MultiComboBoxLayoutStyle[] values = MultiComboBoxLayoutStyle.values();
        LAYOUT_STYLES = new HashMap<String, MultiComboBoxLayoutStyle>(values.length);

        for (MultiComboBoxLayoutStyle value : values) {
            LAYOUT_STYLES.put(value.getValue(), value);
        }
    }

    @Override
    public Canvas getViewPanel() {

        final MultiComboBoxLayoutStyle initialLayoutStyle = MultiComboBoxLayoutStyle.FLOW;
        final boolean initialAddUnknownValues = false;

        final MultiComboBoxItem suppliesItem = new MultiComboBoxItem("supplies", "Items");
        suppliesItem.setOptionDataSource(ItemSupplyXmlDS.getInstance());
        suppliesItem.setDisplayField("itemName");
        suppliesItem.setValueField("SKU");
        suppliesItem.setValue(new String[] { "58074604", "90600", "1089400", "6024900" });
        suppliesItem.setAutoFetchData(true);
        suppliesItem.setLayoutStyle(initialLayoutStyle);

        final SelectItem layoutStyleSelector = new SelectItem();
        layoutStyleSelector.setTitle("Change layout style");
        layoutStyleSelector.setColSpan(2);
        layoutStyleSelector.setDefaultValue(initialLayoutStyle.getValue());
        layoutStyleSelector.setValueMap(LAYOUT_STYLES.keySet().toArray(new String[LAYOUT_STYLES.size()]));
        layoutStyleSelector.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                final String value = (String)event.getValue();
                suppliesItem.setLayoutStyle(LAYOUT_STYLES.get(value));
            }
        });

        final CheckboxItem auvCheckbox = new CheckboxItem();
        auvCheckbox.setTitle("Allow New Values");
        auvCheckbox.setValue(initialAddUnknownValues);
        auvCheckbox.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                suppliesItem.setAddUnknownValues((Boolean)event.getValue());
            }
        });

        final DynamicForm configureForm = new DynamicForm();
        configureForm.setIsGroup(true);
        configureForm.setGroupTitle("Configure Multi ComboBox");
        configureForm.setWidth100();
        configureForm.setPadding(3);
        configureForm.setTitleOrientation(TitleOrientation.TOP);
        configureForm.setItems(layoutStyleSelector, auvCheckbox);

        final DynamicForm suppliesForm = new DynamicForm();
        suppliesForm.setWidth100();
        suppliesForm.setNumCols(1);
        suppliesForm.setTitleOrientation(TitleOrientation.TOP);
        suppliesForm.setItems(suppliesItem);

        final VStack layout = new VStack(10);
        layout.setWidth(500);
        layout.setMembers(configureForm, suppliesForm);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
