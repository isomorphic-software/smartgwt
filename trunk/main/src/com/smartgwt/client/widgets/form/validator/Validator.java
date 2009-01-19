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
 
package com.smartgwt.client.widgets.form.validator;



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
    * A validator describes a check that should be performed on a value the user is trying to save. <p> Validators are specified for DataSource fields via the {@link com.smartgwt.client.data.DataSourceField#getValidators validators} property.  Validators that need not be run on the server can also be specified for a specific {@link com.smartgwt.client.widgets.form.fields.FormItem} or ${isc.DocUtils.linkForRef('object:ListGridField')}. <p> ISC supports a powerful library of {@link com.smartgwt.client..ValidatorTypes} which have identical behavior on both the client and the server.   <p>  Beyond this, custom validators can be defined on the client and custom validation logic added on the server.  Note that the <code>regexp</code> and <code>mask</code> validator types are very flexible and can be used to perform virtually any kind of formatting check that doesn't involve some large external dataset. <p> Custom validators can be reused on the client by adding them to the global validator list, via the {@link com.smartgwt.client.widgets.form.validator.Validator#addValidator} method.

    */
public class Validator extends DataClass {

    public static Validator getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        return new Validator(jsObj);
    }


    public Validator(){
        
    }

    public Validator(JavaScriptObject jsObj){
        super(jsObj);
    }

    // ********************* Properties / Attributes ***********************

    /**
    * Normally, all validators defined for a field will be run even if one of the validators has already failed.  However, if <code>stopIfFalse</code> is set, validation will not proceed beyond this validator if the check fails. <P> This is useful to prevent expensive validators from being run unnecessarily, or to allow custom validators that don't need to be robust about handling every conceivable type of value.
    *
    * @param stopIfFalse stopIfFalse Default value is false
    */
    public void setStopIfFalse(Boolean stopIfFalse) {
        setAttribute("stopIfFalse", stopIfFalse);
    }
    /**
     * Normally, all validators defined for a field will be run even if one of the validators has already failed.  However, if <code>stopIfFalse</code> is set, validation will not proceed beyond this validator if the check fails. <P> This is useful to prevent expensive validators from being run unnecessarily, or to allow custom validators that don't need to be robust about handling every conceivable type of value.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getStopIfFalse()  {
        return getAttributeAsBoolean("stopIfFalse");
    }

    /**
    * Indicates this validator runs on the client only. <p> Normally, if the server is trying to run validators and finds a validator that it can't execute, for safety reasons validation is considered to have failed.  Use this flag to explicitly mark a validator that only needs to run on the client.
    *
    * @param clientOnly clientOnly Default value is false
    */
    public void setClientOnly(Boolean clientOnly) {
        setAttribute("clientOnly", clientOnly);
    }
    /**
     * Indicates this validator runs on the client only. <p> Normally, if the server is trying to run validators and finds a validator that it can't execute, for safety reasons validation is considered to have failed.  Use this flag to explicitly mark a validator that only needs to run on the client.
     *
     *
     * @return Boolean
     *
     */
    public Boolean getClientOnly()  {
        return getAttributeAsBoolean("clientOnly");
    }

    // ********************* Methods ***********************


    // ********************* Static Methods ***********************






    /**
     * Text to display if the value does not pass this validation check. <P> If unspecified, default error messages
     * exist for all built-in validators, and a generic message will be used for a custom validator that is not passed.
     *
     * @param errorMessage errorMessage Default value is null
     */
    public void setErrorMessage(String errorMessage) {
        setAttribute("errorMessage", errorMessage);
    }

}



