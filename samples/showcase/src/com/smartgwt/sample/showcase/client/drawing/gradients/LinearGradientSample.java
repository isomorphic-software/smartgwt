package com.smartgwt.sample.showcase.client.drawing.gradients;

import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.ValidatorType;
import com.smartgwt.client.types.FormErrorOrientation;

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
import com.smartgwt.client.widgets.form.validator.Validator;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class LinearGradientSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Sample of using a linear type of gradient.";
    private DrawPane drawPane;
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

        /* ------------------------------------------- */
        
        drawPane = new DrawPane();
        drawPane.setTop(950);
        drawPane.setHeight(400);
        drawPane.setLeft(25);
        drawPane.setWidth(400);
        drawPane.setEdgeSize(4);
        drawPane.setBackgroundColor("papayawhip");
        drawPane.setOverflow(Overflow.HIDDEN);
        drawPane.setCursor(Cursor.AUTO);

        drawPane.addDrawHandler(new DrawHandler() {
            
            @Override
            public void onDraw(DrawEvent event) {

                DrawPane drawPane = (DrawPane) event.getSource();

                linearGradientShapesDraw(drawPane);
            }
            
        });
        
        ItemChangedHandler linearGradientItemChangedHandler = new ItemChangedHandler() {
            @Override
            public void onItemChanged(ItemChangedEvent event) {
                linearGradientShapesDraw(drawPane);
            }

        };
        ColorPickerItem startColorColorPicker = new ColorPickerItem("startColor","Start Color");
        ColorPickerItem firstStopColorPicker = new ColorPickerItem("firstStop","First Stop Color");
        ColorPickerItem secondStopColorPicker = new ColorPickerItem("secondStop","Second Stop Color");
        ColorPickerItem endColorColorPicker   = new ColorPickerItem("endColor","End Color");

        startColorColorPicker.setDefaultValue("#ff0000");
        firstStopColorPicker.setDefaultValue("#ffff00");
        secondStopColorPicker.setDefaultValue("#00ff00");
        endColorColorPicker.setDefaultValue("#0000ff");

        linearGradientDynamicForm = new DynamicForm();
        linearGradientDynamicForm.setID("linearGradientDynamicForm");
        linearGradientDynamicForm.setWidth(400);
        linearGradientDynamicForm.addItemChangedHandler(linearGradientItemChangedHandler);
        linearGradientDynamicForm.setFields(startColorColorPicker, 
                                            firstStopColorPicker, 
                                            secondStopColorPicker, 
                                            endColorColorPicker);

        SliderItem x1Slider = new GradientItem("x1");
        x1Slider.setDefaultValue(20);

        SliderItem y1Slider = new GradientItem("y1");
        y1Slider.setDefaultValue(20);

        SliderItem x2Slider = new GradientItem("x2");
        x2Slider.setDefaultValue(80);

        SliderItem y2Slider = new GradientItem("y2");
        y2Slider.setDefaultValue(80);
        
        linearGradientSliderDynamicForm = new DynamicForm();
        linearGradientSliderDynamicForm.setWidth(290);
        linearGradientSliderDynamicForm.setTitleWidth(30);
        linearGradientSliderDynamicForm.setFields(x1Slider, y1Slider, x2Slider, y2Slider);
        linearGradientSliderDynamicForm.addItemChangedHandler(linearGradientItemChangedHandler);
        linearGradientSliderDynamicForm.setErrorOrientation(FormErrorOrientation.RIGHT);
        linearGradientSliderDynamicForm.setValidateOnChange(true);
        linearGradientSliderDynamicForm.draw();
        
        linearGradientShapesDraw(drawPane);
        

        VStack layout = new VStack();
        HLayout layout2 = new HLayout();
        layout2.setMembersMargin(10);
        layout2.addMember(drawPane);
        layout2.addMember(linearGradientSliderDynamicForm);
        layout.addMember(layout2);
        layout.addMember(linearGradientDynamicForm);
        layout.setMembersMargin(15);
        layout.draw();
        
        return layout;
    }
    
    /**
     * This method is called to re-render the pane that contains the shapes with
     *  a defined gradient in them.
     */
    private void linearGradientShapesDraw(DrawPane drawPane) {

        Object x1 = linearGradientSliderDynamicForm.getValue("x1");
        Object y1 = linearGradientSliderDynamicForm.getValue("y1");
        Object x2 = linearGradientSliderDynamicForm.getValue("x2");
        Object y2 = linearGradientSliderDynamicForm.getValue("y2");
        if (x1.equals(x2) && y1.equals(y2)) return;
        
        drawPane.erase();

        ColorStop colorStop1 = new ColorStop();
        colorStop1.setColor(linearGradientDynamicForm.getValueAsString("startColor"));
        colorStop1.setOffset(0.0f);

        ColorStop colorStop2 = new ColorStop();
        colorStop2.setColor(linearGradientDynamicForm.getValueAsString("firstStop"));
        colorStop2.setOffset(0.33f);

        ColorStop colorStop3 = new ColorStop();
        colorStop3.setColor(linearGradientDynamicForm.getValueAsString("secondStop"));
        colorStop3.setOffset(0.66f);

        ColorStop colorStop4 = new ColorStop();
        colorStop4.setColor(linearGradientDynamicForm.getValueAsString("endColor"));
        colorStop4.setOffset(1.0f);
        
        LinearGradient linearGradient = new LinearGradient();
        linearGradient.setX1(x1 + "%"); linearGradient.setY1(y1 + "%");
        linearGradient.setX2(x2 + "%"); linearGradient.setY2(y2 + "%");
        linearGradient.setColorStops(colorStop1, colorStop2, colorStop3, colorStop4);
        
        DrawTriangle drawTriangle = new DrawTriangle();
        drawTriangle.setDrawPane(drawPane);
        drawTriangle.setFillGradient(linearGradient);
        drawTriangle.setPoints(new Point(100,50), new Point(150,150), new Point(50,150));
        drawTriangle.draw();
        
        DrawCurve drawCurve = new DrawCurve();
        drawCurve.setDrawPane(drawPane);
        drawCurve.setFillGradient(linearGradient);
        drawCurve.setStartPoint(new Point(200,50));
        drawCurve.setEndPoint(new Point(340,150));
        drawCurve.setControlPoint1(new Point(270,0));
        drawCurve.setControlPoint2(new Point(270,200));
        drawCurve.draw();
        
        DrawOval drawOval = new DrawOval();
        drawOval.setDrawPane(drawPane);
        drawOval.setFillGradient(linearGradient);
        drawOval.setLeft(50);
        drawOval.setTop(200);
        drawOval.setWidth(100);
        drawOval.setHeight(150);
        drawOval.draw();
        
        DrawRect drawRect = new DrawRect();
        drawRect.setDrawPane(drawPane);
        drawRect.setFillGradient(linearGradient);
        drawRect.setLeft(200);
        drawRect.setTop(225);
        drawRect.setWidth(150);
        drawRect.setHeight(100);
        drawRect.draw();
               
    }

    public static class GradientValidator extends Validator {
        public GradientValidator() {
            setType(ValidatorType.CUSTOM);
            setDependentFields(new String[] {"x1", "x2", "y1", "y2"});
            setCondition("record.x1 != record.x2 || record.y1 != record.y2");
            setErrorMessage("please select x1\u00a0!=\u00a0x2 or " +
                                          "y1\u00a0!=\u00a0y2 to avoid a singular gradient");
        }
    }

    public static class GradientItem extends SliderItem {
        public GradientItem(String name) {
            super(name);
            setHeight(20);
            setMinValue(1);
            setMaxValue(100);
            setValidators(new GradientValidator());
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
