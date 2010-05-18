
package com.smartgwt.client.docs;

/**
 * <h3>Admin Console</h3>
 * The Admin Console allows you to configure database access for DataSources that use&#010 Smart GWT's built-in {@link
 * com.smartgwt.client.docs.SqlDataSource SQL engine}.&#010 <P>&#010 NOTE: You must have the Isomorphic Smart GWT package
 * installed and your servlet engine&#010 started. &#010 <p>&#010 Direct your browser to the following URL to access the
 * Admin Console: &#010 <p>&#010 &nbsp;&nbsp;<a href='http://localhost:8080/tools/adminConsole.jsp'
 * onclick="window.open('http://localhost:8080/tools/adminConsole.jsp');return
 * false;">http://localhost:8080/tools/adminConsole.jsp</a>&#010 <p>&#010 The common default servlet engine port 8080 is
 * used in the URL given above. Adjust your URL&#010 as necessary if you are using a different port and replace localhost
 * with the machine name&#010 running the servlet engine if you are accessing it from a remote machine.&#010 <p>&#010 Note
 * that the Admin Console interface is also available in the Developer Console as the&#010 "DataBases" tab.&#010 <P>&#010
 * <b>Test Data</b>&#010 <p>&#010 You can create a test file that contains a sample dataset which can be imported into
 * your&#010 database table with the Admin Console.&#010 <p>&#010 The test file to use with your DataSource is specified in
 * the <code>testFileName</code>&#010 DataSource configuration property. The test file uses the extension .data.xml.&#010
 * <p>&#010 The test data file should consist of a top-level &lt;List&gt; element containing a series of XML&#010 elements
 * named after your DataSource's ID, each of which creates one DataSource&#010 record. Values for each field are given
 * within tags named after the field name. &#010 <p>&#010 For example, the following XML is from the supplyItem.data.xml
 * test data file supplied with&#010 the Isomorphic Smart GWT package. This file is located in&#010
 * [webroot]/examples/shared/ds/test_data/.&#010 <p>&#010 <pre>&#010 &lt;List&gt;&#010  &lt;supplyItem&gt;&#010     
 * &lt;description&gt;A revolutionary cushion-grip ballpoint pen that reduces &#010          required gripping power,
 * relieving stress and alleviating writing &#010          fatigue. Excellent for people who suffer from arthritis or
 * carpal &#010          tunnel syndrome. Medium point, black ink. Refillable.&lt;/description&gt;&#010     
 * &lt;category&gt;1&lt;/category&gt;&#010      &lt;itemRef&gt;ODC 204-502-153&lt;/itemRef&gt;&#010     
 * &lt;maxQuantity&gt;5&lt;/maxQuantity&gt;&#010      &lt;requiresJustification&gt;0&lt;/requiresJustification&gt;&#010    
 * &lt;itemName&gt;Dr. Grip Pens -- Blue Barrel&lt;/itemName&gt;&#010      &lt;itemID&gt;1&lt;/itemID&gt;&#010     
 * &lt;unitCost&gt;4.99&lt;/unitCost&gt;&#010  &lt;/supplyItem&gt;&#010  &lt;supplyItem&gt;&#010      &lt;description&gt;A
 * revolutionary cushion-grip ballpoint pen that reduces &#010          required gripping power, relieving stress and
 * alleviating writing &#010          fatigue. Excellent for people who suffer from arthritis or carpal &#010         
 * tunnel syndrome. Medium point, black ink. Refillable.&lt;/description&gt;&#010     
 * &lt;category&gt;1&lt;/category&gt;&#010      &lt;itemRef&gt;ODC 204-708-834&lt;/itemRef&gt;&#010     
 * &lt;maxQuantity&gt;5&lt;/maxQuantity&gt;&#010      &lt;requiresJustification&gt;0&lt;/requiresJustification&gt;&#010    
 * &lt;itemName&gt;Dr. Grip Pens -- Black Barrel&lt;/itemName&gt;&#010      &lt;itemID&gt;2&lt;/itemID&gt;&#010     
 * &lt;unitCost&gt;4.99&lt;/unitCost&gt;&#010  &lt;/supplyItem&gt;&#010  &lt;supplyItem&gt;&#010     
 * &lt;description&gt;Personalized business cards for all your networking &#010          needs.&lt;/description&gt;&#010   
 * &lt;category&gt;2&lt;/category&gt;&#010      &lt;itemRef&gt;&lt;/itemRef&gt;&#010     
 * &lt;maxQuantity&gt;500&lt;/maxQuantity&gt;&#010      &lt;requiresJustification&gt;1&lt;/requiresJustification&gt;&#010  
 * &lt;itemName&gt;Personalized business cards -- 500 count&lt;/itemName&gt;&#010      &lt;itemID&gt;3&lt;/itemID&gt;&#010 
 * &lt;unitCost&gt;25.00&lt;/unitCost&gt;&#010  &lt;/supplyItem&gt;&#010  ...&#010 &lt;List/&gt;&#010 </pre>&#010 &#010
 * Data for a tree-like DataSource can be specified with the same format.&#010 The following code example is from the
 * supplyCategory.data.xml test data file. This file&#010 is also located in [webroot]/examples/shares/ds/test_data/.
 * &#010&#010 <pre>&#010 &lt;List&gt;&#010     &lt;supplyCategory&gt;&#010      &lt;itemName&gt;Office Paper
 * Products&lt;/itemName&gt;&#010      &lt;parentID&gt;root&lt;/parentID&gt;&#010     &lt;/supplyCategory&gt;&#010    
 * &lt;supplyCategory&gt;&#010      &lt;itemName&gt;Calculator Rolls&lt;/itemName&gt;&#010      &lt;parentID&gt;Office
 * Paper Products&lt;/parentID&gt;&#010     &lt;/supplyCategory&gt;&#010     &lt;supplyCategory&gt;&#010     
 * &lt;itemName&gt;Adding Machine/calculator Roll&lt;/itemName&gt;&#010      &lt;parentID&gt;Calculator
 * Rolls&lt;/parentID&gt;&#010     &lt;/supplyCategory&gt;&#010     . . .&#010 &lt;/List&gt;&#010 </pre>&#010 &#010 Notice
 * that all records must define values for the itemName primary key field and for the&#010 parentID field that establishes
 * the tree relationship.
 */
public interface AdminConsole {
}
