package com.smartgwt.sample.showcase.client.drawing;

import java.util.LinkedHashMap;

import com.smartgwt.client.types.ArrowStyle;
import com.smartgwt.client.types.LineCap;
import com.smartgwt.client.types.LinePattern;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.util.EnumUtil;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.drawing.DrawCurve;
import com.smartgwt.client.widgets.drawing.DrawItem;
import com.smartgwt.client.widgets.drawing.DrawLine;
import com.smartgwt.client.widgets.drawing.DrawLinePath;
import com.smartgwt.client.widgets.drawing.DrawPane;
import com.smartgwt.client.widgets.drawing.DrawPath;
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ColorItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.SpinnerItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class LinesAndArrowheadsSample extends ShowcasePanel {
    private static final String DESCRIPTION = "Sample of using lines and curves with selects for line width, style, and arrowhead style, generated at random coordinates.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            final LinesAndArrowheadsSample panel = new LinesAndArrowheadsSample();
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

    public static final int DEFAULT_LINE_WIDTH = 5;
    public static final LinePattern DEFAULT_LINE_PATTERN = LinePattern.SOLID;
    public static final LineCap DEFAULT_LINE_CAP = LineCap.ROUND;
    public static final String DEFAULT_LINE_COLOR = "#993366";
    public static final ArrowStyle DEFAULT_ARROW_HEAD_STYLE = ArrowStyle.OPEN;

    public Canvas getViewPanel() {
        final DrawPane mainPane = new DrawPane();
        mainPane.setAutoDraw(false);
        mainPane.setID("mainPane");
        mainPane.setWidth(750);
        mainPane.setHeight(250);
        mainPane.setOverflow(Overflow.HIDDEN);
        mainPane.setShowEdges(true);

        final DrawLine drawLine = new DrawLine();
        drawLine.setLineWidth(DEFAULT_LINE_WIDTH);
        drawLine.setLinePattern(DEFAULT_LINE_PATTERN);
        drawLine.setLineCap(DEFAULT_LINE_CAP);
        drawLine.setLineColor(DEFAULT_LINE_COLOR);
        drawLine.setStartArrow(DEFAULT_ARROW_HEAD_STYLE);
        drawLine.setEndArrow(DEFAULT_ARROW_HEAD_STYLE);
        drawLine.setStartPoint(new Point(20, 30));
        drawLine.setEndPoint(new Point(180, 190));

        final DrawLinePath drawLinePath = new DrawLinePath();
        drawLinePath.setLineWidth(DEFAULT_LINE_WIDTH);
        drawLinePath.setLinePattern(DEFAULT_LINE_PATTERN);
        drawLinePath.setLineCap(DEFAULT_LINE_CAP);
        drawLinePath.setLineColor(DEFAULT_LINE_COLOR);
        drawLinePath.setStartArrow(DEFAULT_ARROW_HEAD_STYLE);
        drawLinePath.setEndArrow(DEFAULT_ARROW_HEAD_STYLE);
        drawLinePath.setStartPoint(new Point(190, 40));
        drawLinePath.setEndPoint(new Point(340, 190));

        final DrawPath drawPath = new DrawPath();
        drawPath.setLineWidth(DEFAULT_LINE_WIDTH);
        drawPath.setLinePattern(DEFAULT_LINE_PATTERN);
        drawPath.setLineCap(DEFAULT_LINE_CAP);
        drawPath.setLineColor(DEFAULT_LINE_COLOR);
        drawPath.setStartArrow(DEFAULT_ARROW_HEAD_STYLE);
        drawPath.setEndArrow(DEFAULT_ARROW_HEAD_STYLE);
        drawPath.setPoints(new Point(400, 25), new Point(425, 50), new Point(450, 75), new Point(475, 75),
                new Point(500, 75), new Point(500, 125), new Point(475, 125), new Point(450, 125),
                new Point(425, 150), new Point(500, 175));

        final DrawCurve drawCurve = new DrawCurve();
        drawCurve.setLineWidth(DEFAULT_LINE_WIDTH);
        drawCurve.setLinePattern(DEFAULT_LINE_PATTERN);
        drawCurve.setLineCap(DEFAULT_LINE_CAP);
        drawCurve.setLineColor(DEFAULT_LINE_COLOR);
        drawCurve.setStartArrow(DEFAULT_ARROW_HEAD_STYLE);
        drawCurve.setEndArrow(DEFAULT_ARROW_HEAD_STYLE);
        drawCurve.setStartPoint(new Point(600, 50));
        drawCurve.setEndPoint(new Point(700, 200));
        drawCurve.setControlPoint1(new Point(680, -10));
        drawCurve.setControlPoint2(new Point(620, 260));

        final DrawItem[] drawItems = new DrawItem[] { drawLine, drawLinePath, drawPath, drawCurve };
        mainPane.setDrawItems(drawItems);

        SpinnerItem lineWidthSpinner = new SpinnerItem("lineWidth", "Line Width");
        lineWidthSpinner.setDefaultValue(DEFAULT_LINE_WIDTH);
        lineWidthSpinner.setMin(1);
        lineWidthSpinner.setMax(10);
        lineWidthSpinner.setStep(1);
        lineWidthSpinner.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                final int value = ((Number)event.getValue()).intValue();
                for (final DrawItem item : drawItems) {
                    item.setLineWidth(value);
                }
            }
        });

        final SelectItem linePatternSelect = new SelectItem("linePattern", "Line Pattern");
        linePatternSelect.setDefaultValue(DEFAULT_LINE_PATTERN.getValue());
        final LinkedHashMap<String, String> linePatternValueMap = new LinkedHashMap<String, String>();
        linePatternValueMap.put(LinePattern.SOLID.getValue(), "Solid");
        linePatternValueMap.put(LinePattern.DOT.getValue(), "Dot");
        linePatternValueMap.put(LinePattern.DASH.getValue(), "Dash");
        linePatternValueMap.put(LinePattern.SHORTDOT.getValue(), "Short dot");
        linePatternValueMap.put(LinePattern.SHORTDASH.getValue(), "Short dash");
        linePatternValueMap.put(LinePattern.LONGDASH.getValue(), "Long dash");
        linePatternSelect.setValueMap(linePatternValueMap);
        linePatternSelect.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                final LinePattern value = EnumUtil.getEnum(LinePattern.values(), (String)event.getValue());
                for (final DrawItem item : drawItems) {
                    item.setLinePattern(value);
                }
            }
        });

        final SelectItem lineCapSelect = new SelectItem("lineCap", "Line Cap");
        lineCapSelect.setDefaultValue(DEFAULT_LINE_CAP.getValue());
        final LinkedHashMap<String, String> lineCapValueMap = new LinkedHashMap<String, String>();
        lineCapValueMap.put(LineCap.ROUND.getValue(), "Round");
        lineCapValueMap.put(LineCap.SQUARE.getValue(), "Square");
        lineCapValueMap.put(LineCap.BUTT.getValue(), "Butt");
        lineCapSelect.setValueMap(lineCapValueMap);
        lineCapSelect.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                final LineCap value = EnumUtil.getEnum(LineCap.values(), (String)event.getValue());
                for (final DrawItem item : drawItems) {
                    item.setLineCap(value);
                }
            }
        });

        final ColorItem lineColorItem = new ColorItem("lineColor", "Line Color");
        lineColorItem.setDefaultValue(DEFAULT_LINE_COLOR);
        lineColorItem.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                final String value = (String)event.getValue();
                for (final DrawItem item : drawItems) {
                    item.setLineColor(value);
                }
            }
        });

        final SelectItem arrowHeadStyleSelect = new SelectItem("arrowHeadStyle", "Arrow Head Style");
        arrowHeadStyleSelect.setDefaultValue(DEFAULT_ARROW_HEAD_STYLE.getValue());
        final LinkedHashMap<String, String> arrowHeadStyleValueMap = new LinkedHashMap<String, String>();
        arrowHeadStyleValueMap.put(ArrowStyle.OPEN.getValue(), "Open");
        arrowHeadStyleValueMap.put(ArrowStyle.BLOCK.getValue(), "Block");
        arrowHeadStyleSelect.setValueMap(arrowHeadStyleValueMap);
        arrowHeadStyleSelect.addChangedHandler(new ChangedHandler() {
            @Override
            public void onChanged(ChangedEvent event) {
                final ArrowStyle value = EnumUtil.getEnum(ArrowStyle.values(), (String)event.getValue());
                for (final DrawItem item : drawItems) {
                    item.setStartArrow(value);
                    item.setEndArrow(value);
                }
            }
        });

        final DynamicForm dataForm = new DynamicForm();
        dataForm.setAutoDraw(false);
        dataForm.setID("dataForm");
        dataForm.setWidth(300);
        dataForm.setHeight(140);
        dataForm.setOverflow(Overflow.HIDDEN);
        dataForm.setColWidths(150, "*");
        dataForm.setItems(lineWidthSpinner, linePatternSelect, lineCapSelect, lineColorItem, arrowHeadStyleSelect);

        final Layout layout = new VLayout(10);
        layout.setMembers(dataForm, mainPane);
        return layout;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
