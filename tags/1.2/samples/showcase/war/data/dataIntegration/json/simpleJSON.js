isc.DataSource.create({
    ID:"countries",
    dataFormat:"json",
    dataURL:"/isomorphic/system/reference/inlineExamples/dataIntegration/json/countries_small.js",
    fields:[
        {title:"Name", name:"name"},
        {title:"Population", name:"population"},
        {title:"Total Area", name:"total_area"},
        {title:"Government", name:"government"}
    ]
});


isc.ListGrid.create({
    width: "100%",
    height: 150,
    dataSource: "countries",
    autoFetchData: true
});