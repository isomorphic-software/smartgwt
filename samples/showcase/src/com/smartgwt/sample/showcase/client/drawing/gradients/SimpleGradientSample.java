package com.smartgwt.sample.showcase.client.drawing.gradients;

import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.drawing.DrawCurve;
import com.smartgwt.client.widgets.drawing.DrawOval;
import com.smartgwt.client.widgets.drawing.DrawPane;
import com.smartgwt.client.widgets.drawing.DrawRect;
import com.smartgwt.client.widgets.drawing.DrawTriangle;
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.drawing.SimpleGradient;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.fields.ColorPickerItem;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class SimpleGradientSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Sample of using simple type of gradient.";
    private static final Integer DEFAULT_DIRECTION = 45;
    private DrawPane drawPane;
    private DrawTriangle drawTriangle;
    private DrawCurve drawCurve;
    private DrawOval drawOval;
    private DrawRect drawRect;
    private DynamicForm simpleGradientDynamicForm;

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            SimpleGradientSample panel = new SimpleGradientSample();
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

        final ItemChangedHandler simpleGradientItemChangedHandler = new ItemChangedHandler() {
            @Override
            public void onItemChanged(ItemChangedEvent event) {
                updateGradient(drawPane);
            }
        };

        final ColorPickerItem startColorColorPicker = new ColorPickerItem("startColor", "Start Color");
        startColorColorPicker.setDefaultValue("#33CCCC");

        final ColorPickerItem endColorColorPicker = new ColorPickerItem("endColor", "End Color");
        endColorColorPicker.setDefaultValue("#3366FF");

        final SpinnerItem directionSpinnerItem = new SpinnerItem("direction", "Direction");
        directionSpinnerItem.setDefaultValue(DEFAULT_DIRECTION);
        directionSpinnerItem.setMin(0);
        directionSpinnerItem.setMax(360);
        directionSpinnerItem.setStep(1);

        simpleGradientDynamicForm = new DynamicForm();
        simpleGradientDynamicForm.setID("simpleGradientDynamicForm");
        simpleGradientDynamicForm.setWidth(250);
        simpleGradientDynamicForm.addItemChangedHandler(simpleGradientItemChangedHandler);
        simpleGradientDynamicForm.setFields(startColorColorPicker, endColorColorPicker, directionSpinnerItem);
        simpleGradientDynamicForm.draw();


        final Layout layout = new HStack();
        layout.addMember(drawPane);
        layout.addMember(simpleGradientDynamicForm);
        return layout;
    }

    private void updateGradient(DrawPane drawPane) {
        drawPane.removeGradient("mySimpleGradient");

        final SimpleGradient simpleGradient = new SimpleGradient();
        simpleGradient.setId("mySimpleGradient");
        Number direction = (Number)simpleGradientDynamicForm.getValue("direction");
        if (direction == null) direction = DEFAULT_DIRECTION;
        simpleGradient.setDirection(direction.intValue());
        simpleGradient.setStartColor(simpleGradientDynamicForm.getValueAsString("startColor"));
        simpleGradient.setEndColor(simpleGradientDynamicForm.getValueAsString("endColor"));

        drawTriangle.setFillGradient(simpleGradient);
        drawCurve.setFillGradient(simpleGradient);
        drawOval.setFillGradient(simpleGradient);
        drawRect.setFillGradient(simpleGradient);
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
