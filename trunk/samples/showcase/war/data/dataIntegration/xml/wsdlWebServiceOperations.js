// form to take user input of zipcode, and display city returned from web service
isc.DynamicForm.create({
    ID:"zipForm",
    left:50, top:50, numCols:3, cellSpacing:5,
    items:[
        {name:"ZipCode", keyPress: "if(keyName == 'Enter') form.callService()"},
        {type:"button", startRow:false, title:"Find City", click:"form.callService()"},
        {name:"City", type:"staticText"}
    ],
	callService: function () {
        if (!this.zipCodeService) {
            isc.say("Please try again in a moment  - still loading web service descriptor");
            return;
        }
        this.setValue('City', 'Loading...');
		// call the web service
	    this.zipCodeService.callOperation(
        	"GetInfoByZIP",                         // operation name
    	    {USZip:zipForm.getValue("ZipCode")},    // inbound data for operation
	        "//CITY",                               // XPath, Type, or ElementName to extract result
    	    "zipForm.setValue('City', data[0])"     // script to execute when operation returns
	    );
	}
});


// load the zipcode-lookup web-service description
isc.XMLTools.loadWSDL(
    "http://www.webservicex.net/uszip.asmx?WSDL", // URL to load WSDL from
    "if (window.zipForm) zipForm.zipCodeService = service" // script to execute when description is loaded.
);


