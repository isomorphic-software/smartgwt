package com.smartgwt.client.rpc;


public interface MessagingCallback {

    /**
     *
     * @param data raw "data" property received from the message channel
     */
    void execute(Object data);
}
