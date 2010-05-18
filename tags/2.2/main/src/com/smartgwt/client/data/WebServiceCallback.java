package com.smartgwt.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.rpc.RPCResponse;

public interface WebServiceCallback {

    void execute(Object[] data, JavaScriptObject xmlDoc, RPCResponse rpcResponse, JavaScriptObject wsRequest);
}
