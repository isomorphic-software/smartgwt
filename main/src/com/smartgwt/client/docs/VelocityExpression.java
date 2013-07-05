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
 * An expression in the <a href=http://velocity.apache.org/engine/releases/velocity-1.5/user-guide.html> Velocity Template
 * Language</a> (VTL).  For more information on Smart GWT's Velocity support,  see {@link
 * com.smartgwt.client.docs.VelocitySupport Velocity support}. <p> Note that a <code>VelocityExpression</code> must often
 * evaluate to a particular type of value  to be useful.  For example, {@link
 * com.smartgwt.client.docs.serverds.DataSource#requires requires} must evaluate to true or false  (Boolean objects or
 * strings containing those two words), and {@link com.smartgwt.client.docs.serverds.Mail#messageData messageData} must
 * evaluate to a Java <code>Map</code> object, or a Java <code>List</code> containing only  <code>Map</code>s.
 */
public interface VelocityExpression  {
}
