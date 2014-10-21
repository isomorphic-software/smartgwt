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
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.drawing.RadialGradient;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.fields.ColorPickerItem;
import com.smartgwt.client.widgets.form.fields.SliderItem;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class RadialGradientSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Sample of using radial type of gradient.";
    private DrawPane drawPane;
    private DrawTriangle drawTriangle;
    private DrawCurve drawCurve;
    private DrawOval drawOval;
    private DrawRect drawRect;
    private DynamicForm radialGradientDynamicForm;
    private DynamicForm radialGradientSliderDynamicForm;

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            RadialGradientSample panel = new RadialGradientSample();
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

        final ColorPickerItem startColorColorPicker = new ColorPickerItem("startColor", "Start Color");
        startColorColorPicker.setDefaultValue("#ff0000");

        final ColorPickerItem firstStopColorPicker = new ColorPickerItem("firstStop", "First Stop Color");
        firstStopColorPicker.setDefaultValue("#ffff00");

        final ColorPickerItem secondStopColorPicker = new ColorPickerItem("secondStop", "Second Stop Color");
        secondStopColorPicker.setDefaultValue("#00ff00");

        final ColorPickerItem endColorColorPicker = new ColorPickerItem("endColor", "End Color");
        endColorColorPicker.setDefaultValue("#0000ff");

        final ItemChangedHandler radialGradientItemChangedHandler = new ItemChangedHandler() {
            @Override
            public void onItemChanged(ItemChangedEvent event) {
                updateGradient(drawPane);
            }
        };

        radialGradientDynamicForm = new DynamicForm();
        radialGradientDynamicForm.setWidth(270);
        radialGradientDynamicForm.setFields(startColorColorPicker, firstStopColorPicker, secondStopColorPicker, endColorColorPicker);
        radialGradientDynamicForm.addItemChangedHandler(radialGradientItemChangedHandler);

        final SliderItem rSlider = new SliderItem("r");
        rSlider.setDefaultValue(100);
        rSlider.setMinValue(1.0);
        rSlider.setMaxValue(100.0);
        rSlider.setHeight(20);

        radialGradientSliderDynamicForm = new DynamicForm();
        radialGradientSliderDynamicForm.setWidth(270);
        radialGradientSliderDynamicForm.setFields(rSlider);
        radialGradientSliderDynamicForm.addItemChangedHandler(radialGradientItemChangedHandler);


        final Layout layout = new VLayout();
        layout.addMember(drawPane);
        layout.addMember(radialGradientDynamicForm);
        layout.addMember(radialGradientSliderDynamicForm);
        return layout;
    }

    private void updateGradient(DrawPane drawPane) {
        drawPane.removeGradient("myRadialGradient");

        final RadialGradient radialGradient = new RadialGradient();
        radialGradient.setId("myRadialGradient");
        radialGradient.setCx("0");
        radialGradient.setCy("0");
        radialGradient.setR(radialGradientSliderDynamicForm.getValue("r") + "%");
        radialGradient.setFx("0");
        radialGradient.setFy("0");
        final ColorStop colorStop1 = new ColorStop(radialGradientDynamicForm.getValueAsString("startColor"), 0.0f);
        final ColorStop colorStop2 = new ColorStop(radialGradientDynamicForm.getValueAsString("firstStop"), 0.33f);
        final ColorStop colorStop3 = new ColorStop(radialGradientDynamicForm.getValueAsString("secondStop"), 0.66f);
        final ColorStop colorStop4 = new ColorStop(radialGradientDynamicForm.getValueAsString("endColor"), 1.0f);
        radialGradient.setColorStops(colorStop1, colorStop2, colorStop3, colorStop4);

        drawTriangle.setFillGradient(radialGradient);
        drawCurve.setFillGradient(radialGradient);
        drawOval.setFillGradient(radialGradient);
        drawRect.setFillGradient(radialGradient);
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
