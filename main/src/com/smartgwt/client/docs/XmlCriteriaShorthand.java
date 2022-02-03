
package com.smartgwt.client.docs;

/**
 * A shorthand format for {@link com.smartgwt.client.data.AdvancedCriteria} is supported for
 * simple criteria
 *  where the outer criterion is assumed to be an "and" operator:
 *  <pre>
 *  &lt;!-- Simple format --&gt;
 *  &lt;criteria fieldName="restrictAge" operator="equals" value="true"/&gt;
 *  </pre>
 *  This is equivalent to:
 *  <pre>
 *  &lt;!-- Normal format --&gt;
 *  &lt;criteria _constructor="AdvancedCriteria operator="and"&gt;
 *    &lt;criteria&gt;
 *      &lt;criterion fieldName="restrictAge" operator="equals" value="true"/&gt;
 *    &lt;/criteria&gt; 
 *  &lt;/criteria&gt;
 *  </pre>
 */
public interface XmlCriteriaShorthand {
}
