
package com.smartgwt.client.docs;

/**
 * <h3>Adding Custom Components to Reify</h3>
 * Reify is a web-based visual application builder that enables non-developers to build 
 *  Smart GWT screens, and even build complete applications.
 *  <P>
 *  You can customize Reify by adding your own custom components, and even adding custom 
 *  editors for properties of those components.
 *  <P>
 * The following instructions are for customizing a {@link com.smartgwt.client.docs.ReifyOnSite
 * Reify OnSite} instance. 
 * It's also possible to customize your account at Reify.com - to do that, please contact
 * Isomorphic 
 *  <a href='https://www.reify.com/contactus.jsp' target='_blank'>here</a>.
 *  <P>
 *  <b>Component Library</b>
 *  <P>
 *  Reify has the ability to include new component classes defined in JavaScript, in addition
 *  to the set of components available by default.
 *  <P>
 *  The Component Library on the right hand side of Reify loads component definitions
 *  from two XML files in the [webroot]/tools/visualBuilder directory: customComponents.xml and
 *  defaultComponents.xml.  customComponents.xml is empty and is intended for developers to add
 *  their own components.  defaultComponents.xml can also be customized, but the base version
 *  will change between Smart GWT releases.
 *  <P>
 *  As can be seen by looking at defaultComponents.xml, components are specified using a tree
 *  structure similar to that shown in the 
 * <a href="http://www.smartclient.com/smartgwtee/showcase/#treeLoadXML" target="examples">tree
 * XML loading example</a>.  The properties that can be set on
 *  nodes are:
 *  <ul>
 *  <li> <code>type</code>: name of the Smart GWT Class on which  create() will be
 *  called in order to construct the component.  <code>type</code> can be omitted to create
 *  a folder that cannot be dropped
 *  <li> <code>title</code>: title for the node
 *  <li> <code>defaults</code>: an Object specifying defaults to be passed to
 *   create().
 *  For example, you could add an "EditableGrid" node by using <code>type: "ListGrid"</code>
 *  and specifying:
 *  <pre>
 *  &lt;defaults canEdit="true"/&gt;</pre>
 *  NOTE: if you set any defaults that are not Canvas properties, you need to provide explicit
 * type as documented under <i>Custom Properties</i> for {@link
 * com.smartgwt.client.docs.ComponentXML}.
 *  <li> <code>children</code>: components that should appear as children in the tree under this
 *  node
 *  <li> <code>icon</code>: icon to show in the Reify component tree (if desired)
 *  <li> <code>iconWidth/Height/Size</code>: dimensions of the icon in pixels ("iconSize" sets
 *  both)
 *  <li> <code>showDropIcon</code>: for components that allow children, whether to show a
 * special drop icon on valid drop (like {@link
 * com.smartgwt.client.widgets.tree.TreeGrid#getShowDropIcons TreeGrid.showDropIcons})
 *  <li> and additional properties described on {@link com.smartgwt.client.tools.PaletteNode}.
 *  </ul>
 *  <P>
 *  In order to use custom classes in Reify, you must modify
 *  <code>[webroot]/tools/visualBuilder/globalDependencies.xml</code> to include:
 *  <ul>
 *  <li> the JavaScript class definition for the custom class (in other words, the
 *  {@link com.smartgwt.client.util.isc#defineClass defineClass()} call)
 * <li> a {@link com.smartgwt.client.docs.ComponentSchema component schema} for the custom
 * component
 *  </ul>
 *  See globalDependencies.xml for examples.
 *  <P>
 *  <h4>Component Schema and Reify</h4>
 *  <P>
 * When you provide {@link com.smartgwt.client.docs.ComponentSchema custom schema} for a
 * component, Reify
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
 * {@link com.smartgwt.client.types.FormItemType same rules} used for ordinary databinding,
 * including the ability to
 *  set field.editorType to use a custom FormItem.
 *  <P>
 *  When properties are changed by the user, Reify will look for an appropriate "setter
 *  function" for the custom field, for example, for a field named "myProp", Reify will
 * look for "setMyProp".  The target component will also be {@link
 * com.smartgwt.client.widgets.Canvas#redraw redrawn}.
 *  <P>
 *  <b>Designing Components for Editing & Using Placeholders</b>
 *  <P>
 *  When Reify creates your custom component, no properties are provided at
 *  construction, and all necessary properties will be provided after construction via calling
 *  setter methods (for example, <code>set<i>PropertyName</i></code>) as users assign them
 *  via the Property Sheet.
 *  <p>
 *  Often a custom component has been implemented to expect that certain properties are passed
 *  at construction, and the constructor may crash if they are absent.  Similarly, setters may
 *  not exist for properties assumed to be provided at construction, or may crash.  Any such
 *  errors are caught by Reify and reported under the "componentExceptions" log
 *  category, however, Reify has several features to make it possible to work with
 *  misbehaving components without requiring refactoring.
 *  <p>
 *  If a component requires certain properties before it can be validly created, you can set
 * {@link com.smartgwt.client.tools.PaletteNode#getRequiredProperties
 * PaletteNode.requiredProperties} as a comma-separated list of property names on the
 *  <code>paletteNode</code> for the component, and Reify will use a placeholder until
 *  the designer has provided each of the required properties.  The placeholder will just show
 *  the className of the real component and the list of remaining required properties.  In
 *  order to take up the right amount of space, the placeholder will use the same sizing-related
 *  settings that the real component would use (such as <code>overflow</code> and
 *  <code>defaultWidth</code>).
 *  <p>
 *  If a component lacks appropriate setters for some properties but would work properly if
 * re-created from scratch, in the Component Schema you can set {@link
 * com.smartgwt.client.data.DataSourceField#getRecreateOnChange DataSourceField.recreateOnChange}
 *  on any fields that should cause the component to be re-created. You can also set
 * {@link com.smartgwt.client.tools.PaletteNode#getRecreateOnChange PaletteNode.recreateOnChange}
 * on a <code>paletteNode</code> to cause <b>any</b> property
 *  change to cause the component to be re-created.
 *  <p>
 *  You may also have components that you don't want to try to use within Reify at all.  In
 * this case, just set {@link com.smartgwt.client.tools.PaletteNode#getAlwaysUsePlaceholder
 * PaletteNode.alwaysUsePlaceholder} to true, and Reify will never
 *  try to create the component, and always show a placeholder.  You can also set
 * {@link com.smartgwt.client.tools.PaletteNode#getPlaceholderImage PaletteNode.placeholderImage}
 * to the URL of an image file to use in lieu of the usual
 *  placeholder text.
 *  <p>
 *  Note that when you use the Run within Reify, Placeholders will appear (otherwise
 *  your screen would presumably crash!) - this is because Reify is using the
 * {@link com.smartgwt.client.rpc.LoadProjectSettings#getAllowPlaceholders
 * LoadProjectSettings.allowPlaceholders} option.  If you export a Reify project or
 * {@link com.smartgwt.client.tools.Reify#loadProject load it dynamically},
 * <code>allowPlaceholders</code> will be false,
 *  and your screen will use the real target components.
 *  <P>
 *  <b>Event -&gt; Action Bindings</b>
 *  <P>
 *  The Component Properties pane contains an Events tab that allows you wire components events
 *  to actions on any other component currently in the project.
 *  <P>
 * Events are simply {@link com.smartgwt.client.docs.StringMethods StringMethods} defined on the
 * component.  In
 *  order to be considered events, method definitions must have been added to the class via
 *   Class.registerStringMethods() and either be publicly documented Smart GWT methods or,
 * for custom classes, have a methods definition in the {@link
 * com.smartgwt.client.docs.ComponentSchema component schema}.
 * Examples of events are: {@link com.smartgwt.client.widgets.grid.ListGrid#recordClick
 * ListGrid.recordClick()} and {@link
 * com.smartgwt.client.widgets.form.DynamicForm#addItemChangeHandler DynamicForm.itemChange()}.
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
 * param in the {@link com.smartgwt.client.docs.ComponentSchema component schema} definition of a
 * custom component.
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
 *  Reify uses component schema to determine whether a given drop is allowed and what
 *  methods should be called to accomplish the drop.  For example, any Canvas-based component
 *  can be dropped on a VLayout because VLayout has a "members" field of type "Canvas", and an 
 *  {@link com.smartgwt.client.widgets.layout.Layout#addMember addMember()} function.
 *  <P>
 *  Because of these rules, any subclass of Canvas will be automatically eligible to be dropped
 *  into any container that accepts a Canvas (eg, a Layout or Tab).  Any subclass of a FormItem
 *  will be, likewise, automatically eligible to be dropped into a DynamicForm.
 *  <P>
 *  
 *  <P>
 *  <B>NOTE:</B> after modifying component schema, it may be necessary to restart the servlet
 *  engine and reload Reify
 *  <P>
 *  <b>Presenting simplified components</b>
 *  <P>
 *  Smart GWT components expose many methods and properties.  For some environments, it is
 *  more appropriate to provide a simplified list of properties, events, and actions on either
 *  built-in Smart GWT components or your custom components.  This can be done by providing a
 * custom {@link com.smartgwt.client.docs.ComponentSchema component schema} for an existing
 * component that exposes
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
 *      &lt;type&gt;EButton&lt;/type&gt;
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
 * See documentation above and also {@link com.smartgwt.client.docs.ComponentSchema component
 * schema} for what the
 *  properties above do.
 *  <P>
 *  3.  Finally, you'll need to define an EButton class as a simple subclass of Button, as
 *  follows:
 *  <pre>
 *  isc.defineClass("EButton", "Button");
 *  </pre>
 *  To make sure that Reify will load the above definition, you'll need to place it into a
 *  JavaScript file being loaded by Reify.  If you do not already have such a file, you can
 *  create one and add it to the list of Reify dependencies by adding an entry in
 *  /tools/visualBuilder/globalDependencies.xml.  See examples in that file for specifics.
     * @see com.smartgwt.client.docs.ToolsDeployment
     * @see com.smartgwt.client.docs.ReifyCustomComponents
     * @see com.smartgwt.client.docs.ReifyCustomDataSources
 */
public interface ReifyCustomComponents {
}
