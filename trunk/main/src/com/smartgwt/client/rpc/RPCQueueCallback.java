package com.smartgwt.client.rpc;

public interface RPCQueueCallback {

    /**
     * Callback to fire when a queue of requests sent via {@link com.smartgwt.client.rpc.RPCManager#sendQueue(RPCQueueCallback)} returns.
     * @param array of responses returned from the sent queue of requests
     */
    void execute(RPCResponse[] responses);
}
