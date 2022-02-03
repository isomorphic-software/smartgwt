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
/* sgwtgen */
 
package com.smartgwt.client.widgets.drawing;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
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
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.ace.*;
import com.smartgwt.client.widgets.ace.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.tableview.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
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
import com.smartgwt.logicalstructure.widgets.rte.*;
import com.smartgwt.logicalstructure.widgets.ace.*;
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * DrawItem subclass to render a connector between two points. If the points are aligned  on one axis, this connector will
 * draw as a straight line. If the points are offset on  both axes and there is enough space, the connector will by default
 * draw short horizontal   segments from the start and end points, and a diagonal segment connecting the ends of these 
 * 'tail' segments.  Connector style and orientation defaults may be changed through  configuration.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawLinePath")
public class DrawLinePath extends DrawItem {

    public static DrawLinePath getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DrawLinePath(jsObj);
        } else {
            assert refInstance instanceof DrawLinePath;
            return (DrawLinePath)refInstance;
        }
    }
        


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawLinePath.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawLinePath.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.form.fields.FormItem::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawLinePath.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DrawLinePath.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;
    /**
     * Changes the defaults for DrawItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults DrawItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.  For usage tips on this
     * param, see {@link com.smartgwt.client.docs.SGWTProperties}.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, DrawItem defaults) /*-{
        if (defaults.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawLinePath.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "DrawItem");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawLinePath.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public DrawLinePath(){
        scClassName = "DrawLinePath";
    }

    public DrawLinePath(JavaScriptObject jsObj){
        scClassName = "DrawLinePath";
        setJavaScriptObject(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
        var widget = $wnd.isc[scClassName].create(config);
        if ($wnd.isc.keepGlobals) this.@com.smartgwt.client.widgets.BaseWidget::internalSetID(Lcom/google/gwt/core/client/JavaScriptObject;)(widget);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;

    // ********************* Properties / Attributes ***********************

    /**
     * The ConnectorOrientation controlling the orientation and behavior of this line's  tail segments.
     *
     * @param connectorOrientation New connectorOrientation value. Default value is "auto"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setConnectorOrientation(ConnectorOrientation connectorOrientation)  throws IllegalStateException {
        setAttribute("connectorOrientation", connectorOrientation == null ? null : connectorOrientation.getValue(), false);
    }

    /**
     * The ConnectorOrientation controlling the orientation and behavior of this line's  tail segments.
     *
     * @return Current connectorOrientation value. Default value is "auto"
     */
    public ConnectorOrientation getConnectorOrientation()  {
        return EnumUtil.getEnum(ConnectorOrientation.values(), getAttribute("connectorOrientation"));
    }
    

    /**
     * The ConnectorStyle controlling the presentation and behavior of this line's  tail segments.
     *
     * @param connectorStyle New connectorStyle value. Default value is "diagonal"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setConnectorStyle(ConnectorStyle connectorStyle)  throws IllegalStateException {
        setAttribute("connectorStyle", connectorStyle == null ? null : connectorStyle.getValue(), false);
    }

    /**
     * The ConnectorStyle controlling the presentation and behavior of this line's  tail segments.
     *
     * @return Current connectorStyle value. Default value is "diagonal"
     */
    public ConnectorStyle getConnectorStyle()  {
        return EnumUtil.getEnum(ConnectorStyle.values(), getAttribute("connectorStyle"));
    }
    

    /**
     * The point at which the leading tail segment joins the connecting center segment.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the coordinates of the controlPoint1 knob and by extension the coordinates of this DrawLinePath's leading tail segment.
     *
     * @param controlPoint1 left coordinate for start point, in pixels. Default value is null
     */
    public void setControlPoint1(Point controlPoint1) {
        setAttribute("controlPoint1", controlPoint1 == null ? null : controlPoint1.getJsObj(), true);
    }

    /**
     * The point at which the leading tail segment joins the connecting center segment.
     *
     * @return Current controlPoint1 value. Default value is null
     */
    public Point getControlPoint1()  {
        return Point.getOrCreateRef(getAttributeAsJavaScriptObject("controlPoint1"));
    }
    

    /**
     * The point at which the trailing tail segment joins the connecting center segment. Has no effect on lines with right
     * angle ConnectorStyles.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the coordinates of the controlPoint2 knob and by extension the coordinates of this DrawLinePath's trailing tail segment.
     *
     * @param controlPoint2 left coordinate for start point, in pixels. Default value is null
     */
    public void setControlPoint2(Point controlPoint2) {
        setAttribute("controlPoint2", controlPoint2 == null ? null : controlPoint2.getJsObj(), true);
    }

    /**
     * The point at which the trailing tail segment joins the connecting center segment. Has no effect on lines with right
     * angle ConnectorStyles.
     *
     * @return Current controlPoint2 value. Default value is null
     */
    public Point getControlPoint2()  {
        return Point.getOrCreateRef(getAttributeAsJavaScriptObject("controlPoint2"));
    }
    

    /**
     * Style of arrow head to draw at the end of the line or path.
     *
     * @param endArrow New endArrow value. Default value is "open", IRW
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#lines_and_arrowheads" target="examples">Lines & Arrowheads Example</a>
     */
    public void setEndArrow(ArrowStyle endArrow) {
        setAttribute("endArrow", endArrow == null ? null : endArrow.getValue(), true);
    }

    /**
     * Style of arrow head to draw at the end of the line or path.
     *
     * @return Current endArrow value. Default value is "open", IRW
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#lines_and_arrowheads" target="examples">Lines & Arrowheads Example</a>
     */
    public ArrowStyle getEndArrow()  {
        return EnumUtil.getEnum(ArrowStyle.values(), getAttribute("endArrow"));
    }
    

    /**
     * Ending left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getEndPoint endPoint} if both are set.
     *
     * @param endLeft New endLeft value. Default value is 0 , IRW
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEndLeft(int endLeft)  throws IllegalStateException {
        setAttribute("endLeft", endLeft, false);
    }

    /**
     * Ending left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getEndPoint endPoint} if both are set.
     *
     * @return Current endLeft value. Default value is 0 , IRW
     */
    public int getEndLeft()  {
        return (int)Math.round(getAttributeAsDouble("endLeft"));
    }

    /**
     * Ending left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getEndPoint endPoint} if both are set.
     *
     * @return Current endLeft value. Default value is 0 , IRW
     */
    public double getEndLeftAsDouble()  {
        return getAttributeAsDouble("endLeft");
    }
    

    /**
     * End point of the line
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the endPoint
     *
     * @param endPoint left coordinate for end point, in pixels. Default value is [100,100]
     */
    public void setEndPoint(Point endPoint) {
        setAttribute("endPoint", endPoint == null ? null : endPoint.getJsObj(), true);
    }

    /**
     * End point of the line
     *
     * @return Current endPoint value. Default value is [100,100]
     */
    public Point getEndPoint()  {
        return Point.getOrCreateRef(getAttributeAsJavaScriptObject("endPoint"));
    }
    

    /**
     * Ending top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getEndPoint endPoint} if both are set.
     *
     * @param endTop New endTop value. Default value is 0 , IRW
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEndTop(int endTop)  throws IllegalStateException {
        setAttribute("endTop", endTop, false);
    }

    /**
     * Ending top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getEndPoint endPoint} if both are set.
     *
     * @return Current endTop value. Default value is 0 , IRW
     */
    public int getEndTop()  {
        return (int)Math.round(getAttributeAsDouble("endTop"));
    }

    /**
     * Ending top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getEndPoint endPoint} if both are set.
     *
     * @return Current endTop value. Default value is 0 , IRW
     */
    public double getEndTopAsDouble()  {
        return getAttributeAsDouble("endTop");
    }
    

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this will
     * turn on UI element(s) allowing the user to manipulate this DrawLinePath.  To update the set of knobs at runtime use
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs()} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs()}. <p> DrawLinePath supports the  {@link
     * com.smartgwt.client.types.KnobType#STARTPOINT}, {@link com.smartgwt.client.types.KnobType#ENDPOINT}, {@link
     * com.smartgwt.client.types.KnobType#CONTROLPOINT1}, and {@link com.smartgwt.client.types.KnobType#CONTROLPOINT2} knob
     * types.
     *
     * @param knobs New knobs value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setKnobs
     * 
     * 
     */
    public void setKnobs(KnobType... knobs)  throws IllegalStateException {
        setAttribute("knobs", knobs, false);
    }

    /**
     * Array of control knobs to display for this item. Each {@link com.smartgwt.client.types.KnobType} specified in this will
     * turn on UI element(s) allowing the user to manipulate this DrawLinePath.  To update the set of knobs at runtime use
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#showKnobs DrawItem.showKnobs()} and {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#hideKnobs DrawItem.hideKnobs()}. <p> DrawLinePath supports the  {@link
     * com.smartgwt.client.types.KnobType#STARTPOINT}, {@link com.smartgwt.client.types.KnobType#ENDPOINT}, {@link
     * com.smartgwt.client.types.KnobType#CONTROLPOINT1}, and {@link com.smartgwt.client.types.KnobType#CONTROLPOINT2} knob
     * types.
     *
     * @return Current knobs value. Default value is null
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getKnobs
     * 
     * 
     */
    public KnobType[] getKnobs()  {
        final String[] strings = getAttributeAsStringArray("knobs");
        return EnumUtil.getEnums(KnobType.values(), strings, strings == null ? null : new KnobType[strings.length]);
    }
    

    /**
     * If the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} is showing, should the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelBackground titleLabelBackground} be created and placed behind
     * the <code>titleLabel</code>? <p> This defaults to true for {@link com.smartgwt.client.widgets.drawing.DrawSector}s and
     * shapes that are not commonly filled (e.g. {@link com.smartgwt.client.widgets.drawing.DrawLine}s).
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTitleLabelBackground New showTitleLabelBackground value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowTitleLabelBackground(boolean showTitleLabelBackground)  throws IllegalStateException {
        setAttribute("showTitleLabelBackground", showTitleLabelBackground, false);
    }

    /**
     * If the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} is showing, should the {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabelBackground titleLabelBackground} be created and placed behind
     * the <code>titleLabel</code>? <p> This defaults to true for {@link com.smartgwt.client.widgets.drawing.DrawSector}s and
     * shapes that are not commonly filled (e.g. {@link com.smartgwt.client.widgets.drawing.DrawLine}s).
     *
     * @return Current showTitleLabelBackground value. Default value is true
     */
    public boolean getShowTitleLabelBackground()  {
        Boolean result = getAttributeAsBoolean("showTitleLabelBackground");
        return result == null ? true : result;
    }
    

    /**
     * Starting left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getStartPoint startPoint} if both are set.
     *
     * @param startLeft New startLeft value. Default value is 0 , IRW
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStartLeft(int startLeft)  throws IllegalStateException {
        setAttribute("startLeft", startLeft, false);
    }

    /**
     * Starting left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getStartPoint startPoint} if both are set.
     *
     * @return Current startLeft value. Default value is 0 , IRW
     */
    public int getStartLeft()  {
        return (int)Math.round(getAttributeAsDouble("startLeft"));
    }

    /**
     * Starting left coordinate of the line.  Overrides left coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getStartPoint startPoint} if both are set.
     *
     * @return Current startLeft value. Default value is 0 , IRW
     */
    public double getStartLeftAsDouble()  {
        return getAttributeAsDouble("startLeft");
    }
    

    /**
     * Start point of the line
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Update the startPoint
     *
     * @param startPoint left coordinate for start point, in pixels. Default value is [0,0]
     */
    public void setStartPoint(Point startPoint) {
        setAttribute("startPoint", startPoint == null ? null : startPoint.getJsObj(), true);
    }

    /**
     * Start point of the line
     *
     * @return Current startPoint value. Default value is [0,0]
     */
    public Point getStartPoint()  {
        return Point.getOrCreateRef(getAttributeAsJavaScriptObject("startPoint"));
    }
    

    /**
     * Starting top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getStartPoint startPoint} if both are set.
     *
     * @param startTop New startTop value. Default value is 0 , IRW
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStartTop(int startTop)  throws IllegalStateException {
        setAttribute("startTop", startTop, false);
    }

    /**
     * Starting top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getStartPoint startPoint} if both are set.
     *
     * @return Current startTop value. Default value is 0 , IRW
     */
    public int getStartTop()  {
        return (int)Math.round(getAttributeAsDouble("startTop"));
    }

    /**
     * Starting top coordinate of the line.  Overrides top coordinate of {@link
     * com.smartgwt.client.widgets.drawing.DrawLinePath#getStartPoint startPoint} if both are set.
     *
     * @return Current startTop value. Default value is 0 , IRW
     */
    public double getStartTopAsDouble()  {
        return getAttributeAsDouble("startTop");
    }
    

    /**
     * Length of the horizontal/vertical "tail segments" between the start and end points of  this DrawLinePath and the
     * connecting center segment.
     *
     * @param tailSize New tailSize value. Default value is 30
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTailSize(int tailSize)  throws IllegalStateException {
        setAttribute("tailSize", tailSize, false);
    }

    /**
     * Length of the horizontal/vertical "tail segments" between the start and end points of  this DrawLinePath and the
     * connecting center segment.
     *
     * @return Current tailSize value. Default value is 30
     */
    public int getTailSize()  {
        return (int)Math.round(getAttributeAsDouble("tailSize"));
    }

    /**
     * Length of the horizontal/vertical "tail segments" between the start and end points of  this DrawLinePath and the
     * connecting center segment.
     *
     * @return Current tailSize value. Default value is 30
     */
    public double getTailSizeAsDouble()  {
        return getAttributeAsDouble("tailSize");
    }
    

    /**
     * The mode in which the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} (if shown) is
     * rotated with this draw item.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param titleRotationMode New titleRotationMode value. Default value is "withLineAlwaysUp"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawItem#setTitle
     * 
     */
    public void setTitleRotationMode(TitleRotationMode titleRotationMode)  throws IllegalStateException {
        setAttribute("titleRotationMode", titleRotationMode == null ? null : titleRotationMode.getValue(), false);
    }

    /**
     * The mode in which the {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel} (if shown) is
     * rotated with this draw item.
     *
     * @return Current titleRotationMode value. Default value is "withLineAlwaysUp"
     * @see com.smartgwt.client.widgets.drawing.DrawItem#getTitle
     * 
     */
    public TitleRotationMode getTitleRotationMode()  {
        return EnumUtil.getEnum(TitleRotationMode.values(), getAttribute("titleRotationMode"));
    }
    

    // ********************* Methods ***********************
	/**
     * Get the center point of the line path.
     *
     * @return the center point
     */
    public native Point getCenter() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getCenter", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getCenter();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.drawing.Point::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Move both the start and end points of the line by a relative amount.
     * @param left change to left coordinate in pixels
     * @param top change to top coordinate in pixels
     */
    public native void moveBy(int left, int top) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveBy", "int,int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveBy(left, top);
    }-*/;

	/**
     * Moves the line path such that the {@link com.smartgwt.client.widgets.drawing.DrawLinePath#getStartPoint startPoint} ends
     * up at the specified point.
     * @param left new left coordinate in pixels
     * @param top new top coordinate in pixels
     */
    public native void moveStartPointTo(Integer left, Integer top) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "moveStartPointTo", "Integer,Integer");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.moveStartPointTo(left == null ? null : left.@java.lang.Integer::intValue()(), top == null ? null : top.@java.lang.Integer::intValue()());
    }-*/;


    // ********************* Static Methods ***********************

    /** 
     * Class level method to set the default properties of this class.  If set, then all
     * existing and subsequently created instances of this class will automatically have
     * default properties corresponding to
     * the properties set on the SmartGWT class instance passed to this function before its
     * underlying SmartClient JS object was created.
     * This is a powerful feature that eliminates the need for users to create a separate
     * hierarchy of subclasses that only alter the default properties of this class. Can also
     * be used for skinning / styling purposes.  <P> <b>Note:</b> This method is intended for
     * setting default attributes only and will affect all instances of the underlying class
     * (including those automatically generated in JavaScript).  This method should not be used
     * to apply standard EventHandlers or override methods for a class - use a custom subclass
     * instead.  Calling this method after instances have been created can result in undefined
     * behavior, since it bypasses any setters and a class instance may have already examined 
     * a particular property and not be expecting any changes through this route.
     *
     * @param drawLinePathProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DrawLinePath drawLinePathProperties) /*-{
        if (drawLinePathProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DrawLinePath.@java.lang.Object::getClass()(), "setDefaultProperties", drawLinePathProperties.@java.lang.Object::getClass()());
        }
        drawLinePathProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = drawLinePathProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.DrawLinePath.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DrawLinePathLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.connectorOrientation = getAttributeAsString("connectorOrientation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.connectorOrientation:" + t.getMessage() + "\n";
        }
        try {
            s.connectorStyle = getAttributeAsString("connectorStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.connectorStyle:" + t.getMessage() + "\n";
        }
        try {
            s.controlPoint1 = getControlPoint1();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.controlPoint1:" + t.getMessage() + "\n";
        }
        try {
            s.controlPoint2 = getControlPoint2();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.controlPoint2:" + t.getMessage() + "\n";
        }
        try {
            s.endArrow = getAttributeAsString("endArrow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.endArrow:" + t.getMessage() + "\n";
        }
        try {
            s.endLeft = getAttributeAsString("endLeft");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.endLeft:" + t.getMessage() + "\n";
        }
        try {
            s.endPoint = getEndPoint();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.endPoint:" + t.getMessage() + "\n";
        }
        try {
            s.endTop = getAttributeAsString("endTop");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.endTop:" + t.getMessage() + "\n";
        }
        try {
            s.knobs = getAttributeAsStringArray("knobs");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.knobsArray:" + t.getMessage() + "\n";
        }
        try {
            s.showTitleLabelBackground = getAttributeAsString("showTitleLabelBackground");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.showTitleLabelBackground:" + t.getMessage() + "\n";
        }
        try {
            s.startLeft = getAttributeAsString("startLeft");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.startLeft:" + t.getMessage() + "\n";
        }
        try {
            s.startPoint = getStartPoint();
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.startPoint:" + t.getMessage() + "\n";
        }
        try {
            s.startTop = getAttributeAsString("startTop");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.startTop:" + t.getMessage() + "\n";
        }
        try {
            s.tailSize = getAttributeAsString("tailSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.tailSize:" + t.getMessage() + "\n";
        }
        try {
            s.titleRotationMode = getAttributeAsString("titleRotationMode");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLinePath.titleRotationMode:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DrawLinePathLogicalStructure s = new DrawLinePathLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
