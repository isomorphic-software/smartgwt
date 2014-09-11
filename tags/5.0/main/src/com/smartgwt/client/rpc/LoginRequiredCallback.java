package com.smartgwt.client.rpc;

/**
 * The LoginRequred callback.
 */
public interface LoginRequiredCallback {

    /**
     * Called when a session timeout is encountered while trying to do a background RPC.
     *
     * @param transactionNum id of the transaction
     * @param request the first RPCRequest of the transaction
     * @param response the RPCResponse containing the session timeout response that caused loginRequired() to be invoked
     *
     * @see com.smartgwt.client.rpc.RPCManager#setLoginRequiredCallback
     */
    void loginRequired(int transactionNum, RPCRequest request, RPCResponse response);
}
