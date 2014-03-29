package com.smartgwt.sample.showcase.client.drawing;

import java.util.LinkedHashMap;

import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.types.LineCap;
import com.smartgwt.client.types.LinePattern;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.drawing.DrawLine;
import com.smartgwt.client.widgets.drawing.DrawLinePath;
import com.smartgwt.client.widgets.drawing.DrawPane;
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.ItemChangedEvent;
import com.smartgwt.client.widgets.form.events.ItemChangedHandler;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class LinesAndArrowheadsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Sample of using lines and curves with selects for line width, style, and arrowhead style, generated at random coordinates.";

    public static class Factory implements PanelFactory {

        private String id;

        public Canvas create() {
            LinesAndArrowheadsSample panel = new LinesAndArrowheadsSample();
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


    private DrawPane drawPane;
    private DynamicForm lineStyleDynamicForm;

    public Canvas getViewPanel() {

        drawPane = new DrawPane();
        drawPane.setHeight(200);
        drawPane.setWidth(400);
        drawPane.setTop(650);
        drawPane.setLeft(25);
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

                drawLines(drawPane);
            }
            
        });
        
        SpinnerItem lineWidthSpinner = new SpinnerItem();
        lineWidthSpinner.setName("lineWidth");
        lineWidthSpinner.setTitle("Line Width");
        lineWidthSpinner.setDefaultValue(5);
        lineWidthSpinner.setMin(1);
        lineWidthSpinner.setMax(10);
        lineWidthSpinner.setStep(1);
        lineWidthSpinner.setWidth(150);
        
        LinkedHashMap<String, String> lineStyleValues = new LinkedHashMap<String, String>();
        lineStyleValues.put(LinePattern.SOLID.getValue(),"Solid");
        lineStyleValues.put(LinePattern.DOT.getValue(),"Dot");
        lineStyleValues.put(LinePattern.DASH.getValue(),"Dash");
        lineStyleValues.put(LinePattern.SHORTDOT.getValue(),"Short dot");
        lineStyleValues.put(LinePattern.SHORTDASH.getValue(),"Short dash");
        lineStyleValues.put(LinePattern.LONGDASH.getValue(),"Long dash");
        
        SelectItem lineStyleSelect = new SelectItem();
        lineStyleSelect.setName("lineStyle");
        lineStyleSelect.setTitle("Line Style");
        lineStyleSelect.setWidth(150);
        lineStyleSelect.setDefaultValue("solid");
        lineStyleSelect.setValueMap(lineStyleValues);
        
        LinkedHashMap<String, String> arrowheadStyleValues = new LinkedHashMap<String, String>();
        arrowheadStyleValues.put(LineCap.ROUND.getValue(),"Round");
        arrowheadStyleValues.put(LineCap.SQUARE.getValue(),"Square");
        arrowheadStyleValues.put(LineCap.BUTT.getValue(),"Butt");
        
        SelectItem arrowStyleSelect = new SelectItem();
        arrowStyleSelect.setName("arrowheadStyle");
        arrowStyleSelect.setTitle("Line Cap Style");
        arrowStyleSelect.setWidth(150);
        arrowStyleSelect.setDefaultValue("round");
        arrowStyleSelect.setValueMap(arrowheadStyleValues);

        ItemChangedHandler lineStyleItemChangedHandler = new ItemChangedHandler() {
            @Override
            public void onItemChanged(ItemChangedEvent event) {
                drawLines(drawPane);
            }
        };
        
        lineStyleDynamicForm = new DynamicForm();
        lineStyleDynamicForm.setID("dynamicForm");
        lineStyleDynamicForm.setWidth(300);
        lineStyleDynamicForm.setHeight(100);
        lineStyleDynamicForm.setLeft(25);
        lineStyleDynamicForm.setTop(850);
        lineStyleDynamicForm.setFields(lineWidthSpinner,lineStyleSelect,arrowStyleSelect);
        lineStyleDynamicForm.addItemChangedHandler(lineStyleItemChangedHandler);
        lineStyleDynamicForm.draw();
        
        drawLines(drawPane);
        
        VLayout layout = new VLayout();
        layout.addMember(drawPane);
        layout.addMember(lineStyleDynamicForm);
        layout.draw();
        
        return layout;
    }

    /**
     * This method is called to re-render the lines within the second draw pane to
     *  demonstrate the different line types and shapes.
     */
    private void drawLines(DrawPane drawPane) {

        drawPane.erase();

        int    lineWidth      = (Integer) lineStyleDynamicForm.getValue("lineWidth");
        String lineStyle      = (String) lineStyleDynamicForm.getValue("lineStyle");
        String arrowheadStyle = (String) lineStyleDynamicForm.getValue("arrowheadStyle");
        
        LineCap lineCap = null;
        
        if(LineCap.BUTT.getValue().equals(arrowheadStyle)){
            lineCap = LineCap.BUTT;
        } else if(LineCap.ROUND.getValue().equals(arrowheadStyle)){
            lineCap = LineCap.ROUND;
        } else if(LineCap.SQUARE.getValue().equals(arrowheadStyle)){
            lineCap = LineCap.SQUARE;
        }
        
        LinePattern linePattern = null;
        
        if(LinePattern.DASH.getValue().equals(lineStyle)){
            linePattern = LinePattern.DASH;
        } else if(LinePattern.DOT.getValue().equals(lineStyle)){
            linePattern = LinePattern.DOT;
        } else if(LinePattern.LONGDASH.getValue().equals(lineStyle)){
            linePattern = LinePattern.LONGDASH;
        } else if(LinePattern.SHORTDASH.getValue().equals(lineStyle)){
            linePattern = LinePattern.SHORTDASH;
        } else if(LinePattern.SHORTDOT.getValue().equals(lineStyle)){
            linePattern = LinePattern.SHORTDOT;
        } else if(LinePattern.SOLID.getValue().equals(lineStyle)){
            linePattern = LinePattern.SOLID;
        } 
        
        
        DrawLine drawLine = new DrawLine();
        drawLine.setDrawPane(drawPane);
        drawLine.setStartPoint(new Point(20,30));
        drawLine.setEndPoint(new Point(180,160));
        drawLine.setLineWidth(lineWidth);
        drawLine.setLineCap(lineCap);
        drawLine.setLinePattern(linePattern);
        drawLine.draw();
        
        DrawLinePath drawLinePath = new DrawLinePath();
        drawLinePath.setDrawPane(drawPane);
        drawLinePath.setStartTop(40);
        drawLinePath.setStartLeft(170);
        drawLinePath.setEndLeft(340);
        drawLinePath.setEndTop(160);
        drawLinePath.setLineWidth(lineWidth);
        drawLinePath.setLineCap(lineCap);
        drawLinePath.setLinePattern(linePattern);
        drawLinePath.draw();
    }
    

    public String getIntro() {
        return DESCRIPTION;
    }
}
