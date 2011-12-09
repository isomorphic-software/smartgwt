
package com.smartgwt.client.docs;

/**
 * <h3>Visual Builder</h3>
 * The Smart GWT Visual Builder tool, accessible from the SDK Explorer as Tools->Visual
 *  Builder, is intended for:
 *  <ul>
 *  <li> business analysts and others doing functional application design, who want to create
 *  functional prototypes in a codeless, "what you see is what you get" environment
 *  <li> developers new to Smart GWT who want to get a basic familiarity with component
 *  layout, component properties and Smart GWT code structure
 *  <li> developers building simple applications that can be completed entirely within Visual
 *  Builder
 *  </ul>
 *  <P>
 *  <h4>Using Visual Builder</h4>
 *  <P>
 *  Basic usage instructions are embedded in Visual Builder itself, in the "About Visual
 *  Builder" pane.  Click on it to open it.
 *  <P>
 *  <b>Visual Builder for Functional Design</b>
 *  <P>
 *  Visual Builder has several advantages over other tools typically used for functional design:
 *  <ul>
 *  <li> Visual Builder allows simple drag and drop manipulation of components, form-based
 *  editing of component properties, and simple connection of events to actions - all without
 *  requiring any code to be written.  It is actually simpler to use than
 *  DreamWeaver or other code-oriented prototyping tools
 *  <li> because Visual Builder generates clean code, designs will not have to be converted to
 *  another technology before development can proceed.  This reduces both effort and the
 *  potential for miscommunication
 *  <li> developers can add custom skinning, components with custom behaviors, and custom
 *  DataSources with sample datasets to Visual Builder so that the design environment is an even
 *  closer match to the final application.  This helps eliminate many types of unimplementable
 *  designs 
 *  <li> because Visual Builder is built in Smart GWT itself, Visual Builder is simply a 
 *  web page, and does not require installation.  Visual Builder can be deployed to 
 *  an internal network to allow teams with a mixture of technical and semi-technical 
 *  users to collaboratively build and share prototypes of Smart GWT-based applications.  
 *  </ul>
 *  <P>
 *  <b>Loading and Saving</b>
 *  <P>
 *  The "File" menu within Visual Builder allows screens to be saved and reloaded for further
 *  editing.  Saved screens <b>can</b> be edited outside of Visual Builder and successfully
 *  reloaded, however, as with any design tool that provides a drag and drop, dialog-driven
 *  approach to screen creation, Visual Builder cannot work with entirely free-form code.  In
 *  particular, when a screen is loaded and then re-saved:
 *  <ul>
 *  <li> any indenting or spacing changes are not preserved 
 *  <li> order of property or method definitions will revert to Visual Builder's default
 *  <li> while method definitions on components are preserved, any code <b>outside of</b>
 *       component definitions will be dropped (in some cases adding such code will cause
 *       loading to fail)
 *  <li> each Canvas-based component will be output separately, in the order these components
 *       appear in the project tree, deepest first
 *  </ul>
 *  Generally speaking, screen definitions that you edit within Visual Builder should consist of
 *  purely declarative code.  Rather than appearing in screen definitions, custom components and
 *  JavaScript libraries should be added to Visual Builder itself via the customization
 *  facilities described below.
 *  <P>
 *  <h4>Installing Visual Builder</h4>
 *  <P>
 *  Visual Builder comes already installed and working in the SDK, and can be used from there out
 *  of the box.  This is the simplest thing to do during initial prototyping.
 *  <P>
 *  Further on in the development cycle, it may be advantageous to have Visual Builder available 
 *  outside the SDK, for example in your test environment.  Installing Visual Builder into 
 *  such an environment is very easy:
 *  <ul>
 *  <li>Perform a normal installation procedure, as discussed {@link iscInstall here}</li>
 *  <li>Copy the following .jar files from the SDK <code>lib</code> folder to the target 
 *  <code>WEB-INF/lib</code> folder: 
 *  <ul>
 *  <li><code>isomorphic_tools.jar</code></li>
 *  <li><code>isomorphic_sql.jar</code></li>
 *  <li><code>isomorphic_hibernate.jar</code></li>
 *  </ul></li>
 *  <li>Copy the SDK <code>tools</code> folder to the target application root</li>
 *  <li>Add the following line to the end of <code>WEB-INF/server.properties</code>:
 *  <ul>
 *  <li><code>FilesystemDataSource.enabled: true</code></li>
 *  </ul>
 *  </li>
 *  </ul>
 *  Note that it is safe to include Visual Builder even in a production environment, so long 
 *  as you ensure that the <code>tools</code> folder is protected with any normal HTTP
 *  authentication/authorization mechanism - for example, an authentication filter.
 *  <P>
 *  <h4>Customizing Visual Builder</h4>
 *  <P>
 *  The rest of this topic focuses on how Visual Builder can be customized and deployed by
 *  developers to make it more effective as a functional design tool for a particular
 *  organization.
 *  <P>
 *  <b>Adding Custom DataSources to Visual Builder</b>
 *  <P>
 *  DataSources placed in the project dataSources directory ([webroot]/shared/ds by default)
 *  will be detected by Visual Builder whenever it is started, and appear in the DataSource
 *  listing in the lower right-hand corner automatically.
 *  <P>
 *  If you have created a custom subclass of DataSource (eg, as a base class for several
 *  DataSources that contact the same web service), you can use it with Visual Builder by:
 *  <ul>
 *  <li> creating an XML version of the DataSource using the XML tag &lt;DataSource&gt; and the
 *  <code>constructor</code> property set to the name of your custom DataSource subclass (as
 *  described {@link com.smartgwt.client.docs.ComponentXML} under the heading <i>Custom Components</i>)
 *  <li> modifying [webroot]/tools/visualBuilder/globalDependencies.xml to load the JavaScript
 *  code for your custom DataSource class.  See examples in that file.
 *  </ul>
 *  <P>
 *  <b>Adding Custom Components to Visual Builder</b>
 *  <P>
 *  The Component Library on the right hand side of Visual Builder loads component definitions
 *  from two XML files in the [webroot]/tools/visualBuilder directory: customComponents.xml and
 *  defaultComponents.xml.  customComponents.xml is empty and is intended for developers to add
 *  their own components.  defaultComponents.xml can also be customized, but the base version
 *  will change between Smart GWT releases.
 *  <P>
 *  As can be seen by looking at defaultComponents.xml, components are specified using a tree
 *  structure similar to that shown in the 
 * <a href="http://www.smartclient.com/smartgwtee/showcase/#treeLoadXML" target="examples">tree XML loading example</a>. 
 * The properties that can be set on
 *  nodes are:
 *  <ul>
 *  <li> <code>className</code>: name of the Smart GWT Class on which  create() will be
 *  called in order to construct the component.  <code>className</code> can be omitted to create
 *  a folder that cannot be dropped
 *  <li> <code>title</code>: title for the node
 *  <li> <code>defaults</code>: an Object specifying defaults to be passed to
 *   create().
 *  For example, you could add an "EditableGrid" node by using <code>className:"ListGrid"</code>
 *  and specifying:
 *  <pre>
 *  &lt;defaults canEdit="true"/&gt;</pre>
 *  NOTE: if you set any defaults that are not Canvas properties, you need to provide explicit
 *  type as documented under <i>Custom Properties</i> for {@link com.smartgwt.client.docs.ComponentXML}.
 *  <li> <code>children</code>: components that should appear as children in the tree under this
 *  node
 *  <li> <code>icon</code>: icon to show in the Visual Builder component tree (if desired)
 *  <li> <code>iconWidth/Height/Size</code>: dimensions of the icon in pixels ("iconSize" sets
 *  both)
 *  <li> <code>showDropIcon</code>: for components that allow children, whether to show a
 * special drop icon on valid drop (like {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons showDropIcons}).
 *  </ul>
 *  <P>
 *  In order to use custom classes in Visual Builder, you must modify
 *  <code>[webroot]/tools/visualBuilder/globalDependencies.xml</code> to include:
 *  <ul>
 *  <li> the JavaScript class definition for the custom class (in other words, the
 *  {@link com.smartgwt.client.util.isc#defineClass defineClass()} call)
 *  <li> a {@link com.smartgwt.client.docs.ComponentSchema component schema} for the custom component
 *  </ul>
 *  See globalDependencies.xml for examples.
 *  <P>
 *  <h4>Component Schema and Visual Builder</h4>
 *  <P>
 *  When you provide {@link com.smartgwt.client.docs.ComponentSchema custom schema} for a component, Visual Builder
 *  uses that schema to drive component editing (Component Properties pane) and to drive drag
 *  and drop screen building functionality.
 *  <P>
 *  <b>Component Editing</b>
 *  <P>
 *  Newly declared fields will appear in the Component Editor in the "Other" category at the
 *  bottom by default.  You can create your own category by simply setting field.group to the
 *  name of a new group and using this on multiple custom fields.
 *  <P>
 *  The ComponentEditor will pick a FormItem for a custom field by the
 *  {@link com.smartgwt.client.types.FormItemType same rules} used for ordinary databinding, including the ability to
 *  set field.editorType to use a custom FormItem.
 *  <P>
 *  When the "Apply" button is clicked, Visual Builder will look for an appropriate "setter
 *  function" for the custom field, for example, for a field named "myProp", Visual Builder will
 *  look for "setMyProp".  The target component will also be {@link com.smartgwt.client.widgets.Canvas#redraw redrawn}.
 *  <P>
 *  <b>Event -&gt; Action Bindings</b>
 *  <P>
 *  The Component Properties pane contains an Events tab that allows you wire components events
 *  to actions on any other component currently in the project.
 *  <P>
 *  Events are simply {@link com.smartgwt.client.docs.StringMethods StringMethods} defined on the component.  In
 *  order to be considered events, method definitions must have been added to the class via
 *   Class.registerStringMethods and either be publicly documented Smart GWT methods or,
 *  for custom classes, have a methods definition in the {@link com.smartgwt.client.docs.ComponentSchema component
 *  schema}.
 * Examples of events are: {@link com.smartgwt.client.widgets.grid.ListGrid#addRecordClickHandler ListGrid.recordClick} and
 * {@link com.smartgwt.client.widgets.form.DynamicForm#addItemChangeHandler DynamicForm.itemChange}.
 *  <P>
 *  Actions are methods on any component that have a method definition in the
 *  {@link com.smartgwt.client.docs.ComponentSchema component schema} and specify action="true".
 *  <P>
 *  All available events (stringMethods) on a component are shown in the Events tab of the
 *  Component Editor.  Clicking the plus (+) sign next to the event name brings up a menu that
 *  shows a list of all components currently in the project and their available actions.
 *  Selecting an action from this submenu binds the action to the selected event.  When an event
 *  is bound to an action in this manner, automatic type matching is performed to pass arguments
 *  from the event to the action as follows:
 *  <ul>
 *  <li>Only non-optional parameters of the action are bound.
 *  <li>For each non-optional parameter of the action method, every parameter of the
 *  event method is inspected in order to either directly match the type (for non-object types)
 *  or to match an isAssignableFrom type check via a Smart GWT schema inheritance check.
 *  <li>The 'type' of a parameter is determined from the type documented in the Smart GWT
 *  reference for built-in components, or from the <code>type</code> attribute on the method
 *  param in the {@link com.smartgwt.client.docs.ComponentSchema component schema} definition of a custom component.
 *  <li>When a matching parameter is found, it is assigned to the current slot of the action and
 *  not considered for further parameter matching.
 *  <li>The above pattern is repeated until all non-optional parameters are exhausted, all
 *  event parameters are exhausted, or until no further type matches can be inferred.
 *  </ul>
 *  The "actionBinding" log category can be enabled in the Developer Console to troubleshoot
 *  issues with automatic binding for custom methods.
 *  <P>
 *  <b>Component Drag and Drop</b>
 *  <P>
 *  Visual Builder uses component schema to determine whether a given drop is allowed and what
 *  methods should be called to accomplish the drop.  For example, any Canvas-based component
 *  can be dropped on a VLayout because VLayout has a "members" field of type "Canvas", and an 
 *  {@link com.smartgwt.client.widgets.layout.Layout#addMember addMember()} function.
 *  <P>
 *  Because of these rules, any subclass of Canvas will be automatically eligible to be dropped
 *  into any container that accepts a Canvas (eg, a Layout or Tab).  Any subclass of a FormItem
 *  will be, likewise, automatically eligible to be dropped into a DynamicForm.
 *  <P>
 *  You can declare custom containment relations, such as a custom class "Wizard" that accepts
 *  instances of the custom class "Pane" by simply declaring a
 *  {@link com.smartgwt.client.docs.ComponentSchema component schema} that says that Wizard has a property called
 *  "panes" of type "Pane".  Then, provide methods that allow components to be added and removed:
 *  <ul>
 *  <li> for a {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple} field, provide "add" and "remove"
 *  functions based on the name of the field.  For example, for a field "panes" of type "Pane",
 *  provide "addPane()" that takes a Pane instance, and "removePane()" that takes a pane
 *  instance or pane ID 
 * <li> for a singular field (such as {@link com.smartgwt.client.widgets.Canvas#getContextMenu contextMenu} or {@link
 * com.smartgwt.client.widgets.tab.Tab#getPane pane}), provide a
 *  setter method named after the field (eg setContextMenu()) that takes either an instance of
 *  the component or null for removal
 *  </ul>
 *  <P>
 *  The "editing" log category can be enabled in the Developer Console to troubleshoot issues
 *  with schema-driven drag and drop and automatic lookup of getter/setter and adder/remover
 *  methods.
 *  <P>
 *  <B>NOTE:</B> after modifying component schema, it may be necessary to restart the servlet
 *  engine and reload Visual Builder
 *  <P>
 *  <b>Presenting simplified components</b>
 *  <P>
 *  Smart GWT components expose many methods and properties.  For some environments, it is
 *  more appropriate to provide a simplified list of properties, events, and actions on either
 *  built-in Smart GWT components or your custom components.  This can be done by providing a
 *  custom {@link com.smartgwt.client.docs.ComponentSchema component schema} for an existing component that exposes
 *  your minimal set.  You also need to provide a trivial subclass of the class you're exposing
 *  so that it can be instantiated.
 *  <P>
 *  For example, let's say you want to make a simplified button called EButton that exposes only
 *  the 'title' property and the 'click' event of a standard Button.  The following steps will
 *  accomplish this:
 *  <p>
 *  1. Edit /tools/visualBuilder/customComponents.xml and add a block similar to the following
 *  to make your custom component appear in the Component Library:
 *  <pre>
 *  &lt;PaletteNode&gt;
 *      &lt;title&gt;EButton&lt;/title&gt;
 *      &lt;className&gt;EButton&lt;/className&gt;
 *      &lt;icon&gt;button.gif&lt;/icon&gt;
 *  &lt;/PaletteNode&gt;
 *  </pre>
 *  2. Next, create a custom schema: /isomorphic/system/schema/EButton.ds.xml as follows:
 *  <pre>
 *  &lt;DataSource ID="EButton" inheritsFrom="Button" Constructor="EButton"
 *              showLocalFieldsOnly="true" showSuperClassActions="false"
 *              showSuperClassEvents="false"&gt;
 *      &lt;fields&gt;
 *          &lt;field name="title"  type="HTML"/&gt;
 *      &lt;/fields&gt;
 *      &lt;methods&gt;
 *          &lt;method name="click"&gt;
 *              &lt;description&gt;Fires when this button is clicked.&lt;/description&gt;
 *          &lt;/method&gt;
 *      &lt;/methods&gt;
 *  &lt;/DataSource&gt;
 *  </pre>
 *  See documentation above and also {@link com.smartgwt.client.docs.ComponentSchema component schema} for what the
 *  properties above do.
 *  3.  Finally, you'll need to define an EButton class as a simple subclass of Button, as
 *  follows:
 *  <pre>
 *  isc.defineClass("EButton", "Button");
 *  </pre>
 *  To make sure that the Visual Builder will load the above definition, you'll need to place it
 *  into a JavaScript file being loaded by the Visual Builder.  If you do not already have
 *  such a file, you can create one and add it to the list of Visual Builder dependencies by
 *  adding an entry in /tools/visualBuilder/globalDependencies.xml.  See examples in that file
 *  for specifics.
 *  <P>
 *  <h4>Deploying Visual Builder for Functional Designers</h4>
 *  <P>
 *  The normal {@link iscInstall} deployment instructions apply to Visual Builder <b>except
 *  that</b> the "BuiltinRPCs", which are configured via server.properties, must be enabled
 *  in order for Visual Builder to load and save files to the Smart GWT server.  This also
 *  means that Visual Builder should only be deployed within trusted environments.  
 *  <P>
 *  Note that the Visual Builder provides a "live" interface to the provided DataSources.  In
 *  other words, if a DataSource supports saving and a designer enables inline editing in a grid,
 *  real saves will be initiated.  The Visual Builder tool should be configured to use the same
 *  sample data that developers use during development.
 */
public interface VisualBuilder {
}
