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
 
package com.smartgwt.client.util;


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
 * Provides information about the page you're loaded in.  We define "page" here to be roughly  equivalent to the browser
 * window or frame the libraries have been loaded in.
 */
@BeanFactory.FrameworkClass
public class Page {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Check whether the browser is supported by the Isomorphic Smart GWT system. Behavior depends upon the value of {@link
     * com.smartgwt.client.util.Page#unsupportedBrowserAction unsupportedBrowserAction}: <ul> <li><code>"continue"</code> Load
     * the page without notifying the user of potential issues</li> <li><code>"confirm"</code> Notify the user via a standard
     * confirm dialog that their browser is  not supported. Provide options to continue anyway, or redirect to another page.
     * Text of the  confirm dialog is retrieved by calling {@link
     * com.smartgwt.client.util.Page#getUnsupportedBrowserPromptString getUnsupportedBrowserPromptString()}.</li>
     * <li><code>"redirect"</code> Automatically redirect to the another URL</li> </ul> If redirecting to another page is
     * necessary, and no explicit URL is provided we will use {@link com.smartgwt.client.util.Page#defaultUnsupportedBrowserURL
     * defaultUnsupportedBrowserURL}. <p> This method is commonly called as part of the {@link
     * com.smartgwt.client.docs.Skinning skinning} logic after page load.
     * @see com.smartgwt.client.util.Page#unsupportedBrowserAction
     * @see com.smartgwt.client.util.Page#getUnsupportedBrowserPromptString
     * @see com.smartgwt.client.util.Page#defaultUnsupportedBrowserURL
     * @deprecated As discussed in {@link com.smartgwt.client.docs.BrowserSupport}, developers are recommended to consider  which browsers
     * they wish to support within their specific application rather than relying on framework  supported browser detection.
     */
    public static native void checkBrowserAndRedirect() /*-{
        $wnd.isc.Page.checkBrowserAndRedirect();
    }-*/;

	/**
     * Check whether the browser is supported by the Isomorphic Smart GWT system. Behavior depends upon the value of {@link
     * com.smartgwt.client.util.Page#unsupportedBrowserAction unsupportedBrowserAction}: <ul> <li><code>"continue"</code> Load
     * the page without notifying the user of potential issues</li> <li><code>"confirm"</code> Notify the user via a standard
     * confirm dialog that their browser is  not supported. Provide options to continue anyway, or redirect to another page.
     * Text of the  confirm dialog is retrieved by calling {@link
     * com.smartgwt.client.util.Page#getUnsupportedBrowserPromptString getUnsupportedBrowserPromptString()}.</li>
     * <li><code>"redirect"</code> Automatically redirect to the another URL</li> </ul> If redirecting to another page is
     * necessary, and no explicit URL is provided we will use {@link com.smartgwt.client.util.Page#defaultUnsupportedBrowserURL
     * defaultUnsupportedBrowserURL}. <p> This method is commonly called as part of the {@link
     * com.smartgwt.client.docs.Skinning skinning} logic after page load.
     * @param URL URL of redirect page. May include Isomorphic special directories      such as [SKIN].
     * @see com.smartgwt.client.util.Page#unsupportedBrowserAction
     * @see com.smartgwt.client.util.Page#getUnsupportedBrowserPromptString
     * @see com.smartgwt.client.util.Page#defaultUnsupportedBrowserURL
     * @deprecated As discussed in {@link com.smartgwt.client.docs.BrowserSupport}, developers are recommended to consider  which browsers
     * they wish to support within their specific application rather than relying on framework  supported browser detection.
     */
    public static native void checkBrowserAndRedirect(String URL) /*-{
        $wnd.isc.Page.checkBrowserAndRedirect(URL);
    }-*/;
	


	/**
     * Returns the base URL of the application, which is the page URL minus the last non-directory  path component.  For
     * example, if the page is loaded from <code>http://foo.com/bar/zoo.jsp</code>, appDir will be
     * <code>http://foo.com/bar/</code>. <P> If other page-wide URLs such as {@link
     * com.smartgwt.client.util.Page#setIsomorphicDir setIsomorphicDir()} are specified as relative paths, they are considered
     * relative to this URL.
     *
     * @return URL for page-specific files.
     */
    public static native String getAppDir() /*-{
        var ret = $wnd.isc.Page.getAppDir();
        return ret;
    }-*/;


	/**
     * Returns the directory for application-specific files (other than images).
     */
    public static native void getAppFilesDir() /*-{
        $wnd.isc.Page.getAppFilesDir();
    }-*/;

	/**
     * Returns the directory for application-specific files (other than images).
     * @param URL New app files URL.
     */
    public static native void getAppFilesDir(String URL) /*-{
        $wnd.isc.Page.getAppFilesDir(URL);
    }-*/;
	

	/**
     * Return the directory for app-specific images.
     *
     * @return URL for page-specific images.
     */
    public static native String getAppImgDir() /*-{
        var ret = $wnd.isc.Page.getAppImgDir();
        return ret;
    }-*/;


	/**
     * Returns the current ratio of the resolution in physical pixels to the resolution in CSS pixels in the browser, known as
     * the <a href='https://developer.mozilla.org/en-US/docs/Web/API/Window/devicePixelRatio' target='_blank'>device pixel
     * ratio</a>. The ratio reflects the combination of OS-level zoom, browser-level zoom, and device/OS  defaults. <p> When
     * this value isn't 1, some browser bugs manifest, so it can be useful to check it as an indicator that certain issues may
     * be present and, in turn, whether workarounds fom them  must run.  However, note that on Safari it's not useful as the
     * value is identically 1. <p> A specific application of this function is to check whether any zoom is present after a
     * resize event so that the user can be informed that a page reload might be required for proper rendering. For that you'd
     * want to follow these steps:<ul> <li>When your module's <code>EntryPoint</code> is called, store the current device pixel
     * ratio <li>Then add a window resize handler (see <a
     * href='http://www.gwtproject.org/javadoc/latest/com/google/gwt/user/client/Window.html#addResizeHandler-com.google.gwt.event.logical.shared.ResizeHandler-'
     * target='_blank'>Window.addResizeHandler()</a>) that checks whether the ratio has transitioned away from one. <li>If
     * zooming has been introduced, call {@link com.smartgwt.client.util.SC#notify notify()} to let the user know a page resize
     * may be needed. </ul>
     */
    public static native void getDevicePixelRatio() /*-{
        $wnd.isc.Page.getDevicePixelRatio();
    }-*/;



	/**
     * Return the full URL for app-specific or skin image. <P> To use a skin image, start the URL with "[SKIN]".  Any other
     * relative URL is assumed relative to the {@link com.smartgwt.client.util.Page#getAppImgDir appImgDir}.
     * @param src Local file name for the image.
     * See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     *
     * @return URL for the image.
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL
     */
    public static native String getImgURL(String src) /*-{
        var ret = $wnd.isc.Page.getImgURL(src);
        return ret;
    }-*/;

	/**
     * Return the full URL for app-specific or skin image. <P> To use a skin image, start the URL with "[SKIN]".  Any other
     * relative URL is assumed relative to the {@link com.smartgwt.client.util.Page#getAppImgDir appImgDir}.
     * @param src Local file name for the image.
     * See {@link com.smartgwt.client.docs.SCImgURL SCImgURL}
     * @param imgDir User-specified image directory,          local to
     *
     * @return URL for the image.
     */
    public static native String getImgURL(String src, String imgDir) /*-{
        var ret = $wnd.isc.Page.getImgURL(src, imgDir);
        return ret;
    }-*/;
	

	/**
     * Return the root directory for Isomorphic-specific files.
     *
     * @return IsomorphicDir URL.
     */
    public static native String getIsomorphicDir() /*-{
        var ret = $wnd.isc.Page.getIsomorphicDir();
        return ret;
    }-*/;


	/**
     * Return the root directory for Isomorphic-supplied tools dir.
     *
     * @return IsomorphicToolsDir URL.
     */
    public static native String getIsomorphicToolsDir() /*-{
        var ret = $wnd.isc.Page.getIsomorphicToolsDir();
        return ret;
    }-*/;


	/**
     * Is the current page wider than it is tall ("landscape" orientation) or the reverse  ("portrait" orientation). Note that
     * the {@link com.smartgwt.client.types.PageEvent orientationChange page event} will be fired whenever the page orientation
     * changes. <P> This method is typically useful for apps developed for display on mobile devices, though it will also
     * return a valid value when running against a desktop browser. See also {@link com.smartgwt.client.docs.MobileDevelopment
     * this discussion} on building applications for mobile devices
     *
     * @return current page orientation
     */
    public static native PageOrientation getOrientation() /*-{
        var ret = $wnd.isc.Page.getOrientation();
        if(ret == null) return null;
        var enumValues = @com.smartgwt.client.types.PageOrientation::values()();
        return @com.smartgwt.client.util.EnumUtil::getEnum([Lcom/smartgwt/client/types/ValueEnum;Ljava/lang/String;)(enumValues, ret);
    }-*/;




	/**
     * Get the height of the window contents as they have been drawn.  If the page scrolls, this may be larger than the {@link
     * com.smartgwt.client.util.Page#getHeight getHeight()}.
     *
     * @return height of the page as drawn
     */
    public static native int getScrollHeight() /*-{
        var ret = $wnd.isc.Page.getScrollHeight();
        return ret;
    }-*/;


	/**
     * Get the amount that the browser window has been scrolled horizontally.
     *
     * @return horizontal scroll amount
     */
    public static native int getScrollLeft() /*-{
        var ret = $wnd.isc.Page.getScrollLeft();
        return ret;
    }-*/;


	/**
     * Get the amount that the browser window has been scrolled vertically.
     *
     * @return vertical scroll amount
     */
    public static native int getScrollTop() /*-{
        var ret = $wnd.isc.Page.getScrollTop();
        return ret;
    }-*/;


	/**
     * Get the width of the window contents as they have been drawn.  If the page scrolls, this may be larger than the {@link
     * com.smartgwt.client.util.Page#getWidth getWidth()}.
     *
     * @return width of the page as drawn
     */
    public static native int getScrollWidth() /*-{
        var ret = $wnd.isc.Page.getScrollWidth();
        return ret;
    }-*/;


	/**
     * Return the directory for media that's part of the skin
     *
     * @return base URL for skin media
     */
    public static native String getSkinDir() /*-{
        var ret = $wnd.isc.Page.getSkinDir();
        return ret;
    }-*/;


	/**
     * Return the directory for a skin image.
     *
     * @return URL for page-specific images.
     */
    public static native String getSkinImgDir() /*-{
        var ret = $wnd.isc.Page.getSkinImgDir();
        return ret;
    }-*/;

	/**
     * Return the directory for a skin image.
     * @param imgDir Partial URL (relative to Page._skinDir) where the image lives.          If not supplied, will use "images/".
     * See {@link com.smartgwt.client.docs.URL URL}
     *
     * @return URL for page-specific images.
     */
    public static native String getSkinImgDir(String imgDir) /*-{
        var ret = $wnd.isc.Page.getSkinImgDir(imgDir);
        return ret;
    }-*/;
	

	/**
     * Return the images directory used by Isomorphic-supplied tools.
     *
     * @return ToolsImgDir URL.
     */
    public static native String getToolsImgDir() /*-{
        var ret = $wnd.isc.Page.getToolsImgDir();
        return ret;
    }-*/;


	/**
     * Returns the text for the prompt shown to user from {@link com.smartgwt.client.util.Page#checkBrowserAndRedirect
     * checkBrowserAndRedirect()} if they are accessing this page in an unsupported browser and {@link
     * com.smartgwt.client.util.Page#unsupportedBrowserAction unsupportedBrowserAction} is set to <code>"confirm"</code>. May
     * be overridden to return a different message.
     *
     * @return Unsupported browser message.
     * @see com.smartgwt.client.util.Page#checkBrowserAndRedirect
     */
    public static native String getUnsupportedBrowserPromptString() /*-{
        var ret = $wnd.isc.Page.getUnsupportedBrowserPromptString();
        return ret;
    }-*/;


	/**
     * Return a full URL for a relative path that uses a special prefix such as "[APPFILES]" or "[SKIN]". <P> For images, use
     * {@link com.smartgwt.client.util.Page#getImgURL getImgURL()} instead.
     * @param fileName Local file name for the image.
     *
     * @return URL for the image.
     */
    public static native String getURL(String fileName) /*-{
        var ret = $wnd.isc.Page.getURL(fileName);
        return ret;
    }-*/;





	/**
     * Returns true if add version to skin CSS is currently turned on.
     *
     * @return true == add version to skin CSS is turned on
     */
    public static native Boolean isAddVersionToSkinCSS() /*-{
        var ret = $wnd.isc.Page.isAddVersionToSkinCSS();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Has the page finished loading?
     *
     * @return true == page is done loading
     */
    public static native Boolean isLoaded() /*-{
        var ret = $wnd.isc.Page.isLoaded();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Return whether the page text direction is right to left.  If you set "DIR=RTL" in the BODY tag of the page, then this
     * method will return true.  If you set "DIR=LTR" then this method will return false.
     *
     * @return true if Page text direction is RTL, false otherwise
     */
    public static native Boolean isRTL() /*-{
        var ret = $wnd.isc.Page.isRTL();
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Load a styleSheet for this application.    The styleSheetURL parameter can use any special directories, eg:<br>     
     * &nbsp;&nbsp;<code>Page.loadStylesheet("[SKIN]/skin_styles.css")</code><br>      or<br>     
     * &nbsp;&nbsp;<code>Page.loadStylesheet("[APP]/app_styles.css")</code>.      <P>  If you don't specify a special
     * directory, the app directory   will be assumed.  <P>  Note:   If the document's ONLOAD handler has already fired, this  
     *  will have no effect.
     * @param styleSheetURL URL to the stylesheet.
     * See {@link com.smartgwt.client.docs.URL URL}
     * @see com.smartgwt.client.docs.URL URL
     */
    public static native void loadStyleSheet(String styleSheetURL) /*-{
        $wnd.isc.Page.loadStyleSheet(styleSheetURL);
    }-*/;


	/**
     * Move the window to a specified top and left in screen coordinates.
     * @param left new left coordinate for window
     * @param top new top coordinate for window
     */
    public static native void moveTo(int left, int top) /*-{
        $wnd.isc.Page.moveTo(left, top);
    }-*/;




	/**
     * Resize the outer portion of the window to a specific width and height.
     * @param width new width for the window
     * @param height new height for the window
     */
    public static native void resizeTo(int width, int height) /*-{
        $wnd.isc.Page.resizeTo(width, height);
    }-*/;


	/**
     * Scroll the window to a specified top and left coordinate.
     * @param left new left coordinate for window
     * @param top new top coordinate for window
     */
    public static native void scrollTo(int left, int top) /*-{
        $wnd.isc.Page.scrollTo(left, top);
    }-*/;


	/**
     * Setting this to true will cause {@link com.smartgwt.client.util.Page#loadStyleSheet loadStyleSheet()} to append an
     * "isc_version" parameter to the end of the url when loading a stylesheet.
     * @param addVersionToSkinCss pass in true to turn on automatic adding of version                                              parameter to css urls.
     */
    public static native void setAddVersionToSkinCSS(Boolean addVersionToSkinCss) /*-{
        $wnd.isc.Page.setAddVersionToSkinCSS(addVersionToSkinCss == null ? null : addVersionToSkinCss.@java.lang.Boolean::booleanValue()());
    }-*/;


	/**
     * Specify the directory for miscellaneous app-specific files <b>other than</b> images, such as {@link
     * com.smartgwt.client.widgets.HTMLFlow#getContentsURL HTML fragments}, {@link com.smartgwt.client.widgets.ViewLoader
     * loadable views},  XML or JSON flat data files, videos, etc. <P> This URL also becomes available via the prefix
     * "[APPFILES]" for {@link com.smartgwt.client.rpc.RPCRequest#getActionURL RPCRequest.actionURL}. <P> Defaults to the value
     * of {@link com.smartgwt.client.util.Page#getAppDir getAppDir()}, that is, the current directory.
     */
    public static native void setAppFilesDir() /*-{
        $wnd.isc.Page.setAppFilesDir();
    }-*/;

	/**
     * Specify the directory for miscellaneous app-specific files <b>other than</b> images, such as {@link
     * com.smartgwt.client.widgets.HTMLFlow#getContentsURL HTML fragments}, {@link com.smartgwt.client.widgets.ViewLoader
     * loadable views},  XML or JSON flat data files, videos, etc. <P> This URL also becomes available via the prefix
     * "[APPFILES]" for {@link com.smartgwt.client.rpc.RPCRequest#getActionURL RPCRequest.actionURL}. <P> Defaults to the value
     * of {@link com.smartgwt.client.util.Page#getAppDir getAppDir()}, that is, the current directory.
     * @param URL New app files URL.
     */
    public static native void setAppFilesDir(String URL) /*-{
        $wnd.isc.Page.setAppFilesDir(URL);
    }-*/;
	

	/**
     * Specify the directory for app-specific images. <P> This becomes the default location where any Smart GWT component will
     * load images from unless the special "[SKIN]" prefix is used to indicate that an image is part of a skin. <P> Default is
     * "[APP]images/"
     */
    public static native void setAppImgDir() /*-{
        $wnd.isc.Page.setAppImgDir();
    }-*/;

	/**
     * Specify the directory for app-specific images. <P> This becomes the default location where any Smart GWT component will
     * load images from unless the special "[SKIN]" prefix is used to indicate that an image is part of a skin. <P> Default is
     * "[APP]images/"
     * @param URL New imgDir URL.
     */
    public static native void setAppImgDir(String URL) /*-{
        $wnd.isc.Page.setAppImgDir(URL);
    }-*/;
	


	/**
     * Specify the root directory for Isomorphic-supplied files - the directory containing  the <code>modules/</code> and
     * <code>system/</code> subdirectories shipped as part of the Smart GWT package. <P> Note that this property is commonly
     * specified directly in the bootstrap HTML file by setting <code>window.isomorphicDir</code> before loading the Smart GWT
     * library files.
     */
    public static native void setIsomorphicDir() /*-{
        $wnd.isc.Page.setIsomorphicDir();
    }-*/;

	/**
     * Specify the root directory for Isomorphic-supplied files - the directory containing  the <code>modules/</code> and
     * <code>system/</code> subdirectories shipped as part of the Smart GWT package. <P> Note that this property is commonly
     * specified directly in the bootstrap HTML file by setting <code>window.isomorphicDir</code> before loading the Smart GWT
     * library files.
     * @param URL New IsomorphicDir URL.
     */
    public static native void setIsomorphicDir(String URL) /*-{
        $wnd.isc.Page.setIsomorphicDir(URL);
    }-*/;
	

	/**
     * Specify the root directory for Isomorphic-supplied tools.  Typicall tools/ under webRoot. <P> Note that this property is
     * commonly specified directly in the bootstrap HTML file by setting <code>window.isomorphicToolsDir</code> before loading
     * the Smart GWT library files.  If unset, it defaults to $isomorphicDir/../tools/
     */
    public static native void setIsomorphicToolsDir() /*-{
        $wnd.isc.Page.setIsomorphicToolsDir();
    }-*/;

	/**
     * Specify the root directory for Isomorphic-supplied tools.  Typicall tools/ under webRoot. <P> Note that this property is
     * commonly specified directly in the bootstrap HTML file by setting <code>window.isomorphicToolsDir</code> before loading
     * the Smart GWT library files.  If unset, it defaults to $isomorphicDir/../tools/
     * @param URL New IsomorphicToolsDir URL.
     */
    public static native void setIsomorphicToolsDir(String URL) /*-{
        $wnd.isc.Page.setIsomorphicToolsDir(URL);
    }-*/;
	

	/**
     * Specify the URL for media that's part of the skin
     */
    public static native void setSkinDir() /*-{
        $wnd.isc.Page.setSkinDir();
    }-*/;

	/**
     * Specify the URL for media that's part of the skin
     * @param URL New skinDir URL
     */
    public static native void setSkinDir(String URL) /*-{
        $wnd.isc.Page.setSkinDir(URL);
    }-*/;
	






    // ***********************************************************



    private static HandlerManager handlerManager;
    private static Double orientationChangeEventID;

   /**
    * Fire some action when the Page receives a keyPress event from a certain key.
    * Note that if a widget has keyboard focus, this action will fire only after any widget-level
    * keyPress handlers have fired and bubbled the event up to the top of their ancestor chain.
    * Multiple actions can be registered to fire on a single keyPress using this method.
    * This differs from calling Page.setEvent() with the "keyPress" events registered via setEvent() will fire before widget
    * level handlers respond to the event, and will fire for every keyPress event, not just those triggered by some specific
    * key or key-combination.
    *
    * @param keyName the key name
    * @param callback the callback function
    * @deprecated in favor of {@link com.smartgwt.client.util.Page#registerKey(String, PageKeyHandler)}
    */
    public static native void registerKey(String keyName, KeyCallback callback)/*-{
        $wnd.isc.Page.registerKey(keyName, $entry(function(key) {
            callback.@com.smartgwt.client.util.KeyCallback::execute(Ljava/lang/String;)(key);
        }));
    }-*/;

   /**
    * Fire some action when the Page receives a keyPress event from a certain key.
    * Note that if a widget has keyboard focus, this action will fire only after any widget-level
    * keyPress handlers have fired and bubbled the event up to the top of their ancestor chain.
    * Multiple actions can be registered to fire on a single keyPress using this method.
    * This differs from calling Page.setEvent() with the "keyPress" events registered via setEvent() will fire before widget
    * level handlers respond to the event, and will fire for every keyPress event, not just those triggered by some specific
    * key or key-combination.
    *
    * @param keyIdentifier the key identifier
    * @param callback the callback function
    * @deprecated in favor of {@link com.smartgwt.client.util.Page#registerKey(KeyIdentifier, PageKeyHandler)}
    */
    public static native void registerKey(KeyIdentifier keyIdentifier, KeyCallback callback)/*-{
        var keyIdentifierJS = keyIdentifier.@com.smartgwt.client.core.DataClass::getJsObj()();
        $wnd.isc.Page.registerKey(keyIdentifierJS, $entry(function(key) {
            callback.@com.smartgwt.client.util.KeyCallback::execute(Ljava/lang/String;)(key);
        }));
    }-*/;

   /**
    * Fire some action when the Page receives a keyPress event from a certain key.
    * Note that if a widget has keyboard focus, this action will fire only after any widget-level
    * keyPress handlers have fired and bubbled the event up to the top of their ancestor chain.
    * Multiple actions can be registered to fire on a single keyPress using this method.
    * This differs from calling Page.setEvent() with the "keyPress" events registered via 
    * setEvent() will fire before widget level handlers respond to the event, and will fire for 
    * every keyPress event, not just those triggered by some specific key or key-combination.
    * To attempt to cancel the native behavior of a browser-level event, call cancel() on the 
    * PageKeyHandler.   Note, however, that not all browsers support cancelling all native 
    * actions, and that cancelling certain native key shortcuts can be annoying to end users 
    * (like cancelling a key shortcut used to create a new bookmark, for example).
    *
    * @param keyName the key name
    * @param callback a cancellable PageKeyHandler instance
    */
    public static native void registerKey(String keyName, PageKeyHandler callback)/*-{
        $wnd.isc.Page.registerKey(keyName, $entry(function(key) {
            callback.@com.smartgwt.client.util.PageKeyHandler::execute(Ljava/lang/String;)(key);
            if ($wnd.isc.Page._keyCallbackCancelled == true) {
                delete $wnd.isc.Page._keyCallbackCancelled;
                return false;
            }
        }));
    }-*/;

    /**
    * Fire some action when the Page receives a keyPress event from a certain key.
    * Note that if a widget has keyboard focus, this action will fire only after any widget-level
    * keyPress handlers have fired and bubbled the event up to the top of their ancestor chain.
    * Multiple actions can be registered to fire on a single keyPress using this method.
    * This differs from calling Page.setEvent() with the "keyPress" events registered via 
    * setEvent() will fire before widget level handlers respond to the event, and will fire for 
    * every keyPress event, not just those triggered by some specific key or key-combination.  
    * To attempt to cancel the native behavior of a browser-level event, call cancel() on the 
    * PageKeyHandler.   Note, however, that not all browsers support cancelling all native 
    * actions, and that cancelling certain native key shortcuts can be annoying to end users 
    * (like cancelling a key shortcut used to create a new bookmark, for example).
    *
    * @param keyIdentifier the key identifier
    * @param callback a cancellable PageKeyHandler instance
    */
    public static native void registerKey(KeyIdentifier keyIdentifier, PageKeyHandler callback)/*-{
        var keyIdentifierJS = keyIdentifier.@com.smartgwt.client.core.DataClass::getJsObj()();
        $wnd.isc.Page.registerKey(keyIdentifierJS, $entry(function(key) {
            callback.@com.smartgwt.client.util.PageKeyHandler::execute(Ljava/lang/String;)(key);
            if ($wnd.isc.Page._keyCallbackCancelled == true) {
                delete $wnd.isc.Page._keyCallbackCancelled;
                return false;
            }
        }));
    }-*/;

    /**
     * Clears an action registered to fire on a specific keyPress event via the {@link #registerKey(String, KeyCallback)}  method.
     *
     * @param keyName name of key to clear registry entries for
     */
    public static native void unregisterKey(String keyName)/*-{
        $wnd.isc.Page.unregisterKey(keyName);
    }-*/;
    
    /**
     * Set the title of the page, which is typically shown as part of the browser window title
     *
     * @param title the page title
     */
    public static native void setTitle(String title) /*-{
        $wnd.isc.Page.setTitle(title);
    }-*/;

    /**
     * Get the width of the visible portion of the window, not including browser chrome or the scrollbar area.
     *
     * @return the width of the page
     */
    public static native int getWidth() /*-{
        return $wnd.isc.Page.getWidth();
    }-*/;

    /**
     * Get the height of the visible portion of the window, not including browser chrome or the scrollbar area. 
     *
     * @return the height of the page
     */
    public static native int getHeight() /*-{
        return $wnd.isc.Page.getHeight();
    }-*/;


    /**
     * Get the width of the user's screen, in pixels.
     *
     * @return the screen width
     */
    public static native int getScreenWidth() /*-{
        return $wnd.isc.Page.getScreenWidth();
    }-*/;

    /**
     * Get the height of the user's screen, in pixels.
     *
     * @return the screen height
     */
    public static native int getScreenHeight() /*-{
        return $wnd.isc.Page.getScreenHeight();
    }-*/;

    /**
     * This method only applies to browsers who support the special viewport meta html tag such as Safari running on the
     * iPhone. <P> This method will dynamically change the viewport configuration, allowing you to set an initial size or scale
     * level and enable / disable user-scaling. Typically this method will be called with a value for scale, width or height
     * rather than passing in values for all three properties.<br> See the apple documentation about configuring the viewport
     * for more information:
     * @externalLink{http://developer.apple.com/safari/library/documentation/AppleApplications/Reference/SafariWebContent/UsingtheViewport/UsingtheViewport.html}
     * <P> <i>Note:</i> Modifying the width/height or initial scale of the viewport has 2 user-visible effects: <ul> <li>HTML
     * elements may reflow to fit the specified size (or the implied size calculated     from the specified scale level and the
     * native device size).</li> <li>If the user has not scaled the application explicitly, and no other scaling or sizing    
     * attributes were specified via a viewport meta tag for this page, the application will     zoom to specified scale
     * level(or the scale level required to fit the specified viewport     size to the device's screen).</li> </ul>
     * @param scale Desired scale level where 1 indicates no scaling (each CSS pixel    will be displayed using 1px on the physical device).
     * Pass in null to avoid setting   this property.
     * @param width Desired viewport width in pixels. This indicates how many pixels   should fit within the device screen. Pass in null to
     * avoid setting this property.
     * @param height Desired viewport height in pixels. This indicates how many pixels   should fit within the device screen. Pass in null to
     * avoid setting this property.
     * @param scalable Should the user be able to scale the application (using   pinch gestures, double tapping, rotating the device, etc.)?
     */
    public static native void updateViewport(Float scale, Integer width, Integer height, Boolean scalable) /*-{
    
		// convert params to javascript numbers / boolean before passing to updateViewport
	 	if (scale != null) {
	 		scale = scale.@java.lang.Float::floatValue()();
	 	}
	 	if (width != null) {
	 		width = width.@java.lang.Integer::intValue()();
	 	}
	 	if (height != null) {
	 		height = height.@java.lang.Integer::intValue()();
	 	}
	    if (scalable != null) {
	     	scalable = scalable.@java.lang.Boolean::booleanValue()();
	 	}
	    
	    $wnd.isc.Page.updateViewport(scale, width, height, scalable);
	}-*/;

    private static HandlerManager ensureHandlerManager() {
        if (handlerManager == null) handlerManager = new HandlerManager(null);
        return handlerManager;
    }

    private static native void setOrientationChangeEvent() /*-{
        var eventID = $wnd.isc.Page.setEvent("orientationChange", $entry(function () {
            var eventJ = @com.smartgwt.client.util.events.OrientationChangeEvent::new()();
            @com.smartgwt.client.util.Page::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(eventJ);
        }));
        @com.smartgwt.client.util.Page::orientationChangeEventID = @java.lang.Double::valueOf(D)(eventID);
    }-*/;

    public static HandlerRegistration addOrientationChangeHandler(com.smartgwt.client.util.events.OrientationChangeHandler handler) {
        final HandlerManager handlerManager = ensureHandlerManager();
        if (orientationChangeEventID == null) setOrientationChangeEvent();
        return handlerManager.addHandler(com.smartgwt.client.util.events.OrientationChangeEvent.getType(), handler);
    }

    private static <H extends com.google.gwt.event.shared.EventHandler> void fireEvent(GwtEvent<H> event) {
        if (handlerManager != null) {
            handlerManager.fireEvent(event);
        }
    }

}
