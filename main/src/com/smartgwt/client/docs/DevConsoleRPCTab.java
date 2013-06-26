
package com.smartgwt.client.docs;

/**
 * <h3>The Developer Console RPC Tab</h3>
 * The "RPC" tab of the Smart GWT Developer Console allows you to track  {@link
 * com.smartgwt.client.rpc.RPCRequest}s and {@link com.smartgwt.client.data.DSRequest}s sent from
 * your application.  Tracking is activated by checking the "Track RPCs" box at the top of the
 * tab. <p> The main "RPC History" list shows the transactions that have been sent from your
 * application since the session began (since you checked the "Track RPCs" box or refreshed your
 * browser, whichever happened most recently).  Each entry in the list represents either a server
 * roundtrip, a DSRequest to a clientOnly DataSource or a direct request to a webservice.   {@link
 * com.smartgwt.client.rpc.RPCManager#startQueue Request queues} are shown as separate entries,
 * with the requests that made up the queue shown indented beneath it. <p> Each entry in the RPC
 * History list shows useful diagnostic information, including: <ul> <li>Whether the request was
 * sent via a server-side proxy</li> <li>The URL of the request, or an indication that the request
 * was client-only</li> <li>The type of request - {@link com.smartgwt.client.data.DSRequest},
 * {@link com.smartgwt.client.rpc.RPCRequest},     {@link com.smartgwt.client.data.WSRequest} or
 * {@link com.smartgwt.client.rpc.RPCManager#startQueue Queue}</li> <li>The DataSource name,
 * operation type and operation ID</li> <li>The success/failure status of the request, if it has
 * completed</li> <li>Basic timing information</li> </ul> In addition, clicking an entry in the
 * RPC History list populates the "Request" and "Response" sections with the details of the
 * request. <p> <h2>Detailed timing/profiling information</h2> <P> Smart GWT and Smart GWT Server
 * can gather detailed profiling information for a  request/response roundtrip, and display it in
 * the Developer Console.  Note, the server-side information is only available for DSRequests, and
 * only if you are using the Smart GWT  Server module.  Extra levels of server-side detail are
 * available if you are also using one  of Smart GWT Server's built-in DataSource types (note, at
 * the time of writing this only  applies to SQLDataSource).  To enable detailed timings: <ul>
 * <li>Set debug log category "RpcTabTiming" to INFO level in "Logging Preferences" (see     
 * {@link com.smartgwt.client.docs.Debugging} for details)</li> <li>If you want to collect details
 * of the server-side processing, either:     <ul>     <li>Set <code>DSRequest.returnTimingData:
 * true</code> in your <code>server.properties</code>          file.  This will cause server
 * timing information to be gathered and returned for          every DSRequest from every
 * client</li>     <li>Enable the built-in RPCs "areServerTimingsTracked" and "trackServerTimings"
 * via the         <code>RPCManager.enabledBuiltinMethods</code> setting of your
 * <code>server.properties</code>         file (these builtin RPCs should already be enabled in a
 * development environment).          When these built-in RPCs are enabled, server timing data can
 * be switched on and          off on a per-client basis, via a checkbox in the Developer
 * Console.</li>     </ul>  </li> </ul> With these settings in place, an extra "Timing" tab
 * appears in the "Request" section: <p> <img src="skin/detailedTiming1.png" width="1059px"
 * height="275px"> <p> The timing data is tree-structured; a node with an opener next to it can be
 * expanded to  drill into more detail: <p> <img src="skin/detailedTiming2.png" width="1059px"
 * height="701px"> <p> The following important points apply to the detailed timing information:
 * <ul> <li>It is meaningless to compare the actual start and end timestamps reported by the
 * client     with those reported by the server, because their clocks are unlikely to be exactly  
 * synchronized (unless the client and the server are the same physical machine).  The     
 * timestamps are the underlying raw data - it is much more meaningful to consider the     
 * elapsed times than the timestamps</li> <li>The basic timing details reported in the main RPC
 * History list do not correspond to the     detailed timing data because the detailed timing data
 * attempts to cover the entire      period of the transaction, from the UI event to calling the
 * user callback method.  By      contrast, the basic timing data only covers the period from when
 * the request left the      client to when the response was received by the client.  The basic
 * timing "Time Sent"      and "Elapsed time" figures correspond to the "Server roundtrip" entry
 * in the detailed      timing data</li> <li>The "Network time (inferred)" measurements are
 * informed guesswork.  We calculate the     difference between the "Server turnaround" time
 * measured by the client and the "Server     processing" time measured by the server, and apply
 * half of that difference to either side     of the "Server processing" figure as "Network time
 * (inferred)".  Note that this guesswork     can easily mean that network timings overlap with
 * server processing timings, even when the      client and the server are the same machine</li>
 * <li>The "UI event to DSRequest creation" timing measures the time from the most recent event   
 * to be registered by the EventHandler subsystem, to that of DSRequest creation (and      hence,
 * incidentally, is not recorded for RPCRequests).  This is often a meaningful thing     to
 * measure, but not always.  If the DSRequest was created programatically during application     
 * startup or off the back of a timer, then the most recent UI event clearly had no influence     
 * and so measuring the time since it happened has no meaning.  However, most DSRequests     
 * <em>are</em> created, directly or indirectly, as a result of a UI event; so even though we     
 * can't tell which DSRequests belong to events and which don't, we still provide the figure     
 * in the timing data as something that will be "often useful"</li> </ul>
 */
public interface DevConsoleRPCTab {
}
