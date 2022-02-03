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
 * An object used to configure how messages shown by {@link com.smartgwt.client.widgets.notify.Notify#addMessage
 * Notify.addMessage()} are drawn and behave.
 * @see com.smartgwt.client.widgets.notify.Notify#addMessage
 * @see com.smartgwt.client.widgets.notify.Notify#configureMessages
 */
@BeanFactory.FrameworkClass
public class NotifySettings extends DataClass {

    public static NotifySettings getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new NotifySettings(jsObj);
    }
        


    public NotifySettings(){
        
    }

    public NotifySettings(JavaScriptObject jsObj){
        
        setJavaScriptObject(jsObj);
    }


    // ********************* Properties / Attributes ***********************

    /**
     * HTML to be added before each action to separate it from the previous action. For the first action, it will only be added
     * if the message contents aren't empty. <P> You may override this on a per action basis using {@link
     * com.smartgwt.client.widgets.notify.NotifyAction#getSeparator NotifyAction.separator}. <P> Besides the default, some
     * other known useful values are "&amp;emsp;" and "&amp;nbsp;".
     *
     * @param actionSeparator New actionSeparator value. Default value is " "
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public NotifySettings setActionSeparator(String actionSeparator) {
        return (NotifySettings)setAttribute("actionSeparator", actionSeparator);
    }

    /**
     * HTML to be added before each action to separate it from the previous action. For the first action, it will only be added
     * if the message contents aren't empty. <P> You may override this on a per action basis using {@link
     * com.smartgwt.client.widgets.notify.NotifyAction#getSeparator NotifyAction.separator}. <P> Besides the default, some
     * other known useful values are "&amp;emsp;" and "&amp;nbsp;".
     *
     * @return Current actionSeparator value. Default value is " "
     * @see com.smartgwt.client.docs.HTMLString HTMLString 
     */
    public String getActionSeparator()  {
        return getAttributeAsString("actionSeparator");
    }
    

    /**
     * The CSS class to apply to action text in this message.  default is: <ul> <li>"notifyErrorActionLink" for {@link
     * com.smartgwt.client.docs.NotifyType}: "error", <li>"notifyWarnActionLink" for {@link
     * com.smartgwt.client.docs.NotifyType}: "warn", and <li>"notifyMessageActionLink" for all other {@link
     * com.smartgwt.client.docs.NotifyType}s. </ul> However, if you specify a {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority}, it will determine the default
     * rather than the actual <code>NotifyType</code>, if {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getApplyPriorityToAppearance applyPriorityToAppearance} is true.
     *
     * @param actionStyleName New actionStyleName value. Default value is varies
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setMessagePriority
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public NotifySettings setActionStyleName(String actionStyleName) {
        return (NotifySettings)setAttribute("actionStyleName", actionStyleName);
    }

    /**
     * The CSS class to apply to action text in this message.  default is: <ul> <li>"notifyErrorActionLink" for {@link
     * com.smartgwt.client.docs.NotifyType}: "error", <li>"notifyWarnActionLink" for {@link
     * com.smartgwt.client.docs.NotifyType}: "warn", and <li>"notifyMessageActionLink" for all other {@link
     * com.smartgwt.client.docs.NotifyType}s. </ul> However, if you specify a {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority}, it will determine the default
     * rather than the actual <code>NotifyType</code>, if {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getApplyPriorityToAppearance applyPriorityToAppearance} is true.
     *
     * @return Current actionStyleName value. Default value is varies
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getActionStyleName()  {
        return getAttributeAsString("actionStyleName");
    }
    

    /**
     * Controls how messages appear at or reach their requested location.  The default of "slide" is recommended because the
     * motion will draw the user's attention to the notification.
     *
     * @param appearMethod New appearMethod value. Default value is "slide"
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setAppearMethod(NotifyTransition appearMethod) {
        return (NotifySettings)setAttribute("appearMethod", appearMethod == null ? null : appearMethod.getValue());
    }

    /**
     * Controls how messages appear at or reach their requested location.  The default of "slide" is recommended because the
     * motion will draw the user's attention to the notification.
     *
     * @return Current appearMethod value. Default value is "slide"
     */
    public NotifyTransition getAppearMethod()  {
        return EnumUtil.getEnum(NotifyTransition.values(), getAttribute("appearMethod"));
    }
    

    /**
     * Whether to default properties affecting the message appearance to those of the built-in {@link
     * com.smartgwt.client.docs.NotifyType} corresponding to the  {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority}.  Default is true except for
     * {@link com.smartgwt.client.docs.NotifyType}s "error" and "warn", which default to false.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param applyPriorityToAppearance New applyPriorityToAppearance value. Default value is varies
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setMessagePriority
     */
    public NotifySettings setApplyPriorityToAppearance(boolean applyPriorityToAppearance) {
        return (NotifySettings)setAttribute("applyPriorityToAppearance", applyPriorityToAppearance);
    }

    /**
     * Whether to default properties affecting the message appearance to those of the built-in {@link
     * com.smartgwt.client.docs.NotifyType} corresponding to the  {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority}.  Default is true except for
     * {@link com.smartgwt.client.docs.NotifyType}s "error" and "warn", which default to false.
     *
     * @return Current applyPriorityToAppearance value. Default value is varies
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority
     */
    public boolean getApplyPriorityToAppearance()  {
        Boolean result = getAttributeAsBoolean("applyPriorityToAppearance", true);
        return result == null ? false : result;
    }
    

    /**
     * Maximum auto-fit width for a message if {@link com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitWidth
     * autoFitWidth} is enabled. May be specified as a pixel value, or a percentage of page width.
     *
     * @param autoFitMaxWidth New autoFitMaxWidth value. Default value is 300
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setAutoFitWidth
     */
    public NotifySettings setAutoFitMaxWidth(Integer autoFitMaxWidth) {
        return (NotifySettings)setAttribute("autoFitMaxWidth", autoFitMaxWidth);
    }

    /**
     * Maximum auto-fit width for a message if {@link com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitWidth
     * autoFitWidth} is enabled. May be specified as a pixel value, or a percentage of page width.
     *
     * @return Current autoFitMaxWidth value. Default value is 300
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitWidth
     */
    public Integer getAutoFitMaxWidth()  {
        return getAttributeAsInt("autoFitMaxWidth");
    }

    /**
     * Maximum auto-fit width for a message if {@link com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitWidth
     * autoFitWidth} is enabled. May be specified as a pixel value, or a percentage of page width.
     *
     * @param autoFitMaxWidth New autoFitMaxWidth value. Default value is 300
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setAutoFitWidth
     */
    public NotifySettings setAutoFitMaxWidth(String autoFitMaxWidth) {
        return (NotifySettings)setAttribute("autoFitMaxWidth", autoFitMaxWidth);
    }

    /**
     * Maximum auto-fit width for a message if {@link com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitWidth
     * autoFitWidth} is enabled. May be specified as a pixel value, or a percentage of page width.
     *
     * @return Current autoFitMaxWidth value. Default value is 300
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitWidth
     */
    public String getAutoFitMaxWidthAsString()  {
        return getAttributeAsString("autoFitMaxWidth");
    }
    

    /**
     * If true, the specified width of the {@link com.smartgwt.client.widgets.Label} drawn for this message will be treated as
     * a minimum width.  If the message content string exceeds this, the {@link com.smartgwt.client.widgets.Label} will expand
     * to accommodate it up to {@link com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitMaxWidth autoFitMaxWidth}
     * (without the text wrapping). <P> Using this setting differs from simply disabling wrapping via {@link
     * com.smartgwt.client.widgets.Label#getWrap wrap:false} as the content will wrap if the {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitMaxWidth autoFitMaxWidth} is exceeded.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param autoFitWidth New autoFitWidth value. Default value is null
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setAutoFitWidth(Boolean autoFitWidth) {
        return (NotifySettings)setAttribute("autoFitWidth", autoFitWidth);
    }

    /**
     * If true, the specified width of the {@link com.smartgwt.client.widgets.Label} drawn for this message will be treated as
     * a minimum width.  If the message content string exceeds this, the {@link com.smartgwt.client.widgets.Label} will expand
     * to accommodate it up to {@link com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitMaxWidth autoFitMaxWidth}
     * (without the text wrapping). <P> Using this setting differs from simply disabling wrapping via {@link
     * com.smartgwt.client.widgets.Label#getWrap wrap:false} as the content will wrap if the {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitMaxWidth autoFitMaxWidth} is exceeded.
     *
     * @return Current autoFitWidth value. Default value is null
     */
    public Boolean getAutoFitWidth()  {
        return getAttributeAsBoolean("autoFitWidth", true);
    }
    

    /**
     * Displays an icon to allow a message to be dismissed through the UI.  Messages can always be dismissed programmatically
     * by calling {@link com.smartgwt.client.widgets.notify.Notify#dismissMessage Notify.dismissMessage()}.
     *
     * @param canDismiss New canDismiss value. Default value is false
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setCanDismiss(Boolean canDismiss) {
        return (NotifySettings)setAttribute("canDismiss", canDismiss);
    }

    /**
     * Displays an icon to allow a message to be dismissed through the UI.  Messages can always be dismissed programmatically
     * by calling {@link com.smartgwt.client.widgets.notify.Notify#dismissMessage Notify.dismissMessage()}.
     *
     * @return Current canDismiss value. Default value is false
     */
    public Boolean getCanDismiss()  {
        Boolean result = getAttributeAsBoolean("canDismiss", true);
        return result == null ? false : result;
    }
    

    /**
     * Controls how messages disappear from or leave their requested location.  The default of "fade" is recommended because a
     * slide animation would draw too much attention to a notification that is no longer current, whereas a subtle fade should
     * draw a minimum of attention (less even than instantaneously disappearing).
     *
     * @param disappearMethod New disappearMethod value. Default value is "fade"
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setDisappearMethod(NotifyTransition disappearMethod) {
        return (NotifySettings)setAttribute("disappearMethod", disappearMethod == null ? null : disappearMethod.getValue());
    }

    /**
     * Controls how messages disappear from or leave their requested location.  The default of "fade" is recommended because a
     * slide animation would draw too much attention to a notification that is no longer current, whereas a subtle fade should
     * draw a minimum of attention (less even than instantaneously disappearing).
     *
     * @return Current disappearMethod value. Default value is "fade"
     */
    public NotifyTransition getDisappearMethod()  {
        return EnumUtil.getEnum(NotifyTransition.values(), getAttribute("disappearMethod"));
    }
    

    /**
     * Length of time a message is shown before being auto-dismissed, in milliseconds. A value of 0 means that the message will
     * not be dismissed automatically. Messages can always be dismissed by calling {@link
     * com.smartgwt.client.widgets.notify.Notify#dismissMessage Notify.dismissMessage()} or, if {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getCanDismiss canDismiss} is set, by performing a "close click".
     *
     * @param duration New duration value. Default value is 5000
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setDuration(int duration) {
        return (NotifySettings)setAttribute("duration", duration);
    }

    /**
     * Length of time a message is shown before being auto-dismissed, in milliseconds. A value of 0 means that the message will
     * not be dismissed automatically. Messages can always be dismissed by calling {@link
     * com.smartgwt.client.widgets.notify.Notify#dismissMessage Notify.dismissMessage()} or, if {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getCanDismiss canDismiss} is set, by performing a "close click".
     *
     * @return Current duration value. Default value is 5000
     */
    public int getDuration()  {
        return getAttributeAsInt("duration");
    }
    

    /**
     * Time over which the fade-in effect runs for {@link com.smartgwt.client.types.NotifyTransition}: "fade", in milliseconds.
     *
     * @param fadeInDuration New fadeInDuration value. Default value is 500
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setFadeInDuration(int fadeInDuration) {
        return (NotifySettings)setAttribute("fadeInDuration", fadeInDuration);
    }

    /**
     * Time over which the fade-in effect runs for {@link com.smartgwt.client.types.NotifyTransition}: "fade", in milliseconds.
     *
     * @return Current fadeInDuration value. Default value is 500
     */
    public int getFadeInDuration()  {
        return getAttributeAsInt("fadeInDuration");
    }
    

    /**
     * Time over which the fade-out effect runs for {@link com.smartgwt.client.types.NotifyTransition}: "fade", in
     * milliseconds.
     *
     * @param fadeOutDuration New fadeOutDuration value. Default value is 500
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setFadeOutDuration(int fadeOutDuration) {
        return (NotifySettings)setAttribute("fadeOutDuration", fadeOutDuration);
    }

    /**
     * Time over which the fade-out effect runs for {@link com.smartgwt.client.types.NotifyTransition}: "fade", in
     * milliseconds.
     *
     * @return Current fadeOutDuration value. Default value is 500
     */
    public int getFadeOutDuration()  {
        return getAttributeAsInt("fadeOutDuration");
    }
    

    /**
     * Configures the properties, such as {@link com.smartgwt.client.widgets.Label#getAutoFit Label.autoFit}, {@link
     * com.smartgwt.client.widgets.Label#getAlign Label.align}, and {@link com.smartgwt.client.widgets.Label#getWidth
     * Label.width}. of the {@link com.smartgwt.client.widgets.Label} autochildren that will be used to draw messages, where
     * not already determined by message layout or other <code>NotifySettings</code> properties such as {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getStyleName styleName}. <P> Not all label properties are guaranteed
     * to work here, as the Notify system is assumed to layout message content and manage positioning messages.  In particular,
     * the following properties should be avoided: <table border=1 class="normal"> <tr bgcolor="#D0D0D0"><td>Property
     * Name</td><td>Issue</td><td>Guidance</td></tr> <tr> <td>margin</td> <td>Layout and positioning of the messages is handled
     * by the Notify system.</td> <td>Use {@link com.smartgwt.client.widgets.notify.NotifySettings#getStackSpacing
     * stackSpacing} to configure the separation between messages, and {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getLeftOffset leftOffset} and {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getTopOffset topOffset} to fine-tine stack {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPosition positioning}. </td> </tr> <tr> <td>padding</td>
     * <td>Padding is set by notification CSS so that children are positioned corrected relative to content.</td> <td>You can
     * apply your own {@link com.smartgwt.client.widgets.notify.NotifySettings#getStyleName styling} to messages via CSS.  Or
     * you can use HTML as the message contents to create whatever sort of interior layout you like.</td> </tr> <tr>
     * <td>wrap</td> <td>Autowrap behavior is managed by the Notify system.</td> <td>To have {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitWidth autofitted} content not wrap, set {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitMaxWidth autoFitMaxWidth} higher than your expected message
     * widths.  You can set it to "100%" if needed to allow the message to expand across the entire page.</td> </tr> </table>
     *
     * @param labelProperties New labelProperties value. Default value is null
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.docs.SGWTProperties
     */
    public NotifySettings setLabelProperties(Label labelProperties) {
        if (labelProperties != null) {
            if (labelProperties.isCreated()) {
                ConfigUtil.warnOfPreConfigInstantiation(NotifySettings.class, "setLabelProperties", "Label");
            }                                                                       
            labelProperties.setConfigOnly(true);
        }
        JavaScriptObject config = labelProperties == null ? null : labelProperties.getConfig();
        return (NotifySettings)setAttribute("labelProperties", JSOHelper.cleanProperties(config, true));
    }

    /**
     * Configures the properties, such as {@link com.smartgwt.client.widgets.Label#getAutoFit Label.autoFit}, {@link
     * com.smartgwt.client.widgets.Label#getAlign Label.align}, and {@link com.smartgwt.client.widgets.Label#getWidth
     * Label.width}. of the {@link com.smartgwt.client.widgets.Label} autochildren that will be used to draw messages, where
     * not already determined by message layout or other <code>NotifySettings</code> properties such as {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getStyleName styleName}. <P> Not all label properties are guaranteed
     * to work here, as the Notify system is assumed to layout message content and manage positioning messages.  In particular,
     * the following properties should be avoided: <table border=1 class="normal"> <tr bgcolor="#D0D0D0"><td>Property
     * Name</td><td>Issue</td><td>Guidance</td></tr> <tr> <td>margin</td> <td>Layout and positioning of the messages is handled
     * by the Notify system.</td> <td>Use {@link com.smartgwt.client.widgets.notify.NotifySettings#getStackSpacing
     * stackSpacing} to configure the separation between messages, and {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getLeftOffset leftOffset} and {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getTopOffset topOffset} to fine-tine stack {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPosition positioning}. </td> </tr> <tr> <td>padding</td>
     * <td>Padding is set by notification CSS so that children are positioned corrected relative to content.</td> <td>You can
     * apply your own {@link com.smartgwt.client.widgets.notify.NotifySettings#getStyleName styling} to messages via CSS.  Or
     * you can use HTML as the message contents to create whatever sort of interior layout you like.</td> </tr> <tr>
     * <td>wrap</td> <td>Autowrap behavior is managed by the Notify system.</td> <td>To have {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitWidth autofitted} content not wrap, set {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getAutoFitMaxWidth autoFitMaxWidth} higher than your expected message
     * widths.  You can set it to "100%" if needed to allow the message to expand across the entire page.</td> </tr> </table>
     *
     * @return Current labelProperties value. Default value is null
     */
    public Label getLabelProperties()  {
        Label properties = new Label();
        properties.setConfigOnly(true);
        properties.setConfig(getAttributeAsJavaScriptObject("labelProperties"));
        return properties;
    }
    

    /**
     * Specifies a left offset from the position specified by {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPosition position} or {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPositionCanvas positionCanvas} where the message should be shown. 
     * Ignored if {@link com.smartgwt.client.widgets.notify.NotifySettings#getX coordinates} are provided to position the
     * message.
     *
     * @param leftOffset New leftOffset value. Default value is null
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setPosition
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setTopOffset
     */
    public NotifySettings setLeftOffset(Integer leftOffset) {
        return (NotifySettings)setAttribute("leftOffset", leftOffset);
    }

    /**
     * Specifies a left offset from the position specified by {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPosition position} or {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPositionCanvas positionCanvas} where the message should be shown. 
     * Ignored if {@link com.smartgwt.client.widgets.notify.NotifySettings#getX coordinates} are provided to position the
     * message.
     *
     * @return Current leftOffset value. Default value is null
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getPosition
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getTopOffset
     */
    public Integer getLeftOffset()  {
        return getAttributeAsInt("leftOffset");
    }
    

    /**
     * Specifies how to pick which message to dismiss when the {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMaxStackSize maxStackSize} is reached, and the lowest priority
     * value (highest numerical  {@link com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority})
     * is shared by more than one message.  <P> We can simply dismiss the oldest message of that  {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority}, or we can pick the message with
     * the least time left until it's auto-dismissed.
     *
     * @param maxStackDismissMode New maxStackDismissMode value. Default value is "oldest"
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setDuration
     * @see com.smartgwt.client.widgets.notify.Notify#dismissMessage
     */
    public NotifySettings setMaxStackDismissMode(MaxStackDismissMode maxStackDismissMode) {
        return (NotifySettings)setAttribute("maxStackDismissMode", maxStackDismissMode == null ? null : maxStackDismissMode.getValue());
    }

    /**
     * Specifies how to pick which message to dismiss when the {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMaxStackSize maxStackSize} is reached, and the lowest priority
     * value (highest numerical  {@link com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority})
     * is shared by more than one message.  <P> We can simply dismiss the oldest message of that  {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority}, or we can pick the message with
     * the least time left until it's auto-dismissed.
     *
     * @return Current maxStackDismissMode value. Default value is "oldest"
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getDuration
     * @see com.smartgwt.client.widgets.notify.Notify#dismissMessage
     */
    public MaxStackDismissMode getMaxStackDismissMode()  {
        return EnumUtil.getEnum(MaxStackDismissMode.values(), getAttribute("maxStackDismissMode"));
    }
    

    /**
     * Sets a limit on how many messages may be stacked if {@link com.smartgwt.client.types.MultiMessageMode} is "stack".  The
     * oldest message of the affected {@link com.smartgwt.client.docs.NotifyType} will be dismissed to enforce this limit.
     *
     * @param maxStackSize New maxStackSize value. Default value is 3
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setMaxStackSize(int maxStackSize) {
        return (NotifySettings)setAttribute("maxStackSize", maxStackSize);
    }

    /**
     * Sets a limit on how many messages may be stacked if {@link com.smartgwt.client.types.MultiMessageMode} is "stack".  The
     * oldest message of the affected {@link com.smartgwt.client.docs.NotifyType} will be dismissed to enforce this limit.
     *
     * @return Current maxStackSize value. Default value is 3
     */
    public int getMaxStackSize()  {
        return getAttributeAsInt("maxStackSize");
    }
    

    /**
     * Optional specified padding to apply after the message content when showing a {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getCanDismiss dismiss button} so that the button doesn't occlude any
     * content. Only needed if the message {@link com.smartgwt.client.widgets.notify.NotifySettings#getStyleName styling}
     * doesn't already provide enough padding.
     *
     * @param messageControlPadding New messageControlPadding value. Default value is null
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setMessageControlPadding(Integer messageControlPadding) {
        return (NotifySettings)setAttribute("messageControlPadding", messageControlPadding);
    }

    /**
     * Optional specified padding to apply after the message content when showing a {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getCanDismiss dismiss button} so that the button doesn't occlude any
     * content. Only needed if the message {@link com.smartgwt.client.widgets.notify.NotifySettings#getStyleName styling}
     * doesn't already provide enough padding.
     *
     * @return Current messageControlPadding value. Default value is null
     */
    public Integer getMessageControlPadding()  {
        return getAttributeAsInt("messageControlPadding");
    }
    

    /**
     * Optional icon to be shown in the {@link com.smartgwt.client.widgets.Label} drawn for this message.  Default is <ul>
     * <li>"[SKIN]/Notify/error.png" for {@link com.smartgwt.client.docs.NotifyType}: "error", <li>"[SKIN]/Notify/warning.png"
     * for {@link com.smartgwt.client.docs.NotifyType}: "warn", and <li>"[SKIN]/Notify/checkmark.png" for all other {@link
     * com.smartgwt.client.docs.NotifyType}s. </ul> However, if you specify a {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority},  it will determine the default
     * rather than the actual <code>NotifyType</code>, if {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getApplyPriorityToAppearance applyPriorityToAppearance} is true.
     *
     * @param messageIcon New messageIcon value. Default value is varies
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setMessagePriority
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public NotifySettings setMessageIcon(String messageIcon) {
        return (NotifySettings)setAttribute("messageIcon", messageIcon);
    }

    /**
     * Optional icon to be shown in the {@link com.smartgwt.client.widgets.Label} drawn for this message.  Default is <ul>
     * <li>"[SKIN]/Notify/error.png" for {@link com.smartgwt.client.docs.NotifyType}: "error", <li>"[SKIN]/Notify/warning.png"
     * for {@link com.smartgwt.client.docs.NotifyType}: "warn", and <li>"[SKIN]/Notify/checkmark.png" for all other {@link
     * com.smartgwt.client.docs.NotifyType}s. </ul> However, if you specify a {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority},  it will determine the default
     * rather than the actual <code>NotifyType</code>, if {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getApplyPriorityToAppearance applyPriorityToAppearance} is true.
     *
     * @return Current messageIcon value. Default value is varies
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority
     * @see com.smartgwt.client.docs.SCImgURL SCImgURL 
     */
    public String getMessageIcon()  {
        return getAttributeAsString("messageIcon");
    }
    

    /**
     * Height in pixels of the icon image.
     *
     * @param messageIconHeight New messageIconHeight value. Default value is 17
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Label#setIconHeight
     */
    public NotifySettings setMessageIconHeight(int messageIconHeight) {
        return (NotifySettings)setAttribute("messageIconHeight", messageIconHeight);
    }

    /**
     * Height in pixels of the icon image.
     *
     * @return Current messageIconHeight value. Default value is 17
     * @see com.smartgwt.client.widgets.Label#getIconHeight
     */
    public int getMessageIconHeight()  {
        return getAttributeAsInt("messageIconHeight");
    }
    

    /**
     * If an icon is present, should it appear to the left or right of the title? valid options are <code>"left"</code> and
     * <code>"right"</code>.  If unset, default is "left" unless {@link com.smartgwt.client.util.Page#isRTL RTL} is active, in
     * which case it's "right". <P> Note that the icon will automatically be given an alignment matching its orientation, so
     * "left" for <code>messageIconOrientation</code> "left", and vice versa.
     *
     * @param messageIconOrientation New messageIconOrientation value. Default value is varies
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Label#setIconAlign
     * @see com.smartgwt.client.widgets.Label#setIconOrientation
     */
    public NotifySettings setMessageIconOrientation(String messageIconOrientation) {
        return (NotifySettings)setAttribute("messageIconOrientation", messageIconOrientation);
    }

    /**
     * If an icon is present, should it appear to the left or right of the title? valid options are <code>"left"</code> and
     * <code>"right"</code>.  If unset, default is "left" unless {@link com.smartgwt.client.util.Page#isRTL RTL} is active, in
     * which case it's "right". <P> Note that the icon will automatically be given an alignment matching its orientation, so
     * "left" for <code>messageIconOrientation</code> "left", and vice versa.
     *
     * @return Current messageIconOrientation value. Default value is varies
     * @see com.smartgwt.client.widgets.Label#getIconAlign
     * @see com.smartgwt.client.widgets.Label#getIconOrientation
     */
    public String getMessageIconOrientation()  {
        return getAttributeAsString("messageIconOrientation");
    }
    

    /**
     * Pixels between icon and title text.
     *
     * @param messageIconSpacing New messageIconSpacing value. Default value is 20
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Label#setIconSpacing
     */
    public NotifySettings setMessageIconSpacing(int messageIconSpacing) {
        return (NotifySettings)setAttribute("messageIconSpacing", messageIconSpacing);
    }

    /**
     * Pixels between icon and title text.
     *
     * @return Current messageIconSpacing value. Default value is 20
     * @see com.smartgwt.client.widgets.Label#getIconSpacing
     */
    public int getMessageIconSpacing()  {
        return getAttributeAsInt("messageIconSpacing");
    }
    

    /**
     * Width in pixels of the icon image.
     *
     * @param messageIconWidth New messageIconWidth value. Default value is 17
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.Label#setIconWidth
     */
    public NotifySettings setMessageIconWidth(int messageIconWidth) {
        return (NotifySettings)setAttribute("messageIconWidth", messageIconWidth);
    }

    /**
     * Width in pixels of the icon image.
     *
     * @return Current messageIconWidth value. Default value is 17
     * @see com.smartgwt.client.widgets.Label#getIconWidth
     */
    public int getMessageIconWidth()  {
        return getAttributeAsInt("messageIconWidth");
    }
    

    /**
     * Sets the priority of the message.  Priority is used to determine which message to dismiss if {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMaxStackSize maxStackSize} is hit.  Lower numerical values have
     * higher priority. <p>The default is: <ul> <li>{@link com.smartgwt.client.widgets.notify.Notify#ERROR ERROR} for {@link
     * com.smartgwt.client.docs.NotifyType}: "error", <li>{@link com.smartgwt.client.widgets.notify.Notify#WARN WARN} for
     * {@link com.smartgwt.client.docs.NotifyType}: "warn", and <li>{@link com.smartgwt.client.widgets.notify.Notify#MESSAGE
     * MESSAGE} for all other {@link com.smartgwt.client.docs.NotifyType}s </ul> <b>Impact on Appearance</b> <p> If you specify
     * <code>messagePriority</code>, and {@link com.smartgwt.client.widgets.notify.NotifySettings#getApplyPriorityToAppearance
     * applyPriorityToAppearance} is set, the properties: <ul> <li> {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMessageIcon messageIcon}, <li> {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getStyleName styleName}, and  <li> {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getActionStyleName actionStyleName} </ul> will be assigned, if not
     * specified, to the default values from:<ul> <li> {@link com.smartgwt.client.docs.NotifyType}: "error" for priority {@link
     * com.smartgwt.client.widgets.notify.Notify#ERROR ERROR}, <li> {@link com.smartgwt.client.docs.NotifyType}: "warn" for
     * priority {@link com.smartgwt.client.widgets.notify.Notify#WARN WARN}, or <li> {@link
     * com.smartgwt.client.docs.NotifyType}: "message" for priorities at or below                          {@link
     * com.smartgwt.client.widgets.notify.Notify#MESSAGE MESSAGE} (greater or equal numerically) </ul> This allows you to
     * automatically set "error" or "warn" styling, on a per-message basis, for any non-"error" or "warn"
     * <code>NotifyType</code> by simply supplying a <code>messagePriority</code> for that message.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param messagePriority New messagePriority value. Default value is varies
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.Notify#addMessage
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setMaxStackDismissMode
     */
    public NotifySettings setMessagePriority(int messagePriority) {
        return (NotifySettings)setAttribute("messagePriority", messagePriority);
    }

    /**
     * Sets the priority of the message.  Priority is used to determine which message to dismiss if {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMaxStackSize maxStackSize} is hit.  Lower numerical values have
     * higher priority. <p>The default is: <ul> <li>{@link com.smartgwt.client.widgets.notify.Notify#ERROR ERROR} for {@link
     * com.smartgwt.client.docs.NotifyType}: "error", <li>{@link com.smartgwt.client.widgets.notify.Notify#WARN WARN} for
     * {@link com.smartgwt.client.docs.NotifyType}: "warn", and <li>{@link com.smartgwt.client.widgets.notify.Notify#MESSAGE
     * MESSAGE} for all other {@link com.smartgwt.client.docs.NotifyType}s </ul> <b>Impact on Appearance</b> <p> If you specify
     * <code>messagePriority</code>, and {@link com.smartgwt.client.widgets.notify.NotifySettings#getApplyPriorityToAppearance
     * applyPriorityToAppearance} is set, the properties: <ul> <li> {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMessageIcon messageIcon}, <li> {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getStyleName styleName}, and  <li> {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getActionStyleName actionStyleName} </ul> will be assigned, if not
     * specified, to the default values from:<ul> <li> {@link com.smartgwt.client.docs.NotifyType}: "error" for priority {@link
     * com.smartgwt.client.widgets.notify.Notify#ERROR ERROR}, <li> {@link com.smartgwt.client.docs.NotifyType}: "warn" for
     * priority {@link com.smartgwt.client.widgets.notify.Notify#WARN WARN}, or <li> {@link
     * com.smartgwt.client.docs.NotifyType}: "message" for priorities at or below                          {@link
     * com.smartgwt.client.widgets.notify.Notify#MESSAGE MESSAGE} (greater or equal numerically) </ul> This allows you to
     * automatically set "error" or "warn" styling, on a per-message basis, for any non-"error" or "warn"
     * <code>NotifyType</code> by simply supplying a <code>messagePriority</code> for that message.
     *
     * @return Current messagePriority value. Default value is varies
     * @see com.smartgwt.client.widgets.notify.Notify#addMessage
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getMaxStackDismissMode
     */
    public int getMessagePriority()  {
        return getAttributeAsInt("messagePriority");
    }
    

    /**
     * Determines what happens if a message appears while there's still another one of the same {@link
     * com.smartgwt.client.docs.NotifyType} being shown.  Such messages are either stacked or replace one another,
     *
     * @param multiMessageMode New multiMessageMode value. Default value is "stack"
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setMultiMessageMode(MultiMessageMode multiMessageMode) {
        return (NotifySettings)setAttribute("multiMessageMode", multiMessageMode == null ? null : multiMessageMode.getValue());
    }

    /**
     * Determines what happens if a message appears while there's still another one of the same {@link
     * com.smartgwt.client.docs.NotifyType} being shown.  Such messages are either stacked or replace one another,
     *
     * @return Current multiMessageMode value. Default value is "stack"
     */
    public MultiMessageMode getMultiMessageMode()  {
        return EnumUtil.getEnum(MultiMessageMode.values(), getAttribute("multiMessageMode"));
    }
    

    /**
     * Where to show the message, specified as an edge ("T", "B", "R", "L"), a corner ("TL", "TR", "BL", "BR), or "C" for
     * center,  similar to {@link com.smartgwt.client.widgets.Canvas#getSnapTo Canvas.snapTo}. If an edge is specified, the
     * message will be shown at its center (or the very center for "C").  Only used if {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getX coordinates} haven't been provided. <P> If a {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPositionCanvas positionCanvas} has been specified, the
     * <code>position</code> is interpreted relative to it instead of the viewport, and this property defaults to "C". 
     * Otherwise, if no <code>positionCanvas</code> is present, the default is to use {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getSlideInOrigin slideInOrigin} or {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getSlideOutOrigin slideOutOrigin}, or "L" if neither property is
     * defined. <P> To place the message at an offset from the specified position, use {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getLeftOffset leftOffset} or {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getTopOffset topOffset}.
     *
     * @param position New position value. Default value is varies
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setX
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setY
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setPositionCanvas
     */
    public NotifySettings setPosition(EdgeName position) {
        return (NotifySettings)setAttribute("position", position == null ? null : position.getValue());
    }

    /**
     * Where to show the message, specified as an edge ("T", "B", "R", "L"), a corner ("TL", "TR", "BL", "BR), or "C" for
     * center,  similar to {@link com.smartgwt.client.widgets.Canvas#getSnapTo Canvas.snapTo}. If an edge is specified, the
     * message will be shown at its center (or the very center for "C").  Only used if {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getX coordinates} haven't been provided. <P> If a {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPositionCanvas positionCanvas} has been specified, the
     * <code>position</code> is interpreted relative to it instead of the viewport, and this property defaults to "C". 
     * Otherwise, if no <code>positionCanvas</code> is present, the default is to use {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getSlideInOrigin slideInOrigin} or {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getSlideOutOrigin slideOutOrigin}, or "L" if neither property is
     * defined. <P> To place the message at an offset from the specified position, use {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getLeftOffset leftOffset} or {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getTopOffset topOffset}.
     *
     * @return Current position value. Default value is varies
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getX
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getY
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getPositionCanvas
     */
    public EdgeName getPosition()  {
        return EnumUtil.getEnum(EdgeName.values(), getAttribute("position"));
    }
    

    /**
     * Canvas over which to position the message, available as an alternative means of placement if viewport-relative {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getX coordinates} aren't provided.  Note that the canvas is only used
     * to compute where to the place message, and will not be altered.
     *
     * @param positionCanvas New positionCanvas value. Default value is null
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setLeftOffset
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setTopOffset
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setPosition
     */
    public NotifySettings setPositionCanvas(Canvas positionCanvas) {
        return (NotifySettings)setAttribute("positionCanvas", positionCanvas == null ? null : positionCanvas.getOrCreateJsObj());
    }

    /**
     * Canvas over which to position the message, available as an alternative means of placement if viewport-relative {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getX coordinates} aren't provided.  Note that the canvas is only used
     * to compute where to the place message, and will not be altered.
     *
     * @return Current positionCanvas value. Default value is null
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getLeftOffset
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getTopOffset
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getPosition
     */
    public Canvas getPositionCanvas()  {
        return (Canvas)Canvas.getByJSObject(getAttributeAsJavaScriptObject("positionCanvas"));
    }
    

    /**
     * Controls how the stack or message is repositioned, if required, after {@link
     * com.smartgwt.client.widgets.notify.Notify#setMessageContents Notify.setMessageContents()} has been called.  Valid values
     * are "slide" and "instant".
     *
     * @param repositionMethod New repositionMethod value. Default value is "slide"
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setRepositionMethod(NotifyTransition repositionMethod) {
        return (NotifySettings)setAttribute("repositionMethod", repositionMethod == null ? null : repositionMethod.getValue());
    }

    /**
     * Controls how the stack or message is repositioned, if required, after {@link
     * com.smartgwt.client.widgets.notify.Notify#setMessageContents Notify.setMessageContents()} has been called.  Valid values
     * are "slide" and "instant".
     *
     * @return Current repositionMethod value. Default value is "slide"
     */
    public NotifyTransition getRepositionMethod()  {
        return EnumUtil.getEnum(NotifyTransition.values(), getAttribute("repositionMethod"));
    }
    

    /**
     * Determines where messages originate when they appear for {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getAppearMethod appearMethod}: "slide".  Possible values are "L", "R",
     * "T", and "B". <P>  If not specified, the edge nearest the message's requested coordinates or position is used.
     *
     * @param slideInOrigin New slideInOrigin value. Default value is null
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setSlideInOrigin(String slideInOrigin) {
        return (NotifySettings)setAttribute("slideInOrigin", slideInOrigin);
    }

    /**
     * Determines where messages originate when they appear for {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getAppearMethod appearMethod}: "slide".  Possible values are "L", "R",
     * "T", and "B". <P>  If not specified, the edge nearest the message's requested coordinates or position is used.
     *
     * @return Current slideInOrigin value. Default value is null
     */
    public String getSlideInOrigin()  {
        return getAttributeAsString("slideInOrigin");
    }
    

    /**
     * Determines where messages go when they disappear for {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getDisappearMethod disappearMethod}: "slide".  Possible values are
     * "L", "R", "T", and "B".  <P> If not specified, the edge nearest the message's requested coordinates or position is used.
     *
     * @param slideOutOrigin New slideOutOrigin value. Default value is null
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setSlideOutOrigin(String slideOutOrigin) {
        return (NotifySettings)setAttribute("slideOutOrigin", slideOutOrigin);
    }

    /**
     * Determines where messages go when they disappear for {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getDisappearMethod disappearMethod}: "slide".  Possible values are
     * "L", "R", "T", and "B".  <P> If not specified, the edge nearest the message's requested coordinates or position is used.
     *
     * @return Current slideOutOrigin value. Default value is null
     */
    public String getSlideOutOrigin()  {
        return getAttributeAsString("slideOutOrigin");
    }
    

    /**
     * Animation speed for {@link com.smartgwt.client.types.NotifyTransition}: "slide", in pixels/second.
     *
     * @param slideSpeed New slideSpeed value. Default value is 300
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setSlideSpeed(int slideSpeed) {
        return (NotifySettings)setAttribute("slideSpeed", slideSpeed);
    }

    /**
     * Animation speed for {@link com.smartgwt.client.types.NotifyTransition}: "slide", in pixels/second.
     *
     * @return Current slideSpeed value. Default value is 300
     */
    public int getSlideSpeed()  {
        return getAttributeAsInt("slideSpeed");
    }
    

    /**
     * Determines how messages are stacked if {@link com.smartgwt.client.types.MultiMessageMode} is "stack".  For example,
     * "down" means that older messages move down when a new message of the same {@link com.smartgwt.client.docs.NotifyType}
     * appears.
     *
     * @param stackDirection New stackDirection value. Default value is "down"
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setStackDirection(StackDirection stackDirection) {
        return (NotifySettings)setAttribute("stackDirection", stackDirection == null ? null : stackDirection.getValue());
    }

    /**
     * Determines how messages are stacked if {@link com.smartgwt.client.types.MultiMessageMode} is "stack".  For example,
     * "down" means that older messages move down when a new message of the same {@link com.smartgwt.client.docs.NotifyType}
     * appears.
     *
     * @return Current stackDirection value. Default value is "down"
     */
    public StackDirection getStackDirection()  {
        return EnumUtil.getEnum(StackDirection.values(), getAttribute("stackDirection"));
    }
    

    /**
     * Controls how older messages' {@link com.smartgwt.client.widgets.notify.NotifySettings#getDuration duration} countdowns
     * are affected when a new message of the same {@link com.smartgwt.client.docs.NotifyType} appears.  We either continue the
     * countdowns on the older messages as if they are unrelated, or we reset any countdowns that are less than the new
     * message's <code>duration</code>. <P> Note that you can set this property in a call to {@link
     * com.smartgwt.client.widgets.notify.Notify#addMessage Notify.addMessage()} even though it has "stack" in its name, since
     * it governs the logic run on behalf of this message.
     * <p><b>Note : </b> This is an advanced setting</p>
     *
     * @param stackPersistence New stackPersistence value. Default value is "none"
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setStackPersistence(StackPersistence stackPersistence) {
        return (NotifySettings)setAttribute("stackPersistence", stackPersistence == null ? null : stackPersistence.getValue());
    }

    /**
     * Controls how older messages' {@link com.smartgwt.client.widgets.notify.NotifySettings#getDuration duration} countdowns
     * are affected when a new message of the same {@link com.smartgwt.client.docs.NotifyType} appears.  We either continue the
     * countdowns on the older messages as if they are unrelated, or we reset any countdowns that are less than the new
     * message's <code>duration</code>. <P> Note that you can set this property in a call to {@link
     * com.smartgwt.client.widgets.notify.Notify#addMessage Notify.addMessage()} even though it has "stack" in its name, since
     * it governs the logic run on behalf of this message.
     *
     * @return Current stackPersistence value. Default value is "none"
     */
    public StackPersistence getStackPersistence()  {
        return EnumUtil.getEnum(StackPersistence.values(), getAttribute("stackPersistence"));
    }
    

    /**
     * Space between each message when {@link com.smartgwt.client.types.MultiMessageMode} is "stack".
     *
     * @param stackSpacing New stackSpacing value. Default value is 2
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setStackSpacing(int stackSpacing) {
        return (NotifySettings)setAttribute("stackSpacing", stackSpacing);
    }

    /**
     * Space between each message when {@link com.smartgwt.client.types.MultiMessageMode} is "stack".
     *
     * @return Current stackSpacing value. Default value is 2
     */
    public int getStackSpacing()  {
        return getAttributeAsInt("stackSpacing");
    }
    

    /**
     * If true, pauses the auto-dismiss countdown timer when the mouse is over the messasge.
     *
     * @param stayIfHovered New stayIfHovered value. Default value is false
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     */
    public NotifySettings setStayIfHovered(boolean stayIfHovered) {
        return (NotifySettings)setAttribute("stayIfHovered", stayIfHovered);
    }

    /**
     * If true, pauses the auto-dismiss countdown timer when the mouse is over the messasge.
     *
     * @return Current stayIfHovered value. Default value is false
     */
    public boolean getStayIfHovered()  {
        Boolean result = getAttributeAsBoolean("stayIfHovered", true);
        return result == null ? false : result;
    }
    

    /**
     * The CSS class to apply to the {@link com.smartgwt.client.widgets.Label} drawn for this message.  Default is: <ul>
     * <li>"notifyError" for {@link com.smartgwt.client.docs.NotifyType}: "error", <li>"notifyWarn" for {@link
     * com.smartgwt.client.docs.NotifyType}: "warn", and <li>"notifyMessage" for all other {@link
     * com.smartgwt.client.docs.NotifyType}s. </ul> However, if you specify a {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority}, it will determine the default
     * rather than the actual <code>NotifyType</code>, if {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getApplyPriorityToAppearance applyPriorityToAppearance} is true. <P>
     * Note that if {@link com.smartgwt.client.util.Page#isRTL RTL} is active, the default will be as above, but with an "RTL"
     * suffix added.
     *
     * @param styleName New styleName value. Default value is varies
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setMessagePriority
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public NotifySettings setStyleName(String styleName) {
        return (NotifySettings)setAttribute("styleName", styleName);
    }

    /**
     * The CSS class to apply to the {@link com.smartgwt.client.widgets.Label} drawn for this message.  Default is: <ul>
     * <li>"notifyError" for {@link com.smartgwt.client.docs.NotifyType}: "error", <li>"notifyWarn" for {@link
     * com.smartgwt.client.docs.NotifyType}: "warn", and <li>"notifyMessage" for all other {@link
     * com.smartgwt.client.docs.NotifyType}s. </ul> However, if you specify a {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority messagePriority}, it will determine the default
     * rather than the actual <code>NotifyType</code>, if {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getApplyPriorityToAppearance applyPriorityToAppearance} is true. <P>
     * Note that if {@link com.smartgwt.client.util.Page#isRTL RTL} is active, the default will be as above, but with an "RTL"
     * suffix added.
     *
     * @return Current styleName value. Default value is varies
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getMessagePriority
     * @see com.smartgwt.client.docs.CSSStyleName CSSStyleName 
     */
    public String getStyleName()  {
        return getAttributeAsString("styleName");
    }
    

    /**
     * Specifies a top offset from the position specified by {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPosition position} or {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPositionCanvas positionCanvas} where the message should be shown. 
     * Ignored if {@link com.smartgwt.client.widgets.notify.NotifySettings#getY coordinates} are provided to position the
     * message.
     *
     * @param topOffset New topOffset value. Default value is null
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setPosition
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setLeftOffset
     */
    public NotifySettings setTopOffset(Integer topOffset) {
        return (NotifySettings)setAttribute("topOffset", topOffset);
    }

    /**
     * Specifies a top offset from the position specified by {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPosition position} or {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPositionCanvas positionCanvas} where the message should be shown. 
     * Ignored if {@link com.smartgwt.client.widgets.notify.NotifySettings#getY coordinates} are provided to position the
     * message.
     *
     * @return Current topOffset value. Default value is null
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getPosition
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getLeftOffset
     */
    public Integer getTopOffset()  {
        return getAttributeAsInt("topOffset");
    }
    

    /**
     * Where to show the message, as a viewport-relative x coordinate offset to the left edge of the {@link
     * com.smartgwt.client.widgets.Label} rendering the message.  Properties {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPosition position} and {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPositionCanvas positionCanvas} will only be used to place messages
     * if coordinates aren't provided.
     *
     * @param x New x value. Default value is null
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setY
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setPosition
     */
    public NotifySettings setX(Integer x) {
        return (NotifySettings)setAttribute("x", x);
    }

    /**
     * Where to show the message, as a viewport-relative x coordinate offset to the left edge of the {@link
     * com.smartgwt.client.widgets.Label} rendering the message.  Properties {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPosition position} and {@link
     * com.smartgwt.client.widgets.notify.NotifySettings#getPositionCanvas positionCanvas} will only be used to place messages
     * if coordinates aren't provided.
     *
     * @return Current x value. Default value is null
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getY
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getPosition
     */
    public Integer getX()  {
        return getAttributeAsInt("x");
    }
    

    /**
     * Where to show the message, as a viewport-relative y coordinate offset to the top edge of the {@link
     * com.smartgwt.client.widgets.Label} rendering the message.
     *
     * @param y New y value. Default value is null
     * @return {@link com.smartgwt.client.widgets.notify.NotifySettings NotifySettings} instance, for chaining setter calls
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setX
     * @see com.smartgwt.client.widgets.notify.NotifySettings#setPosition
     */
    public NotifySettings setY(Integer y) {
        return (NotifySettings)setAttribute("y", y);
    }

    /**
     * Where to show the message, as a viewport-relative y coordinate offset to the top edge of the {@link
     * com.smartgwt.client.widgets.Label} rendering the message.
     *
     * @return Current y value. Default value is null
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getX
     * @see com.smartgwt.client.widgets.notify.NotifySettings#getPosition
     */
    public Integer getY()  {
        return getAttributeAsInt("y");
    }
    

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

    // ***********************************************************

}
