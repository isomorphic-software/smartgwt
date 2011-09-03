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
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class RadialGradientSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Sample of Rotation feature of Drawing module.";
    private DrawPane drawPane;
    private DynamicForm simpleGradientDynamicForm;

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

                simpleGradientShapesDraw(drawPane);
            }
            
        });
        
        ItemChangedHandler simpleGradientItemChangedHandler = new ItemChangedHandler() {
            @Override
            public void onItemChanged(ItemChangedEvent event) {
                simpleGradientShapesDraw(drawPane);
            }

        };
        ColorPickerItem startColorColorPicker = new ColorPickerItem("startColor","Start Color");
        ColorPickerItem endColorColorPicker   = new ColorPickerItem("endColor","End Color");
        SpinnerItem     directionSpinnerItem  = new SpinnerItem("direction","Direction");

        startColorColorPicker.setDefaultValue("#0000ff");
        endColorColorPicker.setDefaultValue("#00ff00");
        directionSpinnerItem.setDefaultValue(45);
        directionSpinnerItem.setMin(0);
        directionSpinnerItem.setMax(360);
        directionSpinnerItem.setStep(1);

        simpleGradientDynamicForm = new DynamicForm();
        simpleGradientDynamicForm.setID("simpleGradientDynamicForm");
        simpleGradientDynamicForm.setWidth(250);
        simpleGradientDynamicForm.setLeft(475);
        simpleGradientDynamicForm.setTop(950);
        simpleGradientDynamicForm.addItemChangedHandler(simpleGradientItemChangedHandler);
        simpleGradientDynamicForm.setFields(startColorColorPicker,endColorColorPicker,directionSpinnerItem);
        simpleGradientDynamicForm.draw();
        
        simpleGradientShapesDraw(drawPane);
        drawPane.draw();
        

        VLayout layout = new VLayout();
        layout.addMember(drawPane);
        layout.addMember(simpleGradientDynamicForm);
        layout.draw();
        
        return layout;
    }
    
    /**
     * This method is called to re-render the pane that contains the shapes with
     *  a defined gradient in them.
     */
    private void simpleGradientShapesDraw(DrawPane drawPane) {

        drawPane.erase();
        
        SimpleGradient simpleGradient = new SimpleGradient();
        simpleGradient.setDirection( (Integer) simpleGradientDynamicForm.getValue("direction") );
        simpleGradient.setEndColor( (String) simpleGradientDynamicForm.getValue("endColor") );
        simpleGradient.setStartColor( (String) simpleGradientDynamicForm.getValue("startColor") );
        
        DrawTriangle drawTriangle = new DrawTriangle();
        drawTriangle.setDrawPane(drawPane);
        drawTriangle.setFillGradient(simpleGradient);
        drawTriangle.setPoints(new Point(100,50), new Point(150,150), new Point(50,150));
        drawTriangle.draw();
        
        DrawCurve drawCurve = new DrawCurve();
        drawCurve.setDrawPane(drawPane);
        drawCurve.setFillGradient(simpleGradient);
        drawCurve.setStartPoint(new Point(200,50));
        drawCurve.setEndPoint(new Point(340,150));
        drawCurve.setControlPoint1(new Point(270,0));
        drawCurve.setControlPoint2(new Point(270,200));
        drawCurve.draw();
        
        DrawOval drawOval = new DrawOval();
        drawOval.setDrawPane(drawPane);
        drawOval.setFillGradient(simpleGradient);
        drawOval.setLeft(50);
        drawOval.setTop(200);
        drawOval.setWidth(100);
        drawOval.setHeight(150);
        drawOval.draw();
        
        DrawRect drawRect = new DrawRect();
        drawRect.setDrawPane(drawPane);
        drawRect.setFillGradient(simpleGradient);
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
