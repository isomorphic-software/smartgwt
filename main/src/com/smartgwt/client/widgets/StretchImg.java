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
 
package com.smartgwt.client.widgets;


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
 * The StretchImg widget class implements a widget type that displays a list of multiple images  that make up a single
 * image.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("StretchImg")
public class StretchImg extends StatefulCanvas {

    public static StretchImg getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new StretchImg(jsObj);
        } else {
            assert refInstance instanceof StretchImg;
            return (StretchImg)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(StretchImg.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.StretchImg.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(StretchImg.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.StretchImg.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public StretchImg(){
        scClassName = "StretchImg";
    }

    public StretchImg(JavaScriptObject jsObj){
        scClassName = "StretchImg";
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
     * If the default items are used, capSize is the size in pixels of the first and last          images in this stretchImg.
     *
     * @param capSize New capSize value. Default value is 2
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setCapSize(int capSize) {
        setAttribute("capSize", capSize, true);
    }

    /**
     * If the default items are used, capSize is the size in pixels of the first and last          images in this stretchImg.
     *
     * @return Current capSize value. Default value is 2
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getCapSize()  {
        return getAttributeAsInt("capSize");
    }
    

    /**
     * Suffix used the 'grip' image if {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param gripImgSuffix New gripImgSuffix value. Default value is "grip"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGripImgSuffix(String gripImgSuffix)  throws IllegalStateException {
        setAttribute("gripImgSuffix", gripImgSuffix, false);
    }

    /**
     * Suffix used the 'grip' image if {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true.
     *
     * @return Current gripImgSuffix value. Default value is "grip"
     */
    public String getGripImgSuffix()  {
        return getAttributeAsString("gripImgSuffix");
    }
    

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is false and  {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} is unset.
     *
     * @param hSrc New hSrc value. Default value is null
     * @see com.smartgwt.client.widgets.StretchImg#setSrc
     * @see com.smartgwt.client.widgets.StretchImg#setVSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setHSrc(String hSrc) {
        setAttribute("hSrc", hSrc, true);
    }

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is false and  {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} is unset.
     *
     * @return Current hSrc value. Default value is null
     * @see com.smartgwt.client.widgets.StretchImg#getSrc
     * @see com.smartgwt.client.widgets.StretchImg#getVSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getHSrc()  {
        return getAttributeAsString("hSrc");
    }
    

    /**
     * Should the {@link com.smartgwt.client.widgets.StretchImg#getItems items} for this StretchImg display left-to-right even
     * if this page is displaying {@link com.smartgwt.client.util.Page#isRTL right to left text}? <P> Only has an effect if
     * this StretchImg is horizontal ({@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is set to false). <P>
     * Having this property set to true is usually desirable for the common pattern of media consisting of fixed size "end
     * caps" and a stretchable center, because it allows the same media to be used for LTR and RTL pages. <P> If set to false,
     * items will be displayed in RTL order for RTL pages.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.StretchImg#getIgnoreRTL ignoreRTL}.
     *
     * @param ignoreRTL new value for ignoreRTL. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setIgnoreRTL(boolean ignoreRTL) {
        setAttribute("ignoreRTL", ignoreRTL, true);
    }

    /**
     * Should the {@link com.smartgwt.client.widgets.StretchImg#getItems items} for this StretchImg display left-to-right even
     * if this page is displaying {@link com.smartgwt.client.util.Page#isRTL right to left text}? <P> Only has an effect if
     * this StretchImg is horizontal ({@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is set to false). <P>
     * Having this property set to true is usually desirable for the common pattern of media consisting of fixed size "end
     * caps" and a stretchable center, because it allows the same media to be used for LTR and RTL pages. <P> If set to false,
     * items will be displayed in RTL order for RTL pages.
     *
     * @return Current ignoreRTL value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public boolean getIgnoreRTL()  {
        Boolean result = getAttributeAsBoolean("ignoreRTL");
        return result == null ? true : result;
    }
    

    /**
     * Indicates whether the image should be tiled/cropped, stretched, or centered when the          size of this widget does
     * not match the size of the image. See ImageStyle for          details.
     *
     * @param imageType New imageType value. Default value is Img.STRETCH
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setImageType(ImageStyle imageType) {
        setAttribute("imageType", imageType == null ? null : imageType.getValue(), true);
    }

    /**
     * Indicates whether the image should be tiled/cropped, stretched, or centered when the          size of this widget does
     * not match the size of the image. See ImageStyle for          details.
     *
     * @return Current imageType value. Default value is Img.STRETCH
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public ImageStyle getImageType()  {
        return EnumUtil.getEnum(ImageStyle.values(), getAttribute("imageType"));
    }
    

    /**
     * If specified this css class will be applied to the individual item images within this StretchImg. May be overridden by
     * specifying item-specific base styles to each object in the {@link com.smartgwt.client.widgets.StretchImg#getItems items
     * array}. This base style will have standard stateful suffixes appended to indicate the state of this component (as
     * described in  {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle StatefulCanvas.baseStyle}).
     *
     * @param itemBaseStyle New itemBaseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setItemBaseStyle(String itemBaseStyle) {
        setAttribute("itemBaseStyle", itemBaseStyle, true);
    }

    /**
     * If specified this css class will be applied to the individual item images within this StretchImg. May be overridden by
     * specifying item-specific base styles to each object in the {@link com.smartgwt.client.widgets.StretchImg#getItems items
     * array}. This base style will have standard stateful suffixes appended to indicate the state of this component (as
     * described in  {@link com.smartgwt.client.widgets.StatefulCanvas#getBaseStyle StatefulCanvas.baseStyle}).
     *
     * @return Current itemBaseStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getItemBaseStyle()  {
        return getAttributeAsString("itemBaseStyle");
    }
    

    /**
     * The list of images to display as an array of objects specifying the image names and
     *  sizes.
     *  <P>
     * The {@link com.smartgwt.client.widgets.StretchItem#getName name} is appended as a suffix to the {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} URL in order
     *  to fetch separate media files for each image. Alternatively a StretchItem may specify
     *  its own {@link com.smartgwt.client.widgets.StretchItem#getSrc src}.
     *  <P>
     * The {@link com.smartgwt.client.widgets.StretchItem#getHeight height} and {@link
     * com.smartgwt.client.widgets.StretchItem#getWidth width} can be set to a number,
     *  "*" (remaining space, divided amongst all images that specify "*") or to the name of a
     * property on this StretchImg component, such as "capSize" for the {@link
     * com.smartgwt.client.widgets.StretchImg#getCapSize capSize}.
     *  <P>
     *  Height or width is only used for the axis along which images are stacked.  For example, if
     * {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is true, images stack vertically and heights are
     * used to size images on
     *  the vertical axis, but all images will have width matching the overall component size.
     *  <P>
     *  For example, the default setting for <code>items</code>, which is used to produce
     *  stretchable buttons and headers with fixed-size endcaps, is as follows:
     *  <pre>
     *    new StretchItem[] {
     *        new StretchItem("start", "capSize", "capSize"),
     *        new StretchItem("stretch", "*", "*"),
     *        new StretchItem("end", "capSize", "capSize")
     *    };
     *  </pre>
     *  Note that by default horizontal StretchImg instances will always render their items
     *  in left-to-right order, even if the page is localized for right-to-left display
     *  (see {@link com.smartgwt.client.util.Page#isRTL Page.isRTL()}). This default behavior may be overridden by setting the
     *  {@link com.smartgwt.client.widgets.StretchImg#getIgnoreRTL ignoreRTL} flag to false.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Setter for {@link com.smartgwt.client.widgets.StretchImg#getItems items}.
     *
     * @param items the new array of items. Default value is see below
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setItems(StretchItem... items) {
        setAttribute("items", items, true);
    }

    /**
     * The list of images to display as an array of objects specifying the image names and
     *  sizes.
     *  <P>
     * The {@link com.smartgwt.client.widgets.StretchItem#getName name} is appended as a suffix to the {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} URL in order
     *  to fetch separate media files for each image. Alternatively a StretchItem may specify
     *  its own {@link com.smartgwt.client.widgets.StretchItem#getSrc src}.
     *  <P>
     * The {@link com.smartgwt.client.widgets.StretchItem#getHeight height} and {@link
     * com.smartgwt.client.widgets.StretchItem#getWidth width} can be set to a number,
     *  "*" (remaining space, divided amongst all images that specify "*") or to the name of a
     * property on this StretchImg component, such as "capSize" for the {@link
     * com.smartgwt.client.widgets.StretchImg#getCapSize capSize}.
     *  <P>
     *  Height or width is only used for the axis along which images are stacked.  For example, if
     * {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is true, images stack vertically and heights are
     * used to size images on
     *  the vertical axis, but all images will have width matching the overall component size.
     *  <P>
     *  For example, the default setting for <code>items</code>, which is used to produce
     *  stretchable buttons and headers with fixed-size endcaps, is as follows:
     *  <pre>
     *    new StretchItem[] {
     *        new StretchItem("start", "capSize", "capSize"),
     *        new StretchItem("stretch", "*", "*"),
     *        new StretchItem("end", "capSize", "capSize")
     *    };
     *  </pre>
     *  Note that by default horizontal StretchImg instances will always render their items
     *  in left-to-right order, even if the page is localized for right-to-left display
     *  (see {@link com.smartgwt.client.util.Page#isRTL Page.isRTL()}). This default behavior may be overridden by setting the
     *  {@link com.smartgwt.client.widgets.StretchImg#getIgnoreRTL ignoreRTL} flag to false.
     *
     * @return Current items value. Default value is see below
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public StretchItem[] getItems()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfStretchItem(getAttributeAsJavaScriptObject("items"));
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Down' state on the grip image when the user mousedown's on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown StatefulCanvas.showDown} is false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showDownGrip New showDownGrip value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDownGrip(Boolean showDownGrip)  throws IllegalStateException {
        setAttribute("showDownGrip", showDownGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Down' state on the grip image when the user mousedown's on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown StatefulCanvas.showDown} is false.
     *
     * @return Current showDownGrip value. Default value is null
     */
    public Boolean getShowDownGrip()  {
        return getAttributeAsBoolean("showDownGrip");
    }
    

    /**
     * Should we show a "grip" image floating above the center of this widget?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showGrip New showGrip value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowGrip(Boolean showGrip)  throws IllegalStateException {
        setAttribute("showGrip", showGrip, false);
    }

    /**
     * Should we show a "grip" image floating above the center of this widget?
     *
     * @return Current showGrip value. Default value is null
     */
    public Boolean getShowGrip()  {
        return getAttributeAsBoolean("showGrip");
    }
    

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Over' state on the grip image when the user rolls over on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver StatefulCanvas.showRollOver} is false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showRollOverGrip New showRollOverGrip value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowRollOverGrip(Boolean showRollOverGrip)  throws IllegalStateException {
        setAttribute("showRollOverGrip", showRollOverGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.StretchImg#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Over' state on the grip image when the user rolls over on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver StatefulCanvas.showRollOver} is false.
     *
     * @return Current showRollOverGrip value. Default value is null
     */
    public Boolean getShowRollOverGrip()  {
        return getAttributeAsBoolean("showRollOverGrip");
    }
    

    /**
     * Determines whether any specified {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title} will be  displayed
     * for this component.<br> Applies to Image-based components only, where the title will be rendered out in a label floating
     * over the component
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showTitle New showTitle value. Default value is false
     */
    public void setShowTitle(Boolean showTitle) {
        setAttribute("showTitle", showTitle, true);
    }

    /**
     * Determines whether any specified {@link com.smartgwt.client.widgets.StatefulCanvas#getTitle title} will be  displayed
     * for this component.<br> Applies to Image-based components only, where the title will be rendered out in a label floating
     * over the component
     *
     * @return Current showTitle value. Default value is false
     */
    public Boolean getShowTitle()  {
        Boolean result = getAttributeAsBoolean("showTitle");
        return result == null ? false : result;
    }
    

    /**
     * The base URL for the image.  <P> The {@link com.smartgwt.client.types.State} for the component will be combined with
     * this URL using the same approach as described in {@link com.smartgwt.client.widgets.Img#getSrc Img.src}. Then the image
     * segment {@link com.smartgwt.client.widgets.StretchItem#getName name} as specified by each {@link
     * com.smartgwt.client.widgets.StretchItem} is added. <P> For example, for a stretchImg in "Over" state with a
     * <code>src</code> of "button.png" and a segment name of "stretch", the resulting URL would be "button_Over_stretch.png".
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Changes the base {@link com.smartgwt.client.widgets.StretchImg#getSrc src} for this stretchImg, redrawing if necessary.
     *
     * @param src new URL for the image. Default value is null
     * @see com.smartgwt.client.widgets.StretchImg#setHSrc
     * @see com.smartgwt.client.widgets.StretchImg#setVSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSrc(String src) {
        setAttribute("src", src, true);
    }

    /**
     * The base URL for the image.  <P> The {@link com.smartgwt.client.types.State} for the component will be combined with
     * this URL using the same approach as described in {@link com.smartgwt.client.widgets.Img#getSrc Img.src}. Then the image
     * segment {@link com.smartgwt.client.widgets.StretchItem#getName name} as specified by each {@link
     * com.smartgwt.client.widgets.StretchItem} is added. <P> For example, for a stretchImg in "Over" state with a
     * <code>src</code> of "button.png" and a segment name of "stretch", the resulting URL would be "button_Over_stretch.png".
     *
     * @return Current src value. Default value is null
     * @see com.smartgwt.client.widgets.StretchImg#getHSrc
     * @see com.smartgwt.client.widgets.StretchImg#getVSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }
    

    /**
     * Indicates whether the list of images is drawn vertically from top to bottom (true), or horizontally from left to right
     * (false).
     *
     * @param vertical New vertical value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical, true);
    }

    /**
     * Indicates whether the list of images is drawn vertically from top to bottom (true), or horizontally from left to right
     * (false).
     *
     * @return Current vertical value. Default value is true
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public Boolean getVertical()  {
        Boolean result = getAttributeAsBoolean("vertical");
        return result == null ? true : result;
    }
    

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is true and  {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} is unset.
     *
     * @param vSrc New vSrc value. Default value is null
     * @see com.smartgwt.client.widgets.StretchImg#setSrc
     * @see com.smartgwt.client.widgets.StretchImg#setVSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setVSrc(String vSrc) {
        setAttribute("vSrc", vSrc, true);
    }

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is true and  {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} is unset.
     *
     * @return Current vSrc value. Default value is null
     * @see com.smartgwt.client.widgets.StretchImg#getSrc
     * @see com.smartgwt.client.widgets.StretchImg#getVSrc
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getVSrc()  {
        return getAttributeAsString("vSrc");
    }
    

    // ********************* Methods ***********************
	/**
     * Set the specified image's state to newState and update the displayed image given by whichPart, or set the state for all
     * images to newState and update the displayed images if whichPart is not provided.
     * @param newState name for the new state ("off", "down", etc)
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public native void setState(String newState) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setState", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setState(newState);
    }-*/;

	/**
     * Set the specified image's state to newState and update the displayed image given by whichPart, or set the state for all
     * images to newState and update the displayed images if whichPart is not provided.
     * @param newState name for the new state ("off", "down", etc)
     * @param whichPart name of the piece to set ("start", "stretch" or "end")           if not specified, sets them all
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public native void setState(String newState, String whichPart) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setState", "String,String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setState(newState, whichPart);
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
     * @param stretchImgProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(StretchImg stretchImgProperties) /*-{
        if (stretchImgProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(StretchImg.@java.lang.Object::getClass()(), "setDefaultProperties", stretchImgProperties.@java.lang.Object::getClass()());
        }
        stretchImgProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = stretchImgProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.StretchImg.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(StretchImgLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.capSize = getAttributeAsString("capSize");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.capSize:" + t.getMessage() + "\n";
        }
        try {
            s.gripImgSuffix = getAttributeAsString("gripImgSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.gripImgSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.hSrc = getAttributeAsString("hSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.hSrc:" + t.getMessage() + "\n";
        }
        try {
            s.ignoreRTL = getAttributeAsString("ignoreRTL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.ignoreRTL:" + t.getMessage() + "\n";
        }
        try {
            s.imageType = getAttributeAsString("imageType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.imageType:" + t.getMessage() + "\n";
        }
        try {
            s.itemBaseStyle = getAttributeAsString("itemBaseStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.itemBaseStyle:" + t.getMessage() + "\n";
        }
        try {
            s.items = getItems();
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.itemsArray:" + t.getMessage() + "\n";
        }
        try {
            s.showDownGrip = getAttributeAsString("showDownGrip");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.showDownGrip:" + t.getMessage() + "\n";
        }
        try {
            s.showGrip = getAttributeAsString("showGrip");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.showGrip:" + t.getMessage() + "\n";
        }
        try {
            s.showRollOverGrip = getAttributeAsString("showRollOverGrip");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.showRollOverGrip:" + t.getMessage() + "\n";
        }
        try {
            s.showTitle = getAttributeAsString("showTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.showTitle:" + t.getMessage() + "\n";
        }
        try {
            s.src = getAttributeAsString("src");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.src:" + t.getMessage() + "\n";
        }
        try {
            s.vertical = getAttributeAsString("vertical");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.vertical:" + t.getMessage() + "\n";
        }
        try {
            s.vSrc = getAttributeAsString("vSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "StretchImg.vSrc:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        StretchImgLogicalStructure s = new StretchImgLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
