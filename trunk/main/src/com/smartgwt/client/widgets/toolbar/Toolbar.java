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
 
package com.smartgwt.client.widgets.toolbar;



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
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
   /**
    * A Toolbar creates a vertical or horizontal strip of similar components (typically Buttons) and provides managed resizing and reordering behavior over those components. <p> If you are creating a bar with a mixture of different elements (eg some MenuButtons, some Labels, some Buttons, some custom components), you want to use a {@link com.smartgwt.client.widgets.toolbar.ToolStrip}.  A Toolbar is better suited for managing a set of highly similar, interchangeable components, such as ListGrid headers.

    */


public class Toolbar extends Layout  implements com.smartgwt.client.widgets.toolbar.events.HasItemClickHandlers, com.smartgwt.client.widgets.toolbar.events.HasItemDragResizedHandlers {

    public static Toolbar getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseWidget obj = BaseWidget.getRef(jsObj);
        if(obj != null) {
            return (Toolbar) obj;
        } else {
            return new Toolbar(jsObj);
        }
    }


    public Toolbar(){
        
    }

    public Toolbar(JavaScriptObject jsObj){
        super(jsObj);
    }

    protected native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
        var widget = $wnd.isc.Toolbar.create(config);
        this.@com.smartgwt.client.widgets.BaseWidget::doInit()();
        return widget;
    }-*/;
    // ********************* Properties / Attributes ***********************

    /**
    * Indicates whether the buttons are drawn horizontally from left to right (false), or vertically from top to bottom (true).
    *
    * @param vertical vertical Default value is false
    */
    public void setVertical(Boolean vertical) {
        setAttribute("vertical", vertical, true);
    }
    /**
     * Indicates whether the buttons are drawn horizontally from left to right (false), or vertically from top to bottom (true).
     *
     *
     * @return Boolean
     *
     */
    public Boolean getVertical()  {
        return getAttributeAsBoolean("vertical");
    }

    /**
    * If true, items can be reordered by dragging on them.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canReorderItems canReorderItems Default value is false
    */
    public void setCanReorderItems(Boolean canReorderItems) {
        setAttribute("canReorderItems", canReorderItems, true);
    }
    /**
     * If true, items can be reordered by dragging on them.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanReorderItems()  {
        return getAttributeAsBoolean("canReorderItems");
    }

    /**
    * If true, items (buttons) can be resized by dragging on them.
    * Setter for updating {@link com.smartgwt.client.widgets.toolbar.Toolbar#getCanResizeItems canResizeItems} at runtime.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canResizeItems New value for this.canResizeItems. Default value is false
    */
    public void setCanResizeItems(Boolean canResizeItems) {
        setAttribute("canResizeItems", canResizeItems, true);
    }
    /**
     * If true, items (buttons) can be resized by dragging on them.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanResizeItems()  {
        return getAttributeAsBoolean("canResizeItems");
    }

    /**
    * If true, items (buttons) can be dropped into this toolbar, and the toolbar will show a drop line at the drop location.  Override drop() to decide what happens when the item is dropped.
    * <p><b>Note : </b> This is an advanced setting</p>
    *
    * @param canAcceptDrop canAcceptDrop Default value is false
    */
    public void setCanAcceptDrop(Boolean canAcceptDrop) {
        setAttribute("canAcceptDrop", canAcceptDrop, true);
    }
    /**
     * If true, items (buttons) can be dropped into this toolbar, and the toolbar will show a drop line at the drop location.  Override drop() to decide what happens when the item is dropped.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getCanAcceptDrop()  {
        return getAttributeAsBoolean("canAcceptDrop");
    }

    // ********************* Methods ***********************











        /**
         * Add a itemClick handler.
         *
         * @param handler the itemClick handler
         */
        public HandlerRegistration addItemClickHandler(com.smartgwt.client.widgets.toolbar.events.ItemClickHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.toolbar.events.ItemClickEvent.getType()) == 0) setupItemClickEvent();
            return manager.addHandler(com.smartgwt.client.widgets.toolbar.events.ItemClickEvent.getType(), handler);
        }
        private native void setupItemClickEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({itemClick:function(){
                        var param = {"item" : arguments[0], "itemNum" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.toolbar.events.ItemClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.itemClick = function(){
                    var param = {"item" : arguments[0], "itemNum" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.toolbar.events.ItemClickEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;



        /**
         * Add a itemDragResized handler.
         *
         * @param handler the itemDragResized handler
         */
        public HandlerRegistration addItemDragResizedHandler(com.smartgwt.client.widgets.toolbar.events.ItemDragResizedHandler handler) {
            if(manager.getHandlerCount(com.smartgwt.client.widgets.toolbar.events.ItemResizedEvent.getType()) == 0) setupItemDragResizedEvent();
            return manager.addHandler(com.smartgwt.client.widgets.toolbar.events.ItemResizedEvent.getType(), handler);
        }
        private native void setupItemDragResizedEvent() /*-{
            var obj = null;
            var managerJ = this.@com.smartgwt.client.widgets.BaseWidget::manager;
            if(this.@com.smartgwt.client.widgets.BaseWidget::isCreated()()) {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getJsObj()();
                obj.addProperties({itemDragResized:function(){
                        var param = {"itemNum" : arguments[0], "newSize" : arguments[1]};
                        var event = @com.smartgwt.client.widgets.toolbar.events.ItemResizedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                        managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                    }
                });
            } else {
                obj = this.@com.smartgwt.client.widgets.BaseWidget::getConfig()();
                obj.itemDragResized = function(){
                    var param = {"itemNum" : arguments[0], "newSize" : arguments[1]};
                    var event = @com.smartgwt.client.widgets.toolbar.events.ItemResizedEvent::new(Lcom/google/gwt/core/client/JavaScriptObject;)(param);
                    managerJ.@com.google.gwt.event.shared.HandlerManager::fireEvent(Lcom/google/gwt/event/shared/GwtEvent;)(event);
                };
            }
        }-*/;

    // ********************* Static Methods ***********************

}




