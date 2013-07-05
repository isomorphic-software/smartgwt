
package com.smartgwt.client.docs;

/**
 * <h3>Internationalization and Localization</h3>
 * <b><u>Internationalizing Smart GWT Applications</u></b>
 *  <p>
 *  Internationalizing a Smart GWT application involves creating locale-specific
 *  versions of all strings, images, and possibly colors.  In some cases, component layout may
 *  be affected as well (for example date field order differs between some locales).
 *  <p>
 *  <u><b>Character Encodings</b></u>
 *  <p>
 *  In order to deliver content in different languages to the browser and have it be displayed
 *  correctly, it is important that the browser and server agree on the character encoding being
 *  used to send the page.  
 *  <p>
 *  Generally speaking, you can use whatever character encoding you prefer, so long as
 *  you're consistent about serving your files to the browser with exactly the same encoding
 *  as was used to save the file to disk.  Keep in mind though that the character encoding you
 *  choose must be supported by all browsers you intend to support.  Isomorphic recommends that,
 *  where possible, you use the UTF-8 encoding.  Regardless of which character encoding you
 *  choose, keep in mind that for the browser to correctly display non-ASCII characters, you
 *  <b>must</b> explicitly set the character encoding of your page to match the encoding you
 *  used to save the file.  Browsers have built-in heuristics to guess the character encoding,
 *  but they can't be relied upon to work 100% of the time.
 *  <p>
 *  There are two ways to explicitly tell the browser what character
 *  encoding is being used for a given page.  One is to set the "Content-Type" HTTP header, for
 *  example:
 *  <pre>
 *  Content-Type: text/html; charset=UTF-8
 *  </pre>
 *  If you're using JSP on the back-end, you can set this header as follows:
 *  <pre>
 *  &lt;%@ page contentType="text/html; charset=UTF-8"%&gt;
 *  </pre>
 *  Or using Java Servlet APIs in a Servlet as follows:
 *  <pre>
 *  response.setContentType("text/html; charset=UTF-8");
 *  </pre>
 *  Note that the latter needs to be done before any content is written to the response output
 *  stream.
 *  <p>
 *  The other approach to setting the content encoding is to use an HTML META tag to embed it
 *  in the page itself (note that this applies to HTML documents only).  The META tag must go
 *  inside the &lt;HEAD&gt; HTML element - e.g. as follows:
 *  <pre>
 *  &lt;HEAD&gt;
 *  &lt;META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8"&gt;
 *  &lt;/HEAD&gt;
 *  </pre>
 *  In addition, for a .html or other static (non-.jsp) file, you must also ensure that the file
 *  itself is saved in UTF-8 encoding.  Advanced text editors (including the Eclipse IDE) can
 *  show you the encoding of a text file and allow you to change it.  In Eclipse this is in the
 *  Preferences area (search for "Encoding") and UTF-8 is <b>not the default</b> for .html
 *  files, and should be changed.
 *  <P>
 *  Isomorphic recommends that you follow <b>all</b> of the above approaches for maximum
 *  compatibility.  For example, if you omit the META tag approach, pages saved by the user
 *  using the browser save function may not render correctly when subsequently read from disk
 *  because HTTP headers are not available in that context.  Conversely, not providing the
 *  HTTP header or not saving the file in UTF-8 can result in application servers delivering the
 *  file in the encoding in which it is saved, or in their own default and incorrect content
 *  encoding.
 *  <p>
 *  If you're using a given character encoding pervasively in your pages, you can also configure
 *  your web server or application server to use that character encoding as the default for all
 *  pages of a given mime type or some other criteria (depending on the capability of your
 *  server) - for example on a per-directory basis.
 *  <p>
 *  For more information on character encodings, character sets, and working with HTML, please
 *  see W3C's tutorial here:
 * <a href='http://www.w3.org/International/tutorials/tutorial-char-enc/'
 * onclick="window.open('http://www.w3.org/International/tutorials/tutorial-char-enc/');return
 * false;">http://www.w3.org/International/tutorials/tutorial-char-enc/</a>
 *  <p>
 *  <b>NOTE: Default Encoding</b>
 *  <p>
 *  As mentioned above, Isomorphic recommends the use of UTF-8 encoding.  However, it is 
 *  not possible to configure some servlet engines to do this by default.  Both Tomcat and Jetty 
 *  default to the ISO-8859-1 character set (commonly known as Latin-1), even if the Java VM 
 *  specifies a different encoding (the Tomcat documentation claims that this behavior is a 
 *  requirement of the Servlet specification).
 *  <p>
 *  To work around this, we change charset encoding to UTF-8 on every request/response that 
 * goes through two core Isomorphic servlets: <code>IDACall</code> and
 * <code>DataSourceLoader</code>.
 *  If you need to change this, you can do so by adding <code>init-param</code> settings to your
 *  <code>web.xml</code> file.  Please see the Javadocs for those two servlets for examples of 
 *  how to do this.
 *  <p>
 *  <u><b>Framework Message Localization</b></u>
 *  <p>
 *  Smart GWT components include standard prompts and error messages in various cases, and all
 *  such messages support localization.
 *  <P>
 *  
 *  
 *  SmartGWT ships with pre-built language packs for many languages.  These are automatically 
 *  used by the framework: all you have to do is ensure that the appropriate locale has been
 *  set using one of the 
 * <a
 * href=https://developers.google.com/web-toolkit/doc/latest/DevGuideI18nLocale#LocaleSpecifying>standard
 * GWT mechanisms</a>.
 *  In brief, either:<ul>
 * <li>Add a meta tag to your bootstrap page: <code>&lt;meta name="gwt:property"
 * content="locale=ja_JP"&gt;</code></li>
 * <li>Specify the locale in a query parameter:
 * <code>http://www.example.org/myapp.html?locale=fr_CA</code></li>
 *  </ul>
 *  
 *  <P>
 *  If you find that the language pack you are using has any incorrect or missing translations,
 *  or you want to add a new language pack, please visit
 * <a href='http://forums.smartclient.com/showthread.php?t=9987'
 * onclick="window.open('http://forums.smartclient.com/showthread.php?t=9987');return false;">this
 * forums thread</a> for
 *  instructions on how to contribute translations so that they will be added to future
 *  Smart GWT builds.
 *  <P>
 *  You can alternatively maintain your own private additions or overrides to the default
 *  language packs.
 *  
 *  
 *  Use the standard GWT technique for selectively overriding Messages: create a
 *  subclass of <code>SmartGwtMessages</code> that overrides specific methods, and a 
 *  .properties file with your overridden messages.  Then create your overridden Messages
 *  instance and call <code>I18nUtil.initMessages()</code> with it.  For example:
 *  <pre>
 *     public class CustomizedSgwtMessages extends com.smartgwt.client.i18n.SmartGwtMessages {
 *        // override button_title
 *        String button_title();
 *     }
 *    
 *     // then in a new file CustomizedSgwtMessages.properties
 *     button_title=My Title
 * 
 *     // and in a new file CustomizedSgwtMessages_fr.properties
 *     button_title=French translation
 * 
 *     // then in your onModuleLoad() call
 *     CustomizedSgwtMessages myMessages = GWT.create(CustomizedSgwtMessages);
 *     I18nUtil.initMessages(myMessages);
 *  </pre>
 *  
 *  <p>
 *  <u><b>Application Message Localization</b></u>
 *  <p>
 *  
 *  
 * String localization in SmartGWT is best done using <a
 * href=http://code.google.com/webtoolkit/doc/latest/DevGuideI18n.html>
 *  standard GWT approaches</a>.  Although GWT supports various ways of localizing strings, 
 *  Isomorphic recommends the use of an approach based on Resource Bundles.  Other parts of 
 *  SmartGWT - for example, <code>.ds.xml</code> files - are best localized using resource 
 *  bundles, so using resource bundles makes it easier to share messages that are used both
 *  client and server side.
 *  
 *  <p>
 *  <u><b>Support for Right-to-Left (RTL) languages</b></u>
 *  <P>
 *  Smart GWT includes support for RTL languages.  To enable, simply set
 *  <code>dir="rtl"</code> on the HTML element:
 *  <pre>
 *     &lt;HTML dir="rtl"&gt;
 *  </pre>
 *  ListGrid columns, horizontal layouts, scrolling directions, etc will reverse order
 *  automatically.
 *  <p>
 *  Because RTL in some cases requires additional media files, RTL is only supported for the
 *  Enterprise, EnterpriseBlue and Graphite skins.
 *  <p>
 *  <u><b>DataSource and Component XML localization</b></u>
 *  <p>
 *  Please see the separate article on 
 * {@link com.smartgwt.client.docs.DataSourceLocalization DataSource and Component XML
 * Localization}
 *  <p>
 *  <u><b>Localized Number and Currency Formatting</b></u>
 *  <p>
 *  Please see the separate article on 
 *  {@link com.smartgwt.client.docs.LocalizedNumberFormatting Localized Number Formatting}
 *  <p>
 *  
 *  Resources:
 *  <p>
 *  <b><u>Java</u></b>
 *  <ul>
 * <li>Sun's i18n tutorial: <a href='http://java.sun.com/docs/books/tutorial/i18n/'
 * onclick="window.open('http://java.sun.com/docs/books/tutorial/i18n/');return
 * false;">http://java.sun.com/docs/books/tutorial/i18n/</a>
 * <li>JSTL home page: <a href='http://java.sun.com/products/jsp/jstl/'
 * onclick="window.open('http://java.sun.com/products/jsp/jstl/');return
 * false;">http://java.sun.com/products/jsp/jstl/</a>
 *  <li>Apache JSTL "Getting Started": 
 * <a href='http://jakarta.apache.org/taglibs/doc/standard-doc/standard/GettingStarted.html'
 * onclick="window.open('http://jakarta.apache.org/taglibs/doc/standard-doc/standard/GettingStarted.html');return
 * false;">http://jakarta.apache.org/taglibs/doc/standard-doc/standard/GettingStarted.html</a>
 * <li>Apache taglibs: <a href='http://jakarta.apache.org/taglibs/'
 * onclick="window.open('http://jakarta.apache.org/taglibs/');return
 * false;">http://jakarta.apache.org/taglibs/</a>
 *  </ul>
 *  <p>
 * 
 *  <b><u>.NET</u></b>
 *  <ul>
 *  <li>MSDN Developer Resource: "Developing World-Ready Applications":
 * <a
 * href='http://msdn.microsoft.com/library/default.asp?url=/library/en-us/cpguide/html/cpcondesigningglobalapplications.asp'
 * onclick="window.open('http://msdn.microsoft.com/library/default.asp?url=/library/en-us/cpguide/html/cpcondesigningglobalapplications.asp');return
 * false;">http://msdn.microsoft.com/library/default.asp?url=/library/en-us/cpguide/html/cpcondesigningglobalapplications.asp</a>
 *  </ul>
 * 
 *  <b><u>PHP</u></b>
 *  <ul>
 * <li>PHP Gettext manual: <a href='http://us2.php.net/gettext'
 * onclick="window.open('http://us2.php.net/gettext');return
 * false;">http://us2.php.net/gettext</a>
 * <li>O'Reilly Gettext tutorial: <a href='http://www.onlamp.com/pub/a/php/2002/06/13/php.html'
 * onclick="window.open('http://www.onlamp.com/pub/a/php/2002/06/13/php.html');return
 * false;">http://www.onlamp.com/pub/a/php/2002/06/13/php.html</a>
 *  </ul>
 *  <p>
 * 
 *  <b><u>Perl</u></b>
 *  <ul>
 * <li>Perl, Unicode and i18n FAQ: <a href='http://rf.net/~james/perli18n.html'
 * onclick="window.open('http://rf.net/~james/perli18n.html');return
 * false;">http://rf.net/~james/perli18n.html</a>
 *  </ul>
 */
public interface I18n {
}
