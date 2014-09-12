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

package com.smartgwt.client.widgets.events;



import com.smartgwt.client.event.*;
import com.smartgwt.client.data.*;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HasHandlers;
public class FetchDataEvent extends BrowserEvent<FetchDataHandler> {

  /**
   * Handler type.
   */
  private static Type<FetchDataHandler> TYPE;

  /**
   * Fires a open event on all registered handlers in the handler manager.If no
   * such handlers exist, this method will do nothing.
   *
   * @param <S> The event source
   * @param source the source of the handlers
   * @param jsObj the native event
   */
  public static <S extends HasFetchDataHandlers & HasHandlers> void fire(
      S source, JavaScriptObject jsObj) {
    if (TYPE != null) {
        FetchDataEvent event = new FetchDataEvent(jsObj);
        source.fireEvent(event);
    }
  }

  /**
   * Gets the type associated with this event.
   *
   * @return returns the handler type
   */
  public static Type<FetchDataHandler> getType() {
    if (TYPE == null) {
      TYPE = new Type<FetchDataHandler>();
    }
    return TYPE;
  }


  @Override
  protected void dispatch(FetchDataHandler handler) {
    handler.onFilterData(this);
  }

  // Because of type erasure, our static type is
  // wild carded, yet the "real" type should use our I param.

  @SuppressWarnings("unchecked")
  @Override
  public final Type<FetchDataHandler> getAssociatedType() {
    return TYPE;
  }

    public FetchDataEvent(JavaScriptObject jsObj) {
        super(jsObj);
    }

    /**
     * The criteria derived from the filter editor values.
     *
     * @return criteria derived from the filter editor values
     */
    public native Criteria getCriteria() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var criteriaJS =  jsObj.criteria;
        return criteriaJS == null || criteriaJS === undefined ? null : @com.smartgwt.client.data.Criteria::new(Lcom/google/gwt/core/client/JavaScriptObject;)(criteriaJS);
    }-*/;

    /**
     * The criteria derived from the filter editor values.
     *
     * @return criteria derived from the filter editor values
     */
    public native DSRequest getRequestProperties() /*-{
        var jsObj = this.@com.smartgwt.client.event.AbstractSmartEvent::jsObj;
        var requestPropertiesJS =  jsObj.requestProperties;
        return requestPropertiesJS == null || requestPropertiesJS === undefined ? null : @com.smartgwt.client.data.DSRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(requestPropertiesJS);
    }-*/;
}
