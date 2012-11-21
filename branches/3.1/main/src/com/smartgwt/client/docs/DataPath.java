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
 * String specifying a nested data field structure.
 *  <P>
 *  Each dataPath string is a slash-delimited set of field identifiers, for example
 *  <code>"id1/id2/id3"</code>. DataPaths may be applied directly to a
 *  {@link com.smartgwt.client.widgets.Canvas#getDataPath component}, and/or to a databound component field specification.
 *  A datapath denotes a path to a nested field value in a hierarchical structure, giving
 *  developers the opportunity to easily view or edit nested data structures.
 *  Specifically:
 *  <ul><li>if the component is viewing or editing a record, the value for fields 
 *          will be derived from a nested structure of records</li>
 *      <li>if the component is bound to a dataSource, field attributes may be picked up by
 *          following the dataPath to a field definition on another dataSource</li></ul>
 *  <b>Examples:</b><br>
 *  If a dynamicForm is defined with the following fields:
 *  <pre>
 *     [
 *       { name:"name" },
 *       { name:"street", dataPath:"address/street" }
 *     ]
 *  </pre>
 *  If the <code>"name"</code> field is set to <i>"Joe Smith"</i> and the <code>"street"</code> field
 *  is set to <i>"1221 High Street"</i>, when the values for this form are retrieved via a
 *  <code>getValues()</code> call they will return an object in the following format:
 *  <pre>
 *     {name:"Joe Smith", address:{street:"1221 High Street"}}
 *  </pre>
 *  <P>
 *  For databound components, dataPath also provides a way to pick up field attributes from nested
 *  dataSources. Given the following dataSource definitions:
 *  <pre>
 *   isc.DataSource.create({
 *       ID:"contacts",
 *       fields:[
 *           {name:"name"},
 *           {name:"email"},
 *           {name:"organization"},
 *           {name:"phone"},
 *           {name:"address", type:"Address"}
 *       ]
 *   });
 *  
 *   isc.DataSource.create({
 *       ID:"Address",
 *       fields:[
 *           {name:"street"},
 *           {name:"city"},
 *           {name:"state"},
 *           {name:"zip"}
 *       ]
 *   });
 *   </pre>
 *  and a databound component bound to the 'contacts' dataSource, specifying a field with a dataPath
 *  of <code>"address/street"</code> would ensure the field attributes were derived from the 
 *  "street" field of the 'Address' dataSource.
 *  <P>
 *  dataPaths are also cumulative. In other words if a component has a specified dataPath, 
 *  the dataPath of any fields it contains will be appended to that component level path when
 *  accessing data. For example the following form:
 *  <pre>
 *       isc.DynamicForm.create({
 *           dataPath:"contact",
 *           fields:[
 *               {dataPath:"address/email"}
 *           ]
 *  </pre>
 *  Might be used to edit a data structure similar to this:
 *  <pre>{contact:{name:'Ed Jones', address:{state:"CA", email:"ed@ed.jones.com"}}}</pre>
 *  Nested canvases can also have dataPaths specified, which will similarly be combined. See
 * the {@link com.smartgwt.client.widgets.Canvas#getDataPath dataPath} attribute for more information and examples of this.
 */
public interface DataPath  {
}
        
