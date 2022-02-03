
package com.smartgwt.client.docs;

/**
 * <h3>Reify for Developers</h3>
 * <b>What is Reify</b>
 *  <p>
 *  Reify is a cloud-based visual application builder in which users can build screens via 
 *  drag-and-drop, create DataSources from sample data or using wizards, and visually define 
 *  standard event handlers and multi-step workflows.
 *  <p>
 *  You can export a Reify project and continue development in an IDE, because an application 
 *  built with Reify simply consists of standard Component XML screen definitions, DataSource 
 *  definitions, and XML event handler and workflow declarations.
 *  <p>
 *  In fact, everything that Reify produces is standard, declarative usage of Smart GWT, 
 *  so if you are unfamiliar with a property that a Reify project uses, you can simply look it up 
 * in the documentation. We've also put a great deal of effort into ensuring that the XML
 * declarations 
 * produced by Reify are concise and self-explanatory. Also, Reify never generates methods or
 * other 
 * programmatic code, because there's no way generated programmatic code can ever be clean or
 * clear. 
 *  By keeping everything declarative, we ensure that everything Reify generates will be easy to 
 *  understand and extend.
 *  <P>
 * Because it's always possible to export your Reify projects and keep going in an IDE
 * environment, 
 * you can start any kind of project with Reify - you don't have to limit your use of Reify to
 * only 
 *  projects that can be built completely in a visual tool.
 *  <P>
 *  <b>Reify Projects</b>
 *  <P>
 *  An exported Reify project consists of:
 *  <P>
 *  <ol>
 *  <li> a project file (<i>projectName</i>.proj.xml) which lists all the screens and DataSources 
 *  involved in the project </li>
 * <li> one or more screen files (<i>screenName</i>.ui.xml) which have {@link
 * com.smartgwt.client.docs.ComponentXML Component XML} 
 *  screen definitions </li>
 * <li> one or more DataSource files (<i>dataSourceId</i>.ds.xml) which have {@link
 * com.smartgwt.client.data.DataSource} definitions </li>
 *  <li> 
 *  
 *  a launch .html file 
 *  that can start your project right away. </li>
 *  </ol>
 *  <P>
 *  The launch file just contains 
 *  
 *  
 * a &lt;script&gt; tag that invokes the {@link com.smartgwt.client.rpc.RPCManager#loadProject
 * ProjectLoaderServlet} 
 *  
 * which causes all screens and DataSources to be loaded, and the start screen to be created and
 * drawn.  
 *  <p>
 * If all you want to do is deploy your application, all that's necessary is to provide real
 * DataSources 
 * to replace the {@link com.smartgwt.client.data.MockDataSource MockDataSources} from the Reify
 * project. Because the Reify project 
 * places MockDataSources into the special "mock" subdirectory, and DataSources are loaded from
 * the first 
 * place they are found, you can replace your MockDataSources by just creating same-named
 * DataSource 
 *  descriptor files 
 * in the {@link com.smartgwt.client.docs.Server_properties DataSources directory configured for
 * your project}.
 *  <p>
 * Replacement DataSources must have the same fields and field types. If all you want to do is use
 * a 
 *  SQL database, you can just:
 *  <ol>
 *  <li> copy your MockDataSource files to the parent directory</li>
 *  <li> change the outer tag from MockDataSource to &lt;SQLDataSource&gt;</li>
 * <li> use the {@link com.smartgwt.client.docs.AdminConsole} tool to configure a connection to a
 * SQL database, and create tables 
 *  from the DataSources</li>
 *  </ol>
 *  <p>
 *  .. and your project is now ready to deploy.
 *  <p>
 *  <b>Hybrid development style: mixing Reify projects and hand-coding</b>
 *  <p>
 * It's easy to use Reify for just the simpler parts of a complex application. For example, the
 * start 
 * screen of a complex application might need to be hand-coded, but from there, other screens
 * might be 
 * Reify projects or hand-coded, in any mix. Even a hand-coded screen might use a Reify project
 * for a 
 * pop-up dialog or wizard. All that's necessary to do this is to load the Reify project into your
 * 
 * existing application, and use {@link com.smartgwt.client.rpc.RPCManager#createScreen
 * RPCManager.createScreen()} at the point where you want to 
 *  introduce Reify-created screens.
 *  <p>
 * Remember that while your Reify project is built and tested as a full-screen application,
 * there's no 
 * requirement that it takes over the screen when embedded into a larger application. For example,
 * say 
 * you have a hand-coded application where the main screen consists of a {@link
 * com.smartgwt.client.widgets.layout.SplitPane} with a tree 
 * on the left, which controls what components are shown in the {@link
 * com.smartgwt.client.widgets.layout.SplitPane#getDetailPane detailPane} 
 * on the right. You've loaded a Reify project with a screen called "leadDetails". If you wanted
 * to 
 *  place a Reify-created screen in <i>just the right pane</i>, you can just do this:
 *  
 *  
 *  <pre>
 *      <i>mySplitPane</i>.setDetailPane(RPCManager.createScreen("leadDetails"));
 *  </pre>
 *  
 * Similarly, imagine you are building a modal window in Reify, such as a wizard or a pop-up
 * dialog. 
 * There's no reason for the <code>Window</code> component itself to appear in the Reify project,
 * since 
 *  you can just do this:
 *  
 *  
 *  <pre>    
 *     Window myWindow = new Window();
 *     myWindow.addItem(RPCManager.createScreen("<i>reifyScreenName</i>"));
 *     ... other properties ...
 *  </pre>
 *  
 * Leaving the <code>Window</code> component out of the Reify project gives you a little more room
 * 
 * to work in the editor, and may be a more natural split in your application. Alternatively, you
 * may 
 * want the <code>Window</code> in the Reify project so that previewers see something closer to
 * the 
 *  actual appearance.  
 *  <p>
 * Either approach is fine; the key point is that in the Hybrid Development approach, you can
 * place 
 * the boundary between your Reify screens and your custom code <i>anywhere you want</i>. You can
 * use a 
 * Reify screen for the contents of a window, or a tab, or even just the <i>lower half</i> of a
 * tab, 
 * if there is a hand-coded component that needs to appear up top. This makes it possible to use
 * Reify 
 *  for a much greater proportion of your application than may at first be obvious.
 *  <p>
 *  <b>Hybrid Development: adding custom behavior while leaving Reify resources unchanged</b>
 *  <p>
 * Ideally, leave the resources you import from your Reify project unchanged - that way, you can
 * continue 
 * to modify them visually and collaboratively in the Reify tool, and re-import them into your IDE
 * project 
 * at any time to pick up changes. Importing an updated Reify project into your IDE project is
 * already 
 * simple, but we make it into just one step with special {@link
 * com.smartgwt.client.docs.ReifyMaven Maven commands}.
 *  <p>
 * Note that you can leave Reify resources unchanged, and yet still inject custom logic and custom
 * 
 *  components into the screen. For example:
 *  <ol>
 *  <li> you can add event handlers to components in a loaded screen
 *  
 *  
 *  <pre>    
 *  ListGrid mainGrid = (ListGrid)RPCManager.createScreen("<i>screenName</i>");
 *  mainGrid.addRecordClickHandler(new RecordClickHandler() {
 *      &#64;Override
 *      public void onRecordClick(RecordClickEvent event) {
 *          myApp.loadRelatedImages(event.getRecord());
 *      }
 *  });
 *  </pre>
 *  
 *  <p>
 *  
 *  <p>
 *  </li>
 * <li> you can swap in custom subclasses for standard components. For example, say you have a
 * custom 
 * subclass of <code>ListGrid</code> that you want to use everywhere in your application - you can
 * use 
 * {@link com.smartgwt.client.rpc.CreateScreenSettings#getClassSubstitutions
 * CreateScreenSettings.classSubstitutions} to do that:
 *  
 *  
 *  <p><pre>
 *  CreateScreenSettings settings = new CreateScreenSettings();
 *  settings.setClassSubstitutions(new HashMap() {{ put("ListGrid", "MyCustomListGrid"); }});
 *  Canvas screen = RPCManager.createScreen("<i>screenName</i>", settings);
 *  </pre>
 *  
 * .. alternatively, you can use {@link
 * com.smartgwt.client.rpc.CreateScreenSettings#getComponentSubstitutions
 * CreateScreenSettings.componentSubstitutions} to change the 
 *  classes used for individual components by the component's ID:
 *  
 *  
 *  <p><pre>
 *  CreateScreenSettings settings = new CreateScreenSettings();
 *  settings.setComponentSubstitutions(new HashMap() {{ put("mainGrid", myCustomListGrid); }});
 *  Canvas screen = RPCManager.createScreen("<i>screenName</i>", settings);
 *  </pre>
 *  
 *  </li>
 * <li> you can also inject components into the loaded screen, such as a custom component you've
 * written
 *  
 *  
 *  <p><pre>
 *  Canvas screen = RPCManager.createScreen("<i>screenName</i>");
 *  Layout mainLayout = (Layout)screen.getByLocalId("mainLayout");
 *  mainLayout.addMember(<i>customDisplayComponent</i>);
 *  </pre>
 *  
 *  </li>
 *  </ol>
 *  <p>
 * Using the above techniques, you can keep large portions of even a complex application in
 * declarative, 
 * Reify-editable files. This makes it much easier to make changes, and collaborate and iterate on
 * 
 *  possible designs.
 *  <p>
 *  <b>Uploading existing DataSources to Reify</b>
 *  <p>
 *  If you have existing DataSources in hand-coded applications, the quickest way to get
 *  them into Reify is to go to the Admin Console and do a CSV export.  Export with the radio
 *  button set to "Reify format" to ensure both your field names and titles are written into
 *  the CSV.  Then, within Reify, you can create a new DataSource from the CSV sample data.
 *  <p>
 * If you give the DataSource you create in Reify the same ID as the real DataSource in your
 * project, 
 *  then when the Reify project is exported and added to an existing hand-coded project, the real 
 *  DataSource will automatically take the place of the MockDataSource you create in Reify.
 *  <p>
 * Note that Reify does not offer direct upload of existing .ds.xml files, because of the security
 * 
 * implications of features such as {@link com.smartgwt.client.data.OperationBinding#getCustomSQL
 * &lt;customSQL&gt;} and 
 * {@link com.smartgwt.client.docs.ServerScript Server Scripting}. Even aside from security
 * concerns, an existing .ds.xml 
 * can have dependencies on other parts of your environment, such as custom {@link
 * com.smartgwt.client.data.SimpleType SimpleTypes}, 
 *  validators that invoke server Java code, or custom tags.  
 *  <p>
 * When you export to CSV and create a MockDataSource, Reify automatically determines field types,
 * 
 * including distinguishing between "time", "date", and "datetime" fields, as well as between
 * "int" 
 * and "float" fields, so the MockDataSource is a perfect stand-in for your real DataSource for
 * design 
 *  purposes.
 *  <p>
 *  Consider trimming the sample data down to 50-100 rows before creating the MockDataSource. 
 * Any additional data won't do anything other than slightly slow down the tool, as sample data in
 * 
 * Reify is stored inside the .ds.xml file and not in a SQL database or other production-capable
 * data store.
 *  <p>
 *  <b>Providing initial data to Reify screens</b>
 *  <p>
 * Because the Reify-created portions of your application use the same DataSources as the rest of
 * your 
 * application, they already have access to the same data. But what if there is some data that you
 * 
 * want to pass to your Reify screen that isn't in a DataSource? For example, perhaps you have a
 * variable 
 * that holds the current user name, and the Reify screen has an area that should say "Hello,
 * <i>user</i>".
 *  <p>
 * A simple way to handle that case is to simply reach into the Reify screen after you've created
 * it, 
 *  and populate components with the necessary data. For example:
 *  
 *  
 *  <pre>
 *  Canvas myScreen = RPCManager.createScreen("<i>screenName</i>");
 *  myScreen.getByLocalId("mainHeaderLabel").setContents("Hello " + <i>userNameVariable</i>);
 *  </pre>
 *  
 *  <p>
 * However, what if you need to pass along information such as a record that is currently
 * selected, where 
 * the Reify screen should load details related to this record? You could programmatically
 * populate the 
 * components in the Reify screen with data, but this would mean that the Reify screen would have
 * to be 
 * set up to <i>not</i> populate itself with data, which would make it less capable and less
 * useful for 
 *  reviewers.
 *  <p>
 * The recommended practice here is to <i>turn the data into a DataSource</i>. The natural way to
 * build 
 * a Reify screen that needs to start with a specific selected record is simply to create a
 * DataSource 
 * in the Reify project representing the selected record. You can fulfill the Reify project's need
 * for 
 * data by creating a single-record, {@link com.smartgwt.client.data.DataSource#getClientOnly
 * clientOnly DataSource}, which the 
 *  Reify project can fetch from when it draws.
 *  <p>
 * This can be done with very little code, since you can use {@link
 * com.smartgwt.client.data.DataSource#getInheritsFrom DataSource.inheritsFrom} to avoid 
 * duplicating field definitions. For example, say you have a Reify screen that needs to load data
 * 
 * related to a selected record from the "customer" DataSource. In the Reify project, a
 * MockDataSource called 
 * "selectedCustomer" was created to represent the necessary data, and in your custom code, you've
 * got 
 * a variable <code>currentCustomer</code> that has the Record for the currently selected
 * customer. 
 *  To make the data available to the Reify project, you can just do this:
 *  
 *  
 *  <pre>
 *  DataSource selectedCustomer = new DataSource();
 *  selectedCustomer.setID("selectedCustomer");
 *  selectedCustomer.setClientOnly(true);
 *  selectedCustomer.setInheritsFrom("customer");
 *  selectedCustomer.setCacheData(<i>currentCustomer</i>);
 *  Canvas myScreen = RPCManager.createScreen("<i>reifyScreenName</i>");
 *  myScreen.draw();
 *  </pre>
 *  
 * Now the Reify screen can pull the data about the selected "customer" record from the
 * "selectedCustomer"
 * DataSource. If you have multiple Reify screens that need to start with a selected customer, you
 * can 
 * standardize on the name "selectedCustomer" and just use <code>DataSource.setCacheData()</code>
 * to 
 *  update the data in the <code>selectedCustomer</code> client-only DataSource.
 *  <p>
 *  <b>Detecting that a Reify screen is done</b>
 *  <p>
 * For many if not most scenarios of embedding Reify screens in a larger application, the user
 * simply 
 * completes a task on the Reify-created screen and then navigates away, and may navigate back
 * later 
 * and complete more tasks, so nothing special needs to be done.  However, sometimes you need to
 * know 
 * when a user has completed interacting with a Reify-created screen (such as a wizard), so that
 * the 
 *  containing application code can take the next step.
 *  <p>
 *  There are a few simple techniques for doing this:
 *  <ul> 
 * <li> watch for an event on some object in the Reify screen - for example, wait for the click
 * event 
 *  on a "Done" button </li>
 * <li> watch for Reify screen to hide itself, if that's what it does on completion. You can do
 * this by
 *  
 *   adding a VisibilityChangedHandler 
 *  </li>
 *  <li> watch for a successful DataSource operation by
 *  
 *   adding a DataSourceDataChangedHandler 
 *  </li>
 * <li> have the Reify screen write to a <code>clientOnly</code> DataSource when it completes.
 * This is 
 * the same as the technique described above for providing initial data to a Reify screen, but in 
 * reverse. This is also useful if the Reify screen needs to pass data back to the main
 * application, 
 * and you'd prefer not to retrieve that data by simply interrogating components in the Reify
 * screen</li>
 *  </ul>
 *  <p>
 *  <b>Best practices &amp; long-term maintenance</b>
 *  <p>
 * Once your exported Reify application has been integrated into an IDE-based project with custom
 * code, 
 * you will need a process to coordinate on further changes made within Reify to try to avoid, or
 * at 
 * least minimize, problems when new versions of the Reify project are pulled into the IDE-based
 * project.
 *  <p>
 * The boundary between the hand-written parts of your application and your Reify-created screens
 * consists of:
 *  <ol>
 *  <li>DataSources the Reify screen accesses</li>
 * <li>component IDs that your custom code accesses in order to install event handlers, populate
 * or 
 *  retrieve data, or insert or replace components</li>
 *  </ol>
 *  <p>
 *  For long-term maintenance, when you have a choice between integration techniques that 
 *  use DataSources vs those that use component access, use DataSources where possible.
 *  DataSources are generally less likely to change, generally easier to reconcile when they 
 *  do, and discrepancies are easier to detect. In fact, 
 *  SmartGWT provides tooling to 
 *  detect those changes through Maven goals, Ant tasks, or a Java CLI.  
 *  <p>
 *  By default, both
 * <a href='http://github.smartclient.com/isc-maven-plugin/reify-import-mojo.html'
 * target='_blank'>Maven</a>
 *  and 
 * <a
 * href='http://github.smartclient.com/isc-maven-plugin/apidocs/com/isomorphic/maven/mojo/reify/ImportTask.html'
 * target='_blank'>Ant</a>
 *  import utilities automatically check for common discrepancies on import, but this step 
 *  may also be run independently at any time using
 * <a href='http://github.smartclient.com/isc-maven-plugin/reify-validate-mojo.html'
 * target='_blank'>reify-validate</a>
 *  goal or
 * <a
 * href='http://github.smartclient.com/isc-maven-plugin/apidocs/com/isomorphic/maven/mojo/reify/ImportTask.html'
 * target='_blank'>ValidateTask</a>
 *  tasks, respectively.  For Maven, that could be as simple as something like this:
 *  <p>
 *  <pre>
 *  &lt;plugin&gt;
 *      &lt;groupId&gt;com.isomorphic&lt;/groupId&gt;
 *      &lt;artifactId&gt;isc-maven-plugin&lt;/artifactId&gt;
 *      &lt;version&gt;1.4.3&lt;/version&gt;
 *      &lt;configuration&gt;
 *        &lt;dataSourcesDir&gt;WEB-INF/ds/classic-models&lt;/dataSourcesDir&gt;
 *      &lt;/configuration&gt;
 *      &lt;dependencies&gt;
 *         &lt;dependency&gt;
 *             &lt;groupId&gt;com.isomorphic.extras&lt;/groupId&gt;
 *             &lt;artifactId&gt;isomorphic-m2pluginextras&lt;/artifactId&gt;
 *             &lt;version&gt;\${smartgwt.version}&lt;/version&gt;
 *         &lt;/dependency&gt;       
 *    &lt;/dependencies&gt;
 *  &lt;/plugin&gt; 
 *  
 *  mvn com.isomorphic:isc-maven-plugin:1.4.3:reify-validate
 *  </pre>
 *  and for Ant:
 *  <pre>
 *  &lt;target name="reify-validate" depends="reify-tasklibs"&gt;
 *      
 *      &lt;taskdef name="reify-validate"
 *               classname="com.isomorphic.maven.mojo.reify.ValidateTask"
 *               classpathref="reify.classpath"/&gt;
 *      &lt;reify-validate datasourcesDir="WEB-INF/ds/classic-models" 
 *                      smartclientRuntimeDir="\${basedir}/war/isomorphic" /&gt;
 *  &lt;/target&gt;   
 *  
 *  ant reify-validate
 *  </pre>
 *  <p>
 *  If, for any reason, one wanted access to the same feature outside of either Ant or Maven 
 *  environments, a Java class is provided for invocation from command line, scripts, etc.
 *  Note that in this case, however, the classpath would need manual setup to include the
 * isomorphic_m2pluginextras JAR and {@link com.smartgwt.client.docs.JavaModuleDependencies its
 * dependencies},
 *  and you'll need to provide the full path to your application resources.  Assuming the
 *  required JARs could all be found at tools/reify/lib, that might look something like 
 *  this:
 *  <pre>
 *  java -cp :tools/reify/lib/* com.isomorphic.tools.ReifyDataSourceValidator 
 *       -r /Users/you/dev/your-application/war/isomorphic
 *       -d /Users/you/dev/your-application/war/WEB-INF/ds/classic-models
 *       -m /Users/you/dev/your-application/war/WEB-INF/ds/mock
 *  </pre>
 */
public interface ReifyForDevelopers {
}
