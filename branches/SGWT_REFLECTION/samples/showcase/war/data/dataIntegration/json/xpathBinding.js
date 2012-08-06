isc.DataSource.create({
    ID:"contacts",
    dataFormat:"json",
    dataURL:"/isomorphic/system/reference/inlineExamples/dataIntegration/json/contactsData.js",
    fields:[
        {name:"name"},
        {name:"email"},
        {name:"organization"},
        {name:"phone"},
        {valueXPath:"address/street", name:"street"},
        {valueXPath:"address/city", name:"city"},
        {valueXPath:"address/state", name:"state"},
        {valueXPath:"address/zip", name:"zip"}
    ]
});

isc.ListGrid.create({
    ID: "boundGrid",
	dataSource: "contacts",
	width: "100%",
	autoFetchData: true
});
