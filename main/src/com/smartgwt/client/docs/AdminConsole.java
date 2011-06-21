
package com.smartgwt.client.docs;

/**
 * <h3>Admin Console</h3>
 * The Admin Console allows you to configure database access for DataSources that use
 *  Smart GWT's built-in {@link com.smartgwt.client.docs.SqlDataSource SQL engine}.
 *  <P>
 *  NOTE: You must have the Isomorphic Smart GWT package installed and your servlet engine
 *  started. 
 *  <p>
 *  Direct your browser to the following URL to access the Admin Console: 
 *  <p>
 * &nbsp;&nbsp;<a href='http://localhost:8080/tools/adminConsole.jsp'
 * onclick="window.open('http://localhost:8080/tools/adminConsole.jsp');return
 * false;">http://localhost:8080/tools/adminConsole.jsp</a>
 *  <p>
 *  The common default servlet engine port 8080 is used in the URL given above. Adjust your URL
 *  as necessary if you are using a different port and replace localhost with the machine name
 *  running the servlet engine if you are accessing it from a remote machine.
 *  <P>
 *  <b>Test Data</b>
 *  <p>
 *  You can create a test file that contains a sample dataset which can be imported into your
 *  database table with the Admin Console.
 *  <p>
 *  The test file to use with your DataSource is specified in the <code>testFileName</code>
 *  DataSource configuration property. The test file uses the extension .data.xml.
 *  <p>
 *  The test data file should consist of a top-level &lt;List&gt; element containing a series of XML
 *  elements named after your DataSource's ID, each of which creates one DataSource
 *  record. Values for each field are given within tags named after the field name. 
 *  <p>
 *  For example, the following XML is from the supplyItem.data.xml test data file supplied with
 *  the Isomorphic Smart GWT package. This file is located in
 *  [webroot]/examples/shared/ds/test_data/.
 *  <p>
 *  <pre>
 *  &lt;List&gt;
 *   &lt;supplyItem&gt;
 *       &lt;description&gt;A revolutionary cushion-grip ballpoint pen that reduces 
 *           required gripping power, relieving stress and alleviating writing 
 *           fatigue. Excellent for people who suffer from arthritis or carpal 
 *           tunnel syndrome. Medium point, black ink. Refillable.&lt;/description&gt;
 *       &lt;category&gt;1&lt;/category&gt;
 *       &lt;itemRef&gt;ODC 204-502-153&lt;/itemRef&gt;
 *       &lt;maxQuantity&gt;5&lt;/maxQuantity&gt;
 *       &lt;requiresJustification&gt;0&lt;/requiresJustification&gt;
 *       &lt;itemName&gt;Dr. Grip Pens -- Blue Barrel&lt;/itemName&gt;
 *       &lt;itemID&gt;1&lt;/itemID&gt;
 *       &lt;unitCost&gt;4.99&lt;/unitCost&gt;
 *   &lt;/supplyItem&gt;
 *   &lt;supplyItem&gt;
 *       &lt;description&gt;A revolutionary cushion-grip ballpoint pen that reduces 
 *           required gripping power, relieving stress and alleviating writing 
 *           fatigue. Excellent for people who suffer from arthritis or carpal 
 *           tunnel syndrome. Medium point, black ink. Refillable.&lt;/description&gt;
 *       &lt;category&gt;1&lt;/category&gt;
 *       &lt;itemRef&gt;ODC 204-708-834&lt;/itemRef&gt;
 *       &lt;maxQuantity&gt;5&lt;/maxQuantity&gt;
 *       &lt;requiresJustification&gt;0&lt;/requiresJustification&gt;
 *       &lt;itemName&gt;Dr. Grip Pens -- Black Barrel&lt;/itemName&gt;
 *       &lt;itemID&gt;2&lt;/itemID&gt;
 *       &lt;unitCost&gt;4.99&lt;/unitCost&gt;
 *   &lt;/supplyItem&gt;
 *   &lt;supplyItem&gt;
 *       &lt;description&gt;Personalized business cards for all your networking 
 *           needs.&lt;/description&gt;
 *       &lt;category&gt;2&lt;/category&gt;
 *       &lt;itemRef&gt;&lt;/itemRef&gt;
 *       &lt;maxQuantity&gt;500&lt;/maxQuantity&gt;
 *       &lt;requiresJustification&gt;1&lt;/requiresJustification&gt;
 *       &lt;itemName&gt;Personalized business cards -- 500 count&lt;/itemName&gt;
 *       &lt;itemID&gt;3&lt;/itemID&gt;
 *       &lt;unitCost&gt;25.00&lt;/unitCost&gt;
 *   &lt;/supplyItem&gt;
 *   ...
 *  &lt;List/&gt;
 *  </pre>
 *  
 *  Data for a tree-like DataSource can be specified with the same format.
 *  The following code example is from the supplyCategory.data.xml test data file. This file
 *  is also located in [webroot]/examples/shares/ds/test_data/. 
 * 
 *  <pre>
 *  &lt;List&gt;
 *      &lt;supplyCategory&gt;
 *       &lt;itemName&gt;Office Paper Products&lt;/itemName&gt;
 *       &lt;parentID&gt;root&lt;/parentID&gt;
 *      &lt;/supplyCategory&gt;
 *      &lt;supplyCategory&gt;
 *       &lt;itemName&gt;Calculator Rolls&lt;/itemName&gt;
 *       &lt;parentID&gt;Office Paper Products&lt;/parentID&gt;
 *      &lt;/supplyCategory&gt;
 *      &lt;supplyCategory&gt;
 *       &lt;itemName&gt;Adding Machine/calculator Roll&lt;/itemName&gt;
 *       &lt;parentID&gt;Calculator Rolls&lt;/parentID&gt;
 *      &lt;/supplyCategory&gt;
 *      . . .
 *  &lt;/List&gt;
 *  </pre>
 *  
 *  Notice that all records must define values for the itemName primary key field and for the
 *  parentID field that establishes the tree relationship.
 *  <P>
 *  <br>
 *  <b>Manually specifying database connection settings</b>
 *  <p>
 *  The Admin Console maintains settings in the <code>server.properties</code> file, found in 
 *  your application's <code>WEB-INF/classes</code> directory.  If you prefer, you can maintain
 *  these settings by directly editing that file.  You should restart your servlet engine 
 *  after changing this file.
 *  <p>
 *  For example, the following settings are the defaults in a new Smart GWT installation for 
 *  a MySQL server; they are approximately correct for a MySQL server running on the same 
 *  machine as the servlet engine and listening on the default MySQL port.  For details of what
 *  each of these properties means, check {@link com.smartgwt.client.docs.SqlSettings this page}.<pre>
 *    sql.Mysql.database.type: mysql
 *    sql.Mysql.database.ansiMode: false
 *    sql.Mysql.interface.type: dataSource
 *    sql.Mysql.driver: com.mysql.jdbc.jdbc2.optional.MysqlDataSource
 *    # name of the database to use
 *    sql.Mysql.driver.databaseName: isomorphic
 *    # hostname and port where the database server is installed
 *    sql.Mysql.driver.serverName: localhost
 *    sql.Mysql.driver.portNumber: 3306
 *    # username and password that can create and modify tables in that database
 *    # this user must have the following privileges for the system to function
 *    # properly: create/alter/drop table; insert/update/replace/delete rows.
 *    sql.Mysql.driver.user: root
 *    sql.Mysql.driver.password: 
 *  </pre>
 *  Note the distinction here between database <em>type</em> and database <em>name</em>.  Database
 *  type refers to the actual product - Oracle, DB2 or whatever.  In the above example, database 
 *  type is "mysql" (all lowercase) - the value of property <code>sql.Mysql.database.type</code>.
 *  Database type is very important.  The type of a given database connection dictates whether
 *  features like SQL paging and transactions are supported; it even dictates the syntax of the 
 *  SQL we generate.
 *  <p>
 *  Database name is just an arbitrary name for a particular database connection, and it is
 *  embedded in the property names immediately after the <code>sql</code> prefix. In this example
 *  it happens to be very similar to the database type - "Mysql" as opposed to "mysql" - but in 
 *  fact the name has no significance and could be any string.  When referring to specific 
 *  database connections in your {@link com.smartgwt.client.data.DataSource DataSources} with the 
 *  {@link com.smartgwt.client.docs.serverds.DataSource#dbName dbName} property, it is the database <em>name</em> you use.
 *  <p>
 *  NOTE: It is common for DataSources to not specify <code>dbName</code>.  In this case, the 
 *  default database is used.  To specify the default database manually in 
 *  <code>server.properties</code>, set <code>sql.defaultDatabase</code>, using database 
 *  name.  So, to set our example connection from above as the default:<pre>
 *    sql.defaultDatabase: Mysql
 *  </pre>
 *  <P>
 *  <b>Manually specifying JNDI settings</b>
 *  <p>
 *  Instead of specifying database connection parameters directly in <code>server.properties</code>,
 *  it is possible to connect to a database that is configured as a JNDI resource in your 
 *  application server.  Assume you have an Oracle JNDI resource with the name "jndiTest", 
 *  configured similar to this in Tomcat:
 *  <pre>
 *    &lt;Resource name="jdbc/jndiTest"
 *                     auth="Container"
 *                     type="javax.sql.DataSource"
 *                     driverClassName="oracle.jdbc.driver.OracleDriver"
 *                     url="jdbc:oracle:thin:@192.168.132.152:1521:xe"
 *                     username="system"
 *                     password="manager"
 *                     initialSize="5"                 
 *                     maxActive="50" /&gt;
 *  </pre>
 *  The minimal set of properties required to create a Smart GWT database connection that 
 *  attaches to this resource is as follows (Note that the <code>java:comp/env/</code> prelude
 *  in the first line is optional - the server will automatically look there if it can't find 
 *  the resource in the absolute location)
 *  <pre>
 *    sql.myOracleConnection.driver.name: java:comp/env/jdbc/jndiTest
 *    sql.myOracleConnection.database.type: oracle
 *    sql.myOracleConnection.interface.type: jndi
 *  </pre>
 */
public interface AdminConsole {
}
