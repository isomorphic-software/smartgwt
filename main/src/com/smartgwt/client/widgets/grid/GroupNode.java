package com.smartgwt.client.widgets.grid;

import com.smartgwt.client.core.DataClass;
import com.smartgwt.client.data.Record;
import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.widgets.tree.TreeNode;
import com.smartgwt.client.core.RefDataClass;
import com.smartgwt.client.bean.BeanFactory;

/**
 * An auto-generated class representing the group nodes in a grouped listgrid.
 *
 * @see com.smartgwt.client.widgets.grid.ListGrid#groupBy(String[]) 
 */
public class GroupNode extends TreeNode {

    public static GroupNode getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;

        final RefDataClass existingObj = RefDataClass.getRef(jsObj);

        if (existingObj instanceof GroupNode) {
            existingObj.setJsObj(jsObj);
            return (GroupNode)existingObj;
        } else {
            return new GroupNode(jsObj);
        }
    }

    public GroupNode(ListGridRecord record) {
        this(record.getJsObj());
    }
        
    public GroupNode(JavaScriptObject jsObj) {
        setJavaScriptObject(jsObj);
        setAttribute(com.smartgwt.client.util.SC.REF, (Object) this);
        setAttribute(com.smartgwt.client.util.SC.MODULE, (Object) BeanFactory.getSGWTModule());
    }

    /**
     * The value from which groups are computed for a field, which results from
     * {@link com.smartgwt.client.widgets.grid.GroupValueFunction#getGroupValue(Object, ListGridRecord, ListGridField, String, ListGrid)}
     *
     * @return the group value
     */
    public Object getGroupValue() {
        return getAttributeAsObject("groupValue");
    }

    /**
     * The computed title for the group, which results from
     * {@link com.smartgwt.client.widgets.grid.GroupTitleRenderer#getGroupTitle(Object, GroupNode, ListGridField, String, ListGrid)}
     *
     * @return the group title
     */
    public String getGroupTitle() {
        return getAttribute("groupTitle");
    }

    /**
     * Array of Records that belong to this group, or, for multi-field grouping, array of
     * groupNodes of subgroups under this groupNode.
     *
     * @return records
     * @deprecated Use {@link com.smartgwt.client.widgets.grid.ListGrid#getGroupMembers ListGrid.getGroupMembers()}
     * instead to get the descendants of a <code>GroupNode</code>.<P>
     */
    public Record[] getGroupMembers() {
        JavaScriptObject recordsJS = getAttributeAsJavaScriptObject("groupMembers");
        return Record.convertToRecordArray(recordsJS);
    }
}
