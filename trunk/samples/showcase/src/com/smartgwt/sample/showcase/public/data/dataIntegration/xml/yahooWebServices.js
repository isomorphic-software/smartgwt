isc.DataSource.create({
    ID:"yahooImageSearch",
    xmlNamespaces : {yahoo:"urn:yahoo:srchmi"},  
    recordXPath:"/yahoo:ResultSet/yahoo:Result",
    dataURL:"http://api.search.yahoo.com/ImageSearchService/V1/imageSearch",
    fields:[
        {imageHeight:"imageHeight", imageWidth:"imageWidth", width:"150", type:"image", 
                   valueXPath:"yahoo:Thumbnail/yahoo:Url",name:"Thumbnail"},
        {type:"integer", hidden:true, valueXPath:"yahoo:Thumbnail/yahoo:Width", 
                    name:"imageWidth"},
        {type:"integer", hidden:true, valueXPath:"yahoo:Thumbnail/yahoo:Height", 
                     name:"imageHeight"},
        {name:"Title"},
        {name:"Summary"},
        {target:"_blank", type:"link", title:"Full Image", valueXPath:"yahoo:Url", 
                   name:"FullImage"}
    ]
});

isc.SearchForm.create({
    ID:"searchForm",
	top: 40,
    numCols:3,
    items : [
        { name:"query", title:"Query", type:"text", defaultValue:"snowboarding" },
        { type:"button", title:"Search", click:"form.doFetch()", startRow:false },
        // appid must part of form post
        { type:"hidden", name: "appid", defaultValue:"YahooDemo"}

    ],
	doFetch : function () {
	    imageGrid.fetchData(searchForm.getValuesAsCriteria());
	}
});

isc.ListGrid.create({
    ID:"imageGrid",
    top:80,
    width:"100%",
    height:300,
    wrapCells:true,
    fixedRecordHeights:false,
    showAllRecords:true,
    alternateRecordStyles:true,
    dataSource:"yahooImageSearch"
});

searchForm.doFetch();


// required Yahoo attribution image
isc.Canvas.create({
	ID: "YahooAttribution",
    height:30,
	contents: "<a href='http://developer.yahoo.net/about'>"
			  +"<img src='http://us.dev1.yimg.com/us.yimg.com/i/us/nt/bdg/websrv_88_1.gif' border='0'>"
			  +"</a>"
});
