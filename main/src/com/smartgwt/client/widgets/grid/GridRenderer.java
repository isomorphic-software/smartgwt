package com.smartgwt.client.widgets.grid;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.Canvas;

/**
 * The underlying grid canvas that offers consistent cross-platform sizing, clipping, and events.
 */
public class GridRenderer extends Canvas {

    public GridRenderer(JavaScriptObject jsObj) {
        super(jsObj);
    }
    
}
