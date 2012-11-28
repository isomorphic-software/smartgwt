package com.smartgwt.sample.showcase.client.drawing;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.drawing.Gauge;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ColorPickerItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.FormItemIcon;
import com.smartgwt.client.widgets.form.fields.SliderItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemClickHandler;
import com.smartgwt.client.widgets.form.fields.events.FormItemIconClickEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class GaugeSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Use the controls to set the needle position " +
                                              "as well as the number of sectors on the dial and their colors.  " +
                                              "The Gauge component also supports configurable tick marks and labels.";

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            GaugeSample sample = new GaugeSample();
            id = sample.getID();
            return sample;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }

    private Gauge gauge;

    private DynamicForm configForm;
    private CheckboxItem drawnClockwiseConfigItem;
    private TextItem minValueConfigItem;
    private TextItem maxValueConfigItem;
    private TextItem numMajorTicksConfigItem;
    private TextItem numMinorTicksConfigItem;
    private TextItem labelPrefixConfigItem;
    private TextItem labelSuffixConfigItem;
    private TextItem newSectorValueTextItem;
    private ButtonItem addSectorButtonItem;
    private SliderItem gaugeValueConfigItem;

    private DynamicForm sectorsForm;

    public String getIntro() {
        return DESCRIPTION;
    }

    @Override
    public Canvas getViewPanel() {
        HLayout hLayout = new HLayout();

        gauge = new Gauge();
        gauge.setWidth(400);
        gauge.setHeight(400);
        gauge.setNumMajorTicks(11);
        gauge.setNumMinorTicks(101);
        gauge.setValue(45);
        gauge.addSector(10);
        gauge.addSector(30);
        gauge.addSector(60);
        gauge.addSector(90);
        gauge.setSectorFillColor(0, "#FF0000");
        gauge.setSectorFillColor(1, "#FF6600");
        gauge.setSectorFillColor(2, "#FFFF00");
        gauge.setSectorFillColor(3, "#99CC00");
        gauge.setSectorFillColor(4, "#00FF00");

        configForm = new DynamicForm();
        configForm.setNumCols(3);
        configForm.setWidth(320);
        configForm.setIsGroup(true);
        configForm.setGroupTitle("Configuration");

        sectorsForm = new DynamicForm();
        sectorsForm.setNumCols(2);
        sectorsForm.setWidth(250);
        sectorsForm.setIsGroup(true);
        sectorsForm.setGroupTitle("Sector Fill Colors");

        drawnClockwiseConfigItem = new CheckboxItem("chkbox_drawnClockwise", "Draw Clockwise?");
        drawnClockwiseConfigItem.setEndRow(true);
        drawnClockwiseConfigItem.setValue(gauge.getDrawnClockwise());
        drawnClockwiseConfigItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                gauge.setDrawnClockwise((Boolean) event.getValue());
            }
        });

        minValueConfigItem = new TextItem("text_minValue", "Min. Value");
        minValueConfigItem.setEndRow(true);
        minValueConfigItem.setValue(String.valueOf(gauge.getMinValue()));
        minValueConfigItem.addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent event) {
                float minValue = Float.parseFloat(minValueConfigItem.getValueAsString());
                gauge.setMinValue(minValue);
                updateGaugeValueConfigItem();
                makeSectorsForm();
            }
        });

        maxValueConfigItem = new TextItem("text_maxValue", "Max. Value");
        maxValueConfigItem.setEndRow(true);
        maxValueConfigItem.setValue(String.valueOf(gauge.getMaxValue()));
        maxValueConfigItem.addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent event) {
                float maxValue = Float.parseFloat(maxValueConfigItem.getValueAsString());
                gauge.setMaxValue(maxValue);
                updateGaugeValueConfigItem();
                makeSectorsForm();
            }
        });

        numMajorTicksConfigItem = new TextItem("text_numMajorTicks", "# Major Ticks");
        numMajorTicksConfigItem.setEndRow(true);
        numMajorTicksConfigItem.setValue(String.valueOf(gauge.getNumMajorTicks()));
        numMajorTicksConfigItem.addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent event) {
                int num = Integer.parseInt(numMajorTicksConfigItem.getValueAsString());
                gauge.setNumMajorTicks(num);
            }
        });

        numMinorTicksConfigItem = new TextItem("text_numMinorTicks", "# Minor Ticks");
        numMinorTicksConfigItem.setEndRow(true);
        numMinorTicksConfigItem.setValue(String.valueOf(gauge.getNumMinorTicks()));
        numMinorTicksConfigItem.addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent event) {
                int num = Integer.parseInt(numMinorTicksConfigItem.getValueAsString());
                gauge.setNumMinorTicks(num);
            }
        });

        labelPrefixConfigItem = new TextItem("text_labelPrefix", "Label Prefix");
        labelPrefixConfigItem.setEndRow(true);
        labelPrefixConfigItem.setValue(gauge.getLabelPrefix());
        labelPrefixConfigItem.addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent event) {
                gauge.setLabelPrefix(labelPrefixConfigItem.getValueAsString());
            }
        });

        labelSuffixConfigItem = new TextItem("text_labelSuffix", "Label Suffix");
        labelSuffixConfigItem.setEndRow(true);
        labelSuffixConfigItem.setValue(gauge.getLabelSuffix());
        labelSuffixConfigItem.addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent event) {
                gauge.setLabelSuffix(labelSuffixConfigItem.getValueAsString());
            }
        });

        newSectorValueTextItem = new TextItem("text_newSectorValue", "New Sector - Value");
        newSectorValueTextItem.setEndRow(false);

        addSectorButtonItem = new ButtonItem("button_addSector", "Add Sector");
        addSectorButtonItem.setStartRow(false);
        addSectorButtonItem.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                float value = Float.parseFloat(newSectorValueTextItem.getValueAsString());
                gauge.addSector(value);
                makeSectorsForm();
            }
        });

        makeSectorsForm();

        gaugeValueConfigItem = new SliderItem("slider_gaugeValue", "Value");
        gaugeValueConfigItem.setColSpan(2);
        gaugeValueConfigItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                int pos = Integer.parseInt(event.getValue().toString());
                gauge.setValue(pos);
            }
        });

        updateGaugeValueConfigItem();

        FormItem[] formItems = new FormItem[10];
        formItems[0] = drawnClockwiseConfigItem;
        formItems[1] = minValueConfigItem;
        formItems[2] = maxValueConfigItem;
        formItems[3] = numMajorTicksConfigItem;
        formItems[4] = numMinorTicksConfigItem;
        formItems[5] = labelPrefixConfigItem;
        formItems[6] = labelSuffixConfigItem;
        formItems[7] = newSectorValueTextItem;
        formItems[8] = addSectorButtonItem;
        formItems[9] = gaugeValueConfigItem;
        configForm.setItems(formItems);

        hLayout.addMember(gauge);
        hLayout.addMember(configForm);
        hLayout.addMember(sectorsForm);

        return hLayout;
    }

    private void makeSectorsForm() {
        final int numSectors = gauge.getNumSectors();
        ColorPickerItem[] sectorFillColorConfigItems = new ColorPickerItem[numSectors];
        for (int i = 0; i < numSectors; ++i) {
            final ColorPickerItem colorPickerItem;
            sectorFillColorConfigItems[i] = colorPickerItem = new ColorPickerItem("colorpick_sector" + (i + 1) + "Color", "Sector " + (i + 1));

            final int sectorIndex = i;
            colorPickerItem.addChangedHandler(new ChangedHandler() {
                @Override
                public void onChanged(ChangedEvent event) {
                    String value = colorPickerItem.getValueAsString();
                    gauge.setSectorFillColor(sectorIndex, value);
                }
            });
            if (numSectors != 1) {
                FormItemIcon icon = new FormItemIcon();
                icon.setSrc("[SKIN]/actions/remove.png");
                icon.addFormItemClickHandler(new FormItemClickHandler() {

                    @Override
                    public void onFormItemClick(FormItemIconClickEvent event) {
                        assert numSectors > 1;
                        gauge.removeSector(sectorIndex);
                        makeSectorsForm();
                    }
                });
                colorPickerItem.setIcons(icon);
            }
        }

        sectorsForm.setItems(sectorFillColorConfigItems);

        for (int i = 0; i < numSectors; ++i) {
            ColorPickerItem colorPickerItem = sectorFillColorConfigItems[i];
            String fillColor = gauge.getSectorFillColor(i);
            colorPickerItem.setDefaultValue(fillColor);
            colorPickerItem.setValue(fillColor);
        }
    }

    private void updateGaugeValueConfigItem() {
        gaugeValueConfigItem.setMinValue(gauge.getMinValue());
        gaugeValueConfigItem.setMaxValue(gauge.getMaxValue());
        float value = gauge.getValue();
        gaugeValueConfigItem.setDefaultValue(value);
        gaugeValueConfigItem.setValue(value);
    }
}
