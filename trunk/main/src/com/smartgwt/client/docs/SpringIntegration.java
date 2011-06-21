
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
 *  inapplicable in the {@link com.smartgwt.client.docs.SmartArchitecture Smart GWT architecture}.  Specifically,
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
 *  As discussed under the general {@link com.smartgwt.client.docs.ClientServerIntegration server integration}
 *  topic, integrating Smart GWT into your application involves finding a way to provide data
 *  that fulfills the {@link com.smartgwt.client.data.DSRequest DataSource requests} sent by Smart GWT components.
 *  <P>
 *  There are 2 approaches for integrating Smart GWT into an existing Spring application:
 *  <ul>
 *  <li> <b>call Spring beans via Smart GWT DMI</b> <span
 *  style="color:red">[Recommended]</span>: use Smart GWT Direct Method Invocation
 *  (DMI) to map {@link com.smartgwt.client.data.DSRequest DataSource requests} to beans managed by Spring, via
 * {@link com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle}:"spring".   Return data to the browser by
 * either simply
 *  returning it from your method, or via creating a DSResponse and calling DSResponse.setData()
 *  (server-side method). 
 *  <P>
 *  This is the easiest method and produces the best result.  A Collection of Java Beans, such
 *  as EJB or Hibernate-managed beans, can be directly returned to Smart GWT as the result of
 *  a DMI method, without the need to create an intervening
 * <a href='http://en.wikipedia.org/wiki/Data_transfer_object'
 * onclick="window.open('http://en.wikipedia.org/wiki/Data_transfer_object');return false;">Data Transfer Object</a> to
 * express
 *  which fields should be delivered to the browser - instead, only the fields declared on the
 *  DataSource are returned to the browser (see
 *  {@link com.smartgwt.client.data.DataSource#getDropExtraFields dropExtraFields}.  In this integration scenario, the
 *  majority of the features of the Smart GWT Server framework still apply - see this
 *  {@link com.smartgwt.client.docs.FeaturesCustomPersistence overview}.
 *  <P>
 *  <li> <b>configure Spring to return XML or JSON responses</b>: create variants
 *  on existing Spring workflows that use a different type of View in order to output XML or
 *  JSON data instead of complete HTML pages.  The Smart GWT {@link com.smartgwt.client.data.RestDataSource} provides a
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
 *  <b>Using Spring Controllers with Smart GWT DMI</b>
 *  <P>
 *  You can create a Controller that invokes standard Smart GWT server request processing,
 *  including DMI, like so:
 *  <pre>
 *  public class Smart GWTRPCController extends AbstractController
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
 */
public interface SpringIntegration {
}
