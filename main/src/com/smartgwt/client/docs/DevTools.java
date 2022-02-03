
package com.smartgwt.client.docs;

/**
 * <h3>Dashboards & Tools Framework Overview</h3>
 * The Dashboards &amp; Tools framework enables you to build interfaces in which a set of UI
 *  components can be edited by end users, saved and later restored.
 *  <P>
 *  This includes interfaces such as:
 *  <ul> 
 *  <li> <b>Dashboards</b>: where a library of possible widgets can be created & configured,
 *       arranged into freehand or portal-style layouts, then stored for future use and
 *       shared with other users
 *  <li> <b>Diagramming &amp; Flowchart tools</b>: tools similar to Visio&trade; which allow users
 *       to use shapes and connectors to create a flowchart or diagram representing a workflow,
 *       equipment or locations being monitored, a storyboard, or any similar interactive &amp;
 *       modifiable visualization. 
 *  <li> <b>Form Builders &amp; Development Tools</b>: tools which enable end users to create
 *       new forms or new screens, define interactive behaviors and rules, and add the screens
 *       to an application on the fly
 *  </ul>
 *  <P>
 *  <h3>Overview</h3>
 *  <p>
 *  Dashboards &amp; Tools provides a pattern for end user creation and configuration of UI
 *  components which enables the framework to store and re-create components exactly as the user
 *  configured them.
 *  <p>
 *  Unlike simple serialization, Dashboards &amp; Tools is designed to capture <i>only</i>
 *  UI state created directly by end user actions, and not transient or derived state
 *  (for more on this behavior and how it is different from serialization, see "Stored
 *  vs Derived State" below).
 *  <p>
 *  To achieve this, user-editable components are created via a special pattern (not just the
 *  usual 
 *  
 *  <code>new SomeComponent()</code>),
 *  and changes to user-editable components that are meant to be saved are likewise applied via
 *  special APIs (not just direct calls to <code>someComponent.setSomething()</code>).
 *  <p>
 *  The main components and behaviors involved in Dashboards &amp; Tools are covered in brief
 *  below - each of these points is covered in more detail in further sections:
 *  <p>
 *  <ul>
 * <li> User-editable components are created by {@link com.smartgwt.client.tools.Palette
 * Palettes}.  <code>Palettes</code>
 * create components from {@link com.smartgwt.client.tools.PaletteNode PaletteNodes}, which are
 * {@link com.smartgwt.client.data.Record data records}
 *       containing the component's class and default settings.  Some <code>Palettes</code>
 *       provide an end user UI for creating components (eg drag a node from a Tree).
 *  <li> An editable component created by a <code>Palette</code> is represented by an
 * {@link com.smartgwt.client.tools.EditNode}, which tracks the created component along with the
 * data necessary
 *       to save and re-create the component.
 * <li> An {@link com.smartgwt.client.tools.EditContext} manages a list or {@link
 * com.smartgwt.client.widgets.tree.Tree} of {@link com.smartgwt.client.tools.EditNode EditNodes},
 * and provides
 *       APIs for serializing and restoring <code>EditNodes</code> to and from XML and JSON, and
 *       updating the nodes as users make changes.
 * <li> Many UI components have {@link com.smartgwt.client.widgets.Canvas#setEditMode "edit mode"}
 * behaviors.  When "edit
 *       mode" is enabled, when an end user interacts with the component, the component will
 * save changes to its {@link com.smartgwt.client.tools.EditNode} or to child {@link
 * com.smartgwt.client.tools.EditNode EditNodes} in the
 * {@link com.smartgwt.client.tools.EditContext}.  For example, {@link
 * com.smartgwt.client.widgets.layout.PortalLayout} can track and persist changes to
 *       the placement and size of portlets made by end users.  <code>EditMode</code> behaviors
 * are implemented by {@link com.smartgwt.client.tools.EditProxy EditProxies}, and different edit
 * mode behaviors can
 *       be turned on and off for different kinds of tools.
 *  </ul>
 *  A simple tool based on the Dashboards &amp; Tools framework would typically consist of:
 *  <p>
 *  <ul>
 *  <li> one or more <code>Palettes</code> showing components that the user can create
 * <li> a main editing area where you can drag things from a {@link
 * com.smartgwt.client.tools.Palette} to create them.  The
 *       editing area is just an ordinary UI component that has been placed into "edit mode"
 *       and provided with an <code>EditContext</code>.  Depending on the type of tool, the main
 * editing area might be a {@link com.smartgwt.client.widgets.drawing.DrawPane} (for diagrams), a
 * {@link com.smartgwt.client.widgets.form.DynamicForm} (for a
 *       form builder) or various other widgets.
 *  <li> Buttons, Menus and pop-up dialogs that act on the currently selected widget.
 * Dashboards &amp; Tools has {@link com.smartgwt.client.tools.EditProxy#getCanSelectChildren
 * built-in UI} for
 *       selecting one or more of the components being edited.
 * {@link com.smartgwt.client.tools.EditContext#getSelectedEditNode
 * EditContext.getSelectedEditNode()} provides the current edit node, and
 * {@link com.smartgwt.client.tools.EditContext#setNodeProperties EditContext.setNodeProperties()}
 * lets you manipulate its persisted state.
 *  <li> Buttons, Menus and pop-up dialogs providing the ability to load or save.  These would
 *       use APIs on <code>EditContext</code> to 
 * {@link com.smartgwt.client.tools.EditContext#serializeEditNodes obtain XML or JSON Strings}
 * representing the
 *       data to be saved, as well as to 
 * {@link com.smartgwt.client.tools.EditContext#addPaletteNodesFromXML restore saved state} from
 * such Strings.
 *       DataSources can be used to store whatever is being edited: the serialized form is just
 * an XML or JSON String, so it can be stored as an ordinary {@link
 * com.smartgwt.client.data.DataSourceField} value. 
 *  </ul>
 *  <p>
 *  <h3>Creating editable components: <code>Palettes</code></h3>
 *  <p>
 * User-editable components are created by {@link com.smartgwt.client.tools.Palette Palettes}. 
 * <code>Palettes</code>
 * create components from {@link com.smartgwt.client.tools.PaletteNode PaletteNodes}, which are
 * {@link com.smartgwt.client.data.Record data records}
 *  containing the component's class and default settings.
 *  <p>
 *  Most types of <code>palettes</code> provide a UI for an end user to create components from
 * <code>paletteNodes</code>.  For example, a {@link com.smartgwt.client.tools.TreePalette}
 * presents a hierarchical
 *  set of <code>paletteNodes</code> as a tree, and allows end users to drag nodes out in order
 *  to create components.  All <code>palettes</code> also support
 * {@link com.smartgwt.client.tools.Palette#makeEditNode programmatic creation of components} from
 *  <code>paletteNodes</code>.
 *  <p>
 *  <code>paletteNodes</code> can be programmatically provided to a <code>Palette</code>, or, 
 *  <code>Palettes</code> that are derived from
 * {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents} can load
 * <code>paletteNodes</code> from a
 *  {@link com.smartgwt.client.data.DataSource}.
 *  <p>
 * When a component is created from a <code>paletteNode</code>, an {@link
 * com.smartgwt.client.tools.EditNode} is created
 * that tracks the {@link com.smartgwt.client.tools.EditNode#getLiveObject live component} and the
 * state needed to re-create
 *  it, called the {@link com.smartgwt.client.tools.EditNode#getDefaults defaults}.  
 *  <p>
 *  <h3>EditContexts &amp; EditProxies</h3>
 *  <p>
 * An {@link com.smartgwt.client.tools.EditContext} manages a {@link
 * com.smartgwt.client.widgets.tree.Tree} of {@link com.smartgwt.client.tools.EditNode EditNodes},
 * and provides APIs for
 *  serializing and restoring <code>EditNodes</code> and updating the tree of nodes.
 *  <p>
 *  When an <code>EditNode</code> is added to an EditContext, typically it is immediately placed
 * into {@link com.smartgwt.client.widgets.Canvas#setEditMode "Edit Mode"} (see {@link
 * com.smartgwt.client.tools.EditContext#getAutoEditNewNodes EditContext.autoEditNewNodes} for how
 *  this can be controlled).  In Edit Mode, components introduce special behaviors, such as the
 * ability to directly edit the titles of {@link com.smartgwt.client.widgets.tab.Tab}s in a {@link
 * com.smartgwt.client.widgets.tab.TabSet} by double-clicking, or
 * support for dragging new {@link com.smartgwt.client.widgets.form.fields.FormItem}s into a
 * {@link com.smartgwt.client.widgets.form.DynamicForm}.  Changes made while a
 * component is in Edit Mode are saved to the component's {@link
 * com.smartgwt.client.tools.EditNode}, in
 *  {@link com.smartgwt.client.tools.EditNode#getDefaults EditNode.defaults}. 
 *  <p>
 * Each component that has <code>editMode</code> features has a corresponding {@link
 * com.smartgwt.client.tools.EditProxy}
 *  that implements those features.  A component's <code>EditProxy</code> is automatically
 * created when a component {@link com.smartgwt.client.widgets.Canvas#setEditMode goes into edit
 * mode}, and overrides the
 *  normal behavior of the component.  By configuring the <code>EditProxy</code> for a
 *  component, you configure what behaviors the component will have when in edit mode, and which
 *  specific actions on the component will cause changes to be saved to its <code>EditNode</code>.
 *  <p>
 *  For example, {@link com.smartgwt.client.tools.CanvasEditProxy} has features for 
 * {@link com.smartgwt.client.tools.EditProxy#getPersistCoordinates saving coordinates as child
 * widgets are dragged}, and
 *  {@link com.smartgwt.client.tools.GridEditProxy} has features for persisting 
 * {@link com.smartgwt.client.tools.GridEditProxy#getSaveFieldVisibility field visibility} when
 * end users show and hide
 *  fields.
 *  <p> 
 *  You can configure which EditProxy behaviors are active via
 * {@link com.smartgwt.client.tools.PaletteNode#getEditProxyProperties
 * PaletteNode.editProxyProperties} and {@link
 * com.smartgwt.client.tools.EditNode#getEditProxyProperties EditNode.editProxyProperties}, and
 * via the
 *  {@link com.smartgwt.client.widgets.Canvas#getEditProxy editProxy AutoChild}.
 *  <p>
 *  <h3>EditContext &amp; Trees of EditNodes</h3>
 *  <p>
 *  The <code>EditContext</code> has the capability to manage a <code>Tree</code> of
 *  <code>EditNodes</code> in order to enable tools that create a hierarchy of Smart GWT
 * components.  When you use {@link com.smartgwt.client.tools.EditContext#addNode
 * EditContext.addNode()} and add a new EditNode underneath
 *  another EditNode, the EditContext will automatically try to determine how the parent and
 *  child are related and actually call APIs on the widgets to establish a relationship, such as
 *  a Tab being added to a TabSet, or a FormItem being added to a DynamicForm.  The
 *  EditContext uses the same approach as is used for Visual Builder Drag and Drop - see
 *  {@link com.smartgwt.client.docs.VisualBuilder Visual Builder overview} for details.
 *  <!-- Note that the system for discovering setter/adder methods used by the EditContext is
 *  not actually specific to visual widgets as implied above.  You could use an EditContext to
 *  manage a hierarchy of non-visual instances of Smart GWT classes which directly subclass
 *  isc.Class, for example, you could have an interface for constructing a nested formula by
 *  dragging and dropping mathematical operators into a tree, where each operator is represented
 *  by a Smart GWT Class and with a corresponding component schema.  The final formula might
 *  then be rendered in MathML or similar, completely separately from the Smart GWT drawing
 *  system.  We won't try to document this yet, at least not without a sample; it's too advanced
 *  to explain with prose alone -->
 *  <p>
 *  Note that many if not most kinds of tools use only a flat list of EditNodes - for example,
 *  in a collage editor, photos may sometimes be stacked on top of each other, but a
 * parent/child relationship in the sense of {@link com.smartgwt.client.widgets.Canvas#getChildren
 * Canvas.children} is not established by doing
 * so.  Likewise, although the <a
 * href="http://www.smartclient.com/smartgwtee/showcase/#mockupEditor" target="examples">Mockup
 * Editor sample</a> allows end
 *  users to create mockups using Smart GWT components, the components never truly become
 *  children of other components.  Instead, as is typical of most mockup tools, hierarchy is
 *  achieved visually by simply placing a component on top of another and within its bounding
 *  rectangle.  
 *  <p>
 *  Most types of tools use a flat list of <code>EditNodes</code> - generally speaking you will
 *  only use the hierarchy management features of <code>Editcontext</code> if you are creating a
 *  tool that actually allows end users to build functioning Smart GWT screens, such as the
 * <a href="http://www.smartclient.com/smartgwtee/showcase/#formBuilder" target="examples">Form
 * Builder example</a>.  For such applications, use 
 * {@link com.smartgwt.client.tools.EditContext#getAllowNestedDrops EditContext.allowNestedDrops}
 * to enable drag and drop interactions that will allow end
 *  users to place components inside of other components.
 *  <p>
 *  <h3>Stored vs Derived state</h3>
 *  <p>
 *  The purpose of having an <code>EditNode</code> for each UI component is to maintain a
 *  distinction between the current state of the live UI component and the state that should
 *  be saved.  For example:
 *  <ul>
 *  <li> a component may have a current width of 510 pixels when viewed within a tool, but what
 *  should persist is the configured width of 40% of available space
 *  <li> a component may have editing behaviors enabled, such as the ability to double-click to
 *       edit labels or titles, which should be enabled in the tool but not at runtime
 *  <li> a tool may allow end users to create a Window, and then drag components into the Window.
 *      Every Window automatically creates subcomponents such as a header, but these should not be
 *      persisted because they don't represent state created by the end user.  Only the components
 *       the end user actually dragged into the Window should be persisted
 * <li> an end user may try out the effect of a property change, then abandon it and revert to the
 *       default value.  We don't want the temporary change saved, and we don't even want to save
 *       the reversion to the default value - nothing about the saved state should be changed
 *  </ul>
 *  By being careful to save <i>only intentional changes made by the user</i>:
 *  <ul>
 *  <li> the saved state remains minimal in size, and re-creating components from the stored state
 *       is more efficient
 * <li> the saved state is much easier to edit since it contains only intentional settings, and
 * not
 *       generated or derived information
 *  <li> the stored state is more robust against changes over time and easier to re-use.  When we
 *       avoiding spuriously saving default values that the user has not modified, we avoid
 *       possible conflicts when a saved UI is deployed to a new version or in a different
 *       environment with different defaults
 *  </ul>
 *  Specifically, only two things affect the state that will be stored for a given component:
 *  <ol>
 * <li> Features enabled when a component is in EditMode, configured via the component's EditProxy
 * <li> Direct calls to {@link com.smartgwt.client.tools.EditContext#setNodeProperties
 * EditContext.setNodeProperties()} by application code
 *  </ol>
 *  Any other kind of change to the widget is not automatically persisted.
 *  <P>
 *  
 *  <h3>Deriving default settings for PaletteNodes</h3>
 *  PaletteNodes contain a set of default settings which define the initial properties for any
 *  live object created from that PaletteNode.  When you create a PaletteNode directly, you 
 *  configure these defaults by creating a properties object of the same type as the object 
 *  represented by the PaletteNode, and passing it to the PalleteNode's
 * {@link
 * com.smartgwt.client.tools.PaletteNode#setCanvasDefaults(com.smartgwt.client.widgets.Canvas)
 * setCanvasDefaults()}
 *  method (PaletteNode also has equivalent <code>setFormItemDefaults()</code> and 
 *  <code>setDrawItemDefaults()</code> methods).
 *  <p>
 *  Sometimes, however, your code does not directly create the PaletteNode itself.  For
 *  example, when you provide {@link com.smartgwt.client.widgets.tile.TileRecord}s that will be
 *  used in a {@link com.smartgwt.client.tools.TilePalette}, you provide the PaletteNode 
 *  defaults on the TileRecords, but your code does not actually create the PaletteNodes.  In 
 *  this case, you create a properties object as described above, and then you call its 
 *  {@link com.smartgwt.client.widgets.Canvas#getPaletteDefaults() getPaletteDefaults()}
 *  method to obtain a Map of properties suitable for specifying PaletteNode defaults.  This 
 * code, taken from the <a href="http://www.smartclient.com/smartgwtee/showcase/#collageEditor"
 * target="examples">Collage Editor sample</a>, demonstrates 
 *  the approach:<pre>
 *      Img img = new Img();
 *      img.setTitle(title);
 *      img.setSrc("stockPhotos/" + photos.get(i));
 *      TileRecord record = new TileRecord();
 *      record.setAttribute("title", title);
 *      record.setAttribute("type", "Img");
 *      record.setAttribute("defaults", img.getPaletteDefaults());
 *  </pre>
 *  <h3>Module requirements</h3>
 * <b>NOTE:</b> you must load the Tools {@link com.smartgwt.client.docs.LoadingOptionalModules
 * Optional Module} 
 *  for this framework.
 *  <P>
 *  Any tools that work with hierarchies of system components or derivations
 *  of them will also need the system schema which can be loaded by either of the
 *  following:
 *  <P>
 *  <i>JSP tag:</i> <pre>&lt;script&gt;&lt;isomorphic:loadSystemSchema /&gt;&lt;/script&gt;</pre>
 *  <P>
 *  <i>HTML tag:</i> <pre>&lt;SCRIPT SRC="../isomorphic/DataSourceLoader?dataSource=$systemSchema"&gt;&lt;/SCRIPT&gt;</pre>
 * @see com.smartgwt.client.tools.EditContext
 * @see com.smartgwt.client.tools.SerializationSettings
 * @see com.smartgwt.client.tools.Palette
 * @see com.smartgwt.client.tools.HiddenPalette
 * @see com.smartgwt.client.tools.TreePalette
 * @see com.smartgwt.client.tools.ListPalette
 * @see com.smartgwt.client.tools.TilePalette
 * @see com.smartgwt.client.tools.MenuPalette
 * @see com.smartgwt.client.tools.EditPane
 * @see com.smartgwt.client.tools.EditTree
 * @see com.smartgwt.client.tools.EditProxy
 * @see com.smartgwt.client.tools.CanvasEditProxy
 * @see com.smartgwt.client.tools.LayoutEditProxy
 * @see com.smartgwt.client.tools.SplitPaneEditProxy
 * @see com.smartgwt.client.tools.SectionStackEditProxy
 * @see com.smartgwt.client.tools.TabSetEditProxy
 * @see com.smartgwt.client.tools.StatefulCanvasEditProxy
 * @see com.smartgwt.client.tools.LabelEditProxy
 * @see com.smartgwt.client.tools.ProgressbarEditProxy
 * @see com.smartgwt.client.tools.WindowEditProxy
 * @see com.smartgwt.client.tools.DetailViewerEditProxy
 * @see com.smartgwt.client.tools.MenuEditProxy
 * @see com.smartgwt.client.tools.FormEditProxy
 * @see com.smartgwt.client.tools.FormItemEditProxy
 * @see com.smartgwt.client.tools.TextItemEditProxy
 * @see com.smartgwt.client.tools.TextAreaItemEditProxy
 * @see com.smartgwt.client.tools.SelectItemEditProxy
 * @see com.smartgwt.client.tools.CheckboxItemEditProxy
 * @see com.smartgwt.client.tools.DateItemEditProxy
 * @see com.smartgwt.client.tools.GridEditProxy
 * @see com.smartgwt.client.tools.DrawPaneEditProxy
 * @see com.smartgwt.client.tools.DrawItemEditProxy
 * @see com.smartgwt.client.tools.DrawLabelEditProxy
 * @see com.smartgwt.client.tools.FacetChartEditProxy
 * @see com.smartgwt.client.tools.EditContext#editNodePasteOffset
 * @see com.smartgwt.client.tools.EditContext#getRootComponent
 * @see com.smartgwt.client.tools.Palette#getGenerateNames
 * @see com.smartgwt.client.tools.TreePalette#getComponentDefaults
 * @see com.smartgwt.client.tools.EditPane#getRootComponent
 * @see com.smartgwt.client.tools.EditTree#getRootComponent
 */
public interface DevTools {
}
