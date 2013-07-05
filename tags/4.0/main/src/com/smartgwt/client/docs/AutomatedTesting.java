
package com.smartgwt.client.docs;

/**
 * <h3>Automated Testing</h3>
 * Smart GWT supports automated testing with a variety of tools.
 *  <P>
 *  <h3>Selenium</h3>
 *  <P>
 *  Smart GWT includes a free, custom Selenium extension for robust record and playback of tests,
 *  including the ability to record on one browser and play back on others, support for Selenium
 *  Remote Control allowing tests to be written in a variety of programming languages and run as
 *  scripts, as well as Smart GWT-specific enhancements to the Selenium IDE.
 *  <P>
 *  These extensions can be found in the 
 *  
 *  <code>selenium/</code>
 *  directory and a user guide can be found {@link com.smartgwt.client.docs.UsingSelenium here}. 
 *  <P>
 *  Selenium supports writing test code in any programming language via
 * <a href='http://seleniumhq.org/projects/remote-control/'
 * onclick="window.open('http://seleniumhq.org/projects/remote-control/');return false;">Seleniun
 * RC</a>.  By writing
 *  Selenium RC test cases in Java, you can drive them from JUnit, hence creating automated
 *  tests that can be run from the command line or via Continuous Integration servers such as
 *  Hudson, allowing for running tests on checkins to source control or in overnight batch runs.
 *  <P>
 * Services such as <a href='http://saucelabs.com/ondemand'
 * onclick="window.open('http://saucelabs.com/ondemand');return false;">SauceLabs OnDemand</a>
 * allow you
 *  to run the actual browsers in the cloud, tunneling back to a private network via an
 *  encrypted channel, so that you do not need to set up Selenium RC servers with appropriate
 *  browsers installed.
 *  <P>
 *  For apps requiring load testing, also take a look at
 * <a href='http://browsermob.com' onclick="window.open('http://browsermob.com');return
 * false;">BrowserMob</a>, which allows you to run Selenium tests with
 *  thousands of browsers at once against a test deployment.
 *  <P>
 *  <b>JUnit + Selenium RC</b>
 *  <P>
 * Explore {@link com.smartgwt.client.docs.JUnitSeleniumRC JUnit + Selenium RC}, where we walk
 * through a JUnit test built
 *  using Selenium IDE and targeting a Smart GWT Showcase example.
 *  <P>
 *  <h3>SOASTA</h3>
 *  <P>
 *  SOASTA's CloudTest product includes special support for Smart GWT with capabilities
 *  similar to our Selenium extensions, with special emphasis on load testing.  Find out more at
 * <a href='http://soasta.com' onclick="window.open('http://soasta.com');return
 * false;">http://soasta.com</a>.
 *  <P>
 *  
 *  <h3>GwtTestCase</h3>
 *  <P>
 *  GWT includes a way to run a GWT application under JUnit, running your GWT application in a
 *  "headless" browser.  This is a very limited testing approach appropriate for certain unit
 *  tests only - it cannot replace events such as clicks, and it doesn't run in actual browser
 *  (instead it runs in a simulator called HtmlUnit), which can lead to false failures in a
 *  variety of areas, including network communication and XML processing, where HtmlUnit's
 *  behaviors do not correspond to any real browser.
 *  <p>
 *  For these reasons, Isomorphic recommends performing substantially all of your tests via
 *  Selenium, including unit tests.  In particular, if a test fails under HtmlUnit but would not
 *  fail in a real browser, this will not be regarded as a bug.
 *  <P>
 *  If you use GwtTestCase, note that it has a bug where it does not run onModuleLoad() for
 *  included GWT modules.  To make sure SmartGWT's onModuleLoad() runs, add a
 *  <code>gwtSetUp()</code> implementation like so:
 *  <P>
 *  <pre>
 *    public class SgwtTest extends GWTTestCase {
 *       public void gwtSetUp() {
 *        new SmartGwtEntryPoint().onModuleLoad();  
 *       }
 *       ...
 *  </pre>
 *  <P>
 *  You may need to add similar manual calls for other GWT modules you inherit which expect to
 *  have their <code>onModuleLoad()</code> method called normally.
 *  
 *  <P>
 *  <h3>WebDriver / "Selenium 2"</h3>
 *  <P>
 *  WebDriver, which is now part of Selenium 2, uses a different basic architecture in which
 *  extensions are added to each browser in order to drive tests, instead of doing so from
 *  JavaScript.
 *  <P>
 *  Support for WebDriver-based testing for Smart GWT is now available with the same custom
 *  locator strategies and custom commands as we provide for Selenium 1.0.  However, we continue
 *  to recommend Selenium 1.0 rather than WebDriver-based Selenium 2, because:
 *  <P>
 *  <ol>
 *  <li> <b>WebDriver is more complex to install</b>: WebDriver requires installing support for
 *  each browser where you want to run tests, and in some cases multiple WebDriver plugins for
 *  multiple versions of the browser
 *  <li> <b>WebDriver has version / browser support issues</b>: Selenium 1.0 generally works
 *  with any standards-compliant browser.  Because WebDriver requires deeper integration with
 *  the browser, new browser releases require updated WebDriver extensions.  This is a
 *  particular issue with the rapid pace of new releases of Firefox, where the WebDriver
 *  extension becomes disabled by an update of Firefox, but WebDriver test will still run in a
 *  "non-native" mode that behaves erratically.  Unfortuantely, there is <b>no way we can
 *  detect and warn users about this</b>; this is a general issue with WebDriver and
 *  Firefox, not specific to Smart GWT.
 *  <li> <b>Mobile testing issues</b>: Mobile testing is supported only for certain devices,
 *  requires that an application be installed on the devices, doesn't run a normal browser
 *  (rather an embedded browser window inside an application), which can introduce spurious
 *  issues during playback.  In contrast, while Selenium RC doesn't support mobile, with
 *  Selenium 1.0 you can use Selenium Core to test any mobile device that supports JavaScript
 *  without installation of an app.  Both situations have drawbacks but we feel that Selenium
 *  1.0 has an overall advantage over WebDriver here.
 *  <li> <b>Java skills required</b>: Tests created in Selenium IDE and stored in Selenese can
 *  be executed by a variety of tools without requiring Java skills, including our own
 * {@link com.smartgwt.client.docs.TestRunner}.  Most ways of running WebDriver tests involve Java
 * coding
 *  skills or at least the ability to work with a Java IDE.  This tends to mean that all QA
 *  personnel must either have Java skills or drain the time of Java developers on repetitive
 *  tasks.
 *  </ol>
 *  <P>
 *  Ultimately, our current recommendation is to use Selenium 1.0 and Selenium RC exclusively or
 *  at least primarily.  If there are critically important tests that you can only build via
 *  WebDriver (rare: the most common such case is testing file upload), use WebDriver for
 *  those tests only, or use manual testing for those tests.
 *  <P>
 *  <b>WebDriver Usage</b>
 *  <P>
 *  When using WebDriver, we recommend using Selenum IDE to record tests, and storing tests in
 *  Selenese (as with Selenium RC / 1.0).  WebDriver is not normally able to execute Selenese
 *  tests, but we provide a Java class <code>SeleneseRunner</code> that can be used to:
 *  <ul>
 *  <li> execute Selenese directly from the command line
 *  <li> execute Selenese from inside a Java program (eg, as part of a JUnit test)
 *  <li> convert a Selenese test to Java code (as a JUnit test)
 *  </ul>
 *  See the server-side JavaDoc for com.isomorphic.webdriver.SeleneseRunner for more information
 *  on how to use these features.
 *  <p>
 *  <b>NOTE:</b> Selenium IDE has an option to export tests as WebDriver-compatible code.  <b>Do
 *  not use</b> this feature, it exports useless code that doesn't understand custom commands,
 *  custom locators, or other key features of Selenium IDE.  Use SeleneseRunner instead.
 *  <p>
 *  <b>WebDriver Classes overview</b>
 *  <p>
 *  Storing and executing Selenese tests recorded in the Selenium IDE is recommended as the
 *  primary approach for using WebDriver.  However, for certain rare tests it can make sense to
 *  use WebDriver Java support directly.
 *  <p>
 *  Smart GWT support for WebDriver is based around 3 different Java classes:
 *  <P>
 *  <ol>
 *  <li> <b>ByScLocator</b>: This implements the ability to find WebElements or WebDriver "By"
 * objects using Smart GWT Locator strings.  See {@link com.smartgwt.client.docs.UsingSelenium}
 * for more
 * background on Locator strings and how to obtain them.  Given a locator String, example usage
 * is:
 *  <pre>
 * ByScLocator.scLocator("//ListGrid[ID=\"countryList\"]/body/row[countryCode=US||0]/col[fieldName=countryCode||0]")
 *  </pre>
 *  <li> <b>Smart GWTWebDriver</b>: This is an abstract class which provides a number of
 *  different methods for interacting with the browser, such as:
 *  <ul>
 *  <li> open a browser at a particular URL
 *  <li> find the element or elements which match a given "By" object (either ByScLocator, or a
 *       standard WebDriver locator)
 *  <li> perform events and operations (click, drag, select etc)
 *  <li> perform custom Smart GWT validations / state checks, such as whether a grid has
 *       loaded data
 *  </ul>
 *  Three concrete implementations of Smart GWTWebDriver are provided: Smart GWTFireFoxDriver,
 *  Smart GWTChromeDriver and Smart GWTIEDriver. 
 *  <li> <b>ScAction</b>: a Smart GWT-specific version of the standard WebDriver
 *  "Action" class, providing a builder pattern to create a sequence of operations which can
 *  then be perform()ed.
 *  </ol>
 *  <P>
 *  These classes are packaged in the library isomorphic_webriver.jar, which can be found
 *  in WEB-INF/lib-WebDriverSupport (along with several 3rd-party supporting libraries).
 *  <P>
 *  General information regarding WebDriver can be found
 * +ExternalLink{http://docs.seleniumhq.org/docs/03_webdriver.jsp#introducing-webdriver, here}.
 * Setup for
 *  WebDriver is more complex than for classic Selenium: The basic Java package includes drivers
 * for FireFox (subject to important version limitations as described above), but additional
 * drivers must
 * be downloaded for +ExternalLink{http://code.google.com/p/chromium/downloads/list, Google
 * Chrome} and 
 *  +ExternalLink{http://code.google.com/p/selenium/downloads/list, Internet Explorer}.
 *  <P>
 *  <b>Other tools</b>
 *  <P>
 *  Smart GWT supports a special JavaScript API to allow other test tools to integrate in the
 * same manner as Selenium, WebDriver and SOASTA.  This API allows the test tool to record an
 * abstract
 *  "locator" string representing the logical name for an interactive DOM element, and then
 *  during test playback, retrieve a DOM element given a locator.
 *  <P>
 *  This is critical because, like many modern Ajax systems, Smart GWT generates different DOM
 *  elements in different browsers, in different skins, and in different versions of Smart GWT.  
 *  Testing tools that try to directly record the generated Smart GWT DOM produce extremely
 *  brittle tests because they are effectively recording undocumented internals.
 *  <P>
 *  Using the "locator" API allows you to record or write tests that will run in any browser
 *  supported by Smart GWT, in any version of Smart GWT, and in any skin.  It also makes
 *  tests more readable and easier to understand and maintain.
 *  <P>
 *  Different testing tools vary in how easily they can be configured to use the locator API,
 *  and in some older tools it can be a large effort.  We highly recommend using our Selenium
 *  extensions - it often makes sense to use them even if you have to use them in parallel with
 *  another, older testing tool.  If you are forced to use another tool exclusively:
 *  <ul>
 *  
 *  
 *  <li> Refer to the &#83;martClient documentation for the AutoTest class (because it's a
 *  JavaScript API).  It can be found
 * <a href='http://www.smartclient.com/product/documentation.jsp'
 * onclick="window.open('http://www.smartclient.com/product/documentation.jsp');return
 * false;">here</a>
 *  
 *  <li> Read over the source code of our Selenium extensions to get a clear understanding of
 *  how the Selenium integration works, because this will be analogous to the work you'll need
 *  to do
 * <li> Search the <a href='http://forums.smartclient.com/'
 * onclick="window.open('http://forums.smartclient.com/');return false;">forums</a> for other
 * developers
 *  who are trying to use the same test tool with Smart GWT, and share efforts
 *  </ul>
 */
public interface AutomatedTesting {
}
