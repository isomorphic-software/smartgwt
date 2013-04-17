package com.smartgwt.client.rpc;

import com.smartgwt.client.rpc.RPCCallback;
import com.smartgwt.client.util.SC;

/**
 * The Messaging class provides APIs to make use of SmartGWT Real-Time Messaging module, an
 * optional module available with SmartGWT Power or Enterprise Edition which allows browser based web applications to
 * publish and subscribe to HTTP Messaging channels, allowing the application to receive (and send) messages
 * delivered via server push for "real-time" updates from the server without polling.
 * <P>
 * To use this class, you will need to inherit <code>RealtimeMessaging</code> or 
 * <code>RealtimeMessagingNoScript</code> from the <code>messaging.jar</code>
 * (required for client side functionality only), and include the <code>isomorphic_messaging</code>
 * and <code>isomorphic_js_parser</code> jar files for deployment on the server.
 * <P>
 * See the Messaging Quick Reference PDF file for more information on the optional Messaging module.
 *  
 */
public class Messaging {
    /**
     * Set the url of the messaging servlet. 
     * 
     * @param URL May be prefixed with [ISOMORPHIC] to use the isomorphicDir
     */
	public static native void setMessagingURL(String URL) /*-{
	    if ($wnd.isc.Messaging == null) return;
		$wnd.isc.Messaging.messagingURL = URL;
	}-*/;
	
	/**
	 * Get the URL of the messaging servlet.
	 * @return
	 */
	public static native String getMessagingURL() /*-{
	    if ($wnd.isc.Messaging == null) return null;
		return $wnd.isc.Messaging.messagingURL;
    }-*/;

	/**
	 * Specifies how long we wait for the handshake to the server to complete, before trying again.
	 * @param timeout in ms
	 */
	public static native void setConnectTimeout(int timeout) /*-{
	    if ($wnd.isc.Messaging == null) return;
		$wnd.isc.Messaging.connectTimeout = timeout;
	}-*/;

	public static native int getConnectTimeout() /*-{
	    if ($wnd.isc.Messaging == null) return 0;
		return $wnd.isc.Messaging.connectTimeout;
	}-*/;
	
	/**
	 * Actually send data to a list of channels. Each browser subscribed to the specified channel will be sent this
	 * data from the server in realtime.
	 * <P>
	 * Note that the data is of type Object - typically this will be just a String.
	 * To send a complex data type such as a Map to the server, use the JSOHelper utility to get a
	 * JavaScript equivalent and pass in the JavaScriptObject.
	 * @param channels
	 * @param data
	 * @param callback
	 */
	public static void send (String[] channels, Object data, RPCCallback callback) {
	    checkMessagingLoaded();
		sendJS(channels, data, callback);
	}
	/**
     * Actually send data to a channel. Each browser subscribed to the specified channel will be sent this
     * data from the server in realtime.
     * <P>
     * Note that the data is of type Object - typically this will be just a String.
     * To send a complex data type such as a Map to the server, use the JSOHelper utility to get a
     * JavaScript equivalent and pass in the JavaScriptObject.
     * @param channels
     * @param data
     * @param callback
     */
	public static void send (String channel, Object data, RPCCallback callback) {
		String[] channels = new String[] {channel};
		send(channels, data, callback);
	}
	
	private static native void sendJS(String[] channels, Object data, RPCCallback callback) /*-{
		
		var jsCallback = function (rpcResponse, data, rpcRequest) {
			if (callback == null) return;
			var responseJ = @com.smartgwt.client.rpc.RPCResponse::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcResponse);
            var requestJ = @com.smartgwt.client.rpc.RPCRequest::new(Lcom/google/gwt/core/client/JavaScriptObject;)(rpcRequest);
            callback.@com.smartgwt.client.rpc.RPCCallback::execute(Lcom/smartgwt/client/rpc/RPCResponse;Ljava/lang/Object;Lcom/smartgwt/client/rpc/RPCRequest;)(responseJ, data, requestJ);
        };
        
        var jsChannels = @com.smartgwt.client.util.JSOHelper::convertToJavaScriptArray([Ljava/lang/Object;)(channels);
        $wnd.isc.Messaging.send(jsChannels, data, jsCallback);
        
	}-*/;
	

	/**
	 * Returns list of channels that we're currently subscribed to.
	 * @return
	 */
	public static native String[] getSubscribedChannels () /*-{
	    if ($wnd.isc.Messaging == null) return null;
		var channels = $wnd.isc.Messaging.getSubscribedChannels();
		// convert to string array and return
		return @com.smartgwt.client.util.JSOHelper::convertToJavaStringArray(Lcom/google/gwt/core/client/JavaScriptObject;)(channels);
	}-*/;
	
	/**
	 * Call to subscribe to channel.  This will cause a reconnect to the server - for this reason we
	 * defer the actuall reconnect to allow for multiple subscribe() calls in sequence.
	 * @param channel name of the channel we are subscribing to.
	 * @param callback this will execute whenever data is received from the server on this messaging channel.
	 */
	public static void subscribe(String channel, MessagingCallback callback) {
	    checkMessagingLoaded();
	    subscribeJS(channel, callback);
	}
	
	private static native void subscribeJS(String channel, MessagingCallback callback) /*-{
			
		var jsCallback = function (data) {
			if (callback == null) return;
			callback.@com.smartgwt.client.rpc.MessagingCallback::execute(Ljava/lang/Object;)(data);
        };
        
        $wnd.isc.Messaging.subscribe(channel, jsCallback);
        
	}-*/;
	
	/**
	 * call to unsubscribe from channel(s).  This will cause a reconnect to the server - for this reason
	 * we defer the actual reconnect to allow for multiple unsubscribeToChannel() calls in
	 * sequence.
     * @param channel
	 */
	public static native void unsubscribe (String channel) /*-{
	    if ($wnd.isc.Messaging == null) return;
		$wnd.isc.Messaging.unsubscribe(channel);
	}-*/;
	
	/**
	 * Returns true if we are currently connected to any channels.
	 * @return
	 */
	public static native boolean connected () /*-{
	    if ($wnd.isc.Messaging == null) return false;
		var connected = $wnd.isc.Messaging.connected();
		if (connected == null) connected = false;
		return connected;
	 }-*/;
	
	/**
	 * disconnect from all channels
	 */
	public static native void disconnect() /*-{
	    if ($wnd.isc.Messaging == null) return;
		$wnd.isc.Messaging.disconnect();
	}-*/;
	
	// For the major APIs (subscribe / send) we explicitly check for the Messaging components being present and
	// throw an error if they are not.
	private static void checkMessagingLoaded () {
        if (!messagingLoaded()) {
            String errorMessage = "Attempt to use Messaging APIs without the optional Realtime Messaging module. " +
                "Verify that your license includes this optional module and that you have included the necessary " +
                "client and server-side components in your project.";
            SC.logWarn(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }

    /**
     * Static method indicating whether the optional RealtimeMessaging module is loaded for the page.
     * The Messaging class cannot function without this module being present.
     * @return true if the RealtimeMessaging module is present
     */
    public static boolean messagingLoaded() {
        return SC.hasRealtimeMessaging();
    }

    
}
