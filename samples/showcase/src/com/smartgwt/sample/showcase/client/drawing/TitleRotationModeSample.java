package com.smartgwt.sample.showcase.client.drawing;

import java.util.LinkedHashMap;

import com.smartgwt.client.types.ArrowStyle;
import com.smartgwt.client.types.LineCap;
import com.smartgwt.client.types.TitleRotationMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.drawing.DrawCurve;
import com.smartgwt.client.widgets.drawing.DrawItem;
import com.smartgwt.client.widgets.drawing.DrawLine;
import com.smartgwt.client.widgets.drawing.DrawLinePath;
import com.smartgwt.client.widgets.drawing.DrawPane;
import com.smartgwt.client.widgets.drawing.DrawTriangle;
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SliderItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class TitleRotationModeSample extends ShowcasePanel {
    private static final String DESCRIPTION = "This example demonstrates the various title rotation modes "+
                                              "that are supported by the Drawing module.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
        	TitleRotationModeSample panel = new TitleRotationModeSample();
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

    private DrawLine drawLine = null;
    private DrawLinePath drawLinePath = null;
    private DrawCurve drawCurve = null;
    private DrawTriangle drawTriangle = null;

    public Canvas getViewPanel() {
    	final DrawPane mainPane = new DrawPane();
        mainPane.setShowEdges(true);
        mainPane.setWidth(720);
        mainPane.setHeight(220);
		
        final DynamicForm configForm = new DynamicForm();
        configForm.setWidth(500);
        configForm.setColWidths(150, "*");
        
        final SelectItem titleRotationMode = new SelectItem();
        titleRotationMode.setName("titleRotationMode");
        titleRotationMode.setTitle("Title Rotation Mode");
        LinkedHashMap<Object, Object> map = new LinkedHashMap<Object, Object>();
        map.put("NEVER_ROTATE", TitleRotationMode.NEVER_ROTATE);
        map.put("WITH_ITEM", TitleRotationMode.WITH_ITEM);
        map.put("WITH_ITEM_ALWAYS_UP", TitleRotationMode.WITH_ITEM_ALWAYS_UP);
        map.put("WITH_LINE", TitleRotationMode.WITH_LINE);
        map.put("WITH_LINE_ALWAYS_UP", TitleRotationMode.WITH_LINE_ALWAYS_UP);
        titleRotationMode.setValueMap(map);
        titleRotationMode.setDefaultValue("NEVER_ROTATE");
        titleRotationMode.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                createItems(mainPane, configForm);
            }
        });

        SliderItem rotation = new SliderItem();
        rotation.setTitle("Rotation Shapes");
        rotation.setName("rotation");
        rotation.setMinValue(0.0);
        rotation.setMaxValue(360.0);
        rotation.setNumValues(361);
        rotation.setDefaultValue(0);
        rotation.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                final double value = Double.parseDouble(event.getValue().toString());
                drawLine.rotateTo(value);
                drawLinePath.rotateTo(value);
                drawCurve.rotateTo(value);
                drawTriangle.rotateTo(value);
            }
        });
        configForm.setFields(titleRotationMode, rotation);
		
        createItems(mainPane, configForm);
		
        VStack vStack = new VStack();
        vStack.setWidth("100%");
        vStack.setMembersMargin(10);
        vStack.addMember(mainPane);
        vStack.addMember(configForm);
		
        return vStack;
    }

    private void createItems(DrawPane mainPane, DynamicForm configForm) {
        mainPane.destroyItems();
	    
        drawTriangle = new DrawTriangle();
        drawTriangle.setPoints(new Point(100,50), new Point(150,150), new Point(50,150));
        drawTriangle.setTitle("Triangle");
        applyCommonProps(drawTriangle, mainPane, configForm);
        drawTriangle.draw();
	    
        drawCurve = new DrawCurve();
        drawCurve.setStartPoint(new Point(225, 50));
        drawCurve.setEndPoint(new Point(325, 150));
        drawCurve.setControlPoint1(new Point(275, 0));
        drawCurve.setControlPoint2(new Point(275, 200));
        drawCurve.setLineCap(LineCap.ROUND);
        drawCurve.setTitle("Curve");
        applyCommonProps(drawCurve, mainPane, configForm);
        drawCurve.draw();
	    
        drawLinePath = new DrawLinePath();
        drawLinePath.setStartPoint(new Point(495, 150));
        drawLinePath.setEndPoint(new Point(395, 50));
        drawLinePath.setTitle("LinePath");
        applyCommonProps(drawLinePath, mainPane, configForm);
        drawLinePath.draw();
	    
        drawLine = new DrawLine();
        drawLine.setStartPoint(new Point(550, 50));
        drawLine.setEndPoint(new Point(650, 150));
        drawLine.setEndArrow(ArrowStyle.BLOCK);
        drawLine.setTitle("Line");
        applyCommonProps(drawLine, mainPane, configForm);
        drawLine.draw();
	    
        final double value = Double.parseDouble(configForm.getValueAsString("rotation"));
        drawLine.rotateTo(value);
        drawLinePath.rotateTo(value);
        drawCurve.rotateTo(value);
        drawTriangle.rotateTo(value);
	}
	
    private void applyCommonProps(DrawItem item, DrawPane mainPane, DynamicForm configForm) {
    	item.setDrawPane(mainPane);
        item.setCanDrag(false);
        String rotationMode = configForm.getValueAsString("titleRotationMode");
        if (rotationMode != null) item.setTitleRotationMode(TitleRotationMode.valueOf(rotationMode));
    } 
    
    public String getIntro() {
        return DESCRIPTION;
    }
}
