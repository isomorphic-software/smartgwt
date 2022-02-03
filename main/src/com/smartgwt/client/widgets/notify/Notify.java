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
 
package com.smartgwt.client.widgets.notify;


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
 * Notify provides a means to display on-screen messages that are automatically dismissed after a configurable amount of
 * time, as an alternative to {@link com.smartgwt.client.util.isc#confirm modal notification} dialogs that can lower end
 * user productivity.  Messages may be shown at a particular location, specified either with viewport-relative coordinates,
 * or as an edge or center location relative to the viewport or a canvas.  Messages can be configured to appear and
 * disappear instantly, by sliding into (or out of) view, or by fading in (or out). <P> One or more {@link
 * com.smartgwt.client.widgets.notify.NotifyAction actions} can be provided when {@link
 * com.smartgwt.client.widgets.notify.Notify#addMessage addMessage()} is called to display a message.  They will be
 * rendered as links on which to click to execute the action. <P> The behavior and appearance of messages are configured
 * per {@link com.smartgwt.client.docs.NotifyType}, which is simply a string that identifies that message group, similar to
 * log category. By calling {@link com.smartgwt.client.widgets.notify.Notify#configureMessages configureMessages()} with
 * the <code>NotifyType</code>, it can be assigned a {@link com.smartgwt.client.widgets.notify.NotifySettings}
 * configuration to control message animation, placement, and the the {@link com.smartgwt.client.widgets.Label} used to
 * render each message, allowing styling and autofit behavior to be configured. <P> Messages of the same
 * <code>NotifyType</code> may be stacked to provide a visible history, with a configurable stacking direction and maximum
 * stacking depth.  Details on how to configure messages are provided in the documentation for {@link
 * com.smartgwt.client.widgets.notify.NotifySettings}. <P> Messages for different <code>NotifyType</code>s are stacked
 * separately and animated by independent Framework pipelines.  It's up to you to configure the placement of supported
 * <code>NotifyType</code>s in your app so that they don't overlap, as the Framework doesn't manage it.  For example,
 * separate <code>NotifyType</code>s could be assigned separate screen edges, or assigned a different {@link
 * com.smartgwt.client.widgets.notify.NotifySettings#getPositionCanvas NotifySettings.positionCanvas}. <P> To dismiss a
 * message manually before its scheduled duration expires, you may call {@link
 * com.smartgwt.client.widgets.notify.Notify#dismissMessage dismissMessage()} with a <code>NotifyType</code> (to dismiss
 * all such messages) or an ID previously returned by {@link com.smartgwt.client.widgets.notify.Notify#addMessage
 * addMessage()} (to dismiss that single message). <P> <B>Warnings and Errors</B> <P> Each notification may be assigned a
 * {@link com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority} in the settings passed to
 * {@link com.smartgwt.client.widgets.notify.Notify#addMessage addMessage()}.  By default, all <code>NotifyType</code>s are
 * configured to have priority {@link com.smartgwt.client.widgets.notify.Notify#MESSAGE MESSAGE}, except for "error" and
 * "warn" <code>NotifyType</code>s, which are configured with priority {@link
 * com.smartgwt.client.widgets.notify.Notify#ERROR ERROR} and {@link com.smartgwt.client.widgets.notify.Notify#WARN WARN},
 * respectively. <P> The {@link com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority}
 * determines the default styling of a message, and which message to remove if a new message is sent while the message
 * stack is already at its limit.  We recommended applying a {@link
 * com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority} as the best approach for showing
 * pre-styled warnings and errors, since that allows you to interleave them with ordinary messages in a single
 * <code>NotifyType</code>. <P> Alternatively, you can display pre-styled warnings and errors by calling {@link
 * com.smartgwt.client.widgets.notify.Notify#addMessage addMessage()} with the separate <code>NotifyType</code>s "warning"
 * and "error", respectively, but then you must take care to {@link
 * com.smartgwt.client.widgets.notify.Notify#configureMessages assign each NotifyType} used to a separate screen location
 * to avoid one rendering on top of the other. <P> <B>Viewport Considerations</B> <P> Messages are edge or corner-aligned
 * based on the {@link com.smartgwt.client.util.Page#getScrollWidth viewport width} and {@link
 * com.smartgwt.client.util.Page#getScrollHeight viewport height} of the current page rather than screen, so you may need
 * to scroll to see the targeted corner or edge.  Note that widgets placed offscreen below or to the right of a page may
 * cause the browser to report a larger viewport, and prevent messages from being visible, even if no scrollbars are
 * present.  If you need to stage widgets offscreen for measurement or other reasons, place them above or to the left. <P>
 * <B>Modal Windows and Click Masks</B> <P> Messages are always shown above all other widgets, including {@link
 * com.smartgwt.client.widgets.Window#getIsModal modal windows} and {@link com.smartgwt.client.widgets.Canvas#showClickMask
 * click masks}.  This is because it's expected that messages are "out of band" and logically indepedent of the widget
 * hierarchy being shown. We apply this layering policy even for windows and widgets created by {@link
 * com.smartgwt.client.widgets.notify.NotifyAction}s. If there may a scenario where a message can block a window created by
 * an action, set {@link com.smartgwt.client.widgets.notify.NotifySettings#getCanDismiss NotifySettings.canDismiss} to true
 * so that an unobstructed view of the underlying widgets can be restored. <P> In the linked sample, note how we take care
 * to reuse the existing modal window, if any, if the "Launch..." link is clicked, so that repeated clicks never stack
 * windows over each other.
 * @see com.smartgwt.client.util.isc#say
 * @see com.smartgwt.client.util.isc#confirm
 */
@BeanFactory.FrameworkClass
public class Notify {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Displays a new message, subject to the {@link com.smartgwt.client.widgets.notify.Notify#configureMessages stored
     * configuration} for the passed <code>notifyType</code>, overridden by any passed <code>settings</code>. Returns an opaque
     * <code>MessageID</code> that can be passed to {@link com.smartgwt.client.widgets.notify.Notify#dismissMessage
     * dismissMessage()} to clear it. <P> Note that an empty string may be passed for <code>contents</code> if
     * <code>actions</code> have been provided, so you may have the message consist only of your specified actions. <P> Most
     * users should do all configuration up front via a call to {@link
     * com.smartgwt.client.widgets.notify.Notify#configureMessages configureMessages()}. The <code>settings</code> argument in
     * this method is provided to allow adjustment of properties that affect only one message, such as {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitWidth autoFitWidth}, {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getStyleName styleName}, or  {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getLabelProperties labelProperties}.  Making changes to  {@link
     * com.smartgwt.client.types.MultiMessageMode stacking}-related properties via this argument isn't supported, unless
     * specifically documented on the property.
     * @param contents message to be displayed.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     *
     * @return opaque identifier for message
     * @see com.smartgwt.client.util.isc#say
     * @see com.smartgwt.client.util.isc#confirm
     * @see com.smartgwt.client.util.isc#notify
     * @see com.smartgwt.client.docs.HTMLString HTMLString
     */
    public static native MessageID addMessage(String contents) /*-{
        var ret = $wnd.isc.Notify.addMessage(contents);
        return ret;
    }-*/;

    /**
     * @see Notify#addMessage
     */
    public static MessageID addMessage(String contents, NotifyAction... actions){
        return addMessage(contents, actions, null, null);
    }

    /**
     * @see Notify#addMessage
     */
    public static MessageID addMessage(String contents, NotifyAction[] actions, String notifyType){
        return addMessage(contents, actions, notifyType, null);
    }

	/**
     * Displays a new message, subject to the {@link com.smartgwt.client.widgets.notify.Notify#configureMessages stored
     * configuration} for the passed <code>notifyType</code>, overridden by any passed <code>settings</code>. Returns an opaque
     * <code>MessageID</code> that can be passed to {@link com.smartgwt.client.widgets.notify.Notify#dismissMessage
     * dismissMessage()} to clear it. <P> Note that an empty string may be passed for <code>contents</code> if
     * <code>actions</code> have been provided, so you may have the message consist only of your specified actions. <P> Most
     * users should do all configuration up front via a call to {@link
     * com.smartgwt.client.widgets.notify.Notify#configureMessages configureMessages()}. The <code>settings</code> argument in
     * this method is provided to allow adjustment of properties that affect only one message, such as {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitWidth autoFitWidth}, {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getStyleName styleName}, or  {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getLabelProperties labelProperties}.  Making changes to  {@link
     * com.smartgwt.client.types.MultiMessageMode stacking}-related properties via this argument isn't supported, unless
     * specifically documented on the property.
     * @param contents message to be displayed.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     * @param actions actions (if any) for this message
     * @param notifyType category of message; default "message".
     * See {@link com.smartgwt.client.docs.NotifyType NotifyType}
     * @param settings display and behavior settings for                                               this message that override the          
     * {@link com.smartgwt.client.widgets.notify.Notify#configureMessages configured}                                          
     *     settings for the <code>notifyType</code>
     *
     * @return opaque identifier for message
     * @see com.smartgwt.client.util.isc#say
     * @see com.smartgwt.client.util.isc#confirm
     * @see com.smartgwt.client.util.isc#notify
     */
    public static native MessageID addMessage(String contents, NotifyAction[] actions, String notifyType, NotifySettings settings) /*-{
        var ret = $wnd.isc.Notify.addMessage(contents, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(actions), notifyType, settings == null ? null : settings.@com.smartgwt.client.core.DataClass::getJsObj()());
        return ret;
    }-*/;
	

	/**
     * Can the message corresponding to the <code>messageID</code> be dismissed?  Returns false if the message is no longer
     * being shown.  The <code>messageID</code> must have been previously returned by {@link
     * com.smartgwt.client.widgets.notify.Notify#addMessage addMessage()}.
     * @param messageID message identifier to dismiss
     *
     * @return whether message can be dismissed
     * @see com.smartgwt.client.widgets.notify.Notify#dismissMessage
     */
    public static native boolean canDismissMessage(MessageID messageID) /*-{
        var ret = $wnd.isc.Notify.canDismissMessage(messageID);
        return ret == null ? false : ret;
    }-*/;


	/**
     * Changes the default settings that are applied when you create a new {@link com.smartgwt.client.docs.NotifyType} with
     * {@link com.smartgwt.client.widgets.notify.Notify#configureMessages configureMessages()}.  If you want to change the
     * defaults for the built-in NotifyTypes "message", "warn", and "error", with this method, it must be called before the
     * first call to {@link com.smartgwt.client.widgets.notify.Notify#configureMessages configureMessages()} or {@link
     * com.smartgwt.client.widgets.notify.Notify#addMessage addMessage()}.  Once a NotifyType has been created, you must use
     * {@link com.smartgwt.client.widgets.notify.Notify#configureMessages configureMessages()} to change its settings. <P> Note
     * that for defaults that depend on priority (and thus differ between the built-in NotifyTypes), this method only sets the
     * defaults for the "message" NotifyType.
     * @param settings changes to NotifyType defaults
     * @see com.smartgwt.client.widgets.notify.Notify#configureMessages
     */
    public static native void configureDefaultSettings(NotifySettings settings) /*-{
        $wnd.isc.Notify.configureDefaultSettings(settings.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


	/**
     * Sets the default {@link com.smartgwt.client.widgets.notify.NotifySettings} for the specified {@link
     * com.smartgwt.client.docs.NotifyType}.  This may be overridden by passing settings to {@link
     * com.smartgwt.client.widgets.notify.Notify#addMessage addMessage()} when the message is shown, but changing {@link
     * com.smartgwt.client.types.MultiMessageMode stacking}-related properties via {@link
     * com.smartgwt.client.widgets.notify.Notify#addMessage addMessage()} isn't supported, <P> By default, the {@link
     * com.smartgwt.client.docs.NotifyType}s "message", "warn", and "error" are predefined, each with their own {@link
     * com.smartgwt.client.widgets.notify.NotifySettings} with different {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getStyleName styleName}s.  When configuring a new (non-predefined)
     * NotifyType with this method, any {@link com.smartgwt.client.widgets.notify.NotifySettings} left unset will default to
     * those for NotifyType "message".
     * @param notifyType category of message; null defaults to "message".
     * See {@link com.smartgwt.client.docs.NotifyType NotifyType}
     * @param settings settings to store for the <code>notifyType</code>
     * @see com.smartgwt.client.widgets.notify.Notify#configureDefaultSettings
     */
    public static native void configureMessages(String notifyType, NotifySettings settings) /*-{
        $wnd.isc.Notify.configureMessages(notifyType, settings.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


	/**
     * Dismisses one or more messages currently being shown, subject to the existing settings for their {@link
     * com.smartgwt.client.docs.NotifyType}.  You may either pass the opaque message identifier returned from the call to
     * {@link com.smartgwt.client.widgets.notify.Notify#addMessage addMessage()} to dismiss a single message, or a
     * <code>NotifyType</code> to dismiss all such messages.
     * @param messageID message identifier or category to dismiss
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getDuration
     * @see com.smartgwt.client.widgets.notify.NotifyAction#getWholeMessage
     */
    public static native void dismissMessage(MessageID messageID) /*-{
        $wnd.isc.Notify.dismissMessage(messageID);
    }-*/;

	/**
     * Dismisses one or more messages currently being shown, subject to the existing settings for their {@link
     * com.smartgwt.client.docs.NotifyType}.  You may either pass the opaque message identifier returned from the call to
     * {@link com.smartgwt.client.widgets.notify.Notify#addMessage addMessage()} to dismiss a single message, or a
     * <code>NotifyType</code> to dismiss all such messages.
     * @param messageID message identifier or category to dismiss
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getDuration
     * @see com.smartgwt.client.widgets.notify.NotifyAction#getWholeMessage
     * @see com.smartgwt.client.docs.NotifyType NotifyType
     */
    public static native void dismissMessage(String messageID) /*-{
        $wnd.isc.Notify.dismissMessage(messageID);
    }-*/;


	/**
     * 
     * @param messageID message identifier to check
     *
     * @return whether message has any actions
     * @see com.smartgwt.client.widgets.notify.Notify#addMessage
     * @see com.smartgwt.client.widgets.notify.Notify#setMessageActions
     */
    public static native boolean messageHasActions(MessageID messageID) /*-{
        var ret = $wnd.isc.Notify.messageHasActions(messageID);
        return ret == null ? false : ret;
    }-*/;


	/**
     * Updates the actions of the message from those, if any, passed originally to {@link
     * com.smartgwt.client.widgets.notify.Notify#addMessage addMessage()}, while preserving any existing {@link
     * com.smartgwt.client.widgets.notify.Notify#addMessage contents}. <P> See {@link
     * com.smartgwt.client.widgets.notify.Notify#setMessageContents setMessageContents()} for further guidance and animation
     * details.
     * @param messageID message identifier from {@link com.smartgwt.client.widgets.notify.Notify#addMessage addMessage()}
     * @param actions updated actions for this message
     */
    public static native void setMessageActions(MessageID messageID, NotifyAction... actions) /*-{
        $wnd.isc.Notify.setMessageActions(messageID, @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(actions));
    }-*/;


	/**
     * Updates the contents of the message from what was passed originally to {@link
     * com.smartgwt.client.widgets.notify.Notify#addMessage addMessage()}, while preserving any existing {@link
     * com.smartgwt.client.widgets.notify.NotifyAction actions}. <P> The purpose of this method is to support messages that
     * contain timer countdowns or other data that perhaps need refreshing during display.  If you find yourself replacing the
     * entire content with something new, you should probably just add it as a new message. <P> Note that this method has
     * minimal animation support.  The change in message content and corresponding resizing are instant, but the repositioning
     * of the message or stack (if stacked) to keep your requested {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPosition alignment} is controlled by {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getRepositionMethod NotifySettings.repositionMethod}, allowing slide
     * animation.  However, that setting is ignored and the repositioning is instant if you've chosen {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPositionCanvas viewport alignment} to a border or corner along the
     * {@link com.smartgwt.client.widgets.notify.NotifySettings#getPosition bottom or right} viewport edge, or if an animation
     * is already in progress, in which case the instant repositioning will happen after it completes.
     * @param messageID message identifier from {@link com.smartgwt.client.widgets.notify.Notify#addMessage addMessage()}
     * @param contents updated message.
     * See {@link com.smartgwt.client.docs.HTMLString HTMLString}
     */
    public static native void setMessageContents(MessageID messageID, String contents) /*-{
        $wnd.isc.Notify.setMessageContents(messageID, contents);
    }-*/;


    // ***********************************************************



    /**
     * Highest priority.  Default priority of 
     * {@link com.smartgwt.client.docs.NotifyType NotifyType}: "error".
     */
    public static final int ERROR = 1;

    /**
     * Second-highest priority.  Default priority of
     * {@link com.smartgwt.client.docs.NotifyType NotifyType}: "warn".
     */
    public static final int WARN = 2;

    /**
     * Third-highest priority.  Default priority for all
     * {@link com.smartgwt.client.docs.NotifyType NotifyType}s other than "error" and "warn".
     */
    public static final int MESSAGE = 3;


}
