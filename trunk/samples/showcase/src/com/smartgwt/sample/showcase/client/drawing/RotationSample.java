package com.smartgwt.sample.showcase.client.drawing;

import com.smartgwt.client.types.TitleRotationMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Slider;
import com.smartgwt.client.widgets.drawing.DrawCurve;
import com.smartgwt.client.widgets.drawing.DrawItem;
import com.smartgwt.client.widgets.drawing.DrawLabel;
import com.smartgwt.client.widgets.drawing.DrawLine;
import com.smartgwt.client.widgets.drawing.DrawLinePath;
import com.smartgwt.client.widgets.drawing.DrawOval;
import com.smartgwt.client.widgets.drawing.DrawPane;
import com.smartgwt.client.widgets.drawing.DrawPolygon;
import com.smartgwt.client.widgets.drawing.DrawRect;
import com.smartgwt.client.widgets.drawing.DrawTriangle;
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.events.ValueChangedEvent;
import com.smartgwt.client.widgets.events.ValueChangedHandler;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class RotationSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Sample of Rotation feature of Drawing module.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            RotationSample panel = new RotationSample();
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

    private DrawTriangle drawTriangle;
    private DrawCurve drawCurve;
    private DrawLinePath drawLinePath;
    private DrawPolygon drawPolygon;
    private DrawOval drawOval;
    private DrawRect drawRect;
    private DrawLine drawLine;

    private void applyCommonProps(DrawItem item) {
        item.setDrawPane(mainPane);
        item.setLineColor("#000000");
        item.setLineWidth(1);
        item.setCanDrag(true);
        final DrawLabel titleLabelProperties = new DrawLabel();
        titleLabelProperties.setFontSize(12);
        titleLabelProperties.setLineColor("#0000ff");
        item.setAutoChildProperties("titleLabel", titleLabelProperties);
        item.setTitleRotationMode(TitleRotationMode.WITH_ITEM);
        final DrawRect titleLabelBackgroundProperties = new DrawRect();
        titleLabelBackgroundProperties.setLineColor(null);
        titleLabelBackgroundProperties.setFillColor("#d0d0ff");
        titleLabelBackgroundProperties.setFillOpacity(0.5f);
        item.setAutoChildProperties("titleLabelBackground", titleLabelBackgroundProperties);
    }

    public Canvas getViewPanel() {
        mainPane = new DrawPane();
        mainPane.setID("mainPane");
        mainPane.setWidth(400);
        mainPane.setHeight(300);
        mainPane.setTop(120);
        mainPane.setShowEdges(true);

        drawTriangle = new DrawTriangle();
        drawTriangle.setID("drawTriangle");
        drawTriangle.setPoints(new Point(75, 50), new Point(100, 100), new Point(50, 100));
        drawTriangle.setTitle("Triangle");
        applyCommonProps(drawTriangle);
        drawTriangle.draw();

        drawCurve = new DrawCurve();
        drawCurve.setID("drawCurve");
        drawCurve.setStartPoint(new Point(125, 50));
        drawCurve.setEndPoint(new Point(175, 100));
        drawCurve.setControlPoint1(new Point(150, 25));
        drawCurve.setControlPoint2(new Point(150, 125));
        drawCurve.setTitle("Curve");
        applyCommonProps(drawCurve);
        drawCurve.draw();

        drawLinePath = new DrawLinePath();
        drawLinePath.setID("drawLinePath");
        drawLinePath.setStartPoint(new Point(200, 50));
        drawLinePath.setEndPoint(new Point(250, 100));
        drawLinePath.setTitle("LinePath");
        applyCommonProps(drawLinePath);
        drawLinePath.draw();

        drawPolygon = new DrawPolygon();
        drawPolygon.setID("drawPolygon");
        drawPolygon.setPoints(
                new Point(275, 50),
                new Point(287, 50),
                new Point(300, 62),
                new Point(312, 62),
                new Point(325, 62),
                new Point(325, 87),
                new Point(312, 87),
                new Point(300, 87),
                new Point(287, 100),
                new Point(275, 100));
        drawPolygon.setTitle("Polygon");
        applyCommonProps(drawPolygon);
        drawPolygon.draw();

        drawOval = new DrawOval();
        drawOval.setID("drawOval");
        drawOval.setLeft(50);
        drawOval.setTop(150);
        drawOval.setWidth(50);
        drawOval.setHeight(75);
        drawOval.setTitle("Oval");
        applyCommonProps(drawOval);
        drawOval.draw();

        drawRect = new DrawRect();
        drawRect.setID("drawRect");
        drawRect.setLeft(150);
        drawRect.setTop(175);
        drawRect.setWidth(75);
        drawRect.setHeight(50);
        drawRect.setTitle("Rect");
        applyCommonProps(drawRect);
        drawRect.draw();

        drawLine = new DrawLine();
        drawLine.setID("drawLine");
        drawLine.setStartPoint(new Point(275, 175));
        drawLine.setEndPoint(new Point(325, 225));
        drawLine.setTitle("Line");
        applyCommonProps(drawLine);
        drawLine.draw();

        final Slider shapesRotationSlider = new Slider();
        shapesRotationSlider.setID("shapesRotation");
        shapesRotationSlider.setMinValue(0.0);
        shapesRotationSlider.setMaxValue(360.0);
        shapesRotationSlider.setNumValues(361);
        shapesRotationSlider.setWidth(400);
        shapesRotationSlider.setValue(0.0);
        shapesRotationSlider.setTitle("Rotate Shapes");
        shapesRotationSlider.setVertical(false);
        shapesRotationSlider.addValueChangedHandler(new ValueChangedHandler() {
            @Override
            public void onValueChanged(ValueChangedEvent event) {
                final double value = event.getValue();
                drawTriangle.rotateTo(value);
                drawCurve.rotateTo(value);
                drawLinePath.rotateTo(value);
                drawPolygon.rotateTo(value);
                drawOval.rotateTo(value);
                drawRect.rotateTo(value);
                drawLine.rotateTo(value);
            }
        });

        final Slider paneRotationSlider = new Slider();
        paneRotationSlider.setID("paneRotation");
        paneRotationSlider.setMinValue(0.0);
        paneRotationSlider.setMaxValue(360.0);
        paneRotationSlider.setNumValues(361);
        paneRotationSlider.setWidth(400);
        paneRotationSlider.setValue(0.0);
        paneRotationSlider.setTitle("Rotate Pane");
        paneRotationSlider.setVertical(false);
        paneRotationSlider.addValueChangedHandler(new ValueChangedHandler() {
            @Override
            public void onValueChanged(ValueChangedEvent event) {
                mainPane.rotate(event.getValue());
            }
        });

        final Layout layout = new VStack();
        layout.setWidth100();
        layout.setMembers(mainPane, shapesRotationSlider, paneRotationSlider);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
