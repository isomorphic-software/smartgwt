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
     * without destroying or wiping out non-overridden properties.
     * @see com.smartgwt.client.docs.AutoChildUsage
     */
    public static native void changeAutoChildDefaults(String autoChildName, Canvas defaults) /*-{
        $wnd.isc.DateChooser.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.Canvas::getConfig()());
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
        $wnd.isc.DateChooser.changeDefaults(autoChildName + "Defaults", defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getJsObj()());
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
     * @param alternateStyleSuffix  Default value is "Dark"
     */
    public void setAlternateStyleSuffix(String alternateStyleSuffix) {
        setAttribute("alternateStyleSuffix", alternateStyleSuffix, true);
    }

    /**
     * The text appended to the style name when using {@link com.smartgwt.client.widgets.DateChooser#getAlternateWeekStyles
     * alternateWeekStyles}.
     *
     * @return String
     */
    public String getAlternateStyleSuffix()  {
        return getAttributeAsString("alternateStyleSuffix");
    }
    

    /**
     * Whether alternating weeks should be drawn in alternating styles. If enabled, the cell style for alternate rows will have
     * {@link com.smartgwt.client.widgets.DateChooser#getAlternateStyleSuffix alternateStyleSuffix} appended to it.
     *
     * @param alternateWeekStyles  Default value is null
     */
    public void setAlternateWeekStyles(Boolean alternateWeekStyles) {
        setAttribute("alternateWeekStyles", alternateWeekStyles, true);
    }

    /**
     * Whether alternating weeks should be drawn in alternating styles. If enabled, the cell style for alternate rows will have
     * {@link com.smartgwt.client.widgets.DateChooser#getAlternateStyleSuffix alternateStyleSuffix} appended to it.
     *
     * @return Boolean
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
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getApplyButton() throws IllegalStateException {
        errorIfNotCreated("applyButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("applyButton"));
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getApplyButton Apply} button.
     *
     * @param applyButtonTitle  Default value is "Apply"
     */
    public void setApplyButtonTitle(String applyButtonTitle) {
        setAttribute("applyButtonTitle", applyButtonTitle, true);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getApplyButton Apply} button.
     *
     * @return String
     */
    public String getApplyButtonTitle()  {
        return getAttributeAsString("applyButtonTitle");
    }
    

    /**
     * CSS style to apply to the buttons at the bottom of the DateChooser ("Today" and "Cancel").  If null, the CSS style
     * specified in {@link com.smartgwt.client.widgets.DateChooser#getBaseButtonStyle baseButtonStyle} is used.
     *
     * @param baseBottomButtonStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     */
    public void setBaseBottomButtonStyle(String baseBottomButtonStyle) {
        setAttribute("baseBottomButtonStyle", baseBottomButtonStyle, true);
    }

    /**
     * CSS style to apply to the buttons at the bottom of the DateChooser ("Today" and "Cancel").  If null, the CSS style
     * specified in {@link com.smartgwt.client.widgets.DateChooser#getBaseButtonStyle baseButtonStyle} is used.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getBaseBottomButtonStyle()  {
        return getAttributeAsString("baseBottomButtonStyle");
    }
    

    /**
     * Base CSS style applied to this picker's buttons. Will have "Over", "Selected" and "Down" suffix appended as the user
     * interacts with buttons.
     *
     * @param baseButtonStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "dateChooserButton"
     */
    public void setBaseButtonStyle(String baseButtonStyle) {
        setAttribute("baseButtonStyle", baseButtonStyle, true);
    }

    /**
     * Base CSS style applied to this picker's buttons. Will have "Over", "Selected" and "Down" suffix appended as the user
     * interacts with buttons.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getBaseButtonStyle()  {
        return getAttributeAsString("baseButtonStyle");
    }
    

    /**
     * Base CSS style applied to cells in the {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser fiscal
     * year column}.
     *
     * @param baseFiscalYearStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "dateChooserFiscalYearCell"
     */
    public void setBaseFiscalYearStyle(String baseFiscalYearStyle) {
        setAttribute("baseFiscalYearStyle", baseFiscalYearStyle, true);
    }

    /**
     * Base CSS style applied to cells in the {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser fiscal
     * year column}.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getBaseFiscalYearStyle()  {
        return getAttributeAsString("baseFiscalYearStyle");
    }
    

    /**
     * CSS style to apply to navigation buttons and date display at the top of the component. If null, the CSS style specified
     * in {@link com.smartgwt.client.widgets.DateChooser#getBaseButtonStyle baseButtonStyle} is used.
     *
     * @param baseNavButtonStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     */
    public void setBaseNavButtonStyle(String baseNavButtonStyle) {
        setAttribute("baseNavButtonStyle", baseNavButtonStyle, true);
    }

    /**
     * CSS style to apply to navigation buttons and date display at the top of the component. If null, the CSS style specified
     * in {@link com.smartgwt.client.widgets.DateChooser#getBaseButtonStyle baseButtonStyle} is used.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getBaseNavButtonStyle()  {
        return getAttributeAsString("baseNavButtonStyle");
    }
    

    /**
     * Base CSS style applied to weekdays. Will have "Over", "Selected" and "Down" suffix appended as the user interacts with
     * buttons.  Defaults to {@link com.smartgwt.client.widgets.DateChooser#getBaseButtonStyle baseButtonStyle}.
     *
     * @param baseWeekdayStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "dateChooserWeekday"
     */
    public void setBaseWeekdayStyle(String baseWeekdayStyle) {
        setAttribute("baseWeekdayStyle", baseWeekdayStyle, true);
    }

    /**
     * Base CSS style applied to weekdays. Will have "Over", "Selected" and "Down" suffix appended as the user interacts with
     * buttons.  Defaults to {@link com.smartgwt.client.widgets.DateChooser#getBaseButtonStyle baseButtonStyle}.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getBaseWeekdayStyle()  {
        return getAttributeAsString("baseWeekdayStyle");
    }
    

    /**
     * Base CSS style applied to weekends. Will have "Over", "Selected" and "Down" suffix appended as the user interacts with
     * buttons.  Defaults to {@link com.smartgwt.client.widgets.DateChooser#getBaseWeekdayStyle baseWeekdayStyle}.
     *
     * @param baseWeekendStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "dateChooserWeekend"
     */
    public void setBaseWeekendStyle(String baseWeekendStyle) {
        setAttribute("baseWeekendStyle", baseWeekendStyle, true);
    }

    /**
     * Base CSS style applied to weekends. Will have "Over", "Selected" and "Down" suffix appended as the user interacts with
     * buttons.  Defaults to {@link com.smartgwt.client.widgets.DateChooser#getBaseWeekdayStyle baseWeekdayStyle}.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getBaseWeekendStyle()  {
        return getAttributeAsString("baseWeekendStyle");
    }
    

    /**
     * Base CSS style applied to cells in the {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser fiscal week
     * column}.
     *
     * @param baseWeekStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "dateChooserWeekCell"
     */
    public void setBaseWeekStyle(String baseWeekStyle) {
        setAttribute("baseWeekStyle", baseWeekStyle, true);
    }

    /**
     * Base CSS style applied to cells in the {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser fiscal week
     * column}.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
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
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return HLayout
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public HLayout getButtonLayout() throws IllegalStateException {
        errorIfNotCreated("buttonLayout");
        return (HLayout)HLayout.getByJSObject(getAttributeAsJavaScriptObject("buttonLayout"));
    }
    

    /**
     * A button shown below the {@link com.smartgwt.client.widgets.grid.DateGrid calendar grid} which, when clicked,  closes
     * the DateChooser without selecting a value.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getCancelButton() throws IllegalStateException {
        errorIfNotCreated("cancelButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("cancelButton"));
    }
    

    /**
     * Title for the cancellation button.
     *
     * @param cancelButtonTitle  Default value is "Cancel"
     */
    public void setCancelButtonTitle(String cancelButtonTitle) {
        setAttribute("cancelButtonTitle", cancelButtonTitle, true);
    }

    /**
     * Title for the cancellation button.
     *
     * @return String
     */
    public String getCancelButtonTitle()  {
        return getAttributeAsString("cancelButtonTitle");
    }
    

    /**
     * Should this dateChooser be dismissed if the user presses the Escape key?
     *
     * @param closeOnEscapeKeypress  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCloseOnEscapeKeypress(boolean closeOnEscapeKeypress)  throws IllegalStateException {
        setAttribute("closeOnEscapeKeypress", closeOnEscapeKeypress, false);
    }

    /**
     * Should this dateChooser be dismissed if the user presses the Escape key?
     *
     * @return boolean
     */
    public boolean getCloseOnEscapeKeypress()  {
        Boolean result = getAttributeAsBoolean("closeOnEscapeKeypress");
        return result == null ? false : result;
    }
    

    /**
     * A {@link com.smartgwt.client.widgets.grid.ListGrid} subclass, responsible for rendering the calendar view.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return DateGrid
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public DateGrid getDateGrid() throws IllegalStateException {
        errorIfNotCreated("dateGrid");
        return (DateGrid)DateGrid.getByJSObject(getAttributeAsJavaScriptObject("dateGrid"));
    }
    

    /**
     * How long (how many characters) should be day names be. May be 1, 2 or 3 characters.
     *
     * @param dayNameLength  Default value is 2
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDayNameLength(int dayNameLength)  throws IllegalStateException {
        setAttribute("dayNameLength", dayNameLength, false);
    }

    /**
     * How long (how many characters) should be day names be. May be 1, 2 or 3 characters.
     *
     * @return int
     */
    public int getDayNameLength()  {
        return getAttributeAsInt("dayNameLength");
    }
    

    /**
     * An array of Date instances that should be disabled if they appear in the calendar view.
     *
     * @param disabledDates  Default value is null
     */
    public void setDisabledDates(Date... disabledDates) {
        setAttribute("disabledDates", disabledDates, true);
    }

    /**
     * An array of Date instances that should be disabled if they appear in the calendar view.
     *
     * @return Date...
     */
    public Date[] getDisabledDates()  {
        return com.smartgwt.client.util.ConvertTo.arrayOfDate(getAttributeAsJavaScriptObject("disabledDates"));
    }
    

    /**
     * Base CSS style applied to weekday dates which have been {@link com.smartgwt.client.widgets.DateChooser#getDisabledDates
     * disabled}.
     *
     * @param disabledWeekdayStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "dateChooserDisabledWeekday"
     */
    public void setDisabledWeekdayStyle(String disabledWeekdayStyle) {
        setAttribute("disabledWeekdayStyle", disabledWeekdayStyle, true);
    }

    /**
     * Base CSS style applied to weekday dates which have been {@link com.smartgwt.client.widgets.DateChooser#getDisabledDates
     * disabled}.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getDisabledWeekdayStyle()  {
        return getAttributeAsString("disabledWeekdayStyle");
    }
    

    /**
     * Base CSS style applied to weekend dates which have been {@link com.smartgwt.client.widgets.DateChooser#getDisabledDates
     * disabled}.
     *
     * @param disabledWeekendStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "dateChooserDisabledWeekend"
     */
    public void setDisabledWeekendStyle(String disabledWeekendStyle) {
        setAttribute("disabledWeekendStyle", disabledWeekendStyle, true);
    }

    /**
     * Base CSS style applied to weekend dates which have been {@link com.smartgwt.client.widgets.DateChooser#getDisabledDates
     * disabled}.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getDisabledWeekendStyle()  {
        return getAttributeAsString("disabledWeekendStyle");
    }
    

    /**
     * Whether it should be valid to pick a weekend day.  If set to true, weekend days appear in disabled style and cannot be
     * picked.  <P> Which days are considered weekends is controlled by {@link com.smartgwt.client.util.Date#weekendDays
     * weekendDays}.
     *
     * @param disableWeekends  Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setDisableWeekends(Boolean disableWeekends)  throws IllegalStateException {
        setAttribute("disableWeekends", disableWeekends, false);
    }

    /**
     * Whether it should be valid to pick a weekend day.  If set to true, weekend days appear in disabled style and cannot be
     * picked.  <P> Which days are considered weekends is controlled by {@link com.smartgwt.client.util.Date#weekendDays
     * weekendDays}.
     *
     * @return Boolean
     */
    public Boolean getDisableWeekends()  {
        Boolean result = getAttributeAsBoolean("disableWeekends");
        return result == null ? false : result;
    }
    

    /**
     * Last year that may be selected.
     *
     * @param endYear  Default value is 2020
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEndYear(int endYear)  throws IllegalStateException {
        setAttribute("endYear", endYear, false);
    }

    /**
     * Last year that may be selected.
     *
     * @return int
     */
    public int getEndYear()  {
        return getAttributeAsInt("endYear");
    }
    

    /**
     * Day of the week to show in the first column.  0=Sunday, 1=Monday, ..., 6=Saturday.  The default value for this attribute
     * is picked up from the current locale and can also be  altered system-wide with the {@link
     * com.smartgwt.client.util.Date#setFirstDayOfWeek global setter}.
     *
     * @param firstDayOfWeek  Default value is 0
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public void setFirstDayOfWeek(int firstDayOfWeek)  throws IllegalStateException {
        setAttribute("firstDayOfWeek", firstDayOfWeek, false);
    }

    /**
     * Day of the week to show in the first column.  0=Sunday, 1=Monday, ..., 6=Saturday.  The default value for this attribute
     * is picked up from the current locale and can also be  altered system-wide with the {@link
     * com.smartgwt.client.util.Date#setFirstDayOfWeek global setter}.
     *
     * @return int
     * @see com.smartgwt.client.docs.Appearance Appearance overview and related methods
     */
    public int getFirstDayOfWeek()  {
        return getAttributeAsInt("firstDayOfWeek");
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} which,  when
     * clicked, shows a picker for selecting a specific fiscal year.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
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
     * @param fiscalYearFieldTitle  Default value is "Year"
     */
    public void setFiscalYearFieldTitle(String fiscalYearFieldTitle) {
        setAttribute("fiscalYearFieldTitle", fiscalYearFieldTitle, true);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser fiscal year} field in the date
     * grid.
     *
     * @return String
     */
    public String getFiscalYearFieldTitle()  {
        return getAttributeAsString("fiscalYearFieldTitle");
    }
    

    /**
     * Base CSS style applied to the header of the  {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser
     * fiscal year column} in the  {@link com.smartgwt.client.widgets.DateChooser#getDateGrid calendar view}.
     *
     * @param fiscalYearHeaderStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     */
    public void setFiscalYearHeaderStyle(String fiscalYearHeaderStyle) {
        setAttribute("fiscalYearHeaderStyle", fiscalYearHeaderStyle, true);
    }

    /**
     * Base CSS style applied to the header of the  {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser
     * fiscal year column} in the  {@link com.smartgwt.client.widgets.DateChooser#getDateGrid calendar view}.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getFiscalYearHeaderStyle()  {
        return getAttributeAsString("fiscalYearHeaderStyle");
    }
    

    /**
     * Height of the header area (containing the navigation buttons) in pixels.
     *
     * @param headerHeight  Default value is 20
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @deprecated in favor of {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayoutHeight navigationLayoutHeight}
     */
    public void setHeaderHeight(Integer headerHeight)  throws IllegalStateException {
        setAttribute("headerHeight", headerHeight, false);
    }

    /**
     * Height of the header area (containing the navigation buttons) in pixels.
     *
     * @return Integer
     * @deprecated in favor of {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayoutHeight navigationLayoutHeight}
     */
    public Integer getHeaderHeight()  {
        return getAttributeAsInt("headerHeight");
    }
    

    /**
     * CSS style applied to the day-of-week headers. By default this applies to all days of the  week. To apply a separate
     * style to weekend headers, set  {@link com.smartgwt.client.widgets.DateChooser#getWeekendHeaderStyle weekendHeaderStyle}
     *
     * @param headerStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "dateChooserButtonDisabled"
     */
    public void setHeaderStyle(String headerStyle) {
        setAttribute("headerStyle", headerStyle, true);
    }

    /**
     * CSS style applied to the day-of-week headers. By default this applies to all days of the  week. To apply a separate
     * style to weekend headers, set  {@link com.smartgwt.client.widgets.DateChooser#getWeekendHeaderStyle weekendHeaderStyle}
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getHeaderStyle()  {
        return getAttributeAsString("headerStyle");
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} that shows 
     * a picker for selecting a specific month.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getMonthChooserButton() throws IllegalStateException {
        errorIfNotCreated("monthChooserButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("monthChooserButton"));
    }
    

    /**
     * Style for the pop-up year menu.
     *
     * @param monthMenuStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "dateChooserMonthMenu"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setMonthMenuStyle(String monthMenuStyle)  throws IllegalStateException {
        setAttribute("monthMenuStyle", monthMenuStyle, false);
    }

    /**
     * Style for the pop-up year menu.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
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
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return HLayout
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
     * @param navigationLayoutHeight  Default value is 20
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
     * @return int
     * @deprecated in favor of {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayoutHeight navigationLayoutHeight}
     */
    public int getNavigationLayoutHeight()  {
        return getAttributeAsInt("navigationLayoutHeight");
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} that shifts
     * the calendar view forward by a month.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getNextMonthButton() throws IllegalStateException {
        errorIfNotCreated("nextMonthButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("nextMonthButton"));
    }
    

    /**
     * Icon for the next month button
     *
     * @param nextMonthIcon  Default value is "[SKIN]arrow_right.gif"
     */
    public void setNextMonthIcon(String nextMonthIcon) {
        setAttribute("nextMonthIcon", nextMonthIcon, true);
    }

    /**
     * Icon for the next month button
     *
     * @return String
     */
    public String getNextMonthIcon()  {
        return getAttributeAsString("nextMonthIcon");
    }
    

    /**
     * Height of the icon for the next month button
     *
     * @param nextMonthIconHeight  Default value is 7
     */
    public void setNextMonthIconHeight(int nextMonthIconHeight) {
        setAttribute("nextMonthIconHeight", nextMonthIconHeight, true);
    }

    /**
     * Height of the icon for the next month button
     *
     * @return int
     */
    public int getNextMonthIconHeight()  {
        return getAttributeAsInt("nextMonthIconHeight");
    }
    

    /**
     * Icon for the next month button
     *
     * @param nextMonthIconRTL  Default value is null
     */
    public void setNextMonthIconRTL(String nextMonthIconRTL) {
        setAttribute("nextMonthIconRTL", nextMonthIconRTL, true);
    }

    /**
     * Icon for the next month button
     *
     * @return String
     */
    public String getNextMonthIconRTL()  {
        return getAttributeAsString("nextMonthIconRTL");
    }
    

    /**
     * Width of the icon for the next month button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL} is true. If not
     * set, and the page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextMonthIcon nextMonthIcon}
     * will be used in place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevMonthIcon prevMonthIcon} and vice
     * versa.
     *
     * @param nextMonthIconWidth  Default value is 7
     */
    public void setNextMonthIconWidth(int nextMonthIconWidth) {
        setAttribute("nextMonthIconWidth", nextMonthIconWidth, true);
    }

    /**
     * Width of the icon for the next month button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL} is true. If not
     * set, and the page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextMonthIcon nextMonthIcon}
     * will be used in place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevMonthIcon prevMonthIcon} and vice
     * versa.
     *
     * @return int
     */
    public int getNextMonthIconWidth()  {
        return getAttributeAsInt("nextMonthIconWidth");
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} that shifts
     * the calendar view forward by a year.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getNextYearButton() throws IllegalStateException {
        errorIfNotCreated("nextYearButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("nextYearButton"));
    }
    

    /**
     * Icon for the next year button
     *
     * @param nextYearIcon  Default value is "[SKIN]doubleArrow_right.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.DateChooser#setShowDoubleYearIcon
     */
    public void setNextYearIcon(String nextYearIcon)  throws IllegalStateException {
        setAttribute("nextYearIcon", nextYearIcon, false);
    }

    /**
     * Icon for the next year button
     *
     * @return String
     * @see com.smartgwt.client.widgets.DateChooser#getShowDoubleYearIcon
     */
    public String getNextYearIcon()  {
        return getAttributeAsString("nextYearIcon");
    }
    

    /**
     * Height of the icon for the next year button
     *
     * @param nextYearIconHeight  Default value is 7
     */
    public void setNextYearIconHeight(int nextYearIconHeight) {
        setAttribute("nextYearIconHeight", nextYearIconHeight, true);
    }

    /**
     * Height of the icon for the next year button
     *
     * @return int
     */
    public int getNextYearIconHeight()  {
        return getAttributeAsInt("nextYearIconHeight");
    }
    

    /**
     * Icon for the next year button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL} is true. If not set, and the
     * page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextYearIcon nextYearIcon} will be used in
     * place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevYearIcon prevYearIcon} and vice versa.
     *
     * @param nextYearIconRTL  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.DateChooser#setShowDoubleYearIcon
     */
    public void setNextYearIconRTL(String nextYearIconRTL)  throws IllegalStateException {
        setAttribute("nextYearIconRTL", nextYearIconRTL, false);
    }

    /**
     * Icon for the next year button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL} is true. If not set, and the
     * page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextYearIcon nextYearIcon} will be used in
     * place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevYearIcon prevYearIcon} and vice versa.
     *
     * @return String
     * @see com.smartgwt.client.widgets.DateChooser#getShowDoubleYearIcon
     */
    public String getNextYearIconRTL()  {
        return getAttributeAsString("nextYearIconRTL");
    }
    

    /**
     * Width of the icon for the next year button
     *
     * @param nextYearIconWidth  Default value is 14
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setNextYearIconWidth(int nextYearIconWidth)  throws IllegalStateException {
        setAttribute("nextYearIconWidth", nextYearIconWidth, false);
    }

    /**
     * Width of the icon for the next year button
     *
     * @return int
     */
    public int getNextYearIconWidth()  {
        return getAttributeAsInt("nextYearIconWidth");
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} that shifts
     * the calendar view backward by a month.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
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
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getPreviousYearButton() throws IllegalStateException {
        errorIfNotCreated("previousYearButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("previousYearButton"));
    }
    

    /**
     * Icon for the previous month button
     *
     * @param prevMonthIcon  Default value is "[SKIN]arrow_left.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPrevMonthIcon(String prevMonthIcon)  throws IllegalStateException {
        setAttribute("prevMonthIcon", prevMonthIcon, false);
    }

    /**
     * Icon for the previous month button
     *
     * @return String
     */
    public String getPrevMonthIcon()  {
        return getAttributeAsString("prevMonthIcon");
    }
    

    /**
     * Height of the icon for the previous month button
     *
     * @param prevMonthIconHeight  Default value is 7
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPrevMonthIconHeight(int prevMonthIconHeight)  throws IllegalStateException {
        setAttribute("prevMonthIconHeight", prevMonthIconHeight, false);
    }

    /**
     * Height of the icon for the previous month button
     *
     * @return int
     */
    public int getPrevMonthIconHeight()  {
        return getAttributeAsInt("prevMonthIconHeight");
    }
    

    /**
     * Icon for the previous month button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL} is true. If not set, and
     * the page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextMonthIcon nextMonthIcon} will be used
     * in place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevMonthIcon prevMonthIcon} and vice versa.
     *
     * @param prevMonthIconRTL  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPrevMonthIconRTL(String prevMonthIconRTL)  throws IllegalStateException {
        setAttribute("prevMonthIconRTL", prevMonthIconRTL, false);
    }

    /**
     * Icon for the previous month button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL} is true. If not set, and
     * the page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextMonthIcon nextMonthIcon} will be used
     * in place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevMonthIcon prevMonthIcon} and vice versa.
     *
     * @return String
     */
    public String getPrevMonthIconRTL()  {
        return getAttributeAsString("prevMonthIconRTL");
    }
    

    /**
     * Width of the icon for the previous month button
     *
     * @param prevMonthIconWidth  Default value is 7
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPrevMonthIconWidth(int prevMonthIconWidth)  throws IllegalStateException {
        setAttribute("prevMonthIconWidth", prevMonthIconWidth, false);
    }

    /**
     * Width of the icon for the previous month button
     *
     * @return int
     */
    public int getPrevMonthIconWidth()  {
        return getAttributeAsInt("prevMonthIconWidth");
    }
    

    /**
     * Icon for the previous year button
     *
     * @param prevYearIcon  Default value is "[SKIN]doubleArrow_left.gif"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.DateChooser#setShowDoubleYearIcon
     */
    public void setPrevYearIcon(String prevYearIcon)  throws IllegalStateException {
        setAttribute("prevYearIcon", prevYearIcon, false);
    }

    /**
     * Icon for the previous year button
     *
     * @return String
     * @see com.smartgwt.client.widgets.DateChooser#getShowDoubleYearIcon
     */
    public String getPrevYearIcon()  {
        return getAttributeAsString("prevYearIcon");
    }
    

    /**
     * Height of the icon for the previous year button
     *
     * @param prevYearIconHeight  Default value is 7
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPrevYearIconHeight(int prevYearIconHeight)  throws IllegalStateException {
        setAttribute("prevYearIconHeight", prevYearIconHeight, false);
    }

    /**
     * Height of the icon for the previous year button
     *
     * @return int
     */
    public int getPrevYearIconHeight()  {
        return getAttributeAsInt("prevYearIconHeight");
    }
    

    /**
     * Icon for the previous year button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL} is true. If not set, and the
     * page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextYearIcon nextYearIcon} will be used in
     * place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevYearIcon prevYearIcon} and vice versa.
     *
     * @param prevYearIconRTL  Default value is null
     * @see com.smartgwt.client.widgets.DateChooser#setShowDoubleYearIcon
     */
    public void setPrevYearIconRTL(String prevYearIconRTL) {
        setAttribute("prevYearIconRTL", prevYearIconRTL, true);
    }

    /**
     * Icon for the previous year button if {@link com.smartgwt.client.util.Page#isRTL Page.isRTL} is true. If not set, and the
     * page is in RTL mode, the {@link com.smartgwt.client.widgets.DateChooser#getNextYearIcon nextYearIcon} will be used in
     * place of the {@link com.smartgwt.client.widgets.DateChooser#getPrevYearIcon prevYearIcon} and vice versa.
     *
     * @return String
     * @see com.smartgwt.client.widgets.DateChooser#getShowDoubleYearIcon
     */
    public String getPrevYearIconRTL()  {
        return getAttributeAsString("prevYearIconRTL");
    }
    

    /**
     * Width of the icon for the previous year button
     *
     * @param prevYearIconWidth  Default value is 14
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPrevYearIconWidth(int prevYearIconWidth)  throws IllegalStateException {
        setAttribute("prevYearIconWidth", prevYearIconWidth, false);
    }

    /**
     * Width of the icon for the previous year button
     *
     * @return int
     */
    public int getPrevYearIconWidth()  {
        return getAttributeAsInt("prevYearIconWidth");
    }
    

    /**
     * CSS style applied to the Fiscal Year and Week columns for the currently selected week  (the one being displayed in the
     * {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser week chooser}).
     *
     * @param selectedWeekStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "dateChooserSelectedWeek"
     */
    public void setSelectedWeekStyle(String selectedWeekStyle) {
        setAttribute("selectedWeekStyle", selectedWeekStyle, true);
    }

    /**
     * CSS style applied to the Fiscal Year and Week columns for the currently selected week  (the one being displayed in the
     * {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser week chooser}).
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getSelectedWeekStyle()  {
        return getAttributeAsString("selectedWeekStyle");
    }
    

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.DateChooser#getApplyButton applyButton} will be displayed.
     *
     * @param showApplyButton  Default value is null
     */
    public void setShowApplyButton(Boolean showApplyButton) {
        setAttribute("showApplyButton", showApplyButton, true);
    }

    /**
     * Determines whether the {@link com.smartgwt.client.widgets.DateChooser#getApplyButton applyButton} will be displayed.
     *
     * @return Boolean
     */
    public Boolean getShowApplyButton()  {
        return getAttributeAsBoolean("showApplyButton");
    }
    

    /**
     * Determines whether the "Cancel" button will be displayed.
     *
     * @param showCancelButton  Default value is false
     */
    public void setShowCancelButton(Boolean showCancelButton) {
        setAttribute("showCancelButton", showCancelButton, true);
    }

    /**
     * Determines whether the "Cancel" button will be displayed.
     *
     * @return Boolean
     */
    public Boolean getShowCancelButton()  {
        Boolean result = getAttributeAsBoolean("showCancelButton");
        return result == null ? false : result;
    }
    
    

    /**
     * When set to true, show a button that allows the calendar to be navigated by fiscal year.
     *
     * @param showFiscalYearChooser  Default value is false
     */
    public void setShowFiscalYearChooser(Boolean showFiscalYearChooser) {
        setAttribute("showFiscalYearChooser", showFiscalYearChooser, true);
    }

    /**
     * When set to true, show a button that allows the calendar to be navigated by fiscal year.
     *
     * @return Boolean
     */
    public Boolean getShowFiscalYearChooser()  {
        Boolean result = getAttributeAsBoolean("showFiscalYearChooser");
        return result == null ? false : result;
    }
    

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field}, whether to show the "second" 
     * picker.  When unset, the second field is not shown.
     *
     * @param showSecondItem  Default value is null
     */
    public void setShowSecondItem(Boolean showSecondItem) {
        setAttribute("showSecondItem", showSecondItem, true);
    }

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field}, whether to show the "second" 
     * picker.  When unset, the second field is not shown.
     *
     * @return Boolean
     */
    public Boolean getShowSecondItem()  {
        return getAttributeAsBoolean("showSecondItem");
    }
    

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field} for editing the time portion
     * of the date.  When unset, the time field is shown automatically if the field type is "datetime".
     *
     * @param showTimeItem  Default value is null
     */
    public void setShowTimeItem(Boolean showTimeItem) {
        setAttribute("showTimeItem", showTimeItem, true);
    }

    /**
     * Whether to show the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field} for editing the time portion
     * of the date.  When unset, the time field is shown automatically if the field type is "datetime".
     *
     * @return Boolean
     */
    public Boolean getShowTimeItem()  {
        return getAttributeAsBoolean("showTimeItem");
    }
    

    /**
     * Determines whether the "Today" button will be displayed, allowing the user to select  the current date.
     *
     * @param showTodayButton  Default value is true
     */
    public void setShowTodayButton(Boolean showTodayButton) {
        setAttribute("showTodayButton", showTodayButton, true);
    }

    /**
     * Determines whether the "Today" button will be displayed, allowing the user to select  the current date.
     *
     * @return Boolean
     */
    public Boolean getShowTodayButton()  {
        Boolean result = getAttributeAsBoolean("showTodayButton");
        return result == null ? true : result;
    }
    

    /**
     * When set to true, show a button that allows the calendar to be navigated by week or fiscal week, depending on the value
     * of {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser showFiscalYearChooser}.
     *
     * @param showWeekChooser  Default value is false
     */
    public void setShowWeekChooser(Boolean showWeekChooser) {
        setAttribute("showWeekChooser", showWeekChooser, true);
    }

    /**
     * When set to true, show a button that allows the calendar to be navigated by week or fiscal week, depending on the value
     * of {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser showFiscalYearChooser}.
     *
     * @return Boolean
     */
    public Boolean getShowWeekChooser()  {
        Boolean result = getAttributeAsBoolean("showWeekChooser");
        return result == null ? false : result;
    }
    

    /**
     * Whether weekend days should be shown.  Which days are considered weekends is controlled by {@link
     * com.smartgwt.client.util.Date#weekendDays weekendDays}.
     *
     * @param showWeekends  Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setShowWeekends(Boolean showWeekends)  throws IllegalStateException {
        setAttribute("showWeekends", showWeekends, false);
    }

    /**
     * Whether weekend days should be shown.  Which days are considered weekends is controlled by {@link
     * com.smartgwt.client.util.Date#weekendDays weekendDays}.
     *
     * @return Boolean
     */
    public Boolean getShowWeekends()  {
        Boolean result = getAttributeAsBoolean("showWeekends");
        return result == null ? true : result;
    }
    

    /**
     * Overridden directory where images for this widget (such as the month and year button icons) may be found.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param skinImgDir  Default value is "images/common/"
     */
    public void setSkinImgDir(String skinImgDir) {
        setAttribute("skinImgDir", skinImgDir, true);
    }

    /**
     * Overridden directory where images for this widget (such as the month and year button icons) may be found.
     *
     * @return String
     */
    public String getSkinImgDir()  {
        return getAttributeAsString("skinImgDir");
    }
    

    /**
     * Earliest year that may be selected.
     *
     * @param startYear  Default value is 1995
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setStartYear(int startYear)  throws IllegalStateException {
        setAttribute("startYear", startYear, false);
    }

    /**
     * Earliest year that may be selected.
     *
     * @return int
     */
    public int getStartYear()  {
        return getAttributeAsInt("startYear");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.form.fields.TimeItem} for editing the time portion of dates.  Visible by default for
     * fields  of type "datetime" and can be controlled by setting {@link
     * com.smartgwt.client.widgets.DateChooser#getShowTimeItem showTimeItem}.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return TimeItem
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
     * @param timeItemProperties  Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setTimeItemProperties(TimeItem timeItemProperties)  throws IllegalStateException {
        setAttribute("timeItemProperties", timeItemProperties.getJsObj(), false);
    }

    /**
     * Custom properties to apply to the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field} used  for
     * editing the time portion of the date.
     *
     * @return TimeItem
     */
    public TimeItem getTimeItemProperties()  {
        return TimeItem.getOrCreateRef(getAttributeAsJavaScriptObject("timeItemProperties"));
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field}.
     *
     * @param timeItemTitle  Default value is "Time"
     */
    public void setTimeItemTitle(String timeItemTitle) {
        setAttribute("timeItemTitle", timeItemTitle, true);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getTimeItem time field}.
     *
     * @return String
     */
    public String getTimeItemTitle()  {
        return getAttributeAsString("timeItemTitle");
    }
    

    /**
     * A button shown below the {@link com.smartgwt.client.widgets.grid.DateGrid calendar grid} which, when clicked,  navigates
     * the calendar to today.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getTodayButton() throws IllegalStateException {
        errorIfNotCreated("todayButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("todayButton"));
    }
    

    /**
     * If set specifies a fixed height for the Today and Cancel buttons.
     *
     * @param todayButtonHeight  Default value is null
     */
    public void setTodayButtonHeight(Integer todayButtonHeight) {
        setAttribute("todayButtonHeight", todayButtonHeight, true);
    }

    /**
     * If set specifies a fixed height for the Today and Cancel buttons.
     *
     * @return Integer
     */
    public Integer getTodayButtonHeight()  {
        return getAttributeAsInt("todayButtonHeight");
    }
    

    /**
     * Title for "Today" button.
     *
     * @param todayButtonTitle  Default value is "Today"
     */
    public void setTodayButtonTitle(String todayButtonTitle) {
        setAttribute("todayButtonTitle", todayButtonTitle, true);
    }

    /**
     * Title for "Today" button.
     *
     * @return String
     */
    public String getTodayButtonTitle()  {
        return getAttributeAsString("todayButtonTitle");
    }
    

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser#getShowTimeItem time field}, whether the  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} should be set to use 24-hour time.  The default is true.
     *
     * @param use24HourTime  Default value is true
     */
    public void setUse24HourTime(Boolean use24HourTime) {
        setAttribute("use24HourTime", use24HourTime, true);
    }

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser#getShowTimeItem time field}, whether the  {@link
     * com.smartgwt.client.widgets.form.fields.TimeItem TimeItem} should be set to use 24-hour time.  The default is true.
     *
     * @return Boolean
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
     * @param useFirstDayOfFiscalWeek  Default value is true
     */
    public void setUseFirstDayOfFiscalWeek(Boolean useFirstDayOfFiscalWeek) {
        setAttribute("useFirstDayOfFiscalWeek", useFirstDayOfFiscalWeek, true);
    }

    /**
     * When showing the {@link com.smartgwt.client.widgets.DateChooser#getShowFiscalYearChooser fiscal year chooser}, should
     * firstDayOfWeek be defaulted to the same day as the fiscal start date?  If true and a fiscal year  starts on a Tuesday,
     * the calendar will display Tuesday to Monday from left to right.
     *
     * @return Boolean
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
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getWeekChooserButton() throws IllegalStateException {
        errorIfNotCreated("weekChooserButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("weekChooserButton"));
    }
    

    /**
     * Optional CSS style applied to the day-of-week headers for weekend days. If unset  {@link
     * com.smartgwt.client.widgets.DateChooser#getHeaderStyle headerStyle} will be applied to both weekdays and weekend days.
     *
     * @param weekendHeaderStyle  Default value is null
     */
    public void setWeekendHeaderStyle(String weekendHeaderStyle) {
        setAttribute("weekendHeaderStyle", weekendHeaderStyle, true);
    }

    /**
     * Optional CSS style applied to the day-of-week headers for weekend days. If unset  {@link
     * com.smartgwt.client.widgets.DateChooser#getHeaderStyle headerStyle} will be applied to both weekdays and weekend days.
     *
     * @return String
     */
    public String getWeekendHeaderStyle()  {
        return getAttributeAsString("weekendHeaderStyle");
    }
    

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser week} field in the date grid.
     *
     * @param weekFieldTitle  Default value is "Wk"
     */
    public void setWeekFieldTitle(String weekFieldTitle) {
        setAttribute("weekFieldTitle", weekFieldTitle, true);
    }

    /**
     * Title for the {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser week} field in the date grid.
     *
     * @return String
     */
    public String getWeekFieldTitle()  {
        return getAttributeAsString("weekFieldTitle");
    }
    

    /**
     * Base CSS style applied to the header of the  {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser fiscal or
     * calendar week column} in the {@link com.smartgwt.client.widgets.DateChooser#getDateGrid calendar view}.
     *
     * @param weekHeaderStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is null
     */
    public void setWeekHeaderStyle(String weekHeaderStyle) {
        setAttribute("weekHeaderStyle", weekHeaderStyle, true);
    }

    /**
     * Base CSS style applied to the header of the  {@link com.smartgwt.client.widgets.DateChooser#getShowWeekChooser fiscal or
     * calendar week column} in the {@link com.smartgwt.client.widgets.DateChooser#getDateGrid calendar view}.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getWeekHeaderStyle()  {
        return getAttributeAsString("weekHeaderStyle");
    }
    

    /**
     * Style for the pop-up week menu.
     *
     * @param weekMenuStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "dateChooserWeekMenu"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setWeekMenuStyle(String weekMenuStyle)  throws IllegalStateException {
        setAttribute("weekMenuStyle", weekMenuStyle, false);
    }

    /**
     * Style for the pop-up week menu.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getWeekMenuStyle()  {
        return getAttributeAsString("weekMenuStyle");
    }
    

    /**
     * A button shown in the {@link com.smartgwt.client.widgets.DateChooser#getNavigationLayout navigation layout} that shows 
     * a picker for selecting a specific calendar year.
     * <p>
     * For an overview of how to use and configure AutoChildren, see {@link com.smartgwt.client.docs.AutoChildUsage Using AutoChildren}.
     *
     * @return IButton
     * @throws IllegalStateException if this widget has not yet been rendered.
     */
    public IButton getYearChooserButton() throws IllegalStateException {
        errorIfNotCreated("yearChooserButton");
        return (IButton)IButton.getByJSObject(getAttributeAsJavaScriptObject("yearChooserButton"));
    }
    

    /**
     * Style for the pop-up year menu.
     *
     * @param yearMenuStyle  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} . Default value is "dateChooserYearMenu"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setYearMenuStyle(String yearMenuStyle)  throws IllegalStateException {
        setAttribute("yearMenuStyle", yearMenuStyle, false);
    }

    /**
     * Style for the pop-up year menu.
     *
     * @return  See {@link com.smartgwt.client.docs.CSSStyleName CSSStyleName} 
     */
    public String getYearMenuStyle()  {
        return getAttributeAsString("yearMenuStyle");
    }
    

    // ********************* Methods ***********************
	/**
     * Fired when the user clicks the cancel button in this date chooser. Default implementation clears the date chooser.
     */
    public native void cancelClick() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.cancelClick();
    }-*/;

    /**
     * Add a dataChanged handler.
     * <p>
     * Method to override or observe in order to be notified when a user picks a date value. <P> Has no default behavior (so no
     * need to call Super). <P> Use {@link com.smartgwt.client.widgets.DateChooser#getData DateChooser.getData} to get the
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
        var obj = null;
        var selfJ = this;
        var dataChanged = $entry(function(){
            var param = {};

                var event = @com.smartgwt.client.widgets.events.DataChangedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({dataChanged:  dataChanged              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.dataChanged =  dataChanged             ;
        }
   }-*/;
	/**
     * Get the current value of the picker. <P> See {@link com.smartgwt.client.widgets.DateChooser#addDataChangedHandler
     * DateChooser.dataChanged} for how to respond to the user picking a date.
     *
     * @return current date
     */
    public native Date getData() /*-{
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
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setData(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptDate(Ljava/util/Date;)(date));
    }-*/;


	/**
     * Sets the {@link com.smartgwt.client.widgets.FiscalCalendar} object that will be used by this DateChooser.  If unset, the
     * _link{Date.getFiscalCalendar, global fiscal calendar} is used.
     */
    public native void setFiscalCalendar() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFiscalCalendar();
    }-*/;

	/**
     * Sets the {@link com.smartgwt.client.widgets.FiscalCalendar} object that will be used by this DateChooser.  If unset, the
     * _link{Date.getFiscalCalendar, global fiscal calendar} is used.
     * @param fiscalCalendar the fiscal calendar for this chooser
     */
    public native void setFiscalCalendar(FiscalCalendar fiscalCalendar) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.setFiscalCalendar(fiscalCalendar == null ? null : fiscalCalendar.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Fired when the user clicks the Today button. Default implementation will select the current date in the date chooser.
     */
    public native void todayClick() /*-{
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
     */
    public static native void setDefaultProperties(DateChooser dateChooserProperties) /*-{
    	var properties = $wnd.isc.addProperties({},dateChooserProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()());
        @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,false);
        $wnd.isc.DateChooser.addProperties(properties);
    }-*/;

    // ***********************************************************

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
            s.cancelButtonTitle = getAttributeAsString("cancelButtonTitle");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.cancelButtonTitle:" + t.getMessage() + "\n";
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
            s.timeItemProperties = getAttributeAsString("timeItemProperties");
        } catch (Throwable t) {
            s.logicalStructureErrors += "DateChooser.timeItemProperties:" + t.getMessage() + "\n";
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

    public LogicalStructureObject getLogicalStructure() {
        DateChooserLogicalStructure s = new DateChooserLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}

