package com.smartgwt.client.rpc;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;

/**
 * The error handler callback
 */
public interface HandleErrorCallback {

    /**
     * RPCManager error handler callback.
     *
     * @param response the response
     * @param request the request
     *
     * @see RPCManager#setHandleErrorCallback
     */
    void handleError(DSResponse response, DSRequest request);

}
