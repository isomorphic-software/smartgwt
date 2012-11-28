package com.smartgwt.client;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


public class PluginBridges_DeprecatedEntryPoint implements EntryPoint {
    public void onModuleLoad() {
        GWT.log("Note: Deprecated version of SmartGWT PluginBridges module included in this project." +
                " Inherit the module 'com.smartgwt.PluginBridgesWidgets', not 'com.smartgwt.PluginBridges' or 'com.smartgwt.SmartGwtPluginBridges'");
    }


}
