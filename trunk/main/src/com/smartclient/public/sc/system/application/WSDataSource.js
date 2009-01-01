/*
 * Isomorphic SmartClient
 * Version 7.0beta3 (2008-12-31)
 * Copyright(c) 1998-2007 Isomorphic Software, Inc. All rights reserved.
 * "SmartClient" is a trademark of Isomorphic Software, Inc.
 *
 * licensing@smartclient.com
 *
 * http://smartclient.com/license
 */
isc.defineClass("WSDataSource", "DataSource");

//> @class WSDataSource
// A WSDataSource is a DataSource that is preconfigured to contact the WSDL-described web
// service built into the SDK.  WSDataSource is a subclass of DataSource used exactly like a
// normal DataSource.
// <P>
// The WSDL service that WSDataSource contacts can be easily implemented on Java and non-Java
// backends.  See +link{group:wsdlBinding,WSDL Integration} for details.
//
// @treeLocation Client Reference/Data Binding
// @visibility xmlBinding
//<

isc.WSDataSource.addMethods({
    serviceNamespace : "urn:operations.smartclient.com",
    operationBindings:[
       {operationType:"fetch", wsOperation:"fetch", recordXPath:"//data/*" },
       {operationType:"add", wsOperation:"add", recordXPath:"//data/*" },
       {operationType:"remove", wsOperation:"remove", recordXPath:"//data/*" },
       {operationType:"update", wsOperation:"update" , recordXPath:"//data/*" }
    ],
    transformRequest : function (dsRequest) {
        var data = {
            dataSource : dsRequest.dataSource,
            operationType : dsRequest.operationType,
            data : dsRequest.data
        };
        // send various metadata only if set
        if (dsRequest.startRow != null) {
            data.startRow = dsRequest.startRow;
            data.endRow = dsRequest.endRow;
        }
        if (dsRequest.textMatchStyle != null) data.textMatchStyle = dsRequest.textMatchStyle;
        if (dsRequest.operationId != null) data.operationId = dsRequest.operationId;
        if (dsRequest.sortBy != null) data.sortBy = dsRequest.sortBy;
        return data;
    },
    transformResponse : function (dsResponse, dsRequest, xmlData) {
        
        // Bail out early if xmlData is null or an unexpected type
        if (!xmlData || !xmlData.selectString) return;
        
        dsResponse.status = xmlData.selectString("//status");

        // convert status from a String to a numeric code
        if (isc.isA.String(dsResponse.status)) {
            var status = isc.DSResponse[dsResponse.status];
            if (dsResponse.status == null) {
                this.logWarn("Unable to map response code: " + status
                              + " to a DSResponse code, setting status to DSResponse.STATUS_FAILURE.");
                status = isc.DSResponse.STATUS_FAILURE;
                dsResponse.data = xmlData.selectString("//data");
            } else {
                dsResponse.status = status;
            }
        }

        // if the status is a validation error, conver the errors from XML
        if (dsResponse.status == isc.DSResponse.STATUS_VALIDATION_ERROR) {
            var errors = xmlData.selectNodes("//errors/*");
            dsResponse.errors = isc.xml.toJS(errors, null, this);
        }

        dsResponse.totalRows = xmlData.selectNumber("//totalRows");
        dsResponse.startRow = xmlData.selectNumber("//startRow");
        dsResponse.endRow = xmlData.selectNumber("//endRow");

    }
});


