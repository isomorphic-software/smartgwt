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
/* sgwtgen */
 
/**
 * String specifying a nested data field structure.
 *  <P>
 *  <b>NOTE: the dataPath feature is intended to help certain legacy architectures, 
 *  such as systems that work in terms of exchanging large messages with several different 
 *  entity types in one message, and are incapable of providing separate access to each 
 *  entity type.  Don't use dataPath if this is not your situation.</b>
 *  <P>
 *  <i>
 *  If you are not forced by legacy issues to use hierarchical data structures, 
 *  we recommend:
 *  <ol>
 *   <li>If a subobject exists just to bundle several related fields together, and is 
 *       not a separate entity (cannot be separately created or separately referenced by 
 *       other objects), "flatten" the fields using features such as 
 *       {@link com.smartgwt.client.data.DataSourceField#getValueXPath DataSourceField.valueXPath}.</li>
 *   <li>If a subobject is actually a separate entity, make a DataSource for it and use
 *       operations on that DataSource to load and modify it.
 *       <P>
 *       For example, when representing a sales order with a "deliveryAddress" (consisting of
 *       multiple fields), you'd typically want an "orders" dataSource to define the fields
 *       for the order as a whole, and an "address" dataSource to define the structure of the
 *       deliveryAddress object.
 *       <P>
 *       It may seem like a good idea to work with a single hierarchical order object, where
 *       the "deliveryAddress" attribute is set to a sub-object that matches the structure
 *       defined in the "address" dataSource. DataPaths could be used to extract individual
 *       address fields for editing in a form alongside other fields from the order, and 
 *       edits would be saved via a simple "add" or "update" operation, passing in the 
 *       modified nested data object.
 *       <P>
 *       In fact, this has a number of disadvantages. Since there is no call to the
 *       "update" operation on the "address" subobject, the address will be modified without
 *       the normal features of a dataSource update. You can't specify 
 *       {@link com.smartgwt.client.docs.serverds.DataSource#requiresAuthentication security rules},
 * {@link com.smartgwt.client.docs.DmiOverview DMI} logic, {@link com.smartgwt.client.docs.serverds.DSRequestModifier
 * request modifiers}, 
 *       and no logging or {@link com.smartgwt.client.docs.serverds.DataSource#audit auditing} will run.<br>
 *       The same "bypassing" problem occurs, in perhaps worse form, if a subobject does not yet 
 *       exist and the framework creates it automatically, skipping a DataSource "add" 
 *       operation that may have established defaults, not been allowed for the user, etc.
 *       <P>
 *       Loading and saving nested data objects as a single hierarchical block also offers
 *       no advantages in terms of performance or simplicity.<br>
 * The {@link com.smartgwt.client.rpc.RPCManager#startQueue queuing} system makes it extremely easy to load and save
 * multiple types of 
 *       entities in a single HTTP request, and takes far less code to implement properly as 
 *       multiple DataSource operations, with equivalent or better performance.
 *       <P>
 *       Loading arrays of related objects (such as all LineItems in an Order) as a 
 *       hierarchical object has the further drawback that paging cannot be used for the 
 *       list of related objects, and all such objects will not participate in 
 *       {@link com.smartgwt.client.data.ResultSet automatic cache synchronization}.
 *   </li>
 *  </ol>
 *  In short, we do not recommend structuring your data as a hierarchy of nested data objects
 *  and using dataPath to navigate these structures unless you are forced to by a legacy system 
 *  that doesn't allow separate operations on each entity type.</i>
 *  <P>
 *  <b>How to use dataPaths</b>
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
 *  
 *  
 *  <pre>
 *       DataSource addressDS = new DataSource();
 *       DataSourceField street = new DataSourceField();
 *       street.setName("street");
 *       DataSourceField city = new DataSourceField();
 *       city.setName("city");
 *       DataSourceField state = new DataSourceField();
 *       state.setName("state");
 *       DataSourceField zip = new DataSourceField();
 *       zip.setName("zip");
 *       addressDS.setFields(street, city, state, zip);
 * 
 *       DataSource contactsDS = new DataSource();
 *       DataSourceField name = new DataSourceField();
 *       name.setName("name");
 *       DataSourceField email = new DataSourceField();
 *       email.setName("email");
 *       DataSourceField organization = new DataSourceField();
 *       organization.setName("organization");
 *       DataSourceField phone = new DataSourceField();
 *       phone.setName("phone");
 *       DataSourceField address = new DataSourceField();
 *       address.setName("address");
 *       address.setType(addressDS);
 *       contactsDS.setFields(name, email, organization, phone, address);
 *  </pre>
 *  
 *  and a databound component bound to the 'contacts' dataSource, specifying a field with a dataPath
 *  of <code>"address/street"</code> would ensure the field attributes were derived from the 
 *  "street" field of the 'Address' dataSource.
 *  <P>
 *  dataPaths are also cumulative. In other words if a component has a specified dataPath, 
 *  the dataPath of any fields it contains will be appended to that component level path when
 *  accessing data. For example the following form:
 *  
 *  
 *  <pre>
 *       DynamicForm form = new DynamicForm();
 *       form.setDataPath("contact");
 *       TextItem field1 = new TextItem();
 *       field1.setDataPath("address/email");
 *       form.setFields(field1);
 *  </pre>
 *  
 *  Might be used to edit a data structure similar to this:
 *  <pre>{contact:{name:'Ed Jones', address:{state:"CA", email:"ed@ed.jones.com"}}}</pre>
 *  Nested canvases can also have dataPaths specified, which will similarly be combined. See
 * the {@link com.smartgwt.client.widgets.Canvas#getDataPath Canvas.dataPath} attribute for more information and examples
 * of this.
 */
public interface DataPath  {
}
