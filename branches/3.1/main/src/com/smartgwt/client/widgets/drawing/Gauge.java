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
 
package com.smartgwt.client.widgets.drawing;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.logicalstructure.core.*;
import com.smartgwt.logicalstructure.widgets.*;
import com.smartgwt.logicalstructure.widgets.drawing.*;
import com.smartgwt.logicalstructure.widgets.plugins.*;
import com.smartgwt.logicalstructure.widgets.form.*;
import com.smartgwt.logicalstructure.widgets.tile.*;
import com.smartgwt.logicalstructure.widgets.grid.*;
import com.smartgwt.logicalstructure.widgets.chart.*;
import com.smartgwt.logicalstructure.widgets.layout.*;
import com.smartgwt.logicalstructure.widgets.menu.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;

/**
 * The Gauge widget class implements a graphical speedometer-style gauge for displaying a measurement by means of a needle
 * on a dial. The dial is divided into sectors, each having its own color and value. <P> <b>NOTE:</b> you must load the
 * Drawing {@link com.smartgwt.client.docs.LoadingOptionalModules Optional Module} before you can use Gauge.
 */
public class Gauge extends DrawPane {

    public native static Gauge getOrCreateRef(JavaScriptObject jsObj) /*-{

    	if(jsObj == null) return null;
    	
    	var instance = jsObj["__ref"];
    	
    	if(instance==undefined) {
            return @com.smartgwt.client.util.ObjectFactory::createCanvas(Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)("Gauge",jsObj);
        } else if(instance != null) {
            return instance;
        //} else {
        //    return @com.smartgwt.client.widgets.drawing.Gauge::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj);
        }
    }-*/;

    public void setJavaScriptObject(JavaScriptObject jsObj) {
        id = JSOHelper.getAttribute(jsObj, "ID");
    }


    public Gauge(){
        scClassName = "Gauge";
    }

    public Gauge(JavaScriptObject jsObj){
        scClassName = "Gauge";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * Radius in pixels of the dial.
     *
     * @param dialRadius dialRadius Default value is 150
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDialRadius(float dialRadius)  throws IllegalStateException {
        setAttribute("dialRadius", dialRadius, false);
    }

    /**
     * Radius in pixels of the dial.
     *
     *
     * @return float
     */
    public float getDialRadius()  {
        return getAttributeAsFloat("dialRadius");
    }

    /**
     * Whether the sectors are drawn clockwise, and increasing the value causes the needle to move clockwise.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.drawing.Gauge#getDrawnClockwise drawnClockwise} property and redraws the gauge.
     *
     * @param drawnClockwise whether the sectors are drawn clockwise.. Default value is true
     */
    public void setDrawnClockwise(Boolean drawnClockwise) {
        setAttribute("drawnClockwise", drawnClockwise, true);
    }

    /**
     * Whether the sectors are drawn clockwise, and increasing the value causes the needle to move clockwise.
     *
     *
     * @return Boolean
     */
    public Boolean getDrawnClockwise()  {
        return getAttributeAsBoolean("drawnClockwise");
    }

    /**
     * Font size of sector labels. Must be at least 3.
     *
     * @param fontSize fontSize Default value is 11
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#setFontSize
     */
    public void setFontSize(int fontSize)  throws IllegalStateException {
        setAttribute("fontSize", fontSize, false);
    }

    /**
     * Font size of sector labels. Must be at least 3.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#getFontSize
     */
    public int getFontSize()  {
        return getAttributeAsInt("fontSize");
    }

    /**
     * The label prefix.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.drawing.Gauge#getLabelPrefix labelPrefix} property and recreates all sector labels.
     *
     * @param labelPrefix the new label prefix.. See {@link com.smartgwt.client.docs.String String}. Default value is ""
     * @see com.smartgwt.client.widgets.drawing.Gauge#formatLabelContents
     */
    public void setLabelPrefix(String labelPrefix) {
        setAttribute("labelPrefix", labelPrefix, true);
    }

    /**
     * The label prefix.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.widgets.drawing.Gauge#formatLabelContents
     */
    public String getLabelPrefix()  {
        return getAttributeAsString("labelPrefix");
    }

    /**
     * The label suffix.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.drawing.Gauge#getLabelSuffix labelSuffix} property and recreates all sector labels.
     *
     * @param labelSuffix the new label suffix.. See {@link com.smartgwt.client.docs.String String}. Default value is "%"
     * @see com.smartgwt.client.widgets.drawing.Gauge#formatLabelContents
     */
    public void setLabelSuffix(String labelSuffix) {
        setAttribute("labelSuffix", labelSuffix, true);
    }

    /**
     * The label suffix.
     *
     *
     * @return . See {@link com.smartgwt.client.docs.String String}
     * @see com.smartgwt.client.widgets.drawing.Gauge#formatLabelContents
     */
    public String getLabelSuffix()  {
        return getAttributeAsString("labelSuffix");
    }

    /**
     * Pixel width for sector label lines. Must be at least 10.
     *
     * @param lineWidth lineWidth Default value is 50
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setLineWidth
     */
    public void setLineWidth(int lineWidth)  throws IllegalStateException {
        setAttribute("lineWidth", lineWidth, false);
    }

    /**
     * Pixel width for sector label lines. Must be at least 10.
     *
     *
     * @return int
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getLineWidth
     */
    public int getLineWidth()  {
        return getAttributeAsInt("lineWidth");
    }

    /**
     * The maximum dial value.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the maximum dial value, rescaling all sectors and the dial value.
     *
     * @param maxValue the new maximum dial value. Must be at least 1 greater than the minimum dial value. If <code>maxValue</code> is not at
     * least 1 greater than the minimum value, then it is set to <code>1 + minValue</code>.. Default value is 100
     */
    public void setMaxValue(float maxValue) {
        setAttribute("maxValue", maxValue, true);
    }

    /**
     * The maximum dial value.
     *
     *
     * @return float
     */
    public float getMaxValue()  {
        return getAttributeAsFloat("maxValue");
    }

    /**
     * The minimum dial value.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the minimum dial value, rescaling all sectors and the dial value.
     *
     * @param minValue the new minimum dial value. Must be at least 1 less than the maximum dial value. If <code>minValue</code> is not at
     * least 1 less than the maximum value, then it is set to <code>maxValue - 1</code>.. Default value is 0
     */
    public void setMinValue(float minValue) {
        setAttribute("minValue", minValue, true);
    }

    /**
     * The minimum dial value.
     *
     *
     * @return float
     */
    public float getMinValue()  {
        return getAttributeAsFloat("minValue");
    }

    /**
     * The number of major tick lines.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the number of major tick lines. <p><b>NOTE:</b> To divide the dial into <i>n</i> regions, you will need <i>n</i> + 1 ticks. For example, if the minimum value is 0 and the maximum value is 100, then to place major tick lines at 0, 10, 20, 30, ..., 90, 100, you need 11 (10 + 1) major ticks.
     *
     * @param numMajorTicks the number of major tick lines to draw. Must be either 0 or an integer greater than or equal to 2.. Default value is 0
     */
    public void setNumMajorTicks(int numMajorTicks) {
        setAttribute("numMajorTicks", numMajorTicks, true);
    }

    /**
     * The number of major tick lines.
     *
     *
     * @return int
     */
    public int getNumMajorTicks()  {
        return getAttributeAsInt("numMajorTicks");
    }

    /**
     * The number of minor tick lines.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the number of minor tick lines. <p><b>NOTE:</b> To divide the dial into <i>n</i> regions, you will need <i>n</i> + 1 ticks. For example, if the minimum value is 0 and the maximum value is 100, then to place minor tick lines at 0, 1, 2, 3, 4, 5, ..., 99, 100, you need 101 (100 + 1) minor ticks.
     *
     * @param numMinorTicks the number of minor tick lines to draw. Must be either 0 or an integer greater than or equal to 2.. Default value is 0
     */
    public void setNumMinorTicks(int numMinorTicks) {
        setAttribute("numMinorTicks", numMinorTicks, true);
    }

    /**
     * The number of minor tick lines.
     *
     *
     * @return int
     */
    public int getNumMinorTicks()  {
        return getAttributeAsInt("numMinorTicks");
    }


    /**
     * Position in canvas coordinates of the pivot of the knob. <p><b>NOTE:</b> Until the gauge is drawn, the pivot point will
     * be <code>null</code>.
     *
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Point
     * @throws IllegalStateException if widget has not yet been rendered.
     */
    public Point getPivotPoint() throws IllegalStateException {
        errorIfNotCreated("pivotPoint");
        return new Point(getAttributeAsJavaScriptObject("pivotPoint"));
    }

    /**
     * Array of preset fill colors used by the default implementation of {@link
     * com.smartgwt.client.widgets.drawing.Gauge#getDefaultFillColor Gauge.getDefaultFillColor} to initialize the fill color of
     * new sectors. <p>The default array of colors is: <table border="0" cellpadding="0" cellspacing="2">   <tr>     <td
     * style="background-color:#AFFFFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#AFFFFF</a></td>     <td
     * style="background-color:#008080;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#008080</a></td>     <td
     * style="background-color:#AAAFFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#AAAFFF</a></td>     <td
     * style="background-color:#FF0000;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#FF0000</a></td>     <td
     * style="background-color:#FFCC99;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#FFCC99</a></td>     <td
     * style="background-color:#800080;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#800080</a></td>   </tr> </table>
     *
     * @param sectorColors . See {@link com.smartgwt.client.docs.CSSColor CSSColor}. Default value is [ "#AFFFFF", "#008080", "#AAAFFF", "#FF0000", "#FFCC99", "#800080" ]
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setFillColor
     */
    public void setSectorColors(String... sectorColors)  throws IllegalStateException {
        setAttribute("sectorColors", sectorColors, false);
    }

    /**
     * Array of preset fill colors used by the default implementation of {@link
     * com.smartgwt.client.widgets.drawing.Gauge#getDefaultFillColor Gauge.getDefaultFillColor} to initialize the fill color of
     * new sectors. <p>The default array of colors is: <table border="0" cellpadding="0" cellspacing="2">   <tr>     <td
     * style="background-color:#AFFFFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#AFFFFF</a></td>     <td
     * style="background-color:#008080;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#008080</a></td>     <td
     * style="background-color:#AAAFFF;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#AAAFFF</a></td>     <td
     * style="background-color:#FF0000;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#FF0000</a></td>     <td
     * style="background-color:#FFCC99;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#FFCC99</a></td>     <td
     * style="background-color:#800080;width:90px;height:90px;text-align:center"><a
     * style="vertical-align:middle">#800080</a></td>   </tr> </table>
     *
     *
     * @return . See {@link com.smartgwt.client.docs.CSSColor CSSColor}
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getFillColor
     */
    public String[] getSectorColors()  {
        return getAttributeAsStringArray("sectorColors");
    }

    /**
     * The current value on the dial.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the value on the dial that the needle is displaying.
     *
     * @param value the new dial value. Must be between {@link com.smartgwt.client.widgets.drawing.Gauge#getMinValue minValue} and {@link
     * com.smartgwt.client.widgets.drawing.Gauge#getMaxValue maxValue}.. Default value is 0
     */
    public void setValue(float value) {
        setAttribute("value", value, true);
    }

    /**
     * The current value on the dial.
     *
     *
     * @return float
     */
    public float getValue()  {
        return getAttributeAsFloat("value");
    }

    // ********************* Methods ***********************

    /**
     * Adds a new sector.
     * @param value the new sector's value. This is formatted with {@link com.smartgwt.client.widgets.drawing.Gauge#formatLabelContents
     * Gauge.formatLabelContents} to get its label.
     *
     * @return the index of the newly-added sector.
     */
    public native int addSector(float value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.addSector(value);
    }-*/;

    /**
     * Gets the number of sectors.
     *
     * @return the number of sectors on this gauge.
     */
    public native int getNumSectors() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getNumSectors();
    }-*/;

    /**
     * Gets the fill color of the sector at index <code>sectorIndex</code>.
     * @param sectorIndex index of the target sector.
     *
     * @return the fill color of the sector at <code>sectorIndex</code>.
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getFillColor
     */
    public native String getSectorFillColor(int sectorIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getSectorFillColor(sectorIndex);
    }-*/;

    /**
     * Gets the label contents of the label for the sector at <code>sectorIndex</code>.
     * @param sectorIndex index of the target sector.
     *
     * @return the label contents of the sector's label.
     */
    public native String getSectorLabelContents(int sectorIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getSectorLabelContents(sectorIndex);
    }-*/;

    /**
     * Gets the value of the sector at <code>sectorIndex</code>.
     * @param sectorIndex index of the target sector.
     *
     * @return the value of the sector at <code>sectorIndex</code>.
     */
    public native float getSectorValue(int sectorIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getSectorValue(sectorIndex);
    }-*/;

    /**
     * Resets the contents of all labels. This involves calling {@link
     * com.smartgwt.client.widgets.drawing.Gauge#formatLabelContents Gauge.formatLabelContents} to get the label contents for
     * each corresponding value and repositioning the label.
     */
    public native void reformatLabelContents() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.reformatLabelContents();
    }-*/;

    /**
     * Removes the sector at <code>sectorIndex</code>. <p><b>NOTE:</b> There must always be one sector and it is not possible
     * to remove the sole remaining sector. Calling this method to attempt to remove the sole remaining sector is a no-op.
     * @param sectorIndex the index of the sector to remove.
     */
    public native void removeSector(int sectorIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeSector(sectorIndex);
    }-*/;

    /**
     * Sets the fill color of the sector at <code>sectorIndex</code>.
     * @param sectorIndex index of the target sector.
     * @param fillColor the new fill color.
     */
    public native void setSectorFillColor(int sectorIndex, String fillColor) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setSectorFillColor(sectorIndex, fillColor);
    }-*/;

    // ********************* Static Methods ***********************
    /**
     * Class level method to set the default properties of this class. If set, then all subsequent instances of this
     * class will automatically have the default properties that were set when this method was called. This is a powerful
     * feature that eliminates the need for users to create a separate hierarchy of subclasses that only alter the default
     * properties of this class. Can also be used for skinning / styling purposes.
     * <P>
     * <b>Note:</b> This method is intended for setting default attributes only and will effect all instances of the
     * underlying class (including those automatically generated in JavaScript). 
     * This method should not be used to apply standard EventHandlers or override methods for
     * a class - use a custom subclass instead.
     *
     * @param gaugeProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(Gauge gaugeProperties) /*-{
    	var properties = $wnd.isc.addProperties({},gaugeProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.Gauge.addProperties(properties);
    }-*/;
        
    // ***********************************************************        


    @Override
    protected void onInit () {
        super.onInit();
        onInit_Gauge();
    }

    private native void onInit_Gauge() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();

        self.__formatLabelContents = self.formatLabelContents;
        self.formatLabelContents = $entry(function (value) {
            var jObj = this.__ref;
            return jObj.@com.smartgwt.client.widgets.drawing.Gauge::formatLabelContents(F)(value);
        });

        self.__getDefaultFillColor = self.getDefaultFillColor;
        self.getDefaultFillColor = $entry(function (sectorIndex) {
            var jObj = this.__ref;
            return jObj.@com.smartgwt.client.widgets.drawing.Gauge::getDefaultFillColor(I)(sectorIndex);
        });
        self.sectors[0].setFillColor(this.@com.smartgwt.client.widgets.drawing.Gauge::getDefaultFillColor(I)(0));
    }-*/;

    /**
     * Formats a value as a string to be used as the contents of a {@link com.smartgwt.client.widgets.drawing.DrawLabel}.  The default implementation prepends
     * {@link com.smartgwt.client.widgets.drawing.Gauge#getLabelPrefix labelPrefix} and appends
     * {@link com.smartgwt.client.widgets.drawing.Gauge#getLabelSuffix labelSuffix} to
     * <code>value</code>.
     *
     * <p><b>NOTE:</b> If a subclass overrides this, then whenever it changes the way that values are
     * formatted, it should call {@link com.smartgwt.client.widgets.drawing.Gauge#reformatLabelContents Gauge.reformatLabelContents}.
     *
     * @param value the value to format.
     * @return label contents.
     */
    protected native String formatLabelContents(float value) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.__formatLabelContents(value);
    }-*/;

    /**
     * Gets the default fill color for the sector at index <code>sectorIndex</code>.
     * The default implementation cycles through {@link com.smartgwt.client.widgets.drawing.Gauge#getSectorColors sectorColors}
     * using modular arithmetic.
     *
     * @param sectorIndex index of the target sector.
     * @return a fill color.
     */
    protected native String getDefaultFillColor(int sectorIndex) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.__getDefaultFillColor(sectorIndex);
    }-*/;

    public LogicalStructureObject setLogicalStructure(GaugeLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.dialRadius = getAttributeAsString("dialRadius");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.dialRadius:" + t.getMessage() + "\n";
        }
        try {
            s.drawnClockwise = getAttributeAsString("drawnClockwise");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.drawnClockwise:" + t.getMessage() + "\n";
        }
        try {
            s.fontSize = getAttributeAsString("fontSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.fontSize:" + t.getMessage() + "\n";
        }
        try {
            s.labelPrefix = getAttributeAsString("labelPrefix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.labelPrefix:" + t.getMessage() + "\n";
        }
        try {
            s.labelSuffix = getAttributeAsString("labelSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.labelSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.lineWidth = getAttributeAsString("lineWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.lineWidth:" + t.getMessage() + "\n";
        }
        try {
            s.maxValue = getAttributeAsString("maxValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.maxValue:" + t.getMessage() + "\n";
        }
        try {
            s.minValue = getAttributeAsString("minValue");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.minValue:" + t.getMessage() + "\n";
        }
        try {
            s.numMajorTicks = getAttributeAsString("numMajorTicks");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.numMajorTicks:" + t.getMessage() + "\n";
        }
        try {
            s.numMinorTicks = getAttributeAsString("numMinorTicks");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.numMinorTicks:" + t.getMessage() + "\n";
        }
        try {
            s.pivotPoint = getPivotPoint();
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.pivotPoint:" + t.getMessage() + "\n";
        }
        try {
            s.sectorColors = getAttributeAsStringArray("sectorColors");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.sectorColorsArray:" + t.getMessage() + "\n";
        }
        try {
            s.value = getAttributeAsString("value");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Gauge.value:" + t.getMessage() + "\n";
        }
        return s;
    }
    
    public LogicalStructureObject getLogicalStructure() {
        GaugeLogicalStructure s = new GaugeLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

