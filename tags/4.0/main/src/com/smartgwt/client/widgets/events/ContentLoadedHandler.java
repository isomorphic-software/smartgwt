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
 
package com.smartgwt.client.widgets.events;

import com.google.gwt.event.shared.EventHandler;

public interface ContentLoadedHandler extends EventHandler {
    /**
     * StringMethod fired when content is completely loaded in this htmlFlow. Has no default  implementation. May be observed
     * or overridden as a notification type method to fire custom logic when loading completes. <P> Notes: <ul><li>A call to
     * {@link com.smartgwt.client.widgets.Canvas#setContents this.setContents()}   will cause this notification to be fired
     * when  the contents have been set. If {@link com.smartgwt.client.widgets.HTMLFlow#getEvalScriptBlocks evalScriptBlocks}
     * is true, and the HTML passed  into <code>setContents()</code> contains any <code>&lt;script src=... &gt;</code>  tags,
     * this callback will be fired asynchronously once the scripts have been loaded  from the server and executed, as well as
     * having the widget content updated</li> <li>When using {@link com.smartgwt.client.widgets.HTMLFlow#getContentsURL
     * contentsURL}, this does not apply to htmlFlows with  {@link com.smartgwt.client.widgets.HTMLFlow#getContentsType
     * contentsType} set to <code>"page"</code></li></ul>
     *
     * @param event the event
     */
    void onContentLoaded(com.smartgwt.client.widgets.events.ContentLoadedEvent event);
}
