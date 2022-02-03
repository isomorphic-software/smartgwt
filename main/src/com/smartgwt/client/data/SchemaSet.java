package com.smartgwt.client.data;

import com.google.gwt.core.client.JavaScriptObject;
import com.smartgwt.client.core.BaseClass;

/**
 * A set of schema derived from the <code>&lt;xsd:schema&gt;</code> element in a WSDL or XML schema file loaded by
 * {@link com.smartgwt.client.data.XMLTools#loadWSDL} or {@link XMLTools#loadXMLSchema}.
 */
public class SchemaSet extends BaseClass {

    public static SchemaSet getOrCreateRef(JavaScriptObject jsObj) {
        if(jsObj == null) return null;
        BaseClass obj = BaseClass.getRef(jsObj);
        if(obj != null) {
            return (SchemaSet) obj;
        } else {
            return new SchemaSet(jsObj);
        }
    }

    public SchemaSet() {
        scClassName = "SchemaSet";
    }

    public SchemaSet(JavaScriptObject jsObj) {
        scClassName = "SchemaSet";
        setJavaScriptObject(jsObj);
    }

    public native JavaScriptObject create()/*-{
        var config = this.@com.smartgwt.client.core.BaseClass::getConfig()();
        var scClassName = this.@com.smartgwt.client.core.BaseClass::scClassName;
        return $wnd.isc[scClassName].create(config);
    }-*/;

    /**
     * Get the schema definition of any complexType or element of complexType defined within the <schema> element this
     * SchemaSet represents.
     *
     * @param schemaName name of the schema to retrieve
     * @return the data source if schema found, or null
     */
    public native DataSource getSchema(String schemaName)/*-{
        var self  = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        var ds = self.getSchema(schemaName);

        if(ds == null || ds === undefined) {
            return null;
        } else {
            var dsJ = @com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ds);
            return dsJ;
        }
    }-*/;

    /**
     * Get the schema definition of any complexType or element of complexType defined within the <schema> element this
     * SchemaSet represents.
     *
     * @param schemaName name of the schema to retrieve
     * @param schemaType type of schema to return, either "element" for xs:element definitions only or "type" for
     *                   xs:complexType definitions. If unspecified, either will be returned, with types preferred if
     *                   names collide
     * @return the data source if schema found, or null
     */
    public native DataSource getSchema(String schemaName, String schemaType)/*-{
        var self  = this.@com.smartgwt.client.core.BaseClass::getJsObj()();
        var ds = self.getSchema(schemaName, schemaType);
        return ds == null || ds === undefined ? null : @com.smartgwt.client.data.DataSource::new(Lcom/google/gwt/core/client/JavaScriptObject;)(ds);
    }-*/;
}
