package com.smartgwt.sample.showcase.client.drawing;

import java.util.HashMap;
import java.util.Map;

import com.smartgwt.client.types.KnobType;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Slider;
import com.smartgwt.client.widgets.drawing.CloseCommand;
import com.smartgwt.client.widgets.drawing.DrawCurve;
import com.smartgwt.client.widgets.drawing.DrawImage;
import com.smartgwt.client.widgets.drawing.DrawItem;
import com.smartgwt.client.widgets.drawing.DrawLabel;
import com.smartgwt.client.widgets.drawing.DrawLine;
import com.smartgwt.client.widgets.drawing.DrawLinePath;
import com.smartgwt.client.widgets.drawing.DrawOval;
import com.smartgwt.client.widgets.drawing.DrawPane;
import com.smartgwt.client.widgets.drawing.DrawRect;
import com.smartgwt.client.widgets.drawing.DrawShape;
import com.smartgwt.client.widgets.drawing.DrawTriangle;
import com.smartgwt.client.widgets.drawing.LineToCommand;
import com.smartgwt.client.widgets.drawing.MoveToCommand;
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.events.ValueChangedEvent;
import com.smartgwt.client.widgets.events.ValueChangedHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;


public class DrawItemKnobsSample extends ShowcasePanel {
    private static final String DESCRIPTION = (
        "This example demonstrates the different draw knobs supported by the " +
        "DrawItem classes which support draw knobs.");

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            DrawItemKnobsSample panel = new DrawItemKnobsSample();
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

    // In this sample, a DrawPane is created to hold each of nine different
    // types of DrawItems:  DrawLine, DrawRect, DrawOval, DrawTriangle,
    // DrawCurve, DrawShape, DrawLinePath, DrawImage, and DrawLabel.  For each
    // item a DynamicForm is created with checkboxes to toggle the control
    // knobs available to the item.

    // The nine DrawPanes will all have the same configuration defined in this
    // method.
    private DrawPane createDrawPane() {
        DrawPane drawPane = new DrawPane();
        drawPane.setMargin(2);
        drawPane.setWidth100();
        drawPane.setHeight("*");
        drawPane.setBorder("1px solid #f0f0f0");
        drawPane.setOverflow(Overflow.HIDDEN);
        return drawPane;
    }

    // This method creates each of the nine forms containing a checkbox for
    // each KnobType that calls DrawItme.showKnobs() and hideKnobs() when the
    // checkbox is toggled.
    private DynamicForm createForm(final DrawItem drawItem, KnobType[] knobTypes) {
        FormItem[] items = new FormItem[knobTypes.length];
        Map<String, Boolean> initialValues = new HashMap<String, Boolean>();

        // Create a checkbox for each KnobType that shows/hides that type of
        // control knob.
        for (int i = 0; i < knobTypes.length; i++) {
            final KnobType knobType = knobTypes[i];
            String itemName = knobType.getValue();
            CheckboxItem item = new CheckboxItem(itemName, itemName);
            item.setShowTitle(false);
            item.addChangedHandler(new ChangedHandler() {
                    @Override
                    public void onChanged(ChangedEvent event) {
                        boolean checked = ((Boolean)event.getValue()).booleanValue();
                        if (checked) {
                            drawItem.showKnobs(knobType);
                        } else {
                            drawItem.hideKnobs(knobType);
                        }
                    }
                });
            items[i] = item;

            // Initially check the checkbox if the DrawItem is showing this
            // type of control knob.
            initialValues.put(itemName, contains(drawItem.getKnobs(), knobType));
        }

        DynamicForm form = new DynamicForm();
        form.setItems(items);
        form.setValues(initialValues);
        form.setNumCols(knobTypes.length);
        return form;
    }

    // The nine DrawPanes and accompanying DynamicForms will be placed in their
    // own section of a SectionStack.  This method generates these sections.
    private SectionStackSection createSection(
            final DrawItem drawItem, boolean expanded, KnobType[] knobTypes)
    {
        String title = drawItem.getScClassName();
        DrawPane drawPane = drawItem.getDrawPane();
        DynamicForm knobsForm = createForm(drawItem, knobTypes);

        // Place a slider at the bottom of each section to control the rotation
        // of the DrawItem.
        double minValue = 0, maxValue = 360;
        int numValues = 361;
        Slider rotationSlider = new Slider();
        rotationSlider.setVertical(false);
        rotationSlider.setValue(0.0);
        rotationSlider.setMinValue(minValue);
        rotationSlider.setMaxValue(maxValue);
        rotationSlider.setNumValues(numValues);
        rotationSlider.setShowValue(false);
        rotationSlider.setWidth(300);
        rotationSlider.setHeight(50);
        rotationSlider.setTitle("Rotation");

        rotationSlider.addValueChangedHandler(new ValueChangedHandler() {
                @Override
                public void onValueChanged(ValueChangedEvent event) {
                    drawItem.rotateTo(event.getValue());
                }
            });

        SectionStackSection section = new SectionStackSection();
        section.setTitle(title);
        section.setExpanded(expanded);
        section.setControls(knobsForm);
        VLayout itemsLayout = new VLayout();
        itemsLayout.setWidth100();
        itemsLayout.setHeight(250);
        itemsLayout.setMembers(drawPane, rotationSlider);
        section.setItems(itemsLayout);
        return section;
    }

    private static <T> boolean contains(T[] arr, T value) {
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                if (value == null ? arr[i] == null : value.equals(arr[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public Canvas getViewPanel() {
        // Create the nine DrawItems:
        DrawLine drawLine = new DrawLine();
        drawLine.setDrawPane(createDrawPane());
        drawLine.setStartPoint(new Point(200, 20));
        drawLine.setEndPoint(new Point(400, 70));
        drawLine.setKeepInParentRect(true);

        DrawRect drawRect = new DrawRect();
        drawRect.setDrawPane(createDrawPane());
        drawRect.setLeft(160);
        drawRect.setTop(30);
        drawRect.setWidth(50);
        drawRect.setHeight(120);
        drawRect.setKeepInParentRect(true);
        drawRect.setKnobs(KnobType.RESIZE);

        DrawOval drawOval = new DrawOval();
        drawOval.setDrawPane(createDrawPane());
        drawOval.setLeft(450);
        drawOval.setTop(10);
        drawOval.setWidth(70);
        drawOval.setHeight(140);
        drawOval.setKeepInParentRect(true);
        drawOval.setKnobs(KnobType.RESIZE);

        DrawTriangle drawTriangle = new DrawTriangle();
        drawTriangle.setDrawPane(createDrawPane());
        drawTriangle.setPoints(
            new Point(75, 50), new Point(100, 100), new Point(50, 100));
        drawTriangle.setKeepInParentRect(true);
        drawTriangle.setKnobs(KnobType.RESIZE);

        DrawCurve drawCurve = new DrawCurve();
        drawCurve.setDrawPane(createDrawPane());
        drawCurve.setStartPoint(new Point(60, 140));
        drawCurve.setEndPoint(new Point(200, 10));
        drawCurve.setControlPoint1(new Point(20, 20));
        drawCurve.setControlPoint2(new Point(300, 120));
        drawCurve.setKeepInParentRect(true);

        DrawShape drawShape = new DrawShape();
        drawShape.setDrawPane(createDrawPane());
        drawShape.setCommands(
                new MoveToCommand(new Point(275, 50)),
                new LineToCommand(
                        new Point(287, 50), new Point(300, 62),
                        new Point(312, 62), new Point(325, 62),
                        new Point(325, 87), new Point(312, 87),
                        new Point(300, 87), new Point(287, 100),
                        new Point(275, 100)),
                new CloseCommand());
        drawShape.setKeepInParentRect(true);
        drawShape.setKnobs(KnobType.RESIZE);

        DrawLinePath drawLinePath = new DrawLinePath();
        drawLinePath.setDrawPane(createDrawPane());
        drawLinePath.setStartPoint(new Point(200, 20));
        drawLinePath.setEndPoint(new Point(400, 70));
        drawLinePath.setKeepInParentRect(true);

        DrawImage drawImage = new DrawImage();
        drawImage.setDrawPane(createDrawPane());
        drawImage.setLeft(250);
        drawImage.setTop(30);
        drawImage.setWidth(48);
        drawImage.setHeight(48);
        drawImage.setSrc("pieces/48/piece_red.png");
        drawImage.setKeepInParentRect(true);
        drawImage.setKnobs(KnobType.RESIZE);
        drawImage.setUseMatrixFilter(true);

        DrawLabel drawLabel = new DrawLabel();
        drawLabel.setDrawPane(createDrawPane());
        drawLabel.setLeft(160);
        drawLabel.setTop(30);
        drawLabel.setContents("DrawLabel");
        drawLabel.setFontSize(25);
        drawLabel.setFontWeight("normal");
        drawLabel.setFontStyle("italic");
        drawLabel.setFontFamily("Times New Roman, serif");
        drawLabel.setKeepInParentRect(true);

        // Put everything together in a SectionStack.
        SectionStack sectionStack = new SectionStack();
        sectionStack.setWidth100();
        sectionStack.setOverflow(Overflow.VISIBLE);
        sectionStack.setVisibilityMode(VisibilityMode.MULTIPLE);
        sectionStack.setSections(
            createSection(drawLine, true, new KnobType[] { KnobType.STARTPOINT, KnobType.ENDPOINT }),
            createSection(drawRect, false, new KnobType[] { KnobType.RESIZE, KnobType.MOVE }),
            createSection(drawOval, false, new KnobType[] { KnobType.RESIZE, KnobType.MOVE }),
            createSection(drawTriangle, true, new KnobType[] { KnobType.RESIZE, KnobType.MOVE }),
            createSection(
                drawCurve,
                false,
                new KnobType[] { KnobType.STARTPOINT, KnobType.ENDPOINT, KnobType.CONTROLPOINT1, KnobType.CONTROLPOINT2 }),
            createSection(drawShape, true, new KnobType[] { KnobType.RESIZE, KnobType.MOVE }),
            createSection(
                drawLinePath,
                false,
                new KnobType[] { KnobType.STARTPOINT, KnobType.ENDPOINT, KnobType.CONTROLPOINT1, KnobType.CONTROLPOINT2 }),
            createSection(drawImage, false, new KnobType[] { KnobType.RESIZE, KnobType.MOVE }),
            createSection(drawLabel, false, new KnobType[] { KnobType.MOVE }));

        return sectionStack;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
