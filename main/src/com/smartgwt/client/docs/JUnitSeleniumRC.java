
package com.smartgwt.client.docs;

/**
 * <h3>JUnit + Selenium RC</h3>
 * <div style="width:600px">
 * 
 *  Let's take a look at some JUnit code designed to test a standalone version of the
 *  
 *  
 * <a href='http://localhost:8080/index.html#tree_editing' target='_blank'>Smart GWT Showcase:
 * Trees &gt;&gt; Editing</a> 
 *  
 * example.  The overall test class, TreeTest, contains a test, testTree1, targeted at the
 * TreeGrid in the
 * example, and a test, testTree2, targeted at the SearchForm/ListGrid.  As recommended by the
 * official 
 * <a href='http://seleniumhq.org/docs/08_user_extensions.html' target='_blank'>Selenium
 * documentation</a>,  we create 
 * the <code>HttpCommandProcessor</code> separately from <code>DefaultSelenium</code> to provide a
 * way to
 * invoke the new user extension command <code>waitForElementClickable()</code> which Smart GWT
 * defines.
 *  (See our Selenium User Guide described in {@link com.smartgwt.client.docs.AutomatedTesting}.)
 *  <P>
 * The test class TreeTest was initially generated by exporting the Selenium script for testTree1
 * in JUnit 4 
 * format, but it was modified by hand as mentioned above to support the
 * <code>waitForElementClickable()</code>.
 * 
 * Below we look at the two test cases testTree1 and testTree2.  Note that in each case, we
 * maximize
 *  the Selenium browser window in accordance with the best practices mentioned in the User Guide.
 *  <P>
 * If you'd like to experiment with making changes to the sample JUnit code, one improvement that
 * simplifies
 * things is to add a myClick() function that handles both the
 * <code>waitForElementClickable()</code> and
 * the <code>click</code> on a supplied locator.  Even just assigning each unique locator to a
 * local Java 
 * variable so it can be reused for multiple calls will make the code simpler to follow and
 * maintain.
 * 
 *  <pre>
 *  import com.thoughtworks.selenium.*;
 *  import org.junit.After;
 *  import org.junit.Before;
 *  import org.junit.Test;
 *  import java.util.regex.Pattern;
 * 
 *  public class TreeTest extends SeleneseTestCase {
 *   
 *      HttpCommandProcessor proc;
 *   
 *      void waitForElementClickable(String locator) {
 *          String[] locatorArg = {locator};
 *          proc.doCommand("waitForElementClickable", locatorArg);   
 *      }
 *   
 *      &#64;Before
 *      public void setUp() throws Exception {
 *          proc = new HttpCommandProcessor("localhost", 4444, "*chrome",
 *              "http://localhost:8080/"); 
 *          selenium = new DefaultSelenium(proc);
 *          selenium.start();
 *      }
 * 
 *      &#64;Test
 *      public void testTree1() throws Exception {
 *          selenium.open("treeEdit.html");
 *          selenium.windowMaximize();
 * 
 *          waitForElementClickable("scLocator=//TreeGrid[ID=\"employeeTree\"]/body/row[EmployeeId=4||Name=Charles%20Madigen||0]/col[fieldName=Name||0]/open");
 *          selenium.click("scLocator=//TreeGrid[ID=\"employeeTree\"]/body/row[EmployeeId=4||Name=Charles%20Madigen||0]/col[fieldName=Name||0]/open");
 *          waitForElementClickable("scLocator=//TreeGrid[ID=\"employeeTree\"]/body/row[EmployeeId=189||Name=Gene%20Porter||8]/col[fieldName=Name||0]/open");
 *          selenium.click("scLocator=//TreeGrid[ID=\"employeeTree\"]/body/row[EmployeeId=189||Name=Gene%20Porter||8]/col[fieldName=Name||0]/open");
 *          waitForElementClickable("scLocator=//TreeGrid[ID=\"employeeTree\"]/body/row[EmployeeId=264||Name=Cheryl%20Pearson||Salary=5650||10]/col[fieldName=Salary||2]");
 *          verifyEquals("5650", selenium.getText("scLocator=//TreeGrid[ID=\"employeeTree\"]/body/row[EmployeeId=264||Name=Cheryl%20Pearson||Salary=5650||10]/col[fieldName=Salary||2]"));
 * 
 *          checkForVerificationErrors();
 *      }
 *  </pre>
 * 
 *  In test testTree1, the idea is to:
 *  <ul>
 *      <li> Open the node for the top level employee, Charles Madigen,
 *      <li> Open the node for his report, Gene Porter, and
 *      <li> Verify that the Salary of Cheryl Pearson, who reports to Gene, is 5650
 *  </ul>
 *  For this test, the locators were generated by Selenium IDE for us but we did modify the code
 *  to make use of the function <code>waitForElementClickable()</code>.
 *  <P>
 *   Note that though the locator for Cheryl includes the salary, it will match based on the first
 *  field, EmployeeId, which is the primary key, so the test will correctly compare the contents 
 *  of Cheryl's salary against the value 5650 and fail if it doesn't match.  If for some reason 
 *  your test requires matching a specific field rather than the default fields and ordering
 *  generated automatically, you can hand edit the locator.
 * 
 *  <pre>
 *  
 *      public void testTree2() throws Exception {
 *          selenium.open("treeEdit.html");
 *          selenium.windowMaximize();
 * 
 *          // Steps 1-3: Load the ListGrid with Joan's Reports
 *          waitForElementClickable("scLocator=//SearchForm[ID="employeeSearchForm"]/item[index=0||Class=PickTreeItem]/button/");
 *          selenium.click("scLocator=//SearchForm[ID="employeeSearchForm"]/item[index=0||Class=PickTreeItem]/button/");
 * 
 *          waitForElementClickable("scLocator=//autoID[Class=SelectionTreeMenu||index=8||length=14||classIndex=0||classLength=2||roleIndex=0||roleLength=2||scRole=menu]/body/row[Name=Charles%20Madigen]/col[fieldName=title||0]");
 *          selenium.mouseMove("scLocator=//autoID[Class=SelectionTreeMenu||index=8||length=14||classIndex=0||classLength=2||roleIndex=0||roleLength=2||scRole=menu]/body/row[Name=Charles%20Madigen]/col[fieldName=title||0]");
 * 
 *          waitForElementClickable("scLocator=//SelectionTreeMenu[ID=\"isc_SelectionTreeMenu_0_childrenSubMenu_0\"]/body/row[EmployeeId=183]/col[fieldName=title||1]");
 *          selenium.click("scLocator=//SelectionTreeMenu[ID=\"isc_SelectionTreeMenu_0_childrenSubMenu_0\"]/body/row[EmployeeId=183]/col[fieldName=title||1]");
 *  
 *          // Step 4: Sort by salary, descending, and wait for ListGrid to be redrawn with final result
 *          waitForElementClickable("scLocator=//ListGrid[ID=\"employeeGrid\"]/header/headerButton[fieldName=Salary]/");
 *          selenium.click("scLocator=//ListGrid[ID=\"employeeGrid\"]/header/headerButton[fieldName=Salary]/");
 *          waitForElementClickable("scLocator=//ListGrid[ID=\"employeeGrid\"]/header/headerButton[fieldName=Salary]/");
 *          selenium.click("scLocator=//ListGrid[ID=\"employeeGrid\"]/header/headerButton[fieldName=Salary]/");
 * 
 *          selenium.waitForGridDone("scLocator=//ListGrid[ID='employeeGrid']");
 * 
 *          // Step 5: Verify the top salary
 *          waitForElementClickable("scLocator=//ListGrid[ID=\"employeeGrid\"]/body/row[0]/col[fieldName=Salary||2]");
 *          verifyEquals("9400", selenium.getText("scLocator=//ListGrid[ID=\"employeeGrid\"]/body/row[0]/col[fieldName=Salary||2]"));
 * 
 *          checkForVerificationErrors();
 *      }
 *  </pre>
 * 
 *  In test testTree2, the idea is to:
 *  <P>
 *  1. Click on the SearchForm button, revealing a Charles Madigen popup,<BR>
 *  2. Issue a MouseMove on the Charles Madigen popup, revealing a list of his reports,<BR>
 *  3. Click on his report Joan Little, filling the ListGrid with her reports,<BR>
 *  4. Click on the salary column header twice, sorting by descending salary, and<BR>
 *  5. Verify the salary in the top row (top salary) is 9400<BR>
 *  <P>
 * This test required more hand modification than the previous one.  In particular three
 * modifications were made:
 *  <ul>
 *     <li> A mouseMove command was manually added to the Selenium IDE script,
 * <li> A call to <code>waitForGridDone()</code> was added to assure the sorting was done before
 * we ran verifyText, and
 * <li> We manually removed all but row qualifier from the automatically generated scLocator for
 * step &#35;5.
 *  </ul>
 *  
 *  The first modification is required because our user extensions don't record mouseMove
 *  events, and the second is needed to ensure the sorts are complete before verifyText runs--for
 * details see the User Guide (described in {@link com.smartgwt.client.docs.AutomatedTesting}). 
 * The final modification is
 *  just a reflection of what our intent is in step &#35;5; we want to operate on the top row,
 *  regardless of its contents, so we don't want our locator matching based on the EmployeeId or
 *  Name fields of the records.  (Matching by EmployeeId in the locator as automatically
 * generated would make the test verify that Kelly Fetterman's salary is 9400 rather than that
 * 9400 
 *  is the highest salary.)
 *  
 *  <pre>
 *      &#64;After
 *      public void tearDown() throws Exception {
 *          selenium.stop();
 *      }
 *  }
 *  </pre>
 *  </div>
 */
public interface JUnitSeleniumRC {
}
