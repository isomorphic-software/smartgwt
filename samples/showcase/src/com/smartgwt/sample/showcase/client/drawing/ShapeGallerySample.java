package com.smartgwt.sample.showcase.client.drawing;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.drawing.DrawCurve;
import com.smartgwt.client.widgets.drawing.DrawItem;
import com.smartgwt.client.widgets.drawing.DrawLine;
import com.smartgwt.client.widgets.drawing.DrawLinePath;
import com.smartgwt.client.widgets.drawing.DrawOval;
import com.smartgwt.client.widgets.drawing.DrawPane;
import com.smartgwt.client.widgets.drawing.DrawPath;
import com.smartgwt.client.widgets.drawing.DrawRect;
import com.smartgwt.client.widgets.drawing.DrawSector;
import com.smartgwt.client.widgets.drawing.DrawTriangle;
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.events.DrawEvent;
import com.smartgwt.client.widgets.events.DrawHandler;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class ShapeGallerySample extends ShowcasePanel {
    private static final String DESCRIPTION = "This is a sample of the shapes available in the SmartClient drawing module.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            ShapeGallerySample panel = new ShapeGallerySample();
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

    private DrawPane mainPane;

    private void applyCommonProps(DrawItem item) {
        item.setDrawPane(mainPane);
        item.setCanDrag(true);
    }

    public Canvas getViewPanel() {
        mainPane = new DrawPane();
        mainPane.setWidth(720);
        mainPane.setHeight(475);
        mainPane.setShowEdges(true);
        mainPane.addDrawHandler(new DrawHandler() {
            @Override
            public void onDraw(DrawEvent event) {
                final DrawTriangle drawTriangle = new DrawTriangle();
                drawTriangle.setPoints(new Point(100, 50), new Point(150, 150), new Point(50, 150));
                drawTriangle.setTitle("Triangle");
                applyCommonProps(drawTriangle);
                drawTriangle.draw();

                final DrawCurve drawCurve = new DrawCurve();
                drawCurve.setStartPoint(new Point(200, 50));
                drawCurve.setEndPoint(new Point(300, 150));
                drawCurve.setControlPoint1(new Point(250, 0));
                drawCurve.setControlPoint2(new Point(250, 200));
                drawCurve.setTitle("Curve");
                applyCommonProps(drawCurve);
                drawCurve.draw();

                final DrawLinePath drawLinePath = new DrawLinePath();
                drawLinePath.setStartPoint(new Point(350, 50));
                drawLinePath.setEndPoint(new Point(450, 150));
                drawLinePath.setTitle("LinePath");
                applyCommonProps(drawLinePath);
                drawLinePath.draw();

                final DrawPath drawPath = new DrawPath();
                drawPath.setPoints(
                        new Point(500, 50),
                        new Point(525, 50),
                        new Point(550, 75),
                        new Point(575, 75),
                        new Point(600, 75),
                        new Point(600, 125),
                        new Point(575, 125),
                        new Point(550, 125),
                        new Point(525, 150),
                        new Point(500, 150)
                );
                drawPath.setTitle("Path");
                applyCommonProps(drawPath);
                drawPath.draw();

                final DrawOval drawOval = new DrawOval();
                drawOval.setLeft(50);
                drawOval.setTop(300);
                drawOval.setWidth(100);
                drawOval.setHeight(100);
                drawOval.setTitle("Oval");
                applyCommonProps(drawOval);
                drawOval.draw();

                final DrawRect drawRect = new DrawRect();
                drawRect.setLeft(200);
                drawRect.setTop(300);
                drawRect.setWidth(150);
                drawRect.setHeight(100);
                drawRect.setTitle("Rectangle");
                applyCommonProps(drawRect);
                drawRect.draw();

                final DrawLine drawLine = new DrawLine();
                drawLine.setStartPoint(new Point(400, 300));
                drawLine.setEndPoint(new Point(500, 400));
                drawLine.setTitle("Line");
                applyCommonProps(drawLine);
                drawLine.draw();

                final DrawSector drawSector = new DrawSector();
                drawSector.setDrawPane(mainPane);
                drawSector.setCenterPoint(new Point(550, 300));
                drawSector.setStartAngle(0.0);
                drawSector.setEndAngle(90.0);
                drawSector.setRadius(100);
                drawSector.setTitle("Sector");
                applyCommonProps(drawSector);
                drawSector.draw();
            }
        });

        final Layout layout = new HStack();
        layout.setWidth100();
        layout.setMembers(mainPane);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
