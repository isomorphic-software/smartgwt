package com.mycompany.client;

import com.smartgwt.client.widgets.layout.Layout;

class MyContactsImpl {

    void slideTransition(MyContacts self, Layout oldPane, Layout newPane, Layout container, boolean right) {
        container.removeChild(oldPane);
        container.addChild(newPane);
    }
}
