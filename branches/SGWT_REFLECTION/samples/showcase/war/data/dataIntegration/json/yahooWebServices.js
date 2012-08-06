isc.XJSONDataSource.create({
    ID:"yahooImageSearch",
    recordXPath:"/ResultSet/Result",
    dataURL:"http://api.search.yahoo.com/ImageSearchService/V1/imageSearch?appid=YahooDemo&output=json",
    fields:[
        {imageHeight:"imageHeight", imageWidth:"imageWidth", width:"150", type:"image", 
                   valueXPath:"Thumbnail/Url",name:"Thumbnail"},
        {type:"integer", hidden:true, valueXPath:"Thumbnail/Width", name:"imageWidth"},
        {type:"integer", hidden:true, valueXPath:"Thumbnail/Height", name:"imageHeight"},
        {name:"Title"},
        {name:"Summary"},
        {target:"_blank", type:"link", title:"Full Image", valueXPath:"Url", name:"FullImage"}
    ]
});

isc.SearchForm.create({
    ID:"searchForm",
	top: 40,
    numCols:3,
    items : [
        { name:"query", title:"Query", type:"text", defaultValue:"snowboarding" },
        { type:"button", title:"Search", click:"form.doFetch()", startRow:false }
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
    height:31,
	contents: "<a href='http://developer.yahoo.net/about'>"
			  +"<img src='http://us.dev1.yimg.com/us.yimg.com/i/us/nt/bdg/websrv_88_1.gif' border='0'>"
			  +"</a>"
});
