
package com.smartgwt.client.docs;

/**
 * <h3>Visual Builder</h3>
 * The Smart GWT Visual Builder tool, accessible from the SDK Explorer as Tools->Visual&#010 Builder, is intended for:&#010
 * <ul>&#010 <li> business analysts and others doing functional application design, who want to create&#010 functional
 * prototypes in a codeless, "what you see is what you get" environment&#010 <li> developers new to Smart GWT who want to
 * get a basic familiarity with component&#010 layout, component properties and Smart GWT code structure&#010 <li>
 * developers building simple applications that can be completed entirely within Visual&#010 Builder&#010 </ul>&#010
 * <P>&#010 <h4>Using Visual Builder</h4>&#010 <P>&#010 Basic usage instructions are embedded in Visual Builder itself, in
 * the "About Visual&#010 Builder" pane.  Click on it to open it.&#010 <P>&#010 <b>Visual Builder for Functional
 * Design</b>&#010 <P>&#010 Visual Builder has several advantages over other tools typically used for functional
 * design:&#010 <ul>&#010 <li> Visual Builder allows simple drag and drop manipulation of components, form-based&#010
 * editing of component properties, and simple connection of events to actions - all without&#010 requiring any code to be
 * written.  It is actually simpler to use than&#010 DreamWeaver or other code-oriented prototyping tools&#010 <li> because
 * Visual Builder generates clean code, designs will not have to be converted to&#010 another technology before development
 * can proceed.  This reduces both effort and the&#010 potential for miscommunication&#010 <li> developers can add custom
 * skinning, components with custom behaviors, and custom&#010 DataSources with sample datasets to Visual Builder so that
 * the design environment is an even&#010 closer match to the final application.  This helps eliminate many types of
 * unimplementable&#010 designs &#010 <li> because Visual Builder is built in Smart GWT itself, Visual Builder is simply a
 * &#010 web page, and does not require installation.  Visual Builder can be deployed to &#010 an internal network to allow
 * teams with a mixture of technical and semi-technical &#010 users to collaboratively build and share prototypes of Smart
 * GWT-based applications.  &#010 </ul>&#010 <P>&#010 <b>Loading and Saving</b>&#010 <P>&#010 The "File" menu within Visual
 * Builder allows screens to be saved and reloaded for further&#010 editing.  Saved screens <b>can</b> be edited outside of
 * Visual Builder and successfully&#010 reloaded, however, as with any design tool that provides a drag and drop,
 * dialog-driven&#010 approach to screen creation, Visual Builder cannot work with entirely free-form code.  In&#010
 * particular, when a screen is loaded and then re-saved:&#010 <ul>&#010 <li> any indenting or spacing changes are not
 * preserved &#010 <li> order of property or method definitions will revert to Visual Builder's default&#010 <li> while
 * method definitions on components are preserved, any code <b>outside of</b>&#010      component definitions will be
 * dropped (in some cases adding such code will cause&#010      loading to fail)&#010 <li> each Canvas-based component will
 * be output separately, in the order these components&#010      appear in the project tree, deepest first&#010 </ul>&#010
 * Generally speaking, screen definitions that you edit within Visual Builder should consist of&#010 purely declarative
 * code.  Rather than appearing in screen definitions, custom components and&#010 JavaScript libraries should be added to
 * Visual Builder itself via the customization&#010 facilities described below.&#010 <P>&#010 <h4>Installing Visual
 * Builder</h4>&#010 <P>&#010 Visual Builder comes already installed and working in the SDK, and can be used from there
 * out&#010 of the box.  This is the simplest thing to do during initial prototyping.&#010 <P>&#010 Further on in the
 * development cycle, it may be advantageous to have Visual Builder available &#010 outside the SDK, for example in your
 * test environment.  Installing Visual Builder into &#010 such an environment is very easy:&#010 <ul>&#010 <li>Perform a
 * normal installation procedure, as discussed {@link iscInstall here}</li>&#010 <li>Copy the following .jar files from the
 * SDK <code>lib</code> folder to the target &#010 <code>WEB-INF/lib</code> folder: &#010 <ul>&#010
 * <li><code>isomorphic_tools.jar</code></li>&#010 <li><code>isomorphic_sql.jar</code></li>&#010
 * <li><code>isomorphic_hibernate.jar</code></li>&#010 </ul></li>&#010 <li>Copy the SDK <code>tools</code> folder to the
 * target application root</li>&#010 <li>Add the following line to the end of <code>WEB-INF/server.properties</code>:&#010
 * <ul>&#010 <li><code>FilesystemDataSource.enabled: true</code></li>&#010 </ul>&#010 </li>&#010 </ul>&#010 Note that it is
 * safe to include Visual Builder even in a production environment, so long &#010 as you ensure that the <code>tools</code>
 * folder is protected with any normal HTTP&#010 authentication/authorization mechanism - for example, an authentication
 * filter.&#010 <P>&#010 <h4>Customizing Visual Builder</h4>&#010 <P>&#010 The rest of this topic focuses on how Visual
 * Builder can be customized and deployed by&#010 developers to make it more effective as a functional design tool for a
 * particular&#010 organization.&#010 <P>&#010 <b>Adding Custom DataSources to Visual Builder</b>&#010 <P>&#010 DataSources
 * placed in the project dataSources directory ([webroot]/shared/ds by default)&#010 will be detected by Visual Builder
 * whenever it is started, and appear in the DataSource&#010 listing in the lower right-hand corner automatically.&#010
 * <P>&#010 If you have created a custom subclass of DataSource (eg, as a base class for several&#010 DataSources that
 * contact the same web service), you can use it with Visual Builder by:&#010 <ul>&#010 <li> creating an XML version of the
 * DataSource using the XML tag &lt;DataSource&gt; and the&#010 <code>constructor</code> property set to the name of your
 * custom DataSource subclass (as&#010 described {@link com.smartgwt.client.docs.ComponentXML} under the heading <i>Custom
 * Components</i>)&#010 <li> modifying [webroot]/tools/visualBuilder/globalDependencies.xml to load the JavaScript&#010
 * code for your custom DataSource class.  See examples in that file.&#010 </ul>&#010 <P>&#010 <b>Adding Custom Components
 * to Visual Builder</b>&#010 <P>&#010 The Component Library on the right hand side of Visual Builder loads component
 * definitions&#010 from two XML files in the [webroot]/tools/visualBuilder directory: customComponents.xml and&#010
 * defaultComponents.xml.  customComponents.xml is empty and is intended for developers to add&#010 their own components. 
 * defaultComponents.xml can also be customized, but the base version&#010 will change between Smart GWT releases.&#010
 * <P>&#010 As can be seen by looking at defaultComponents.xml, components are specified using a tree&#010 structure
 * similar to that shown in the &#010 <a href="http://www.smartclient.com/smartgwtee/showcase/#treeLoadXML"
 * target="examples">tree XML loading example</a>.  The properties that can be set on&#010 nodes are:&#010 <ul>&#010 <li>
 * <code>className</code>: name of the Smart GWT Class on which  create() will be&#010 called in order to construct the
 * component.  <code>className</code> can be omitted to create&#010 a folder that cannot be dropped&#010 <li>
 * <code>title</code>: title for the node&#010 <li> <code>defaults</code>: an Object specifying defaults to be passed
 * to&#010  create().&#010 For example, you could add an "EditableGrid" node by using
 * <code>className:"ListGrid"</code>&#010 and specifying:&#010 <pre>&#010 &lt;defaults canEdit="true"/&gt;</pre>&#010 NOTE:
 * if you set any defaults that are not Canvas properties, you need to provide explicit&#010 type as documented under
 * <i>Custom Properties</i> for {@link com.smartgwt.client.docs.ComponentXML}.&#010 <li> <code>children</code>: components
 * that should appear as children in the tree under this&#010 node&#010 <li> <code>icon</code>: icon to show in the Visual
 * Builder component tree (if desired)&#010 <li> <code>iconWidth/Height/Size</code>: dimensions of the icon in pixels
 * ("iconSize" sets&#010 both)&#010 <li> <code>showDropIcon</code>: for components that allow children, whether to show
 * a&#010 special drop icon on valid drop (like {@link com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons
 * showDropIcons}).&#010 </ul>&#010 <P>&#010 In order to use custom classes in Visual Builder, you must modify&#010
 * <code>[webroot]/tools/visualBuilder/globalDependencies.xml</code> to include:&#010 <ul>&#010 <li> the JavaScript class
 * definition for the custom class (in other words, the&#010 {@link com.smartgwt.client.util.isc#defineClass defineClass()}
 * call)&#010 <li> a {@link com.smartgwt.client.docs.ComponentSchema component schema} for the custom component&#010
 * </ul>&#010 See globalDependencies.xml for examples.&#010 <P>&#010 <h4>Component Schema and Visual Builder</h4>&#010
 * <P>&#010 When you provide {@link com.smartgwt.client.docs.ComponentSchema custom schema} for a component, Visual
 * Builder&#010 uses that schema to drive component editing (Component Properties pane) and to drive drag&#010 and drop
 * screen building functionality.&#010 <P>&#010 <b>Component Editing</b>&#010 <P>&#010 Newly declared fields will appear in
 * the Component Editor in the "Other" category at the&#010 bottom by default.  You can create your own category by simply
 * setting field.group to the&#010 name of a new group and using this on multiple custom fields.&#010 <P>&#010 The
 * ComponentEditor will pick a FormItem for a custom field by the&#010 {@link com.smartgwt.client.types.FormItemType same
 * rules} used for ordinary databinding, including the ability to&#010 set field.editorType to use a custom FormItem.&#010
 * <P>&#010 When the "Apply" button is clicked, Visual Builder will look for an appropriate "setter&#010 function" for the
 * custom field, for example, for a field named "myProp", Visual Builder will&#010 look for "setMyProp".  The target
 * component will also be {@link com.smartgwt.client.widgets.Canvas#redraw redrawn}.&#010 <P>&#010 <b>Event -&gt; Action
 * Bindings</b>&#010 <P>&#010 The Component Properties pane contains an Events tab that allows you wire components
 * events&#010 to actions on any other component currently in the project.&#010 <P>&#010 Events are simply {@link
 * com.smartgwt.client.docs.StringMethods StringMethods} defined on the component.  In&#010 order to be considered events,
 * method definitions must have been added to the class via&#010  Class.registerStringMethods and either be publicly
 * documented Smart GWT methods or,&#010 for custom classes, have a methods definition in the {@link
 * com.smartgwt.client.docs.ComponentSchema component&#010 schema}.&#010 Examples of events are: {@link
 * com.smartgwt.client.widgets.grid.ListGrid#addRecordClickHandler ListGrid.recordClick} and {@link
 * com.smartgwt.client.widgets.form.DynamicForm#addItemChangeHandler DynamicForm.itemChange}.&#010 <P>&#010 Actions are
 * methods on any component that have a method definition in the&#010 {@link com.smartgwt.client.docs.ComponentSchema
 * component schema} and specify action="true".&#010 <P>&#010 All available events (stringMethods) on a component are shown
 * in the Events tab of the&#010 Component Editor.  Clicking the plus (+) sign next to the event name brings up a menu
 * that&#010 shows a list of all components currently in the project and their available actions.&#010 Selecting an action
 * from this submenu binds the action to the selected event.  When an event&#010 is bound to an action in this manner,
 * automatic type matching is performed to pass arguments&#010 from the event to the action as follows:&#010 <ul>&#010
 * <li>Only non-optional parameters of the action are bound.&#010 <li>For each non-optional parameter of the action method,
 * every parameter of the&#010 event method is inspected in order to either directly match the type (for non-object
 * types)&#010 or to match an isAssignableFrom type check via a Smart GWT schema inheritance check.&#010 <li>The 'type' of
 * a parameter is determined from the type documented in the Smart GWT&#010 reference for built-in components, or from the
 * <code>type</code> attribute on the method&#010 param in the {@link com.smartgwt.client.docs.ComponentSchema component
 * schema} definition of a custom component.&#010 <li>When a matching parameter is found, it is assigned to the current
 * slot of the action and&#010 not considered for further parameter matching.&#010 <li>The above pattern is repeated until
 * all non-optional parameters are exhausted, all&#010 event parameters are exhausted, or until no further type matches can
 * be inferred.&#010 </ul>&#010 The "actionBinding" log category can be enabled in the Developer Console to
 * troubleshoot&#010 issues with automatic binding for custom methods.&#010 <P>&#010 <b>Component Drag and Drop</b>&#010
 * <P>&#010 Visual Builder uses component schema to determine whether a given drop is allowed and what&#010 methods should
 * be called to accomplish the drop.  For example, any Canvas-based component&#010 can be dropped on a VLayout because
 * VLayout has a "members" field of type "Canvas", and an &#010 {@link com.smartgwt.client.widgets.layout.Layout#addMember
 * addMember()} function.&#010 <P>&#010 Because of these rules, any subclass of Canvas will be automatically eligible to be
 * dropped&#010 into any container that accepts a Canvas (eg, a Layout or Tab).  Any subclass of a FormItem&#010 will be,
 * likewise, automatically eligible to be dropped into a DynamicForm.&#010 <P>&#010 You can declare custom containment
 * relations, such as a custom class "Wizard" that accepts&#010 instances of the custom class "Pane" by simply declaring
 * a&#010 {@link com.smartgwt.client.docs.ComponentSchema component schema} that says that Wizard has a property
 * called&#010 "panes" of type "Pane".  Then, provide methods that allow components to be added and removed:&#010 <ul>&#010
 * <li> for a {@link com.smartgwt.client.data.DataSourceField#getMultiple multiple} field, provide "add" and "remove"&#010
 * functions based on the name of the field.  For example, for a field "panes" of type "Pane",&#010 provide "addPane()"
 * that takes a Pane instance, and "removePane()" that takes a pane&#010 instance or pane ID &#010 <li> for a singular
 * field (such as {@link com.smartgwt.client.widgets.Canvas#getContextMenu contextMenu} or {@link
 * com.smartgwt.client.widgets.tab.Tab#getPane pane}), provide a&#010 setter method named after the field (eg
 * setContextMenu()) that takes either an instance of&#010 the component or null for removal&#010 </ul>&#010 <P>&#010 The
 * "editing" log category can be enabled in the Developer Console to troubleshoot issues&#010 with schema-driven drag and
 * drop and automatic lookup of getter/setter and adder/remover&#010 methods.&#010 <P>&#010 <B>NOTE:</B> after modifying
 * component schema, it may be necessary to restart the servlet&#010 engine and reload Visual Builder&#010 <P>&#010
 * <b>Presenting simplified components</b>&#010 <P>&#010 Smart GWT components expose many methods and properties.  For some
 * environments, it is&#010 more appropriate to provide a simplified list of properties, events, and actions on either&#010
 * built-in Smart GWT components or your custom components.  This can be done by providing a&#010 custom {@link
 * com.smartgwt.client.docs.ComponentSchema component schema} for an existing component that exposes&#010 your minimal set.
 * You also need to provide a trivial subclass of the class you're exposing&#010 so that it can be instantiated.&#010
 * <P>&#010 For example, let's say you want to make a simplified button called EButton that exposes only&#010 the 'title'
 * property and the 'click' event of a standard Button.  The following steps will&#010 accomplish this:&#010 <p>&#010 1.
 * Edit /tools/visualBuilder/customComponents.xml and add a block similar to the following&#010 to make your custom
 * component appear in the Component Library:&#010 <pre>&#010 &lt;PaletteNode&gt;&#010    
 * &lt;title&gt;EButton&lt;/title&gt;&#010     &lt;className&gt;EButton&lt;/className&gt;&#010    
 * &lt;icon&gt;button.gif&lt;/icon&gt;&#010 &lt;/PaletteNode&gt;&#010 </pre>&#010 2. Next, create a custom schema:
 * /isomorphic/system/schema/EButton.ds.xml as follows:&#010 <pre>&#010 &lt;DataSource ID="EButton" inheritsFrom="Button"
 * Constructor="EButton"&#010             showLocalFieldsOnly="true" showSuperClassActions="false"&#010            
 * showSuperClassEvents="false"&gt;&#010     &lt;fields&gt;&#010         &lt;field name="title"  type="HTML"/&gt;&#010    
 * &lt;/fields&gt;&#010     &lt;methods&gt;&#010         &lt;method name="click"&gt;&#010            
 * &lt;description&gt;Fires when this button is clicked.&lt;/description&gt;&#010         &lt;/method&gt;&#010    
 * &lt;/methods&gt;&#010 &lt;/DataSource&gt;&#010 </pre>&#010 See documentation above and also {@link
 * com.smartgwt.client.docs.ComponentSchema component schema} for what the&#010 properties above do.&#010 3.  Finally,
 * you'll need to define an EButton class as a simple subclass of Button, as&#010 follows:&#010 <pre>&#010
 * isc.defineClass("EButton", "Button");&#010 </pre>&#010 To make sure that the Visual Builder will load the above
 * definition, you'll need to place it&#010 into a JavaScript file being loaded by the Visual Builder.  If you do not
 * already have&#010 such a file, you can create one and add it to the list of Visual Builder dependencies by&#010 adding
 * an entry in /tools/visualBuilder/globalDependencies.xml.  See examples in that file&#010 for specifics.&#010 <P>&#010
 * <h4>Deploying Visual Builder for Functional Designers</h4>&#010 <P>&#010 The normal {@link iscInstall} deployment
 * instructions apply to Visual Builder <b>except&#010 that</b> the "BuiltinRPCs", which are configured via
 * server.properties, must be enabled&#010 in order for Visual Builder to load and save files to the Smart GWT server. 
 * This also&#010 means that Visual Builder should only be deployed within trusted environments.  &#010 <P>&#010 Note that
 * the Visual Builder provides a "live" interface to the provided DataSources.  In&#010 other words, if a DataSource
 * supports saving and a designer enables inline editing in a grid,&#010 real saves will be initiated.  The Visual Builder
 * tool should be configured to use the same&#010 sample data that developers use during development.
 */
public interface VisualBuilder {
}
