
package com.smartgwt.client.docs;

/**
 * <h3>Reify Messaging</h3>
 * <P>Reify allows you to send two different kind of messages from your applications: Email and
 * SMS. <P><b>Email</b> <P> There is a special DataSource named 'isc_sendEmail', which you can
 * directly use from your app. The following fields are required to send this kind of message: <P>
 * <ul> <li><b>to</b>: indicates the email accounts of the destinataries. Use commas (',') in
 * order  to use more than one destinatary.</li> <li><b>subject</b>: indicates the topic of the
 * email.</li> <li><b>message</b>: indicates the message to send.</li> </ul> <P> You need to set
 * up the following entry in the server.properties file in order to use this feature: <ul>
 * <li><b>reify.emailFrom</b>: the email account used as 'from' in the email message.</li> </ul>
 * <P> Also, you can check the {@link com.smartgwt.client.docs.serverds.Mail Mail overview} to
 * know how to set up access to an SMTP server and complete the configuration to use this feature.
 * <P><b>SMS</b> <P> There is a special DataSource named 'isc_sendSMS', which you can directly use
 * from your app. The following fields are required to send this kind of message: <ul>
 * <li><b>to</b>: phone numbers of the destinataries that will receive the message.  Use commas
 * (',') in order to use more than one phone number.</li> <li><b>message</b>: message to
 * send.</li> </ul> <P> Also, Reify uses a specific Twilio library to achieve this. You need to
 * set up the following entries in the server.properties file in order to use this feature: <ul>
 * <li><b>twilio.ACCOUNT_SID</b>: identifier of the account, which acts as a username.</li>
 * <li><b>twilio.AUTH_TOKEN</b>: acts as a password.</li> <li><b>twilio.twilioPhoneNumber</b>:
 * Twilio phone number you get when setting up your account in Twilio.</li> </ul> <P> You need to
 * register in the Twilio website and set up your account in order to get the required values.
 */
public interface ReifyMessaging {
}
