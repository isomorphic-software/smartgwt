	    
package com.smartgwt.client.docs;

/**
 * <h3>Automated Testing</h3>
 * Smart GWT supports automated testing with a variety of tools.
 *  <P>
 *  <b>Selenium</b>
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
 * through a JUnit test built using Selenium IDE 
 *  and targeting a Smart GWT Showcase example.
 *  <P>
 *  <b>SOASTA</b>
 *  <P>
 *  SOASTA's CloudTest product includes special support for Smart GWT with capabilities
 *  similar to our Selenium extensions, with special emphasis on load testing.  Find out more at
 * <a href='http://soasta.com' onclick="window.open('http://soasta.com');return
 * false;">http://soasta.com</a>.
 *  <P>
 *  
 *  <b>GwtTestCase</b>
 *  <P>
 *  GWT includes a way to run a GWT application under JUnit, running your GWT application in a
 *  "headless" browser.  This is a very limited testing approach appropriate for certain unit
 *  tests only - it cannot replace events such as clicks, and it doesn't run in actual browser
 *  (instead it runs in a simulator called HtmlUnit), which can lead to false failures in a
 *  variety of areas, including network communication and XML processing, where HtmlUnit's
 *  behaviors do not correspond to any real browser.  For these reasons, Isomorphic recommends
 *  that the majority of your testing focus on Selenium.
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
 *  <b>WebDriver / "Selenium 2"</b>
 *  <P>
 *  WebDriver, which is now part of Selenium 2, uses a different basic architecture in which
 *  extensions are added to each browser in order to drive tests, instead of doing so from
 *  JavaScript.
 *  <P>
 *  Support for WebDriver-based testing for Smart GWT is currently under development, with the
 *  intent to provide the same custom locator strategies and custom commands as we provide for
 *  Selenium 1.0.  However, even once such support exists we will continue to recommend Selenium
 *  1.0 rather than WebDriver-based Selenium 2, because:
 *  <P>
 *  <ol>
 *  <li> <b>Selenese/HTML scripts not supported</b>: WebDriver does not directly support
 *  execution of Selenese (HTML script files)
 *  <li> <b>Java skills required to write/record tests</b>: lack of support for Selenese means 
 *  a Java developer and Java environment is required to develop WebDriver tests.  We consider
 *  this very bad, as the ideal setup is that QA personnel with limited skills can drop Selenese
 *  test files onto a test server and have them automatically run - this requires no Java skills
 *  <li> <b>Selenium IDE recording made useless</b>: Selenium IDE's export to WebDriver code
 *  requires large manual effort to produce working scripts.  As things stand, it actually takes
 *  less effort to hand-write Java code, using Selenium IDE to capture locators only
 *  <li> <b>WebDriver is more complex to install</b>: need to install WebDriver support for each
 *  browser, and in some cases multiple WebDriver plugins for multiple versions of the browser
 *  <li> <b>WebDriver supports less browsers</b>: Although major browser bugs can sometimes
 *  break it, Selenium RC generally works with any browser that has JavaScript
 *  <li> <b>Mobile testing issues</b>: Mobile testing requires that an application be installed
 *  on the devices, doesn't run a normal browser (rather an embedded browser window inside an
 *  application), and supports only limited devices.  In contrast, while Selenium RC doesn't
 *  support mobile, with Selenium 1.0 you can use Selenium Core to test any mobile device that
 *  supports JavaScript without installation of an app.  Both situations have drawbacks but we
 *  feel class Selenium 1.0 has an overall advantage over WebDriver here.
 *  </ol>
 *  <P>
 *  Overall, WebDriver does not yet provide a solution that can be used in place of classic
 *  Selenium - at most WebDriver <i>could</i> be used by Java developers who plan to write tests
 *  in pure Java anyway.  
 *  <P>
 *  However, if Selenese and Selenium IDE recording are also used, this implies two parallel
 *  sets of tests executed by different engines, and this complexity may not be worthwhile.
 *  This is especially true since part of the value of WebDriver is a simplified Java API, but
 *  the extensive custom commands provided by Smart GWT mean that Selenium RC tests written in
 *  Java are far shorter and simpler anyway.
 *  <P>
 *  Ultimately, our current recommendation is to use Selenium 1.0 and Selenium RC only unless
 *  there are critically important tests that you can only build via WebDriver - this is rare
 *  and the most common such case is testing file upload.  For these cases, use WebDriver for
 *  those tests only or use manual testing. 
 *  <P>
 *  <b>Other tools</b>
 *  <P>
 *  Smart GWT supports a special JavaScript API to allow other test tools to integrate in the
 *  same manner as Selenium and SOASTA.  This API allows the test tool to record an abstract
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
