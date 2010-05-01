
package com.smartgwt.client.docs;

/**
 * <h3>Integration with Spring</h3>
 * <b>Overview</b>&#010 <P>&#010 The Spring framework has many different parts, from integration with Object
 * Relational&#010 Mapping (ORM) and transaction management systems, to a Model View Controller (MVC)&#010
 * architecture.&#010 <P>&#010 If you are building a new application from scratch and/or you are trying to &#010 modernize
 * the presentation layer of an existing application, most of Spring MVC is&#010 inapplicable in the {@link
 * com.smartgwt.client.docs.SmartArchitecture Smart GWT architecture}.  Specifically,&#010 Smart GWT renders <b>all</b>
 * HTML on the client, and the server is responsible only for&#010 retrieving data and enforcing business rules.  This
 * means that Spring's ModelAndView and all&#010 functionality related to retrieving and rendering Views is unnecessary in
 * Smart GWT.&#010 Smart GWT only needs the Model, and provides methods to deliver that Model to Smart GWT&#010 components
 * (the server side method DSResponse.setData()).&#010 <P>&#010 However, Spring's DispatchServlet, Handler chain, and
 * Controller architecture is applicable&#010 to Smart GWT.  See "Using Spring Controllers" below.&#010 <P>&#010
 * <b>Existing Spring Application</b>&#010 <P>&#010 As discussed under the general {@link
 * com.smartgwt.client.docs.ClientServerIntegration server integration}&#010 topic, integrating Smart GWT into your
 * application involves finding a way to provide data&#010 that fulfills the {@link com.smartgwt.client.data.DSRequest
 * DataSource requests} sent by Smart GWT components.&#010 <P>&#010 There are 2 approaches for integrating Smart GWT into
 * an existing Spring application:&#010 <ul>&#010 <li> <b>call Spring beans via Smart GWT DMI</b> <span&#010
 * style="color:red">[Recommended]</span>: use Smart GWT Direct Method Invocation&#010 (DMI) to map {@link
 * com.smartgwt.client.data.DSRequest DataSource requests} to beans managed by Spring, via&#010 {@link
 * com.smartgwt.client.docs.serverds.ServerObject#lookupStyle lookupStyle}:"spring".   Return data to the browser by either
 * simply&#010 returning it from your method, or via creating a DSResponse and calling DSResponse.setData()&#010
 * (server-side method). &#010 <P>&#010 This is the easiest method and produces the best result.  A Collection of Java
 * Beans, such&#010 as EJB or Hibernate-managed beans, can be directly returned to Smart GWT as the result of&#010 a DMI
 * method, without the need to create an intervening&#010 <a href='http://en.wikipedia.org/wiki/Data_transfer_object'
 * onclick="window.open('http://en.wikipedia.org/wiki/Data_transfer_object');return false;">Data Transfer Object</a> to
 * express&#010 which fields should be delivered to the browser - instead, only the fields declared on the&#010 DataSource
 * are returned to the browser (see&#010 {@link com.smartgwt.client.data.DataSource#getDropExtraFields dropExtraFields}. 
 * In this integration scenario, the&#010 majority of the features of the Smart GWT Server framework still apply - see
 * this&#010 {@link com.smartgwt.client.docs.FeaturesCustomPersistence overview}.&#010 <P>&#010 <li> <b>configure Spring to
 * return XML or JSON responses</b>: create variants&#010 on existing Spring workflows that use a different type of View in
 * order to output XML or&#010 JSON data instead of complete HTML pages.  The Smart GWT {@link
 * com.smartgwt.client.data.RestDataSource} provides a&#010 standard "REST" XML or JSON-based protocol you can implement,
 * or you can adapt generic&#010 {@link com.smartgwt.client.data.DataSource DataSources} to existing formats.&#010 <P>&#010
 * In some Spring applications, all existing Spring workflows can be made callable by&#010 Smart GWT with a generic View
 * class capable of serializing the Model to XML or JSON,&#010 combined with a Controller that always uses this View. 
 * Consider the following Java&#010 anonymous class, which uses the Smart GWT JSTranslater class to dump the entire &#010
 * Spring Model as a JSON response.&#010 <pre>&#010  new View() {&#010        public void render(Map model,
 * HttpServletRequest request,&#010                           HttpServletResponse response) throws IOException {&#010      
 * final ServletOutputStream outputStream = response.getOutputStream();&#010               
 * response.setContentType("application/x-javascript");&#010               
 * outputStream.println(JSTranslater.get().toJS(model));&#010                outputStream.close();&#010        }&#010      
 * public String getContentType() {&#010                return "application/x-javascript";&#010        }&#010  }&#010
 * </pre>&#010 <P>&#010 If you use this approach, you do not need to install the Smart GWT server, and can&#010 {@link
 * iscInstall deploy} Smart GWT as simple web content (JS/media/HTML files).  If you&#010 are already familiar with how to
 * generate XML from objects that typically appear in your&#010 Spring Models, this may be the easiest path.&#010
 * </ul>&#010 <P>&#010 <b>Using Spring Controllers with Smart GWT DMI</b>&#010 <P>&#010 You can create a Controller that
 * invokes standard Smart GWT server request processing,&#010 including DMI, like so:&#010 <pre>&#010 public class Smart
 * GWTRPCController extends AbstractController&#010 {&#010     public ModelAndView handleRequest(HttpServletRequest
 * request, &#010                                       HttpServletResponse response)&#010         throws Exception&#010   
 * {&#010         // invoke Smart GWT server standard request processing&#010        
 * com.isomorphic.rpc.RPCManager.processRequest(request, response);&#010         return null; // avoid default
 * rendering&#010     }&#010 }&#010 </pre>&#010 This lets you use Spring's DispatchServlet, Handler chain and Controller
 * architecture as a&#010 pre- and post-processing model wrapped around Smart GWT DMI.
 */
public interface SpringIntegration {
}
