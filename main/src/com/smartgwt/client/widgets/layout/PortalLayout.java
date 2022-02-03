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
 
package com.smartgwt.client.widgets.layout;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.browser.window.*;
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
import com.smartgwt.client.widgets.tour.*;
import com.smartgwt.client.widgets.notify.*;
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
import com.smartgwt.client.widgets.notify.*;
import com.smartgwt.client.widgets.drawing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process
import com.smartgwt.client.util.tour.*;

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
import com.smartgwt.logicalstructure.widgets.tour.*;

/**
 * A PortalLayout is a special subclass of Layout designed to display {@link com.smartgwt.client.widgets.layout.Portlet}
 * windows. A PortalLayout displays Portlets in columns and supports drag-drop interaction for moving  Portlets around
 * within the PortalLayout. Portlets may be drag-reordered within columns, dragged into other columns, or dragged next to
 * other Portlets to sit next to them horizontally within a column.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("PortalLayout")
public class PortalLayout extends Layout {

    public static PortalLayout getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new PortalLayout(jsObj);
        } else {
            assert refInstance instanceof PortalLayout;
            return (PortalLayout)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(PortalLayout.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.PortalLayout.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(PortalLayout.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.PortalLayout.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public PortalLayout(){
        scClassName = "PortalLayout";
    }

    public PortalLayout(JavaScriptObject jsObj){
        scClassName = "PortalLayout";
        setJavaScriptObject(jsObj);
    }


    public PortalLayout(int numColumns) {
        setNumColumns(numColumns);
                scClassName = "PortalLayout";
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
     * Are columns in this PortalLayout drag-resizeable? <p> Note that the <u>displayed</u> width of a column will
     * automatically shrink and stretch to accommodate the width of {@link com.smartgwt.client.widgets.layout.Portlet Portlets}
     * -- see {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths canStretchColumnWidths} and
     * {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths} for an
     * explanation.  This setting affects the <u>intrinsic</u> width of a column -- that is, the width it will try to return to
     * when not necessary to stretch or shrink to accommodate Portlet widths.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set whether columns in this portalLayout are drag-resizable, and update any drawn columns to reflect this.
     *
     * @param canResizeColumns Whether columns are drag-resizable. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanStretchColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanShrinkColumnWidths
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public PortalLayout setCanResizeColumns(Boolean canResizeColumns) {
        return (PortalLayout)setAttribute("canResizeColumns", canResizeColumns, true);
    }

    /**
     * Are columns in this PortalLayout drag-resizeable? <p> Note that the <u>displayed</u> width of a column will
     * automatically shrink and stretch to accommodate the width of {@link com.smartgwt.client.widgets.layout.Portlet Portlets}
     * -- see {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths canStretchColumnWidths} and
     * {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths} for an
     * explanation.  This setting affects the <u>intrinsic</u> width of a column -- that is, the width it will try to return to
     * when not necessary to stretch or shrink to accommodate Portlet widths.
     *
     * @return Current canResizeColumns value. Default value is true
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Boolean getCanResizeColumns()  {
        Boolean result = getAttributeAsBoolean("canResizeColumns");
        return result == null ? true : result;
    }
    

    /**
     * Should the height and width of {@link com.smartgwt.client.widgets.layout.Portlet Portlets} be drag-resizable? <p> Note
     * that changing the <b>height</b> of a Portlet will change the height of all the Portlets in the same row to match. <p> If
     * the height of Portlets causes a column to overflow, that column will scroll vertically (independent of other columns),
     * depending on the {@link com.smartgwt.client.widgets.layout.PortalLayout#getColumnOverflow columnOverflow} setting. <p>
     * Changing the <b>width</b> of a Portlet will potentially cause columns to stretch and shrink their <u>displayed</u>
     * widths in order to accommodate the Portlets, depending on the value of {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths canStretchColumnWidths} and  {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths}. <p> However, the
     * <u>instrinsic</u> width of the columns will remain the same, so that the columns will resume their former widths when no
     * longer necessary  to stretch or shrink to accommodate the widths of Portlets.  To allow drag-resizing of the intrinsic
     * width of columns, see {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanResizeColumns canResizeColumns}. <p>
     * The net effect is that (by default) PortalLayouts behave like layouts when Portlet sizes do not cause overflow, but
     * behave more like stacks when overflow occurs.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set whether the height and width of {@link com.smartgwt.client.widgets.layout.Portlet Portlets} should be drag-resizable, and update any drawn Portlets to reflect this.
     *
     * @param canResizePortlets Whether drag-resizing the height and width of portlets is allowed. Default value is false
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanResizeColumns
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanStretchColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanShrinkColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setColumnOverflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public PortalLayout setCanResizePortlets(Boolean canResizePortlets) {
        return (PortalLayout)setAttribute("canResizePortlets", canResizePortlets, true);
    }

    /**
     * Should the height and width of {@link com.smartgwt.client.widgets.layout.Portlet Portlets} be drag-resizable? <p> Note
     * that changing the <b>height</b> of a Portlet will change the height of all the Portlets in the same row to match. <p> If
     * the height of Portlets causes a column to overflow, that column will scroll vertically (independent of other columns),
     * depending on the {@link com.smartgwt.client.widgets.layout.PortalLayout#getColumnOverflow columnOverflow} setting. <p>
     * Changing the <b>width</b> of a Portlet will potentially cause columns to stretch and shrink their <u>displayed</u>
     * widths in order to accommodate the Portlets, depending on the value of {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths canStretchColumnWidths} and  {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths}. <p> However, the
     * <u>instrinsic</u> width of the columns will remain the same, so that the columns will resume their former widths when no
     * longer necessary  to stretch or shrink to accommodate the widths of Portlets.  To allow drag-resizing of the intrinsic
     * width of columns, see {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanResizeColumns canResizeColumns}. <p>
     * The net effect is that (by default) PortalLayouts behave like layouts when Portlet sizes do not cause overflow, but
     * behave more like stacks when overflow occurs.
     *
     * @return Current canResizePortlets value. Default value is false
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanResizeColumns
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getColumnOverflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Boolean getCanResizePortlets()  {
        Boolean result = getAttributeAsBoolean("canResizePortlets");
        return result == null ? false : result;
    }
    

    /**
     * Should vertical drag-resize of portlets within columns be allowed?
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Set whether vertical drag-resize of portlets within columns is allowed, and update any drawn columns to reflect this.
     *
     * @param canResizeRows Whether drag-resize of portlets within columns is allowed. Default value is false
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @deprecated Use {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanResizePortlets canResizePortlets} instead.
     */
    public PortalLayout setCanResizeRows(Boolean canResizeRows) {
        return (PortalLayout)setAttribute("canResizeRows", canResizeRows, true);
    }

    /**
     * Should vertical drag-resize of portlets within columns be allowed?
     *
     * @return Current canResizeRows value. Default value is false
     * @deprecated Use {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanResizePortlets canResizePortlets} instead.
     */
    public Boolean getCanResizeRows()  {
        Boolean result = getAttributeAsBoolean("canResizeRows");
        return result == null ? false : result;
    }
    

    /**
     * Controls whether the PortalLayout will shrink column widths to avoid overflowing the PortalLayout  horizontally. If the
     * PortalLayout would otherwise overflow its width, it will check each column to see whether it is wider than necessary to
     * accommodate its {@link com.smartgwt.client.widgets.layout.Portlet Portlets}. If so, the column may shrink to avoid
     * having to scroll the PortalLayout.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths} and reflows to reflect the new setting.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canShrinkColumnWidths Whether columns can shrink to avoid overflowing the PortalLayout's width. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanStretchColumnWidths
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public PortalLayout setCanShrinkColumnWidths(Boolean canShrinkColumnWidths) {
        return (PortalLayout)setAttribute("canShrinkColumnWidths", canShrinkColumnWidths, true);
    }

    /**
     * Controls whether the PortalLayout will shrink column widths to avoid overflowing the PortalLayout  horizontally. If the
     * PortalLayout would otherwise overflow its width, it will check each column to see whether it is wider than necessary to
     * accommodate its {@link com.smartgwt.client.widgets.layout.Portlet Portlets}. If so, the column may shrink to avoid
     * having to scroll the PortalLayout.
     *
     * @return Current canShrinkColumnWidths value. Default value is true
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Boolean getCanShrinkColumnWidths()  {
        Boolean result = getAttributeAsBoolean("canShrinkColumnWidths");
        return result == null ? true : result;
    }
    

    /**
     * Controls whether the PortalLayout will stretch column widths, if needed to accommodate the width of {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets}. If set, columns will overflow their widths in order to accommodate
     * the widths of their Portlets. <p> With the default setting of {@link com.smartgwt.client.types.Overflow}: auto, the
     * PortalLayout as a whole will scroll  horizontally if needed. Depending on the setting of {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths},  other columns may
     * shrink to avoid overflow on the PortalLayout as a whole. <p> If <code>canStretchColumnWidths</code> is turned off, then
     * individual rows will scroll horizontally in order to accommodate Portlets that are wider than their column width allows.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths canStretchColumnWidths} and reflows to reflect the new setting.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param canStretchColumnWidths Whether columns can stretch to accommodate {@link com.smartgwt.client.widgets.layout.Portlet} widths. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanShrinkColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanResizePortlets
     * @see com.smartgwt.client.types.Overflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public PortalLayout setCanStretchColumnWidths(Boolean canStretchColumnWidths) {
        return (PortalLayout)setAttribute("canStretchColumnWidths", canStretchColumnWidths, true);
    }

    /**
     * Controls whether the PortalLayout will stretch column widths, if needed to accommodate the width of {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets}. If set, columns will overflow their widths in order to accommodate
     * the widths of their Portlets. <p> With the default setting of {@link com.smartgwt.client.types.Overflow}: auto, the
     * PortalLayout as a whole will scroll  horizontally if needed. Depending on the setting of {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths canShrinkColumnWidths},  other columns may
     * shrink to avoid overflow on the PortalLayout as a whole. <p> If <code>canStretchColumnWidths</code> is turned off, then
     * individual rows will scroll horizontally in order to accommodate Portlets that are wider than their column width allows.
     *
     * @return Current canStretchColumnWidths value. Default value is true
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanResizePortlets
     * @see com.smartgwt.client.types.Overflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Boolean getCanStretchColumnWidths()  {
        Boolean result = getAttributeAsBoolean("canStretchColumnWidths");
        return result == null ? true : result;
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * Automatically generated vertical {@link com.smartgwt.client.widgets.layout.Layout} used to create columns of {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets} via  createAutoChild(). Since this is an {@link
     * com.smartgwt.client.types.AutoChild}, you can use  columnDefaults and columnProperties to customize the columns. <p> The
     * column includes a menu, if {@link com.smartgwt.client.widgets.layout.PortalLayout#getShowColumnMenus showColumnMenus} is
     * true, and a {@link com.smartgwt.client.widgets.layout.PortalLayout#getRowLayout rowLayout} which actually contains the
     * {@link com.smartgwt.client.widgets.layout.PortalLayout#getRow rows}. Therefore, if you want to style the columns as a
     * whole, use columnDefaults or columnProperties, but if you want to style the layout that contains the rows, use
     * rowLayoutDefaults or rowLayoutProperties.
     *
     * @return null
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getRowLayout
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getRow
     */
    public Layout getColumn()  {
        return null;
    }
    

    /**
     * Border to show around columns in this PortalLayout
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the columnBorder for to the specified value and updates any drawn columns to reflect this.
     *
     * @param columnBorder New border to show around columns. Default value is "1px solid gray"
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     */
    public PortalLayout setColumnBorder(String columnBorder) {
        return (PortalLayout)setAttribute("columnBorder", columnBorder, true);
    }

    /**
     * Border to show around columns in this PortalLayout
     *
     * @return Current columnBorder value. Default value is "1px solid gray"
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
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.types.Overflow
     * @see com.smartgwt.client.widgets.Canvas#setOverflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public PortalLayout setColumnOverflow(Overflow columnOverflow) {
        return (PortalLayout)setAttribute("columnOverflow", columnOverflow == null ? null : columnOverflow.getValue(), true);
    }

    /**
     * Controls the {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow} setting for each column. If set to "auto"
     * (the default) then each column will scroll individually (if its {@link com.smartgwt.client.widgets.layout.Portlet
     * Portlets} overflow the column height). You can also use "hidden" to clip overflowing heights, or "visible" to show the
     * overflow. The effect of "visible" will depend on the setting for {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getOverflow overflow} -- by default, the PortalLayout as a whole will
     * scroll when necessary.
     *
     * @return Current columnOverflow value. Default value is "auto"
     * @see com.smartgwt.client.types.Overflow
     * @see com.smartgwt.client.widgets.Canvas#getOverflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Overflow getColumnOverflow()  {
        return EnumUtil.getEnum(Overflow.values(), getAttribute("columnOverflow"));
    }
    

    /**
     * The space between portal columns. <p> To set spacing between portlets on a row in the same column, see {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getPortletHSpacing portletHSpacing}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getColumnSpacing columnSpacing} and reflows the layout to implement it.
     *
     * @param columnSpacing The amount of space to apply between columns. Default value is 0
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setPortletHSpacing
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setPortletVSpacing
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public PortalLayout setColumnSpacing(Integer columnSpacing) {
        return (PortalLayout)setAttribute("columnSpacing", columnSpacing, true);
    }

    /**
     * The space between portal columns. <p> To set spacing between portlets on a row in the same column, see {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getPortletHSpacing portletHSpacing}.
     *
     * @return Current columnSpacing value. Default value is 0
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getPortletHSpacing
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getPortletVSpacing
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Integer getColumnSpacing()  {
        return getAttributeAsInt("columnSpacing");
    }
    

    /**
     * <code>dropTypes</code> is set to <code>["PortalColumn"]</code> in order to allow the dragging of columns within the
     * <code>PortalLayout</code>.  To control <code>dropTypes</code> when {@link com.smartgwt.client.widgets.layout.Portlet
     * Portlets} or other components are dragged into the <code>PortalLayout</code>, use {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getPortletDropTypes portletDropTypes} instead.
     *
     * @param dropTypes New dropTypes value. Default value is ["PortalColumn"]
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setPortletDropTypes
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public PortalLayout setDropTypes(String... dropTypes)  throws IllegalStateException {
        return (PortalLayout)setAttribute("dropTypes", dropTypes, false);
    }

    /**
     * <code>dropTypes</code> is set to <code>["PortalColumn"]</code> in order to allow the dragging of columns within the
     * <code>PortalLayout</code>.  To control <code>dropTypes</code> when {@link com.smartgwt.client.widgets.layout.Portlet
     * Portlets} or other components are dragged into the <code>PortalLayout</code>, use {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getPortletDropTypes portletDropTypes} instead.
     *
     * @return Current dropTypes value. Default value is ["PortalColumn"]
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getPortletDropTypes
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public String[] getDropTypes()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("dropTypes"));
    }
    

    /**
     * Initial number of columns to show in this PortalLayout. Note that after initialization columns should be added / removed
     * via {@link com.smartgwt.client.widgets.layout.PortalLayout#addColumn addColumn()} and {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#removeColumn removeColumn()}. numColumns is ignored if you initialize
     * the {@link com.smartgwt.client.widgets.layout.PortalLayout#getPortlets portlets} attribute, since the portlets attribute
     * will imply how many columns to create.
     *
     * @param numColumns New numColumns value. Default value is 2
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setPortlets
     */
    public PortalLayout setNumColumns(int numColumns)  throws IllegalStateException {
        return (PortalLayout)setAttribute("numColumns", numColumns, false);
    }

    /**
     * Initial number of columns to show in this PortalLayout. Note that after initialization columns should be added / removed
     * via {@link com.smartgwt.client.widgets.layout.PortalLayout#addColumn addColumn()} and {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#removeColumn removeColumn()}. numColumns is ignored if you initialize
     * the {@link com.smartgwt.client.widgets.layout.PortalLayout#getPortlets portlets} attribute, since the portlets attribute
     * will imply how many columns to create.
     *
     * @return Returns the current number of columns displayed in this PortalLayout. Default value is 2
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
     * @param overflow New overflow value. Default value is "auto"
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanResizePortlets
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setColumnOverflow
     * @see com.smartgwt.client.widgets.Canvas#setOverflow
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public PortalLayout setOverflow(Overflow overflow) {
        return (PortalLayout)setAttribute("overflow", overflow == null ? null : overflow.getValue(), true);
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
     * @return Current overflow value. Default value is "auto"
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
     * <p>The {@link com.smartgwt.client.widgets.Canvas#getDropTypes dropTypes} to be applied when dropping {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets} on this <code>PortalLayout</code>, or when dropping other
     * components to be auto-wrapped in a {@link com.smartgwt.client.widgets.layout.Portlet}. If you set this, then you will
     * need to set an equivalent {@link com.smartgwt.client.widgets.Canvas#getDragType Canvas.dragType} on anything to be
     * dragged into this <code>PortalLayout</code> (including {@link com.smartgwt.client.widgets.layout.Portlet Portlets}).</p>
     * <p>As a convenience, {@link com.smartgwt.client.widgets.layout.Portlet#getDragType Portlet.dragType} defaults to
     * <code>"Portlet"</code>. Thus, if you want  to allow {@link com.smartgwt.client.widgets.layout.Portlet Portlets} to be
     * dropped on this <code>PortalLayout</code>, but disable  auto-wrapping of other components, you can set
     * <code>portletDropTypes</code> to  <code>["Portlet"]</code>.</p> <p>If you want to allow some {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets} to be dropped on this <code>PortalLayout</code> but  not others,
     * then set a custom {@link com.smartgwt.client.widgets.layout.Portlet#getDragType dragType} for the {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets}, and  set <code>portletDropTypes</code> to match.</p> <p>If you
     * want to have different <code>dropTypes</code> for {@link com.smartgwt.client.widgets.layout.PortalLayout#getRow rows}
     * and  {@link com.smartgwt.client.widgets.layout.PortalLayout#getRowLayout rowLayouts}, you can specify
     * <code>dropType</code> on the {@link com.smartgwt.client.widgets.layout.PortalLayout#getRow row}  or {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getRowLayout rowLayout} autochildren instead.</p> <p>For more control
     * over what can be dropped, you can also implement  {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#willAcceptPortletDrop willAcceptPortletDrop()}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * <p>Sets the {@link com.smartgwt.client.widgets.layout.PortalLayout#getPortletDropTypes portletDropTypes} to be applied when dropping {@link com.smartgwt.client.widgets.layout.Portlet Portlets} on this <code>PortalLayout</code>, or when dropping other components to be auto-wrapped in a {@link com.smartgwt.client.widgets.layout.Portlet}.</p>
     *
     * @param portletDropTypes dropTypes to apply when dropping {@link com.smartgwt.client.widgets.layout.Portlet Portlets}. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Canvas#setDropTypes
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public PortalLayout setPortletDropTypes(String... portletDropTypes) {
        return (PortalLayout)setAttribute("portletDropTypes", portletDropTypes, true);
    }

    /**
     * <p>The {@link com.smartgwt.client.widgets.Canvas#getDropTypes dropTypes} to be applied when dropping {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets} on this <code>PortalLayout</code>, or when dropping other
     * components to be auto-wrapped in a {@link com.smartgwt.client.widgets.layout.Portlet}. If you set this, then you will
     * need to set an equivalent {@link com.smartgwt.client.widgets.Canvas#getDragType Canvas.dragType} on anything to be
     * dragged into this <code>PortalLayout</code> (including {@link com.smartgwt.client.widgets.layout.Portlet Portlets}).</p>
     * <p>As a convenience, {@link com.smartgwt.client.widgets.layout.Portlet#getDragType Portlet.dragType} defaults to
     * <code>"Portlet"</code>. Thus, if you want  to allow {@link com.smartgwt.client.widgets.layout.Portlet Portlets} to be
     * dropped on this <code>PortalLayout</code>, but disable  auto-wrapping of other components, you can set
     * <code>portletDropTypes</code> to  <code>["Portlet"]</code>.</p> <p>If you want to allow some {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets} to be dropped on this <code>PortalLayout</code> but  not others,
     * then set a custom {@link com.smartgwt.client.widgets.layout.Portlet#getDragType dragType} for the {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets}, and  set <code>portletDropTypes</code> to match.</p> <p>If you
     * want to have different <code>dropTypes</code> for {@link com.smartgwt.client.widgets.layout.PortalLayout#getRow rows}
     * and  {@link com.smartgwt.client.widgets.layout.PortalLayout#getRowLayout rowLayouts}, you can specify
     * <code>dropType</code> on the {@link com.smartgwt.client.widgets.layout.PortalLayout#getRow row}  or {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getRowLayout rowLayout} autochildren instead.</p> <p>For more control
     * over what can be dropped, you can also implement  {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#willAcceptPortletDrop willAcceptPortletDrop()}.
     *
     * @return Current portletDropTypes value. Default value is null
     * @see com.smartgwt.client.widgets.Canvas#getDropTypes
     * @see com.smartgwt.client.docs.Dragdrop Dragdrop overview and related methods
     */
    public String[] getPortletDropTypes()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("portletDropTypes"));
    }
    

    /**
     * The horizontal space between portlets placed into the same row. <p> To set the spacing between portal columns, use
     * {@link com.smartgwt.client.widgets.layout.PortalLayout#getColumnSpacing columnSpacing}.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getPortletHSpacing portletHSpacing} and reflows the layout to implement it.
     *
     * @param portletHSpacing The amount of space to apply between portlets in a row. Default value is 3
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setPortletVSpacing
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setColumnSpacing
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public PortalLayout setPortletHSpacing(Integer portletHSpacing) {
        return (PortalLayout)setAttribute("portletHSpacing", portletHSpacing, true);
    }

    /**
     * The horizontal space between portlets placed into the same row. <p> To set the spacing between portal columns, use
     * {@link com.smartgwt.client.widgets.layout.PortalLayout#getColumnSpacing columnSpacing}.
     *
     * @return Current portletHSpacing value. Default value is 3
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getPortletVSpacing
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getColumnSpacing
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Integer getPortletHSpacing()  {
        return getAttributeAsInt("portletHSpacing");
    }
    

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
     * @param portlets New portlets value. Default value is null
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getPortlets
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getPortletArray
     * @see com.smartgwt.client.widgets.layout.PortalLayout#addPortlet
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setNumColumns
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#repositioning_portal_layout_new" target="examples">Repositioning Example</a>
     */
    public PortalLayout setPortlets(Portlet... portlets)  throws IllegalStateException {
        return (PortalLayout)setAttribute("portlets", portlets, false);
    }
    

    /**
     * The vertical space between portal rows.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getPortletVSpacing portletVSpacing} and reflows the layout to implement it.
     *
     * @param portletVSpacing The amount of space to apply between rows. Default value is 3
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setPortletHSpacing
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public PortalLayout setPortletVSpacing(Integer portletVSpacing) {
        return (PortalLayout)setAttribute("portletVSpacing", portletVSpacing, true);
    }

    /**
     * The vertical space between portal rows.
     *
     * @return Current portletVSpacing value. Default value is 3
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getPortletHSpacing
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Integer getPortletVSpacing()  {
        return getAttributeAsInt("portletVSpacing");
    }
    

    /**
     * Controls whether the last {@link com.smartgwt.client.widgets.layout.Portlet} in a column will be stretched to fill the
     * column's height, or left at its specified height.
     *
     * @param preventColumnUnderflow New preventColumnUnderflow value. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public PortalLayout setPreventColumnUnderflow(Boolean preventColumnUnderflow) {
        return (PortalLayout)setAttribute("preventColumnUnderflow", preventColumnUnderflow, true);
    }

    /**
     * Controls whether the last {@link com.smartgwt.client.widgets.layout.Portlet} in a column will be stretched to fill the
     * column's height, or left at its specified height.
     *
     * @return Current preventColumnUnderflow value. Default value is true
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Boolean getPreventColumnUnderflow()  {
        Boolean result = getAttributeAsBoolean("preventColumnUnderflow");
        return result == null ? true : result;
    }
    

    /**
     * Controls whether the last {@link com.smartgwt.client.widgets.layout.Portlet} in a row will be stretched to fill the
     * row's width, or left at its specified width.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getPreventRowUnderflow preventRowUnderflow} and reflows the layout to implement it.
     *
     * @param preventRowUnderflow Whether to stretch the last {@link com.smartgwt.client.widgets.layout.Portlet} in a row to to fill the row's width. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public PortalLayout setPreventRowUnderflow(Boolean preventRowUnderflow) {
        return (PortalLayout)setAttribute("preventRowUnderflow", preventRowUnderflow, true);
    }

    /**
     * Controls whether the last {@link com.smartgwt.client.widgets.layout.Portlet} in a row will be stretched to fill the
     * row's width, or left at its specified width.
     *
     * @return Current preventRowUnderflow value. Default value is true
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Boolean getPreventRowUnderflow()  {
        Boolean result = getAttributeAsBoolean("preventRowUnderflow");
        return result == null ? true : result;
    }
    

    /**
     * Controls whether the last column will be stretched to fill the PortalLayout's width, or left at its specified width.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getPreventUnderflow preventUnderflow} and reflows the layout to implement it.
     *
     * @param preventUnderflow Whether to stretch the last column to fill the PortalLayout's width. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public PortalLayout setPreventUnderflow(Boolean preventUnderflow) {
        return (PortalLayout)setAttribute("preventUnderflow", preventUnderflow, true);
    }

    /**
     * Controls whether the last column will be stretched to fill the PortalLayout's width, or left at its specified width.
     *
     * @return Current preventUnderflow value. Default value is true
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public Boolean getPreventUnderflow()  {
        Boolean result = getAttributeAsBoolean("preventUnderflow");
        return result == null ? true : result;
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * Automatically generated horizontal {@link com.smartgwt.client.widgets.layout.Layout} used to create rows of {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets} via  createAutoChild(). Since this is an {@link
     * com.smartgwt.client.types.AutoChild}, you can use  rowDefaults and rowProperties to customize the rows. <p> Rows are
     * created inside {@link com.smartgwt.client.widgets.layout.PortalLayout#getRowLayout rowLayouts}, which in turn are inside
     * {@link com.smartgwt.client.widgets.layout.PortalLayout#getColumn columns}.
     *
     * @return null
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getColumn
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getRowLayout
     */
    public Layout getRow()  {
        return null;
    }
    

    /**
     * <b>Note :</b> This API is non-functional (always returns null) and exists only to make
     * you aware that this MultiAutoChild exists.  See {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}
     * for details.
     * <p>
     * Automatically generated vertical {@link com.smartgwt.client.widgets.layout.Layout} used to create columns of {@link
     * com.smartgwt.client.widgets.layout.Portlet Portlets} via  createAutoChild(). Since this is an {@link
     * com.smartgwt.client.types.AutoChild}, you can use  rowLayoutDefaults and rowLayoutProperties to customize the layout
     * used to contain the rows. <p> The rowLayout is the actual container for {@link
     * com.smartgwt.client.widgets.layout.PortalLayout#getRow rows} of {@link com.smartgwt.client.widgets.layout.Portlet
     * Portlets}. See {@link com.smartgwt.client.widgets.layout.PortalLayout#getColumn column} for the column as a whole, which
     * may include a menu as well (depending on {@link com.smartgwt.client.widgets.layout.PortalLayout#getShowColumnMenus
     * showColumnMenus}). If you want to style the columns as a whole, use columnDefaults or columnProperties, but if you want
     * to style the layout that actually contains the rows, use rowLayoutDefaults or rowLayoutProperties.
     *
     * @return null
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getRowLayout
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getRow
     */
    public Layout getRowLayout()  {
        return null;
    }
    

    /**
     * Should a menu be shown within each column with options to add / remove columns?
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getShowColumnMenus showColumnMenus} and updates existing columns to reflect the new setting.
     *
     * @param showColumnMenus Whether to show column menus. Default value is true
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#add_remove_columns_portal_layout_new" target="examples">Add/Remove Columns Example</a>
     */
    public PortalLayout setShowColumnMenus(Boolean showColumnMenus) {
        return (PortalLayout)setAttribute("showColumnMenus", showColumnMenus, true);
    }

    /**
     * Should a menu be shown within each column with options to add / remove columns?
     *
     * @return Current showColumnMenus value. Default value is true
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#add_remove_columns_portal_layout_new" target="examples">Add/Remove Columns Example</a>
     */
    public Boolean getShowColumnMenus()  {
        Boolean result = getAttributeAsBoolean("showColumnMenus");
        return result == null ? true : result;
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
     * @return {@link com.smartgwt.client.widgets.layout.PortalLayout PortalLayout} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanStretchColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#setCanShrinkColumnWidths
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public PortalLayout setStretchColumnWidthsProportionally(Boolean stretchColumnWidthsProportionally) {
        return (PortalLayout)setAttribute("stretchColumnWidthsProportionally", stretchColumnWidthsProportionally, true);
    }

    /**
     * When {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths stretching column widths}, should
     * we stretch all column widths proportionally, or just stretch the columns that need extra width? <p> Note that this
     * implies turning off {@link com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths
     * canShrinkColumnWidths}.
     *
     * @return Current stretchColumnWidthsProportionally value. Default value is false
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanStretchColumnWidths
     * @see com.smartgwt.client.widgets.layout.PortalLayout#getCanShrinkColumnWidths
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     */
    public Boolean getStretchColumnWidthsProportionally()  {
        Boolean result = getAttributeAsBoolean("stretchColumnWidthsProportionally");
        return result == null ? false : result;
    }
    

    // ********************* Methods ***********************
	/**
     * Adds a new portal column to this layout at the specified position
     * @param index target position for the new column
     */
    public native void addColumn(int index) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "addColumn", "int");
        }
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
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getColumnWidth", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getColumnWidth(colNumber);
        return ret;
    }-*/;

	/**
     * Gets the position of the {@link com.smartgwt.client.widgets.layout.Portlet} within this PortalLayout. Returns null if
     * the Portlet is not in this PortalLayout.
     * @param portlet the Portlet for which to get the position
     *
     * @return the position of the Portlet
     */
    public native PortalPosition getPortalPosition(Portlet portlet) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPortalPosition", "Portlet");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getPortalPosition(portlet == null ? null : portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.layout.PortalPosition::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Removes the specified column from this layout. All portlets displayed within this column will be destroyed when the
     * column is removed.
     * @param index column number to remove
     */
    public native void removeColumn(int index) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removeColumn", "int");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removeColumn(index);
    }-*/;

	/**
     * Removes a {@link com.smartgwt.client.widgets.layout.Portlet} which is currently rendered in this PortalLayout. Portlet
     * will not be destroyed by default - if this is desired the calling code should do this explicitly.
     * @param portlet portlet to remove
     */
    public native void removePortlet(Portlet portlet) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "removePortlet", "Portlet");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.removePortlet(portlet == null ? null : portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

	/**
     * Sets {@link com.smartgwt.client.widgets.layout.PortalLayout#getPreventColumnUnderflow preventColumnUnderflow} and
     * reflows the layout to implement it.
     * @param preventColumnUnderflow Whether to stretch the last {@link com.smartgwt.client.widgets.layout.Portlet} in a column to  fill the column's height.
     * @see com.smartgwt.client.docs.Sizing Sizing overview and related methods
     * 
     */
    public native void setColumnPreventUnderflow(boolean preventColumnUnderflow) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setColumnPreventUnderflow", "boolean");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setColumnPreventUnderflow(preventColumnUnderflow);
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
     * @param portalLayoutProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(PortalLayout portalLayoutProperties) /*-{
        if (portalLayoutProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(PortalLayout.@java.lang.Object::getClass()(), "setDefaultProperties", portalLayoutProperties.@java.lang.Object::getClass()());
        }
        portalLayoutProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = portalLayoutProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.PortalLayout.addProperties(properties);
    }-*/;

    // ***********************************************************



    public void onInit () {
        super.onInit();
        onInit_PortalLayout();
    }

    protected native void onInit_PortalLayout () /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();

        self.__willAcceptPortletDrop = self.willAcceptPortletDrop;
        self.willAcceptPortletDrop = $debox($entry(function(dragTarget, colNum, rowNum, dropPosition) {
            var jObj = this.__ref;
            if (jObj == null) return this.__willAcceptPortletDrop(dragTarget, colNum, rowNum, dropPosition);

            var dragTargetJ = dragTarget == null ? null : @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(dragTarget);
            var colNumJ = @java.lang.Integer::new(I)(colNum);
            var rowNumJ = @java.lang.Integer::new(I)(rowNum);
            var dropPositionJ = dropPosition == null ? null : @java.lang.Integer::new(I)(dropPosition);

            var retVal = jObj.@com.smartgwt.client.widgets.layout.PortalLayout::willAcceptPortletDrop(Lcom/smartgwt/client/widgets/Canvas;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)(dragTargetJ,colNumJ,rowNumJ,dropPositionJ);
            return retVal.@java.lang.Boolean::booleanValue()();
        }));

        self.__getDropPortlet = self.getDropPortlet;
        self.getDropPortlet = $entry(function(dragTarget, colNum, rowNum, dropPosition) {
            var jObj = this.__ref;

            if (jObj == null) return this.__getDropPortlet(dragTarget, rowNum,colNum,dropPosition);

            var dragTargetJ = @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(dragTarget);
            var colNumJ = @java.lang.Integer::new(I)(colNum);
            var rowNumJ = @java.lang.Integer::new(I)(rowNum);
            var dropPositionJ = dropPosition == null ? null : @java.lang.Integer::new(I)(dropPosition);
            var jPortlet = jObj.@com.smartgwt.client.widgets.layout.PortalLayout::getDropPortlet(Lcom/smartgwt/client/widgets/Canvas;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)(dragTargetJ,colNumJ,rowNumJ,dropPositionJ);
            if (jPortlet == null) return null;
            return jPortlet.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        });

        self.__willMaximizePortlet = self.willMaximizePortlet;
        self.willMaximizePortlet = $debox($entry(function(portlet) {
            var jObj = this.__ref;

            if (jObj == null) return this.__willMaximizePortlet ? this.__willMaximizePortlet(portlet) : true;

            var portletJ = @com.smartgwt.client.widgets.layout.Portlet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(portlet);
            return jObj.@com.smartgwt.client.widgets.layout.PortalLayout::willMaximizePortlet(Lcom/smartgwt/client/widgets/layout/Portlet;)(portletJ);
        }));
        
        self.__willMinimizePortlet = self.willMinimizePortlet;
        self.willMinimizePortlet = $debox($entry(function(portlet) {
            var jObj = this.__ref;

            if (jObj == null) return this.__willMinimizePortlet ? this.__willMinimizePortlet(portlet) : true;

            var portletJ = @com.smartgwt.client.widgets.layout.Portlet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(portlet);
            return jObj.@com.smartgwt.client.widgets.layout.PortalLayout::willMinimizePortlet(Lcom/smartgwt/client/widgets/layout/Portlet;)(portletJ);
        }));
        
        self.__willRestorePortlet = self.willRestorePortlet;
        self.willRestorePortlet = $debox($entry(function(portlet) {
            var jObj = this.__ref;

            if (jObj == null) return this.__willRestorePortlet ? this.__willRestorePortlet(portlet) : true;

            var portletJ = @com.smartgwt.client.widgets.layout.Portlet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(portlet);
            return jObj.@com.smartgwt.client.widgets.layout.PortalLayout::willRestorePortlet(Lcom/smartgwt/client/widgets/layout/Portlet;)(portletJ);
        }));
        
        self.__willClosePortlet = self.willClosePortlet;
        self.willClosePortlet = $debox($entry(function(portlet) {
            var jObj = this.__ref;

            if (jObj == null) return this.__willClosePortlet ? this.__willClosePortlet(portlet) : true;

            var portletJ = @com.smartgwt.client.widgets.layout.Portlet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(portlet);
            return jObj.@com.smartgwt.client.widgets.layout.PortalLayout::willClosePortlet(Lcom/smartgwt/client/widgets/layout/Portlet;)(portletJ);
        }));
        
        self.__portletMaximized = self.portletMaximized;
        self.portletMaximized = $entry(function(portlet) {
            var jObj = this.__ref;

            if (jObj == null) {
                if (this.__portletMaximized) this.__portletMaximized(portlet);
            } else {
                var portletJ = @com.smartgwt.client.widgets.layout.Portlet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(portlet);
                jObj.@com.smartgwt.client.widgets.layout.PortalLayout::portletMaximized(Lcom/smartgwt/client/widgets/layout/Portlet;)(portletJ);
            }
        });
        
        self.__portletMinimized = self.portletMinimized;
        self.portletMinimized = $entry(function(portlet) {
            var jObj = this.__ref;

            if (jObj == null) {
                if (this.__portletMinimized) this.__portletMinimized(portlet);
            } else {
                var portletJ = @com.smartgwt.client.widgets.layout.Portlet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(portlet);
                jObj.@com.smartgwt.client.widgets.layout.PortalLayout::portletMinimized(Lcom/smartgwt/client/widgets/layout/Portlet;)(portletJ);
            }
        });
        
        self.__portletRestored = self.portletRestored;
        self.portletRestored = $entry(function(portlet) {
            var jObj = this.__ref;

            if (jObj == null) {
                if (this.__portletRestored) this.__portletRestored(portlet);
            } else {
                var portletJ = @com.smartgwt.client.widgets.layout.Portlet::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(portlet);
                jObj.@com.smartgwt.client.widgets.layout.PortalLayout::portletRestored(Lcom/smartgwt/client/widgets/layout/Portlet;)(portletJ);
            }
        });
        
        self.__portletsChanged = self.portletsChanged;
        self.portletsChanged = $entry(function() {
            var jObj = this.__ref;

            if (jObj == null) {
                if (this.__portletsChanged) this.__portletsChanged();
            } else {
                jObj.@com.smartgwt.client.widgets.layout.PortalLayout::portletsChanged()();
            }
        });
        
        self.__portletsResized = self.portletsResized;
        self.portletsResized = $entry(function() {
            var jObj = this.__ref;

            if (jObj == null) {
                if (this.__portletsResized) this.__portletsResized();
            } else {
                jObj.@com.smartgwt.client.widgets.layout.PortalLayout::portletsResized()();
            }
        });
    }-*/;

    /** <p>Returns true if the dragged {@link com.smartgwt.client.widgets.layout.Portlet}, or other component, can be dropped onto
     * this <code>PortalLayout</code> (other components would be auto-wrapped in a <code>Portlet</code>).</p>
     *
     * <p>The default implementation acts like {@link com.smartgwt.client.widgets.Canvas#willAcceptDrop}, except applying
     * {@link com.smartgwt.client.widgets.layout.PortalLayout#getPortletDropTypes portletDropTypes} rather than
     * {@link com.smartgwt.client.widgets.layout.PortalLayout#getDropTypes dropTypes}.
     * You can subclass to apply other (or additional) criteria</p>
     *
     * <p><b>Note: This is an override point</b></p>
     *
     * @param dragTarget The {@link com.smartgwt.client.widgets.layout.Portlet}, or other component, being dragged
     * @param colNum indicates which column the portlet would be dropped on.
     * @param rowNum indicates the row number being dropped on.
     * @param dropPosition Drop position within an existing row. If the dropPosition is null, then that means that a new row will be created.
     * @return	true if the {@link com.smartgwt.client.widgets.layout.Portlet} or other component being dragged can be dropped on this PortalLayout, false otherwise
     */
    public native Boolean willAcceptPortletDrop(Canvas dragTarget, Integer colNum, Integer rowNum, Integer dropPosition) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var dragTargetJS = dragTarget.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var colNumJS = colNum.@java.lang.Integer::intValue()();
        var rowNumJS = rowNum.@java.lang.Integer::intValue()();
        var dropPositionJS = dropPosition == null ? null : dropPosition.@java.lang.Integer::intValue()();

        var retVal = self.__willAcceptPortletDrop(dragTargetJS, colNumJS, rowNumJS, dropPositionJS);
        if (retVal == null) {
            return null;
        } else {
            return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(retVal);
        }
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
        var colNumJS = colNum.@java.lang.Integer::intValue()();
        var rowNumJS = rowNum.@java.lang.Integer::intValue()();
        var dropPositionJS = dropPosition == null ? null : dropPosition.@java.lang.Integer::intValue()();

        var ret = self.__getDropPortlet(dragTargetJS, colNumJS, rowNumJS, dropPositionJS);
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.Canvas::getByJSObject(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

    /**
     * Returns a flat array of all the {@link com.smartgwt.client.widgets.layout.Portlet Portlets} in this PortalLayout.
     *
     * @return portlets
     */
    public native Portlet[] getPortlets() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var portletsJS = self.getPortlets();
        return @com.smartgwt.client.util.ConvertTo::arrayOfPortlet(Lcom/google/gwt/core/client/JavaScriptObject;)(portletsJS);
    }-*/;

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

    /** 
     * Method called when a {@link com.smartgwt.client.widgets.layout.Portlet} 
     * in this PortalLayout is about to be maximized. Note that this method is
     * only called when the user explicitly clicks on the portlet's
     * {@link com.smartgwt.client.widgets.Window#getShowMaximizeButton() maximize button} 
     * -- it is not called when programmatically maximizing a portlet via
     * {@link com.smartgwt.client.widgets.layout.Portlet#maximize()}.
     * <p>
     * Return false to cancel the action.
     * <p>
     * <b>Note: This is an override point</b>
     * 
     * @param portlet the Portlet which will be maximized
     * @return whether the action should proceed
     */
    public native boolean willMaximizePortlet (Portlet portlet) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var portletJS = portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();

        var retVal = self.__willMaximizePortlet ? self.__willMaximizePortlet(portletJS) : true;
        return retVal === false ? false : true;
    }-*/;
    
    /** 
     * Method called when a {@link com.smartgwt.client.widgets.layout.Portlet} 
     * in this PortalLayout is about to be minimized. Note that this method is
     * only called when the user explicitly clicks on the portlet's
     * {@link com.smartgwt.client.widgets.Window#getShowMinimizeButton() minimize button} 
     * -- it is not called when programmatically minimizing a portlet via
     * {@link com.smartgwt.client.widgets.layout.Portlet#minimize()}.
     * <p>
     * Return false to cancel the action.
     * <p>
     * <b>Note: This is an override point</b>
     * 
     * @param portlet the Portlet which will be minimized
     * @return whether the action should proceed
     */
    public native boolean willMinimizePortlet (Portlet portlet) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var portletJS = portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();

        var retVal = self.__willMinimizePortlet ? self.__willMinimizePortlet(portletJS) : true;
        return retVal === false ? false : true;
    }-*/;
    
    /** 
     * Method called when a {@link com.smartgwt.client.widgets.layout.Portlet} 
     * in this PortalLayout is about to be restored to its normal place (after having been
     * {@link com.smartgwt.client.widgets.layout.Portlet#maximize() maximized}. 
     * Note that this method is
     * only called when the user explicitly clicks on the portlet's "restore" button
     * -- it is not called when programmatically restoring a portlet via
     * {@link com.smartgwt.client.widgets.Window#restore() restore()}.
     * <p>
     * Return false to cancel the action.
     * <p>
     * <b>Note: This is an override point</b>
     * 
     * @param portlet the Portlet which will be restored
     * @return whether the action should proceed
     */
    public native boolean willRestorePortlet (Portlet portlet) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var portletJS = portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();

        var retVal = self.__willRestorePortlet ? self.__willRestorePortlet(portletJS) : true;
        return retVal === false ? false : true;
    }-*/;
    
    /** 
     * Method called when a {@link com.smartgwt.client.widgets.layout.Portlet} 
     * in this PortalLayout is about to be closed. 
     * Note that this method is
     * only called when the user explicitly clicks on the portlet's "close" button
     * -- it is not called when programmatically removing a portlet via
     * {@link com.smartgwt.client.widgets.layout.PortalLayout#removePortlet(com.smartgwt.client.widgets.layout.Portlet) removePortlet()}.
     * <p>
     * Return false to cancel the action.
     * <p>
     * <b>Note: This is an override point</b>
     * 
     * @param portlet the Portlet which will be closed
     * @return whether the action should proceed
     */
    public native boolean willClosePortlet (Portlet portlet) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var portletJS = portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();

        var retVal = self.__willClosePortlet ? self.__willClosePortlet(portletJS) : true;
        return retVal === false ? false : true;
    }-*/;
    
    /**
     * Notification method called after a {@link Portlet} has been maximized (whether by
     * user action or programmatically).
     * <p>
     * <b>Note: This is an override point</b>
     * 
     * @param portlet The portlet which was maximized
     * @see #willMaximizePortlet
     */
    public native void portletMaximized (Portlet portlet) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var portletJS = portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if (self.__portletMaximized) self.__portletMaximized(portletJS);
    }-*/;
    
    /**
     * Notification method called after a {@link Portlet} has been minimized (whether by
     * user action or programmatically).
     * <p>
     * <b>Note: This is an override point</b>
     * 
     * @param portlet The portlet which was minimized
     * @see #willMinimizePortlet
     */
    public native void portletMinimized (Portlet portlet) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var portletJS = portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if (self.__portletMinimized) self.__portletMinimized(portletJS);
    }-*/;
    
    /**
     * Notification method called after a {@link Portlet} has been restored to its normal place
     * (after having been maximized). The method is called whether the restore is
     * via user action or done programmatically.
     * <p>
     * <b>Note: This is an override point</b>
     *
     * @param portlet The portlet which was restored.
     * @see #willRestorePortlet
     */
    public native void portletRestored (Portlet portlet) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var portletJS = portlet.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if (self.__portletRestored) self.__portletRestored(portletJS);
    }-*/;
    
    /**
     * Fires at initialization if the PortalLayout has any initial
     * {@link Portlet portlets}, and then fires whenever portlets are added,
     * removed or reordered.
     * <p>
     * <b>Note: This is an override point</b>
     *
     * @see com.smartgwt.client.widgets.layout.Layout#membersChanged
     */
    public native void portletsChanged () /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if (self.__portletsChanged) self.__portletsChanged();
    }-*/;
    
    /**
     * Fires when {@link Portlet portlets} or columns in this PortalLayout are
     * resized.  Note that this fires on a short delay -- otherwise, it would
     * fire multiple times for each change, since most portlet size changes
     * will affect multiple portlets.  Does not fire when a portlet is 
     * {@link #portletMaximized(com.smartgwt.client.widgets.layout.Portlet) maximized}
     * or {@link #portletRestored(com.smartgwt.client.widgets.layout.Portlet) restored}.
     * <p>
     * <b>Note: This is an override point</b>
     */
    public native void portletsResized () /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        if (self.__portletsResized) self.__portletsResized();
    }-*/;

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(PortalLayoutLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.canResizeColumns = getAttributeAsString("canResizeColumns");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.canResizeColumns:" + t.getMessage() + "\n";
        }
        try {
            s.canResizePortlets = getAttributeAsString("canResizePortlets");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.canResizePortlets:" + t.getMessage() + "\n";
        }
        try {
            s.canResizeRows = getAttributeAsString("canResizeRows");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.canResizeRows:" + t.getMessage() + "\n";
        }
        try {
            s.canShrinkColumnWidths = getAttributeAsString("canShrinkColumnWidths");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.canShrinkColumnWidths:" + t.getMessage() + "\n";
        }
        try {
            s.canStretchColumnWidths = getAttributeAsString("canStretchColumnWidths");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.canStretchColumnWidths:" + t.getMessage() + "\n";
        }
        try {
            s.columnBorder = getAttributeAsString("columnBorder");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.columnBorder:" + t.getMessage() + "\n";
        }
        try {
            s.columnOverflow = getAttributeAsString("columnOverflow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.columnOverflow:" + t.getMessage() + "\n";
        }
        try {
            s.columnSpacing = getAttributeAsString("columnSpacing");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.columnSpacing:" + t.getMessage() + "\n";
        }
        try {
            s.dropTypes = getAttributeAsStringArray("dropTypes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.dropTypesArray:" + t.getMessage() + "\n";
        }
        try {
            s.numColumns = getAttributeAsString("numColumns");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.numColumns:" + t.getMessage() + "\n";
        }
        try {
            s.overflow = getAttributeAsString("overflow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.overflow:" + t.getMessage() + "\n";
        }
        try {
            s.portletDropTypes = getAttributeAsStringArray("portletDropTypes");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.portletDropTypesArray:" + t.getMessage() + "\n";
        }
        try {
            s.portletHSpacing = getAttributeAsString("portletHSpacing");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.portletHSpacing:" + t.getMessage() + "\n";
        }
        try {
            s.portletVSpacing = getAttributeAsString("portletVSpacing");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.portletVSpacing:" + t.getMessage() + "\n";
        }
        try {
            s.preventColumnUnderflow = getAttributeAsString("preventColumnUnderflow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.preventColumnUnderflow:" + t.getMessage() + "\n";
        }
        try {
            s.preventRowUnderflow = getAttributeAsString("preventRowUnderflow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.preventRowUnderflow:" + t.getMessage() + "\n";
        }
        try {
            s.preventUnderflow = getAttributeAsString("preventUnderflow");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.preventUnderflow:" + t.getMessage() + "\n";
        }
        try {
            s.showColumnMenus = getAttributeAsString("showColumnMenus");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.showColumnMenus:" + t.getMessage() + "\n";
        }
        try {
            s.stretchColumnWidthsProportionally = getAttributeAsString("stretchColumnWidthsProportionally");
        } catch (Throwable t) {
            s.logicalStructureErrors += "PortalLayout.stretchColumnWidthsProportionally:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        PortalLayoutLogicalStructure s = new PortalLayoutLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
