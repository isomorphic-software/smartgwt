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
 
package com.smartgwt.client.widgets;



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
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * Subclass of the {@link com.smartgwt.client.widgets.StretchImg} class. As with the {@link
 * com.smartgwt.client.widgets.ImgSplitbar} class,   widgets of this class can be displayed as a resize-bar for widgets  
 * in Layouts where showResizeBar is set to true. Provides a different appearance from  the <code>ImgSplitbar</code>
 * class.<br>  To specify the resizeBar class for some layout, use the {@link
 * com.smartgwt.client.widgets.layout.Layout#getResizeBarClass resizeBarClass}  property.
 */
public class Splitbar extends StretchImg {

    public static Splitbar getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Splitbar) obj;
        } else {
            return new Splitbar(jsObj);
        }
    }

    public Splitbar(){
        scClassName = "Splitbar";
    }

    public Splitbar(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.Splitbar.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * If this property is true, a click on the Splitbar will collapse its  {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget 'target'}, hiding it and shifting the Splitbar and other members of the
     * layout across to fill the newly available space. If the target is already hidden a click will expand it again (showing
     * it at it's normal size).
     *
     * @param canCollapse canCollapse Default value is true
     */
    public void setCanCollapse(Boolean canCollapse) {
        setAttribute("canCollapse", canCollapse, true);
    }

    /**
     * If this property is true, a click on the Splitbar will collapse its  {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget 'target'}, hiding it and shifting the Splitbar and other members of the
     * layout across to fill the newly available space. If the target is already hidden a click will expand it again (showing
     * it at it's normal size).
     *
     *
     * @return Boolean
     */
    public Boolean getCanCollapse()  {
        return getAttributeAsBoolean("canCollapse");
    }

    /**
     * <code>canDrag</code> set to true to allow dragging of the split bar. Dragging the Splitbar will resize it's {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget 'target'}
     *
     * @param canDrag canDrag Default value is true
     */
    public void setCanDrag(Boolean canDrag) {
        setAttribute("canDrag", canDrag, true);
    }

    /**
     * <code>canDrag</code> set to true to allow dragging of the split bar. Dragging the Splitbar will resize it's {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget 'target'}
     *
     *
     * @return Boolean
     */
    public Boolean getCanDrag()  {
        return getAttributeAsBoolean("canDrag");
    }
 
    /**
     * Splitbars' cursors are set at init time based on whether they are to be used for vertical or horizontal resize.  To
     * customize the cursor for this class, modify  {@link com.smartgwt.client.widgets.Splitbar#getVResizeCursor vResizeCursor}
     * or {@link com.smartgwt.client.widgets.Splitbar#getHResizeCursor hResizeCursor} rather than this property.
     *
     * @param cursor cursor Default value is "hand"
     */
    public void setCursor(Cursor cursor) {
        setAttribute("cursor", cursor.getValue(), true);
    }

    /**
     * Splitbars' cursors are set at init time based on whether they are to be used for vertical or horizontal resize.  To
     * customize the cursor for this class, modify  {@link com.smartgwt.client.widgets.Splitbar#getVResizeCursor vResizeCursor}
     * or {@link com.smartgwt.client.widgets.Splitbar#getHResizeCursor hResizeCursor} rather than this property.
     *
     *
     * @return Cursor
     */
    public Cursor getCursor()  {
        return EnumUtil.getEnum(Cursor.values(), getAttribute("cursor"));
    }

    /**
     * part name for the 'grip' image if {@link com.smartgwt.client.widgets.Splitbar#getShowGrip showGrip} is true
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param gripImgSuffix gripImgSuffix Default value is "grip"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setGripImgSuffix(String gripImgSuffix)  throws IllegalStateException {
        setAttribute("gripImgSuffix", gripImgSuffix, false);
    }

    /**
     * part name for the 'grip' image if {@link com.smartgwt.client.widgets.Splitbar#getShowGrip showGrip} is true
     *
     *
     * @return String
     */
    public String getGripImgSuffix()  {
        return getAttributeAsString("gripImgSuffix");
    }
 
    /**
     * Cursor to display if this Splitbar is to be used for horizontal resize of widgets.
     *
     * @param hResizeCursor hResizeCursor Default value is "col-resize"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHResizeCursor(Cursor hResizeCursor)  throws IllegalStateException {
        setAttribute("hResizeCursor", hResizeCursor.getValue(), false);
    }

    /**
     * Cursor to display if this Splitbar is to be used for horizontal resize of widgets.
     *
     *
     * @return Cursor
     */
    public Cursor getHResizeCursor()  {
        return EnumUtil.getEnum(Cursor.values(), getAttribute("hResizeCursor"));
    }

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is false and  {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} is unset.
     *
     * @param hSrc hSrc Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setHSrc(String hSrc)  throws IllegalStateException {
        setAttribute("hSrc", hSrc, false);
    }

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is false and  {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} is unset.
     *
     *
     * @return String
     */
    public String getHSrc()  {
        return getAttributeAsString("hSrc");
    }

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowGrip showGrip} is true, this property determines whether the grip
     * image displayed should show the <code>"Closed"</code> state when the {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}  is hidden.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showClosedGrip showClosedGrip Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowClosedGrip(Boolean showClosedGrip)  throws IllegalStateException {
        setAttribute("showClosedGrip", showClosedGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowGrip showGrip} is true, this property determines whether the grip
     * image displayed should show the <code>"Closed"</code> state when the {@link
     * com.smartgwt.client.widgets.Splitbar#getTarget target}  is hidden.
     *
     *
     * @return Boolean
     */
    public Boolean getShowClosedGrip()  {
        return getAttributeAsBoolean("showClosedGrip");
    }

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Down' state on the grip image when the user mousedown's on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown showDown} is false
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showDownGrip showDownGrip Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowDownGrip(Boolean showDownGrip)  throws IllegalStateException {
        setAttribute("showDownGrip", showDownGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Down' state on the grip image when the user mousedown's on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowDown showDown} is false
     *
     *
     * @return Boolean
     */
    public Boolean getShowDownGrip()  {
        return getAttributeAsBoolean("showDownGrip");
    }

    /**
     * Should we show a "grip" image floating above the center of this widget?
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showGrip showGrip Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowGrip(Boolean showGrip)  throws IllegalStateException {
        setAttribute("showGrip", showGrip, false);
    }

    /**
     * Should we show a "grip" image floating above the center of this widget?
     *
     *
     * @return Boolean
     */
    public Boolean getShowGrip()  {
        return getAttributeAsBoolean("showGrip");
    }

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Over' state on the grip image when the user rolls over on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver showRollOver} is false
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param showRollOverGrip showRollOverGrip Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowRollOverGrip(Boolean showRollOverGrip)  throws IllegalStateException {
        setAttribute("showRollOverGrip", showRollOverGrip, false);
    }

    /**
     * If {@link com.smartgwt.client.widgets.Splitbar#getShowGrip showGrip} is true, this property determines whether to show
     * the 'Over' state on the grip image when the user rolls over on this widget.  Has no effect if {@link
     * com.smartgwt.client.widgets.StatefulCanvas#getShowRollOver showRollOver} is false
     *
     *
     * @return Boolean
     */
    public Boolean getShowRollOverGrip()  {
        return getAttributeAsBoolean("showRollOverGrip");
    }

    /**
     * The base URL for the image.  <P> As with {@link com.smartgwt.client.widgets.Img#getSrc src}, the {@link
     * com.smartgwt.client.types.State} of the component is added to this URL.  Then, the image segment name as specified by
     * {@link com.smartgwt.client.widgets.StretchImg#getItems items} is added. <P> For example, for a stretchImg in "Over"
     * state with a <code>src</code> of "button.png" and a segment name of "stretch", the resulting URL would be
     * "button_Over_stretch.png".
     *
     * @param src src Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setSrc(String src)  throws IllegalStateException {
        setAttribute("src", src, false);
    }

    /**
     * The base URL for the image.  <P> As with {@link com.smartgwt.client.widgets.Img#getSrc src}, the {@link
     * com.smartgwt.client.types.State} of the component is added to this URL.  Then, the image segment name as specified by
     * {@link com.smartgwt.client.widgets.StretchImg#getItems items} is added. <P> For example, for a stretchImg in "Over"
     * state with a <code>src</code> of "button.png" and a segment name of "stretch", the resulting URL would be
     * "button_Over_stretch.png".
     *
     *
     * @return String
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }


    /**
     * Is this split bar vertically orientated?<br> When a <code>Splitbar</code> is created by a layout to be the resizeBar for
     * some member of the layout, the <code>vertical</code> property will be set to <code>true</code> if the layout is
     * horizontal, meaning this resizeBar will be taller than it is wide,  and will allow horizontal resizing of the member.
     *
     * <b>Note :</b> This method should be called only after the widget has been rendered.
     *
     * @return Boolean
     * @throws IllegalStateException if widget has not yet been rendered.
     */
    public Boolean getVertical() throws IllegalStateException {
        errorIfNotCreated("vertical");
        return getAttributeAsBoolean("vertical");
    }
 
    /**
     * Cursor to display if this Splitbar is to be used for vertical resize of widgets.
     *
     * @param vResizeCursor vResizeCursor Default value is "row-resize"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setVResizeCursor(Cursor vResizeCursor)  throws IllegalStateException {
        setAttribute("vResizeCursor", vResizeCursor.getValue(), false);
    }

    /**
     * Cursor to display if this Splitbar is to be used for vertical resize of widgets.
     *
     *
     * @return Cursor
     */
    public Cursor getVResizeCursor()  {
        return EnumUtil.getEnum(Cursor.values(), getAttribute("vResizeCursor"));
    }

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is true and  {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} is unset.
     *
     * @param vSrc vSrc Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setVSrc(String vSrc)  throws IllegalStateException {
        setAttribute("vSrc", vSrc, false);
    }

    /**
     * Base URL for the image if {@link com.smartgwt.client.widgets.StretchImg#getVertical vertical} is true and  {@link
     * com.smartgwt.client.widgets.StretchImg#getSrc src} is unset.
     *
     *
     * @return String
     */
    public String getVSrc()  {
        return getAttributeAsString("vSrc");
    }

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

}



