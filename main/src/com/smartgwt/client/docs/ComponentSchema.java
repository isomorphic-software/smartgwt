
package com.smartgwt.client.docs;

/**
 * <h3>Component Schema</h3>
 * A component schema is a special type of DataSource that describes a custom component.  &#010 <P>&#010 Declaring a
 * component schema for your custom component allows you to:&#010 <ul>&#010 <li> use simpler XML when creating your custom
 * component: avoid having to specify the&#010 <code>constructor</code> and <code>xsi:type</code> attributes as described
 * under&#010 {@link com.smartgwt.client.docs.ComponentXML}&#010 <li> use your custom component within {@link
 * com.smartgwt.client.docs.VisualBuilder}&#010 </ul>&#010 <P>&#010 <b>Example of a Component Schema</b>&#010 <P>&#010 It's
 * most basic form, a component schema for a custom subclass of ListGrid called&#010 "MyListGrid" looks like this:&#010
 * <pre>&#010 &lt;DataSource serverType="component" ID="MyListGrid" &#010             inheritsFrom="ListGrid"
 * instanceConstructor="MyListGrid"/&gt;&#010 </pre>&#010 With this definition saved as "MyListGrid.ds.xml" in the project
 * dataSources directory&#010 ([webroot]/shared/ds/ by default), you can now create an instance of MyListGrid with
 * just:&#010 <pre>&#010 &lt;MyListGrid width="500"/&gt;&#010 </pre>&#010 Note: you may need to restart your servlet
 * engine/J2EE container before this example will&#010 work.&#010 <P>&#010 The attributes set directly on the DataSource
 * tag have special meaning for a component&#010 schema definition:&#010 <ul>&#010 <li>{@link
 * com.smartgwt.client.data.DataSource#getServerType 'serverType'}="component" indicates this DataSource describes&#010 a
 * component, as opposed to a SQL table or other data provider&#010 <li>{@link com.smartgwt.client.data.DataSource#getID
 * 'ID'} means the tagName that will be used to create your custom&#010 component.  This must match the first component of
 * the filename (ID="MyListGrid" means the&#010 filename must be MyListGrid.ds.xml) and typically also matches the name of
 * the class.&#010 <li>{@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}="ListGrid" inherits the
 * ListGrid property definitions via&#010 {@link com.smartgwt.client.data.DataSource#getInheritsFrom inheritsFrom}.  &#010
 * <li>instanceConstructor="MyListGrid" indicates the Smart GWT class that&#010 {@link com.smartgwt.client..Class#create
 * Class.create} should be called on to construct an instance.&#010 <li>showLocalFieldsOnly is a boolean that, when set to
 * true, tells the {@link com.smartgwt.client..VisualBuilder}&#010 to show only the fields declared in this schema in the
 * component editor.  Otherwise fields&#010 inherited via {@link com.smartgwt.client.data.DataSource#getInheritsFrom
 * inheritsFrom} (all the way up the chain) are also included.&#010 <li>showSuperClassEvents is a boolean that, like
 * showLocalFieldsOnly, optionally restricts&#010 the list of events shown in the Events tab of the {@link
 * com.smartgwt.client..VisualBuilder} to those defined in&#010 this schema only.&#010 <li>showSuperClassActions is a
 * boolean that optionally restricts the list of actions shown&#010 in the menu when you map a component Event to a
 * component Action within {@link com.smartgwt.client..VisualBuilder}&#010 to those defined in this schema only.&#010
 * </ul>&#010 <P>&#010 <b>Declaring custom properties</b>&#010 <P>&#010 Custom properties are declared via {@link
 * com.smartgwt.client.data.DataSource#getFields 'fields'} as for an ordinary&#010 {@link
 * com.smartgwt.client.data.DataSource}.  As with ordinary DataSources, it is legal to redeclare inherited fields&#010 in
 * order to modify properties such as {@link com.smartgwt.client.data.DataSourceField#getEditorType
 * 'field.editorType'}.&#010 <P>&#010 The following DataSourceField properties have special significance when a component
 * schema&#010 is used to process {@link com.smartgwt.client.docs.ComponentXML 'component XML'}:&#010 <ul>&#010 <li> {@link
 * com.smartgwt.client.data.DataSourceField#getType 'field.type'} declares the type of the field, and hence the&#010 type
 * of the JavaScript value your custom class will be initialized with.  In order to&#010 declare subcomponents, can be set
 * to the name of another component (built-in or custom).  &#010 <li> {@link
 * com.smartgwt.client.data.DataSourceField#getMultiple 'field.multiple'} declares that the field should always be&#010
 * array-valued even when only a single value is provided.  Also indicates that the field name&#010 should be used as a
 * "wrapper tag" in the XML format for the component.&#010 <li> {@link
 * com.smartgwt.client.data.DataSourceField#getPropertiesOnly 'field.propertiesOnly'}.  For fields that hold&#010
 * subcomponents, suppresses auto-construction to avoid {@link com.smartgwt.client.widgets.Canvas#getAutoDraw 'double
 * drawing'}&#010 and to allow subcomponents to be modified by their parent component before they are created&#010 and
 * drawn&#010 </ul>&#010 When a component is edited within Visual Builder, the DataSource properties that normally&#010
 * influence databound forms will influence the Component Editor (for example, field.title,&#010 field.editorType).  In
 * addition, the following properties have special significance in&#010 component editing and component drag and drop:&#010
 * <ul>&#010 <li> {@link com.smartgwt.client.data.DataSourceField#getInapplicable 'field.inapplicable'} indicates that an
 * inherited&#010 field is inapplicable in this component.&#010 <li> {@link
 * com.smartgwt.client.data.DataSourceField#getGroup 'field.group'} indicates what group the property should be&#010 placed
 * in when editing in Visual Builder.&#010 <li> {@link com.smartgwt.client.data.DataSourceField#getXmlAttribute
 * 'field.xmlAttribute'}: indicates this field should&#010 serialize as an XML attribute.  Note that when constructing the
 * component from XML, either&#010 an attribute or a subelement will continue to be accepted as means of specifying the
 * field&#010 value, so this property is primarily set in order to make code generated by Visual Builder&#010 maximally
 * compact or to make it conform to externally set standards.&#010 </ul>&#010 <P>&#010 <b>Declaring Events and
 * Actions</b>&#010 <P>&#010 Events and Actions are declared via a methods array.  In order for a method to be
 * considered&#010 an event, it needs to have a method definition in the methods array (or be publicly&#010 documented in
 * the Smart GWT reference) and have been added to&#010 the class as a {@link com.smartgwt.client.docs.StringMethods
 * 'StringMethod'} via {@link com.smartgwt.client..Class#registerStringMethods Class.registerStringMethods}.&#010 <p>&#010
 * In order for a method to be considered an action, it needs to have a method definition in&#010 the methods array and
 * have the <code>action</code> property set to <code>true</code>.  For&#010 example, the following is a definition of the
 * 'hide' action available on any Canvas, as&#010 copied from Canvas.ds.xml:&#010 <pre>&#010     &lt;methods&gt;&#010      
 * &lt;method name="hide" title="Hide" action="true"/&gt;&#010     &lt;/methods&gt;&#010 </pre>&#010 For custom component
 * actions, an array of expected parameters may be specified using the&#010 <code>params</code> attribute. Each entry in
 * this array should have a specified type.&#010 By doing this, you allow the visual builder to pass parameters through to
 * actions when setting &#010 up events that call actions (possibly on another component).&#010 For example if you had a
 * component with a custom action that expected to be passed a single&#010 parameter of type {@link
 * com.smartgwt.client.widgets.grid.ListGridRecord} you could define it as follows:&#010 <pre>&#010     &lt;method
 * name="showRecordDetails" title="Show Record Details" action="true"&gt;&#010         &lt;params&gt;&#010            
 * &lt;param type="ListGridRecord"/&gt;&#010         &lt;params&gt;&#010     &lt;/method&gt;&#010 </pre>&#010 If a user
 * working within the visualBuilder then added ListGrid to the page and used the "+" icon&#010 to associate the {@link
 * com.smartgwt.client.widgets.grid.ListGrid#addRecordClickHandler ListGrid.addRecordClickHandler} event with this custom
 * method, the&#010 Visual Builder logic would automatically associate the parameters available in the fired event&#010 (in
 * this case <code>recordClick</code>) with the expected parameters for the action to fire &#010 by type. So the
 * <code>record</code> parameter of the event (known to be of type &#010 <code>ListGridRecord</code>) would be passed
 * through to this custom <i>showRecordDetails</i>&#010 action as the first parameter.
 * @see com.smartgwt.client.data.DataSourceField#getXmlAttribute
 * @see com.smartgwt.client.data.DataSourceField#getMultiple
 * @see com.smartgwt.client.data.DataSourceField#getChildTagName
 * @see com.smartgwt.client.data.DataSourceField#getPropertiesOnly
 * @see com.smartgwt.client.data.DataSourceField#getInapplicable
 * @see com.smartgwt.client.data.DataSourceField#getGroup
 */
public interface ComponentSchema {
}
