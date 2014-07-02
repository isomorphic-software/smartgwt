/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
package com.smartgwt.client.docs;


import com.smartgwt.client.event.*;
import com.smartgwt.client.core.*;
import com.smartgwt.client.types.*;
import com.smartgwt.client.data.*;
import com.smartgwt.client.data.events.*;
import com.smartgwt.client.rpc.*;
import com.smartgwt.client.callbacks.*;
import com.smartgwt.client.tools.*;
import com.smartgwt.client.bean.*;
import com.smartgwt.client.widgets.*;
import com.smartgwt.client.widgets.events.*;
import com.smartgwt.client.widgets.form.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.tile.*;
import com.smartgwt.client.widgets.tile.events.*;
import com.smartgwt.client.widgets.grid.*;
import com.smartgwt.client.widgets.grid.events.*;
import com.smartgwt.client.widgets.chart.*;
import com.smartgwt.client.widgets.layout.*;
import com.smartgwt.client.widgets.layout.events.*;
import com.smartgwt.client.widgets.menu.*;
import com.smartgwt.client.widgets.rte.*;
import com.smartgwt.client.widgets.rte.events.*;
import com.smartgwt.client.widgets.tab.*;
import com.smartgwt.client.widgets.toolbar.*;
import com.smartgwt.client.widgets.tree.*;
import com.smartgwt.client.widgets.tree.events.*;
import com.smartgwt.client.widgets.viewer.*;
import com.smartgwt.client.widgets.calendar.*;
import com.smartgwt.client.widgets.calendar.events.*;
import com.smartgwt.client.widgets.cube.*;
import com.smartgwt.client.widgets.drawing.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;
import com.smartgwt.client.util.*;
import com.smartgwt.client.util.workflow.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.event.shared.HasHandlers;

/**
 * A <code>Mail</code> object describes an email that will be sent automatically by the  Smart GWT Server as part of a
 * normal {@link com.smartgwt.client.data.DataSource} operation.  Mail definitions are part of an {@link
 * com.smartgwt.client.data.OperationBinding}, and they can only be specified in a  DataSource's XML definition.  Despite
 * the declarative nature of mail definitions, templating support via Velocity makes it very flexible; it is very easy to
 * include values from records just fetched from permanent storage by this operation, for example.  See  {@link
 * com.smartgwt.client.docs.VelocitySupport} for an overview of Smart GWT Server's pervasive support for  templated
 * declarative operations using Velocity.  <P> The default context for the message is the dsResponse.data; that is, $foo in
 * the message refers to the field "foo" in the DataSource response (the equivalent of calling
 * dsResponse.getFieldValue("foo") in Java).  You also have access to the normal Velocity variables described in the
 * overview linked to above. <P> If multiple records appear in the dsResponse, one message will be sent per record in the
 * response unless "multiple" is set to false.  This allows a set of recipients to be selected by a "fetch"
 * operationBinding and messages sent to each. This also means that if no data is selected by a fetch or affected by an
 * update, no mail is sent. <P> If you have the Transaction Chaining feature, all of the variables normally accessible in
 * other Velocity contexts are available in the message template as well, for example, $responseData.last('order').orderId.
 * See  {@link com.smartgwt.client.data.DSRequestModifier#getValue transaction chaining} for more details. <p> You can
 * provide the body of the email directly in the {@link com.smartgwt.client.docs.serverds.Mail#messageTemplate
 * messageTemplate} tag, or you can provide a filename in the {@link com.smartgwt.client.docs.serverds.Mail#templateFile
 * templateFile} attribute, which tells Smart GWT to use the contents of that file as the body of the email.  If you 
 * provide neither of these, your email will have no body; if you provide both, Smart GWT will ignore the file and just use
 * the content directly provided. <p> <b>Mail server configuration</b><br> The mail server to use for sending emails is
 * configured in the {@link com.smartgwt.client.docs.Server_properties server.properties} file.  The following values can
 * be provided:<p> <code>mail.system.mail.smtp.host</code>: The name of the SMTP server to use; defaults  to
 * "localhost"<br> <code>mail.system.mail.smtp.port</code>: What port is the MTA listening on; defaults to 25<br>
 * <code>mail.system.mail.smtp.auth</code>: Whether this server requires authentication;  defaults to false<br>
 * <code>mail.system.mail.smtp.user</code>: SMTP user, if authentication is on; no default<br>
 * <code>mail.system.mail.smtp.password</code>: Password, if authentication is on; no default<br> <p> Note that we will
 * also pass any other properties that start <code>mail.system</code> through to the underlying Javamail
 * <code>Session</code> object, so you can use Javamail features that aren't explicitly exposed by Smart GWT's mail
 * support.  For example, many cloud-based SMTP providers require that you issue a STARTTLS command before authenticating;
 * you can  achieve this by adding the following line to {@link com.smartgwt.client.docs.Server_properties
 * server.properties}:<p> <code>mail.system.mail.smtp.starttls.enable: true</code>
 */
@BeanFactory.FrameworkClass
public interface Mail {


    // ********************* Properties / Attributes ***********************
    
    
    
    
    
    
    
    
    
    
    
    

    // ********************* Methods ***********************

}


