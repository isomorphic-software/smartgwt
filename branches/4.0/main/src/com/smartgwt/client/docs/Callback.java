package com.smartgwt.client.docs;


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
 
/**
 * A <code>Callback</code> is an arbitrary action to be fired - usually passed into a  method to be fired asynchronously as
 * a notificaction of some event.<br> The <code>callback</code> can be defined in the following formats:<ul> <li>a
 * function</li> <li>A string containing an expression to evaluate</li> <li>An object with the following properties:<br>   
 * - target: fire in the scope of this target - when the action fires,       the target will be available as
 * <code>this</code>.<br>     - methodName: if specified we'll check for a method on the target object with this       
 * name.<br>  </li></ul> <code>Callbacks</code> are fired via the  Class.fireCallback method, which allows named parameters
 * to be passed into the callback at runtime. If the Callback was specified as a string of script, these parameters are
 * available as local variables at eval time.<br> For specific Smart GWT methods that make use of <code>Callback</code>
 * objects, see local documentation for information on parameters and scope.
 */
public interface Callback  {
}
