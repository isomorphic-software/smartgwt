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
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
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
import com.smartgwt.logicalstructure.widgets.tab.*;
import com.smartgwt.logicalstructure.widgets.tableview.*;
import com.smartgwt.logicalstructure.widgets.toolbar.*;
import com.smartgwt.logicalstructure.widgets.tree.*;
import com.smartgwt.logicalstructure.widgets.viewer.*;
import com.smartgwt.logicalstructure.widgets.calendar.*;
import com.smartgwt.logicalstructure.widgets.cube.*;
import com.smartgwt.logicalstructure.widgets.tools.*;

/**
 * Resize bar for use in {@link com.smartgwt.client.widgets.layout.Layout#getResizeBarClass Layouts}, based on the {@link
 * com.smartgwt.client.widgets.Img} class.  As with the {@link com.smartgwt.client.widgets.Splitbar} class,  widgets of
 * this class can be displayed as a resize-bar for widgets  in Layouts where showResizeBar is set to true. Provides a
 * different appearance from the <code>Splitbar</code> class. <p> To specify the resizeBar class for some layout, use the
 * {@link com.smartgwt.client.widgets.layout.Layout#getResizeBarClass resizeBarClass} property.
 * @see com.smartgwt.client.widgets.layout.Layout
 * @see com.smartgwt.client.widgets.Splitbar
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("ImgSplitbar")
public class ImgSplitbar extends Img {

    public static ImgSplitbar getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new ImgSplitbar(jsObj);
        } else {
            assert refInstance instanceof ImgSplitbar;
            return (ImgSplitbar)refInstance;
        }
    }


    /**
     * Changes the defaults for Canvas AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults Canvas defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.ImgSplitbar.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
    }-*/;

    /**
     * Changes the defaults for FormItem AutoChildren named <code>autoChildName</code>.
     *
     * @param autoChildName name of an AutoChild to customize the defaults for.
     * @param defaults FormItem defaults to apply. These defaults override any existing properties
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, FormItem defaults) /*-{
        $wnd.isc.ImgSplitbar.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
    }-*/;

    public ImgSplitbar(){
        scClassName = "ImgSplitbar";
    }

    public ImgSplitbar(JavaScriptObject jsObj){
        scClassName = "ImgSplitbar";
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
     * If this property is true, a click on the Splitbar will collapse its  {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}, hiding it and shifting the Splitbar and other members of the
     * layout across to fill the newly available space. If the target is already hidden a click will expand it again (showing
     * it at it's normal size).
     *
     * @param canCollapse  Default value is true
     */
    public void setCanCollapse(Boolean canCollapse) {
        setAttribute("canCollapse", canCollapse, true);
    }

    /**
     * If this property is true, a click on the Splitbar will collapse its  {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}, hiding it and shifting the Splitbar and other members of the
     * layout across to fill the newly available space. If the target is already hidden a click will expand it again (showing
     * it at it's normal size).
     *
     * @return Boolean
     */
    public Boolean getCanCollapse()  {
        return getAttributeAsBoolean("canCollapse");
    }

    /**
     * <code>canDrag</code> set to true to allow dragging of the split bar. Dragging the Splitbar will resize it's {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}
     *
     * @param canDrag  Default value is true
     */
    public void setCanDrag(Boolean canDrag) {
        setAttribute("canDrag", canDrag, true);
    }

    /**
     * <code>canDrag</code> set to true to allow dragging of the split bar. Dragging the Splitbar will resize it's {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}
     *
     * @return Boolean
     */
    public Boolean getCanDrag()  {
        return getAttributeAsBoolean("canDrag");
    }

    /**
     * Default src to display when {@link com.smartgwt.client.widgets.ImgSplitbar#getVertical vertical} is false,  and {@link
     * com.smartgwt.client.widgets.ImgSplitbar#getSrc src} is unset.
     *
     * @param hSrc  Default value is [SKIN]hgrip.png
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.ImgSplitbar#setSrc
     */
    public void setHSrc(String hSrc)  throws IllegalStateException {
        setAttribute("hSrc", hSrc, false);
    }

    /**
     * Default src to display when {@link com.smartgwt.client.widgets.ImgSplitbar#getVertical vertical} is false,  and {@link
     * com.smartgwt.client.widgets.ImgSplitbar#getSrc src} is unset.
     *
     * @return String
     * @see com.smartgwt.client.widgets.ImgSplitbar#getSrc
     */
    public String getHSrc()  {
        return getAttributeAsString("hSrc");
    }

    /**
     * Default directory for skin images (those defined by the class), relative to the Page-wide {@link
     * com.smartgwt.client.util.Page#getSkinDir skinDir}.
     *
     * @param skinImgDir  See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} . Default value is "images/SplitBar/"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public void setSkinImgDir(String skinImgDir)  throws IllegalStateException {
        setAttribute("skinImgDir", skinImgDir, false);
    }

    /**
     * Default directory for skin images (those defined by the class), relative to the Page-wide {@link
     * com.smartgwt.client.util.Page#getSkinDir skinDir}.
     *
     * @return  See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} 
     * @see com.smartgwt.client.docs.Images Images overview and related methods
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }

    /**
     * The base filename for the image. <P> This value will be combined with any specified {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getState state} to form a combined URL, changing the appearance of the
     * component as the state changes. <P> The following table lists out the standard set of combined URLs that  may be
     * generated. Subclasses may support additional state-derived media of course. Note that the src URL will be split such
     * that the extension is always applied to the end of the combined string. For example in the following table, if
     * <code>src</code> was set to <code>"blank.gif"</code>, the Selected+Focused URL would be 
     * <code>"blank_Selected_Focused.gif"</code>. <table> <tr><td><b>URL for Img
     * source</b></td><td><b>Description</b></td></tr> <tr><td><code><i>src</i>+<i>extension</i></code></td><td>Default
     * URL</td></tr> <tr><td><code><i>src</i>+"_Selected"+<i>extension</i></code></td>      <td>Applied when {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} is set to true</td></tr>
     * <tr><td><code><i>src</i>+"_Focused"+<i>extension</i></code></td>      <td>Applied when the component has keyboard focus,
     * if       {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocused showFocused} is true, and       {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is not true.</td></tr>
     * <tr><td><code><i>src</i>+"_Over"+<i>extension</i></code></td>      <td>Applied when the user rolls over the component if
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver showRollOver} is set to true</td></tr>
     * <tr><td><code><i>src</i>+"_Down"+<i>extension</i></code></td>      <td>Applied when the user presses the mouse button
     * over over the component if          {@link com.smartgwt.client.widgets.StatefulCanvas#getShowDown showDown} is set to
     * true</td></tr> <tr><td><code><i>src</i>+"_Disabled"+<i>extension</i></code></td>      <td>Applied to {@link
     * com.smartgwt.client.widgets.Canvas#getDisabled disabled} component       if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDisabled showDisabled} is true.</td></tr> <tr><td
     * colspan=2><i>Combined states</i></td></tr> <tr><td><code><i>src</i>+"_Selected_Focused"+<i>extension</i></code></td>    
     * <td>Combined Selected and focused state</td></tr> <tr><td><code><i>src</i>+"_Selected_Over"+<i>extension</i></code></td>
     * <td>Combined Selected and rollOver state</td></tr> <tr><td><code><i>src</i>+"_Focused_Over"+<i>extension</i></code></td>
     * <td>Combined Focused and rollOver state</td></tr>
     * <tr><td><code><i>src</i>+"_Selected_Focused_Over"+<i>extension</i></code></td>      <td>Combined Selected, Focused and
     * rollOver state</td></tr> <tr><td><code><i>src</i>+"_Selected_Down"+<i>extension</i></code></td>      <td>Combined
     * Selected and mouse-down state</td></tr> <tr><td><code><i>src</i>+"_Focused_Down"+<i>extension</i></code></td>     
     * <td>Combined Focused and mouse-down state</td></tr>
     * <tr><td><code><i>src</i>+"_Selected_Focused_Down"+<i>extension</i></code></td>      <td>Combined Selected, Focused and
     * mouse-down state</td></tr> <tr><td><code><i>src</i>+"_Selected_Disabled"+<i>extension</i></code></td>      <td>Combined
     * Selected and Disabled state</td></tr> </table>
     *
     * @param src  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setSrc(String src)  throws IllegalStateException {
        setAttribute("src", src, false);
    }

    /**
     * The base filename for the image. <P> This value will be combined with any specified {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getState state} to form a combined URL, changing the appearance of the
     * component as the state changes. <P> The following table lists out the standard set of combined URLs that  may be
     * generated. Subclasses may support additional state-derived media of course. Note that the src URL will be split such
     * that the extension is always applied to the end of the combined string. For example in the following table, if
     * <code>src</code> was set to <code>"blank.gif"</code>, the Selected+Focused URL would be 
     * <code>"blank_Selected_Focused.gif"</code>. <table> <tr><td><b>URL for Img
     * source</b></td><td><b>Description</b></td></tr> <tr><td><code><i>src</i>+<i>extension</i></code></td><td>Default
     * URL</td></tr> <tr><td><code><i>src</i>+"_Selected"+<i>extension</i></code></td>      <td>Applied when {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getSelected selected} is set to true</td></tr>
     * <tr><td><code><i>src</i>+"_Focused"+<i>extension</i></code></td>      <td>Applied when the component has keyboard focus,
     * if       {@link com.smartgwt.client.widgets.StatefulCanvas#getShowFocused showFocused} is true, and       {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowFocusedAsOver showFocusedAsOver} is not true.</td></tr>
     * <tr><td><code><i>src</i>+"_Over"+<i>extension</i></code></td>      <td>Applied when the user rolls over the component if
     * {@link com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver showRollOver} is set to true</td></tr>
     * <tr><td><code><i>src</i>+"_Down"+<i>extension</i></code></td>      <td>Applied when the user presses the mouse button
     * over over the component if          {@link com.smartgwt.client.widgets.StatefulCanvas#getShowDown showDown} is set to
     * true</td></tr> <tr><td><code><i>src</i>+"_Disabled"+<i>extension</i></code></td>      <td>Applied to {@link
     * com.smartgwt.client.widgets.Canvas#getDisabled disabled} component       if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDisabled showDisabled} is true.</td></tr> <tr><td
     * colspan=2><i>Combined states</i></td></tr> <tr><td><code><i>src</i>+"_Selected_Focused"+<i>extension</i></code></td>    
     * <td>Combined Selected and focused state</td></tr> <tr><td><code><i>src</i>+"_Selected_Over"+<i>extension</i></code></td>
     * <td>Combined Selected and rollOver state</td></tr> <tr><td><code><i>src</i>+"_Focused_Over"+<i>extension</i></code></td>
     * <td>Combined Focused and rollOver state</td></tr>
     * <tr><td><code><i>src</i>+"_Selected_Focused_Over"+<i>extension</i></code></td>      <td>Combined Selected, Focused and
     * rollOver state</td></tr> <tr><td><code><i>src</i>+"_Selected_Down"+<i>extension</i></code></td>      <td>Combined
     * Selected and mouse-down state</td></tr> <tr><td><code><i>src</i>+"_Focused_Down"+<i>extension</i></code></td>     
     * <td>Combined Focused and mouse-down state</td></tr>
     * <tr><td><code><i>src</i>+"_Selected_Focused_Down"+<i>extension</i></code></td>      <td>Combined Selected, Focused and
     * mouse-down state</td></tr> <tr><td><code><i>src</i>+"_Selected_Disabled"+<i>extension</i></code></td>      <td>Combined
     * Selected and Disabled state</td></tr> </table>
     *
     * @return String
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }

    /**
     * Is this split bar vertically orientated?<br> When a <code>Splitbar</code> is created by a layout to be the resizeBar for
     * some member of the layout, the <code>vertical</code> property will be set to <code>true</code> if the layout is
     * horizontal, meaning this resizeBar will be taller than it is wide,  and will allow horizontal resizing of the member.
     * <p>
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Boolean
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public Boolean getVertical() throws IllegalStateException {
        errorIfNotCreated("vertical");
        return getAttributeAsBoolean("vertical");
    }

    /**
     * Default src to display when {@link com.smartgwt.client.widgets.ImgSplitbar#getVertical vertical} is true,  and {@link
     * com.smartgwt.client.widgets.ImgSplitbar#getSrc src} is unset.
     *
     * @param vSrc  See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} . Default value is [SKIN]vgrip.png
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.ImgSplitbar#setSrc
     */
    public void setVSrc(String vSrc)  throws IllegalStateException {
        setAttribute("vSrc", vSrc, false);
    }

    /**
     * Default src to display when {@link com.smartgwt.client.widgets.ImgSplitbar#getVertical vertical} is true,  and {@link
     * com.smartgwt.client.widgets.ImgSplitbar#getSrc src} is unset.
     *
     * @return  See {@link com.smartgwt.client.docs.SCImgURL SCImgURL} 
     * @see com.smartgwt.client.widgets.ImgSplitbar#getSrc
     */
    public String getVSrc()  {
        return getAttributeAsString("vSrc");
    }

    // ********************* Methods ***********************

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
     * @param imgSplitbarProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(ImgSplitbar imgSplitbarProperties) /*-{
    	var properties = $wnd.isc.addProperties({},imgSplitbarProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.ImgSplitbar.addProperties(properties);
    }-*/;

    // ***********************************************************

    public LogicalStructureObject setLogicalStructure(ImgSplitbarLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.canCollapse = getAttributeAsString("canCollapse");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgSplitbar.canCollapse:" + t.getMessage() + "\n";
        }
        try {
            s.canDrag = getAttributeAsString("canDrag");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgSplitbar.canDrag:" + t.getMessage() + "\n";
        }
        try {
            s.hSrc = getAttributeAsString("hSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgSplitbar.hSrc:" + t.getMessage() + "\n";
        }
        try {
            s.skinImgDir = getAttributeAsString("skinImgDir");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgSplitbar.skinImgDir:" + t.getMessage() + "\n";
        }
        try {
            s.src = getAttributeAsString("src");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgSplitbar.src:" + t.getMessage() + "\n";
        }
        try {
            s.vertical = getAttributeAsString("vertical");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgSplitbar.vertical:" + t.getMessage() + "\n";
        }
        try {
            s.vSrc = getAttributeAsString("vSrc");
        } catch (Throwable t) {
            s.logicalStructureErrors += "ImgSplitbar.vSrc:" + t.getMessage() + "\n";
        }
        return s;
    }

    public LogicalStructureObject getLogicalStructure() {
        ImgSplitbarLogicalStructure s = new ImgSplitbarLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

