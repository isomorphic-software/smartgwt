/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.data;

import java.util.Map;

import com.smartgwt.client.core.RefDataClass;
import com.smartgwt.client.util.JSOHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Record contains attributes that are displayed and edited by a {@link com.smartgwt.client.widgets.DataBoundComponent}.
 * <p/>
 * DataBoundComponents have a concept of named fields, where values for each field are found
 * under the same-named attribute in a Record.
 * <p/>
 * The concept of working with Records is common to all DataBoundComponents, although individual
 * DataBoundComponents may work with singular records ({@link com.smartgwt.client.widgets.form.DynamicForm}) or may work with lists
 * ({@link com.smartgwt.client.widgets.grid.ListGrid}), trees ({@link com.smartgwt.client.widgets.tree.TreeGrid}), or cubes
 * (CubeGrid) of records.
 * <p/>
 * A Record is always the same type of Java object regardless of how the record is loaded (static
 * data, java server, XML web service, etc).  However, individual DataBoundComponents may also
 * look for special attributes on Records which control styling or behavior.  For convenience,
 * there are subclasses of Record with type-safe setters for such attributes (such as {@link
 * com.smartgwt.client.widgets.grid.ListGrid#setRecordEditProperty(String)}).  In reality, all
 * such subclasses are wrappers over the same underlying data object, and you can convert to
 * whichever wrapper is most convenient via:
 * <pre>
 *    new ListGridRecord(recordInstance.getJsObj());
 * </pre>
 * You can also create your own subclass of Record with type-specific getters and setters,
 * however, if you do so, you should store values via setAttribute() and retrieve them via
 * getAttribute() rather than keeping values as normal Java properties.  Only attributes will
 * be visible to DataBoundComponents, ordinary Java properties will not. 
 * <p/>
 * Note that directly changing an attribute of a Record via setAttribute() will not notify any
 * DataBoundComponents that the Record has changed or cause any kind of persistence operation
 * to occur.  Instead, use component-specific methods such as DynamicForm.setValue() or
 * ListGrid.setEditValue() to explicitly tell the components about a change that should be
 * saved.
 */
public class Record extends RefDataClass {

    public static boolean isARecord(Object obj) {
        return obj instanceof Record;
    }

    /**
     * Creates a shallow copy of <code>record</code> containing its attributes for properties
     * named in <code>properties</code>.
     *
     * @param record the record to copy attributes from.
     * @param properties an array of properties to copy.
     * @return a copy of <code>record</code> containing only the attributes for properties
     * named in <code>properties</code>.
     */
    public static Record copyAttributes(Record record, String... properties) {
        Record copyOfRecord = new Record();
        copyAttributesInto(copyOfRecord, record, properties);
        return copyOfRecord;
    }

    /**
     * Shallow copies the attributes of <code>record</code> to <code>destRecord</code> for
     * properties named in <code>properties</code>.
     *
     * @param destRecord (out) destination record into which attributes are copied.
     * @param record the record to copy attributes from.
     * @param properties an array of properties to copy.
     */
    public static void copyAttributesInto(Record destRecord, Record record, String... properties) {
        for (String property : properties) {
            if (property == null) continue;
            Object attr = record.getAttributeAsObject(property);
            destRecord.setAttribute(property, attr);
        }
    }

    public Record() {
    }

    public Record(JavaScriptObject jsObj) {
        super(jsObj);
    }
    
    public Record(Map recordProperties) {
        JavaScriptObject jsObj = JSOHelper.convertMapToJavascriptObject(recordProperties);
        this.setJsObj(jsObj);
    }

    public static Record getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        RefDataClass obj = RefDataClass.getRef(jsObj);
        if (obj != null) {
            obj.setJsObj(jsObj);
            return (Record) obj;
        } else {
            return new Record(jsObj);
        }
    }

    /** 
     * This method returns a Map of config properties suitable for use as the "defaults" 
     * attribute of a {@link com.smartgwt.client.tools.PaletteNode}.  Use it when you need to
     * work with PaletteNodes indirectly, such when setting up 
     * {@link com.smartgwt.client.widgets.tile.TileRecord}s that will be used in a 
     * {@link com.smartgwt.client.tools.TilePalette}.  See 
     * {@link com.smartgwt.client.docs.DevTools the dev tools overview} for examples of how to
     * assemble and acquire a suitable defaults object when you are creating a PaletteNode 
     * indirectly
     */
    public Map getPaletteDefaults() {
        return JSOHelper.convertToMap(JSOHelper.cleanProperties(jsObj, true));
    }

    /**
     * Returns the nested structure as Record array.
     *
     * @param property the record property
     * @return array of records
     */
    public Record[] getAttributeAsRecordArray(String property) {
        return convertToRecordArray(getAttributeAsJavaScriptObject(property));
    }

    /**
     * Returns the nested structure as a RecordList.
     *
     * @param property the record property
     * @return the RecordList
     */
    public RecordList getAttributeAsRecordList(String property) {
        JavaScriptObject jsObject = getAttributeAsJavaScriptObject(property);
        return jsObject == null ? null : new RecordList(jsObject);
    }

    public static Record[] convertToRecordArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new Record[]{};
        }
        if (JSOHelper.isArray(nativeArray)) {
            JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
            Record[] objects = new Record[componentsj.length];
            for (int i = 0; i < componentsj.length; i++) {
                JavaScriptObject componentJS = componentsj[i];
                Record obj = (Record) RefDataClass.getRef(componentJS);
                if (obj == null) obj = new Record(componentJS);
                objects[i] = obj;
            }
            return objects;
        } else {
            Record[] ret = new Record[1];
            ret[0] = Record.getOrCreateRef(nativeArray);
            return ret;
        }
    }
    
    /**
     * Convert this record to a Map. This is a recursive conversion so if an attribute on this
     * record is set to another Record instance it will also be converted to a Map.
     * @return the Map
     */
    public native Map toMap() /*-{
        $wnd.SmartGWT._cleanSgwtProperties = true;
        var jsObj = this.@com.smartgwt.client.data.Record::getJsObj()(),
            map = @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
        delete $wnd.SmartGWT._cleanSgwtProperties;
        return map;
    }-*/;
}
