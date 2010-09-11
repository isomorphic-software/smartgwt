
package com.smartgwt.client.docs;

/**
 * <h3>Development for mobile devices</h3>
 * Smart GWT supports Safari on the Apple iPad, iPhone and iPhone touch platforms. <P> Smart GWT makes writing web
 * applications for deployment on mobile devices  straightforward.  Wherever possible device-specific behavior has been
 * abstracted away allowing developers to provide full featured applications to mobile users using standard Smart GWT
 * components and APIs. <P> Some specific features to be aware of: <ul> <li>The full set of Smart GWT UI components is
 * available on all supported      mobile platforms</li> <li>The standard Smart GWT event model (including click, double
 * click, drag and drop     behavior) is supported. Right click (or "contextMenu") events are also available - these    
 * are triggered by the user holding their finger over a context-menu enabled component</li> <li>We provide the
 * light-weight "Simplicity" skin, with less media, to cut down on     your applications bandwidth requirements</li> </ul>
 * <P> Any Smart GWT application will run on supported mobile platforms. However the limited screen size often makes
 * building a custom application specifically for mobile users a good idea.<br> Safari on the Apple iPod/iPhone supports
 * explicitly configuring the viewport as detailed here: <a
 * href='http://developer.apple.com/safari/library/documentation/AppleApplications/Reference/SafariWebContent/UsingtheViewport/UsingtheViewport.html'
 * onclick="window.open('http://developer.apple.com/safari/library/documentation/AppleApplications/Reference/SafariWebContent/UsingtheViewport/UsingtheViewport.html');return
 * false;">http://developer.apple.com/safari/library/documentation/AppleApplications/Reference/SafariWebContent/UsingtheViewport/UsingtheViewport.html</a>.
 * Including these meta tags in your bootstrap HTML file will allow you to set  a default "zoom level" - how many pixels
 * show up on the screen in landscape or portrait mode as well as disabling the user's standard zoom interactions. We also
 * have  {@link com.smartgwt.client.util.Page#updateViewport an API} to configure the viewport programmatically at
 * runtime.<br> Note that the {@link com.smartgwt.client.util.Page#getOrientation Page.getOrientation} API may be used to
 * determine the current orientation of the application, and {@link com.smartgwt.client.types.PageEvent the page
 * orientationChange event} will fire whenever the user rotates the screen allowing applications to directly respond to the
 * user pivoting their device.
 * @see com.smartgwt.client.util.Page#getOrientation
 * @see com.smartgwt.client.util.Page#updateViewport
 */
public interface MobileDevelopment {
}
