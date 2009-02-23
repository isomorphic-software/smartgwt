package com.smartgwt.client.rpc;

import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DSRequest;

/**
 * The error handler callback
 */
public interface HandleErrorCallback {

    /**
     *
     * @param response
     * @param request
     *
     * @see RPCManager#setHandleErrorCallback
     */
    void handleError(DSResponse response, DSRequest request);

}
