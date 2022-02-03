
package com.smartgwt.client.docs;

/**
 * <h3>Strict Mode</h3>
 * Enabling "strict mode" means that any attributes in a {@link
 * com.smartgwt.client.docs.ComponentXML Component XML}
 * file which are not declared in {@link com.smartgwt.client.docs.ComponentSchema Component
 * Schema} will cause warnings
 *  in the server-side log.
 *  <p>
 *  Enabling strict mode can help catch typos in attribute names that may be difficult to
 *  spot.  However, custom attributes are generally allowed in Component XML and it is not
 *  required to declare them in advance in Component Schema, so there are various ways to
 *  disable strict mode warnings at fine granularity.
 *  <p>
 *  In server.properties, strict mode can be turned on or off system-wide for specific schema
 *  or specific attributes of schema.  Examples:
 *  <pre>
 *  # set the global default for *all* Component XML and DataSources
 *  schema.strict.all:true
 * 
 *  # enable strict checking for any &lt;DataSource&gt; tag
 *  schema.strict.DataSource:true
 * 
 *  # enable strict checking for DataSource.operationBindings, but not for
 *  # &lt;OperationBinding&gt; in general (it can appear in other contexts)
 *  schema.strict.DataSource.operationBindings:true 
 *  </pre>
 *  Note that the above settings do not apply to inheriting classes.  For example, enabling
 *  strict validation for &lt;DataBoundComponent&gt; would not enable strict validation for
 *  &lt;ListGrid&gt; tags.
 *  <p>
 *  Strict mode can be disabled for a specific tag by setting strictValidation="false".  For
 *  example, the following would suppress any warnings for custom attributes that appeared on a
 *  particular DataSource's fields:
 *  <pre>
 *      &lt;DataSource .. /&gt;
 *          &lt;fields strictValidation="false"&gt;
 *              &lt;field customAttribute="someValue" .. /&gt;
 *          &lt;/fields&gt;
 *      &lt;/DataSource&gt;
 *  <pre>
 *  The following would be a way of adding a custom attribute and suppressing any warnings for
 *  just that one attribute.
 *      &lt;DataSource .. /&gt;
 *          &lt;fields&gt;
 *              &lt;field name="fieldName"&gt;
 *                  &lt;customAttribute strictValidation="false"&gt;someValue&lt;/customAttribute&gt;
 *              &lt;/field&gt;
 *          &lt;/fields&gt;
 *      &lt;/DataSource&gt;
 */
public interface StrictMode {
}
