
package com.smartgwt.client.docs;

/**
 * <h3>Component XML</h3>
 * 
 *  
 *  Component XML is an XML format for declaring Smart GWT components and screen definitions.
 *  Available with Smart GWT Pro and above, Component XML is the same format used by Visual
 *  Builder to save screens.  
 *  <P>
 *  By allowing you to keep layout information and property settings in an XML format, Component
 *  XML enables non-developers to build and maintain portions of your application, either by
 *  editing screens within Visual Builder or by directly editing the XML itself.
 *  <P>
 *  Unlike the similar GWT "UIBinder" technology, Component XML does not require a compilation
 *  step.  XML screen definitions can be generated on the fly, modified at runtime, stored in a
 *  database, and in all other ways treated as a dynamic resource.  See the section "Dynamic
 *  Component XML" for details.
 *  <P>
 *  <h3>Basic Usage</h3>
 *  <P>
 *  To create a Smart GWT component in XML code, you create a tag with the component's class
 *  name. You can set that component's properties either as tag attributes:
 *  <pre>
 *    &lt;Button title="Click me" width="200" /&gt;
 *  </pre>
 *  or in nested tags:
 *  <pre>
 *    &lt;Button&gt; 
 *      &lt;title&gt;Click me&lt;/title&gt;
 *      &lt;width&gt;200&lt;/width&gt;
 *    &lt;/Button&gt; 
 *  </pre>
 *  <P>
 *  To set a property that is an Array of simple types (like int, or String), repeat tags like
 *  so (for {@link com.smartgwt.client.widgets.form.DynamicForm#getColWidths colWidths}):
 *  <P>
 *  <pre>
 *  &lt;DynamicForm&gt;
 *      &lt;numCols&gt;2&lt;/numCols&gt;
 *      &lt;colWidths&gt;250&lt;/colWidths&gt;
 *      &lt;colWidths&gt;*&lt;/colWidths&gt;
 *  &lt;/DynamicForm&gt;
 *  </pre>
 *  To set a property that takes an Array of complex objects, use the property name as a
 *  container tag, then create further nested tags for the objects in the array, like so (for
 *  {@link com.smartgwt.client.widgets.grid.ListGrid#getFields fields}):
 *  <P>
 *  <pre>
 *  &lt;ListGrid&gt;
 *      &lt;fields&gt;
 *          &lt;ListGridField name="accountName" ... /&gt;
 *          &lt;ListGridField name="accountType" ... /&gt;
 *      &lt;/fields&gt;
 *  &lt;/ListGrid&gt;
 *  </pre>
 *  <P>
 *  This same approach works for creating nested layouts, such as placing a ListGrid in a
 *  VLayout:
 *  <P> 
 *  <pre>
 *  &lt;VLayout&gt;
 *      &lt;members&gt;
 *          &lt;ListGrid .. /&gt;
 *      &lt;/members&gt;
 *  &lt;VLayout&gt;
 *  </pre>
 *  <P>
 *  
 *  <b>Referring to previously defined components</b>
 *  <P>
 *  To refer to another component by ID in XML, use &lt;Canvas ref=/&gt;.  For example:
 *  <pre>
 *  &lt;Canvas ID="myCanvas"/&gt;
 *  &lt;Canvas ID="myCanvas2"/&gt;
 *  &lt;VLayout&gt;
 *      &lt;members&gt;
 *          &lt;Canvas ref="myCanvas"/&gt;
 *          &lt;Canvas ref="myCanvas2"/&gt;
 *      &lt;/members&gt;
 *  &lt;/VLayout&gt;
 *  </pre>
 *  <P>
 *  <h3>Loading screens stored in Component XML</h3>
 *  <P>
 *  Save your Component XML as a file called <i>screenName</i>.ui.xml under
 *  <i>webroot</i>/shared/ui/.  Placing your .ui.xml file in this directory makes it visible to
 *  the system; the location of this directory can be configured in server.properties by setting
 *  the <i>project.ui</i> property.  <i>screenName</i> can be any valid identifier (no spaces,
 *  dashes or periods - underscores OK).
 *  <P>
 *  If you have multiple top-level tags (eg, your code is similar to the example above under
 *  "Referring to previousy defined components") use &lt;isomorphicXML&gt; as a top-level
 *  container tag - this has no impact on processing and is just an idiom to make your file valid
 *  XML, since XML does not allow multiple top-level tags in a document.
 *  <P>
 *  Component XML screens are then loaded using the ScreenLoaderServlet.  The default SDK comes
 *  with this servlet already registered at 
 *  
 *  <i>projectBase</i>/sc/screenLoader.  If you've modified web.xml
 *  or only included some of the default servlets, you may need to add it now - see the 
 *  
 *  {@link com.smartgwt.client.docs.SgwtEESetup Installation Instructions}.
 *  <P>
 *  To create an application that consists of <i>just</i> the imported mockup, just add a
 *  &lt;script src&gt; tag pointing to the ScreenLoader servlet and referring to the
 *  <i>screenName</i> you used when you saved your file.  
 *  
 *  
 *  For example, add the following to your bootstrap .html file:
 *  <pre>
 *     &lt;script src="sc/screenLoader?screenName=<i>screenName</i>"&gt;&lt;/script&gt;
 *  </pre>
 *  
 *  If you want to load screens dynamically, or if you want to load more than one screen, use
 * {@link com.smartgwt.client.rpc.RPCManager#loadScreen RPCManager.loadScreen}.  See the section
 * on "Multiple screens and global IDs"
 *  below.
 *  <P>
 *  
 *  <P>
 *  <h3>Event Handlers &amp; Scripting loaded components</h3>
 *  <P>
 *  You can retrieve the components in your loaded screen in order to add event handlers to
 *  them, call APIs on them, place them into layouts you programmatically create, and in general
 * add dynamic behavior.  Retrieve the components via the {@link
 * com.smartgwt.client.widgets.Canvas#getGetByID getByID} API
 *  (note, when working with multiple screens, be sure to see the upcoming section about managing
 *  global IDs).
 *  <P>
 *  You can then add event handlers normally.  For example, say there is a ListGrid with ID
 *  "mainGrid" and a DynamicForm with ID "editForm" in the same screen, and you want to populate
 *  the form with whatever record is clicked on in the grid:
 *  <P>
 *  
 *  
 *  <pre>
 *    ListGrid grid = (ListGrid)Canvas.getByID("mainGrid");
 *    final DynamicForm form = (DynamicForm)Canvas.getByID("editForm");
 *    grid.addRecordClickHandler(new RecordClickHandler() {
 *        public void onRecordClick(RecordClickEvent event) {
 *            form.editRecord(event.getRecord());  
 *        }
 *    });
 *  </pre>
 *  
 *  <P>
 *  You can also add a loaded screen to an existing layout container.  For example, perhaps you've
 * already written parts of the application via normal coding techniques, and now you want to take
 *  a screen defined in Component XML and place it in a particular Layout you've already created
 * ("existingLayout" below) - just use {@link com.smartgwt.client.widgets.layout.Layout#addMember
 * Layout.addMember} as usual:
 *  
 *  <pre>
 *     existingLayout.addMember(Canvas.getById("<i>componentId</i>"));
 *  </pre>
 *  
 *  
 * Component XML files can also refer to components you have created programmatically, and
 * incorporate
 * them into layouts.  For example, if you have created a ListGrid component with ID "theGrid",
 * you could
 * refer to that grid using a <code>&lt;Canvas ref=""/&gt;</code> tag, which can be used anywhere
 * a
 *  Canvas is expected.  For example:
 *  <pre>
 *  &lt;VLayout ... &gt;
 *      &lt;members&gt;
 *            &lt;Canvas ref="theGrid"/&gt;
 *      &lt;/members&gt;
 *  &lt;/VLayout&gt;
 *  </pre>
 *  Note that this approach requires that the referenced component has been created <b>before</b>
 *  <code>loadScreen</code> is called.
 *  <P>
 *  <h3>Component XML and global IDs</h3>
 *  <P>
 *  A Component XML screen created in Visual Builder or via the
 * {@link com.smartgwt.client.docs.BalsamiqImport Balsamiq importer} will assign global IDs to all
 * components
 *  generated from your mockup so that you can retrieve them by ID to add event handlers and
 *  call APIs.   However if you build an application out of multiple screens built at different
 *  times, these IDs can collide, which will cause components to overwrite each other as they
 *  each try to use the same ID.
 *  <P>
 * To solve this, the {@link com.smartgwt.client.rpc.RPCManager#loadScreen RPCManager.loadScreen}
 * API will <i>ignore</i> global IDs on loaded
 *  components, assigning them sequential generated IDs instead (which will never collide). 
 *  Instead of using global IDs, the callback for <i>loadScreen()</i> will automatically provide
 *  you with the outermost component of a loaded screen, and that outermost component will
 * provide access to other components by their original IDs via {@link
 * com.smartgwt.client.widgets.Canvas#getByLocalId Canvas.getByLocalId}.
 *  <P>
 *  This allows you to add loaded screens to existing layouts, attach event handlers and take
 *  other programmatic actions, all without ever establishing global IDs.
 *  <P>
 *  <h3>Loading multiple screens</h3>
 *  <P>
 *  A typical application that uses screens stored in Component XML will have several such
 * screens, or in some cases, hundreds or thousands.  {@link
 * com.smartgwt.client.rpc.RPCManager#cacheScreens RPCManager.cacheScreens} can be
 *  used to load a set of screen definitions without actually creating any UI components - a
 * subsequent call to {@link com.smartgwt.client.rpc.RPCManager#createScreen
 * RPCManager.createScreen} is used to actually create the screen
 *  when needed.  These two APIs provide the same global ID management facilities as
 *  {@link com.smartgwt.client.rpc.RPCManager#loadScreen loadScreen()}.
 *  <P>
 * As discussed in the {@link com.smartgwt.client.docs.SmartArchitecture Smart GWT Architecture
 * overview}, screen
 *  definitions are typically very small, and should be loaded entirely up front or in very
 *  large batches.  Further, screen <i>definitions</i> have essentially negligible runtime
 *  overhead until the screen is actually created.
 *  <P>
 *  Therefore, use the following best practices for screen loading, even if you have very few or
 *  only one screen defined in Component XML:
 *  <ul>
 * <li> at application startup, load all screens using {@link
 * com.smartgwt.client.rpc.RPCManager#cacheScreens RPCManager.cacheScreens}
 *  <li> create screens lazily (when they are about to be shown to the end user) using
 *       {@link com.smartgwt.client.rpc.RPCManager#createScreen RPCManager.createScreen}.
 *  <li> for applications with very very large numbers of screens where loading all screen
 *       definitions up front creates a very large download, consider multiple calls to
 *       <code>cacheScreens()</code>, loading sets of screens that are likely to be used
 *       together.
 *  </ul>
 *  <P>
 *  <h3>Dynamic Component XML</h3>
 *  <P>
 *  There are two additional ways to load Component XML screens - you can create a .jsp that
 *  uses the JSP tags that come with the SDK:
 *  <pre>
 *     &lt;%@ taglib uri="/WEB-INF/iscTaglib.xml" prefix="isomorphic" %&gt;
 *     &lt;isomorphic:XML&gt;
 *        ... Component XML ...
 *     &lt;/isomorphic:XML&gt;
 *  </pre>
 *  <P>
 *  Or you can use the server-side API com.isomorphic.XML.toJS():
 *  <pre>
 *      XML.toJS("&lt;isomorphicXML xmlns:xsi=\"nativeType\"&gt;" +
 *                   componentXMLCode +                                 
 *                   "&lt;/isomorphicXML&gt;");
 *  </pre>
 *  The JSP code above and the programmatic call to XML.toJS() both return a JavaScript code,
 * which is the response that {@link com.smartgwt.client.rpc.RPCManager#loadScreen
 * RPCManager.loadScreen} expects.  The
 *  <code>XML.toJS()</code> API can be easily combined with 
 * {@link com.smartgwt.client.docs.StandaloneDataSourceUsage direct use of the server-side
 * DataSource API} to build
 *  a version of the ScreenLoaderServlet that can retrieve Component XML from a database
 *  or any Java API.
 *  <P>
 *  For static Component XML screens (cannot be changed at runtime), you can optionally run the
 *  XML.toJS() process as a build step to save a small amount of runtime overhead in XML to JS
 * translation.  Use {@link com.smartgwt.client.rpc.RPCManager#loadScreen RPCManager.loadScreen}
 * to load the resulting JavaScript by
 * overriding the {@link com.smartgwt.client.rpc.RPCRequest#getActionURL actionURL} to point to
 * the generated JavaScript file.
 *  Note that the overhead is minor enough that this is not worth doing unless you have a very
 *  large deployment and a very large number of static Component XML files.
 *  <P>
 *  <h3>Troubleshooting</h3>
 *  <P>
 *  XML parsing errors, which happen when XML is not well-formed and would be rejected by any
 *  standard XML parser, are reported in the server-side log, and, when possible, also in the
 *  client-side log within the "Results" tab of the Developer Console.
 *  <P>
 * If you are loading a screen via the {@link com.smartgwt.client.rpc.RPCManager#loadScreen
 * RPCManager.loadScreen} API, you can see the
 *  response from the server in the RPC tab of the Developer Console - this will show you issues
 *  such as a misplaced ScreenLoaderServlet (HTTP response code will be 404 - Not Found) or
 *  responses that contain server exception details instead of the expected JavaScript response.
 *  <P>
 *  
 *  <P>
 *  You can also use the "Eval XML" section in the "Results" tab of the Developer Console to
 *  interactively experiment with Component XML ("Eval XML" button) and as a means of seeing the
 *  generated JavaScript ("Show JS" button).
 *  <P>
 *  <h3>Localization / Internationalization</h3>
 *  <P>
 *  Component XML files support embedding references to messages loaded from ResourceBundles via
 *  the same JSTL-like &lt;fmt&gt; syntax as is used for DataSource .ds.xml files.  See
 *  {@link com.smartgwt.client.docs.DataSourceLocalization DataSource localization for details}.
 *  <P>
 *  
 * 
 *  
 *  <h3>Custom Components</h3>
 *  <p>
 * If you define a new component class <code>com.mycompany.MyListGrid</code> which is a subclass
 * of the
 * built-in component <code>ListGrid</code>, and you {@link com.smartgwt.client.docs.Reflection
 * register your class for reflection},
 *  you can create it in XML as shown below:
 *  <pre>
 *     &lt;ListGrid constructor="com.mycompany.MyListGrid" width="500"/&gt;
 *  </pre>
 *  <p>
 *  By using the &lt;ListGrid&gt; tag you advertise that properties should be interpreted 
 *  as <code>ListGrid</code> properties.  By specifying <code>constructor</code>
 *  you tell SmartGWT what class to create. 
 *  <p>
 *  <h3>Custom Properties</h3>
 *  <p>
 *  Your custom component (e.g. <code>com.mycompany.MyListGrid</code>) may have additional
 *  properties which are not present in the standard superclass (e.g. <code>ListGrid</code>).
 *  You can set such properties in XML as if they were pre-defined properties:
 *  <pre>
 *     &lt;ListGrid constructor="com.mycompany.MyListGrid" myProperty="false"/&gt;
 *  </pre>
 *  <p>
 *  In this case, the {@link com.smartgwt.client.bean.BeanFactory} code
 *  will ultimately call <code>MyListGrid.setMyProperty(false);</code> in order
 *  to set the property. Since <code>BeanFactory</code> knows that the property
 *  takes a boolean, it will automatically convert the string value "false" to a
 *  boolean, using the type conversions described below.
 *  <p>
 *  Instead of relying on the automatic type conversions, you can force a
 *  property to be interpreted as a given type by using the "xsi:type"
 *  attribute:
 *  <pre>
 *  &lt;ListGrid&gt;
 *      &lt;constructor&gt;com.mycompany.MyListGrid&lt;/constructor&gt;
 *      &lt;myProperty xsi:type="xsd:boolean"&gt;false&lt;/myProperty&gt;
 *  &lt;/ListGrid&gt;
 *  </pre>
 *  <p>
 *  The same notation works when you want to declare that an entire subobject has a given type.
 *  For example, this would cause the custom property "myListGrid" to have a live
 * {@link com.smartgwt.client.widgets.grid.ListGrid} instance as its value.  All of the properties
 * on the &lt;myListGrid&gt; tag
 *  will be correctly interpreted as ListGrid properties and have the correct types.
 *  <pre>
 *  &lt;Canvas&gt;
 *      &lt;myListGrid xsi:type="ListGrid" width="500" height="600"/&gt;
 *  &lt;/Canvas&gt;
 *  </pre>
 *  <p>
 *  For your reference: "xsi" stands for "XML Schema Instance"; this notation derives from XML
 *  Schema standards for explicitly specifying type inline.
 *  <p>
 *  <h3>Component Schema</h3>
 *  <p>
 *  Instead of using the <code>constructor</code> and <code>xsi:type</code> attributes for
 * custom components and custom properties, you can create a {@link
 * com.smartgwt.client.docs.ComponentSchema} that
 *  describes the custom component.  Declaring a component schema allows you to use your
 *  component just like the built-in SmartGWT components, and also allows your component to
 *  be used within {@link com.smartgwt.client.docs.VisualBuilder}.
 *  <p>
 *  <h3>Type Conversions</h3>
 *  <p>
 *  The {@link com.smartgwt.client.bean.BeanFactory} code
 *  uses a reflection-like mechanism to discern the type which a SmartGWT
 *  property requires, and automatically
 *  converts supplied values to the required type when possible. In cases where
 *  conversion is impossible, an {@link IllegalArgumentException} is
 *  thrown.
 *  <p>
 *  Where the setter for a property takes a <b>primitive type</b> (boolean,
 *  double, float, int, or long), any "null" value supplied will be converted to
 *  0 (for the numeric types) or false (for boolean). Conversely, if the setter
 *  takes the boxed version of the type (Boolean, Double, etc.), any primitive
 *  value supplied will be auto-boxed. Note that byte, short and char properties
 *  are not currently handled.
 *  <p>
 *  Properties which take <b>numeric types</b> will convert other numeric
 *  types, as well as strings, using standard Java APIs (e.g.
 *  <code>Integer.valueOf()</code>).  Boolean "true" will be converted to 1, and false to 0.
 *  If the supplied value cannot be converted to the numeric type, an
 *  {@link IllegalArgumentException} will be thrown.
 *  <p>
 *  Properties which take a <b>Date</b> type will convert from strings using
 *  {@link com.smartgwt.client.util.DateUtil#parseInput(String)}.
 *  <p>
 * Properties which take <b>Enum</b> types will convert from strings using
 * <code>Enum.valueOf()</code>.
 *  However, any dashes ("-") in the string will be converted to underscores, and
 *  the string will be converted to upper-case if necessary. If the string does not match
 *  one of the <code>Enum</code> values, an {@link IllegalArgumentException} will be thrown.
 *  <p>
 *  Properties which take <b>Array</b> types will convert arrays where the individual
 *  values can be converted to the appropriate type. If a single value is supplied,
 *  it will be wrapped in an array.
 * 
 */
public interface ComponentXML {
}
