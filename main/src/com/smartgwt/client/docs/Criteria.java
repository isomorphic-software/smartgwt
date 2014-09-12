package com.smartgwt.client.docs;


/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
/* sgwtgen */
 
/**
 * Criteria for selecting only a matching set of records from a DataSource.  Criteria can be applied on the client and
 * server.  Unless configured otherwise, criteria will generally be applied client-side by {@link
 * com.smartgwt.client.data.ResultSet}s via {@link com.smartgwt.client.data.ResultSet#applyFilter ResultSet.applyFilter}.  
 * <P> Client- and server-side systems built into Smart GWT understand two criteria formats by default: simple key-value
 * pairs (Criteria) or the {@link com.smartgwt.client.data.AdvancedCriteria} format.   <P>  <P> Use {@link
 * com.smartgwt.client.data.DataSource#combineCriteria DataSource.combineCriteria} to combine two Criteria objects
 * (including Criteria and AdvancedCriteria) or {@link com.smartgwt.client.data.DataSource#convertCriteria
 * DataSource.convertCriteria} to convert simple Criteria to the AdvancedCriteria format. <P>  When sent to the Smart GWT
 * server, the Java representation of the criteria is described {@link com.smartgwt.client.rpc.RPCRequest#getData here}. 
 * When sent to other servers, the {@link com.smartgwt.client.types.DSProtocol operationBinding.dataProtocol} affects the
 * format.
 */
public interface Criteria  {
}
