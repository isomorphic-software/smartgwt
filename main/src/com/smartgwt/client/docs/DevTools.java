
package com.smartgwt.client.docs;

/**
 * <h3>Dashboards & Tools Framework Overview</h3>
 * The Dashboards & Tools framework enables you to build interfaces in which a set of UI
 *  components can be edited by end users, saved and later restored.
 *  <P>
 *  This includes interfaces such as:
 *  <ul> 
 *  <li> <b>Dashboards</b>: where a library of possible widgets can be created &
 *  configured then stored for future use and shared with other users
 *  <li> <b>Diagramming & Flowchart tools</b>: tools similar to Visio&trade; which allows users
 *  to use shapes and connectors to create a flowchart or diagram
 *  <li> <b>Form Builders &amp; Development Tools</b>: tools which enable end users to create
 *  new forms or entirely new screens and add them to the application on the fly
 *  </ul>
 *  <P>
 *  The basic building blocks of the Dashboards & Tools framework are:
 *  <ul>
 *  <li> <i>Palettes</i>: palettes create UI components on the fly from stored data.  Palettes
 *  come in a variety of flavors which implement different UI gestures for creating components
 *  (e.g. drag from tree, pick from menu, etc)
 *  <li> <i>EditContexts</i>: an edit context tracks a set of components that are being edited.
 *  Different EditContexts offer different built-in user interactions for editing the
 *  components they track, for example, a tree-based EditContext can provide an interface for
 *  managing relationships between components via drag and drop, and a Canvas-based EditContext
 *  can automatically store changes to position and size.
 *  </ul>
 *  <h3>Defaults vs LiveObject</h3>
 * The Dashboards & Tools framework is careful to maintain a distinction between the current state
 *  of the live UI component and the data that should actually be persisted and used to
 *  re-create the component.  For example:
 *  <ul>
 *  <li> a portlet may be showing a border or brightened background color to hilite it within
 *  the tool, but this should not be saved as part of the portlet state
 *  <li> a component may have a current width of 510 pixels when viewed within a tool, but what
 *  should persist is the configured width of 40% of available space
 *  <li> in a development tool, a component such a Window automatically creates subcomponents
 *  such as a header - these should not persist because the Window knows how to create them
 *  without any additional data.  Only components specifically dragged into the Window by the
 *  end user should be persisted
 *  </ul>
 *  The data that will be saved and used to re-create the component is called the
 *  <b>defaults</b>.  A Palette, which creates a component from stored data, minimally requires
 *  the String of the component to create, and the defaults.  This
 * information is captured by a {@link com.smartgwt.client.tools.PaletteNode} (along with other
 * options) - all types of
 *  Palettes work with a set or tree of paletteNodes.
 *  <P>
 *  When a component is created from a paletteNode, a "live object" is created from the
 * defaults.  One PaletteNode may generate any number of live objects.  An {@link
 * com.smartgwt.client.tools.EditNode} 
 * combines the {@link com.smartgwt.client.tools.EditNode#getLiveObject live object} along with
 * the type and defaults
 *  needed to recreate the live object, and is used to track the created live object as it is
 *  further edited.  Essentially an EditNode is a copy of the PaletteNode in which a live object
 *  has been created and the editNode.defaults may now begin to change as the user edits the
 *  object they have created.
 * 
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
 * <i>HTML tag:</i> <pre>&lt;SCRIPT
 * SRC="../isomorphic/DataSourceLoader?dataSource=$systemSchema"&gt;&lt;/SCRIPT&gt;</pre>
 * @see com.smartgwt.client.tools.EditContext
 * @see com.smartgwt.client.tools.Palette
 * @see com.smartgwt.client.tools.HiddenPalette
 * @see com.smartgwt.client.tools.TreePalette
 * @see com.smartgwt.client.tools.ListPalette
 * @see com.smartgwt.client.tools.TilePalette
 * @see com.smartgwt.client.tools.MenuPalette
 * @see com.smartgwt.client.tools.EditPane
 * @see com.smartgwt.client.tools.EditTree
 * @see com.smartgwt.client.tools.Palette#getGenerateNames
 * @see com.smartgwt.client.tools.TreePalette#getComponentDefaults
 * @see com.smartgwt.client.tools.EditTree#getRootComponent
 */
public interface DevTools {
}
