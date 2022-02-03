
package com.smartgwt.client.docs;

/**
 * <h3>Remote Debugging</h3>
 * In Pro and better builds (and also the Eval build), the Smart GWT {@link
 * com.smartgwt.client.docs.Debugging Developer Console} supports debugging remote pages,
 * including those running on mobile devices.  With remote debugging, you can use all of the
 * powerful debugging features of the {@link com.smartgwt.client.docs.Debugging Developer Console}
 * - the component hierarchy (Watch tab), client/server requests (RPC tab), logs and log
 * categories - using the large screen and physical keyboard of a desktop machine. <P> <h4>Using
 * Remote Debugging</h4> <P> To enable remote debugging on a page, just add
 * <code>isc_remoteDebug=true</code> to the page URL.  For example: <p>   <a
 * href='http://localhost:8080/?isc_remoteDebug=true'
 * target='_blank'>http://localhost:8080/?isc_remoteDebug=true</a>  </p> Note in the URL above,
 * set localhost to the actual hostname or IP address of the machine running the SDK. <P> You'll
 * also need to be sure that your {@link com.smartgwt.client.util.Page#setIsomorphicDir
 * isomorphicDir} has been set up correctly and that messaging is enabled on your server as noted
 * below. <p> Then direct your <i>desktop</i> browser to the Developer Console in the 
 * <code>system/helpers/</code> subdirectory of your isomorphic dir - typically: <p>   <a
 * href='http://localhost:8080/showcase/sc/system/helpers/Log.html'
 * target='_blank'>http://localhost:8080/showcase/sc/system/helpers/Log.html</a>  </p> At top
 * right of the page, you will see a "Remote" dropdown that lists the devices and URLs that have
 * registered for remote debugging (by passing the <code>isc_remoteDebug</code> parameter).  As
 * you roll over the available remote targets in this dropdown, the target page will glow blue to
 * make it easy to tell which page you will be selecting for debugging - this is particularly
 * handy when you have a lot of devices.  Pick the page to debug and just starting using the
 * {@link com.smartgwt.client.docs.Debugging Developer Console} as normal. <p> If you reload the
 * page on your mobile device, the remote Developer Console automatically re-establishes the
 * connection.  And any settings - such as Logging Preferences or Watch tab settings -
 * automatically persist as they normally would. <p> <h4>Licensing</h4> <p> Anyone with a Pro or
 * better license can use the Remote Debugging feature. Under the covers, the Remote Debugging
 * feature actually uses the Real-time Messaging module, which is not a Pro feature.  However
 * we've rearranged things so that Pro users can use Real-time Messaging <i>just for Remote
 * Debugging</i>. This does mean that, if you are upgrading your environment to the current
 * release and you don't already have Real-time Messaging, you will need to follow the
 * installation steps normally required for Real-time Messaging before the Remote Debugging
 * feature will work. See the {@link com.smartgwt.client.docs.Messaging} documentation for
 * details.
     * @see com.smartgwt.client.docs.Debugging
 */
public interface RemoteDebugging {
}
