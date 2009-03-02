/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.smartgwt.client.util;

import com.google.gwt.user.client.ui.Image;

public class SkinPreLoader {

    public static native String getSkinDir() /*-{
        return $wnd.isc.Page.getSkinDir();
    }-*/;

    public static void preloadActions() {
        prefetch(actions);
    }

    public static void preloadCorners() {
        prefetch(corners);
    }

    public static void preloadButtons() {
        prefetch(buttons);
    }

    public static void preloadEdges() {
        prefetch(edges);
    }

    private static void prefetch(String[] images) {
        String skinDir = getSkinDir();
        for (int i = 0; i < images.length; i++) {
            String img = images[i];
            Image.prefetch(skinDir + "/" + img);
        }
    }

    private static final String[] actions = {
            "add.png",
            "approve.png",
            "back.png",
            "cancel.png",
            "column_preferences.png",
            "configure.png",
            "download.png",
            "edit.png",
            "filter.png",
            "find.png",
            "first.png",
            "forward.png",
            "freezeLeft.png",
            "freezeRight.png",
            "groupby.png",
            "help.png",
            "last.png",
            "next.png",
            "ok.png",
            "prev.png",
            "redo.png",
            "refresh.png",
            "remove.png",
            "save.png",
            "search.png",
            "sort_ascending.png",
            "sort_descending.png",
            "undo.png",
            "unfreeze.png",
            "ungroup.png",
            "view.png",
    };

    private static final String[] corners = {
            "corner_808080_BL.gif",
            "corner_808080_BR.gif",
            "corner_808080_TL.gif",
            "corner_808080_TR.gif",
            "corner_8080FF_BL.gif",
            "corner_8080FF_BR.gif",
            "corner_8080FF_TL.gif",
            "corner_8080FF_TR.gif",
            "corner_D6D6D6_BL.gif",
            "corner_D6D6D6_BR.gif",
            "corner_D6D6D6_TL.gif",
            "corner_D6D6D6_TR.gif",
            "corner_DDDDDD_BL.gif",
            "corner_DDDDDD_BR.gif",
            "corner_DDDDDD_TL.gif",
            "corner_DDDDDD_TR.gif",
            "corner_EEEEEE_BL.gif",
            "corner_EEEEEE_BR.gif",
            "corner_EEEEEE_TL.gif",
            "corner_EEEEEE_TR.gif",
            "corner_FFFFFF_BL.gif",
            "corner_FFFFFF_BR.gif",
            "corner_FFFFFF_TL.gif",
            "corner_FFFFFF_TR.gif"
    };

    private static String[] buttons = {
            "button_Disabled_end.png",
            "button_Disabled_start.png",
            "button_Disabled_stretch.png",
            "button_Down_end.png",
            "button_Down_start.png",
            "button_Down_stretch.png",
            "button_end.png",
            "button_Over_end.png",
            "button_Over_start.png",
            "button_Over_stretch.png",
            "button_Selected_Disabled_end.png",
            "button_Selected_Disabled_start.png",
            "button_Selected_Disabled_stretch.png",
            "button_Selected_Down_end.png",
            "button_Selected_Down_start.png",
            "button_Selected_Down_stretch.png",
            "button_Selected_end.png",
            "button_Selected_Over_end.png",
            "button_Selected_Over_start.png",
            "button_Selected_Over_stretch.png",
            "button_Selected_start.png",
            "button_Selected_stretch.png",
            "button_start.png",
            "button_stretch.png"
    };

    private static String[] edges = {
            "edge_D6D6D6_B.gif",
            "edge_D6D6D6_B.png",
            "edge_D6D6D6_BL.gif",
            "edge_D6D6D6_BL.png",
            "edge_D6D6D6_BR.gif",
            "edge_D6D6D6_BR.png",
            "edge_D6D6D6_L.gif",
            "edge_D6D6D6_L.png",
            "edge_D6D6D6_R.gif",
            "edge_D6D6D6_R.png",
            "edge_D6D6D6_T.gif",
            "edge_D6D6D6_T.png",
            "edge_D6D6D6_TL.gif",
            "edge_D6D6D6_TL.png",
            "edge_D6D6D6_TR.gif",
            "edge_D6D6D6_TR.png",
            "edge_DDDDDD_B.gif",
            "edge_DDDDDD_B.png",
            "edge_DDDDDD_BL.gif",
            "edge_DDDDDD_BL.png",
            "edge_DDDDDD_BR.gif",
            "edge_DDDDDD_BR.png",
            "edge_DDDDDD_L.gif",
            "edge_DDDDDD_L.png",
            "edge_DDDDDD_R.gif",
            "edge_DDDDDD_R.png",
            "edge_DDDDDD_T.gif",
            "edge_DDDDDD_T.png",
            "edge_DDDDDD_TL.gif",
            "edge_DDDDDD_TL.png",
            "edge_DDDDDD_TR.gif",
            "edge_DDDDDD_TR.png",
            "edge_EEEEEE_B.gif",
            "edge_EEEEEE_B.png",
            "edge_EEEEEE_BL.gif",
            "edge_EEEEEE_BL.png",
            "edge_EEEEEE_BR.gif",
            "edge_EEEEEE_BR.png",
            "edge_EEEEEE_L.gif",
            "edge_EEEEEE_L.png",
            "edge_EEEEEE_R.gif",
            "edge_EEEEEE_R.png",
            "edge_EEEEEE_T.gif",
            "edge_EEEEEE_T.png",
            "edge_EEEEEE_TL.gif",
            "edge_EEEEEE_TL.png",
            "edge_EEEEEE_TR.gif",
            "edge_EEEEEE_TR.png",
            "edge_FFFFFF_B.gif",
            "edge_FFFFFF_B.png",
            "edge_FFFFFF_BL.gif",
            "edge_FFFFFF_BL.png",
            "edge_FFFFFF_BR.gif",
            "edge_FFFFFF_BR.png",
            "edge_FFFFFF_L.gif",
            "edge_FFFFFF_L.png",
            "edge_FFFFFF_R.gif",
            "edge_FFFFFF_R.png",
            "edge_FFFFFF_T.gif",
            "edge_FFFFFF_T.png",
            "edge_FFFFFF_TL.gif",
            "edge_FFFFFF_TL.png",
            "edge_FFFFFF_TR.gif",
            "edge_FFFFFF_TR.png"

    };
}
