/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2012, Isomorphic Software, Inc.
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

package com.smartgwt.client.core;

/** <h1>Smart GWT debugging in Eclipse with logical structures</h1>
 * <p>Normally, when debugging a Smart GWT application in Eclipse, inspecting a Smart GWT
 * object 
 * <p>The logical structure facility in Eclipse allows dynamic code execution when
 * inspecting a variable </p>
 *
 */
public class NativeObject {
    private LogicalStructure o;
    
    public NativeObject(LogicalStructure o) {
        this.o = o;
    }
}
