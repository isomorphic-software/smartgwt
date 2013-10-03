package com.smartgwt.client.widgets.drawing;

import com.smartgwt.client.types.DrawShapeCommandType;

/**
 * Command to close the current sub-path. Corresponds to the {@link com.smartgwt.client.types.DrawShapeCommandType#CLOSE}
 * command type.
 */
public class CloseCommand extends DrawShapeCommand {

    public CloseCommand() {
        super.setType(DrawShapeCommandType.CLOSE);
    }
}
