
/*
 * Isomorphic Smart GWT web presentation layer
 * Copyright 2000 and beyond Isomorphic Software, Inc.
 *
 * OWNERSHIP NOTICE
 * Isomorphic Software owns and reserves all rights not expressly granted in this source code,
 * including all intellectual property rights to the structure, sequence, and format of this code
 * and to all designs, interfaces, algorithms, schema, protocols, and inventions expressed herein.
 *
 *  If you have any questions, please email <sourcecode@isomorphic.com>.
 *
 *  This entire comment must accompany any portion of Isomorphic Software source code that is
 *  copied or moved from this file.
 */
/* sgwtgen */
package com.smartgwt.client.docs.serverds;

import com.smartgwt.client.types.*;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.docs.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.widgets.form.fields.FormItem;
import java.util.List;
import java.util.Map;

/**
 * The ServerObject tells the ISC server how to find or create a server-side object involved in
 * {@link com.smartgwt.client.docs.DmiOverview DMI} (Direct Method Invocation).<p>
 * <b>This class is not meant to be created and used, it is actually documentation of settings
 * allowed in a DataSource descriptor (.ds.xml file), for use with Smart GWT Pro Edition and
 * above.
 * See {@link com.smartgwt.client.docs.serverds} for how to use this documentation.</b>
 * <p>
 * <p> A ServerObject declaration appears in the XML definition of a {@link
 * com.smartgwt.client.docs.serverds.DataSource} (for responding to {@link
 * com.smartgwt.client.data.DSRequest}s) or in an Application configuration file (.app.xml) for
 * responding to {@link com.smartgwt.client.rpc.RPCRequest}s. <P> NOTE: Please take note of the
 * points made in  {@link com.smartgwt.client.docs.ServerDataSourceImplementation this discussion}
 * of caching and thread-safety issues in server-side DataSources.
 */
public class ServerObject {

    /**
     * Specifies the fully-qualified class name that provides the server-side endpoint of the DMI
     * ({@link com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle}:"new") or the
     * class name of the factory that produces the DMI instance ({@link
     * com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle}:"factory"). <p> This is
     * one of the values that you need to pass to  DMI.call() to invoke the DMI from the client. <p>
     * The value of this attribute is used for <code>"new"</code> and <code>"factory"</code> values of
     * {@link com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle}. <p> It is also
     * used for <code>"cdi"</code> value of {@link
     * com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle}, to provide  class name
     * of the bean to ask CDI to create.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.ServerObject#lookupStyle
     * @see com.smartgwt.client.docs.serverds.ServerObject#ID
     */
    public String className;

    /**
     * Specifies the mechanism for locating the class instance on which to invoke the method. Valid
     * values are as follows: <ul> <li>"spring": For use with the <a href='http://springframework.com'
     * target='_blank'>Spring framework</a>. {@link
     * com.smartgwt.client.docs.serverds.ServerObject#bean bean} contains the name of the bean to
     * invoke.  Which application context is used can be configured via web.xml (see the example
     * web.xml in the SDK).  See also {@link com.smartgwt.client.docs.ServerInit} for special concerns
     * with framework initialization when using Spring. <li>"cdi": For use with  <a
     * href='http://docs.oracle.com/javaee/6/tutorial/doc/giwhb.html' target='_blank'>CDI (Contexts
     * and Dependency Injection)</a>. Use {@link com.smartgwt.client.docs.serverds.ServerObject#bean
     * bean} to configure the name of the  bean to invoke or, alternatively, {@link
     * com.smartgwt.client.docs.serverds.ServerObject#className className} to configure its class
     * name. <li>"new": A new instance of the class specified by {@link
     * com.smartgwt.client.docs.serverds.ServerObject#className className} will be created and the DMI
     * method will be invoked on that instance (unless the specified method is static, in which case
     * no instance is created, but the class specified by {@link
     * com.smartgwt.client.docs.serverds.ServerObject#className className} is still used).
     * <li>"factory": A custom factory provides the class instance on which the DMI method is to be
     * invoked.  In this case, {@link com.smartgwt.client.docs.serverds.ServerObject#className
     * className} specifies the className of the factory that will provide the instance on which the
     * DMI method is to be invoked.  The class specified by {@link
     * com.smartgwt.client.docs.serverds.ServerObject#className className} must provide exactly one
     * method named <code>create</code> that must return the class instance on which you wish the DMI
     * method to be invoked.  Like the DMI methods, the <code>create</code> method can request a
     * standard set of values as arguments.  See {@link com.smartgwt.client.docs.DmiOverview DMI} for
     * a list of available values. <li> "attribute": The instance on which the DMI method is to be
     * invoked is looked up in the scope defined by {@link
     * com.smartgwt.client.docs.serverds.ServerObject#attributeScope attributeScope} via the attribute
     * name specified in {@link com.smartgwt.client.docs.serverds.ServerObject#attributeName
     * attributeName}. </ul>
     *
     * <p>Default value is "new"
     * @see com.smartgwt.client.docs.serverds.ServerObject#className
     * @see com.smartgwt.client.docs.serverds.ServerObject#bean
     * @see com.smartgwt.client.docs.serverds.ServerObject#attributeName
     * @see com.smartgwt.client.docs.serverds.ServerObject#attributeScope
     */
    public String lookupStyle;

    /**
     * For use when {@link com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle} is
     * <code>"spring"</code> or <code>"cdi"</code>,  id (name) of the bean to ask Spring (CDI) to
     * create.
     *
     * <p>Default value is null
     */
    public String bean;

    /**
     * By default, for DMI DSResponses, DSResponse.data is filtered on the server to just the set of
     * fields defined on the DataSource.  This behavior can be overridden in several ways - see the
     * overview in {@link com.smartgwt.client.docs.DmiOverview DMI} for details.  The value of this
     * attribute overrides {@link com.smartgwt.client.docs.serverds.DataSource#dropExtraFields
     * DataSource.dropExtraFields}.
     *
     * <p>Default value is null
     */
    public Boolean dropExtraFields;

    /**
     * When the {@link com.smartgwt.client.docs.serverds.ServerObject} appears in a .app.xml file (for
     * RPC DMI), this property specifies the list of methods on the ServerObject that are callable
     * from the client.  See the builtin.app.xml file in the /shared/app directory of the SDK for an
     * example of a visibleMethods declaration block.
     *
     * <p>Default value is null
     */
    public String[] visibleMethods;

    /**
     * Specifies the name of the method to call for operations using this ServerObject.  This is  a
     * DataSource-level default; you can override it for individual operations either by  specifying
     * the {@link com.smartgwt.client.docs.serverds.OperationBinding#serverMethod
     * OperationBinding.serverMethod} attribute, or by declaring an  operation-level serverObject that
     * specifies a different methodName (if you specify both  an operationBinding.serverMethod and an
     * operation-level serverObject.methodName, the  latter takes precedence)
     *
     * <p>Default value is null
     */
    public String methodName;

    /**
     * Specifies the scope in which the DMI instance is to be looked up.  Valid values are: 
     * <code>"request"</code>, <code>"session"</code>, and <code>"application"</code>.  If
     * <code>attributeScope</code> is left out of the <code>ServerObject</code> definition, then all
     * scopes are searched in the order in which they are listed above. <p> This attribute is
     * consulted only when the value of {@link
     * com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle} is
     * <code>"attribute"</code>.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.ServerObject#attributeName
     * @see com.smartgwt.client.docs.serverds.ServerObject#lookupStyle
     */
    public String attributeScope;

    /**
     * You can optionally specify an ID on the ServerObject config block - in which case you can use
     * that value as the "className" argument when calling  DMI.call().  This allows you to hide the
     * name of the server-side class used as the factory or implementer of the DMI from the browser as
     * a security precaution.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.ServerObject#className
     */
    public String ID;

    /**
     * If set, the Smart GWT server will use JXPath to call your server code.  The
     * <code>JXPathContext</code> (start point) will be the object arrived at by applying the  {@link
     * com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle} and related
     * ServerObject properties. The  intention of this property is to allow easier access to your
     * existing Java objects  and reduce the need to write Smart GWT-specific server code.
     *
     * <p>Default value is null
     */
    public String targetXPath;

    /**
     * Specifies the name of the attribute by which to look up the DMI instance.  This attribute is
     * consulted only when the value of {@link
     * com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle} is
     * <code>"attribute"</code>.
     *
     * <p>Default value is null
     * @see com.smartgwt.client.docs.serverds.ServerObject#attributeScope
     * @see com.smartgwt.client.docs.serverds.ServerObject#lookupStyle
     */
    public String attributeName;

    /**
     * For a ServerObject defined at the {@link
     * com.smartgwt.client.docs.serverds.DataSource#serverObject DataSource level}, by 
     *  default we only allow it to intercept standard CRUD operations (ie, ordinary fetches, adds,
     *  updates and removes).  To allow the ServerObject to intercept other types of operation - 
     *  custom operations, validations, etc - set this property to false.  Note that ServerObjects 
     * declared at the {@link com.smartgwt.client.docs.serverds.OperationBinding#serverObject
     * OperationBinding level} always intercept
     *  that operation, whatever its type, and this property has no effect.
     *  <p>
     *  <b>NOTE:</b> If you are intercepting operations on the server because you wish to inspect
     *  them before deciding whether to process them with bespoke code or allow them to proceed 
     *  with normal processing, the way to invoke normal processing without causing any interference
     *  is:<pre>
     *     return dsRequest.execute();
     *  </pre>
     *
     * <p>Default value is null
     */
    public Boolean crudOnly;

}
