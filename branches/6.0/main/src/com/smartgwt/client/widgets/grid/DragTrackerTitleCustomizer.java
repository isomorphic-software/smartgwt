package com.smartgwt.client.widgets.grid;


/**
 * Hover customizer object for returning a different icon when a user has selected record(s) and is dragging them.
 */
public abstract class DragTrackerTitleCustomizer {
    
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
     * Return "title" HTML to display as a drag tracker when the user drags some record.<br>
     * Default implementation will display the cell value for the title field (see 
     * +link{listGrid.getTitleField()}) for the record(s) being dragged (including any
     * icons / custom formatting / styling, etc).
     * <p>
     * Note: Only called if +link{listGrid.dragTrackerMode} is set to <code>"title"</code>.
     * 
     * @param record being dragged.
     * @param rowNum
     * @return Title HTML for the row. Default implementation looks at the value of the title-field cell for the row.
     */
    public abstract String getDragTrackerTitle(ListGridRecord listGridRecord, int rowNum);
}
