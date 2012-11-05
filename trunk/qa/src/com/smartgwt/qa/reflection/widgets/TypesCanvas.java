/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
 
package com.smartgwt.qa.reflection.widgets;

import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.types.Alignment;

import java.util.Map;
import java.util.HashMap;
import java.util.Date;

// For tests. 
public class TypesCanvas extends Canvas {
    private int prInt;
    public int getPrInt () {return prInt;}
    public void setPrInt (int v) {prInt = v;} 
    
    private Integer pInteger;
    public Integer getInteger () {return pInteger;}
    public void setInteger (Integer v) {pInteger = v;}

    private float prFloat;
    public float getPrFloat () {return prFloat;}
    public void setPrFloat (float v) {prFloat = v;} 
    
    private Float pFloat;
    public Float getFloat () {return pFloat;}
    public void setFloat (Float v) {pFloat = v;} 
    
    private long prLong;
    public long getPrLong () {return prLong;}
    public void setPrLong (long v) {prLong = v;} 
    
    private Long pLong;
    public Long getLong () {return pLong;}
    public void setLong (Long v) {pLong = v;} 
    
    private double prDouble;
    public double getPrDouble () {return prDouble;}
    public void setPrDouble (double v) {prDouble = v;} 
    
    private Double pDouble;
    public Double getDouble () {return pDouble;}
    public void setDouble (Double v) {pDouble = v;} 
    
    private boolean prBoolean;
    public boolean getPrBoolean () {return prBoolean;}
    public void setPrBoolean (boolean v) {prBoolean = v;} 
    
    private Boolean pBoolean;
    public Boolean getBoolean () {return pBoolean;}
    public void setBoolean (Boolean v) {pBoolean = v;} 
    
    private Date pDate;
    public Date getDate () {return pDate;}
    public void setDate (Date v) {pDate = v;} 

    private JavaScriptObject pJavaScriptObject;
    public JavaScriptObject getJavaScriptObject () {return pJavaScriptObject;}
    public void setJavaScriptObject (JavaScriptObject v) {pJavaScriptObject = v;} 
   
    public static class JsoSubclass extends JavaScriptObject {
        protected JsoSubclass () {

        }
    }

    private JsoSubclass pJsoSubclassObject;
    public JsoSubclass getJsoSubclass () {return pJsoSubclassObject;}
    public void setJsoSubclass (JsoSubclass v) {pJsoSubclassObject = v;}

    private String pString;
    public String getString () {return pString;}
    public void setString (String v) {pString = v;} 

    public enum TestEnum {
        VALUE1,
        VALUE2
    }

    private TestEnum pEnum;
    public TestEnum getEnum () {return pEnum;}
    public void setEnum (TestEnum v) {pEnum = v;}

    private Alignment pValueEnum;
    public Alignment getValueEnum () {return pValueEnum;}
    public void setValueEnum (Alignment v) {pValueEnum = v;}

    public interface TestInterface {
        public void testMethod ();
    }

    private TestInterface pInterface;
    public TestInterface getInterface () {return pInterface;}
    public void setInterface (TestInterface v) {pInterface = v;}

    private TestInterface[] pInterfaceArray;
    public TestInterface[] getInterfaceArray () {return pInterfaceArray;}
    public void setInterfaceArray (TestInterface[] v) {pInterfaceArray = v;}

    private Canvas pCanvas;
    public Canvas getCanvas () {return pCanvas;}
    public void setCanvas (Canvas v) {pCanvas = v;}

    public static class OtherValue {
        int property;
    }

    public static class OtherValueSubclass extends OtherValue {

    }

    private OtherValue pOtherValue;
    public OtherValue getOtherValue () {return pOtherValue;}
    public void setOtherValue (OtherValue v) {pOtherValue = v;}

    private int[] prIntArray;
    public int[] getPrIntArray () {return prIntArray;}
    public void setPrIntArray (int[] v) {prIntArray = v;}

    private Number pNumber;
    public Number getNumber () {return pNumber;}
    public void setNumber (Number v) {pNumber = v;}

    private Number[] pNumberArray;
    public Number[] getNumberArray () {return pNumberArray;}
    public void setNumberArray (Number[] v) {pNumberArray = v;}

    private boolean[] pBooleanArray;
    public boolean[] getBooleanArray () {return pBooleanArray;}
    public void setBooleanArray (boolean[] v) {pBooleanArray = v;}
}
