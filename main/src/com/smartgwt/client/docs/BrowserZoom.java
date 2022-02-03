
package com.smartgwt.client.docs;

/**
 * <h3>Native Browser Zoom Support</h3>
 * Native browser zooming, that is, the ability in most browsers to enlarge or shrink the entire
 *  web page, is currently only partly supported in specific browsers due to intractable browser
 *  bugs.
 *  <p>
 *  Support in this release is restricted to:
 *  <ul>
 * <li> support for almost all components for Internet Explorer version 11 only, with known
 * issues, almost all cosmetic (see below)
 * <li> supported with the requirement that users refresh the page after changing zoom, with known
 * cosmetic issues listed
 *       below. See also the Detecting Zoom Changes section below.
 * <li> no support for Chrome, Safari, other Webkit browsers - support not yet possible (see
 * below)
 *  </ul>
 *  In addition, support guarantees are limited for zoom-related issues:
 *  <ul>
 *  <li> cosmetic issues that appear only in zoom mode will not be investigated
 *  <li> functional issues that appear only in zoom mode will be investigated if they are
 *       reproducible, but the normal guarantee of a fix or workaround is not provided, since for
 *       most zoom issues, there is no feasible way to work around the problem
 *  </ul>
 *  Known issues by browser are listed below.
 * 
 *  <h3>Chrome and Opera 15+</h3>
 *  <ul>
 *  <li>Core DOM APIs for querying position and sizing information of an element return fractional
 *   values even though they shouldn't be, which can impact layout, scrolling, and event handling.
 *      See issue
 *      <a href='http://crbug.com/60837' target='_blank'>60837</a>.</li>
 *  <li>The minimum font size feature can cause layout issues when the page zoom is decreased
 *      but the page is not refreshed at the new zoom level.</li>
 *  <li>Chrome fails <code>background-image</code> related CSS Working Group tests with page zoom,
 *      causing background images to draw oddly in certain cases. See issues
 *      <a href='http://crbug.com/412914' target='_blank'>412914</a> and
 *      <a href='http://crbug.com/421331' target='_blank'>421331</a>.</li>
 *  <li>Borders do not scale properly, causing layout issues, cosmetic issues where borders
 *      do not line up with background images or appear beveled, and accessibility issues where
 *      borders may be too thin. See issues
 *      <a href='http://crbug.com/382483' target='_blank'>382483</a>,
 *      <a href='http://crbug.com/388879' target='_blank'>388879</a>,
 *      <a href='http://crbug.com/406371' target='_blank'>406371</a>, and
 *      <a href='http://crbug.com/434720' target='_blank'>434720</a>.</li>
 *  <li>Various issues affecting SVG drawings. See issues
 *      <a href='http://crbug.com/181122' target='_blank'>181122</a>,
 *      <a href='http://crbug.com/407159' target='_blank'>407159</a>, and
 *      <a href='http://crbug.com/421926' target='_blank'>421926</a>.</li>
 *  </ul>
 * 
 *  <h3>Firefox</h3>
 *  <ul>
 *  <li>Firefox' approach to page zoom involves changing the layout rather than scaling the
 *      entire page content by the zoom factor. This can cause layout and scrolling issues
 *      if the zoom level is changed without refreshing the page. See
 * <a href='http://robert.ocallahan.org/2007/10/tale-of-two-zooms_19.html' target='_blank'>A Tale
 * Of Two Zooms</a>.</li>
 *  <li>Like Chrome and Safari, Firefox has a minimum font size feature which may cause layout
 *      issues when the page zoom is changed without refreshing the page at the new zoom level.
 *      See bug
 *  <a href='https://bugzilla.mozilla.org/show_bug.cgi?id=912159' target='_blank'>912159</a>.</li>
 *  <li>On Windows and Linux, native checkbox and radio button inputs do not scale with the
 *      page zoom. See bug
 *  <a href='https://bugzilla.mozilla.org/show_bug.cgi?id=400364' target='_blank'>400364</a>.</li>
 *  <li>A focus outline might not be drawn around the focus element when zoomed. See bug
 * <a href='https://bugzilla.mozilla.org/show_bug.cgi?id=1050753'
 * target='_blank'>1050753</a>.</li>
 *  <li>The form element autocomplete box does not move when the page zoom is changed. See bug
 *  <a href='https://bugzilla.mozilla.org/show_bug.cgi?id=731150' target='_blank'>731150</a>.</li>
 *  </ul>
 * 
 *  <h3>Internet Explorer</h3>
 *  <ul>
 * <li>IE may draw "seams" on {@link com.smartgwt.client.widgets.EdgedCanvas} objects, which are
 * faint antialiasing artifacts
 *      between the images used to make up the <code>EdgedCanvas</code>. This affects
 * {@link com.smartgwt.client.widgets.Canvas#getShowShadow drop shadows} and showing edges with a
 * high {@link com.smartgwt.client.widgets.Canvas#getEdgeSize Canvas.edgeSize}.</li>
 *  <li>Phantom borders may appear between table cells and other content that should be adjacent
 *      with no separation. This issue is also thought to be the cause of a line appearing below
 *      a selected {@link com.smartgwt.client.widgets.tab.TabSet} tab at certain zoom levels.</li>
 *  <li>SVG content may disappear at high zoom levels.</li>
 *  </ul>
 * 
 *  <h3>Safari and WebKit</h3>
 *  <ul>
 *  <li>Core DOM APIs for querying sizing information of an element may overstate a dimension,
 *      which can impact layout, scrolling, and event handling.</li>
 * <li>Like Chrome and Firefox, Safari supports a minimum font size feature. This can cause layout
 * issues
 * to appear when the page zoom is decreased but the page is not refreshed at the new zoom
 * level.</li>
 *  <li>CSS <code>background-position</code> and background image clipping used for spriting may
 *      be misapplied. This can introduce visual effects where different parts of a sprite are
 *      visible. See bug
 *      <a href='https://bugs.webkit.org/show_bug.cgi?id=45840' target='_blank'>45840</a>.</li>
 *  <li>Background images can be misdrawn at certain zoom levels, where the first or last row
 *      or column of pixels in the image "wrap" to the other side. See bug
 *      <a href='https://bugs.webkit.org/show_bug.cgi?id=125133' target='_blank'>125133</a>.</li>
 * <li>Transparent 1px-wide gaps can appear around the content area of an {@link
 * com.smartgwt.client.widgets.EdgedCanvas},
 *      allowing content below the <code>EdgedCanvas</code> in stacking order to show through.
 *      See bug
 *      <a href='https://bugs.webkit.org/show_bug.cgi?id=122061' target='_blank'>122061</a>.</li>
 * <li>A phantom line may appear below a selected {@link com.smartgwt.client.widgets.tab.TabSet}
 * tab at certain zoom levels.</li>
 *  </ul>
 * 
 *  <h2>Detecting Zoom Changes</h2>
 *  There is no officially supported cross-browser way of detecting zoom, and current approaches
 * rely on hacks that browser vendors seem willing to break or deprecate. These current approaches
 *  are described at
 * <a
 * href='http://stackoverflow.com/questions/1713771/how-to-detect-page-zoom-level-in-all-modern-browsers/'
 * target='_blank'>How to detect page zoom level in all modern browsers?</a>
 * with a small proof-of-concept JavaScript library called <a
 * href='https://github.com/tombigel/detect-zoom' target='_blank'>detect-zoom</a>.
 *  <p>
 * Although the detect-zoom library does not accurately determine the current zoom level, the
 * library
 * can be used in Firefox to detect when the zoom level <em>changes</em> so that a warning message
 *  can be displayed to the user.
 *  <p>
 * Note that the latest version of <code>detect-zoom.min.js</code> that is committed to the GitHub
 *  repository is out of date. It is not recommended to use this file because it causes a runtime
 *  <code>TypeError</code> if the script is included before the document body has been
 * created (see <a href='https://github.com/tombigel/detect-zoom/issues/41' target='_blank'>issue
 * #41</a>).
 *  To rebuild <code>detect-zoom.min.js</code>, you will need to install git, npm, and GNU make.
 *  Then at a terminal, run the following commands:
 *  <pre>git clone https://github.com/tombigel/detect-zoom.git
 * cd detect-zoom
 * npm install
 * touch detect-zoom.js && make</pre>
 *  <p>
 *  
 *  
 *  To use the detect-zoom library in your Smart&nbsp;GWT project:
 *  <ul>
 *  <li>Rebuild the <code>detect-zoom.min.js</code> script.</li>
 *  <li>Create a directory called <code>public</code> in the same directory as your GWT module.
 *      For example, if your GWT module is located at <code>com/mycompany/Product.gwt.xml</code>
 *      then create the <code>com/mycompany/public</code> directory if it does not already exist.
 *      Copy the rebuilt <code>detect-zoom.min.js</code> script to this <code>public</code>
 *      directory.</li>
 *  <li>Add the following &lt;script&gt; tag to your GWT module definition:
 *      <pre>&lt;script src="detect-zoom.min.js"/&gt;</pre></li>
 *  <li>Add the following JSNI method that calls the detectZoom.zoom() API:
 *      <pre>    public static native double detectZoom() /&#42;-{
 *         return $wnd.detectZoom.zoom();
 *     }-&#42;/;</pre></li>
 *  <li>When your module's <code>EntryPoint</code> is called, call the detectZoom() static
 *      method and save the return value. Then add a window resize handler
 * (see <a
 * href='http://www.gwtproject.org/javadoc/latest/com/google/gwt/user/client/Window.html#addResizeHandler-com.google.gwt.event.logical.shared.ResizeHandler-'
 * target='_blank'>Window.addResizeHandler(com.google.gwt.event.logical.shared.ResizeHandler)</a>)
 *      that calls detectZoom() on resize, checking to see if a different value is returned.</li>
 *  </ul>
 *  Here is a complete example:
 *  <p><pre>
 * import com.google.gwt.core.client.EntryPoint;
 * import com.google.gwt.event.logical.shared.ResizeEvent;
 * import com.google.gwt.event.logical.shared.ResizeHandler;
 * import com.google.gwt.user.client.Window;
 * import com.smartgwt.client.util.SC;
 * 
 * public class MyEntryPoint implements EntryPoint {
 * 
 *     public static native double detectZoom() /&#42;-{
 *         return $wnd.detectZoom.zoom();
 *     }-&#42;/;
 * 
 *     &#64;Override
 *     public void onModuleLoad() {
 *         //...
 * 
 *         Window.addResizeHandler(new ResizeHandler() {
 *             private double lastZoom = detectZoom();
 * 
 *             &#64;Override
 *             public void onResize(ResizeEvent event) {
 *                 final double newZoom = detectZoom();
 *                 if (newZoom != lastZoom) {
 *                     lastZoom = newZoom;
 *                     SC.warn("After changing the page zoom, you must refresh the page.");
 *                 }
 *             }
 *         });
 *     }
 * }</pre>
 *  
 *  <h2>Flickering Scrollbars and Workarounds</h2>
 *  When a browser is zoomed, either directly or via OS-level zoom, it can report sizes that are
 *  slightly off and vary unpredictably, which if we took no special action would lead to
 *  flickering scrollbars, thusly:<ul>
 *  <li>we ask the browser the size of the content, it tells us it's big enough that scrollbars
 *  are required
 *  <li>we add scrollbars
 *  <li> because of subpixel measurement bugs, the browser now reports that the size of content
 *  doesn't require scrollbars
 *  <li>we remove scrollbars
 *  <li>because of subpixel measurement bugs, the browser changes its mind and decides that the
 *  same content now requires scrollbars again
 *  <li>we re-add scrollbars</ul>
 *  <p>
 * To work around this issue, we rely the idea of a {@link
 * com.smartgwt.client.widgets.Canvas#getMaxZoomOverflowError maximum zoom overflow error}, the
 * experimental maximum possible error due to subpixel
 *  rendering when browser and/or OS-level zoom is present.  This value is typically one or a
 *  few pixels, but should always be kept as small as possible because it also represents the
 *  maximum amount of unwanted clipping that the Framework might apply to the canvas when
 *  overflow is present.  If too large, it will easily be noticed and may clip the edges of
 *  buttons or other content.
 *  <p>
 *  For example, if you execute the following sample in a zoomed desktop browser, you'll see
 *  that if you try to grab the bottom edge and drag-resize it shorter, some text will be
 *  clipped from the bottom before the scrollbar appears.  This is because the
 * {@link com.smartgwt.client.widgets.Canvas#getMaxZoomOverflowError maximum zoom overflow error}
 * for the sample is 25, a
 *  much larger value than ever needed but illustrative of its potential for clipping content.
 *  <p>
 *  <pre>
 * Canvas pane = new HTMLPane()
 *     .setWidth(230).setHeight(100)
 *     .setShowEdges(true)
 *     .setMaxZoomOverflowError(25).setCorrectZoomOverflow(true)
 *     .setCanDragResize(true).setDragResizeAppearance(DragAppearance.TARGET)
 *     .setContents("Here men from the planet Earth first set foot upon the Moon " + 
 *                  "July 1969, A.D.  We came in peace for all mankind."); 
 *  </pre>
 * <b>Note:</b> the framework should set {@link
 * com.smartgwt.client.widgets.Canvas#getCorrectZoomOverflow Canvas.correctZoomOverflow}
 * automatically
 *  for you where it's needed, so it's set explicitly above to force it to an excessive value.
 *  <p>    
 *  If you can still reproduce the flickering scrollbar problem with our canvas default settings
 *  for your browser and OS, please contact Isomorphic and provide as much detail about your
 *  setup as possible: framework version, skin in use, whether the skin is customized, browser,
 *  browser version, OS platform and version, and any non-default visual settings for the
 *  browser or OS.
 *  <h2>Disabling Browser-level Scrolling</h2>
 *  If native, browser-level scrolling is introduced on the viewport, it can make flickering
 *  more likely by creating situations in which the screen width or height may change outside
 *  the framework's control.  For this reason we recommend disabling it by styling the document
 *  <code>body</code> to have hidden CSS
 * <a href='https://developer.mozilla.org/en-US/docs/Web/CSS/overflow'
 * target='_blank'>overflow</a> via
 *   something like:
 *  <pre>
 *  &lt;body style="overflow:hidden"&gt;</pre>
 *  The framework will log a warning if overflow hasn't been properly suppressed.  To avoid it,
 *  you can set the window property <code>isc_allowViewportScrolling</code> true before
 *  loading the framework files in your HTML.
     * @see com.smartgwt.client.util.Page#getDevicePixelRatio
 */
public interface BrowserZoom {
}
