package com.smartgwt.sample.showcase.client;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.viewer.DetailViewer;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.util.SC;

import com.google.gwt.core.client.JavaScriptObject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;

public class SampleResultsManager implements UncaughtExceptionHandler {

    private static final int DETAILS_STACK_DEPTH = 10;

    // referenced widgets
    private Canvas panel;
    private Canvas parent;
    private Canvas viewer;

    // results to be presented
    private String description;
    private StringBuffer details;

    // current sample test state
    private int pendingRPCs;
    private boolean allComplete;
    private boolean evalComplete;

    // saved handlers allow reinstall after sample test
    private JavaScriptObject         oldErrorHandler;
    private JavaScriptObject         oldRPCErrorHandler;
    private JavaScriptObject         oldTransformResponse;
    private JavaScriptObject         oldTransformRequest;
    private JavaScriptObject         oldTransactionComplete;
    private UncaughtExceptionHandler oldExceptionHandler;

    // manage sample created by factory, hang results off canvas 'parent'
    private SampleResultsManager(PanelFactory factory, Canvas parent) {
        description = factory.getDescription();
        details = new StringBuffer("");
        this.parent = parent;
        attachExceptionHandler();
        attachErrorHandler();
        attachRPCHandlers();
        requestCallback();
    }
    
    // uninstaller handles and display DetailViewer
    private void completeResultsCollection() {
        detachRPCHandlers();
        detachErrorHandler();
        detachExceptionHandler();
        addDetailViewerForTestResults();
        allComplete = true;
    }

    // create DetailViewer for sample test results
    private void addDetailViewerForTestResults() {
        viewer = createDetailViewerForTestResults();
        JSOHelper.setAttribute(viewer.getJsObj(), SC.REF, viewer);
        parent.addChild(viewer);
        viewer.setTop(50);
    }

    private boolean isWidgetInStableState() {
        if (details.length() > 0) {
            return true;
        }
        return panel == null || (panel.isDrawn() && !panel.isDirty());
    }

    // track pending RPCs
    private void incrementRPCs() {
        pendingRPCs++;
    }
    private void decrementRPCs() {
        pendingRPCs--;
    }

    // collect reported errors
    private  void reportError(String error) {
        details.append(error + "\n");
    }

    public void onUncaughtException(Throwable t) {
        String report = t.toString();
        StackTraceElement[] trace = t.getStackTrace();
        for (int i = 0; i < Math.min(trace.length, DETAILS_STACK_DEPTH); i++ ) {
            report += "\n" + trace[i];
        }
        // space replacement improves formatting
        reportError(report.replaceAll(" ", "^"));
    }
    
    // if original stability check already completed,
    // and RPCs just now fell to zero, redo the check
    private void completeRPCs() {
        if (pendingRPCs <= 0 && evalComplete) {
            evalComplete = false;
            requestCallback();
        }
    }
    
    // if widget is not stable, check again after quiescence;
    // otherwise if no RPCs, prepare results for DetailViewer
    private void checkForCompletion() {
        if (isWidgetInStableState()) {
            evalComplete = true;
            if (pendingRPCs <= 0) {
                completeResultsCollection();
            }
        } else {
            requestCallback();     
        }
    }

    private void destroy() {
        if (!allComplete) {
            detachRPCHandlers();
            detachErrorHandler();
            detachExceptionHandler();
            allComplete = true;
        } else if (viewer != null) {
            viewer.destroy();
            viewer = null;
        }
    }

     private native void requestCallback() /*-{
        var wrapper = this;
        var callback = function() {
            if (!wrapper.@com.smartgwt.sample.showcase.client.SampleResultsManager::allComplete) {
                $entry(wrapper.@com.smartgwt.sample.showcase.client.SampleResultsManager::checkForCompletion()());
            }
        }
        var parent = this.@com.smartgwt.sample.showcase.client.SampleResultsManager::parent;
        var object = parent.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        object.fireOnPause("checkForCompletion", callback);
    }-*/;

    private void attachExceptionHandler() {
        oldExceptionHandler = GWT.getUncaughtExceptionHandler();
        GWT.setUncaughtExceptionHandler(this);
    }

    private void detachExceptionHandler() {
        GWT.setUncaughtExceptionHandler(oldExceptionHandler);        
    }

    private native void attachErrorHandler() /*-{
        var wrapper = this;
        this.@com.smartgwt.sample.showcase.client.SampleResultsManager::oldErrorHandler = $wnd.onerror;
        $wnd.onerror = function(msg, url, line) {
            var error = "Javascript Exception at " + url + ", line " + line + ": " + msg;
            $entry(wrapper.@com.smartgwt.sample.showcase.client.SampleResultsManager::reportError(Ljava/lang/String;)(error));
            return true;
        }
    }-*/;

    private native void detachErrorHandler() /*-{
        var oldErrorHandler = this.@com.smartgwt.sample.showcase.client.SampleResultsManager::oldErrorHandler;
        if (oldErrorHandler != null) {
            this.@com.smartgwt.sample.showcase.client.SampleResultsManager::oldErrorHandler = null;
            $wnd.onerror = oldErrorHandler;
        }
    }-*/;

    private native void attachRPCHandlers() /*-{
        var rpc = $wnd.isc.RPCManager;
        this.@com.smartgwt.sample.showcase.client.SampleResultsManager::oldRPCErrorHandler     = rpc.reportError;
        this.@com.smartgwt.sample.showcase.client.SampleResultsManager::oldTransformRequest    = rpc.transformRequest;
        this.@com.smartgwt.sample.showcase.client.SampleResultsManager::oldTransformResponse   = rpc.transformResponse;
        this.@com.smartgwt.sample.showcase.client.SampleResultsManager::oldTransactionComplete = rpc.transactionComplete;

        var wrapper = this;
        rpc.reportError = function (error) {
            $entry(wrapper.@com.smartgwt.sample.showcase.client.SampleResultsManager::reportError(Ljava/lang/String;)(error));
        }
        rpc.transformRequest = function (rpcRequest) {
            $entry(wrapper.@com.smartgwt.sample.showcase.client.SampleResultsManager::incrementRPCs()());
            return rpcRequest.data;
        }
        rpc.transformResponse = function (rpcResponse, rpcRequest, data) {
            $entry(wrapper.@com.smartgwt.sample.showcase.client.SampleResultsManager::decrementRPCs()());
            return rpcResponse;
        }
        rpc.transactionComplete = function () {
            $entry(wrapper.@com.smartgwt.sample.showcase.client.SampleResultsManager::completeRPCs()());
        }
    }-*/;

    private native void detachRPCHandlers() /*-{
        var rpc = $wnd.isc.RPCManager;
        rpc.reportError         = this.@com.smartgwt.sample.showcase.client.SampleResultsManager::oldRPCErrorHandler;
        rpc.transformRequest    = this.@com.smartgwt.sample.showcase.client.SampleResultsManager::oldTransformRequest;
        rpc.transformResponse   = this.@com.smartgwt.sample.showcase.client.SampleResultsManager::oldTransformResponse;
        rpc.transactionComplete = this.@com.smartgwt.sample.showcase.client.SampleResultsManager::oldTransactionComplete;
    }-*/;

    private native DetailViewer createDetailViewerForTestResults() /*-{
        var text = this.@com.smartgwt.sample.showcase.client.SampleResultsManager::description;
        var errors = this.@com.smartgwt.sample.showcase.client.SampleResultsManager::details.toString();
        var results = { result : errors.length > 0 ? "failure" : "success",
                          description : text,
                          detail : errors };
        var parent = this.@com.smartgwt.sample.showcase.client.SampleResultsManager::parent;
        var parentJsObj = parent.@com.smartgwt.client.widgets.Canvas::getOrCreateJsObj()();
        var viewerJsObj = $wnd.isc.AutoTest.createDetailViewerForTestResults(parentJsObj, results);
        var viewer = @com.smartgwt.client.widgets.viewer.DetailViewer::getOrCreateRef(Lcom/google/gwt/core/client/JavaScriptObject;)(viewerJsObj);
        viewer.@com.smartgwt.client.widgets.viewer.DetailViewer::doInit()();
        return viewer;
    }-*/;

    // singleton paradigm for SampleResultsManager

    private static SampleResultsManager singleton;

    private static SampleResultsManager getSingleton(PanelFactory factory, Canvas parent) {
        destroySingletonAndInstallDestroyEntryPoint();
        singleton = new SampleResultsManager(factory, parent);
        return singleton;
    }

    private static native void destroySingletonAndInstallDestroyEntryPoint() /*-{
        var destroyFunction = function () {
            var singleton = @com.smartgwt.sample.showcase.client.SampleResultsManager::singleton;
            if (singleton) {
                $entry(singleton.@com.smartgwt.sample.showcase.client.SampleResultsManager::destroy()());
            }
        }
        if ($wnd.isc_Showcase_1_0.destroySampleResultsManager == null) {
            $wnd.isc_Showcase_1_0.destroySampleResultsManager = destroyFunction;
        }
        destroyFunction();
    }-*/;

    // Collects new results, replacing the previous SampleResultsManager
    public static Canvas create(TabSet tabSet, PanelFactory factory) {
        SampleResultsManager results = getSingleton(factory, tabSet);
        // avoid huge population of tabs
        Tab tab0 = tabSet.getTab(1);
        if (tab0 != null) {
            tabSet.removeTab(tab0);
        }
        // create the sample canvas under test
        try {
            results.panel = factory.create();
        } catch (Exception e) {
            results.onUncaughtException(e);
        }
        return results.panel;
    }
}
