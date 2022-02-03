
package com.smartgwt.client.docs;

/**
 * <h3>DataSource Facade pattern</h3>
 * The DataSource Facade pattern means implementing a DataSource that fulfills its
 * {@link com.smartgwt.client.data.DSRequest DSRequests} by passing them on to another DataSource.
 *  <p>
 *  This can be useful for:
 *  <ul>
 *  <li> various testing purposes, such as introducing long delays or intermittent failures to
 *  see how your code responds
 *  <li> implementing application-specific caching behaviors that go beyond
 * {@link com.smartgwt.client.data.DataSource#getCacheAllData DataSource.cacheAllData} or
 * automatic caching done by {@link com.smartgwt.client.data.ResultSet}
 *  <li> providing DSResponses that make use of data from two or more DataSources, by sending
 *  DSRequests to those other DataSources, waiting for both to respond, then combining the
 *  response data (note that for something like a SQL join, you should instead use
 * {@link com.smartgwt.client.docs.serverds.DataSourceField#includeFrom
 * DataSourceField.includeFrom} if you have Smart GWT Pro or better)
 *  <li> slight modifications of data returned by another DataSource (although consider just
 * using {@link com.smartgwt.client.data.OperationBinding#getOperationId
 * OperationBinding.operationId} for this)
 *  </ul>
 *  <p>
 *  This facade pattern can be implemented either server-side or client-side:
 *  <ul>
 *  <li> server-side (Smart GWT Pro or better), implement a custom DataSource (see QuickStart
 *  Guide) and implement the server-side API DataSource.execute() by calling
 *  DataSource.execute() on some other DataSource, then return the DSResponse that results.
 * <li> client-side, use {@link com.smartgwt.client.data.DataSource#getDataProtocol
 * dataProtocol:"clientCustom"}.  The
 * {@link com.smartgwt.client.data.FacadeDataSource} provides a specific implementation that is
 * useful for testing
 *  purposes.  Alternative, the code below shows the simplest possible code for the facade
 *  pattern when implemented client-side via <code>dataProtocol:"clientCustom"</code> - requests
 *  are forwarded to another DataSource, and the responses are returned completely unchanged.
 *  </ul>
 *  <p>
 *  
 *  
 *  <pre>
 *  final DataSource facadeDataSource = new DataSource() {
 *      {
 *          setDataProtocol(DSProtocol.CLIENTCUSTOM);
 *          setInheritsFrom(ItemSupplyXmlDS.getInstance());
 *      }
 * 
 *      &#64;Override
 *      public Object transformRequest(final DSRequest dsRequest) {
 *          final DataSource superDS = DataSource.get(getInheritsFrom()),
 *                  selfDS = this;
 * 
 *          final DSRequest derivedDSRequest = cloneDSRequest(dsRequest);
 *          derivedDSRequest.setShowPrompt(false);
 *          derivedDSRequest.setCallback(new DSCallback() {
 *              &#64;Override
 *              public void execute(DSResponse dsResponse, Object data, DSRequest derivedDSRequest) {
 *                  selfDS.processResponse(dsRequest.getRequestId(), superDS.cloneDSResponse(dsResponse));
 *              }
 *          });
 * 
 *          superDS.execute(derivedDSRequest);
 * 
 *          return dsRequest.getData();
 *      }
 *  };
 *  </pre>
 * 
 */
public interface DsFacade {
}
