package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.data.Record;

/**
 * Hover customizer object for returning a different icon when a user has selected record(s) and is dragging them.
 */
public abstract class DragTrackerIconCustomizer {
    
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
     * 
     * @param records being dragged.
     * @return HTML to display
     */
    public abstract String getDragTrackerIcon(Record[] records);
}
