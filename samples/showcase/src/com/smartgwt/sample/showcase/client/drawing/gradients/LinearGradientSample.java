package com.smartgwt.sample.showcase.client.drawing.gradients;

import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.drawing.ColorStop;
import com.smartgwt.client.widgets.drawing.DrawCurve;
import com.smartgwt.client.widgets.drawing.DrawOval;
import com.smartgwt.client.widgets.drawing.DrawPane;
import com.smartgwt.client.widgets.drawing.DrawRect;
import com.smartgwt.client.widgets.drawing.DrawTriangle;
import com.smartgwt.client.widgets.drawing.LinearGradient;
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.fields.ColorPickerItem;
import com.smartgwt.client.widgets.form.fields.SliderItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class LinearGradientSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Sample of using linear type of gradient.";
    private DrawPane drawPane;
    private DrawTriangle drawTriangle;
    private DrawCurve drawCurve;
    private DrawOval drawOval;
    private DrawRect drawRect;
    private DynamicForm linearGradientDynamicForm,
                        linearGradientSliderDynamicForm;

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            LinearGradientSample panel = new LinearGradientSample();
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
        drawPane = new DrawPane();
        drawPane.setWidth(400);
        drawPane.setHeight(400);
        drawPane.setShowEdges(true);
        drawPane.setOverflow(Overflow.HIDDEN);
        drawPane.setCursor(Cursor.AUTO);

        drawPane.addDrawHandler(new DrawHandler() {
            @Override
            public void onDraw(DrawEvent event) {
                updateGradient(drawPane);
            }
        });

        drawTriangle = new DrawTriangle();
        drawTriangle.setDrawPane(drawPane);
        drawTriangle.setPoints(new Point(100, 50), new Point(150, 150), new Point(50, 150));
        drawTriangle.draw();

        drawCurve = new DrawCurve();
        drawCurve.setDrawPane(drawPane);
        drawCurve.setStartPoint(new Point(200, 50));
        drawCurve.setEndPoint(new Point(340, 150));
        drawCurve.setControlPoint1(new Point(270, 0));
        drawCurve.setControlPoint2(new Point(270, 200));
        drawCurve.draw();

        drawOval = new DrawOval();
        drawOval.setDrawPane(drawPane);
        drawOval.setLeft(50);
        drawOval.setTop(200);
        drawOval.setWidth(100);
        drawOval.setHeight(150);
        drawOval.draw();

        drawRect = new DrawRect();
        drawRect.setDrawPane(drawPane);
        drawRect.setLeft(200);
        drawRect.setTop(225);
        drawRect.setWidth(150);
        drawRect.setHeight(100);
        drawRect.draw();

        final ItemChangedHandler linearGradientItemChangedHandler = new ItemChangedHandler() {
            @Override
            public void onItemChanged(ItemChangedEvent event) {
                updateGradient(drawPane);
            }
        };

        final ColorPickerItem startColorColorPicker = new ColorPickerItem("startColor", "Start Color");
        startColorColorPicker.setDefaultValue("#FF6600");

        final ColorPickerItem firstStopColorPicker = new ColorPickerItem("firstStop", "First Stop Color");
        firstStopColorPicker.setDefaultValue("#FFFF99");

        final ColorPickerItem secondStopColorPicker = new ColorPickerItem("secondStop", "Second Stop Color");
        secondStopColorPicker.setDefaultValue("#CCFFCC");

        final ColorPickerItem endColorColorPicker = new ColorPickerItem("endColor", "End Color");
        endColorColorPicker.setDefaultValue("#33CCCC");

        linearGradientDynamicForm = new DynamicForm();
        linearGradientDynamicForm.setID("linearGradientDynamicForm");
        linearGradientDynamicForm.setWidth(250);
        linearGradientDynamicForm.addItemChangedHandler(linearGradientItemChangedHandler);
        linearGradientDynamicForm.setFields(startColorColorPicker,
                                            firstStopColorPicker,
                                            secondStopColorPicker,
                                            endColorColorPicker);

        final SliderItem x1Slider = new SliderItem("x1");
        x1Slider.setMinValue(1.0);
        x1Slider.setMaxValue(100.0);
        x1Slider.setHeight(20);
        x1Slider.setDefaultValue(20);

        final SliderItem y1Slider = new SliderItem("y1");
        y1Slider.setMinValue(1.0);
        y1Slider.setMaxValue(100.0);
        y1Slider.setHeight(20);
        y1Slider.setDefaultValue(20);

        final SliderItem x2Slider = new SliderItem("x2");
        x2Slider.setMinValue(1.0);
        x2Slider.setMaxValue(100.0);
        x2Slider.setHeight(20);
        x2Slider.setDefaultValue(80);

        final SliderItem y2Slider = new SliderItem("y2");
        y2Slider.setMinValue(1.0);
        y2Slider.setMaxValue(100.0);
        y2Slider.setHeight(20);
        y2Slider.setDefaultValue(80);

        linearGradientSliderDynamicForm = new DynamicForm();
        linearGradientSliderDynamicForm.setWidth(270);
        linearGradientSliderDynamicForm.setFields(x1Slider, y1Slider, x2Slider, y2Slider);
        linearGradientSliderDynamicForm.addItemChangedHandler(linearGradientItemChangedHandler);


        final Layout layout = new VStack();
        final Layout layout2 = new HLayout();
        layout2.addMember(drawPane);
        layout2.addMember(linearGradientSliderDynamicForm);
        layout.addMember(layout2);
        layout.addMember(linearGradientDynamicForm);
        layout.setMembersMargin(15);
        return layout;
    }

    private void updateGradient(DrawPane drawPane) {
        drawPane.removeGradient("myLinearGradient");

        final LinearGradient linearGradient = new LinearGradient();
        linearGradient.setId("myLinearGradient");
        linearGradient.setX1(linearGradientSliderDynamicForm.getValue("x1") + "%");
        linearGradient.setY1(linearGradientSliderDynamicForm.getValue("y1") + "%");
        linearGradient.setX2(linearGradientSliderDynamicForm.getValue("x2") + "%");
        linearGradient.setY2(linearGradientSliderDynamicForm.getValue("y2") + "%");
        final ColorStop colorStop1 = new ColorStop(linearGradientDynamicForm.getValueAsString("startColor"), 0.0f);
        final ColorStop colorStop2 = new ColorStop(linearGradientDynamicForm.getValueAsString("firstStop"), 0.33f);
        final ColorStop colorStop3 = new ColorStop(linearGradientDynamicForm.getValueAsString("secondStop"), 0.66f);
        final ColorStop colorStop4 = new ColorStop(linearGradientDynamicForm.getValueAsString("endColor"), 1.0f);
        linearGradient.setColorStops(colorStop1, colorStop2, colorStop3, colorStop4);

        drawTriangle.setFillGradient(linearGradient);
        drawCurve.setFillGradient(linearGradient);
        drawOval.setFillGradient(linearGradient);
        drawRect.setFillGradient(linearGradient);
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
