
package com.smartgwt.client.docs;

/**
 * <h3>Using AutoChildren</h3>
 * An AutoChild is an automatically generated subcomponent that a parent component creates to
 * handle part of its presentation or functionality.  An example is the {@link
 * com.smartgwt.client.widgets.Window} component and
 *  its subcomponent the {@link com.smartgwt.client.widgets.Window#getHeader header}.
 * 
 *  <!----><!---->
 *  <p>
 * AutoChildren support four standard configuration mechanisms that can be used to customize or
 * skin
 *  them. Note, however, that configuring AutoChildren in Smart&nbsp;GWT is advanced usage.
 *  <p>
 * To determine which AutoChildren exist for a particular component type, search the class'
 * Javadocs
 *  for "AutoChild" as there is a getter for each AutoChild that is supported. In the case
 * of a {@link com.smartgwt.client.docs.MultiAutoChildren MultiAutoChild}, the getter is
 * non-functional (always
 *  returns null) and exists only to make you aware that the MultiAutoChild exists.
 *  <p>
 *  The four different ways to configure AutoChildren in Smart&nbsp;GWT are:
 *  <dl>
 *  <dt> <b>Visibility</b>
 *  <dd> Controls whether the AutoChild should be created and shown at all.  The
 *  {@link com.smartgwt.client.widgets.Canvas#setAutoChildVisibility(String, boolean)} or
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#setAutoChildVisibility(String,
 * boolean)} API
 *  as appropriate is used to change this property for the named AutoChild.
 * 
 *  <dt> <b>Properties</b>
 *  <dd> Properties to apply to the AutoChild created by a particular instance of the
 *  parent component. In the case of a MultiAutoChild, the properties are applied to each
 *  instance created by the parent.
 *  <P>
 *  To change the properties of an AutoChild of a widget, the
 *  {@link com.smartgwt.client.widgets.Canvas#setAutoChildProperties(String, Canvas)} or
 *  {@link com.smartgwt.client.widgets.Canvas#setAutoChildProperties(String, FormItem)} API
 *  is used. To change the properties of an AutoChild of a form item, the
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#setAutoChildProperties(String, Canvas)}
 * or
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#setAutoChildProperties(String,
 * FormItem)}
 *  API is used. For example:
 *  <pre>
 *         final Window myWindow = new Window();
 *         final Layout headerProperties = new Layout();
 *         headerProperties.setLayoutMargin(10);
 *         myWindow.setAutoChildProperties("header", headerProperties);
 *  </pre>
 * The above applies a {@link com.smartgwt.client.widgets.layout.Layout#getLayoutMargin
 * layoutMargin} of 10 to the header of <code>myWindow</code>,
 *  increasing the empty space around the subcomponents of the header (buttons, title label,
 *  etc).
 *  <P>
 *  <b>Do not</b> use the Properties mechanism for skinning.  See Defaults next.
 * 
 *  <dt> <b>Defaults</b>
 *  <dd> Defaults that will be applied to the AutoChild created by any instance of the
 * parent class.  Changing the defaults is used for skinning.  The
 * <code>changeAutoChildDefaults()</code>
 *  static method of the target Smart&nbsp;GWT class is used to change the defaults for all
 * instances of the class.  For example, to change the {@link
 * com.smartgwt.client.widgets.Window#getHeader Window.header}
 * defaults, the {@link com.smartgwt.client.widgets.Window#changeAutoChildDefaults(String,
 * Canvas)}
 *  API is used passing "header" for the <code>autoChildName</code>.
 *  <p>
 *  <code>changeAutoChildDefaults()</code> must be called before any
 *  components are created, and will generally be the first thing in your module's
 *  <code>onModuleLoad()</code> function.  Alternatively, you can use the JavaScript equivalent
 *  <code>Class.changeDefaults()</code> inside of a load_skin.js file - see <i>Skinning
 *  AutoChildren</i> below.
 * 
 *  <dt> <b>Constructor</b>
 *  <dd> &#83;martClient Class of the component to be created.  An advanced option, the
 *  AutoChild constructor should generally only be changed when there is documentation encouraging
 * you to do so.  For example, {@link com.smartgwt.client.widgets.grid.ListGrid} offers the
 * ability to use simple CSS-based headers or
 *  more complex {@link com.smartgwt.client.widgets.StretchImg} headers via
 *  <code>listGridInstance.setAutoChildConstructor("headerButton", "StretchImg")</code>.
 *  To change the constructor of AutoChildren, the
 *  {@link com.smartgwt.client.widgets.Canvas#setAutoChildConstructor(String, String)} or
 * {@link com.smartgwt.client.widgets.form.fields.FormItem#setAutoChildConstructor(String,
 * String)}
 *  API is used.
 *  <p>
 *  For some drastic customizations of an AutoChild where the constructor is changed, the
 * signature of the <code>get[AutoChild]()</code> method may have too specific a return type and
 * the
 *  {@link com.smartgwt.client.widgets.Canvas#getCanvasAutoChild(String)},
 *  {@link com.smartgwt.client.widgets.Canvas#getFormItemAutoChild(String)},
 *  {@link com.smartgwt.client.widgets.form.fields.FormItem#getCanvasAutoChild(String)}, or
 *  {@link com.smartgwt.client.widgets.form.fields.FormItem#getFormItemAutoChild(String)} API
 *  as appropriate would need to be used instead to retrieve the AutoChild instance.
 *  </dl>
 *  <p>
 *  <b>NOTE:</b> When setting Properties or Defaults in Smart&nbsp;GWT, attributes and event
 *  handlers can be set, but override points are not supported.
 *  <!---->
 * 
 *  <p>
 * The AutoChild system can be used to create both {@link
 * com.smartgwt.client.widgets.Canvas#getChildren direct children} 
 *  and indirect children (children of children).  For example, the
 * {@link com.smartgwt.client.widgets.Window#getMinimizeButton minimizeButton} of the Window is
 * also an autoChild, even
 *  though it is actually located within the window header.
 *  <P>
 *  <h4>Skinning AutoChildren</h4>
 *  <P>
 *  Skinning AutoChildren by changing the AutoChild defaults is typically done for two purposes:
 *  <ul>
 *  <li> Changing the default appearance or behavior of a component, for example, making all
 *  Window headers shorter
 *  <li> Creating a customized variation of an existing component <i>while retaining the
 *  base component unchanged</i>.  For example, creating a subclass of Window called
 *  "PaletteWindow" with a very compact appearance, while leaving the base Window class
 *  unchanged so that warning dialogs and other core uses of Windows do not look like
 *  PaletteWindows.
 *  </ul>
 *  The best code examples for skinning are in the load_skin.js file for the "&#83;martClient"
 *  skin, in <code>isomorphic/skins/&#83;martClient/load_skin.js</code>.
 *  <P>
 *  <h4>Passthroughs (eg window.headerStyle)</h4>
 *  <P>
 *  In many cases a component will provide shortcuts to skinning or customizing its
 * AutoChildren, such as {@link com.smartgwt.client.widgets.Window#getHeaderStyle headerStyle},
 * which becomes header.styleName.  When
 *  these shortcuts exist, they must be used instead of the more general AutoChild skinning
 *  system.
 *  <P>
 *  <h4>Safe Skinning</h4>
 *  <P>
 * Before skinning an AutoChild consider the {@link com.smartgwt.client.docs.SafeSkinning safe
 * skinning guidelines}.
 *  <P>
 *  <h4>Accessing AutoChildren Dynamically</h4>
 *  <P>
 *  For a component "Window" with an AutoChild named "header", if you create a Window
 *  called <code>myWindow</code>, the header AutoChild is available 
 *  
 *  via <code>myWindow.getHeader()</code>.
 *  <P>
 *  Unless documented otherwise, an AutoChild should be considered an internal part of a
 *  component.  Always configure AutoChildren by APIs on the parent component when they
 *  exist.  It makes sense to access an AutoChild for troubleshooting purposes or for
 *  workarounds, but in general, an AutoChild's type, behavior, and internal structure are
 *  subject to change without notice in future Smart GWT versions.
 *  <P>
 *  Accessing an AutoChild may give you a way to make a dynamic change to a component that
 *  is not otherwise supported by the parent component (for example, changing a text label
 *  where there is no setter on the parent).  Before using this approach, consider whether
 *  simply recreating the parent component from scratch is a viable option. This approach
 *  is more than fast enough for most smaller components, and will not create a reliance on
 *  unsupported APIs.
 */
public interface AutoChildUsage {
}
