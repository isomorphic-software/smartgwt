isc.DataSource.create({
    Constructor:"SchemaSet",
    ID:"SchemaSet",
    fields:{
        schemaNamespace:{type:"url", name:"schemaNamespace"},
        qualifyAll:{type:"boolean", name:"qualifyAll"},
        schema:{type:"DataSource", name:"schema", multiple:true}
    },
    addGlobalId:false
})
