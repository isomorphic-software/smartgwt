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

package com.smartgwt.client.data;

import com.smartgwt.client.widgets.DataBoundComponent;

/**
 * A dialog that allows the user to set up complex sorting arrangements by defining a group of {@link SortSpecifier}s.
 * <p>
 * Each SortSpecifier applies to a single property and direction - so, for instance, in a grid with two columns,
 * year and monthNumber, you could sort first by year in descending order and then by monthNumber in ascending order. T
 * his would producing a grid sorted by year from largest (most recent) to smallest (least recent) and, within each year,
 * by monthNumber from smallest (January) to largest (December).
 */
public class MultiSortDialog {

    /**
     * Launches a MultiSortDialog and obtains a sort-definition from the user.
     * 
     * @param dataBoundComponent the databound component to apply the sort to
     * @param initialSort The initial sort definition.
     * @param callback Called when the user defines and accepts one or more SortSpecifiers. Single parameter sortLevels is an Array
     * of SortSpecifier or null if the user cancelled the dialog.
     */
    public static native void askForSort(DataBoundComponent dataBoundComponent, SortSpecifier[] initialSort, MultiSortCallback callback) /*-{
        var dbcJS = dataBoundComponent.@com.smartgwt.client.widgets.DataBoundComponent::getOrCreateJsObj()();
        var initialSortJS = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(initialSort);

        $wnd.isc.MultiSortDialog.askForSort(dbcJS, initialSortJS,
                
           callback == null ? null : function(sortLevels) {
               var sortLevelsJ = sortLevels == null || sortLevels == undefined ? null : @com.smartgwt.client.data.SortSpecifier::convertToArray(Lcom/google/gwt/core/client/JavaScriptObject;)(sortLevels);
               callback.@com.smartgwt.client.data.MultiSortCallback::execute([Lcom/smartgwt/client/data/SortSpecifier;)(sortLevelsJ);
           }
        );
    }-*/;    
}
