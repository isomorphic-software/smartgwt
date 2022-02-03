package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.widgets.grid.*;

/**
 * Called to determine whether a given record can be selected in a grid.
 */
public abstract class CanSelectRecordCustomizer {
    /**
     * canSelectRecord() should be implemented and return a Boolean value if applicable, or null 
     * to fall through to the builtin implementation.
     * @param record the record test sest for selectability
     * @param grid the grid in which the record appears
     * @return a Boolean indicating if the record can be selected, or null to delegate to default behavior
     */
    public abstract Boolean canSelectRecord(ListGridRecord record, ListGrid grid);
}
