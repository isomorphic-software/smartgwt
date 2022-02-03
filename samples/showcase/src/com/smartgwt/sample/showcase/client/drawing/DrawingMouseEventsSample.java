package com.smartgwt.sample.showcase.client.drawing;

import com.smartgwt.client.types.Cursor;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.drawing.DrawCurve;
import com.smartgwt.client.widgets.drawing.DrawItem;
import com.smartgwt.client.widgets.drawing.DrawLabel;
import com.smartgwt.client.widgets.drawing.DrawLine;
import com.smartgwt.client.widgets.drawing.DrawLinePath;
import com.smartgwt.client.widgets.drawing.DrawOval;
import com.smartgwt.client.widgets.drawing.DrawPane;
import com.smartgwt.client.widgets.drawing.DrawPath;
import com.smartgwt.client.widgets.drawing.DrawRect;
import com.smartgwt.client.widgets.drawing.DrawSector;
import com.smartgwt.client.widgets.drawing.DrawTriangle;
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.drawing.events.ClickEvent;
import com.smartgwt.client.widgets.drawing.events.ClickHandler;
import com.smartgwt.client.widgets.drawing.events.MouseDownEvent;
import com.smartgwt.client.widgets.drawing.events.MouseDownHandler;
import com.smartgwt.client.widgets.drawing.events.MouseMoveEvent;
import com.smartgwt.client.widgets.drawing.events.MouseMoveHandler;
import com.smartgwt.client.widgets.drawing.events.MouseOverEvent;
import com.smartgwt.client.widgets.drawing.events.MouseOverHandler;
import com.smartgwt.client.widgets.drawing.events.MouseUpEvent;
import com.smartgwt.client.widgets.drawing.events.MouseUpHandler;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class DrawingMouseEventsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Shows some of the mouse events that apply to shapes.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            DrawingMouseEventsSample panel = new DrawingMouseEventsSample();
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
        DrawPane drawPane = new DrawPane();
        drawPane.setHeight(450);
        drawPane.setWidth(700);
        drawPane.setShowEdges(true);
        drawPane.setEdgeSize(4);
        drawPane.setBackgroundColor("papayawhip");
        drawPane.setOverflow(Overflow.HIDDEN);
        drawPane.setCursor(Cursor.AUTO);
        
        final Label label = new Label();
        label.setBorder("1px solid black");
        label.setHeight(30);
        label.setWidth(700);
        label.setPadding(5);
        
        VStack layout = new VStack();
        layout.setMembersMargin(10);
        layout.setMembers(drawPane, label);
        
        drawPane.addDrawHandler(new DrawHandler() {
            
            @Override
            public void onDraw(DrawEvent event) {

                DrawPane drawPane = (DrawPane) event.getSource();
                
                DrawLabel triangleLabel = new DrawLabel();
                triangleLabel.setDrawPane(drawPane);
                triangleLabel.setLeft(50);
                triangleLabel.setTop(175);
                triangleLabel.setContents("Triangle");
                triangleLabel.draw();
             
                DrawTriangle drawTriangle = new DrawTriangle();
                drawTriangle.setDrawPane(drawPane);
                drawTriangle.setPoints(new Point(100,50),new Point(150,150),new Point(50,150));
                drawTriangle.draw();
        
                DrawLabel curveLabel = new DrawLabel();
                curveLabel.setDrawPane(drawPane);
                curveLabel.setLeft(200);
                curveLabel.setTop(175);
                curveLabel.setContents("Curve");
                curveLabel.draw();
                
                DrawCurve drawCurve = new DrawCurve();
                drawCurve.setDrawPane(drawPane);
                drawCurve.setStartPoint(new Point(200,50));
                drawCurve.setEndPoint(new Point(300,150));
                drawCurve.setControlPoint1(new Point(250,0));
                drawCurve.setControlPoint2(new Point(250,200));
                drawCurve.draw();
        
                DrawLabel linePathLabel = new DrawLabel();
                linePathLabel.setDrawPane(drawPane);
                linePathLabel.setLeft(350);
                linePathLabel.setTop(175);
                linePathLabel.setContents("Line Path");
                linePathLabel.draw();
                
                DrawLinePath drawLinePath = new DrawLinePath();
                drawLinePath.setDrawPane(drawPane);
                drawLinePath.setStartPoint(new Point(350,50));
                drawLinePath.setEndPoint(new Point(450,150));
                drawLinePath.draw();
        
                DrawLabel pathLabel = new DrawLabel();
                pathLabel.setDrawPane(drawPane);
                pathLabel.setLeft(500);
                pathLabel.setTop(175);
                pathLabel.setContents("Path");
                pathLabel.draw();
                
                DrawPath drawPath = new DrawPath();
                drawPath.setDrawPane(drawPane);
                drawPath.setPoints(
                        new Point(500,50),
                        new Point(525,50),
                        new Point(550,75),
                        new Point(575,75),
                        new Point(600,75),
                        new Point(600,125),
                        new Point(575,125),
                        new Point(550,125),
                        new Point(525,150),
                        new Point(500,150)
                );
                drawPath.draw();
        
                DrawLabel ovalLabel = new DrawLabel();
                ovalLabel.setDrawPane(drawPane);
                ovalLabel.setLeft(50);
                ovalLabel.setTop(415);
                ovalLabel.setContents("Oval");
                ovalLabel.draw();
                
                DrawOval drawOval = new DrawOval();
                drawOval.setDrawPane(drawPane);
                drawOval.setLeft(50);
                drawOval.setTop(300);
                drawOval.setWidth(100);
                drawOval.setHeight(100);
                drawOval.draw();
        
                DrawLabel rectLabel = new DrawLabel();
                rectLabel.setDrawPane(drawPane);
                rectLabel.setLeft(200);
                rectLabel.setTop(415);
                rectLabel.setContents("Rect");
                rectLabel.draw();
                
                DrawRect drawRect = new DrawRect();
                drawRect.setDrawPane(drawPane);
                drawRect.setLeft(200);
                drawRect.setTop(300);
                drawRect.setWidth(150);
                drawRect.setHeight(100);
                drawRect.draw();
        
                DrawLabel lineLabel = new DrawLabel();
                lineLabel.setDrawPane(drawPane);
                lineLabel.setLeft(400);
                lineLabel.setTop(415);
                lineLabel.setContents("Line");
                lineLabel.draw();
                
                DrawLine drawLine = new DrawLine();
                drawLine.setDrawPane(drawPane);
                drawLine.setStartPoint(new Point(400,300));
                drawLine.setEndPoint(new Point(500,400));
                drawLine.draw();

                DrawLabel sectorLabel = new DrawLabel();
                sectorLabel.setDrawPane(drawPane);
                sectorLabel.setLeft(550);
                sectorLabel.setTop(415);
                sectorLabel.setContents("Sector");
                sectorLabel.draw();

                DrawSector drawSector = new DrawSector();
                drawSector.setDrawPane(drawPane);
                drawSector.setCenterPoint(new Point(550,300));
                drawSector.setStartAngle(0.0);
                drawSector.setEndAngle(90.0);
                drawSector.setRadius(100);
                drawSector.draw();

                DrawItem[] drawItems = drawPane.getDrawItems();
                for (int i = 0; i < drawItems.length; i++) {
                    DrawItem drawItem = drawItems[i];
                    drawItem.addClickHandler(new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent event) {
                            label.setContents("Click on " + ((DrawItem)event.getSource()).getID());
                        }
                    });
                    drawItem.addMouseDownHandler(new MouseDownHandler() {
                        @Override
                        public void onMouseDown(MouseDownEvent event) {
                        	label.setContents("Mouse is Down on " + ((DrawItem)event.getSource()).getID());
                        }
                    });
                    drawItem.addMouseUpHandler(new MouseUpHandler() {
                        @Override
                        public void onMouseUp(MouseUpEvent event) {
                        	label.setContents("Mouse Up on " + ((DrawItem)event.getSource()).getID());    
                        }
                    });
                    drawItem.addMouseMoveHandler(new MouseMoveHandler() {
                        @Override
                        public void onMouseMove(MouseMoveEvent event) {
                        	label.setContents("Mouse Move on " + ((DrawItem)event.getSource()).getID()); 
                        }
                    });
                    drawItem.addMouseOverHandler(new MouseOverHandler() {
                        @Override
                        public void onMouseOver(MouseOverEvent event) {
                        	label.setContents("Mouse Over " + ((DrawItem)event.getSource()).getID());    
                        }
                    });
                    drawItem.addClickHandler(new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent event) {
                        	label.setContents("Mouse Click on " + ((DrawItem)event.getSource()).getID());    
                        }
                    });

                }
            }
        });

        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
