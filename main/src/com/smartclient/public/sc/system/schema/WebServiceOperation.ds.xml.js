isc.DataSource.create({
    ID:"WebServiceOperation",
    fields:{
        name:{title:"Operation Name", name:"name", required:true},
        soapAction:{title:"SOAPAction Header", name:"soapAction"},
        inputMessage:{title:"Input Message", name:"inputMessage"},
        outputMessage:{title:"Input Message", name:"outputMessage"},
        inputHeaders:{type:"WSOperationHeader", name:"inputHeaders", multiple:true},
        outputHeaders:{type:"WSOperationHeader", name:"outputHeaders", multiple:true}
    },
    addGlobalId:false
})
