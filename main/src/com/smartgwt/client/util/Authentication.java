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
 * The Authentication or Auth class represents a convenient, standard place to keep  information about the currently logged
 * in user and their assigned user roles. <p> The intended usage is that a server authentication system would require the
 * user to log in,  then provide data about the currently logged in user via {@link
 * com.smartgwt.client.util.Authentication#setCurrentUser Auth.setCurrentUser()}  and {@link
 * com.smartgwt.client.util.Authentication#setRoles setRoles()}.  This data is then available in the  {@link
 * com.smartgwt.client.widgets.Canvas#getRuleScope Rule Scope} so that components can use it to enable or disable or hide
 * themselves, via properties such as {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyWhen
 * FormItem.readOnlyWhen}. <p> The format for user records is not explicitly defined or restricted by the Authentication 
 * subsystem but we recommend using the format described by {@link com.smartgwt.client.util.Authentication#getUserSchema
 * getUserSchema()}.<br> Having a standardized user record allows application designers to rely on a  well-known set of
 * field names at design time, and then at deployment time when a  particular authentication system is chosen, the deployer
 * can simply fill in the  standardized user record from the data that the chosen authentication system returns.   This
 * also allows authentication systems to be swapped out in the future without  the need to change application code. <p> The
 * DataSource returned by {@link com.smartgwt.client.util.Authentication#getUserSchema getUserSchema()} is used solely for
 * visual  tools to help with application authoring.<br> It is not intended to be used directly to store and retrieve user
 * data, and while we recommend this format it is not a requirement that user records conform to it. <p> There are no
 * security implications to calling <code>setRoles()</code> or other APIs on the <code>Authentication</code> class. The
 * provided data affects only  client-side components.  All actual security enforcement must be done server-side -  see the
 * QuickStart Guide, especially the sections on Declarative Security,  to understand how role-based authorization can be
 * used on the server.
 */
@BeanFactory.FrameworkClass
public class Authentication {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Returns the full set of available user roles specified by {@link
     * com.smartgwt.client.util.Authentication#setAvailableRoles setAvailableRoles()}.
     *
     * @return full set of possible user roles.
     */
    public static native String[] getAvailableRoles() /*-{
        var ret = $wnd.isc.Authentication.getAvailableRoles();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfString(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Returns the current user specified by {@link com.smartgwt.client.util.Authentication#setCurrentUser setCurrentUser()}. 
     * <P> This method returns the user record currently available in the  {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope Canvas.ruleScope} as "auth.currentUser".
     *
     * @return Record with attributes detailing the current user
     */
    public static native Record getCurrentUser() /*-{
        var ret = $wnd.isc.Authentication.getCurrentUser();
        if(ret == null) return null;
        return @com.smartgwt.client.data.Record::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Convenience method to return the <code>"userId"</code> attribute of the {@link
     * com.smartgwt.client.util.Authentication#getCurrentUser current user} if there is one.
     *
     * @return userId attribute of the      {@link com.smartgwt.client.util.Authentication#getCurrentUser current user record} if there
     * is one.
     */
    public static native String getCurrentUserId() /*-{
        var ret = $wnd.isc.Authentication.getCurrentUserId();
        return ret;
    }-*/;


	/**
     * Returns the current set of user roles. For {@link com.smartgwt.client.util.Authentication#setSuperUser super users} this
     * will be the intersection of any roles specified by  {@link com.smartgwt.client.util.Authentication#setRoles setRoles()}
     * and the full set of {@link com.smartgwt.client.util.Authentication#setAvailableRoles available roles}  - otherwise it
     * will be the set of roles specified by {@link com.smartgwt.client.util.Authentication#setRoles setRoles()}. <P> Current
     * set of user roles are available in the {@link com.smartgwt.client.widgets.Canvas#getRuleScope Canvas.ruleScope}  as a
     * top-level property "userRoles", so that it can be used in criteria such as  {@link
     * com.smartgwt.client.widgets.Canvas#getVisibleWhen Canvas.visibleWhen} or {@link
     * com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyWhen FormItem.readOnlyWhen}.
     *
     * @return set of roles which apply to the current user
     */
    public static native String[] getRoles() /*-{
        var ret = $wnd.isc.Authentication.getRoles();
        if(ret == null) return null;
        return @com.smartgwt.client.util.ConvertTo::arrayOfString(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Returns a DataSource describing the standard schema for user data. <P> The schema contains the following fields: <table
     * border=1> <tr><td><b>Field Name</b></td><td><b>Type</b></td></tr> <tr><td>"userId"</td><td>"text"</td></tr>
     * <tr><td>"email"</td><td>"text"</td></tr> <tr><td>"firstName"</td><td>"text"</td></tr>
     * <tr><td>"lastName"</td><td>"text"</td></tr> <tr><td>"title"</td><td>"text"</td></tr>
     * <tr><td>"phone"</td><td>"phoneNumber"</td></tr> <tr><td>"superUser"</td><td>"boolean"</td></tr> </table>
     *
     * @return user schema dataSource
     */
    public static native DataSource getUserSchema() /*-{
        var ret = $wnd.isc.Authentication.getUserSchema();
        if(ret == null) return null;
        return @com.smartgwt.client.data.DataSource::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(ret);
    }-*/;


	/**
     * Is the current user assigned to the specified role?
     * @param role role to check in current roles
     *
     * @return true if the user has the role in its {@link com.smartgwt.client.util.Authentication#getRoles getRoles()} list; false
     * otherwise
     * @see com.smartgwt.client.util.Authentication#getRoles
     */
    public static native Boolean hasRole(String role) /*-{
        var ret = $wnd.isc.Authentication.hasRole(role);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toBoolean(Z)(ret);
    }-*/;


	/**
     * Has the current user been marked as a super-user via {@link com.smartgwt.client.util.Authentication#setSuperUser
     * setSuperUser()}?
     * @param isSuperUser New super user status
     */
    public static native void isSuperUser(Boolean isSuperUser) /*-{
        $wnd.isc.Authentication.isSuperUser(isSuperUser == null ? null : isSuperUser.@java.lang.Boolean::booleanValue()());
    }-*/;


	/**
     * Specify the full set of available user roles. <P> Note that if the current user has been marked as a  {@link
     * com.smartgwt.client.util.Authentication#isSuperUser superUser}, {@link com.smartgwt.client.util.Authentication#getRoles
     * getRoles()} will return the full set of available roles.
     * @param roles full set of possible user roles.
     */
    public static native void setAvailableRoles(String[] roles) /*-{
        $wnd.isc.Authentication.setAvailableRoles(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(roles));
    }-*/;


	/**
     * Set up the current user. This method makes the user record available in the  {@link
     * com.smartgwt.client.widgets.Canvas#getRuleScope Canvas.ruleScope} as "auth.currentUser".
     * @param user Record with attributes detailing the current user
     */
    public static native void setCurrentUser(Record user) /*-{
        $wnd.isc.Authentication.setCurrentUser(user.@com.smartgwt.client.core.DataClass::getJsObj()());
    }-*/;


	/**
     * Set the user roles for the current user. Roles may be retrieved via {@link
     * com.smartgwt.client.util.Authentication#getRoles getRoles()}. <P> Calling setRoles() makes the specified set of user
     * roles available in the {@link com.smartgwt.client.widgets.Canvas#getRuleScope Canvas.ruleScope}  as a top-level property
     * "userRoles", so that it can be used in criteria such as  {@link com.smartgwt.client.widgets.Canvas#getVisibleWhen
     * Canvas.visibleWhen} or {@link com.smartgwt.client.widgets.form.fields.FormItem#getReadOnlyWhen FormItem.readOnlyWhen}. 
     * <P> Note that if this current user has been {@link com.smartgwt.client.util.Authentication#setSuperUser marked as a
     * super-user}, {@link com.smartgwt.client.util.Authentication#getRoles getRoles()} will return the full set of available
     * roles rather than the set of roles specified here.
     * @param roles set of roles which apply to the current user
     */
    public static native void setRoles(String[] roles) /*-{
        $wnd.isc.Authentication.setRoles(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(roles));
    }-*/;


	/**
     * Mark the current user as a super-user. This causes {@link com.smartgwt.client.util.Authentication#getRoles getRoles()}
     * to return the full set of {@link com.smartgwt.client.util.Authentication#getAvailableRoles available roles} if specified
     * @param isSuperUser New super user status
     */
    public static native void setSuperUser(Boolean isSuperUser) /*-{
        $wnd.isc.Authentication.setSuperUser(isSuperUser == null ? null : isSuperUser.@java.lang.Boolean::booleanValue()());
    }-*/;


    // ***********************************************************

}
