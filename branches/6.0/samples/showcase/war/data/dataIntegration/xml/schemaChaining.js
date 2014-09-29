isc.IButton.create({
    ID:"loadButton",
    title: "Load Schema",
    click : function () {
        isc.XMLTools.loadXMLSchema("/isomorphic/system/reference/inlineExamples/dataIntegration/xml/supplyItem.xsd", 
                                   this.getID()+".loadXMLSchemaReply(schemaSet)");
    },
    loadXMLSchemaReply : function (schemaSet) {
        var schemaDS = schemaSet.getSchema("supplyItem");

        var ds = isc.DataSource.create({
            inheritsFrom:schemaDS,
            useParentFieldOrder:true,
            fields:[
                {name:"itemId", hidden:true, primaryKey:true},
                {name:"itemName", title:"item name"},
                {name:"nextShipment", useTextField:true, title:"next shipment" }
            ]
        });
        listGrid.setDataSource(ds);
        dynamicForm.setDataSource(ds);

        // to demonstrate grid editors, add sample data and start editing
        listGrid.setData([{ itemId:123, itemName:"Sample Item" }]);        
        listGrid.startEditing();

        // to demonstrate validation, use values that will fail validation
        dynamicForm.setValue("unitCost", -1.234);
        dynamicForm.setValue("SKU", "thisSkuIsWayTooLong");
        validateButton.enable();
    }
});


isc.ListGrid.create({ ID: "listGrid", canEdit:true });

isc.DynamicForm.create({ ID: "dynamicForm" });

isc.IButton.create({
    ID: "validateButton",
    title: "Validate",
    click: "dynamicForm.validate()",
    enabled: false,
    top: 450
});

isc.VLayout.create({
    width:"100%",
    height:"100%",
    membersMargin:10,
    members:[loadButton, listGrid, dynamicForm, validateButton]
});
