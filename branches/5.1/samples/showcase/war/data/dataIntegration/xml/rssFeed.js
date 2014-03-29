isc.DataSource.create({
    ID: "newsFeed",
    dataURL: "http://rss.slashdot.org/Slashdot/slashdot",
    recordXPath: "//default:item",
    fields: [
        { name: "title" },
        { name: "link", type: "link" }
    ]
});

isc.ListGrid.create({
    ID: "newsViewer",
	width: "100%",
    height:"300",
	dataSource:"newsFeed",
	autoFetchData: "true"
});
