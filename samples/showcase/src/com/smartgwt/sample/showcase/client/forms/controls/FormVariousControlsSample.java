package com.smartgwt.sample.showcase.client.forms.controls;

import java.util.LinkedHashMap;

import com.smartgwt.client.data.DateRange;
import com.smartgwt.client.data.RelativeDate;
import com.smartgwt.client.types.MultipleAppearance;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ColorPickerItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.DateRangeItem;
import com.smartgwt.client.widgets.form.fields.LinkItem;
import com.smartgwt.client.widgets.form.fields.MiniDateRangeItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.RelativeDateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SliderItem;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.TimeItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormVariousControlsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Demonstration of several form controls.";

    public static class Factory implements PanelFactory {
        private String id;

        public ShowcasePanel create() {
            FormVariousControlsSample panel = new FormVariousControlsSample();
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
        VLayout layout = new VLayout(10);

        final DynamicForm form = new DynamicForm();
        form.setWidth(620);
        form.setColWidths(190, "*");

        TextItem textItem = new TextItem();
        textItem.setTitle("Text");
        textItem.setHint("<nobr>A plain text field</nobr>");

        TextAreaItem textAreaItem = new TextAreaItem();
        textAreaItem.setTitle("TextArea");

        ColorPickerItem colorPicker = new ColorPickerItem();
        colorPicker.setTitle("Color Picker");

        SpinnerItem stackedSpinnerItem = new SpinnerItem();
        stackedSpinnerItem.setTitle("Stacked Spinner");
        stackedSpinnerItem.setDefaultValue(5);
        stackedSpinnerItem.setMin(0);
        stackedSpinnerItem.setMax(10);
        stackedSpinnerItem.setStep(0.5f);
        stackedSpinnerItem.setWriteStackedIcons(true);

        SpinnerItem unstackedSpinnerItem = new SpinnerItem();
        unstackedSpinnerItem.setTitle("Unstacked Spinner");
        unstackedSpinnerItem.setDefaultValue(5);
        unstackedSpinnerItem.setMin(0);
        unstackedSpinnerItem.setMax(10);
        unstackedSpinnerItem.setStep(0.5f);
        unstackedSpinnerItem.setWriteStackedIcons(false);

        SliderItem sliderItem = new SliderItem();
        sliderItem.setTitle("Slider");
        sliderItem.setHeight(40);
        sliderItem.setMinValue(1.0);
        sliderItem.setMaxValue(5.0);
        sliderItem.setNumValues(5);
        sliderItem.setDefaultValue(4);

        LinkItem linkItem = new LinkItem("link");
        linkItem.setTitle("LinkItem");
        linkItem.setLinkTitle("Click Me");
        linkItem.setHeight(80);
        linkItem.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                SC.say("Hello World");
            }
        });

        CheckboxItem checkboxItem = new CheckboxItem();
        checkboxItem.setTitle("Checkbox");
        checkboxItem.setHeight(25);

        RadioGroupItem radioGroupItem = new RadioGroupItem();
        radioGroupItem.setTitle("Radio Group");
        radioGroupItem.setValueMap("Option 1", "Option 2");

        form.setFields(textItem, colorPicker, textAreaItem, stackedSpinnerItem, unstackedSpinnerItem,
                sliderItem, linkItem, checkboxItem, radioGroupItem);
        layout.addMember(form);

        DynamicForm selectComboForm = new DynamicForm();
        selectComboForm.setWidth(620);
        selectComboForm.setColWidths(190, "*");
        selectComboForm.setIsGroup(true);
        selectComboForm.setGroupTitle("Select / Combo Controls");

        ComboBoxItem cbItem = new ComboBoxItem();
        cbItem.setTitle("ComboBox");
        cbItem.setHint("<nobr>A simple combobox</nobr>");
        cbItem.setType("comboBox");
        cbItem.setValueMap("Cat", "Dog", "Giraffe", "Goat", "Marmoset", "Mouse");

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

        final SelectItem selectItem = new SelectItem();
        selectItem.setTitle("Select");
        selectItem.setHint("<nobr>A select with icons</nobr>");
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
        selectItem2.setHint("<nobr>A select with styled entries</nobr>");
        selectItem2.setValueMap("<span style='color:#FF0000;'>Red</span>",
                "<span style='color:#00FF00;'>Green</span>",
                "<span style='color:#0000FF;'>Blue</span>");


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

        selectComboForm.setItems(cbItem, selectItem, selectItem2, selectItemMultipleGrid, selectItemMultiplePickList);
        layout.addMember(selectComboForm);

        DynamicForm dateForm = new DynamicForm();
        dateForm.setWidth(620);
        dateForm.setColWidths(190, "*");
        dateForm.setIsGroup(true);
        dateForm.setGroupTitle("Date Controls");

        DateItem dateItem = new DateItem();
        dateItem.setTitle("Date");
        dateItem.setHint("<nobr>Picklist based date input</nobr>");

        DateItem dateItem2 = new DateItem();
        dateItem2.setTitle("Date");
        dateItem2.setUseTextField(true);
        dateItem2.setHint("<nobr>Direct date input</nobr>");

        DateTimeItem dateTimeItem = new DateTimeItem();
        dateTimeItem.setTitle("Datetime");
        dateTimeItem.setHint("<nobr>Direct datetime input</nobr>");
        dateTimeItem.setUseTextField(true);
        
        TimeItem timeItem1 = new TimeItem("timeItem", "Time");
        TimeItem timeItem2 = new TimeItem("timeItem2", "Time");
        timeItem2.setHint("Picklist based time input");
        timeItem2.setUseTextField(false);

        DateRangeItem dateRangeItem = new DateRangeItem("dri", "Date Range");
        dateRangeItem.setAllowRelativeDates(true);
        DateRange dateRange = new DateRange();
        dateRange.setRelativeStartDate(RelativeDate.TODAY);
        dateRange.setRelativeEndDate(new RelativeDate("-1m"));
        dateRangeItem.setValue(dateRange);

        MiniDateRangeItem miniDateRangeItem = new MiniDateRangeItem("mdri", "Mini Date Range");
        RelativeDateItem relativeDateItem = new RelativeDateItem("rdi", "Relative Date");

        dateForm.setItems(dateItem, dateItem2, dateTimeItem, timeItem1, timeItem2,
                          dateRangeItem, miniDateRangeItem, relativeDateItem);
        layout.addMember(dateForm);

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
    
    @Override
    protected boolean shouldWrapViewPanel() {
        return true;
    }

}