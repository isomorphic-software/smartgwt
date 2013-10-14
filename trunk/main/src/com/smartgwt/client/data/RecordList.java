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


import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.core.BaseClass;
import com.smartgwt.client.util.JSOHelper;

/**
 * An an ordered collection of Records. <P> This class is expected by list-oriented display
 * components such as the ListGrid.
 */
public class RecordList extends BaseClass implements com.smartgwt.client.data.events.HasDataChangedHandlers {

    public static boolean isARecordList(Object obj) {
        return obj instanceof RecordList;
    }

    protected JavaScriptObject jsObj;

    public static RecordList getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new RecordList(jsObj);
    }

    /**
     * Construct a RecordList with no initial data. Use the various add* methods to add Records to this list.
     */
    public RecordList(){
        super();
    }

    /**
     * Construct a RecordList with initial data.
     *
     * @param data initial Record data
     */
    public RecordList(Record[] data) {
        addList(data);
    }

    public RecordList(List<? extends Record> data) {
        this(data == null ? null : data.toArray(new Record[data.size()]));
    }

    public RecordList(JavaScriptObject jsObj){
        super(jsObj);
        this.jsObj = jsObj;
    }

    @Override
    protected JavaScriptObject create() {
        jsObj = JSOHelper.createJavaScriptArray();
        return jsObj;
    }

    @Override
    public JavaScriptObject getJsObj() {
        return jsObj;
    }

    @Override
    public boolean isCreated() {
        return jsObj != null;
    }

    @Override
    public JavaScriptObject getOrCreateJsObj() {
        if (!isCreated()) {
            this.jsObj = createJsObj();
            doInit();
        }
        return getJsObj();
    }


    // ********************* Methods ***********************

    /**
     * Return the item at a particular position
     * @param pos position of the element to get
     *
     * @return whatever's at that position, null if not found
     */
    public native Record get(int pos) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = self.get(pos);
        return recordJS == null ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;

    /**
     * Return the number of items in this list
     *
     * @return number of items in the list
     */
    public native int getLength() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.getLength();
    }-*/;

    /**
     * Return whether or not this array is empty
     *
     * @return true == this array is empty, false == some items in the array
     */
    public native Boolean isEmpty() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.isEmpty();
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Return the first item in this list
     *
     * @return first item in the list
     */
    public native Record first() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS =  self.first();
        return recordJS == null || recordJS === undefined ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;

    /**
     * Return the last item in this list
     *
     * @return last item in the list
     */
    public native Record last() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS =   self.last();
        return recordJS == null || recordJS === undefined ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;

    /**
     * Return the position in the list of the first instance of the specified object. <p> If pos is specified, starts looking
     * after that position. <p> Returns -1 if not found.
     * @param record object to look for
     *
     * @return position of the item, if found, -1 if not found
     */
    public native int indexOf(Record record) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.indexOf(record.@com.smartgwt.client.data.Record::getJsObj()());
    }-*/;

    /**
     * Return the position in the list of the first instance of the specified object. <p> If pos is specified, starts looking
     * after that position. <p> Returns -1 if not found.
     * @param record object to look for
     * @param pos earliest index to consider
     * @param endPos last index to consider
     *
     * @return position of the item, if found, -1 if not found
     */
    public native int indexOf(Record record, int pos, int endPos) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.indexOf(record.@com.smartgwt.client.data.Record::getJsObj()(), pos, endPos);
    }-*/;

    /**
     * Return the position in the list of the last instance of the specified object. <p> If pos is specified, starts looking
     * before that position. <p> Returns -1 if not found.
     * @param record object to look for
     *
     * @return position of the item, if found, -1 if not found
     */
    public native int lastIndexOf(Record record) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.lastIndexOf(record.@com.smartgwt.client.data.Record::getJsObj()());
    }-*/;

    /**
     * Return the position in the list of the last instance of the specified object. <p> If pos is specified, starts looking
     * before that position. <p> Returns -1 if not found.
     * @param record object to look for
     * @param pos last index to consider
     * @param endPos earliest index to consider
     *
     * @return position of the item, if found, -1 if not found
     */
    public native int lastIndexOf(Record record, int pos, int endPos) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.lastIndexOf(record.@com.smartgwt.client.data.Record::getJsObj()(), pos, endPos);
    }-*/;

    /**
     * Find the index of the first Record where property == value in the object. <P> Note: for string values, matches are case sensitive.
     * @param properties set of properties and values to match
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(Map properties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(@com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(properties));
    }-*/;

    /**
     * Find the index of the first Record where property == value in the object. <P> Note: for string values, matches are case sensitive.
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(String propertyName, String value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(propertyName, value);
    }-*/;

    /**
     * Find the index of the first Record where property == value in the object.
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(String propertyName, int value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(propertyName, value);
    }-*/;

    /**
     * Find the index of the first Record where property == value in the object.
     * <P> Note: JavaScript has no long type, so the long value becomes a JavaScript Number, which has a lesser range than Java long.
     * The range for integer numbers in Javascript is [-9007199254740992,9007199254740992] or [-Math.pow(2,53),Math.pow(2,53)].
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(String propertyName, Long value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(propertyName, value);
    }-*/;

    /**
     * Find the index of the first Record where property == value in the object.
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(String propertyName, float value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(propertyName, value);
    }-*/;

    /**
     * Find the index of the first Record where property == value in the object.
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(String propertyName, boolean value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(propertyName, value);
    }-*/;

    /**
     * Find the index of the first Record where property == value in the object.
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(String propertyName, Date value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(propertyName, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value));
    }-*/;

    /**
     * Like {@link RecordList#findIndex}, but inspects a range from startIndex to endIndex.
     * @param startIndex first index to consider
     * @param propertyName property to match
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName);
    }-*/;

    /**
     * Like {@link RecordList#findIndex}, but inspects a range from startIndex to endIndex.
     * @param startIndex first index to consider
     * @param properties set of properties and values to match
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, Map properties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, @com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(properties));
    }-*/;

    /**
     * Like {@link RecordList#findIndex}, but inspects a range from startIndex to endIndex.
     * @param startIndex first index to consider
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     * @param endIndex last index to consider
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName, String value, int endIndex) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName, value, endIndex);
    }-*/;

    /**
     * Like {@link RecordList#findIndex}, but inspects a range from startIndex to endIndex.
     * @param startIndex first index to consider
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     * @param endIndex last index to consider
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName, int value, int endIndex) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName, value, endIndex);
    }-*/;

    /**
     * Like {@link RecordList#findIndex}, but inspects a range from startIndex to endIndex.
     * <P> Note: JavaScript has no long type, so the long value becomes a JavaScript Number, which has a lesser range than Java long.
     * The range for integer numbers in Javascript is [-9007199254740992,9007199254740992] or [-Math.pow(2,53),Math.pow(2,53)].
     * @param startIndex first index to consider
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     * @param endIndex last index to consider
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName, Long value, int endIndex) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName, value, endIndex);
    }-*/;

    /**
     * Like {@link RecordList#findIndex}, but inspects a range from startIndex to endIndex.
     * @param startIndex first index to consider
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     * @param endIndex last index to consider
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName, float value, int endIndex) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName, value, endIndex);
    }-*/;

    /**
     * Like {@link RecordList#findIndex}, but inspects a range from startIndex to endIndex.
     * @param startIndex first index to consider
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     * @param endIndex last index to consider
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName, boolean value, int endIndex) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName, value, endIndex);
    }-*/;

    /**
     * Like {@link RecordList#findIndex}, but inspects a range from startIndex to endIndex.
     * @param startIndex first index to consider
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     * @param endIndex last index to consider
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, String propertyName, Date value, int endIndex) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, propertyName, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value), endIndex);
    }-*/;

    /**
     * Like {@link RecordList#findIndex}, but returns the object itself instead of its index.
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return first matching object or null if not found
     */
    public native Record find(String propertyName, Object value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = self.find(propertyName, value);
        return recordJS == null || recordJS === undefined ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;

    /**
     * Like {@link RecordList#findIndex}, but returns the object itself instead of its index.
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return first matching object or null if not found
     */
    public Record find(String propertyName, Date value) {
        return find(propertyName, (Object) JSOHelper.convertToJavaScriptDate(value));
    }

    /**
     * Find all objects where property == value in the object
     * @param properties set of properties and values to
     * match
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(Map properties) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(@com.smartgwt.client.util.JSOHelper::convertMapToJavascriptObject(Ljava/util/Map;)(properties));
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Find all objects where property == value in the object.
     *
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(String propertyName, String value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(propertyName, value);
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Find all objects where property == value in the object
     *
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(String propertyName, int value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(propertyName, value);
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Find all objects where property == value in the object
     * <P> Note: JavaScript has no long type, so the long value becomes a JavaScript Number, which has a lesser range than Java long.
     * The range for integer numbers in Javascript is [-9007199254740992,9007199254740992] or [-Math.pow(2,53),Math.pow(2,53)].
     *
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(String propertyName, Long value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(propertyName, value);
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Find all objects where property == value in the object
     *
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(String propertyName, float value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(propertyName, value);
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Find all objects where property == value in the object.
     *
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(String propertyName, boolean value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(propertyName, value);
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Find all objects where property == value in the object.
     *
     * @param propertyName property to match
     * @param value value to compare against (if propertyName is a string)
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(String propertyName, Date value) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(propertyName, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(value));
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Filters all objects according to the AdvancedCriteria passed
     *
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return all matching Objects or null if none found
     */
    public native Record[] findAll(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS = self.findAll(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Filters all objects according to the AdvancedCriteria passed and returns the first matching object or null if not found
     *
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return first matching object or null if not found
     */
    public native Record find(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = self.find(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
        return recordJS == null || recordJS === undefined ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;

    /**
     * Finds the index of the first Record that matches with the AdvacendCriteria passed.
     * @param adCriteria AdvancedCriteria to use to filter results
     *
     * @return index of the first matching Record or -1 if not found
     */
    public native int findIndex(AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findIndex(adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;

    /**
     * Like {@link RecordList#findIndex}, but considering the startIndex and endIndex parameters.
     * @param startIndex first index to consider
     * @param adCriteria AdvancedCriteria to use to filter results
     * @param endIndex last index to consider
     * 
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, AdvancedCriteria adCriteria, int endIndex) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()(), null, endIndex);
    }-*/;

    /**
     * Like {@link RecordList#findIndex}, but considering the startIndex parameter.
     * @param startIndex first index to consider
     * @param adCriteria AdvancedCriteria to use to filter results
     * 
     * @return index of the first matching Record or -1 if not found
     */
    public native int findNextIndex(int startIndex, AdvancedCriteria adCriteria) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        return self.findNextIndex(startIndex, adCriteria.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
    
    /**
     * Return if this list contains the specified object.
     * @param record item to look for
     *
     * @return true == item was found, false == not found
     */
    public native Boolean contains(Record record) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.contains(record.@com.smartgwt.client.data.Record::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Return if this list contains the specified object. <P> If pos is specified, starts looking after that position.
     * @param record item to look for
     * @param pos optional position in the list to look after
     *
     * @return true == item was found, false == not found
     */
    public native Boolean contains(Record record, int pos) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.contains(record.@com.smartgwt.client.data.Record::getJsObj()(), pos);
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
                return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Return whether this list contains all the item in the specified list.
     * @param list items to look for
     *
     * @return whether all items were found
     */
    public native Boolean containsAll(RecordList list) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.containsAll(list.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Return the list of items that are in both this list and the passed-in list.
     * @param list list to intersect with
     *
     * @return intersection
     */
    public native RecordList intersect(RecordList list) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.intersect(list.@com.smartgwt.client.data.RecordList::getJsObj()());
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Return whether this list is equal to another list. <P> Two lists are equal only if they have the same length and all
     * contained items are in the same order and are also equal.
     * @param list list to check for equality
     *
     * @return whether the specified list is equal to this list
     */
    public native Boolean equals(RecordList list) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.equals(list.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Return the items at a list of specified positions.
     * @param itemList array of positions
     *
     * @return subset of the array, in the same order as itemList
     */
    public native Record[] getItems(int[] itemList) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS =  self.getItems(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([I)(itemList));
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Return the items between position start and end, non-inclusive at the end.
     * @param start start position
     * @param end end position
     *
     * @return subset of the array from start -> end-1
     */
    public native Record[] getRange(int start, int end) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS =  self.getRange(start, end);
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Return an Array that is a shallow copy of the list, that is, containing the same items.
     *
     * @return new array, pointing to the same items
     */
    public native Record[] duplicate() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS =   self.duplicate();
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Change the array element at a particular position. <P> set() can be used to expand the length of the list.
     * @param pos position in the list to change
     * @param record new value for that position
     *
     * @return whatever's at that position, null if not found
     */
    public native Record set(int pos, Record record) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS = self.set(pos, record.@com.smartgwt.client.data.Record::getJsObj()());
        return recordJS == null || recordJS === undefined ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;

    /**
     * Add a single item to this array at a specific position in the list, sliding other items over to fit.
     * @param record object to add
     * @param pos position in the list to add at
     *
     * @return object that was added
     */
    public native Record addAt(Record record, int pos) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS =  self.addAt(record.@com.smartgwt.client.data.Record::getJsObj()(), pos);
        return recordJS == null || recordJS === undefined ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;

    /**
     * Remove the item at the specified position, rearranging all subsequent items to fill the gap
     * @param pos position to remove
     *
     * @return item that was removed
     */
    public native Record removeAt(int pos) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordJS =   self.removeAt(pos);
        return recordJS == null || recordJS === undefined ? null : @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(recordJS);
    }-*/;

    /**
     * Add an object to this list, at the end
     * @param record object to add
     *
     */
    public native void add(Record record) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.add(record.@com.smartgwt.client.data.Record::getJsObj()());
    }-*/;

    /**
     * Add a list of items to this array. <P> Note: you can specify that a subset range be added by passing start and end
     * indices
     * @param list list of items to add
     *
     */
    public native void addList(Record[] list) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addList(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(list));
    }-*/;

    /**
     * Add a list of items to this array. <P> Note: you can specify that a subset range be added by passing start and end
     * indices
     * @param list list of items to add
     * @param listStartRow optional start index in list
     * @param listEndRow optional end index in list (non-inclusive)
     *
     */
    public native void addList(Record[] list, int listStartRow, int listEndRow) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addList(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(list), listStartRow, listEndRow);
    }-*/;

    /**
     * Set the length of this list. <P> If the length of the list is shortened, any elements past the new length of the list
     * are removed. If the length is increased, all positions past the old length have the value <code>undefined</code>.
     * @param length new length
     */
    public native void setLength(int length) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setLength(length);
    }-*/;

    /**
     * Add list of items list to this array at item pos.  All items after array[pos] will slide down to fit new items.
     * @param list new array of items
     * @param pos position in this list to put the new items
     *
     */
    public native void addListAt(Record[] list, int pos) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.addListAt(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(list), pos);
    }-*/;

    /**
     * Remove first instance of the passed object from this array, sliding other items around to fill gaps.
     * @param record item to remove
     *
     * @return true if a matching object was found and removed, false if no matching object was found and the list remains unchanged.
     */
    public native Boolean remove(Record record) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var retVal =self.remove(record.@com.smartgwt.client.data.Record::getJsObj()());
        if(retVal == null || retVal === undefined) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
    }-*/;

    /**
     * Remove all instances of objects in the specified list from this list, sliding the remaining objects around to fill gaps.
     * @param list list of items to remove
     *
     */
    public native void removeList(Record[] list) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.removeList(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(list));
    }-*/;

    /**
     * Sorts the elements of the List in place. <P> The optional comparator function should take two parameters "a" and "b"
     * which are the two list items to compare, and should return: <ul> <li> a value less than zero, if "a" is less than "b"
     * such that "a" should appear earlier in the      list <li> zero, if "a" and "b" are equal <li> a value greater than zero,
     * if "a" is greater than "b" such that "b" should appear earlier in      the list </ul>
     *
     */
    public native void sort() /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.sort();
    }-*/;

    /**
     * Sorts the elements of the List in place. <P> The optional comparator function should take two parameters "a" and "b"
     * which are the two list items to compare, and should return: <ul> <li> a value less than zero, if "a" is less than "b"
     * such that "a" should appear earlier in the      list <li> zero, if "a" and "b" are equal <li> a value greater than zero,
     * if "a" is greater than "b" such that "b" should appear earlier in      the list </ul>
     * @param comparator comparator function to use
     *
     * @return the list itself
     */
    public native RecordList sort(Comparator<Record> comparator) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var result = self.sort(function(record1, record2) {
            var record1J = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record1);
            var record2J = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record2);
            return comparator.@java.util.Comparator::compare(Ljava/lang/Object;Ljava/lang/Object;)(record1J, record2J);
        });
        if (result == null) return null;
        return @com.smartgwt.client.data.RecordList::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(result);
    }-*/;

    /**
     * Return a new Array where the value of item i is the value of "property" of item i in this array.  If an item doesn't
     * have that property or is null, return item will be null.
     * @param property name of the property to look for
     *
     * @return array of the values of property in each item of this list
     */
    public native Record[] getProperty(String property) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var recordsJS =  self.getProperty(property);
        return recordsJS == null || recordsJS === undefined ? null : @com.smartgwt.client.data.Record::convertToRecordArray(Lcom/google/gwt/core/client/JavaScriptObject;)(recordsJS);
    }-*/;

    /**
     * Sort a list of objects by a given property of each item. <P> The optional normalizer, if passed as a function, is called
     * for each item in the List, and should return whatever value should be used for sorting, which does not have to agree
     * with the property value. By passing a normalizer function you can achieve any kind of sorting you'd like, including
     * sorting by multiple properties. <P> NOTE: string sort is case INsensitive by default
     * @param property name of the property to sort by
     * @param up true == sort ascending, false == sort descending
     *
     * @return the list itself
     */
    public native RecordList sortByProperty(String property, boolean up) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret = self.sortByProperty(property, up);
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Sort this ResultSet by a property of each record. <P> Sorting is performed on the client for a ResultSet that has a full
     * cache for the current filter criteria.  Otherwise, sorting is performed by the server, and changing the sort order will
     * invalidate the cache. <P> <b>NOTE:</b> normalizers are not supported by ResultSets in "paged" mode
     * @param property name of the property to sort by
     * @param up true == sort ascending, false == sort descending
     * @param normalizer May be specified as a callbac with signature <code>normalize(item, propertyName)</code>, where
     * <code>item</code> is reference to the item in the array, <code>propertyName</code> is the
     * property by which the array is being sorted. Normalizer function should return the value normalized for sorting.
     */
    public native void sortByProperty(String property, boolean up, SortNormalizer normalizer) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.sortByProperty(property, up, normalizer == null ? null : $debox($entry(function(record, propertyName) {
                var recordJ = @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(record);
                var value = normalizer.@com.smartgwt.client.data.RecordList$SortNormalizer::normalize(Lcom/smartgwt/client/data/Record;Ljava/lang/String;)(recordJ, propertyName);
                if(value == null) return null;
                if(typeof value == 'string') {
                    return value;
                } else {
                    return @com.smartgwt.client.data.RecordList::normalizedValue(Ljava/lang/Number;)(value);
                }
            })));
    }-*/;

    private static double normalizedValue(Number number) {
        return JSOHelper.doubleValue(number);
    }

    /**
     * Multi-Property sort. Sort this ResultSet by a list of {@link com.smartgwt.client.data.SortSpecifier}'s.
     *
     * @param sortSpecifiers a list of {@link com.smartgwt.client.data.SortSpecifier} objects, one per sort-field and direction
     */
    public native void setSort(SortSpecifier... sortSpecifiers)/*-{
        var sortSpecifiersJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(sortSpecifiers);
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        self.setSort(sortSpecifiersJS);
    }-*/;

    /**
     * Get a map of the form <code>{ item[idField] -&gt; item[displayField] }</code>, for all  items in the list.  Note that if
     * more than one item has the same <code>idProperty</code>,  the value for the later item in the list will clobber the
     * value for the earlier item.
     * @param idField Property to use as ID (data value) in the valueMap
     * @param displayField Property to use a display value in the valueMap
     *
     * @return valueMap object
     */
    public native Map getValueMap(String idField, String displayField) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var mapJS = self.getValueMap(idField, displayField);
        return mapJS == null ? null : @com.smartgwt.client.util.JSOHelper::convertToMap(Lcom/google/gwt/core/client/JavaScriptObject;)(mapJS);
    }-*/;

     /**
     * Add a DataChanged handler.
     * <p>
     * Notification fired when data changes in some way. Note that this will only fire when items are added, removed or
     * rearranged. If a list contains objects, this method will not fire if changes are made to objects within the list without
     * changing their position within the list
     *
     * @param handler the DataChanged handler
     * @return {@link com.google.gwt.event.shared.HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDataChangedHandler(com.smartgwt.client.data.events.DataChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.data.events.DataChangedEvent.getType()) == 0) setupDataChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.data.events.DataChangedEvent.getType());
    }

    private native void setupDataChangedEvent() /*-{
        var obj,
            selfJ = this;
        if (this.@com.smartgwt.client.core.BaseClass::isCreated()()) {
            obj = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        }
        obj.onDataChanged = $entry(function () {
            var param = {};
            var event = @com.smartgwt.client.data.events.DataChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.core.BaseClass::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
        });
    }-*/;

    /**
     * Returns the records in this RecordList as an array.
     *
     * @return an array of records.
     */
    public Record[] toArray() {
        return getRange(0, getLength());
    }

    public interface SortNormalizer {
        /**
         * The normalization function.
         *
         * @param record    the record to normalize
         * @param fieldName name of the field on which sorting occurred
         * @return normalized value for sorting (a java numeric primitive type or String)
         */
        Object normalize(Record record, String fieldName);
    }

    /**
     * Return a RecordList with the items between position start and end, non-inclusive at the end.
     * @param start start position
     * @param end end position
     *
     * @return a RecordList with the items from start -> end-1
     */
    public native RecordList getRangeList(int start, int end) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::getOrCreateJsObj()();
        var ret =  self.getRange(start, end);
        if(ret == null || ret === undefined) return null;
        return @com.smartgwt.client.data.RecordList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;
}



