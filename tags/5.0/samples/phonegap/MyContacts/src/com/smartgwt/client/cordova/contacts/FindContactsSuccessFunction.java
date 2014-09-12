package com.smartgwt.client.cordova.contacts;

import com.google.gwt.core.client.JsArray;

public interface FindContactsSuccessFunction {

    public void execute(JsArray<Contact> contacts);
}