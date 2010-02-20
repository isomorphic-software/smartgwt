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
 * Use the HTMLFlow component to display HTML content that should expand to its natural size without scrolling.   <p> HTML
 * content can be loaded and reloaded from a URL via the property <code>contentsURL</code>.  This method of loading is for
 * simple HTML content only; Smart GWT components should be loaded via the {@link com.smartgwt.client.widgets.ViewLoader}
 * class. <P> NOTE: Since the size of an HTMLFlow component is determined by its HTML contents, this component will draw at
 * varying sizes if given content of varying size.  When using HTMLFlow components within a Layout, consider what will
 * happen if the HTMLFlow renders at various sizes.  An HTMLFlow which can expand should be placed in a container where
 * other components can render smaller, where the container is allowed to scroll, or where there is padding to expand into.
 */
public class HTMLFlow extends Canvas  implements com.smartgwt.client.widgets.events.HasContentLoadedHandlers {

    public static HTMLFlow getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (HTMLFlow) obj;
        } else {
            return new HTMLFlow(jsObj);
        }
    }

    public HTMLFlow(){
        scClassName = "HTMLFlow";
    }

    public HTMLFlow(JavaScriptObject jsObj){
        super(jsObj);
    }

    public HTMLFlow(String contents) {
        setContents(contents);
        scClassName = "HTMLFlow";
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.HTMLFlow.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
     * By default an HTMLFlow will explicitly prevent browser caching. <P> Set to true to allow browser caching <b>if the
     * browser would normally do so</b>, in other words, if the HTTP headers returned with the response indicate that the
     * response can be cached.
     *
     * @param allowCaching allowCaching Default value is false
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
     *
     * @return Boolean
     */
    public Boolean getAllowCaching()  {
        return getAttributeAsBoolean("allowCaching");
    }

    /**
     * If true, Smart GWT components created while executing the loaded HTML are captured for rendering inside the HTMLFlow.
     * <P> Only applies when contentsType is <b>not</b> "page".
     *
     * @param captureSCComponents captureSCComponents Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setCaptureSCComponents(Boolean captureSCComponents)  throws IllegalStateException {
        setAttribute("captureSCComponents", captureSCComponents, false);
    }

    /**
     * If true, Smart GWT components created while executing the loaded HTML are captured for rendering inside the HTMLFlow.
     * <P> Only applies when contentsType is <b>not</b> "page".
     *
     *
     * @return Boolean
     */
    public Boolean getCaptureSCComponents()  {
        return getAttributeAsBoolean("captureSCComponents");
    }

    /**
     * The contents of a canvas or label widget. Any HTML string is acceptable.
     *
     * @param contents contents Default value is "&nbsp;"
     */
    public void setContents(String contents) {
        setAttribute("contents", contents, true);
    }

    /**
     * The contents of a canvas or label widget. Any HTML string is acceptable.
     *
     *
     * @return String
     */
    public String getContents()  {
        return getAttributeAsString("contents");
    }

    /**
     * URL to load content from. <P> If specified, this component will load HTML content from the specified URL when it is
     * first drawn. <p> This feature relies on the XMLHttpRequest object which can be disabled by end-users in some supported
     * browsers.  See {@link com.smartgwt.client.docs.PlatformDependencies} for more information.
     * Change the URL this component loads content from.  Triggers a fetch for content from the new URL. <p> Can also be called with no arguments to reload content from the existing {@link com.smartgwt.client.widgets.HTMLFlow#getContentsURL contentsURL}. <P> This feature relies on the XMLHttpRequest object which can be disabled by end-users in some supported browsers.  See {@link com.smartgwt.client.docs.PlatformDependencies} for more information.
     *
     * @param contentsURL URL to retrieve contents from. Default value is null
     */
    public void setContentsURL(String contentsURL) {
        setAttribute("contentsURL", contentsURL, true);
    }

    /**
     * URL to load content from. <P> If specified, this component will load HTML content from the specified URL when it is
     * first drawn. <p> This feature relies on the XMLHttpRequest object which can be disabled by end-users in some supported
     * browsers.  See {@link com.smartgwt.client.docs.PlatformDependencies} for more information.
     *
     *
     * @return String
     */
    public String getContentsURL()  {
        return getAttributeAsString("contentsURL");
    }

    /**
     * Dynamic contents allows the contents string to be treated as a simple, but powerful&#010 template.  When this attribute
     * is set to true, expressions of the form \${arbitrary JS&#010 here} are replaced by the result of the evaluation of the
     * JS code inside the curly&#010 brackets.  This evaluation happens at draw time.  If you want to trigger a
     * re-evaluation&#010 of the expressions in the contents string you can call markForRedraw() on the canvas.&#010 <p>&#010
     * You can use this feature to build some simple custom components. For example, let's say&#010 you want to show the value
     * of a Slider in a Canvas somewhere on the screen.  You can do&#010 this by observing the valueChanged() method on the
     * slider and calling setContents() on&#010 your canvas with the new string or you can set the contents of the canvas to
     * something&#010 like:&#010 <p><code>&#010 "The slider value is \${sliderInstance.getValue()}."&#010 </code><p>&#010 Next
     * you set dynamicContents: true on the canvas, observe valueChanged() on the slider&#010 and call canvas.markForRedraw()
     * in that observation.  This approach is cleaner than&#010 setContents() when the Canvas is aggregating several values or
     * dynamic expressions.&#010 Like so:&#010 <p>&#010 <pre>&#010 Slider.create({&#010     ID: "mySlider"&#010 });&#010&#010
     * Canvas.create({&#010     ID: "myCanvas",&#010     dynamicContents: true,&#010     contents: "The slider value is
     * \${mySlider.getValue()}."&#010 });&#010     &#010 myCanvas.observe(mySlider, "valueChanged", &#010                 
     * "observer.markForRedraw()");&#010 </pre>&#010 You can embed an arbitrary number of dynamic expressions in the contents
     * string.  The&#010 search and replace is optimized for speed.&#010 <p>&#010 If an error occurs during the evaluation of
     * one of the expressions, a warning is logged&#010 to the ISC Developer Console and the error string is embedded in place
     * of the expected&#010 value in the Canvas.&#010 <p>&#010 The value of a function is its return value.  The value of any
     * variable is the same as&#010 that returned by its toString() representation.&#010 <p>&#010 Inside the evaluation
     * contentext, <code>this</code> points to the canvas instance that&#010 has the dynamicContents string as its contents -
     * in other words the canvas instance on&#010 which the template is declared.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param dynamicContents dynamicContents Default value is false
     */
    public void setDynamicContents(Boolean dynamicContents) {
        setAttribute("dynamicContents", dynamicContents, true);
    }

    /**
     * Dynamic contents allows the contents string to be treated as a simple, but powerful&#010 template.  When this attribute
     * is set to true, expressions of the form \${arbitrary JS&#010 here} are replaced by the result of the evaluation of the
     * JS code inside the curly&#010 brackets.  This evaluation happens at draw time.  If you want to trigger a
     * re-evaluation&#010 of the expressions in the contents string you can call markForRedraw() on the canvas.&#010 <p>&#010
     * You can use this feature to build some simple custom components. For example, let's say&#010 you want to show the value
     * of a Slider in a Canvas somewhere on the screen.  You can do&#010 this by observing the valueChanged() method on the
     * slider and calling setContents() on&#010 your canvas with the new string or you can set the contents of the canvas to
     * something&#010 like:&#010 <p><code>&#010 "The slider value is \${sliderInstance.getValue()}."&#010 </code><p>&#010 Next
     * you set dynamicContents: true on the canvas, observe valueChanged() on the slider&#010 and call canvas.markForRedraw()
     * in that observation.  This approach is cleaner than&#010 setContents() when the Canvas is aggregating several values or
     * dynamic expressions.&#010 Like so:&#010 <p>&#010 <pre>&#010 Slider.create({&#010     ID: "mySlider"&#010 });&#010&#010
     * Canvas.create({&#010     ID: "myCanvas",&#010     dynamicContents: true,&#010     contents: "The slider value is
     * \${mySlider.getValue()}."&#010 });&#010     &#010 myCanvas.observe(mySlider, "valueChanged", &#010                 
     * "observer.markForRedraw()");&#010 </pre>&#010 You can embed an arbitrary number of dynamic expressions in the contents
     * string.  The&#010 search and replace is optimized for speed.&#010 <p>&#010 If an error occurs during the evaluation of
     * one of the expressions, a warning is logged&#010 to the ISC Developer Console and the error string is embedded in place
     * of the expected&#010 value in the Canvas.&#010 <p>&#010 The value of a function is its return value.  The value of any
     * variable is the same as&#010 that returned by its toString() representation.&#010 <p>&#010 Inside the evaluation
     * contentext, <code>this</code> points to the canvas instance that&#010 has the dynamicContents string as its contents -
     * in other words the canvas instance on&#010 which the template is declared.
     *
     *
     * @return Boolean
     */
    public Boolean getDynamicContents()  {
        return getAttributeAsBoolean("dynamicContents");
    }

    /**
     * If <code>evalScriptBlocks</code> is true, HTMLFlow will pre-process the loaded HTML in order to mimic how the HTML would
     * execute if it were loaded as an independent page or loaded via an IFRAME.   <P> This feature is intended to assist with
     * migrating existing applications to Smart GWT. <P> Note that, if evalScriptBlocks is false, &lt;SCRIPT&gt; blocks will
     * still be detected and disabled to avoid the inconsistent results across different browsers. <P> Only applies when
     * contentsType is <b>not</b> "page".
     *
     * @param evalScriptBlocks evalScriptBlocks Default value is true
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setEvalScriptBlocks(Boolean evalScriptBlocks)  throws IllegalStateException {
        setAttribute("evalScriptBlocks", evalScriptBlocks, false);
    }

    /**
     * If <code>evalScriptBlocks</code> is true, HTMLFlow will pre-process the loaded HTML in order to mimic how the HTML would
     * execute if it were loaded as an independent page or loaded via an IFRAME.   <P> This feature is intended to assist with
     * migrating existing applications to Smart GWT. <P> Note that, if evalScriptBlocks is false, &lt;SCRIPT&gt; blocks will
     * still be detected and disabled to avoid the inconsistent results across different browsers. <P> Only applies when
     * contentsType is <b>not</b> "page".
     *
     *
     * @return Boolean
     */
    public Boolean getEvalScriptBlocks()  {
        return getAttributeAsBoolean("evalScriptBlocks");
    }
             
    /**
     * Selects the HTTP method that will be used when fetching content.  Valid values are "POST" and "GET".
     *
     * @param httpMethod httpMethod Default value is "GET"
     */
    public void setHttpMethod(SendMethod httpMethod) {
        setAttribute("httpMethod", httpMethod.getValue(), true);
    }

    /**
     * Selects the HTTP method that will be used when fetching content.  Valid values are "POST" and "GET".
     *
     *
     * @return SendMethod
     */
    public SendMethod getHttpMethod()  {
        return EnumUtil.getEnum(SendMethod.values(), getAttribute("httpMethod"));
    }

    /**
     * HTML to show while content is being fetched, active only if the <code>contentsURL</code> property has been set. <P> The
     * loading message will show both during the initial load of content, and during reload if the contents are reloaded or the
     * contentsURL changed.  For a first-time only loading message, initialize the <code>contents</code> property instead.<br>
     * Note: the <code>loadingMessage</code> is never displayed when loading complete web pages  rather than HTML fragments
     * (see {@link com.smartgwt.client.widgets.HTMLFlow#getContentsType contentsType}).
     *
     * @param loadingMessage loadingMessage Default value is null
     */
    public void setLoadingMessage(String loadingMessage) {
        setAttribute("loadingMessage", loadingMessage, true);
    }

    /**
     * HTML to show while content is being fetched, active only if the <code>contentsURL</code> property has been set. <P> The
     * loading message will show both during the initial load of content, and during reload if the contents are reloaded or the
     * contentsURL changed.  For a first-time only loading message, initialize the <code>contents</code> property instead.<br>
     * Note: the <code>loadingMessage</code> is never displayed when loading complete web pages  rather than HTML fragments
     * (see {@link com.smartgwt.client.widgets.HTMLFlow#getContentsType contentsType}).
     *
     *
     * @return String
     */
    public String getLoadingMessage()  {
        return getAttributeAsString("loadingMessage");
    }

    // ********************* Methods ***********************
    /**
     * Add a contentLoaded handler.
     * <p>
     * StringMethod fired when content is completely loaded in this htmlFlow. Has no default  implementation. May be observed
     * or overridden as a notification type method to fire custom logic when loading completes. <P> Note: Does not apply to
     * htmlFlows with {@link com.smartgwt.client.widgets.HTMLFlow#getContentsType 'contentsType'} set  to <code>"page"</code>
     *
     * @param handler the contentLoaded handler
     * @return {@link HandlerRegistration} used to remove this handler
     */
    public HandlerRegistration addContentLoadedHandler(com.smartgwt.client.widgets.events.ContentLoadedHandler handler) {
        if(getHandlerCount(com.smartgwt.client.widgets.events.ContentLoadedEvent.getType()) == 0) setupContentLoadedEvent();
        return doAddHandler(handler, com.smartgwt.client.widgets.events.ContentLoadedEvent.getType());
    }

    private native void setupContentLoadedEvent() /*-{
        var obj = null;
        var selfJ = this;
        if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
            obj.addProperties({contentLoaded:$entry(function(){
                        var param = {};
                        var event = @com.smartgwt.client.widgets.events.ContentLoadedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    })
             });
        } else {
            obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
            obj.contentLoaded = $entry(function(){
                   var param = {};
                   var event = @com.smartgwt.client.widgets.events.ContentLoadedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                   selfJ.@com.smartgwt.client.widgets.BaseWidget::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
               });
        }
   }-*/;
            
    /**
     * Returns true if this htmlFlow is currently loading content from the server.<br> Note: Does not apply to htmlFlows with
     * {@link com.smartgwt.client.widgets.HTMLFlow#getContentsType 'contentsType'} set to  <code>"page"</code>
     */
    public native void loadingContent() /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.loadingContent();
    }-*/;
            
    /**
     * Override to modify the loaded HTML before it is rendered.
     * @param html the html as loaded from the server return (HTML) html to be rendered
     */
    public native void transformHTML(String html) /*-{
        var self = this.@com.smartgwt.client.widgets.BaseWidget::getOrCreateJsObj()();
        self.transformHTML(html);
    }-*/;

    // ********************* Static Methods ***********************


    /**
     * The default setting of 'null' or 'fragment' indicates that HTML loaded from {@link
     * com.smartgwt.client.widgets.HTMLFlow#getContentsURL contentsURL} is assumed to be an HTML fragment rather than a
     * complete page.  Set to "page" to load HTML as a standalone page, via an IFRAME.   <P>
     * <code>contentsType:"page"</code> should only be used for controlled HTML content, and only when such content
     * cannot be delivered as an HTML fragment instead (the default).  To dynamically load Smart GWT components, use
     * {@link com.smartgwt.client.widgets.ViewLoader}, <b>never</b> this mechanism (click here for why). <P> Loading
     * HTML content as a fragment is less resource intensive and avoids visual artifacts such as translucent media
     * becoming opaque or disappearing when placed over an IFRAME.   <P> Loading third-party, uncontrolled content could
     * lead to the surrounding page disappearing if a user clicks on an HTML link with <code>target=_top</code>. <P>
     * With <code>contentsType:"page"</code>, {@link com.smartgwt.client.widgets.HTMLFlow#getLoadingMessage
     * loadingMessage} is not supported, and only "GET" is supported for {@link com.smartgwt.client.widgets.HTMLFlow#getHttpMethod
     * httpMethod}.
     *
     * @param contentsType contentsType Default value is null
     * @throws IllegalStateException this property cannot be changed after the component has been created
     */
    public void setContentsType(ContentsType contentsType) throws IllegalStateException {
        setAttribute("contentsType", contentsType.getValue(), false);
    }

    /**
     * The default setting of 'null' or 'fragment' indicates that HTML loaded from {@link
     * com.smartgwt.client.widgets.HTMLFlow#getContentsURL contentsURL} is assumed to be an HTML fragment rather than a
     * complete page.  Set to "page" to load HTML as a standalone page, via an IFRAME.   <P>
     * <code>contentsType:"page"</code> should only be used for controlled HTML content, and only when such content
     * cannot be delivered as an HTML fragment instead (the default).  To dynamically load Smart GWT components, use
     * {@link com.smartgwt.client.widgets.ViewLoader}, <b>never</b> this mechanism (click here for why). <P> Loading
     * HTML content as a fragment is less resource intensive and avoids visual artifacts such as translucent media
     * becoming opaque or disappearing when placed over an IFRAME.   <P> Loading third-party, uncontrolled content could
     * lead to the surrounding page disappearing if a user clicks on an HTML link with <code>target=_top</code>. <P>
     * With <code>contentsType:"page"</code>, {@link com.smartgwt.client.widgets.HTMLFlow#getLoadingMessage
     * loadingMessage} is not supported, and only "GET" is supported for {@link com.smartgwt.client.widgets.HTMLFlow#getHttpMethod
     * httpMethod}.
     *
     * @return String
     */
    public ContentsType getContentsType() {
        return EnumUtil.getEnum(ContentsType.values(), getAttribute("contentsType"));
    }

    /**
     * Parameters to be sent to the contentsURL when fetching content.
     *
     * @param contentsURLParams parameters
     */
    public void setContentsURLParams(Map contentsURLParams) {
        setAttribute("contentsURLParams", contentsURLParams, true);
    }

}



