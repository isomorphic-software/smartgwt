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
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class RadialGradientSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Sample of using radial type of gradient.";
    private DrawPane drawPane;
    private DynamicForm radialGradientDynamicForm;
    private DynamicForm radialGradientSliderDynamicForm;

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
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
        drawPane.setTop(1850);
        drawPane.setHeight(400);
        drawPane.setLeft(25);
        drawPane.setWidth(400);
        drawPane.setShowEdges(true);
        drawPane.setEdgeSize(4);
        drawPane.setBackgroundColor("papayawhip");
        drawPane.setOverflow(Overflow.HIDDEN);
        drawPane.setCursor(Cursor.AUTO);
        drawPane.draw();

        drawPane.addDrawHandler(new DrawHandler() {
            
            @Override
            public void onDraw(DrawEvent event) {

                DrawPane drawPane = (DrawPane) event.getSource();

                radialGradientShapesDraw(drawPane);
            }
            
        });
        
        ColorPickerItem startColorColorPicker = new ColorPickerItem("startColor","Start Color");
        ColorPickerItem firstStopColorPicker  = new ColorPickerItem("firstStop","First Stop Color");
        ColorPickerItem secondStopColorPicker = new ColorPickerItem("secondStop","Second Stop Color");
        ColorPickerItem endColorColorPicker   = new ColorPickerItem("endColor","End Color");

        startColorColorPicker.setDefaultValue("#ff0000");
        firstStopColorPicker.setDefaultValue("#ffff00");
        secondStopColorPicker.setDefaultValue("#00ff00");
        endColorColorPicker.setDefaultValue("#0000ff");

        ItemChangedHandler radialGradientItemChangedHandler = new ItemChangedHandler() {
            @Override
            public void onItemChanged(ItemChangedEvent event) {
                radialGradientShapesDraw(drawPane);
            }


        };
        
        radialGradientDynamicForm = new DynamicForm();
        radialGradientDynamicForm.setTop(1850);
        radialGradientDynamicForm.setWidth(270);
        radialGradientDynamicForm.setLeft(475);
        radialGradientDynamicForm.setFields(startColorColorPicker,firstStopColorPicker,secondStopColorPicker,endColorColorPicker);
        radialGradientDynamicForm.addItemChangedHandler(radialGradientItemChangedHandler);
        radialGradientDynamicForm.draw();
        

        SliderItem rSlider = new SliderItem("r");
        rSlider.setDefaultValue(100);
        rSlider.setMinValue(1);
        rSlider.setMaxValue(100);
        rSlider.setHeight(20);
        
        radialGradientSliderDynamicForm = new DynamicForm();
        radialGradientSliderDynamicForm.setTop(1950);
        radialGradientSliderDynamicForm.setWidth(270);
        radialGradientSliderDynamicForm.setLeft(475);
        radialGradientSliderDynamicForm.setFields(rSlider);
        radialGradientSliderDynamicForm.addItemChangedHandler(radialGradientItemChangedHandler);
        radialGradientSliderDynamicForm.draw();


        VLayout layout = new VLayout();
        layout.addMember(drawPane);
        layout.addMember(radialGradientDynamicForm);
        layout.addMember(radialGradientSliderDynamicForm);
        layout.draw();
        
        return layout;
    }

    private void radialGradientShapesDraw(DrawPane drawPane) {
        drawPane.erase();

        ColorStop colorStop1 = new ColorStop();
        colorStop1.setColor(radialGradientDynamicForm.getValueAsString("startColor"));
        colorStop1.setOffset(0.0f);

        ColorStop colorStop2 = new ColorStop();
        colorStop2.setColor(radialGradientDynamicForm.getValueAsString("firstStop"));
        colorStop2.setOffset(0.33f);

        ColorStop colorStop3 = new ColorStop();
        colorStop3.setColor(radialGradientDynamicForm.getValueAsString("secondStop"));
        colorStop3.setOffset(0.66f);

        ColorStop colorStop4 = new ColorStop();
        colorStop4.setColor(radialGradientDynamicForm.getValueAsString("endColor"));
        colorStop4.setOffset(1.0f);
        
        int r = (Integer) radialGradientSliderDynamicForm.getValue("r");
        
        RadialGradient radialGradient = new RadialGradient();
        radialGradient.setCx("0");
        radialGradient.setCy("0");
        radialGradient.setR(r+"%");
        radialGradient.setFx("0");
        radialGradient.setFy("0");
        radialGradient.setColorStops(colorStop1,colorStop2,colorStop3,colorStop4);
               
        DrawTriangle drawTriangle = new DrawTriangle();
        drawTriangle.setDrawPane(drawPane);
        drawTriangle.setFillGradient(radialGradient);
        drawTriangle.setPoints(new Point(100,50),new Point(150,150),new Point(50,150));
        drawTriangle.draw();
        
        DrawCurve drawCurve = new DrawCurve();
        drawCurve.setDrawPane(drawPane);
        drawCurve.setFillGradient(radialGradient);
        drawCurve.setStartPoint(new Point(200,50));
        drawCurve.setEndPoint(new Point(340,150));
        drawCurve.setControlPoint1(new Point(270,0));
        drawCurve.setControlPoint2(new Point(270,200));
        drawCurve.draw();
        
        DrawOval drawOval = new DrawOval();
        drawOval.setDrawPane(drawPane);
        drawOval.setFillGradient(radialGradient);
        drawOval.setLeft(50);
        drawOval.setTop(200);
        drawOval.setWidth(100);
        drawOval.setHeight(150);
        drawOval.draw();
        
        DrawRect drawRect = new DrawRect();
        drawRect.setDrawPane(drawPane);
        drawRect.setFillGradient(radialGradient);
        drawRect.setLeft(200);
        drawRect.setTop(225);
        drawRect.setWidth(150);
        drawRect.setHeight(100);
        drawRect.draw();
        
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
