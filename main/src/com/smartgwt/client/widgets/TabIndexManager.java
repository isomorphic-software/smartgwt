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
 * Singleton class with static APIs for managing automatically assigned tab order for Smart GWT components and other
 * focusable elements. <P> The TabIndexManager separates the logic required to maintain a sensible tab-order for a page's
 * components from the logic to handle allocation of actual tab index values. It is common to have non-focusable components
 * with an implied position in the page's tab order - for example Layouts containing focusable buttons, or DynamicForms
 * containing focusable items, and this class handles maintaining relative tab order within such groups, and supplying
 * explicit TabIndex values for the items which actually need them. <P> Entries are registered with the TabIndexManager via
 * the {@link com.smartgwt.client.widgets.TabIndexManager#addTarget addTarget()}  API. A  numeric tab index for each entry
 * will be lazily generated when requested via  {@link com.smartgwt.client.widgets.TabIndexManager#getTabIndex
 * getTabIndex()}. The class provides APIs to modify the position of entries  in the tab tree. When a target is registered,
 * a couple of custom callback functions can be provided. The first is a notification method for the tab index being
 * updated (due to, for example, a parent being repositioned and all its children having new tab indices assigned), and can
 * be used to take an appropriate action such as updating the tab index of an element in the DOM. The second callback will
 * be fired when a call to the special {@link com.smartgwt.client.widgets.TabIndexManager#focusInTarget focusInTarget()} or
 * {@link com.smartgwt.client.widgets.TabIndexManager#shiftFocus shiftFocus()} API requests focus be passed to an entry.
 * This allows a developer to take an appropriate action (such as programmatically focussing in some DOM element). <P> For
 * standard Smart GWT components (focusable {@link com.smartgwt.client.widgets.Canvas canvases}  and {@link
 * com.smartgwt.client.widgets.form.fields.FormItem formItems}), developers will typically use APIs directly on the widget
 * to customize tab sequence behavior rather than interacting with the TabIndexManager class. See the {@link
 * com.smartgwt.client.docs.TabOrderOverview tab order overview} topic for more  information on tab order management for
 * components in Smart GWT.<br> Developers wishing to embed focusable components into a page which are not Smart GWT
 * components (native HTML elements and third party widgets), may use TabIndexManager APIs to do so. This process is
 * described in  {@link com.smartgwt.client.docs.CustomTabElements}.
 */
@BeanFactory.FrameworkClass
public class TabIndexManager {


    // ********************* Properties / Attributes ***********************

    // ********************* Methods ***********************

    // ********************* Static Methods ***********************

	/**
     * Register a target to have its tab order position managed by the TabIndexManager.
     * @param ID Unique ID to associate with a tab position. For a Canvas this    would typically be the {@link
     * com.smartgwt.client.widgets.Canvas#getID Canvas.ID} but any unique string is valid.
     * @param canFocus Is this target directly focusable? Governs whether an     explicit tabIndex will be created for this target. This
     * parameter should be    passed as <code>false</code> for targets which do not require an explicit tabIndex    as they are
     * not focusable, or not explicit tab-stops for the user tabbing through the     page. They will still have an implicit tab
     * order position which     governs where descendants appear, and would be used to generate a tabIndex if    canFocus is
     * subsequently updated via {@link com.smartgwt.client.widgets.TabIndexManager#setCanFocus setCanFocus()}.
     */
    public static native void addTarget(String ID, boolean canFocus) /*-{
        $wnd.isc.TabIndexManager.addTarget(ID, canFocus);
    }-*/;

    /**
     * @see TabIndexManager#addTarget
     */
    public static void addTarget(String ID, boolean canFocus, String parentID){
        addTarget(ID, canFocus, parentID, (Integer) null, null, null);
    }

    /**
     * @see TabIndexManager#addTarget
     */
    public static void addTarget(String ID, boolean canFocus, String parentID, Integer position){
        addTarget(ID, canFocus, parentID, position, null, null);
    }

    /**
     * @see TabIndexManager#addTarget
     */
    public static void addTarget(String ID, boolean canFocus, String parentID, Integer position, TabIndexUpdatedCallback tabIndexUpdatedCallback){
        addTarget(ID, canFocus, parentID, position, tabIndexUpdatedCallback, null);
    }

	/**
     * Register a target to have its tab order position managed by the TabIndexManager.
     * @param ID Unique ID to associate with a tab position. For a Canvas this    would typically be the {@link
     * com.smartgwt.client.widgets.Canvas#getID Canvas.ID} but any unique string is valid.
     * @param canFocus Is this target directly focusable? Governs whether an     explicit tabIndex will be created for this target. This
     * parameter should be    passed as <code>false</code> for targets which do not require an explicit tabIndex    as they are
     * not focusable, or not explicit tab-stops for the user tabbing through the     page. They will still have an implicit tab
     * order position which     governs where descendants appear, and would be used to generate a tabIndex if    canFocus is
     * subsequently updated via {@link com.smartgwt.client.widgets.TabIndexManager#setCanFocus setCanFocus()}.
     * @param parentID For cases where the tab position should be treated part of a     group to be moved together, the ID of the parent target
     * containing all members of this    group. An example of this would be a Layout managing the tab order of all its members.
     * If present, the passed parentID must already be being managed by this TabIndexManager.    May be updated for registered
     * targets via {@link com.smartgwt.client.widgets.TabIndexManager#moveTarget moveTarget()}.
     * @param position Position in the tab-order within the specified parent [or    within top level widgets]. Omitting this parameter will add
     * the target to the end of    the specified parent's tab group.     May be updated for registered targets via {@link
     * com.smartgwt.client.widgets.TabIndexManager#moveTarget moveTarget()}.
     * @param tabIndexUpdatedCallback This notification method will     be fired when the tabIndex is actually updated, typically due to the target, or some  
     * parent of it being re-positioned in the managed Tab order. In some cases tab indices    may also be updated to make
     * space for unrelated entries being added to the    TabIndexManager. This notification is typically used to update the
     * appropriate element    in the DOM to reflect a new tab index.
     * @param shiftFocusCallback This notification method will be fired    when the special {@link com.smartgwt.client.widgets.TabIndexManager#shiftFocus
     * shiftFocus()} method is called to     programmatically move focus through the registered targets (simulating the user
     * tabbing    through elements in the tab index chain). The implementation should attempt to update    the UI state by
     * focusing in the appropriate UI for this target -- typically this means    putting browser focus into a DOM element, and
     * return true to indicate success.<br>    Returning false indicates the element is currently not focusable (disabled,
     * masked, etc),    and cause the TabIndexManager to call the shiftFocusCallback on the next registered    entry (skipping
     * over this entry).<br>    If this  method was not supplied, calls to {@link
     * com.smartgwt.client.widgets.TabIndexManager#shiftFocus shiftFocus()} will simply skip    this entry.
     */
    public static native void addTarget(String ID, boolean canFocus, String parentID, Integer position, TabIndexUpdatedCallback tabIndexUpdatedCallback, ShiftFocusCallback shiftFocusCallback) /*-{
        $wnd.isc.TabIndexManager.addTarget(ID, canFocus, parentID, position == null ? null : position.@java.lang.Integer::intValue()(), 
			$entry( function(ID) { 
				if(tabIndexUpdatedCallback!=null) tabIndexUpdatedCallback.@com.smartgwt.client.callbacks.TabIndexUpdatedCallback::execute(Ljava/lang/String;)(
					ID
				);
			}), 
			$entry( function(ID) { 
				var retVal=null;
				if(shiftFocusCallback!=null) retVal = shiftFocusCallback.@com.smartgwt.client.callbacks.ShiftFocusCallback::execute(Ljava/lang/String;)(
					ID
				);
				return retVal;
			}));
    }-*/;
	

	/**
     * Request the TabIndexManager shift focus to a registered focus target. <P> This method does not directly change the focus
     * within the DOM - instead it invokes the  <code>shiftFocusCallback</code> registered for the specified target if it is
     * marked as <code>canFocus:true</code>. <P> Returns false if the target had no no <code>shiftFocusCallback</code>,  the
     * <code>shiftFocusCallback</code> returned false, or if the target is marked as not <code>canFocus:true</code>
     * @param ID target to shift focus to
     *
     * @return returns false to indicate failure to shift focus.
     */
    public static native boolean focusInTarget(String ID) /*-{
        var ret = $wnd.isc.TabIndexManager.focusInTarget(ID);
        return ret == null ? false : ret;
    }-*/;


	/**
     * Get a report of the  current hierarchy of targets passed to {@link com.smartgwt.client.widgets.TabIndexManager#addTarget
     * addTarget()} together with current canFocus state and tabIndex (if assigned).
     *
     * @return 
     */
    public static native String getAllocatedTabChain() /*-{
        var ret = $wnd.isc.TabIndexManager.getAllocatedTabChain();
        return ret;
    }-*/;


	/**
     * Returns a tabIndex number for some target ID registered via {@link com.smartgwt.client.widgets.TabIndexManager#addTarget
     * addTarget()}. Generated tab indices are guaranteed to be in order. <P> As targets are added to, or moved within the
     * TabIndexManager, their tab index may become invalid. The <code>tabIndexUpdated</code> notification will be fired when
     * this occurs, giving developers a way to pick up the new tab index, and assign it to the appropriate DOM element if
     * appropriate.
     * @param ID ID of the target for which you want to get a numeric tabIndex.
     *
     * @return returns the numeric tabIndex value for the specified target
     */
    public static native Integer getTabIndex(String ID) /*-{
        var ret = $wnd.isc.TabIndexManager.getTabIndex(ID);
        if(ret == null) return null;
        return @com.smartgwt.client.util.JSOHelper::toInteger(I)(ret);
    }-*/;


	/**
     * Has the specified target been added to this TabIndexManager via {@link
     * com.smartgwt.client.widgets.TabIndexManager#addTarget addTarget()}?
     * @param ID Unique ID to test for.
     *
     * @return true if we are managing the tab index for the specified target
     */
    public static native boolean hasTarget(String ID) /*-{
        var ret = $wnd.isc.TabIndexManager.hasTarget(ID);
        return ret == null ? false : ret;
    }-*/;


	/**
     * Move a target to the newly specified parent / position. This method may change the calculated tab index for this entry,
     * or other canFocus:true entries which already have a calculated tabIndex. The registered tabIndexUpdated notification
     * method will for for any entry where this occurs.
     * @param ID ID of the target to move
     */
    public static native void moveTarget(String ID) /*-{
        $wnd.isc.TabIndexManager.moveTarget(ID);
    }-*/;

    /**
     * @see TabIndexManager#moveTarget
     */
    public static void moveTarget(String ID, String parentID){
        moveTarget(ID, parentID, (Integer) null);
    }

	/**
     * Move a target to the newly specified parent / position. This method may change the calculated tab index for this entry,
     * or other canFocus:true entries which already have a calculated tabIndex. The registered tabIndexUpdated notification
     * method will for for any entry where this occurs.
     * @param ID ID of the target to move
     * @param parentID ID of the new parent (if null, will move to the top level)
     * @param position Position within the specified parent. If null will be the   last entry.
     */
    public static native void moveTarget(String ID, String parentID, Integer position) /*-{
        $wnd.isc.TabIndexManager.moveTarget(ID, parentID, position == null ? null : position.@java.lang.Integer::intValue()());
    }-*/;
	

	/**
     * Move a list of targets to the newly specified parent / position. This method may change the calculated tab index for
     * these entries, or other canFocus:true entries which already have a calculated tabIndex. The registered tabIndexUpdated
     * notification method will for for any entry where this occurs.
     * @param IDs IDs of the targets to move
     */
    public static native void moveTargets(String[] IDs) /*-{
        $wnd.isc.TabIndexManager.moveTargets(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(IDs));
    }-*/;

    /**
     * @see TabIndexManager#moveTargets
     */
    public static void moveTargets(String[] IDs, String parentID){
        moveTargets(IDs, parentID, (Integer) null);
    }

	/**
     * Move a list of targets to the newly specified parent / position. This method may change the calculated tab index for
     * these entries, or other canFocus:true entries which already have a calculated tabIndex. The registered tabIndexUpdated
     * notification method will for for any entry where this occurs.
     * @param IDs IDs of the targets to move
     * @param parentID ID of the new parent (if null, will move to the top level)
     * @param position Position within the specified parent. If null will be added at the end
     */
    public static native void moveTargets(String[] IDs, String parentID, Integer position) /*-{
        $wnd.isc.TabIndexManager.moveTargets(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(IDs), parentID, position == null ? null : position.@java.lang.Integer::intValue()());
    }-*/;
	

	/**
     * Removes a target from this TabIndexManager. Any children of this target will also be removed - developers wishing to
     * preserve children should first call {@link com.smartgwt.client.widgets.TabIndexManager#moveTarget moveTarget()} to move
     * the children out of this parent
     * @param ID target to remove
     */
    public static native void removeTarget(String ID) /*-{
        $wnd.isc.TabIndexManager.removeTarget(ID);
    }-*/;


	/**
     * Resume firing any callbacks suppressed by {@link com.smartgwt.client.widgets.TabIndexManager#suppressCallbacks
     * suppressCallbacks()}
     * @param targets targets for which callbacks should be resumed
     * @see com.smartgwt.client.widgets.TabIndexManager#suppressCallbacks
     */
    public static native void resumeCallbacks(String[] targets) /*-{
        $wnd.isc.TabIndexManager.resumeCallbacks(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(targets));
    }-*/;


	/**
     * Should {@link com.smartgwt.client.widgets.TabIndexManager#useExplicitFocusNavigation useExplicitFocusNavigation()} to
     * always return true?
     * @param newValue whether we should always use explicit focus navigation
     */
    public static native void setAlwaysUseExplicitFocusNavigation(boolean newValue) /*-{
        $wnd.isc.TabIndexManager.setAlwaysUseExplicitFocusNavigation(newValue);
    }-*/;


	/**
     * Modifies whether or not some specified target should be treated as focusable and provide a meaningful TabIndex on a call
     * to {@link com.smartgwt.client.widgets.TabIndexManager#getTabIndex getTabIndex()}.
     * @param ID target ID
     * @param canFocus new value for canFocus
     */
    public static native void setCanFocus(String ID, boolean canFocus) /*-{
        $wnd.isc.TabIndexManager.setCanFocus(ID, canFocus);
    }-*/;


	/**
     * Mark the specified node (and its descendents) as using explicit focus navigation rather than relying on native browser
     * Tab event handling behavior. See {@link com.smartgwt.client.widgets.TabIndexManager#useExplicitFocusNavigation
     * useExplicitFocusNavigation()} for more information.
     * @param ID registered TabIndexManager target
     * @param newValue should explicit focus navigation be used for the specified   target and its descendents
     */
    public static native void setUseExplicitFocusNavigation(String ID, boolean newValue) /*-{
        $wnd.isc.TabIndexManager.setUseExplicitFocusNavigation(ID, newValue);
    }-*/;


	/**
     * Method to shift focus to the next registered focusable target. <P> This method does not directly change the focus within
     * the DOM - instead it finds the  next target marked as <code>canFocus:true</code>, and invokes the 
     * <code>shiftFocusCallback</code> registered for that target. This callback is expected to take the appropriate action
     * (typically shifting native focus to an element in the DOM), and return true (or return false, if the target could not
     * receieve focus for some reason, in which case we'll find the next <code>canFocus:true</code> target and repeat the
     * action there. <P> Targets with no <code>shiftFocusCallback</code> will be skipped entirely in this process.
     * @param ID current focus target. If null, focus will be applied to the first   focusable target (or the last if the
     * <code>forward</code> parameter is false).
     * @param forward should focus move forward to the next focusable target, or    backward to the previous focusable target.
     *
     * @return returns true to indicate focus was successfully shifted, false to   indicate this method was unable to change focus.
     */
    public static native boolean shiftFocus(String ID, boolean forward) /*-{
        var ret = $wnd.isc.TabIndexManager.shiftFocus(ID, forward);
        return ret == null ? false : ret;
    }-*/;


	/**
     * Method to shift focus to the next registered focusable target beyond some registered target and any targets registered
     * as children within its group via  {@link com.smartgwt.client.widgets.TabIndexManager#addTarget addTarget()} or {@link
     * com.smartgwt.client.widgets.TabIndexManager#moveTarget moveTarget()}. <P> This method does not directly change the focus
     * within the DOM - instead it finds the  next target marked as <code>canFocus:true</code>, and invokes the 
     * <code>shiftFocusCallback</code> registered for that target. This callback is expected to take the appropriate action
     * (typically shifting native focus to an element in the DOM), and return true (or return false, if the target could not
     * receieve focus for some reason, in which case we'll find the next <code>canFocus:true</code> target and repeat the
     * action there. <P> Targets with no <code>shiftFocusCallback</code> will be skipped entirely in this process. <P> A return
     * value of false indicates that this method was unable to shift focus to a new  target.
     * @param targetGroup ID of registered target. Focus will be shifted to the   next registered focusable element, skipping this group and its
     * descendants.
     * @param forward should focus move forward to the next focusable target, or    backward to the previous focusable target.
     *
     * @return returns true to indicate focus was successfully shifted, false to   indicate this method was unable to change focus.
     */
    public static native boolean shiftFocusAfterGroup(String targetGroup, boolean forward) /*-{
        var ret = $wnd.isc.TabIndexManager.shiftFocusAfterGroup(targetGroup, forward);
        return ret == null ? false : ret;
    }-*/;


	/**
     * Method to shift focus to the next registered focusable target within some group. This method will move focus forward or
     * backward, considering only the specified target and any targets within its group (registered as children of the target
     * via {@link com.smartgwt.client.widgets.TabIndexManager#addTarget addTarget()} or {@link
     * com.smartgwt.client.widgets.TabIndexManager#moveTarget moveTarget()}). <P> The second parameter can be passed to specify
     * an explicit starting position to shift focus from. If this is not present, this method will attempt to focus into the
     * group target itself if moving forward (or its last child, if moving backward) and failing that, shift focus from there.
     * <P> This method does not directly change the focus within the DOM - instead it finds the  next target marked as
     * <code>canFocus:true</code>, and invokes the  <code>shiftFocusCallback</code> registered for that target. This callback
     * is expected to take the appropriate action (typically shifting native focus to an element in the DOM), and return true
     * (or return false, if the target could not receieve focus for some reason, in which case we'll find the next
     * <code>canFocus:true</code> target and repeat the action there. <P> Targets with no <code>shiftFocusCallback</code> will
     * be skipped entirely in this process. <P> A return value of false indicates that this method was unable to shift focus to
     * a new  target.
     * @param targetGroup ID of registered target. Focus will be shifted within   this target and its descendants only.
     * @param currentTarget Optional ID of current focus target within the group   focus will be shifted in the specified direction from this node.
     * @param forward should focus move forward to the next focusable target, or    backward to the previous focusable target.
     *
     * @return returns true to indicate focus was successfully shifted, false to   indicate this method was unable to change focus.
     */
    public static native boolean shiftFocusWithinGroup(String targetGroup, String currentTarget, boolean forward) /*-{
        var ret = $wnd.isc.TabIndexManager.shiftFocusWithinGroup(targetGroup, currentTarget, forward);
        return ret == null ? false : ret;
    }-*/;


	/**
     * Show the current hierarchy of targets passed to {@link com.smartgwt.client.widgets.TabIndexManager#addTarget
     * addTarget()} together with current canFocus state and tabIndex (if assigned). Results are output to the developer
     * console.
     */
    public static native void showAllocatedTabChain() /*-{
        $wnd.isc.TabIndexManager.showAllocatedTabChain();
    }-*/;


	/**
     * Temporarily suppress firing any tabIndexChanged callback passed into  {@link
     * com.smartgwt.client.widgets.TabIndexManager#addTarget addTarget()} for the  specified targets should their tab index
     * change. <P> This is useful for cases where a developer is managing a list of items and wants to avoid any potential for
     * multiple notifications until the entire list has been managed
     * @param targets targets for which callbacks should be suppressed
     * @see com.smartgwt.client.widgets.TabIndexManager#resumeCallbacks
     */
    public static native void suppressCallbacks(String[] targets) /*-{
        $wnd.isc.TabIndexManager.suppressCallbacks(@com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(targets));
    }-*/;


	/**
     * Should focus navigation be achieved by explicitly calling the TabIndexManager {@link
     * com.smartgwt.client.widgets.TabIndexManager#shiftFocus shiftFocus()} method for the specified node? <P> Developers
     * integrating custom focusable element's into a Smart GWT based application  can use this method to ensure the elements in
     * question interact correctly with  {@link com.smartgwt.client.widgets.Canvas#showClickMask click masks} and {@link
     * com.smartgwt.client.widgets.grid.ListGrid#getCanEdit grid editing}. See the {@link
     * com.smartgwt.client.docs.TabOrderOverview tab order overview} topic for more information on integrating custom focusable
     * UI into a Smart GWT application. <P> This method will return true if the {@link
     * com.smartgwt.client.widgets.TabIndexManager#setAlwaysUseExplicitFocusNavigation setAlwaysUseExplicitFocusNavigation()}
     * has been set to true (typically because a {@link com.smartgwt.client.widgets.Canvas#showClickMask click mask} is
     * showing), or if the entry or some ancestor has been marked as  {@link
     * com.smartgwt.client.widgets.TabIndexManager#setUseExplicitFocusNavigation useExplicitFocusNavigation:true}. Note that
     * this is the case for entries registered under a canvas with {@link
     * com.smartgwt.client.widgets.Canvas#getAlwaysManageFocusNavigation Canvas.alwaysManageFocusNavigation} set to true.
     * @param ID TabIndexManager registered target ID
     *
     * @return true if explicit focus navigation should be used
     */
    public static native boolean useExplicitFocusNavigation(String ID) /*-{
        var ret = $wnd.isc.TabIndexManager.useExplicitFocusNavigation(ID);
        return ret == null ? false : ret;
    }-*/;


    // ***********************************************************

}
