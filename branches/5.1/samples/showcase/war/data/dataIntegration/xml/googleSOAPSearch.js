isc.VLayout.create({
	width: "100%",
	height: "100%",
	members: [

isc.SearchForm.create({
	ID: "searchForm",
	numCols: 4,
	wsdlLoaded: function () {
		isc.clearPrompt();
	    var service = isc.WebService.get("urn:GoogleSearch");
		if (service == null) {
			isc.warn("WSDL not currently available from Google (tried"
					+"http://api.google.com/GoogleSearch.wsdl)");
		}
    
        // bind the SearchForm to a DataSource representing the operation inputs
		this.setDataSource(service.getInputDS("doGoogleSearch"));

        // bind the ListGrid to a DataSource that will show selected operation outputs
        var googleResults = isc.DataSource.create({
            serviceNamespace : service.serviceNamespace,
            wsOperation : "doGoogleSearch",
            recordName : "ResultElement", 
            fields : [
                { name:"URL" },
                { name:"snippet" },
                { name:"title" }
            ]
        });
        searchResults.setDataSource(googleResults);

		this.setValues({
		    key: "/90Hfy0p5FxaC8YOxKoQKFFFfeKUjJWp",
			q: "[enter search here]",
			start: 0,
			maxResults: 10
		});
	}
}),

isc.IButton.create({
	title: "Search",
	click: "searchResults.fetchData(searchForm.getValuesAsCriteria())"
}),

isc.ListGrid.create({
	ID: "searchResults",
    fixedRecordHeights:false,
    showAllRecords:true
})

]
});

isc.showPrompt("Loading WSDL from http://api.google.com/GoogleSearch.wsdl");
isc.XMLTools.loadWSDL("http://api.google.com/GoogleSearch.wsdl", "if(window.searchForm) searchForm.wsdlLoaded()");
