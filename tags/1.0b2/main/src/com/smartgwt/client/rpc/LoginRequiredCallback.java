package com.smartgwt.client.rpc;

/**
 * The LoginRequred callback.
 */
public interface LoginRequiredCallback {

    /**
     *
     * @param transactionNum
     * @param request
     * @param response
     *
     * @see com.smartgwt.client.rpc.RPCManager#setLoginRequiredCallback
     */
    void loginRequired(int transactionNum, RPCRequest request, RPCResponse response);
}
