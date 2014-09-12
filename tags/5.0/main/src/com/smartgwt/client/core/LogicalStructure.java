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

import com.smartgwt.logicalstructure.core.LogicalStructureObject;

/**
 * <p>SmartGWT classes implementing <pre>LogicalStructure</pre> allow their JavaScript state to
 * be viewed in an Eclipse Java debugging environment, using Eclipse's logical structure
 * facility. To use this:</p>
 * <ul>
 * <li>In Eclipse, open the Preferences dialog, and navigate to the "Logical Structures"
 *     page (<i>Java->Debug->Logical Structures</i>). Add two new entries:
 *     <ol>
 *     <li><i>Qualified type name:</i> <pre>com.smartgwt.client.core.LogicalStructure</pre><br/>
 *         <i>Description:</i> SmartGWT LogicalStructure<br/>
 *         <i>Applies to subtypes:</i> Checked<br/>
 *         <i>Structure type:</i> Single value<br/>
 *         <i>Code:</i> <pre>this.initNativeObject(); return this;</pre></li>
 *     <li><i>Qualified type name:</i> <pre>com.smartgwt.client.core.NativeObject</pre><br/>
 *         <i>Description:</i> SmartGWT NativeObject<br/>
 *         <i>Applies to subtypes:</i> Checked<br/>
 *         <i>Structure type:</i> Single value<br/>
 *         <i>Code:</i> <pre>return this.o.getLogicalStructure();</pre></li>
 *     </ol></li>
 * <li>Debug your SmartGWT application in Eclipse as you normally would.</li>
 * <li>When viewing variables structurally (e.g.,
 *     in the "Variables" or "Expressions" view, or when hovering over a variable),
 *     objects implementing LogicalStructure will have a <pre>nativeObject</pre> field,
 *     the contents of which are described below:
 *     <ul>
 *       <li>The <pre>scClassName</pre> field contains the underlying SmartClient class name 
 *           for the object.</li>
 *       <li>The documented attributes for the SmartClient class, and its superclasses, are
 *           displayed as separate fields.</li>
 *       <li><pre>nativeObject</pre> field values are always cast to Strings in JavaScript,
 *           <i>unless</u> the field is a class which implements <pre>LogicalStructure</pre>, 
 *           or is an array thereof (e.g. <pre>Layout.members</pre>).
 *           In that case, the value of the field is the
 *           underlying SmartGWT object, which in turn has its own <pre>nativeObject</pre>
 *           field, etc.</li>
 *       <li>The <pre>logicalStructureErrors</pre> field is a string describing all of the 
 *           runtime errors encountered when displaying other <pre>nativeObject</pre> 
 *           fields.</li>
 *       <li>A <pre>null</pre> value for a <pre>nativeObject</pre> field may indicate any
 *           of the following:
 *           <ul>
 *           <li>The underlying JavaScript attribute is undefined.</li>
 *           <li>The underlying JavaScript attribute is defined, but set to <pre>null</pre>.</li>
 *           <li>An error occurred while attempting to read the attribute, which would be
 *               documented in the value of <pre>logicalStructureErrors</pre>.</li>
 *       </li>
 *     </ul>
 * </ul>
 *
 * <p>For more information on the JavaScript state of SmartGWT objects, consult the
 * <a href="http://www.smartclient.com/product/documentation.jsp">SmartClient documentation</a>.</p>
 */
public interface LogicalStructure {
    public void initNativeObject();
    public LogicalStructureObject setLogicalStructure(LogicalStructureObject s);
    public LogicalStructureObject getLogicalStructure();
}
