package com.mycompany.client;

import com.google.gwt.core.client.EntryPoint;

public abstract class CordovaEntryPoint implements EntryPoint {

    @Override
    public final native void onModuleLoad() /*-{
        var self = this;
        if ($wnd.isDeviceReady) self.@com.mycompany.client.CordovaEntryPoint::onDeviceReady()();
        else {
            var listener = $entry(function () {
                try {
                    self.@com.mycompany.client.CordovaEntryPoint::onDeviceReady()();
                } finally {
                    $doc.removeEventListener("deviceready", listener, false);
                }
            });
            $doc.addEventListener("deviceready", listener, false);
        }
    }-*/;

    protected abstract void onDeviceReady();
}
