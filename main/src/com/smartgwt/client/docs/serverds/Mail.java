
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
 * A <code>Mail</code> object describes an email that will be sent automatically by the  Smart GWT
 * Server as part of a normal {@link com.smartgwt.client.docs.serverds.DataSource} operation.<p>
 * <b>This class is not meant to be created and used, it is actually documentation of settings
 * allowed in a DataSource descriptor (.ds.xml file), for use with Smart GWT Pro Edition and
 * above.
 * See {@link com.smartgwt.client.docs.serverds} for how to use this documentation.</b>
 * <p>
 * Mail definitions are part of an {@link com.smartgwt.client.docs.serverds.OperationBinding}, and
 * they can only be specified in a  DataSource's XML definition.  Despite the declarative nature
 * of mail definitions, templating support via Velocity makes it very flexible; it is very easy to
 * include values from records just fetched from permanent storage by this operation, for example.
 * See  {@link com.smartgwt.client.docs.VelocitySupport} for an overview of Smart GWT Server's
 * pervasive support for  templated declarative operations using Velocity.  <P> The default
 * context for the message is the dsResponse.data; that is, $foo in the message refers to the
 * field "foo" in the DataSource response (the equivalent of calling
 * dsResponse.getFieldValue("foo") in Java).  You also have access to the normal Velocity
 * variables described in the overview linked to above. <P> If multiple records appear in the
 * dsResponse, one message will be sent per record in the response unless "multiple" is set to
 * false.  This allows a set of recipients to be selected by a "fetch" operationBinding and
 * messages sent to each. This also means that if no data is selected by a fetch or affected by an
 * update, no mail is sent. <P> If you have the {@link
 * com.smartgwt.client.docs.TransactionChaining Transaction Chaining} feature (available  in Power
 * and better versions), all of the variables normally accessible in other Velocity  contexts are
 * available in the message template as well, for example: 
 * <code>$responseData.last('order').orderId</code> <p> You can provide the body of the email
 * directly in the {@link com.smartgwt.client.docs.serverds.Mail#messageTemplate messageTemplate}
 * tag, or you can provide a filename in the {@link
 * com.smartgwt.client.docs.serverds.Mail#templateFile templateFile} attribute, which tells Smart
 * GWT to use the contents of that file as the body of the email.  If you  provide neither of
 * these, your email will have no body; if you provide both, Smart GWT will ignore the file and
 * just use the content directly provided. <p> <b>Mail server configuration in
 * server.properties</b><br> <p> Static mail server to use for sending emails can be configured in
 * the {@link com.smartgwt.client.docs.Server_properties server.properties} file.  The following
 * values can be provided:<p> <code>mail.system.mail.smtp.host</code>: The name of the SMTP server
 * to use; defaults  to "localhost"<br> <code>mail.system.mail.smtp.port</code>: What port is the
 * MTA listening on; defaults to 25<br> <code>mail.system.mail.smtp.auth</code>: Whether this
 * server requires authentication;  defaults to false<br> <code>mail.system.mail.smtp.user</code>:
 * SMTP user, if authentication is on; no default<br> <code>mail.system.mail.smtp.password</code>:
 * Password, if authentication is on; no default<br> <p> Note that we will also pass any other
 * properties that start <code>mail.system</code> through to the underlying Javamail
 * <code>Session</code> object, so you can use Javamail features that aren't explicitly exposed by
 * Smart GWT's mail support.  For example, many cloud-based SMTP providers require that you issue
 * a STARTTLS command before authenticating; you can  achieve this by adding the following line to
 * {@link com.smartgwt.client.docs.Server_properties server.properties}:<p>
 * <code>mail.system.mail.smtp.starttls.enable: true</code> <p> <b>Mail server configuration in
 * OperationBinding</b><br> <p> Dynamic mail server can be configured in {@link
 * com.smartgwt.client.docs.serverds.DataSource#operationBindings DataSource.operationBindings}
 * under  {@link com.smartgwt.client.docs.serverds.OperationBinding#mail &lt;mail&gt;} tag. This
 * allows to alter mail server settings for different operations and depending on data using
 * {@link com.smartgwt.client.docs.VelocitySupport Velocity templates}. Same values can be
 * provided as in <code>server.properties</code> omitting "mail.system.mail.smtp" prefix, i.e.
 * "host", "port", "auth", "user" and "password". <p> Just like in <code>server.properties</code>
 * any other properties can be provided and will be passed through to the underlying Javamail
 * <code>Session</code> object. Note that property names must omit "mail.smtp" prefix, for
 * example:<p> <code>&lt;starttls.enable&gt;true&lt;/starttls.enable&gt;</code>
 */
public class Mail {

    /**
     * The text that will form the body of the mail message.  Like all other <code>String</code> 
     * properties of <code>Mail</code>, you can use Velocity substitution variables in this property.
     * <p> You must specify either this property or {@link
     * com.smartgwt.client.docs.serverds.Mail#templateFile templateFile}, but clearly it makes no
     * sense to specify them both.
     *
     * <p>Default value is null
     */
    public VelocityExpression messageTemplate;

    /**
     * The string to appear in the subject line of the message.  Like all other <code>String</code> 
     * properties of <code>Mail</code>, you can use Velocity substitution variables in this property.
     * <p> If you specify a "Subject:" line in the body of your email, the subject will be parsed  and
     * this property will be ignored.
     *
     * <p>Default value is null
     */
    public VelocityExpression subject;

    /**
     * Comma-separated list of recipients.  Like all other <code>String</code>  properties of
     * <code>Mail</code>, you can use Velocity substitution variables in this property. <p> If you
     * specify a "To:" line in the body of your email, recipient addresses will be parsed  and this
     * property will be ignored.
     *
     * <p>Default value is null
     */
    public VelocityExpression to;

    /**
     * Defines whether authentication is required by SMTP server that will send the email. Like all
     * other <code>String</code> properties of <code>Mail</code>, you can use Velocity substitution
     * variables in this property.
     *
     * <p>Default value is null
     */
    public VelocityExpression auth;

    /**
     * Allows you to specify an alternative source of substitution values for the templating 
     *  process (by default, the data record(s) returned by the DataSource operation are used).
     * If set, this {@link com.smartgwt.client.docs.VelocityExpression} should evaluate to a Java
     * <code>Map</code>
     *  object, or a Java <code>List</code> containing only <code>Map</code>s.
     *  <p>
     *  For example, assuming you had suitable context stored in a <code>Map</code> that is
     *  held in the current session as attribute "foo", the following would cause the mail 
     *  templating system to look in there for values when running substitution:
     *  <pre>
     *      messageData="$session.foo"
     *  </pre>
     *
     * <p>Default value is null
     */
    public VelocityExpression messageData;

    /**
     * Used to override the character encoding we apply to the email body.  If you do not set  this
     * property, it is derived from the {@link com.smartgwt.client.docs.Server_properties
     * server.properties} setting  <code>mail.system.default.encoding</code>, which is set to "UTF-8"
     * by default.  This setting should be appropriate for most use cases.
     *
     * <p>Default value is null
     */
    public String encoding;

    /**
     * Port of the SMTP server that will send the email.  Like all other <code>String</code>
     * properties of <code>Mail</code>, you can use Velocity substitution variables in this property.
     *
     * <p>Default value is null
     */
    public VelocityExpression port;

    /**
     * The email address the message will appear to come from.  Like all other <code>String</code> 
     * properties of <code>Mail</code>, you can use Velocity substitution variables in this property.
     * <p> If you specify a "From:" line in the body of your email, the from address will be parsed 
     * and this property will be ignored. <p> Ordinarily, this property (or the parsed equivalent in
     * the email body) is mandatory for all emails.  However, if you specify the property
     * <code>mail.system.mail.smtp.from</code> in  <code>server.properties</code>, it will become the
     * default "from" address, and this property becomes optional.
     *
     * <p>Default value is null
     */
    public VelocityExpression from;

    /**
     * Qualified name of the file containing the message template, relative to webroot.  Like all the
     * other <code>VelocityExpression</code> properties of <code>Mail</code>, you can use Velocity
     * substitution variables in this property.  The content itself (ie, the contents of the file
     * named in this property) can also contain Velocity substitutions, of course. <p> You must
     * specify either this property or {@link com.smartgwt.client.docs.serverds.Mail#messageTemplate
     * messageTemplate}, but clearly it makes no sense to specify them both.
     *
     * <p>Default value is null
     */
    public VelocityExpression templateFile;

    /**
     * Used to override the content-type header applied to the email.  Primarily used to send  HTML
     * emails rather than plain text ones (use "text/html" to do this).
     *
     * <p>Default value is null
     */
    public String contentType;

    /**
     * Host of the SMTP server that will send the email.  Like all other <code>String</code>
     * properties of <code>Mail</code>, you can use Velocity substitution variables in this property.
     *
     * <p>Default value is null
     */
    public VelocityExpression host;

    /**
     * User if authentication is required by SMTP server that will send the email. Like all other
     * <code>String</code> properties of <code>Mail</code>, you can use Velocity substitution
     * variables in this property.
     *
     * <p>Default value is null
     */
    public VelocityExpression user;

    /**
     * An email address to indicate as the reply-to address on the message.  Like all other 
     * <code>String</code> properties of <code>Mail</code>, you can use Velocity substitution 
     * variables in this property.
     *
     * <p>Default value is null
     */
    public VelocityExpression replyTo;

    /**
     * Comma-separated list of "BCC" recipients.  Like all other <code>String</code>  properties of
     * <code>Mail</code>, you can use Velocity substitution variables in this property. <p> If you
     * specify a "Bcc:" line in the body of your email, recipient addresses will be parsed  and this
     * property will be ignored.
     *
     * <p>Default value is null
     */
    public VelocityExpression bcc;

    /**
     * Password if authentication is required by SMTP server that will send the email. Like all other
     * <code>String</code> properties of <code>Mail</code>, you can use Velocity substitution
     * variables in this property.
     *
     * <p>Default value is null
     */
    public VelocityExpression password;

    /**
     * Comma-separated list of "CC" recipients.  Like all other <code>String</code>  properties of
     * <code>Mail</code>, you can use Velocity substitution variables in this property. <p> If you
     * specify a "Cc:" line in the body of your email, recipient addresses will be parsed  and this
     * property will be ignored.
     *
     * <p>Default value is null
     */
    public VelocityExpression cc;

    /**
     * By default, multiple mail messages are sent if the dsResponse contains multiple records.  Set
     * this property to false to prevent this behavior.
     *
     * <p>Default value is null
     */
    public Boolean multiple;

}
