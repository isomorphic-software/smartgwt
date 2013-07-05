
package com.smartgwt.client.docs;

/**
 * <h3>DOM Integration &amp; Third-party Components</h3>
 * Smart GWT provides a huge variety of pre-built components and allows you to create new
 *  components via combining and composing the existing components.  However in rare cases, it can
 *  make sense to write code that works directly with raw HTML and the browser's DOM (document
 *  object model) APIs.  This level of coding is also involved when integrating third-party
 *  JavaScript components into Smart GWT applications.
 *  <P>
 *  First, a warning: when you use HTML and the DOM directly, all of Smart GWT's guarantees of
 *  cross-browser consistent behavior no longer apply.  When you use Smart GWT's API, Smart GWT
 *  is automatically compensating for many, many browser bugs - not just trivial things like
 *  different property names or missing utility methods, but problems where browsers fail to fire
 *  certain events, report sizes wrong only in certain modes with certain styling, or bugs that
 *  only occur with specific timing.
 *  <P>
 *  Before deciding to do direct HTML coding, consider whether you really want to expose yourself
 *  to all of these possible issues.  If you can achieve the same look and feel and behavior
 *  through Smart GWT's APIs, that's usually best.
 *  <P>
 *  <h3>Adding or modifying the DOM</h3>
 *  <P>
 *  The DOM structures used by Smart GWT necessarily differ by browser in order to work around
 *  each browser's specific bugs.  This DOM structure is intentionally undocumented because it is
 *  subject to change without notice - in may be necessary to modify the DOM structure to work
 *  around the bugs in each new browser release.
 *  <P>
 *  Instead of trying to modify the Smart GWT-generated DOM, you should always <b>add new
 *  elements</b>.  For a new standalone component that will be based on direct use of HTML, you
 * usually do this by subclassing Canvas and overriding {@link
 * com.smartgwt.client.widgets.Canvas#getInnerHTML Canvas.getInnerHTML} and returning
 *  an HTML string representing the components you want to create.
 *  <P>
 *  You can use a similar approach anywhere HTML is allowed in a widget property: formatting APIs
 *  for StaticTextItem, DetailViewer, TileGrid, and other DataBoundComponents, as well as places
 * such as {@link com.smartgwt.client.widgets.tab.Tab#getTitle title} or {@link
 * com.smartgwt.client.widgets.Button#getTitle title}.
 *  <P>
 *  <h3>Third-party components</h3>
 *  <P>
 *  Most third-party JavaScript components have the ability to generate their HTML content into a
 *  DOM element specified by ID, or to replace such an element with new HTML.  This is true of
 * Google Maps, <a href='http://ckeditor.com' onclick="window.open('http://ckeditor.com');return
 * false;">CKEditor</a> and many other libraries.
 *  <P>
 * To use this form of integration, implement a {@link
 * com.smartgwt.client.widgets.Canvas#getInnerHTML Canvas.getInnerHTML} function that returns
 *  a DOM element with a known ID, then have the third-party library target that DOM element once
 *  the Canvas is drawn.  For example, CKEDITOR.replace() takes the ID of a &lt;textarea&gt;
 *  element, and the following code would create a &lt;textarea&gt; and have the CKEditor replace
 *  it with a CKEditor widget: 
 *  
 *  
 *  <pre>
 *  public class CKEditor extends Canvas {
 *  
 *      private static native void replace(String id) &#47;*-{
 *          $wnd.CKEDITOR.replace(id);
 *      }-*&#47;;
 *  
 *      public CKEditor() {
 *          setRedrawOnResize(false);
 *      }
 *  
 *      &#64;Override
 *      public String getInnerHTML() {
 * return "&lt;textarea id='" + getID() + "_ckEditor'
 * style='width:100%;height:100%'>&lt;/textarea>";
 *      }
 *  
 *      &#64;Override
 *      protected void onDraw() {
 *          CKEditor.replace(getID() + "_ckEditor");
 *      }
 *  }
 *  </pre>
 *  
 *  <P>
 *  This same approach can be used when you want to insert third-party generated HTML into just a
 *  specific part of a Smart GWT widget.  For example, you might want to insert 
 * <a href='https://www.google.com/search?q=jquery+sparklines'
 * onclick="window.open('https://www.google.com/search?q=jquery+sparklines');return false;">JQuery
 * 'sparklines'</a>, which are
 *  essentially miniature charts, into cells of a ListGrid.  You could use
 * {@link com.smartgwt.client.widgets.grid.ListGridField#formatCellValue a cell formatter} to
 * write out &lt;div&gt; elements with
 *  known IDs into the cells, then target them with JQuery.
 *  <P>
 *  <h3>Resizing and Redraw</h3>
 *  <P>
 *  When implementing <code>canvas.getInnerHTML()</code>, your getInnerHTML() function will be
 * called every time the component redraw()s, and the new HTML will replace the old.  This is also
 *  true of something like a ListGrid cell formatter.
 *  <P>
 *  Also by default, your component will redraw() if it is resized.  In the example above with
 * CKEditor, we wouldn't want this because it would wipe out the CKEditor widget every time it was
 * resized, so we set {@link com.smartgwt.client.widgets.Canvas#getRedrawOnResize redrawOnResize}
 * to false.  In other circumstances you may want
 *  to redraw on every resize in order to generate new HTML.
 *  <P>
 *  If you do not redraw HTML on resize, you either have to write the HTML in a way that makes it
 * flow into available space (width/height 100% may be enough here) <b>or</b> you need to manually
 * resize the DOM element when the {@link com.smartgwt.client.widgets.Canvas#addResizedHandler
 * resized event} fires.  
 *  <P>
 *  In the latter case, you should adjust the size of the DOM element to match the
 *  {@link com.smartgwt.client.widgets.Canvas#getInnerWidth inner width} and 
 * {@link com.smartgwt.client.widgets.Canvas#getInnerHeight inner height} of the containing
 * Canvas.  The "inner" dimensions
 *  are the dimensions after border and margins have been subtracted, so this will work even if a
 * border is added to your Canvas subclass via CSS or {@link
 * com.smartgwt.client.widgets.Canvas#setBorder Canvas.setBorder}.
 *  <P>
 *  <h3>Other redraws</h3>
 *  <P>
 * Once you have set {@link com.smartgwt.client.widgets.Canvas#getRedrawOnResize redrawOnResize}
 * to false you may still see redraws from other
 *  sources.  Generally this would be from code in your application which calls
 * {@link com.smartgwt.client.widgets.Canvas#redraw Canvas.redraw} or {@link
 * com.smartgwt.client.widgets.Canvas#markForRedraw Canvas.markForRedraw} unnecessarily.  To
 * troubleshoot, you
 *  can enable the "redraws" log category in the Developer Console - this will log the source of
 *  any redraws in the system.
 *  <P>
 *  <h3>Auto-Sizing</h3>
 *  <P>
 * With the default setting of {@link com.smartgwt.client.widgets.Canvas#getOverflow
 * overflow:"visible"}, an HTMLFlow will
 *  auto-size to fit content returned by <code>getInnerHTML()</code>.  However, if you
 *  subsequently modify the DOM inside the HTMLFlow, there is no cross-browser-reliable way for
 *  the HTMLFlow to detect this and auto-size again.  Instead, call
 * {@link com.smartgwt.client.widgets.Canvas#adjustForContent Canvas.adjustForContent} to trigger
 * auto-sizing again.
 *  <P>
 *  <h3>zIndex</h3>
 *  <P>
 *  zIndex values control what component is rendered "on top" when multiple components appear in
 *  the same area of the page.
 *  <P>
 *  To work around various browser issues, Smart GWT components use a very high range of
 *  zIndex values.  If a component creates pop-up widgets such as hovers or floating toolbars
 *  via direct HTML/DOM usage, these pop-up widgets will appear <b>behind</b> all Smart GWT
 *  components unless they set a very high zIndex.  
 *  <P>
 *  For your own custom HTML/DOM components, the simplest strategy is to create pop-up widgets
 *  based on Smart GWT components, even if they are triggered by interacting with
 *  hand-created HTML.  For example, even if you've written some kind of advanced SVG-based data
 *  visualization component, you can still implement pop-up configuration dialogs based on the
 * Smart GWT {@link com.smartgwt.client.widgets.Window} class; there's no reason to implement such
 * dialogs directly in
 *  low-level HTML/DOM code.
 *  <P>
 *  If a third-party widget is creating pop-ups you don't directly control, you may be able to
 *  configure the third-party widget to use a certain zIndex range, or you may be able to
 *  directly reach into the widget's DOM and modify zIndexes that way.  You can use
 * {@link com.smartgwt.client.widgets.Canvas#getZIndex Canvas.getZIndex} to discover the zIndex of
 * any Smart GWT widget you need to
 *  appear above, then set a higher value.
 *  <P>
 *  Finally, as a last resort and completely unsupported approach, you can modify the zIndex
 *  range used by Smart GWT using the following JavaScript code:
 *  <pre>
 *  isc.Canvas.addClassProperties({
 *     // default zIndex for the next item to be drawn
 *     _nextZIndex:200000,
 * 
 *     // zIndex of the next item to be sent to the back
 *     _SMALL_Z_INDEX:199950,
 * 
 *     // zIndex of the next item to be brought to the front
 *     _BIG_Z_INDEX:800000
 *  });
 *  </pre>
 *  <P>
 *  <h3>Other issues</h3>
 *  <P>
 *  There are several other issues, listed below, for which there really is no general strategy
 *  for solving the issue, although some general pointers are provided.
 *  <P>
 *  Because of problems like these, it's a very very bad idea to freely intermix components from
 *  multiple component libraries.  While mixing components may appear to be an appealing
 *  strategy and you may experience apparent success with early attempts, the issues below will
 *  ultimately prevent you from completing an application of sufficient quality for enterprise
 *  use.
 *  <P>
 *  In the following discussion, "third-party widgets" should be understood to include
 *  widgets that you write using direct DOM/HTML techniques.
 *  <ul>
 *  <li> <b>tabbing order / accessibility</b>: a correct tabbing order that visits all
 *  components on the page is a requirement for your application to be considered accessible, as
 * is ARIA markup (for more information, see {@link com.smartgwt.client.docs.Accessibility}). 
 * Third-party
 *  widgets may completely lack ARIA markup, such that you may be required to modify them or
 *  reach into their DOM to add ARIA attributes.  It may be necessary to add manual keyDown or
 *  keyPress event handlers to handle focus moving from Smart GWT components to third-party
 *  widgets and back.
 * 
 *  <li> <b>modality</b>: aside from zIndex issues covered above, modality means that the tab
 *  order should be a closed loop that reaches only active widgets, which can create additional
 *  complexity in getting tabbing to work correctly.  Also, keyboard shortcuts should be
 *  disabled for inactive widgets; this may require calls to
 * {@link com.smartgwt.client.util.EventHandler#targetIsMasked EventHandler.targetIsMasked} to
 * make third-party widgets respect Smart GWT
 * modality, or may require calls to {@link com.smartgwt.client.widgets.Canvas#showClickMask
 * Canvas.showClickMask} to cause Smart GWT
 *  components to consider themselves inactive when a third-party widget opens a pop-up that is
 *  intended to be modal.  Multi-layered modality, such as a modal window that in turn pops a
 *  modal dialog, is yet more complex.
 * 
 *  <li> <b>bad CSS</b>: some third-party widgets introduce CSS selectors that target, for
 *  example, every table cell on the entire page.  This very bad practice will interfere with
 *  Smart GWT (or any other HTML on the page).  This may require modifying the third-party
 *  component, or extensively modifying Smart GWT CSS to reverse any changes caused by
 *  third-party CSS.  For example, it may be necessary to modify every Smart GWT CSS style
 *  that may be applied to a table cell to reverse a change in padding for all table cells that
 *  is introduced by bad third-party CSS.
 * 
 * <li> <b>skinning</b>: third-party widgets may lack sufficient skinning APIs to allow you to
 * match
 *  look and feel to SmartGWT, which may necessitate creating a custom SmartGWT skin to match
 * the look and feel of third-party widgets (see {@link com.smartgwt.client.docs.Skinning Skinning
 * Overview})
 * 
 *  <li> <b>event interference</b>: third-party widgets may register page-wide event handling
 *  logic that conflicts with or destroys similar event handling logic in Smart GWT.  For best
 *  results, load third-party JavaScript libraries <b>before</b> Smart GWT since Smart GWT
 *  makes a best effort to preserve any previously installed handlers and allows such handlers to
 *  cancel native browser behaviors if they do so.
 * 
 *  <li> <b>RTL / i18n</b>: third party widgets may not allow all user-visible messages to be
 *  replaced, a requirement for internationalization / localization, or they may not support
 *  RTL/BIDI (Right-To-Left / Bi-Directional) rendering
 *  </ul>
 * 
 *  Because of issues like the above, not all of which may be resolvable for some third-party
 *  widgets, we recommend the following overall approach:
 *  <ul>
 *  <li> avoid using third-party widgets if you can build equivalent functionality in
 *       Smart GWT
 *  <li> if the third-party component is completely non-interactive, either does not require
 *       ARIA markup or already includes such markup, and there are no conflicting look and feel
 *       issues, go ahead and use it
 *  <li> if you anticipate issues, consider the 
 * <a href='http://www.smartclient.com/services/index.jsp#features'
 * onclick="window.open('http://www.smartclient.com/services/index.jsp#features');return
 * false;">Feature Sponsorship Program</a> 
 *       as a means of getting new supported functionality added to Smart GWT
 *  <li> search for existing posts and/or ask about the feasibility of integration on the
 * <a href='http://forums.smartclient.com/'
 * onclick="window.open('http://forums.smartclient.com/');return false;">Smart GWT Forums</a>.
 *  <li> finally, you could attempt to tackle the issues above on your own.  To avoid wasting
 *       time on dead ends, we would recommend assessing the amount of work involved in fixing
 *    <b>all</b> problems that need to be solved before attempting actual fixes for any one issue.
 *  </ul>
 */
public interface DomIntegration {
}
