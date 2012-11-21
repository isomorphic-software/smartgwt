	    
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
 *  <P>
 *  <h3>Multiple screens and global IDs</h3>
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
 *  components, assigning them sequential generated IDs instead (which will never collide).  Only 
 * the list of specific global IDs you pass to <code>loadScreen()</code> will be allowed to become
 *  global.
 *  <P>
 *  Therefore when building an application out of multiple screens, the best approach is:
 *  <ul>
 *  <li> always use RPCManager.loadScreen() to load screens; don't use the &lt;script src&gt;
 *  approach as it cannot suppress global IDs
 *  <li> assign meaningful IDs to the components where you will attach event handlers or call
 *  APIs.  Be sure to use search and replace when you do this as the ID may appear multiple places
 *  in the file
 *  <li> when using <code>loadScreen()</code>, pass the list of IDs of components that you will
 *  need to access programmatically
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
 */
public interface ComponentXML {
}
