
package com.smartgwt.client.docs;

/**
 * <h3>Mobile Application Development</h3>
 * Smart GWT supports building web applications that can be accessed by mobile devices that
 * support modern web browsers, specifically: <ul> <li> Safari on iOS devices (iPad, iPhone, iPod
 * Touch) <li> Android's default (WebKit-based) browser <li> Windows Phone 7 (future, for 'Mango'
 * and up) <li> Blackberry devices that use a WebKit-based browser (future) </ul> <P> <h3>Finger /
 * touch events</h3> <P> Mobile and touch devices support "touch events" that correspond to finger
 * actions on the screen.  By default, Smart GWT simply sends touch events to UI components as
 * normal mouse events.  Specifically: <ul> <li> a finger tap gesture will trigger mouseDown,
 * mouseUp and click events <li> a touch-and-slide interaction will trigger drag and drop, firing
 * the normal Smart GWT      sequence of dragStart, dragMove, and dragStop <li> a touch-and-hold
 * interaction will trigger a contextMenu event, and will trigger a hover      if no contextMenu
 * is shown </ul> This means that most applications that are written initially to target desktop
 * computers need little or no modification in order be able to run on tablet-sized devices (eg
 * the iPad).  For handset-sized devices (phones, iPod touch), conditional logic may need to be
 * added to make different use of the screen real estate. <P> <h3>Adapting to tablets and
 * handsets</h3> Smart GWT provides the {@link com.smartgwt.client.util.Browser#isTablet isTablet}
 * variable which can be used to determine whether a device is tablet-size (e.g. iPad, Nexus 7) or
 * handset-size (phones, iPod touch, and similar smaller form-factor devices). In most cases Smart
 * GWT will correctly determine whether the device running your application is a tablet. For any
 * uncommon device for which this variable is incorrect, you can override Smart GWT's detection
 * logic by defining the <code>isc_isTablet</code> global with the correct value before Smart GWT
 * is loaded. Whenever the <code>isc_isTablet</code> global is defined, Smart GWT will use this
 * value for Browser.isTablet instead of its own detection logic. <P> <h3>Mobile look and
 * feel</h3> <P> We recommend using either the Enterprise, EnterpriseBlue or Graphite skins for
 * applications that support mobile (or a custom skin based on one of these skins).  These skins
 * make maximum use of CSS3 to minimize the number of images that need to be loaded and the number
 * of DOM elements used to create components. <p> We also do <b>not</b> recommend attempting to
 * mimic the native UI of each particular mobile platform, because: <ul> <li> if users access the
 * same application via desktop and mobile browsers, consistent appearance between the desktop and
 * mobile rendering of the application is more important for familiarity than looking similar to
 * other applications on the mobile device <li> there is no single consistent appearance across
 * Android devices because different manufacturers customize the platform a great deal, so there's
 * no single appearance to mimic <li> mobile platform design overhauls, such as the major changes
 * from iOS6 to iOS7, can easily invalidate efforts to look like native applications on the device
 * </ul> <P> <h3>Adapting to Screen Size and Orientation Change</h3> <P> Safari on the Apple
 * iPod/iPhone supports explicitly configuring the viewport as detailed here: <a
 * href='http://developer.apple.com/safari/library/documentation/AppleApplications/Reference/SafariWebContent/UsingtheViewport/UsingtheViewport.html'
 * onclick="window.open('http://developer.apple.com/safari/library/documentation/AppleApplications/Reference/SafariWebContent/UsingtheViewport/UsingtheViewport.html');return
 * false;">http://developer.apple.com/safari/library/documentation/AppleApplications/Reference/SafariWebContent/UsingtheViewport/UsingtheViewport.html</a>.
 * Including these meta tags in your bootstrap HTML file will allow you to set  a default "zoom
 * level" - how many pixels show up on the screen in landscape or portrait mode as well as
 * disabling the user's standard zoom interactions. We also have  {@link
 * com.smartgwt.client.util.Page#updateViewport an API} to configure the viewport programmatically
 * at runtime. <P> It is recommended to start with the following viewport meta tag in the
 * bootstrap HTML file:<br> <br> <code>&lt;meta name="viewport"
 * content="initial-scale=1"&gt;</code><br> <br> .. and then use {@link
 * com.smartgwt.client.util.Page#updateViewport Page.updateViewport} to update the viewport meta
 * tag. On tablet devices (see {@link com.smartgwt.client.util.Browser#isTablet isTablet}), it is
 * recommended to scale the viewport to 125% via:<br> <code>Page.updateViewport(1.25, null, null,
 * true);</code><br> <br> On handsets, it is recommended to set the viewport width to 700 via:<br>
 * <code>Page.updateViewport(null, 700, null, true);</code> <P> Note that the {@link
 * com.smartgwt.client.util.Page#getOrientation Page.getOrientation} API may be used to determine
 * the current orientation of the application, and {@link com.smartgwt.client.types.PageEvent the
 * page orientationChange event} will fire whenever the user rotates the screen allowing
 * applications to directly respond to the user pivoting their device. <P> <h3>Packaging as a
 * native application</h3> <P> Via "packaging" technologies such as PhoneGap/Cordova and Titanium,
 * a Smart GWT web application can be packaged as an installable native application that can be
 * delivered via the "App Store" for the target mobile platform.  Applications packaged in this
 * way have access to phone-specific data and services such as contacts stored on the phone, or
 * the ability to invoke the device's camera. <P> Both Titanium and PhoneGap provide access to the
 * underlying native device APIs such as the accelerometer, geolocation, and UI. Both frameworks
 * enable application development using only JavaScript, CSS and HTML. Additionally they provide
 * development environments that work across a wide variety of devices. <P> PhoneGap has good
 * support for native device APIs as noted <a href='http://www.phonegap.com/about/feature'
 * onclick="window.open('http://www.phonegap.com/about/feature');return false;">here</a>. Titanium
 * has similar support. There are differences between the two environments and how they expose
 * their APIs, though both provide Xcode-compatible projects that can be compiled and run from the
 * Xcode IDE. See {@link com.smartgwt.client.docs.TitaniumIntegration Integration with Titanium}
 * and {@link com.smartgwt.client.docs.PhonegapIntegration Integration with PhoneGap} for more
 * information.
 * @see com.smartgwt.client.util.Page#getOrientation
 * @see com.smartgwt.client.util.Page#updateViewport
 */
public interface MobileDevelopment {
}
