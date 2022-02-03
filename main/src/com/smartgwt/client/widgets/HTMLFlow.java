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
 * Use the HTMLFlow component to display HTML content that should expand to its natural size without scrolling.   <p> HTML
 * content can be loaded and reloaded from a URL via the property <code>contentsURL</code>.  This method of loading is for
 * simple HTML content only; Smart GWT components should be loaded via the {@link com.smartgwt.client.widgets.ViewLoader}
 * class. <P> NOTE: Since the size of an HTMLFlow component is determined by its HTML contents, this component will draw at
 * varying sizes if given content of varying size.  When using HTMLFlow components within a Layout, consider what will
 * happen if the HTMLFlow renders at various sizes.  An HTMLFlow which can expand should be placed in a container where
 * other components can render smaller, where the container is allowed to scroll, or where there is padding to expand into.
 * <p> HTMLFlow is a {@link com.smartgwt.client.widgets.DataBoundComponent} but only supports one method at this time,
 * {@link com.smartgwt.client.widgets.HTMLFlow#fetchRelatedData fetchRelatedData}.
 */
@BeanFactory.FrameworkClass
@BeanFactory.ScClassName("HTMLFlow")
public class HTMLFlow extends Canvas implements com.smartgwt.client.widgets.events.HasContentLoadedHandlers {

    public static HTMLFlow getOrCreateRef(JavaScriptObject jsObj) {
        if (jsObj == null) return null;
        final BaseWidget refInstance = BaseWidget.getRef(jsObj);
        if (refInstance == null) {
            return new HTMLFlow(jsObj);
        } else {
            assert refInstance instanceof HTMLFlow;
            return (HTMLFlow)refInstance;
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(HTMLFlow.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "Canvas");
        }
        defaults.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
        var cleanDefaultsJS = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(defaults.@com.smartgwt.client.widgets.BaseWidget::getConfig()(), true);
        $wnd.isc.HTMLFlow.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
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
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(HTMLFlow.@java.lang.Object::getClass()(), "changeAutoChildDefaults", "FormItem");
        }
        defaults.@com.smartgwt.client.widgets.form.fields.FormItem::setConfigOnly(Z)(true);
    	var cleanDefaultsJS = defaults.@com.smartgwt.client.widgets.form.fields.FormItem::getEditorTypeConfig()();
        $wnd.isc.HTMLFlow.changeDefaults(autoChildName + "Defaults", cleanDefaultsJS);
    }-*/;

    public HTMLFlow(){
        scClassName = "HTMLFlow";
    }

    public HTMLFlow(JavaScriptObject jsObj){
        scClassName = "HTMLFlow";
        setJavaScriptObject(jsObj);
    }


    public HTMLFlow(String contents) {
        setContents(contents);
                scClassName = "HTMLFlow";
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
     * By default an HTMLFlow will explicitly prevent browser caching. <P> Set to true to allow browser caching <b>if the
     * browser would normally do so</b>, in other words, if the HTTP headers returned with the response indicate that the
     * response can be cached.
     *
     * @param allowCaching New allowCaching value. Default value is false
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setAllowCaching(Boolean allowCaching)  throws IllegalStateException {
        setAttribute("allowCaching", allowCaching, false);
    }

    /**
     * By default an HTMLFlow will explicitly prevent browser caching. <P> Set to true to allow browser caching <b>if the
     * browser would normally do so</b>, in other words, if the HTTP headers returned with the response indicate that the
     * response can be cached.
     *
     * @return Current allowCaching value. Default value is false
     */
    public Boolean getAllowCaching()  {
        Boolean result = getAttributeAsBoolean("allowCaching");
        return result == null ? false : result;
    }
    

    /**
     * If true, Smart GWT components created while executing the loaded HTML are captured for rendering inside the HTMLFlow.
     * <P> Only applies when contentsType is <b>not</b> "page".
     *
     * @param captureSCComponents New captureSCComponents value. Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCaptureSCComponents(Boolean captureSCComponents)  throws IllegalStateException {
        setAttribute("captureSCComponents", captureSCComponents, false);
    }

    /**
     * If true, Smart GWT components created while executing the loaded HTML are captured for rendering inside the HTMLFlow.
     * <P> Only applies when contentsType is <b>not</b> "page".
     *
     * @return Current captureSCComponents value. Default value is true
     */
    public Boolean getCaptureSCComponents()  {
        Boolean result = getAttributeAsBoolean("captureSCComponents");
        return result == null ? true : result;
    }
    

    /**
     * The contents of a canvas or label widget. Any HTML string is acceptable.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Changes the contents of a widget to newContents, an HTML string.
     *
     * @param contents an HTML string to be set as the contents of this widget. Default value is "&amp;nbsp;"
     * @see com.smartgwt.client.widgets.HTMLFlow#setDynamicContents
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setContents(String contents) {
        setAttribute("contents", contents, true);
    }

    /**
     * The contents of a canvas or label widget. Any HTML string is acceptable.
     *
     * @return Current contents value. Default value is "&amp;nbsp;"
     * @see com.smartgwt.client.widgets.HTMLFlow#getDynamicContents
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getContents()  {
        return getAttributeAsString("contents");
    }
    

    /**
     * The default setting of <code>null</code> or 'fragment' indicates that HTML loaded from {@link
     * com.smartgwt.client.widgets.HTMLFlow#getContentsURL contentsURL} is assumed to be an HTML fragment rather than a
     * complete page.  Set to "page" to load HTML as a standalone page, via an IFRAME.   <P> <code>contentsType:"page"</code>
     * should only be used for controlled HTML content, and only when such content cannot be delivered as an HTML fragment
     * instead (the default).  To dynamically load Smart GWT components, use {@link com.smartgwt.client.widgets.ViewLoader},
     * <b>never</b> this mechanism (click {@link com.smartgwt.client.docs.NoFrames here} for why). <P> Loading HTML content as
     * a fragment is less resource intensive and avoids visual artifacts such as translucent media becoming opaque or
     * disappearing when placed over an IFRAME.   <P> Loading third-party, uncontrolled content could lead to the surrounding
     * page disappearing if a user clicks on an HTML link with <code>target=_top</code>. <P> With
     * <code>contentsType:"page"</code>, {@link com.smartgwt.client.widgets.HTMLFlow#getLoadingMessage loadingMessage} is not
     * supported, and only "GET" is supported for {@link com.smartgwt.client.widgets.HTMLFlow#getHttpMethod httpMethod}. <P>
     * Note that a native bug has been observed in Internet Explorer version 10 whereby if an HTMLFlow with
     * <code>contentsType</code> set to <code>"page"</code> loads a page containing an HTML <code>&lt;frameset&gt;</code>, when
     * the HTMLFlow is {@link com.smartgwt.client.widgets.Canvas#hide hidden}, it can interfere with the rendering of other
     * elements on the page. Setting {@link com.smartgwt.client.widgets.Canvas#getShrinkElementOnHide
     * Canvas.shrinkElementOnHide} to <code>true</code> will work around this behavior.
     *
     * @param contentsType New contentsType value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setContentsType(ContentsType contentsType)  throws IllegalStateException {
        setAttribute("contentsType", contentsType == null ? null : contentsType.getValue(), false);
    }

    /**
     * The default setting of <code>null</code> or 'fragment' indicates that HTML loaded from {@link
     * com.smartgwt.client.widgets.HTMLFlow#getContentsURL contentsURL} is assumed to be an HTML fragment rather than a
     * complete page.  Set to "page" to load HTML as a standalone page, via an IFRAME.   <P> <code>contentsType:"page"</code>
     * should only be used for controlled HTML content, and only when such content cannot be delivered as an HTML fragment
     * instead (the default).  To dynamically load Smart GWT components, use {@link com.smartgwt.client.widgets.ViewLoader},
     * <b>never</b> this mechanism (click {@link com.smartgwt.client.docs.NoFrames here} for why). <P> Loading HTML content as
     * a fragment is less resource intensive and avoids visual artifacts such as translucent media becoming opaque or
     * disappearing when placed over an IFRAME.   <P> Loading third-party, uncontrolled content could lead to the surrounding
     * page disappearing if a user clicks on an HTML link with <code>target=_top</code>. <P> With
     * <code>contentsType:"page"</code>, {@link com.smartgwt.client.widgets.HTMLFlow#getLoadingMessage loadingMessage} is not
     * supported, and only "GET" is supported for {@link com.smartgwt.client.widgets.HTMLFlow#getHttpMethod httpMethod}. <P>
     * Note that a native bug has been observed in Internet Explorer version 10 whereby if an HTMLFlow with
     * <code>contentsType</code> set to <code>"page"</code> loads a page containing an HTML <code>&lt;frameset&gt;</code>, when
     * the HTMLFlow is {@link com.smartgwt.client.widgets.Canvas#hide hidden}, it can interfere with the rendering of other
     * elements on the page. Setting {@link com.smartgwt.client.widgets.Canvas#getShrinkElementOnHide
     * Canvas.shrinkElementOnHide} to <code>true</code> will work around this behavior.
     *
     * @return Current contentsType value. Default value is null
     */
    public ContentsType getContentsType()  {
        return EnumUtil.getEnum(ContentsType.values(), getAttribute("contentsType"));
    }
    

    /**
     * URL to load content from. <P> If specified, this component will load HTML content from the specified URL when it is
     * first drawn. <p> This feature relies on the XMLHttpRequest object which can be disabled by end-users in some supported
     * browsers.  See {@link com.smartgwt.client.docs.PlatformDependencies} for more information.
     *
     * <br><br>If this method is called after the component has been drawn/initialized:
     * Change the URL this component loads content from.  Triggers a fetch for content from the new URL. <p> Can also be called with no arguments to reload content from the existing {@link com.smartgwt.client.widgets.HTMLFlow#getContentsURL contentsURL}. <P> This feature relies on the XMLHttpRequest object which can be disabled by end-users in some supported browsers.  See {@link com.smartgwt.client.docs.PlatformDependencies} for more information.
     *
     * @param contentsURL URL to retrieve contents from. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     */
    public void setContentsURL(String contentsURL) {
        setAttribute("contentsURL", contentsURL, true);
    }

    /**
     * URL to load content from. <P> If specified, this component will load HTML content from the specified URL when it is
     * first drawn. <p> This feature relies on the XMLHttpRequest object which can be disabled by end-users in some supported
     * browsers.  See {@link com.smartgwt.client.docs.PlatformDependencies} for more information.
     *
     * @return Current contentsURL value. Default value is null
     * @see com.smartgwt.client.docs.URL URL 
     */
    public String getContentsURL()  {
        return getAttributeAsString("contentsURL");
    }
    

    /**
     * Parameters to be sent to the contentsURL when fetching content.
     *
     * @param contentsURLParams New contentsURLParams value. Default value is null
     */
    public void setContentsURLParams(Map contentsURLParams) {
        setAttribute("contentsURLParams", contentsURLParams, true);
    }
    

    /**
     * Dynamic contents allows the contents string to be treated as a simple, but powerful
     *  template.  When this attribute is set to true, expressions of the form &#36;{arbitrary JS
     *  here} are replaced by the result of the evaluation of the JS code inside the curly
     *  brackets.  This evaluation happens at draw time.  If you want to trigger a re-evaluation
     *  of the expressions in the contents string you can call markForRedraw() on the canvas.
     *  <p>
     *  You can use this feature to build some simple custom components. For example, let's say
     *  you want to show the value of a Slider in a Canvas somewhere on the screen.  You can do
     *  this by observing the valueChanged() method on the slider and calling setContents() on
     *  your canvas with the new string or you can set the contents of the canvas to something
     *  like:
     *  <p><code>
     *  "The slider value is &#36;{sliderInstance.getValue()}."
     *  </code><p>
     *  Next you set dynamicContents: true on the canvas, observe valueChanged() on the slider
     *  and call canvas.markForRedraw() in that observation.  This approach is cleaner than
     *  setContents() when the Canvas is aggregating several values or dynamic expressions.
     *  Like so:
     *  <p>
     *  <pre>
     *  Slider.create({
     *      ID: "mySlider"
     *  });
     * 
     *  Canvas.create({
     *      ID: "myCanvas",
     *      dynamicContents: true,
     *      contents: "The slider value is &#36;{mySlider.getValue()}."
     *  });
     * 
     *  myCanvas.observe(mySlider, "valueChanged",
     *                   "observer.markForRedraw()");
     *  </pre>
     *  You can embed an arbitrary number of dynamic expressions in the contents string.  The
     *  search and replace is optimized for speed.
     *  <p>
     *  If an error occurs during the evaluation of one of the expressions, a warning is logged
     *  to the ISC Developer Console and the error string is embedded in place of the expected
     *  value in the Canvas.
     *  <p>
     *  The value of a function is its return value.  The value of any variable is the same as
     *  that returned by its toString() representation.
     *  <p>
     *  Inside the evaluation contentext, <code>this</code> points to the canvas instance that
     *  has the dynamicContents string as its contents - in other words the canvas instance on
     *  which the template is declared.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dynamicContents New dynamicContents value. Default value is false
     * @see com.smartgwt.client.widgets.HTMLFlow#setContents
     * @see com.smartgwt.client.widgets.Canvas#setDynamicContentsVars
     * 
     */
    public void setDynamicContents(Boolean dynamicContents) {
        setAttribute("dynamicContents", dynamicContents, true);
    }

    /**
     * Dynamic contents allows the contents string to be treated as a simple, but powerful
     *  template.  When this attribute is set to true, expressions of the form &#36;{arbitrary JS
     *  here} are replaced by the result of the evaluation of the JS code inside the curly
     *  brackets.  This evaluation happens at draw time.  If you want to trigger a re-evaluation
     *  of the expressions in the contents string you can call markForRedraw() on the canvas.
     *  <p>
     *  You can use this feature to build some simple custom components. For example, let's say
     *  you want to show the value of a Slider in a Canvas somewhere on the screen.  You can do
     *  this by observing the valueChanged() method on the slider and calling setContents() on
     *  your canvas with the new string or you can set the contents of the canvas to something
     *  like:
     *  <p><code>
     *  "The slider value is &#36;{sliderInstance.getValue()}."
     *  </code><p>
     *  Next you set dynamicContents: true on the canvas, observe valueChanged() on the slider
     *  and call canvas.markForRedraw() in that observation.  This approach is cleaner than
     *  setContents() when the Canvas is aggregating several values or dynamic expressions.
     *  Like so:
     *  <p>
     *  <pre>
     *  Slider.create({
     *      ID: "mySlider"
     *  });
     * 
     *  Canvas.create({
     *      ID: "myCanvas",
     *      dynamicContents: true,
     *      contents: "The slider value is &#36;{mySlider.getValue()}."
     *  });
     * 
     *  myCanvas.observe(mySlider, "valueChanged",
     *                   "observer.markForRedraw()");
     *  </pre>
     *  You can embed an arbitrary number of dynamic expressions in the contents string.  The
     *  search and replace is optimized for speed.
     *  <p>
     *  If an error occurs during the evaluation of one of the expressions, a warning is logged
     *  to the ISC Developer Console and the error string is embedded in place of the expected
     *  value in the Canvas.
     *  <p>
     *  The value of a function is its return value.  The value of any variable is the same as
     *  that returned by its toString() representation.
     *  <p>
     *  Inside the evaluation contentext, <code>this</code> points to the canvas instance that
     *  has the dynamicContents string as its contents - in other words the canvas instance on
     *  which the template is declared.
     *
     * @return Current dynamicContents value. Default value is false
     * @see com.smartgwt.client.widgets.HTMLFlow#getContents
     * @see com.smartgwt.client.widgets.Canvas#getDynamicContentsVars
     * 
     */
    public Boolean getDynamicContents()  {
        Boolean result = getAttributeAsBoolean("dynamicContents");
        return result == null ? false : result;
    }
    

    /**
     * If <code>evalScriptBlocks</code> is true, HTMLFlow will pre-process the loaded HTML in order to mimic how the HTML would
     * execute if it were loaded as an independent page or loaded via an IFRAME.   <P> This feature is intended to assist with
     * migrating existing applications to Smart GWT. <P> <code>evalScriptBlocks</code> is enabled by default when loading
     * remote content (via {@link com.smartgwt.client.widgets.HTMLFlow#getContentsURL contentsURL}) and disabled by default for
     * content supplied via {@link com.smartgwt.client.widgets.HTMLFlow#setContents setContents()}. <P> Note that, if
     * evalScriptBlocks is false, &lt;SCRIPT&gt; blocks will still be detected and disabled to avoid the inconsistent results
     * across different browsers. <P> Only applies when contentsType is <b>not</b> "page".
     *
     * @param evalScriptBlocks New evalScriptBlocks value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEvalScriptBlocks(Boolean evalScriptBlocks)  throws IllegalStateException {
        setAttribute("evalScriptBlocks", evalScriptBlocks, false);
    }

    /**
     * If <code>evalScriptBlocks</code> is true, HTMLFlow will pre-process the loaded HTML in order to mimic how the HTML would
     * execute if it were loaded as an independent page or loaded via an IFRAME.   <P> This feature is intended to assist with
     * migrating existing applications to Smart GWT. <P> <code>evalScriptBlocks</code> is enabled by default when loading
     * remote content (via {@link com.smartgwt.client.widgets.HTMLFlow#getContentsURL contentsURL}) and disabled by default for
     * content supplied via {@link com.smartgwt.client.widgets.HTMLFlow#setContents setContents()}. <P> Note that, if
     * evalScriptBlocks is false, &lt;SCRIPT&gt; blocks will still be detected and disabled to avoid the inconsistent results
     * across different browsers. <P> Only applies when contentsType is <b>not</b> "page".
     *
     * @return Current evalScriptBlocks value. Default value is null
     */
    public Boolean getEvalScriptBlocks()  {
        return getAttributeAsBoolean("evalScriptBlocks");
    }
    

    /**
     * Selects the HTTP method that will be used when fetching content.  Valid values are "POST" and "GET".
     *
     * @param httpMethod New httpMethod value. Default value is "GET"
     */
    public void setHttpMethod(SendMethod httpMethod) {
        setAttribute("httpMethod", httpMethod == null ? null : httpMethod.getValue(), true);
    }

    /**
     * Selects the HTTP method that will be used when fetching content.  Valid values are "POST" and "GET".
     *
     * @return Current httpMethod value. Default value is "GET"
     */
    public SendMethod getHttpMethod()  {
        return EnumUtil.getEnum(SendMethod.values(), getAttribute("httpMethod"));
    }
    

    /**
     * When using {@link com.smartgwt.client.widgets.HTMLFlow#getContentsType contentsType}  {@link
     * com.smartgwt.client.types.ContentsType#PAGE},  sets the &lt;iframe&gt; <code>sandbox</code> attribute to the provided
     * value. <p> Use the value "*ALL*" to cause the "sandbox" attribute to be output with no value (which causes full
     * sandboxing). <p> See any HTML reference for other legal values of the "sandbox" attribute, which allow you to remove
     * individual restrictions on the loaded content. <p> Note that Smart GWT simply applies the provided value to the
     * generated &lt;iframe&gt; element and cannot fix bugs or differences in sandbox behavior across different browsers.
     *
     * @param iframeSandbox New iframeSandbox value. Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setIframeSandbox(String iframeSandbox)  throws IllegalStateException {
        setAttribute("iframeSandbox", iframeSandbox, false);
    }

    /**
     * When using {@link com.smartgwt.client.widgets.HTMLFlow#getContentsType contentsType}  {@link
     * com.smartgwt.client.types.ContentsType#PAGE},  sets the &lt;iframe&gt; <code>sandbox</code> attribute to the provided
     * value. <p> Use the value "*ALL*" to cause the "sandbox" attribute to be output with no value (which causes full
     * sandboxing). <p> See any HTML reference for other legal values of the "sandbox" attribute, which allow you to remove
     * individual restrictions on the loaded content. <p> Note that Smart GWT simply applies the provided value to the
     * generated &lt;iframe&gt; element and cannot fix bugs or differences in sandbox behavior across different browsers.
     *
     * @return Current iframeSandbox value. Default value is null
     */
    public String getIframeSandbox()  {
        return getAttributeAsString("iframeSandbox");
    }
    

    /**
     * HTML to show while content is being fetched, active only if the <code>contentsURL</code> property has been set. Use
     * <code>"&#36;{loadingImage}"</code> to include {@link com.smartgwt.client.widgets.Canvas#loadingImageSrc a loading
     * image}. <P> The loading message will show both during the initial load of content, and during reload if the contents are
     * reloaded or the contentsURL changed.  For a first-time only loading message, initialize the <code>contents</code>
     * property instead.<br> Note: the <code>loadingMessage</code> is never displayed when loading complete web pages  rather
     * than HTML fragments (see {@link com.smartgwt.client.widgets.HTMLFlow#getContentsType contentsType}).
     *
     * @param loadingMessage New loadingMessage value. Default value is "&amp;nbsp;${loadingImage}"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public void setLoadingMessage(String loadingMessage) {
        setAttribute("loadingMessage", loadingMessage, true);
    }

    /**
     * HTML to show while content is being fetched, active only if the <code>contentsURL</code> property has been set. Use
     * <code>"&#36;{loadingImage}"</code> to include {@link com.smartgwt.client.widgets.Canvas#loadingImageSrc a loading
     * image}. <P> The loading message will show both during the initial load of content, and during reload if the contents are
     * reloaded or the contentsURL changed.  For a first-time only loading message, initialize the <code>contents</code>
     * property instead.<br> Note: the <code>loadingMessage</code> is never displayed when loading complete web pages  rather
     * than HTML fragments (see {@link com.smartgwt.client.widgets.HTMLFlow#getContentsType contentsType}).
     *
     * @return Current loadingMessage value. Default value is "&amp;nbsp;${loadingImage}"
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getLoadingMessage()  {
        return getAttributeAsString("loadingMessage");
    }
    

    /**
     * When this <code>HTMLFlow</code> is focused, causes Ctrl-A / Command-A keypresses to select just the content, as opposed
     * to all content on the screen becoming selected. This <code>HTMLFlow</code> must be {@link
     * com.smartgwt.client.widgets.Canvas#getCanFocus focusable} in order for this setting to have an effect. <p> Not valid
     * with {@link com.smartgwt.client.widgets.HTMLFlow#getContentsType contentsType}  {@link
     * com.smartgwt.client.types.ContentsType#PAGE}.
     *
     * @param selectContentOnSelectAll New selectContentOnSelectAll value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_html_pane" target="examples">HTMLPane Example</a>
     */
    public void setSelectContentOnSelectAll(Boolean selectContentOnSelectAll) {
        setAttribute("selectContentOnSelectAll", selectContentOnSelectAll, true);
    }

    /**
     * When this <code>HTMLFlow</code> is focused, causes Ctrl-A / Command-A keypresses to select just the content, as opposed
     * to all content on the screen becoming selected. This <code>HTMLFlow</code> must be {@link
     * com.smartgwt.client.widgets.Canvas#getCanFocus focusable} in order for this setting to have an effect. <p> Not valid
     * with {@link com.smartgwt.client.widgets.HTMLFlow#getContentsType contentsType}  {@link
     * com.smartgwt.client.types.ContentsType#PAGE}.
     *
     * @return Current selectContentOnSelectAll value. Default value is null
     * @see <a href="http://www.smartclient.com/smartgwt/showcase/#basics_html_pane" target="examples">HTMLPane Example</a>
     */
    public Boolean getSelectContentOnSelectAll()  {
        return getAttributeAsBoolean("selectContentOnSelectAll");
    }
    

    // ********************* Methods ***********************
    /**
     * Add a contentLoaded handler.
     * <p>
     * StringMethod fired when content is completely loaded in this htmlFlow. Has no default  implementation. May be observed
     * or overridden as a notification type method to fire custom logic when loading completes. <P> Notes: <ul><li>A call to
     * {@link com.smartgwt.client.widgets.Canvas#setContents this.setContents()}   will cause this notification to be fired
     * when  the contents have been set. If {@link com.smartgwt.client.widgets.HTMLFlow#getEvalScriptBlocks
     * HTMLFlow.evalScriptBlocks} is true, and the HTML passed  into <code>setContents()</code> contains any <code>&lt;script
     * src=... &gt;</code>  tags, this callback will be fired asynchronously once the scripts have been loaded  from the server
     * and executed, as well as having the widget content updated</li> <li>When using {@link
     * com.smartgwt.client.widgets.HTMLFlow#getContentsURL HTMLFlow.contentsURL}, this does not apply to htmlFlows with  {@link
     * com.smartgwt.client.widgets.HTMLFlow#getContentsType contentsType} set to <code>"page"</code></li></ul>
     *
     * @param handler the contentLoaded handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addContentLoadedHandler(com.smartgwt.client.widgets.events.ContentLoadedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.ContentLoadedEvent.getType()) == 0) setupContentLoadedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.ContentLoadedEvent.getType());
    }

    private native void setupContentLoadedEvent() /*-{
        var obj;
        var selfJ = this;
        var hasDefaultHandler;
        var contentLoaded = $entry(function(){
            var param = {"_this": this};
            var event = @com.smartgwt.client.widgets.events.ContentLoadedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
            selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
            selfJ.@com.smartgwt.client.widgets.HTMLFlow::handleTearDownContentLoadedEvent()();
            if (hasDefaultHandler) this.Super("contentLoaded", arguments);
        });
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            hasDefaultHandler = $wnd.isc.isA.Function(obj.getProperty("contentLoaded"));
            obj.addProperties({contentLoaded:  contentLoaded              });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            var scClassName = this.@com.smartgwt.client.widgets.BaseWidget::scClassName;
            hasDefaultHandler = $wnd.isc.isA.Function($wnd.isc[scClassName].getInstanceProperty("contentLoaded"));
            obj.contentLoaded =  contentLoaded             ;
        }
    }-*/;

    private void handleTearDownContentLoadedEvent() {
        if (getHandlerCount(com.smartgwt.client.widgets.events.ContentLoadedEvent.getType()) == 0) tearDownContentLoadedEvent();
    }

    private native void tearDownContentLoadedEvent() /*-{
        var obj;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        }
        if (obj && obj.hasOwnProperty("contentLoaded")) delete obj.contentLoaded;
    }-*/;

	/**
     * Based on the relationship between the DataSource this component is bound to and the DataSource specified as the "schema"
     * argument, call fetchData() to retrieve records in this data set that are related to the passed-in record. <P>
     * Relationships between DataSources are declared via {@link com.smartgwt.client.data.DataSourceField#getForeignKey
     * DataSourceField.foreignKey}. <P> For example, given two related DataSources "orders" and "orderItems", where we want to
     * fetch the "orderItems" that belong to a given "order".  "orderItems" should declare a field that is a {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} to the "orders" table (for example, it might be named
     * "orderId" with foreignKey="orders.id").  Then, to load the records related to a given "order", call fetchRelatedData()
     * on the component bound to "orderItems", pass the "orders" DataSource as the "schema" and pass a record from the "orders"
     * DataSource as the "record" argument. <p> <b>Note:</b> When you expect a large number of records to be returned it is not
     * recommended to display these in the DetailViewer as it doesn't have the same level of support for large datasets as the
     * {@link com.smartgwt.client.widgets.grid.ListGrid}.
     * @param record DataSource record
     * @param schema schema of the DataSource record, or                            DataBoundComponent already bound to that schema
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void fetchRelatedData(ListGridRecord record, Canvas schema) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fetchRelatedData", "ListGridRecord,Canvas");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchRelatedData(record.@com.smartgwt.client.core.DataClass::getJsObj()(), schema == null ? null : schema.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()());
    }-*/;

    /**
     * @see HTMLFlow#fetchRelatedData
     */
    public void fetchRelatedData(ListGridRecord record, Canvas schema, DSCallback callback){
        fetchRelatedData(record, schema, callback, null);
    }

	/**
     * Based on the relationship between the DataSource this component is bound to and the DataSource specified as the "schema"
     * argument, call fetchData() to retrieve records in this data set that are related to the passed-in record. <P>
     * Relationships between DataSources are declared via {@link com.smartgwt.client.data.DataSourceField#getForeignKey
     * DataSourceField.foreignKey}. <P> For example, given two related DataSources "orders" and "orderItems", where we want to
     * fetch the "orderItems" that belong to a given "order".  "orderItems" should declare a field that is a {@link
     * com.smartgwt.client.data.DataSourceField#getForeignKey foreignKey} to the "orders" table (for example, it might be named
     * "orderId" with foreignKey="orders.id").  Then, to load the records related to a given "order", call fetchRelatedData()
     * on the component bound to "orderItems", pass the "orders" DataSource as the "schema" and pass a record from the "orders"
     * DataSource as the "record" argument. <p> <b>Note:</b> When you expect a large number of records to be returned it is not
     * recommended to display these in the DetailViewer as it doesn't have the same level of support for large datasets as the
     * {@link com.smartgwt.client.widgets.grid.ListGrid}.
     * @param record DataSource record
     * @param schema schema of the DataSource record, or                            DataBoundComponent already bound to that schema
     * @param callback callback to invoke on completion
     * @param requestProperties additional properties to set on the DSRequest                                            that will be issued
     * @see com.smartgwt.client.docs.DataBoundComponentMethods DataBoundComponentMethods overview and related methods
     */
    public native void fetchRelatedData(ListGridRecord record, Canvas schema, DSCallback callback, DSRequest requestProperties) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "fetchRelatedData", "ListGridRecord,Canvas,DSCallback,DSRequest");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.fetchRelatedData(record.@com.smartgwt.client.core.DataClass::getJsObj()(), schema == null ? null : schema.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()(), 
			$entry( function(dsResponse, data, dsRequest) { 
				if(callback!=null) callback.@com.smartgwt.client.data.DSCallback::execute(Lcom/smartgwt/client/data/DSResponse;Ljava/lang/Object;Lcom/smartgwt/client/data/DSRequest;)(
					@com.smartgwt.client.data.DSResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsResponse), 
					data, 
					@com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(dsRequest)
				);
			}), requestProperties == null ? null : requestProperties.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;
	
	/**
     * Returns true if this htmlFlow is currently loading content from the server.<br> Note: Does not apply to htmlFlows with
     * {@link com.smartgwt.client.widgets.HTMLFlow#getContentsType contentsType} set to  <code>"page"</code>
     *
     * @return whether content is currently being loaded
     * @see com.smartgwt.client.widgets.events.ContentLoadedEvent
     */
    public native Boolean loadingContent() /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "loadingContent", "");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        var ret = self.loadingContent();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;

	/**
     * Override to modify the loaded HTML before it is rendered.
     * @param html the html as loaded from the server return (HTML) html to be rendered.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @see com.smartgwt.client.docs.HTMLString HTMLString
     */
    public native void transformHTML(String html) /*-{
        if (this.@com.smartgwt.client.widgets.BaseWidget::isConfigOnly()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPostConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)(this.@java.lang.Object::getClass()(), "transformHTML", "String");
        }
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.transformHTML(html);
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
     * @param hTMLFlowProperties properties that should be used as new defaults when instances of this class are created
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public static native void setDefaultProperties(HTMLFlow hTMLFlowProperties) /*-{
        if (hTMLFlowProperties.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            @com.smartgwt.client.util.ConfigUtil::warnOfPreConfigInstantiation(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)(HTMLFlow.@java.lang.Object::getClass()(), "setDefaultProperties", hTMLFlowProperties.@java.lang.Object::getClass()());
        }
        hTMLFlowProperties.@com.smartgwt.client.widgets.BaseWidget::setConfigOnly(Z)(true);
    	var properties = hTMLFlowProperties.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        properties = @com.smartgwt.client.util.JSOHelper::cleanProperties(Lcom/google/gwt/core/client/JavaScriptObject;Z)(properties,true);
        $wnd.isc.HTMLFlow.addProperties(properties);
    }-*/;

    // ***********************************************************

    /**
     * Setter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject setLogicalStructure(HTMLFlowLogicalStructure s) {
        super.setLogicalStructure(s);
        try {
            s.allowCaching = getAttributeAsString("allowCaching");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HTMLFlow.allowCaching:" + t.getMessage() + "\n";
        }
        try {
            s.captureSCComponents = getAttributeAsString("captureSCComponents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HTMLFlow.captureSCComponents:" + t.getMessage() + "\n";
        }
        try {
            s.contents = getAttributeAsString("contents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HTMLFlow.contents:" + t.getMessage() + "\n";
        }
        try {
            s.contentsType = getAttributeAsString("contentsType");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HTMLFlow.contentsType:" + t.getMessage() + "\n";
        }
        try {
            s.contentsURL = getAttributeAsString("contentsURL");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HTMLFlow.contentsURL:" + t.getMessage() + "\n";
        }
        try {
            s.dynamicContents = getAttributeAsString("dynamicContents");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HTMLFlow.dynamicContents:" + t.getMessage() + "\n";
        }
        try {
            s.evalScriptBlocks = getAttributeAsString("evalScriptBlocks");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HTMLFlow.evalScriptBlocks:" + t.getMessage() + "\n";
        }
        try {
            s.httpMethod = getAttributeAsString("httpMethod");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HTMLFlow.httpMethod:" + t.getMessage() + "\n";
        }
        try {
            s.iframeSandbox = getAttributeAsString("iframeSandbox");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HTMLFlow.iframeSandbox:" + t.getMessage() + "\n";
        }
        try {
            s.loadingMessage = getAttributeAsString("loadingMessage");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HTMLFlow.loadingMessage:" + t.getMessage() + "\n";
        }
        try {
            s.selectContentOnSelectAll = getAttributeAsString("selectContentOnSelectAll");
        } catch (Throwable t) {
            s.logicalStructureErrors += "HTMLFlow.selectContentOnSelectAll:" + t.getMessage() + "\n";
        }
        return s;
    }

    /**
     * Getter implementing the {@link com.smartgwt.client.core.LogicalStructure} interface,
     * which supports Eclipse's logical structure debugging facility.
     */
    public LogicalStructureObject getLogicalStructure() {
        HTMLFlowLogicalStructure s = new HTMLFlowLogicalStructure();
        setLogicalStructure(s);
        return s;
    }
}
