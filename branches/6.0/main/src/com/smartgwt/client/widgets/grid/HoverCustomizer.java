package com.smartgwt.client.widgets.grid;

/**
 * Hover customizer object for returning custom HTML to display in a hover prompt for ListGrid cells
 */
public abstract class HoverCustomizer {
    
    private ListGrid grid;

    public void setGrid(ListGrid grid) {
        this.grid = grid;
    }    

    /**
     * Returns the ListGrid over which the hover occurred
     * @return ListGrid over which the hover occurred
     */
    public ListGrid getGrid() {
        return this.grid;
    }    
    
    /**
     * hoverHTML() should be implemented and return the string of HTML to display when the user hovers
     * over ListGrid cells
     * @param value
     * @param record
     * @param rowNum
     * @param colNum
     * @return HTML to display
     */
    public abstract String hoverHTML(Object value, ListGridRecord record, int rowNum, int colNum);
}
