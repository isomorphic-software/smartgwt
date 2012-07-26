package com.smartgwt.client.cordova.contacts;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.smartgwt.client.util.JSOHelper;

public class Contact extends JavaScriptObject {

    public static native Contact create() /*-{
        return $wnd.navigator.contacts.create();
    }-*/;

    public static native Contact create(String id) /*-{
        return $wnd.navigator.contacts.create({ id: id });
    }-*/;

    protected Contact() {}

    public final native String getID() /*-{
        // The Cordova documentation states that the type of Contact.id is DOMString, but
        // at least with the iOS implementation and Cordova 2.0.0, the type is actually DOMNumber.
        //
        // Make sure that the ID is a DOMString when returning it to Java land to prevent
        // ClassCastExceptions.
        return $wnd.String(this.id);
    }-*/;

    public final native String getDisplayName() /*-{
        return this.displayName;
    }-*/;

    public final native void setDisplayName(String displayName) /*-{
        this.displayName = displayName;
    }-*/;

    public final native ContactName getName() /*-{
        return this.name;
    }-*/;

    public final native void setName(ContactName name) /*-{
        this.name = name;
    }-*/;

    public final native String getNickname() /*-{
        return this.nickname;
    }-*/;

    public final native void setNickname(String nickname) /*-{
        this.nickname = nickname;
    }-*/;

    public final native JsArray<ContactField> getPhoneNumbers() /*-{
        return this.phoneNumbers;
    }-*/;

    public final native void setPhoneNumbers(JsArray<ContactField> phoneNumbers) /*-{
        this.phoneNumbers = phoneNumbers;
    }-*/;

    public final void setPhoneNumbers(ContactField... phoneNumbers) {
        setPhoneNumbers(JSOHelper.convertToJsArray(phoneNumbers));
    }

    public final native JsArray<ContactField> getEmailAddresses() /*-{
        return this.emails;
    }-*/;

    public final native void setEmailAddresses(JsArray<ContactField> emailAddresses) /*-{
        this.emails = emailAddresses;
    }-*/;

    public final void setEmailAddresses(ContactField... emailAddresses) {
        setEmailAddresses(JSOHelper.convertToJsArray(emailAddresses));
    }

    public final native JsArray<ContactAddress> getAddresses() /*-{
        return this.addresses;
    }-*/;

    public final native void setAddresses(JsArray<ContactAddress> addresses) /*-{
        this.addresses = addresses;
    }-*/;

    public final void setAddresses(ContactAddress... contactAddresses) {
        setAddresses(JSOHelper.convertToJsArray(contactAddresses));
    }

    // TODO ims, organizations, birthday, note, photos, categories, urls

    /**
     * Creates a deep copy of this <code>Contact</code> instance, but with the {@link #getID() id}
     * set to <code>null</code>.
     *
     * @return a deep copy of the current <code>Contact</code> instance.
     */
    public final native Contact createDeepCopy() /*-{
        return this.clone();
    }-*/;

    public final void save() {
        remove(null);
    }

    public final void save(SaveContactSuccessFunction contactSuccess) {
        save(contactSuccess, null);
    }

    public final native void save(SaveContactSuccessFunction contactSuccess, ContactErrorFunction contactError) /*-{
        this.save($entry(function (contact) {
            if (contactSuccess) contactSuccess.@com.smartgwt.client.cordova.contacts.SaveContactSuccessFunction::execute(Lcom/smartgwt/client/cordova/contacts/Contact;)(contact);
        }), $entry(function (error) {
            if (contactError) contactError.@com.smartgwt.client.cordova.contacts.ContactErrorFunction::execute(Lcom/smartgwt/client/cordova/contacts/ContactError;)(error);
        }));
    }-*/;

    public final void remove() {
        remove(null);
    }

    public final void remove(ContactSuccessFunction contactSuccess) {
        remove(contactSuccess, null);
    }

    public final native void remove(ContactSuccessFunction contactSuccess, ContactErrorFunction contactError) /*-{
        this.remove($entry(function () {
            if (contactSuccess) contactSuccess.@com.smartgwt.client.cordova.contacts.ContactSuccessFunction::execute()();
        }), $entry(function (error) {
            if (contactError) contactError.@com.smartgwt.client.cordova.contacts.ContactErrorFunction::execute(Lcom/smartgwt/client/cordova/contacts/ContactError;)(error);
        }));
    }-*/;
}
