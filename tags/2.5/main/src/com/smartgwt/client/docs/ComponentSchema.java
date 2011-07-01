
package com.smartgwt.client.docs;

/**
 * <h3>Component Schema</h3>
 * A component schema is a special type of DataSource that describes a custom component.  
 *  <P>
 *  Declaring a component schema for your custom component allows you to:
 *  <ul>
 *  <li> use simpler XML when creating your custom component: avoid having to specify the
 *  <code>constructor</code> and <code>xsi:type</code> attributes as described under
 *  {@link com.smartgwt.client.docs.ComponentXML}
 *  <li> use your custom component within {@link com.smartgwt.client.docs.VisualBuilder}
 *  </ul>
 *  <P>
 *  <b>Example of a Component Schema</b>
 *  <P>
 *  It's most basic form, a component schema for a custom subclass of ListGrid called
 *  "MyListGrid" looks like this:
 *  <pre>
 *  &lt;DataSource serverType="component" ID="MyListGrid" 
 *              inheritsFrom="ListGrid" instanceConstructor="MyListGrid"/&gt;
 *  </pre>
 *  With this definition saved as "MyListGrid.ds.xml" in the project dataSources directory
 *  ([webroot]/shared/ds/ by default), you can now create an instance of MyListGrid with just:
 *  <pre>
 *  &lt;MyListGrid width="500"/&gt;
 *  </pre>
 *  Note: you may need to restart your servlet engine/J2EE container before this example will
 *  work.
 *  <P>
 *  The attributes set directly on the DataSource tag have special meaning for a component
 *  schema definition:
 *  <ul>
 * <li>{@link com.smartgwt.client.docs.serverds.DataSource#serverType serverType}="component" indicates this DataSource
 * describes
 *  a component, as opposed to a SQL table or other data provider
 *  <li>{@link com.smartgwt.client.data.DataSource#getID ID} means the tagName that will be used to create your custom
 *  component.  This must match the first component of the filename (ID="MyListGrid" means the
 *  filename must be MyListGrid.ds.xml) and typically also matches the name of the class.
 * <li>{@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}="ListGrid" inherits the ListGrid property
 * definitions via
 *  {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}.  
 *  <li>instanceConstructor="MyListGrid" indicates the Smart GWT class that
 *   create() should be called on to construct an instance.
 *  <li>showLocalFieldsOnly is a boolean that, when set to true, tells the {@link com.smartgwt.client.docs.VisualBuilder}
 *  to show only the fields declared in this schema in the component editor.  Otherwise fields
 * inherited via {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom} (all the way up the chain) are
 * also included.
 *  <li>showSuperClassEvents is a boolean that, like showLocalFieldsOnly, optionally restricts
 *  the list of events shown in the Events tab of the {@link com.smartgwt.client.docs.VisualBuilder} to those defined in
 *  this schema only.
 *  <li>showSuperClassActions is a boolean that optionally restricts the list of actions shown
 *  in the menu when you map a component Event to a component Action within {@link com.smartgwt.client.docs.VisualBuilder}
 *  to those defined in this schema only.
 *  </ul>
 *  <P>
 *  <b>Declaring custom properties</b>
 *  <P>
 *  Custom properties are declared via {@link com.smartgwt.client.data.DataSource#getFields fields} as for an ordinary
 *  {@link com.smartgwt.client.data.DataSource}.  As with ordinary DataSources, it is legal to redeclare inherited fields
 *  in order to modify properties such as {@link com.smartgwt.client.data.DataSourceField#getEditorType field.editorType}.
 *  <P>
 *  The following DataSourceField properties have special significance when a component schema
 *  is used to process {@link com.smartgwt.client.docs.ComponentXML component XML}:
 *  <ul>
 *  <li> {@link com.smartgwt.client.data.DataSourceField#getType field.type} declares the type of the field, and hence the
 *  type of the JavaScript value your custom class will be initialized with.  In order to
 *  declare subcomponents, can be set to the name of another component (built-in or custom).  
 * <li> {@link com.smartgwt.client.data.DataSourceField#getMultiple field.multiple} declares that the field should always
 * be
 *  array-valued even when only a single value is provided.  Also indicates that the field name
 *  should be used as a "wrapper tag" in the XML format for the component.
 *  <li> {@link com.smartgwt.client.data.DataSourceField#getPropertiesOnly field.propertiesOnly}.  For fields that hold
 * subcomponents, suppresses auto-construction to avoid {@link com.smartgwt.client.widgets.Canvas#getAutoDraw double
 * drawing}
 *  and to allow subcomponents to be modified by their parent component before they are created
 *  and drawn
 *  </ul>
 *  When a component is edited within Visual Builder, the DataSource properties that normally
 *  influence databound forms will influence the Component Editor (for example, field.title,
 *  field.editorType).  In addition, the following properties have special significance in
 *  component editing and component drag and drop:
 *  <ul>
 *  <li> {@link com.smartgwt.client.data.DataSourceField#getInapplicable field.inapplicable} indicates that an inherited
 *  field is inapplicable in this component.
 *  <li> {@link com.smartgwt.client.data.DataSourceField#getGroup field.group} indicates what group the property should be
 *  placed in when editing in Visual Builder.
 *  <li> {@link com.smartgwt.client.data.DataSourceField#getXmlAttribute field.xmlAttribute}: indicates this field should
 *  serialize as an XML attribute.  Note that when constructing the component from XML, either
 *  an attribute or a subelement will continue to be accepted as means of specifying the field
 *  value, so this property is primarily set in order to make code generated by Visual Builder
 *  maximally compact or to make it conform to externally set standards.
 *  </ul>
 *  <P>
 *  <b>Declaring Events and Actions</b>
 *  <P>
 *  Events and Actions are declared via a methods array.  In order for a method to be considered
 *  an event, it needs to have a method definition in the methods array (or be publicly
 *  documented in the Smart GWT reference) and have been added to
 *  the class as a {@link com.smartgwt.client.docs.StringMethods StringMethod} via  Class.registerStringMethods.
 *  <p>
 *  In order for a method to be considered an action, it needs to have a method definition in
 *  the methods array and have the <code>action</code> property set to <code>true</code>.  For
 *  example, the following is a definition of the 'hide' action available on any Canvas, as
 *  copied from Canvas.ds.xml:
 *  <pre>
 *      &lt;methods&gt;
 *          &lt;method name="hide" title="Hide" action="true"/&gt;
 *      &lt;/methods&gt;
 *  </pre>
 *  For custom component actions, an array of expected parameters may be specified using the
 *  <code>params</code> attribute. Each entry in this array should have a specified type.
 *  By doing this, you allow the visual builder to pass parameters through to actions when setting 
 *  up events that call actions (possibly on another component).
 *  For example if you had a component with a custom action that expected to be passed a single
 *  parameter of type {@link com.smartgwt.client.widgets.grid.ListGridRecord} you could define it as follows:
 *  <pre>
 *      &lt;method name="showRecordDetails" title="Show Record Details" action="true"&gt;
 *          &lt;params&gt;
 *              &lt;param type="ListGridRecord"/&gt;
 *          &lt;params&gt;
 *      &lt;/method&gt;
 *  </pre>
 *  If a user working within the visualBuilder then added ListGrid to the page and used the "+" icon
 * to associate the {@link com.smartgwt.client.widgets.grid.ListGrid#addRecordClickHandler recordClick} event with this
 * custom method, the
 *  Visual Builder logic would automatically associate the parameters available in the fired event
 *  (in this case <code>recordClick</code>) with the expected parameters for the action to fire 
 *  by type. So the <code>record</code> parameter of the event (known to be of type 
 *  <code>ListGridRecord</code>) would be passed through to this custom <i>showRecordDetails</i>
 *  action as the first parameter.
 * @see com.smartgwt.client.data.DataSourceField#getXmlAttribute
 * @see com.smartgwt.client.data.DataSourceField#getMultiple
 * @see com.smartgwt.client.data.DataSourceField#getChildTagName
 * @see com.smartgwt.client.data.DataSourceField#getPropertiesOnly
 * @see com.smartgwt.client.data.DataSourceField#getInapplicable
 * @see com.smartgwt.client.data.DataSourceField#getGroup
 */
public interface ComponentSchema {
}
