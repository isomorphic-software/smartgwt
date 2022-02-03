
package com.smartgwt.client.docs;

/**
 * <h3>Adding Custom DataSources to Reify</h3>
 * DataSources placed in the project dataSources directory ([webroot]/shared/ds by default) will
 * be detected by Reify whenever it is started, and appear in the DataSource listing in the lower
 * right-hand corner automatically. <P> If you have created a custom subclass of DataSource (eg,
 * as a base class for several DataSources that contact the same web service), you can use it with
 * Reify by: <ul> <li> creating an XML version of the DataSource using the XML tag
 * &lt;DataSource&gt; and the <code>constructor</code> property set to the name of your custom
 * DataSource subclass (as described {@link com.smartgwt.client.docs.ComponentXML} under the
 * heading <i>Custom Components</i>) <li> modifying
 * [webroot]/tools/visualBuilder/globalDependencies.xml to load the JavaScript code for your
 * custom DataSource class.  See examples in that file. </ul> <P>
     * @see com.smartgwt.client.docs.ToolsDeployment
     * @see com.smartgwt.client.docs.ReifyCustomComponents
     * @see com.smartgwt.client.docs.Reify
 */
public interface ReifyCustomDataSources {
}
