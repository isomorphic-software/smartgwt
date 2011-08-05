package com.smartgwt.client.event;

public interface Cancellable {

    void cancel();

    boolean isCancelled();
}
