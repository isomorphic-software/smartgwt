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
 * Simple interactive calendar interface used to pick a date. Used by the {@link
 * com.smartgwt.client.widgets.form.fields.DateItem} class.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("DateChooser")
public class DateChooser extends VLayout implements com.smartgwt.client.widgets.events.HasDataChangedHandlers {

    public static DateChooser getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new DateChooser(jsObj);
        } else {
            assert refInstance instanceof DateChooser;
            return (DateChooser)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DateChooser.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.DateChooser.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(DateChooser.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.DateChooser.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public DateChooser(){
        scClassName = "DateChooser";
    }

    public DateChooser(JavaScriptObject jsObj){
        scClassName = "DateChooser";
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
     * The text appended to the style name when using {@link com.smartgwt.client.widgets.DateChooser#getAlternateWeekStyles
     * alternateWeekStyles}.
     *
     * @param alternateStyleSuffix New alternateStyleSuffix value. Default value is "Dark"
     */
    public void setAlternateStyleSuffix(String alternateStyleSuffix) {
        setAttribute("alternateStyleSuffix", alternateStyleSuffix, true);
    }

    /**
     * The text appended to the style name when using {@link com.smartgwt.client.widgets.DateChooser#getAlternateWeekStyles
     * alternateWeekStyles}.
     *
     * @return Current alternateStyleSuffix value. Default value is "Dark"
     */
    public String getAlternateStyleSuffix()  {
        return getAttributeAsString("alternateStyleSuffix");
    }
    

    /**
     * Whether alternating weeks should be drawn in alternating styles. If enabled, the cell style for alternate rows will have
     * {@link com.smartgwt.client.widgets.DateChooser#getAlternateStyleSuffix alternateStyleSuffix} appended to it.
     *
     * @param alternateWeekStyles New alternateWeekStyles value. Default value is null
     */
    public void setAlternateWeekStyles(Boolean alternateWeekStyles) {
        setAttribute("alternateWeekStyles", alternateWeekStyles, true);
    }

    /**
     * Whether alternating weeks should be drawn in alternating styles. If enabled, the cell style for alternate rows will have
     * {@link com.smartgwt.client.widgets.DateChooser#getAlternateStyleSuffix alternateStyleSuffix} appended to it.
     *
     * @return Current alternateWeekStyles value. Default value is null
     */
    public Boolean getAlternateWeekStyles()  {
        return getAttributeAsBoolean("alternateWeekStyles");
    }
    

    /**
     * When a DateChooser is configured for {@link com.smartgwt.client.widgets.DateChooser#getTimeItem a "datetime" value},
     * clicking on a date cell in the {@link com.smartgwt.client.widgets.DateChooser#getDateGrid grid} will not automatically
     * dismiss the DateChooser canvas.  In this case, use the <code>Apply</code> button to accept the selected date and time
     * and dismiss the chooser.
     * <p>
     * This component is an AutoChild named "applyButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current applyButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getApplyButton() throws IllegalStateException {
        errorIfNotCreated("applyButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("applyButton"));
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getApplyButton Apply} button.
     *
     * @param applyButtonTitle New applyButtonTitle value. Default value is "Apply"
     */
    public void setApplyButtonTitle(String applyButtonTitle) {
        setAttribute("applyButtonTitle", applyButtonTitle, true);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getApplyButton Apply} button.
     *
     * @return Current applyButtonTitle value. Default value is "Apply"
     */
    public String getApplyButtonTitle()  {
        return getAttributeAsString("applyButtonTitle");
    }
    

    /**
     * CSS style to apply to the buttons at the bottom of the DateChooser ("Today" and "Cancel").  If null, the CSS style
     * specified in {@link com.smartgwt.client.widgets.DateChooser#getBaseButtonStyle baseButtonStyle} is used.
     *
     * @param baseBottomButtonStyle New baseBottomButtonStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setBaseBottomButtonStyle(String baseBottomButtonStyle) {
        setAttribute("baseBottomButtonStyle", baseBottomButtonStyle, true);
    }

    /**
     * CSS style to apply to the buttons at the bottom of the DateChooser ("Today" and "Cancel").  If null, the CSS style
     * specified in {@link com.smartgwt.client.widgets.DateChooser#getBaseButtonStyle baseButtonStyle} is used.
     *
     * @return Current baseBottomButtonStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseBottomButtonStyle()  {
        return getAttributeAsString("baseBottomButtonStyle");
    }
    

    /**
     * Base CSS style applied to this picker's buttons. Will have "Over", "Selected" and "Down" suffix appended as the user
     * interacts with buttons. <P> See {@link com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes
     * are combined with the base style to generate stateful cell styles in Grids.
     *
     * @param baseButtonStyle New baseButtonStyle value. Default value is "dateChooserButton"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setBaseButtonStyle(String baseButtonStyle) {
        setAttribute("baseButtonStyle", baseButtonStyle, true);
    }

    /**
     * Base CSS style applied to this picker's buttons. Will have "Over", "Selected" and "Down" suffix appended as the user
     * interacts with buttons. <P> See {@link com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes
     * are combined with the base style to generate stateful cell styles in Grids.
     *
     * @return Current baseButtonStyle value. Default value is "dateChooserButton"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseButtonStyle()  {
        return getAttributeAsString("baseButtonStyle");
    }
    

    /**
     * Base CSS style applied to cells in the {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser fiscal
     * year column}. <P> See {@link com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are
     * combined with the base style to generate stateful cell styles in Grids.
     *
     * @param baseFiscalYearStyle New baseFiscalYearStyle value. Default value is "dateChooserFiscalYearCell"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setBaseFiscalYearStyle(String baseFiscalYearStyle) {
        setAttribute("baseFiscalYearStyle", baseFiscalYearStyle, true);
    }

    /**
     * Base CSS style applied to cells in the {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser fiscal
     * year column}. <P> See {@link com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are
     * combined with the base style to generate stateful cell styles in Grids.
     *
     * @return Current baseFiscalYearStyle value. Default value is "dateChooserFiscalYearCell"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseFiscalYearStyle()  {
        return getAttributeAsString("baseFiscalYearStyle");
    }
    

    /**
     * CSS style to apply to navigation buttons and date display at the top of the component. If null, the CSS style specified
     * in {@link com.smartgwt.client.widgets.DateChooser#getBaseButtonStyle baseButtonStyle} is used.
     *
     * @param baseNavButtonStyle New baseNavButtonStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setBaseNavButtonStyle(String baseNavButtonStyle) {
        setAttribute("baseNavButtonStyle", baseNavButtonStyle, true);
    }

    /**
     * CSS style to apply to navigation buttons and date display at the top of the component. If null, the CSS style specified
     * in {@link com.smartgwt.client.widgets.DateChooser#getBaseButtonStyle baseButtonStyle} is used.
     *
     * @return Current baseNavButtonStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseNavButtonStyle()  {
        return getAttributeAsString("baseNavButtonStyle");
    }
    

    /**
     * Base CSS style applied to weekdays. Will have "Over", "Selected" and "Down" suffix appended as the user interacts with
     * buttons.  Defaults to {@link com.smartgwt.client.widgets.DateChooser#getBaseButtonStyle baseButtonStyle}. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles in Grids.
     *
     * @param baseWeekdayStyle New baseWeekdayStyle value. Default value is "dateChooserWeekday"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setBaseWeekdayStyle(String baseWeekdayStyle) {
        setAttribute("baseWeekdayStyle", baseWeekdayStyle, true);
    }

    /**
     * Base CSS style applied to weekdays. Will have "Over", "Selected" and "Down" suffix appended as the user interacts with
     * buttons.  Defaults to {@link com.smartgwt.client.widgets.DateChooser#getBaseButtonStyle baseButtonStyle}. <P> See {@link
     * com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style to
     * generate stateful cell styles in Grids.
     *
     * @return Current baseWeekdayStyle value. Default value is "dateChooserWeekday"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseWeekdayStyle()  {
        return getAttributeAsString("baseWeekdayStyle");
    }
    

    /**
     * Base CSS style applied to weekends. Will have "Over", "Selected" and "Down" suffix appended as the user interacts with
     * buttons.  Defaults to {@link com.smartgwt.client.widgets.DateChooser#getBaseWeekdayStyle baseWeekdayStyle}. <P> See
     * {@link com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style
     * to generate stateful cell styles in Grids.
     *
     * @param baseWeekendStyle New baseWeekendStyle value. Default value is "dateChooserWeekend"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setBaseWeekendStyle(String baseWeekendStyle) {
        setAttribute("baseWeekendStyle", baseWeekendStyle, true);
    }

    /**
     * Base CSS style applied to weekends. Will have "Over", "Selected" and "Down" suffix appended as the user interacts with
     * buttons.  Defaults to {@link com.smartgwt.client.widgets.DateChooser#getBaseWeekdayStyle baseWeekdayStyle}. <P> See
     * {@link com.smartgwt.client.docs.CellStyleSuffixes} for details on how stateful suffixes are combined with the base style
     * to generate stateful cell styles in Grids.
     *
     * @return Current baseWeekendStyle value. Default value is "dateChooserWeekend"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseWeekendStyle()  {
        return getAttributeAsString("baseWeekendStyle");
    }
    

    /**
     * Base CSS style applied to cells in the {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser fiscal week
     * column}.
     *
     * @param baseWeekStyle New baseWeekStyle value. Default value is "dateChooserWeekCell"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setBaseWeekStyle(String baseWeekStyle) {
        setAttribute("baseWeekStyle", baseWeekStyle, true);
    }

    /**
     * Base CSS style applied to cells in the {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser fiscal week
     * column}.
     *
     * @return Current baseWeekStyle value. Default value is "dateChooserWeekCell"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getBaseWeekStyle()  {
        return getAttributeAsString("baseWeekStyle");
    }
    

    /**
     * An {@link com.smartgwt.client.types.AutoChild} {@link com.smartgwt.client.widgets.layout.HLayout}, rendered below the
     * {@link com.smartgwt.client.widgets.grid.DateGrid date grid}, and showing the {@link
     * com.smartgwt.client.widgets.DateChooser#getTodayButton Today}, {@link
     * com.smartgwt.client.widgets.DateChooser#getCancelButton Cancel} and, when working with "datetime" values,  {@link
     * com.smartgwt.client.widgets.DateChooser#getApplyButton Apply} buttons.
     * <p>
     * This component is an AutoChild named "buttonLayout".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current buttonLayout value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public HLayout getButtonLayout() throws IllegalStateException {
        errorIfNotCreated("buttonLayout");
        return (HLayout)HLayout.getByJSObject(getAttributeAsJavaScriptObject("buttonLayout"));
    }
    

    /**
     * Array of members to show in the {@link com.smartgwt.client.widgets.DateChooser#getButtonLayout buttonLayout}.
     *  <P>
     *  The default value of <code>buttonLayoutControls</code> is an Array of Strings listing 
     *  the standard buttons in their default order:
     *  <pre>
     *     buttonLayoutControls : ["todayButton", "cancelButton", "applyButton"]
     *  </pre>
     *  You can override <code>buttonLayoutControls</code> to change the order of the standard 
     *  buttons.  You can also omit standard buttons this way, although it's more efficient to
     * use the related "show" property if available (eg {@link com.smartgwt.client.widgets.DateChooser#getShowTodayButton
     * showTodayButton}).  
     *  <P>
     *  By embedding a Canvas directly in this list you can add arbitrary additional controls to
     *  the buttonLayout.  
     *  <P>
     *  Note that having added controls to buttonLayoutControls, you can still call APIs directly on
     *  those controls to change their appearance, and you can also show() and hide() them if
     *  they should not be shown in some circumstances.
     *  <P>
     *  Tip: custom controls need to set layoutAlign:"center" to appear vertically centered.
     *
     * @param buttonLayoutControls New buttonLayoutControls value. Default value is (see below)
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setButtonLayoutControls(String... buttonLayoutControls)  throws IllegalStateException {
        setAttribute("buttonLayoutControls", buttonLayoutControls, false);
    }

    /**
     * Array of members to show in the {@link com.smartgwt.client.widgets.DateChooser#getButtonLayout buttonLayout}.
     *  <P>
     *  The default value of <code>buttonLayoutControls</code> is an Array of Strings listing 
     *  the standard buttons in their default order:
     *  <pre>
     *     buttonLayoutControls : ["todayButton", "cancelButton", "applyButton"]
     *  </pre>
     *  You can override <code>buttonLayoutControls</code> to change the order of the standard 
     *  buttons.  You can also omit standard buttons this way, although it's more efficient to
     * use the related "show" property if available (eg {@link com.smartgwt.client.widgets.DateChooser#getShowTodayButton
     * showTodayButton}).  
     *  <P>
     *  By embedding a Canvas directly in this list you can add arbitrary additional controls to
     *  the buttonLayout.  
     *  <P>
     *  Note that having added controls to buttonLayoutControls, you can still call APIs directly on
     *  those controls to change their appearance, and you can also show() and hide() them if
     *  they should not be shown in some circumstances.
     *  <P>
     *  Tip: custom controls need to set layoutAlign:"center" to appear vertically centered.
     *
     * @return Current buttonLayoutControls value. Default value is (see below)
     */
    public String[] getButtonLayoutControls()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfString(getAttributeAsJavaScriptObject("buttonLayoutControls"));
    }
    

    /**
     * A button shown below the {@link com.smartgwt.client.widgets.grid.DateGrid calendar grid} which, when clicked,  closes
     * the DateChooser without selecting a value.
     * <p>
     * This component is an AutoChild named "cancelButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current cancelButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCancelButton() throws IllegalStateException {
        errorIfNotCreated("cancelButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("cancelButton"));
    }
    

    /**
     * Title for the cancellation button.
     *
     * @param cancelButtonTitle New cancelButtonTitle value. Default value is "Cancel"
     */
    public void setCancelButtonTitle(String cancelButtonTitle) {
        setAttribute("cancelButtonTitle", cancelButtonTitle, true);
    }

    /**
     * Title for the cancellation button.
     *
     * @return Current cancelButtonTitle value. Default value is "Cancel"
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * When editing a "date" value, with no time portion, clicking on a date-cell selects the  date and closes the DateChooser.
     * When a {@link com.smartgwt.client.widgets.DateChooser#getShowTimeItem time portion}  is required, however, the {@link
     * com.smartgwt.client.widgets.DateChooser#getApplyButton apply button} must be clicked to close the chooser, by default.
     * <P> Set this attribute to true to have the DateChooser close when a user clicks in a  date-cell, even if the {@link
     * com.smartgwt.client.widgets.DateChooser#getTimeItem timeItem} is showing.
     *
     * @param closeOnDateClick New closeOnDateClick value. Default value is null
     */
    public void setCloseOnDateClick(Boolean closeOnDateClick) {
        setAttribute("closeOnDateClick", closeOnDateClick, true);
    }

    /**
     * When editing a "date" value, with no time portion, clicking on a date-cell selects the  date and closes the DateChooser.
     * When a {@link com.smartgwt.client.widgets.DateChooser#getShowTimeItem time portion}  is required, however, the {@link
     * com.smartgwt.client.widgets.DateChooser#getApplyButton apply button} must be clicked to close the chooser, by default.
     * <P> Set this attribute to true to have the DateChooser close when a user clicks in a  date-cell, even if the {@link
     * com.smartgwt.client.widgets.DateChooser#getTimeItem timeItem} is showing.
     *
     * @return Current closeOnDateClick value. Default value is null
     */
    public Boolean getCloseOnDateClick()  {
        return getAttributeAsBoolean("closeOnDateClick");
    }
    

    /**
     * Should this dateChooser be dismissed if the user presses the Escape key?
     *
     * @param closeOnEscapeKeypress New closeOnEscapeKeypress value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCloseOnEscapeKeypress(boolean closeOnEscapeKeypress)  throws IllegalStateException {
        setAttribute("closeOnEscapeKeypress", closeOnEscapeKeypress, false);
    }

    /**
     * Should this dateChooser be dismissed if the user presses the Escape key?
     *
     * @return Current closeOnEscapeKeypress value. Default value is false
     */
    public boolean getCloseOnEscapeKeypress()  {
        Boolean result = getAttributeAsBoolean("closeOnEscapeKeypress");
        return result == null ? false : result;
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.grid.ListGrid} subclass, responsible for rendering the calendar view.
     * <p>
     * This component is an AutoChild named "dateGrid".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current dateGrid value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DateGrid getDateGrid() throws IllegalStateException {
        errorIfNotCreated("dateGrid");
        return (DateGrid)DateGrid.getByJSObject(getAttributeAsJavaScriptObject("dateGrid"));
    }
    

    /**
     * How long (how many characters) should be day names be. May be 1, 2 or 3 characters.
     *
     * @param dayNameLength New dayNameLength value. Default value is 2
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDayNameLength(int dayNameLength)  throws IllegalStateException {
        setAttribute("dayNameLength", dayNameLength, false);
    }

    /**
     * How long (how many characters) should be day names be. May be 1, 2 or 3 characters.
     *
     * @return Current dayNameLength value. Default value is 2
     */
    public int getDayNameLength()  {
        return getAttributeAsInt("dayNameLength");
    }
    

    /**
     * An array of Date instances that should be disabled if they appear in the calendar view.
     *
     * @param disabledDates New disabledDates value. Default value is null
     */
    public void setDisabledDates(Date... disabledDates) {
        setAttribute("disabledDates", disabledDates, true);
    }

    /**
     * An array of Date instances that should be disabled if they appear in the calendar view.
     *
     * @return Current disabledDates value. Default value is null
     */
    public Date[] getDisabledDates()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfDate(getAttributeAsJavaScriptObject("disabledDates"));
    }
    

    /**
     * Base CSS style applied to weekday dates which have been {@link com.smartgwt.client.widgets.DateChooser#getDisabledDates
     * disabled}.
     *
     * @param disabledWeekdayStyle New disabledWeekdayStyle value. Default value is "dateChooserDisabledWeekday"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setDisabledWeekdayStyle(String disabledWeekdayStyle) {
        setAttribute("disabledWeekdayStyle", disabledWeekdayStyle, true);
    }

    /**
     * Base CSS style applied to weekday dates which have been {@link com.smartgwt.client.widgets.DateChooser#getDisabledDates
     * disabled}.
     *
     * @return Current disabledWeekdayStyle value. Default value is "dateChooserDisabledWeekday"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getDisabledWeekdayStyle()  {
        return getAttributeAsString("disabledWeekdayStyle");
    }
    

    /**
     * Base CSS style applied to weekend dates which have been {@link com.smartgwt.client.widgets.DateChooser#getDisabledDates
     * disabled}.
     *
     * @param disabledWeekendStyle New disabledWeekendStyle value. Default value is "dateChooserDisabledWeekend"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setDisabledWeekendStyle(String disabledWeekendStyle) {
        setAttribute("disabledWeekendStyle", disabledWeekendStyle, true);
    }

    /**
     * Base CSS style applied to weekend dates which have been {@link com.smartgwt.client.widgets.DateChooser#getDisabledDates
     * disabled}.
     *
     * @return Current disabledWeekendStyle value. Default value is "dateChooserDisabledWeekend"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getDisabledWeekendStyle()  {
        return getAttributeAsString("disabledWeekendStyle");
    }
    

    /**
     * Whether it should be valid to pick a weekend day.  If set to true, weekend days appear in disabled style and cannot be
     * picked.  <P> Which days are considered weekends is controlled by {@link
     * com.smartgwt.client.widgets.DateChooser#getWeekendDays weekendDays} if set or by {@link
     * com.smartgwt.client.util.DateUtil#weekendDays weekendDays} otherwise.
     *
     * @param disableWeekends New disableWeekends value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDisableWeekends(Boolean disableWeekends)  throws IllegalStateException {
        setAttribute("disableWeekends", disableWeekends, false);
    }

    /**
     * Whether it should be valid to pick a weekend day.  If set to true, weekend days appear in disabled style and cannot be
     * picked.  <P> Which days are considered weekends is controlled by {@link
     * com.smartgwt.client.widgets.DateChooser#getWeekendDays weekendDays} if set or by {@link
     * com.smartgwt.client.util.DateUtil#weekendDays weekendDays} otherwise.
     *
     * @return Current disableWeekends value. Default value is false
     */
    public Boolean getDisableWeekends()  {
        Boolean result = getAttributeAsBoolean("disableWeekends");
        return result == null ? false : result;
    }
    

    /**
     * Last year that may be selected.
     *
     * @param endYear New endYear value. Default value is 2020
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEndYear(int endYear)  throws IllegalStateException {
        setAttribute("endYear", endYear, false);
    }

    /**
     * Last year that may be selected.
     *
     * @return Current endYear value. Default value is 2020
     */
    public int getEndYear()  {
        return getAttributeAsInt("endYear");
    }
    

    /**
     * Day of the week to show in the first column.  0=Sunday, 1=Monday, ..., 6=Saturday.  The default value for this attribute
     * is picked up from the current locale and can also be  altered system-wide with the {@link
     * com.smartgwt.client.util.DateUtil#setFirstDayOfWeek global setter}.
     *
     * @param firstDayOfWeek New firstDayOfWeek value. Default value is 0
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setFirstDayOfWeek(int firstDayOfWeek)  throws IllegalStateException {
        setAttribute("firstDayOfWeek", firstDayOfWeek, false);
    }

    /**
     * Day of the week to show in the first column.  0=Sunday, 1=Monday, ..., 6=Saturday.  The default value for this attribute
     * is picked up from the current locale and can also be  altered system-wide with the {@link
     * com.smartgwt.client.util.DateUtil#setFirstDayOfWeek global setter}.
     *
     * @return Current firstDayOfWeek value. Default value is 0
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getFirstDayOfWeek()  {
        return getAttributeAsInt("firstDayOfWeek");
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} which,  when
     * clicked, shows a picker for selecting a specific fiscal year.
     * <p>
     * This component is an AutoChild named "fiscalYearChooserButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current fiscalYearChooserButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getFiscalYearChooserButton() throws IllegalStateException {
        errorIfNotCreated("fiscalYearChooserButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("fiscalYearChooserButton"));
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser fiscal year} field in the date
     * grid.
     *
     * @param fiscalYearFieldTitle New fiscalYearFieldTitle value. Default value is "Year"
     */
    public void setFiscalYearFieldTitle(String fiscalYearFieldTitle) {
        setAttribute("fiscalYearFieldTitle", fiscalYearFieldTitle, true);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser fiscal year} field in the date
     * grid.
     *
     * @return Current fiscalYearFieldTitle value. Default value is "Year"
     */
    public String getFiscalYearFieldTitle()  {
        return getAttributeAsString("fiscalYearFieldTitle");
    }
    

    /**
     * Base CSS style applied to the header of the  {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser
     * fiscal year column} in the  {@link com.smartgwt.client.widgets.DateChooser#getDateGrid calendar view}.
     *
     * @param fiscalYearHeaderStyle New fiscalYearHeaderStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setFiscalYearHeaderStyle(String fiscalYearHeaderStyle) {
        setAttribute("fiscalYearHeaderStyle", fiscalYearHeaderStyle, true);
    }

    /**
     * Base CSS style applied to the header of the  {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser
     * fiscal year column} in the  {@link com.smartgwt.client.widgets.DateChooser#getDateGrid calendar view}.
     *
     * @return Current fiscalYearHeaderStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getFiscalYearHeaderStyle()  {
        return getAttributeAsString("fiscalYearHeaderStyle");
    }
    

    /**
     * Height of the header area (containing the navigation buttons) in pixels.
     *
     * @param headerHeight New headerHeight value. Default value is 20
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated in favor of {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayoutHeight navigationLayoutHeight}
     */
    public void setHeaderHeight(Integer headerHeight)  throws IllegalStateException {
        setAttribute("headerHeight", headerHeight, false);
    }

    /**
     * Height of the header area (containing the navigation buttons) in pixels.
     *
     * @return Current headerHeight value. Default value is 20
     * @deprecated in favor of {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayoutHeight navigationLayoutHeight}
     */
    public Integer getHeaderHeight()  {
        return getAttributeAsInt("headerHeight");
    }
    

    /**
     * CSS style applied to the day-of-week headers. By default this applies to all days of the  week. To apply a separate
     * style to weekend headers, set  {@link com.smartgwt.client.widgets.DateChooser#getWeekendHeaderStyle weekendHeaderStyle}
     *
     * @param headerStyle New headerStyle value. Default value is "dateChooserButtonDisabled"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setHeaderStyle(String headerStyle) {
        setAttribute("headerStyle", headerStyle, true);
    }

    /**
     * CSS style applied to the day-of-week headers. By default this applies to all days of the  week. To apply a separate
     * style to weekend headers, set  {@link com.smartgwt.client.widgets.DateChooser#getWeekendHeaderStyle weekendHeaderStyle}
     *
     * @return Current headerStyle value. Default value is "dateChooserButtonDisabled"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getHeaderStyle()  {
        return getAttributeAsString("headerStyle");
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} that shows 
     * a picker for selecting a specific month.
     * <p>
     * This component is an AutoChild named "monthChooserButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current monthChooserButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getMonthChooserButton() throws IllegalStateException {
        errorIfNotCreated("monthChooserButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("monthChooserButton"));
    }
    

    /**
     * Style for the pop-up year menu.
     *
     * @param monthMenuStyle New monthMenuStyle value. Default value is "dateChooserMonthMenu"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setMonthMenuStyle(String monthMenuStyle)  throws IllegalStateException {
        setAttribute("monthMenuStyle", monthMenuStyle, false);
    }

    /**
     * Style for the pop-up year menu.
     *
     * @return Current monthMenuStyle value. Default value is "dateChooserMonthMenu"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getMonthMenuStyle()  {
        return getAttributeAsString("monthMenuStyle");
    }
    
    

    /**
     * An {@link com.smartgwt.client.types.AutoChild} {@link com.smartgwt.client.widgets.layout.HLayout}, rendered above the
     * {@link com.smartgwt.client.widgets.grid.DateGrid date grid}, and showing a number of widgets for navigating the
     * DateChooser.  These include buttons  for moving to the previous {@link
     * com.smartgwt.client.widgets.DateChooser#getPreviousYearButton year} or  {@link
     * com.smartgwt.client.widgets.DateChooser#getPreviousMonthButton month}, the next  {@link
     * com.smartgwt.client.widgets.DateChooser#getNextYearButton year} or {@link
     * com.smartgwt.client.widgets.DateChooser#getNextMonthButton month},  and for selecting a specific {@link
     * com.smartgwt.client.widgets.DateChooser#getYearChooserButton year},  {@link
     * com.smartgwt.client.widgets.DateChooser#getMonthChooserButton month} or  {@link
     * com.smartgwt.client.widgets.DateChooser#getWeekChooserButton week}.
     * <p>
     * This component is an AutoChild named "navigationLayout".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current navigationLayout value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public HLayout getNavigationLayout() throws IllegalStateException {
        errorIfNotCreated("navigationLayout");
        return (HLayout)HLayout.getByJSObject(getAttributeAsJavaScriptObject("navigationLayout"));
    }
    

    /**
     * Height of the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation area}, containing the 
     * various buttons for navigating the {@link com.smartgwt.client.widgets.DateChooser#getDateGrid calendar view}.
     *
     * @param navigationLayoutHeight New navigationLayoutHeight value. Default value is 20
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated in favor of {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayoutHeight navigationLayoutHeight}
     */
    public void setNavigationLayoutHeight(int navigationLayoutHeight)  throws IllegalStateException {
        setAttribute("navigationLayoutHeight", navigationLayoutHeight, false);
    }

    /**
     * Height of the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation area}, containing the 
     * various buttons for navigating the {@link com.smartgwt.client.widgets.DateChooser#getDateGrid calendar view}.
     *
     * @return Current navigationLayoutHeight value. Default value is 20
     * @deprecated in favor of {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayoutHeight navigationLayoutHeight}
     */
    public int getNavigationLayoutHeight()  {
        return getAttributeAsInt("navigationLayoutHeight");
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} that shifts
     * the calendar view forward by a month.
     * <p>
     * This component is an AutoChild named "nextMonthButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current nextMonthButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getNextMonthButton() throws IllegalStateException {
        errorIfNotCreated("nextMonthButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("nextMonthButton"));
    }
    

    /**
     * Icon for the next month button
     *
     * @param nextMonthIcon New nextMonthIcon value. Default value is "[SKIN]arrow_right.gif"
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setNextMonthIcon(String nextMonthIcon) {
        setAttribute("nextMonthIcon", nextMonthIcon, true);
    }

    /**
     * Icon for the next month button
     *
     * @return Current nextMonthIcon value. Default value is "[SKIN]arrow_right.gif"
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getNextMonthIcon()  {
        return getAttributeAsString("nextMonthIcon");
    }
    

    /**
     * Height of the icon for the next month button
     *
     * @param nextMonthIconHeight New nextMonthIconHeight value. Default value is 7
     */
    public void setNextMonthIconHeight(int nextMonthIconHeight) {
        setAttribute("nextMonthIconHeight", nextMonthIconHeight, true);
    }

    /**
     * Height of the icon for the next month button
     *
     * @return Current nextMonthIconHeight value. Default value is 7
     */
    public int getNextMonthIconHeight()  {
        return getAttributeAsInt("nextMonthIconHeight");
    }
    

    /**
     * Icon for the next month button
     *
     * @param nextMonthIconRTL New nextMonthIconRTL value. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setNextMonthIconRTL(String nextMonthIconRTL) {
        setAttribute("nextMonthIconRTL", nextMonthIconRTL, true);
    }

    /**
     * Icon for the next month button
     *
     * @return Current nextMonthIconRTL value. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getNextMonthIconRTL()  {
        return getAttributeAsString("nextMonthIconRTL");
    }
    

    /**
     * Width of the icon for the next month button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL()} is true. If not
     * set, and the page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextMonthIcon nextMonthIcon}
     * will be used in place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevMonthIcon prevMonthIcon} and vice
     * versa.
     *
     * @param nextMonthIconWidth New nextMonthIconWidth value. Default value is 7
     */
    public void setNextMonthIconWidth(int nextMonthIconWidth) {
        setAttribute("nextMonthIconWidth", nextMonthIconWidth, true);
    }

    /**
     * Width of the icon for the next month button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL()} is true. If not
     * set, and the page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextMonthIcon nextMonthIcon}
     * will be used in place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevMonthIcon prevMonthIcon} and vice
     * versa.
     *
     * @return Current nextMonthIconWidth value. Default value is 7
     */
    public int getNextMonthIconWidth()  {
        return getAttributeAsInt("nextMonthIconWidth");
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} that shifts
     * the calendar view forward by a year.
     * <p>
     * This component is an AutoChild named "nextYearButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current nextYearButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getNextYearButton() throws IllegalStateException {
        errorIfNotCreated("nextYearButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("nextYearButton"));
    }
    

    /**
     * Icon for the next year button
     *
     * @param nextYearIcon New nextYearIcon value. Default value is "[SKIN]doubleArrow_right.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.DateChooser#setShowDoubleYearIcon
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setNextYearIcon(String nextYearIcon)  throws IllegalStateException {
        setAttribute("nextYearIcon", nextYearIcon, false);
    }

    /**
     * Icon for the next year button
     *
     * @return Current nextYearIcon value. Default value is "[SKIN]doubleArrow_right.gif"
     * @see com.smartgwt.client.widgets.DateChooser#getShowDoubleYearIcon
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getNextYearIcon()  {
        return getAttributeAsString("nextYearIcon");
    }
    

    /**
     * Height of the icon for the next year button
     *
     * @param nextYearIconHeight New nextYearIconHeight value. Default value is 7
     */
    public void setNextYearIconHeight(int nextYearIconHeight) {
        setAttribute("nextYearIconHeight", nextYearIconHeight, true);
    }

    /**
     * Height of the icon for the next year button
     *
     * @return Current nextYearIconHeight value. Default value is 7
     */
    public int getNextYearIconHeight()  {
        return getAttributeAsInt("nextYearIconHeight");
    }
    

    /**
     * Icon for the next year button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL()} is true. If not set, and the
     * page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextYearIcon nextYearIcon} will be used in
     * place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevYearIcon prevYearIcon} and vice versa.
     *
     * @param nextYearIconRTL New nextYearIconRTL value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.DateChooser#setShowDoubleYearIcon
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setNextYearIconRTL(String nextYearIconRTL)  throws IllegalStateException {
        setAttribute("nextYearIconRTL", nextYearIconRTL, false);
    }

    /**
     * Icon for the next year button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL()} is true. If not set, and the
     * page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextYearIcon nextYearIcon} will be used in
     * place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevYearIcon prevYearIcon} and vice versa.
     *
     * @return Current nextYearIconRTL value. Default value is null
     * @see com.smartgwt.client.widgets.DateChooser#getShowDoubleYearIcon
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getNextYearIconRTL()  {
        return getAttributeAsString("nextYearIconRTL");
    }
    

    /**
     * Width of the icon for the next year button
     *
     * @param nextYearIconWidth New nextYearIconWidth value. Default value is 14
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setNextYearIconWidth(int nextYearIconWidth)  throws IllegalStateException {
        setAttribute("nextYearIconWidth", nextYearIconWidth, false);
    }

    /**
     * Width of the icon for the next year button
     *
     * @return Current nextYearIconWidth value. Default value is 14
     */
    public int getNextYearIconWidth()  {
        return getAttributeAsInt("nextYearIconWidth");
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} that shifts
     * the calendar view backward by a month.
     * <p>
     * This component is an AutoChild named "previousMonthButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current previousMonthButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getPreviousMonthButton() throws IllegalStateException {
        errorIfNotCreated("previousMonthButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("previousMonthButton"));
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} that shifts
     * the calendar view backward by a year.
     * <p>
     * This component is an AutoChild named "previousYearButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current previousYearButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getPreviousYearButton() throws IllegalStateException {
        errorIfNotCreated("previousYearButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("previousYearButton"));
    }
    

    /**
     * Icon for the previous month button
     *
     * @param prevMonthIcon New prevMonthIcon value. Default value is "[SKIN]arrow_left.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setPrevMonthIcon(String prevMonthIcon)  throws IllegalStateException {
        setAttribute("prevMonthIcon", prevMonthIcon, false);
    }

    /**
     * Icon for the previous month button
     *
     * @return Current prevMonthIcon value. Default value is "[SKIN]arrow_left.gif"
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getPrevMonthIcon()  {
        return getAttributeAsString("prevMonthIcon");
    }
    

    /**
     * Height of the icon for the previous month button
     *
     * @param prevMonthIconHeight New prevMonthIconHeight value. Default value is 7
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPrevMonthIconHeight(int prevMonthIconHeight)  throws IllegalStateException {
        setAttribute("prevMonthIconHeight", prevMonthIconHeight, false);
    }

    /**
     * Height of the icon for the previous month button
     *
     * @return Current prevMonthIconHeight value. Default value is 7
     */
    public int getPrevMonthIconHeight()  {
        return getAttributeAsInt("prevMonthIconHeight");
    }
    

    /**
     * Icon for the previous month button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL()} is true. If not set, and
     * the page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextMonthIcon nextMonthIcon} will be used
     * in place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevMonthIcon prevMonthIcon} and vice versa.
     *
     * @param prevMonthIconRTL New prevMonthIconRTL value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setPrevMonthIconRTL(String prevMonthIconRTL)  throws IllegalStateException {
        setAttribute("prevMonthIconRTL", prevMonthIconRTL, false);
    }

    /**
     * Icon for the previous month button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL()} is true. If not set, and
     * the page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextMonthIcon nextMonthIcon} will be used
     * in place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevMonthIcon prevMonthIcon} and vice versa.
     *
     * @return Current prevMonthIconRTL value. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getPrevMonthIconRTL()  {
        return getAttributeAsString("prevMonthIconRTL");
    }
    

    /**
     * Width of the icon for the previous month button
     *
     * @param prevMonthIconWidth New prevMonthIconWidth value. Default value is 7
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPrevMonthIconWidth(int prevMonthIconWidth)  throws IllegalStateException {
        setAttribute("prevMonthIconWidth", prevMonthIconWidth, false);
    }

    /**
     * Width of the icon for the previous month button
     *
     * @return Current prevMonthIconWidth value. Default value is 7
     */
    public int getPrevMonthIconWidth()  {
        return getAttributeAsInt("prevMonthIconWidth");
    }
    

    /**
     * Icon for the previous year button
     *
     * @param prevYearIcon New prevYearIcon value. Default value is "[SKIN]doubleArrow_left.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.DateChooser#setShowDoubleYearIcon
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setPrevYearIcon(String prevYearIcon)  throws IllegalStateException {
        setAttribute("prevYearIcon", prevYearIcon, false);
    }

    /**
     * Icon for the previous year button
     *
     * @return Current prevYearIcon value. Default value is "[SKIN]doubleArrow_left.gif"
     * @see com.smartgwt.client.widgets.DateChooser#getShowDoubleYearIcon
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getPrevYearIcon()  {
        return getAttributeAsString("prevYearIcon");
    }
    

    /**
     * Height of the icon for the previous year button
     *
     * @param prevYearIconHeight New prevYearIconHeight value. Default value is 7
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPrevYearIconHeight(int prevYearIconHeight)  throws IllegalStateException {
        setAttribute("prevYearIconHeight", prevYearIconHeight, false);
    }

    /**
     * Height of the icon for the previous year button
     *
     * @return Current prevYearIconHeight value. Default value is 7
     */
    public int getPrevYearIconHeight()  {
        return getAttributeAsInt("prevYearIconHeight");
    }
    

    /**
     * Icon for the previous year button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL()} is true. If not set, and
     * the page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextYearIcon nextYearIcon} will be used
     * in place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevYearIcon prevYearIcon} and vice versa.
     *
     * @param prevYearIconRTL New prevYearIconRTL value. Default value is null
     * @see com.smartgwt.client.widgets.DateChooser#setShowDoubleYearIcon
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setPrevYearIconRTL(String prevYearIconRTL) {
        setAttribute("prevYearIconRTL", prevYearIconRTL, true);
    }

    /**
     * Icon for the previous year button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL()} is true. If not set, and
     * the page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextYearIcon nextYearIcon} will be used
     * in place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevYearIcon prevYearIcon} and vice versa.
     *
     * @return Current prevYearIconRTL value. Default value is null
     * @see com.smartgwt.client.widgets.DateChooser#getShowDoubleYearIcon
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getPrevYearIconRTL()  {
        return getAttributeAsString("prevYearIconRTL");
    }
    

    /**
     * Width of the icon for the previous year button
     *
     * @param prevYearIconWidth New prevYearIconWidth value. Default value is 14
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPrevYearIconWidth(int prevYearIconWidth)  throws IllegalStateException {
        setAttribute("prevYearIconWidth", prevYearIconWidth, false);
    }

    /**
     * Width of the icon for the previous year button
     *
     * @return Current prevYearIconWidth value. Default value is 14
     */
    public int getPrevYearIconWidth()  {
        return getAttributeAsInt("prevYearIconWidth");
    }
    

    /**
     * CSS style applied to the Fiscal Year and Week columns for the currently selected week  (the one being displayed in the
     * {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser week chooser}).
     *
     * @param selectedWeekStyle New selectedWeekStyle value. Default value is "dateChooserSelectedWeek"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setSelectedWeekStyle(String selectedWeekStyle) {
        setAttribute("selectedWeekStyle", selectedWeekStyle, true);
    }

    /**
     * CSS style applied to the Fiscal Year and Week columns for the currently selected week  (the one being displayed in the
     * {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser week chooser}).
     *
     * @return Current selectedWeekStyle value. Default value is "dateChooserSelectedWeek"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getSelectedWeekStyle()  {
        return getAttributeAsString("selectedWeekStyle");
    }
    

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.DateChooser#getApplyButton applyButton} will be displayed.
     *
     * @param showApplyButton New showApplyButton value. Default value is null
     */
    public void setShowApplyButton(Boolean showApplyButton) {
        setAttribute("showApplyButton", showApplyButton, true);
    }

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.DateChooser#getApplyButton applyButton} will be displayed.
     *
     * @return Current showApplyButton value. Default value is null
     */
    public Boolean getShowApplyButton()  {
        return getAttributeAsBoolean("showApplyButton");
    }
    

    /**
     * Determines whether the "Cancel" button will be displayed.
     *
     * @param showCancelButton New showCancelButton value. Default value is false
     */
    public void setShowCancelButton(Boolean showCancelButton) {
        setAttribute("showCancelButton", showCancelButton, true);
    }

    /**
     * Determines whether the "Cancel" button will be displayed.
     *
     * @return Current showCancelButton value. Default value is false
     */
    public Boolean getShowCancelButton()  {
        Boolean result = getAttributeAsBoolean("showCancelButton");
        return result == null ? false : result;
    }
    
    

    /**
     * When set to true, show a button that allows the calendar to be navigated by fiscal year.
     *
     * @param showFiscalYearChooser New showFiscalYearChooser value. Default value is false
     */
    public void setShowFiscalYearChooser(Boolean showFiscalYearChooser) {
        setAttribute("showFiscalYearChooser", showFiscalYearChooser, true);
    }

    /**
     * When set to true, show a button that allows the calendar to be navigated by fiscal year.
     *
     * @return Current showFiscalYearChooser value. Default value is false
     */
    public Boolean getShowFiscalYearChooser()  {
        Boolean result = getAttributeAsBoolean("showFiscalYearChooser");
        return result == null ? false : result;
    }
    

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field}, whether to show the "second" 
     * picker.  When unset, the second field is not shown.
     *
     * @param showSecondItem New showSecondItem value. Default value is null
     */
    public void setShowSecondItem(Boolean showSecondItem) {
        setAttribute("showSecondItem", showSecondItem, true);
    }

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field}, whether to show the "second" 
     * picker.  When unset, the second field is not shown.
     *
     * @return Current showSecondItem value. Default value is null
     */
    public Boolean getShowSecondItem()  {
        return getAttributeAsBoolean("showSecondItem");
    }
    

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field} for editing the time portion
     * of the date.  When unset, the time field is shown automatically if the field type is "datetime".  Note that the item's
     * {@link com.smartgwt.client.widgets.DateChooser#getShowSecondItem second chooser} is  not shown by default.
     *
     * @param showTimeItem New showTimeItem value. Default value is null
     */
    public void setShowTimeItem(Boolean showTimeItem) {
        setAttribute("showTimeItem", showTimeItem, true);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field} for editing the time portion
     * of the date.  When unset, the time field is shown automatically if the field type is "datetime".  Note that the item's
     * {@link com.smartgwt.client.widgets.DateChooser#getShowSecondItem second chooser} is  not shown by default.
     *
     * @return Current showTimeItem value. Default value is null
     */
    public Boolean getShowTimeItem()  {
        return getAttributeAsBoolean("showTimeItem");
    }
    

    /**
     * Determines whether the "Today" button will be displayed, allowing the user to select  the current date.
     *
     * @param showTodayButton New showTodayButton value. Default value is true
     */
    public void setShowTodayButton(Boolean showTodayButton) {
        setAttribute("showTodayButton", showTodayButton, true);
    }

    /**
     * Determines whether the "Today" button will be displayed, allowing the user to select  the current date.
     *
     * @return Current showTodayButton value. Default value is true
     */
    public Boolean getShowTodayButton()  {
        Boolean result = getAttributeAsBoolean("showTodayButton");
        return result == null ? true : result;
    }
    

    /**
     * When set to true, show a button that allows the calendar to be navigated by week or fiscal week, depending on the value
     * of {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser showFiscalYearChooser}.
     *
     * @param showWeekChooser New showWeekChooser value. Default value is false
     */
    public void setShowWeekChooser(Boolean showWeekChooser) {
        setAttribute("showWeekChooser", showWeekChooser, true);
    }

    /**
     * When set to true, show a button that allows the calendar to be navigated by week or fiscal week, depending on the value
     * of {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser showFiscalYearChooser}.
     *
     * @return Current showWeekChooser value. Default value is false
     */
    public Boolean getShowWeekChooser()  {
        Boolean result = getAttributeAsBoolean("showWeekChooser");
        return result == null ? false : result;
    }
    

    /**
     * Whether weekend days should be shown.  Which days are considered weekends is controlled  by {@link
     * com.smartgwt.client.widgets.DateChooser#getWeekendDays weekendDays} if set or by {@link
     * com.smartgwt.client.util.DateUtil#weekendDays weekendDays} otherwise.
     *
     * @param showWeekends New showWeekends value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowWeekends(Boolean showWeekends)  throws IllegalStateException {
        setAttribute("showWeekends", showWeekends, false);
    }

    /**
     * Whether weekend days should be shown.  Which days are considered weekends is controlled  by {@link
     * com.smartgwt.client.widgets.DateChooser#getWeekendDays weekendDays} if set or by {@link
     * com.smartgwt.client.util.DateUtil#weekendDays weekendDays} otherwise.
     *
     * @return Current showWeekends value. Default value is true
     */
    public Boolean getShowWeekends()  {
        Boolean result = getAttributeAsBoolean("showWeekends");
        return result == null ? true : result;
    }
    

    /**
     * Overridden directory where images for this widget (such as the month and year button icons) may be found.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param skinImgDir New skinImgDir value. Default value is "images/common/"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public void setSkinImgDir(String skinImgDir) {
        setAttribute("skinImgDir", skinImgDir, true);
    }

    /**
     * Overridden directory where images for this widget (such as the month and year button icons) may be found.
     *
     * @return Current skinImgDir value. Default value is "images/common/"
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }
    

    /**
     * Earliest year that may be selected.
     *
     * @param startYear New startYear value. Default value is 1995
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStartYear(int startYear)  throws IllegalStateException {
        setAttribute("startYear", startYear, false);
    }

    /**
     * Earliest year that may be selected.
     *
     * @return Current startYear value. Default value is 1995
     */
    public int getStartYear()  {
        return getAttributeAsInt("startYear");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem} for editing the time portion of dates.  Visible by default for
     * fields  of type "datetime" and can be controlled by setting {@link
     * com.smartgwt.client.widgets.DateChooser#getShowTimeItem showTimeItem}.
     * <p>
     * This component is an AutoChild named "timeItem".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current timeItem value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public TimeItem getTimeItem() throws IllegalStateException {
        errorIfNotCreated("timeItem");
        return TimeItem.getOrCreateRef(getAttributeAsJavaScriptObject("timeItem"));
    }
    

    /**
     * Custom properties to apply to the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field} used  for
     * editing the time portion of the date.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param timeItemProperties New timeItemProperties value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTimeItemProperties(TimeItem timeItemProperties)  throws IllegalStateException {
        if (timeItemProperties.isCreated()) {
            ConfigUtil.warnOfPreConfigInstantiation(DateChooser.class, "setTimeItemProperties", "TimeItem");
        }                                                                       
        timeItemProperties.setConfigOnly(true);
        setAttribute("timeItemProperties", timeItemProperties == null ? null : timeItemProperties.getEditorTypeConfig(), false);
    }

    /**
     * Custom properties to apply to the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field} used  for
     * editing the time portion of the date.
     *
     * @return Current timeItemProperties value. Default value is null
     */
    public TimeItem getTimeItemProperties()  {
        return TimeItem.getOrCreateRef(getAttributeAsJavaScriptObject("timeItemProperties"));
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field}.
     *
     * @param timeItemTitle New timeItemTitle value. Default value is "Time"
     */
    public void setTimeItemTitle(String timeItemTitle) {
        setAttribute("timeItemTitle", timeItemTitle, true);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field}.
     *
     * @return Current timeItemTitle value. Default value is "Time"
     */
    public String getTimeItemTitle()  {
        return getAttributeAsString("timeItemTitle");
    }
    

    /**
     * A button shown below the {@link com.smartgwt.client.widgets.grid.DateGrid calendar grid} which, when clicked,  navigates
     * the calendar to today.
     * <p>
     * This component is an AutoChild named "todayButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current todayButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getTodayButton() throws IllegalStateException {
        errorIfNotCreated("todayButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("todayButton"));
    }
    

    /**
     * If set specifies a fixed height for the Today and Cancel buttons.
     *
     * @param todayButtonHeight New todayButtonHeight value. Default value is null
     */
    public void setTodayButtonHeight(Integer todayButtonHeight) {
        setAttribute("todayButtonHeight", todayButtonHeight, true);
    }

    /**
     * If set specifies a fixed height for the Today and Cancel buttons.
     *
     * @return Current todayButtonHeight value. Default value is null
     */
    public Integer getTodayButtonHeight()  {
        return getAttributeAsInt("todayButtonHeight");
    }
    

    /**
     * Title for "Today" button.
     *
     * @param todayButtonTitle New todayButtonTitle value. Default value is "Today"
     */
    public void setTodayButtonTitle(String todayButtonTitle) {
        setAttribute("todayButtonTitle", todayButtonTitle, true);
    }

    /**
     * Title for "Today" button.
     *
     * @return Current todayButtonTitle value. Default value is "Today"
     */
    public String getTodayButtonTitle()  {
        return getAttributeAsString("todayButtonTitle");
    }
    

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser#getShowTimeItem time field}, whether the  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} should be set to use 24-hour time.  The default is true.
     *
     * @param use24HourTime New use24HourTime value. Default value is true
     */
    public void setUse24HourTime(Boolean use24HourTime) {
        setAttribute("use24HourTime", use24HourTime, true);
    }

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser#getShowTimeItem time field}, whether the  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} should be set to use 24-hour time.  The default is true.
     *
     * @return Current use24HourTime value. Default value is true
     */
    public Boolean getUse24HourTime()  {
        Boolean result = getAttributeAsBoolean("use24HourTime");
        return result == null ? true : result;
    }
    

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser fiscal year chooser}, should
     * firstDayOfWeek be defaulted to the same day as the fiscal start date?  If true and a fiscal year  starts on a Tuesday,
     * the calendar will display Tuesday to Monday from left to right.
     *
     * @param useFirstDayOfFiscalWeek New useFirstDayOfFiscalWeek value. Default value is true
     */
    public void setUseFirstDayOfFiscalWeek(Boolean useFirstDayOfFiscalWeek) {
        setAttribute("useFirstDayOfFiscalWeek", useFirstDayOfFiscalWeek, true);
    }

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser fiscal year chooser}, should
     * firstDayOfWeek be defaulted to the same day as the fiscal start date?  If true and a fiscal year  starts on a Tuesday,
     * the calendar will display Tuesday to Monday from left to right.
     *
     * @return Current useFirstDayOfFiscalWeek value. Default value is true
     */
    public Boolean getUseFirstDayOfFiscalWeek()  {
        Boolean result = getAttributeAsBoolean("useFirstDayOfFiscalWeek");
        return result == null ? true : result;
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} which shows
     * a picker for selecting a specific week of the year.  When {@link
     * com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser showFiscalYearChooser} is true, the week number
     * represents a fiscal week number, one offset from the start of  the fiscal year.  Otherwise, it represents a week number
     * offset from the start of the calendar year.
     * <p>
     * This component is an AutoChild named "weekChooserButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current weekChooserButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getWeekChooserButton() throws IllegalStateException {
        errorIfNotCreated("weekChooserButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("weekChooserButton"));
    }
    

    /**
     * An array of integer day-numbers that should be considered to be weekend days by this DateChooser instance.  If unset,
     * defaults to the set of days indicated  {@link com.smartgwt.client.util.DateUtil#weekendDays globally}.
     *
     * @param weekendDays New weekendDays value. Default value is null
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public void setWeekendDays(int... weekendDays) {
        setAttribute("weekendDays", weekendDays, true);
    }

    /**
     * An array of integer day-numbers that should be considered to be weekend days by this DateChooser instance.  If unset,
     * defaults to the set of days indicated  {@link com.smartgwt.client.util.DateUtil#weekendDays globally}.
     *
     * @return Current weekendDays value. Default value is null
     * @see com.smartgwt.client.docs.Visibility Visibility overview and related methods
     */
    public int[] getWeekendDays()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfint(getAttributeAsJavaScriptObject("weekendDays"));
    }
    

    /**
     * Optional CSS style applied to the day-of-week headers for weekend days. If unset  {@link
     * com.smartgwt.client.widgets.DateChooser#getHeaderStyle headerStyle} will be applied to both weekdays and weekend days.
     *
     * @param weekendHeaderStyle New weekendHeaderStyle value. Default value is null
     */
    public void setWeekendHeaderStyle(String weekendHeaderStyle) {
        setAttribute("weekendHeaderStyle", weekendHeaderStyle, true);
    }

    /**
     * Optional CSS style applied to the day-of-week headers for weekend days. If unset  {@link
     * com.smartgwt.client.widgets.DateChooser#getHeaderStyle headerStyle} will be applied to both weekdays and weekend days.
     *
     * @return Current weekendHeaderStyle value. Default value is null
     */
    public String getWeekendHeaderStyle()  {
        return getAttributeAsString("weekendHeaderStyle");
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser week} field in the date grid.
     *
     * @param weekFieldTitle New weekFieldTitle value. Default value is "Wk"
     */
    public void setWeekFieldTitle(String weekFieldTitle) {
        setAttribute("weekFieldTitle", weekFieldTitle, true);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser week} field in the date grid.
     *
     * @return Current weekFieldTitle value. Default value is "Wk"
     */
    public String getWeekFieldTitle()  {
        return getAttributeAsString("weekFieldTitle");
    }
    

    /**
     * Base CSS style applied to the header of the  {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser fiscal or
     * calendar week column} in the {@link com.smartgwt.client.widgets.DateChooser#getDateGrid calendar view}.
     *
     * @param weekHeaderStyle New weekHeaderStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setWeekHeaderStyle(String weekHeaderStyle) {
        setAttribute("weekHeaderStyle", weekHeaderStyle, true);
    }

    /**
     * Base CSS style applied to the header of the  {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser fiscal or
     * calendar week column} in the {@link com.smartgwt.client.widgets.DateChooser#getDateGrid calendar view}.
     *
     * @return Current weekHeaderStyle value. Default value is null
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getWeekHeaderStyle()  {
        return getAttributeAsString("weekHeaderStyle");
    }
    

    /**
     * Style for the pop-up week menu.
     *
     * @param weekMenuStyle New weekMenuStyle value. Default value is "dateChooserWeekMenu"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setWeekMenuStyle(String weekMenuStyle)  throws IllegalStateException {
        setAttribute("weekMenuStyle", weekMenuStyle, false);
    }

    /**
     * Style for the pop-up week menu.
     *
     * @return Current weekMenuStyle value. Default value is "dateChooserWeekMenu"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getWeekMenuStyle()  {
        return getAttributeAsString("weekMenuStyle");
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} that shows 
     * a picker for selecting a specific calendar year.
     * <p>
     * This component is an AutoChild named "yearChooserButton".  For an overview of how to use and
     * configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return Current yearChooserButton value. Default value is null
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getYearChooserButton() throws IllegalStateException {
        errorIfNotCreated("yearChooserButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("yearChooserButton"));
    }
    

    /**
     * Style for the pop-up year menu.
     *
     * @param yearMenuStyle New yearMenuStyle value. Default value is "dateChooserYearMenu"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public void setYearMenuStyle(String yearMenuStyle)  throws IllegalStateException {
        setAttribute("yearMenuStyle", yearMenuStyle, false);
    }

    /**
     * Style for the pop-up year menu.
     *
     * @return Current yearMenuStyle value. Default value is "dateChooserYearMenu"
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getYearMenuStyle()  {
        return getAttributeAsString("yearMenuStyle");
    }
    

    // ********************* Methods ***********************
	/**
     * Fired when the user clicks the cancel button in this date chooser. Default implementation clears the date chooser.
     */
    public native void cancelClick() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "cancelClick", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancelClick();
    }-*/;

    /**
     * Add a dataChanged handler.
     * <p>
     * Method to override or observe in order to be notified when a user picks a date value. <P> Has no default behavior (so no
     * need to call Super). <P> Use {@link com.smartgwt.client.widgets.DateChooser#getData DateChooser.getData()} to get the
     * current date value.
     *
     * @param handler the dataChanged handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addDataChangedHandler(com.smartgwt.client.widgets.events.DataChangedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.DataChangedEvent.getType()) == 0) setupDataChangedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.DataChangedEvent.getType());
    }

    private native void setupDataChangedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var dataChanged = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.events.DataChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.DateChooser::handleTearDownDataChangedEvent()();
            if (hasDefaultHandler) this.Super("dataChanged", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("dataChanged"));
            obj.addProperties({dataChanged:  dataChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("dataChanged"));
            obj.dataChanged =  dataChanged             ;
        }
    }-*/;

    private void handleTearDownDataChangedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.events.DataChangedEvent.getType()) == 0) tearDownDataChangedEvent();
    }

    private native void tearDownDataChangedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("dataChanged")) delete obj.dataChanged;
    }-*/;

	/**
     * Get the current value of the picker. <P> See {@link com.smartgwt.client.widgets.DateChooser#addDataChangedHandler
     * DateChooser.dataChanged()} for how to respond to the user picking a date.
     *
     * @return current date
     */
    public native Date getData() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getData", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getData();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toDate(D)(ret.getTime());
    }-*/;

	/**
     * Returns the {@link com.smartgwt.client.widgets.FiscalCalendar} object that will be used by this DateChooser.
     *
     * @return the fiscal calendar for this chooser, if set, or the global            one otherwise
     */
    public native FiscalCalendar getFiscalCalendar() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getFiscalCalendar", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getFiscalCalendar();
        if(ret == null) return null;
        return @com.smartgwt.client.widgets.FiscalCalendar::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;

	/**
     * Set the picker to show the given date.
     * @param date new value
     */
    public native void setData(Date date) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setData", "Date");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setData(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date));
    }-*/;

	/**
     * Sets the {@link com.smartgwt.client.widgets.FiscalCalendar} object that will be used by this DateChooser.  If unset, the
     * {@link com.smartgwt.client.util.DateUtil#getFiscalCalendar global fiscal calendar} is used.
     */
    public native void setFiscalCalendar() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setFiscalCalendar", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFiscalCalendar();
    }-*/;

	/**
     * Sets the {@link com.smartgwt.client.widgets.FiscalCalendar} object that will be used by this DateChooser.  If unset, the
     * {@link com.smartgwt.client.util.DateUtil#getFiscalCalendar global fiscal calendar} is used.
     * @param fiscalCalendar the fiscal calendar for this chooser
     */
    public native void setFiscalCalendar(FiscalCalendar fiscalCalendar) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "setFiscalCalendar", "FiscalCalendar");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFiscalCalendar(fiscalCalendar == null ? null : fiscalCalendar.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Fired when the user clicks the Today button. Default implementation will select the current date in the date chooser.
     */
    public native void todayClick() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "todayClick", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.todayClick();
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
     * @param dateChooserProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(DateChooser dateChooserProperties) /*-{
        if (dateChooserProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(DateChooser.@java.lang.Object::getClass()(), "setDefaultProperties", dateChooserProperties.@java.lang.Object::getClass()());
        }
        dateChooserProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = dateChooserProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.DateChooser.addProperties(properties);
    }-*/;

    // ***********************************************************



    public native void setYearTitleFormatter(YearTitleFormatter formatter) /*-{
        var self = this.@com.smartgwt.client.core.BaseClass::isCreated()() ? this.@com.smartgwt.client.core.BaseClass::getJsObj()() : this.@com.smartgwt.client.core.BaseClass::getConfig()();
        self.getYearTitle = $debox($entry(function(value) {
            var val = formatter.@com.smartgwt.client.widgets.DateChooser.YearTitleFormatter::getYearTitle(I)(value);
            return $wnd.SmartGWT.convertToPrimitiveType(val);
        }));
        self.getHeaderYearTitle = $debox($entry(function(value) {
            var val = formatter.@com.smartgwt.client.widgets.DateChooser.YearTitleFormatter::getHeaderYearTitle(I)(value);
            return $wnd.SmartGWT.convertToPrimitiveType(val);
        }));
    }-*/;
    
    /**
     * A customizer that allows you to alter the year representations used in various places in the DateChooser widget.
     * NOTE: DateChooser instances are typically not directly created by application code, they are normally created as
     * autoChildren of {@link com.smartgwt.client.widgets.form.fields.DateItem DateItem}s, at the Javascript level.  To
     * use a YearTitleFormatter in this common case, you will need to create a DateChooser subclass, mark it for processing 
     * by the BeanFactory reflection mechanism, and specify it via the autoChild system.  See the example code below, and 
     * refer to the {@link com.smartgwt.client.docs.AutoChildUsage autoChild} and {@link com.smartgwt.client.docs.Reflection reflection}
     * documentation for more details.
     * <pre>
     *  DateItem dateItem = new DateItem();
     *  dateItem.setAutoChildConstructor("picker", "com.mycompany.client.MyDateChooser");
     *  dateItem.setAutoChildProperties("picker", new MyDateChooser());
     * </pre>
     * And the <code>MyDateChooser</code> subclass:
     * <pre>
     *  @BeanFactory.Generate
     *  
     *      public MyDateChooser() {
     *          setYearTitleFormatter(new YearTitleFormatter() {
     *              @Override
     *              public String getYearTitle(int value) {
     *                  // Example: just return the 2-digit year
     *                  return "" + (value - 1900);
     *              }	
     *              @Override
     *              public String getHeaderYearTitle(int value) {
     *                  // Return the full year (same as default behavior)
     *                  return "" + value;
     *              }
	 *          });
     *      }
     *  }
     */
    public static interface YearTitleFormatter {
        
        /**
         * Method to provide the year representations that are shown in the DateChooser's "Select a year" dropdown.  
         * The default implementation returns the full four-digit Gregorian year (ie, the same value that is passed in,
         * converted to a String)
         * @param year The Gregorian year number to derive a display value for
         * @return The value to show for the parameter year
         */
        public String getYearTitle(int value);
        /**
         * Method to provide the year representation that is shown in the DateChooser header.  
         * The default implementation returns the full four-digit Gregorian year (ie, the same value that is passed in,
         * converted to a String)
         * @param year The Gregorian year number to derive a display value for
         * @return The value to show for the parameter year
         */
        public String getHeaderYearTitle(int value);
    }


    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(DateChooserLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.alternateStyleSuffix = getAttributeAsString("alternateStyleSuffix");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.alternateStyleSuffix:" + t.getMessage() + "\n";
        }
        try {
            s.alternateWeekStyles = getAttributeAsString("alternateWeekStyles");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.alternateWeekStyles:" + t.getMessage() + "\n";
        }
        try {
            s.applyButtonTitle = getAttributeAsString("applyButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.applyButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.baseBottomButtonStyle = getAttributeAsString("baseBottomButtonStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.baseBottomButtonStyle:" + t.getMessage() + "\n";
        }
        try {
            s.baseButtonStyle = getAttributeAsString("baseButtonStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.baseButtonStyle:" + t.getMessage() + "\n";
        }
        try {
            s.baseFiscalYearStyle = getAttributeAsString("baseFiscalYearStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.baseFiscalYearStyle:" + t.getMessage() + "\n";
        }
        try {
            s.baseNavButtonStyle = getAttributeAsString("baseNavButtonStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.baseNavButtonStyle:" + t.getMessage() + "\n";
        }
        try {
            s.baseWeekdayStyle = getAttributeAsString("baseWeekdayStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.baseWeekdayStyle:" + t.getMessage() + "\n";
        }
        try {
            s.baseWeekendStyle = getAttributeAsString("baseWeekendStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.baseWeekendStyle:" + t.getMessage() + "\n";
        }
        try {
            s.baseWeekStyle = getAttributeAsString("baseWeekStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.baseWeekStyle:" + t.getMessage() + "\n";
        }
        try {
            s.buttonLayoutControls = getAttributeAsStringArray("buttonLayoutControls");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.buttonLayoutControlsArray:" + t.getMessage() + "\n";
        }
        try {
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.cancelButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.closeOnDateClick = getAttributeAsString("closeOnDateClick");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.closeOnDateClick:" + t.getMessage() + "\n";
        }
        try {
            s.closeOnEscapeKeypress = getAttributeAsString("closeOnEscapeKeypress");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.closeOnEscapeKeypress:" + t.getMessage() + "\n";
        }
        try {
            s.dayNameLength = getAttributeAsString("dayNameLength");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.dayNameLength:" + t.getMessage() + "\n";
        }
        try {
            s.disabledDates = getAttributeAsStringArray("disabledDates");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.disabledDatesArray:" + t.getMessage() + "\n";
        }
        try {
            s.disabledWeekdayStyle = getAttributeAsString("disabledWeekdayStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.disabledWeekdayStyle:" + t.getMessage() + "\n";
        }
        try {
            s.disabledWeekendStyle = getAttributeAsString("disabledWeekendStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.disabledWeekendStyle:" + t.getMessage() + "\n";
        }
        try {
            s.disableWeekends = getAttributeAsString("disableWeekends");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.disableWeekends:" + t.getMessage() + "\n";
        }
        try {
            s.endYear = getAttributeAsString("endYear");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.endYear:" + t.getMessage() + "\n";
        }
        try {
            s.firstDayOfWeek = getAttributeAsString("firstDayOfWeek");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.firstDayOfWeek:" + t.getMessage() + "\n";
        }
        try {
            s.fiscalYearFieldTitle = getAttributeAsString("fiscalYearFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.fiscalYearFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.fiscalYearHeaderStyle = getAttributeAsString("fiscalYearHeaderStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.fiscalYearHeaderStyle:" + t.getMessage() + "\n";
        }
        try {
            s.headerHeight = getAttributeAsString("headerHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.headerHeight:" + t.getMessage() + "\n";
        }
        try {
            s.headerStyle = getAttributeAsString("headerStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.headerStyle:" + t.getMessage() + "\n";
        }
        try {
            s.monthMenuStyle = getAttributeAsString("monthMenuStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.monthMenuStyle:" + t.getMessage() + "\n";
        }
        try {
            s.navigationLayoutHeight = getAttributeAsString("navigationLayoutHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.navigationLayoutHeight:" + t.getMessage() + "\n";
        }
        try {
            s.nextMonthIcon = getAttributeAsString("nextMonthIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.nextMonthIcon:" + t.getMessage() + "\n";
        }
        try {
            s.nextMonthIconHeight = getAttributeAsString("nextMonthIconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.nextMonthIconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.nextMonthIconRTL = getAttributeAsString("nextMonthIconRTL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.nextMonthIconRTL:" + t.getMessage() + "\n";
        }
        try {
            s.nextMonthIconWidth = getAttributeAsString("nextMonthIconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.nextMonthIconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.nextYearIcon = getAttributeAsString("nextYearIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.nextYearIcon:" + t.getMessage() + "\n";
        }
        try {
            s.nextYearIconHeight = getAttributeAsString("nextYearIconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.nextYearIconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.nextYearIconRTL = getAttributeAsString("nextYearIconRTL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.nextYearIconRTL:" + t.getMessage() + "\n";
        }
        try {
            s.nextYearIconWidth = getAttributeAsString("nextYearIconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.nextYearIconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.prevMonthIcon = getAttributeAsString("prevMonthIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.prevMonthIcon:" + t.getMessage() + "\n";
        }
        try {
            s.prevMonthIconHeight = getAttributeAsString("prevMonthIconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.prevMonthIconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.prevMonthIconRTL = getAttributeAsString("prevMonthIconRTL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.prevMonthIconRTL:" + t.getMessage() + "\n";
        }
        try {
            s.prevMonthIconWidth = getAttributeAsString("prevMonthIconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.prevMonthIconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.prevYearIcon = getAttributeAsString("prevYearIcon");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.prevYearIcon:" + t.getMessage() + "\n";
        }
        try {
            s.prevYearIconHeight = getAttributeAsString("prevYearIconHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.prevYearIconHeight:" + t.getMessage() + "\n";
        }
        try {
            s.prevYearIconRTL = getAttributeAsString("prevYearIconRTL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.prevYearIconRTL:" + t.getMessage() + "\n";
        }
        try {
            s.prevYearIconWidth = getAttributeAsString("prevYearIconWidth");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.prevYearIconWidth:" + t.getMessage() + "\n";
        }
        try {
            s.selectedWeekStyle = getAttributeAsString("selectedWeekStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.selectedWeekStyle:" + t.getMessage() + "\n";
        }
        try {
            s.showApplyButton = getAttributeAsString("showApplyButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.showApplyButton:" + t.getMessage() + "\n";
        }
        try {
            s.showCancelButton = getAttributeAsString("showCancelButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.showCancelButton:" + t.getMessage() + "\n";
        }
        try {
            s.showFiscalYearChooser = getAttributeAsString("showFiscalYearChooser");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.showFiscalYearChooser:" + t.getMessage() + "\n";
        }
        try {
            s.showSecondItem = getAttributeAsString("showSecondItem");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.showSecondItem:" + t.getMessage() + "\n";
        }
        try {
            s.showTimeItem = getAttributeAsString("showTimeItem");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.showTimeItem:" + t.getMessage() + "\n";
        }
        try {
            s.showTodayButton = getAttributeAsString("showTodayButton");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.showTodayButton:" + t.getMessage() + "\n";
        }
        try {
            s.showWeekChooser = getAttributeAsString("showWeekChooser");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.showWeekChooser:" + t.getMessage() + "\n";
        }
        try {
            s.showWeekends = getAttributeAsString("showWeekends");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.showWeekends:" + t.getMessage() + "\n";
        }
        try {
            s.skinImgDir = getAttributeAsString("skinImgDir");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.skinImgDir:" + t.getMessage() + "\n";
        }
        try {
            s.startYear = getAttributeAsString("startYear");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.startYear:" + t.getMessage() + "\n";
        }
        try {
            s.timeItemTitle = getAttributeAsString("timeItemTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.timeItemTitle:" + t.getMessage() + "\n";
        }
        try {
            s.todayButtonHeight = getAttributeAsString("todayButtonHeight");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.todayButtonHeight:" + t.getMessage() + "\n";
        }
        try {
            s.todayButtonTitle = getAttributeAsString("todayButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.todayButtonTitle:" + t.getMessage() + "\n";
        }
        try {
            s.use24HourTime = getAttributeAsString("use24HourTime");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.use24HourTime:" + t.getMessage() + "\n";
        }
        try {
            s.useFirstDayOfFiscalWeek = getAttributeAsString("useFirstDayOfFiscalWeek");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.useFirstDayOfFiscalWeek:" + t.getMessage() + "\n";
        }
        try {
            s.weekendDays = getAttributeAsStringArray("weekendDays");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.weekendDaysArray:" + t.getMessage() + "\n";
        }
        try {
            s.weekendHeaderStyle = getAttributeAsString("weekendHeaderStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.weekendHeaderStyle:" + t.getMessage() + "\n";
        }
        try {
            s.weekFieldTitle = getAttributeAsString("weekFieldTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.weekFieldTitle:" + t.getMessage() + "\n";
        }
        try {
            s.weekHeaderStyle = getAttributeAsString("weekHeaderStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.weekHeaderStyle:" + t.getMessage() + "\n";
        }
        try {
            s.weekMenuStyle = getAttributeAsString("weekMenuStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.weekMenuStyle:" + t.getMessage() + "\n";
        }
        try {
            s.yearMenuStyle = getAttributeAsString("yearMenuStyle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.yearMenuStyle:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        DateChooserLogicalStructure s = new DateChooserLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
