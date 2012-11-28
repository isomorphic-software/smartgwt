package com.smartgwt.client.cordova.contacts;

import com.google.gwt.core.client.JavaScriptObject;

public class ContactError extends JavaScriptObject {

    private static native int getUnknownErrorCode() /*-{
        return $wnd.ContactError.UNKNOWN_ERROR;
    }-*/;
    private static native int getInvalidArgumentErrorCode() /*-{
        return $wnd.ContactError.INVALID_ARGUMENT_ERROR;
    }-*/;
    private static native int getTimeoutErrorCode() /*-{
        return $wnd.ContactError.TIMEOUT_ERROR;
    }-*/;
    private static native int getPendingOperationErrorCode() /*-{
        return $wnd.ContactError.PENDING_OPERATION_ERROR;
    }-*/;
    private static native int getIOErrorCode() /*-{
        return $wnd.ContactError.IO_ERROR;
    }-*/;
    private static native int getNotSupportedErrorCode() /*-{
        return $wnd.ContactError.NOT_SUPPORTED_ERROR;
    }-*/;
    private static native int getPermissionDeniedErrorCode() /*-{
        return $wnd.ContactError.PERMISSION_DENIED_ERROR;
    }-*/;

    public static final int UNKNOWN_ERROR = getUnknownErrorCode(),
            INVALID_ARGUMENT_ERROR = getInvalidArgumentErrorCode(),
            TIMEOUT_ERROR = getTimeoutErrorCode(),
            PENDING_OPERATION_ERROR = getPendingOperationErrorCode(),
            IO_ERROR = getIOErrorCode(),
            NOT_SUPPORTED_ERROR = getNotSupportedErrorCode(),
            PERMISSION_DENIED_ERROR = getPermissionDeniedErrorCode();

    protected ContactError() {}

    public final native int getCode() /*-{
        return this.code;
    }-*/;
}
