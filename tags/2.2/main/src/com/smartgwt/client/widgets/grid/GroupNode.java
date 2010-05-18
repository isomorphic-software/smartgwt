package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.data.Record;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * An auto-generated class representing the group nodes in a grouped listgrid.
 *
 * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy(String[]) 
 */
public class GroupNode extends DataClass {

    public GroupNode(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * The value from which groups are computed for a field, which results from {@link com.smartgwt.client.widgets.grid.GroupValueFunction#getGroupValue(Object, ListGridRecord, ListGridField, String, ListGrid)}
     *
     * @return the group value
     */
    public Object getGroupValue() {
        return getAttributeAsObject("groupValue");
    }

    /**
     * The computed title for the group, which results from {@link com.smartgwt.client.widgets.grid.GroupTitleRenderer#getGroupTitle(Object, GroupNode, ListGridField, String, ListGrid)}
     *
     * @return the group title
     */
    public String getGroupTitle() {
        return getAttribute("groupTitle");
    }

    /**
     * Array of Records that belong to this group, or, for multi-field grouping, array of groupNodes of subgroups under this groupNode.
     *
     * @return records
     */
    public Record[] getGroupMembers() {
        JavaScriptObject recordsJS = getAttributeAsJavaScriptObject("groupMembers");
        return Record.convertToRecordArray(recordsJS);
    }
}
