
package com.smartgwt.client.docs;

/**
 * <h3>Mobile Application Development</h3>
 * Smart GWT is designed to automatically adapt to smaller screen sizes and the lower
 *  accuracy of touch-based interfaces.  
 *  <p>
 *  In general, a Smart GWT application written with complete ignorance of mobile development
 *  will still be highly usable on tablet or handset-sized touch devices.  This topic explains
 *  all the automatic behaviors that make this possible, and the few areas developers need to
 *  consider in order to optimize the mobile experience, the most important being:
 *  <p>
 *  <ul>
 *  <li> read about potential issues created by the automatically shown and hidden browser
 *       toolbars in Safari on iOS7+, discussed under "minimal-ui" below.  Smart GWT
 *       automatically handles this, but most applications will want to create a non-interactive
 *       banner to fill the blank screen area that is rendered unusable by iOS' behavior
 *  <li> read about "Automatic touch scrolling" below - if your application does not already
 *       have alternative UIs for performing drag operations (as is required anyway for
 * {@link com.smartgwt.client.docs.Accessibility accessibility reasons}), this section discusses
 * options for
 *       controlling drag scrolling vs dragging of data
 *  <li> review your application for the rare screen that has a fixed, very wide width and
 *       doesn't allow scrolling.  Such screens would already be unusable for narrow desktop
 *       browsers but are more of a problem for fixed-size mobile screens.  The section
 *       "Exceptionally wide screens" below explains strategies for dealing with this.
 *  </ul>
 *  <p>
 *  <h3>Supported Browsers</h3>
 *  <P>
 *  <ul>
 *  <li> Safari on iOS devices (iPad, iPhone, iPod Touch)
 *  <li> Android's default (WebKit-based) browser <b>*</b>
 *  <li> Windows Phone default browser, latest release only <b>**</b>
 *  <li> Blackberry 10+ default (WekKit-based) browser <b>**</b>
 *  </ul>
 *  <b>*</b>: Android issues that occur <i>exclusively</i> on rare devices (under a certain
 *  percent of market share) will not normally be covered by a Support plan.  This is a
 *  necessity because highly customized versions of Android are used for a variety of niche
 *  devices (even microsatellites)<br>
 *  <b>**</b>: These browsers generally work and bug reports are accepted, but they do not yet
 *  fall under the normal Enterprise+ Support guarantee of fixing every confirmed bug 
 *  <p>
 *  If you would like to check whether a specific device falls under normal Support, or would
 *  like a quote for a Support plan that would include a specific device or platform,
 * <a href='http://smartclient.com/company/contact.jsp' target='_blank'>contact Isomorphic
 * here</a>.
 *  <P>
 *  <h3>Adaptive Components</h3>
 *  <p>
 *  Many Smart GWT components automatically change their behavior and/or appearance when used
 *  with touch devices in general, or tablets and handsets specifically.  There are too many
 *  adaptations to comprehensively list, but some of the more obvious behaviors are listed below:
 *  <ul>
 * <li> {@link com.smartgwt.client.widgets.form.fields.SelectItem} and {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem} controls automatically fill the entire
 * screen
 *       or a major portion of the screen when activated, and add a control to dismiss the
 * full-screen interface.  See {@link
 * com.smartgwt.client.widgets.form.fields.ComboBoxItem#getPickListPlacement
 * ComboBoxItem.pickListPlacement} for details
 * <li> {@link com.smartgwt.client.widgets.menu.Menu} components likewise fill the entire screen
 * or a major portion, and offer
 *       submenu navigation via a slide-in animation and back button instead of displaying the
 *       origin menu and submenu simultaneously
 * <li> {@link com.smartgwt.client.widgets.calendar.Calendar#getMinimalUI Calendar} eliminates the
 * tabs normally used to switch between
 *       Day, Week and Month view, instead using device pivot to switch between Day and Week
 *       views and offering a compact link to Month view
 *  <li> Windows and Dialogs fill the screen by default and remove rounded edges to save space
 *  <li> many controls implement an expanded hit area for clicks or drags so that finger touches
 *       that are technically outside of the drawn area of the control still activate the
 *       control.  This accomodates the imprecision of finger touches as compared to mouse
 *       clicks, while still showing the same compact appearance as is used for desktop
 * interfaces.  This includes the {@link com.smartgwt.client.widgets.Slider} thumb, {@link
 * com.smartgwt.client.widgets.Window#getHeaderControls Window.headerControls},
 * {@link com.smartgwt.client.widgets.Canvas#getResizeFrom edge-based resizing}, and many other
 * controls.
 * <li> {@link com.smartgwt.client.widgets.form.fields.SpinnerItem} switches to side-by-side +/-
 * controls instead of the very small,
 *       vertically stacked +/- control typical of desktop interfaces
 * <li> {@link com.smartgwt.client.widgets.menu.AdaptiveMenu} can either display menu items
 * inline, or in a drop-down,
 *         or mix the two modes according to available space.
 *  </ul>
 *  <p>
 * In addition to automatic behavior, Smart GWT offers Adaptive Layout whereby a {@link
 * com.smartgwt.client.widgets.layout.Layout}
 *  member may be <i>designed</i> to render itself at multiple possible sizes, in order to fit
 *  into the amount of space available in the Layout.  Unlike simply indicating a flexible size
 *  on a member, setting an adaptive width or height indicates that the member has two (or more)
 *  different <i>ways</i> of rendering itself with different <i>discrete</I> sizes, but does not
 *  have the ability to use every additional available pixel.
 *  <p>
 * For more guidance, see the documentation under {@link
 * com.smartgwt.client.widgets.Canvas#getCanAdaptWidth Canvas.canAdaptWidth} and the
 * <a href="http://www.smartclient.com/smartgwt/showcase/#custom_adaptation_ms_new"
 * target="examples">Inlined Menu Mobile</a> and 
 * <a href="http://www.smartclient.com/smartgwt/showcase/#adaptive_menu_ms_new"
 * target="examples">Adaptive Menu</a> samples.
 *  <p>
 *  <h3>Finger / touch event handling</h3>
 *  <P>
 *  Mobile and touch devices support "touch events" that correspond to finger actions on the
 *  screen.  By default, Smart GWT simply sends touch events to UI components as normal mouse
 *  events.  Specifically:
 *  <ul>
 *  <li> a finger tap gesture will trigger mouseDown, mouseUp and click events
 *  <li> a touch-and-slide interaction will trigger drag and drop, firing the normal Smart GWT
 *       sequence of dragStart, dragMove, and dragStop
 *  <li> a touch-and-hold interaction will trigger a contextMenu event, and will trigger a hover
 *       if no contextMenu is shown
 *  </ul>
 *  This means that most applications that are written with mouse interaction in mind will
 *  function with a touch-based UI without special efforts.  Some interfaces which rely heavily
 *  on mouse hovers may want to display instructions to explicitly tell the user that they have
 *  to touch a given element to see more information.
 *  <p>
 *  <h3>Automatic touch scrolling</h3>
 *  <p>
 *  Components that normally show scrollbars on desktop browsers will, by default, hide
 *  scrollbars and allow scrolling via finger dragging instead.
 *  <p>
 * If you are using drag and drop features such as {@link
 * com.smartgwt.client.widgets.grid.ListGrid#getCanReorderRecords ListGrid.canReorderRecords},
 * this
 *  obviously conflicts with using finger drags for scrolling.  There are two options:
 *  <p>
 *  <ol>
 *  <li> Leave touch scrolling active for the grid, but provide additional controls, such as
 *       buttons, that enable users to perform the drag operation in a different way.
 *       Optionally display scrollbars <em>in addition to</em> leaving touch scrolling active
 * by setting {@link com.smartgwt.client.widgets.Canvas#getAlwaysShowScrollbars
 * Canvas.alwaysShowScrollbars} to <code>true</code>.
 * <li> Set {@link com.smartgwt.client.widgets.Canvas#getUseTouchScrolling useTouchScrolling} to
 * <code>false</code> on the component.
 *       Scrollbars will be shown, and finger drags will no longer cause scrolling, so that
 *       finger drags can now be used for the drag and drop operation configured on the
 *       component
 *  </ol>
 *  Option #1 above is generally preferred, since it is also considered an
 * {@link com.smartgwt.client.docs.Accessibility} violation if drag and drop is the sole way to
 * trigger an
 *  operation (keyboard-only users cannot use drag and drop), and also because scrollbars are
 *  not usually found in touch interfaces.
 *  <p>
 *  If your application is not required to be keyboard accessible, and you prefer to show
 *  scrollbars and use finger drags for normal drag operations, you can use
 * {@link com.smartgwt.client.widgets.Canvas#getDisableTouchScrollingForDrag
 * Canvas.disableTouchScrollingForDrag} to make this choice system-wide or on a
 *  per-component-type basis.
 *  <p>
 *  <h3>Exceptionally wide screens / forms</h3>
 *  <p>
 *  If you have designed a screen for desktop use and it is too wide to fit on a handset or
 *  tablet-sized screen, there are several possible strategies:
 *  <ul>
 * <li> <b>use {@link com.smartgwt.client.widgets.layout.SplitPane}</b>: any time you have two or
 * more panes where a choice in one
 *       pane decides what is displayed in the other.  See the "SplitPane" section further down
 *       for details
 * <li> <b>rely on horizontal scrolling</b>: if you have something like a {@link
 * com.smartgwt.client.widgets.form.DynamicForm}
 *       that has 3 columns of input fields, as long as the form itself or some parent has
 * {@link com.smartgwt.client.widgets.Canvas#getOverflow overflow:"auto"} set, horizontal touch
 * scrolling will be
 *       available to reach fields that initially render offscreen.  Most of the time, there is
 *       already an <code>overflow:"auto"</code> parent component as a result of default
 *       framework behaviors or application settings that also make sense for desktop mode,
 *       so nothing needs to be done.
 *       <p>
 *       However, consider whether scrolling is already in use for other purposes: if you have a
 *       grid plus an adjacent component to the right, if the adjacent component is entirely
 *       offscreen, attempting touch scrollng on the grid will just scroll the grid as such and
 *       won't reveal the adjacent component.  In this kind of situation, you can:
 *    <ul>
 * <li> <i>use {@link com.smartgwt.client.widgets.layout.SplitPane}</i> as described above, a grid
 * with something adjacent is
 *         frequently a good candidate for conversion to <code>SplitPane</code>
 *    <li> <i>make the scrolling component smaller or flexible size</i>.  Whether it's a grid or
 *         other scrollable component on the left, this situation usually arises because an
 *         inappropriately large fixed size has been set, instead of a
 *         {@link com.smartgwt.client.widgets.Canvas#getWidth flexible size}.
 *    <li> <i>leave some blank space</i> above or below the grid - this gives the user somewhere
 *         to use touch scrolling to move both the grid and adjacent component
 *    <li> <i>force scrollbars to appear</i> by setting
 * {@link com.smartgwt.client.widgets.Canvas#getUseTouchScrolling useTouchScrolling} to false. 
 * This is another way to
 *         give the user a place they can touch in order to scroll the both the grid and
 *         adjacent component together
 *    </ul>
 * <li> <b>use {@link com.smartgwt.client.widgets.layout.FlowLayout}</b>: a
 * <code>FlowLayout</code> can automatically take two
 *       side-by-side elements and switch them to vertical stacking when the screen is narrow
 *  </ul>
 *  <p>
 *  <h3>SplitPane</h3>
 *  <p>
 * The {@link com.smartgwt.client.widgets.layout.SplitPane} component implements the common
 * pattern of rendering
 *  two or three panes simultaneously on desktop machines and on tablets in landscape
 *  orientation, while switching to showing a single pane for handset-sized devices or tablets
 *  in portrait orientation.
 *  <p>
 *  Use <code>SplitPane</code> anywhere you have two or more panes in your application where a
 *  choice in one pane decides what is displayed in the other pane.  For example, you may have a
 *  list of Records where details of a single selected Record are shown next to the list.  A
 *  <code>SplitPane</code> is well-suited to this interface since it provides automatic "Back"
 *  navigation and a place to show the title of the selected record when only the detail view is
 *  showing.
 *  <p>
 *  Note that you do not need to use a <code>SplitPane</code> as your top-level component
 *  containing the whole application, and it <i>does</i> makes sense to use multiple
 *  <code>SplitPane</code> components in a single application.  For example, your top-level
 * container component might be a {@link com.smartgwt.client.widgets.tab.TabSet}, and a {@link
 * com.smartgwt.client.widgets.layout.SplitPane} would be used to manage
 *  components in tabs which normally show 2 panes side-by-side on desktop browsers.
 *  <P>
 *  <h3>Device type and overriding</h3>
 *  <p>
 *  In most cases Smart GWT will correctly detect the device running your application, and set
 * the flags {@link com.smartgwt.client.util.Browser#isTouch isTouch}, {@link
 * com.smartgwt.client.util.Browser#isHandset isHandset}, {@link
 * com.smartgwt.client.util.Browser#isTablet isTablet} and
 *  {@link com.smartgwt.client.util.Browser#isDesktop isDesktop} appropriately.
 *  <p>
 *  For any uncommon device for which these variables are not set correctly, you can use
 * {@link com.smartgwt.client.util.Browser#setIsTablet Browser.setIsTablet()}, {@link
 * com.smartgwt.client.util.Browser#setIsHandset Browser.setIsHandset()} and {@link
 * com.smartgwt.client.util.Browser#setIsTouch Browser.setIsTouch()}
 *  to override the auto-detected settings.  If you use these APIs, call them <b>before</b>
 *  creating or drawing any Smart GWT components or using any other Smart GWT APIs.
 *  <p>
 * Note that the various automatic behaviors triggered by flags on the {@link
 * com.smartgwt.client.util.Browser} class can
 *  be overriden at a fine-grained level on individual components.  For example,
 * {@link com.smartgwt.client.widgets.layout.SplitPane} will use 2-pane display when a tablet is
 * detected, however, for a
 *  particularly large, high-resolution tablet device, you could instead use 3-pane display by
 * setting {@link com.smartgwt.client.widgets.layout.SplitPane#getDeviceMode SplitPane.deviceMode}
 * to "desktop".
 *  <p>
 *  <h3>Mobile look and feel</h3>
 *  <P>
 *  We recommend using either the Enterprise, EnterpriseBlue or Graphite skins for applications
 *  that support mobile (or a custom skin based on one of these skins).  These skins make
 *  maximum use of CSS3 to minimize the number of images that need to be loaded and the number
 *  of DOM elements used to create components.
 *  <p>
 *  We also do <b>not</b> recommend attempting to mimic the native UI of each particular mobile
 *  platform, because:
 *  <ul>
 *  <li> if users access the same application via desktop and mobile browsers, consistent
 *  appearance and behavior between the desktop and mobile rendering of the application is more
 *  important for familiarity than looking similar to other applications on the mobile device
 *  <li> mobile platform design overhauls, such as the major changes from iOS6 to iOS7, can
 *  easily invalidate efforts to look like native applications on the device
 *  <li> there is no single consistent appearance across Android devices because different
 *  manufacturers customize the platform a great deal, so efforts to closely mimic any one
 *  device won't yield any real consistency
 *  </ul>
 *  <P>
 *  <h3>iOS 7, browser toolbars and "minimal-ui" setting</h3>
 *  <p>
 *  Safari in iOS 7.0 will automatically hide and show browser toolbars as the user scrolls
 *  around a normal web page, pivots, or touches near edges of the screen.  This creates serious
 *  problems for web applications, partly because notifications are not reliably fired when
 *  toolbars are shown and hidden, and partly because it introduces "dead zones" where an
 *  application cannot place interactive controls, since touching there shows browser toolbars
 *  instead.
 *  <p>
 *  iOS 7.1 introduces a "minimal-ui" setting on the viewport <code>meta</code> tag which
 *  eliminates most of these problems, by requiring that the user specifically touch the 
 *  URL bar to reveal browser toolbars.  Even with this setting, the top 20px of space <i>in
 *  landscape orientation only</i> is still a "dead zone".
 *  <p>
 *  Smart GWT automatically uses the minimal-ui setting whenever iOS is detected, and also
 * sets {@link com.smartgwt.client.widgets.Canvas#defaultPageSpace defaultPageSpace} to 20px in
 * landscape orientation to avoid components
 *  being placed in the dead zone.  These default behaviors can be disabled by defining the
 *  <code>isc_useMinimalUI</code> global variable with the value <code>false</code> before the
 *  framework is loaded: 
 *  <pre> &lt;script type="text/javascript"&gt;
 *  window.isc_useMinimalUI = false;
 *  &lt;/script&gt;</pre>
 *  <p>
 *  Whether minimal-ui is used or not, it is recommend to place some kind of non-interactive
 * widget or content in the dead zones created by browser toolbars, for example, a {@link
 * com.smartgwt.client.widgets.Label}
 * showing your company name or application name.  When using {@link
 * com.smartgwt.client.widgets.Canvas#defaultPageSpace defaultPageSpace} to have
 *  all components avoid a dead zone at the top of the page, you can set
 * {@link com.smartgwt.client.widgets.Canvas#getLeavePageSpace leavePageSpace:0} to allow
 * individual components to place
 *  themselves in a dead zone.
 *  <p>
 *  <h3>Configuring the viewport</h3>
 *  <p>
 *  When a Smart GWT application loads, by default a viewport &ltmeta&gt; tag is added to the
 *  page which, on touch devices, fixes the page zoom to 100% and disables the pinch-zoom gesture.
 *  This is usually the expected behavior of a touch-enabled web application because it makes
 *  the application look and feel more like a native app. This default setting can be disabled
 *  by defining the <code>isc_useDefaultViewport</code> global variable with the value
 *  <code>false</code> before the framework is loaded:
 *  <pre> &lt;script type="text/javascript"&gt;
 *  window.isc_useDefaultViewport = false;
 *  &lt;/script&gt;</pre>
 *  For more information on the mobile device viewport, see:
 *  <ul>
 * <li><a
 * href='http://developer.apple.com/safari/library/documentation/AppleApplications/Reference/SafariWebContent/UsingtheViewport/UsingtheViewport.html'
 * target='_blank'>Configuring the Viewport - Safari Web Content Guide</a></li>
 * <li><a href='https://developer.mozilla.org/en-US/docs/Mozilla/Mobile/Viewport_meta_tag'
 * target='_blank'>Using the viewport meta tag to control layout on mobile browsers - MDN</a></li>
 *  </ul>
 *  <p>
 *  <h3>Orientation Change &amp; Screen Size</h3>
 *  <P>
 *  When orientation changes, this is treated identically to resizing the browser on a desktop
 *  machine.  If you've already created a UI that fills the browser and makes good use of
 *  available screen space for desktop browsers, the same behaviors will automatically apply
 *  when your application runs on mobile devices and the device is pivoted.
 *  <P>
 *  If you want to build specialized interfaces that respond to device orientation, the
 * {@link com.smartgwt.client.util.Page#getOrientation Page.getOrientation()} API may be used to
 * determine the current orientation of the
 * application, and {@link com.smartgwt.client.types.PageEvent the page orientationChange event}
 * will fire whenever the
 *  user rotates the screen allowing applications or components to directly respond to the user
 *  pivoting their device.
 *  <p>
 *  <h3>Launching native helper apps (phone, facetime, maps..)</h3>
 *  <p>
 *  Generally, all that's required to launch native mobile apps is to create an ordinary HTML
 *  hyperlink (<code>&lt;a&gt;</code> tag) with a special prefix for the URL specified in the
 *  <code>href</code> attribute.  For example, the following HTML link will place a call when
 *  the user finger-taps it:
 *  <pre>
 *    &lt;a href="tel:8675309"&gt;Call Jenny&lt;/a&gt;</pre>
 * You can provide HTML like this as {@link com.smartgwt.client.widgets.HTMLFlow#getContents
 * HTMLFlow.contents}.  Or use a field of
 *  {@link com.smartgwt.client.types.FieldType type:"link"} to cause various
 * {@link com.smartgwt.client.widgets.DataBoundComponent DataBoundComponents} to render a
 * DataSourceField value as a
 *  clickable URL.
 *  <p>
 *  The URL prefixes that are valid for iOS are documented 
 * <a
 * href='https://developer.apple.com/library/ios/featuredarticles/iPhoneURLScheme_Reference/Introduction/Introduction.html#//apple_ref/doc/uid/TP40007899-CH1-SW1'
 * target='_blank'>at Apple.com</a>.
 *  Typically, the same prefixes also work for Android, Windows Phone and others.
 *  <p>
 *  <h3>Configure the soft keyboard</h3>
 *  <p>
 * {@link com.smartgwt.client.widgets.form.fields.TextItem#getBrowserInputType
 * TextItem.browserInputType} can be set to various values such as "email" or "tel"
 *  (telephone number) to hint to mobile devices to use a different software keyboard with
 *  specialized keys appropriate for entering certain types of data values.
 *  <p>
 *  <h3>Note on mobile platform performance</h3>
 *  <p>
 *  When the first modern smartphones were released, it was necessary to use tiny,
 *  mobile-specific frameworks to get adequate performance for mobile web applications.
 *  <p>
 *  The situation is now completely different: through a combination of hardware improvements,
 *  optimizations in mobile browsers and vastly improved network speeds, typical mobile devices
 *  are easily able to run applications built with full-featured web platforms like Smart GWT.
 *  For an application that supports both desktop and mobile interfaces, the worst case scenario
 *  for platform performance is often <b>not</b> a mobile phone, but an older desktop machine
 *  running Internet Explorer.
 *  <p>
 *  Unfortunately, there is a lot of out-of-date advice on the web about mobile web development
 *  that still advises using ultra-light, feature-poor frameworks for performance reasons.
 *  Carefully consider the source and recency of any such advice - the reality is that using
 *  such feature-poor frameworks means you will under-deliver with both your desktop <i>and</i>
 *  mobile interfaces.
 *  <p>
 *  For more background on choosing the right technologies for mobile and desktop web
 *  applications, see the 
 * <a href='http://smartclient.com/product/mobileStrategy.jsp' target='_blank'>Mobile Strategy
 * Page</a> at
 *  smartclient.com.
 *  <P>
 *  <h3>Offline Operation</h3>
 *  <P>
 *  Smart GWT applications support "offline" operation (continuing to work without network
 *  access).
 *  <P>
 *  Permanent caching of resources such as .js, .css files and images are handled via the standard
 * <a href='https://www.google.com/search?q=html5+manifest' target='_blank'>HTML5 Manifest</a> -
 * just list all
 *  the static files your application needs in a manifest file and mobile browsers will cache
 *  those resources.
 *  <P>
 * Dynamic data is handled via the {@link com.smartgwt.client.util.Offline} APIs as well as
 * special DataSource support
 * enabled by {@link com.smartgwt.client.data.DataSource#getUseOfflineStorage
 * DataSource.useOfflineStorage}.
 *  <P>
 *  The end result is that you can bookmark a Smart GWT application to a phone's home screen
 *  and use it offline with cached data, much like an installed native application.
 *  <P>
 *  <h2>Packaging as a native application</h2>
 *  <P>
 * Via "packaging" technologies such as PhoneGap/Cordova and Titanium, a Smart GWT web application
 *  can be packaged as an installable native application that can be delivered via the "App Store"
 * for the target mobile platform.  Applications packaged in this way have access to
 * phone-specific
 * data and services such as contacts stored on the phone, or the ability to invoke the device's
 * camera.
 *  <P>
 *  Both Titanium and PhoneGap provide access to the underlying native device APIs such as the
 *  accelerometer, geolocation, and UI. Both frameworks enable application development using
 *  only JavaScript, CSS and HTML. Additionally they provide development environments that work
 *  across a wide variety of devices.
 *  <P>
 * PhoneGap has good support for native device APIs as noted <a
 * href='http://www.phonegap.com/about/feature' target='_blank'>here</a>.
 *  Titanium has similar support. There are differences between the two environments and how they
 * expose their APIs, though both provide Xcode-compatible projects that can be compiled and run
 * from the Xcode IDE.
 * See {@link com.smartgwt.client.docs.TitaniumIntegration Integration with Titanium} and {@link
 * com.smartgwt.client.docs.PhonegapIntegration Integration with PhoneGap}
 *  for more information.
 * @see com.smartgwt.client.util.Page#getOrientation
 * @see com.smartgwt.client.util.Page#updateViewport
 */
public interface MobileDevelopment {
}
