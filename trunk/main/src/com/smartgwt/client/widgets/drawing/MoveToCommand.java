package com.smartgwt.client.widgets.drawing;

import com.smartgwt.client.types.DrawShapeCommandType;

/**
 * Command to start a new sub-path. Corresponds to the {@link com.smartgwt.client.types.DrawShapeCommandType#MOVETO}
 * command type.
 */
public class MoveToCommand extends DrawShapeCommand {

    public MoveToCommand() {
        super.setType(DrawShapeCommandType.MOVETO);
    }

    public MoveToCommand(Point p) {
        this();
        internalSetArgs(p);
    }

    private void internalSetArgs(Point p) {
        super.setArgs(p.getAsJSArray());
    }

    /**
     * Sets the point to move to when executing this "moveto" command.
     *
     * @param p the point to move to.
     */
    public void setArgs(Point p) {
        internalSetArgs(p);
    }
}
