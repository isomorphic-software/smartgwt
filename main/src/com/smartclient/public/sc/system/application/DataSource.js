/*
 * Isomorphic SmartClient
 * Version 7.0beta3 (2008-12-31)
 * Copyright(c) 1998-2007 Isomorphic Software, Inc. All rights reserved.
 * "SmartClient" is a trademark of Isomorphic Software, Inc.
 *
 * licensing@smartclient.com
 *
 * http://smartclient.com/license
 */

 




//> @class DataSource
// A DataSource is data-provider-independant description of a set of objects
// that will be loaded, edited and saved within the user interface of your application.
// <P>
// Each DataSource consists of a list of +link{dataSource.fields,fields} that make up a
// DataSource <code>record</code>, along with +link{dataSourceField.type,field types}, 
// +link{dataSourceField.validators,validation rules}, 
// +link{dataSourceField.foreignKey,relationships} to other DataSources, and other
// metadata.
// <P>
// The abstract object description provided by a DataSource is easily mapped to a variety of
// backend object models and storage schemes.  The following table shows analogous terminology
// across systems.
// <table border=1 class="normal">
// <tr>
//   <td>Isomorphic SmartClient</td>
//   <td>Relational Database</td>
//   <td>Enterprise Java Beans (EJB)</td>
//   <td>Entity/Relationship Modelling</td>
//   <td>OO/UML</td>
//   <td>XML Schema/WSDL</td>
//   <td>LDAP</td>
// </tr><tr>
//   <td>DataSource</td>
//   <td>Table</td>
//   <td>EJB class</td>
//   <td>Entity</td>
//   <td>Class</td>
//   <td>Element Schema (ComplexType)</td>
//   <td>Objectclass</td>
// </tr><tr>
//   <td>Record</td>
//   <td>Row</td>
//   <td>EJB instance</td>
//   <td>Entity instance</td>
//   <td>Class instance/Object</td>
//   <td>Element instance (ComplexType)</td>
//   <td>Entry</td>
// </tr><tr>
//   <td>Field</td>
//   <td>Column</td>
//   <td>Property</td>
//   <td>Attribute</td>
//   <td>Property/Attribute</td>
//   <td>Attribute or Element (SimpleType)</td>
//   <td>Attribute</td>
// </tr></table>
// <P>
// DataSources can be +link{group:dataSourceDeclaration,declared} in either JavaScript or XML
// format, and can also be +link{group:metadataImport,imported} from existing metadata formats,
// including XML Schema.
// <P>
// <i>Data Binding</i> is the process by which
// +link{dataBoundComponent,Data Binding-capable UI components} can automatically configure
// themselves for viewing, editing and saving data described by DataSources.  DataBinding is
// covered in the +docTreeLink{QuickStartGuide,QuickStart Guide}, Chapter 6, <i>Data
// Binding</i>.
// <P>
// +link{group:clientServerIntegration,Data Integration} is the process by which a DataSource
// can be connected to server systems such as SQL DataBases, Java Object models, WSDL web
// services and other data providers.  Data Integration comes in two variants: client-side and
// server-side.  +link{group:serverDataIntegration,Server-side integration} uses the
// SmartClient Java-based server to connect to data represented by Java Objects or
// JDBC-accessible databases.  +link{group:clientDataIntegration,Client-side integration}
// connects SmartClient DataSources to XML, JSON or other formats accessible via HTTP.
// <P>
// DataSources have a concept of +link{group:dataSourceOperations,4 core operations} ("fetch",
// "add", "update" and "remove") that can be performed on the set of objects represented by a
// DataSource.  Once a DataSource has been integrated with your data store, databinding-capable 
// UI components can leverage the 4 core DataSource operations to provide many complete user
// interactions without the need to configure how each individual component loads and saves
// data.
// <P>
// These interactions include +link{listGrid,grid views}, +link{TreeGrid,tree views}, 
// +link{detailViewer,detail views}, +link{DynamicForm,form}-based 
// +link{dynamicForm.editRecord,editing} and +link{dynamicForm.saveData,saving},
// grid-based +link{listGrid.canEdit,editing} and +link{listGrid.saveByCell,saving},
// and custom interactions provided by +explorerExample{patternReuse} custom
// databinding-capable components.
// 
// @see interface:DataBoundComponent for information on DataBound Components
// @see group:dataSourceDeclaration for how to create DataSources
// @treeLocation Client Reference/Data Binding
// @visibility external
//<
isc.defineClass("DataSource");

//> @type DSOperationType
// One of the four basic operations that can be performed on DataSource data: "fetch",
// "add", "update", "remove".  Elsewhere called CRUD operations, where CRUD stands for
// "create", "retrieve", "update", "delete", which correspond to "add", "fetch", "update" and
// "remove" in SmartClient terminology.  See +link{group:dataSourceOperations} for a full
// description.
//
// @value "fetch"  Fetch one or more records that match a set of search criteria.
// @value "add"    Store new records
// @value "update" Update an existing record
// @value "remove" Remove (delete) an existing record
//
// @visibility external
//<

//> @object Record
// A Record is an ordinary JavaScript Object with properties that are treated as data to
// be displayed and edited by a +link{DataBoundComponent}. 
// <P>
// +link{DataBoundComponent}s have a concept of +link{dataBoundComponent.fields,named fields},
// where values for each field are found under the same-named property in a Record.
// <P>
// A Record is always an ordinary JavaScript Object regardless of how the record is 
// loaded (static data, java server, XML web service, etc), and so supports the
// normal behaviors of JavaScript Objects, including accessing and assigning to properties
// via dot notation:
// <pre>
//     var fieldValue = record.<i>fieldName</i>;
//     record.<i>fieldName</i> = newValue;
// </pre>
// <P>
// The concept of working with Records is common to all +link{DataBoundComponent}s, although
// individual DataBoundComponents may work with singular records (+link{DynamicForm}) or
// may work with lists (+link{ListGrid}), trees (+link{TreeGrid}), or cubes
// (+link{CubeGrid}) of records.
// <P>
// Individual DataComponents may also look for special properties on Records which
// control styling or behavior for those records, such as
// +link{listGrid.recordEditProperty,<code>record.canEdit</code>}.
// 
// @treeLocation Client Reference/Data Binding/DataSource
// @visibility external
//<

//> @groupDef dataSourceDeclaration
// DataSources can be specified in XML format, in which case the ISC server is used to load the
// DataSource in a JSP file, or DataSources can be directly created on the client via
// JavaScript.
// <P>
// Whether a DataSource is specified in XML or JS, identical requests will ultimately be
// submitted to the server, so the server integration pattern is the same.  However,
// DataSources created in XML can be loaded and used by the SmartClient Server,
// enabling many features including synchronized client-server validation, request bundling, 
// file upload, and optional automatic SQL/Hibernate connectivity (see the
// +link{group:iscServer,Server Summary} for details).
// <P>
// DataSources created on the client use the same style of creation as DataBound components:
// <pre>
//    isc.DataSource.create({
//        ID:"supplyItem",
//        fields:[
//            {name:"itemName", ... }
//            ...
//        ]
//    });
// </pre>
// Reference for all properties that can be set for DataSources, their fields and validators is
// given in the +link{class:DataSource} class reference.
// <P>
// XML DataSources use a direct analogue of this format:
// <pre>
//     &lt;DataSource ID="supplyItem"&gt;
//         &lt;fields&gt;
//             &lt;field name="itemName" type="text" title="Item"/&gt;
//             &lt;field name="SKU"      type="text" title="SKU"&gt;
//                 &lt;validators&gt;
//                     &lt;validator type="integerRange" ... /&gt;
//                 &lt;/validators&gt;
//             &lt;/field&gt;
//         &lt;/fields&gt;
//     &lt;/DataSource&gt;
// </pre>
// XML DataSources are loaded via a special JSP tag supported by the ISC Server:
// <pre>
//     &lt;%&#64; taglib uri="/WEB-INF/iscTaglib.xml" prefix="isomorphic" %&gt;
//     ...
//     &lt;SCRIPT&gt;
//     &lt;isomorphic:loadDS ID="supplyItem"/&gt;
//     &lt;/SCRIPT&gt;
// </pre>
// When loading an XML DataSource, by default, the ISC Server will look for a file named
// <code>&lt;dataSourceId&gt;.ds.xml</code> in the <code>/shared/ds</code> subdirectory under
// webroot.  The location of this directory can be changed, or individual DataSources can be
// placed in arbitrary locations.  For more information, see
// <code>[webroot]/WEB-INF/classes/server.properties</code>.
// <p>
//
// @see class:DataSource
// @see group:loadDSTag
// @treeLocation Client Reference/Data Binding/DataSource
// @title Creating DataSources
// @visibility external
//<



//> @groupDef i18n
//
// <b><u>Internationalizing SmartClient UI Components</u></b>
// <p>
// Internationalizing a SmartClient application involves creating locale-specific
// versions of all strings, images, and possibly colors.  In some cases, component layout may
// be affected as well (for example date field order differs between some locales).
// <p>
// <u><b>Character Encodings</b></u>
// <p>
// In order to deliver content in different languages to the browser and have it be displayed
// correctly, it is important that the browser and server agree on the character encoding being
// used to send the page.  
// <p>
// Generally speaking, you can use whatever character encoding you prefer, so long as
// as you're consistent about serving your files to the browser with exactly the same encoding
// as was used to save the file to disk.  Keep in mind though that the character encoding you
// choose must be supported by all browsers you intend to support.  Isomorphic recommends that,
// where possible, you use the UTF-8 encoding.  Regardless of which character encoding you
// choose, keep in mind that for the browser to correctly display non-ASCII characters, you
// <b>must</b> explicitly set the character encoding of your page to match the encoding you
// used to save the file.  Browsers have built-in heuristics to guess the character encoding,
// but they can't be relied upon to work 100% of the time.
// <p>
// There are two ways to explicitly tell the browser what character
// encoding is being used for a given page.  One is to set the "Content-Type" header - e.g. as
// follows in a raw HTTP response to set UTF-8 character encoding and a text/html mime type:
// <pre>
// Content-Type: text/html; charset=UTF-8
// </pre>
// If you're using Java on the back-end, you can set this header out of JSP as follows:
// <pre>
// &lt;%@ page contentType="text/html; charset=UTF-8"%&gt;
// </pre>
// Or using Java Servlet APIs in a Servlet as follows:
// <pre>
// response.setContentType("text/html; charset=UTF-8");
// </pre>
// Note that the latter needs to be done before any content is written to the response output
// stream.
// <p>
// The other approach to setting the content encoding is to use an HTML META tag to embed it
// in the page itself (note that this applies to HTML documents only).  The META tag must go
// inside the &lt;HEAD&gt; HTML element - e.g. as follows:
// <pre>
// &lt;HEAD&gt;
// &lt;META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8"&gt;
// &lt;/HEAD&gt;
// </pre>
// Isomorphic recommends that you use <b>both</b> of these approaches for maximum
// compatibility.  For example, if you omit the META tag approach, documents saved by the user
// using the browser save function may not render correctly when subsequently read from disk
// because HTTP headers are not available in that context.  And conversely not providing the
// HTTP header can result in application servings applying their own default and incorrect
// content encoding.
// <p>
// If you're using a given character encoding pervasively in your pages, you can also configure
// your web server or application server to use that character encoding as the default for all
// pages of a given mime type or some other criteria (depending on the capability of your
// server) - for example on a per-directory basis.
// <p>
// For more information on character encodings, character sets, and working with HTML, please
// see W3C's tutorial here:
// +externalLink{http://www.w3.org/International/tutorials/tutorial-char-enc/}
// <p>
// <u><b>String localization</b></u>
// <p>
// All text appearing in SmartClient UI components is customizeable at the component prototype
// level and at the instance level.  For example, Button component has a default title of
// "Untitled Button" that is changed at the instance level when the button is created (using
// JavaScript syntax):
// <pre>
// isc.Button.create({ title: "Click me!"});
// </pre>
// Likewise, the default title can be changed like so:
// <pre>
// isc.Button.create({});  // this produces a button with the title "Untitled Button"
// isc.Button.addProperties({ title: "Titled Button"});
// isc.Button.create({});  // this now produces a button with the title "Titled Button"
// </pre>
// Using these mechanisms, you can set locale-specific text on any SmartClient component.
// <p>
// We'll use Java-based internationalization examples here because the SDK ships with a Java
// backend - but note that Java is not required to internationalize your SmartClient
// application - see the "Resources" section a the end of this overview for links to
// internationalization resources of other popular back-end technologies.  All those
// techonologies provide mechanisms for fetching locale-specific strings that are compatible
// with SmartClient because ultimately internationalizing a SmartClient application is not much
// different from internationalizing an HTML page.
// <p>
// So, to give a Java-based example, let's say we want to create a button on a page in a manner
// that permits future localization.  Let's say we currently have the following code in our JSP
// page: 
// <pre>
// &lt;SCRIPT&gt;
// isc.Button.create({ title: "Click me!" });
// &lt;/SCRIPT&gt;
// </pre>
// One standards-based approach is to use the i18n component of the JSTL Core package (Java
// Server Pages Standard Tag Library) to replace that static "Click me!" text with a localized
// reference.  This can be done as follows:
// <pre>
// &lt;%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %&gt;
// &lt;SCRIPT&gt;
// isc.Button.create({ title: &lt;fmt:message key="buttonTitle"&gt; });
// &lt;/SCRIPT&gt;
// </pre>
// Assuming you've set the current Locale and provided a resource bundle with the relevant
// translated text, the above would create a button with a title that comes from the locale-specific
// bundle you provided.  See Sun's i18n tutorial:
// +externalLink{http://java.sun.com/docs/books/tutorial/i18n/} and the JSTL home page:
// +externalLink{http://java.sun.com/products/jsp/jstl/} for more information on how to set up
// Resource Bundles.
// <p>
// If you're developing in XML, the mechanism is much the same.  Let's say we have the following
// XML code in our JSP:
// <pre>
// &lt;isomorphic:XML&gt;
// &lt;Button title="Click me!"/&gt;
// &lt;/isomorphic:XML&gt;
// </pre>
// We can localize this button by using JSTL as before by writing it like this:
// <pre>
// &lt;%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %&gt;
// &lt;isomorphic:XML&gt;
// &lt;Button&gt;
//   &lt;title&gt;&lt;fmt:message key="buttonTitle"&gt;&lt;/title&gt;
// &lt;/Button&gt;
// &lt;/isomorphic:XML&gt;
// </pre>
// Note that the XML must be well-formed so we can't just replace "Click me!" with the
// <code>fmt</code> tag because we would end up with embedded double quotes.
// <p>
// NOTE: even though you are dynamically adding localized data to your presentation using
// JSTL/JSPs, you can still allow the browser to cache the entire presentation layer (described
// in detail +link{group:smartArchitecture, here}.  Your bootstrap JSP (the application start
// page) can use a &lt;SCRIPT SRC=&gt; tag to load the localized presentation code as
// cacheable JavaScript, for example, &lt;SCRIPT SRC=/mainUI.jsp?locale=[localeName]&gt;.  This
// works with both XML and JS component descriptors since both are ultimately delivered to the
// browser as JavaScript.
// <p>
// <u><b>Framework message localization</b></u>
// <p>
// In addition to titles and other strings displayed on SmartClient widget instances, 
// SmarClient displays a number of standard prompts and error messages in various cases, all
// of which are fully customizeable for localization purposes.<br>
// A complete list of these standard messages is visible +link{group:i18nMessages, here}.<br>
// Customizing these standard messages is very similar to customizing any other strings, such
// as the <code>Button.title</code> attribute described above.  To take an example, the 
// +link{classAttr:RPCManager.timeoutErrorMessage} is displayed to the user in a warning dialog
// when a SmartClient operation fails to complete. By default this is set to 
// <code>"Operation Timed Out"</code> but can be modified using the +link{Class.addClassProperties()} 
// method, as follows:
// <pre>
// isc.RPCManager.addClassProperties({timeoutErrorMessage:"Custom Timeout Message"});
// </pre>
// <p>
// <u><b>DataSource localization</b></u>
// <p>
// DataSources can be created in +link{group:dataSourceDeclaration,several ways}.  DataSources
// created directly in JavaScript can be internationalized via the techniques described above.
// DataSources which are declared in XML (.ds.xml files) and are read by the ISC server, which
// are normally loaded into a .jsp page via the <code>&lt;isomorphic:loadDS&gt;</code> JSP tag,
// can instead be loaded and interpreted as .jsp files via the technique described below.  This
// allows JSTL and other JSP tags to be used to internationalize the titles and validation
// error messages in XML DataSources.
// <P>
// For example, given the following DataSource located in /shared/ds/supplyItem.ds.xml:
// <pre>
// &lt;DataSource&gt;
//     &lt;fields&gt;
//         &lt;field name="itemName"&gt;
//             &lt;title&gt;Item Name&lt;/title&gt;
//             &lt;validators&gt;
//                 &lt;Validator type="lengthRange" max="40"&gt;
//                     &lt;errorMessage&gt;Must be 40 characters or less.&lt;/errorMessage&gt;
//                 &lt;/Validator&gt;
//             &lt;/validators&gt;
//         &lt;/field&gt;
//     &lt;/fields&gt;
// &lt;/DataSource&gt;
// </pre>
// To localize the title and validator error string of the <code>itemName</code> field 
// using the same JSTL strategy we've been using, first add the following to your web.xml to
// allow DataSource files to be interpreted as JSPs:
// <pre>
// &lt;jsp-config&gt;
//     &lt;jsp-property-group&gt;
//       &lt;url-pattern&gt;/shared/ds/*&lt;/url-pattern&gt;
//     &lt;/jsp-property-group&gt;     
// &lt;/jsp-config&gt;
// </pre>
// Next change the DataSource definition as follows:
// <pre>
// &lt;!--
// &lt;%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %&gt;
// --&gt;
// &lt;DataSource xmlns:fmt="urn:jsptld:/WEB-INF/fmt.tld"&gt;
//     &lt;fields&gt;
//         &lt;field name="itemName"&gt;
//             &lt;title&gt;&lt;fmt:message key="itemTitle"&gt;&lt;/title&gt;
//             &lt;validators&gt;
//                 &lt;Validator type="lengthRange" max="40"&gt;
//                     &lt;errorMessage&gt;&lt;fmt:message key="itemLengthRangeValidator"/&gt;&lt;/errorMessage&gt;
//                 &lt;/Validator&gt;
//             &lt;/validators&gt;
//         &lt;/field&gt;
//     &lt;/fields&gt;
// &lt;/DataSource&gt;
// </pre>
// Note that the XML comment around the taglib declaration is intentional.  It is there to make
// sure the JSP parser sees the tag library declaration, while the file remains valid XML.
// If you need to use multiple JSP tag libraries to achieve your goals, simply add additional
// taglib declarations inside the XML comment and be sure to register the tag namespace in the
// DataSource tag via <code>xmlns:tagName</code> as done above for the <code>fmt</code>
// namespace. instead of using the <code>&lt;isomorphic:loadDS&gt;</code> JSP tag to load this
// DataSource, you would load it as follows in your JSP:
// <pre>
// &lt;SCRIPT&gt;
// &lt;isomorphic:XML&gt;
// &lt;jsp:include page="/shared/ds/supplyItem.ds.xml"&gt;&lt;/jsp:include&gt;
// &lt;/isomorphic:XML&gt;
// &lt;/SCRIPT&gt;
// </pre> 
// This makes it possible to internationalize field titles as well as validation error messages
// for built-in validators.  To internationalize custom server-side validation errors, simply
// provide internationalized strings when calling <code>DSResponse.setErrorReport()</code> to
// report validation errors (see the JavaDoc for that documentation).
// <p>
// <u><b>Support for Right-to-Left (RTL) languages</b></u>
// <P>
// SmartClient includes beta quality support for RTL langauges, with known issues in certain
// skins and components.  To enable, simple set <code>dir="rtl"</code> on the HTML element:
// <pre>
//    &lt;HTML dir="rtl"&gt;
// </pre>
// ListGrid columns, horizontal layouts, scrolling directions, etc will reverse order
// automatically.
// <P>
// If you need production-quality RTL support for your application, visit the<a
// href="http://forums.smartclient.com">SmartClient forums</a> for details of 
// known limitations.
// <P>
// <u><b>Image, CSS localization</b></u>
// <p>
// Most SmartClient components use a mixture of text, CSS and images to render.  If you wish to
// provide locale-specific images or use locale-specific CSS, you can create localized copies
// of a SmartClient skin named after the locale and modify images as you see fit.  A skin is
// specified at load time using either the <code>skin</code> attribute of the
// <code>&lt;isomorphic:loadISC&gt;</code> tag or by loading the skin
// directly using a script tag like so: &lt;SCRIPT SRC=/isomorphic/skins/[skin]/load_skin.js&gt;.
// If you're using the <code>loadISC</code> tag, you can specify a locale-specific skin like so:
// <pre>
// &lt;isomorphic:loadISC skin="[localeName]"/&gt;
// </pre>
// Or you can use a script tag like so:
// <pre>
// &lt;SCRIPT SRC=/isomorphic/skins/[localeName]/load_skin.js&gt;&lt;/SCRIPT&gt;
// </pre>
// Where the <code>[localeName]</code> is the name of the current locale - you'll have this in the
// current page context as you'll need it to use the JSTL &lt;fmt:setLocale&gt; tag.
//
// Resources:
// <p>
// <b><u>Java</u></b>
// <ul>
// <li>Sun's i18n tutorial: +externalLink{http://java.sun.com/docs/books/tutorial/i18n/}
// <li>JSTL home page: +externalLink{http://java.sun.com/products/jsp/jstl/}
// <li>Apache JSTL "Getting Started": 
//     +externalLink{http://jakarta.apache.org/taglibs/doc/standard-doc/standard/GettingStarted.html}
// <li>Apache taglibs: +externalLink{http://jakarta.apache.org/taglibs/}
// </ul>
// <p>
//
// <b><u>.NET</u></b>
// <ul>
// <li>MSDN Developer Resource: "Developing World-Ready Applications":
// +externalLink{http://msdn.microsoft.com/library/default.asp?url=/library/en-us/cpguide/html/cpcondesigningglobalapplications.asp}
// </ul>
//
// <b><u>PHP</u></b>
// <ul>
// <li>PHP Gettext manual: +externalLink{http://us2.php.net/gettext}
// <li>O'Reilly Gettext tutorial: +externalLink{http://www.onlamp.com/pub/a/php/2002/06/13/php.html}
// </ul>
// <p>
//
// <b><u>Perl</u></b>
// <ul>
// <li>Perl, Unicode and i18n FAQ: +externalLink{http://rf.net/~james/perli18n.html}
// </ul>
// @treeLocation Concepts
// @title Internationalization and Localization (i18n,l10n)
// @visibility external
//<

//> @groupDef eclipseIntegration
//
//    If you're developing with Eclipse, you can use the SmartClient personality for Eclipse ATF
//    (+externalLink{http://eclipse.org/atf, Ajax Toolkit Framework}).  Here's how to set it up:
//    <p>
//    1. If you haven't already, download and install ATF from 
//      +externalLink{http://www.eclipse.org/atf/downloads/index.php}.
//      The SmartClient personality has been tested against the ATF 0.1 Milestone Build, but is
//      also known to work with later releases.<p>
//    2. Download the SmartClient personality: 
//        +externalLink{http://smartclient.com/product/SmartClient_ATF_Personality_1.0.zip,SmartClient_ATF_Personality_1.0.zip}<p>
//    3. Unzip the above archive into your eclipse installation directory.  This will create
//    three directories under the plugins directory: <i>com.smartClient.core_1.0.0,
//    com.smartClient.runtime_1.0.0, com.smartClient.ui_1.0.0</i>.<p>
//    4. For the next step, you will need to have downloaded and unzipped a copy of the
//    SmartClient Evaluation SDK, available from
//    +externalLink{http://smartclient.com/product/download.jsp}.  You can of course also use
//    any other licensed copy of SmartClient.  From the SDK, copy the <i>isomorphic</i>
//    directory from smartclientRuntime into the
//    <i>eclipse/plugins/com.smartClient.runtime_1.0.0/resources</i> directory.
//    <p>
//    You're all set.  When you next start Eclipse, you'll be able to select ATF->SmartClient as
//    a new Project Facet during project creation or add it as a facet to an existing project.
//    You can then create new SmartClient Applications by right-clicking on your project and
//    selecting New->Other->SmartClient->SmartClient Application.  And you'll be able to use the
//    provided snippets to quickly create components.  If you have any problems, please post to
//    the +externalLink{http://forums.smartclient.com,forums}.
//
// @title Eclipse Integration
// @visibility external
//<

//> @groupDef featureExplorerOverview
//
// The +docTreeLink{FeatureExplorer, Feature Explorer} is an example shell designed to help you
// explore the capabilities of SmartClient.  Read on for a brief overview, including specific
// instructions for using the example code in your own standalone application.
// <p>
// The tree on the left of the Feature Explorer contains examples grouped by logical
// categories.  Selecting an example brings it up on the right side of the screen, inside a
// tabbed view.  The default "View" tab shows the interactive example itself, while other
// tabs show the underlying source.  The "JS" tab shows the source for the example.  There is
// sometimes also an "XML" tab that shows the corresponding version in 
// +link{componentXML, Component XML} format.  For databound examples, there are also
// frequently additional tabs that show the +link{dataSource, DataSources} associated with the
// example.
// <p>
// <b><u>How to create a standalone application using code from the Feature Explorer</u></b>
// <p>
// The Feature Explorer shell is designed to show many examples in one place and to enable
// experimentation by providing a way for you to modify example code and try out your changes.
// As a result, the Feature Explorer requires some basic server support and its examples omit
// the usual SmartClient module includes that have to be in place for using SmartClient
// components standalone.
// <p>
// If you'd like to use example code in your application to get started quickly, create a page
// with SmartClient includes and then take the code from the "JS" tab and place it between
// &lt;SCRIPT&gt; blocks as described +link{group:nonJavaBackend, here}.  If the example also
// includes a datasource, place the datasource definitions in the same file before the
// component code.  Note that DataSources (and components) written in XML require the optional
// SmartClient server.  If you're using the server, you can include them on your page using the 
// +link{group:loadDSTag} tag.
// <p>
// <b><u>Feature Explorer difference in the LGPL package</u></b>
// <p>
// The LGPL edition of SmartClient does not include the SmartClient Java Server as part of the
// licensed software, but a trimmed down server is included in the package to support the
// Feature Explorer shell.  There are some examples that use DataSources that would normally
// use the SmartClient server for persistence.  In the LGPL package, these DataSources are
// automatically turned into +link{group:clientOnlyDataSources, Client Only DataSources} and
// the Feature Explorer loads the data for these one-time from the dataURL or testFileName
// attributes specified on the DataSource.  Subsequent DataSource operations work against this
// client-side dataset, which is why changes to the data aren't permanent in these examples.
// <p>
// Check out the +link{clientServerIntegration, Client-Server Integration} overview topic for
// an overview of your DataBinding options.
//
// @title Feature Explorer Overview
// @visibility external
//<

//> @groupDef iscInstall
//
// This overview serves as a how-to for installing SmartClient into your web application.
// Evaluators are urged to use the SmartClient SDK with the embedded tomcat servlet engine
// during evaluation rather than persue installation into an existing web application up front,
// however, reading this document and the related +link{group:clientServerIntegration,server
// integration} materials is recommended to get an overview.
// <P>
// SmartClient has two pieces - the client components that run in the browser and the server
// components that run in a J2SE compatible container.  You don't need to use a Java back-end
// to use SmartClient, but the SDK comes with some examples that assume the presence of the
// Java back-end and, for some examples, a SQL Database.  If you will be using SmartClient with
// a Java back-end, see below for the list of J2SE application servers supported by the Java
// implementation of the SmartClient server.
// <p>
// The SDK contains two top-level directories: <code>smartclientSDK</code> and
// <code>smartclientRuntime</code>.  The <code>smartclientSDK</code> directory contains the
// membedded servlet engine, embedded database, examples, and documentation.  The
// <code>smartclientRuntime</code> directory contains just the client and server components of
// the SmartClient product - use the contents of this directory when deploying SmartClient into
// your application environment.
// <p>
// <u><b>Client integration</b></u>
// <p>
// To install the client-side portion of SmartClient, simply copy the <code>isomorphic</code>
// directory from the smartclientRuntime webroot to the webroot of your application.  Having
// done this you can use SmartClient components on your pages regardless of the technologies
// used on your back-end and you can bind to server-side componentry backed by arbitrary
// technology - see the <i>Data Integration</i> section of the
// +link{group:clientServerIntegration} section for more information.
// <p>
// <u><b>Server integration</b></u>
// <p>
// SmartClient can be +link{group:nonJavaBackend,integrated with any backend} without
// installing the SmartClient Java server.  However, the SmartClient server accelerates Java
// integration and provides other useful facilities, including server-push and network
// performance enhancements.  See the +link{group:iscServer,SmartClient Server summary} for
// details.
// <P>
// To integrate the server portion of SmartClient, you need to follow the steps below for each
// application (WAR) that uses SmartClient.  Note that, if installing into an environment that
// uses multiple WARs, installation of SmartClient JARs into a directory shared by multiple
// applications is not supported.  Installation of a separate WAR with client-side SmartClient
// modules for maintaining cache coherence across applications using the same version of ISC is
// supported - contact Isomorphic support for more details on how to set that up.  
// <p>
// <ul>
// <li> Copy all files from WEB-INF/lib directory of the smartclientRuntime to your
// WEB-INF/lib.  SmartClient
// leverages a number of third-party libraries - if there are conflicts with the versions you
// want to use, use the versions you want - SmartClient has minimal dependencies on these
// libraries.  Contact Isomorphic with any specific questions about compatibility.
// See the "Java Module Dependencies" section below for a dependency tree that will
// help you select a minimal set of JARs to deploy.
// <li> Copy the WEB-INF/classes/log4j.isc.config.xml from the smartclientRuntime to your
// WEB-INF/classes
// directory.  This file contains the SmartClient server log configuration.
// <li> Copy the WEB-INF/classes/server.properties from the smartclientRuntime to your WEB-INF/classes
// directory.  This file contains settings for basic file locations such the location of
// webroot, the SmartClient SQL engine and DMI.  The version under smartclientRuntime has a
// basic, secure configuration.  See the version of server.properties under the
// smartclientSDK directory for sample SQL and other settings.
// <li> Copy the WEB-INF/iscTaglib.xml from the smartclientRuntime to your WEB-INF directory.
// This file enables the use of custom SmartClient tags in your JSPs.  
// <li> Merge portions of the WEB-INF/web.xml into your application's web.xml.  To use
// SmartClient JSP tags like &lt;loadISC&gt;, you'll need to merge the &lt;jsp-config&gt;
// section from web.xml.  Also there are some mandatory and optional servlets and filters to
// merge - see below.
// <li> Copy the shared/ds/batchUpload.ds.xml file to the same location in your target webapp
// directory.  This file is a utility DataSource that is used to provide the initial upload 
// functionality of the +link{BatchUploader} component - strictly speaking, you only need to perform
// this step if you intend to use that component.
// 
// </ul>
// <u>Merging web.xml</u>
// <p>
// The following is a description of the servlets and filters you'll find in the web.xml file
// contained in the smartclientRuntime and what they do:
// <p>
// <i>Core Functionality</i>
// <ul>
// <li>Init servlet- <b>required:</b> initializes the SmartClient server componentry from config files
// at container startup time.  Notice that this servlet has no mapping - it's purely an
// initialization servlet.
// <li>IDACall servlet - <b>required</b> for +link{DMI}, built-in RPC operations and built-in DataSource
// operations to work.  All databound examples in the SDK use this servlet.  If you're planning on
// using a custom actionURL for all your RPC requests, then you don't need this servlet.
// <li>FileDownload servlet - required for serving the Isomorphic framework code compressed and with
// caching headers as well as for serving skin images with caching headers.  It is highly
// recommended that you use this for production but is not required. 
// <li>PreCache servlet - loads resources into memory on container startup.  Not required, but if you
// exclude this servlet there may be a slow response to the very first request.
// <li>jsp-config section - the iscTaglib registration block is required to use
// &lt;isomorphic&gt; tags, and the *.isc and *.rpc mappings.  These are optional, if you want
// to use these as handy development tools.
// </ul>
// <p>
// <i>Optional Functionality</i>
// <ul>
// <li>HttpProxy - used by the RPCManager when sending AJAX RPCs to a server other than the
// server that serves the main application page.  You need to install this servlet if, for
// example, your application will be querying web services exposed by servers other than the
// server that is serving the rest of the application.  See the javadoc for this servlet for
// various configuration options, such as how to restrict the URLs that are allowed to be
// proxied. 
// <li>MessagingServlet - used by the realtime messaging system.  If you're planning
// on using this subsystem, you'll need this servlet.
// <li>CompressionFilter - required if you want to use dynamic compression of html and js
// files.
// <li>JSSyntaxScannerFilter - development tool that looks for trailing commas in JS
// source (scans html files for &lt;script&gt; tags and scans .js files in their entirety).
// This is a useful development tool, but should not be included in production.
// <li>NoCacheFilter - development tool that makes any content it intercepts non-cacheable in
// order to ensure developers are looking at the latest version of a file when modifying
// examples.  Not for production use.
// </ul>
// Note that not all of the servlets and filters listed under <i>Optional Functionality</i>
// above are present in the web.xml that ships with the smartclientRuntime - if you need to use
// any of these, copy their configuration from the web.xml available under the WEB-INF
// directory of smartclientSDK.  Other servlets, filters and configuration files from the
// smartclientSDK should not be copied to your deployment, simply because the SDK includes many
// developer tools that are not extensively audited from a security standpoint.
// <p>
// <u><b>Java Module Dependencies</b></u>
// <p>
// The following is a description of what functionality is contained in each SmartClient JAR
// file, and which other SmartClient JARs and third party libraries are required to enable that
// functionality.  Note that actual filenames in WEB-INF/lib will typically contain the version
// number of the library, whereas the library names below simply list the base name.
// <ul>
// <li><b>isomorphic_core_rpc</b>: This is the core SmartClient module.  It provides the RPC, DMI,
// and DataSource support.<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-cli<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-collections<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-pool<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-codec<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isc-jakarta-oro<br>
// &nbsp;&nbsp;&nbsp;&nbsp;log4j<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-jxpath<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-httpclient<br>
// &nbsp;&nbsp;&nbsp;&nbsp;velocity<br>
// &nbsp;&nbsp;<u>Optionally Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;xercesImpl - if you're using JDK &lt; 1.5<br>
// &nbsp;&nbsp;&nbsp;&nbsp;xml-apis - if you're using JDK &lt; 1.5<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-fileupload - if you plan to use the upload form item with
// SmartClient processing.<br>
// </li>
// <li><b>isomorphic_web_services</b>: Web services examples only.  Contains code backing the
// SmartClientOperations.wsdl example.  Do not deploy in production.<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
// &nbsp;&nbsp;&nbsp;&nbsp;axis<br>
// &nbsp;&nbsp;&nbsp;&nbsp;axis-schema<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-discovery<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br>
// &nbsp;&nbsp;&nbsp;&nbsp;jaxrpc<br>
// &nbsp;&nbsp;&nbsp;&nbsp;saaj<br>
// &nbsp;&nbsp;&nbsp;&nbsp;wsdl4j<br>
// </li>
// <li><b>isomorphic_tools</b>: Contains back-end logic for the "Admin Console" tool visible in
// the Developer Console, and also standalone from the SDK home page.  This is an SDK-only
// tool, not intended for production deployment, and further intended for rapid prototyping
// only.  Do not deploy this module to production, but you may use it in your development if
// you're using the SmartClient rapid prototyping SQL engine.<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_sql<br>
// </li>
// <li><b>isomorphic_embedded_tomcat</b>: This contains the bootstrap class for the Embedded
// Tomcat engine shipped with the SmartClient SDK.  It is not intended to be used in any way
// other than via the start_embedded_tomcat.bat|sh|command scripts in the webRoot of the
// SDK.<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
// &nbsp;&nbsp;&nbsp;&nbsp;All JARs under WEB-INF/embeddedTomcat/lib<br>
// </li>
// <li><b>isomorphic_struts</b>: Contains the ValidationAction and ValidationFailureAction
// classes that implement RPC-based validation of DynamicForms using the Struts
// ValidatorPlugIn.  If you're not using Struts or if you don't need this particular feature of
// SmartClient, you do not need this module or its dependencies.  An example of this style of
// validation is available here: +externalLink{/examples/struts/forms/welcome.do} - read the
// info on this page, and follow the "Dynamic Form (With RPC-based Validation) Link for
// the actual example.<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
// &nbsp;&nbsp;&nbsp;&nbsp;struts<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-digester<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-beanutils<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-fileupload<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-validator<br>
// &nbsp;&nbsp;&nbsp;&nbsp;jakarta-oro<br>
// </li>
// <li><b>isomorphic_spring</b>: Required for +link{DMI} dispatches to Spring beans (via
// +link{serverObject.lookupStyle} : "spring").<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
// &nbsp;&nbsp;&nbsp;&nbsp;spring<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br>
// </li>
// <li><b>isomorphic_examples</b>: Contains code for various SmartClient examples shown in the
// SDK.  Do not deploy to production.  The source code for the compiled classes in this module
// are present in the SDK in various locations and typically linked to directly from the
// examples that use them.<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_sql<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_struts<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_spring<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_hibernate<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br>
// &nbsp;&nbsp;&nbsp;&nbsp;jstl<br>
// &nbsp;&nbsp;&nbsp;&nbsp;jakarta-taglib-standard<br>
// </li>
// <li><b>isomorphic_realtime_messaging</b>: Server support required for the SmartClient
// Realtime Messaging Module.  Install this if you're using this 'push' technology.  For more
// information, see: +docTreeLink{Messaging QuickRef}:<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
// </li>
// <li><b>isomorphic_hibernate</b>: Contains support for Hibernate DataSources as described
// here: +link{group:hibernateIntegration}.<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br>
// &nbsp;&nbsp;&nbsp;&nbsp;hibernate3<br>
// &nbsp;&nbsp;&nbsp;&nbsp;commons-logging<br>
// &nbsp;&nbsp;&nbsp;&nbsp;dom4j<br>
// &nbsp;&nbsp;&nbsp;&nbsp;jdbc2_0-stdext<br>
// &nbsp;&nbsp;&nbsp;&nbsp;asm<br>
// &nbsp;&nbsp;&nbsp;&nbsp;asm-attrs<br>
// &nbsp;&nbsp;&nbsp;&nbsp;jta<br>
// &nbsp;&nbsp;&nbsp;&nbsp;cglib<br>
// &nbsp;&nbsp;&nbsp;&nbsp;antlr<br>
// &nbsp;&nbsp;<u>Optionally Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;hsqldb - not required for linking, but needed for Hibernate to
// actually connect to databases of this type, and hsqldb is what's used in the SDK examples.
// Note that for production use you will need a JDBC driver for your database type.<br>
// </li>
// <li><b>isomorphic_sql</b>: Implementation of the SmartClient SQL rapid prototyping layer.
// This is a SQL generation engine similar to Hibernate, but not as flexible.  Some SQL-based
// SDK examples rely on this logic, but it should not be used in production.<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> 
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_hibernate<br> 
// &nbsp;&nbsp;&nbsp;&nbsp;commons-dbcp<br> 
// &nbsp;&nbsp;&nbsp;&nbsp;hsqldb<br> 
// </li>
// <li><b>isomorphic_js_parser</b>: A parser capable of reading a JSON byte stream and creating
// an in-memory Java object structure to match.  Used by any mechanism that relies on
// JSON-style configuration.  Examples include FileAssembly definitions in JSON format, any use
// of the rulesFile with a URIRegexFilter (Java Servlet) or subclass.  Generally not
// required.<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> 
// </li>
// <li><b>isomorphic_compression</b>: This is a part of the Network Performance Module.  The
// isomorphic_compression module is required for dynamic and static compression of various
// assets delivered to the browser.  For more information, see: 
// +link{group:compression}.<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> 
// </li>
// <li><b>isomorphic_assembly</b>: This is part of the Network Performance Module.  The
// isomorphic_assembly module is required for file assembly and stripping.  For more
// information, see: +link{group:fileAssembly}.<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> 
// &nbsp;&nbsp;<u>Optionally Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_obfuscation - for code obfuscation<br> 
// </li>
// <li><b>isomorphic_obfuscation</b>: This is part of the Network Performance Module.  The
// isomorphic_obfuscation module is required to enable obfuscation of code assembled by the
// File Assembly system.  For more information, see: 
// +link{group:compression}.<br>
// &nbsp;&nbsp;<u>Requires</u>:<br>
// &nbsp;&nbsp;&nbsp;&nbsp;isomorphic_core_rpc<br> 
// </li>
// </ul>
// <p>
// <u><b>Caching Considerations</b></u>
// <p>
// When upgrading from one SmartClient release to the next you want to make sure that the user
// picks up the new version on next access, but you also want to keep the ISC modules cacheable
// so they're not refetched on every access.
// <p>
// SmartClient deals with this problem by appending a version string as a query parameter to
// each module load directive.  This is done by the &lt;isomorphic:loadISC&gt; and
// &lt;isomorphic:loadModules&gt; tags automatically.  As long as you make sure that the file
// that contains these tags is non-cacheable, you will get the desired behavior.
// <p>
// <u><b>Supported J2SE Containers</b></u>
// <p>
// Below is the list of J2SE containters that have been tested to be compatible with this
// version of SmartClient.  Installation in these containers is supported for deployment by
// Isomorphic.  If your application server is not on this list, please contact us at the
// <a href="http://forums.smartclient.com" target='_blank'>SmartClient forums</a> to see if we can support
// your deployment.  In general, the Java portion of ISC should work on servlet containers that
// comply with servlet specification version 2.3 and up and utilize a JVM no older than version
// 1.4.
// <p>
// Supported J2SE Containers:
// <p>
// <table class='normal'>
// <tr><td width=40></td><td width=200><i>Apache Tomcat 4.0.x, 4.1.x, 5.0.x, 5.5x, 6.0.x</i></td><td></td></tr>
// <tr><td></td><td><i>Apache Geronimo 1.x, 2.x</i></td><td></td></tr>
// <tr><td></td><td><i>BEA WebLogic 6.x, 7x, 8.x, 9.x, 10.x</i></td><td></td></tr>
// <tr><td></td><td><i>Caucho Resin 2.1.x, 3.0.x, 3.1.x</i></td><td></td></tr>
// <tr><td></td><td><i>IBM WebSphere 5.x, 6.x</i></td><td></td></tr>
// <tr><td></td><td><i>IBM WebSphere Community Edition 1.x</i></td><td></td></tr>
// <tr><td></td><td><i>JBoss 3.2.x, 4.0.x, 4.2.x</i></td><td></td></tr>
// <tr><td></td><td><i>Mortbay Jetty 4.x, 5.x, 6.x</i></td><td></td></tr>
// <tr><td></td><td><i>Oracle Containers for J2EE (OC4J) 9.x, 10.x, 11.x</i></td><td></td></tr>
// <tr><td></td><td><i>Oracle Application Server 10g 9.x, 10.x</i></td><td></td></tr>
// <tr><td></td><td><i>Sun Application Server 8.x, 9.x</i></td><td></td></tr>
// </table>
//
// <p>
// <u><b>Troubleshooting</b></u>
// <p>
// This section covers some common problems with possible solutions. You may also need to refer to the
// documentation for your specific application server, web server,  or database. If you experience any problems
// installing and configuring SmartClient in your environment, please post on the 
// <a href="http://forums.smartclient.com/" target='_blank'>SmartClient forums</a> for
// assistance.
// <p>
// <table width="90%" class="normal" align="center" border="1" cellpadding="5">
// <tr bgcolor="#808080">
// 	<td width="30%"><b>Problem</b></td>
// 	<td width="30%"><b>Possible Causes</b></td>
// 	<td width="40%"><b>Solution</b></td>
// </tr><tr>
// 	<td rowspan='3'>Browser displays a generic "page cannot be displayed" or "unable to locate the server" message.</td>
// 	<td>Servlet engine not started.</td>
// 	<td>Start your application server.</td>
// </tr><tr>
// 	<td>Missing/incorrect port for servlet engine in URL.</td>
// 	<td>Check the startup messages, logs, or documentation for the servlet engine to determine what port it is using.</td>
// </tr><tr>
// 	<td>Host name is incorrect.</td>
// 	<td>Check whether other pages on the host can be accessed.
// 		Try the base URL http://[host name]:[port number] to see whether the servlet engine or webserver is functioning.</td>
// </tr><tr>
// 	<td>Browser displays a 404 or other page/file not found error.</td>
// 	<td>Incorrect URL.</td>
// 	<td>Check for errors in the URL, including capitalization.</td>
// </tr><tr>
// 	<td>Server error: taglib not defined</td>
// 	<td>Missing iscTaglib.xml or iscTaglib.xml not referenced in web.xml</td>
// 	<td>Copy WEB-INF/iscTaglib.xml from smartclientRuntime to your deployment WEB-INF directory
// 	and make sure that you have merged the &lt;jsp-config&gt; section from the
// 	smartclientRuntime web.xml</td>
// </tr><tr>
//  <td>ClassNotFound or other Java Exceptions in the server log.</td>
//  <td>Missing JAR files</td>
//  <td>Verify every .jar from the smartclientRuntime WEB-INF/lib directory has been copied to
//  your deployment WEB-INF/lib.  Although you might later be able to remove some .jars, for
//  initial installation testing, copy every .jar</td>
// </tr><tr>
//  <td>"isc" is not defined JS error</td>
//  <td>Incorreect URLs to SmartClient modules</td>
//  <td>use View Source to look at SCRIPT includes (e.g. for ISC_Core.js), try those URLs
//  directly in the browser to  verify the files are correctly deployed</td>
// </tr>
// </table>
// 
// @treeLocation Concepts
// @title Deploying SmartClient
// @visibility external
//<


//> @groupDef iscServer
//
// The SmartClient Server is a set of Java libraries, servlets and tools that provide the key
// server-side components needed to build a complete application in the modern web
// architecture.
// <P>
// The SmartClient Server can be +link{group:iscInstall,integrated} into any pre-existing Java
// application, and is designed to rapidly connect SmartClient visual components to
// pre-existing Java business logic or persistence engines.  SmartClient's Ajax request
// processing facilities can be easily integrated into Struts Actions,
// +link{group:springIntegration,Spring controllers}, or custom servlets and JSPs.
// <P>
// Alternatively, the SmartClient Server provides a complete SQL and Hibernate-based
// persistence engine for new applications, with out-of-the-box servlets for processing Ajax
// data requests.
// <P>
// The SmartClient Server is optional, and SmartClient's client-side Ajax engine can be
// integrated with any server that provides HTTP access, using XML, JSON, SOAP or proprietary
// data protocols.  However any server in a modern web application will be required to provide
// most or all of the features of the SmartClient Server (described below), and the SmartClient
// Server represents a best-of-breed implementation of these facilities with a long history of
// high-volume production deployments.
// <P>
// <h4>Server enforcement of +link{class:Validator,Validators}</h4>
// <P>
// Data passed from the browser can be automatically validated by the SmartClient Server.
// In contrast, when using +link{group:clientDataIntegration,client-side integration},
// data arrives as HTTP params or XML messages, and you must parse values into the correct
// types (eg java.util.Date) and validate them, or use a server framework that does so.
// <P>
// <h4>High Speed Data Delivery / Data Compression</h4>
// <P>
// The SmartClient Server delivers data to and from the browser using a proprietary, maximally
// efficient protocol, providing simple Java APIs for sending and receiving data.
// <P>
// SmartClient's data protocol is:
// <ul>
// <li> automatically compressed: provides 6-8x improvement in bandwidth utilization
// <li> efficient on the server: high speed data serialization for any Java Object
// <li> efficient in the browser: faster than ordinary XML or JSON data delivery
// <li> minimal: facilities for +link{dataSource.dropExtraFields,trimming} and
// +link{dataSourceField.valueXPath,extracting} only the data you want the browser to see
// </ul>
// <P>
// <h4>Transparent upload support</h4>
// <P>
// SmartClient provides special client and server-side support for +link{group:upload,file
// upload}, which allows single and multiple-file HTTP uploads to be performed as a background
// Ajax request without reloading the page or launching sub-windows.
// <P>
// Uploaded files arrive at the SmartClient server as Java InputStreams accessible from the
// DSRequest object, and can optionally be automatically stored via SmartClient's SQL
// subsystem.
// <P>
// <h4>Transparent Queuing / "Batch" Operations</h4>
// <P>
// Any request transmitted to the SmartClient Server can be combined into a "queue" transmitted
// as a single HTTP request, with in-order execution for all queued operations. 
// +link{RPCManager.startQueue,startQueue()} starts a queue and
// +link{RPCManager.sendQueue,sendQueue()} transmits it; queueing is transparent to the code
// that initiates the individual requests.  This enables:
// <ul>
// <li> re-use of data access operations across different screens
// <li> easy implementation of transaction boundaries
// <li> simplified saving and loading of screens with complex, master-detail views
// <li> guaranteed in-order processing of operations
// <li> more efficient network usage
// </ul>
// <P>
// <h4>Visual Builder</h4>
// <P>
// +link{group:visualBuilder,Visual Builder} is included with the SmartClient Server, and uses
// server features such as automatic SQL binding to provide a rapid prototyping environment.
// <P>
// <h4>Automatic Bi-directional Java &lt; - &gt; JavaScript serialization and translation</h4>
// <P>
// Provides a powerful, type-safe +link{rpcRequest.data,data transmission mechanism} for moving
// data between a Java server and the browser. 
// <P>
// Any Java objects, including Java Beans, POJOs, Java Collections, XML DOMs and all Java
// primitives, with any level of nesting, can be automatically serialized and delivered as
// JavaScript Objects to the SmartClient client-side components.
// <P>
// JavaScript Objects existing in the browser can likewise be automatically transmitted to a
// Java Server and translated to Java Objects, with any level of nesting and automatic
// preservation of primitive types.
// <P>
// <h4>SQL and Hibernate connectors</h4>
// <P>
// DataSource of serverType:"sql" or serverType:"hibernate" can generate and execute queries
// against popular SQL engines or against the Hibernate ORM system, providing SmartClient's
// +link{DataBoundComponent}s with the four standard CRUD operations (create, retrieve, update,
// delete) without writing any server-side code.  For rapid prototyping, these DataSources can
// even generate SQL tables based on the DataSource declaration, using the
// +link{group:adminConsole} visual tool.
// <P>
// Server-side APIs allow server-side modification of the request before it is executed (for
// example, to enforce security) and post-processing of the request after execution (for
// example, to provide calculated values).
// <P>
// Both serverType:"sql" and serverType:"hibernate" support the field-operator-value queries
// that can be generated by using the +link{FilterBuilder} component (see
// +explorerExample{filterBuilderBracket,example}).
// <P>
// <h4>Rich, Standardized Request / Response protocol</h4>
// <P>
// The SmartClient Server provides a standardized request and response protocol designed for
// data-oriented "CRUD" operations (create, retrieve, update, delete).
// <P>
// This standardized protocol automatically handles +link{DSRequest,request metadata} (paging
// parameters, requested sort order, original values of data being modified) and
// +link{DSResponse,response metadata} (error handling, cache management, session expiration etc).
// <P>
// Similar to the impact of Struts on early web applications, this standardized protocol avoids
// developers in different groups inventing their own incompatible and redundant
// request/response protocols, and allows developers to more easily learn code they didn't
// author.
// <P>
// <h4>Bi-directional XPath binding to Java Objects</h4>
// <P>
// Most UI designs do not directly reflect the underlying Object model and so some degree of
// translation is necessary in order to populate UI components with data and apply user changes
// to the Java Object model.  This is often accomplished with brittle, difficult to understand
// data translation code sprinkled throughout the system, done in a different way for every
// screen or component.
// <P>
// SmartClient provides a standard, +link{dataSourceField.valueXPath,XPath-based approach} to
// adapting any Java-based Object model to the requirements of the UI design.  Data relevant to
// the application UI is centrally extracted in the server-side +link{DataSource} layer, so
// that all UI components have a consistent, unified view of the data model for both loading
// <b>and</b> saving data.
// <P>
// <h4>Broadest possible browser support</h4>
// <P>
// The SmartClient Server can compensate for facilities 
// +link{group:platformDependencies,missing or disabled in certain browsers},
// including ActiveX being disabled in IE6 and missing XML support in some versions
// of Apple's Safari browser.
// <P>
// <h4>Transparent Proxying</h4>
// <P>
// +link{RPCManager.sendProxied,Proxying} allows SmartClient applications to access web
// services, RSS feeds, HTML content and other data services in a secure manner regardless of
// where they are located: across the enterprise or publicly available.
// <P>
// <h4>Optional +link{group:networkPerformance,Network Performance} Module</h4>
// <P>
// Provides:
// <ul>
// <li> compressed delivery of SmartClient runtime, application logic and other assets such as CSS
// <li> +link{FileLoader,background download} of SmartClient and other assets for zero
// user-perceived load time
// <li> on-the-fly stripping, combining and obfuscation of JavaScript (application code and data)
// <li> browser cache control
// </ul>
// <P>
// <h4>Optional Messaging Module (aka server push)</h4>
// <P>
// The +docTreeLink{messaging,Messaging} module allows the server to "push" messages to the client, without
// client polling, for real-time monitoring/dashboarding applications.
//
// @title SmartClient Server Summary
// @treeLocation Java Server Reference
// @visibility external
//<


//> @groupDef jsfIntegration
//
// SmartClient can be used within JSF applications to add AJAX richness and interactivity.
// <P>
// Because +link{group:iscJSF,JSF is a pre-AJAX architecture}, the recommended approach in adding
// SmartClient to JSF applications is to create pages that use SmartClient components exclusively,
// so that older, server-based JSF components do not introduce full-page refreshes.
// <P>
// JSF pages that render components on the server access data via JSF Expression Language.
// SmartClient-based JSF pages can similarly load initial data by using JSTL, as shown in the
// +externalLink{/examples/server_integration/#jstlList,this example}, where a ListGrid is
// populated by JSTL access to Java Beans stored in the JSP <code>pageContext</code>.  
// <P>
// Once a SmartClient JSF page has loaded, SmartClient components will request data via background
// HTTP requests that load only data, not a complete page.  The 
// +link{class:DMI,Direct Method Invocation} system can be used to declaratively map SmartClient's
// background data requests directly to Java Methods. The SmartClient server automatically
// translates inbound request data into Java Objects that are passed to the method you specify,
// and the Java method return value is automatically translated into data for SmartClient
// components.
// <P>
// <h4>Incorporating server-side JSF components into a SmartClient JSF page</h4>
// <P>
// An +link{HTMLFlow} or +link{HTMLPane} component can be used to incorporate server-generated
// content within a SmartClient-based page.  With +link{htmlFlow.contentsType,contentsType} set to
// "page", the HTMLPane/Flow will act like a standalone page-within-a-page (via a
// SmartClient-managed HTML IFRAME element), allowing interactive server-side JSF components to
// participate normally, with limitations as discussed under the documentation for 
// +link{htmlFlow.contentsType,contentsType}.
//
// @treeLocation Concepts
// @title Integration with JSF
// @visibility external
//<

//> @groupDef strutsIntegration
//
// <b>Overview of SmartClient integration with Struts and other popular server-side
// frameworks.</b>
// <p>
// Current and upcoming server-side frameworks solve a lot of problems endemic to the past
// generation of web applications.  Piles of JSPs and Servlets have been replaced by MVC and
// other paradigms that enhance developer productivity.  Unfortunately the end-user
// presentation remains vanilla HTML.  SmartClient solves this problem by providing rich
// databindable components. SmartClient was designed to integrate cleanly with existing
// server-side frameworks.  Because SmartClient components only require an HTML context to
// render, they can be used with any server-side frameworks that use HTML for presentation.
// <p>
// SmartClient provides a rich UI by doing more work on the client (browser) rather than
// sending every user action to the server for re-rendering.  Instead of doing page transitions
// to redraw the whole page, SmartClient sends RPC (Remote Procedure Call) requests (or AJAX
// requests) to the server while the UI allows the user to continue interacting with the
// system.  Current server-side frameworks, on the other hand are typically designed around
// page transitions - for example in Struts user actions are typically mapped to URLs that
// dispatch through a central servlet and ultimately return new HTML to be rendered by the
// browser.  The problem with page transitions is that they destroy client-side state and
// introduce client-server latency (and generally use more bandwidth since HTML is sent over
// the wire rather than just data) - essentially destroying a large part of the Rich
// Internet Application (RIA) experience.
// <p>
// Fortunately, there's a way to get the best of both worlds - to leverage the power of your
// favorite server-side framework and combine it with the SmartClient UI.  There are several
// approaches to integrating SmartClient into an existing framework:
// <p>
// <u><b>Plug-replacing HTML components with SmartClient components</b></u>
// <p>
// SmartClient components can be instructed to draw at page load time using by specifying
// <code>position: "relative"</code> at construction time.  This enables you to replace any
// chunk of HTML with a SmartClient component - the new component simply inserts its HTML in
// the page flow during page load.  This is the easiest integration option - you get a better
// UI with minimal work.  The downside is that you don't get the full power of a rich client
// because most user actions will still trigger a page transition.
// <p>
// <u><b>Eliminating page transitions</b></u>
// <p>
// Most SmartClient components can accept new data (or even dynamically pre-fetch and expire
// data) without needing to be recreated.  For example - let's say you want to draw a grid on a
// page.  In a traditional server-side-rendered application the server would generate all of
// the html with a "next 20 records" and "previous 20 records" buttons. When the user wants to
// see the next set of data, he clicks one of the buttons and the server replaces the entire
// page with a new grid that contains the next/previous 20 records.  In a SmartClient
// application, you would create a databound ListGrid.  Based on its configuration this grid
// will fetch the first N (say 20) records and display a scrollbar for the user to scroll
// through the data.  When the user scrolls off the last cached record the ListGrid
// automatically sends an RPC to the server asking for the next 20 records.  This RPC (fetch)
// is performed without destroying the page the user is currently looking at - it just happens
// seamlessly in the background.  If the user now scrolls back to the first 20 records -
// they're already cached in the grid, so no fetch is performed.  Of course, in a real world
// application, it's typical that a page has hundreds of components and in a server-side-only
// rendering all of them need to be rebuilt by the server and resent to the client when a piece
// of data in just one needs to be updated.  SmartClient components can intelligently update
// just their data without the need to redraw the whole page.
// <p>
// The plug-replacement strategy listed above gives us a SmartClient component in place of a
// raw HTML rendering.  Now we need to databind that component so that actions like scrolling a
// grid or validating a form don't cause a page transition.  The SmartClient RPC mechanism has
// a default actionURL that's configurable by the end user.  This allows you to funnel all RPC
// requests through a central dispatcher like the Struts Action servlet.
// SmartClient RPCs are just HTTP requests with XML payloads that can be accessed using the
// provided Java APIs (RPCManager Java class and associated classes).  On the other hand you
// can decide to have the SmartClient RPCs work out of band of something like the Action
// servlet - the choice is up to you.  Usually funnelling through the Action servlet makes
// sense if you have a need to centrally capture all requests - for example for later playback
// during load or QA testing.
// <p>
// Here's what the code would look like to accomplish the funneling (for example with the
// Struts Action servlet):
// <pre>
// On the client - the following line of code forces all SmartClient RPC requests to make
// requests to the /smartClientRPC.do URL that would then be intercepted by the Action servlet -
// assuming you have the standard *.do mapping for it in your web.xml.
//
// RPCManager.addProperties({ actionURL: "/smartClientRPC.do"});
//
// On the server, you would then create an action mapping for the "/smartClientRPC" path
// that you would forward to a custom Action handler.  For example you could have this in your
// struts config.xml:
//
// &lt;action path="/smartClientRPC" type="com.your.company.name.SmartClientRPCAction"/&gt;
// 
// In your Action execute() method you have access to the HttpServletRequest and
// HttpServletResponse objects - which is all you need to instantiate the RPCManager class
// that's part of the SmartClient server-side SDK that you can then use to obtain the RPC
// payload.  Like this:
//
// RPCManager rpc = new RPCManager(request, response);
// Object data = rpc.getData();
// rpc.send("here's a response");
// </pre> 
// Given this configuration, all databound components will send their requests through this
// pipeline and you need only write the code to respond to e.g. a given ListGrid's request to
// get the next 25 rows.  For custom RPCs, you can specify actionURLs in the RPCRequest itself
// that override the RPCManager default that you can then use to target different actions - in
// other words you need not dispatch all SmartClient RPCs through a single Struts Action.
// <p>
// <u><b>Struts examples in the SDK</b></u>
// <p>
// The SDK contains a simple example of doing form validation without incurring a page
// transition. These examples also show how to populate e.g. field names using the struts-bean
// taglib and how to set validation errors using the standard Struts Validation plugin.
// Point your browser to +externalLink{/examples/struts/forms} in the SmartClient SDK to take a
// look.
//
// @treeLocation Concepts
// @title Integration with Struts
// @visibility external
//<

//> @groupDef springIntegration
// <b>Overview</b>
// <P>
// The Spring framework has many different parts, from integration with Object Relational
// Mapping (ORM) and transaction management systems, to a Model View Controller (MVC)
// architecture.
// <P>
// If you are building a new application from scratch and/or you are trying to 
// modernize the presentation layer of an existing application, most of Spring MVC is
// inapplicable in the +link{group:smartArchitecture,SmartClient architecture}.  Specifically,
// SmartClient renders <b>all</b> HTML on the client, and the server is responsible only for
// retrieving data and enforcing business rules.  This means that Spring's ModelAndView and all
// functionality related to retrieving and rendering Views is unnecessary in SmartClient.
// SmartClient only needs the Model, and provides methods to deliver that Model to SmartClient
// components (the server side method DSResponse.setData()).
// <P>
// However, Spring's DispatchServlet, Handler chain, and Controller architecture is applicable
// to SmartClient.  See "Using Spring Controllers" below.
// <P>
// <b>Existing Spring Application</b>
// <P>
// As discussed under the general +link{group:clientServerIntegration,server integration}
// topic, integrating SmartClient into your application involves finding a way to provide data
// that fulfills the +link{DSRequest,DataSource requests} sent by SmartClient components.
// <P>
// There are 2 approaches for integrating SmartClient into an existing Spring application:
// <ul>
// <li> <b>configure Spring to return XML or JSON responses</b>: create variants
// on existing Spring workflows that use a different type of View in order to output XML or
// JSON data instead of complete HTML pages.  The SmartClient +link{RestDataSource} provides a
// standard "REST" XML or JSON-based protocol you can implement, or you can adapt generic
// +link{DataSource,DataSources} to existing formats.
// <P>
// In some Spring applications, all existing Spring workflows can be made callable by
// SmartClient with a generic View class capable of serializing the Model to XML or JSON,
// combined with a Controller that always uses this View.  Consider the following Java
// anonymous class, which uses the SmartClient JSTranslater class to dump the entire 
// Spring Model as a JSON response.
// <pre>
//  new View() {
//        public void render(Map model, HttpServletRequest request,
//                           HttpServletResponse response) throws IOException {
//                final ServletOutputStream outputStream = response.getOutputStream();
//                response.setContentType("application/x-javascript");
//                outputStream.println(JSTranslater.get().toJS(model));
//                outputStream.close();
//        }
//        public String getContentType() {
//                return "application/x-javascript";
//        }
//  }
// </pre>
// <P>
// If you use this approach, you do not need to install the SmartClient server, and can
// +link{iscInstall,deploy} SmartClient as simple web content (JS/media/HTML files).  If you
// are already familiar with how to generate XML from objects that typically appear in your
// Spring Models, this may be the easiest path.
// <P>
// <li> <b>call Spring beans via SmartClient DMI</b>: use SmartClient Direct Method Invocation
// (DMI) to map +link{dsRequest,DataSource requests} to beans managed by Spring, via
// +link{serverObject.lookupStyle}:"spring".   Return data to the browser by either simply
// returning it from your method, or via calling DSResponse.setData() (server-side method).  
// If, from a bean created by Spring, you can easily create the data you typically use to
// populate a Model in a ModelAndView, this may be the easiest path.
// </ul>
// <P>
// <b>Using Spring Controllers with SmartClient DMI</b>
// <P>
// You can create a Controller that invokes standard SmartClient server request processing,
// including DMI, like so:
// <pre>
// public class SmartClientRPCController extends AbstractController
// {
//     public ModelAndView handleRequest(HttpServletRequest request, 
//                                       HttpServletResponse response)
//         throws Exception
//     {
//         // invoke SmartClient server standard request processing
//         com.isomorphic.rpc.RPCManager.processRequest(request, response);
//         return null; // avoid default rendering
//     }
// }
// </pre>
// This lets you use Spring's DispatchServlet, Handler chain and Controller architecture as a
// pre- and post-processing model wrapped around SmartClient DMI.
//
// @treeLocation Concepts
// @title Integration with Spring
// @visibility external
//<



//> @groupDef hibernateIntegration
//
// SmartClient can integrate with Hibernate in two main ways:
// <ul>
// <li> With pre-existing Hibernate configuration and Java beans, SmartClient
// server-side DSRequests can be transformed into Hibernate <code>Criteria</code> objects,
// and results returned via a SmartClient DSResponse.  
// <li> SmartClient can drive Hibernate as a storage layer only, automatically generating
// Hibernate configuration from a SmartClient DataSource file (<i>dataSourceID</i>.ds.xml).  In
// this case, you do not write a Java bean; Hibernate's beanless 
// +externalLink{http://www.hibernate.org/hib_docs/v3/reference/en/html_single/#persistent-classes-dynamicmodels,"dynamic model"}
// mode is used.  This is enabled via +link{dataSource.serverType}:"hibernate".
// </ul>
// <P>
// <b>Mapping DSRequest/DSResponse to Hibernate</b>
// <P>
// This integration strategy uses the server-side Java APIs described in
// +link{group:serverDataIntegration}.  Two complete examples of Hibernate integration are
// provided in the SDK, one using +link{DMI} and one using +link{RPCManager} dispatch.  Both
// are accessible from the SDK Explorer as Examples->Server Integration, and both include
// sample Hibernate configuration as well as a sample UI capable of loading and saving data.
// <ul>
// <li>
// +externalLink{/examples/server_integration/index.html#customDataSourceIntegrationHibernate,"Custom DataSource Integration with Hibernate"} 
// shows how to create a .jsp that uses RPCManager dispatch to implement all four DataSource
// request +link{dsRequest.operationType}s via Hibernate for a sample bean.
// <li>
// +externalLink{/examples/server_integration/index.html#springDSHiberateDMI,"Spring DataSource Integration using DMI to Hibernate"}
// shows how to use SmartClient Direct Method Invocation (+link{DMI}) to implement all four
// DataSource operations with Hibernate.  This particular example uses
// +link{group:springIntegration,Spring}-based lookup of the target for DMI, however, the same
// approach will work without Spring - see other DMI examples on the same page for non-Spring
// methods of DMI target lookup.
// </ul>
// As discussed under +link{DMI}, whether to use DMI or RPCManager dispatch is largely a matter
// of preference, however if you are already using Spring, a DMI-based approach is probably
// a better fit.
// <P>
// <b>serverType:"hibernate"</b>
// <P>
// As with DataSources using SmartClient's built-in +link{group:sqlDataSource,SQL engine}, you
// need only +link{group:dataSourceDeclaration,create a DataSource} in XML format - no Java
// classes or other configuration are required.  The +link{group:adminConsole,Admin Console}'s
// "Import DataSources" section can be used to import test data into serverType:"hibernate"
// DataSources in the same manner as SQLDataSources.
//
// @treeLocation Concepts
// @title Integration with Hibernate
// @visibility external
//<


//> @groupDef sqlDataSource
// For prototyping purposes, the ISC server supports basic SQL connectivity for DataSources
// defined in XML.  Because the request processing flow for the built-in SQL engine is
// identical to the flow used for 
// +link{group:serverDataIntegration,integrating with other Java storage engines},
// when your application grows past prototype stage you can switch to a different storage
// engine without wasted work.
// <P>
// To use the built-in SQL engine, declare a +link{DataSource} in XML format with
// +link{dataSource.serverType} set to "sql", and place it in the shared dataSources directory
// ([webroot]/shared/ds by default) in a file called "[dataSourceId].ds.xml".
// <p>
// You can then use the +link{group:adminConsole,Admin Console} to configure database access,
// as well as to automatically create and populate a database table based on your DataSource.
// By default, DataSources will use the "default database" from the admin console, however you
// can set +link{dataSource.dbName} to the name of a specific database configuration you have
// configured via the Admin Console.
// <P>
// The list of databases known to work with the the built-in SQL logic is as follows:
// <p>
// <table class='normal'>
// <tr><td width=40></td><td width=200><i>HSQLDB 1.7.x, 1.8.x</i></td><td></td></tr>
// <tr><td></td><td><i>IBM DB2 8.x, 9.x</i></td><td></td></tr>
// <tr><td></td><td><i>MS SQL Server 2000</i></td><td></td></tr>
// <tr><td></td><td><i>MySQL 3.2.x, 4.0.x, 4.1.x, 5.0.x, 5.1.x</i></td><td></td></tr>
// <tr><td></td><td><i>Oracle 8.0.5, 8i, 9i, 10g</i></td><td></td></tr>
// <tr><td></td><td><i>PostgreSQL 7.x, 8.x</i></td><td></td></tr>
// </table>
// <p>You will also need a JDBC driver for your specific database. Licensing restrictions
// prevent us including any JDBC driver other than the one for HSQLDB.  However, you
// can download these drivers for free from the vendors' websites.  If your specific database
// server or version is not listed above, please go to the
// <a href="http://forums.smartclient.com">SmartClient forums</a> for assistance.
// <P>
// You can also connect to an existing database table - the ISC SQL engine simply generates a
// DB table whose columns match the DataSource field names and types, so you can instead
// declare a DataSource whose fields match an existing table.  To troubleshoot such an
// integration, you can look at the generated SQL for both table creation and +link{DSRequest}
// handling in the server-side log.
// <P>
// Once you have your SQL DataSource connected to a table, in a default SDK installation,
// DSRequests for your DataSource will be sent to the default
// +link{RPCManager.actionURL,actionURL}, and hence handled automatically, without you having
// to write any Java code, by the +link{iscInstall,IDACall servlet registered in web.xml}.
// IDACall is a very simple servlet that just calls the server-side method
// dsRequest.execute() for all inbound requests.
// <P>
// If you need to customize how DSRequests are handled on the server, you can write your own
// version of the IDACall servlet to dispatch requests, as described under +link{RPCManager}
// and exemplified by the
// +externalLink{/examples/server_integration/#customDataSourceIntegration,Custom DataSource Integration example}.
// This allows you add your own logic either before or after calling dsRequest.execute() 
// to invoke the normal behavior of the SQL engine.  This means you can implement:
// <ol>
// <li> authenticated access (also see +link{group:relogin})
// <li> custom validation rules, via inspecting the inbound DSRequest and sending back a
//      DSResponse with errors set
// <li> business rules such as user-based data visibility, by eg calling
//      dsRequest.setCriteria() to set certain fixed criteria on all requests
// <li> side effects such as sending notifications mails after data is updated
// <li> server-side formatting or other derived values such as totals, by retrieving the
//      default returned dataset via dsResponse.getData(), and updating it via
//      dsResponse.setData()
// </ol>
// When your application grows past prototype stage and you switch to a different storage
// engine, you should be able to reuse any logic that surrounds the dsRequest.execute() call,
// simply replacing that dsRequest.execute() call with code that performs the dsRequest against
// your own storage engine.
//
// @treeLocation Client Reference/Data Binding/DataSource
// @title SQL DataSources
// @requiresModules SCServer
// @visibility external
//<

//> @groupDef adminConsole
// The Admin Console allows you to configure database access for DataSources that use
// SmartClient's built-in +link{group:sqlDataSource,SQL engine}.
// <P>
// NOTE: You must have the Isomorphic SmartClient package installed and your servlet engine
// started. 
// <p>
// Direct your browser to the following URL to access the Admin Console: 
// <p>
// &nbsp;&nbsp;+externalLink{http://localhost:8080/tools/adminConsole.jsp}
// <p>
// The common default servlet engine port 8080 is used in the URL given above. Adjust your URL
// as necessary if you are using a different port and replace localhost with the machine name
// running the servlet engine if you are accessing it from a remote machine.
// <p>
// Note that the Admin Console interface is also available in the Developer Console as the
// "DataBases" tab.
// <P>
// <b>Test Data</b>
// <p>
// You can create a test file that contains a sample dataset which can be imported into your
// database table with the Admin Console.
// <p>
// The test file to use with your DataSource is specified in the <code>testFileName</code>
// DataSource configuration property. The test file uses the extension .data.xml.
// <p>
// The test data file should consist of a top-level &lt;List&gt; element containing a series of XML
// elements named after your DataSource's ID, each of which creates one DataSource
// record. Values for each field are given within tags named after the field name. 
// <p>
// For example, the following XML is from the supplyItem.data.xml test data file supplied with
// the Isomorphic SmartClient package. This file is located in
// [webroot]/examples/shared/ds/test_data/.
// <p>
// <pre>
// &lt;List&gt;
//  &lt;supplyItem&gt;
//      &lt;description&gt;A revolutionary cushion-grip ballpoint pen that reduces 
//          required gripping power, relieving stress and alleviating writing 
//          fatigue. Excellent for people who suffer from arthritis or carpal 
//          tunnel syndrome. Medium point, black ink. Refillable.&lt;/description&gt;
//      &lt;category&gt;1&lt;/category&gt;
//      &lt;itemRef&gt;ODC 204-502-153&lt;/itemRef&gt;
//      &lt;maxQuantity&gt;5&lt;/maxQuantity&gt;
//      &lt;requiresJustification&gt;0&lt;/requiresJustification&gt;
//      &lt;itemName&gt;Dr. Grip Pens -- Blue Barrel&lt;/itemName&gt;
//      &lt;itemID&gt;1&lt;/itemID&gt;
//      &lt;unitCost&gt;4.99&lt;/unitCost&gt;
//  &lt;/supplyItem&gt;
//  &lt;supplyItem&gt;
//      &lt;description&gt;A revolutionary cushion-grip ballpoint pen that reduces 
//          required gripping power, relieving stress and alleviating writing 
//          fatigue. Excellent for people who suffer from arthritis or carpal 
//          tunnel syndrome. Medium point, black ink. Refillable.&lt;/description&gt;
//      &lt;category&gt;1&lt;/category&gt;
//      &lt;itemRef&gt;ODC 204-708-834&lt;/itemRef&gt;
//      &lt;maxQuantity&gt;5&lt;/maxQuantity&gt;
//      &lt;requiresJustification&gt;0&lt;/requiresJustification&gt;
//      &lt;itemName&gt;Dr. Grip Pens -- Black Barrel&lt;/itemName&gt;
//      &lt;itemID&gt;2&lt;/itemID&gt;
//      &lt;unitCost&gt;4.99&lt;/unitCost&gt;
//  &lt;/supplyItem&gt;
//  &lt;supplyItem&gt;
//      &lt;description&gt;Personalized business cards for all your networking 
//          needs.&lt;/description&gt;
//      &lt;category&gt;2&lt;/category&gt;
//      &lt;itemRef&gt;&lt;/itemRef&gt;
//      &lt;maxQuantity&gt;500&lt;/maxQuantity&gt;
//      &lt;requiresJustification&gt;1&lt;/requiresJustification&gt;
//      &lt;itemName&gt;Personalized business cards -- 500 count&lt;/itemName&gt;
//      &lt;itemID&gt;3&lt;/itemID&gt;
//      &lt;unitCost&gt;25.00&lt;/unitCost&gt;
//  &lt;/supplyItem&gt;
//  ...
// &lt;List/&gt;
// </pre>
// 
// Data for a tree-like DataSource can be specified with the same format.
// The following code example is from the supplyCategory.data.xml test data file. This file
// is also located in [webroot]/examples/shares/ds/test_data/. 
//
// <pre>
// &lt;List&gt;
//     &lt;supplyCategory&gt;
//     	&lt;itemName&gt;Office Paper Products&lt;/itemName&gt;
//     	&lt;parentID&gt;root&lt;/parentID&gt;
//     &lt;/supplyCategory&gt;
//     &lt;supplyCategory&gt;
//     	&lt;itemName&gt;Calculator Rolls&lt;/itemName&gt;
//     	&lt;parentID&gt;Office Paper Products&lt;/parentID&gt;
//     &lt;/supplyCategory&gt;
//     &lt;supplyCategory&gt;
//     	&lt;itemName&gt;Adding Machine/calculator Roll&lt;/itemName&gt;
//     	&lt;parentID&gt;Calculator Rolls&lt;/parentID&gt;
//     &lt;/supplyCategory&gt;
//     . . .
// &lt;/List&gt;
// </pre>
// 
// Notice that all records must define values for the itemName primary key field and for the
// parentID field that establishes the tree relationship.
//
// @treeLocation Client Reference/Data Binding/DataSource
// @title Admin Console
// @requiresModules SCServer
// @visibility external
//<

//> @groupDef clientOnlyDataSources
// For prototyping purposes, a "client-only" DataSource can be created that has no permanent
// storage and never contacts the server, instead using a set of test data to respond to
// requests in the same manner as a server-based DataSource might.
// <P>
// The client-side interface to a client-only DataSource is identical to a server-based
// DataSource, including asynchronous responses, so that a client-only DataSource can be
// replaced by a server-based DataSource without code changes.  The only difference is that
// changes to records belonging to the DataSource persist only until the page is reloaded.
// <p>
// Client-only DataSources allow you to create a complete prototype application in an .html
// file that does not require a server.
// <p>
// The <code>clientOnly</code> property is specified to create a client-only DataSource, and
// the <code>testData</code> property should contain the test dataset, as an Array of Objects,
// one per DataSource record.  For example:
// <pre>
//   isc.DataSource.create({
//       ID:"supplyItem",
//       fields: ...,
//       clientOnly:true,
//       testData:[
//          {itemName:"Pencil", cost:5.50},
//          ...
//       ]
//   });
// </pre>
// If you have existing test data in XML, you can use the XML->JS translation engine to load it
// into a client-only DataSource, like so:
// <pre>
//   isc.DataSource.create({
//     ID:"solutions",
//     fields: ...,
//     clientOnly : true,
//     testData : 
//         &lt;isomorphic:XML filename="shared/ds/test_data/solutions.data.xml"/&gt;
//   });
// </pre>
// Another useful practice is to specify both the DataSource and it's test data in XML, so that
// the +link{group:adminConsole,Admin Console} can later be used to import the DataSource and
// its test data into a SQL DataBase.  An idiom for accomplishing this is:
// <pre>
//   &lt;isomorphic:loadDS name="solutions"/&gt;
//   isc.DataSource.getDataSource("solutions").addProperties({
//     clientOnly : true,
//     testData : 
//        &lt;isomorphic:XML filename="shared/ds/test_data/solutions.data.xml"/&gt;
//   });
// </pre>
// Finally, if you specify your DataSource as <code>clientOnly: true</code>, omit testData
// entirely, and provide either a +link{dataSource.dataURL} or a <code>testFileName</code>, the
// DataSource will lazily make a one-time fetch against the specified data file the first time
// an operation is called on it.  From then on, the DataSource will work against the local
// cache created from this initial request.  This is a quick way to prototype against some test
// data that may eventually be returned from an arbitrary back-end.
//
// @treeLocation Client Reference/Data Binding/DataSource
// @title Client Only DataSources
// @visibility external
//<


// synonym, isc namespace only (never a global)
isc.DS = isc.DataSource;

// static properties and methods
isc.DataSource.addClassProperties({
    

	// locating dataSources
	dataSourceObjectSuffix : "DS",			// suffix for the global to hold info about a dataSource,
											//	eg:  var myDataSourceDS = {...}
	
	_dataSources : {},						// internal array to hold the list of dataSources we've loaded
	_elements : {},						    // internal array of XSElements
	_types : {},						    // internal array of XSComplexTypes
    _$element : "element", _$type:"type",
	
	TABLE : "table",						// table type of datasource
	VIEW : "view",							// view type of datasource (virtual datasource)



    // chunks of SOAP messages
	_soapEnvelopeStart : "<soap:Envelope xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/' ",
	_soapEnvelopeEnd : "</soap:Envelope>",
	_soapHeaderStart : "<soap:Header>",
	_soapHeaderEnd : "</soap:Header>",
	_soapBodyStart : "<soap:Body", // intentionally unterminated
	_soapBodyEnd : "</soap:Body>"
});

isc.DataSource.addClassMethods({

    // Looking up and loading DataSources
	// --------------------------------------------------------------------------------------------

    isLoaded : function (name) {
		// if no name was passed to us, return false
		if (!name) return false;
        if (isc.isA.DataSource(name) || this._dataSources[name]) return true;
        return false;
    },
    
    //> @classMethod DataSource.getDataSource()
    // Lookup a DataSource by ID.
    //
    // @param ID (identifier) DataSource ID
    // @return (DataSource) the DataSource with this ID, if loaded, otherwise null.
    // @visibility external
    //<
    // If the dataSource does not exist locally and a callback is provided to this method, we
    // attempt to fetch the named datasource from the server and callback.  
	getDataSource : function (name, callback, context, schemaType) {
		// if no name was passed to us, return null
		if (!name) return null;

        // handle being passed a DataSource instance
        if (isc.isA.DataSource(name)) return name;

        if (schemaType && isc.WebService) {
            if (schemaType == isc.DS._$element) return this._elements[name];
            if (schemaType == isc.DS._$type) return this._types[name];
            return null;
        }

		// load the ds (clientside)
        var ds = this._dataSources[name];
		if (!ds) {
			ds = this._loadDataSource(name, callback);
			if (ds) ds.ID = name; // tell the dataSource it's name for later
		}

		if (ds) {
            // if they've specified a callback, call the callback in addition to returning the ds
            if (callback) {
                this.fireCallback(callback, "ds", [ds], ds);
            }
            
            return ds;
		}

		// load from server if a callback was passed
		if (callback) {
            this.loadSchema(name, callback, context);
        }
			
		// let the caller know that we don't have the datasource.  if a callback was passed,
		// the caller will be notified via the callback.
		return null;
	},
    
    // loadSchema - attempt to load a remote dataSource schema from the server.
    // This is supported as part of the SmartClient server functionality
    loadSchema : function (name, callback, context) {
        this.logWarn("Attempt to load schema for DataSource '" + name + 
            "'. This dataSource cannot be found. To load DataSources from the server without " +
            "explicit inclusion in your application requires optional SmartClient server " +
            "support - not present in this build.");
        return null;
    },
    
    
    //> @classMethod DataSource.get()
    // Synonym of +link{getDataSource()}: Lookup a DataSource by ID.
    //
    // @param ID (identifier) DataSource ID
    // @return (DataSource) the DataSource with this ID, if loaded, otherwise null.
    // @visibility external
    //<
    get : function (name, callback, context, schemaType) { 
        return this.getDataSource(name, callback, context, schemaType); 
    },

    _loadDataSource : function (name, callback) {
		if (callback) return null; // no error if we're going to try to load from server.

		//>DEBUG
        if (name != isc.auto && this.logIsDebugEnabled()) {
            this.logDebug("isc.DataSource '" + name + "' not present");
        }
		//<DEBUG

		// couldn't load the dataSource -- return null
		return null;
	},

    // returns a list of all registered datasources
    getRegisteredDataSources : function () {
        return isc.getKeys(this._dataSources);
    },

	// returns true if the named DS is registered, false otherwise
	isRegistered : function (name) {
		if (this._dataSources[name]) return true;
		return false;
	},

    // Foreign Key relationships
	// --------------------------------------------------------------------------------------------
    // field.foreignKey can be [dataSourceID].[fieldName] or just [dataSourceID], where the latter
    // form means it's a foreignKey on the other dataSource' primary key fields.
    
    // methods to break up field.foreignKey into the target DataSource and field name.  Factored in
    // case we ever want to change our somewhat hokey foreign key scheme
    getForeignFieldName : function (field) {
        var foreignKey = field.foreignKey,
            dotIndex = foreignKey.indexOf(".");
    
        // If there is no dot the foreignkey is a field within this dataSource.
        
        if (dotIndex == -1) return foreignKey;
        return foreignKey.substring(dotIndex + 1);
    },

    getForeignDSName : function (field, defaultDS) {
        var foreignKey = field.foreignKey,
            dotIndex = foreignKey.indexOf(".");

        // If there is no dot the foreignkey is a field within this dataSource.
                
        if (dotIndex == -1) return isc.isA.String(defaultDS) ? defaultDS : defaultDS.ID;
        return foreignKey.substring(0, dotIndex);
    },
    
    registerDataSource : function (dataSource) {
        //>DEBUG
        if (this.logIsInfoEnabled()) {
            this.logInfo("Registered new isc.DataSource '" + dataSource.ID + "'");
        }
        //<DEBUG
        if (dataSource.ID) {
            var existingDS = this._dataSources[dataSource.ID];
            // overwrite any existing registered DataSource, unless we have a schemaNamespace.
            // This avoids XMLSchema-derived Schema cloberring ordinary DataSources, since
            // XMLSchema-derived DataSources can be looked up via other means
            // (SchemaSet.getSchema())
            if (!existingDS || !dataSource.schemaNamespace) {
                this._dataSources[dataSource.ID] = dataSource;
            }
        }

        
        if (isc.Schema && isc.isA.Schema(dataSource)) {
            if (isc.isAn.XSElement(dataSource)) this._elements[dataSource.ID] = dataSource;
            else if (isc.isAn.XSComplexType(dataSource)) this._types[dataSource.ID] = dataSource;
            return;
        }

        
   
        // link DataSources with foreignKeys to each other as they are loaded
        // -----------------------------------------------------------------------------------
        
        var fields = dataSource.getLocalFields(true);

        var unlinkedChildren = this._unlinkedChildren = (this._unlinkedChildren || {});
 
        // try to satisfy this DS's foreignKey relationships
		for (var fieldName in fields) { 
			var field = fields[fieldName];
            if (field.foreignKey == null) continue;

            var targetDSName = this.getForeignDSName(field, dataSource);
            if (isc.DS.isRegistered(targetDSName)) {
                //this.logWarn("dataSource: " + dataSource.ID + " found parent: " + targetDS.ID);
                // tell the other DataSource that this DS links to it in a 1 to many
                // relationship
                isc.DS.get(targetDSName).addChildDataSource(dataSource);
            } else {
                //this.logWarn("dataSource: " + dataSource.ID + " could not find parent: " +
                //             targetDSName);  
                // add ourselves to the list of future children of targetDS, to be linked up
                // whenever it gets loaded
                if (unlinkedChildren[targetDSName] == null) {
                    unlinkedChildren[targetDSName] = [];
                }
                unlinkedChildren[targetDSName].add(dataSource);
            }
        }

        // see if this new DS satisfies any foreignKey relationships
        var children = unlinkedChildren[dataSource.ID];
        if (children != null) {
            //this.logWarn("dataSource: " + dataSource.ID + " found children: " + children);  
            dataSource.map("addChildDataSource", children);
            unlinkedChildren[dataSource.ID] = null;
        }

        // Link DataSources that declare childRelations to their children
        // ---------------------------------------------------------------------------------
        var unfoundChildren = this._unfoundChildren = this._unfoundChildren || {};
        if (dataSource.childRelations) {
            for (var i = 0; i < dataSource.childRelations.length; i++) {
                var relation = dataSource.childRelations[i],
                    childDSName = relation.dsName,
                    childDS = isc.DS.get(childDSName);
                if (childDS) {
                    //this.logWarn("dataSource: " + dataSource.ID + 
                    //             " found child: " + childDS.ID);
                    this._addChildRelation(dataSource, childDS, relation);
                } else {
                    //this.logWarn("dataSource: " + dataSource.ID + 
                    //             " could not find child: " + childDSName);  
                    if (unfoundChildren[childDSName] == null) {
                        unfoundChildren[childDSName] = [];
                    }
                    relation.parentDS = dataSource.ID;
                    unfoundChildren[childDSName].add(relation);
                }
            }
        }
        // eg User loaded, now Account is loaded
        var relations = unfoundChildren[dataSource.ID];
        if (relations) {
            for (var i = 0; i < relations.length; i++) {
                var relation = relations[i];
                this._addChildRelation(isc.DS.get(relation.parentDS), dataSource, relation);
            }
        }
        
    },

    _addChildRelation : function (parentDS, childDS, relation) {
        parentDS.addChildDataSource(childDS);

        // create foreignKey marker on field
        if (!relation.fieldName) return;

        var field = childDS.getField(relation.fieldName);
        if (!field.foriegnKey) {
            // HACK allows getTreeRelationship to work
            field.foreignKey = parentDS.ID + "." + 
                                    parentDS.getPrimaryKeyFieldNames()[0];
        }
    },

    // Schema and types
    // ---------------------------------------------------------------------------------------
    
    // helper method for getObjectField; returns inheritance distance or -1 on error
    getInheritanceDistance : function (superclass, subclass) {
        // check that the arguments are in fact classes, and confirm their relationship
        var superclassObj = isc.ClassFactory.getClass(superclass),
            subclassObj = isc.ClassFactory.getClass(subclass)
        ;
        if (superclassObj == null || subclassObj == null) {
            this.logWarn("Invalid superclass and/or subclass argument provided");
            return -1;
        }
        if (!subclassObj.isA(superclass)) {
            this.logWarn(subclass + " is not a subclass of " + superclass);
            return -1;
        }
        
        for (var distance = 0; subclassObj != superclassObj; distance++) {
            subclassObj = subclassObj.getSuperClass();
        }
        
        return distance;
    },

    // simple: String, Number, Boolean, Date, Time, Function
    // non-simple: null, Object, Array
    isSimpleTypeValue : function (value) {
        if (value != null && (!isc.isAn.Object(value) || isc.isA.Date(value))) return true;
        return false;
    },

    // Given an object, find the nearest schema to be used to serialize it.
    // If there is a SmartClient Class, but no schema exists (eg custom class), we find the
    // nearest SmartClient super class that has a schema.
    getNearestSchema : function (object) {
        if (object == null) return null;
    
        var className;
        if (isc.isA.String(object)) className = object;
        else {
            className = isc.isAn.Instance(object) ? object.getClassName() : 
                                                    object._constructor || object.type || object.$schemaId;
        }

		var schema = isc.DS.get(className);
		
        // if no schema is loaded for this class, look for a superclass schema
		var theClass = isc.ClassFactory.getClass(className);

        if (theClass != null) {
    		var lastSuperClass = null;
	    	while (schema == null && (theClass = theClass.getSuperClass()) != null && 
                                      theClass != lastSuperClass) 
            {
	    		schema = isc.DS.get(theClass.getClassName());
		    	lastSuperClass = theClass;
    		}
        }
        return schema || isc.DS.get("Object");
    },
    
    // Given a SmartClient component schema name, determine the associated SmartClient class
    
    getNearestSchemaClass : function (schema) {
        if (schema == null) return null;
        var theClass;
        
        while (theClass == null) {
            // Pick up the dataSource for the className passed in.
            // This will allow us to determine the correct SmartClient class for the object
            // by iterating up the datasource parent chain if necessary
            var schema = isc.DS.get(schema);
            
            theClass = isc.ClassFactory.getClass(schema._constructor || schema.Constructor 
                                                                     || schema.type);
            //this.logWarn("schema is: " + schema + ", theClass: " + theClass + 
            //             ", schema.inheritsFrom: " + schema.inheritsFrom);
            
            if (theClass != null) return theClass;
            schema = schema.inheritsFrom;
            
            if (!schema) return null;
        }
        return null;
    },

    // Standard Operations
	// ----------------------------------------------------------------------------------------

    // Centrally handle backcompat synonyms for operation types
    _getStandardOperationType : function (operationType) {
        switch (operationType) {
            case "fetch":
            case "select":
            case "filter":
                return "fetch";
            case "add":
            case "insert":
                return "add";
            case "update": 
                return "update";
            case "remove":
            case "delete":
                return "remove";

            default:
                // cases not covered:
                // "replace": no longer supported, but not equivalent to any supported type
                // "validate": never had a synonym

            return operationType;
        }
    },

	isClientOnly : function (dataSource) {
		if (isc.isA.String(dataSource)) dataSource = this.getDataSource(dataSource);
		if (!dataSource) return false;
		return dataSource.clientOnly;
	},

	// ResultSets creation
	// --------------------------------------------------------------------------------------------
    

    // make a default operation for the specified dataSource, using the specified application.
	// if no application is specified, use the default application.
    makeDefaultOperation : function (dataSourceId, operationType, operationId) 
    {
		// XXX this is really only intended for the standard set of operations (fetch, update,
        // add, remove): check that operationType is valid?
		
		var theApp = isc.rpc.app();

        if (isc.isA.DataSource(dataSourceId)) dataSourceId = dataSourceId.ID;
        if (!dataSourceId) dataSourceId = "auto";

        // NOTE: removed code that added the datasource to the application if it wasn't
        // already there so that it could be looked up when performing the operation;
        // now behaviour is that if no datasources are defined on the app, it will just
        // look for a currently loaded datasource with that name

        // make sure the app has an operations array
        if (theApp.operations == null) theApp.operations = {};

        // create the default operation on this DataSource

        // allow an operationId, otherwise create one based on DS and operation type
        operationId = operationId || dataSourceId + "_" + operationType;
        var operation = theApp.operations[operationId];
        if (operation == null) {
            operation = {ID:operationId,
                         dataSource:dataSourceId,
                         type:operationType, 
                         filterType:"paged",
                         loadDataOnDemand:true,
                         source:"auto"};
            theApp.operations[operationId] = operation;

            
        }

        // return the operation
        return operation;
    },

	// ResultSet cache sync
	// --------------------------------------------------------------------------------------------
    // NOTE: if an operation modifies more than one DataSource, obviously its not going to make
    // sense to pass the same updateData to ResultSets on different DataSources.  We assume you
    // know that you don't have a ResultSet on the second DataSource, or are dropping cache on
    // updates!

    handleUpdate : function (dsResponse, dsRequest) {    
        if (!this.isUpdateOperation(dsRequest.operationType)) return;
        // notify the datasource that the operation affects
        var ds = this.get(dsRequest.dataSource);
        ds.updateCaches(dsResponse, dsRequest);
    },

	// is this an operation which alters data?
	isUpdateOperation : function (operation) {
		if (operation == "add" || operation == "update" || operation == "remove" || 
            operation == "replace"
            //>!BackCompat 2004.7.23 synonyms
            || operation == "delete" || operation == "insert" 
            //<!BackCompat
           ) return true;
	},

    // Helper method for ResultSet / ResultTree. Derives the updated record values from 
    // a successful dsRequest and response.
    getUpdatedData : function (dsRequest, dsResponse, useDataFromRequest) {
        var updateData = dsResponse.data;
        // If the server failed to return the updated records, and updateCacheFromRequest is true,
        // integrate the submitted values into the cache if the operation was succesful.
        if (useDataFromRequest && 
            dsResponse.status == 0 && 
            (updateData == null || 
             (isc.isA.Array(updateData) && updateData.length == 0) || 
             isc.isAn.emptyString(updateData))
           ) 
        {
            this.logInfo("dsResponse for successful operation of type " + dsRequest.operationType + 
                         " did not return updated record[s]. Using submitted request data to update" + 
                         " ResultSet cache.", "ResultSet");
            var requestData = dsRequest.data;
            
            // if operationType is an update, request data will be sparse so need to combine 
            // with oldValues
            if (dsRequest.operationType == "update") {
                updateData = isc.addProperties({}, dsRequest.oldValues);
        
                // Assertion - we only update one record at a time, so if submitted data is an array
                // it will contain one entry that matches the 'oldValues'
                if (isc.isAn.Array(requestData)) {
                    updateData = isc.addProperties(updateData, requestData[0]);  
                } else {
                    updateData = isc.addProperties(updateData, requestData);
                }
                updateData = [updateData];
            // for add or delete old values are irrelevant
            } else {      
                if (!isc.isAn.Array(requestData)) requestData = [requestData];
                updateData = [];
                for (var i = 0; i < requestData.length; i++) {
                    updateData[i] = isc.addProperties({}, requestData[i]);
                }
            }
            //>DEBUG
            if (this.logIsDebugEnabled("ResultSet")) {
                this.logDebug("Submitted data to be integrated into the cache:"
                              + this.echoAll(updateData), "ResultSet");
            }
            //<DEBUG
        }
        return updateData;
    },
    
    // ---------------------------------------------------------------------------------------
    
	// given a set of values from a DynamicForm, return appropriate filter criteria
	filterCriteriaForFormValues : function (formValues) {
		var filterValues = {};
		for (var fieldName in formValues) {
			var formValue = formValues[fieldName];
			// Form fields may have the value "" if they held a value and were cleared out.  A
            // blank field in a form used as a filter means "field can have any value", not
            // "field must be blank", so we eliminate blank field->value pairs.
			// This also goes for a selectList where a blank value is selected, which is
            // supposed to mean "Any".
			if (formValue == null || isc.is.emptyString(formValue)) continue;

			// multi-selects are returned as an array.  
			if (isc.isAn.Array(formValue)) {
                
                // If nothing is selected we get [], meaning no criteria
                if (formValue.length == 0) continue;
			    // If blank is selected, we get ["", "otherValue", ...], meaning "field can
                // have any value".
                
                for (var i = 0; i < formValue.length; i++) {
                    var orValue = formValue[i];
                    if (isc.isAn.emptyString(orValue)) continue;
                }
            }
			
			// use the formValue as is
			filterValues[fieldName] = formValue;

			// NOTE: we do this on the client rather than the server because otherwise the client
			// would be unable to express "field must be blank" - the server would discard the
			// criterion assuming it was an artifact of the filterValues having come from a
			// DynamicForm.
		}
		return filterValues;
	}
    
});


isc.DataSource.addProperties({
    //> @attr dataSource.ID              (string : null : [IR])
	// Unique identifier for this DataSource.  Required for all DataSources.
    //
    // DataSources will make themselves available as JavaScript globals under the same name
    // as their ID only if <code>addGlobalId</code> is set.
    //
    // @group identity
    // @visibility external
    //<

    //> @attr dataSource.addGlobalId    (boolean : true : IRA)
    // Whether to make this DataSource available as a global variable for convenience.
    // @group identity
    // @visibility external
    //<
    addGlobalId:true,

    //> @attr dataSource.dataFormat (DSDataFormat : "iscServer" : [IR])
    // Indicates the format to be used for HTTP requests and responses when
    // fulfilling DSRequests (eg +link{DataSource.fetchData()} is called).
    //
    // @group clientDataIntegration
    // @group serverDataIntegration
    // @visibility external
    // @example jsonDataSource
    // @example simpleJSON
    //<
    dataFormat:"iscServer",
    
    //> @attr dataSource.dataProtocol (DSDataProtocol : null : [IR])
    // Controls the format in which inputs are sent to the dataURL when fulfilling DSRequests.
    // May be overridden for individual request types using
    // +link{OperationBinding.dataProtocol,opration bindings}}
    // @group clientDataIntegration
    // @group serverDataIntegration
    // @visibility external
    //<
    
    //> @attr dataSource.callbackParam (String : "callback" : [IR])
    // Applies only to dataFormat: "json".  Specifies the name of the query parameter that
    // tells your JSON service what function to call as part of the response.
    //
    // @see dataSource.dataFormat
    // @see dataSource.operationBindings
    // @see operationBinding.callbackParam
    // @group clientDataIntegration
    // @visibility external
    // @example xmlEditSave
    //<
    callbackParam : "callback",

    //> @attr dataSource.requestProperties (DSRequest Properties : null : [IR])
    // Additional properties to pass through to the +link{DSRequest}s made by this
    // DataSource.
    // <p>
    // These properties are applied before +link{dataSource.transformRequest} is called.
    //
    // @see DSRequest
    // @see operationBinding.requestProperties
    // @group clientDataIntegration
    // @group serverDataIntegration
    // @visibility external
    //<

    //> @attr dataSource.dataTransport      (RPCTransport : RPCManager.defaultTransport : [IR])
    // Transport to use for all operations on this DataSource. Defaults to
    // +link{RPCManager.defaultTransport}.  This would typically only be set to
    // enable "scriptInclude" transport for contacting +link{DataSource.dataFormat,JSON} web
    // services hosted on servers other than the origin server.
    // <p>
    // When using the "scriptInclude" transport, be sure to set +link{dataSource.callbackParam} or
    // +link{operationBinding.callbackParam} to match the name of the query parameter name expected
    // by your JSON service provider.
    //
    // @see RPCTransport
    // @see dataSource.callbackParam
    // @group clientDataIntegration
    // @visibility xmlBinding
    //<

    //> @type DSDataFormat
    // Indicates the format to be used for HTTP requests and responses when
    // fulfilling DSRequests (eg +link{DataSource.fetchData()} is called).
    // <P>
    // Note that +link{RPCManager.startQueue(),request queuing} is only available for
    // "iscServer" requests.
    //
    // @value "iscServer"
    // Make an HTTP request in a format recognized by the ISC server and expect ISC server
    // response format.  +link{group:serverDataIntegration,Server-side integration} can then be
    // used to connect to any kind of data store or web service.
    //
    // @value "xml"
    // Expect XML responses.  Request format depends on the setting for
    // +link{operationBinding.dataProtocol,protocol}.  This is the correct setting when
    // consuming RSS feeds, XML web services (whether SOAP, REST, XML-RPC or custom format),
    // and XML flat files directly from the browser.
    // <P>
    // A DSResponse will be derived from the returned XML via the process described under
    // +link{dataSource.transformResponse()}.
    //
    // @value "json"
    // Expect response in JSON +externalLink{http://json.org,(Java Script Object Notation)}
    // format, ready to be eval()'d. Response should either be a naked object literal:<br>
    // <code>&nbsp;&nbsp;&nbsp;&nbsp;{ "property":"value1", "property2" : "value2", ... }</code><br>
    // or a string that evals to return a valid response object:<br>
    // <code>&nbsp;&nbsp;&nbsp;&nbsp;var response = { "property":"value1", "property2" : "value2", ... }</code>
    // <br>
    // <code>&nbsp;&nbsp;&nbsp;&nbsp;response;</code><br>
    // <P>
    // A DSResponse will be derived from the returned JSON via the process described under
    // +link{dataSource.transformResponse()}.
    // <P>
    // Request format depends on the setting for +link{operationBinding.dataProtocol,protocol}.  
    // See also +link{XJSONDataSource}.
    //
    // @value "custom"
    // SmartClient will not attempt to parse the response, instead,
    // +link{dataSource.transformResponse()} must be implemented.
    // <code>transformResponse</code> will receive the "data" parameter as a String, and must
    // parse this String into an Array of Objects, which should be set as
    // +link{dsResponse.data}.  Request format depends on the setting for
    // +link{operationBinding.dataProtocol,protocol}.
    // <P>
    // Note that, unlike either the "json" or "xml" settings of <code>dataFormat</code>, you
    // are responsible for ensuring that parsed values are the correct type, for example, using
    // the JavaScript built-ins <code>parseInt</code> and <code>parseFloat</code> on integer
    // and decimal values respectively, and using <code>new Date()</code> to construct valid
    // Dates.
    //
    // @group clientDataIntegration
    // @group serverDataIntegration
    // @visibility external
    // @example simpleJSON
    //<

    //> @attr dataSource.serverType (DSServerType : "generic" : [IR])
    // For a DataSource stored in .xml format on the ISC server, indicates what server-side
    // connector to use to execute requests, that is, what happens if you call
    // dsRequest.execute() in server code.
    // 
    // @group serverDataIntegration
    // @requiresModules SCServer
    // @visibility external
    //<
    
    //> @type DSServerType
    // Indicates what the ISC server will do with a DataSource request if you call
    // dsRequest.execute() in server code.
    // <P>
    // If you use a Java-based persistence layer not provided by SmartClient, such as
    // Hibernate, EJB or your own custom object model, you don't need to set
    // <code>dataSource.serverType</code> and should follow the
    // +link{group:serverDataIntegration,integration instructions}.
    // <P>
    // If you want to use the SmartClient SQL engine for persistence, set
    // <code>dataSource.serverType</code> to "sql", and see the instructions on
    // +link{group:sqlDataSource}.
    // 
    // @value "hibernate"
    // Saves via Hibernate, by automatically generating a Hibernate configuration based on a
    // SmartClient DataSource file (<i>dataSourceID</i>.ds.xml).  See
    // +link{group:hibernateIntegration} for details.
    //
    // @value "sql"
    // Uses SmartClient's +link{group:sqlDataSource,built-in SQL connectors} to talk to
    // relational databases.  You can use this if your DataSource connects to a relational
    // database table.
    //
    // @value "generic"
    // Requests will be delivered to the server and you are expected to write Java code to
    // create a valid response.  Throws an error if the server side method dsRequest.execute()
    // is called. This is appropriate if you intend an entirely custom implementation, and you
    // want an error thrown if there is an attempt to call an operation you have not
    // implemented.
    //
    // @group serverDataIntegration
    // @visibility external
    //<

    //> @attr dataSource.tableName (String : null : [IR])
    // For DataSources using the +link{group:sqlDataSource,SmartClient SQL engine} for
    // persistence, what database table name to use.  The default is to use the DataSource ID
    // as the table name.
    // 
    // @group serverDataIntegration
    // @requiresModules SCServer
    // @visibility external
    //<

    //> @attr dataSource.dbName (String : null : [IR])
    // For DataSources using the +link{group:sqlDataSource,SmartClient SQL engine} for
    // persistence, which database configuration to use.  Database configurations can be
    // created using the "Databases" tab in the Developer Console.  If unset, the default
    // database configuration is used (which also settable using the "Databases" tab).
    // 
    // @group serverDataIntegration
    // @requiresModules SCServer
    // @visibility external
    //<
    
    //> @attr dataSource.jsonPrefix (String : null : [IRA])
    // Allows you to specify an arbitrary prefix string to apply to all json format responses 
    // sent from the server to this application.<br>
    // The inclusion of such a prefix ensures your code is not directly executable outside of
    // your application, as a preventitive measure against
    // +externalLink{http://www.google.com/search?q=javascript+hijacking, javascript hijacking}.
    // <br>
    // Only applies to responses formatted as json objects. Does not apply to responses returned
    // via scriptInclude type transport.<br>
    // Note: If the prefix / suffix served by your backend is not a constant, you can use 
    // +link{operationBinding.dataFormat, dataFormat:"custom"} instead and explicitly parse
    // the prefix out as part of +link{dataSource.transformResponse(), transformResponse()}.
    //
    // @see operationBinding.dataFormat
    // @see operationBinding.dataTransport
    // @visibility external
    //<
    
    //> @attr dataSource.jsonSuffix (String : null : [IRA])
    // Allows you to specify an arbitrary suffix string to apply to all json format responses 
    // sent from the server to this application.<br>
    // The inclusion of such a suffix ensures your code is not directly executable outside of
    // your application, as a preventitive measure against
    // +externalLink{http://www.google.com/search?q=javascript+hijacking, javascript hijacking}.
    // <br>
    // Only applies to responses formatted as json objects. Does not apply to responses returned
    // via scriptInclude type transport.
    //
    // @see operationBinding.dataFormat
    // @see operationBinding.dataTransport
    // @visibility external
    //<

    //> @attr dataSource.fields         (Array of DataSourceField : null : [IR])
    // The list of fields that compose records from this DataSource.
    // <P>
    // Each DataSource field can have type, user-visible title, validators, and other metadata
    // attached.
    //
    // @group fields
    // @see class:DataSourceField
    // @visibility external
    //<

    //> @attr dataSource.inheritsFrom (DataSource ID : null : IR)
    // ID of another DataSource this DataSource inherits its +link{fields} from.
    // <P>
    // Local fields (fields defined in this DataSource) are added to inherited fields 
    // to form the full set of fields.  Fields with the same name are merged in the same way
    // that +link{DataBoundComponent.fields,databound component fields} are merged with
    // DataSource fields.
    // <P>
    // The default order of the combined fields is new local fields first (including any fields
    // present in the parent DataSource which the local DataSource re-declares), then parent
    // fields.  You can set +link{useParentFieldOrder} to instead use the parent's field
    // order, with new local fields appearing last.  You can set +link{showLocalFieldsOnly} to
    // have all non-local fields hidden.
    // <P>
    // Note that <b>only fields are inherited</b> - other properties such as dataURL and
    // dataFormat are not.  You can use ordinary inheritance, that is, creating a subclass of
    // DataSource, in order to share properties such as dataURL across a series of DataSources
    // that also inherit fields from each other via <code>inheritsFrom</code>.
    // <P>
    // This feature can be used for:
    // <ul>
    // <li>creating a customized view (eg, only certain fields shown) which will be used by
    // multiple +link{DataBoundComponent,databound components}.
    // <li>adding presentation-specific attributes to metadata that has been automatically
    // derived from +link{XMLTools.loadXMLSchema,XML Schema} or other metadata formats
    // <li>modelling object subclassing and extension in server-side code and storage systems
    // <li>modelling relational database joins, and the equivalents in other systems
    // <li>creating hooks for others to customize your application in a maintainable way.  For
    // example, if you have a dataSource "employee", you can create a dataSource
    // "customizedEmployee" which inherits from "employee" but does not initially define any
    // fields, and bind all +link{DataBoundComponent,databound components} to
    // "customizedEmployee".  Customizations of fields (including appearance changes, field
    // order, new fields, hiding of fields, and custom validation rules) can be added to
    // "customizedEmployee", so that they are kept separtely from the original field data and
    // have the best possible chance of working with future versions of the "employee"
    // dataSource.
    // </ul>
    //
    // @group fields
    // @visibility external
    // @example schemaChaining
    //<

    //> @attr dataSource.useFlatFields (boolean : null : IR)
    // Like +link{dataBoundComponent.useFlatFields}, but applies to all DataBound components
    // that bind to this DataSource.
    //
    // @group fields
    // @visibility external
    //<

    //> @attr dataSource.showLocalFieldsOnly (boolean : null : IR)
    // For a DataSource that inherits +link{fields} from another DataSource 
    // (via +link{inheritsFrom}), indicates that only the fields listed in this DataSource
    // should be shown.  All other inherited parent fields will be marked "hidden:true".
    //
    // @group fields
    // @visibility external
    //<

    //> @attr dataSource.useParentFieldOrder (boolean : null : IR)
    // For a DataSource that inherits +link{fields} from another DataSource 
    // (via +link{inheritsFrom}), indicates that the parent's field order should be used
    // instead of the order of the fields as declared in this DataSource.  New fields, if any,
    // are placed at the end.
    // 
    // @group fields
    // @visibility external
    // @example schemaChaining
    //<

    //> @attr dataSource.dropExtraFields     (boolean : null : IR)
    // Indicates that for any data being interpreted as DataSource records, only data that
    // corresponds to declared fields should be retained; any extra data should be discarded.
    // <P>
    // For +link{DataSource.dataFormat,JSON} data, this means extra properties in selected
    // objects are dropped.
    // <P>
    // By default, for DMI DSResponses, DSResponse.data is filtered on the server to just
    // the set of fields defined on the DataSource.  This type of filtering can also be enabled
    // for non-DMI DSResponses (see the overview in +link{DMI}).  Setting this property to
    // <code>false</code> disables this filtering for this DataSource only.  This setting
    // overrides the configuration in <code>server.properties</code>.  This setting can
    // be overridden by +link{ServerObject.dropExtraFields}.
    // 
    // @group clientDataIntegration
    // @visibility external
    //<

    //> @attr dataSource.autoDeriveSchema (boolean : null : IR)
    // For a DataSource with serverType: "sql" or serverType: "hibernate", automatically derive
    // the dataSource's schema (field definitions) from from the SQL table specified in 
    // +link{tableName}.  This causes SmartClient to create a "super" DataSource, which
    // this dataSource then automatically +link{inheritsFrom,inheritsFrom}.  This allows you to 
    // override auto-derived schema as required.
    // <p>
    // This property is only applicable if you are using the SmartClient server.
    //
    // @group fields
    // @visibility external
    //<

    // XML
    // ---------------------------------------------------------------------------------------
    
    //> @attr dataSource.serviceNamespace (URN : null : IR)
    // For an XML DataSource, URN of the WebService to use to invoke operations.  This URN
    // comes from the "targetNamespace" attribute of the &lt;wsdl:definitions&gt; element in a
    // WSDL (Web Service Description Language) document, and serves as the unique identifier of
    // the service.
    // <P>
    // Having loaded a WebService using +link{XMLTools.loadWSDL()}, setting
    // <code>serviceNamespace</code> combined with specifying 
    // +link{class:OperationBinding,operationBindings}
    // that set +link{attr:operationBinding.wsOperation} will cause a DataSource to invoke web
    // service operations to fulfill DataSource requests (+link{class:DSRequest,DSRequests}).
    // <P>
    // Setting <code>serviceNamespace</code> also defaults
    // +link{DataSource.dataURL,dataURL} to the service's location,
    // +link{DataSource.dataFormat,dataFormat} to "xml" and
    // +link{operationBinding.dataProtocol,dataProtocol} to "soap".
    //
    // @group wsdlBinding
    // @group clientDataIntegration
    // @visibility xmlBinding
    // @example wsdlBinding
    //<

    //> @attr dataSource.schemaNamespace (URN : null : R)
    // For a DataSource derived from WSDL or XML schema, the XML namespace this schema belongs
    // to.  This is a read-only attribute automatically present on DataSources returned from
    // +link{schemaSet.getSchema()} and +link{webService.getSchema()}.
    //
    // @group wsdlBinding
    // @group clientDataIntegration
    // @visibility xmlBinding
    //<

    //> @attr dataSource.recordXPath          (XPathExpression : null : [IR])
    // See +link{attr:operationBinding.recordXPath}.  <code>recordXPath</code> can be specified
    // directly on the DataSource for a simple read-only DataSource only capable of "fetch"
    // operations.
    //
    // @group clientDataIntegration
    // @visibility xmlBinding
    // @example xmlDataSource
    // @example jsonXPath
    //<

    //> @attr dataSource.dataURL              (URL : null : [IR])
    // Default URL to contact to fulfill all DSRequests.  Can also be set on a
    // per-operationType basis via +link{attr:operationBinding.dataURL}.
    // <P>
    // NOTE: Best practice is to use the same <code>dataURL</code> for all DataSources which
    // fulfill DSRequests via the server-side RPCManager API.  Otherwise, cross-DataSource
    // +link{RPCManager.startQueue(),operation queueing} will not be possible.
    //
    // @group clientDataIntegration
    // @visibility xmlBinding
    // @example jsonDataSource
    //<

    //> @attr dataSource.tagName             (String : null : IRA)
    // Tag name to use when serializing to XML.  If unspecified, the <code>dataSource.ID</code>
    // will be used.
    // @group clientDataIntegration
    // @visibility xmlBinding
    //<


// whether to transform XML responses to JS automatically, such that the client-side DSResponse
// is a JS object (whether the transform was performed on client or server is intended to be an
// implementation detail).
// At the moment 2005.7.5, some components can work directly with XML objects (eg read-only,
// selectable ListGrid), some can't.  Server XML->JS transform will always speed up the client.
// Aside from features that don't yet work with XML object, client XML->JS transform is a
// tradeoff between initial load vs later access time.
transformResponseToJS:true,

// whether this DataSource can queue requests to be submitted as a batch
supportsRequestQueuing : true,

    // Client Only DataSources
	// ----------------------------------------------------------------------------------------
    //> @attr dataSource.clientOnly     (boolean : false : [IR])
    // Whether to ask as a "client-only" DataSource, which has no permanent storage and never
    // contacts the server, instead using a set of test data to respond to requests in the same
    // manner as a server-based DataSource might.
    // <P>
    // See +link{group:clientOnlyDataSources,this discussion} for ways to populate a
    // client-only DataSource with test data.
    //
    // @group clientOnlyDataSources
    // @visibility external
    // @example localDataSource
    //<
	//clientOnly: false,

    //> @attr dataSource.testData       (Array of Object : null : IRW)
    // For a client-only DataSource, a set of records to use as a dataset, specified as an
    // Array of JavaScript Objects.
    // <P>
    // See +link{group:clientOnlyDataSources,this discussion} for ways to populate a
    // client-only DataSource with test data.
    //
    // @see clientOnly
    // @group clientOnlyDataSources
    // @visibility external
    // @example localDataSource
    //<
	//testData: null

    // in clientOnly mode, whether to shallow copy results to more fully simulate a server.
    // This allows separate changes to be made to the "server data set" (testData) and
    // ResultSet caches.
    copyLocalResults:true,

    // Filtering
	// ----------------------------------------------------------------------------------------
	// whether to match case in filter    
	//filterIsCaseSensitive : false,		

    //> @attr dataSource.criteriaPolicy (CriteriaPolicy : "dropOnShortening" : IRWA)
    // Decides under what conditions the +link{ResultSet} cache should be dropped when the
    // +link{resultSet.criteria} changes
    // @see compareCriteria()
    // @visibility external
    //<
    criteriaPolicy:"dropOnShortening",

    // ResultTrees
	// ----------------------------------------------------------------------------------------
    //> @attr dataSource.resultTreeClass (Class Object : null : [IRA])
    // Class for ResultTrees used by this datasource.  If null, defaults to using
    // +link{ResultTree}.
    // <P>
    // This can be set to a custom subclass of ResultTree that, for example, hangs onto to extra
    // information necessary for integration with web services.
    //
    //  @visibility external
    //<

    // ResultSets
	// ----------------------------------------------------------------------------------------
    //> @attr dataSource.resultSetClass (Class Object : null : [IRA])
    // Class for ResultSets used by this datasource.  If null, defaults to using
    // +link{ResultSet}.
    // <P>
    // This can be set to a custom subclass of ResultSet that, for example, hangs onto to extra
    // information necessary for integration with web services.
    //
    // @visibility external
    //<
    
    // Validation
	// ----------------------------------------------------------------------------------------
    //> @attr dataSource.useLocalValidators (boolean : false : [A])
    // Whether to attempt validation on the client at all for this DataSource.
    // <p>
    // Disabling client-side validation entirely is a good way to test server-side validation.
    // @group validation
    // @visibility external
    //<

    // ShowPrompt
	// ----------------------------------------------------------------------------------------
    //> @attr dataSource.showPrompt (boolean : true : [A])
    // Whether RPCRequests sent by this DataSource should enable 
    // +link{attr:RPCRequest.showPrompt} if it's unset.
    // @visibility external
    //<
    showPrompt:true,

    // Selection
	// ----------------------------------------------------------------------------------------
    //> @attr dataSource.selectionClass (className : null : [A])
    // Class to use as the Selection object for ResultSets derived from this DataSource.
    // @visibility serverSelection
    //<
    

    // Java enum translation
	// ----------------------------------------------------------------------------------------
    //> @type EnumTranslateStrategy
    // Determines how Java enums are translated to and from Javascript by the SmartClient server.
    //
    // @value "string"
    //   Translates to/from a String matching the constant name. This is the default if not set.
    // @value "ordinal"
    //   Translates to/from an integer matching the ordinal number of the constant within 
    //   the enumeration
    // @value "bean"
    //   Translates to/from a Javascript object containing one property for each property defined 
    //   within the enum. The constant itself and the ordinal number are included in the JS object.
    //   By default they are called "_constant" and "_ordinal", but this can be overridden with 
    //   the +link{dataSource.enumOrdinalProperty} and +link{dataSource.enumConstantProperty}
    //   properties
    //
    // @see dataSource.enumTranslateStrategy
    // @visibility external
    //<
    
    
    //> @attr dataSource.enumTranslateStrategy (EnumTranslateStrategy : null : IA)
    //
    // Sets the strategy this DataSource uses to translate Java enumerated types (objects of type
    // enum) to and from Javascript.
    // 
    // This property is only applicable if you are using the SmartClient server
    // @visibility external
    //<

    //> @attr dataSource.enumConstantProperty (String : null : IA)
    //
    // The name of the property this DataSource uses for constant name when translating
    // Java enumerated types to and from Javascript, if the +link{enumTranslateStrategy} is set
    // to "bean".  Defaults to "_constant" if not set.
    // <p>
    //  This property is only applicable if you are using the SmartClient server
    // @visibility external
    //<

    //> @attr dataSource.enumOrdinalProperty (String : null : IA)
    //
    // The name of the property this DataSource uses for ordinal number when translating
    // Java enumerated types to and from Javascript, if the +link{enumTranslateStrategy} is set
    // to "bean".  Defaults to "_ordinal" if not set.
    // <p>
    //  This property is only applicable if you are using the SmartClient server
    // @visibility external
    //<

    //> @attr dataSource.autoDeriveTitles (boolean : true : IR)
    // If set, titles are automatically derived from +link{dataSourceField.name,field.name} for any 
    // field that does not have a +link{dataSourceField.title,field.title} and is not marked
    // +link{dataSourceField.hidden,hidden}:true. 
    // <P>
    // The following approach is taken:
    // <ul>
    // <li> any underscores (_) become spaces, except a leading underscore
    // <li> if the fieldName is either entirely uppercase or lowercase, all words separate by
    //      spaces are given a leading capital letter.  Example USER_NAME -> "User Name".
    // <li> if there is any use of mixed case, camelCaps convention is assumed, and the field name
    //      is split into separate words based on 1) everywhere an uppercase letter appears after a
    //      lowercase letter 2) everywhere a series of uppercase letters ends.  Letter case will
    //      not be modified, with the exception that the first word will have it's first letter 
    //      capitalized.  Example: useHTTPProxy -> "Use HTTP Proxy"
    // </ul>
    // @visibility external
    //<
    autoDeriveTitles: true
});

//> @type ValueMap
// A ValueMap defines the set of legal values for a field, and optionally allows you to provide
// a mapping from stored values to values as seen by the end user.
// <P>
// A valueMap can be specified as either an Array of legal values, or as an +link{type:Object}
// where each property maps a stored value to a user-displayable value.  See
// +link{DataSourceField.valueMap} for how to express a ValueMap in
// +link{group:componentXML,Component XML}.
// <P>
// A ValueMap can be entirely static or entirely dynamic, with many options in between.  For
// example, a ValueMap may be:
// <ul>
// <li> staticly defined in a JavaScript or XML file.  Such a valueMap changes only when
// application code is upgraded.
// <li> generated dynamically by server code when the application first loads, for example,
// by generating JavaScript or XML dynamically in a .jsp or .asp file.  Such a valueMap may be
// different for each session and for each user.
// <li> loaded on demand from a DataSource, via the
// +link{PickList.optionDataSource,optionDataSource} property, or via a call to
// +link{dataSource.fetchData()} where a valueMap is derived dynamically from the returned data
// (see +link{dataSource.fetchData()} for an example).  Such a valueMap may be updated at any
// time, for example, every time the user changes a related field while editing data.
// </ul>
// See also the +link{group:smartArchitecture,SmartClient Architecture Overview} to understand
// the best architecture from a performance and caching perspective.
// @visibility external
//<

//> @class DataSourceField
// Metadata about a DataSourceField, including its type and validators.
// @treeLocation Client Reference/Data Binding/DataSource
// @visibility external
//<

//> @groupDef basics
// Basic definition of a DataSource field
// @visibility external
//<

//> @attr dataSourceField.name                 (String : null : [IR])
// Name for this field.  
// <p>
// The field name is also the property in each DataSource record which holds the value for this
// field.
// <P>
// Must be unique across all fields within the DataSource.
// @group basics
// @visibility external
//<

//> @attr dataSourceField.type                 (FieldType : null : [IR])
// Type of this field.  Required for all DataSource fields.
// <P>
// Field type may imply automatic validators (for example, an integer field cannot accept the
// value "foo").  Field type also affects the default behaviors of DataBound components, for
// example, if a field is declared of type "date", components that edit that field will
// automatically choose a date-editing interface with pop-up date picker.
// @group basics
// @visibility external
//<

// Validation
// --------------------------------------------------------------------------------------------

//> @attr dataSourceField.required             (boolean : false : [IR])
// Indicates this field must be non-null in order for a record to pass validation.
// <P>
// Note that <code>required</code> should not be set for a server-generated field, such as a
// sequence, or validation will fail on the client.
// @group dataType
// @visibility external
//<

//> @attr dataSourceField.valueMap             (ValueMap : null : [IR])
// A +link{type:ValueMap} is a set of legal values for a field.
// <p>
// The valueMap can be specified as either an Array of legal values, or as an
// +link{type:Object} where each property maps a stored value to a user-displayable value.
// <p>
// To enforce that a field should be constrained to only the values in the valueMap, either
// declare +link{dataSourceField.type,field.type} as "enum", or use an
// +link{ValidatorTypes.isOneOf,isOneOf validator} with explicitly listed values.  Otherwise,
// although a normal +link{SelectItem} control will only allow values from the valueMap to be
// entered, other controls such as a +link{ComboBoxItem,ComboBox} will allow other values 
// to be entered.
// <p>
// In XML, a valueMap that specifies only a list of legal values is specified as follows:
// <pre>
//   &lt;valueMap&gt;
//   	&lt;value&gt;Pens &amp; Pencils&lt;/value&gt;
//   	&lt;value&gt;Stationery&lt;/value&gt;
//   	&lt;value&gt;Computer Products&lt;/value&gt;
//   	&lt;value&gt;Furniture&lt;/value&gt;
//   	&lt;value&gt;Misc&lt;/value&gt;
//   &lt;/valueMap&gt;
// </pre>
// A ValueMap that specifies stored values mapped to user-visible values is specified as
// follows:
// <pre>
//   &lt;valueMap&gt;
//   	&lt;value ID="1"&gt;Pens &amp; Pencils&lt;/value&gt;
//   	&lt;value ID="2"&gt;Stationery&lt;/value&gt;
//   	&lt;value ID="3"&gt;Computer Products&lt;/value&gt;
//   	&lt;value ID="4"&gt;Furniture&lt;/value&gt;
//   	&lt;value ID="5"&gt;Misc&lt;/value&gt;
//   &lt;/valueMap&gt;
// </pre>
// 
// @group dataType
// @visibility external
//<

//> @attr dataSourceField.validators           (Array of Validator : null : [IR])
// Validators to be applied to this field.
// <p>
// Validators are applied whenever there is an attempt to save changes to a field.
// <p>
// For the available set of built-in validators, and how to define a custom validator, see the
// +link{class:Validator} class.
//
// @see class:Validator
// @group dataType
// @group validation
// @visibility external
//<

//> @attr dataSourceField.length               (number : null : [IR])
// Maximum number of characters allowed.  Applicable only to fields of text type.
// @group dataType
// @visibility external
// @example longText
//<

// XML
// ---------------------------------------------------------------------------------------

//> @attr dataSourceField.valueXPath      (XPathExpression : null : [IR])
// XPath expression used to retrieve the field's value.
// <P>
// This XPath expression will be evaluated in the scope of the record objects selected by 
// the +link{dataSource.recordXPath}.  For XML data 
// (+link{DataSource.dataFormat,dataFormat:"xml"}) this means a call to
// +link{XMLTools.selectString()} passing the selected XML element.  For JSON data
// (+link{DataSource.dataFormat,dataFormat:"json"}), this means a call to 
// +link{XMLTools.selectObjects()} passing the selected JSON object.
// <P>
// In the absence of a <code>valueXPath</code>, for JSON data the value for the field will
// be the value of the same-named property in the selected object.  
// <P>
// For XML data, the value will be the attribute or subelement named after the field name
// For example, for a field "author" on a record element &lt;book&gt;, the following structures
// require no valueXPath:
// <pre>
//    &lt;book author="Mark Jones"/&gt;
//
//    &lt;book&gt;
//        &lt;author&gt;Mark Jones&lt;/author&gt;
//    &lt;/book&gt;
// </pre>
// <p>
// To learn about XPath, try the following search:
// <a href="http://www.google.com/search?q=xpath+tutorial" target="_blank"
// >http://www.google.com/search?q=xpath+tutorial</a>
// <P>
// <B>Using valueXPath with the SmartClient server</B>
// <p>
// If you're using the SmartClient server to return data via the DSResponse object (or
// indirectly doing so using DataSource DMI), the valueXPath you specify on the DataSource
// fields will be applied to the data you return via the 
// +externalLink{http://jakarta.apache.org/commons/jxpath/,JXPath} library.
// <P>
// If you are returning Java Beans as your DSResponse data, normally each dataSource field
// receives the value of the same named Java Bean property, that is, a field "zipCode" is
// populated by looking for "getZipCode()" on the objects passed as DSResponse data.  You can
// use <code>valueXPath</code> to retrieve properties from subobjects, so long as a chain of
// getter methods exists that corresponds to the valueXPath.  For example, a valueXPath of
// "address/zipCode" expects to call "getAddress()" on the bean(s) passed to
// DSResponse.setData(), followed by "getZipCode()" on whatever object "getAddress()" returns.
// <P>
// When you are saving data, the inbound DSRequest values, available as a Java Map, will use 
// just dataSource field names as Map keys, not the valueXPath used to derive them.  However,
// to achieve bidirectional valueXPath binding, you can use the server-side method
// dataSource.setProperties() to use the valueXPath when setting properties on your server
// object model.  When applied as a setter, an XPath like "address/zipCode" attempts
// "getAddress()" followed by "setZipCode()" on the returned object.  JXPath also has some
// ability to auto-create intervening objects if they are missing, such as auto-creating an
// "address" subobject when applying "address/zipCode" as a valueXPath.
// <P>
// See the
// +externalLink{http://jakarta.apache.org/commons/jxpath/,JXPath} library documentation for
// complete details, including other types of server object models supported, such as
// server-side XML.
//
// @see DataSource.setProperties() (Java API)
// @see DSResponse.setData() (Java API)
// @group clientDataIntegration
// @visibility xmlBinding
// @example xpathBinding
//<

//> @method dataSourceField.getFieldValue() [A]
// Function or JavaScript expression used to retrieve the field's value from the XML element or
// JSON record returned from a web service.
// <P>
// This is an advanced API for use when a +link{dataSourceField.valueXPath,valueXPath} setting
// is insufficient to derive a field's value, yet an implementation of
// +link{DataSource.transformResponse()} is overkill.
//
// @param record (Object or XMLElement) record object selected from web service response data
//                                      by +link{operationBinding.recordXPath,recordXPath}
// @param value (any) default value derived by the method described in
//                    +link{dataSourceField.valueXPath}
// @param field (DataSourceField) DataSourceField definition
// @param fieldName (String) name of the DataSource field
//
// @group clientDataIntegration
// @visibility xmlBinding
//<

// Component Binding
// --------------------------------------------------------------------------------------------

//> @groupDef componentBinding
// Properties that control how a DataBound Component binds to this DataSource
// @title Component Binding
// @visibility external
//< 

//> @attr dataSourceField.title                (String : null : [IR])
// Default user-visible title for this field.
// <p>
// This will be picked up by DataBound components and other views onto this DataSource.
// @group componentBinding
// @visibility external
//<

//> @attr dataSourceField.canEdit              (boolean : null : [IR])
// Whether this field can ever be edited by the user.  If set to <code>false</code>, no
// DataBound component will ever try to offer an editing interface for this field.
// @group componentBinding
// @visibility external
//<

//> @attr dataSourceField.editorType           (FormItem className : null : [IR])
// Sets the default FormItem to be used whenever this field is edited (whether in a grid, form,
// or other component).
// <P>
// If unset, a FormItem will be automatically chosen based on the type of the field, by the
// rules explained +link{type:FormItemType,here}.
// 
// @group componentBinding
// @visibility external
//<

//> @attr dataSourceField.hidden (boolean : false : [IR])
// Whether this field should be hidden from users by default within a DataBound component.
// This is generally used for internal ids and other values not meaningful to users.
// <P>
// See +link{dataSourceField.detail} for fields that should be hidden in a summary view such as
// a +link{ListGrid}, but still available to the user.
// 
// @group componentBinding
// @visibility external
//<

//> @attr dataSourceField.ignore (boolean : false : [IR])
// Whether this field should be completely excluded from this dataSource, as if it had never been
// defined.
// 
// @group componentBinding
// @visibility external
//<

//> @attr dataSourceField.detail (boolean : false : [IR])
// Whether this field should be considered a "detail" by a +link{DataBoundComponent}.
// <P>
// Detail fields won't be shown by default in a DataBoundComponent where 
// +link{DataBoundComponent.showDetailFields} is false.  This allows for some DataBound
// components, like a +link{ListGrid}, to show a summary view of records which displays only 
// the most commonly viewed fields by default, while other DataBoundComponents, like a
// +link{DetailViewer}, show all fields by default.
// <P>
// In addition, the +link{field.showIf,formItem.showIf} property is supported in multiple
// components for conditional visibility - see for example +link{listGridField.showIf} and
// +link{formItem.showIf}).
//
// @group componentBinding
// @visibility external
//<

// Relations
// --------------------------------------------------------------------------------------------

//> @groupDef dataSourceRelations
// Properties for declaring relations between DataSource and within DataSources, such as
// master-detail relationship (a SalesOrder contains 0 or more OrderItems) and tree
// relationships (records can be linked by a parentId field).
//
// @see DataSourceField.foreignKey
// @title Relations
// @visibility external
//<

//> @attr dataSourceField.primaryKey           (boolean : false : [IR])
// Whether this field holds a value unique across all records in this DataSource.
// <p>
// A DataSource that can <i>only</i> perform the "fetch" operation does not require a
// primaryKey.  If a DataSource allows modification of DataSource records through add, update
// and remove DataSource operations, exactly one field must be marked as the primary key.
// <P>
// SmartClient requires a primary key value to uniquely identify records when communicating
// updates or deletions to the server.  There is no requirement that the primaryKey field be
// mapped to an actual "primary key" in your object model, web service, or database.  The only
// requirement is that values of the primaryKey field be unique for a given browser instance
// for the lifetime of the page.  
// <P>
// If your underlying data model has no primaryKey or has multiple primaryKey(s), you can
// generate unique values or combine multiple values into a single field that serves as a
// unique key, and declare that field as the single primary key instead.  For example, if your
// underlying data model has two primary keys "firstName" and "lastName", you can use
// +link{DataSource.transformResponse()} to combine them to into a new field "name_key":
// <pre>
// isc.DataSource.create({
//    fields:[
//        {name:"name_key", primaryKey:true},
//        {name:"firstName"},
//        {name:"lastName"},
//        ... other fields ...
//    ],
//    transformResponse : function (dsResponse) {
//        var data = dsResponse.data;
//        for (var i = 0 ; i &lt; data.length; i++) {
//            data[i].name_key = data[i].firstName + ":" +
//                               data[i].lastName;
//        }
//    }
// });
// </pre>
// <P>
// Here it is assumed that ":" is not a legal character in either the firstName or lastName
// field.  Updates to records from this DataSource will then be sent with name_key as the
// primary key value, and the server can split the value to obtain the separate key values.
// <P>
// If using ISC's +link{group:sqlDataSource,SQL engine} and generating SQL tables using the
// "DataBases" tab of the Developer Console, the table column generated from a primaryKey field
// will have a unique constraint applied in the database table.  
//
// @group dataSourceRelations
// @visibility external
//<

//> @attr dataSourceField.foreignKey           (String : false : [IR])
// Declares that this field holds values that can be matched to values from another DataSource
// field, to create a relationship between records from different DataSources or even records
// within the same DataSource.
// <p>
// The format of <code>foreignKey</code> is
// <code>&lt;dataSourceId&gt;.&lt;fieldName&gt;</code>.<br>
// For a foreignKey within the same dataSource, you can omit the <code>dataSourceId</code>
// and just specify <code>&lt;fieldName&gt;</code>.<br>
// For example, to create a tree relationship within a DataSource:
// <pre>
//   DataSource.create({
//     ID:"supplyItem",
//     fields : [
//       {name:"itemId", type:"sequence", primaryKey:true},
//       {name:"parentId", type:"integer", foreignKey:"itemId"},
//       ...
//     ]
//   });
// </pre>
// <P>
// <code>foreignKey</code> declarations also allow other automatic behaviors by
// +link{DataBoundComponent,DataBoundComponents}, such as +link{listGrid.fetchRelatedData()}.
//
// @group dataSourceRelations
// @visibility external
//<

//> @attr dataSourceField.childrenProperty (boolean : false : [IR])
// If true, this property indicates that this field will hold an explicit array of child nodes 
// for the current node.
// This has the same effect as specifying +link{dataSource.childrenField} to this field's 
// name.
// @see dataSource.childrenField
// @group dataSourceRelations
// @visibility external
// @example treeLoadXML
//<


//> @attr dataSourceField.rootValue            (any : null : [IR])
// For a field that is a foreignKey establishing a tree relationship, what value indicates a
// root-level node.  Defaults to null.
// @group dataSourceRelations
// @visibility external
// @example treeLoadXML
//<

//> @attr dataSourceField.sequenceName (String : null : IR)
// For a DataSource with +link{dataSource.serverType,serverType:"sql"} with a field of type
// "sequence", the name of the SQL sequence that should be used when inserting new records into
// this table.
// <P>
// Note that this is never required for SQL tables that are generated from SmartClient
// DataSources (a default sequence name of tableName + "_" + columnName is chosen), and is 
// never required for databases where inserting null into a sequence column is sufficient
// (MySQL, SQL Server, DB2 and others).  
// <P>
// You would only need to set sequenceName if you are integrating with a pre-existing table
// stored in a database where the sequence must be named for insertion to work (Oracle,
// Postgres) OR you are trying to use the same sequence across multiple DataSources.
//
// @group sqlDataSource
// @visibility external
//<

// XML binding / serialization
// ---------------------------------------------------------------------------------------

//> @attr dataSourceField.xmlAttribute (boolean : null : IR)
// Indicates that +link{dataSource.xmlSerialize()} should serialize this value as an XML
// attribute.
// <P>
// Note this does not need to be declared in order for DataSource records to be derived from
// XML data: a field will be populated with either an attribute or subelement with matching
// name.
//
// @group xmlSerialize
// @group componentSchema
// @visibility external
//<

//> @attr dataSourceField.multiple (boolean : null : IR)
// Indicates that this field should always be Array-valued.  If the value derived from
// +link{dataSource.dataFormat,XML or JSON data} is singular, it will be wrapped in an Array.
// <P>
// Specifically for XML serialization and deserialization, <code>multiple:true</code> behaves
// similarly to the 
// +externalLink{http://www.google.com/search?hl=en&q=soap+array,SOAP array idiom}, that is,
// there will be a "wrapper element" named after the field name, whose contents will be several
// elements of the specified +link{dataSourceField.type,field.type}.  
// <P>
// For example, +link{layout.members} is declared with <code>type:"Canvas",
// multiple:true</code>.  The correct XML format is thus:
// <pre>
// &lt;VLayout&gt;
//     &lt;members&gt;
//         &lt;Canvas ID="myCanvas" ... /&gt;
//         &lt;ListGrid ID="myGrid" .../&gt;
//         &lt;Toolstrip ID="myToolStrip" ... /&gt;
//     &lt;/members&gt;
// &lt;/VLayout&gt;
// </pre>
//
// @group xmlSerialize
// @group componentSchema
// @visibility external
//<

//> @attr dataSourceField.propertiesOnly (boolean : null : IR)
// For use in +link{group:componentSchema} for fields that contain other components, this flag
// suppresses auto-construction for subcomponents that appear under this field.
// <P>
// For example, the +link{VLayout} schema sets this for its +link{Layout.members,members}
// property, so that when a VLayout is constructed via XML as follows:
// <pre>
// &lt;VLayout&gt;
//     &lt;members&gt;
//         &lt;ListGrid ID="myGrid" .../&gt;
//         &lt;Toolstrip ID="myToolStrip" ... /&gt;
//     &lt;/members&gt;
// &lt;/VLayout&gt;
// </pre>
// The ListGrid and ToolStrip do not construct themselves automatically.  Instead, the VLayout
// receives the properties of the ListGrid and ToolStrip as ordinary JavaScript Objects, with
// the special property <code>_constructor</code> set to the name of the class that should be
// constructed.
//
// @group componentSchema
// @visibility external
//<

//> @attr dataSourceField.inapplicable (boolean : null : IR)
// For use in +link{group:componentSchema}, a field +link{dataSource.inheritsFrom,inherited} from
// another schema can be redeclared with this property set in order to indicate that the
// property should not be used.
// <P>
// This is primarily used to influence +link{group:visualBuilder}.  For simple type properties,
// this avoids the property appearing in the Component Editor.  
// <P>
// For fields that hold subcomponents, this prevents inappropriate drag and drop.  For example,
// a custom class called <code>MyDialog</code> may automatically create a series of children,
// and not allow arbitrary other children to be added.  In this case, the inherited property
// +link{Canvas.children} should be marked inapplicable in order to prevent arbitrary
// components being dropped onto a <code>MyDialog</code> instance.
//
// @group componentSchema
// @visibility external
//<

//> @attr dataSourceField.group (string : null : IR)
// For use in +link{group:componentSchema}, indicates what group to place the property in when
// editing in Visual Builder.
//
// @group componentSchema
// @visibility external
//<

// Javabean/POJO Binding
// ---------------------------------------------------------------------------------------

//> @attr dataSourceField.javaClass (String : null : IR)
// For use with the SmartClient server when populating Java Beans / POJOs based on data
// contained in a DSRequest, <code>javaClass</code> specifies the fully qualified Java
// className to be created and passed to the setter for the Java Bean Property with the same
// name as this field.   <code>javaClass</code> is used both when manually calling
// DataSource.setProperties() and when auto-populating POJO arguments of a +link{DMI} method.
// <P>
// The Java class to create does not normally have to be specified: SmartClient will
// use Java reflection to inspect the type of argument expected by a setter method and will
// attempt conversion of inbound data to that type.  As described in the documentation for
// DataTools.setProperties(), this works for almost all typical cases.  However
// <code>field.javaClass</code> is useful for:
// <ul>
// <li> subobject of abstract or interface type: in this case Java Reflection is not sufficient
// to discover the concrete type that should be instantiated, and <code>javaClass</code> should be
// set instead.</li>
// <li> subobject of Collection or Map type, when Java generics are not used or the Collection
// member type or Map value type is abstract.  When Java generics are used (for example the
// setter takes an argument is of type Collection&lt;SomePOJO&gt; or Map&lt;KeyType,SomePOJO&gt;,
// SmartClient will automatically attempt to convert inbound data to the type of the members of
// the Collection or values of the Map.  Without generics, <code>javaClass</code> needs to be
// specified.  Note that <code>javaClass</code> will take precendence over generics if both 
// are used. Also note that +link{dataSourceField.javaCollectionClass} can be specified if a
// particular Collection or Map type is needed, and +link{dataSourceField.javaKeyClass} can be
// specified for a field of type <code>java.util.Map</code>.</li>
// </ul>
// 
// @visibility external
//<

//> @attr dataSourceField.javaCollectionClass (String : null : IR)
// See +link{dataSourceField.javaClass} - when auto-populating of Java Beans / POJOs based on 
// inbound DSRequest data, for a field of type Collection or Map, 
// <code>javaCollectionClass</code> can 
// be used to specify a particular concrete class to use.  If not specified, and a concrete
// Collection or Map class cannot be discovered using Java Reflection, 
// <code>java.util.ArrayList</code> is used for fields of type Collection, and 
// <code>org.apache.commons.collections.SequencedHashMap</code> is used for fields of type Map.
//
// Note that this value is used even if the target Collection or Map is declared as a concrete
// class.  So, for example, if you set <code>javaCollectionClass</code> to 
// <code>java.util.LinkedList</code> but your setter method accepts a 
// <code>java.util.ArrayList</code>, you will get a ClassCastException.
//
// @visibility external
//<

//> @attr dataSourceField.javaKeyClass (String : null : IR)
// See +link{dataSourceField.javaClass} - when auto-populating of Java Beans / POJOs based on 
// inbound DSRequest data, for a field of Map type, <code>javaKeyClass</code> can be used to
// specify a particular concrete class for the map keys.  If not specified, and a concrete
// type cannot be discovered using Java Reflection, <code>java.lang.Object</code> is used.
//
// Note that <code>javaKeyClass</code> take precedence over generics if both are used.
//
// @visibility external
//<
// Field Types
// --------------------------------------------------------------------------------------------

//> @type FieldType
// The types listed below are built-in types that +link{DataBoundComponent,databound
// components} understand and treat specially (using type-specific form controls, validators,
// formatters, sorting logic, etc).  
// <P>
// You can declare custom types via +link{SimpleType,SimpleType.create()}, with settings that
// will influence DataBound components.  You can also create your own subclasses of databound
// components to add further custom, reusable behaviors based on field.type.
// <P>
// <code>field.type</code> can also be the ID of another +link{DataSource}, which allows you to
// model nested structures such as XML documents (in fact, +link{XMLTools.loadXMLSchema()}
// models XML schema in this way).  Nested DataSource declarations affect how XML and JSON data
// is deserialized into JavaScript objects in the 
// +link{group:clientDataIntegration,client-side integration} pipeline, so that you can load
// complex XML documents and have them deserialized into a correctly typed JavaScript object
// model.
// <P>
// Note: to declared related but <i>separate</i> objects, as in an "Account" object that can be
// related to both a "Contact" object and "Order" objects, use
// +link{dataSourceField.foreignKey}, <b>not</b> a nested structure declaration.
//
// @value "text"      Generic text, e.g. <code>"John Doe"</code>. This is the default field type.
//                    Use <code>field.length</code> to set length.
// @value "boolean"   A boolean value, e.g. <code>true</code>
// @value "integer"   A whole number, e.g. <code>123</code>
// @value "float"     A floating point (decimal) number, e.g. <code>1.23</code>
// @value "date"      A date, including time of day. Represented on the client as a
//                    JavaScript <code>Date</code> object. See +link{class:Date} for
//                    SmartClient extensions to the <code>Date</code> object.
// @value "enum"      A text value constrained to a set of legal values specified by the
//                    field's +link{DataSourceField.valueMap,valueMap}, as though an
//                    +link{ValidatorTypes.isOneOf,isOneOf} validator had been declared.
// @value "intEnum"   An enum whose values are numeric.
// @value "sequence"  If you are using the SmartClient SQL datasource connector, a
//                    <code>sequence</code> is a unique, increasing whole number, incremented
//                    whenever a new record is added. Otherwise, <code>sequence</code> behaves
//                    identically to <code>integer</code>. This type is typically used with
//                    <code>field.primaryKey</code> to auto-generate unique primary keys.
// @value "link"      A string representing a well-formed URL.  Some components
//                    will render this as an HTML link (using an anchor tag for example).    
// @value "image"     A string representing a well-formed URL that points to an
//                    image.  Some components will render an IMG tag with the value of this field
//                    as the 'src' attribute to render the image.
// @value "binary"    Arbitrary binary data.  When this field type is present, three additional
// fields are automatically generated.  They are: &lt;fieldName&gt;_filename, &lt;fieldName&gt;_filesize, and
// &lt;fieldName&gt;_date_created where &lt;fieldName&gt; is the value of the <code>name</code>
// attribute of this field.  These fields are marked as
// +link{attr:dataSourceField.hidden}<code>:true</code> to suppress their rendering by default.  You
// can show one or more of these fields by specifying the field with a <code>hidden:false</code>
// override in the fields array of the databound component.
//
// @value "imageFile" Binary data comprising an image.
//
// @see type:ListGridFieldType
// @see type:FormItemType
// @visibility external
//<


// Titles
// ---------------------------------------------------------------------------------------

//> @attr DataSource.title (string : dataSource.ID : IRW)
// User-visible name for this DataSource.
// <P>
// For example, for the supplyItem DataSource, "Supply Item".
// <P>
// Defaults to <code>dataSource.ID</code>.
// @group titles
// @visibility external
//<

//> @attr DataSource.pluralTitle (string : dataSource.ID : IR)
// User-visible plural name for this DataSource.
// <P>
// For example, for the supplyItem DataSource, "Supply Items".
// <P>
// Defaults to (<code>dataSource.title</code> or <code>dataSource.ID</code>) + "s".
// @group titles
// @visibility external
//<

//> @attr dataSource.titleField (string : see below : IR)
// Best field to use for a user-visible title for an individual record from this dataSource.
// <p>
// For example, for a DataSource of employees, a "full name" field would probably most clearly
// labels an employee record.
// <p>
// If not explicitly set, titleField looks for fields named "title", "label", "name", and "id"
// in that order.  If a field exists with one of those names, it becomes the titleField.  If not,
// then the first field is designated as the titleField.
//
// @group titles
// @visibility external
//<

//> @attr dataSource.iconField (string : see below : IR)
// Designates a field of +link{FieldType,type}:"image" as the field to use when rendering a
// record as an image, for example, in a +link{TileGrid}.
// <p>
// For example, for a DataSource of employees, a "photo" field of type "image" should be
// designated as the iconField.
// <p>
// If not explicitly set, iconField looks for fields named "picture", "thumbnail", "icon",
// "image" and "img", in that order, and will use any of these fields as the iconField if it
// exists and has type "image". 
// <P>
// To avoid any field being used as the iconField, set iconField to <code>null</code>.
// 
// @visibility external
//<


//> @attr dataSource.childrenField (string : null : [IR])
// fieldName for a field in the dataSource expected to contain an explicit array of child nodes.
// Enables loading a databound tree as a hierachical data structure, rather than a flat list of
// nodes linked by foreignKey.<br>
// Note this is an alternative to setting +link{dataSourceField.childrenProperty} directly on
// the childrenField object.<P>
// By default the children field will be assumed to be +link{dataSourceField.multiple, multiple},
// for XML databinding. This implies that child data should be delivered in the format:
// <pre>
//      &lt;childrenFieldName&gt;
//          &lt;item name="firstChild" ...&gt;
//          &lt;item name="secondChild" ...&gt;
//      &lt;/childrenFieldName&gt;
// </pre>
// However data may also be delivered as a direct list of <code>childrenFieldName</code> 
// elements:
// <pre>
//      &lt;childrenFieldName name="firstChild" ...&gt;
//      &lt;childrenFieldName name="secondChild" ...&gt;
// </pre>
// If you want to return your data in this format, you will need to explicitly set 
// <code>multiple</code> to false in the appropriate dataSource field definition.
//
// @see dataSourceField.childrenProperty
// @group dataSourceRelations
// @visibility external
//<



isc.DataSource.addMethods({
	init : function () {
        // serverType:"sql" implies iscServer format
        if (this.serverType == "sql") this.dataFormat = "iscServer";

        // make it unnecessary to set dataFormat="xml" when properties related to XML have
        // already been set
        if (this.dataFormat == "iscServer" &&
            (this.serviceNamespace != null || this.recordXPath != null)) this.dataFormat = "xml";
        
        // we don't currently support request queuing (multi-op) for anything other than the
        // iscServer format
        this.canQueueRequests = (this.dataFormat == "iscServer" || this.clientOnly);

        
        if (this.ID == null && this.id != null) this.ID = this.id;

		
        if (this.name == null) this.name = this.ID;

        // prevent the server definition of eg ValueMap from destroying certain built-in schema
        var existingDS = isc.DS.get(this.ID);
        if (existingDS && existingDS.builtinSchema) return existingDS;

        // make the DataSource a global variable if set to do so, and it doesn't belong to a
        // particular namespace
        // NOTE: when becoming global, only clobber other DataSources, never a Class or any
        // other kind of global.  Otherwise widget DataSources like Canvas clobber the
        // corresponding widget class.  Note we have to specially check for isA.ClassObject()
        // because the DataSource classObject and subclasses will return true when
        // isA.DataSource() is applied to them.
        var existingValue = window[this.ID];
        if (this.addGlobalId && this.addGlobalId != isc._false &&
            (!existingValue || 
                (!isc.isA.ClassObject(existingValue) && isc.isA.DataSource(existingValue)))) 
        {
            isc.ClassFactory.addGlobalID(this);
        }

        
        // if field is provided as an Array, make them into an index by name (so client-only
        // DataSources can use the array of fields format common to all components).  NOTE:
        // this is essentially Array.makeIndex, except we log collisions.
        var fields = this.fields;
        if (isc.isAn.Array(fields)) {
            var fieldIndex = {};
            for (var i = 0; i < fields.length; i++) {
                var field = fields[i];
                // last field wins on name collision.  
                if (fieldIndex[field.name] != null) {
                    this.logWarn("field.name collision: first field: " +
                                 this.echo(fieldIndex[field.name]) + 
                                 ", discarded field: " + this.echo(field));
                    continue;
                }
                fieldIndex[field.name] = field;
            }
            this.fields = fieldIndex;
        }
	
		if (this.dataSourceType == isc.DataSource.VIEW) this.initViewSources();

        // register globally
        isc.DataSource.registerDataSource(this);
	},
	
    // destroy global ID, if one was assigned.
    destroy : function () { 
        var ID = this.ID,
            DS = isc.DS;
        
        // remove from global scope
        if (ID && this == window[ID]) window[ID] = null;

        // remove from global registries
        if (DS._dataSources[ID] == this) DS._dataSources[ID] = null;
        if (DS._elements[ID] == this) DS._elements[ID] = null;
        if (DS._types[ID] == this) DS._types[ID] = null;
    },
    

    // Result Sets
	// --------------------------------------------------------------------------------------------
    getResultSet : function (params) {
        var resultSetClass = isc.ClassFactory.getClass(this.resultSetClass || isc.ResultSet);
        
        if (!isc.isA.Class(resultSetClass)) {
            this.logWarn("getResultSet(): Unrecognized 'resultSetClass' property:" 
                         + resultSetClass + ", returning a standard isc.ResultSet.");
            resultSetClass = isc.ResultSet;
        }
        
        // flag resultSet as autoCreated, so we know to destroy() it when the component no
        // longer needs it
        return resultSetClass.create(params, {_autoCreated: true});
    },
    
    // Observable dataChanged methods.
    // ResultSets associated with this dataSource will observe these methods and use them
    // to handle cache-sync
    // Dont obfuscate: allow observers to pick up parameter names            
    dataChanged : function (dsResponse, dsRequest) {
        //!DONTOBFUSCATE
    },
    
	updateCaches : function (dsResponse, dsRequest) {
		var updateData = dsResponse.data,
            forceCacheInvalidation = dsResponse.invalidateCache
        ;

		if (!updateData && !forceCacheInvalidation) {
			//>DEBUG
			this.logWarn("Empty results returned on '" + dsRequest.operationType + 
                         "' on dataSource '" + dsRequest.dataSource + 
                         "', unable to update resultSet(s) on DataSource " + this.ID +
                         ".  Return affected records to ensure cache consistency.");
			//<DEBUG
			return;
		}
    
        this.dataChanged(dsResponse, dsRequest);
	},

    // ---------------------------------------------------------------------------------------
    // XML
    // ---------------------------------------------------------------------------------------

    //> @method dataSource.getLegalChildTags
    // For a DataSource that describes a DOM structure, the list legal child elements that can
    // be contained by the element described by this DataSource.
    // <p>
    // For a DataSource described by XML schema, this is the list of legal subelements <b>of
    // complexType</b> (elements of simpleType become DataSourceFields with atomic type).
    // <p>
    // Note that currently, if an XML schema file contains ordering constraints, DataSources
    // derived from XML Schema do not capture these constraints.
    //
    // @group xmlSchema
    // @visibility xmlBinding
    //<
    getLegalChildTags : function () {
        var fieldNames = this.getFieldNames(),
            complexFields = [];
        for (var i = 0; i < fieldNames.length; i++) {
            if (this.fieldIsComplexType(fieldNames[i])) complexFields.add(fieldNames[i]);
        }
        return complexFields;
    },

    // get the operationBinding for this operation.  The operationBinding is the bundle of properties specifying
    // how to invoke a particular DataSource operation, eg "fetch".  
    // <BR>
    // In the absence of an operationBinding for a particular operation, the DataSource itself is used
    // as the operationBinding, with the same set of properties supported - in this case you basically
    // have a read-only DataSource only capable of fetch.
    // <BR>
    // Takes either a dsRequest or an operationType and optional operationId.  
    getOperationBinding : function (operationType, operationId) { 
        if (operationType == null || this.operationBindings == null) return this;

        if (isc.isAn.Object(operationType)) {
            // passed a DSRequest 
            var dsRequest = operationType;
            operationType = dsRequest.operationType;
            operationId = dsRequest.operationId;
        }

        var schemaName;
        // look for a binding specific to the operationId (eg myFetchSchema) if passed
        if (operationId) {
            var operationBinding = this.operationBindings.find("operationId", operationId);
            if (operationBinding) return operationBinding;
        }
        // look for a binding for this operationType
        if (operationType) { 
            var operationBinding = this.operationBindings.find("operationType", operationType);
            if (operationBinding) return operationBinding;
        }
        return this;
    },

    getDataFormat : function (operationType, operationId) {
        return this.getOperationBinding(operationType, operationId).dataFormat || this.dataFormat;
    },

    //> @method dataSource.transformRequest() [A]
    // For a dataSource using +link{group:clientDataIntegration,client-side data integration},
    // return the data that should be sent to the +link{dataURL}.
    // <P>
    // By default, HTTP requests sent to non-SmartClient servers do not include DSRequest
    // metadata such as +link{dsRequest.startRow}, +link{dsRequest.endRow,endRow},
    // and +link{dsRequest.oldValues,oldValues}.  Only the core
    // +link{group:dataSourceOperations,datasource protocol data} is sent, such as the criteria
    // passed to +link{listGrid.fetchData,fetchData()} or the updated values submitted by
    // +link{dynamicForm.saveData(),form.saveData()}.  
    // <P>
    // transformRequest() allows you to transform dsRequest metadata into a
    // format understood by your server and include it in the HTTP request, so that you can
    // integrate DataSource features such as data paging with servers that support such
    // features.
    // <P>
    // How the data is actually sent to the URL is controlled by 
    // +link{operationBinding.dataProtocol}.  If using the "getParams" or
    // "postParams" protocol, data is expected to be a JavaScript Object where each property
    // will become a GET or POST'd parameter.  If using dataProtocol:"soap" or "postXML", data
    // will be serialized as an XML message by +link{method:DataSource.xmlSerialize()}.
    // <P>
    // As an example, if you have a dataURL that can return paged data given URL parameters
    // "start" and "end", you could implement transformRequest like so:
    // <pre>
    //   isc.DataSource.create({
    //      ... 
    //      transformRequest : function (dsRequest) {
    //         if (dsRequest.operationType == "fetch") {
    //             var params = {
    //                start : dsRequest.startRow,
    //                end : dsRequest.endRow
    //             };
    //             // combine paging parameters with criteria
    //             return isc.addProperties({}, dsRequest.data, params);
    //         }
    //      }
    //   });
    // </pre>
    // Other reasons to implement transformRequest():
    // <ul>
    // <li> transform a +link{type:Criteria} object into the custom query language of a web
    //      service
    // <li> add a session id to requests that require authentication
    // <li> detect colliding updates by sending both updated values and the values the user
    //      originally retrieved before editing began (available as +link{dsRequest.oldValues})
    // </ul>
    // <i>Special case:</i> If the <code>dataProtocol</code> is <code>"clientCustom"</code>
    // the SmartClient system will not attempt to send data to the server in any way. Instead 
    // transformRequest should be implemented such that it accesses or updates the underlying
    // data-set and calls +link{DataSource.processResponse()} when the operation is complete. This
    // setting allows straightforward integration with non SmartClient comm mechanisms that 
    // directly send requests to the server (such as GWT-RPC), or handle data manipulation without
    // sending HTTP at all (such as Google Gears).
    //
    // @param dsRequest (DSRequest) the DSRequest being processed
    // @return (any) data to be sent to the dataURL
    // @visibility xmlBinding
    //<
    transformRequest : function (dsRequest) {
        return dsRequest.data;
    },

    
    serializeFields : function (data, dsRequest) {
        if (!data) data = dsRequest.data;
        if (!data) return data;

        // don't try to serialize simpleType values
        if (isc.DS.isSimpleTypeValue(data)) return data;

        if (isc.isAn.Array(data)) {
            var newData = [];
            for (var i = 0; i < data.length; i++) {
                newData[i] = this.serializeFields(data[i], dsRequest);
            }
            return newData;
        }
        data = isc.addProperties({}, data);
        var fields = this.getFields();
        for (var fieldName in fields) {
            var field = fields[fieldName];
            if (isc.isA.Date(data[fieldName]) &&
                isc.SimpleType.getBaseType(field.type) == "date" &&
                !isc.SimpleType.inheritsFrom(field.type, "datetime"))
            {
                // NOTE: we choose to flag the date instead of serializing it right here
                // because we want isc.Comm.xmlSerialize() to use xsi:type="date" for clarity 
                data[fieldName].logicalDate = true;
            }
        }
        return data;
    },

    getDataProtocol : function (dsRequest) {
        var operationBinding = this.getOperationBinding(dsRequest),
            service = this.getWebService(dsRequest);
        // WSDL-described web services use SOAP unless a dataProtocol has been explicitly set
        // for the operationBinding.
        // NOTE: protocol per operationBinding allows eg GET fetch, POST update
        return (operationBinding.dataProtocol != null ? operationBinding.dataProtocol :
                isc.isA.WebService(service) ? "soap" : this.dataProtocol || "getParams");
    },

    // get rpcRequest properties that should be set on this dsRequest based on dataProtocol and
    // other DataSource settings.
    // NOTE: 
    // - these settings will be applied to an rpcRequest which is a *copy* of the dsRequest,
    //   which is why we don't simply change the settings directly here.  See 
    //   "RPCRequest vs DSRequest" comment elsewhere in this file
    // - we need to be careful to respect overrides set on the dsRequest
    getServiceInputs : function (dsRequest) {
        
        var operationBinding = this.getOperationBinding(dsRequest),
            service = this.getWebService(dsRequest),
            operation = this.getWSOperation(dsRequest);

        var defaultCriteria = operationBinding.defaultCriteria || this.defaultCriteria;
        if (defaultCriteria && dsRequest.operationType == "fetch") {
            dsRequest.data = isc.addProperties({}, defaultCriteria, dsRequest.data);
        }

        // call transformRequest to allow the data to be changed before it is serialized to the
        // wire.  Hang onto the data in it's original format too
        dsRequest.originalData = dsRequest.data;
        
        var protocol = this.getDataProtocol(dsRequest),
            clientCustom = protocol == "clientCustom";
        // clientCustom dataProtocol 
        // - transformRequest has been implemented to call non SmartClient code to generate the
        //   appropriate response, and call 'processResponse()' with it.
        // - store out the request so we can retrieve it by ID when processResponse fires.
        //   Doing this before calling transformRequest should handle synchronous as well as asynch
        //   response generation code.
        if (clientCustom) {
            if (!this._clientCustomRequests) this._clientCustomRequests = {};
            this._clientCustomRequests[dsRequest.requestId] = dsRequest;
        }
        
        dsRequest.data = this.transformRequest(dsRequest);
        
        // If it was a clientCustom request, just return and wait for a call to processResponse 
        if (clientCustom) {
            return {dataProtocol:"clientCustom"};
        }

        if (isc.isA.WebService(service)) {
            if (dsRequest.wsOperation == null && isc.isAn.Object(operation)) {
                dsRequest.wsOperation = operation.name;
            }
            this.logInfo("web service: " + service + 
                          ", wsOperation: " + this.echoLeaf(operation), "xmlBinding");
        }

        var dataURL = this.getDataURL(dsRequest);

        // allow dataURL to be specified as a DSRequest property.  Needed because the same
        // structure of data may come from many different URLs (such as RSS feeds or WSDL
        // files).  Also allow actionURL because we advertise that all RPCRequest props are
        // legal on DSRequests.
        dataURL = dsRequest.actionURL || dsRequest.dataURL || dataURL;
        
        // getParams / postParams send the request data to the server as params.
        // In addition to this, regardless of data protocol we support explicit
        // per request params, and defaultParams from the DS / binding.
        var params,
            defaultParams = operationBinding.defaultParams || this.defaultParams,
            explicitParams = dsRequest.params;
        
        if (defaultParams || explicitParams) {
            params = isc.addProperties({}, defaultParams, explicitParams);
        }

        var dataAsParams = protocol == "getParams" || protocol == "postParams"; 
        if (dataAsParams) {
            params = isc.addProperties(params || {}, dsRequest.data);
        }
        
        if (dataAsParams) {
    
            if (params) params = this.serializeFields(params, dsRequest);
            
            // GET or POST with form-style params
            return {
                actionURL: dataURL,
                httpMethod: dsRequest.httpMethod || (protocol == "getParams" ? "GET" : "POST"),
                params: params
            };
        }
        
        // remaining possibilities ("postMessage", "postXML", "soap") all POST a request body

        var serviceInputs = {
            actionURL: dataURL,
            // allow httpMethods like "PUT"
            httpMethod: dsRequest.httpMethod || "POST"
        };
        // if necessary pass params to the server as well as data in the body
        if (params) serviceInputs.params = params;
        
        if (protocol == "postMessage") {
            serviceInputs.data = (dsRequest.data || "").toString();
        }

        // for XML posts, serialize the data as XML
        if (protocol == "postXML" || protocol == "soap") {
            var requestBody = serviceInputs.data = this.getXMLRequestBody(dsRequest);
            serviceInputs.contentType = dsRequest.contentType || "text/xml";
            this.logDebug("XML post requestBody is: " + requestBody, "xmlBinding");
        }

        // add SOAPAction HTTP header for SOAP
        if (protocol == "soap") {
            var soapAction = this._firstNonNull(operationBinding.soapAction, 
                                                operation.soapAction);
            if (soapAction != null) {
                // NOTE: some engines, like Axis, require a soapAction to be present, so people who
                // don't really need a soapAction put soapAction="" into their WSDL, hoping for a
                // meaningless 'SOAPAction: ""' header to get by Axis.
                if (isc.isAn.emptyString(soapAction)) soapAction = '""';

                serviceInputs.httpHeaders = isc.addProperties({ SOAPAction : soapAction },
                                                              dsRequest.httpHeaders);
            }
        }

        this.logDebug("serviceInputs are: " + this.echo(serviceInputs), "xmlBinding");
        return serviceInputs;
    },
    
    //> @method DataSource.processResponse() (A)
    // Process a dsResponse for a request initiated by a DataSource with
    // +link{OperationBinding.dataProtocol,dataProtocol:"clientCustom"}.
    // <code>requestId</code> parameter should be dsRequest.requestId as found on the dsRequest
    // passed to +link{dataSource.transformRequest()}.
    // <P>
    // You must provide a response for both error and non-error cases.  For an error case, a
    // sufficient response is:
    // <pre>
    // { status : -1 }
    // </pre>
    // @param requestId (string) requestId attribute from the associated dataSource request object
    // @param dsResponse (DSResponse properties) Configuration for the dsResponse 
    // @visibility external
    //<
    processResponse : function (requestId, dsResponse) {
        var dsRequest = this._clientCustomRequests[requestId];
        if (dsRequest == null) {
            this.logWarn("DataSource.provedResponse(): Unable to find request corresponding to ID "
                        + requestId + ", taking no action.");
            return;
        }
        delete this._clientCustomRequests[requestId];
        
        // assume success
        if (dsResponse.status == null) dsResponse.status = 0;
        if (dsResponse.status == 0) {
            // If start/endRow are unset check for data length            
            var data = dsResponse.data;
            if (data == null) dsResponse.data = data = [];
            if (dsResponse.startRow == null) dsResponse.startRow = dsRequest.startRow || 0;
            if (dsResponse.endRow == null) dsResponse.endRow = dsResponse.startRow + data.length;
            if (dsResponse.totalRows == null) {
                dsResponse.totalRows = Math.max(dsResponse.endRow, data.length);
            }
        }
        this._completeResponseProcessing(data, dsResponse, dsRequest);
    },
    
    _handleClientOnlyReply : function (rpcResponse, data, rpcRequest) {
        var dsResponse = this.getClientOnlyResult(rpcRequest),
            dsRequest = rpcRequest._dsRequest;

        this._completeResponseProcessing(data, dsResponse, dsRequest, rpcResponse, rpcRequest);
    },

    
    _handleCustomReply : function (rpcResponse, data, rpcRequest) {
        var dsResponse = {
            data : data,
            startRow : 0,
            endRow : 0,
            totalRows : 0,
            status : 0
        };
        var dsRequest = rpcRequest._dsRequest;
        this._completeResponseProcessing(data, dsResponse, dsRequest, rpcResponse, rpcRequest);
    },

    _handleJSONReply : function (rpcResponse, data, rpcRequest) {
        var dsRequest = rpcRequest._dsRequest,
            recordXPath = this.getOperationBinding(dsRequest).recordXPath;

        // log the raw object reply if we didn't just eval it from text (if we eval it from
        // text we've already logged the raw response)
        if (rpcResponse._wasJSONTextReply && this.logIsDebugEnabled("xmlBinding")) {
            this.logDebug("Raw response data: " + 
                           isc.Comm.serialize(data, true), "xmlBinding");
        }

        // Hang onto the raw JSON object returned by the server. This allows transformResponse
        // to actually do something useful with the data returned (EG, pick up meta-data)
        var rawData = data;
        
        // Don't try to process null data - this can now happen if we get an invalid 
        // HTTP response (404, 500, etc) and willHandleError == true
        if ( data ) {
	        if (this.recordXPath) {
	            // extract relevant records via XPath
	            data = isc.xml.selectObjects(data, this.recordXPath);
	            this.logInfo("JSON recordXPath: '" + this.recordXPath + 
	                         "', selected: " + this.echoLeaf(data), "xmlBinding");
	        }
	
	        data = this.recordsFromObjects(data);
	
	        if (this.logIsDebugEnabled("xmlBinding")) {
	            this.logDebug("Validated dsResponse.data: " + 
	                           isc.Comm.serialize(data, true), "xmlBinding");
	        }
	
	        // derive the default response
	        var dsResponse = {
	            data : data,
	            startRow : dsRequest.startRow || 0, 
	            status : 0 // assume success
	        };       

	        dsResponse.endRow = dsResponse.startRow + Math.max(0, data.length);
	        dsResponse.totalRows = Math.max(dsResponse.endRow, data.length);
	        
        } else {
	        // derive the default error response
	        var dsResponse = {
	            status : -1
	        };       
        }

        this._completeResponseProcessing(rawData, dsResponse, dsRequest, rpcResponse, rpcRequest);
    },

    _handleJSONTextReply : function (rpcResponse, jsonText, rpcRequest) {
        //!DONTOBFUSCATE
        
        // Don't try to process jsonText if we didn't get a valid response
        if (rpcResponse.status >= 0) {
	        var evalText = jsonText;
	        // Strip the json prefix / suffix if supplied, and transport was not scriptInclude
	        if (rpcRequest.transport != "scriptInclude") {
	            // Strip whitespace before checking for specified prefix / suffix
	            var re;            
	            if (this.jsonPrefix) {
	                re = new RegExp(/^\s*/);
	                evalText = evalText.replace(re, "");
	                if (evalText.startsWith(this.jsonPrefix)) {
	                    evalText = evalText.substring(this.jsonPrefix.length);
	                } else {
	                    this.logInfo("DataSource specifies jsonPrefix, but not present in " + 
	                                 "response returned from server. Processing response anyway.");
	                }
	            } 
	            if (this.jsonSuffix) {
	                re = new RegExp(/\s*$/)                
	                evalText = evalText.replace(re, "");            
	                if (evalText.endsWith(this.jsonSuffix)) {
	                    evalText = evalText.substring(0, (evalText.length - this.jsonSuffix.length));
	                } else {
	                    this.logInfo("DataSource specifies jsonSuffix, but not present in " + 
	                                 "response returned from server. Processing response anyway.");
	                }
	            }
	        }
	
	        // Note: FF1.0.7 bug: curly must be escaped in the following regex.  Not an issue in IE
	        // or FF1.5
	        if (evalText.match(/^\s*\{/)) {
	            // eval barfs on "{ ...  }", thinking it's a closure
	            evalText = "var evalText = " + evalText + ";evalText;"
	        } 
	        try {
	            var jsonObjects = isc.eval(evalText);
	        } catch (e) {
	            this.logWarn("Error evaluating JSON: " + e.toString() + ", JSON text:\r" + jsonText);
	            return;
	        }
	        
	        // warn and bail if server response object evals to null.
	        // This can happen if the response is "", or if it's something like "var foo = {};"
	        // where the result of the eval is undef.
	        // Avoids a JS error in handleJSONReply
	        if (jsonObjects == null) {
	            this.logWarn("Evaluating JSON reply resulted in empty value. JSON text:\r" 
	                         + this.echo(jsonText));
	            return;
	        }
	
	        // Hack to let _handleJSONReply know this JSON response came from text, for logging
	        // purposes
	        rpcResponse._wasJSONTextReply = true; 
        }

        this._handleJSONReply(rpcResponse, jsonObjects, rpcRequest);
    },

    //> @method dataSource.recordsFromObjects() [A]
    // Transform a list of Objects to DataSource records.
    // <P>
    // The value for each field is extracted from the XML according to the
    // rules described under +link{attr:DataSourceField.valueXPath}.  
    //<
    recordsFromObjects : function (data) {

        // normalize to Array and apply schema
        if (!isc.isAn.Array(data)) data = [data];
        for (var i = 0; i < data.length; i++) {
            data[i] = this.validateJSONRecord(data[i]);
        }
        return data;
    },

    validateJSONRecord : function (record) {
        var fieldNames = this.getFieldNames(),
            result = {};
        for (var i = 0; i < fieldNames.length; i++) {
            var fieldName = fieldNames[i],
                field = this.getField(fieldName),
                fieldValue;

            if (field.valueXPath) {
                fieldValue = isc.xml.selectObjects(record, field.valueXPath, true);
            } else {
                fieldValue = record[fieldName];
            }
            
            if (field.getFieldValue) {
                if (!isc.isA.Function(field.getFieldValue)) {
            	    isc.Func.replaceWithMethod(field, "getFieldValue", 
                                                     "record,value,field,fieldName");
                }
                fieldValue = field.getFieldValue(record, fieldValue, field, fieldName);
            }

            var undef;
            if (fieldValue != undef) {
                //this.logWarn("validating value: " + fieldValue + 
                //             " of field: " + this.echo(field));
                result[fieldName] = this.validateFieldValue(field, fieldValue);
            }
        }

        if (this.dropExtraFields) return result;
            
        
        for (var i = 0; i < fieldNames.length; i++) {
            var fieldName = fieldNames[i];
            record[fieldName] = result[fieldName]
        }
        return record;
    },
		
    // XML Request Formation
    // ---------------------------------------------------------------------------------------

    // get the schema to be used to serialize JS data to XML.  
    // Also takes a dsRequest.
    getMessageSerializer : function (operationType, operationId) {
        // either: 
        // - an operationBinding has been specified with a wsOperation
        // - no operationBinding was specified, so getOperationBinding() returns this, and then:
        //   - if this.wsOperation has been set, we use it
        //   - otherwise we use this DataSource as the message schema
        var operationBinding = this.getOperationBinding(operationType, operationId);
        if (operationBinding.wsOperation) {
            var service = this.getWebService(operationType, operationId);
            return service.getMessageSerializer(operationBinding.wsOperation);
        }
        return this;
    },

    //> @method dataSource.getXMLRequestBody() [A]
    // Get the XML to be posted to the dataURL based on the passed DSRequest.
    // <P>
    // This API is intended to be overriden in order to integrate with web services that
    // expect XML messages rather than simple HTTP parameters, but lack a
    // WSDL description.  For WSDL-described web services, having loaded the service
    // description, SmartClient knows the correct XML message structure, so customization is
    // best done by modifying the JavaScript data that is used to form the message.
    //
    // @see XMLTools.loadWSDL() for integration with WSDL-described web services
    // 
    // @param dsRequest (DSRequest) the request to encode as an XML message.
    // @return (String) the entire XML request as a String, including SOAP envelope if SOAP is used
    // @visibility xmlBinding
    //<
    getXMLRequestBody : function (dsRequest, flags) {
        if (isc._traceMarkers) arguments.__this = this;

        var requestBody = isc.SB.create(),
            protocol = this.getDataProtocol(dsRequest);

        // start envelope and headers
        if (protocol == "soap") {
            requestBody.append(this.getSoapStart(dsRequest), "\r");
            requestBody.append(this.getSoapBody(dsRequest, flags));
            requestBody.append("\r", this.getSoapEnd(dsRequest));
        } else { 
            if (this.messageStyle == "template") {
                requestBody.append(this._createTemplatedRequestBody(dsRequest));
            } else {
                var schema = this.getMessageSerializer(dsRequest);
                requestBody.append(this.getXMLRequestBodyPart(dsRequest, dsRequest.data,
                                                              schema, flags));
            }
        }

        if (this.logIsDebugEnabled("xmlComm")) {
            this.logDebug("outbound XML message: " + requestBody, "xmlComm");
        }

        return requestBody.toString();
    },

    
    _createTemplatedRequestBody : function (dsRequest) {
        var requestBody = isc.SB.create(),
            template = this.soapBodyTemplate,
            message;

        
            message = template.evalDynamicString(this, dsRequest);
        

        return message;
    },

    // WebService-related helper methods
    getSchemaSet : function () {
        return isc.SchemaSet.get(this.schemaNamespace);
    },

    hasWSDLService : function (dsRequest) {
        return isc.isA.WebService(this.getWebService(dsRequest));
    },

    getWebService : function (dsRequest) {
        var operationBinding = this.getOperationBinding(dsRequest),
            serviceNamespace = (dsRequest ? dsRequest.serviceNamespace : null) 
                                    || operationBinding.serviceNamespace || this.serviceNamespace;

        // see if we have a WebService instance with this serviceNamespace
        var service = isc.WebService.get(serviceNamespace);

        if (serviceNamespace != null && service == null) {
            this.logWarn("No WebService definition has been loaded for serviceNamespace: " +
                         serviceNamespace + this.getStackTrace());
        }

        // if we don't, then the DataSource itself is expected to have all the relevant
        // properties
        return service || this;
    },
    
    getWSOperation : function (dsRequest) {
        
        var operationBinding = this.getOperationBinding(dsRequest),
            wsOperation = (isc.isAn.Object(dsRequest) ? dsRequest.wsOperation : null) || 
                            operationBinding.wsOperation || this.wsOperation,
            service = this.getWebService(dsRequest);

        if (wsOperation != null && isc.isA.WebService(service)) {
            var returnOp = service.getOperation(wsOperation);
            if (!returnOp) {
                isc.logWarn("DataSource.getWSOperation() : could not retrieve the operation " 
                    + wsOperation);
            }
            return returnOp;
        }
        return this;
    },

    getDataURL : function (dsRequest) {
        var operationBinding = this.getOperationBinding(dsRequest);

        // if we have a real operationBinding definition (we're not using "this" as the
        // operationBinding definition) and it has a dataURL set, use that.  This allows eg
        // fetch via GET from one URL, save via POST to another
        if (operationBinding != this && operationBinding.dataURL) return operationBinding.dataURL;

        // NOTE: allow dataURL to be specified even on a DataSource that is using a web
        // service.  This is a simple way to spoof web service responses for a single
        // DataSource; using webService.setLocation() allows you to put the spoofing at the
        // WebService level
        if (this.dataURL != null) return this.dataURL;

        // otherwise if we have a WSDL-derived WebService definition, ask it for a dataURL
        // (WSDL services can't really have multiple URLs, but it's useful to set a different
        // URL per operation for spoofing during testing)
        if (this.hasWSDLService(dsRequest)) {
            var service = this.getWebService(dsRequest);
            return service.getDataURL(this.getWSOperation(dsRequest).name);
        }
        
        return this.dataURL;
    },

    //> @attr dataSource.globalNamespaces (Object : ... : IRW)
    // Namespaces definitions to add to the root element of outbound XML messages sent to a web
    // service, as a mapping from namespace prefix to namespace URI.
    // <P>
    // The default value is:
    // <pre>
    //   globalNamespaces : {
    //      xsi: "http://www.w3.org/2001/XMLSchema-instance",
    //      xsd: "http://www.w3.org/2001/XMLSchema"
    //   },
    // </pre>
    // This default value allows the use of the xsi:type and xsi:nil attributes without further
    // declarations.
    // <P>
    // Note that some web services will only accept specific revisions of the XML Schema URI.
    // If xsi-namespaced attributes seem to be ignored by an older webservice, try the URI
    // "http://www.w3.org/1999/XMLSchema-instance" instead.
    //
    // @visibility xmlBinding
    //<
    getGlobalNamespaces : function (dsRequest) {
        var service = this.getWebService(dsRequest),
            namespaces = this.globalNamespaces;
        if (service && service.globalNamespaces) {
            namespaces = isc.addProperties({}, namespaces, service.globalNamespaces);
        }
        return namespaces;
    },

    getSoapStart : function (dsRequest) {
        // allow centralized overrides of getSoapStart/End via overrides on a WebService object
        var service = this.getWebService(dsRequest);
        if (service.getSoapStart) return service.getSoapStart(dsRequest);

        return isc.SB.concat(isc.DataSource._soapEnvelopeStart, 
                             isc.xml._generateNamespaces(this.getGlobalNamespaces(dsRequest), 
                                                         null, "         "),
                             ">", isc.DataSource._soapHeaderStart,
                             this.getSoapHeader(dsRequest),
                             isc.DataSource._soapHeaderEnd);
    },
    getSoapHeader : function (dsRequest) { 
        var service = this.getWebService(dsRequest);
        if (service.getSoapHeader) return service.getSoapHeader(dsRequest);

        // take data from either the request or from the service
        var headerData = dsRequest.headerData || service.getHeaderData(dsRequest);

        if (!headerData) return;

        this.logDebug("headerData is: " + this.echo(headerData), "xmlBinding");

        // get schema for the headers
        var allHeaderSchema = service.getInputHeaderSchema(this.getWSOperation(dsRequest)) || 
                                isc.emptyObject;
 
        // WSDL/SOAP blows: in SOAP the <wsdl:part>s of a <wsdl:message> do not have any name or
        // means of referring to them other than by the combination of the wsdl:message@name and
        // wsdl:part@name attributes.  When asking developers to specify data to be serialized
        // for each part, we rely on just the part name.  It would be perverse to declare a
        // soap header or body that uses two identically named parts of different messages, but
        // it appears to be legal. 
        // Relevant spec: http://www.w3.org/TR/wsdl#_soap:header
        var output = "", flatHeaders = dsRequest.useFlatHeaderFields;
        for (var partName in headerData) {
            var headerSchema = allHeaderSchema[partName];
            if (headerSchema != null) {
                //this.logWarn("serialized partName: " + partName + 
                //             " with schema " + headerSchema);
                if (isc.isA.DataSource(headerSchema)) {
                    output += headerSchema.xmlSerialize(headerData[partName], 
                                                        { useFlatFields: flatHeaders })
                } else {
                    // special handling for simpleType headers:
                    // The wsdl:message declaration, which becomes a DataSource, does not have
                    // a namespace (it doesn't belong to an xs:schema), however the wsdl:parts
                    // refer to types declared in an xs:schema block that must be namespaced.
                    // When a wsdl:part refers to a simpleType element, there won't be a
                    // DataSource for the element, only a field, hence the field has to carry
                    // the namespace via the special partNamespace property.
                    // headerSchema, in this case, is a field definition.
                    output += "\r     " + this._serializeSimpleTypeTag(partName, headerSchema,
                                    headerData[partName], headerSchema.partNamespace);
                }
            } else {
                this.logWarn("headerData passed for SOAP header partName: " + partName +
                             ", no schema available, not outputting");
            }
        }
        return output;
    },
    getSoapBody : function (dsRequest, flags) {
        var soapBody = isc.SB.create(),
            service = this.getWebService(dsRequest),
            soapStyle = service.getSoapStyle(dsRequest),
            wsOperation = this.getWSOperation(dsRequest),

            // pass in a "flags" object that already has nsPrefixes, and reuse this flags
            // object to serialize each soap:body part.  This will capture all required
            // namespaces so we can output them as part of the soap:body element.   
            // For readability of the SOAP message, include the explicitly specified 
            // namespace prefixes.
            userPrefixes = this.xmlNamespaces ? isc.makeReverseMap(this.xmlNamespaces) : null,
            flags = isc.addProperties({
                nsPrefixes : isc.addProperties({}, userPrefixes)
            }, flags),

            // A soap:body has exactly one wsdl:message, represented by a DataSource, where each
            // DataSource field represents a wsdl:part of the message.  
            messageSchema = flags.generateResponse ? service.getResponseMessage(wsOperation.name)
                                                   : service.getRequestMessage(wsOperation.name),
            // 1. the soap:body can have multiple parts, either because:
            // - soap:body@parts is unspecified and the message has multiple parts
            // - soap:body@parts is specified and is a list
            // 2. each part can be just a simple type element or a complex element
            // 
            // Relevant spec: http://www.w3.org/TR/wsdl#_soap:body
            // - NOTE: not explicitly covered in the spec above, but based on WSDL4J APIs and
            //   other samples, soap:body@parts can be a space-separated *list* of part names
            //
            // Contrast this with soap:headers:
            // 1. each soap:header can have a different message
            // 2. each soap:header must specify a part
            bodyPartNames = service.getBodyPartNames(wsOperation.name, flags.generateResponse);


        
        isc.Comm.omitXSI = wsOperation.inputEncoding != "encoded";
        var oldXMLSchemaMode = isc.Comm.xmlSchemaMode;
        isc.Comm.xmlSchemaMode = true;

        var indent = "        ";

        if (soapStyle == "rpc") {
            // for RPC-style SOAP, SOAP body's outermost element should be named after the
            // operation and namespaced with the operation namespace 
            soapBody.append(
                "\n", indent, 
                isc.Comm._xmlOpenTag(wsOperation.name, null, 
                                     wsOperation.inputNamespace, "opNS", true), 
                ">"
            );
            indent += "    ";
            // otherwise the message definition as such does not produce outputs, only it's
            // parts do 
        }

        this.logInfo("soap:body parts in use: " + bodyPartNames, "xmlSerialize");

        for (var i = 0; i < bodyPartNames.length; i++) {
            var partName = bodyPartNames[i],
                field = messageSchema.getField(partName);

            // for document-style SOAP, if there is exactly one message part (the most common
            // style by far), use the entirety of the request data for that part.
            // This means that when a message is supposed to look like this:
            //    <login>
            //       <username>bob</username>
            //       <password>mebob</password>
            //    </login>
            // The JS data you need to pass is: 
            //    { username:"bob", password:"mebob" }
            // .. instead of the surprising and less obvious:
            //    { login : { username:"bob", password:"mebob" } }
            // Note that this works in conjunction with webService.getInputDS(), which for a
            // single part message will return the schema of that single part, such that a form
            // bound to that schema will produce the appropriate values to pass as
            // dsRequest.data.
            var data = bodyPartNames.length < 2 && soapStyle == "document" ? 
                            dsRequest.data : (dsRequest.data ? dsRequest.data[partName] : null);

            var partSchema = this.getSchema(field.type, field.xsElementRef ? "element" : null);

            // As with DataSource fields in general, each wsdl:part of a wsdl:message can be simple
            // or complex type
            var partXML;
            if (isc.isA.DataSource(partSchema)) {
                this.logInfo("soap:body part '" + partName + 
                             "' is complex type with schema: " + partSchema, "xmlSerialize");
                partXML = this.getXMLRequestBodyPart(dsRequest, data, partSchema, flags, indent);
            } else {
                this.logInfo("soap:body part '" + partName + 
                             " is of simple type '" + field.type + "'", "xmlSerialize");
                soapBody.append("\r", indent);
                partXML = this._serializeSimpleTypeTag(partName, field, data,
                                                       field.partNamespace, flags);
            }

            soapBody.append(partXML);
        }

        if (soapStyle == "rpc") {
            soapBody.append(
                "\n", "        ", isc.Comm._xmlCloseTag(wsOperation.name,
                                                        wsOperation.inputNamespace, "opNS")
            );
        }

        // restore global XML serialization settings
        isc.Comm.omitXSI = null;
        isc.Comm.xmlSchemaMode = oldXMLSchemaMode;

        return isc.SB.concat("    ", isc.DS._soapBodyStart,
                             this.outputNSPrefixes(flags.nsPrefixes, "        "),
                             ">",
                             soapBody.toString(),
                             "\r    ", isc.DS._soapBodyEnd);
    },
    getSoapEnd : function (dsRequest) {
        // allow centralized overrides of getSoapStart/End via overrides on a WebService object
        var service = this.getWebService(dsRequest);
        if (service.getSoapEnd) return service.getSoapEnd(dsRequest);

        return isc.DataSource._soapEnvelopeEnd;
    },
    
    getSoapStyle : function (dsRequest) {
        if (!this.hasWSDLService(dsRequest)) return "document";
        return this.getWebService(dsRequest).getSoapStyle(this.getWSOperation(dsRequest).name);
    },

    getXMLRequestBodyPart : function (dsRequest, data, schema, flags, indent) {
        flags = isc.addProperties({
            soapStyle : this.getSoapStyle(dsRequest)
        }, flags);

        // a few properties can be set on the operationBinding
        var operationBinding = this.getOperationBinding(dsRequest);
        
        // XXX for multi-part soap:bodies, flags formation is currently being done for every
        // soap:body part if there are multiple parts, but there's no way to affect any of
        // these flags on a per-soap:body part basis.  Factor a getFlags()?

        // if useFlatFields is set, assume flat inbound data to be mapped automatically to
        // hierarchical XML message
        flags.flatData = this._firstNonNull(dsRequest.useFlatFields, 
                                            operationBinding.useFlatFields, 
                                            this.useFlatFields); 
        flags.recursiveFlatFields = this._firstNonNull(dsRequest.recursiveFlatFields,
                                                       operationBinding.recursiveFlatFields, 
                                                       this.recursiveFlatFields); 

        // ability to change the default textContentProperty for one serialization run
        flags.textContentProperty = this._firstNonNull(dsRequest.textContentProperty,
                                                       operationBinding.textContentProperty);

        // serialization of DS metadata: "startRowTag" et al can be set on the operationBinding schema,
        // and that tag will take on the value of dsRequest.startRow
        flags.dsRequest = dsRequest;
        flags.startRowTag = operationBinding.startRowTag || this.startRowTag;
        flags.endRowTag = operationBinding.endRowTag || this.endRowTag;

        // serialize actual data according to schema
        return schema.xmlSerialize(dsRequest.data, flags, indent);
    },

    // Serializing Objects as XML
    // ---------------------------------------------------------------------------------------
    // Overall: we go through declared subelements, where the value of each subelement is the
    // value of the same named property in the object being serialized.  For complexType
    // subelements (described by another DataSource), we recurse.
    // - flatData mode: we assume the inbound structure is an object with properties that hold
    //   values for same-named subelements at various levels in the structure.  This is for
    //   flattening structures that have gratuitous nesting and are reasonably editable in a
    //   single form.
    // - ordering issues: if the XML output should be something like:
    //   <page>
    //      <section ../>
    //      <header ../>
    //      <section ../>
    //   .. where a subelement name appears *twice* or more, we have no object representation
    //   for this.  One possibility here is a marker on a field that indicates it serializes
    //   it's contents without outputting a tag for the fieldName itself (this would be the
    //   same or a related marker to what would cause immediate Canvas-typed subelements to be
    //   automatically binned in Canvas.children by default).

    // NOTE: there are a few reasons why schema is a necessity in XML serialization:
    // - SOAP
    //   - namespace requirements - eg must be able to tell whether an element definition was
    //     declared at top-level in the WSDL file, which means it requires namespacing
    //     (regardless of whether it appears in a given message)
    //   - "encoded" messages where xsi:type attributes are required pervasively - no way to
    //     detect the appropriate type from live JS data
    // - XML Schema (including it's use in SOAP)
    //   - order dependencies - XML schema basically forces you to declare an order even if you
    //     don't want one, and that order must be followed or the message is considered invalid
    // - ISC Widget XML
    //   - type:multiple fields and ValueMaps have custom encoding

    //> @object SerializationContext
    // Flags for XML serialization
    // @treeLocation Client Reference/Data Binding/DataSource
    // @visibility external
    //<
    
    //> @attr serializationContext.useFlatFields (boolean : null : IR)
    // Enables flat serialization mode, as described for +link{dsRequest.useFlatFields}.
    // @visibility external
    //<

    //> @method dataSource.xmlSerialize() [A]
    // Serialize a JavaScript object as XML.
    // <P>
    // The JavaScript Object passed to +link{method:DataSource.xmlSerialize()} becomes an XML
    // element named after the +link{attr:DataSource.tagName} (or +link{attr:DataSource.ID} if
    // tagName is unset).  Each property of the object becomes a subElement.  For example,
    // using a DataSource to serialize like this:
    // <pre>
    //     var inputObject = {
    //        startRow : 5,
    //        endRow : 50,
    //        data : [
    //           { field1 : "value1", field2: new Date() },
    //           { field1 : "value3", field2: null }
    //        ]
    //     };
    //     var myDS = isc.DataSource.create({ tagName:"DSRequest" });
    //     myDS.xmlSerialize(inputObject);
    // </pre>
    // .. produces the following XML:
    // <pre>
    //     &lt;DSRequest&gt;
    //         &lt;startRow&gt;5&lt;/startRow&gt;
    //         &lt;endRow&gt;50&lt;/endRow&gt;
    //         &lt;data&gt;
    //             &lt;field1&gt;value1&lt;/field1&gt;
    //             &lt;field2&gt;2005-10-14T18:01:16&lt;/field2&gt;
    //         &lt;/data&gt;
    //         &lt;data&gt;
    //             &lt;field1&gt;value3&lt;/field1&gt;
    //             &lt;field2&gt;&lt;/field2&gt;
    //         &lt;/data&gt;
    //     &lt;/DSRequest&gt;
    // </pre>
    // <P>
    // If you are working with a WSDL-described web service, XML serialization is performed
    // automatically by APIs like +link{method:WebService.callOperation()} - you only need to
    // know about serialization in order to understand how to put together JavaScript data that
    // will fill in an XML message properly.   
    // <br>
    // <b>Note:</b> when trying to send data to a web service, it is best to avoid putting
    // together any XML yourself, instead modify the JavaScript data being fed to ISC's SOAP
    // engine.  This is because the WSDL and SOAP rules for correctly namespacing and encoding
    // Web Service messages are very complex and are subject to change with new versions of the
    // web service you are contacting, whereas the data itself is easy to manipulate and less
    // likely to change.
    // <br>
    // To troubleshoot message formation, you can set the log category "xmlComm" to 
    // <code>DEBUG</code> level in order to see the XML message formed by SmartClient reported
    // in log statements in the Developer Console.
    //
    // @param data (any) data to be serialized
    // @param flags (SerializationContext) options for the serialization engine
    // @return (String) data as serialized to XML
    //
    // @visibility xmlBinding
    //<
    xmlSerialize : function (data, flags, indent, tagName) {
        if (!flags) flags = {};

        if (flags.useFlatFields) flags.flatData = true;

        // qualifyAll, if set, should cascade to child elements which would not otherwise be
        // namespaced (because they were not declared as top level).  However when we are done
        // with this element, if we enabled qualifyAll we need to turn it back off
        var schemaSet = this.getSchemaSet(),
            enabledQualifyAll = (flags.qualifyAll == null);
        if (schemaSet && schemaSet.qualifyAll) {
            flags.qualifyAll = true;
        }

        
        var topLevel;
        if (flags.nsPrefixes == null) {
            var userPrefixes = this.xmlNamespaces ? isc.makeReverseMap(this.xmlNamespaces) : null;
            flags.nsPrefixes = isc.addProperties({}, userPrefixes);
            topLevel = true;
        }

        
        // enable xmlSchemaMode for any calls to xmlSerialize
        isc.Comm.xmlSchemaMode = true;
        // disable xsi:type unless it's been set explicitly
        var resetOmitXSI;
        if (isc.Comm.omitXSI == null) {
            resetOmitXSI = isc.Comm.omitXSI = true;
        }

        var result = this._xmlSerialize(data, flags, indent, tagName, topLevel);

        // reset qualify all
        if (enabledQualifyAll) flags.qualifyAll = null;

        // restore global xml serialize settings
        var oldXMLSchemaMode = isc.Comm.xmlSchemaMode;
        isc.Comm.xmlSchemaMode = oldXMLSchemaMode;
        if (resetOmitXSI) isc.Comm.omitXSI = null;


        return result;
    },

    _xmlSerialize : function (data, flags, indent, tagName, topLevel) {
        if (isc._traceMarkers) arguments.__this = this;
    
        if (this.logIsDebugEnabled("xmlSerialize")) {
            this.logWarn("schema: " + this + 
                         " serializing: " + this.echo(data) +
                         " with flags: " + this.echo(flags));
        }

        var qualify = this.mustQualify || flags.qualifyAll;

        
        var dataClassName;
        if (data != null && (data._constructor || isc.isAn.Instance(data))) {
            var dataClassName = isc.isAn.Instance(data) ? data.Class : data._constructor;
        }

        // if it's an instance, also trim it down to serializeable fields
        
        if (isc.isAn.Instance(data)) data = data.getSerializeableFields();

        // if we're passed an atomic value like a String, we definitely don't want to iterate
        // down a String's properties and pick up functions like "startsWith", the best we can
        // do is return the String inside our tags
        if (isc.DS.isSimpleTypeValue(data)) {
            this.logDebug("simple type value: " + this.echoLeaf(data) + 
                          " passed to xmlSerialize on " + this, "xmlSerialize");
            return isc.Comm._xmlSerialize(tagName ||  this.tagName || this.ID, data);
        }

        if (isc.isAn.Array(data) && !this.canBeArrayValued) return this.map("xmlSerialize", data, flags, indent).join("\n");

        var output = isc.SB.create(),
            tagName = tagName || this.tagName || this.ID,
            indent = indent || "";

        output.append("\r", indent);

        var schemaNamespace;
        if (qualify) {
            //this.logWarn("schema: " + this + " parentNS: " + flags.parentSchemaNamespace);
            // XML Schema namespacing rules: if a subelement declares its structure via a "ref"
            // attribute pointing to another *Element* definition, the namespace of the
            // referenced element must be used.  If the subelement declares its structure via a
            // "type" attribute, the namespace of the parent element must be used.
            schemaNamespace = (this.isA("XSComplexType") ? flags.parentSchemaNamespace : null) 
                                    || this.schemaNamespace;
        }

        // leave the tag open..  
        output.append(
            isc.Comm._xmlOpenTag(tagName, this.ID, schemaNamespace,
                                 flags.nsPrefixes, true)
        );

        // serialize attributes, if any.  Note only a field declared as an attribute
        // (field.xmlAttribute="true") ever becomes an attribute - undeclared data becomes
        // subelements
        data = this.serializeAttributes(data, output, flags);
        //this.logWarn("after serialize attributes, data is: " + this.echo(data));

        // if serializing an instance, save the actual class as "constructor" if it differs
        // from the schema we're using for serialization
        if (dataClassName && tagName != dataClassName) {            
            output.append(" constructor=\"", dataClassName, "\"");
        }

        var subElements;
        if (data != null) {
            subElements = this.xmlSerializeFields(data, flags, indent+"    ");
        }

        // if this is the top-level element, write out all the namespace prefixes encountered
        // during serialization
        if (topLevel) {
            output.append(this.outputNSPrefixes(flags.nsPrefixes, indent+"     "));
        }

        // NOTE: one time flag to prevent trailing ident, for use eg if there is text content
        var suppressIndent = this._suppressIndent;
        this._suppressIndent = null;

        // use a short tag if possible
        if (subElements == null || isc.isAn.emptyString(subElements)) {
            output.append("/>");
            return output.toString();
        }

        output.append(">", subElements, 
                      // NOTE: one time flag to prevent if there is text content, don't add whitespace/newline inside tag
                      (suppressIndent ? "" : "\r" + indent));
        
        output.append(isc.Comm._xmlCloseTag(tagName, schemaNamespace, flags.nsPrefixes));

        return output.toString();
    },

    outputNSPrefixes : function (prefixes, indent) {
        delete prefixes._nsCount;
        prefixes = isc.makeReverseMap(prefixes);
        var nsDefs = isc.xml._generateNamespaces(prefixes, null, indent+"        ");
        return nsDefs;
    },

    serializeAttributes : function (data, output, flags) {
        var fieldNames = this.getFieldNames(),
            originalData = true;
        
        for (var i = 0; i < fieldNames.length; i++) {
            var fieldName = fieldNames[i],
                field = this.getField(fieldName);
            if (field.xmlAttribute && ((data && data[fieldName] != null) || field.xmlRequired)) {
                // if we run into attributes, shallow copy the data so we can remove already
                // serialized fields without affecting the data the developer passed to
                // xmlSerialize()
                if (originalData) {
                    data = isc.addProperties({}, data);
                    originalData = false;
                }

                var value = data[fieldName];
                if (flags && flags.spoofData) value = this.getSpoofedData(field);

                output.append(" ", fieldName, "=\"", 
                        this._serializeSimpleTypeValue(field, value), 
                        "\"");
                delete data[fieldName]
            }
        }
        return data; // return the (possibly copied) data
    },

    xmlSerializeFields : function (data, flags, indent) {
        var output = isc.SB.create(),
            flags = flags || isc.emptyObject,
            flatData = flags.flatData,
            spoofData = flags.spoofData,
            indent = indent || "";

        // output each known field *in order*
        var data = isc.addProperties({}, data), // copy data so we can delete known fields
            fields = this.getFields();
        for (var fieldName in fields) {
            var field = this.getField(fieldName),
                value = data[fieldName],
                    
                fieldIsComplex = this.fieldIsComplexType(fieldName);

            var childData = data[fieldName];

            if (flags.startRowTag == field.name && childData == null) {
                childData = flags.dsRequest ? flags.dsRequest.startRow : null;
            } else if (flags.endRowTag == field.name && childData == null) {
                childData = flags.dsRequest ? flags.dsRequest.endRow : null;

            // flatData mode: we assume the inbound data is an object with properties
            // that hold values for same-named subelements at various levels in the
            // structure.  This is for flattening structures that have gratuitous nesting
            // and are reasonably editable in a single form.
            // Note that even with flatData=true, "data" may have nested objects, intended
            // as data for a same-named complexType subelement, so flatData amounts to always
            // passing data to child elements of complexType
            } else if (fieldIsComplex && flatData && childData == null) {
                childData = data;
            }
    
            //if (this.logIsDebugEnabled("xmlSerialize")) {
            //    this.logDebug("for field: '" + fieldName + 
            //                 "' serializing data: " + this.echo(childData), "xmlSerialize");
            //}

            // NOTE: the xml notion of required is just that an element needs to be there - not
            // that it has to be non-empty
            var mustOutput = (field.xmlRequired && !field.xmlAttribute) || 
                                (data[fieldName] != null || (spoofData && !field.xmlAttribute));

            if (flatData && fieldIsComplex) {
                // HACK: for flatData, if a tag is not marked required, we can't easily
                // tell whether there will be output since subobjects may produce output if
                // the data happens to intersect with some simpleType field at any level of
                // nesting, so we just try serializing and throw the result away if there's
                // nothing
                var tagSchema = this.getSchema(field.type),
                    // HACK: this serialization run doesn't produce output, so disable caching
                    // of NS prefixes
                    origPrefixes = isc.clone(flags.nsPrefixes),
                    fieldsOutput = tagSchema.xmlSerializeFields(childData, flags);
                //this.logWarn("fieldName: '" + fieldName + 
                //             "', mustOutput before flatData check: " + mustOutput + 
                //             ", fieldsOutput: " + this.echoLeaf(fieldsOutput));
                if (fieldsOutput != null && !isc.isAn.emptyString(fieldsOutput)) {
                    mustOutput = true;
                }
                flags.nsPrefixes = origPrefixes;
            }

            if (mustOutput) {
                
                if (flatData && fieldIsComplex && 
                    // non-simpleType data is provided
                    data[fieldName] != null && !isc.DS.isSimpleTypeValue(data[fieldName]) &&
                    !flags.recursiveFlatFields) 
                {
                    // NOTE: we intentionally addProperties() rather than clone() here, because
                    // we do want flags.nsPrefixes to have any additional nsPrefixes added to
                    // it
                    flags = isc.addProperties({}, flags);
                    flags.flatData = false;
                }
                output.append(this.xmlSerializeField(fieldName, childData, flags, indent));
            }
            // in flatData mode, we don't delete fields that we've output, because we don't
            // write out undeclared data at the end
            if (!flatData && data[fieldName] != null) delete data[fieldName];
        }

        // if there's any data left, tack them on the end
        if (!flatData) {
            for (var fieldName in data) {
                output.append(this.xmlSerializeField(fieldName, data[fieldName], flags, indent));
            }
        }

        return output.toString();
    },

    _$Action:"Action",
    xmlSerializeField : function (fieldName, value, flags, indent) {
        var output = isc.SB.create(),
            field = this.getField(fieldName);

        // skip undeclared, generated properties
        if (field == null && (fieldName.startsWith("_") || fieldName.startsWith("$"))) return;

        var fieldType = (field ? field.type : null),
            flatData = flags && flags.flatData,
            spoofData = flags && flags.spoofData,
            indent = indent || "";

        if (spoofData) value = this.getSpoofedData(field);
    
        if (this.logIsDebugEnabled("xmlSerialize")) {
            this.logDebug("serializing fieldName: " + fieldName + 
                          " with type: " + fieldType + 
                          " with value: " + this.echo(value));
        }

        // namespace the element if either everything must be qualifed or this particular field
        // is declared and must be qualified
        var namespace = ((field && field.mustQualify) || flags.qualifyAll ? 
                         this.getSchemaSet().schemaNamespace : null);

        // if this field matches the textContentProperty, and either a textContent field has
        // been declared or there are no elements, return the value of the textContentProperty
        // with no surrounding tag and no indent.
        // NOTE: this handling appears here so that it works with flatData and spoofData 
        var textContentProperty = flags.textContentProperty || this.textContentProperty,
            textContentField = this.getTextContentField();

        if (fieldName == textContentProperty && 
            (textContentField != null || !this.hasXMLElementFields(textContentProperty))) 
        {
            // one time flag prevents normal whitespace/indent from being added
            this._suppressIndent = true;
            return this._serializeSimpleTypeValue(textContentField, value);
        }

        // special case for "Action"s - get the iscAction we stored on the function object
        if (fieldType == this._$Action && value != null) {
            if (value.iscAction) {
                value = value.iscAction
            // sanity check for StringMethods (may not be necessary since addMethods() / 
            // addProperties() should have converted StringMethods to functions with iscAction 
            // stored on them
            } else if (isc.isA.StringMethod(value)) {
                value = value.value;                
            }
        }

        var fieldStart = isc.Comm._xmlOpenTag(fieldName, field ? field.type : null, 
                                              namespace, flags.nsPrefixes),
            fieldEnd = isc.Comm._xmlCloseTag(fieldName, namespace, flags.nsPrefixes);

        //this.logWarn("schemaSet is: " + this.echo(schemaSet) + ", fieldStart: " + fieldStart);

        var values = isc.isAn.Array(value) ? value : [value];
        

        // for a DataSource type, ask the DataSource to serialize the value
        if (this.fieldIsComplexType(fieldName)) {
            var oldPSN = flags.parentSchemaNamespace;
            flags.parentSchemaNamespace = this.schemaNamespace;
            //if (field && field.xsElementRef) this.logWarn("looking up *element* only: " + fieldType);
    
            var ds = this.getSchema(fieldType, field && field.xsElementRef ? "element" : null);
            //this.logWarn("complexType field: " + fieldName + 
            //             " with schema: " + ds +
            //             " has value: " + this.echo(value));

            if (field.multiple) {
                // if this is a field declaration with multiple=true, we write out a
                // container tag containing one or more tags for the values, where the values
                // have the typeName, eg
                //      <children> // container tag: fieldName
                //          <Canvas> // value tag: field dataSource
                //          </Canvas>
                //          <Canvas> 
                //          </Canvas>
                //      </children>
                output.append("\r", indent, fieldStart);
                for (var i = 0; i < values.length; i++) {
                    output.append(ds.xmlSerialize(values[i], flags, indent+"    ", 
                                                  // allow the field to specify a name for 
                                                  // child tags, eg, ds.fields -> "field"
                                                  field.childTagName));
                }
                output.append("\r", indent, fieldEnd);

            } else if (ds.canBeArrayValued && isc.isAn.Array(value)) {
                // very special case for the valueMap type, which when it appears as a simple
                // JS Array, shouldn't be considered multiple valueMaps.

                output.append(ds.xmlSerialize(value, flags, indent, fieldName));
            } else {
                // if this is a field that isn't declared multiple but has multiple values,
                // we write out one or more tags named after the field name since that's the
                // inbound format that would produce an array in a field not declared
                // multiple
                for (var i = 0; i < values.length; i++) {
                    if (values[i] == null) { // null = empty tag
                        output.append("\r", indent)
                        output.append(fieldStart, fieldEnd);
                    // handle being unexpectedly passed a simple type.  If we're serializing a
                    // SOAP message, the resulting XML isn't going to adhere to the schema, but
                    // there's nothing we can do.
                    } else if (isc.DS.isSimpleTypeValue(values[i])) {
                        this.logWarn("simple type value " + this.echoLeaf(values[i]) + 
                                     " passed to complex field '" + field.name + "'",
                                     "xmlSerialize");
                        output.append("\r", indent)
                        output.append(isc.Comm.xmlSerialize(fieldName, values[i]));
                    } else {
                        output.append(ds.xmlSerialize(values[i], flags, indent, fieldName));
                    }
                }
            }
            flags.parentSchemaNamespace = oldPSN;

        // declared field of simple type
        } else if (field != null) {

            if (field.multiple) {
                output.append("\r", indent, fieldStart, "\r");
                for (var i = 0; i < values.length; i++) {
                    // pass null indicating no particular fieldName is needed
                    output.append(
                         this._serializeSimpleTypeTag(null, field,
                                                      values[i], namespace, flags),
                         "\r", indent);
                }
                output.append("\r", indent, fieldEnd, "\r");
            } else {
                for (var i = 0; i < values.length; i++) {
                    output.append(
                        "\r", indent, 
                        this._serializeSimpleTypeTag(fieldName, field,
                                                       values[i], namespace, flags));
                }
            }

        // undeclared field, simple or complexType
        } else {
            //this.logWarn("serializing values for undeclared field: " + fieldName + 
            //             ", values: " + this.echoAll(values));
            for (var i = 0; i < values.length; i++) {
                if (values[i] == null || isc.isAn.emptyObject(values[i])) {
                    output.append("\r", indent, fieldStart, fieldEnd);
                } else {
                    output.append("\r", indent, 
                                 isc.Comm._xmlSerialize(fieldName, values[i], indent,
                                                        { isRoot:false }));
                }
            }
        }

        return output.toString();
    },

    
    _serializeSimpleTypeTag : function (fieldName, field, value, namespace, flags) {
        // NOTE: fieldName is passed as "null" for multiple:true fields, indicating use the
        // generic "value" for simple values, and let Comm.xmlSerialize pick a name if an
        // Object has been (erroneously) passed to a simple type field.  Comm.xmlSerialize will
        // use the Object's type as a tag name, defaulting to the generic "Object"

        var type = field.type,
            flags = flags || {};

        
        if (isc.isAn.Object(value) && !isc.isA.Function(value._xmlSerialize)) {
            return isc.Comm.xmlSerialize(fieldName || null, value);
        } else {
            
            var type = this._getXMLSchemaType(type);

            // if the value is null and the field is nillable, send an empty element
            // (<element/>) with xsi:nil=true rather than an element with empty content
            // (<element></element>).  Note that this distinction is key for eg boolean or
            // other restricted types, where empty content is actually a bad value.
            if (value == null && field.nillable) {
                var tagName = fieldName || "value";
                return isc.Comm._xmlOpenTag(tagName, null, namespace, flags.nsPrefixes, true)
                        + " xsi:nil=\"true\"/>";
            }

            if (isc.isA.Date(value)) {
                // per XML Schema spec, type == "date" omits the time whereas
                // type == "datetime" shows it.
                value = value.toSchemaDate(field.type == "date");
            } else if (value != null && value._xmlSerialize) {
                return value._xmlSerialize(fieldName, type, namespace); 
            } else {
                // makeXMLSafe covers String, null (as empty string), Number and Boolean
                value = isc.makeXMLSafe(value);
            }
            return isc.Comm._xmlValue(fieldName || "value", value, type, namespace,
                                      flags.nsPrefixes);
        }
    },

    // serialize a simple type value without surrounding tags, for use in attributes and for
    // textContent fields.
    // If value is not actually of simple type, toString() is called on it (best we can do in a
    // context where we are not allowed to generate elements).
    // Pseudo-bug: the internal _xmlSerialize override is factored incorrectly because it
    // always returns a tag, so it cannot be called for an attribute value.
    _serializeSimpleTypeValue : function (field, value) {
        if (isc.isA.Date(value)) {
            return value.toSchemaDate(field && field.type == "date");
        } else {
            return isc.makeXMLSafe(value);
        }
    },

    // translate dataSource field types to their XML Schema equivalents, where we have synonyms
    _getXMLSchemaType : function (type) {
        switch (type) {
            case "integer":
                return "int";
            case "number" :
                return "long";
            default:
                return type;
        }
    },

    xmlSerializeSample : function () {
        return this.xmlSerialize({}, { spoofData:true });
    },

    getSpoofedData : function (field) {
        if (!field) return "textValue";

        // return an object for object-type fields (to avoid following pathway of simpleType
        // passed to complexType field)
        if (this.getSchema(field.type) != null) return {};

        // return arrays for multiple fields 
        if (field.multiple) {
            field = { type : field.type };
            return [this.getSpoofedData(field), this.getSpoofedData(field)];
        }

        // for valueMapped fields, return a value at random
        if (field.valueMap) {
            var values = !isc.isAn.Array(field.valueMap) ? 
                    isc.getKeys(field.valueMap) : field.valueMap;
            return values[Math.round(Math.random() * (values.length-1))];
        }

        // return various simpleType values
        var baseType = isc.SimpleType.getBaseType(field.type);
        switch (baseType) {
            case "boolean" :
                return (Math.random() > 0.5);
            case "integer" :
            case "int" :
            case "number" :
                var min = 0, max = 10;
                if (field.validators) {
                    var rangeValidator = field.validators.find("type", "integerRange");
                    if (rangeValidator) {
                        this.logWarn(field.name + " has " + 
                                     rangeValidator.type + " validator " + 
                                     " with min " + rangeValidator.min + 
                                     " and max " + rangeValidator.max);
                        min = rangeValidator.min || 0;
                        // NOTE: this means if max is < 0 we always pick it exactly
                        max = rangeValidator.max || Math.min(min, 10);
                        if (min > max) min = max;
                    }
                }
                return Math.round(min + (Math.random() * (max-min)));
            case "float" :
            case "decimal" :
            case "double" :
                var min = 0, max = 10, precision = 2;
                if (field.validators) {
                    var rangeValidator = field.validators.find("type", "floatRange");
                    if (rangeValidator) {
                        this.logWarn(field.name + " has " + 
                                     rangeValidator.type + " validator " + 
                                     " with min " + rangeValidator.min + 
                                     " and max " + rangeValidator.max);
                        min = rangeValidator.min || 0;
                        // NOTE: this means if max is < 0 we always pick it exactly
                        max = rangeValidator.max || Math.min(min, 10);
                        if (min > max) min = max;
                    }
                    var precisionValidator = field.validators.find("type", "floatPrecision");
                    if (precisionValidator) {
                        precision = precisionValidator.precision || 2;
                    }
                }
                return (min + (Math.random() * (max-min))).toFixed(precision);
            case "date" :
            case "time" :
            case "datetime" :
                var date = new Date();
                if (field.validators) {
                    var rangeValidator = field.validators.find("type", "dateRange");
                    if (rangeValidator) {
                        this.logWarn(field.name + " has " + 
                                     rangeValidator.type + " validator " + 
                                     " with min " + rangeValidator.min + 
                                     " and max " + rangeValidator.max);
                        // NOTE: picking a random date between min and max would require at
                        // least zeroing out either time or date values for pure date or pure
                        // time value fields
                        if (rangeValidator.min) date = rangeValidator.min;
                        else if (rangeValidator.max) date = rangeValidator.max;
                    }
                }
                return date;
            default:
                
                return "textValue";
        }
    },


    //>EditMode
    // extract saveable data from a live DataSource
	getSerializeableFields : function (removeFields, keepFields) {
	    var props = this.Super("getSerializeableFields", arguments);

        var fields = props.fields;
        // switch back from Map to Array
        fields = isc.getValues(fields);
        // remove type-based validators automatically inserted into validators Array
        for (var i = 0; i < fields.length; i++) {
            var field = fields[i] = isc.addProperties({}, fields[i]);
            var validators = field.validators;
            if (validators) {
                field.validators = validators.findAll("_generated", null);
                if (field.validators == null) delete field.validators;
            }
        }
        props.fields = fields;
        
        return props;
    },
    //<EditMode

    // XML Response handling
    // ---------------------------------------------------------------------------------------

    // take the XML response from a web service and ask the DataSource to provide an Array of
    // XMLElements from it
    _handleXMLReply : function (xmlDoc, xmlText, rpcResponse, rpcRequest) {
    
        var xmlData = xmlDoc,
            dsRequest = rpcRequest._dsRequest,
            operationBinding = this.getOperationBinding(dsRequest),
            opNamespaces;
            
        // Don't try to handle the response unless it's valid
        if (rpcResponse.status < 0) {
            this._completeResponseProcessing(xmlText, {status: -1}, dsRequest, 
                                               rpcResponse, rpcRequest);
            return;
        }

        // add namespaces to the xmlDoc to make subsequent selection easier
        if (xmlData) {
            if (operationBinding.wsOperation) {
                var service = this.getWebService(dsRequest),
                    opNamespaces = service.getOutputNamespaces(operationBinding.wsOperation);
                xmlData.addNamespaces(opNamespaces);
            }
            xmlData.addNamespaces(this.xmlNamespaces);
            xmlData.addNamespaces(operationBinding.xmlNamespaces);
        }

        // Ensure the full set of defined namespaces is available to all xPaths
        // executed during dsResponseFromXML.  Currently we associate all namespaces with the
        // XMLDoc, which means they'll be available for selectNodes() called directly with the
        // xmlDoc, but not for selectNodes() relative to an element (eg valueXPath).
        // To fix this pervasively such that any call to selectNodes() with an element works,
        // we should either tag or wrap all native XMLElements returned from selectNodes() so
        // that we always find the right set of namespaces.
        var xmlNamespaces = isc.addProperties({}, opNamespaces, 
                                               this.xmlNamespaces,
                                               operationBinding.xmlNamespaces);
                                               
        // NOTE: it's key to pass the dsRequest to dsResponseToXML since among other things
        // custom message formats may have the server just return a range of rows without
        // reminding the client what the range is
        // dsResponseFromXML can be asynchronous (depending on resultBatchSize)
        this.dsResponseFromXML(xmlData, dsRequest, xmlNamespaces, 
                                {target:this, methodName:"_completeHandleXMLReply",
                                    xmlData:xmlData, dsRequest:dsRequest,
                                    rpcRequest:rpcRequest, rpcResponse:rpcResponse
                                }
        ); 
        
    },
    
    _completeHandleXMLReply : function (dsResponse, callback) {

        this._completeResponseProcessing(callback.xmlData, dsResponse, callback.dsRequest, 
                                                  callback.rpcResponse, callback.rpcRequest);
    },

    dsResponseFromXML : function (xmlData, dsRequest, xmlNamespaces, callback) {
        if (xmlData) {
            this.selectRecords(
                xmlData, dsRequest, 
                {target:this, methodName:"_completeDSResponseFromXML", dsRequest:dsRequest,
                 callback:callback, xmlData:xmlData, xmlNamespaces:xmlNamespaces}
            );
        } else {
            this._completeDSResponseFromXML([], dsRequest, xmlNamespaces, callback);
        }
    },
    
    _completeDSResponseFromXML : function (data, dsRequest, xmlNamespaces, callback) {
        
        // handle the case where this is fired asynchronously as a callback - 
        // pick up the dsRequest from the 2nd arguments (the callback object)
        if (!callback && dsRequest.callback) callback = dsRequest.callback;
        if (dsRequest.xmlNamespaces) xmlNamespaces = dsRequest.xmlNamespaces;
        if (dsRequest.dsRequest) dsRequest = dsRequest.dsRequest;
        
        if (xmlNamespaces == null) xmlNamespaces = this.xmlNamespaces;
        
        // default startRow as matching what was requested
        var dsResponse = { 
            data : data,
            startRow: dsRequest.startRow || 0,
            status : 0
        };
        dsResponse.endRow = dsResponse.startRow + Math.max(0, data.length-1);
        // assume dataset is complete by default
        dsResponse.totalRows = Math.max(dsResponse.endRow, data.length);
        var xmlData = callback.xmlData;
        if (!xmlData) return dsResponse;

        if (this.totalRowsXPath) {
            dsResponse.totalRows = 
                isc.xml.selectNumber(xmlData, this.totalRowsXPath, xmlNamespaces, true);
        }
        if (this.startRowXPath) {
            dsResponse.startRow = 
                isc.xml.selectNumber(xmlData, this.startRowXPath, xmlNamespaces, true);
            dsResponse.endRow = dsResponse.startRow + Math.max(0, data.length-1);
        }
        if (this.endRowXPath) {
            dsResponse.endRow = 
                isc.xml.selectNumber(xmlData, this.endRowXPath, xmlNamespaces, true);
            // if there's no XPath specified for the startRow, derive it from endRow - number
            // of records returned
            if (!this.startRowXPath) {
                dsResponse.startRow = dsResponse.endRow - Math.max(0, data.length-1);
            }
        }

        // an XPath is unlikely to be able to really translate 3rd party error codes to ISC
        // error codes, but might allow a first cut of error vs no error
        if (this.statusXPath) {
            dsResponse.status = parseInt(
                isc.xml.selectScalar(xmlData, this.statusXPath, xmlNamespaces, true));
        }
        if (this.errorSchema) {
            dsResponse.errors = this.errorSchema.selectRecords(xmlData, dsRequest);
        }

        if (callback) this.fireCallback(callback, "dsResponse", [dsResponse, callback])
        return dsResponse;
    },

    
    
    //>@attr dataSource.resultBatchSize (int : 150 : IRWA)
    // Very advanced: for servers that do not support paging, and must return large numbers of XML
    // records in one HTTP response, SmartClient breaks up the processing of the response
    // in order to avoid the "script running slowly" dialog appearing for an end user.
    // <P>
    // If you have a relatively small number of records with a great deal of properties or
    // subojects on each record, and you have not set +link{dropExtraFields} to eliminate unused
    // data, and you see the "script running slowly" dialog, you may need to set this number
    // lower.
    // @visibility external
    //<
    
    resultBatchSize:150,
    
    // extract records from an XML document using the recordXPath, and transform to JS using
    // the schema
    // @visibility xmlBinding
    selectRecords : function (xmlData, dsRequest, callback) {
        var elements = this.selectRecordElements(xmlData, dsRequest);
        var operationBinding = this.getOperationBinding(dsRequest),
            schema = this.getSchema(operationBinding.responseDataSchema) || this;
        return schema.recordsFromXML(elements, callback);
    },
    
    //> @method dataSource.recordsFromXML() [A]
    // Transform a list of XML elements to DataSource records.
    // <P>
    // <code>recordsFromXML()</code> will return a List of DataSource records in the form of
    // JavaScript objects.  The value for each field is extracted from the XML according to the
    // rules described under +link{attr:DataSourceField.valueXPath}. 
    // <P>
    // Derived JavaScript values for each field will be the appropriate JavaScript type, eg,
    // for a field of "date" type, the JS value will be a JavaScript Date object.
    // 
    // @param elements (List of XMLElement) XML elements to transform, eg, the result of a
    //                                       call to +link{XMLTools.selectNodes()}
    // @return (List) List of DataSource records derived from the XML elements
    // @visibility xmlBinding
    //<
    recordsFromXML : function (elements, callback) {
        
        // handle being passed a single element, or a native nodeList (as returned by natively
        // calling selectNodes)
        if (!isc.isAn.Array(elements)) {
            // XML elements have no length attribute, but NodeLists do
            if (elements.length != null) elements = isc.xml._nodeListToArray(elements);
            // assume a single XML element
            else elements = [elements];
        }

        if (this.transformResponseToJS) {
            if (elements.length > this.resultBatchSize) {                
                var fromXMLContext = {startingRow:0, callback:callback, elements:elements};
                return this._asyncRecordsFromXML(fromXMLContext);
                
            } 
            
            var attrMask = this.dropExtraFields ? this.getFieldNames() : null;
            
            elements = isc.xml.toJS(elements, attrMask, this);
            if (this.logIsDebugEnabled("xmlBinding")) {
                this.logDebug("transformed response: " + isc.Comm.serialize(elements, true) +
                              "xmlBinding");
            }
        }         
        
        if (callback) {
            this.fireCallback(callback, "records", [elements, callback]);
        }
        return elements;
    },
    
    _asyncRecordsFromXML : function (context) {
        
        var elements = context.elements, 
            startingRow = context.startingRow,
            callback = context.callback,
            endRow = Math.min(elements.length, startingRow + this.resultBatchSize),
            attrMask = this.dropExtraFields ? this.getFieldNames() : null;

        if (!context._recordsFromXML) {
            context._recordsFromXML = isc.xml.toJS(
                                        elements.slice(startingRow, endRow+1), attrMask, this);
        } else {
            var records = isc.xml.toJS(elements.slice(startingRow, endRow+1), attrMask, this);
            context._recordsFromXML.addList(records);
        }
        if (endRow < elements.length) {
            context.startingRow = endRow + 1;
            this.delayCall("_asyncRecordsFromXML", [context]);
        } else if (callback) {
            this.fireCallback(callback, "records", [context._recordsFromXML, callback]);
        }
    },

    // given xmlData return by a web service, return an Array of XML elements to be used as a
    // recordSet
    selectRecordElements : function (xmlData, dsRequest) {
        if (isc.isA.String(xmlData)) xmlData = isc.xml.parseXML(xmlData);
        

        // get the XPath or tagName to use to select record elements from the operationBinding
        var operationBinding = this.getOperationBinding(dsRequest);

        // precedence order for selecting records: opBinding.recordXPath, opBinding.recordName, 
        //                                         dataSource.recordXPath, dataSource.recordName
        // Slightly tricky because operationBinding defaults to the DataSource itself when
        // there is no operationBinding for the operation.
        var opXPath = operationBinding == this ? null : operationBinding.recordXPath, 
            opRecordName = operationBinding == this ? null : operationBinding.recordName,
            dsXPath = this.recordXPath,
            dsRecordName = this.recordName;

        // if we have a recordName and a WSDL service definition, and there is no overriding
        // recordXPath definition, use the WebService to select the records by type.
        if (opXPath == null && 
            (opRecordName != null || (dsXPath == null && dsRecordName != null)) && 
            this.hasWSDLService(dsRequest)) 
        {
            // if we have a WebService, allow the recordName to be used as a way of
            // auto-generating the recordXPath
            var service = this.getWebService(dsRequest);

            return service.selectByType(xmlData, 
                                        operationBinding.wsOperation || this.wsOperation,
                                        opRecordName || dsRecordName);
        }

        // use a recordXPath if specified, otherwise use recordName to do just a simple
        // getElementsByTagName
        var recordXPath = opXPath || dsXPath,
            elements;
        if (recordXPath) {
            elements = isc.xml.selectNodes(xmlData, recordXPath, this.xmlNamespaces);
            this.logDebug("applying XPath: " + recordXPath + 
                          (this.xmlNamespaces ? 
                           " with namespaces: " + this.echo(this.xmlNamespaces) : "") +
                          " got " + elements.length + " elements", "xmlBinding");
        } else {
            elements = [];
            var recordName = opRecordName || dsRecordName || this.ID;
            // NOTE: a tagName of "record" matches <foo:record> in Moz, but NOT in IE
            var nodeList = xmlData.getElementsByTagName(recordName);
            for (var i = 0; i < nodeList.length; i++) elements.add(nodeList[i]);
            this.logDebug("getting elements of tag name: " + recordName +
                          " got " + elements.length + " elements", "xmlBinding");
        }

        return elements;
    },

    // Common XML / JSON Response handling
    // ---------------------------------------------------------------------------------------
    
    _completeResponseProcessing : function (data, dsResponse, dsRequest,
                                                  rpcResponse, rpcRequest) 
    {
        // note for "clientCustom" operations this method is fired directly from
        // processResponse() and rpcResponse / rpcRequest will be null
        if (rpcResponse != null && rpcRequest != null) {
            // make the httpResponseCode available on dsResponse - needed for REST implementations
            dsResponse.httpResponseCode = rpcResponse.httpResponseCode;
            // grab the transactionNum - needed for relogin via resubmitTransaction()
            dsResponse.transactionNum = rpcResponse.transactionNum;
            // place the clientContext on the response
            dsResponse.clientContext = rpcRequest.clientContext;
        }

        if (this.logIsInfoEnabled("xmlBinding")) {
            this.logInfo("dsResponse is: " + this.echo(dsResponse), "xmlBinding");
        }

        
        dsResponse.context = rpcRequest; 

        // allow customization 
        var modifiedResponse = this.transformResponse(dsResponse, dsRequest, data);
        // handle failing to return the response - assume it's been modified in place
        dsResponse = modifiedResponse || dsResponse;
        // convert startRow, endRow and totalRows from string to integer if necessary
        dsResponse.startRow = this._parseNumber(dsResponse.startRow);
        dsResponse.endRow = this._parseNumber(dsResponse.endRow);
        dsResponse.totalRows = this._parseNumber(dsResponse.totalRows);

        if (dsResponse.status >= 0) {
            // on success, notify ResultSets
            isc.DataSource.handleUpdate(dsResponse, dsRequest);
        } else if (!dsRequest.willHandleError) {
            isc.RPCManager._handleError(dsResponse, dsRequest);
        }

        // fire callbacks:
                        // passed directly to a DataSource method, eg ds.fetchData()
        var callbacks = [dsRequest._dsCallback, 
                        // secondary convenience callback, see ActionMethods::buildRequest()
                         dsRequest.afterFlowCallback],
            firedCallbacks = [];
            
        for (var i = 0; i < callbacks.length; i++) {

            var callback = callbacks[i];

            // paranoid duplicate callback check
            if (firedCallbacks.contains(callback)) {
                this.logWarn("Suppressed duplicate callback: " + callback);
                continue;
            }
            
            var callbackResult = this.fireCallback(callback, "dsResponse,data,dsRequest", 
                                                    [dsResponse,dsResponse.data,dsRequest]);
            
                                                        
			// the primary callback, which completes the basic dataSource flow, can stop
            // further processing by returning false.  This is intended to allow flow code to
            // signal fundamental errors that high-level user code isn't expected to handle.
			if (rpcRequest && rpcRequest.willHandleError && callbackResult === false) {
				//>DEBUG
				this.logDebug("performOperationReply: Further processing cancelled by callback");
				//<DEBUG
				break;
			}

            // If transaction has been suspended, stop processing callbacks
            // Can happen on EG login failure
            
            if (rpcResponse) {
                var transaction = isc.RPCManager.getTransaction(rpcResponse.transactionNum);            
                if (transaction && transaction.suspended) return;
            }
		}

    },

    // if argument is a string, try parsing it as a number and return parsed value as long as
    // it's not NaN
    _parseNumber : function (number) {
        if (number == null || !isc.isA.String(number)) return number;
        var parsedNum = parseInt(number);
        if (isNaN(parsedNum)) return number;
        else return parsedNum;
    },
    
    //> @method dataSource.transformResponse() [A]
    // Modify the DSResponse object derived from the response returned from the 
    // +link{dataSource.dataURL,dataURL}.
    // <P>
    // This is an override point that makes it possible to use DataSource features such as
    // paging with web services that support such features, by allowing you to fill in metadata
    // fields in the DSResponse object (such as +link{attr:DSResponse.startRow}) based on
    // service-specific metadata fields contained in the service's response.
    // <P>
    // The DSResponse passed to this method already has +link{attr:dsResponse.data}, which is
    // derived differently depending on the +link{dataSource.dataFormat,dataFormat} setting:
    // <ul>
    // <li> <code>dataFormat:"xml"</code> : either the
    // +link{attr:operationBinding.recordXPath,recordXPath} or 
    // +link{attr:operationBinding.recordName,recordName} is used to select the XML elements
    // that represent DataSource records.  The selected XML elements are passed to
    // +link{method:DataSource.recordsFromXML()}, which transforms the XML elements to typed
    // JavaScript data using the DataSource as a schema.
    // <li> <code>dataFormat:"json"</code> : the
    // +link{attr:operationBinding.recordXPath,recordXPath}, if specified, is used to select
    // records from the returned JSON data via +link{XMLTools.selectObjects()}.  
    // +link{DataSourceField.valueXPath} is used to derive correctly typed field values.
    // <li> <code>dataFormat:"custom"</code> : <code>dsResponse.data</code> is the raw response
    // in String form.  It must be parsed into an Array of Objects for subsequent processing to
    // work.
    // </ul> 
    // <P>
    // In addition to <code>dsResponse.data</code>, +link{attr:dsResponse.status} is defaulted
    // to 0 (indicating no error), and +link{attr:dsResponse.startRow} is assumed to be zero,
    // with +link{attr:dsResponse.endRow,endRow} and +link{attr:dsResponse.totalRows,totalRows}
    // both set to <code>dsResponse.data.length - 1</code>, that is, the returned data is
    // assumed to be all records that matched the filter criteria.
    // <P>
    // Examples of using this API include:
    // <ul>
    // <li> setting +link{attr:dsResponse.startRow,startRow}, 
    //      +link{attr:dsResponse.endRow,endRow} and +link{attr:dsResponse.totalRows,totalRows}
    //      to allow paging for a service that supports it.  For example, if an XML service
    //      returns a "resultRow" tag that contained the row number of the first row of the
    //      returned results:<pre>
    //    dsResponse.startRow = 
    //        isc.XMLTools.selectNumber(xmlData, "//resultRow");
    // </pre>
    // <li> setting +link{attr:dsResponse.status} to recognized ISC error values based on
    //      service-specific errors, in order to trigger standard ISC error handling.  For
    //      example, setting <code>dsResponse.status</code> to
    //      +link{rpcResponse.STATUS_VALIDATION_ERROR} and filling in
    //      +link{attr:dsResponse.errors} in order to cause validation errors to be shown in
    //      forms and grids.
    // <li> for services that either do not return cache update data, or return partial data,
    //      using +link{attr:dsRequest.oldValues} to create cache update data (whether this is
    //      appropriate is application-specific), or setting
    //      +link{attr:dsResponse.invalidateCache}.
    // </ul>
    // <P>
    // <span STYLE="color:red">NOTE:</span> this method is NOT an appropriate time to call
    // methods on visual components such as grids, initiate new DSRequests or RPCRequests, or
    // in general do anything other than fill in fields on the DSResponse based on data that is
    // already available.  Any actions that need to be taken as a result of the web
    // service response should be implemented exactly as for a DataSource where
    // <code>transformResponse()</code> has not been overriden, that is, use the callback
    // passed to high-level methods such as 
    // +link{group:dataBoundComponentMethods,<code>grid.fetchData()</code>}, and do error
    // handling via either +link{DataSource.handleError()} or by setting
    // +link{RPCRequest.willHandleError,willHandleError}.
    //
    // @param dsResponse (DSResponse) default DSResponse derived from the response data
    // @param dsRequest (DSRequest) DSRequest object that initiated this request
    // @param data (XMLDocument or JSON) XML document or JSON objects returned by the web
    //                                   service
    // @return (DSResponse) response derived 
    // @visibility xmlBinding
    // @example xmlServerValidationErrors
    //<
    transformResponse : function (dsResponse, dsRequest, data) {
        return dsResponse;
    },

    // get the value of a field of a record from this DataSource.  Used for dynamically
    // fetching field values from XML elements
    getFieldValue : function (record, fieldName, field) {
        var value = isc.xml.getFieldValue(record, fieldName, field, this, this.xmlNamespaces);
        if (!field.getFieldValue) return value;

        if (!isc.isA.Function(field.getFieldValue)) {
    	    isc.Func.replaceWithMethod(field, "getFieldValue", "record,value,field,fieldName");
        }

        return field.getFieldValue(record, value, field, fieldName);
    },

    _singleArray : [],
    validateFieldValue : function (field, value) {
        var validators = field.validators;
        if (!validators) return value;

        // normalize to an Array if necessary, avoiding an allocation   
        if (!isc.isAn.Array(validators)) {
            this._singleArray[0] = validators;
            validators = this._singleArray;
        }

        var origValue = value; // purely for log below

        for (var i = 0; i < validators.length; i++) {
            var validator = validators[i];
            var result = isc.Validator.processValidator(field, validator, value);
            if (!result) {
                this.logWarn(this.ID + "." + field.name + 
                             ": value: " + this.echoLeaf(value) +
                             " failed on validator: " + this.echo(validator));
                // NOTE: this is the value as transformed by what validators did not fail.
                // Hence, having originally been a String, it may now be an integer, but not in
                // the correct range.
                return value;
            }
            var undef;
            if (validator.resultingValue !== undef) {
                value = validator.resultingValue;
                validator.resultingValue = undef;
            }
			// if the validator wants us to stop if it wasn't passed, break out of the
            // validators loop
			if (!result && validator.stopIfFalse) break;
        }

        //this.logWarn("At field: " + this.ID + "." + field.name + 
        //             " validating value: " + this.echoLeaf(origValue) +
        //             " with validators: " + this.echo(validators) + 
        //             " produced result: " + this.echo(value));

        this._singleArray.length = 0;
        return value;
    },

    // DataSource operation methods
	// --------------------------------------------------------------------------------------------

    // NOTE: concurrent editing: 
    //   - for updates and deletes we'll need the oldValues to detect changes in the target
    //     record
    //   - oldValues will be passed as requestProperties.oldValues 
    //   - oldValues will remain optional since many datasets are single-user
    //     - NOTE however: even single user web applications can be logged into simultaneously
    //       from two locations (eg email)

    //> @method dataSource.fetchData()
    // Perform a "fetch" DataSource operation against this DataSource, sending search criteria
    // and retrieving matching records.
    // <P>
    // In contrast to +link{listGrid.fetchData()}, which creates a +link{ResultSet} to manage
    // the returned data, calling <code>dataSource.fetchData()</code> provides the returned
    // data in the callback as a simple JavaScript Array of JavaScript Objects.  Calling
    // <code>dataSource.fetchData()</code> does not automatically update any visual components or
    // caches: code in the callback passed to <code>fetchData()</code> decides what to do with
    // the returned data. 
    // <P>
    // For example, given a ListGrid "myGrid" and a DataSource "employees", the following code
    // would populate "myGrid" with data fetched from the DataSource:
    // <pre>
    //    isc.DataSource.get("employees").fetchData(null, "myGrid.setData(data)");
    // </pre>
    // Unlike calling <code>myGrid.fetchData()</code>, which creates a +link{ResultSet}, the
    // data provided to the grid is "disconnected" data, unmanaged by SmartClient's databinding
    // facilities and safe to directly modify.  This is useful when, for example, a ListGrid is
    // being used as a more sophisticated version of HTML's multi-select component.
    // <P>
    // Disconnected datasets may be used to populate various visual components.  For example,
    // while an individual FormItem can be configured to fetch
    // +link{formItem.valueMap,valueMap} options from a DataSource via the
    // +link{formItem.optionDataSource,optionDataSource} property, the following code shows
    // storing a dataset to derive valueMaps from later:
    // <pre>
    //    isc.DataSource.get("countries").fetchData(null, "window.countries = data");
    //
    //    ... later, a form is created dynamically ...
    //
    //    function showForm() {
    //       isc.DynamicForm.create({
    //           items : [
    //              { name:"country", title:"Pick Country",
    //                valueMap: window.countries.getValueMap("countryId", "countryName")
    //              },
    //       ...
    // </pre>
    // <P>
    // You can also create a ResultSet from the data retrieved from <code>fetchData()</code>,
    // like so:
    // <pre>
    //    isc.DataSource.get("countries").fetchData(null,
    //        function (dsResponse, data) {
    //           isc.ResultSet.create({
    //              dataSource:"countries",
    //              allRows:data
    //           })
    //        }
    //    )
    // </pre>
    // <P>
    // This gives you a dataset that supports client-side filtering (via
    // +link{resultSet.setCriteria,setCriteria()}), can provide 
    // +link{resultSet.getValueMap,filtered valueMaps}, will 
    // +link{ResultSet.disableCacheSync,automatically reflect updates} to the DataSource made via
    // other components, and can be re-used with multiple visual components.
    // <P>
    // See also the server-side com.isomorphic.js.JSTranslater class in the
    // +docTreeLink{javaServerReference,Java Server Reference} for other, similar approaches
    // involving dumping data into the page during initial page load.  <b>Note:</b> care should
    // be taken when using this approach.  Large datasets degrade the basic performance of some
    // browsers, so use +link{pickList.optionDataSource,optionDataSource} and similar
    // facilities to manage datasets that may become very large.
    // <P>
    // <b>Data-Driven Visual Component Creation</b>
    // <P>
    // <code>DataSource.fetchData()</code> can also be used to create SmartClient components in
    // a data-driven way.  Many properties on SmartClient visual components are configured via
    // an Array of Objects - the same data format that <code>dataSource.fetchData()</code>
    // returns.  These include +link{listGrid.fields}, +link{tabSet.tabs},
    // +link{dynamicForm.items}, +link{facet.values} and even +link{dataSource.fields}.
    // <P>
    // For example, if you had a DataSource "myFormFields" whose fields included the
    // basic properties of +link{FormItem,FormItems} (name, title, type, etc), this example
    // code would create a form based on stored field definitions, loaded from the
    // "myFormFields" DataSource on the fly:
    // <pre>
    //    isc.DataSource.get("myFormFields").fetchData(null, 
    //        "isc.DynamicForm.create({ items:data })"
    //    )
    // </pre>
    // This capability to dynamically create visual components from dynamically fetched data
    // provides a foundation for creating interfaces that can be customized by end users.
    // See also +link{dataSource.inheritsFrom}.
    //
    //	@param	[criteria]          (Criteria)	  search criteria
    //	@param	[callback]          (DSCallback)  callback to invoke on completion
    //  @param  [requestProperties] (DSRequest Properties)   additional properties to set on
    //                                                       the DSRequest that will be issued
    // @group operations
    // @visibility external
    //<
    fetchData : function (criteria, callback, requestProperties) {
        this.performDSOperation("fetch", criteria, callback, requestProperties);
    },

    //> @method dataSource.filterData()
    // Perform a "fetch" DataSource operation against this DataSource, sending search criteria
    // and retrieving matching records.
    // <P>
    // This is identical to +link{fetchData()} except that
    // +link{dsRequest.textMatchStyle} is set to "substring" to cause case insensitive
    // substring matching (if the server respects this setting).
    //
    //	@param	[criteria]          (Criteria)	  search criteria
    //	@param	[callback]          (DSCallback)  callback to invoke on completion
    //  @param  [requestProperties] (DSRequest Properties)   additional properties to set on
    //                                                       the DSRequest that will be issued
    // @group operations
    // @visibility external
    //<
    filterData : function (criteria, callback, requestProperties) {
        if (!requestProperties) requestProperties = {};
        if (requestProperties.textMatchStyle == null) requestProperties.textMatchStyle = "substring";
        this.performDSOperation("fetch", criteria, callback, requestProperties);
    },

    //> @method dataSource.addData()
    // Perform an "add" DataSource operation against this DataSource, to create a new DataSource
    // record.
    //
    //	@param	newRecord           (Record)      new record
    //	@param	[callback]          (DSCallback)  callback to invoke on completion
    //  @param  [requestProperties] (DSRequest Properties)   additional properties to set on
    //                                                       the DSRequest that will be issued
    // @group operations
    // @visibility external
    //<
    addData : function (newRecord, callback, requestProperties) {
        this.performDSOperation("add", newRecord, callback, requestProperties);
    },

    //> @method dataSource.updateData()
    // Perform an "update" DataSource operation against this DataSource, to update values in an
    // existing DataSource record.
    //
    //	@param	updatedRecord       (Record Properties)      updated record
    //	@param	[callback]          (DSCallback)  callback to invoke on completion
    //  @param  [requestProperties] (DSRequest Properties)   additional properties to set on
    //                                                       the DSRequest that will be issued
    // @group operations
    // @visibility external
    //<
    updateData : function (updatedRecord, callback, requestProperties) {
        this.performDSOperation("update", updatedRecord, callback, requestProperties);
    },

    //> @method dataSource.removeData()
    // Perform a "remove" DataSource operation against this DataSource, to delete an existing
    // DataSource record.
    //
    //	@param	data                (Record PrimaryKeys) primary key values of record to delete, 
    //                                            (or complete record)
    //	@param	[callback]          (DSCallback)  callback to invoke on completion
    //  @param  [requestProperties] (DSRequest Properties)   additional properties to set on
    //                                                       the DSRequest that will be issued
    // @group operations
    // @visibility external
    //<
    removeData : function (recordKeys, callback, requestProperties) {
        // if passed a full record, trim it down to primaryKeys.
        // This will avoid problems where additional properties such as _selected etc 
        // are present on the record
        
        var keyFields = this.getPrimaryKeyFields(),
            recordKeys = isc.applyMask(recordKeys, keyFields);
        this.performDSOperation("remove", recordKeys, callback, requestProperties);
    },

    

    _getNextRequestId : function () {
        // ID can be completely arbitrary as long as it's unique, but lets use a format like
        // "SupplyItem_request12" to simplify debugging.
        if (!this._requestIdTemplate) this._requestIdTemplate = [this.getID(), "_request"];
        this._requestIdTemplate[2] = isc.DataSource._getNextRequestId();
        return this._requestIdTemplate.join(isc.emptyString);
    },
    performDSOperation : function (operationType, data, callback, requestProperties) {
        if (isc._traceMarkers) arguments.__this = this;
        
        // form a dsRequest
        var dsRequest = isc.addProperties({
            operationType : operationType,
            dataSource : this.ID,
            data : data,
            callback : callback,
            requestId : this._getNextRequestId() 
        }, requestProperties);

        return this.sendDSRequest(dsRequest);
    },

    sendDSRequest : function (dsRequest) {
        // provide default requestProperties for the operationBinding and the DataSource as a
        // whole
        isc.addDefaults(dsRequest, 
                        this.getOperationBinding(dsRequest.operationType).requestProperties);
        isc.addDefaults(dsRequest, this.requestProperties);

        // check for iscServer missing, and switch to clientOnly mode if necessary
        var dataFormat = this.getDataFormat(dsRequest);
        if (dataFormat == "iscServer" && !this.clientOnly && !isc.hasOptionalModule("SCServer")) {
            if (this.dataURL == null && this.testFileName == null) {
                this.logError("DataSource: "+this.ID+
                          ": attempt to use DataSource of type iscServer without SmartClient Server option."+
                          " Please either set clientOnly: true for one-time fetch against"+
                          " dataURL/testFileName or download the edition with SmartClient Server");
                return;
            }
            // have dataURL or testFileName, default to clientOnly mode automatically
            this.logInfo("Switching to clientOnly - no SmartClient Server installed.");
            this.clientOnly = true;
        }

        // default showPrompt:true according to DS setting
        if (dsRequest.showPrompt == null) {
            dsRequest.showPrompt = this.showPrompt;
        }

        // handle clientOnly DataSources
        if (this.fetchingClientOnlyData(dsRequest)) return;

        if (this.logIsDebugEnabled()) {
            this.logDebug("Outbound DSRequest: " + this.echo(dsRequest));
        }

        // store off the dataSource layer callback as we will be passing a different callback
        // to the RPC layer
        dsRequest._dsCallback = dsRequest.callback;

        if (dataFormat == "iscServer" && !this.clientOnly) {
            return this.performSCServerOperation(dsRequest);
        }
        
        

        
        var inputs = this.getServiceInputs(dsRequest);
        
        // clientCustom dataProtocol - in this case we assume transformRequest has been implemented
        // to call non SmartClient code to generate the appropriate response. This will have been
        // called as part of getServiceInputs() - simply return and wait for 'processResponse' to
        // be called
        if (inputs.dataProtocol == "clientCustom") return;
        
        var rpcRequest = isc.addProperties({}, dsRequest, inputs);

        // hold onto the dsRequest that initiated this call, and the indirect callback
        rpcRequest._dsRequest = dsRequest;

        // HACK: if we don't do this, when this request is passed to rpcRequest.send(),
        // dsRequest.data gets passed as a requestBody to the proxy servlet
        if (inputs.data == null) rpcRequest.data = null;

        // client only requests: set up a callback to populate with data
        if (this.clientOnly) {
            rpcRequest.callback = {target:this, methodName:"_handleClientOnlyReply" };
            isc.RPC.sendRequest(rpcRequest);
            return;
        }
        
        var opBinding = this.getOperationBinding(dsRequest);
        rpcRequest.transport = opBinding.dataTransport || this.dataTransport;
        if (rpcRequest.transport == "scriptInclude") {
            // cross-site JSON: we will receive live JS objects directly
            rpcRequest.callback = { target:this, methodName:"_handleJSONReply" };
            // transformResponse or previous application via requestProperties in
            // performDSOperation takes precedence
            if (!rpcRequest.callbackParam) {
                rpcRequest.callbackParam = opBinding.callbackParam || this.callbackParam;
            }
            isc.RPC.sendRequest(rpcRequest);
            return;
        }

        var dataFormat = this.getDataFormat(dsRequest);

        // XML pathway: result will be parsed as XML, have recordXPath and schema applied
        if (dataFormat == "xml") {
            rpcRequest.callback = { target:this, method: this._handleXMLReply };
            isc.xml.getXMLResponse(rpcRequest);

        // JSON pathway: result will be eval()d as JSON, have recordXPath and schema applied
        } else if (dataFormat == "json") {
            rpcRequest.callback = { target:this, method: this._handleJSONTextReply };
            isc.rpc.sendProxied(rpcRequest);

        // custom pathway: you receive the raw String result and must fill out a DSResponse
        } else {
            rpcRequest.serverOutputAsString = true;
            rpcRequest.callback = { target:this, method:this._handleCustomReply };
            isc.rpc.sendProxied(rpcRequest);
        }
    },     
    

    performSCServerOperation : function (dsRequest, callback) {
        this.logWarn("Attempt to perform iscServer request requires options SmartClient server " +
                     "support - not present in this build.\nRequest details:"+ 
                     this.echo(dsRequest));
        return;
    },
    
    //> @method dataSource.handleError() (A)
    // If you define this method on a DataSource, it will be called whenever the server returns
    // a DSResponse with a status other than +link{RPCResponse.STATUS_SUCCESS}.  You can use
    // this hook to do DataSource-specific error handling.  Unless you return
    // <code>false</code> from this method, +link{RPCManager.handleError()} will be called by
    // SmartClient right after this method completes.
    // 
    // @param response (DSResponse) the DSResponse or DSResponse object returned from the server
    // @param request (DSRequest) the DSRequest or DSRequest that was sent to the server
    // 
    // @return (boolean) false to suppress +link{RPCManager.handleError()}
    //
    // @group errorHandling
    // @see RPCManager.handleError()
    // @visibility external
    //<

    //> @type DSCallback
    // A +link{type:Callback} to evaluate when a DataSource request completes.
    // <P>
    // The parameters available in the DSCallback expression are:
    // <ul>
    // <li>dsResponse: a +link{class:DSResponse} instance with metadata about the returned data
    // <li>data: data returned to satisfy the DataSource request.  See the
    //     +link{group:dataSourceOperations,DataSource operations} topic for expected results
    //     for each type of DataSource operation
    // <li>dsRequest: the +link{class:DSRequest} that was sent.  You can use
    //     +link{attr:dsRequest.clientContext} to track state during the server turnaround.
    // </ul>
    // For example, if you had a DynamicForm with ID "myForm" and you wanted to retrieve a 
    // record from a DataSource "myUsers", where each record has a "userId" field:
    // <pre>
    //     myUsers.fetchData({ userId : "fred" }, "myForm.setValues(data)");
    // </pre>
    // or
    // <pre>
    //     myUsers.fetchData({ userId : "fred" }, function (dsResponse, data, dsRequest) {
    //                                              myForm.setValues(data);
    //                                            });
    // </pre>
    // 
    //
    // @treeLocation Client Reference/Data Binding/DataSource
    // @visibility external
    //<

//> @class DSResponse
// Response sent by the server in response to a +link{DSRequest,DataSource request}.  Contains
// all the properties available on the basic +link{class:RPCResponse}, in addition to the
// properties listed here.
//
// @treeLocation Client Reference/Data Binding
// @visibility external
//<

//> @attr dsResponse.clientContext (Object : null : R)
//
// The +link{dsRequest.clientContext} object as set on the +link{DSRequest}.
//
// @see dsRequest.clientContext
// @see rpcResponse.clientContext
//
// @visibility external
//<

//> @attr dsResponse.data (Object : null : R)
// For DataSource operations, this is typically either an Array of Objects representing records
// (for "fetch" operations) or a single Object representing the updated record (for "update",
// "add" or "remove" operations).
// 
// @see group:dataSourceOperations for standard return types for DataSource Operations
// @group dsResponse
// @visibility external
//<

//> @attr dsResponse.status (Number : 0 : R)
//
// Same meaning as +link{RPCResponse.status}, except DSResponses have additional error codes,
// such as +link{RPCResponse.STATUS_VALIDATION_ERROR,validation failure}.
// 
// @see group:dataSourceOperations for standard return types for DataSource Operations
// @group errorHandling
// @visibility external
//<

//> @attr dsResponse.errors (Object : null : R)
// Server-side validation errors for an attempted "update" or "add" operation, as a JS Object
// where each property name is a field name from the record and each property value is an error
// message to be shown to the user.  For example:<pre>
//     dsResponse.errors = {
//         userId : "A user with this userId already exists",
//         orderId : "No Order with ID '6A18294' exists"
//     }
// </pre>
// The Java API DSResponse.addError(fieldName, errorMessage) is used to send server-side errors
// to the client.  See the Java Server Reference for details.
//
// @see dataSource.handleError()
// @group errorHandling
// @visibility external
//<

//> @attr dsResponse.startRow (number : null : R)
// Starting row of returned server results, when using paged result fetching
// <p>
// Note that startRow and endRow are zero-based - the first record is row zero.
//
// @group paging
// @visibility external
//<

//> @attr dsResponse.endRow (number : null : R)
// End row of returned server results, when using paged result fetching
// <p>
// Note that startRow and endRow are zero-based - the first record is row zero.
//
// @group paging
// @visibility external
//<

//> @attr dsResponse.totalRows (number : null : R)
// Total number of rows available from the server that match the current filter criteria,
// when using paged result fetching.
//
// @group paging
// @visibility external
//<

//> @attr dsResponse.invalidateCache (boolean : null : R)
// Optional flag that can be set by the server to force ResultSets to drop any caches of
// records from the DataSource that was the target of the operation.
//
// @group cacheSync
// @visibility external
//<

//> @attr dsResponse.cacheTimestamp (number : null : R)
// Optional number sent by the server to allow cache staleness detection.
// <P>
// If sent by the server, the cacheTimestamp will be sent along with any fetch DSRequests
// originated by ResultSets who received a DSResponse with a
// <code>cacheTimestamp</code> set.
// 
// @group cacheSync
//<

// --------------------------------------------------------------------------------------------

//> @class DSRequest
// Request sent to the server to initiate a 
// +link{group:dataSourceOperations,DataSource operation}.  All properties which are legal on
// +link{class:RPCRequest} are legal, in addition to the properties listed here.
//
// @inheritsFrom RPCRequest 
// @treeLocation Client Reference/Data Binding
// @see RPCRequest
// @visibility external
//<

//> @attr dsRequest.requestId (String : varies : RA)
// Automatically generated unique ID for this request. This ID will be required by developers 
// making use of the +link{dsProtocol,"clientCustom" dataProtocol}.
// @visibility external
//<

//> @attr dsRequest.data  (Object or Array of Object : null : IR)
// Data, such as search criteria or an updated record, to be acted upon.  Contents differ by
// <code>operationType</code>, see +link{group:dataSourceOperations,DataSource Operations} for
// details.
// <P>
// This field is generally filled in by passing the "data" argument to methods such as
// +link{method:ListGrid.fetchData()}.
//
// @visibility external
//<

//> @attr dsRequest.startRow (number : 0 : IR)
// Starting row of requested results, used only with fetch operations.
// <p>
// Note that startRow and endRow are zero-based, so startRow: 0, endRow: 1 is a request
// for the first two records.
//
// @group paging
// @visibility external
//<

//> @attr dsRequest.endRow (number : null  : IR)
// End row of requested results, used only with fetch operations.
// <p>
// Note that startRow and endRow are zero-based, so startRow: 0, endRow: 1 is a request
// for the first two records.
//
// @group paging
// @visibility external
//<

//> @attr dsRequest.dataSource (String : null : IR)
// DataSource this DSRequest will act on.
// <P>
// This property is generally automatically populated, for example when calling
// +link{method:DataSource.fetchData()} the dataSource property is set to the target
// DataSource.
// @visibility external
//<

//> @attr dsRequest.operationType (DSOperationType : null : IR)
// Type of operation being performed, "fetch", "add", "remove" or "update".
// <P>
// This property is generally automatically populated, for example when calling
// <code>fetchData()</code> on a DataSource or DataBound component the operationType is
// automatically set to "fetch".
// @visibility external
//<

//> @attr dsRequest.sortBy (String : null : IR)
// Fieldname to sortBy, prefixed with optional "-" indicating descending sort.  For example, to
// sort by the field "userName" in ascending order, set <code>sortBy</code> to just
// "userName".  For descending sort on "userName", set <code>sortBy</code> to "-userName".
//
// @visibility external
//<

//> @attr dsRequest.oldValues (Object : null : IR)
// For an <code>update</code> or <code>remove</code> operation, the original values of the
// record to be updated or removed.  <code>oldValues</code> is automatically added to
// DSRequests submitted by DataBound Components.  Available on the server via
// <code>DSRequest.getOldValues()</code>.
// <P>
// The server can compare the <code>oldValues</code> to the most recent stored values in order
// to detect that the user was looking at stale values when the user submitted changes (NOTE:
// this means of detecting concurrent edit is sometimes called "optimistic concurrency" or
// "long transactions").  
// <P>
// In applications where a policy of "last update wins" is not appropriate when updating
// certain fields, special UI can be shown for this case.  For example, on detecting concurrent
// edit, the server may send back a special <code>dsResponse.status</code> code that the client
// application detects, offering the user a choice of proceeding with the operation,
// discarding edits, or reconciling new and old values in a special interface.
//
// @visibility external
//<

//> @attr dsRequest.componentId (String : null : IR)
// For requests submitted by a +link{DataBoundComponent}, the +link{canvas.ID} of the
// submitting component.
// <P>
// This ID will be present for operations including automatic saves by a ListGrid 
// +link{gridEditing,during editing}, or calls to
// +link{dynamicForm.saveData,form.saveData()}.  It will not be present for a direct
// call to a DataSource method such as +link{dataSource.fetchData()}.
// <P>
// Note this is the component's <b>String</b> ID - you can retrieve the component itself
// via +link{Canvas.getById()}.
//
// @visibility external
//<

//> @attr dsRequest.operationId (String : null : I)
// When a +link{interface:DataBoundComponent} sends a DSRequest, the
// <code>dsRequest.operationId</code> will be automatically picked up from the
// <code>fetchOperation</code>, <code>addOperation</code>, etc properties of the
// DataBoundComponent.  
// <P>
// The <code>operationId</code> serves as an identifier that you can use to create
// variations on the 4 basic DataSource operations that are used by different components in
// different parts of your application.  For example, you may be using a standard
// <code>fetch</code> operation in one part of your application, however on another screen you
// want to perform a <code>fetch</code> operation on the same DataSource but interpret search
// criteria differently (eg full text search).  
// <P>
// If you declare more than one +link{OperationBinding} for the same
// +link{operationBinding.operationType}, you can specify an <code>operationId</code>
// +link{operationBinding.operationId,on the operationBinding} which will cause that
// operationBinding to be used for dsRequests containing a matching <code>operationId</code>.
// This allows all the possible settings of an <code>operationBinding</code>, including
// +link{operationBinding.wsOperation,wsOperation} or +link{DMI} settings, to be switched on a
// per-component or per-request basis.  
// <P>
// For example, by setting the <code>fetchOperation</code> on a particular ListGrid, you could
// cause it to invoke a different server method via DMI, different
// +link{operationBinding.dataURL,dataURL} or different +link{operation.wsOperation,web service
// operation}.
// <P>
// The <code>operationId</code> can also be directly received by the server in order to affect
// behavior.  When using the SmartClient Server, <code>operationId</code> can be accessed via
// dsRequest.getOperationId().  The +link{RestDataSource} will also send the
// <code>operationId</code> to the server as part of the
// +link{restDataSource.metaDataPrefix,request metadata}.  
// <P>
// Note that if you +link{dataSource.fetchData,manually invoke} a DataSource operation, you can
// also specify operationId via the <code>requestProperties</code> parameter.
//
// @group operations
// @visibility external
//<


//> @attr dsRequest.textMatchStyle (String : "exact" : I)
// For "fetch" operations, how search criteria should be interpreted for text fields: either
// "exact" for exact match, "startsWith" for matching at the beginning only, or "substring" for
// case-insensitive substring match.
// <p>
// This setting is respected by the built-in SQLDataSource.  Your custom DataSource
// implementation can interpret the search criteria passed into "fetch" operations in arbitrary
// ways; you can safely ignore this flag and use others of your own devising.
//
// @visibility external
//<

//> @attr dsRequest.clientContext (Object : {} : IRW)
// An object to be held onto for the duration of the DSRequest turnaround to track
// application-specific context.
// <P>
// When a DataSource request completes, the <code>clientContext</code> is available in the
// +link{type:DSCallback} as <code>dsResponse.clientContext</code>.  The
// <code>clientContext</code> is never sent to the server.
// <br>
// The <code>clientContext</code> is useful for holding onto state that will be used when the
// +link{type:DSCallback} fires, such as the name of a component that will receive the
// returned data.
//
// @see DSResponse.clientContext
// @see RPCRequest.clientContext
//
// @visibility external
//<

//> @attr dsRequest.parentNode (TreeNode : {} : R)
// For advanced use in integrating trees that 
// +link{resultTree.loadDataOnDemand,load data on demand} with web services,
// <code>parentNode</code> is automatically set in "fetch" DSRequests issued by a
// +link{ResultTree} that is loading children for that <code>parentNode</code>.
// <P>
// This is sometimes needed if a web service requires that additional properties beyond the
// ID of the parentNode must be passed in order to accomplished level-by-level loading.
// A custom implementation of +link{dataSource.transformRequest()} can access
// dsRequest.parentNode and add any such properties to +link{dsRequest.data}.
// <P>
// <code>parentNode</code> will also be automatically set by a TreeGrid performing databound
// reparenting of nodes, as implemented by +link{treeGrid.folderDrop}.
// <P>
// This property can only be read.  There is no meaning to setting this property
// yourself.
//
// @visibility external
//<

//> @attr dsRequest.resultTree (ResultTree : {} : R)
// For advanced use in integrating trees that 
// +link{resultTree.loadDataOnDemand,load data on demand} with web services,
// the ResultTree that issued this "fetch" DSRequest is automatically made available as the
// <code>resultTree</code> property.
// <P>
// This property can only be read.  There is no meaning to setting this property
// yourself.
//
// @visibility external
//<

//> @attr dsRequest.resultSet (ResultSet : {} : R)
// For advanced use in integrating dataset paging with web services,
// the ResultSet that issued this "fetch" DSRequest is automatically made available as the
// <code>resultSet</code> property.
// <P>
// This property can only be read.  There is no meaning to setting this property
// yourself.
//
// @visibility external
//<




//> @attr dsRequest.useFlatFields (boolean : null : IR)
// When <code>useFlatFields</code> is set for a request to be sent to a WSDL web service, when
// creating the input XML message to send to the web service, properties in
// +link{data,request.data} will be used as the values for XML elements of the same name, at
// any level of nesting.
// <P>
// <code>useFlatFields</code> allows you to ignore gratuitous XML message structure, such as
// extra levels of nested elements, and provides some insulation against changes in the
// required structure of the input message.
// <P>
// For example, given this input message:
// <pre>
// &lt;FindServices&gt;
//     &lt;searchFor&gt;search text&lt;/searchFor&gt;
//     &lt;Options&gt;
//         &lt;caseSensitive&gt;false&lt;/caseSensitive&gt;
//     &lt;/Options&gt;
//     &lt;IncludeInSearch&gt;
//         &lt;serviceName&gt;true&lt;/serviceName&gt;
//         &lt;documentation&gt;true&lt;/documentation&gt;
//         &lt;keywords&gt;true&lt;/keywords&gt;
//     &lt;/IncludeInSearch&gt;
// &lt;/FindServices&gt;
// </pre>
// If <code>useFlatFields</code> were <b>not</b> set, in order to fill out this message
// correctly, <code>request.data</code> would need to be:
// <pre>{
//    searchFor: "search text",
//    Options : {
//        caseSensitive: false,
//    },
//    IncludeInSearch : {
//        serviceName: true,
//        documentation : true,
//        keywords : true
//    }
// }</pre>
// However if useFlatFields were set, <code>request.data</code> could be just:
// <pre>{
//    searchFor: "search text",
//    caseSensitive: false,
//    serviceName: true,
//    documentation : true,
//    keywords : true
// }</pre>
// <code>useFlatFields</code> is often set when the input data comes from a +link{DynamicForm}
// to avoid the cumbersome and fragile process of mapping input fields to an XML structure.
// <P>
// +link{operationBinding.useFlatFields} can also be set to cause <b>all</b> dsRequests of a
// particular type to <code>useFlatFields</code> automatically.
// <P>
// For +link{DataBoundComponent,DataBoundComponents}, 
// +link{DataBoundComponent.useFlatFields,component.useFlatFields} can be set use "flattened"
// binding to fields of a WSDL message or XML Schema.
// <P>
// Note that <code>useFlatFields</code> is not generally recommended for use with XML input
// messages where multiple simple type fields exist with the same name, however if used in this
// way, the first field to use a given name wins.  "first" means the first field encountered in a
// depth first search.  "wins" means only the first field will be populated in the generated
// XML message.
//
// @group flatFields
// @visibility xmlBinding
//<

//> @attr dsRequest.useFlatHeaderFields (boolean : null : IRW)
// Cause the +link{dsRequest.useFlatFields,useFlatFields} XML serialization behavior to be used
// for <b>all</b> soap headers in the request.  See also +link{dsRequest.headerData}.
//
// @group flatFields
// @visibility xmlBinding
//<

//> @attr dsRequest.headerData (Object : null : IRW)
// For DataSources using SOAP messaging with a WSDL web service, data to be serialized to form
// SOAP headers, as a map from the header part name to the data.  See
// +link{WSRequest.headerData} for more information.
// <P>
// SOAP headers typically contain request metadata such as a session id for authentication, and
// so <code>dsRequest.headerData</code> is typically populated by
// +link{dataSource.transformRequest()}, or, for data that applies to every request sent to the
// server, by +link{webService.getHeaderData()}.
//
// @visibility xmlBinding
//<

//> @attr dsRequest.parameters (Object : null : IR)
// Parameters to pass to the server <i>in addition to</i> the standard inbound data required by
// a DataSource operation of this type.
// <p>
// Parameters are used only with custom implementations of DataSource operations; the
// SQLDataSource built-in to the ISC server ignores all parameters.  A typical use of
// parameters is to control an extra action that a custom DataSource operation supports.  For
// example, a custom "update" DataSource operation might support sending an email notification
// whenever a record is updated; parameters could control whether this notification email is
// sent, to what list of people, etc.
// <p>
// An alternative to using parameters is to use +link{method:RPCManager.startQueue()} to
// combine multiple distinct operations into one round-trip.
// <p>
// These parameters are available on the server via <code>dsRequest.getParameter()</code>.
//<


// ServerObject
// ---------------------------------------------------------------------------------------
//> @attr DataSource.serverObject (ServerObject : null : IR)
//
// For Direct Method Invocation (DMI) binding, declares the ServerObject to use as the default
// target for all +link{DataSource.operationBindings}.  Specifying this
// attribute in an XML DataSource stored on the server enables DMI for this DataSource.
//
// @group serverDataIntegration
// @requiresModules SCServer
// @visibility external
//<

//> @class ServerObject
//
// The ServerObject tells the ISC server how to find or create a server-side object involved in
// +link{DMI} (Direct Method Invocation).  
// <p>
// A ServerObject declaration appears in the XML definition of a +link{DataSource} (for
// responding to +link{DSRequest}s) or in an Application configuration file (.app.xml) for
// responding to +link{RPCRequest}s.
//
// @see DMI
//
// @treeLocation Client Reference/RPC
// @requiresModules SCServer
// @visibility external
//<

//> @attr serverObject.lookupStyle ("new"|"factory"|"attribute"|"spring" : "new" : IR)
//
// Specifies the mechanism for locating the class instance on which to invoke the method.
// Valid values are as follows:
// <ul>
// <li>"spring": For use with the +externalLink{http://springframework.com,Spring framework}.
// +link{serverObject.bean} contains the name of the bean to invoke.  Which application context
// is used can be configured via web.xml (see the example web.xml in the SDK).
// <li>"new": A new instance of the class specified by +link{serverObject.className} will be
// created and the DMI method will be invoked on that instance (unless the specified method is
// static, in which case no instance is created, but the class specified by
// +link{serverObject.className} is still used).
// <li>"factory": A custom factory provides the class instance on which the DMI method is to be
// invoked.  In this case, +link{serverObject.className} specifies the className of the factory
// that will provide the instance on which the DMI method is to be invoked.  The class
// specified by +link{serverObject.className} must provide exactly one method named
// <code>create</code> that must return the class instance on which you wish the DMI method to
// be invoked.  Like the DMI methods, the <code>create</code> can request a standard set of
// values as arguments.  See +link{DMI} for a list of available values.
// <li> "attribute": The instance on which the DMI method is to be invoked is looked up in the
// scope defined by +link{serverObject.attributeScope} via the attribute name specified in
// +link{serverObject.attributeName}.
// </ul>
//
// @see serverObject.className
// @see serverObject.attributeName
// @see serverObject.attributeScope
//
// @visibility external
//<

//> @attr serverObject.className (String : null : IR)
//
// Specifies the fully-qualified class name that provides the server-side endpoint of the DMI
// (+link{serverObject.lookupStyle}:"new") or the class name of the factory that produces the
// DMI instance (+link{serverObject.lookupStyle}:"factory").
// <p>
// This is one of the values that you need to pass to +link{DMI.call} to invoke the DMI from
// the client.
// <p>
// The value of this attribute is used only for <code>"new"</code> and <code>"factory"</code>
// values of +link{serverObject.lookupStyle}.
//
// @see serverObject.lookupStyle
// @see serverObject.ID
// @see DMI.call
//
// @visibility external
//<

//> @attr serverObject.ID (String : null : IR)
//
// You can optionally specify an ID on the ServerObject config block - in which case you can
// use that value as the "className" argument when calling +link{DMI.call}.  This allows you to
// hide the name of the server-side class used as the factory or implementer of the DMI from
// the browser as a security precaution.
//
// @see serverObject.className
// @see DMI.call
//
// @visibility external
//<

//> @attr serverObject.bean (String : null : IR)
//
// For use when +link{serverObject.lookupStyle} is <code>"spring"</code>, id of the bean to ask
// Spring to create.
//
// @visibility external
//<

//> @attr serverObject.attributeName (String : null : IR)
//
// Specifies the name of the attribute by which to look up the DMI instance.  This attribute is
// consulted only when the value of +link{serverObject.lookupStyle} is <code>"attribute"</code>.
//
// @see serverObject.attributeScope
// @see serverObject.lookupStyle
//
// @visibility external
//<

//> @attr serverObject.attributeScope ("request"|"session"|"application" : null : IR)
//
// Specifies the scope in which the DMI instance is to be looked up.  Valid values are: 
// <code>"request"</code>, <code>"session"</code>, and <code>"application"</code>.  If
// <code>attributeScope</code> is left out of the <code>ServerObject</code> definition, then
// all scopes are searched in the order in which they are listed above.
// <p>
// This attribute is consulted only when the value of +link{serverObject.lookupStyle} is
// <code>"attribute"</code>.
//
// @see serverObject.attributeName
// @see serverObject.lookupStyle
//
// @visibility external
//<


//> @attr serverObject.visibleMethods (List : null : IR)
//
// When the +link{ServerObject} appears in a .app.xml file (for RPC DMI), this property
// specifies the list of methods on the ServerObject that are callable from the client.  See
// the builtin.app.xml file in the /shared/app directory of the SDK for an example of a
// visibleMethods declaration block.
//
// @see DMI
//
// @visibility external
//<


//> @attr serverObject.dropExtraFields     (Boolean : null : IR)
// By default, for DMI DSResponses, DSResponse.data is filtered on the server to just the set
// of fields defined on the DataSource.  This behavior can be overridden in several ways - see
// the overview in +link{DMI} for details.  The value of this attribute overrides
// +link{DataSource.dropExtraFields}.
// 
// @visibility external
//<


//> @attr serverObject.targetXPath     (String : null : IR)
// If set, the SmartClient server will use JXPath to call your server code.  The
// <code>JXPathContext</code> (start point) will be the object arrived at by applying the 
// +link{serverObject.lookupStyle,lookupStyle} and related ServerObject properties. The 
// intention of this property is to allow easier access to your existing Java objects 
// and reduce the need to write SmartClient-specific server code.
// 
// @visibility external
//<

// OperationBindings
// ---------------------------------------------------------------------------------------

//> @attr DataSource.operationBindings (Array of OperationBinding : null : IR)
// Optional array of OperationBindings, which provide instructions to the DataSource about how each
// DSOperation is to be performed.
// <P>
// For DataSources bound to WSDL-described web services using
// +link{DataSource.serviceNamespace}, OperationBindings are used to bind each DataSource
// +link{operationBinding.operationType,operationType} to an
// +link{operationBinding.wsOperation,operation} of a WSDL-described 
// +link{WebService,web service}, so that a DataSource can both fetch and save data to a web
// service.
// <P>
// For example, this code accomplishes part of the binding to the 
// +externalLink{http://www.google.com/search?q=sforce+partner+wsdl,SalesForce partner web services}
// <pre>
// isc.DataSource.create({
//    serviceNamespace : "urn:partner.soap.sforce.com",
//    operationBindings : [
//        { operationType:"fetch", wsOperation:"query", recordName: "sObject" },
//        { operationType:"update", wsOperation:"update", recordName: "SaveResult" },
//        { operationType:"add", wsOperation:"create", recordName: "SaveResult" },
//        { operationType:"remove", wsOperation:"delete", recordName: "DeleteResult" }
//    ],
//    ...
// }); 
// </pre>
// NOTE: additional code is required to handle authentication and other details, see the
// complete code in isomorphicSDK/examples/databinding/SalesForce.
// <P>
// For DataSources that contact non-WSDL-described XML or JSON services, OperationBindings can
// be used to separately configure the URL, HTTP method, input and output processing for each
// operationType.  This makes it possible to fetch JSON data from one URL for the "fetch"
// operationType and save to a web service for the "update" operationType, while appearing as a
// single integrated DataSource to a +link{DataBoundComponent} such as an
// +link{ListGrid.canEdit,editable ListGrid}.
// <P>
// If no operationBinding is defined for a given DataSource operation, all of the properties
// which are valid on the operationBinding are checked for on the DataSource itself.  
// <P>
// This also means that a read-only DataSource, that is, a DataSource only capable of fetch
// operations, operationBindings need not be specified, and instead all operationBinding
// properties can be set on the DataSource itself.  An example of using OperationBinding
// properties directly on the DataSource in order to read an RSS feed can be found here:
// <P>
// +standaloneExample{/examples/databinding/rss_databinding.html}
// 
// @see class:OperationBinding
// @visibility xmlBinding
//<

//> @class OperationBinding
// An operationBinding tells a DataSource how to execute one of the basic DS operations: fetch,
// add, update, remove.
// <P>
// OperationBindings are typically used to declaratively bind a DataSource to a Web Service, by
// associating each DataSource operation with a Web Service operation, and providing properties
// such as +link{attr:operationBinding.recordXPath} to map web service responses to data expected by a
// DataSource.
//
// @treeLocation Client Reference/Data Binding/DataSource
// @visibility xmlBinding
//<

//> @attr operationBinding.operationType (DSOperationType : null : IR)
// Which operationType this operationBinding is for.  This property is only settable on an operationBinding, not
// a DataSource as a whole.
//
// @group clientDataIntegration
// @visibility xmlBinding
//<

//> @attr operationBinding.operationId (String : null : IR)
// Optional operationId if this DataSource supports two or more variants of one of the basic
// DataSource operations, for instance, a "fetch" that uses full text search and a "fetch" that
// accepts per-field search criteria.  See +link{dsRequest.operationId} for usage.
//
// @group clientDataIntegration
// @visibility xmlBinding
//<

//> @attr operationBinding.serverMethod (string : null : IR)
//
// The name of the method to invoke on the +link{ServerObject} for this operationBinding.
//
// @requiresModules SCServer
// @visibility external
//<

//> @attr operationBinding.methodArguments (string : null : IR)
//
// You can explicitly declare the arguments to be passed to
// +link{operationBinding.serverMethod} using this attribute.  This isn't required - in the
// absense of <code>methodArguments</code>, the DMI implementation will still automagically
// pass a stock set of arguments to your method (see the overview in +link{ServerObject}), but
// specifying arguments explicitly gives you more flexibility in what can be passed.
// <p>
// The format for specifying <code>methodArguments</code> is as a comma separated list of VTL
// (Velocity Template Language) expressions.  See the
// +externalLink{http://jakarta.apache.org/velocity/docs/vtl-reference-guide.html, VTL Reference}
// and +externalLink{http://jakarta.apache.org/velocity/docs/user-guide.html, Velocity User Guide} 
// for an overview of how to use VTL.
// <p>
// The Velocity context is pre-populated with the following variables - you can pass these
// verbatim as arguments, or call methods on these objects and pass the resulting values:
// <ul>
// <li>dsRequest: instance of the current DSRequest
// <li>request: the current HttpServletRequest
// <li>response: the current HttpServletResponse
// <li>rpcManager: the instance of RPCManager for this request
// <li>dataSource: a DataSource instance for this request
// </ul>
// So, for example, if you had a method signature like the following:
// <p><code>
// public DSResponse fetch(SupplyItem creteria, long startRow, long endRow)
// </code><p>
// You can invoke it by specifying <code>methodArguments</code> as follows:
// <p><code>
// methodArguments="$dsRequest.criteria, $dsRequest.startRow, $dsRequest.endRow"
// </code></p>
// Without <code>methodArguments</code>, there would be no way for you to specify
// <code>startRow/endRow</code> as arguments.  You could, of course, simply declare the method
// to take a <code>DSRequest</code> object and call <code>getStartRow()/getEndRow()</code> in
// the body of the method.
//
// @see ServerObject
//
// @visibility external
//<

//> @attr operationBinding.serverObject (ServerObject : null : IR)
//
// Optional ServerObject declaration that specifies the ServerObject configuration for this
// operationBinding.  In the absense of a serverObject specification here, the one specified on
// the DataSource itself is used by default, if present (+link{dataSource.serverObject}).  If
// neither is present, then Direct Method Invocation will not be enabled for this operationBinding.
//
// @see dataSource.serverObject
// @requiresModules SCServer
// @visibility external
//<

// Input Handling
// ---------------------------------------------------------------------------------------

//> @attr operationBinding.wsOperation (String : null : IR)
// Name of the web service operation that will be invoked in order to execute this DataSource
// operation.
// <P>
// Valid only for a DataSource that has a WebService (+link{attr:dataSource.serviceNamespace} is
// set).  Otherwise, use +link{attr:operationBinding.dataURL}.
// <P>
// Setting <code>wsOperation</code> means that +link{dsRequest.data} will be serialized as the
// request message for the specified web service operation, with namespacing and soap encoding
// handled automatically.  See +link{DataSource.transformRequest()} for how to customize what
// data is sent to the server.
//
// @group clientDataIntegration
// @visibility xmlBinding
// @example wsdlBinding
//<

//> @attr operationBinding.dataURL              (URL : null : [IR])
// URL to contact to fulfill DSRequests for this operationBinding.
// <P>
// <code>dataURL</code> is typically set as DataSource.dataURL rather than on each individual
// operationBinding.
// <P>
// <code>dataURL</code> can be omitted for a DataSource using a Web Service
// (+link{attr:dataSource.serviceNamespace} is set).
//
// @group clientDataIntegration
// @visibility xmlBinding
//<

//> @attr operationBinding.dataProtocol            (DSProtocol : "getParams" : [IR])
// Controls the format in which inputs are sent to the dataURL.
// <p>
// When a DataSource operation such as fetchData() is invoked on this DataSource or a component
// bound to this DataSource, the data passed to the operation, if any, will be sent to the
// <code>dataURL</code>.  The <code>dataProtocol</code> property controls the format in
// which the data is sent: SOAP message, HTTP GET or POST of parameters, etc.
// <P>
// The <code>dataProtocol</code> property need not be set for a DataSource with a WebService
// ( +link{attr:dataSource.serviceNamespace} is set), in this case, SOAP messaging is used by
// default.
// <P>
// Developers may completely bypass the SmartClient comm system by setting dataProtocol to
// <code>"clientCustom"</code>. In this case SmartClient will not attempt to send any data
// to the server after calling +link{DataSource.transformRequest()}. Instead the developer is
// expected to implement <code>transformRequest()</code> such that it performs the necessary
// data action outside of SmartClient, and then calls +link{DataSource.processResponse()}, 
// passing in the +link{DSRequest.requestId} and an appropriate set of DSResponse properties to
// indicate the result of the action.
// <P>
// NOTE: when +link{dataFormat} is "iscServer", <code>dataProtocol</code> is not consulted.
// Instead, SmartClient uses a proprietary wire format to communicate with the SmartClient
// server, and the server-side DSRequest and DSResponse objects should be used to access
// request data and form responses.
//
// @see type:DSProtocol
// @group clientDataIntegration
// @visibility xmlBinding
//<
//dataProtocol:"getParams", // NOTE: dynamic default determined in getServiceInputs()

//> @attr operationBinding.dataFormat (DSDataFormat : "iscServer" : [IR])
// Format for response data for this operation.
// <P>
// Typically set once for the DataSource as a whole via +link{DataSource.dataFormat}.
//
// @group clientDataIntegration
// @visibility xmlBinding
//<

//> @attr operationBinding.dataTransport      (RPCTransport : RPCManager.defaultTransport : [IR])
// Transport to use for this operation.  Defaults to +link{DataSource.dataTransport}, which in
// turn defaults to +link{RPCManager.defaultTransport}.  This would typically only be set to
// enable "scriptInclude" transport for contacting +link{DataSource.dataFormat,JSON} web
// services hosted on servers other than the origin server.
// <p>
// When using the "scriptInclude" transport, be sure to set +link{dataSource.callbackParam} or
// +link{operationBinding.callbackParam} to match the name of the query parameter name expected
// by your JSON service provider.
//
// @see RPCTransport
// @see dataSource.callbackParam
// @group clientDataIntegration
// @visibility xmlBinding
//<


//> @attr operationBinding.callbackParam      (String : "callback" : [IR])
// Applies only to dataFormat: "json".  Specifies the name of the query parameter that
// tells your JSON service what function to call as part of the response for this operation.
// <P>
// Typically set once for the DataSource as a whole via +link{DataSource.callbackParam}.
//
// @see dataSource.callbackParam
// @group clientDataIntegration
// @visibility xmlBinding
//<


//> @attr operationBinding.requestProperties (DSRequest Properties : null : [IR])
// Additional properties to pass through to the +link{DSRequest} created for this operation.
// Note that these will be cumulative with and will override on a per-property basis any
// properties set via +link{dataSource.requestProperties}.
// <p>
// These properties are applied before +link{dataSource.transformRequest} is called.
//
// @see DSRequest
// @see dataSource.requestProperties
// @group clientDataIntegration
// @group serverDataIntegration
// @visibility external
//<

//> @type DSProtocol
// +link{OperationBinding.dataProtocol} affects how the data in the DSRequest (+link{dsRequest.data})
// is sent to the +link{dataSource.dataURL}.  Listed below are the valid values for
// +link{OperationBinding.dataProtocol} and their behavior.
// <P>
// Note that, when using the SmartClient server, data is automatically translated from
// JavaScript to Java according to the rules described +link{rpcRequest.data,here};
// dataProtocol does not apply and is ignored.
// <P>
// If you are integrating with a +link{RestDataSource,REST} server that requires the more
// obscure +link{rpcRequest.httpMethod}s of "PUT", "DELETE" or "HEAD", you can specify these
// httpMethod settings via +link{operationBinding.requestProperties}.  dataProtocol settings
// that mention "GET" or "POST" are compatible with these additional HTTP methods as well.
// Typical +link{dataSource.operationBindings,operationBindings} for a REST server that uses
// "PUT" and "DELETE" are as follows:
// <pre>
//    operationBindings:[
//       {operationType:"fetch", dataProtocol:"getParams"},
//       {operationType:"add", dataProtocol:"postParams"},
//       {operationType:"remove", dataProtocol:"getParams", requestProperties:{httpMethod:"DELETE"}},
//       {operationType:"update", dataProtocol:"postParams", requestProperties:{httpMethod:"PUT"}}
//    ],
// </pre>
// 
// @value "getParams"
//   Data is added to the dataURL, with each property in the data becoming an HTTP parameter,
//   eg http://service.com/search?keyword=foo
// @value "postParams"
//   Data is POST'd to the dataURL, with each property becoming an HTTP parameter, 
//   exactly as an HTML form would submit them if it had one input field per property in the
//   data.
// @value "postXML"
//   Data is serialized as XML via +link{dataSource.xmlSerialize()} and POST'd as the
//   HTTP request body with contentType "text/xml"
// @value "soap"
//   Data is serialized as XML via +link{dataSource.xmlSerialize()}, wrapped in a SOAP
//   envelope, and POST'd as the HTTP request body with contentType "text/xml".  Generally
//   only used in connection with a +link{group:wsdlBinding,WSDL web service}.
// @value "postMessage"
//   dsRequest.data is assumed to be a String set up by +link{dataSource.transformRequest()}
//   and is POST'd as the HTTP request body.
// @value "clientCustom"
//   This setting entirely bypasses the SmartClient comm system. Instead of the DataSource sending
//   an HTTP request to the server, the developer is expected to implement
//   +link{DataSource.transformRequest()} to perform their own custom data manipulation logic, and
//   then call +link{DataSource.processResponse()} to handle the results of this action.
//   
//
// @see operationBinding.dataProtocol
// @group clientDataIntegration
// @visibility xmlBinding
//<

//> @attr operationBinding.defaultParams    (Object : null : [IRA]) 
// HTTP parameters that should be submitted with every DSRequest.
// <P>
// Useful for authenticated services that require a sessionId with every request.
// <P>
// Can be set for all operations of a given DataSource as DataSource.defaultParams.
//
// @group clientDataIntegration
// @visibility xmlBinding
//<


// XML Output handling
// ---------------------------------------------------------------------------------------

//> @attr operationBinding.recordXPath          (XPathExpression : null : [IR])
// For an XML or JSON DataSource, XPath expression used to retrieve the objects that will
// become DataSource records.
// <p>
// For example, an "ItemSearch" web service might return a "Results" structure containing
// metadata along with the set of Items that one might want to display in a grid.  An XPath
// expression like "/Results/Items" could be used to retrieve just the Items, which would then
// become DataSource records.
// <p>
// For a JSON web service, the <code>recordXPath</code> is applied to the returned JSON data
// via +link{XMLTools.selectObjects()}.  Only limited XPath syntax is allowed; see 
// +link{XMLTools.selectObjects(),selectObjects()} for details.
// <P>
// For processing XML results, see +link{attr:operationBinding.xmlNamespaces} for information
// on the namespaces that are available in this XPath expression.
// <P>
// To learn about XPath, try the following search:
// <a href="http://www.google.com/search?q=xpath+tutorial" target="_blank"
// >http://www.google.com/search?q=xpath+tutorial</a>
//
// @group clientDataIntegration
// @visibility xmlBinding
//< 

//> @attr operationBinding.recordName           (String : null : [IR])
// For an XML DataSource, tagName of the elements to be used as records.
// <p>
// This is a simple alternative to +link{attr:recordXPath} when the elements to be used as
// records all share a tagName.
// <p>
// When a DataSource has a WebService, <code>recordName</code> can also be set to the name
// of any <code>complexType</code> declared within the WebService's WSDL file.
//
// @group clientDataIntegration
// @visibility xmlBinding
// @example wsdlBinding
//< 

//> @attr operationBinding.responseDataSchema           (DataSource : null : [IRA])
// Optional schema describing how to extract DataSource records from the XML elements selected.
// <P>
// Once a set of XML elements have been selected via <code>recordXPath</code> or
// <code>recordName</code>, those elements are normally transformed to JavaScript objects
// using the <code>fields</code> of the DataSource that owns the operationBinding.  An
// <code>responseDataSchema</code> can be specified instead if the XML differs in some way between
// different DataSource operations, such that different values for
// +link{attr:DataSourceField.valueXPath,field.valueXPath} may be necessary to extract the same
// DataSource record from slightly different XML structures.
//
// @group clientDataIntegration
// @visibility xmlBinding
//<

//> @attr operationBinding.useFlatFields          (boolean : false : [IR])
// Setting <code>useFlatFields</code> on an operationBinding is equivalent to setting
// +link{dsRequest.useFlatFields} on all DataSource requests with the same +link{operationType}
// as this <code>operationBinding</code>.
// <P>
// Typical usage is to combine operationBinding.useFlatFields with 
// +link{dataBoundComponent.useFlatFields,searchForm.useFlatFields}, with the +link{SearchForm}
// bound to the +link{webService.getInputDS(),input message} of the web service operation set
// as +link{operationBinding.wsOperation}.  This allows gratuitous nesting to be consistently
// bypassed in both the user presentation and in the actual XML messaging.
// <P>
// Not that <code>useFlatFields</code> is not generally recommended for use with input messages
// where multiple simple type fields exist with the same name, however if used in this way,
// the first field to use a given name wins.  "first" means the first field encountered in a
// depth first search.  "wins" means only the first field will be available in data binding,
// and only the first field will be populated in the generated XML message.
//
// @group clientDataIntegration
// @visibility xmlBinding
//<


//> @attr operationBinding.xmlNamespaces              (Object : null : [IR])
// Optional object declaring namespace prefixes for use in +link{attr:recordXPath} and
// +link{attr:DataSourceField.valueXPath} XPath expressions.
// <P>
// <code>xmlNamespaces</code> should be specified as a mapping from namespace prefix to
// namespace URI, for example:
// <pre>
//    xmlNamespaces : {
//        az : "http://webservices.amazon.com/AWSECommerceService/2005-03-23"
//    }
// </pre>
// By default, all namespaces declared on the document element (outermost element of the
// response) are made available with the prefix used in the document itself.
// <P>
// Then, for non-WSDL-described XML results, if there is a default namespace on the document
// element, it is made available with the special prefix "default".
// <P>
// For results of WSDL-described operations, the prefix "service" means the service namespace,
// that is, the "targetNamespace" on the &lt;definitions&gt; element from the WSDL file.  The prefix
// "schema" means the namespace of the outermost element in the output message for the current
// operation.  "default" will be the schema namespace if there is one, otherwise the service
// namespace.
// <P>
// For basic information on XML Namespaces and their use in XPath, try the following search:
// <a href="http://www.google.com/search?q=XPath+xml+namespaces" target="_blank"
// >http://www.google.com/search?q=XPath+xml+namespaces</a>
//
// @group clientDataIntegration
// @visibility xmlBinding
// @example xmlYahooWebServices
//<


	// Schema handling
	// --------------------------------------------------------------------------------------------

    // look up a schema, prefering the local schemaNamespace if we're namespaced
    getSchema : function (schemaName, schemaType) {
        // if we have a SchemaSet, look up through that
        var schemaSet = this.getSchemaSet();
        if (schemaSet != null) {
            //this.logWarn("looking up schema: " + schemaName + " of kind: " + schemaType + 
            //             " in schema namespace: " + this.schemaNamespace);

            var schema = schemaSet.getSchema(schemaName, schemaType);
            if (schema != null) return schema;
        }

        // look up schema through our WSDL web service, if we have one, to allow for multiple
        // SchemaSets within a WebService that reference between each other (SForce service is
        // like this, for the SObject type)
        var service = this.getWebService();
        if (isc.isA.WebService(service)) return service.getSchema(schemaName, schemaType);

        // finally, look for any globally defined schema
        return isc.DS.get(schemaName, null, null, schemaType);
    },

    // how to refer to record[s] of this DataSource
    getTitle : function () {
        return this.title || this.ID;
    },
    getPluralTitle : function () {
        return this.pluralTitle || (this.getTitle() + "s");
    },

    // get the field best used as a title for records from this DataSource 
    getTitleField : function () {
        if (this.titleField == null) {
            // if a title field hasn't been explicitly specified, take a guess.
            // Also, remember the guess (this is an inner loop)
            var fieldNames = isc.getKeys(this.getFields());
            this.titleField = fieldNames.contains("title") ? "title" :
                              fieldNames.contains("label") ? "label" :
                              fieldNames.contains("name") ? "name" :
                              fieldNames.contains("id") ? "id" :
                              fieldNames.first();
        }
        return this.titleField; 
    },

    getIconField : function () {
        var undef;
        if (this.iconField === undef) {
            this.iconField = null;

            // if an Icon field hasn't been explicitly specified, take a guess.
            // Also, remember the guess (this is an inner loop)
            var fieldNames = isc.getKeys(this.getFields());
            var iconFieldNames = ["picture", "thumbnail", "icon", "image", "img"];
            for (var i = 0; i < iconFieldNames.length; i++) {
                var fieldName = iconFieldNames[i],
                    field = this.getField(fieldName);
                if (field && isc.SimpleType.inheritsFrom(field.type,"image")) {
                    this.iconField = fieldName;
                }
            }
        }
        return this.iconField;
    }, 
    
	// init the various sources for a view
	// 	this loads those datasources and creates a "fields" array that is
	//	the union of the fields coming from the other sources
	initViewSources : function () {
		var list = this.fields = {};
		
		for (var sourceName in this.sources) {
			var ds = isc.DS.get(sourceName);
			if (!ds) continue;
			
			var sourceFields = this.sources[sourceName].fields;
			for (var field in sourceFields) {
				var value = sourceFields[field],
					item = null;

				if (value == "*") {
					// if value is a "*", field is the name of the field in the datasource
					item = ds.fields[field];
				} else if (isc.isA.String(value)) {
					// if value is some other string, value is the name of some other field in ds
					item = ds.fields[value];
				} else if (isc.isAn.Object(value)) {
					// it's an object, first apply properties in ds[value.field], then apply
					//	the properties in the value to override
					item = isc.addProperties({}, ds.fields[ds.fields[value.field]]);
					isc.addProperties(item, value);
				}
				
				if (item) list[field] = item;
			}
		}
	},

    inheritsSchema : function (ds) {
        if (ds == null) return false;
        if (isc.isA.String(ds)) ds = this.getSchema(ds);

        if (ds == this || ds == isc.DS.get("Object")) return true;

        if (!this.hasSuperDS()) return false;
        return this.superDS().inheritsSchema(ds);
    },

    getInheritedProperty : function (property) {
        if (this[property]) return this[property];
        var superDS = this.superDS();
        return superDS ? superDS.getInheritedProperty(property) : null;
    },

	hasSuperDS : function () {
		if (this.inheritsFrom) return true;
		return false;
	},

	superDS : function () {
		if (this.hasSuperDS()) return this.getSchema(this.inheritsFrom);
		return null;
	},
		
    //> @method dataSource.getField()
    // Return the field definition object.
    // @param fieldName (String) Name of the field to retrieve
    // @return (DataSourceField) field object
    // @visibility external
    //<
    getField : function (fieldName) {
        var fields = this.getFields();
        return fields ? fields[fieldName] : null;
    },

    //> @method dataSource.getFieldNames()
    // Retrieves the list of fields declared on this DataSource.
    //
    // @return (Array of String) names of all fields declared on this DataSource
    // @visibility external
    //<
    getFieldNames : function () {
        if (isc._traceMarkers) arguments.__this = this;
        return isc.getKeys(this.getFields());
    },

    // get the field defined on this DataSource only (as opposed to inherited)
	getLocalFields : function (dontResolveTypes) {
        if (this._builtinValidatorsAdded) return this.fields;
        if (dontResolveTypes) return this.fields;
        this._addTypeDefaults();
        this._autoDeriveTitles();
        this._builtinValidatorsAdded = true;
        return this.fields;
	},
    
	getFields : function () {
        if (isc._traceMarkers) arguments.__this = this;
    
		if (this.mergedFields) return this.mergedFields;

        //this.logWarn("field init for: " + this);

        // NOTE: silently ignore looping schema definitions.  Currently can happen with
        // schemaTranslator if an element is declared to be of complexType named the same as
        // the element.
        if (!this.hasSuperDS() || this == this.superDS()) {
            return this.mergedFields = this.getLocalFields();
        }

        // combine fields: local fields override superDS fields.  
        
	
        // field inheritance flags:
        // - [default] local fields first, then parent fields
        // - useParentFieldOrder: fields are in parent order
        // - showLocalFieldsOnly: only local fields are shown.  Parent fields are present but
        //   hidden so that serialization is correct.  Typical setting when extending imported
        //   schema to create a DataSource that serves as a default field set for DataBound
        //   components
        // - restrictToLocalFields: use internally for xs:restriction, in which parent fields
        //   must really be dropped (not just hidden) if they aren't redeclared - they aren't
        //   allowed when serializing
        var superDS = this.superDS();
        	
        /*
        // future plans: use combineFieldOrders, equivalent to 
        // dataBoundComponent.useAllDataSourceFields:true, as default binding.
        if (!this.showLocalFieldsOnly && !this.restrictToLocalFields &&
            !this.useParentFieldOrder) 
        {
            return this.mergedFields = 
                this.combineFieldOrders(superDS.getFields(), 
                                        isc.getValues(this.getLocalFields()));
        }
        */

        if (this.showLocalFieldsOnly || this.restrictToLocalFields) {
            this.useParentFieldOrder = false;
        }

        var localFields = isc.addProperties({}, this.getLocalFields()),
            fields;
        if (!this.useParentFieldOrder) {
            // put together fields by adding super fields to the local fields, so local fields
            // are first
            fields = localFields;
        } else {
            // put together fields by adding fields in superDS field order, and adding the rest
            // of the local fields at the end
            fields = {};
        }
    
        // if we have a superDS, add it's fields here.  NOTE: we do this in this order so
        // that locally defined fields appear first in the merged list, which affects the
        // default display of editors
        var fieldNames = (this.restrictToLocalFields ? isc.getKeys(this.getLocalFields()) : 
                                                       superDS.getFieldNames());
        for (var i = 0; i < fieldNames.length; i++) {
            var fieldName = fieldNames[i],
                localField = localFields[fieldName];

            if (localField != null) {
                var superField = superDS.getField(fieldName);
                //this.logWarn("local and super definition for field: " + fieldName +
                //             ", local field: " + this.echo(localField) +
                //             ", super field: " + this.echo(superField));
                // if a field is present in a sub-DS which is hidden in a superDS,
                // assume the intent was to expose it, unless "hidden='true'" is reiterated, or
                // some other property that would hide the field is specified.  Likewise for
                // visibility=internal.
                
                if (superField.hidden && localField.hidden == null && 
                    !localField.inapplicable) 
                {
                    //this.logWarn("dataSource: " + this + 
                    //             " overrides hidden field: " + fieldName +
                    //             " in superDS: " + superDS);
                    localField.hidden = false;
                }
                if (superField.visibility != null && localField.visibility == null &&
                    !localField.inapplicable && !localField.hidden && 
                    superField.visibility == "internal")
                {
                    //this.logWarn("dataSource: " + this + 
                    //             " overrides internal field: " + fieldName +
                    //             " in superDS: " + superDS);
                    localField.visibility = "external";
                }
                // local and super field definition: combine with overrides
                fields[fieldName] = superDS.combineFieldData(localField);
            } else {
                // field definition in parent only
                if (this.showLocalFieldsOnly) {
                    fields[fieldName] = isc.addProperties({}, superDS.getField(fieldName));
                    fields[fieldName].hidden = "true";
                } else {
                    fields[fieldName] = superDS.getField(fieldName);
                }
            }
            // check off this local field as having appeared in the parent already
            if (this.useParentFieldOrder) delete localFields[fieldName];
		}
        // add fields not declared in the parent
        if (this.useParentFieldOrder) isc.addProperties(fields, localFields);
    
        // special rule for XML schema: an xs:restriction is like showLocalFieldsOnly *except*
        // that attributes need not be redeclared to be valid in the derived type.
        // NOTE field order doesn't matter here; attributes are always at the end.
        if (this.restrictToLocalFields && isc.Schema && isc.isA.Schema(this)) {
            var parentFieldNames = superDS.getFieldNames();
            for (var i = 0; i < parentFieldNames.length; i++) {
                var fieldName = parentFieldNames[i],
                    parentField = superDS.getField(fieldName);

                if (parentField.xmlAttribute) {
                    fields[fieldName] = fields[fieldName] || parentField;
                }
            }
        }

		return this.mergedFields = fields;
	},

    // get all simple type fields, throughout this DataSource and any sub-DataSources
    getFlattenedFields : function (flatFields) {
        flatFields = flatFields || {}; // if called recursively, just add new fields to the
                                       // existing listing
        var fieldNames = this.getFieldNames();

        for (var i = 0; i < fieldNames.length; i++) {
            var fieldName = fieldNames[i],
                field = this.getField(fieldName);
            if (!this.fieldIsComplexType(fieldName)) {
                // first field with a given name wins (not clear what's best here)
                if (flatFields[fieldName] == null) {
                    // label the field with the DataSource it came from
                    field.sourceDS = this.ID; 
                    flatFields[fieldName] = field;
                }
            } else {
                var nestedDS = this.getSchema(field.type);
                nestedDS.getFlattenedFields(flatFields);
            }
        }
        return flatFields;
    },

    fieldIsComplexType : function (fieldName) {
        var field = this.getField(fieldName);
        return (field != null && field.type != null && !field.xmlAttribute &&
                this.getSchema(field.type) != null);
    },

    // find an XML tag that has the requested type, anywhere in the XML structure that this
    // DataSource and it's child tags represents.  Used for putting together a default
    // recordXPath when calling web services and probably not appropriate for anything else,
    // as the returned tagName isn't a path, just a tagName
    
    findTagOfType : function (targetType, parentSchema, parentFieldName) {
        // search for immediate fields of the target type
        var fieldNames = this.getFieldNames();
        for (var i = 0; i < fieldNames.length; i++) {
            var fieldName = fieldNames[i],
                field = this.getField(fieldName);
            if (field.type == targetType) return [this, fieldName, parentSchema, parentFieldName];
    
            // for complex type fields, check if they in turn have fields of the target type
            if (this.fieldIsComplexType(fieldName)) {
                //this.logWarn("recursing into childTag: " + this.echo(childTag));
                var childDS = this.getSchema(field.type),
                    childResult = childDS.findTagOfType(targetType, this, fieldName);
                if (childResult) return childResult;
            }
        }
    }, 

    // XML Text Content
    // ---------------------------------------------------------------------------------------
    

    // property to use to store textContent derived from an XML element that also has
    // attributes.  This currently only works for an XML element that has no element children.
    textContentProperty:"xmlTextContent",

    // return the field definition to be used for the text content of an XML element.
    // You can create a field for the textContent (in order to provide type) by just naming a
    // field after the textContentProperty.
    // The schemaTranslator, when encountering <xs:simpleContent>, creates a special field 
    // xsdSimpleContent and sets textContentProperty to match.
    getTextContentField : function () {
        return this.getField(this.textContentProperty);
    },

    // in the absence of an explicit textContentField
    hasXMLElementFields : function (textContentProperty) {
        textContentProperty = textContentProperty || this.textContentProperty;
        var fieldNames = this.getFieldNames();
        for (var i = 0; i < fieldNames.length; i++) {
            if (fieldNames[i] == textContentProperty) continue;
            if (this.getField(fieldNames[i]).xmlAttribute) continue;
            return true;
        }
        return false;
    },

    // EditMode
    // ---------------------------------------------------------------------------------------

    //>EditMode get the list of groups defined in the DataSource, which is the order the Groups
    // should appear in the component editor
    getGroups : function () {
        var ds = this;
        while (ds.groups == null && ds.hasSuperDS()) ds = ds.superDS();
        return ds.groups;
    },
    //<EditMode

    // return a field of the type specified by the dataSource ID passed in, searching in order of
    // subclass to superclass
    // includeAllFields: boolean; if true, advanced fields will be included in the search (default
    //   behaviour is to omit them)
    // excludedFields: a map of fields to be excluded from the search (keys and values are the
    //   field names)
    _$Defaults : "Defaults",
    _$Properties : "Properties",
    getObjectField : function (targetType, includeAllFields, excludedFields) {
        if (!targetType) return null;

        // search through fields in reverse order to find the best match
        var fields = this.getLocalFields(),
            fieldNames = isc.getKeys(fields).reverse(),
            classForType = isc.DataSource.getNearestSchemaClass(targetType)
        ;
        
        if (excludedFields == null) excludedFields = {};
        
        // search for the field that has the smallest inheritance distance to the test class
        var nearestDistance = -1,
            nearestMatch = null
        ;

        for (var i = 0; i < fieldNames.length; i++) {
            var fieldName = fieldNames[i],
                field = fields[fieldName],
                distance
            ;

            // HACK: ignore fields intended for properties to configure subobjects
            if (isc.endsWith(fieldName, this._$Properties) || 
                isc.endsWith(fieldName, this._$Defaults)) continue;

            // remember excluded fields, so we can pass the list to our superclass, so that a
            // we won't choose a field in a superclass that was marked "inapplicable" in a
            // subclass
            if (!includeAllFields && 
                (excludedFields[fieldName] || 
                 field.advanced || field.inapplicable || field.hidden ||
                 (field.visibility != null && field.visibility == "internal"))) 
            {
                excludedFields[fieldName] = fieldName;
                continue;
            }

            // If there is no class for the targetType, 
            // then don't try to find a best match based on inheritance distance, just find any
            // matching field
            if (!classForType && field.type == targetType) return fieldName;

            // find the field that is most specific to the targetType by evaluating inheritance
            // distance between the field type and the targetType
            if (classForType && classForType.isA(field.type)) {
                distance = isc.DS.getInheritanceDistance(field.type, targetType);
                //this.logWarn("field " + fieldName + 
                //             " has distance from type: " + distance); 
                if (nearestMatch == null || distance < nearestDistance) {
                    nearestMatch = fieldName;
                    nearestDistance = distance;
                }
            }
        }
        
        // match was found in the local fields of this datasource; if it has a superDS, get
        // the best match for the superDS and compare the inheritance distances, returning
        // the match with the smaller distance (if the distances are equal, return the match
        // from the local fields)
        if (nearestMatch != null) {
            if (nearestDistance == 0 || !this.hasSuperDS()) {
                return nearestMatch;
            } else {
                var superDSMatch = this.superDS().getObjectField(
                                        targetType, includeAllFields, excludedFields);
                if (superDSMatch) {
                    var fieldType = this.getField(superDSMatch).type,
                        superDSMatchDistance = isc.DS.getInheritanceDistance(fieldType,
                                                                             targetType);
                }
                
                return (superDSMatch && (superDSMatchDistance < nearestDistance)) 
                        ? superDSMatch : nearestMatch;
            }
        // no match was found in the local fields of this datasource, so return the best match
        // found for its superDS, if it has one (recursive search)
        } else if (this.hasSuperDS()) {
            return this.superDS().getObjectField(targetType, includeAllFields, excludedFields);
        }

        return null;
    },
    
        
    // Relationship detection 
	// --------------------------------------------------------------------------------------------
    // primary keys, foreign keys, within-DS relations like trees, cross-DS relations

	getLocalPrimaryKeyFields : function () {
		if (!this.primaryKeys) {
			this.primaryKeys = {};
			var fields = this.getFields();
			for (var fieldName in fields) {
				var fieldSpec = fields[fieldName];
				if (fieldSpec.primaryKey) {
					this.primaryKeys[fieldName] = fieldSpec;
				}
			}
		}
		return this.primaryKeys;
	},

    filterPrimaryKeyFields : function (records) {
        var fieldMask = this.getPrimaryKeyFields();
        return isc.applyMask(records, isc.getKeys(fieldMask));
    },

    filterDSFields : function (records) {
        var fieldMask = this.getFields();
        return isc.applyMask(records, isc.getKeys(fieldMask));
    },

    recordHasAllKeys : function (record) {
        var fields = this.getPrimaryKeyFields();
        for (var fieldName in fields) {
            if (record[fieldName] == null) return false;
        }
        return true;
    },

    // Given a foreign record and a foreignDS, returns a map where the keys are the names of
    // the fields in this datasources that are marked as foreignKey into the foreignDS and the
    // values are the foreignRecord values for the fields in the foreignDS that our foreignKeys
    // point into.
    getForeignKeysByRelation : function (foreignRecord, foreignDS) {
        // Figure out the foreignKeys of the ds that will store the binary value
        var foreignKeyFields = this.getForeignKeyFields(foreignDS);
        if (!foreignKeyFields) return {};

        // grab the foreignRecord values for our foreignKeys
        var record = {};
        for (var foreignKeyFieldName in foreignKeyFields) {
            var foreignKeyField = foreignKeyFields[foreignKeyFieldName];
            var foreignFieldName = isc.DataSource.getForeignFieldName(foreignKeyField);

            // don't return an undef or null for a primary key, just omit it
            var value = foreignRecord[foreignFieldName];
            if (value || value === 0) record[foreignKeyFieldName] = value;
        }
        return record;
    },
    
    // get the names of all primary key fields for this datasource
	getPrimaryKeyFields : function () {
		if (!this.mergedPrimaryKeys) {
			this.mergedPrimaryKeys = {};

			// if we have a superDS, merge those primaryKeys in first
			if (this.hasSuperDS()) {
				isc.addProperties(this.mergedPrimaryKeys, this.superDS().getPrimaryKeyFields());
			}

			// add local fields
			isc.addProperties(this.mergedPrimaryKeys, this.getLocalPrimaryKeyFields());			
		}
		return this.mergedPrimaryKeys;
	},

    // return all foreignKey fields defined on this ds.  If a foreignDS is specified, return
    // only the foreignKeys that point into the foreignDS
    getForeignKeyFields : function (foreignDS) {
        if (isc.isA.DataSource(foreignDS)) foreignDS = foreignDS.ID;

        var fields = this.getFields();
        if (!fields) return null;

        var foreignKeyFields = {};
        for (var fieldName in fields) {
            var field = fields[fieldName];
            if (field.foreignKey) {
                if (foreignDS) {
                    var fieldForeignDS = isc.DataSource.getForeignDSName(field, (foreignDS || this));
                    if (fieldForeignDS != foreignDS) continue;   
                }
                foreignKeyFields[field.name] = field;
            }
        }
        return foreignKeyFields;
    },

	getLocalPrimaryKeyFieldNames : function () {
		var localPrimaryKeyFields = this.getLocalPrimaryKeyFields();
		var localFieldNames = [];
		for (var fieldName in localPrimaryKeyFields) {
			localFieldNames.add(fieldName);
		}
		return localFieldNames;
	},

	getPrimaryKeyFieldNames : function () {
        return isc.getKeys(this.getPrimaryKeyFields());
    },

    // We only expose support for a single PK field, and aren't set up to handle multiple
    // PKs in most DataSource logic.
    // Add public accessor methods to retrieve this single PK
    
    //>@method DataSource.getPrimaryKeyField()
    // Returns a pointer to the primaryKey field for this DataSource
    // @return (DataSourceField) primary key field object
    // @visibility external
    //<
    getPrimaryKeyField : function () {
        var pks = this.getPrimaryKeyFields();
        for (var field in pks) {
            return pks[field];
        }
    },
    
    //>@method DataSource.getPrimaryKeyFieldName()
    // Returns the primary key fieldName for this DataSource
    // @return (string) primary key field name
    // @visibility external
    //<
    getPrimaryKeyFieldName : function () {
        return this.getPrimaryKeyFieldNames()[0];
    },


    // Relationships to other DataSources
	// --------------------------------------------------------------------------------------------
    addChildDataSource : function (dataSource) {
        var children = this._childDataSources = (this._childDataSources || []);
        children.add(dataSource);
    },

    getChildDataSources : function () {
        return this._childDataSources;
    },
    
    getChildDataSource : function (excludeSelf) {
        var childDSs = this.getChildDataSources();
        if (childDSs == null) return null;
        var dataSource;
        for (var i = 0; i < childDSs.length; i++) {
            if (!childDSs[i] || (excludeSelf && childDSs[i] == this)) continue;
            if (!dataSource) {
                dataSource = childDSs[i];
                // don't break - we want to notify the user when this method is returning
                // an ambiguous result
            } else if (dataSource != childDSs[i]) {
                this.logInfo("getChildDatasource(): This DataSource has multiple child " +
                    "DataSources defined making getChildDataSource() ambiguous. Returning the " +
                    "first child dataSource only - call getChildDataSources() to retrieve a " +
                     "complete list.");
                break;
            }
        }
        return dataSource
    },
    
    // get the default tree relationship declared for this DataSource, or null if no tree
    // relationship can be detected.
    // The returned relationship is of the form 
    //            { parentIdField : [fieldName], 
    //              idField : [fieldName],
    //              childrenProperty: [fieldName],
    //              parentDS : [dataSource name]}
    // XXX multi-field relations are not currently supported
    //
    // If parentDS is not passed in it will be autodected from either the first foreignKey found on
    // this DS or the one specified via foreignKeyFieldName (second arg).
    //
    // If foreignKeyFieldName is not passed in, we find the first field on this DS that has a
    // foreignKey definition and use that.
    // Note that a valid hierachical dataSource should have either a foreignKey or 
    // childrenProperty field (or both) specified as otherwise we won't be able to link 
    // records as parents/children.
    getTreeRelationship : function (parentDS, foreignKeyFieldName) {
        
        // make sure we have DS instance
        if (isc.isA.String(parentDS)) parentDS = this.getSchema(parentDS);

        

        // if the name of the foreignKey wasn't passed in, autodetect it by looking for the first
        // field on this ds with the foreignKey property set on it.
        var fields = this.getFields();
        if (foreignKeyFieldName == null) {
            for (var fieldName in fields) {
                var currentField = fields[fieldName];
                if (currentField.foreignKey != null) {
                    foreignKeyFieldName = fieldName;
                    break;
                }
            }
        }

        var targetField;
        // if there was no foreignKey property specified on any of the fields, find the first
        // exact field name match between the two datasources.
        if ( foreignKeyFieldName == null && parentDS) {
            foreignKeyFieldName = targetField = isc.getKeys(this.fields).intersect(isc.getKeys(parentDS.fields))[0];
            this.logWarn("matched tree relationship field by name: " + foreignKeyFieldName);
        }

        var field;
        if (foreignKeyFieldName) field = fields[foreignKeyFieldName];

        //>DEBUG
        if (field == null) {
            // This is acceptable - it can occur children are served up as arrays directly on nodes.
            this.logDebug("getTreeRelationship(): Unable to find foreignKeyField." +
                          "foreignKeyFieldName specified as:" + foreignKeyFieldName);
        }
        //<DEBUG    

        // if parentDS was not passed in and we have a foreignKey field
        // parse it out of the foreignKey property of the field
        if (!parentDS) {
            if (!field) parentDS = this;
            else {
                var parentDSName = isc.DataSource.getForeignDSName(field, this);
                parentDS = this.getSchema(parentDSName);
            }
        }

        if (!targetField) targetField = field ? isc.DataSource.getForeignFieldName(field) : null;
            
        if (targetField == null) {
            // target field not specified; assume primary key.  Get the primary key of the
            // parent dataSource, limiting to one field
            var idField = parentDS.getPrimaryKeyFieldNames();
            if (isc.isAn.Array(idField)) {
                //>DEBUG
                if (idField.length > 1) {
                    this.logWarn("getTreeRelationship: dataSource '" + parentDS.ID + 
                                 "' has multi-field primary key, which is not " + 
                                 "supported for tree viewing.  Using field '" +
                                 idField[0] + "' as the only primary key field");
                }
                //<DEBUG
                idField = idField[0];
            }
            targetField = idField;
        }

        var isFolderField;
        var childrenProperty;

        // Suppoert dataSource.childrenField as well as the dataSourceField.childrenProperty 
        // boolean
        if (this.childrenField) childrenProperty = this.childrenField;

        for (fieldName in fields) {
            var field = fields[fieldName];
            // autodetect a field marked as the 'isFolderProperty' and 'childrenProperty' and
            // make that available via the relationship
            if (field.isFolderProperty) isFolderField = fieldName;
            if (field.childrenProperty) childrenProperty = fieldName;

            // By default, set field.multiple to true for the children field.
            // This expects XML type data to have explicit an array of child elements under
            // the childrenProperty node - like this:
            //   <item name=.../>
            //      <children>
            //          <item name=.../>
            //          <item name=.../>
            //      </children>
            //   </item>
            // However - if field.multiple is set to false, dont override it.
            // When this property is set to false, the server can still deliver an array of
            // elements by simply having a number of same-named child nodes - like this:
            //  <item name=.../>
            //      <child name=.../>
            //      <child name=.../>
            //  </item>
            if (childrenProperty == fieldName && (field.multiple == null)) {
                field.multiple = true;
            }
        }

        var relationship = {
            childDS : this,
            parentDS : parentDS,
            isFolderProperty: isFolderField
        }
        // the field on this DataSource with the foreignKey declaration
        // points to "idField" on the parent DataSource
        if (foreignKeyFieldName) {
            relationship.parentIdField = foreignKeyFieldName;
            relationship.idField = targetField;
        }
        if (childrenProperty) relationship.childrenProperty = childrenProperty;
        
        // If both foreignKey field name and childrenProperty are null there's no way we can
        // serve up children meaningfully:
        // This is not necessarily an error - this method may be called when there is no
        // foreignKey relationship -- EG databound treeGrid drop
        //>DEBUG
        if (childrenProperty == null && foreignKeyFieldName == null) {
            this.logInfo("getTreeRelationship(): No specified foreignKeyField or childrenProperty.")
        }
        //<DEBUG

        // determine the rootValue.  This applies only to within-DataSource trees; for
        // cross-DataSource trees, in effect all records of the parentDS are roots.
        // rootValue defaults to null.
        if (parentDS == this) {
            var rootValue = foreignKeyFieldName ? this.getField(foreignKeyFieldName).rootValue : null;
            
            if (rootValue == null) relationship.rootValue = null;
            else relationship.rootValue = rootValue;
        }

        // NOTE: there may be more than one tree relationship.  For now we're just
        // auto-detecting the first.
        
        return relationship;
    },

    // DataBinding support
	// --------------------------------------------------------------------------------------------
 
    _$name:"name",
    combineFieldOrders : function (parentFields, localFields, shouldUseFieldFunc) {
        // all the fields in the DataSource that would normally be shown will be shown in the
        // order they occur in the DataSource.  The specified fields act as overrides.
        // NOTE: in this mode, if you specify any non-DataSource fields, they appear right
        // after the last DataSource field you added.  In this way you can add extra
        // fields, or items like spacers, at specific positions with respect to DataSource
        // fields.

        // create a new array to hold the combined field specifications
        var combinedFields = [];

        // add any non-DS fields before the first DS field
        this._addNonDSFields(localFields, 0, parentFields, combinedFields, shouldUseFieldFunc);

        // go through all dataSource fields
		for (var fieldName in parentFields) {
            var parentField = parentFields[fieldName],
                // look for a localField with matching name (this is slow but not time
                // critical)
                localFieldIndex = 
                    localFields.findIndex(this._$name, fieldName);

            if (localFieldIndex != -1) {
                // combine the specified field and the reference dsField
                var localField = localFields[localFieldIndex],
                    combinedField = this.combineFieldData(localField, true);

                // check if this is a field this component should use.  NOTE: we check this
                // after combining, so that you can suppress a dsField by adding hidden:true
                if (shouldUseFieldFunc == null ||
                    shouldUseFieldFunc(combinedField, this)) combinedFields.add(combinedField);

                // if there are any non-dataSource fields specified after this dsField, add them
                // here
                this._addNonDSFields(localFields, localFieldIndex + 1,
                                     parentFields, combinedFields, shouldUseFieldFunc);
            } else {
                // no specified field data for this dsField, just clone the dsField
                if (shouldUseFieldFunc == null ||
                    shouldUseFieldFunc(parentField, this)) {
                    combinedFields.add(isc.addProperties({}, parentField));
                }
            }
		}
        return combinedFields;
    },

    // starting at position, add in any fields that don't refer to DataSource fields
    _addNonDSFields : function (localFields, position, parentFields, combinedFields,
                                shouldUseFieldFunc) 
    {
        for (var i = position; i < localFields.length; i++) {
            var field = localFields[i];
            // field refers to a DataSource field; stop
            if (field.name != null && parentFields[field.name] != null) return;

            if (shouldUseFieldFunc == null ||
                !shouldUseFieldFunc(field, this)) continue;

            // field doesn't refer to a DataSource field; add it and continue
            // NOTE: type defaults are auto-applied to DS fields and combined fields
            isc.SimpleType.addTypeDefaults(field);
            combinedFields.add(field);
        }
    },
   
    //> @method combineFieldData()  ([IA])
    //  Internal method to combine data from a field defined on the dataSource with a field object
    //  passed in.
    // @param   field   (object)    field to update with DS field defaults.
    // @return  (object)            field with its data combined with the DS data
    // @visibility internal
    //<
    
    combineFieldData : function (localField) {
        var parentField = this.getField(localField.name);
        if (parentField == null) return localField; // no such dataSource field

        for (var propertyName in parentField) {
            // validators should be combined, not overridden
            if (propertyName == "validators" && localField.validators != null && 
                parentField.validators != localField.validators) 
            {
                for (var i =0; i < parentField.validators.length; i++) {
                    var dsValidator = parentField.validators[i];
                    //this.logWarn("comparing validators in field: " + field.name);
                    // This check is required as if 'combineFieldData' gets called more than once
                    // on the same field object (or on 2 field objects pointing to the same 
                    // validators array), we can end up with duplicate validator objects.
                    if (!localField.validators.contains(dsValidator)) {
                        // if the field is using the shared, default validators for the type, 
                        // make a copy before modifying
                        if (localField.validators._typeValidators) {
                            localField.validators = localField.validators.duplicate();
                        }
                        localField.validators.add(dsValidator);
                    }
                }
                continue;
            }

            // datasource properties act as defaults - they don't override
            if (localField[propertyName] != null) continue;

            // copy any properties the field does not have a value for
            localField[propertyName] = parentField[propertyName];
        }
        return localField;
    },

    // SimpleType handling: local types and type defaults
	// ----------------------------------------------------------------------------------------

    // add validators and other defaults that can be declared as part of a type to the field
    // definition.  NOTE: DataSources do this once on init.  fields that don't come from a
    // DataSource do this during DataBinding (see Canvas.bindtoDataSource)
    _addTypeDefaults : function (fields) {
        
        if (fields == null) fields = this.fields;

        // add validators to each field, based on the specified type for the field
        for (var fieldName in fields) {
            var field = fields[fieldName];
            
            if (field && field.required == null && field.xmlRequired != null && 
                field.xmlNonEmpty != null) 
            {
                field.required = field.xmlRequired && field.xmlNonEmpty
            }

            // if a field is marked as the childrenProperty
            if (field && (field.childrenProperty || field.name == this.childrenField)) {
                            
                // for correct recursive transform of either XML or JSON, it needs to have the
                // type of this DataSource.
                if (!field.type) field.type = this.ID;
            }

            isc.SimpleType.addTypeDefaults(field, this);
        }
    },
        
    _autoDeriveTitles : function() {
        if (!this.autoDeriveTitles) return;
        for (var fieldName in this.fields) {
            var field = this.fields[fieldName];
            if (field.title && field.title != "") continue;

            // Replace underscores with spaces
            work = fieldName.replace(/_/g, " ");
            // Trim whitespace off the beginning and end - this will also get rid of spare 
            // whitespace introduced by leading or trailing underscores
            var work = work.replace(/^\s+|\s+$/g, "");
            if (work == work.toUpperCase() || work == work.toLowerCase()) {
                // All one case.  Convert to lowercase and then capitalize the first letter
                // of each word
                work = work.toLowerCase();
                var capNext = true;
                var title = "";
                for (var i = 0; i < work.length; i++) {
                    var letter = work.substr(i, 1);
                    if (capNext) {
                        letter = letter.toUpperCase();
                        capNext = false;
                    }
                    if (letter == ' ') capNext = true;
                    title = title + letter;
                }
            } else {
                // camelCase.  A new word starts every place an upper-case letter follows 
                // a lower-case letter, or when a sequence of upper-case letters (eg, HTTP)
                // ends (plus the first letter of the name, of course)
                title = work.substr(0,1).toUpperCase();
                var capLast = work.substr(0,1) == work.substr(0,1).toUpperCase();
                var capSeq = false;
                for (var i = 1; i < work.length; i++) {
                    var letter = work.substr(i, 1);
                    if (capSeq && letter == letter.toLowerCase()) {
                        capSeq = false;
                        title = title.substr(0, title.length - 1) + " " + 
                                title.substr(title.length - 1);
                    }
                    if (capLast && letter == letter.toUpperCase()) {
                        capSeq = true;
                    }
                    if (!capLast && letter == letter.toUpperCase()) {
                        title = title + " ";
                    } 
                    capLast = letter == letter.toUpperCase();
                    title = title + letter;
                }
            }
            field.title = title;
        }
    }, 

    // get the type object for the specified typeName, if any, taking into account types
    // declared just on this DataSource
    getType : function (typeName) {
        // search for globally defined type first
        var type = isc.SimpleType.getType(typeName);
        if (type != null) return type;
        // then search for locally defined types
        if (this.types && this.types[typeName]) return this.types[typeName];
        return null;
    },
    
    //>LocalDS mode (serverless DataSource)
	// -----------------------------------------------------------------------------------------

    fetchingClientOnlyData : function (dsRequest) 
    { 
        // mark the request client-only: this causes the RPCManager to avoid sending
        // this RPC to the server.  Note that, if clientOnly requests were not allowed to be
        // involved in transactions, we could just fire the passed-in callback immediately with
        // the client-only dsResult
        if (this.clientOnly) dsRequest.clientOnly = true;

        // if we're deferring requests, add request to queue and return
        if (this._deferredRequests) {
            this._deferredRequests.add(dsRequest);
            return true; // request has been deferred, return true to halt further processing
        }

        // if we're in clientOnly mode and there's no testData, but we do have a dataURL or
        // testFileName, do a one-time load, then re-run current operation against the
        // resulting testData.
        if (this.clientOnly && !this.testData && (this.testFileName || this.dataURL)) {
            // defer all other operations against this datasource until this fetch
            // completes, starting with this one
            this._deferredRequests = [dsRequest];

            // perform a one-time fetch by creating a datasource that picks up the fields,
            // but not the operationBindings or other properties.  This way we don't have
            // to muck with this DS and try to restore settings

            // if only testFileName is set, use that as the dataURL
            var dataURL = this.dataURL || this.testFileName;

            // if dataFormat is the default iscServer, set it based on the file extension
            // of the dataURL, since it doesn't really make sense to have a clientOnly
            // dataSource of type iscServer
            var dataFormat = this.getDataFormat(dsRequest);
            if (dataFormat == "iscServer") dataFormat = dataURL.match(/\.xml$/i) ? "xml" : "json";

            var operationBinding = this.getOperationBinding(dsRequest);
            var oneTimeDS = isc.DataSource.create({
                ID: this.ID+"_oneTime",
                inheritsFrom: this.ID,
                dataURL: dataURL,
                dataFormat: dataFormat,
                recordXPath: this.recordXPath,
                // use our transformRequest/response on the one-time DS to canonicalize data to
                // our internal testData format.
                transformRequest: this.transformRequest,
                transformResponse: this.transformResponse,
                recordName: operationBinding.recordName || this.ID,
                showPrompt: this.showPrompt
            });
            this.logInfo("clientOnly datasource performing one-time " + dataFormat +
                         " fetch via: " + dataURL);

            // reset our tranformRequest/response to default DataSource versions b/c we'll
            // be working against a local testData from now on and transforms no longer apply.
            this.addProperties({
                transformRequest: isc.DataSource.getInstanceProperty("transformRequest"),
                transformResponse: isc.DataSource.getInstanceProperty("transformResponse")
            });

            var ds = this;
            // note: don't pass criteria to the one-time fetch as we want to fetch all the
            // records for our cache, we'll apply the criteria in a follow-up local
            // operation against the cache 
            oneTimeDS.sendDSRequest({
                operationType : "fetch",
                callback : function (dsResponse, data) {
                    if (dsResponse.status != isc.DSResponse.STATUS_SUCCESS) {
                        ds.logWarn("one-time fetch failed with status: " + dsResponse.status +
                                   " and messsage: " + (data ? data : "N/A") + 
                                   ".  Initializing an empty Array as testData.");
                        ds.testData = [];
                    } else {
                        ds.logInfo("One-time fetch complete: "+ (data ? data.length : "null") + " records");
    
                        ds.testData = ds.initializeSequenceFields(data);
                    }            
        
                    var deferredRequests = ds._deferredRequests;
                    delete ds._deferredRequests;
                    // call all deferred requests
                    for (var i = 0; i < deferredRequests.length; i++) {
                        ds.sendDSRequest(deferredRequests[i]);
                    }
                    oneTimeDS.destroy();
                },
                willHandleError:true
            });

            return true; // request has been deferred, return true to halt further processing
        }
    },

	// return appropriate results object from local data based on the rpcRequest/ dsRequest
    // object passed in
	getClientOnlyResult : function (rpcRequest) {
        var request = rpcRequest._dsRequest;

        //!OBFUSCATEOK
        // initialize the spoofed dataset
        var serverData = this.testData;
        if (!serverData || isc.isA.String(serverData)) {
		    if (isc.isA.String(serverData)) {
                // ID or expression
                //>DEBUG
				this.logInfo(this.ID + " datasource: using testData property as data");
                //<DEBUG
                this.testData = isc.eval(serverData);
			} else if (window[this.ID + "TestData"]) {
                // dataset loaded in page under canonical name
                //>DEBUG
				this.logInfo(this.ID + " datasource: using " + this.ID + "TestData object as data");
                //<DEBUG
				this.testData = window[this.ID + "TestData"];
            } else {
                // initialize to empty list
                //>DEBUG
				this.logInfo(this.ID + " datasource: testData property and " + this.ID +
							 "TestData object not found, using empty list as data");
                //<DEBUG
				this.testData = [];
			}
        }
        serverData = this.testData;

		var operationType = request.operationType,
			response = {
				status:0
			};

		switch (operationType) {
			case "fetch":
			case "select":
			case "filter":
                var criteria = request.data;
                // support multiple where clause format (don't think this is actually valid any
                // more)
                if (isc.isAn.Array(criteria)) criteria = criteria[0];
                var filteredData = this.applyFilter(serverData, criteria, request),
                    resultData = filteredData;

                if (request.startRow != null) {
                    // similate paging
                    var startRow = request.startRow,
                        endRow = request.endRow,
                        totalRows = filteredData.length;

                    // server handles sort, so sort the data by the requested direction
                    
                    var sortProperty = request.sortBy;
                    if (sortProperty) {
                        var sortDirection = true; 
                        if (sortProperty.startsWith("-")) {
                            sortProperty = sortProperty.substring(1);
                            sortDirection = false;
                        }
                        filteredData.sortByProperty(sortProperty, sortDirection);
                    }

                    // cap the endRow at the last valid index
                    endRow = Math.min(endRow, totalRows-1);
                    // slice out from startRow to endRow (note: slice is non-inclusive at the end)
				    resultData = filteredData.slice(startRow, endRow+1);
                    response.startRow = startRow;
                    response.endRow = endRow;
                    response.totalRows = totalRows;
                }

                // shallow copy the results.  This allows test or example cases where the
                // "server data set" is changing independantly of the client results
                if (this.copyLocalResults) { 
                    for (var i = 0; i < resultData.length; i++) {
                        resultData[i] = isc.addProperties({}, resultData[i]);
                    }
                }

                response.data = resultData;
				break;
            // NOTE: for modification operations, we always return a copy, "copyLocalResults"
            // doesn't need to be set.
			case "remove":
			case "delete": // old name       
                var serverRecordIndex = this.findByKeys(request.data, serverData);
                if (serverRecordIndex == -1) {
                    this.logWarn("clientOnly remove operation: Unable to find record matching criteria:" 
                                + this.echo(request.data));
                } else {
                    serverData.removeAt(serverRecordIndex);
    				response.data = isc.addProperties({}, request.data);
                }
				break;
			case "add": 
			case "insert": // old name
                // Generate values for sequence fields at this point
                var serverRecord = isc.addProperties({}, request.data);
                serverRecord = this.applySequenceFields(serverRecord);
                
                // make both the saved data and returned data a distinct copy 
                // from the passed data
                serverData.add(serverRecord);
				response.data = isc.addProperties({}, serverRecord);
				break;
			case "replace":
			case "update":
                // find the server record
                var serverRecordIndex = this.findByKeys(request.data, serverData);
                if (serverRecordIndex == -1) {
                    this.logWarn("clientOnly update operation: Unable to find record matching criteria:" 
                                + this.echo(request.data));
                } else {
                    var serverRecord = serverData[serverRecordIndex];
                    // update the server record in place
                    isc.addProperties(serverRecord, request.data);
                    // return a copy
	    			response.data = isc.addProperties({}, serverRecord);
                }
				break;
			case "validate":
			default:
				break;
		}
		return response;
	},
    
    // Generating sequence values in client-only mode
    getNextSequenceValue : function (field) {
        var data = this.testData,
            value = 0;
        for (var i = 0; i < data.length; i++) {
            var fieldValue = data[i][field.name];
            if (fieldValue != null && fieldValue > value) value = fieldValue;
        }
        // So this returns the largest of the stored values, +1
        return value+1;
    },
    
    applySequenceFields : function (record) {

        if (!this.clientOnly) {
            
            return;
        }
        
        var fields = this.getFields();
        for (var fieldName in fields) {
            var field = fields[fieldName];
            // also auto-gen primaryKeys that may not be of type="sequence"
            if ((field.type == "sequence" || field.primaryKey) && record[fieldName] == null) {   
                record[fieldName] = this.getNextSequenceValue(field);
            }
        }
        return record;
    },
                      

    // generate primary keys in test data if not present (as frequently happens
    // where the storage layer is intended to auto-assign the primaryKey values
    // - e.g. Database sequences)
    //
    // This method assumes a potentially large number of records, where calling
    // applySequenceFields() per record would not be appropriate.  Part of the optimization
    // here is that we don't bother supporting gappy records - in other words, the primaryKeys
    // are either present or they're not - we don't attempt to intelligently fill them in as that
    // can be too slow
    initializeSequenceFields : function (records) {
        if (!isc.isAn.Array(records)) return;

        var fields = this.getFields();
        var sequenceFields = [];
        for (var fieldName in fields) {
            if (fields[fieldName].type == "sequence" || fields[fieldName].primaryKey) sequenceFields.add(fieldName);
        }

        for (var i = 0; i < records.length; i++) {
            for (var j = 0; j < sequenceFields.length; j++) {
                var fieldName = sequenceFields[j];
                if (records[i][fieldName] == null) records[i][fieldName] = i;
            }
        }
        return records;
    },

    //<LocalDS
    
	// Local Filtering 
	// --------------------------------------------------------------------------------------------

	// given values for the primary key fields, find the index of the unique matching record
	findByKeys : function (record, recordSet, pos, endPos) {
        return recordSet.findByKeys(record, this, pos, endPos);
	},

    //> @method dataSource.applyFilter()
    // Returns records in the passed Array that match the provided filter
    // +link{type:Criteria,criteria}.
    // <P>
    // By default:
    // <ul>
    // <li> any criteria that do not correspond to a DataSource field are ignored
    // <li> any null or empty string criteria are ignored
    // <li> all other criteria are passed to +link{fieldMatchesFilter()}
    // </ul>
    // This method is called by +link{resultSet.applyFilter()} to provide filtering when a
    // ResultSet has a complete cache and filtering can be performed client-side.  You may want
    // to override this method in order to mimic the filtering behavior that your server performs.
    //
    // @param   data        (Array)     the list of rows
    // @param   criteria    (Criteria)  the filter criteria
    // @param   [requestProperties]   (DSRequest Properties)  optional dataSource request properties
    // @return  (Array)     the list of matching rows
    // @visibility external
    //<
	applyFilter : function (data, criteria, requestProperties) {
		var output = [];
		if (!data || data.length == 0) return output;
		
		// If our criteria object is of type AdvancedCriteria, go down the new
		// AdvancedFilter codepath
		if (criteria && criteria._constructor == "AdvancedCriteria") {
		    return this.recordsMatchingAdvancedFilter(data, criteria, requestProperties);
		}

		// go through the list of items and add any items that match the criteria to the
		// output
		return this.recordsMatchingFilter(data, criteria, requestProperties);
	},
	
    // currently only applies to simple filtering, and not doc'd
    dropUnknownCriteria:true,

	// return the records matching the criteria passed in
	recordsMatchingFilter : function (records, filter, requestProperties) {
        var filterFields = isc.getKeys(filter),
            filterFieldsLength = filterFields.length,
            matches = [],
            record,
            match,
            fieldName,
            fieldValue,
            filterValue,
            j;

        for (var i = 0, l = records.length; i < l; i++) {
            record = records[i];
            if (record == null) continue;
            match = true;

            for (j = 0; j < filterFieldsLength; j++) {
                fieldName = filterFields[j];
                
                if (fieldName == null) continue; // null property in criteria
                // Ignore fields that aren't present in the DataSource.  This allows criteria
                // unrelated to the fields to be present but not interpreted by DataSource
                // filtering (eg, possibly only interpreted by server filtering)
                if (this.dropUnknownCriteria && !this.getField(fieldName)) continue;
                
                fieldValue = record[fieldName];
                filterValue = filter[fieldName];
                
                if (!this.fieldMatchesFilter(fieldValue, filterValue, requestProperties)) {
                    match = false; break;
                }
            }
            if (match) matches.add(record);
		}
		return matches;
	},

	recordMatchesFilter : function (record, filter, requestProperties) {
        return this.recordsMatchingFilter([record], filter, requestProperties).length > 0;
    },

    //> @method dataSource.fieldMatchesFilter()
    // Compares a criteria value to a field value and returns whether they match, as follows:
    // <ul>
    // <li> any non-String filter value is directly compared (==) to the field value
    // <li> any String filter value is compared according to
    //      +link{dsRequest.textMatchStyle} in the passed <code>requestProperties</code>,
    //      regardless of the actual field type
    // <li> if the filter value is an Array, it matches if the field value is contained in the
    //      Array
    // </ul>
    // @param   fieldValue  (object)    field value to be compared
    // @param   filterValue (object)    filter value to be compared
    // @param   [requestProperties]   (DSRequest Properties)  optional dataSource request properties 
    // @return  (boolean)               true if the filter and field values match, false otherwise
    // @visibility external
    //<
    _$startsWith : "startsWith", _$substring : "substring", _$exact:"exact",
    fieldMatchesFilter : function (fieldValue, filterValue, requestProperties) {
        // note: in general the fieldValues are part of records that came from the server and are
        // generally of the same type as the DataSource field.  The filterValues come from a form 
        // and are generally strings (3/25/02), even if the field is numeric.

		// handle multiple selects (array of filter values)
        
		if (isc.isAn.Array(filterValue)) {
			if (filterValue.contains(fieldValue)) return true;
			return false;
		}
			
        if (isc.isA.Date(fieldValue) && isc.isA.Date(filterValue)) {
            return (Date.compareDates(fieldValue, filterValue) == 0)
        }

		if (!isc.isA.String(fieldValue) && !isc.isA.String(filterValue)) {        
			// if both are non-string values, use direct comparison
            // XXX really, we need some way that you can supply a comparison function for comparing
            // two instances of a custom type.
            
			//>DEBUG
            if (this.logIsDebugEnabled()) {
                this.logDebug("Direct compare: " + fieldValue + "==" + filterValue);
            }
			//<DEBUG
			return (fieldValue == filterValue); 
		}
        // Convert nulls to emptyStrings
        
        if (filterValue == null) filterValue = isc.emptyString;
        if (fieldValue == null) fieldValue = isc.emptyString;
			
        // if the field is a string or is numeric, we want to do substring match.  Thus "part"
        // matches "part number" and "17" matches "017395".
        
        // convert both field and filter value to strings (note: they need to be strings because we
        // actually call string methods on them)
        if (!isc.isA.String(fieldValue)) fieldValue = fieldValue.toString();
        if (!isc.isA.String(filterValue)) filterValue = filterValue.toString();
        if (!this.filterIsCaseSensitive) {
            fieldValue = fieldValue.toLocaleLowerCase();
            filterValue = filterValue.toLocaleLowerCase();
        }
        
        // Pick up textMatchStyle from the request, if present
        var textMatchStyle;
        if (requestProperties) textMatchStyle = requestProperties.textMatchStyle;
        // Normalize unsupported text match style to the default
        if (!this.supportsTextMatchStyle(textMatchStyle)) {
            // Only warn once for each text match style for this dataSource
            if (!this._warnedUnsupportedTMS) this._warnedUnsupportedTMS = {};
            if (!this._warnedUnsupportedTMS[textMatchStyle]) {
                this.logWarn("Text match style specified as '" + textMatchStyle + 
                             "': This is not supported for" +
                             " this dataSource - performing a substring match instead");
                this._warnedUnsupportedTMS[textMatchStyle] = true;
            }
            textMatchStyle = this.getTextMatchStyle(textMatchStyle);
        }

        if (textMatchStyle == this._$startsWith) {
            return isc.startsWith(fieldValue, filterValue);
        } else if (textMatchStyle == this._$substring) {        
            return isc.contains(fieldValue, filterValue); 
        // Default to exact match if textMatchStyle is unset. This matches standard fetch
        // behavior
        } else {
            return fieldValue == filterValue;
        }
	},
    
    _$iscServer:"iscServer",
    //> @method  dataSource.supportsTextMatchStyle() (A)
    // Does this dataSource support the specified "textMatchStyle" when performing a filter
    // operation against a text field.
    // @param textMatchStyle (string) textMatchStyle to check. If passed a null value, assume
    //                                an exact match is being requested.
    // @visibility external
    //<
    supportsTextMatchStyle : function (style) {
        // Assume completely custom DataSources can handle any textMatchStyle, as they can
        // be completely custom coded
        if (!this.clientOnly && (this.dataFormat != this._$iscServer)) return true;
        
        // ISC-Server backed dataSources don't support startsWith
        if (style == this._$startsWith && !this.clientOnly) return false;
        
        // return false if passed an unrecognized textMatchStyle string for standard 
        // ISCServer / client only dataSources
        return (style == null || style == this._$substring || style == this._$exact);
    },

    // getTextMatchStyle()
    // Normalizes unsupported text match style to a default
    getTextMatchStyle : function (style) {
        
        if (style == null) style = this._$exact;
        if (!this.supportsTextMatchStyle(style)) {
            
            style = this._$substring;
        }
        return style;
    },
    
    // compareTextMatchStyle()
    // When changing to a new text match style, is the new style 'less restrictive'? 
    // Returns 0 if the text match style is unchanged,
    // -1 if the filter is less restrictive (So we would have to hit the server for new data
    // even if new criteria are unchanged or more restrictive)
    // 1 if the filter is more restrictive (meaning depending on the criteria we should be
    // able to perform a local filter of the client data when new criteria are set).
    compareTextMatchStyle : function (newStyle, oldStyle) {
        newStyle = this.getTextMatchStyle(newStyle);
        oldStyle = this.getTextMatchStyle(oldStyle);

        // Note: If new and old style match we'll look at the criteria to determine 
        // whether a server fetch will be required.
        if (newStyle == oldStyle) return 0;
        
        // exact is the most restrictive, the startsWith (then substring)
        if (newStyle == this._$exact) return 1;
        if (oldStyle == this._$exact) return -1;
        if (newStyle == this._$startsWith) return 1;
        return -1;  
    },
    
    //> @method dataSource.compareCriteria()
    // Given two sets of criteria, determine whether they are equivalent, the new criteria is
    // guaranteed more restrictive, or the new criteria is not guaranteed more restrictive,
    // returning 0, 1 or -1 respectively.
    // <P>
    // By default (+link{criteriaPolicy}:"dropOnShortening"), returns:
    // <ul>
    // <li> -1 if the new criteria has fewer properties than the old criteria (indicating that it
    //      isn't more restrictive)
    // <li> -1 if the value for any property in the old criteria is an array and 1) the value for
    //      the same property in the new criteria isn't an array, or 2) is an array but
    //      of different length, or 3) the arrays do not contain the exact same set of objects
    //      (order can be different)
    // <li> -1 if the value for any given property in the old criteria is not an array, and the
    //      the value for the same property property in the new criteria is different
    // <li> -1 if both values for a given property are strings and the new criteria value doesn't
    //      contain the new criteria value
    // <li> 1 if none of the above are true and for at least one of the properties, the
    //      respective criteria values are both strings, and the old criteria value is a substring
    //      of, and is shorter than, the new criteria value
    // <li> 0 otherwise (indicating the sets of criteria are equivalent)
    // </ul>
    // <P>
    // For (+link{criteriaPolicy}:"dropOnChange"), returns:
    // <ul>
    // <li> -1 if the two sets of criteria have a different number of properties
    // <li> -1 if the value for any property in the old criteria is an array and 1) the value for
    //      the same property in the new criteria isn't an array, or 2) is an array but
    //      of different length, or 3) the arrays do not contain the exact same set of objects
    //      (order can be different)
    // <li> -1 if the value for any given property in the old criteria is not an array, and the
    //      the value for the same property property in the new criteria is different
    // <li> 0 otherwise (indicating the sets of criteria are equivalent)
    // </ul>
    // This method is called by +link{resultSet.compareCriteria()} to determine whether a change
    // in criteria should cause the cache to be invalidated. You may want
    // to override this method in order to mimic the filtering behavior that your server performs.
    //
    // @param   newCriteria     (Criteria)  new filter criteria
    // @param   oldCriteria     (Criteria)  previous filter criteria
    // @param   [requestProperties]     (DSRequest Properties)  dataSource request properties
    // @param   [policy]        (string)    overrides +link{criteriaPolicy}
    // @return  (Number)    0 if the filters are equivalent, 1 if newCriteria is guaranteed more
    //                      restrictive, and -1 if newCriteria is not guaranteed more restrictive
    // @see criteriaPolicy
    // @visibility external
    //<
    compareCriteria : function (newCriteria, oldCriteria, requestProperties, policy) {
        //>DEBUG
        if (this.logIsInfoEnabled()) {
            this.logInfo("Comparing criteria, oldCriteria:\n" + this.echo(oldCriteria) +
                         "\nnewCriteria:\n" + this.echo(newCriteria) + 
                         ", policy: " + (policy || this.criteriaPolicy));
        }
        //<DEBUG

        if (oldCriteria == null) return -1;

        // get the textMatchStyle to be used with simple criteria
        var textMatchStyle = this.getTextMatchStyle(requestProperties ?
                                                    requestProperties.textMatchStyle : null);
		
        // If our criteria objects are of type AdvancedCriteria, go down the new
        // AdvancedFilter codepath
        if (newCriteria._constructor == "AdvancedCriteria") {
            if (oldCriteria && oldCriteria._constructor == "AdvancedCriteria") {
                return this.compareAdvancedCriteria(newCriteria, oldCriteria, 
				                                    requestProperties, policy);
            }
			// Special case: if the old criteria was null or the propertyless object, we're going from 
			// no filter criteria to some filter criteria - so we know we're guaranteed to be more 
			// restrictive (or at least, not to be less restrictive), so we can return 1.
			if (oldCriteria == null) return 1;

			var j = 0;
			for (var i in oldCriteria) j++;
			if (j == 0) return 1; 

			// We have a mix of basic and advanced criteria types - convert the basic criteria
            // object to an equivalent AdvancedCriteria.
            // (NOTE - this code is here as a catch-all only. ResultSet.setCriteria() explicitly 
            //  converts basic criteria to AdvancedCriteria as required, so we should never get as 
            //  far as this)
            oldCriteria = this.convertCriteria(oldCriteria, textMatchStyle);
            return this.compareAdvancedCriteria(newCriteria, oldCriteria, 
			                                    requestProperties, policy);
        } else {

            if (oldCriteria && oldCriteria._constructor == "AdvancedCriteria") {
    			// We have a mix of basic and advanced criteria types - convert the basic criteria
                // object to an equivalent AdvancedCriteria
                newCriteria = this.convertCriteria(newCriteria, textMatchStyle);
                return this.compareAdvancedCriteria(newCriteria, oldCriteria, 
    			                                    requestProperties, policy);
            }
        }
        
        policy = policy || this.criteriaPolicy;
    
        if (policy == "dropOnShortening") {
            // If we're doing an exact match, rather than a substring/startsWith match, 
            // any change to existing criteria will require a fresh set of data from the server.
            // (Note that introducing filtering to previously unrestricted fields will still be
            // more restrictive so won't require a fetch)
            if (textMatchStyle == this._$exact) {
                return this.dropOnFieldChange(newCriteria, oldCriteria, requestProperties);
            } else {
                return this.dropOnShortening(newCriteria, oldCriteria, requestProperties);
            }
        } else {
            return this.dropOnChange(newCriteria, oldCriteria, requestProperties);
        }
    },

    dropOnChange : function (newCriteria, oldCriteria, requestProperties) {
        
        
        if (isc.getKeys(oldCriteria).length != isc.getKeys(newCriteria).length) return -1;
        for (var field in oldCriteria) {
            var oldCriteriaValue = oldCriteria[field],
                newCriteriaValue = newCriteria[field];
            if (isc.isAn.Array(oldCriteriaValue)) {
                
                if (!isc.isAn.Array(newCriteriaValue)) return -1;
                if (oldCriteriaValue.length != newCriteriaValue.length) return -1;
                // the intersection of two identical arrays should be the same length as either of
                // the original arrays
                if (oldCriteriaValue.intersect(newCriteriaValue).length != oldCriteriaValue.length)
                {
                    return -1;
                }
            } else if (isc.isA.Date(oldCriteriaValue) && isc.isA.Date(newCriteriaValue))
            {
                if (oldCriteriaValue.getTime() != newCriteriaValue.getTime()) return -1;
            } else if (oldCriteriaValue != newCriteriaValue) {
                return -1;
            }
        }
        return 0;
    },
    
    
    // dropOnFieldChange() - used for the case where dropOnChange is not true but filter type is
    // exact rather than substring match
    // - if any fields in the old criteria have changed, drop cache
    // - if any new non-dataSource fields have been introduced, drop cache
    // - can retain cache if new criteria restrict previously unrestricted fields (in this case
    //   filter is definitely more restricted)
    dropOnFieldChange : function (newCriteria, oldCriteria, requestProperties) {
        
        var newFields = isc.getKeys(newCriteria),
            oldFields = isc.getKeys(oldCriteria),
            numFieldsDifference = newFields.length - oldFields.length
        ;

        // if new criteria has fewer properties, then it's not more restrictive
        if (numFieldsDifference < 0) return -1;
        
        
        // Ensure that existing criteria are unchanged - otherwise we'll need to drop cache
        for (var field in oldCriteria) {
            var oldCriteriaValue = oldCriteria[field],
                newCriteriaValue = newCriteria[field];
            // If we've dropped a field entirely from the criteria filter is less restrictive
            // (hit server)
            if (newCriteriaValue == null) return -1;
            
            if (isc.isAn.Array(oldCriteriaValue)) {
                
                if (!isc.isAn.Array(newCriteriaValue)) return -1;
                if (oldCriteriaValue.length != newCriteriaValue.length) return -1;
                // the intersection of two identical arrays should be the same length as either of
                // the original arrays
                if (oldCriteriaValue.intersect(newCriteriaValue).length != oldCriteriaValue.length)
                {
                    return -1;
                }
            } else if (isc.isA.Date(oldCriteriaValue) && isc.isA.Date(newCriteriaValue))
            {
                if (oldCriteriaValue.getTime() != newCriteriaValue.getTime()) return -1;
            } else if (oldCriteriaValue != newCriteriaValue) {
                return -1;
            }
        }
        
        // At this point we know the old criteria are unchanged.
        // If the new criteria has more properties, and does not contain any non-DS properties 
        // not present in the old criteria, then it must be more restrictive
        if (numFieldsDifference > 0) {
            newFields.removeList(oldFields);
            // a non-DS field present in newCriteria and not oldCriteria means potentially less
            // restrictive criteria
            for (var i = 0; i < newFields.length; i++) {
                if (this.getField(newFields[i]) == null) return -1;
            }
            return 1;
        }
        return 0;
    },
    
    dropOnShortening : function (newCriteria, oldCriteria, requestProperties) {
        var newFields = isc.getKeys(newCriteria),
            oldFields = isc.getKeys(oldCriteria),
            numFieldsDifference = newFields.length - oldFields.length
        ;

        // if new criteria has fewer properties, then it's not more restrictive
        if (numFieldsDifference < 0) return -1;
        var result = 0;
        for (var field in oldCriteria) {
            var oldCriteriaValue = oldCriteria[field],
                newCriteriaValue = newCriteria[field];
            if (newCriteriaValue == null) return -1;
            // if a field that is not found in the DS changes when we're in dropOnShortening mode,
            // consider that as potentially less restrictive criteria
            if (this.getField(field) == null && oldCriteriaValue != newCriteriaValue)
                return -1;
            if (isc.isAn.Array(oldCriteriaValue)) {
                // copied from dropOnChange behaviour
                if (!isc.isAn.Array(newCriteriaValue)) return -1;
                if (oldCriteriaValue.length != newCriteriaValue.length) return -1;
                if (oldCriteriaValue.intersect(newCriteriaValue).length != oldCriteriaValue.length)
                {
                    return -1;
                }
            } else if (isc.isA.String(oldCriteriaValue)) {
                if (!isc.isA.String(newCriteriaValue)) return -1;
                if (newCriteriaValue.indexOf(oldCriteriaValue) == -1) return -1;
                if (oldCriteriaValue.length > newCriteriaValue.length) return -1;
                if (oldCriteriaValue.length < newCriteriaValue.length) result = 1;
            } else if (isc.isA.Date(oldCriteriaValue) && isc.isA.Date(newCriteriaValue))
            {
                if (oldCriteriaValue.getTime() != newCriteriaValue.getTime()) return -1;
            } else if (oldCriteriaValue != newCriteriaValue) {
                return -1;
            }
        }
        // at this point, the new criteria is either equivalent or more restrictive, so if the new
        // criteria has more properties, and does not contain any non-DS properties not present
        // in the old criteria, then it must be more restrictive
        if (numFieldsDifference > 0) {
            newFields.removeList(oldFields);
            // a non-DS field present in newCriteria and not oldCriteria means potentially less
            // restrictive criteria
            for (var i = 0; i < newFields.length; i++) {
                if (this.getField(newFields[i]) == null) return -1;
            }
            return 1;
        }
        return result;
    }
});

// AdvancedFilter additions for extended local filtering
// --------------------------------------------------------------------------------------------

//> @object AdvancedCriteria
// AdvancedCriteria is a format for representing search criteria which may include
// operators on field values such as "less than", or may include sub-clauses such as several 
// criteria applied to fields joined by an "OR" operator.
// <P>
// SmartClient DataSources can use AdvancedCriteria to search a list of +link{Record}s, and
// the SmartClient Java Server can translate AdvancedCriteria to SQL queries.  If the entire 
// dataset is cached locally, SmartClient can perform AdvancedCriteria filtering on the 
// client, avoiding a server call.
// <P>
// An AdvancedCriteria is an ordinary JavaScript object which can be created directly
// with JavaScript literal notation.  For example:
// <pre>
// var advancedCriteria = {
//        _constructor:"AdvancedCriteria",
//        operator:"and",
//        criteria:[
//            // this is a Criterion
//            { fieldName:"salary", operator:"lessThan", value:"80000" },
//            { operator:"or", criteria:[
//                  { fieldName:"title", operator:"iContains", value:"Manager" },
//                  { fieldName:"reports", operator:"notNull" }
//              ]  
//            }
//        ]
//    }
// </pre>
// An AdvancedCriteria is in effect a +link{Criterion} that has been marked with 
// _constructor:"AdvancedCriteria" to mark it as complete criteria.
// <P>
// When passed to the SmartClient Server, AdvancedCriteria are automatically translated
// to Java Objects, identically to other JavaScript data, by the rules given under 
// +link{rpcRequest.data}.
// <P>
// Other servers may receive AdvancedCriteria in the most convenient format, for example,
// a +link{dataSource.transformRequest()} might translate AdvancedCriteria directly into
// a SQL-like language, or serialize to XML using +link{dataSource.xmlSerialize()}.
// 
// @inheritsFrom Criterion
// @group advancedFilter
// @treeLocation Client Reference/Data Binding/DataSource
// @visibility external
//<


//> @object Criterion
// An object representing a criterion to apply to a record.  
// <P>
// A criterion is part of the definiton of an +link{AdvancedCriteria} object, which is used to
// filter records according to search criteria. 
// <P>
// A criterion consists of an +link{criterion.operator} and typically a
// +link{dataSourceField.name,fieldName} from a
// +link{Record} and a +link{criterion.value,value} to compare to.  However some operators
// either don't require a value (eg isNull) or act on other criteria rather than directly on a
// +link{Record}'s fields (eg the "and" and "or" logical operator).
// @group advancedFilter
// @treeLocation Client Reference/Data Binding/DataSource
// @visibility external
//<

//> @attr criterion.operator (OperatorId : null : IR)
// Operator this criterion applies.
// @group advancedFilter
// @visibility external
//<

//> @attr criterion.fieldName (String : null : IR)
// Name of the field in each +link{Record} that this criterion applies to.  Not applicable for a
// criterion with +link{criterion.criteria,sub-criteria}.
// @group advancedFilter
// @visibility external
//<

//> @attr criterion.value (any : null : IR)
// Value to be used in the application of this criterion.
// <P>
// Value may be required or not required, or may be an Array, according to the
// +link{type:OperatorValueType} of the operator.
//
// @group advancedFilter
// @visibility external
//<

//> @attr criterion.criteria (Array of Criterion : null : IR)
// For a criterion with an operator that acts on other criteria (eg "and", "or"), a list of
// sub-criteria that are grouped together by the operator.
// @group advancedFilter
// @visibility external
//<

//> @attr criterion.start (any : null : IR)
// Start value a criterion with an operator of type <code>"valueRange"</code>.
// @group advancedFilter
// @visibility external
//<


//> @attr criterion.end (any : null : IR)
// End value a criterion with an operator of type <code>"valueRange"</code>.
// @group advancedFilter
// @visibility external
//<

// Operators
// ---------------------------------------------------------------------------------------

//> @type OperatorValueType
// Indicates the kind of value expected in a +link{Criterion} that uses this operator.
// 
// @value "fieldType" +link{criterion.value} should contain a value of the same type as the
//                    field.
// @value "fieldName" +link{criterion.value} should be the name of another field in the record
// @value "none"      no criterion.value or other setting required (used for operators like
//                    isNull)
// @value "criteria" +link{criterion.criteria} should be an Array of criteria (used for logical
//                   operators like "and")
// @value "valueRange" +link{criterion.start} and +link{criterion.end} should contain start and
//                     end values, both of the same type as the field.
// @value "valueSet" +link{criterion.value} should contain an Array of valid field values.
// @value "custom" +link{criterion.value} should contain a value which is not necessarily the
//                 same type as the field (used for regexp and similar operators).  
//                 +link{operator.editorType} can be specified as a FormItem to use to
//                 enter a value for the criterion.
// @group advancedFilter
// @treeLocation Client Reference/Data Binding/DataSource
// @visibility external
//<

//> @type OperatorId
// An operator is used as part of a +link{Criterion} when specifying +link{AdvancedCriteria}.
// <P>
// This list of operators indicates the set of operators built into SmartClient DataSources,
// which can be used for both client and server-side filtering.   You can extend the list of
// operators with +link{dataSource.addSearchOperator()}.
//
// @value "equals" exactly equal to
// @value "notEqual" not equal to 
// @value "greaterThan" Greater than
// @value "lessThan" Less than
// @value "greaterOrEqual" Greater than or equal to
// @value "lessOrEqual" Less than or equal to
// @value "contains" Contains as sub-string (match case)
// @value "startsWith" Starts with (match case)
// @value "endsWith" Ends with (match case)
// @value "iContains" Contains as sub-string (case insensitive)
// @value "iStartsWith" Starts with (case insensitive)
// @value "iEndsWith" Ends with (case insensitive)
// @value "notContains" Does not contain as sub-string (match case)
// @value "notStartsWith" Does not start with (match case)
// @value "notEndsWith" Does not end with (match case)
// @value "iNotContains" Does not contain as sub-string (case insensitive)
// @value "iNotStartsWith" Does not start with (case insensitive)
// @value "iNotEndsWith" Does not end with (case insensitive)
// @value "regexp" Regular expression match
// @value "iregexp" Regular expression match (case insensitive)
// @value "isNull" value is null
// @value "notNull" value is non-null.  Note empty string ("") is non-null
// @value "inSet" value is in a set of values.  Specify criterion.value as an Array
// @value "notInSet" value is not in a set of values.  Specify criterion.value as an Array
// @value "equalsField" matches another field (specify fieldName as criterion.value)
// @value "notEqualField" does not match another field (specified fieldName as criterion.value)
// @value "and" all subcriteria (criterion.criteria) are true
// @value "not" all subcriteria (criterion.criteria) are false
// @value "or" at least one subcriteria (criterion.criteria) is true
// @value "between" shortcut for "greaterThan" + "lessThan" + "and".  Specify criterion.start
//         and criterion.end
// @value "betweenInclusive" shortcut for "greaterOrEqual" + "lessOrEqual" + "and".  Specify
//         criterion.start and criterion.end
// @group advancedFilter
// @treeLocation Client Reference/Data Binding/DataSource
// @visibility external
//<


//> @object Operator
// Specification of an operator for use in filtering, for example "equals".
// Use with +link{DataSource.addSearchOperator()} to define custom filtering behaviors for
// client-side filtering
// @group advancedFilter
// @treeLocation Client Reference/Data Binding/DataSource
// @visibility external
//<
  
//> @attr operator.ID (OperatorId : null : IR)
// Unique id for operator, which appears within +link{AdvancedCriteria} as the
// +link{operator} property.
// <P>
// A list of built-in identifiers is +link{OperatorId,here}.
// @group advancedFilter
// @visibility external
//<

//> @attr operator.title (String : null : IR)
// User-visible title for this operator, such as "doesn't contain".
// <P>
// To simplify internationalization by separating titles from operator code, you can use
// specify +link{operator.titleProperty} instead of this property.
// 
// @group advancedFilter
// @visibility external
//<

//> @attr operator.titleProperty (identifier : null : IR)
// Name of a property on the +link{Operators} class that provides the title for this operator.
// @group advancedFilter
// @visibility external
//<


//> @method operator.condition()
// Method which actually evaluates whether a given record meets a +link{criterion}.
// <P>
// For operators that act on +link{criterion.criteria,sub-criteria}, call
// +link{dataSource.evaluateCriterion()} to evaluate sub-criteria.
// <P>
// Because criteria are sometimes applied to user-entered data that has not been validated, a
// robust <code>condition()</code> function should expect that data found in a +link{Record}
// may be null, NaN, not the correct type (eg "NA" for a type:"date" field) or otherwise out of
// the expected range.
// <P>
// Note that an Operator has access both to the +link{Criterion} object, allowing operators
// that act on more than one field or perform calculations, and access to the +link{Operator}
// object itself, allowing a <code>condition()</code> function to be shared across a range of
// related operators with different +link{OperatorId}s.
// 
// @param value (any) value from the field supplied as +link{criterion.fieldName}, if
//   applicable
// @param record (Record) record being evaluated
// @param fieldName (any) fieldName supplied as +link{criterion.fieldName}, if applicable
// @param criterion (Criterion) criterion definition
// @param operator (Operator) operator definition
// @return (boolean) whether the field passes this criteria
// @group advancedFilter
// @visibility external
//<

//> @attr operator.fieldTypes (Array of FieldType : null : IR)
// List of types that this Operator is valid for.
// <P>
// If omitted, the operator is assumed be valid for all FieldTypes unless a list of 
// FieldTypes is passed to +link{DataSource.addSearchOperator}.
// @group advancedFilter
// @visibility external
//<

//> @attr operator.requiresServer (boolean : false : IR)
// Whether this operator needs to be executed on the server side.
// <P>
// This implies that if a +link{criterion} using this operator is either introduced into
// +link{AdvancedCriteria,criteria} or is changed, the server will need to be contacted to
// perform filtering.
// @group advancedFilter
// @visibility external
//<

//> @attr operator.hidden (boolean : false : IR)
// Whether this operator should be offered to users by default in interfaces such as the
// +link{class:FilterBuilder}.  
// <P>
// Setting hidden:true means the operator can be used in a programmatic search, for example,
// by calling +link{resultSet.setCriteria()}, but does not appear in the UI.
// @group advancedFilter
// @visibility external
//<

//> @method operator.compareCriteria()
// Compare two criteria, both of which use this operator, and report whether the newCriteria is
// definitely more restrictive than the previous criteria.
// <P>
// This is used by the +link{ResultSet} to understand whether client-side filtering can
// continue using cached data, or whether server-side filtering must be used instead.
// 
// @param newCriterion (Criterion) new criterion
// @param oldCriterion (Criterion) previous criterion
// @return (Number) 0 if the criteria are equivalent, 1 if newCriterion is guaranteed more
//                      restrictive, and -1 if newCriterion is not guaranteed more restrictive
// @group advancedFilter
// @visibility external
//<

//> @attr operator.valueType (OperatorValueType : null : IR)
// Indicates the kind of value expected in a +link{Criterion} that uses this operator.
// +link{OperatorValueType} lists possibilities.
// <P>
// The default of <code>null</code> is equivalent to "fieldType", indicating that
// +link{criterion.value} is expected to contain a value of the same type as the field
// indicated by +link{criterion.fieldName}.
// @group advancedFilter
// @visibility external
//<

//> @attr operator.editorType (FormItem classname : null : IR)
// For an operator with +link{valueType}:"custom", indicates what kind of FormItem to use to
// provide a user interface for creating a valid +link{criterion}.  The default of
// <code>null</code> means an ordinary TextItem is fine.
// @group advancedFilter
// @visibility external
//<

// ---------------------------------------------------------------------------------------

//> @attr dataSource.strictSQLFiltering (boolean : false : IR) [A]
// If set to true, both client and server-side advanced filtering used by SmartClient will follow
// SQL99 behavior for dealing with NULL values, which is often counter-intuitive to users.
// Specifically, when a field has NULL value, all of the following expression are false:
// <pre>
//    field == "someValue"  (normally false)
//    field != "someValue"  (normally true)
//    not (field == "someValue")   (normally true)
//    not (field != "someValue")   (normally false)
// </pre>
// @visibility external
//< 


isc.DataSource.addClassMethods({

    //> @classMethod DataSource.addSearchOperator()
    // Add a new search operator to all DataSources.  
    // <P>
    // See also +link{method:DataSource.addSearchOperator()} for adding operators to specific
    // DataSources only.
    //
    // @param operator (Operator) definition of the operator to add
    // @group advancedFilter
    // @visibility external
    //<
    addSearchOperator : function (operator) {
        if (!operator || !operator.ID) {
            isc.logWarn("Attempted to add null search operator, or operator with no ID");
            return;
        }
        if (!isc.DataSource._operators) isc.DataSource._operators = [];
        var opList = isc.DataSource._operators;
        if (opList.containsProperty("ID", operator.ID)) {
            // This operator is already registered - log a warning and replace it with the
            // passed-in definition
            isc.logWarn("Attempted to add existing operator " + operator.ID + " - replacing");
            var index = opList.findIndex("ID", operator.ID);
            if (index >= 0) opList.removeAt(index);
        }
        isc.DataSource._operators.add(operator);
    },

    //> @classMethod DataSource.setTypeOperators()
    // Set the list of valid +link{OperatorId}s valid for a given FieldType.
    // 
    // @param typeName (FieldType) 
    // @param operators (Array of OperatorId) available Operators
    // @group advancedFilter
    // @visibility external
    //<
    setTypeOperators : function (typeName, operators) {
        if (!operators ) return;
        if (!isc.isAn.Array(operators) ) operators = [ operators ];
        if (!isc.DataSource._typeOperators ) isc.DataSource._typeOperators = {};
        isc.DataSource._typeOperators[typeName || "_all_"] = operators;
    },
    
    // _getNextRequestId
    // Increment and return a counter for dsRequests
    // This allows each request to have a unique ID within the page
    _currentRequestId:0,
    _getNextRequestId : function () {
        return this._currentRequestId++;
    }
    
    
});


isc.DataSource.addMethods({

    //> @method dataSource.addSearchOperator()
    // Add a new search operator, only to this DataSource.  
    // <P>
    // If an existing +link{Operator} is passed, restricts the set of FieldTypes to which that
    // operator can be applied in this DataSource.
    // <P>
    // See also +link{classMethod:DataSource.addSearchOperator()} for adding operators to all
    // DataSources.
    //
    // @param operator (Operator) definition of the operator to add
    // @param [types] (Array of FieldType) types to which this operator applies
    // @group advancedFilter
    // @visibility external
    //<
    addSearchOperator : function (operator, types) {
        if (!operator || !operator.ID) {
            isc.logWarn("Attempted to add null search operator, or operator with no ID");
            return;
        }
        if (!isc.DataSource._operators[operator.ID]) {
            isc.DataSource.addSearchOperator(operator);
        }
        if (!this._typeOperators ) this._typeOperators = { _additive: true };
        if (types) {
            // First we need to remove it from whatever it's attached to right now
            for (var idx = 0; idx < this._typeOperators.length; idx++) {
                this._typeOperators[idx].remove(operator.ID);
            }
            // And now attach it to the types we've been passed
            for (var idx = 0; idx < types.length; idx++) {
                if (!this._typeOperators[types[idx]]) {
                    this._typeOperators[types[idx]] = [ operator.ID ];
                }
                if (!this._typeOperators[types[idx]].contains(operator.ID)) {
                    this._typeOperators[types[idx]].add(operator.ID);
                }
            }
        } else {
            if (!this._typeOperators["_all_"]) {
                this._typeOperators["_all_"] = [ operator.ID];
            }
            if (!this._typeOperators["_all_"].contains(operator.ID)) {
                this._typeOperators["_all_"].add(operator.ID);
            }
        }
    },
    

    //> @method dataSource.getSearchOperator()
    // Get the +link{Operator} definition for an +link{OperatorId}.
    //
    // @param operatorId (OperatorId) the id of the operator
    // @return (Operator) the +link{Operator} definition
    // @group advancedFilter
    // @visibility external
    //<
    getSearchOperator : function (operatorId) {
        return isc.DataSource._operators.find("ID", operatorId); 
    },

    //> @method dataSource.getTypeOperators()
    // Get the list of +link{OperatorId}s available on this DataSource for the given +link{FieldType}.
    // <P>
    // If +link{setTypeOperators()} has been called for this DataSource and Fieldtype, returns that
    // list, otherwise, returns the set of valid operators for the +link{FieldType} as specified by 
    // +link{simpleType.validOperators}, otherwise, the system-wide set of valid operators for the
    // type as registered via +link{classMethod:DataSource.addSearchOperator()}.
    // 
    // @param typeName (FieldType) 
    // @return (Array of OperatorId) available Operators
    // @group advancedFilter
    // @visibility external
    //<
    getTypeOperators : function (typeName) {
        var typeOps = [];
        typeName = typeName || "text";
        var origType = isc.SimpleType.getType(typeName);

        // see if type-specific operators appear on this DataSource
        var type = origType;
        if (this._typeOperators) {
            while (type && !this._typeOperators[type.name]) {
                type = isc.SimpleType.getType(type.inheritsFrom, this);
            }
            if (type && this._typeOperators[type.name]) {
                typeOps = this._typeOperators[type.name];
            }
            typeOps.addList(this._typeOperators["_all_"]);
            
            
            if (!this._typeOperators._additive) {
                return typeOps;
            }
        }

        // look up the global list of operators for this type
        type = isc.SimpleType.getType(typeName);
        while (type && !isc.DataSource._typeOperators[type.name]) {
            type = isc.SimpleType.getType(type.inheritsFrom, this);
        }
        if (type && isc.DataSource._typeOperators[type.name]) {
            typeOps.addList(isc.DataSource._typeOperators[type.name]);
        }

        typeOps.addList(isc.DataSource._typeOperators["_all_"]);
        return typeOps;
    },

    //> @method dataSource.setTypeOperators()
    // Set the list of valid +link{OperatorId}s valid for a given FieldType.
    // 
    // @param typeName (FieldType) 
    // @param operators (Array of OperatorId) available Operators
    // @group advancedFilter
    // @visibility external
    //<
    setTypeOperators : function (typeName, operators) {
        if (!operators) return;
        if (!isc.isAn.Array(operators)) operators = [ operators ];
        if (!this._typeOperators) {
            this._typeOperators = {};
        } else {
            // setTypeOperators overrides an existing additive type operators list
            this._typeOperators._additive = false;
        }
        this._typeOperators[typeName || "_all_"] = operators;
        this._typeOperators._additive = false;
    },

    //> @method dataSource.getFieldOperators()
    // Get the list of +link{OperatorId}s available for this field.
    // <P>
    // By default, if +link{dataSourceField.validOperators,field.validOperators} is set,
    // returns that list, otherwise returns result of +link{dataSource.getTypeOperators()}.
    // @param field (string or DataSourceField) Field (or field name) to obtain operators for 
    // @return (Array of OperatorId) available Operators
    // @group advancedFilter
    // @visibility external
    //<
    getFieldOperators : function (field) {
        if (isc.isA.String(field)) field = this.getField(field);
        if (field && field.validOperators) return field.validOperators;
        if (field) return this.getTypeOperators(field.type || "text");
        return [];
    },
    
    //> @method dataSource.getFieldOperatorMap()
    // Get the list of +link{Operator}s available for this field, as +link{ValueMap} from
    // +link{OperatorId} to the +link{operator.title} specified for the +link{Operator}, or
    // the corresponding property in +link{Operators} if +link{operator.titleProperty} is set.
    // <P>
    // This valueMap is suitable for use in a UI for building queries, similar to the
    // +link{FilterBuilder}, and optionally omits operators marked +link{operator.hidden}:true.
    // <p>
    // It is also possible to have this function return only operators of a given 
    // +link{OperatorValueType}, or everything except operators of that type. This is useful, 
    // for example, if you want to return all the logical operators (like "and"), or everything 
    // except the logical operators.
    //
    // @param field (string or DataSourceField) Field (or field name) to obtain operator map for.
    // @param [includeHidden] (boolean) whether to include Operators marked hidden:true
    // @param [valueType] (OperatorValueType) If passed, returns only operators of this +link{OperatorValueType}
    // @param [omitValueType] (boolean) If set, reverses the meaning of the <code>valueType</code> 
    //        parameter, so operators of that +link{OperatorValueType} are the only ones omitted
    // @return (ValueMap) mapping from +link{OperatorId} to title, as described above
    // @group advancedFilter
    // @see dataSource.getTypeOperatorMap
    // @visibility external
    //<
    getFieldOperatorMap : function (field, includeHidden, valueType, omitValueType) {
        if (isc.isA.String(field)) field = this.getField(field);
        var valueMap = {},
            operators = this.getFieldOperators(field);
        for (var idx = 0; idx < operators.length; idx++) {
            var searchOp = this.getSearchOperator(operators[idx]);
            if (searchOp && (!searchOp.hidden || includeHidden)) {
                if (!valueType || (searchOp.valueType == valueType) == !omitValueType)
                valueMap[operators[idx]] = searchOp.titleProperty == null ? searchOp.title : 
                    isc.Operators[searchOp.titleProperty];
            }
        }
        return valueMap;
    },
    
    //> @method dataSource.getTypeOperatorMap()
    // Get the list of +link{Operator}s available for this +link{FieldType}, as +link{ValueMap} from
    // +link{OperatorId} to the +link{operator.title} specified for the +link{Operator}, or
    // the corresponding property in +link{Operators} if +link{operator.titleProperty} is set.
    // <P>
    // This valueMap is suitable for use in a UI for building queries, similar to the
    // +link{FilterBuilder}, and optionally omits operators marked +link{operator.hidden}:true.
    // <p>
    // It is also possible to have this function return only operators of a given 
    // +link{OperatorValueType}, or everything except operators of that type. This is useful, 
    // for example, if you want to return all the logical operators (like "and"), or everything 
    // except the logical operators.
    //
    // @param [type] (FieldType) Type to obtain operator map for. Defaults to "text" if not passed.
    // @param [includeHidden] (boolean) whether to include Operators marked hidden:true
    // @param [valueType] (OperatorValueType) If passed, returns only operators of this +link{OperatorValueType}
    // @param [omitValueType] (boolean) If set, reverses the meaning of the <code>valueType</code> 
    //        parameter, so operators of that +link{OperatorValueType} are the only ones omitted
    // @return (ValueMap) mapping from +link{OperatorId} to title, as described above
    // @group advancedFilter
    // @see dataSource.getFieldOperatorMap
    // @visibility external
    //<
    getTypeOperatorMap : function (type, includeHidden, valueType, omitValueType) {
        var valueMap = {},
            operators = this.getTypeOperators(type);
        for (var idx = 0; idx < operators.length; idx++) {
            var searchOp = this.getSearchOperator(operators[idx]);
            if (searchOp && (!searchOp.hidden || includeHidden)) {
                if (!valueType || (searchOp.valueType == valueType) == !omitValueType)
                valueMap[operators[idx]] = searchOp.titleProperty == null ? searchOp.title : 
                    isc.Operators[searchOp.titleProperty];
            }
        }
        return valueMap;
    }

});

//> @attr dataSourceField.validOperators (Array of OperatorId : null : IR)
// List of operators valid on this field.  
// <P>
// If not specified, all operators that are valid for the field type are allowed.
// @group advancedFilter
// @visibility external
//<

//> @attr simpleType.validOperators (Array of OperatorId : null : IR)
// Set of search operators valid for this type.  
// <P>
// If not specified, the +link{inheritsFrom,inherited} type's operators will be used, finally
// defaulting to the default operators for the basic types (eg integer).
// @group advancedFilter
// @visibility external
//<




// Filtering
// ---------------------------------------------------------------------------------------

isc.DataSource.addMethods({ 
  
    //> @method dataSource.evaluateCriterion()
    // Evaluate the given criterion with respect to the passed record.
    // <P>
    // Typically called by the +link{operator.condition,condition} function of a custom
    // +link{Operator} to evaluate +link{criterion.criteria,sub-criteria}.
    //
    // @param record (Record) record to evaluate
    // @param criterion (Criterion) criterion to use
    // @return (boolean) whether the record meets the supplied +link{Criterion}
    // @group advancedFilter
    // @visibility external
    //<
    evaluateCriterion : function (record, criterion) {

        
        if (criterion.requiresServer == true) return true;
        
        var op = this.getSearchOperator(criterion.operator);
        if (op == null) {
            isc.logWarn("Attempted to use unknown operator " + criterion.operator);
            return false;
        }
        if (criterion.fieldName) {
            var validOps = this.getFieldOperators(criterion.fieldName);
            if (!validOps.contains(op.ID)) {
                isc.logWarn("Operator " + op.ID + " is not valid for field " + criterion.fieldName +
                            ". Continuing anyway.");
            }
        }
        return op.condition(criterion.value, record, criterion.fieldName, criterion, op, this);
    },
    
    recordsMatchingAdvancedFilter : function (data, criteria, requestProperties) {

        var matches = [];
        
        // This flag is needed to match SQL behavior that treats null values as completely unable to
        // be compared, such that (condition-involving-null) == !(condition-involving-null) == false
        this._withinLogicalNot = false;
        
        // This flag dictates whether we match the aforementioned SQL behavior with null values,
        // or use our own, more sophisticated (and logical) algorithms
        this._strictMode = criteria.strictSQLFiltering;

        for (var idx = 0; idx < data.length; idx++) {
        
            // The AdvancedCriteria system makes this very easy - just call evaluateCriterion
            // on the top-level criterion, and it handles all the recursion and evaluation of
            // sub-criteria that it needs to do automatically.
            if (this.evaluateCriterion(data[idx], criteria)) {
                matches.add(data[idx]);
            }
        }
        
        return matches;
    },
    
    compareAdvancedCriteria : function (newCriterion, oldCriterion, requestProperties, policy) {
	
        var op = this.getSearchOperator(oldCriterion.operator);
        if (op != this.getSearchOperator(newCriterion.operator)) {
            
            return -1;
        }        

        return op.compareCriteria(newCriterion, oldCriterion, op, this);

    },
    
    //> @method dataSource.convertCriteria()
    // Converts criteria expressed in SmartClient's simple criteria format to an AdvancedCriteria
    // object.  
    //
    // @param criteria (Criteria) simple criteria
    // @param [textMatchStyle] (TextMatchStyle) default style of matching text.  Defaults to
    //                                          "substring"
    // @return (AdvancedCriteria) equivalent AdvancedCriteria object
    // @visibility external
    //<
    convertCriteria : function(criteria, textMatchStyle) {
        var aCriteria = {
            _constructor: "AdvancedCriteria",
            operator: "and"
        }
        
        var subCriteria = [];
        for (var fieldName in criteria) {
            if (textMatchStyle == "equals") var operator = "equals"
            else operator = "iContains";
            if (isc.isA.Array(criteria[fieldName])) {
                var disjunct = {
                    _constructor: "AdvancedCriteria",
                    operator: "or",
                    criteria: []
                }
                for (var i = 0; i < criteria[fieldName].length; i++) {
                    disjunct.criteria.add({
                        fieldName: fieldName,
                        operator: operator,
                        value: criteria[fieldName][i]
                    });
                }
                subCriteria.add(disjunct);
            } else {
                subCriteria.add({
                    fieldName: fieldName,
                    operator: operator,
                    value: criteria[fieldName]
                });
            }
        }

        aCriteria.criteria = subCriteria;
        return aCriteria;
    }
    
});


// Define temporary function to init the built-in operators - called at the end of the definition
isc._initBuiltInOperators = function () {

    // Operator conditions
    var booleanOperator = 
        function (value, record, fieldName, criterion, operator, ds) {
        
        var returnVal; 
        
            if (!criterion.criteria) {
                // This can legitimately happen if the user proceeds with an "empty" FilterBuilder
                // (ie, one they haven't set any values on).  FilterBuilder strips out all the 
                // empty conditions and returns an empty array; something further downstream is 
                // throwing that empty array away, so by the time we get here criteria is undef.
                // So we'll just set an undef criteria to the empty array and let it drop through
                criterion.criteria = [];
            }
            if (!isc.isAn.Array(criterion.criteria)) {
                isc.logWarn("AdvancedCriteria: found boolean operator where subcriteria was not " +
                            "an array.  Subcriteria was: " + isc.Comm.serialize(criterion.criteria));
                return false;
            }
            
            // Because we now need to match SQL null-handling behavior, we have to return false even 
            // for negated clauses such as not(value equals null). Therefore, we can't just return false
            // if we find a null - we need to return false in the normal case, true where we're nested 
            // inside a "not" clause, and then toggle back and forth between true and false as we progress
            // through multiple levels of nested "not" clauses.
            
            if (operator.isNot) ds._withinLogicalNot = !ds._withinLogicalNot;
            
            for (var idx = 0; idx < criterion.criteria.length; idx++) {
                var bool = ds.evaluateCriterion(record, criterion.criteria[idx]);
                if (operator.isAnd && !bool) returnVal = false;
                if (operator.isNot && bool) returnVal = false;
                if (operator.isOr && bool) returnVal = true;
                if (returnVal != null) break;
            }
            
            // If we get here and returnVal is undefined, "and" or "not" have succeeded, "or" has failed
            if (returnVal == null) {
                if (operator.isOr) returnVal = false;
                else returnVal = true;
            }
            
            // Put "within logical not" status back the way it was
            if (operator.isNot) ds._withinLogicalNot = !ds._withinLogicalNot;
            
            return returnVal;
            
        };

    
    var equality = 
        function (value, record, fieldName, criterion, operator, ds) {
            
            
            if (ds._strictMode) {
            	if (record[fieldName] == null || value == null) return ds._withinLogicalNot;
            }
            
            var eq = (value == record[fieldName]);
            if (isc.isA.Date(value) && isc.isA.Date(record[fieldName])) {
                eq = (Date.compareDates(value, record[fieldName]) == 0);
            }
            if (operator.negate) return !eq;
            else return eq;
        };

    var rangeCheck = 
        function (value, record, fieldName, criterion, operator, ds) {
        
            var start = value, 
                end = value,
                tested = record[fieldName];
            if (criterion.start) start = criterion.start;
            if (criterion.end) end = criterion.end;

            if (ds._strictMode) {
                if (tested == null || (operator.lowerBounds && start == null) ||
                     (operator.upperBounds && end == null)) {
                    return  ds._withinLogicalNot;
                }
            }
            
            
            
            var lowerBoundsCheck = true;
            var upperBoundsCheck = true;
            
            var isDate = isc.isA.Date(record[fieldName]);
            var isNumber = isc.isA.Number(record[fieldName]);
            
            if (operator.lowerBounds && start &&
                    ((isNumber && isNaN(start)) ||
                    (start && isDate && (!isc.isA.Date(start))))) {
                return false;
            }
            
            if (operator.upperBounds && end &&
                    ((isNumber && isNaN(end)) ||
                    (start && isDate && (!isc.isA.Date(end))))) {
                return false;
            }
            
            var undef;
            if (start === null || start === undef) {
                lowerBoundsCheck = false;
            }
            
            if (end === null || end === undef) {
                upperBoundsCheck = false;
            }
            
            if (isDate && !isc.isA.Date(start)) lowerBoundsCheck = false;
            if (isDate && !isc.isA.Date(end)) upperBoundsCheck = false;
            
            isDate = isc.isA.Date(start) || isc.isA.Date(end);
            isNumber = isc.isA.Number(start) || isc.isA.Number(end);
            tested = record[fieldName];
            
            if (tested === null || tested === undef) {
                if (isDate) tested = new Date(-8640000000000000);
                else if (isNumber) tested = Number.MIN_VALUE;
                else tested = "";
            } else {
                if (isNumber && isNaN(tested)) {
                    start = "" + start;
                    end = "" + end;
                }
                // So, we've been handed a Date object to test against a text data value. Whatever we might
                // try to do here will seem wrong to somebody. So, in the absence of anything more sensible,
                // we'll just return false (so all records are excluded when you have this kind of mismatch)
                if (isDate && !isc.isA.Date(tested)) {
                    return false;
                }
            }
            
            // 
            
            // >, >=, lower bounds check on between, betweenInclusive
            if (operator.lowerBounds && lowerBoundsCheck) {
                if (operator.inclusive) {
                    if (tested < start) return false;
                } else {
                    if (tested <= start) return false;
                }
            }
            
            // <, <=, upper bounds check on between, betweenInclusive
            if (operator.upperBounds && upperBoundsCheck) {
                if (operator.inclusive) {
                    if (tested > end) return false;
                } else {
                    if (tested >= end) return false;
                }
            }
            return true;
        };

    var stringComparison = 
        function (value, record, fieldName, criterion, operator, ds) {
            var tested = record[fieldName], 
                test = value;
            
            // Special-case code to match server-side exception when we get a request to do a string-
            // match on a non-text field
            //if ((test && !isc.isA.String(test)) || (!isc.isA.String(tested))) {
            if (!isc.isA.String(tested)) {
                return operator.negate;
            }
             
            // - a null data value cannot contain anything, including null.
            // - a non-null data value is considered to contain null. We originally followed Javascript
            //   and considered non-null values to NOT contain null; however, it is not possible to implement
            //   this scheme in Hibernate without resorting to hackery.  It was easier to change the 
            //   client-side rule
            if (tested == null) return ds._strictMode ? ds._withinLogicalNot : operator.negate;
            
            // Convert a null filter to the empty string, so our comparisons will work
            if (test == null) test = "";
            
            // The following two line is removed to match reduced server-side functionality. See the 
            // comments in Java method HibernateDataSource.stringComparison()
            // if (isc.isA.Number(tested)) tested = "" + tested;
            if (isc.isA.Number(test)) test = "" + test;
            
            if (!isc.isA.String(test) || !isc.isA.String(tested)) return operator.negate;
            
            
            
            if (operator.caseInsensitive) {
                tested = tested.toLowerCase();
                test = test.toLowerCase();
            }
            if (operator.startsWith) var result = isc.startsWith(tested, test);
            else if (operator.endsWith) result = isc.endsWith(tested, test);
            else result = isc.contains(tested, test);
            
            if (operator.negate) return !result;
            else return result;
        };

    var nullCheck = 
        function (value, record, fieldName, criterion, operator) {
            
            var isNull = (record[fieldName] == null);
            if (operator.negate) return !isNull;
            else return isNull;
        };

    var regexpCheck = 
        function (value, record, fieldName, criterion, operator) {
            var regex;
            
            // Bail out early if value is undefined.  This is to provide cross-browser consistency, 
            // because Moz always returns false for a test of RegExp(undefined), whereas all the 
            // others (IE, Safari and Chrome tested) return true.  They all return false if the 
            // value is null, so we'll mirror that and return false for undefined as well
            var undef;
            if (value === undef) return false;
            
            // Dates make no sense for regexp (numbers work OK)
            if (isc.isA.Date(value) || isc.isA.Date(record[fieldName])) return false;
            
            if (operator.caseInsensitive) regex = new RegExp(value, "i");
            else regex = new RegExp(value);
            return regex.test(record[fieldName]);
        };

    var setMembership = 
        function (value, record, fieldName, criterion, operator, ds) {
        
            // We don't support strict SQL mode for this operator - it raises too many hard problems
            // on the server side
            
            // Convert null or undefined to an empty Array
            // Convert a non-null single value into an Array containing that value
            if (value == null) value = []
            else if (!isc.isAn.Array(value)) value = [ value ];

            // Note: Array.contains() returns false for Dates, unless they are actually the 
            // selfsame Date objects (ie, representing the same Date is not enough). 
            if (!isc.isA.Date(record[fieldName])) {
                var isInSet = value.contains(record[fieldName]);
            } else {
                isInSet = false;
                for (var i = 0; i < value.length; i++) {
                    if (isc.isA.Date(value[i]) && Date.compareDates(value[i], record[fieldName]) == 0) {
                        isInSet = true;
                        break;
                    }
                }
            }
            
            if (operator.negate) return !isInSet;
            else return isInSet;
        };

    var fieldValueCheck = 
        function (value, record, fieldName, criterion, operator, ds) {
        
            if (value == null) return true;  // Include all records if the "other" field name is null
            
            // We do not support strict SQL mode for this operator, because different databases behave differently
            // if the two fields are of different types - we can't match a behavior that varies by database.

            var fieldsMatch = (record[value] == record[fieldName]);
            
            // Dates aren't equal in JS unless they are the same object, so we need a special compare
            if (isc.isA.Date(record[value]) && isc.isA.Date(record[fieldName])) {
                fieldsMatch = (Date.compareDates(record[value], record[fieldName]) == 0);
            }
            if (operator.negate) return !fieldsMatch;
            else return fieldsMatch;
        };


    // Operator criterion comparators
    var booleanOperatorComp = 
        function (newCriterion, oldCriterion, operator, ds) {
            if (!oldCriterion.criteria) oldCriterion.criteria = [];
            if (!isc.isAn.Array(oldCriterion.criteria)) {
                isc.logWarn("AdvancedCriteria: boolean compareCriteria found " +
                            "where old subcriteria was not an array");
                return -1;
            }
            if (!newCriterion.criteria) newCriterion.criteria = [];
            if (!isc.isAn.Array(newCriterion.criteria)) {
                isc.logWarn("AdvancedCriteria: boolean compareCriteria found " +
                            "where new subcriteria was not an array");
                return -1;
            }
            var rtn, 
                thisLevelRtn = 0,
                oldCount = oldCriterion.criteria.length,
                newCount = newCriterion.criteria.length;
                
            if (newCount > oldCount && operator.isOr) {
                // We can indicate less restrictive right now without having to check the 
                // sub-criteria - there's an extra "or" condition
                return -1;
            }

            var oldWork = isc.clone(oldCriterion.criteria);
            var newWork = isc.clone(newCriterion.criteria);
            
            
            
            for (var i = 0; i < oldCount; i++) {
                var oldSubCriterion = oldWork[i];
                var newSubCriterion = i > newCount ? null : newWork[i];
                if (!newSubCriterion || 
                    (newSubCriterion && newSubCriterion.fieldName != oldSubCriterion.fieldName ||
                    newSubCriterion.operator  != oldSubCriterion.operator  ||
                    newSubCriterion.processed == true)) {
                    newSubCriterion = null;
                    for (var j = 0; j < newCount; j++) {
                        if (newWork[j].processed) continue;
                        if (newWork[j].fieldName == oldSubCriterion.fieldName &&
                            newWork[j].operator  == oldSubCriterion.operator ) {
                            newSubCriterion = newWork[j];
                            break;
                        }
                    }
                }
                
                if (newSubCriterion && oldSubCriterion) {
                    newSubCriterion.processed = true;
                    rtn = ds.compareAdvancedCriteria(newSubCriterion, oldSubCriterion);
                } else {
                    if (oldSubCriterion && !newSubCriterion) {
                        // Fewer criteria
                        if (operator.isOr) rtn = 1;
                        if (operator.isAnd) rtn = -1;
                        if (operator.isNot) rtn = -1;
                    } 
                }
                if (operator.isAnd && rtn == -1) return -1;
                if (operator.isOr && rtn == -1) return -1;
                if (operator.isNot && rtn == 1) return -1;
                // If any sub-criterion compare comes back as 1 (-1 for NOT), then we should
                // return 1; if they are all 0 we should return 0.
                if (rtn != 0) thisLevelRtn = 1;
            }
            
            for (var i = 0; i < newCount; i++ ) {
                if (!newWork[i].processed) {
                    // Either there are more new criteria than old, or we've found at least one 
                    // that could not be matched.
                    if (operator.isOr) return -1;
                    if (operator.isAnd) return 1;
                    if (operator.isNot) return -1;
                }
            } 
            
            // If we get here, we can indicate identical / more restrictive
            return thisLevelRtn;
        };

    var equalityComp = 
        function (newCriterion, oldCriterion, operator) {
            // There's no way an equality check can be more restrictive - either it's identical,
            // or it's less restrictive
            if (newCriterion.fieldName == oldCriterion.fieldName) {
                var eq = (newCriterion.value == oldCriterion.value);
                if (isc.isA.Date(newCriterion.value) && isc.isA.Date(oldCriterion.value)) {
                    eq = (Date.compareDates(newCriterion.value, oldCriterion.value) == 0);
                }
                if (eq) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        };

    var rangeCheckComp = 
        function (newCriterion, oldCriterion, operator) {
            // We can return 1 as follows:
            // 1 greaterThan/greaterOrEqual. Return 1 if the new value is larger than the old one.
            // 2 lessThan/lessThanOrEqual.   Return 1 if the new value is smaller than the old one.     
            // 3 between/betweenInclusive.   Return 1 if the new start value is larger than the old 
            //                               start value but not larger than the old end value, 
            //                               OR the new end value is smaller than the old end value 
            //                               but not smaller than the old start value.
            if (newCriterion.fieldName == oldCriterion.fieldName) {
                if (operator.upperBounds && operator.lowerBounds) {
                    if ((newCriterion.start == oldCriterion.start) || 
                        (isc.isA.Date(newCriterion.start) && isc.isA.Date(oldCriterion.start) &&
                        Date.compareDates(newCriterion.start, oldCriterion.start) == 0)) {
                        if ((newCriterion.end == oldCriterion.end) || 
                            (isc.isA.Date(newCriterion.end) && isc.isA.Date(oldCriterion.end) &&
                            Date.compareDates(newCriterion.end, oldCriterion.end) == 0)) {
                            return 0;
                        }
                    }
                } else {
                    if ((newCriterion.value == oldCriterion.value) || 
                        (isc.isA.Date(newCriterion.value) && isc.isA.Date(oldCriterion.value) &&
                        Date.compareDates(newCriterion.value, oldCriterion.value) == 0)) {
                        return 0;
                    }
                }
                
                var newStart = newCriterion.start == null ? newCriterion.value : newCriterion.start,
                    oldStart = oldCriterion.start == null ? oldCriterion.value : oldCriterion.start,
                    newEnd   = newCriterion.start == null ? newCriterion.value : newCriterion.end,
                    oldEnd   = oldCriterion.start == null ? oldCriterion.value : oldCriterion.end;

                var isDate, 
                    isnumber;
                    
                var oldLowerBounds = true,
                    oldUpperBounds = true,
                    newLowerBounds = true,
                    newUpperBounds = true;
                    
                 // See the IDoc in the rangeCheck() function for a discussion of why we're doing this
                if (oldStart == null) oldLowerBounds = false;
                if (oldEnd == null) oldUpperBounds = false;
                if (newStart == null) newLowerBounds = false;
                if (newEnd == null) newUpperBounds = false;
                
                if (operator.lowerBounds && !operator.upperBounds && 
                        !newLowerBounds && !oldLowerBounds) {
                    return 0;
                }
                
                if (operator.lowerBounds && !operator.upperBounds && 
                        (newStart > oldStart || (newLowerBounds && !oldLowerBounds))) {
                    return 1;
                }
                
                if (operator.upperBounds && !operator.lowerBounds && 
                        !newUpperBounds && !oldUpperBounds) {
                    return 0;
                }
                
                if (operator.upperBounds && !operator.lowerBounds && 
                        (newEnd < oldEnd || (newUpperBounds && !oldUpperBounds))) {
                    return 1;
                }
                
                if (operator.lowerBounds && operator.upperBounds) {
                    // Technically, checking for >= and <= here is not sufficient to infer more
                    // restriction; however, it IS enough to infer either more restriction or an
                    // identical pair of filters, and since we won't get this far if the filters 
                    // are identical, it's safe to return 1.
                    if (newStart >= oldStart && newStart <= oldEnd &&
                        newEnd <= oldEnd && newEnd >= oldStart) {
                        return 1;
                    }
                    if ((newLowerBounds && !oldLowerBounds) ||
                        (newUpperBounds && !oldUpperBounds)) {
                        return 1;
                    } 
                    if (!newLowerBounds && !oldLowerBounds &&
                        !newUpperBounds && !oldLowerBounds) {
                        return 0;
                    } 
                }
            }
            return -1;
        };
        
    var stringComparisonComp = 
        function (newCriterion, oldCriterion, operator) {
            // We can return 1 as  follows:
            // 1 startsWith. Return 1 if the new value startsWith the old value AND is longer.
            //               Obey the caseInsensitive flag. 
            //               If negate == true, the test is reversed - ie, old value must 
            //               startWith new value, and new value must be shorter.
            // 2 endsWith.   Return 1 if the new value endsWith the old value AND is longer.
            //               Obey the caseInsensitive flag. 
            //               If negate == true, the test is reversed - ie, old value must
            //               endWith new value, and new value must be shorter.
            // 3 contains.   Return 1 if the old value is a proper substring of the new value (ie,
            //               new value both contains and is longer than old value). Obey the 
            //               caseInsensitive flag. If negate == true, the new field must be a 
            //               substring of the old one.

            var oldVal = oldCriterion.value;
            var newVal = newCriterion.value;

            // Convert numbers to strings - other than that, reject anything that isn't a string
            if (isc.isA.Number(oldVal)) oldVal = "" + oldVal;
            if (isc.isA.Number(newVal)) newVal = "" + newVal;

            if (!isc.isA.String(oldVal) || !isc.isA.String(newVal)) return -1;

            if (operator.caseInsensitive) {
                oldVal = oldVal.toLowerCase();
                newVal = newVal.toLowerCase();
            }
            
            if (newCriterion.fieldName == oldCriterion.fieldName 
                    && newCriterion.value == oldCriterion.value) {
                return 0;
            }
                
            if (operator.startsWith && !operator.negate && 
                    newVal.length > oldVal.length && newVal.startsWith(oldVal)) {
                return 1;
            }
                
                
            if (operator.startsWith && operator.negate && 
                    oldVal.length > newVal.length && oldVal.startsWith(newVal)) {
                return 1;
            }

            if (operator.endsWith && !operator.negate && 
                    newVal.length > oldVal.length && newVal.endsWith(oldVal)) {
                return 1;
            }                
                
            if (operator.endsWith && operator.negate && 
                    oldVal.length > newVal.length && oldVal.endsWith(newVal)) {
                return 1;
            }

            if (!operator.startsWith && !operator.endsWith && !operator.negate && 
                    newVal.length > oldVal.length && newVal.contains(oldVal)) {
                return 1;
            }                
                
            if (!operator.startsWith && !operator.endsWith && operator.negate && 
                    oldVal.length > newVal.length && oldVal.contains(newVal)) {
                return 1;
            }
                
            return -1;
        };
        
    var nullCheckComp = 
        function (newCriterion, oldCriterion, operator) {
            if (newCriterion.fieldName == oldCriterion.fieldName)  return 0;
            else return -1;
        };
        
    var regexpCheckComp = 
        function (newCriterion, oldCriterion, operator) {
            // We can't know whether the new regexp is more or less restrictive - either they 
            // match, or we indicate less restrictive
            if (newCriterion.value == oldCriterion.value &&
                      newCriterion.fieldName == oldCriterion.fieldName) {
                return 0;
            } else {
                return -1;
            }
        };
        
    var setMembershipComp = 
        function (newCriterion, oldCriterion, operator) {
            // We can return 1 if the new set is a proper subset of the old one
            // (if negate == true, the old set must be a proper subset of the new one)
            if (newCriterion.fieldName == oldCriterion.fieldName) {
                
                // We can only sensibly compare Arrays
                if (!isc.isAn.Array(oldCriterion.value) || !isc.isAn.Array(newCriterion.value)) {
                    return -1;
                }
                
                if (newCriterion.value.equals(oldCriterion.value)) {
                    return 0;
                }
                
                if (!operator.negate && oldCriterion.value.containsAll(newCriterion.value)) {
                    return 1;
                }
                
                if (operator.negate && newCriterion.value.containsAll(oldCriterion.value)) {
                    return 1;
                }
            }
            
            return -1;
        };
        
    var fieldValueCheckComp = 
        function (newCriterion, oldCriterion, operator) {
            // There's no way this check can be more restrictive - either it's the same 
            // or it's different, and if it's different we have to go back to the server.
            if (newCriterion.value == oldCriterion.value &&
                      newCriterion.fieldName == oldCriterion.fieldName) {
                return 0;
            } else {
                return -1;
            }
        };


    var builtinOps = [
    {
        ID: "equals",
        titleProperty: "equalsTitle",
        negate: false,
        valueType: "fieldType",
        condition: equality,
        compareCriteria: equalityComp
    },
    
    {
        ID: "notEqual",
        titleProperty: "notEqualTitle",
        negate: true,
        valueType: "fieldType",
        condition: equality,
        compareCriteria: equalityComp
    },
    {
        ID: "greaterThan",
        titleProperty: "greaterThanTitle",
        lowerBounds: true,
        valueType: "fieldType",
        condition: rangeCheck,
        compareCriteria: rangeCheckComp
    },
    {
        ID: "lessThan",
        titleProperty: "lessThanTitle",
        upperBounds: true,
        valueType: "fieldType",
        condition: rangeCheck,
        compareCriteria: rangeCheckComp
    },
    {
        ID: "greaterOrEqual",
        titleProperty: "greaterOrEqualTitle",
        lowerBounds: true,
        inclusive: true,
        valueType: "fieldType",
        condition: rangeCheck,
        compareCriteria: rangeCheckComp
    },
    {
        ID: "lessOrEqual",
        titleProperty: "lessOrEqualTitle",
        upperBounds: true,
        inclusive: true,
        valueType: "fieldType",
        condition: rangeCheck,
        compareCriteria: rangeCheckComp
    },
    {
        ID: "between",
        titleProperty: "betweenTitle",
        lowerBounds: true,
        upperBounds: true,
        valueType: "valueRange",
        condition: rangeCheck,
        compareCriteria: rangeCheckComp
    },
    {
        ID: "betweenInclusive",
        titleProperty: "betweenInclusiveTitle",
        lowerBounds: true,
        upperBounds: true,
        hidden:true,
        valueType: "valueRange",
        inclusive: true,
        condition: rangeCheck,
        compareCriteria: rangeCheckComp
    },
    {
        ID: "iContains",
        titleProperty: "iContainsTitle",
        caseInsensitive: true,
        valueType: "fieldType",
        condition: stringComparison,
        compareCriteria: stringComparisonComp
    },
    {
        ID: "iStartsWith",
        titleProperty: "iStartsWithTitle",
        startsWith: true,
        caseInsensitive: true,
        valueType: "fieldType",
        condition: stringComparison,
        compareCriteria: stringComparisonComp
    },
    {
        ID: "iEndsWith",
        titleProperty: "iEndsWithTitle",
        endsWith: true,
        caseInsensitive: true,
        valueType: "fieldType",
        condition: stringComparison,
        compareCriteria: stringComparisonComp
    },
    {
        ID: "contains",
        titleProperty: "containsTitle",
        hidden:true,
        valueType: "fieldType",
        condition: stringComparison,
        compareCriteria: stringComparisonComp
    },
    {
        ID: "startsWith",
        titleProperty: "startsWithTitle",
        startsWith: true,
        hidden:true,
        valueType: "fieldType",
        condition: stringComparison,
        compareCriteria: stringComparisonComp
    },
    {
        ID: "endsWith",
        titleProperty: "endsWithTitle",
        endsWith: true,
        hidden:true,
        valueType: "fieldType",
        condition: stringComparison,
        compareCriteria: stringComparisonComp
    },
    {
        ID: "iNotContains",
        titleProperty: "iNotContainsTitle",
        caseInsensitive: true,
        negate: true,
        valueType: "fieldType",
        condition: stringComparison,
        compareCriteria: stringComparisonComp
    },
    {
        ID: "iNotStartsWith",
        titleProperty: "iNotStartsWithTitle",
        startsWith: true,
        caseInsensitive: true,
        negate: true,
        valueType: "fieldType",
        condition: stringComparison,
        compareCriteria: stringComparisonComp
    },
    {
        ID: "iNotEndsWith",
        titleProperty: "iNotEndsWithTitle",
        endsWith: true,
        caseInsensitive: true,
        negate: true,
        valueType: "fieldType",
        condition: stringComparison,
        compareCriteria: stringComparisonComp
    },
    {
        ID: "notContains",
        titleProperty: "notContainsTitle",
        negate: true,
        hidden:true,
        valueType: "fieldType",
        condition: stringComparison,
        compareCriteria: stringComparisonComp
    },
    {
        ID: "notStartsWith",
        titleProperty: "notStartsWithTitle",
        startsWith: true,
        negate: true,
        hidden:true,
        valueType: "fieldType",
        condition: stringComparison,
        compareCriteria: stringComparisonComp
    },
    {
        ID: "notEndsWith",
        titleProperty: "notEndsWithTitle",
        endsWith: true,
        negate: true,
        hidden:true,
        valueType: "fieldType",
        condition: stringComparison,
        compareCriteria: stringComparisonComp
    },
    {
        ID: "isNull",
        titleProperty: "isNullTitle",
        valueType: "none",
        condition: nullCheck,
        compareCriteria: nullCheckComp
    },
    {
        ID: "notNull",
        titleProperty: "notNullTitle",
        negate: true,
        valueType: "none",
        condition: nullCheck,
        compareCriteria: nullCheckComp
    },
    {
        ID: "regexp",
        titleProperty: "regexpTitle",
        hidden: true, 
        valueType: "custom",
        condition: regexpCheck,
        compareCriteria: regexpCheckComp
    },
    {
        ID: "iregexp",
        titleProperty: "iregexpTitle",
        hidden: true,
        caseInsensitive: true,
        valueType: "custom",
        condition: regexpCheck,
        compareCriteria: regexpCheckComp
    },
    {
        ID: "inSet",
        titleProperty: "inSetTitle",
        hidden: true,
        valueType: "valueSet",
        condition: setMembership,
        compareCriteria: setMembershipComp
    },
    {
        ID: "notInSet",
        titleProperty: "notInSetTitle",
        negate: true,
        hidden: true,
        valueType: "valueSet",
        condition: setMembership,
        compareCriteria: setMembershipComp
    },
    {
        ID: "equalsField",
        titleProperty: "equalsFieldTitle",
        valueType: "fieldName",
        condition: fieldValueCheck,
        compareCriteria: fieldValueCheckComp
    },
    {
        ID: "notEqualField",
        titleProperty: "notEqualFieldTitle",
        negate: true,
        valueType: "fieldName",
        condition: fieldValueCheck,
        compareCriteria: fieldValueCheckComp
    },
    {
        ID: "and",
        titleProperty: "andTitle",
        isAnd: true,
        valueType: "criteria",
        condition: booleanOperator,
        compareCriteria: booleanOperatorComp
    },
    {
        ID: "not",
        titleProperty: "notTitle",
        isNot: true,
        valueType: "criteria",
        condition: booleanOperator,
        compareCriteria: booleanOperatorComp
    },
    {
        ID: "or",
        titleProperty: "orTitle",
        isOr: true,
        valueType: "criteria",
        condition: booleanOperator,
        compareCriteria: booleanOperatorComp
    }
    ];

    for (var idx = 0; idx < builtinOps.length; idx++) {
        isc.DataSource.addSearchOperator(builtinOps[idx]);
    }

    // Create default typeOperators
    isc.DataSource.setTypeOperators(null, ["equals", "notEqual", "lessThan", "greaterThan",
                                           "lessOrEqual", "greaterOrEqual", "between",
                                           "betweenInclusive", "isNull", "notNull", "inSet",
                                           "notInSet", "equalsField", "notEqualField",
                                           "and", "or", "not"]);
    
    isc.DataSource.setTypeOperators("text", ["regexp", "iregexp", "contains", "startsWith",
                                               "endsWith", "iContains", "iStartsWith", "iEndsWith",
                                               "notContains", "notStartsWith", "notEndsWith", 
                                               "iNotContains", "iNotStartsWith", "iNotEndsWith"]);

};

isc._initBuiltInOperators();


// Built-in Schema
// ---------------------------------------------------------------------------------------

// A generic "Object" DataSource is needed so that you can declare that a field is of Object
// type, as opposed to simple type, without having to be more specific.
isc.DataSource.create({ ID:"Object", fields: {}, addGlobalId:false });

isc.DataSource.create({ 
    ID:"ValueMap", 
    addGlobalId:false,
    // prevent clobbering by server definitions
    builtinSchema : true,
    // a valueMap can appear as a simple JS Array, and in this case shouldn't be considered
    // multiple valueMaps
    canBeArrayValued : true, 
    //acceptsSimpleTypes : true,
    fields : {},
    _$ID : "ID", _$id : "id",
    xmlToJS : function (element, context) {
        if (element == null || isc.xml.elementIsNil(element)) return null;

        var children = isc.xml.getElementChildren(element),
            valueMap = isc.xml.getAttributes(element),
            // any attribute is considered to be an id->value mapping
            gotIDMapping = !isc.isAn.emptyObject(valueMap);
        for (var i = 0; i < children.length; i++) {
            var child = children[i],
                ID = element.getAttribute(this._$ID) || element.getAttribute(this._$id),
                value = isc.xml.getElementText(child);
            if (ID != null && value != null) {
                // <value ID="idValue">displayValue</value>
                gotIDMapping = true;
                valueMap[ID] = value;
            } else if (ID != null) {
                // <value ID="idValue">displayValue</value>
                valueMap[ID] = ID;
            } else if (value != null) {
                // <value>onlyValue</value>
                valueMap[value] = value;
            } else {
                // <value/> or <value></value> means the empty value is legal
                valueMap[isc.emptyString] = isc.emptyString;
            }
        }
        // if we got at least one id -> value mapping, return the valueMap as a map
        if (gotIDMapping) return valueMap;
        // otherwise return it as an array
        return isc.getValues(valueMap);
    },
    xmlSerializeFields : function (data, flags, indent) {
        if (data == null || isc.DS.isSimpleTypeValue(data)) {
            return this.Super("xmlSerializeFields", arguments);
        }
    
        var output = isc.SB.create(),
            indent = (indent || "") + "    ";
        if (isc.isAn.Array(data)) {
            for (var i = 0; i < data.length; i++) {
                var value = data[i];
                output.append("\r", indent, "<value>", isc.makeXMLSafe(value), "</value>");
            }
        } else {
            // for objects, output the special valueMap format
            for (var id in data) {
                var value = data[id];
                output.append("\r", indent, "<value id=\"", isc.makeXMLSafe(id), "\">", 
                              isc.makeXMLSafe(value), "</value>");
            }
        }
        return output.toString();
    }
});

// --------------------------------------------------------------------------------------------


isc.ClassFactory.defineInterface("DataModel");


isc.DataModel.addInterfaceMethods({

getDataSource : function () {
    if (isc.isA.String(this.dataSource)) this.dataSource = isc.DS.get(this.dataSource);
    return this.dataSource;
},


getOperationId : function (operationType) {
    var operation = this.getOperation(operationType);
    return operation == null ? null : operation.ID;
},


getOperation : function (operationType) {
    var application = isc.rpc.getDefaultApplication(),
        operation,
        operationId;

    // see if an operation for this operation type was explicitly provided
    var operationProperty = operationType + "Operation";
    if (this[operationProperty]) {
        operation = this[operationProperty];

        // support operation spec in object or string form - if in object form, just return it
        if (isc.isAn.Object(operation)) return operation;

        // it's a string - use that as the operationId
        operationId = operation;
    }

    // no operation specified, create an auto-operation using the dataSource provided
    if (operationId == null) {
        var dataSource = this.getDataSource();
        if (dataSource == null) {
            this.logWarn("can't getOperation for type: " + operationType + 
                         ", no " + operationProperty + " specified, and no dataSource to " +
                         "create an auto-operation");
            return null;
        }
        this.logInfo("creating auto-operation for operationType: " + operationType);
        operation = isc.DataSource.makeDefaultOperation(dataSource, operationType);
                                                            
        // cache the auto-operation
        operationId = operation.ID;
        this[operationProperty] = operationId;        
    }

    return operation;
}

});


//> @class XJSONDataSource
// A DataSource preconfigured to use the +link{type:RPCTransport,"scriptInclude"} transport
// for cross-domain calls to JSON services, such as those provided
// by +externalLink{http://developer.yahoo.net/common/json.html#callbackparam,Yahoo}.
// <P>
// To use this DataSource, provide the URL of the service as +link{DataSource.dataURL}, and
// provide +link{DataSource.fields,fields} that describe the structure of the part of the
// returned data that you would like to use.
// <P>
// +link{DataSource.recordXPath} and +link{DataSourceField.valueXPath} can be used to extract
// data from the structure returned by the service.
// <P>
// This XJSONDataSource is really a subclass of DataSource with just a few property settings:
// <pre>
//    dataFormat : "json",
//    dataTransport : "scriptInclude"
//    callbackParam : "callback"
// </pre>
// <P>
// NOTE: if you use this DataSource to contact Yahoo web services, remember to include
// output=json in the dataURL, as well as a
// +externalLink{http://developer.yahoo.net/,Yahoo developer ID}.
// 
// @treeLocation Client Reference/Data Binding
// @visibility xmlBinding
// @example jsonYahooWebServices
//<
isc.defineClass("XJSONDataSource", "DataSource").addMethods({
    dataFormat : "json",
    dataTransport : "scriptInclude"
});


//> @groupDef clientDataIntegration
// SmartClient supports declarative, XPath-based binding of visual components to any server
// capable of returning XML or JSON responses over HTTP, without the need for the
// +link{group:serverDataIntegration,SmartClient server}.
// <P>
// This approach is called Client-Side Data Integration, which means:
// <ul>
// <li> You +link{group:dataSourceDeclaration,create DataSources} in JavaScript 
// which describe the data to be loaded and manipulated in the user interface. The
// JavaScript that creates these DataSources may be dynamically generated and/or existing
// metadata may be +link{group:metadataImport,imported}.
// <li> You configure DataSources, via property and method overrides, to send appropriate
// HTTP requests to your server, and to parse HTTP responses from your server, in order to
// fulfill the 4 core operations of the +link{group:dataSourceOperations,DataSource Protocol}.
// <li> These DataSources are then bound to 
// +link{dataBoundComponent,databinding-capable UI components}, which can provide a variety of
// complete user interactions (form-based editing, grid-based editing, load on demand, ..)
// based on these 4 core operations
// </ul>
// <P>
// <h4>Approaches and platforms</h4>
// <P>
// <B>WSDL integration (.NET and others)</B>
// <P>
// If you have pre-existing WSDL services or would like to generate web services for
// SmartClient to consume, the +link{group:wsdlBinding,WSDL Binding Overview} covers possible
// approaches.
// <P>
// WSDL binding is the most popular approach for integration with the .NET platform.
// You can 
// +externalLink{http://www.google.com/search?q=create+web+service+visual+studio,use Visual Studio to create web services}
// from existing server-side methods, and then use SmartClient's 
// +link{wsdlBinding,WSDL Binding} system to connect to those web services.  
// <P>
// Here are a couple of examples of integration with .NET web services:
// +externalLink{/examples/databinding/dotNET/temperatureConvert.jsp,temperature conversion service},
// and +externalLink{/examples/databinding/dotNET/customerSearch.jsp,customer search service}.
// Both use the +link{method:WebService.callOperation} method to query the web service. <b>Note:</b>
// These examples will only work if there's a web service running at the WSDL URLs used in the examples.
// <P>
// <B>REST integration (PHP and others)</B>
// <P>
// For PHP and other server technologies (Cold Fusion, Ruby, Python, Perl..), integration
// is based on simple XML or JSON delivered over HTTP, sometimes called the
// +externalLink{http://www.google.com/search?hl=en&q=REST+HTTP,REST} (REpresentational State
// Transfer) pattern.
// <P> 
// When using this, you create a dynamic web page that generates XML or JSON data for
// SmartClient to consume.
// <P>
// SmartClient DataSources can be configured to work with any pre-existing XML or JSON formats
// your application is already using; see below.
// <P>
// For new applications, the +link{RestDataSource} provides a complete XML or JSON-based
// protocol that supports all of the features of SmartClient's databinding layer (data paging,
// server-side validation errors, automatic cache synchronization, etc).  To use the
// RestDataSource, simply write server code that can parse RestDataSource requests and produce
// the required responses; example requests and responses are +link{RestDataSource,provided}.
// <P>
// <h4>Consuming Existing XML and JSON formats</h4>
// <p>
// For WSDL web services, see the +link{group:wsdlBinding,WSDL binding topic} first.
// <P>
// To display XML or JSON data in a visual component such as a ListGrid, you bind the component
// to a +link{DataSource} which provides the +link{DataSource.dataURL,URL} of the service, as
// well as a declaration of how to form inputs to the service and how to interpret service
// responses as DataSource records.
// <P>
// An XPath expression, the +link{attr:operationBinding.recordXPath,recordXPath}, is applied to
// the service response to select the XML elements or JSON objects that should be interpreted
// as DataSource records.  Then, for each field of the DataSource, an optional
// +link{attr:DataSourceField.valueXPath} can be declared which selects the value for the field
// from within each of the XML elements or JSON objects selected by the recordXPath.  If no
// valueXPath is specified, the field name itself is taken as an XPath, which will select the
// same-named subelement or property from the record element or object.
// <P>
// For example, the following code defines a DataSource that a ListGrid could bind to in order
// to display an RSS 2.0 feed.
// <PRE>
//    isc.DataSource.create({
//        dataURL:feedURL,
//        recordXPath:"//item",
//        fields:[
//            { name:"title" },
//            { name:"link" },
//            { name:"description" }
//        ]
//    });
// </PRE>
// A representative slice of an RSS 2.0 feed follows:
// <pre>
//     &lt;?xml version="1.0" encoding="iso-8859-1" ?&gt; 
//     &lt;rss version="2.0"&gt;
//     &lt;channel&gt;
//       &lt;title&gt;feed title&lt;/title&gt; 
//       ...
//       &lt;item&gt;
//         &lt;title&gt;article title&lt;/title&gt; 
//         &lt;link&gt;url of article&lt;/link&gt; 
//         &lt;description&gt;
//            article description
//         &lt;/description&gt; 
//       &lt;/item&gt;
//       &lt;item&gt;
//          ...
// </pre>
// Here, the recordXPath selects a list of &lt;item&gt; elements.  Since the intended values
// for each DataSource field appear as a simple subelements of each &lt;item&gt; element (eg
// &lt;description&gt;), the field name is sufficient to select the correct values, and no
// explicit valueXPath needs to be specified.
// <P>
// A running version of this example is available here: +explorerExample{rssFeed}.  Further
// examples of simple XML or JSON data loading using files stored on disk as the
// "service" to contact: the +explorerExample{simpleJSON,Simple JSON} example shows loading
// data from a JSON file into a databound grid, and the
// +explorerExample{xpathBinding,XPath Binding example} shows loading XML and processing it with
// XPaths.
// <P>
// <H4>Round Tripping: Loading, Editing and Saving</H4>
// <P>
// For WSDL web services, see the +link{group:wsdlBinding,WSDL binding topic} first.
// <P>
// When a user triggers a DSRequest (eg, completes an inline edit in a grid), the request
// data will be sent to the dataURL.  The +link{group:dataSourceOperations,DataSource protocol}
// describes request and response data expected for each operation type.  
// <P>
// By using settings such as +link{operationBinding.dataProtocol}, you can control how
// DSRequests are sent to your backend so that you can handle them most easily.  By using the
// same properties used to initially load data (eg
// +link{operationBinding.recordXPath,recordXPath}), you can control how SmartClient forms the
// DSResponses that are then interpreted by +link{DataBoundComponent,databound components}.
// <P>
// <b>Controlling how DSRequests are sent</b>
// <P>
// According to the +link{attr:operationBinding.dataProtocol,protocol} being used, the
// +link{group:dataSourceOperations,DataSource request data}, if any, either becomes HTTP
// params (sent by GET or POST), or an XML message as put together by
// +link{method:DataSource.xmlSerialize()}.  For a DataSource invoking a WSDL-described web
// service, XML serialization automatically handles namespacing and SOAP encoding.
// <P>
// Note that, by default, just +link{attr:dsRequest.data} is sent, not any of the metadata such
// as +link{attr:dsRequest.startRow}.  This can be customized via
// +link{method:DataSource.transformRequest()}.
// <P>
// The URL to contact is set via the +link{attr:operationBinding.dataURL,dataURL}
// property.  If using a Web Service, the <code>dataURL</code> defaults to the service location
// URL embedded in the WSDL file.
// <P>
// For example, in the default configuration for non-WSDL binding, since
// +link{operationBinding.dataProtocol,dataProtocol} is "getParams", +link{dsRequest.data} is
// sent as HTTP params in an HTTP "GET" operation.  Given:
// <ul>
// <li> changes to an existing record, hence an "update" request
// <li> a +link{dataSourceField.primaryKey,primaryKey} field of "id" with value "5" on the
// record to be updated
// <li> a field "age" being changed to "32"
// <li> "dataURL" of "save.php"
// </ul>
// You will see an HTTP GET to the URL <code>save.php?id=5&age=32</code>.
// <P>
// <b>Forming a DSResponse from the response data</b>
// <P>
// A +link{class:DSResponse} is created from the response data by using XPath
// expressions declared in the schema (+link{attr:operationBinding.recordXPath,recordXPath} and 
// +link{attr:DataSourceField.valueXPath,valueXPath}) to extract DataSource record and field
// values.
// <P>
// See the +explorerExample{xmlEditSave,"Edit and Save"} example for sample XML responses for
// all four operationTypes.  
// <P>
// Similar to input processing, by default DataSource layer metadata, such as
// +link{attr:dsResponse.startRow}, is not extracted from the response data.  You can
// implement +link{method:DataSource.transformResponse()} to fill out the metadata fields of
// the +link{class:DSResponse}, in order to allow more DataSource features, such as paging and
// validation errors, to be used with a web service that supports such features.  
// <P>
// See the +explorerExample{xmlServerValidationErrors, XML} and 
// +explorerExample{jsonServerValidationErrors, JSON} versions of the transformResponse()
// example for an example of providing validation errors in XML or JSON responses.
//
// @visibility xmlBinding
// @treeLocation Concepts/Client-Server Integration
// @treeLocation Client Reference/Data Binding
// @title Client-side Data Integration
//<

//> @groupDef nonJavaBackend
// SmartClient is fully functional without installation of the Java server included in the SDK,
// and can be integrated with any server technology.  This topic providing pointers to
// documentation that is most relevant for this type of integration.
// <P>
// <h4>Installation</h4>
// <P>
// As described in +link{group:iscInstall, <i>Deploying SmartClient</i>}, for a client-only
// integration, installation consists of just copying a directory of JavaScript and media files
// to your webserver.
// <P>
// <h4>Creating Components</h4>
// <P>
// SmartClient components can be included in any .html page, including dynamically generated pages
// produced by .php or .asp files.  The SmartClient libraries can be included in the page as
// follows:
// <pre>
// &lt;HTML&gt;&lt;HEAD&gt;
// &lt;SCRIPT&gt;var isomorphicDir="../isomorphic/";&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=../isomorphic/system/modules/ISC_Core.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=../isomorphic/system/modules/ISC_Foundation.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=../isomorphic/system/modules/ISC_Containers.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=../isomorphic/system/modules/ISC_Grids.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=../isomorphic/system/modules/ISC_Forms.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=../isomorphic/system/modules/ISC_DataBinding.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=../isomorphic/skins/SmartClient/load_skin.js&gt;&lt;/SCRIPT&gt;
// &lt;/HEAD&gt;&lt;BODY&gt;
// ...</pre>
// SmartClient components can then be created via normal JavaScript:
// <pre>
// &lt;SCRIPT&gt;
// isc.Button.create({
//     title:"Button",
//     click:"isc.say('Hello World')"
// });
// &lt;/SCRIPT&gt;</pre>
// This approach is discussed in more detail in the 
// +externalLink{/docs/SmartClient_Quick_Start_Guide.pdf,QuickStart Guide}, Chapter 4, <i>Coding</i>.
// Note that JavaScript-based component instantiation is currently the recommended approach, and
// most examples are provided in the JavaScript format.
// <P>
// <h4>Data Loading / Data Binding</h4>
// <P>
// The primary focus of SmartClient integration is connecting DataSource operations to your
// server.  The +link{group:clientDataIntegration,Client-side Data Integration} chapter covers
// the key approaches, including cookbook approaches for REST-based integration with any server
// that can return XML or JSON over HTTP.
// <P>
// <h4>Simple RPCs (non-DataSource requests)</h4>
// <P>
// You can implement simple RPCs as web service operations: use
// +link{XMLTools.loadWSDL()} to load the service definition, and then use
// +link{WebService.callOperation()} to call the operations.  Note that some server frameworks
// allow the generation of WSDL from server method signatures.
// <P>
// Alternatively, if your backend is capable of outputting 
// +externalLink{http://www.json.org/,JSON} (JavaScript Object Notation), you can use 
// +link{RPCRequest.evalResult} to directly turn JSON results into live JavaScript objects.
// +link{RPCRequest.serverOutputAsString} lets you load arbitrary server results, including
// JSON results that need to be processed before they can be eval()'d.
// <P>
// <h4>HTTPProxy: Cross-site or cross-port data loading</h4>
// <P>
// If you develop a prototype using the SmartClient SDK and SmartClient Java Server, and then
// you migrate the prototype to another server technology, you need to be aware that the
// SmartClient Java Server includes an HTTPProxy servlet that allows SmartClient interfaces to
// contact servers other than the origin server (bypassing what is called the
// +externalLink{http://www.google.com/search?q=same+origin+policy,"same origin policy"}).
// <P>
// SmartClient uses the HttpProxy automatically when needed, so it may not be obvious that the
// HTTPProxy is in use.  Then, your migrated application will encounter errors attempting to
// contact the HTTPProxy servlet.
// <P>
// To avoid these errors, ensure that all services that your application uses are accessed
// using the same hostname and port as the page was loaded from.  In particular, watch for WSDL
// files, which contain the service URL - you may need to use +link{webService.setLocation()}
// to ensure that the web service URL and page URL match.
// <P>
// If your production application really does need to access services or content hosted on
// other servers, typical practice is to persue normal SmartClient integration with your
// server, then write server-side code that contacts other hosts on behalf of your SmartClient
// interface.
//
// @visibility xmlBinding
// @treeLocation Concepts
// @title .NET, PHP, Serverless Integration
//<


//> @groupDef jspTags
// 
// The SmartClient Java Server component ships with a number of custom JSP tags designed to
// make development with SmartClient easier.  The custom tags are defined in
// <code>[webroot]/WEB-INF/iscTaglib.xml</code> in the SDK package.  To make use of these tags, make
// sure you have the following entry in your web.xml (the SDK already contains this entry by
// default):<br>
// <pre>
// &lt;taglib&gt;
//     &lt;taglib-uri&gt;isomorphic&lt;/taglib-uri&gt; 
//     &lt;taglib-location&gt;/WEB-INF/iscTaglib.xml&lt;/taglib-location&gt; 
// &lt;/taglib&gt;
// </pre>
// <p>
// Also, the JSP page making use of the tag must load the custom taglib via the following
// directive:<br>
// <pre>
// &lt;%@ taglib uri="/WEB-INF/iscTaglib.xml" prefix="isomorphic" %&gt;
// </pre>
// All SmartClient JSP tags produce either HTML or JavaScript output, so you can easily see
// what any given tag is generating by doing a "View->Source" in your browser after browsing to
// the JSP that contains your tag.  Tags that produce HTML must be located in the HTML BODY
// context in your JSP - that is, outside of any <code>&lt;SCRIPT&gt;</code> tags and inside
// <code>&lt;BODY&gt;</code> tags.  Tags that produce JavaScript must be located inside
// <code>&lt;SCRIPT&gt;</code> tags.
//
// @visibility external
// @requiresModules SCServer    
// @title SmartClient JSP Tags
//<

//> @groupDef loadISCTag
//
// <i>produces:</i> HTML
// <p>
// This tag sets window.isomorphicDir and loads a default set of SmartClient modules and a
// skin.  SmartClient modules are JavaScript files that need to be loaded via 
// <code>&lt;SCRIPT SRC=/some/filename.js&gt;&lt;/SCRIPT&gt;</code>
// blocks as part of the loading HTML page.  The modules themselves are stored in the
// <code>[webroot]/isomorphic/system/modules</code> directory.  A skin defines the look and feel of your
// website and typically consists of at least one CSS file and some SmartClient UI Component
// default overrides.  Skins are located in <code>[webroot]/isomorphic/skins</code>.  Loading a skin
// consists of loading the corresponding <code>load_skin.js</code> - residing at top-level in
// each skin directory.
// <p>
// The default set of modules loaded by this tag are: <code>Core, Foundation, Containers,
// Grids, Forms, DataBinding</code>.  The default skin is the <code>SmartClient</code> skin.
// So, for example inserting this into your JSP:
// <pre>
// &lt;isomorphic:loadISC/&gt;
// </pre>
// Produces the following output:
// <pre>
// &lt;SCRIPT&gt;window.isomorphicDir='isomorphic/';&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=isomorphic/system/development/ISC_Core.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=isomorphic/system/development/ISC_Foundation.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=isomorphic/system/development/ISC_Containers.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=isomorphic/system/development/ISC_Grids.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=isomorphic/system/development/ISC_Forms.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=isomorphic/system/development/ISC_DataBinding.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT src=isomorphic/skins/SmartClient/load_skin.js&gt;&lt;/SCRIPT&gt;
// </pre>
// <b><u>Tag Attributes:</u></b>
// <p>
// <b>skin</b><br>
// <i>value format</i>: Name of skin to load.  See the <code>[webroot]/isomorphic/skins</code> directory
// for a list of available skins.  You can also create your own skin by copying an existing
// skin directory recursively, modifying anything you need, and using your new skin name as the
// value here.<br>
// <i>default value</i>: "SmartClient"
// <p>
// This selects a skin other than the default.  The value of this attribute is used as a path
// component to <code>load_skin.js</code>.  For example, specifying:
// <pre>
// &lt;isomorphic:loadISC skin="standard"/&gt;
// </pre>
// Produces the following <code>load_skin.js</code> directive (in addition to all the standard
// module loads):
// <pre>
// &lt;SCRIPT src=isomorphic/skins/standard/load_skin.js&gt;&lt;/SCRIPT&gt;
// </pre>
// <p>
// <b>skinDir</b><br>
// <i>value format</i>: path or URL up to and including the name of the skin<br>
// <i>default value</i>: automatically derived from the value of the <code>skin</code>
// attribute
// <p>
// This attribute is usable in lieu of the <code>skin</code> attribute and allows you to
// specify the full path or URL to the directory containing the load_skin.js for your skin.
// This allows you to move the directory containing the skin anywhere you want - including to a
// completely different server.
// <p>
// <b>includeModules</b><br>
// <i>value format</i>: Comma separated list of additional modules to load.  See the
// <code>[webroot]/isomorphic/system/modules</code> directory for a list of loadable modules.  The
// leading "ISC_" is optional, spaces after commas also optional.<br>
// <i>default value</i>: NONE
// <p>
// This attribute allows you to specify SmartClient modules that you want to load in addition
// to the default set of modules. For example, specifying:
// <pre>
// &lt;isomorphic:loadISC includeModules="Analytics"/&gt;
// </pre>
// Produces the following output:
// <pre>
// &lt;SCRIPT&gt;window.isomorphicDir='isomorphic/';&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=isomorphic/system/development/ISC_Core.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=isomorphic/system/development/ISC_Foundation.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=isomorphic/system/development/ISC_Containers.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=isomorphic/system/development/ISC_Grids.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=isomorphic/system/development/ISC_Forms.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=isomorphic/system/development/ISC_DataBinding.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT SRC=isomorphic/system/development/ISC_Analytics.js&gt;&lt;/SCRIPT&gt;
// &lt;SCRIPT src=isomorphic/skins/SmartClient/load_skin.js&gt;&lt;/SCRIPT&gt;
// </pre>
// Notice the addition of the line that loads <code>ISC_Analytics.js</code>.  SmartClient
// modules must be loaded in a particular order and may have dependencies on other modules.
// The <code>loadISC</code> automatically resolves any missing dependencies and includes them
// in the list of modules to load.  The list of modules to load is also automatically reordered
// as required by this tag, so you can specify just the modules you care about, in any order,
// and <code>loadISC</code> will do the right thing.
// <p>
// <b>modules</b><br>
// <i>value format</i>: Comma separated list of modules to load.  See the
// <code>[webroot]/isomorphic/system/modules</code> directory for a list of loadable modules.  The
// leading "ISC_" is optional, spaces after commas also optional.<br>
// <i>default value</i>: "Core, Foundation, Containers, Grids, Forms, DataBinding"
// <p>
// Specifying this attribute overrides the default set of modules loaded by
// <code>loadISC</code> This is useful if you don't need to load all of the default modules on
// a particular page.
// <p>
// <b>isomorphicURI</b><br>
// <i>value format</i>: absolute or relative (from current URI) path to the
// <code>isomorphic</code> directory (by default located in webRoot).<br>
// <i>default value</i>: automatically derived
// <p>
// This value sets <code>window.isomorphicDir</code> and defines the base path to SmartClient
// modules from the currently exectuing JSP.  By default, this value is automatically derived
// and you don't need to override it.  Generally, an override is only required if you're
// pointing multiple web application deployments at one base URL for cache coherence reasons.
// <p>
// <b>defer</b><br>
// <i>value format</i>: boolean - acceptable values: "true" or "false"<br>
// <i>default value</i>: "false"
// <p>
// This attribute applies only if you're using the optional Network Performance component of
// SmartClient.  By default, the modules specified by the <code>loadISC</code> tag are loaded
// synchronously - that is, the the browser waits for each module to download before rendering
// any HTML on the page.  Specifying <code>defer="true"</code> makes the module load
// asynchronous.  In this mode, all the page content except the modules specified by
// <code>loadISC</code> is loaded and rendered first, and then the SmartClient modules are
// loaded.  The asynchronous mode makes it possible to render some content and allow the user
// to interact with the site immediately, while SmartClient modules load in the background.
// <p>
// Note that typically SmartClient modules are delivered compressed with cache headers, so the
// download delay really only affects first time users of your site, those whose cached
// versions have expired, or if you've upgraded your SmartClient module to a newer version that
// the user has cached.
// <p>
// Using this directive is equivalent to calling +link{FileLoader.loadISC()}.
// <p>
// <b>cacheOnly</b><br>
// <i>value format</i>: boolean - acceptable values: "true" or "false"<br>
// <i>default value</i>: "false"
// <p>
// This attribute applies only if you're using the optional Network Performance component of
// SmartClient.  This works like <code>defer</code> (see above), except that the modules are
// only loaded into the browser cache, but not executed.  This means that when the specified
// modules download, they'll be added to the browser cache, but will not be available to the
// execution context of the page.  Actually executing the module code takes some processing
// time on the client, whereas simply caching it does not.  The typical use case for this
// directive is on some intermediary page before the user gets to a SmartClient-enabled page.
// For example, you could include a cacheOnly <code>loadISC</code> tag on a login page that
// does not use SmartClient components, but protects a SmartClient-enabled application.  While
// the user is typing in their credentials, the SmartClient modules will cache in the
// background, then once the user logs in and is sent to a SmartClient-enabled page, the
// modules are simply read from cache.
// <p>
// Using this directive is equivalent to calling +link{FileLoader.cacheISC()}.
// <p>
// <b>onload</b><br>
// <i>value format</i>: String - any javascript code<br>
// <i>default value</i>: NONE
// <p>
// This attribute applies only if you're using the optional Network Performance component of
// SmartClient.  This attribute is usable in conjuction with <code>defer</code> and
// <code>cacheOnly</code> attributes.  This attribute allows you to specify a callback to
// execute when loading or caching of the specified modules has completed.  You can use this
// to, for example, replace portions of the page with SmartClient components once SmartClient
// has loaded.
// <p>
// The value of this attribute is passed as the <code>onload</code> handler to the generated
// +link{FileLoader.cacheISC()} or +link{FileLoader.loadISC()} call as appropriate.
// <p>
// <b>useSimpleNames</b><br>
// <i>value format</i>: boolean - acceptable values: "true" or "false"<br>
// <i>default value</i>: "true"
// <p>
// Setting this attribute to false puts SmartClient in namespace mode.  See +link{class:isc}
// for more info.
//
// @visibility external
// @requiresModules SCServer    
// @treeLocation Java Server Reference/SmartClient JSP Tags
// @title &lt;isomorphic:loadISC&gt;
//<


//> @groupDef loadModulesTag
//
// <i>produces:</i> HTML
// <p>
// This tag works just like +link{group:loadISCTag} except it does not load a skin.  All other
// attributes are supported on this tag just as on <code>loadISC</code>.  This tag is useful if
// you have a single "header" JSP that has the <code>loadISC</code> tag that you then include in other
// SmartClient-enabled JSPs that require additional modules.  The JSPs that require additional
// modules can then use the <code>loadModules</code> to load additional SmartClient modules.
//
// @visibility external
// @requiresModules SCServer    
// @treeLocation Java Server Reference/SmartClient JSP Tags
// @title &lt;isomorphic:loadModules&gt;
//<


//> @groupDef loadDSTag
//
// <i>produces:</i> JavaScript
// <p>
// This tag converts a SmartClient DataSource defined in XML to JavaScript for use in
// databinding on the client (browser).
// <p>
// Note that this JSP tag must be surrounded by &lt;SCRIPT&gt; tags in the JSP because it
// generates JavaScript code.  Like other tags that generate JavaScript code, this tag can be
// used in a JSP that is included from your main page in order to create separate
// cacheability.  For example:<pre>
//     &lt;SCRIPT SRC="myDataSources.jsp"&gt;&lt;/SCRIPT&gt;
// </pre>
// <p>
// <b><u>Tag Attributes:</u></b>
// <p>
// <b>ID</b><br>
// <i>value format</i>: String - ID of datasource to load<br>
// <i>default value</i>: NONE
// <p>
// This attribute specifies the name of the dataSource that you wish to load.  DataSources are
// located in <code>[webroot]/shared/ds</code> by default.  This location is changeable in
// <code>[webroot]/WEB-INF/classes/server.properties</code> by setting the config parameter
// <code>project.datasources</code> to the directory where your dataSources are located.
// We recommend that for prototying, at least, you use the default directory.
// <p>
// For example:
// <pre>
// &lt;isomorphic:loadDS ID="supplyItem"/&gt;
// </pre>
// Would load the <code>supplyItem</code> DataSource.
// <p>
// You can also load multiple dataSources in one go by specifying a comma-separated list of 
// dataSource names as the ID.  For example:
// <pre>
// &lt;isomorphic:loadDS ID="supplyItem, employees, worldDS"/&gt;
// </pre>    
// See +link{group:dataSourceDeclaration} for more details on creating DataSources and an
// example.
// <p>
// <b>name</b><br>
// <i>value format</i>: String - ID of datasource to load<br>
// <i>default value</i>: NONE
// <p>
// This is a synonym for the <code>ID</code> attribute.
// 
//
// @see group:dataSourceDeclaration 
//
// @visibility external
// @requiresModules SCServer    
// @treeLocation Java Server Reference/SmartClient JSP Tags
// @title &lt;isomorphic:loadDS&gt;
//<


//> @groupDef loadUITag
//
// <i>produces:</i> JavaScript
// <p>
// This tag converts SmartClient UI components declaratively specified in an XML "UI" file to
// JavaScript for execution in the browser.
// <p>
// The XML->JS translation works just like with +link{group:xmlTag}, except the XML is read
// from an external file instead of from the body of the tag.
// <p>
// Note that this JSP tag must be surrounded by &lt;SCRIPT&gt; tags in the JSP because it
// generates JavaScript code.  Like other tags that generate JavaScript code, this tag can be
// used in a JSP that is included from your main page in order to create separate
// cacheability.  For example:<pre>
//     &lt;SCRIPT SRC="myUIDefinitions.jsp"&gt;&lt;/SCRIPT&gt;
// </pre>
// <p>
// <p>
// <b><u>Tag Attributes:</u></b>
// <p>
// <b>name</b><br>
// <i>value format</i>: String - name of UI file to load (minus extension)<br>
// <i>default value</i>: NONE
// <p>
// This attribute specifies the name of the file that contains the UI components to translate.
// UI files are located in <code>[webroot]/shared/ui</code> by default.  This location is
// changeable in <code>[webroot]/WEB-INF/classes/server.properties</code> by setting the config
// parameter <code>project.ui</code> to the directory where your UI files are located.   
// We recommend that for prototying, at least, you use the default directory.
// <p>
// For example:
// <pre>
// &lt;isomorphic:loadUI name="test"/&gt;
// </pre>
// Would translate declarative XML in the file <code>[webroot]/shared/ui/test.ui.xml</code> to
// JavaScript and output the results into the JSP output stream at the location of the tag.
//
// @see group:xmlTag
//
// @visibility external
// @requiresModules SCServer    
// @treeLocation Java Server Reference/SmartClient JSP Tags
// @title &lt;isomorphic:loadUI&gt;
//<

//> @groupDef xmlTag
//
// <i>produces:</i> JavaScript
// <p>
// This tag convers SmartClient UI components declaratively specified in the body of the tag to
// JavaScript for execution in the browser.
// <p>
// The XML->JS translation works just like with +link{group:loadUITag}, except the XML is read
// from the body of the tag instead of an external file.
// <p>
// Note that this JSP tag must be surrounded by &lt;SCRIPT&gt; tags in the JSP because it
// generates JavaScript code.  Like other tags that generate JavaScript code, this tag can be
// used in a JSP that is included from your main page in order to create separate
// cacheability.  For example:<pre>
//     &lt;SCRIPT SRC="myUIDefinitions.jsp"&gt;&lt;/SCRIPT&gt;
// </pre>
// <p>
// Example of using this tag :
// <pre>
// &lt;isomorphic:XML&gt;
// &lt;Canvas&nbsp;backgroundColor="black"/&gt;
// &lt;/isomorphic:XML&gt;
// </pre>
// Would output the following JavaScript code:
// <pre>
// Canvas.create({
//   backgroundColor: "black"
// });
// </pre>
//
// @see loadUITag
//
// @visibility external
// @requiresModules SCServer    
// @treeLocation Java Server Reference/SmartClient JSP Tags
// @title &lt;isomorphic:XML&gt;
//<

//> @groupDef loadXMLSchemaTag
//
// <i>produces:</i> JavaScript
// <p>
// Load an XML Schema (.xsd) file and create a +link{SchemaSet} object representing the loaded
// definitions. This tag works just like +link{XMLTools.loadXMLSchema()}, except it's
// synchronous and the result is server-cacheable.
// <p>
// Note that this JSP tag must be surrounded by &lt;SCRIPT&gt; tags in the JSP because it
// generates JavaScript code.  Like other tags that generate JavaScript code, this tag can be
// used in a JSP that is included from your main page in order to create separate
// cacheability.  For example:<pre>
//     &lt;SCRIPT SRC="myXMLSchemaDefinitions.jsp"&gt;&lt;/SCRIPT&gt;
// </pre>
// <p>
// <b><u>Tag Attributes:</u></b>
// <p>
// <b>url</b><br>
// <i>value format</i>: URL or URI
// <i>default value</i>: NONE
// <p>
// This attribute specifies the URL or URI of the XML Schema file to fetch and translate.  This
// can be either a remote URL - e.g: <code>http://host:port/schemaFile.xsd</code> or a relative
// or absolute URI to a file local to this container - e.g: <code>/some/schemaFile.xsd</code>
// or <code>../some/schemaFile.xsd</code>.  If the url is a remote URL, then an HTTP request
// will be made for the file.  If it is local, it will be fetched from disk using standard
// Servlet APIs (<code>ServletContext.getResourceAsStream()</code>).
// <p>
// <b>cache</b><br>
// <i>value format</i>: Integer (number of seconds to cache result)
// <i>default value</i>: 3600 (1 hour)
// <p>
// This attribute specifies the number of seconds for which the fetched XML Schema is cacheable
// on the server.  Fetching a XML Schema file from a remote server can cause a significant
// delay in JSP processing, and XML Schema files rarely change outside of a development
// environment.  Set this value to zero to disable caching.
//
// @see XMLTools.loadXMLSchema()
//
// @visibility xmlBinding
// @requiresModules SCServer    
// @treeLocation Java Server Reference/SmartClient JSP Tags
// @title &lt;isomorphic:loadXMLSchema&gt;
//<

//> @groupDef loadWSDLTag
//
// <i>produces:</i> JavaScript
// <p>
// Load a WSDL file and create an instance of +link{WebService} that allows invoking operations
// and binding DataSources to web service operations. This tag works just like
// +link{XMLTools.loadWSDL()}, except it's synchronous and the result is server-cacheable.
// <p>
// Note that this JSP tag must be surrounded by &lt;SCRIPT&gt; tags in the JSP because it
// generates JavaScript code.  Like other tags that generate JavaScript code, this tag can be
// used in a JSP that is included from your main page in order to create separate
// cacheability.  For example:<pre>
//     &lt;SCRIPT SRC="myWebServiceDefinition.jsp"&gt;&lt;/SCRIPT&gt;
// </pre>
// <p>
// <b><u>Tag Attributes:</u></b>
// <p>
// <b>url</b><br>
// <i>value format</i>: URL or URI
// <i>default value</i>: NONE
// <p>
// This attribute specifies the URL or URI of the WSDL file to fetch and translate.  This can
// be either a remote URL - e.g: <code>http://host:port/wsdlFile.wsdl</code> or a relative or
// absolute URI to a file local to this container - e.g: <code>/some/wsdlFile.wsdl</code> or
// <code>../some/wsdlFile.wsdl</code>.  If the url is a remote URL, then an HTTP request will
// be made for the file.  If it is local, it will be fetched from disk using standard Servlet
// APIs (<code>ServletContext.getResourceAsStream()</code>).
// <p>
// <b>cache</b><br>
// <i>value format</i>: Integer (number of seconds to cache result)
// <i>default value</i>: 3600 (1 hour)
// <p>
// This attribute specifies the number of seconds for which the fetched WSDL is cacheable on
// the server.  Fetching a WSDL file from a remote server can cause a significant delay in JSP
// processing, and WSDL files rarely change outside of a development environment.  Set this
// value to zero to disable caching.
//
// @see group:wsdlBinding
// @see XMLTools.loadWSDL()
//
// @visibility xmlBinding
// @requiresModules SCServer    
// @treeLocation Java Server Reference/SmartClient JSP Tags
// @title &lt;isomorphic:loadWSDL&gt;
//<

//> @groupDef jsStringTag
//
// <i>produces:</i>JavaScript
// <p>
// This tag takes everything in its body and outputs a correctly-escaped JavaScript string.
// This is useful for capturing HTML for display in a Canvas or Label, for example.
// <p>
// <b><u>Tag Attributes:</u></b>
// <p>
// <b>var</b><br>
// <i>value format</i>: Any legal egal JavaScript variable name
// <i>default value</i>: NONE
// <p>
// If specified, the escaped string is assigned to a newly created variable of the specified
// name.  e.g: var foo = "bar";
// <p>
// <b>filename</b><br>
// <i>value format</i>: webRoot-relative path to file
// <i>default value</i>: NONE
// <p>
// If specified, the resulting string contents is loaded from the specified file instead of
// from the tag body.
//
// @visibility external
// @requiresModules SCServer
// @treeLocation Java Server Reference/SmartClient JSP Tags
// @title &lt;isomorphic:jsString&gt;
//<



//> @groupDef xmlClientVsServer
// Server benefits
// - faster client-side processing
// Server neutral
// - heavy customization of XML transform, if any, written in Java
//
// Client benefits
// - faster server-side processing
// Client neutral
// - heavy customization of XML transform, if any, written in JavaScript
//<

