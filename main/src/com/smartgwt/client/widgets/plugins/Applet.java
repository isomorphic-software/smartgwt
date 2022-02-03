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
 
package com.smartgwt.client.widgets.plugins;


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
 * Smart GWT abstraction for Applets.  This class provides Java&lt;-&gt;Smart GWT  interoperability.  When embedding
 * Applets into Smart GWT-based pages, please use this  wrapper class to instantiate the Applet.  Doing so will provide the
 * following benefits:  <p>  <ul>  <li>Drag and drop interactions on the page can target the Applet (can drop on applet). 
 * <li>When a drag interaction transits an Applet, Smart GWT will ensure that the dragTarget  appears above the Applet
 * (prevents burn-through).  <li>Allows you to easily embed the Applet into Smart GWT containers such as Windows and 
 * Layouts, providing automatic masking to ensure the correct z-index order.  But see notes  below for limitations.  </ul> 
 * <p>  <u>Known issues</u><br><br>  <ul>  <li>Resizing Applets can cause Firefox to lock up and require the user to
 * terminate the  process manually.  The cause is currently unknown, but likely causes include applets  attempting to
 * control their own size, or to attempt to re-render on resize.  More recent  JVMs (1.6+) appear to make this problem less
 * frequent.  This may also simply be caused by  applet code being unable to deal with certain combination sizes and
 * crashing.  <li>In Firefox, when using a JVM older than 1.6, Applets cannot be resized smaller than  their originally
 * drawn size.  Doing so causes them to stick at the originally drawn size,  and to overflow the boundary of any Smart GWT
 * component they are embedded in.  <li>In Firefox, Applets do not handle the z-index ordering correctly with respect to 
 * IFRAMEs or other Applets.  Therefore, in Firefox you cannot layer Applets on top of each  other or on top of Smart GWT
 * components containing IFRAMEs and have them render in the  correct order.  </ul>  For a general overview of applets and
 * an applet tutorial see:   <a href='http://docs.oracle.com/javase/tutorial/deployment/applet/index.html'
 * target='_blank'>http://docs.oracle.com/javase/tutorial/deployment/applet/index.html</a>
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("Applet")
public class Applet extends BrowserPlugin {

    public static Applet getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new Applet(jsObj);
        } else {
            assert refInstance instanceof Applet;
            return (Applet)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Applet.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.Applet.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(Applet.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.Applet.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public Applet(){
        scClassName = "Applet";
    }

    public Applet(JavaScriptObject jsObj){
        scClassName = "Applet";
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
     * This text is displayed if the browser understands the tag used for the applet html element,  but can't run the applet
     * for some reason.
     *
     * @param alt New alt value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.plugins.Applet#setAltHTML
     * @see com.smartgwt.client.widgets.plugins.Applet#setUseTag
     */
    public void setAlt(String alt)  throws IllegalStateException {
        setAttribute("alt", alt, false);
    }

    /**
     * This text is displayed if the browser understands the tag used for the applet html element,  but can't run the applet
     * for some reason.
     *
     * @return Current alt value. Default value is null
     * @see com.smartgwt.client.widgets.plugins.Applet#getAltHTML
     * @see com.smartgwt.client.widgets.plugins.Applet#getUseTag
     */
    public String getAlt()  {
        return getAttributeAsString("alt");
    }
    

    /**
     * This text is displayed if the browser does not understand the tag used for the applet html  element.
     *
     * @param altHTML New altHTML value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.plugins.Applet#setAlt
     * @see com.smartgwt.client.widgets.plugins.Applet#setUseTag
     * @see com.smartgwt.client.docs.HTML HTML 
     */
    public void setAltHTML(String altHTML)  throws IllegalStateException {
        setAttribute("altHTML", altHTML, false);
    }

    /**
     * This text is displayed if the browser does not understand the tag used for the applet html  element.
     *
     * @return Current altHTML value. Default value is null
     * @see com.smartgwt.client.widgets.plugins.Applet#getAlt
     * @see com.smartgwt.client.widgets.plugins.Applet#getUseTag
     * @see com.smartgwt.client.docs.HTML HTML 
     */
    public String getAltHTML()  {
        return getAttributeAsString("altHTML");
    }
    

    /**
     * URL to the applet JAR or ZIP archive.
     *
     * @param archive New archive value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.plugins.Applet#setCode
     * @see com.smartgwt.client.widgets.plugins.Applet#setCodeBase
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setArchive(String archive)  throws IllegalStateException {
        setAttribute("archive", archive, false);
    }

    /**
     * URL to the applet JAR or ZIP archive.
     *
     * @return Current archive value. Default value is null
     * @see com.smartgwt.client.widgets.plugins.Applet#getCode
     * @see com.smartgwt.client.widgets.plugins.Applet#getCodeBase
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getArchive()  {
        return getAttributeAsString("archive");
    }
    

    /**
     * This attribute is used only with useTag: "object".  In combination with   {@link
     * com.smartgwt.client.widgets.plugins.Applet#getObjectCodeBase objectCodeBase} this tag specifies the minimum JVM version
     * required to view  this applet and the URL from which the JVM can be downloaded.  <p>  The default settings match the
     * default behavior of the &lt;applet&gt; tag which requires JVM  1.3 or higher.  <p>  The default classID is:
     * "clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"  <p>  For notes on this feature see: <a
     * href='http://java.sun.com/j2se/1.5.0/docs/guide/plugin/developer_guide/using_tags.html#in-ie'
     * target='_blank'>http://java.sun.com/j2se/1.5.0/docs/guide/plugin/developer_guide/using_tags.html#in-ie</a>
     *
     * @param classID New classID value. Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.plugins.Applet#setObjectCodeBase
     */
    public void setClassID(String classID)  throws IllegalStateException {
        setAttribute("classID", classID, false);
    }

    /**
     * This attribute is used only with useTag: "object".  In combination with   {@link
     * com.smartgwt.client.widgets.plugins.Applet#getObjectCodeBase objectCodeBase} this tag specifies the minimum JVM version
     * required to view  this applet and the URL from which the JVM can be downloaded.  <p>  The default settings match the
     * default behavior of the &lt;applet&gt; tag which requires JVM  1.3 or higher.  <p>  The default classID is:
     * "clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"  <p>  For notes on this feature see: <a
     * href='http://java.sun.com/j2se/1.5.0/docs/guide/plugin/developer_guide/using_tags.html#in-ie'
     * target='_blank'>http://java.sun.com/j2se/1.5.0/docs/guide/plugin/developer_guide/using_tags.html#in-ie</a>
     *
     * @return Current classID value. Default value is see below
     * @see com.smartgwt.client.widgets.plugins.Applet#getObjectCodeBase
     */
    public String getClassID()  {
        return getAttributeAsString("classID");
    }
    

    /**
     * A URL that points to the class of the applet.
     *
     * @param code New code value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.plugins.Applet#setCodeBase
     * @see com.smartgwt.client.widgets.plugins.Applet#setArchive
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setCode(String code)  throws IllegalStateException {
        setAttribute("code", code, false);
    }

    /**
     * A URL that points to the class of the applet.
     *
     * @return Current code value. Default value is null
     * @see com.smartgwt.client.widgets.plugins.Applet#getCodeBase
     * @see com.smartgwt.client.widgets.plugins.Applet#getArchive
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getCode()  {
        return getAttributeAsString("code");
    }
    

    /**
     * The base URL of the applet if the {@link com.smartgwt.client.widgets.plugins.Applet#getCode code} attribute is relative
     *
     * @param codeBase New codeBase value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.plugins.Applet#setCode
     * @see com.smartgwt.client.widgets.plugins.Applet#setArchive
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setCodeBase(String codeBase)  throws IllegalStateException {
        setAttribute("codeBase", codeBase, false);
    }

    /**
     * The base URL of the applet if the {@link com.smartgwt.client.widgets.plugins.Applet#getCode code} attribute is relative
     *
     * @return Current codeBase value. Default value is null
     * @see com.smartgwt.client.widgets.plugins.Applet#getCode
     * @see com.smartgwt.client.widgets.plugins.Applet#getArchive
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getCodeBase()  {
        return getAttributeAsString("codeBase");
    }
    

    /**
     * Any additional HTML you want to throw into the tag that specifies the applet element.
     *
     * @param extraHTML New extraHTML value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setExtraHTML(Boolean extraHTML)  throws IllegalStateException {
        setAttribute("extraHTML", extraHTML, false);
    }

    /**
     * Any additional HTML you want to throw into the tag that specifies the applet element.
     *
     * @return Current extraHTML value. Default value is true
     */
    public Boolean getExtraHTML()  {
        Boolean result = getAttributeAsBoolean("extraHTML");
        return result == null ? true : result;
    }
    
    

    /**
     * Usable only in IE: if true allows Java->JS LiveConnect (other platforms that support  LiveConnect have it enabled by
     * default and do not allow it to be disabled).
     *
     * @param mayScript New mayScript value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.plugins.Applet#setScriptable
     */
    public void setMayScript(Boolean mayScript)  throws IllegalStateException {
        setAttribute("mayScript", mayScript, false);
    }

    /**
     * Usable only in IE: if true allows Java->JS LiveConnect (other platforms that support  LiveConnect have it enabled by
     * default and do not allow it to be disabled).
     *
     * @return Current mayScript value. Default value is true
     * @see com.smartgwt.client.widgets.plugins.Applet#getScriptable
     */
    public Boolean getMayScript()  {
        Boolean result = getAttributeAsBoolean("mayScript");
        return result == null ? true : result;
    }
    

    /**
     * Sets the 'name' attribute on the applet object.  If a name is not provided it will be  auto-generated.  Note that in
     * general you don't need to set this.  If you have a handle to  your ISC Applet object you can simply call {@link
     * com.smartgwt.client.widgets.plugins.Applet#getPluginHandle getPluginHandle()} to get a  handle to the element.
     *
     * @param name New name value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.plugins.Applet#getPluginHandle
     */
    public void setName(String name)  throws IllegalStateException {
        setAttribute("name", name, false);
    }

    /**
     * Sets the 'name' attribute on the applet object.  If a name is not provided it will be  auto-generated.  Note that in
     * general you don't need to set this.  If you have a handle to  your ISC Applet object you can simply call {@link
     * com.smartgwt.client.widgets.plugins.Applet#getPluginHandle getPluginHandle()} to get a  handle to the element.
     *
     * @return Current name value. Default value is null
     * @see com.smartgwt.client.widgets.plugins.Applet#getPluginHandle
     */
    public String getName()  {
        return getAttributeAsString("name");
    }
    

    /**
     * This attribute is used only with useTag: "object".  In combination with   {@link
     * com.smartgwt.client.widgets.plugins.Applet#getClassID classID} this tag specifies the minimum JVM version required to
     * view  this applet and the URL from which the JVM can be downloaded.  <p>  The default settings match the default
     * behavior of the &lt;applet&gt; tag which requires JVM  1.3 or higher.  <p>  The default objectCodeBase is:
     * "http://java.sun.com/products/plugin/1.3/jinstall-13-win32.cab#Version=1,3,0,0"  <p>  For notes on this feature see: <a
     * href='http://java.sun.com/j2se/1.5.0/docs/guide/plugin/developer_guide/using_tags.html#in-ie'
     * target='_blank'>http://java.sun.com/j2se/1.5.0/docs/guide/plugin/developer_guide/using_tags.html#in-ie</a>
     *
     * @param objectCodeBase New objectCodeBase value. Default value is see below
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.plugins.Applet#setClassID
     */
    public void setObjectCodeBase(String objectCodeBase)  throws IllegalStateException {
        setAttribute("objectCodeBase", objectCodeBase, false);
    }

    /**
     * This attribute is used only with useTag: "object".  In combination with   {@link
     * com.smartgwt.client.widgets.plugins.Applet#getClassID classID} this tag specifies the minimum JVM version required to
     * view  this applet and the URL from which the JVM can be downloaded.  <p>  The default settings match the default
     * behavior of the &lt;applet&gt; tag which requires JVM  1.3 or higher.  <p>  The default objectCodeBase is:
     * "http://java.sun.com/products/plugin/1.3/jinstall-13-win32.cab#Version=1,3,0,0"  <p>  For notes on this feature see: <a
     * href='http://java.sun.com/j2se/1.5.0/docs/guide/plugin/developer_guide/using_tags.html#in-ie'
     * target='_blank'>http://java.sun.com/j2se/1.5.0/docs/guide/plugin/developer_guide/using_tags.html#in-ie</a>
     *
     * @return Current objectCodeBase value. Default value is see below
     * @see com.smartgwt.client.widgets.plugins.Applet#getClassID
     */
    public String getObjectCodeBase()  {
        return getAttributeAsString("objectCodeBase");
    }
    

    /**
     * A map of key/value pairs to pass to the applet as parameters.  These are typically  accessible within the Java applet
     * code.
     *
     * @param params New params value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setParams(Map params)  throws IllegalStateException {
        setAttribute("params", params, false);
    }

    /**
     * A map of key/value pairs to pass to the applet as parameters.  These are typically  accessible within the Java applet
     * code.
     *
     * @return Current params value. Default value is null
     */
    public Map getParams()  {
        return getAttributeAsMap("params");
    }
    

    /**
     * ID used for the &lt;applet&gt; tag generated by this component.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Sets the ID to be used for the &lt;applet&gt; or &lt;object&gt; DOM element generated by this  component.  Can only be set before draw.
     *
     * @param pluginID New pluginID value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setPluginID(String pluginID)  throws IllegalStateException {
        setAttribute("pluginID", pluginID, false);
    }

    /**
     * ID used for the &lt;applet&gt; tag generated by this component.
     *
     * @return Current pluginID value. Default value is null
     */
    public String getPluginID()  {
        return getAttributeAsString("pluginID");
    }
    

    /**
     * Usable only in IE: if true allows JS->Java LiveConnect (other platforms that support  LiveConnect have it enabled by
     * default and do not allow it to be disabled).
     *
     * @param scriptable New scriptable value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.widgets.plugins.Applet#setMayScript
     */
    public void setScriptable(Boolean scriptable)  throws IllegalStateException {
        setAttribute("scriptable", scriptable, false);
    }

    /**
     * Usable only in IE: if true allows JS->Java LiveConnect (other platforms that support  LiveConnect have it enabled by
     * default and do not allow it to be disabled).
     *
     * @return Current scriptable value. Default value is true
     * @see com.smartgwt.client.widgets.plugins.Applet#getMayScript
     */
    public Boolean getScriptable()  {
        Boolean result = getAttributeAsBoolean("scriptable");
        return result == null ? true : result;
    }
    

    /**
     * A URL that points to the class of this applet.  This is the same as the 'code' attribute.  Note that if you specify both
     * the src and the code attributes, the src attribute will be  ignored in favor of the code attribute.
     *
     * @param src New src value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setSrc(String src)  throws IllegalStateException {
        setAttribute("src", src, false);
    }

    /**
     * A URL that points to the class of this applet.  This is the same as the 'code' attribute.  Note that if you specify both
     * the src and the code attributes, the src attribute will be  ignored in favor of the code attribute.
     *
     * @return Current src value. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getSrc()  {
        return getAttributeAsString("src");
    }
    

    /**
     * Specifies the type of tag to use for the applet html.  See  <a
     * href='http://java.sun.com/j2se/1.5.0/docs/guide/plugin/developer_guide/using_tags.html'
     * target='_blank'>http://java.sun.com/j2se/1.5.0/docs/guide/plugin/developer_guide/using_tags.html</a> for a  discussion
     * of different tags.
     *
     * @param useTag New useTag value. Default value is "applet"
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setUseTag(String useTag)  throws IllegalStateException {
        setAttribute("useTag", useTag, false);
    }

    /**
     * Specifies the type of tag to use for the applet html.  See  <a
     * href='http://java.sun.com/j2se/1.5.0/docs/guide/plugin/developer_guide/using_tags.html'
     * target='_blank'>http://java.sun.com/j2se/1.5.0/docs/guide/plugin/developer_guide/using_tags.html</a> for a  discussion
     * of different tags.
     *
     * @return Current useTag value. Default value is "applet"
     */
    public String getUseTag()  {
        return getAttributeAsString("useTag");
    }
    

    // ********************* Methods ***********************
	/**
     * 
     *
     * @return Returns a handle to the applet DOM element (valid only after the component has been drawn).
     */
    public native Element getPluginHandle() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "getPluginHandle", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.getPluginHandle();
        return ret;
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
     * @param appletProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(Applet appletProperties) /*-{
        if (appletProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(Applet.@java.lang.Object::getClass()(), "setDefaultProperties", appletProperties.@java.lang.Object::getClass()());
        }
        appletProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = appletProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.Applet.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(AppletLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.alt = getAttributeAsString("alt");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.alt:" + t.getMessage() + "\n";
        }
        try {
            s.altHTML = getAttributeAsString("altHTML");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.altHTML:" + t.getMessage() + "\n";
        }
        try {
            s.archive = getAttributeAsString("archive");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.archive:" + t.getMessage() + "\n";
        }
        try {
            s.classID = getAttributeAsString("classID");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.classID:" + t.getMessage() + "\n";
        }
        try {
            s.code = getAttributeAsString("code");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.code:" + t.getMessage() + "\n";
        }
        try {
            s.codeBase = getAttributeAsString("codeBase");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.codeBase:" + t.getMessage() + "\n";
        }
        try {
            s.extraHTML = getAttributeAsString("extraHTML");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.extraHTML:" + t.getMessage() + "\n";
        }
        try {
            s.mayScript = getAttributeAsString("mayScript");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.mayScript:" + t.getMessage() + "\n";
        }
        try {
            s.name = getAttributeAsString("name");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.name:" + t.getMessage() + "\n";
        }
        try {
            s.objectCodeBase = getAttributeAsString("objectCodeBase");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.objectCodeBase:" + t.getMessage() + "\n";
        }
        try {
            s.params = getAttributeAsString("params");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.params:" + t.getMessage() + "\n";
        }
        try {
            s.pluginID = getAttributeAsString("pluginID");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.pluginID:" + t.getMessage() + "\n";
        }
        try {
            s.scriptable = getAttributeAsString("scriptable");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.scriptable:" + t.getMessage() + "\n";
        }
        try {
            s.src = getAttributeAsString("src");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.src:" + t.getMessage() + "\n";
        }
        try {
            s.useTag = getAttributeAsString("useTag");
        } catch (Throwable t) {
            s.logicalStructureErrors += "Applet.useTag:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        AppletLogicalStructure s = new AppletLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
