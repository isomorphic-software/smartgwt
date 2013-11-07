isc.DataSource.create({
    ID: "users",
    dataFormat: "xml",
    dataURL: "/isomorphic/system/reference/inlineExamples/dataIntegration/xml/serverValidationErrors/serverResponse.xml",
    fields: [
        {name: "userName", title: "Username", type: "text", required: true, length: 50},
        {name: "firstName", title: "First Name", type: "text", required: true, length: 50},
        {name: "lastName", title: "Last Name", type: "text", required: true, length: 50},
        {name: "email", title: "Email", type: "text", required: true, length: 100},
        {name: "password", title: "Password", type: "password", required: true, length: 20}
    ],
    transformResponse : function (dsResponse, dsRequest, xmlData) {
        var status = isc.XMLTools.selectString(xmlData, "/response/status");
        if (status != "success") {
            dsResponse.status = isc.RPCResponse.STATUS_VALIDATION_ERROR;
            var errors = isc.XMLTools.selectNodes(xmlData, "/response/errors");
            dsResponse.errors = isc.XMLTools.toJS(errors);
        }
    }
});

isc.DynamicForm.create({
    ID: "boundForm",
    dataSource: "users",
    values : {
        userName: "bsmith",
        firstName: "Bob",
        lastName: "Smith",
        email: "bob@smith.com",
        password: "sekrit"
    }
});

isc.VLayout.create({
    members: [
        boundForm,
        isc.IButton.create({
            title: "Save",
            click : function () {
                if (boundForm.validate()) boundForm.saveData();
            }
        })
    ]
});