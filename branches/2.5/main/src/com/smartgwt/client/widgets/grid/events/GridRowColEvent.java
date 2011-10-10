package com.smartgwt.client.widgets.grid.events;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventHandler;
import com.smartgwt.client.widgets.events.BrowserEvent;
import com.smartgwt.client.widgets.grid.ListGridRecord;

public abstract class GridRowColEvent<H extends EventHandler> extends BrowserEvent<H> {

    protected GridRowColEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * cell record as returned by getCellRecord
     *
     * @return cell record as returned by getCellRecord
     */
    public native ListGridRecord getRecord() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        if (jsObj.record == null) return null;
        var retVal = @com.smartgwt.client.core.RefDataClass::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.record);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.grid.ListGridRecord::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.record);
        }
        return retVal;
    }-*/;

    /**
     * row number for the cell
     *
     * @return row number for the cell
     */
    public native int getRowNum() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return jsObj.rowNum;
    }-*/;

    /**
     * column number of the cell
     *
     * @return column number of the cell
     */
    public native int getColNum() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return jsObj.colNum;
    }-*/;
}
