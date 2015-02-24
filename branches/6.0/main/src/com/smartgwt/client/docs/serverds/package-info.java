/**
 * This package is reference for all properties that may be specified in DataSource descriptor
 * (.ds.xml file), for use with Smart GWT Pro Edition and above.  Do not import this package in
 * your Java code - it is informational only.<p>
 * 
 * Each Java Class here represents an XML element, and each field is a setting that can be
 * specified as either an attribute or a subelement.<p>
 * 
 * For example, DataSource.canMultiSort can be set like this:
 * <pre>{@code
 *<DataSource canMultiSort="true"/>}</pre>
 * Or like this:
 * <pre>{@code
 *<DataSource>
 *    <canMultiSort>true</canMultiSort>
 *</DataSource>}</pre>
 * When a class in this package has a field that is an Array of another class, it means there is
 * a containing XML tag named after the field, then several tags named after the class.  For
 * example, DataSource.operationBindings is an Array of OperationBinding.  The XML for this is:
 * <pre>{@code
 *<DataSource>
 *    <operationBindings>
 *        <operationBinding operationType="fetch">
 *            ... various operationBinding settings ...
 *        </operationBinding>
 *    </operationBindings>
 *</DataSource>}</pre>
 * If the field is <b>not</b> an Array, it means there should be a singular tag.  For example,
 * OperationBinding.mail:
 * <pre>{@code
 *<DataSource>
 *    <operationBindings>
 *        <operationBinding operationType="add">
 *            <mail to="admin@company.com" templateFile="messageTemplate.txt"/>
 *        </operationBinding>
 *    </operationBindings>
 *</DataSource>}</pre>
 * <p>
 * NOTE: the settings described in the special "serverds" JavaDoc package are only usable with
 * Smart GWT Pro Edition and above, however, the "serverds" documentation is included with
 * Smart GWT LGPL since some parts of the documentation cover concepts and approaches that are
 * also applicable in Smart GWT LGPL.
 */
package com.smartgwt.client.docs.serverds;
