
package com.smartgwt.client.docs;

/**
 * <i>All rules described in this topic are applied any time a property is of type
 * {@link com.smartgwt.client.data.AdvancedCriteria} (in both Component XML and JavaScript
 * component creation)
 *  and any API declares an {@link com.smartgwt.client.data.AdvancedCriteria} param.</i>
 *  <p>
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
 *  Additionally these defaults are used allowing to simplify AdvancedCriteria declaration:
 *  <ul>
 *  <li/> <i>operator="and"</i> default is used if <i>criteria</i> is present at the same level
 * <li/> <i>operator="equals"</i> default is used if <i>fieldName</i> is present at the same level
 *  <li/> <i>value="true"</i> default is used if <i>operator="equals"</i> default was applied
 *  </ul>
 *  So, shorthand format above could be simplified even more, for example to
 * {@link com.smartgwt.client.widgets.form.fields.ButtonItem#getEnableWhen conditionally enable a
 * form button}:
 *  <pre>
 *  &lt;!-- Simple format --&gt;
 *  &lt;enableWhen fieldName="CustomerGrid.anySelected"/&gt;
 *  </pre>
 *  Full equivalent:
 *  <pre>
 *  &lt;!-- Normal format --&gt;
 *  &lt;enableWhen _constructor="AdvancedCriteria operator="and"&gt;
 *    &lt;criteria&gt;
 *      &lt;criterion fieldName="CustomerGrid.anySelected" operator="equals" value="true"/&gt;
 *    &lt;/criteria&gt;
 *  &lt;/enableWhen&gt;
 *  </pre>
 * Another example shows all defaults usage, significantly shortening AdvancedCriteria declaration
 * for
 *   boolean dynamic property (see full setup in
 * <a href="http://www.smartclient.com/smartgwtee/showcase/#booleanDynamicProperties"
 * target="examples">Boolean Dynamic Properties</a> example):
 *  <pre>
 *  &lt;!-- Simple format --&gt;
 *  &lt;trueWhen&gt;
 *      &lt;criteria fieldName="settingsForm/values/exportFieldWidths" /&gt;
 *      &lt;criteria fieldName="settingsForm/values/exportAs" operator="inSet" &gt;
 *          &lt;value&gt;xls&lt;/value&gt;
 *          &lt;value&gt;ooxml&lt;/value&gt;
 *      &lt;/criteria&gt;
 *  &lt;/trueWhen&gt;
 *  </pre>
 *  Full equivalent:
 *  <pre>
 *  &lt;!-- Normal format --&gt;
 *  &lt;trueWhen&gt;
 *      &lt;AdvancedCriteria operator="and"&gt;
 *          &lt;criteria&gt;
 *              &lt;criterion fieldName="settingsForm/values/exportFieldWidths" operator="equals" value="true"/&gt;
 *              &lt;criterion fieldName="settingsForm/values/exportAs" operator="inSet" &gt;
 *                  &lt;value&gt;xls&lt;/value&gt;
 *                  &lt;value&gt;ooxml&lt;/value&gt;
 *              &lt;/criterion&gt;
 *          &lt;/criteria&gt;
 *      &lt;/AdvancedCriteria&gt;
 *  &lt;/trueWhen&gt;
 *  </pre>
 *  JS example:
 *  <pre>
 *  // Simple format
 *  {fieldName: "restrictAge"}
 * 
 *  // Normal format
 *  {
 *    _constructor: "AdvancedCriteria",
 *    operator: "and",
 *    criteria: [
 *      {fieldName: "restrictAge", operator: "equals", value: true}
 *    ]
 *  }
 *  </pre>
 */
public interface XmlCriteriaShorthand {
}
