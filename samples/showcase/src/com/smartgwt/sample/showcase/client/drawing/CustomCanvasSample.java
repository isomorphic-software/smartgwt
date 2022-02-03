package com.smartgwt.sample.showcase.client.drawing;

import com.smartgwt.client.types.LineCap;
import com.smartgwt.client.types.KnobType;
import com.smartgwt.client.types.TitleRotationMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.drawing.Point;
import com.smartgwt.client.widgets.drawing.DrawPane;
import com.smartgwt.client.widgets.drawing.DrawItem;
import com.smartgwt.client.widgets.drawing.DrawOval;
import com.smartgwt.client.widgets.drawing.DrawRect;
import com.smartgwt.client.widgets.drawing.DrawTriangle;
import com.smartgwt.client.widgets.drawing.events.DrawEndHandler;
import com.smartgwt.client.widgets.drawing.events.DrawStartHandler;
import com.smartgwt.client.widgets.drawing.events.DrawEndEvent;
import com.smartgwt.client.widgets.drawing.events.DrawStartEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.layout.VStack;
import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;

public class CustomCanvasSample extends ShowcasePanel {
    private static final String DESCRIPTION = 
        "This sample illustrates how to define a DrawItem with a Custom &lt;canvas&gt; " +
        "that's not drawn by the SmartGWT Framework, but by calls to the GWT Context2d APIs " +
        "on the underlying GWT Canvas.  These DrawItems can be dragged or resized via knobs " +
        "just like the built-in DrawItem types.  The custom drawing logic should run when a " +
        "DrawStartEvent or DrawEndEvent occurs, and be limited to the Framework-specified " +
        "bounding box of the DrawItem.";

    public static class Factory implements PanelFactory {

        private String id;

        public ShowcasePanel create() {
            CustomCanvasSample panel = new CustomCanvasSample();
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
    private boolean showKnobs;

    private void addDrawItemWithCommonProps(DrawItem item) {
        item.setCanDrag(true);
        item.setTitleRotationMode(TitleRotationMode.NEVER_ROTATE);
        mainPane.addDrawItem(item, true);
    }

    public Canvas getViewPanel() {
        mainPane = new DrawPane();
        mainPane.setWidth (462);
        mainPane.setHeight(462);
        mainPane.setShowEdges(true);

        final DrawTriangle drawTriangle = new DrawTriangle();
        drawTriangle.setPoints(new Point(125, 50), new Point(200, 200), new Point(50, 200));
        drawTriangle.setTitle("Triangle");
        addDrawItemWithCommonProps(drawTriangle);

        final GameBoard blueBoard = new GameBoard(0, 0, 255, 0.75);
        blueBoard.setLeft(250);
        blueBoard.setTop(50);
        blueBoard.setWidth(150);
        blueBoard.setHeight(150);
        addDrawItemWithCommonProps(blueBoard);

        final GameBoard redBoard = new GameBoard(255, 0, 0, 0.75);
        redBoard.setLeft(50);
        redBoard.setTop(250);
        redBoard.setWidth(150);
        redBoard.setHeight(150);
        addDrawItemWithCommonProps(redBoard);

        final DrawOval drawOval = new DrawOval();
        drawOval.setLeft(250);
        drawOval.setTop(250);
        drawOval.setWidth(150);
        drawOval.setHeight(150);
        drawOval.setTitle("Oval");
        addDrawItemWithCommonProps(drawOval);

        final DrawItem[] items = mainPane.getDrawItems();

        final Button toggleKnobs = new Button();
        toggleKnobs.setTitle("Show Knobs");
        toggleKnobs.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                showKnobs = !showKnobs;
                KnobType[] knobs = new KnobType[] {KnobType.MOVE, KnobType.RESIZE};
                for (DrawItem item : items) {
                    if (showKnobs) item.showKnobs(knobs);
                    else           item.hideAllKnobs();
                }
                toggleKnobs.setTitle(showKnobs ? "Hide Knobs" : "Show Knobs");
            }
        });

        final Layout layout = new VStack();
        layout.setWidth100();
        layout.setMembersMargin(10);
        layout.setMembers(mainPane, toggleKnobs);
        return layout;
    }


    public static class GameBoard extends DrawRect {

        CssColor cssColor;

        public GameBoard(int red, int green, int blue, double alpha) {
            String rgba = "rgba(" + red + "," + green + "," + blue + "," + alpha + ")";
            cssColor = CssColor.make(rgba);

            setEventOpaque(true);
            setLineOpacity(0);

            // install DrawStart event handler
            addDrawStartHandler(new DrawStartHandler() {
                @Override
                public void onDrawStart(DrawStartEvent drawStartEvent) {
                    drawBitmap();
                }
            });
        }

        public void drawBitmap() {
            Context2d context = getUnderlyingGWTCanvas().getContext2d();

            // grab the bounding box, and compute width and height
            int[] boundingBox = getResizeBoundingBox();
            int x1 = boundingBox[0], y1 = boundingBox[1];
            int x2 = boundingBox[2], y2 = boundingBox[3];

            int width  = x2 - x1;
            int height = y2 - y1;

            context.setLineWidth(3);
            context.setStrokeStyle(cssColor);

            // draw the board lines
            for (int i = 1; i < 3; i++) {
                context.beginPath();

                int xOffsetLocal = i * width/3;
                context.moveTo(x1 + xOffsetLocal, y1);
                context.lineTo(x1 + xOffsetLocal, y2);

                int yOffsetLocal = i * height/3;
                context.moveTo(x1, y1 + yOffsetLocal);
                context.lineTo(x2, y1 + yOffsetLocal);

                context.stroke();
            }

            int radius = (width < height ? width : height) / 10;
            
            // draw the board pieces
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    context.beginPath();

                    double xOffsetLocal = (i + 0.5) * width/3;
                    double yOffsetLocal = (j + 0.5) * height/3;
                    
                    if ( (i - j) % 2 == 0) {
                        context.moveTo(x1 + xOffsetLocal - radius, y1 + yOffsetLocal - radius);
                        context.lineTo(x1 + xOffsetLocal + radius, y1 + yOffsetLocal + radius);
                        context.moveTo(x1 + xOffsetLocal - radius, y1 + yOffsetLocal + radius);
                        context.lineTo(x1 + xOffsetLocal + radius, y1 + yOffsetLocal - radius);
                    } else {
                        context.arc(x1 + xOffsetLocal, y1 + yOffsetLocal,radius, 0, Math.PI*2);
                    }

                    context.stroke();
                }
            }
        }
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}
