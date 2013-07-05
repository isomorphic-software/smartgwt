package com.smartgwt.client.widgets;

import com.smartgwt.client.widgets.Canvas;


/**
 * Called to determine the hover HTML.
 */
public abstract class HoverHTMLCustomizer {

	private Canvas canvas;

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
    /**
     * hoverHTML() should be implemented and return the string of HTML to display.
     * 
     * @return HTML to display
     */
    public abstract String getHoverHTML();
}
