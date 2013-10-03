package com.smartgwt.client.widgets.drawing;

import com.smartgwt.client.types.DrawShapeCommandType;
import com.smartgwt.client.util.JSOHelper;

/**
 * Command to draw a multi-segment line. Corresponds to the {@link com.smartgwt.client.types.DrawShapeCommandType#LINETO}
 * command type.
 */
public class LineToCommand extends DrawShapeCommand {

    public LineToCommand() {
        super.setType(DrawShapeCommandType.LINETO);
    }

    public LineToCommand(Point... points) {
        this();
        internalSetArgs(points);
    }

    private void internalSetArgs(Point... points) {
        super.setArgs(JSOHelper.convertToJavaScriptArray(points));
    }

    /**
     * Sets the points to draw lines through in sequence when executing this "lineto" command.
     *
     * @param points the points to draw lines through.
     */
    public void setArgs(Point... points) {
        internalSetArgs(points);
    }
}
