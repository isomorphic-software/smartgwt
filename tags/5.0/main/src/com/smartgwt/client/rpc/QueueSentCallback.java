package com.smartgwt.client.rpc;

import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DSRequest;

public interface QueueSentCallback {

    /**
     * <p>This method is called by the RPCManager every time it sends a queue of requests to the
     * server (note that if you not using queuing, the system simply sends queues containing
     * just one request, so this API is valid regardless).
     * <p/>
     * It is intended to be used by user code that needs to be notified when SmartGWT sends
     * requests to the server.  Note that the list of {@link com.smartgwt.client.rpc.RPCRequest}'s passed to this
     * method is strictly <b>read-only</b>.
     *
     * @param requests the rpc requests
     */
    void queueSent(RPCRequest[] requests);

}
