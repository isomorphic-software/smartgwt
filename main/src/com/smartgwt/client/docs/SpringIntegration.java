
package com.smartgwt.client.docs;

/**
 * <h3>Integration with Spring</h3>
 * <b>Overview</b>
 *  <P>
 *  The Spring framework has many different parts, from integration with Object Relational
 *  Mapping (ORM) and transaction management systems, to a Model View Controller (MVC)
 *  architecture.
 *  <P>
 *  If you are building a new application from scratch and/or you are trying to 
 *  modernize the presentation layer of an existing application, most of Spring MVC is
 * inapplicable in the {@link com.smartgwt.client.docs.SmartArchitecture Smart GWT architecture}. 
 * Specifically,
 *  Smart GWT renders <b>all</b> HTML on the client, and the server is responsible only for
 *  retrieving data and enforcing business rules.  This means that Spring's ModelAndView and all
 *  functionality related to retrieving and rendering Views is unnecessary in Smart GWT.
 *  Smart GWT only needs the Model, and provides methods to deliver that Model to Smart GWT
 *  components (the server side method DSResponse.setData()).
 *  <P>
 *  However, Spring's DispatchServlet, Handler chain, and Controller architecture is applicable
 *  to Smart GWT.  See "Using Spring Controllers" below.
 *  <P>
 *  <b>Existing Spring Application</b>
 *  <P>
 * As discussed under the general {@link com.smartgwt.client.docs.ClientServerIntegration server
 * integration}
 *  topic, integrating Smart GWT into your application involves finding a way to provide data
 * that fulfills the {@link com.smartgwt.client.data.DSRequest DataSource requests} sent by Smart
 * GWT components.
 *  <P>
 *  There are 2 approaches for integrating Smart GWT into an existing Spring application:
 *  <ul>
 *  <li> <b>call Spring beans via Smart GWT DMI or custom DataSources</b>
 *  <span style="color:red">[Recommended]</span>: use Smart GWT Direct Method Invocation
 * (DMI) to map {@link com.smartgwt.client.data.DSRequest DataSource requests} to beans managed by
 * Spring, via
 * {@link com.smartgwt.client.docs.serverds.ServerObject#lookupStyle
 * ServerObject.lookupStyle}:"spring".   Return data to the browser by either simply
 *  returning it from your method, or via creating a DSResponse and calling DSResponse.setData()
 *  (server-side method).  Or, use a similar approach based on custom DataSource implementations
 * where the {@link com.smartgwt.client.docs.serverds.DataSource#serverConstructor
 * serverConstructor} is of the pattern 
 *  <b>"spring:{bean_name}"</b>
 *  <P>
 *  This is the easiest method and produces the best result.  A Collection of Java Beans, such
 *  as EJB or Hibernate-managed beans, can be directly returned to Smart GWT as the result of
 *  a DMI method, without the need to create an intervening
 * <a href='http://en.wikipedia.org/wiki/Data_transfer_object' target='_blank'>Data Transfer
 * Object</a> to express
 *  which fields should be delivered to the browser - instead, only the fields declared on the
 *  DataSource are returned to the browser (see
 * {@link com.smartgwt.client.data.DataSource#getDropExtraFields dropExtraFields}.  In this
 * integration scenario, the
 *  majority of the features of the Smart GWT Server framework still apply - see this
 *  {@link com.smartgwt.client.docs.FeaturesCustomPersistence overview}.
 *  <p>
 *  Note, there are special scoping considerations to bear in mind when using Spring-injected 
 * DataSources or DMIs - see {@link com.smartgwt.client.docs.ServerDataSourceImplementation this
 * discussion} of 
 *  caching and thread-safety issues.
 *  <P>
 *  <li> <b>configure Spring to return XML or JSON responses</b>: create variants
 *  on existing Spring workflows that use a different type of View in order to output XML or
 * JSON data instead of complete HTML pages.  The Smart GWT {@link
 * com.smartgwt.client.data.RestDataSource} provides a
 *  standard "REST" XML or JSON-based protocol you can implement, or you can adapt generic
 *  {@link com.smartgwt.client.data.DataSource DataSources} to existing formats.
 *  <P>
 *  In some Spring applications, all existing Spring workflows can be made callable by
 *  Smart GWT with a generic View class capable of serializing the Model to XML or JSON,
 *  combined with a Controller that always uses this View.  Consider the following Java
 *  anonymous class, which uses the Smart GWT JSTranslater class to dump the entire 
 *  Spring Model as a JSON response.
 *  <pre>
 *   new View() {
 *         public void render(Map model, HttpServletRequest request,
 *                            HttpServletResponse response) throws IOException {
 *                 final ServletOutputStream outputStream = response.getOutputStream();
 *                 response.setContentType("application/x-javascript");
 *                 outputStream.println(JSTranslater.get().toJS(model));
 *                 outputStream.close();
 *         }
 *         public String getContentType() {
 *                 return "application/x-javascript";
 *         }
 *   }
 *  </pre>
 *  <P>
 *  If you use this approach, you do not need to install the Smart GWT server, and can
 *  {@link iscInstall deploy} Smart GWT as simple web content (JS/media/HTML files).  If you
 *  are already familiar with how to generate XML from objects that typically appear in your
 *  Spring Models, this may be the easiest path.
 *  </ul>
 *  <P>
 *  <h3><b>Using Spring Controllers with Smart GWT DMI</b></h3>
 *  <P>
 *  You can create a Controller that invokes standard Smart GWT server request processing,
 *  including DMI, like so:
 *  <pre>
 *  public class SmartGWTRPCController extends AbstractController
 *  {
 *      public ModelAndView handleRequest(HttpServletRequest request, 
 *                                        HttpServletResponse response)
 *          throws Exception
 *      {
 *          // invoke Smart GWT server standard request processing
 *          com.isomorphic.rpc.RPCManager.processRequest(request, response);
 *          return null; // avoid default rendering
 *      }
 *  }
 *  </pre>
 *  This lets you use Spring's DispatchServlet, Handler chain and Controller architecture as a
 *  pre- and post-processing model wrapped around Smart GWT DMI.
 *  <p>
 *  <h3><b>Using Spring Transactions with Smart GWT DMI</b></h3>
 *  <p>
 *  You can make DMI's participate in Spring's transaction management scheme by setting the 
 * {@link com.smartgwt.client.data.DataSource#getUseSpringTransaction useSpringTransaction} flag
 * on your DataSources or 
 *  {@link com.smartgwt.client.data.OperationBinding}s.  This makes your DMI method(s) 
 *  transactional, and ensures that any DSRequests and Spring DAO operations executed within 
 *  that DMI use the same Spring-managed transaction.  See the documentation for 
 *  <code>useSpringTransaction</code> for more details.
 *  <p>
 *  In Power Edition and above, Smart GWT Server has its own transaction management system.
 *  This allows you to send {@link com.smartgwt.client.rpc.RPCManager#startQueue queues} of 
 * {@link com.smartgwt.client.data.DSRequest DSRequest}s to the server, and the entire queue will
 * be treated as a 
 *  single database transaction.  This is <b>not</b> the same thing as Spring transaction 
 *  integration: Smart GWT's built-in transaction management works across an entire queue of
 *  DSRequests, whereas Spring transactions are specific to a Java method that has been marked 
 * <code>&#x0040;Transactional</code> - the transaction starts and ends when the method starts and
 * 
 *  ends.
 *  <p>
 * It is possible to have an entire Smart GWT queue - including any
 * <code>&#x0040;Transactional</code>
 *  DMIs that contain both Spring DAO operations and DSRequests - use the same Spring-managed 
 *  transaction.  To do this:<ul>
 * <li>Create a new Spring service bean with a <code>&#x0040;Transactional</code> method like this
 *  (note, the isolation level can vary as you please, but the propagation type must be REQUIRED
 *  to enable proper sharing of the transaction):<pre>
 *     &#x0040;Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED)
 *     public class MyServiceBean {
 *  
 *         // invoke Smart GWT server standard request processing
 *         public void processQueue(RPCManager rpc) throws Exception {
 *             rpc.processRPCTransaction();
 *         }
 *     }</pre></li>
 *  <li><b>Either:</b> Subclass the <code>com.isomorphic.servlet.IDACall</code> servlet and 
 *  override its <code>processRPCTransaction</code> method to inject the service bean you just
 *  created and invoke its transactional method.  You will also have to change your 
 *  <code>web.xml</code> file to point at this new servlet rather than <code>IDACall</code></li>
 *  <li><b>Or:</b> Use a Spring Controller, as described in the section <b>Using Spring 
 *  Controllers with Smart GWT DMI</b>, above.  Just follow the instructions for using a 
 *  Spring Controller, but have your <code>handleRequest()</code> implementation inject your
 *  service bean and invoke its transactional method, as described for the <code>IDACall</code>
 *  subclass approach</li>
 *  </ul>
 *  Whether you choose the IDACall or Spring Controller approach, the important thing is that 
 *  the call to <code>RPCManager.processRPCTransaction()</code> takes place from within a 
 *  <code>&#x0040;Transactional</code> method of a Spring service bean.  This will place the 
 *  processing of the entire Smart GWT queue inside the transaction that is created by Spring
 *  to service that transactional method.
 */
public interface SpringIntegration {
}
