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

package com.smartgwt.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.ValueEnum;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.widgets.BaseWidget;
import com.smartgwt.client.bean.BeanFactory;

import java.util.Date;
import java.util.Map;

public class DataClass extends JsObject {

    // Properties stashed by BeanFactory when calling the no-arg constructor.
    // We pick them up immediately in the constructor so that they don't get
    // applied to the wrong object (in case the constructor of a subclass
    // triggers the construction of some other object -- which, admittedly,
    // is unlikely in the case of DataClass, but better safe than sorry).
    protected Map<String, Object> factoryProperties;

    // Called by the generated BeanFactory once the instance is fully
    // constructed.  Unlike the implementation in BaseWidget, we don't call
    // this before creating the jsObj, because we're not supplying any
    // properties to the SmartClient constructor. So, this is here just so that
    // BeanFactory doesn't need to care whether it's dealing with a BaseWidget
    // or a DataClass.
    public void applyFactoryProperties () {
        if (factoryProperties != null) {
            // Make sure that this is re-entrant without infinite loop
            Map<String, Object> properties = factoryProperties;
            factoryProperties = null;

            BeanFactory.setProperties(this, properties);
        }
    }
    
    // Tracks whether this object was created by a BeanFactory. The BeanFactory
    // code will set this property via the reflection mechanism when creating
    // an instance. Thus, it can check whether the property has been correctly
    // applied. (That is, if factoryCreated is false for an object which 
    // BeanFactory creates, then BeanFactory knows something went wrong).
    //
    // There is one known case where properties are not correctly applied via
    // reflection: when (a) a class has a static initializer; (b) the static
    // initializer is not triggered before the use of reflection to create an
    // object of that class; and (c) the static initializer itself creates an
    // object of that class. 
    //
    // We can't detect that case directly, but we can at least detect the
    // resulting failure and try to recover (and generate a useful error
    // message).
    protected boolean factoryCreated;

    public void setFactoryCreated (boolean createdByBeanFactory) {
        factoryCreated = createdByBeanFactory;
    }

    public boolean isFactoryCreated () {
        return factoryCreated;
    }

    public DataClass() {
        super(JSOHelper.createObject());

        // Stash any properties supplied by BeanFactory, if intended for an
        // object of this class. The properties will be applied by generated
        // BeanFactory code once the object is fully constructed.
        if (getClass() == BeanFactory.getFactoryPropertiesClass()) {
            factoryProperties = BeanFactory.getFactoryProperties();
            BeanFactory.clearFactoryProperties();
        }
    }

    public DataClass(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * Set attribute value to a String
     * @param property
     * @param value
     */
    public void setAttribute(String property, String value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Returns attribute value as a String
     * @param property
     * @return
     */
    public String getAttribute(String property) {
        return JSOHelper.getAttribute(jsObj, property);
    }

    /**
     * Returns attribute value as a String.
     * @param property
     * @return
     */
    public String getAttributeAsString(String property) {
        return JSOHelper.getAttribute(jsObj, property);
    }

    /**
     * Set attribute value to an int.
     * Value will be stored as a JavaScript Number on the underlying data object
     * @param property
     * @param value
     */
    public void setAttribute(String property, int value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Set attribute value to a double.
     * Value will be stored as a JavaScript Number on the underlying data object
     * @param property
     * @param value
     */
    public void setAttribute(String property, double value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Set attribute value to a long.
     * Value will be stored as a JavaScript Number on the underlying data object.
     * @param property
     * @param value
     */
    public void setAttribute(String property, long value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Returns attribute value as an Integer.
     * Applies to values stored as a JavaScript number on the underlying data object.
     * @param property
     * @return
     */
    public Integer getAttributeAsInt(String property) {
        return JSOHelper.getAttributeAsInt(jsObj, property);
    }

    /**
     * Set attribute value to a boolean.
     * @param property
     * @param value
     */
    public void setAttribute(String property, boolean value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Returns attribute value set as a Boolean.
     * @param property
     * @return
     */
    public Boolean getAttributeAsBoolean(String property) {
        return JSOHelper.getAttributeAsBoolean(jsObj, property);
    }

    /**
     * Returns attribute as a Double.
     * Applies to values stored as a JavaScript Number on the underlying data object.
     * @param property
     * @return
     */
    public Double getAttributeAsDouble(String property) {
        return JSOHelper.getAttributeAsDouble(jsObj, property);
    }

    /**
     * Returns attribute as a Long.
     * Applies to values stored as a JavaScript Number on the underlying data object.
     * @param property
     * @return
     */
    public Long getAttributeAsLong(String property) {
        Double dVal = this.getAttributeAsDouble(property);
        return dVal == null ? null : dVal.longValue();
    }

    /**
     * Returns attribute as a double array.
     * Applies to values stored as a JavaScript Array of Numbers on the underlying data object.
     * @param property
     * @return
     */
    public double[] getAttributeAsDoubleArray(String property) {
        return JSOHelper.getAttributeAsDoubleArray(jsObj, property);
    }

    /**
     * Set attribute value to an int array.
     * Value will be stored as a JavaScript Array of Numbers on the underlying data object.
     * @param property
     * @param value
     */
    public void setAttribute(String property, int[] value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Set attribute value to an Integer array.
     * Value will be stored as a JavaScript Array of Numbers on the underlying data object.
     * @param property
     * @param value
     */
    public void setAttribute(String property, Integer[] value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Set attribute value to a DataClass array.
     * Value will be stored as a JavaScript Array of the underlying JavaScript objects for each entry.
     * @param property
     * @param value
     */
    public void setAttribute(String property, DataClass[] value) {
        JSOHelper.setAttribute(jsObj, property, JSOHelper.convertToJavaScriptArray(value));
    }

    /**
     * Set attribute value to a BaseClass array.
     * Value will be stored as a JavaScript Array of the underlying JavaScript objects for each entry.
     * @param property
     * @param value
     */
    public void setAttribute(String property, BaseClass[] value) {
        JSOHelper.setAttribute(jsObj, property, JSOHelper.convertToJavaScriptArray(value));
    }

    /**
     * Set attribute value to a BaseWidget array.
     * Value will be stored as a JavaScript Array of the underlying JavaScript objects for each entry.
     * @param property
     * @param value
     */
    public void setAttribute(String property, BaseWidget[] value) {
        JSOHelper.setAttribute(jsObj, property, JSOHelper.convertToJavaScriptArray(value));
    }

    /**
     * Returns attribute as an int array.
     * Applies to values stored as a JavaScript Array of Numbers on the underlying data object.
     * @param property
     * @return
     */
    public int[] getAttributeAsIntArray(String property) {
        return JSOHelper.getAttributeAsIntArray(jsObj, property);
    }

    /**
     * Set attribute value to a String array.
     * Value will be stored as a JavaScript Array of Strings on the underlying data object.
     * @param property
     * @param value
     */
    public void setAttribute(String property, String[] value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Returns attribute as a String array.
     * Applies to values stored as a JavaScript Array of Strings on the underlying data object.
     * @param property
     * @return
     */
    public String[] getAttributeAsStringArray(String property) {
        return JSOHelper.getAttributeAsStringArray(jsObj, property);
    }

    /**
     * Set attribute value to a DataClass.
     * Value will be stored as the underlying JavaScript object for the DataClass
     * instance passed in.
     * 
     * @param property
     * @param value
     */
    public void setAttribute(String property, DataClass value) {
        JSOHelper.setAttribute(jsObj, property, value == null ? null : value.getJsObj());
    }

    /**
     * Set attribute value to a BaseClass.
     * Value will be stored as the underlying JavaScript object for the BaseClass
     * instance passed in.
     * 
     * @param property
     * @param value
     */
    public void setAttribute(String property, BaseClass value) {
        JSOHelper.setAttribute(jsObj, property, value == null ? null : value.getOrCreateJsObj());
    }

    /**
     * Set attribute value to a JavaScriptObject.
     * 
     * @param property
     * @param value
     */
    public void setAttribute(String property, JavaScriptObject value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Set attribute value to a Date.
     * Value will be stored as a JavaScript Date on the underlying data object
     * 
     * @param property
     * @param value
     */
    public void setAttribute(String property, Date value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Set attribute value to a double array.
     * Value will be stored as a JavaScript Array of Numbers on the underlying data object
     * 
     * @param property
     * @param value
     */
    public void setAttribute(String property, double[] value) {
    	JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Set attribute value to a Boolean.
     * 
     * @param property
     * @param value
     */
    public void setAttribute(String property, Boolean value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Set attribute value to a Map.
     * Value will be stored as a JavaScript Object on the underlying data object,
     * with property/value pairs matching the keys/values specified on the Map.
     * Note that this is a recursive conversion - each value will also be converted to
     * the equivalent JavaScript type where appropriate. 
     * 
     * @param property
     * @param value
     */
    public void setAttribute(String property, Map value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }
    
    /**
     * Set attribute value to a ValueEnum array.
     * Value will be stored as a JavaScript Array containing the each Enum value.
     * 
     * @param property
     * @param value
     */
    public void setAttribute(String property, ValueEnum[] value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Set attribute value to a ValueEnum.
     * The value of the ValueEnum will be stored on the underlying data object.
     * 
     * @param property
     * @param value
     */
    public void setAttribute(String property, ValueEnum value) {
        JSOHelper.setAttribute(jsObj, property, value == null ? null : value.getValue());
    }
    
    /**
     * Set the attribute value to an Object.
     * <P> 
     * The values provided as attributes are generally expected to contain valid values for a field
     * of a DataBoundComponent. Therefore this method converts the value passed in to an equivalent object in JavaScript before
     * storing on underlying data object. <br>
     * Developers can use {@link #setAttributeAsJavaObject(String, Object)} to store Java objects 
     * without converting to JavaScript.
     * 
     * <P>
     * Conversions that occur include:
     * <ul>
     * <li>Numeric data types will be represented as JavaScript Number</li>
     * <li>Dates (and subclasses) will be stored as JavaScript Date</li>
     * <li>Java Arrays will be stored as JavaScript Array, with members converted to the
     * 		equivalent JavaScript type where appropriate</li>
     * <li>Java Collections (including List, Set) will be stored as JavaScript Array, with members converted to the
     * 		equivalent JavaScript object (recursively) where appropriate</li>
     * <li>Maps are stored as JavaScript Objects with each key mapped to a property on the object.
     * 		Property values are converted to the equivalent JavaScript object (recursively) where appropriate</li>
     * </ul>
     * Other Java Objects, including POJOs are stored on the underlying data object unconverted. Developers can
     * retrieve such values via {@link #getAttributeAsObject(String)}.
     *
     * @param property the attribute name
     * @param value the attribute value.
     */
    public void setAttribute(String property, Object value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Set the attribute value to an Object.
     * <P>
     * Unlike {@link #setAttribute(String, Object)}, this method will store the value passed in as-is
     * rather than converting to an equivalent object in JavaScript.
     * 
     * @param property
     * @param value
     */
    public void setAttributeAsJavaObject(String property, Object value) {
    	JSOHelper.setObjectAttribute(jsObj, property, value);
    }

    /**
     * Set attribute value to a Double.
     * Value will be stored as a JavaScript Number on the underlying data object
     * @param property
     * @param value
     */
    public void setAttribute(String property, Double value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Set attribute value to an Integer.
     * Value will be stored as a JavaScript Number on the underlying data object
     * @param property
     * @param value
     */
    public void setAttribute(String property, Integer value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Set attribute value to a Float.
     * Value will be stored as a JavaScript Number on the underlying data object
     * @param property
     * @param value
     */
    public void setAttribute(String property, Float value) {
        JSOHelper.setAttribute(jsObj, property, value);
    }

    /**
     * Returns attribute value as a Float.
     * Applies to values stored as a JavaScript number on the underlying data object.
     * @param property
     * @return
     */
    public Float getAttributeAsFloat(String property) {
        return JSOHelper.getAttributeAsFloat(jsObj, property);
    }

    /**
     * Returns attribute value as a Date.
     * Applies to values stored as a JavaScript Date on the underlying data object.
     * @param property
     * @return
     */
    public Date getAttributeAsDate(String property) {
        return JSOHelper.getAttributeAsDate(jsObj, property);
    }

    /**
     * Returns attribute value as a Java Object.
     * <P>
     * If the attribute has been set as a Java Object (typically via a call to 
     * {@link #setAttributeAsJavaObject(String, Object)}) it will be returned as is.
     * <P>
     * Values specified as JavaScript types will be converted to the equivalent 
     * Java type if possible.
     * @param property
     * @return
     */
    public Object getAttributeAsObject(String property) {
        return JSOHelper.getAttributeAsObject(jsObj, property);
    }

    /**
     * Returns attribute value as a Map.
     * Applies to values stored as a JavaScript Object on the underlying data object.
     * @param property
     * @return
     */
    public Map getAttributeAsMap(String property) {
        return JSOHelper.getAttributeAsMap(jsObj, property);
    }

    /**
     * Get the attribute value as a Record.
     *
     * @param property the property name
     * @return the record value
     */
    public Record getAttributeAsRecord(String property) {
        return Record.getOrCreateRef(getAttributeAsJavaScriptObject(property));
    }

    /**
     * Returns attribute value as a JavaScript Object.
     * @param property
     * @return
     */
    public JavaScriptObject getAttributeAsJavaScriptObject(String property) {
        return JSOHelper.getAttributeAsJavaScriptObject(jsObj, property);
    }
    
    public String[] getAttributes() {
        return JSOHelper.getProperties(jsObj);
    }

    //event handling code
    private HandlerManager manager = null;

    public void fireEvent(GwtEvent<?> event) {
        if (manager != null) {
            manager.fireEvent(event);
        }
    }

    protected final <H extends EventHandler> HandlerRegistration doAddHandler(
           final H handler, GwtEvent.Type<H> type) {
        return ensureHandlers().addHandler(type, handler);
    }

    /**
     * Ensures the existence of the handler manager.
     *
     * @return the handler manager
     **/
    HandlerManager ensureHandlers() {
        return manager == null ? manager = new HandlerManager(this)
        : manager;
    }

    HandlerManager getManager() {
        return manager;
    }

    public int getHandlerCount(GwtEvent.Type<?> type) {
        return manager == null? 0 : manager.getHandlerCount(type);
    }
}
