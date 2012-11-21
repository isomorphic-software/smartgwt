	    
package com.smartgwt.client.docs;

/**
 * <h3>Mobile Application Development</h3>
 * Smart GWT supports building web applications that can be accessed by mobile devices that
 * support modern web browsers, specifically: <ul> <li> Safari on iOS devices (iPad, iPhone, iPod
 * Touch) <li> Android's default (WebKit-based) browser <li> Windows Phone 7 (future, for 'Mango'
 * and up) <li> Blackberry devices that use a WebKit-based browser (future) </ul> Via "packaging"
 * technologies such as Titanium and PhoneGap, a Smart GWT web application can be packaged as an
 * installable native application that can be delivered via the "App Store" for the target mobile
 * platform.  Applications packaged in this way have access to phone-specific data and services
 * such as contacts stored on the phone, or the ability to invoke the device's camera. <P> Both
 * Titanium and PhoneGap are open source mobile development frameworks which provide access to the
 * underlying native device APIs such as the accelerometer, geolocation, and UI. Both frameworks
 * enable  application development using only JavaScript, CSS and HTML. Additionally they provide
 * development environments  that work across a wide variety of devices. <P> PhoneGap has good
 * support for native device APIs as noted <a href='http://www.phonegap.com/about/feature'
 * onclick="window.open('http://www.phonegap.com/about/feature');return false;">here</a>. Titanium
 * has similar support. There are differences between the two environments and how they expose
 * their APIs, though both provide Xcode-compatible projects that can be compiled and run from the
 * Xcode IDE. See {@link com.smartgwt.client.docs.TitaniumIntegration Integration with Titanium}
 * and {@link com.smartgwt.client.docs.PhonegapIntegration Integration with PhoneGap} for more
 * information. <P> <h3>Finger / touch events</h3> <P> Mobile and touch devices support "touch
 * events" that correspond to finger actions on the screen.  By default, Smart GWT simply sends
 * touch events to UI components as normal mouse events.  Specifically: <ul> <li> a finger tap
 * gesture will trigger mouseDown, mouseUp and click events <li> a touch-and-slide interaction
 * will trigger drag and drop, firing the normal Smart GWT      sequence of dragStart, dragMove,
 * and dragStop <li> a touch-and-hold interaction will trigger a contextMenu event, and will
 * trigger a hover      if no contextMenu is shown </ul> This means that most applications that
 * are written initially to target desktop computers need little or no modification in order be
 * able to run on tablet-sized devices (eg the iPad).  For handset-sized devices (phones, iPod
 * touch), conditional logic may need to be added to make different use of the screen real estate.
 * <P> <h3>Mobile look and feel</h3> <P> The "Mobile" skin should be used whenever mobile devices
 * are detected.  This skin roughly mimics the appearance of the iOS default widgets wherever
 * there is an iOS widget that corresponds closely to a given Smart GWT widget.  It also makes
 * extensive use of CSS3 to minimize the use of images while still providing an attractive look
 * and feel. <P> In addition, this skin also changes the behavior of some Smart GWT widgets to
 * match the UI idioms common on mobile devices.  For example, the TabSet component switches to
 * bottom-oriented tabs, which are flush together (no gaps).  If there are more than a certain
 * number of tabs, a special "More" tab appears which lists other remaining tabs.  Among other
 * examples, this is the behavior of the "iPad" application on iOS devices, and is an efficient
 * use of minimal screen real estate which feels natural when used on a mobile device. <P> In
 * order to detect whether to use the Mobile skin, because of the rapid proliferation of mobile
 * devices, we recommend using server-side detection based on the User-Agent HTTP header, and
 * using conditional logic (such as logic in a .jsp) to load the "Mobile" skin specifically for
 * these devices. <P> <h3>Adapting to Screen Size and Orientation Change</h3> <P> Safari on the
 * Apple iPod/iPhone supports explicitly configuring the viewport as detailed here: <a
 * href='http://developer.apple.com/safari/library/documentation/AppleApplications/Reference/SafariWebContent/UsingtheViewport/UsingtheViewport.html'
 * onclick="window.open('http://developer.apple.com/safari/library/documentation/AppleApplications/Reference/SafariWebContent/UsingtheViewport/UsingtheViewport.html');return
 * false;">http://developer.apple.com/safari/library/documentation/AppleApplications/Reference/SafariWebContent/UsingtheViewport/UsingtheViewport.html</a>.
 * Including these meta tags in your bootstrap HTML file will allow you to set  a default "zoom
 * level" - how many pixels show up on the screen in landscape or portrait mode as well as
 * disabling the user's standard zoom interactions. We also have  {@link
 * com.smartgwt.client.util.Page#updateViewport an API} to configure the viewport programmatically
 * at runtime. <P> Note that the {@link com.smartgwt.client.util.Page#getOrientation
 * Page.getOrientation} API may be used to determine the current orientation of the application,
 * and {@link com.smartgwt.client.types.PageEvent the page orientationChange event} will fire
 * whenever the user rotates the screen allowing applications to directly respond to the user
 * pivoting their device.
 * @see com.smartgwt.client.util.Page#getOrientation
 * @see com.smartgwt.client.util.Page#updateViewport
 */
public interface MobileDevelopment {
}
