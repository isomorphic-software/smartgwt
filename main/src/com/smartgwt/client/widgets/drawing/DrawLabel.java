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
 * DrawItem subclass to render a single-line text label.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DrawLabel")
public class DrawLabel extends DrawItem {

    public static DrawLabel getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DrawLabel(jsObj);
        } else {
            assert refInstance instanceof DrawLabel;
            return (DrawLabel)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawLabel.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawLabel.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawLabel.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DrawLabel.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DrawLabel.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "DrawItem");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DrawLabel.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public DrawLabel(){
        scClassName = "DrawLabel";
    }

    public DrawLabel(JavaScriptObject jsObj){
        scClassName = "DrawLabel";
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
     * Sets the text alignment from the x position. Similar to HTML5 context.textAlign with alignment values such as "start",
     * "center", and "end". <P> Note that this setting is ignored for {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel DrawItem.titleLabel} autochildren, which are always
     * considered to have "start" alignment to make handling of {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleRotationMode DrawItem.titleRotationMode} simpler.
     *
     * @param alignment New alignment value. Default value is DrawLabel.START
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAlignment(LabelAlignment alignment)  throws IllegalStateException {
        setAttribute("alignment", alignment == null ? null : alignment.getValue(), false);
    }

    /**
     * Sets the text alignment from the x position. Similar to HTML5 context.textAlign with alignment values such as "start",
     * "center", and "end". <P> Note that this setting is ignored for {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel DrawItem.titleLabel} autochildren, which are always
     * considered to have "start" alignment to make handling of {@link
     * com.smartgwt.client.widgets.drawing.DrawItem#getTitleRotationMode DrawItem.titleRotationMode} simpler.
     *
     * @return Current alignment value. Default value is DrawLabel.START
     */
    public LabelAlignment getAlignment()  {
        return EnumUtil.getEnum(LabelAlignment.values(), getAttribute("alignment"));
    }
    

    /**
     * This is the content that will exist as the label.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets this DrawLabel's {@link com.smartgwt.client.widgets.drawing.DrawLabel#getContents contents}.
     *
     * @param contents the new contents. Default value is null
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#setEscapeContents
     */
    public void setContents(String contents) {
        setAttribute("contents", contents, true);
    }

    /**
     * This is the content that will exist as the label.
     *
     * @return Current contents value. Default value is null
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#getEscapeContents
     */
    public String getContents()  {
        return getAttributeAsString("contents");
    }
    

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @param editProxyConstructor New editProxyConstructor value. Default value is "DrawLabelEditProxy"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public void setEditProxyConstructor(String editProxyConstructor)  throws IllegalStateException {
        setAttribute("editProxyConstructor", editProxyConstructor, false);
    }

    /**
     * Default class used to construct the {@link com.smartgwt.client.tools.EditProxy} for this component when the component is
     * {@link com.smartgwt.client.widgets.Canvas#setEditMode first placed into edit mode}.
     *
     * @return Current editProxyConstructor value. Default value is "DrawLabelEditProxy"
     * @see com.smartgwt.client.docs.SCClassName SCClassName 
     */
    public String getEditProxyConstructor()  {
        return getAttributeAsString("editProxyConstructor");
    }
    

    /**
     * For {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType SVG-based} {@link
     * com.smartgwt.client.widgets.drawing.DrawPane}s, whether to escape the specified
     * {@link com.smartgwt.client.widgets.drawing.DrawLabel#getContents contents} of this label so that any markup syntax is
     * rendered "as is," without being
     *  interpreted as SVG.  This setting should not be customized when working with other 
     * {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType drawingType}s, as the {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getContents contents} are always escaped in such
     *  case.
     *  <P>
     * In SVG, a {@link com.smartgwt.client.widgets.drawing.DrawLabel}'s {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getContents contents} are rendered inside a <code>&lt;text&gt;</code>
     * tag, so any SVG that's legal inside that tag can be set as the {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getContents contents} when 
     *  {@link com.smartgwt.client.widgets.drawing.DrawLabel#getEscapeContents escapeContents} is false.  See 
     * <a href='https://developer.mozilla.org/en-US/docs/Web/SVG/Element/text' target='_blank'>Mozilla SVG Developer
     * Reference</a>
     *  for more information about what exactly is supported.
     *  <P>
     *  Note that the Framework will not be able to determine the width or height of a 
     * {@link com.smartgwt.client.widgets.drawing.DrawLabel} when this property is false, so the Framework will consider both
     * dimensions
     * to be zero, and centering will not work (e.g. for {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel
     * DrawItem.titleLabel} autochildren).
     * For top-level {@link com.smartgwt.client.widgets.drawing.DrawLabel}s, you may be able to get the DOM to center your
     * content by
     * setting {@link com.smartgwt.client.widgets.drawing.DrawLabel#getAlignment alignment} as "center" - the DOM will then
     * interpret the
     * {@link com.smartgwt.client.widgets.drawing.DrawLabel#getLeft left}, {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getTop top} coordinates of the label as its centerpoint even though our
     * Framework
     *  doesn't know the label's actual size.
     *  <P>
     * For a {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel}, the {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getAlignment alignment} setting
     *  is ignored, as the Framework always positions it using "start" alignment, but SVG code such
     *  as the following demonstrates that centering is possible (via the "style" setting):<pre>
     *  &lt;tspan text-decoration='underline' font-size='20px' 
     *         style='dominant-baseline:central; text-anchor:middle;'&gt;MyLabel
     *  &lt;/tspan&gt;
     *  </pre>
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the {@link com.smartgwt.client.widgets.drawing.DrawLabel#getEscapeContents escapeContents} property for this DrawLabel.
     *
     * @param escapeContents whether to escape {@link com.smartgwt.client.widgets.drawing.DrawLabel#getContents contents}. Default value is true
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#setContents
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#setAlignment
     */
    public void setEscapeContents(boolean escapeContents) {
        setAttribute("escapeContents", escapeContents, true);
    }

    /**
     * For {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType SVG-based} {@link
     * com.smartgwt.client.widgets.drawing.DrawPane}s, whether to escape the specified
     * {@link com.smartgwt.client.widgets.drawing.DrawLabel#getContents contents} of this label so that any markup syntax is
     * rendered "as is," without being
     *  interpreted as SVG.  This setting should not be customized when working with other 
     * {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType drawingType}s, as the {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getContents contents} are always escaped in such
     *  case.
     *  <P>
     * In SVG, a {@link com.smartgwt.client.widgets.drawing.DrawLabel}'s {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getContents contents} are rendered inside a <code>&lt;text&gt;</code>
     * tag, so any SVG that's legal inside that tag can be set as the {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getContents contents} when 
     *  {@link com.smartgwt.client.widgets.drawing.DrawLabel#getEscapeContents escapeContents} is false.  See 
     * <a href='https://developer.mozilla.org/en-US/docs/Web/SVG/Element/text' target='_blank'>Mozilla SVG Developer
     * Reference</a>
     *  for more information about what exactly is supported.
     *  <P>
     *  Note that the Framework will not be able to determine the width or height of a 
     * {@link com.smartgwt.client.widgets.drawing.DrawLabel} when this property is false, so the Framework will consider both
     * dimensions
     * to be zero, and centering will not work (e.g. for {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel
     * DrawItem.titleLabel} autochildren).
     * For top-level {@link com.smartgwt.client.widgets.drawing.DrawLabel}s, you may be able to get the DOM to center your
     * content by
     * setting {@link com.smartgwt.client.widgets.drawing.DrawLabel#getAlignment alignment} as "center" - the DOM will then
     * interpret the
     * {@link com.smartgwt.client.widgets.drawing.DrawLabel#getLeft left}, {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getTop top} coordinates of the label as its centerpoint even though our
     * Framework
     *  doesn't know the label's actual size.
     *  <P>
     * For a {@link com.smartgwt.client.widgets.drawing.DrawItem#getTitleLabel titleLabel}, the {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getAlignment alignment} setting
     *  is ignored, as the Framework always positions it using "start" alignment, but SVG code such
     *  as the following demonstrates that centering is possible (via the "style" setting):<pre>
     *  &lt;tspan text-decoration='underline' font-size='20px' 
     *         style='dominant-baseline:central; text-anchor:middle;'&gt;MyLabel
     *  &lt;/tspan&gt;
     *  </pre>
     *
     * @return Current escapeContents value. Default value is true
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#getContents
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#getAlignment
     */
    public boolean getEscapeContents()  {
        Boolean result = getAttributeAsBoolean("escapeContents");
        return result == null ? true : result;
    }
    

    /**
     * Font family name, similar to the CSS font-family attribute.
     *
     * @param fontFamily New fontFamily value. Default value is "Tahoma"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#setStyleName
     */
    public void setFontFamily(String fontFamily)  throws IllegalStateException {
        setAttribute("fontFamily", fontFamily, false);
    }

    /**
     * Font family name, similar to the CSS font-family attribute.
     *
     * @return Current fontFamily value. Default value is "Tahoma"
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#getStyleName
     */
    public String getFontFamily()  {
        return getAttributeAsString("fontFamily");
    }
    

    /**
     * Font size in pixels, similar to the CSS font-size attribute.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets this DrawLabel's {@link com.smartgwt.client.widgets.drawing.DrawLabel#getFontSize fontSize}.
     *
     * @param fontSize the new font size in pixels. Default value is 18
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#setStyleName
     */
    public void setFontSize(int fontSize) {
        setAttribute("fontSize", fontSize, true);
    }

    /**
     * Font size in pixels, similar to the CSS font-size attribute.
     *
     * @return Current fontSize value. Default value is 18
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#getStyleName
     */
    public int getFontSize()  {
        return getAttributeAsInt("fontSize");
    }
    

    /**
     * Font style, similar to the CSS font-style attribute, eg "normal", "italic".
     *
     * @param fontStyle New fontStyle value. Default value is "normal"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#setStyleName
     */
    public void setFontStyle(String fontStyle)  throws IllegalStateException {
        setAttribute("fontStyle", fontStyle, false);
    }

    /**
     * Font style, similar to the CSS font-style attribute, eg "normal", "italic".
     *
     * @return Current fontStyle value. Default value is "normal"
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#getStyleName
     */
    public String getFontStyle()  {
        return getAttributeAsString("fontStyle");
    }
    

    /**
     * Font weight, similar to the CSS font-weight attribute, eg "normal", "bold".
     *
     * @param fontWeight New fontWeight value. Default value is "bold"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#setStyleName
     */
    public void setFontWeight(String fontWeight)  throws IllegalStateException {
        setAttribute("fontWeight", fontWeight, false);
    }

    /**
     * Font weight, similar to the CSS font-weight attribute, eg "normal", "bold".
     *
     * @return Current fontWeight value. Default value is "bold"
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#getStyleName
     */
    public String getFontWeight()  {
        return getAttributeAsString("fontWeight");
    }
    

    /**
     * DrawLabel only supports the  {@link com.smartgwt.client.types.KnobType#MOVE} knob type.
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
     * DrawLabel only supports the  {@link com.smartgwt.client.types.KnobType#MOVE} knob type.
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
     * Sets the amount from the left of its positioning that the element should be placed.
     *
     * @param left New left value. Default value is 0
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setLeft(int left)  throws IllegalStateException {
        setAttribute("left", left, false);
    }

    /**
     * Sets the amount from the left of its positioning that the element should be placed.
     *
     * @return Current left value. Default value is 0
     */
    public int getLeft()  {
        return (int)Math.round(getAttributeAsDouble("left"));
    }

    /**
     * Sets the amount from the left of its positioning that the element should be placed.
     *
     * @return Current left value. Default value is 0
     */
    public double getLeftAsDouble()  {
        return getAttributeAsDouble("left");
    }
    

    /**
     * The text color of the label.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the text color of the label.
     *
     * @param lineColor new text color. Default value is "#808080"
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public void setLineColor(String lineColor) {
        setAttribute("lineColor", lineColor, true);
    }

    /**
     * The text color of the label.
     *
     * @return Current lineColor value. Default value is "#808080"
     * @see com.smartgwt.client.docs.CSSColor CSSColor 
     */
    public String getLineColor()  {
        return getAttributeAsString("lineColor");
    }
    

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawLabel#getTop top} {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getLeft left} corner.  The positive direction is clockwise.
     *
     * @param rotation New rotation value. Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public void setRotation(float rotation)  throws IllegalStateException {
        setAttribute("rotation", rotation, false);
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawLabel#getTop top} {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getLeft left} corner.  The positive direction is clockwise.
     *
     * @return Current rotation value. Default value is 0.0
     * @deprecated  {@link com.smartgwt.client.docs.GwtFloatVsDouble GwtFloatVsDouble}
     */
    public float getRotation()  {
        return getAttributeAsFloat("rotation");
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawLabel#getTop top} {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getLeft left} corner.  The positive direction is clockwise.
     *
     * @param rotation New rotation value. Default value is 0.0
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setRotation(double rotation)  throws IllegalStateException {
        setAttribute("rotation", rotation, false);
    }

    /**
     * Rotation in degrees about the {@link com.smartgwt.client.widgets.drawing.DrawLabel#getTop top} {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getLeft left} corner.  The positive direction is clockwise.
     *
     * @return Current rotation value. Default value is 0.0
     */
    public double getRotationAsDouble()  {
        return getAttributeAsDouble("rotation");
    }
    

    /**
     * For {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType drawingType} "svg" only, the CSS class applied to
     * this label. Similar to {@link com.smartgwt.client.widgets.Canvas#getStyleName Canvas.styleName}.  The font properties
     * {@link com.smartgwt.client.widgets.drawing.DrawLabel#getFontSize fontSize}, {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getFontWeight fontWeight}, {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getFontStyle fontStyle}, and {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getFontFamily fontFamily}, unless set to null, take priority over any CSS
     * settings.  This property can be used in combination with {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getEscapeContents escapeContents} if needed. but note that in SVG, the
     * precedence of CSS and inline styling applied to an element works differently that it does in HTML.  See <a
     * href='https://developer.mozilla.org/en-US/docs/Web/SVG/Element/text' target='_blank'>Mozilla SVG Developer Reference</a>
     * <P> Note that only font sizes defined in pixels are supported through this property.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets this DrawLabel's {@link com.smartgwt.client.widgets.drawing.DrawLabel#getStyleName styleName}.
     *
     * @param styleName the new styleName. Default value is "normal"
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#setEscapeContents
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setStyleName(String styleName) {
        setAttribute("styleName", styleName, true);
    }

    /**
     * For {@link com.smartgwt.client.widgets.drawing.DrawPane#getDrawingType drawingType} "svg" only, the CSS class applied to
     * this label. Similar to {@link com.smartgwt.client.widgets.Canvas#getStyleName Canvas.styleName}.  The font properties
     * {@link com.smartgwt.client.widgets.drawing.DrawLabel#getFontSize fontSize}, {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getFontWeight fontWeight}, {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getFontStyle fontStyle}, and {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getFontFamily fontFamily}, unless set to null, take priority over any CSS
     * settings.  This property can be used in combination with {@link
     * com.smartgwt.client.widgets.drawing.DrawLabel#getEscapeContents escapeContents} if needed. but note that in SVG, the
     * precedence of CSS and inline styling applied to an element works differently that it does in HTML.  See <a
     * href='https://developer.mozilla.org/en-US/docs/Web/SVG/Element/text' target='_blank'>Mozilla SVG Developer Reference</a>
     * <P> Note that only font sizes defined in pixels are supported through this property.
     *
     * @return Current styleName value. Default value is "normal"
     * @see com.smartgwt.client.widgets.drawing.DrawLabel#getEscapeContents
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * Sets the amount from the top of its positioning that the element should be placed.
     *
     * @param top New top value. Default value is 0
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTop(int top)  throws IllegalStateException {
        setAttribute("top", top, false);
    }

    /**
     * Sets the amount from the top of its positioning that the element should be placed.
     *
     * @return Current top value. Default value is 0
     */
    public int getTop()  {
        return (int)Math.round(getAttributeAsDouble("top"));
    }

    /**
     * Sets the amount from the top of its positioning that the element should be placed.
     *
     * @return Current top value. Default value is 0
     */
    public double getTopAsDouble()  {
        return getAttributeAsDouble("top");
    }
    

    // ********************* Methods ***********************
	/**
     * Get the center point of the label.
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
     * @param drawLabelProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DrawLabel drawLabelProperties) /*-{
        if (drawLabelProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DrawLabel.@java.lang.Object::getClass()(), "setDefaultProperties", drawLabelProperties.@java.lang.Object::getClass()());
        }
        drawLabelProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = drawLabelProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.DrawLabel.addProperties(properties);
    }-*/;

    // ***********************************************************



    /**
     * See {@link #setAlignment(LabelAlignment)}.
     *
     * @param alignment  Default value is "start"
     * @throws IllegalStateException  Thrown upon attempt to change after component creation.
     * 
     * @deprecated Use the method which takes a LabelAlignment.
     */
    public void setAlignment(String alignment)  throws IllegalStateException {
        LabelAlignment alignType = LabelAlignment.START;

        // attempt to resolve the alignment string into a LabelAlignment
        if (alignment != null) try {
            alignType = LabelAlignment.valueOf(alignment.toUpperCase());
        } catch (IllegalArgumentException e) {
            SC.logWarn("DrawLabel::setAlignment(): Ignoring unrecognized alignment '" + 
                       alignment + "'");
            return;
        }
        setAlignment(alignment == null ? null : alignType);
    }


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DrawLabelLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.alignment = getAttributeAsString("alignment");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.alignment:" + t.getMessage() + "\n";
        }
        try {
            s.contents = getAttributeAsString("contents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.contents:" + t.getMessage() + "\n";
        }
        try {
            s.editProxyConstructor = getAttributeAsString("editProxyConstructor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.editProxyConstructor:" + t.getMessage() + "\n";
        }
        try {
            s.escapeContents = getAttributeAsString("escapeContents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.escapeContents:" + t.getMessage() + "\n";
        }
        try {
            s.fontFamily = getAttributeAsString("fontFamily");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.fontFamily:" + t.getMessage() + "\n";
        }
        try {
            s.fontSize = getAttributeAsString("fontSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.fontSize:" + t.getMessage() + "\n";
        }
        try {
            s.fontStyle = getAttributeAsString("fontStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.fontStyle:" + t.getMessage() + "\n";
        }
        try {
            s.fontWeight = getAttributeAsString("fontWeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.fontWeight:" + t.getMessage() + "\n";
        }
        try {
            s.knobs = getAttributeAsStringArray("knobs");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.knobsArray:" + t.getMessage() + "\n";
        }
        try {
            s.left = getAttributeAsString("left");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.left:" + t.getMessage() + "\n";
        }
        try {
            s.lineColor = getAttributeAsString("lineColor");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.lineColor:" + t.getMessage() + "\n";
        }
        try {
            s.rotation = getAttributeAsString("rotation");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.rotation:" + t.getMessage() + "\n";
        }
        try {
            s.styleName = getAttributeAsString("styleName");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.styleName:" + t.getMessage() + "\n";
        }
        try {
            s.top = getAttributeAsString("top");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DrawLabel.top:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DrawLabelLogicalStructure s = new DrawLabelLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
