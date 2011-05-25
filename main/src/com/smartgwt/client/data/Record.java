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
 * {@link com.smartgwt.client.widgets.DataBoundComponent}s have a concept of named fields, where values for each field
 * are found under the same-named attribute in a Record.
 * <p/>
 * The concept of working with Records is common to all {@link com.smartgwt.client.widgets.DataBoundComponent}s, although individual
 * DataBoundComponents may work with singular records ({@link com.smartgwt.client.widgets.form.DynamicForm}) or may work with lists
 * ({@link com.smartgwt.client.widgets.grid.ListGrid}), trees ({@link com.smartgwt.client.widgets.tree.TreeGrid}), or cubes
 * (CubeGrid) of records.
 * <p/>
 * A Record is always the same type of Java object regardless of how the record is loaded (static
 * data, java server, XML web service, etc).
 * <p/>
 * Individual DataBoundComponents may also look for special attributes on Records which control
 * styling or behavior.  For convenience, there are subclasses of Record with type-safe setters
 * for such attributes (such as {@link
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
 */
public class Record extends RefDataClass {

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
     * Convert this record to a Map. This is a recursive conversion so if an attribute on this record is set to
     * another Record instance it will also be converted to a Map.
     * @return
     */
    public Map toMap() {
        return JSOHelper.convertToMap(this.getJsObj());
    }
}
