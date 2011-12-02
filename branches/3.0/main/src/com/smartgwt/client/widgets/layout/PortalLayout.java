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
 
package com.smartgwt.client.widgets.layout;



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

import java.util.*;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A PortalLayout is a special subclass of Layout designed to display {@link com.smartgwt.client.widgets.layout.Portlet}
 * windows. A PortalLayout displays Portlets in columns and supports drag-drop interaction for moving  Portlets around
 * within the PortalLayout. Portlets may be drag-reordered within columns, dragged into other columns, or dragged next to
 * other Portlets to sit next to them horizontally within a column.
 */
public class PortalLayout extends Layout {

    public static PortalLayout getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (PortalLayout) obj;
        } else {
            return new PortalLayout(jsObj);
        }
    }

    public PortalLayout(){
        scClassName = "PortalLayout";
    }

    public PortalLayout(JavaScriptObject jsObj){
        super(jsObj);
    }

    public PortalLayout(int numColumns) {
        setNumColumns(numColumns);
        scClassName = "PortalLayout";
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
     * Are columns in this PortalLayout drag-resizeable? <p> Note that the <u>displayed</u> width of a column will
     * automatically shrink and stretch to accomodate the width of {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getPortlets Portlet} -- see {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths canStretchColumnWidths} and {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths} for an explanation. 
     * This setting affects the <u>intrinsic</u> width of a column -- that is, the width it will try to return to when not
     * necessary to stretch or shrink to accomodate Portlet widths.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set whether columns in this portalLayout are drag-resizable, and update any drawn columns to reflect this.
     *
     * @param canResizeColumns Whether columns are drag-resizable. Default value is false
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanStretchColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanShrinkColumnWidths
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public void setCanResizeColumns(Boolean canResizeColumns) {
        setAttribute("canResizeColumns", canResizeColumns, true);
    }

    /**
     * Are columns in this PortalLayout drag-resizeable? <p> Note that the <u>displayed</u> width of a column will
     * automatically shrink and stretch to accomodate the width of {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getPortlets Portlet} -- see {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths canStretchColumnWidths} and {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths} for an explanation. 
     * This setting affects the <u>intrinsic</u> width of a column -- that is, the width it will try to return to when not
     * necessary to stretch or shrink to accomodate Portlet widths.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Boolean getCanResizeColumns()  {
        return getAttributeAsBoolean("canResizeColumns");
    }

    /**
     * Should the height and width of {@link com.smartgwt.client.widgets.layout.Portlet Portlets} be drag-resizable? <p> Note
     * that changing the <b>height</b> of a Portlet will change the height of all the Portlets in the same row to match. <p> If
     * the height of Portlets causes a column to overflow, that column will scroll vertically (independent of other columns),
     * depending on the {@link com.smartgwt.client.widgets.layout.PortalLayout#getColumnOverflow columnOverflow} setting. <p>
     * Changing the <b>width</b> of a Portlet will potentially cause columns to stretch and shrink their <u>displayed</u>
     * widths in order to accomodate the Portlets, depending on the value of {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanStrechColumnWidths canStretchColumnWidths} and  {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths}. <p> However, the
     * <u>instrinsic</u> width of the columns will remain the same, so that the columns will resume their former widths when no
     * longer necessary  to stretch or shrink to accomodate the widths of Portlets.  To allow drag-resizing of the intrinsic
     * width of columns, see {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanResizeColumns canResizeColumns}. <p>
     * The net effect is that (by default) PortalLayouts behave like layouts when Portlet sizes do not cause overflow, but
     * behave more like stacks when overflow occurs.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set whether the height and width of {@link com.smartgwt.client.widgets.layout.PortalLayout#getPortlets Portlets} should be drag-resizable, and update any drawn Portlets to reflect this.
     *
     * @param canResizePortlets Whether drag-resizing the height and width of portlets is allowed. Default value is false
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanResizeColumns
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanStretchColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanShrinkColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setColumnOverflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public void setCanResizePortlets(Boolean canResizePortlets) {
        setAttribute("canResizePortlets", canResizePortlets, true);
    }

    /**
     * Should the height and width of {@link com.smartgwt.client.widgets.layout.Portlet Portlets} be drag-resizable? <p> Note
     * that changing the <b>height</b> of a Portlet will change the height of all the Portlets in the same row to match. <p> If
     * the height of Portlets causes a column to overflow, that column will scroll vertically (independent of other columns),
     * depending on the {@link com.smartgwt.client.widgets.layout.PortalLayout#getColumnOverflow columnOverflow} setting. <p>
     * Changing the <b>width</b> of a Portlet will potentially cause columns to stretch and shrink their <u>displayed</u>
     * widths in order to accomodate the Portlets, depending on the value of {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanStrechColumnWidths canStretchColumnWidths} and  {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths}. <p> However, the
     * <u>instrinsic</u> width of the columns will remain the same, so that the columns will resume their former widths when no
     * longer necessary  to stretch or shrink to accomodate the widths of Portlets.  To allow drag-resizing of the intrinsic
     * width of columns, see {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanResizeColumns canResizeColumns}. <p>
     * The net effect is that (by default) PortalLayouts behave like layouts when Portlet sizes do not cause overflow, but
     * behave more like stacks when overflow occurs.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanResizeColumns
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getColumnOverflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Boolean getCanResizePortlets()  {
        return getAttributeAsBoolean("canResizePortlets");
    }

    /**
     * Controls whether the PortalLayout will shrink column widths to avoid overflowing the PortalLayout  horizontally. If the
     * PortalLayout would otherwise overflow its width, it will check each column to see whether it is wider than necessary to
     * accommodate its {@link com.smartgwt.client.widgets.layout.Portlet Portlets}. If so, the column may shrink to avoid
     * having to scroll the PortalLayout.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths} and reflows to reflect the new setting.
     *
     * @param canShrinkColumnWidths Whether columns can shrink to avoid overflowing the PortalLayout's width.. Default value is true
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanStretchColumnWidths
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public void setCanShrinkColumnWidths(Boolean canShrinkColumnWidths) {
        setAttribute("canShrinkColumnWidths", canShrinkColumnWidths, true);
    }

    /**
     * Controls whether the PortalLayout will shrink column widths to avoid overflowing the PortalLayout  horizontally. If the
     * PortalLayout would otherwise overflow its width, it will check each column to see whether it is wider than necessary to
     * accommodate its {@link com.smartgwt.client.widgets.layout.Portlet Portlets}. If so, the column may shrink to avoid
     * having to scroll the PortalLayout.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Boolean getCanShrinkColumnWidths()  {
        return getAttributeAsBoolean("canShrinkColumnWidths");
    }

    /**
     * Controls whether the PortalLayout will stretch column widths, if needed to accommodate the width of {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets}. If set, columns will overflow their widths in order to accomodate 
     * the widths of their Portlets. <p> With the default setting of {@link com.smartgwt.client.types.Overflow}: auto, the
     * PortalLayout as a whole will scroll  horizontally if needed. Depending on the setting of {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths},  other columns may
     * shrink to avoid overflow on the PortalLayout as a whole. <p> If <code>canStretchColumnWidths</code> is turned off, then
     * individual rows will scroll horizontally in order to accommodate Portlets that are wider than their column width allows.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths canStretchColumnWidths} and reflows to reflect the new setting.
     *
     * @param canStretchColumnWidths Whether columns can stretch to accommodate {@link com.smartgwt.client.widgets.layout.Portlet} widths.. Default value is true
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanShrinkColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanResizePortlets
     * @see com.smartgwt.client.types.Overflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public void setCanStretchColumnWidths(Boolean canStretchColumnWidths) {
        setAttribute("canStretchColumnWidths", canStretchColumnWidths, true);
    }

    /**
     * Controls whether the PortalLayout will stretch column widths, if needed to accommodate the width of {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets}. If set, columns will overflow their widths in order to accomodate 
     * the widths of their Portlets. <p> With the default setting of {@link com.smartgwt.client.types.Overflow}: auto, the
     * PortalLayout as a whole will scroll  horizontally if needed. Depending on the setting of {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths},  other columns may
     * shrink to avoid overflow on the PortalLayout as a whole. <p> If <code>canStretchColumnWidths</code> is turned off, then
     * individual rows will scroll horizontally in order to accommodate Portlets that are wider than their column width allows.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanResizePortlets
     * @see com.smartgwt.client.types.Overflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Boolean getCanStretchColumnWidths()  {
        return getAttributeAsBoolean("canStretchColumnWidths");
    }

    /**
     * Border to show around columns in this PortalLayout
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the columnBorder for to the specified value and updates any drawn columns to reflect this.
     *
     * @param columnBorder New border to show around columns. Default value is "1px solid gray"
     */
    public void setColumnBorder(String columnBorder) {
        setAttribute("columnBorder", columnBorder, true);
    }

    /**
     * Border to show around columns in this PortalLayout
     *
     *
     * @return String
     */
    public String getColumnBorder()  {
        return getAttributeAsString("columnBorder");
    }

    /**
     * Controls the {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow} setting for each column. If set to "auto"
     * (the default) then each column will scroll individually (if its {@link com.smartgwt.client.widgets.layout.Portlet
     * Portlets} overflow the column height). You can also use "hidden" to clip overflowing heights, or "visible" to show the
     * overflow. The effect of "visible" will depend on the setting for {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getOverflow overflow} -- by default, the PortalLayout as a whole will
     * scroll when necessary.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getColumnOverflow columnOverflow} and updates existing columns to reflect the new setting.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param columnOverflow Overflow setting for columns. Default value is "auto"
     * @see com.smartgwt.client.types.Overflow
     * @see com.smartgwt.client.widgets.Canvas#setOverflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public void setColumnOverflow(Overflow columnOverflow) {
        setAttribute("columnOverflow", columnOverflow.getValue(), true);
    }

    /**
     * Controls the {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow} setting for each column. If set to "auto"
     * (the default) then each column will scroll individually (if its {@link com.smartgwt.client.widgets.layout.Portlet
     * Portlets} overflow the column height). You can also use "hidden" to clip overflowing heights, or "visible" to show the
     * overflow. The effect of "visible" will depend on the setting for {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getOverflow overflow} -- by default, the PortalLayout as a whole will
     * scroll when necessary.
     *
     *
     * @return Overflow
     * @see com.smartgwt.client.types.Overflow
     * @see com.smartgwt.client.widgets.Canvas#getOverflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Overflow getColumnOverflow()  {
        return EnumUtil.getEnum(Overflow.values(), getAttribute("columnOverflow"));
    }

    /**
     * Initial number of columns to show in this PortalLayout. Note that after initialization columns should be added / removed
     * via {@link com.smartgwt.client.widgets.layout.PortalLayout#addColumn PortalLayout.addColumn} and {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#removeColumn PortalLayout.removeColumn}. numColumns is ignored if you
     * initialize the {@link com.smartgwt.client.widgets.layout.PortalLayout#getPortlets portlets} attribute, since the
     * portlets attribute will imply how many columns to create.
     *
     * @param numColumns numColumns Default value is 2
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setPortlets
     */
    public void setNumColumns(int numColumns)  throws IllegalStateException {
        setAttribute("numColumns", numColumns, false);
    }

    /**
     * Initial number of columns to show in this PortalLayout. Note that after initialization columns should be added / removed
     * via {@link com.smartgwt.client.widgets.layout.PortalLayout#addColumn PortalLayout.addColumn} and {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#removeColumn PortalLayout.removeColumn}. numColumns is ignored if you
     * initialize the {@link com.smartgwt.client.widgets.layout.PortalLayout#getPortlets portlets} attribute, since the
     * portlets attribute will imply how many columns to create.
     *
     *
     * @return Returns the current number of columns displayed in this PortalLayout.
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getPortlets
     */
    public int getNumColumns()  {
        return getAttributeAsInt("numColumns");
    }

    /**
     * Controls how the PortalLayout reacts when column widths or {@link com.smartgwt.client.widgets.layout.Portlet} widths
     * overflow the width of the PortalLayout. By default, the PortalLayout scrolls when necessary. You can also use overflow:
     * visible or overflow: hidden, with the  usual results -- see {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanResizePortlets canResizePortlets} for a further explanation of
     * column widths. <p> Note that overflowing height is also affected by {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getColumnOverflow columnOverflow}. By default, each column will scroll
     * individually -- you can change columnOverflow to "auto" to scroll the whole PortalLayout instead.
     *
     * @param overflow overflow Default value is "auto"
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanResizePortlets
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setColumnOverflow
     * @see com.smartgwt.client.widgets.Canvas#setOverflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public void setOverflow(Overflow overflow) {
        setAttribute("overflow", overflow.getValue(), true);
    }

    /**
     * Controls how the PortalLayout reacts when column widths or {@link com.smartgwt.client.widgets.layout.Portlet} widths
     * overflow the width of the PortalLayout. By default, the PortalLayout scrolls when necessary. You can also use overflow:
     * visible or overflow: hidden, with the  usual results -- see {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanResizePortlets canResizePortlets} for a further explanation of
     * column widths. <p> Note that overflowing height is also affected by {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getColumnOverflow columnOverflow}. By default, each column will scroll
     * individually -- you can change columnOverflow to "auto" to scroll the whole PortalLayout instead.
     *
     *
     * @return Overflow
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanResizePortlets
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getColumnOverflow
     * @see com.smartgwt.client.widgets.Canvas#getOverflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Overflow getOverflow()  {
        return EnumUtil.getEnum(Overflow.values(), getAttribute("overflow"));
    }

    /**
     * Controls whether the last {@link com.smartgwt.client.widgets.layout.Portlet} in a column will be stretched to fill the
     * column's height, or left at its specified height.
     *
     * @param preventColumnUnderflow preventColumnUnderflow Default value is true
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public void setPreventColumnUnderflow(Boolean preventColumnUnderflow) {
        setAttribute("preventColumnUnderflow", preventColumnUnderflow, true);
    }

    /**
     * Controls whether the last {@link com.smartgwt.client.widgets.layout.Portlet} in a column will be stretched to fill the
     * column's height, or left at its specified height.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Boolean getPreventColumnUnderflow()  {
        return getAttributeAsBoolean("preventColumnUnderflow");
    }

    /**
     * Controls whether the last {@link com.smartgwt.client.widgets.layout.Portlet} in a row will be stretched to fill the
     * row's width, or left at its specified width.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getPreventRowUnderflow preventRowUnderflow} and reflows the layout to implement it.
     *
     * @param preventRowUnderflow Whether to stretch the last {@link com.smartgwt.client.widgets.layout.Portlet} in a row to to fill the row's width.. Default value is true
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public void setPreventRowUnderflow(Boolean preventRowUnderflow) {
        setAttribute("preventRowUnderflow", preventRowUnderflow, true);
    }

    /**
     * Controls whether the last {@link com.smartgwt.client.widgets.layout.Portlet} in a row will be stretched to fill the
     * row's width, or left at its specified width.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Boolean getPreventRowUnderflow()  {
        return getAttributeAsBoolean("preventRowUnderflow");
    }

    /**
     * Controls whether the last column will be stretched to fill the PortalLayout's width, or left at its specified width.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getPreventUnderflow preventUnderflow} and reflows the layout to implement it.
     *
     * @param preventUnderflow Whether to stretch the last column to fill the PortalLayout's width.. Default value is true
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public void setPreventUnderflow(Boolean preventUnderflow) {
        setAttribute("preventUnderflow", preventUnderflow, true);
    }

    /**
     * Controls whether the last column will be stretched to fill the PortalLayout's width, or left at its specified width.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Boolean getPreventUnderflow()  {
        return getAttributeAsBoolean("preventUnderflow");
    }

    /**
     * Should a menu be shown within each column with options to add / remove columns?
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getShowColumnMenus showColumnMenus} and updates existing columns to reflect the new setting.
     *
     * @param showColumnMenus Whether to show column menus. Default value is true
     * 
     */
    public void setShowColumnMenus(Boolean showColumnMenus) {
        setAttribute("showColumnMenus", showColumnMenus, true);
    }

    /**
     * Should a menu be shown within each column with options to add / remove columns?
     *
     *
     * @return Boolean
     * 
     */
    public Boolean getShowColumnMenus()  {
        return getAttributeAsBoolean("showColumnMenus");
    }

    /**
     * When {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths stretching column widths}, should
     * we stretch all column widths proportionally, or just stretch the columns that need extra width? <p> Note that this
     * implies turning off {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths
     * canShrinkColumnWidths}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getStretchColumnWidthsProportionally stretchColumnWidthsProportionally} and reflows to reflect the new setting.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param stretchColumnWidthsProportionally Whether to stretch column widths proportionally. Default value is false
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanStretchColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanShrinkColumnWidths
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public void setStretchColumnWidthsProportionally(Boolean stretchColumnWidthsProportionally) {
        setAttribute("stretchColumnWidthsProportionally", stretchColumnWidthsProportionally, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths stretching column widths}, should
     * we stretch all column widths proportionally, or just stretch the columns that need extra width? <p> Note that this
     * implies turning off {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths
     * canShrinkColumnWidths}.
     *
     *
     * @return Boolean
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Boolean getStretchColumnWidthsProportionally()  {
        return getAttributeAsBoolean("stretchColumnWidthsProportionally");
    }

    // ********************* Methods ***********************
            
    /**
     * Adds a new portal column to this layout at the specified position
     * @param index target position for the new column
     */
    public native void addColumn(int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addColumn(index);
    }-*/;
            
    /**
     * Gets the width of a column in the PortalLayout.
     * @param colNumber Which column's width to get
     *
     * @return width
     * @see com.smartgwt.client.widgets.Canvas#getWidth
     */
    public native int getColumnWidth(int colNumber) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        return self.getColumnWidth(colNumber);
    }-*/;
            
    /**
     * Removes the specified column from this layout. All portlets displayed within this column will be destroyed when the
     * column is removed.
     * @param index column number to remove
     */
    public native void removeColumn(int index) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeColumn(index);
    }-*/;
            
    /**
     * Removes a {@link com.smartgwt.client.widgets.layout.Portlet} which is currently rendered in this PortalLayout. Portlet
     * will not be destroyed by default - if this is desired the calling code should do this explicitly.
     * @param portlet portlet to remove
     */
    public native void removePortlet(Portlet portlet) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removePortlet(portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;
            
    /**
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getPreventColumnUnderflow preventColumnUnderflow} and
     * reflows the layout to implement it.
     * @param preventColumnUnderflow Whether to stretch the last {@link com.smartgwt.client.widgets.layout.PortalLayout#getPorlet Porlet} in a column to 
     * fill the column's height.
     */
    public native void setColumnPreventUnderflow(boolean preventColumnUnderflow) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setColumnPreventUnderflow(preventColumnUnderflow);
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
     * @param portalLayoutProperties properties that should be used as new defaults when instances of this class are created
     */
    public static native void setDefaultProperties(PortalLayout portalLayoutProperties) /*-{
    	var properties = $wnd.isc.addProperties({},portalLayoutProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
    	delete properties.ID;
        $wnd.isc.PortalLayout.addProperties(properties);
    }-*/;
        
    // ***********************************************************        



    public void onInit () {
        super.onInit();
        onInit_PortalLayout();
    }
    
    protected native void onInit_PortalLayout () /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        
        self.__getDropPortlet = self.getDropPortlet;
        self.getDropPortlet = $entry(function(dragTarget, rowNum, colNum, dropPosition) {
            var jObj = this.__ref;
            
            if (jObj == null) return this.__getDropPortlet(dragTarget, rowNum,colNum,dropPosition);
            
            var dragTargetJ = @com.smartgwt.client.widgets.Canvas::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(dragTarget);
            var rowNumJ = @java.lang.Integer::new(I)(rowNum);
            var colNumJ = @java.lang.Integer::new(I)(colNum);
            var dropPositionJ = dropPosition == null ? null : @java.lang.Integer::new(I)(dropPosition);
            var jPortlet = jObj.@com.smartgwt.client.widgets.layout.PortalLayout::getDropPortlet(Lcom/smartgwt/client/widgets/Canvas;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)(dragTargetJ,rowNumJ,colNumJ,dropPositionJ);
            return jPortlet.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();

        });
        
    }-*/;
    
    /**
     * This method is called when the user drops components into the rows or columns of this PortalLayout. <P> Overriding this
     * method allows you to modify drop behaviour when creating or reordering portlets via drag & drop. You can return the
     * dragTarget for the standard behavior,  or null to cancel the drop. <P> Otherwise, return the component you want to be
     * dropped (as for {@link com.smartgwt.client.widgets.layout.Layout#getDropComponent Layout.getDropComponent}).
     * <P>
     * <b>Note: this is an override point.</b>
     * 
     * @param dragTarget the component being dragged
     * @param colNum indicates which column the portlet is being dropped on.
     * @param rowNum indicates the row number being dropped on.
     * @param dropPosition Drop position within an existing row. If the dropPosition   is null, then that means that a new row will be created.
     *
     * @return drop-component or custom Portlet to embed in the portalLayout. Returning  null will cancel the drop.
     */
    public native Canvas getDropPortlet(Canvas dragTarget, Integer colNum, Integer rowNum, Integer dropPosition) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var dragTargetJS = dragTarget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        
        var ret = self.__getDropPortlet(dragTargetJS, colNum, rowNum, dropPosition);
        if(ret == null || ret === undefined) return null;
        var retVal = @com.smartgwt.client.widgets.BaseWidget::getRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.Canvas::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
        }
        return retVal;
    }-*/;

    /**
     * A convenience attribute which you can use to populate a PortalLayout with {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets} on initialization. After initialization, use {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#addPortlet addPortlet()} or drag-and-drop to add Portlets, and {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getPortlets getPortlets()} or {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getPortletArray getPortletArray()} to get Portlets. <p> To create one
     * column, you can provide an array of Portlets. <p> To create multiple columns, provide an array of arrays (where the
     * first level represents columns, and the second represents Portlets). <p> To put multiple portlets in the same row,
     * provide a third level to the array. <p> Note that {@link com.smartgwt.client.widgets.layout.PortalLayout#getNumColumns
     * numColumns} is ignored if you provide the portlets attribute, since the array will indicate how many columns to create.
     * You can provide an empty second-level array to create a blank column, if needed.
     *
     * @param portlets portlets Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getPortlets
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getPortletArray
     * @see com.smartgwt.client.widgets.layout.PortalLayout#addPortlet
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setNumColumns
     * 
     */
    public void setPortlets(Portlet... portlets)  throws IllegalStateException {
        setAttribute("portlets", portlets, false);
    }
    
    /**
     * Returns a flat array of all the {@link com.smartgwt.client.widgets.layout.Portlet Portlets} in this PortalLayout.
     *
     * @return portlets
     */
    public native Portlet[] getPortlets() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var portletsJS = self.getPortlets();
        return @com.smartgwt.client.widgets.layout.PortalLayout::convertToPortletArray(Lcom/google/gwt/core/client/JavaScriptObject;)(portletsJS);
    }-*/;

    private static Portlet[] convertToPortletArray(JavaScriptObject nativeArray) {
        if (nativeArray == null) {
            return new Portlet[]{};
        }
        if (JSOHelper.isArray(nativeArray)) {
            JavaScriptObject[] componentsj = JSOHelper.toArray(nativeArray);
            Portlet[] objects = new Portlet[componentsj.length];
            for (int i = 0; i < componentsj.length; i++) {
                JavaScriptObject componentJS = componentsj[i];
                Portlet obj = (Portlet) Canvas.getRef(componentJS);
                if (obj == null) obj = new Portlet(componentJS);
                objects[i] = obj;
            }
            return objects;
        } else {
            Portlet[] ret = new Portlet[1];
            ret[0] = Portlet.getOrCreateRef(nativeArray);
            return ret;
        }
    }

    /**
     * Returns a multi-level array of the {@link com.smartgwt.client.widgets.layout.Portlet Portlets} in this PortalLayout, 
     * where the first level corresponds to columns, the second to rows, and the third to Portlets within rows.
     *
     * @return portlets 
     */
    public native Portlet[][][] getPortletArray() /*-{
    	var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
    	var portletsJS = self.getPortletArray();
    	return @com.smartgwt.client.widgets.layout.PortalLayout::convertToMultiDimPortletArray(Lcom/google/gwt/core/client/JavaScriptObject;)(portletsJS);
	}-*/;

	private static Portlet[][][] convertToMultiDimPortletArray(JavaScriptObject columns) {
	    if (columns == null || !JSOHelper.isArray(columns)) {
	        return new Portlet[][][]{};
	    }

	    Portlet[][][] objects;
	    
        JavaScriptObject[] columnsj = JSOHelper.toArray(columns);
    	objects = new Portlet[columnsj.length][][];
        for (int p = 0; p < columnsj.length; p++) {
    	    if (columnsj[p] == null || !JSOHelper.isArray(columnsj[p])) {
                objects[p] = new Portlet[0][];
    	    	continue;
    	    }
            JavaScriptObject[] rowsj = JSOHelper.toArray(columnsj[p]);
            objects[p] = new Portlet[rowsj.length][];
	        for (int q = 0; q < rowsj.length; q++) {
	    	    if (rowsj[q] == null || !JSOHelper.isArray(rowsj[q])) {
	                objects[p][q] = new Portlet[0];
	    	    	continue;
	    	    }
	            JavaScriptObject[] portletsj = JSOHelper.toArray(rowsj[q]);
	            objects[p][q] = new Portlet[portletsj.length];
		        for (int r = 0; r < portletsj.length; r++) {
		            JavaScriptObject portletj = portletsj[r];
		            Portlet obj = (Portlet) Canvas.getRef(portletj);
		            if (obj == null) obj = new Portlet(portletj);
		            objects[p][q][r] = obj;
		        }
	        }
        }
        return objects;
	}

    /**
     * Adds a {@link com.smartgwt.client.widgets.layout.Portlet} instance to this portalLayout in the specified position.
     * @param portlet Portlet to add to this layout.
     */
    public native void addPortlet(Portlet portlet) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPortlet(portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    /**
     * Adds a {@link com.smartgwt.client.widgets.layout.Portlet} instance to this portalLayout in the specified position.
     * @param portlet Portlet to add to this layout.
     * @param colNum Column in which the Portlet should be added. If unspecified,  defaults to zero.
     * @param rowNum Position within the column for the Portlet.
     */
    public native void addPortlet(Portlet portlet, int colNum, int rowNum) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPortlet(portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), colNum, rowNum);
    }-*/;

    /**
     * Adds a {@link com.smartgwt.client.widgets.layout.Portlet} instance to this portalLayout in the specified position.
     * @param portlet Portlet to add to this layout.
     * @param colNum Column in which the Portlet should be added. If unspecified,  defaults to zero.
     * @param rowNum Position within the column for the Portlet
     * @param rowOffset Position for the portlet within an existing row. If the row specified by rowNum already exists,
     * the portlet will be added to that row at this position.  If rowNum does not already exist, this parameter is ignored
     */
    public native void addPortlet(Portlet portlet, int colNum, int rowNum, int rowOffset) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.addPortlet(portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), colNum, rowNum, rowOffset);
    }-*/;
    
    /**
     * Sets the width of a column in the PortalLayout.
     * @param colNumber Which column's width to set.
     * @param width How wide to make the column
     */
    public native void setColumnWidth(int colNumber, int width) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setColumnWidth(colNumber, width);
    }-*/;

    /**
     * Sets the width of a column in the PortalLayout.
     * @param colNumber Which column's width to set.
     * @param width How wide to make the column
     */
    public native void setColumnWidth(int colNumber, String width) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setColumnWidth(colNumber, width);
    }-*/;


}



