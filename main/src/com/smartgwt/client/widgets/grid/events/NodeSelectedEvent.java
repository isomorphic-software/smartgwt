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
 
package com.smartgwt.client.widgets.grid.events;



import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.Record;
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
import com.google.gwt.dom.client.Element;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.EnumUtil;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;
public class NodeSelectedEvent extends BrowserEvent<NodeSelectedHandler>  implements Cancellable {
    private boolean cancel = false;

  /**
   * Handler type.
   */
  private static Type<NodeSelectedHandler> TYPE;

    /**
     * Returns the {@link com.smartgwt.client.widgets.Canvas Canvas} firing the event.
     * @return Canvas firing the event
     */
    public Canvas getFiringCanvas() {
        JavaScriptObject canvasJS = getFiringInstanceAsJavaScriptObject();
        return canvasJS != null ? Canvas.getByJSObject(canvasJS) : null;
    }

  /**
   * Fires a open event on all registered handlers in the handler manager.If no
   * such handlers exist, this method will do nothing.
   *
   * @param <S> The event source
   * @param source the source of the handlers
   * @param jsObj the native event
   */
  public static <S extends HasNodeSelectedHandlers & HasHandlers> void fire(
      S source, JavaScriptObject jsObj) {
    if (TYPE != null) {
        NodeSelectedEvent event = new NodeSelectedEvent(jsObj);
        source.fireEvent(event);
    }
  }

  /**
   * Gets the type associated with this event.
   *
   * @return returns the handler type
   */
  public static Type<NodeSelectedHandler> getType() {
    if (TYPE == null) {
      TYPE = new Type<NodeSelectedHandler>();
    }
    return TYPE;
  }


  @Override
  protected void dispatch(NodeSelectedHandler handler) {
    handler.onNodeSelected(this);
  }

  // Because of type erasure, our static type is
  // wild carded, yet the "real" type should use our I param.

  @SuppressWarnings("unchecked")
  @Override
  public final Type<NodeSelectedHandler> getAssociatedType() {
    return TYPE;
  }

    public NodeSelectedEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }


    /**
     * Call this method to cancel default behavior
     */
    public void cancel() {
        cancel = true;
    }

    /**
     * @return true if cancelled
     */
    public boolean isCancelled() {
        return cancel;
    }

    /**
     * The column (ListGrid instance) in which the node was selected
     *
     * @return The column (ListGrid instance) in which the node was selected
     */
    public  native ListGrid getColumn() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var retVal = @com.smartgwt.client.widgets.grid.ListGrid::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.column);
        if(retVal == null) {
            retVal = @com.smartgwt.client.widgets.grid.ListGrid::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.column);
        }
        return retVal;
    }-*/;

    /**
     * The selected node
     *
     * @return The selected node
     */
    public  native TreeNode getNode() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
            var retVal = @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.node);
            if(retVal == null) {
                retVal = @com.smartgwt.client.widgets.tree.TreeNode::new(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.node);
            }
            return retVal;
    }-*/;





    /**
     * node the node that was selected
     *
     * @return nodethe node that was selected
     */
    public  native TreeNode getTreeNode() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        return @com.smartgwt.client.widgets.tree.TreeNode::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(jsObj.node);
    }-*/;


}
