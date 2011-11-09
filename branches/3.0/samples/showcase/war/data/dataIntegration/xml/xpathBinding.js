isc.DataSource.create({
    ID:"contacts",
    dataFormat:"xml",
    recordXPath:"//contact",
    dataURL:"/isomorphic/system/reference/inlineExamples/dataIntegration/xml/contactsData.xml",
    fields:[
        {name:"name"},
        {name:"email"},
        {name:"organization"},
        {name:"phone"},
        {name:"street", valueXPath:"address/street"},
        {name:"city", valueXPath:"address/city"},
        {name:"state", valueXPath:"address/state"},
        {name:"zip", valueXPath:"address/zip"}
    ]
});

isc.ListGrid.create({
    ID: "boundGrid",
    dataSource: "contacts",
    width: "100%",
    autoFetchData: true
});
