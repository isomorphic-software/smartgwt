
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
 *  "non-native" mode that behaves erratically.  Unfortunately, there is <b>no way we can
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
 * WebDriver (rare: the most common such case is testing file upload - see below), use WebDriver
 * for
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
 *  Smart GWTChromeDriver and Smart GWTIEDriver. There is also a Smart GWTRemoteWebdriver class
 *  which allows the injection of a manually configured RemoteWebDriver instance. This might be
 *  necessary, for example, for use with Selenium Grid.
 *  <li> <b>ScAction</b>: a Smart GWT-specific version of the standard WebDriver
 *  "Action" class, providing a builder pattern to create a sequence of operations which can
 *  then be perform()ed.
 *  </ol>
 *  <P>
 *  These classes are packaged in the library isomorphic_webriver.jar, which can be found
 *  in WEB-INF/lib-WebDriverSupport (along with several 3rd-party supporting libraries).
 *  <P>
 *  General information regarding WebDriver can be found
 * <a href='http://docs.seleniumhq.org/docs/03_webdriver.jsp#introducing-webdriver'
 * onclick="window.open('http://docs.seleniumhq.org/docs/03_webdriver.jsp#introducing-webdriver');return
 * false;">here</a>. Setup for
 *  WebDriver is more complex than for classic Selenium: The basic Java package includes drivers
 * for FireFox (subject to important version limitations as described above), but additional
 * drivers must
 * be downloaded for <a href='http://code.google.com/p/chromium/downloads/list'
 * onclick="window.open('http://code.google.com/p/chromium/downloads/list');return false;">Google
 * Chrome</a> and 
 * <a href='http://code.google.com/p/selenium/downloads/list'
 * onclick="window.open('http://code.google.com/p/selenium/downloads/list');return
 * false;">Internet Explorer</a>.
 *  <P>
 *  <b>File Upload Example Test</b>
 *  <P>
 * As discussed above, one advantage which WebDriver does have over Classic Selenium is the
 * ability
 * to test file upload. It is still limited in that if a click is triggered on the file selection
 * button
 * an OS native file selection dialog will be triggered in which case the test will be suspended
 * until the
 * file is manually selected. To avoid this, the sendKeys() method can be used to enter the file
 * location.
 *  Two examples of this are given below - one for the Smart GWT showcase, and one for SmartGWT:
 *  <p>
 *  <pre>
 *     &#47;**
 * * The following test runs against localhost and requires a small (< 5mb) image to be in
 * /tmp/image.jpg
 *      *&#47;
 *     public void fileUploadSC() throws Exception {
 *         Smart GWTFirefoxDriver driver = new Smart GWTFirefoxDriver();
 *         driver.setBaseUrl("http://localhost:8080/");
 *         driver.get("isomorphic/system/reference/Smart GWT_Explorer.html#upload");
 *         driver.manage().window().maximize();
 * 
 * final int origSize =
 * driver.findElements(ByScLocator.scLocator("//TileGrid[ID=\"mediaTileGrid\"]/tile")).size();
 * 
 * By titleInput =
 * ByScLocator.scLocator("//DynamicForm[ID=\"uploadForm\"]/item[name=title||title=Title||index=0|"
 *                                              +"|Class=TextItem]/element");
 *         driver.click(titleInput);
 *         driver.sendKeys(titleInput, "test image: " + origSize);
 *         
 *         By uploadForm = ByScLocator.scLocator("//DynamicForm[ID=\"uploadForm\"]/");
 *         WebElement form = driver.findElement(uploadForm);
 *         WebElement findElement = form.findElement(By.xpath("//input[@type='FILE']"));
 *         &#47;*
 * * The following causes a native dialog to be created which prevents further progress. Do NOT
 * uncomment!
 *          * We just have to sendKeys() to it
 *          *&#47;
 *         //findElement.click(); 
 *         
 *         findElement.sendKeys("/tmp/image.jpg"); // A local file. Please change accordingly
 * 
 *         By saveButton = ByScLocator.scLocator(
 *        "//DynamicForm[ID=\"uploadForm\"]/item[title=Save||index=2||Class=ButtonItem]/button/");
 *         driver.waitForElementClickable(saveButton);
 *         driver.click(saveButton);
 *         &#47;*
 *          * Note the following fails once the grid contains more than 3 rows of data
 *          * as the index becomes inconsistent as tiles scrolled out of site are removed
 *          * and the indices change
 *          *&#47;                                                        
 * By tile =
 * ByScLocator.scLocator("//TileGrid[ID=\"mediaTileGrid\"]/tile[Class=SimpleTile||index="
 * +(origSize)+"||length="+(origSize+1)+"||classIndex="+(origSize)+"||classLength="+(origSize+1)+"]/");
 *         driver.waitForElementClickable(tile);
 *         WebElement tile1 = driver.findElement(tile);
 *         assertEquals("test image: " + origSize, tile1.getText());
 * assertEquals(origSize + 1,
 * driver.findElements(ByScLocator.scLocator("//TileGrid[ID=\"mediaTileGrid\"]/tile")).size());
 *         driver.close();
 *         driver.quit();
 *     }
 *     
 *     &#47;**
 * * The following test runs against localhost and requires a small (< 5mb) image to be in
 * /tmp/image.jpg
 *      *&#47;
 *     public void fileUploadGWT() throws Exception {
 * final String basePath =
 * "//VLayout[ID=\"isc_Showcase_1_0\"]/member[Class=HLayout||index=0||length=2|"
 *         +"|classIndex=0||classLength=1]/member[Class=HLayout||index=0||length=2||classIndex=0|"
 *         +"|classLength=1]/member[Class=Canvas||index=1||length=2||classIndex=0||classLength=1]"
 *          +"/child[Class=TabSet||index=0||length=1||classIndex=0||classLength=1]/paneContainer/"
 *                       +"member[Class=VLayout||index=1||length=2||classIndex=0||classLength=1]/"
 *                       +"member[Class=VLayout||index=1||length=2||classIndex=0||classLength=1]/"
 *                       +"member[Class=HLayout||index=1||length=2||classIndex=0||classLength=1]/"
 *                      +"member[Class=HLayout||index=0||length=1||classIndex=0||classLength=1]/";
 * final String formPath = basePath +
 * "member[Class=DynamicForm||index=0||length=3||classIndex=0||classLength=1]";
 * final String tilesPath = basePath +
 * "member[Class=VLayout||index=2||length=3||classIndex=0||classLength=1]/"
 *                + "member[Class=TileGrid||index=2||length=4||classIndex=0||classLength=1]/tile";
 *         Smart GWTFirefoxDriver driver = new Smart GWTFirefoxDriver();
 *         driver.setBaseUrl("http://localhost:8888/");
 *         driver.get("index.html#upload_sql");
 *         driver.manage().window().maximize();
 * 
 *         final int origSize = driver.findElements(ByScLocator.scLocator(tilesPath)).size();
 *         By uploadForm = ByScLocator.scLocator(formPath);
 *         WebElement form = driver.findElement(uploadForm);
 *       
 * By titleInput = ByScLocator.scLocator(formPath +
 * "/item[name=title||title=Title||index=0||Class=TextItem]/element");
 *         driver.click(titleInput);
 *         driver.sendKeys(titleInput, "test image: " + origSize);
 *         
 *         WebElement findElement = form.findElement(By.xpath("//input[@type='FILE']"));
 *         &#47;*
 * * The following causes a native dialog to be created which prevents further progress. Do NOT
 * uncomment!
 *          * We just have to sendKeys() to it
 *          *&#47;
 *         //findElement.click(); 
 *         
 *         findElement.sendKeys("/tmp/image.jpg"); // A local file. Please change accordingly
 * 
 * By saveButton = ByScLocator.scLocator(formPath +
 * "/item[title=Save||index=2||Class=ButtonItem]/button/");
 *         driver.waitForElementClickable(saveButton);
 *         driver.click(saveButton);
 *         &#47;*
 * * Note the following fails once the grid contains more than 3 rows of data as the index becomes
 * inconsistent
 *          * as tiles scrolled out of site are removed and the indices change
 *          *&#47;
 * By tile = ByScLocator.scLocator(tilesPath +
 * "[Class=SimpleTile||index="+(origSize)+"||length="+(origSize+1)
 *                               + "||classIndex="+(origSize)+"||classLength="+(origSize+1)+"]/");
 *         driver.waitForElementClickable(tile);
 *         WebElement tile1 = driver.findElement(tile);
 *         assertEquals("test image: " + origSize, tile1.getText());
 *       assertEquals(origSize + 1, driver.findElements(ByScLocator.scLocator(tilesPath)).size());
 *         driver.close();
 *         driver.quit();
 *     }
 *  </pre>
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
