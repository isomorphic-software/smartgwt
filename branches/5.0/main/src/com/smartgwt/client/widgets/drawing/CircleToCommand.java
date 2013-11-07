package com.smartgwt.client.widgets.drawing;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.types.DrawShapeCommandType;
import com.smartgwt.client.util.JSOHelper;

/**
 * Command to draw a segment of a specified circle. Corresponds to the {@link com.smartgwt.client.types.DrawShapeCommandType#CIRCLETO}
 * command type.
 */
public class CircleToCommand extends DrawShapeCommand {

    public CircleToCommand() {
        super.setType(DrawShapeCommandType.CIRCLETO);
    }

    public CircleToCommand(Point centerPoint, double radius, double startAngle, double endAngle) {
        internalSetArgs(centerPoint, radius, startAngle, endAngle);
    }

    private void internalSetArgs(Point centerPoint, double radius, double startAngle, double endAngle) {
        final JavaScriptObject args = JSOHelper.createJavaScriptArray();
        JSOHelper.setArrayValue(args, 0, centerPoint);
        JSOHelper.setArrayValue(args, 1, radius);
        JSOHelper.setArrayValue(args, 2, startAngle);
        JSOHelper.setArrayValue(args, 3, endAngle);
        super.setArgs(args);
    }

    /**
     * Sets the arguments to this "circleto" command. The <code>centerPoint</code> and <code>radius</code>
     * arguments specify the circle. The <code>startAngle</code> and <code>endAngle</code> arguments
     * specify the segment of the circle to draw.
     *
     * @param centerPoint the center point of the circle.
     * @param radius the radius of the circle.
     * @param startAngle the starting angle (in degrees) of the segment of the circle to draw.
     * @param endAngle the ending angle (in degrees) of the segment of the circle to draw.
     */
    public void setArgs(Point centerPoint, double radius, double startAngle, double endAngle) {
        internalSetArgs(centerPoint, radius, startAngle, endAngle);
    }
}
