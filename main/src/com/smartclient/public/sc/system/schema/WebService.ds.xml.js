isc.DataSource.create({
    Constructor:"WebService",
    ID:"WebService",
    fields:{
        location:{type:"url", name:"location"},
        targetNamespace:{type:"url", name:"targetNamespace"},
        operations:{type:"WebServiceOperation", name:"operations", multiple:true},
        messages:{type:"WSDLMessage", name:"messages", multiple:true},
        globalNamespaces:{type:"Object", name:"globalNamespaces"}
    },
    addGlobalId:false
})
