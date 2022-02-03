
package com.smartgwt.client.docs;

/**
 * <h3>DSRequest data auto-converted to bean types</h3>
 * For fields with numeric types, the {@link com.smartgwt.client.data.DSRequest#getData record
 * data} in DSRequests will  automatically be converted to the type of the target field, before
 * the request is received  in a DMI. <p> For example, if {@link
 * com.smartgwt.client.docs.serverds.DataSource#beanClassName your bean} has a field "price" of
 * type Float,  an "update" DSRequest with a new value for this field will use the Java Float type
 * for the  new value, whereas in the absence of a bean, the Double type would ordinarily be used 
 * (see {@link com.smartgwt.client.rpc.RPCRequest#getData RPCRequest.data}). <p> This happens only
 * for fields of type <i>integer</i>, <i>sequence</i>, <i>intEnum</i> and <i>float</i>. Because
 * the conversion is performed as part of server-side validation, it  applies only to "update" or
 * "add" requests, and does not apply to {@link com.smartgwt.client.data.DSRequest#getOldValues
 * DSRequest.oldValues}, which will continue to use the generic types listed in {@link
 * com.smartgwt.client.rpc.RPCRequest#getData RPCRequest.data}. <P> Note that, while values for
 * non-numeric fields will still use basic Java types (for example, values for Java Enum fields
 * will arrive {@link com.smartgwt.client.data.DataSource#getEnumTranslateStrategy as Strings by
 * \n default}), manual conversion of the remaining data is not necessary; the server-side API 
 * <code>DataSource.setProperties()</code> does all remaining conversion necessary to populate  a
 * bean from the request data (see that API's docs for details), and this conversion will be
 * performed automatically if your DMI logic calls <code>execute()</code> on the DSRequest. <P>
 * You may need to explicitly define what Java type must be used during conversion for a given
 * field. This can be achieved by setting {@link
 * com.smartgwt.client.docs.serverds.DataSourceField#javaClass DataSourceField.javaClass}
 * property. <p> If conversion fails, because of target field using an abstract Java type or
 * invalid  class defined in DSField.javaClass property etc, conversion will fall back to its 
 * default behavior, i.e. Java type will be guessed from the actual field value.  It would be Long
 * for integer based types and Double for float type or, if the value would  appear to exceed the
 * ranges of these types, BigInteger and BigDecimal accordingly.
 */
public interface DsRequestBeanTypes {
}
