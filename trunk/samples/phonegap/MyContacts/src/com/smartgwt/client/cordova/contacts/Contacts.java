package com.smartgwt.client.cordova.contacts;

import com.google.gwt.core.client.JsArrayString;
import com.smartgwt.client.cordova.types.ContactFilterProperty;
import com.smartgwt.client.util.JSOHelper;

public final class Contacts {

    public static void find(ContactFilterProperty[] contactFields, FindContactsSuccessFunction contactSuccess) {
        find(contactFields, contactSuccess, null);
    }

    public static void find(ContactFilterProperty[] contactFields, FindContactsSuccessFunction contactSuccess, ContactErrorFunction contactError) {
        find(contactFields, contactSuccess, contactError, null);
    }

    public static void find(ContactFilterProperty[] contactFields, FindContactsSuccessFunction contactSuccess, ContactErrorFunction contactError, ContactFindOptions contactFindOptions) {
        if (contactSuccess == null) throw new NullPointerException("contactSuccess");
        final JsArrayString f = (JsArrayString)JSOHelper.convertToJavaScriptArray(contactFields == null ? new String[] { "*" } : contactFields);
        nativeFind(f, contactSuccess, contactError, contactFindOptions);
    }

    private static native void nativeFind(JsArrayString contactFields, FindContactsSuccessFunction contactSuccess, ContactErrorFunction contactError, ContactFindOptions contactFindOptions) /*-{
        $wnd.navigator.contacts.find(contactFields, $entry(function (contacts) {
            contactSuccess.@com.smartgwt.client.cordova.contacts.FindContactsSuccessFunction::execute(Lcom/google/gwt/core/client/JsArray;)(contacts);
        }), contactError == null ? null : $entry(function (error) {
            if (contactError) contactError.@com.smartgwt.client.cordova.contacts.ContactErrorFunction::execute(Lcom/smartgwt/client/cordova/contacts/ContactError;)(error);
        }), contactFindOptions);
    }-*/;

    private Contacts() {}
}
