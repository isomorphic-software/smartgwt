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
 
package com.smartgwt.client.rpc;


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


/**
 * Controls what class and instance substitutions, if any, are applied during a call to {@link
 * com.smartgwt.client.rpc.RPCManager#createScreen RPCManager.createScreen()}.  Classes and instances can be mapped
 * (constructed as) other classes, and existing widget instances can be returned for new ones.
 * @see com.smartgwt.client.rpc.CreateScreenSettings#getClassSubstitutions
 * @see com.smartgwt.client.rpc.CreateScreenSettings#getComponentSubstitutions
 */
@BeanFactory.FrameworkClass
public class CreateScreenSettings extends DataClass {

    public static CreateScreenSettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new CreateScreenSettings(jsObj);
    }
        


    public CreateScreenSettings(){
        
    }

    public CreateScreenSettings(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * Should  Placeholders be rendered as placeholders? If property is not set actual components are created instead of the
     * Placeholders.
     *
     * @param allowPlaceholders New allowPlaceholders value. Default value is null
     * @return {@link com.smartgwt.client.rpc.CreateScreenSettings CreateScreenSettings} instance, for chaining setter calls
     */
    public CreateScreenSettings setAllowPlaceholders(Boolean allowPlaceholders) {
        return (CreateScreenSettings)setAttribute("allowPlaceholders", allowPlaceholders);
    }

    /**
     * Should  Placeholders be rendered as placeholders? If property is not set actual components are created instead of the
     * Placeholders.
     *
     * @return Current allowPlaceholders value. Default value is null
     */
    public Boolean getAllowPlaceholders()  {
        return getAttributeAsBoolean("allowPlaceholders", true);
    }
    

    /**
     * Maps class names of widgets in the screen to new class names, so that if a widget would normally be constructed as an
     * instance of a class, and that class is in the map, it's instead constructed as an instance of the new class.
     *
     * @param classSubstitutions New classSubstitutions value. Default value is null
     * @return {@link com.smartgwt.client.rpc.CreateScreenSettings CreateScreenSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#createScreen
     */
    public CreateScreenSettings setClassSubstitutions(Map classSubstitutions) {
        return (CreateScreenSettings)setAttribute("classSubstitutions", classSubstitutions);
    }

    /**
     * Maps class names of widgets in the screen to new class names, so that if a widget would normally be constructed as an
     * instance of a class, and that class is in the map, it's instead constructed as an instance of the new class.
     *
     * @return Current classSubstitutions value. Default value is null
     * @see com.smartgwt.client.rpc.RPCManager#createScreen
     */
    public Map getClassSubstitutions()  {
        return getAttributeAsMap("classSubstitutions");
    }
    

    /**
     * Should DataSources referenced by the screen clobber existing, globally-bound DataSources on the client when the screen
     * is created?  The default of false means that any DataSources defined in the screen will be discarded if they collide
     * with existing, globally-bound DataSources. <p> Note that here we consider a DataSource to be "globally bound" if it can
     * be retrieved by ID using the method {@link com.smartgwt.client.data.DataSource#get DataSource.get()}, regardless of
     * whether it's actually bound to the browser <code>window</code> object.
     *
     * @param clobberDataSources New clobberDataSources value. Default value is false
     * @return {@link com.smartgwt.client.rpc.CreateScreenSettings CreateScreenSettings} instance, for chaining setter calls
     */
    public CreateScreenSettings setClobberDataSources(Boolean clobberDataSources) {
        return (CreateScreenSettings)setAttribute("clobberDataSources", clobberDataSources);
    }

    /**
     * Should DataSources referenced by the screen clobber existing, globally-bound DataSources on the client when the screen
     * is created?  The default of false means that any DataSources defined in the screen will be discarded if they collide
     * with existing, globally-bound DataSources. <p> Note that here we consider a DataSource to be "globally bound" if it can
     * be retrieved by ID using the method {@link com.smartgwt.client.data.DataSource#get DataSource.get()}, regardless of
     * whether it's actually bound to the browser <code>window</code> object.
     *
     * @return Current clobberDataSources value. Default value is false
     */
    public Boolean getClobberDataSources()  {
        Boolean result = getAttributeAsBoolean("clobberDataSources", true);
        return result == null ? false : result;
    }
    

    /**
     * Defines the map of new widget  ids to existing class instances, or to new instances that will be of a different class. 
     * A substituted class instance is returned immediately from  Class.create() without modification.  Otherwise, the
     * constructor for the new instance is run, but targeting the substituted class rather than the original. <P> Note that
     * where we return an existing instance, not even its {@link com.smartgwt.client.widgets.Canvas#getID Canvas.ID} will be
     * changed.  An alternative is programmtic replacement using {@link com.smartgwt.client.widgets.layout.Layout#replaceMember
     * Layout.replaceMember()}.
     *
     * @param componentSubstitutions New componentSubstitutions value. Default value is null
     * @return {@link com.smartgwt.client.rpc.CreateScreenSettings CreateScreenSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#createScreen
     */
    public CreateScreenSettings setComponentSubstitutions(Map componentSubstitutions) {
        return (CreateScreenSettings)setAttribute("componentSubstitutions", componentSubstitutions);
    }

    /**
     * Defines the map of new widget  ids to existing class instances, or to new instances that will be of a different class. 
     * A substituted class instance is returned immediately from  Class.create() without modification.  Otherwise, the
     * constructor for the new instance is run, but targeting the substituted class rather than the original. <P> Note that
     * where we return an existing instance, not even its {@link com.smartgwt.client.widgets.Canvas#getID Canvas.ID} will be
     * changed.  An alternative is programmtic replacement using {@link com.smartgwt.client.widgets.layout.Layout#replaceMember
     * Layout.replaceMember()}.
     *
     * @return Current componentSubstitutions value. Default value is null
     * @see com.smartgwt.client.rpc.RPCManager#createScreen
     */
    public Map getComponentSubstitutions()  {
        return getAttributeAsMap("componentSubstitutions");
    }
    

    /**
     * {@link com.smartgwt.client.widgets.DataContext} that will be provided to the top-level component as {@link
     * com.smartgwt.client.widgets.Canvas#getDataContext dataContext} in the screen. <P> To understand how
     * <code>dataContext</code> is used to automatically populate  {@link com.smartgwt.client.widgets.DataBoundComponent
     * DataBoundComponents}, see {@link com.smartgwt.client.widgets.Canvas#getAutoPopulateData Canvas.autoPopulateData}.
     *
     * @param dataContext New dataContext value. Default value is null
     * @return {@link com.smartgwt.client.rpc.CreateScreenSettings CreateScreenSettings} instance, for chaining setter calls
     */
    public CreateScreenSettings setDataContext(DataContext dataContext) {
        return (CreateScreenSettings)setAttribute("dataContext", dataContext == null ? null : dataContext.getJsObj());
    }

    /**
     * {@link com.smartgwt.client.widgets.DataContext} that will be provided to the top-level component as {@link
     * com.smartgwt.client.widgets.Canvas#getDataContext dataContext} in the screen. <P> To understand how
     * <code>dataContext</code> is used to automatically populate  {@link com.smartgwt.client.widgets.DataBoundComponent
     * DataBoundComponents}, see {@link com.smartgwt.client.widgets.Canvas#getAutoPopulateData Canvas.autoPopulateData}.
     *
     * @return Current dataContext value. Default value is null
     */
    public DataContext getDataContext()  {
        return new DataContext(getAttributeAsJavaScriptObject("dataContext"));
    }
    

    /**
     * Simplifies integrating a screen with an existing JavaScript app.  Does the following:
     *  <ul>
     *  <li>Sets {@link com.smartgwt.client.rpc.CreateScreenSettings#getSuppressAutoDraw suppressAutoDraw}: true
     * <li>Sets {@link com.smartgwt.client.widgets.Canvas#getHtmlElement Canvas.htmlElement} of the screen's top widget to the
     * DOM element
     * <li>Sets the screen's top widget to have {@link com.smartgwt.client.widgets.Canvas#getPosition Canvas.position}:
     * "relative"
     *  <li>Draws the screen by calling {@link com.smartgwt.client.widgets.Canvas#draw Canvas.draw()} on the top widget</ul>
     *  If you need to apply additional, custom configuration, for example setting
     * {@link com.smartgwt.client.widgets.Canvas#getHtmlPosition Canvas.htmlPosition}, then instead of using this property, you
     * can call
     * {@link com.smartgwt.client.rpc.RPCManager#createScreen RPCManager.createScreen()} with {@link
     * com.smartgwt.client.rpc.CreateScreenSettings#getSuppressAutoDraw suppressAutoDraw}: true, and then
     *  manually configure and draw the screen:
     *  <pre>
     *      CreateScreenSettings settings = new CreateScreenSettings();
     *      settings.setSuppressAutoDraw(true);
     *      Canvas screen = RPCManager.createScreen("My Screen", settings);
     *      screen.setHtmlElement(element);
     *      screen.setHtmlPosition(DrawPosition.REPLACE);
     *      screen.setPosition(Positioning.RELATIVE);
     *      screen.draw();
     *  </pre>
     *
     * @param htmlElement New htmlElement value. Default value is null
     * @return {@link com.smartgwt.client.rpc.CreateScreenSettings CreateScreenSettings} instance, for chaining setter calls
     */
    public CreateScreenSettings setHtmlElement(Element htmlElement) {
        return (CreateScreenSettings)setAttribute("htmlElement", htmlElement);
    }

    /**
     * Simplifies integrating a screen with an existing JavaScript app.  Does the following:
     *  <ul>
     *  <li>Sets {@link com.smartgwt.client.rpc.CreateScreenSettings#getSuppressAutoDraw suppressAutoDraw}: true
     * <li>Sets {@link com.smartgwt.client.widgets.Canvas#getHtmlElement Canvas.htmlElement} of the screen's top widget to the
     * DOM element
     * <li>Sets the screen's top widget to have {@link com.smartgwt.client.widgets.Canvas#getPosition Canvas.position}:
     * "relative"
     *  <li>Draws the screen by calling {@link com.smartgwt.client.widgets.Canvas#draw Canvas.draw()} on the top widget</ul>
     *  If you need to apply additional, custom configuration, for example setting
     * {@link com.smartgwt.client.widgets.Canvas#getHtmlPosition Canvas.htmlPosition}, then instead of using this property, you
     * can call
     * {@link com.smartgwt.client.rpc.RPCManager#createScreen RPCManager.createScreen()} with {@link
     * com.smartgwt.client.rpc.CreateScreenSettings#getSuppressAutoDraw suppressAutoDraw}: true, and then
     *  manually configure and draw the screen:
     *  <pre>
     *      CreateScreenSettings settings = new CreateScreenSettings();
     *      settings.setSuppressAutoDraw(true);
     *      Canvas screen = RPCManager.createScreen("My Screen", settings);
     *      screen.setHtmlElement(element);
     *      screen.setHtmlPosition(DrawPosition.REPLACE);
     *      screen.setPosition(Positioning.RELATIVE);
     *      screen.draw();
     *  </pre>
     *
     * @return Current htmlElement value. Default value is null
     */
    public Element getHtmlElement()  {
        return getAttributeAsElement("htmlElement");
    }

    /**
     * Simplifies integrating a screen with an existing JavaScript app.  Does the following:
     *  <ul>
     *  <li>Sets {@link com.smartgwt.client.rpc.CreateScreenSettings#getSuppressAutoDraw suppressAutoDraw}: true
     * <li>Sets {@link com.smartgwt.client.widgets.Canvas#getHtmlElement Canvas.htmlElement} of the screen's top widget to the
     * DOM element
     * <li>Sets the screen's top widget to have {@link com.smartgwt.client.widgets.Canvas#getPosition Canvas.position}:
     * "relative"
     *  <li>Draws the screen by calling {@link com.smartgwt.client.widgets.Canvas#draw Canvas.draw()} on the top widget</ul>
     *  If you need to apply additional, custom configuration, for example setting
     * {@link com.smartgwt.client.widgets.Canvas#getHtmlPosition Canvas.htmlPosition}, then instead of using this property, you
     * can call
     * {@link com.smartgwt.client.rpc.RPCManager#createScreen RPCManager.createScreen()} with {@link
     * com.smartgwt.client.rpc.CreateScreenSettings#getSuppressAutoDraw suppressAutoDraw}: true, and then
     *  manually configure and draw the screen:
     *  <pre>
     *      CreateScreenSettings settings = new CreateScreenSettings();
     *      settings.setSuppressAutoDraw(true);
     *      Canvas screen = RPCManager.createScreen("My Screen", settings);
     *      screen.setHtmlElement(element);
     *      screen.setHtmlPosition(DrawPosition.REPLACE);
     *      screen.setPosition(Positioning.RELATIVE);
     *      screen.draw();
     *  </pre>
     *
     * @param htmlElement New htmlElement value. Default value is null
     * @return {@link com.smartgwt.client.rpc.CreateScreenSettings CreateScreenSettings} instance, for chaining setter calls
     */
    public CreateScreenSettings setHtmlElement(String htmlElement) {
        return (CreateScreenSettings)setAttribute("htmlElement", htmlElement);
    }

    /**
     * Simplifies integrating a screen with an existing JavaScript app.  Does the following:
     *  <ul>
     *  <li>Sets {@link com.smartgwt.client.rpc.CreateScreenSettings#getSuppressAutoDraw suppressAutoDraw}: true
     * <li>Sets {@link com.smartgwt.client.widgets.Canvas#getHtmlElement Canvas.htmlElement} of the screen's top widget to the
     * DOM element
     * <li>Sets the screen's top widget to have {@link com.smartgwt.client.widgets.Canvas#getPosition Canvas.position}:
     * "relative"
     *  <li>Draws the screen by calling {@link com.smartgwt.client.widgets.Canvas#draw Canvas.draw()} on the top widget</ul>
     *  If you need to apply additional, custom configuration, for example setting
     * {@link com.smartgwt.client.widgets.Canvas#getHtmlPosition Canvas.htmlPosition}, then instead of using this property, you
     * can call
     * {@link com.smartgwt.client.rpc.RPCManager#createScreen RPCManager.createScreen()} with {@link
     * com.smartgwt.client.rpc.CreateScreenSettings#getSuppressAutoDraw suppressAutoDraw}: true, and then
     *  manually configure and draw the screen:
     *  <pre>
     *      CreateScreenSettings settings = new CreateScreenSettings();
     *      settings.setSuppressAutoDraw(true);
     *      Canvas screen = RPCManager.createScreen("My Screen", settings);
     *      screen.setHtmlElement(element);
     *      screen.setHtmlPosition(DrawPosition.REPLACE);
     *      screen.setPosition(Positioning.RELATIVE);
     *      screen.draw();
     *  </pre>
     *
     * @return Current htmlElement value. Default value is null
     */
    public String getHtmlElementAsString()  {
        return getAttributeAsString("htmlElement");
    }
    

    /**
     * If true, prevents any screen from being drawn when it's created, even if there's an explicit {@link
     * com.smartgwt.client.widgets.Canvas#getAutoDraw Canvas.autoDraw}:true setting on it.
     *
     * @param suppressAutoDraw New suppressAutoDraw value. Default value is false
     * @return {@link com.smartgwt.client.rpc.CreateScreenSettings CreateScreenSettings} instance, for chaining setter calls
     */
    public CreateScreenSettings setSuppressAutoDraw(Boolean suppressAutoDraw) {
        return (CreateScreenSettings)setAttribute("suppressAutoDraw", suppressAutoDraw);
    }

    /**
     * If true, prevents any screen from being drawn when it's created, even if there's an explicit {@link
     * com.smartgwt.client.widgets.Canvas#getAutoDraw Canvas.autoDraw}:true setting on it.
     *
     * @return Current suppressAutoDraw value. Default value is false
     */
    public Boolean getSuppressAutoDraw()  {
        Boolean result = getAttributeAsBoolean("suppressAutoDraw", true);
        return result == null ? false : result;
    }
    

    /**
     * Enable {@link com.smartgwt.client.rpc.RPCManager#verifyAsError verifyAsError} behavior only for requests using these
     * settings.
     *
     * @param verifyAsError New verifyAsError value. Default value is null
     * @return {@link com.smartgwt.client.rpc.CreateScreenSettings CreateScreenSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.CreateScreenSettings#setVerifyAsError
     * @see com.smartgwt.client.rpc.LoadProjectSettings#setVerifyAsError
     */
    public CreateScreenSettings setVerifyAsError(Boolean verifyAsError) {
        return (CreateScreenSettings)setAttribute("verifyAsError", verifyAsError);
    }

    /**
     * Enable {@link com.smartgwt.client.rpc.RPCManager#verifyAsError verifyAsError} behavior only for requests using these
     * settings.
     *
     * @return Current verifyAsError value. Default value is null
     * @see com.smartgwt.client.rpc.CreateScreenSettings#getVerifyAsError
     * @see com.smartgwt.client.rpc.LoadProjectSettings#getVerifyAsError
     */
    public Boolean getVerifyAsError()  {
        return getAttributeAsBoolean("verifyAsError", true);
    }
    

    /**
     * Enables verification that the created screen contains a component having a
     *  <code>localId</code> equal to the given key, and that it is an instance (or subclass)
     *  if the key's value.  Example:
     *  <pre>
     *    {'customerListGrid: 'ListGrid'}
     *  </pre>
     *  You may verify presence and type of Tabs, SectionStackSections, and FormItems by
     *  providing their names following the parent component's id in dot-separated notation.
     *  Example:
     *  <pre>
     *    {
     *      'mainTabSet.customersTab': 'ImgTab',
     *      'mainSectionStack.customersSection': 'SectionHeader',
     *      'customerDetailsForm.customerNameItem': 'TextItem'
     *    }
     *  </pre>
     *  Findings are always reported to the console, and may also be presented to the user
     *  with a warning dialog by setting {@link com.smartgwt.client.rpc.CreateScreenSettings#getVerifyAsError verifyAsError} or
     *  {@link com.smartgwt.client.rpc.RPCManager#verifyAsError verifyAsError}.
     *
     * @param verifyComponents New verifyComponents value. Default value is null
     * @return {@link com.smartgwt.client.rpc.CreateScreenSettings CreateScreenSettings} instance, for chaining setter calls
     * @see com.smartgwt.client.rpc.RPCManager#createScreen
     */
    public CreateScreenSettings setVerifyComponents(Map<String,String> verifyComponents) {
        return (CreateScreenSettings)setAttribute("verifyComponents", verifyComponents);
    }

    /**
     * Enables verification that the created screen contains a component having a
     *  <code>localId</code> equal to the given key, and that it is an instance (or subclass)
     *  if the key's value.  Example:
     *  <pre>
     *    {'customerListGrid: 'ListGrid'}
     *  </pre>
     *  You may verify presence and type of Tabs, SectionStackSections, and FormItems by
     *  providing their names following the parent component's id in dot-separated notation.
     *  Example:
     *  <pre>
     *    {
     *      'mainTabSet.customersTab': 'ImgTab',
     *      'mainSectionStack.customersSection': 'SectionHeader',
     *      'customerDetailsForm.customerNameItem': 'TextItem'
     *    }
     *  </pre>
     *  Findings are always reported to the console, and may also be presented to the user
     *  with a warning dialog by setting {@link com.smartgwt.client.rpc.CreateScreenSettings#getVerifyAsError verifyAsError} or
     *  {@link com.smartgwt.client.rpc.RPCManager#verifyAsError verifyAsError}.
     *
     * @return Current verifyComponents value. Default value is null
     * @see com.smartgwt.client.rpc.RPCManager#createScreen
     */
    public Map<String,String> getVerifyComponents()  {
        return getAttributeAsMap("verifyComponents");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
