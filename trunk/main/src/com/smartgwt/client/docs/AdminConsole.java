
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
 * with the machine name&#010 running the servlet engine if you are accessing it from a remote machine.&#010 <P>&#010
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
 * the tree relationship.&#010 <P>&#010 <br>&#010 <b>Manually specifying database connection settings</b>&#010 <p>&#010 The
 * Admin Console maintains settings in the <code>server.properties</code> file, found in &#010 your application's
 * <code>WEB-INF/classes</code> directory.  If you prefer, you can maintain&#010 these settings by directly editing that
 * file.  You should restart your servlet engine &#010 after changing this file.&#010 <p>&#010 For example, the following
 * settings are the defaults in a new Smart GWT installation for &#010 a MySQL server; they are approximately correct for a
 * MySQL server running on the same &#010 machine as the servlet engine and listening on the default MySQL port.  For
 * details of what&#010 each of these properties means, check {@link com.smartgwt.client.docs.SqlSettings this
 * page}.<pre>&#010   sql.Mysql.database.type: mysql&#010   sql.Mysql.database.ansiMode: false&#010  
 * sql.Mysql.interface.type: dataSource&#010   sql.Mysql.driver: com.mysql.jdbc.jdbc2.optional.MysqlDataSource&#010   #
 * name of the database to use&#010   sql.Mysql.driver.databaseName: isomorphic&#010   # hostname and port where the
 * database server is installed&#010   sql.Mysql.driver.serverName: localhost&#010   sql.Mysql.driver.portNumber: 3306&#010
 * # username and password that can create and modify tables in that database&#010   # this user must have the following
 * privileges for the system to function&#010   # properly: create/alter/drop table; insert/update/replace/delete
 * rows.&#010   sql.Mysql.driver.user: root&#010   sql.Mysql.driver.password: &#010 </pre>&#010 Note the distinction here
 * between database <em>type</em> and database <em>name</em>.  Database&#010 type refers to the actual product - Oracle,
 * DB2 or whatever.  In the above example, database &#010 type is "mysql" (all lowercase) - the value of property
 * <code>sql.Mysql.database.type</code>.&#010 Database type is very important.  The type of a given database connection
 * dictates whether&#010 features like SQL paging and transactions are supported; it even dictates the syntax of the &#010
 * SQL we generate.&#010 <p>&#010 Database name is just an arbitrary name for a particular database connection, and it
 * is&#010 embedded in the property names immediately after the <code>sql</code> prefix. In this example&#010 it happens to
 * be very similar to the database type - "Mysql" as opposed to "mysql" - but in &#010 fact the name has no significance
 * and could be any string.  When referring to specific &#010 database connections in your {@link
 * com.smartgwt.client.data.DataSource DataSources} with the &#010 {@link
 * com.smartgwt.client.docs.serverds.DataSource#dbName dbName} property, it is the database <em>name</em> you use.&#010
 * <p>&#010 NOTE: It is common for DataSources to not specify <code>dbName</code>.  In this case, the &#010 default
 * database is used.  To specify the default database manually in &#010 <code>server.properties</code>, set
 * <code>sql.defaultDatabase</code>, using database &#010 name.  So, to set our example connection from above as the
 * default:<pre>&#010   sql.defaultDatabase: Mysql&#010 </pre>&#010 <P>&#010 <b>Manually specifying JNDI settings</b>&#010
 * <p>&#010 Instead of specifying database connection parameters directly in <code>server.properties</code>,&#010 it is
 * possible to connect to a database that is configured as a JNDI resource in your &#010 application server.  Assume you
 * have an Oracle JNDI resource with the name "jndiTest", &#010 configured similar to this in Tomcat:&#010 <pre>&#010  
 * &lt;Resource name="jdbc/jndiTest"&#010                    auth="Container"&#010                   
 * type="javax.sql.DataSource"&#010                    driverClassName="oracle.jdbc.driver.OracleDriver"&#010              
 * url="jdbc:oracle:thin:@192.168.132.152:1521:xe"&#010                    username="system"&#010                   
 * password="manager"&#010                    initialSize="5"                 &#010                    maxActive="50"
 * /&gt;&#010 </pre>&#010 The minimal set of properties required to create a Smart GWT database connection that &#010
 * attaches to this resource is as follows (Note that the <code>java:comp/env/</code> prelude&#010 in the first line is
 * optional - the server will automatically look there if it can't find &#010 the resource in the absolute location)&#010
 * <pre>&#010   sql.myOracleConnection.driver.name: java:comp/env/jdbc/jndiTest&#010  
 * sql.myOracleConnection.database.type: oracle&#010   sql.myOracleConnection.interface.type: jndi&#010 </pre>
 */
public interface AdminConsole {
}
