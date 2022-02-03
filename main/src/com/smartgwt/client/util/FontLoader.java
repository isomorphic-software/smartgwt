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

import com.google.gwt.event.shared.*;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;

import com.smartgwt.client.util.*;
import com.smartgwt.client.util.events.*;
import com.smartgwt.client.util.workflow.*;
import com.smartgwt.client.util.workflow.Process; // required to override java.lang.Process


/**
 * Force-loads the custom fonts declared in the {@link com.smartgwt.client.docs.Skinning current skin's CSS file} and
 * updates any potentially-affected, already-drawn canvii when loading completes.  Without FontLoader, auto-sized canvii
 * that use custom fonts may end up with the wrong size if a page is loaded when its custom fonts are not available in the
 * browser cache. <P> To disable FontLoader, set &nbsp;<code>window.isc_loadCustomFonts = false</code>&nbsp; before Smart
 * GWT is loaded. <P>  If you want to avoid the Framework redrawing canvii after the fonts load, you may want to code your
 * app to delay drawing anything until the skin fonts are loaded.  You can check {@link
 * com.smartgwt.client.util.FontLoader#isLoadingComplete isLoadingComplete()} to see whether loading is done, and if it's
 * not, you can  call {@link #addFontsLoadedHandler addFontsLoadedHandler()} to run code when it's done or  {@link
 * #addFontLoadingFailedHandler addFontLoadingFailedHandler()} to run code if there's an error. <P> <h3>Advanced Usage</h3>
 * <code>FontLoader</code> will use the new  <a
 * href='https://developer.mozilla.org/en-US/docs/Web/API/CSS_Font_Loading_API' target='_blank'>CSS Font Loading API</a> in
 * browsers in which it's available and has proven reliable.  Otherwise, we fall back to canvas measurement techniques to
 * detect loading.  To force fallback and avoid the API, set &nbsp;<code>window.isc_useCSSFontAPI = false</code>&nbsp;, or
 * to force the API to be used (where it exists but may be unreliable) set &nbsp;<code>window.isc_useCSSFontAPI = 
 * true</code>&nbsp, before Smart GWT is loaded. <P> If you're loading additional style sheets, beyond the skin, that
 * declare custom fonts with &#064;font-face, you can request that the <code>FontLoader</code> force-load them as well by
 * specifying them in <code>window.isc_additionalFonts</code> as an array of the font family names matching those from the
 * &#064;font-face declarations. <P> Note that currently, if you have more than one font with the same font family name in
 * your CSS, you'll need to use the CSS Font Loading API approach if you want them all loaded by the FontLoader.  Under the
 * measurement approach, the FontLoader is only able to load the default font for each font family, since it has no
 * knowledge beyond the specified family names.
 */
@BeanFactory.FrameworkClass
public class FontLoader {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Whether all requested custom fonts have been loaded.  If this method returns true, you know that the {@link
     * com.smartgwt.client.util.FontLoader} won't need to redraw any canvii drawn afterwards, and that a  {@link
     * com.smartgwt.client.util.events.FontsLoadedEvent} or {@link com.smartgwt.client.util.events.FontLoadingFailedEvent}
     * won't arrive (it may have previously been handled).
     *
     * @return whether all requested fonts have been loaded
     */
    public static native boolean isLoadingComplete() /*-{
        var ret = $wnd.isc.FontLoader.isLoadingComplete();
        return ret == null ? false : ret;
    }-*/;


    // ***********************************************************



    private static HandlerManager handlerManager;

    private static Double fontsLoadedEventID;
    private static Double fontLoadingFailedEventID;

    private static HandlerManager ensureHandlerManager() {
        if (handlerManager == null) handlerManager = new HandlerManager(null);
        return handlerManager;
    }

    private static native void setFontsLoadedEvent() /*-{
        var eventID = $wnd.isc.Page.setEvent("fontsLoaded", $entry(function () {
            var eventJ = @com.smartgwt.client.util.events.FontsLoadedEvent::new()();
            @com.smartgwt.client.util.FontLoader::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(eventJ);
        }));
        @com.smartgwt.client.util.FontLoader::fontsLoadedEventID = @java.lang.Double::valueOf(D)(eventID);
    }-*/;

    /**
     * Adds a handler that will be called when the FontLoader finishes loading any custom skin
     * fonts.
     * @param handler loading finished handler
     * @return registration
     */
    public static HandlerRegistration addFontsLoadedHandler(FontsLoadedHandler handler) {
        final HandlerManager handlerManager = ensureHandlerManager();
        if (fontsLoadedEventID == null) setFontsLoadedEvent();
        return handlerManager.addHandler(FontsLoadedEvent.getType(), handler);
    }

    private static native void setFontLoadingFailedEvent() /*-{
        var eventID = $wnd.isc.Page.setEvent("fontLoadingFailed", $entry(function () {
            var eventJ = @com.smartgwt.client.util.events.FontLoadingFailedEvent::new()();
            @com.smartgwt.client.util.FontLoader::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(eventJ);
        }));
        @com.smartgwt.client.util.FontLoader::fontLoadingFailedEventID = @java.lang.Double::valueOf(D)(eventID);
    }-*/;

    /**
     * Adds a handler that will be called if the FontLoader fails to load any of the custom skin
     * fonts.
     * @param handler loading failed handler
     * @return registration
     */
    public static HandlerRegistration addFontLoadingFailedHandler(
                                         FontLoadingFailedHandler handler) 
    {
        final HandlerManager handlerManager = ensureHandlerManager();
        if (fontLoadingFailedEventID == null) setFontLoadingFailedEvent();
        return handlerManager.addHandler(FontLoadingFailedEvent.getType(), handler);
    }

    private static <H extends com.google.gwt.event.shared.EventHandler> void
                                             fireEvent(GwtEvent<H> event)
    {
        if (handlerManager != null) {
            handlerManager.fireEvent(event);
        }
    }


}
