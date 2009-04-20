package com.smartgwt.client.data;

public interface FieldValueExtractor {

    /**
     * @param record    record object selected from web service response data                                      by
     *                  {@link com.smartgwt.client.data.OperationBinding#getRecordXPath recordXPath}
     * @param value     default value derived by the method described in                    {@link
     *                  com.smartgwt.client.data.DataSourceField#getValueXPath valueXPath}
     * @param field     DataSourceField definition
     * @param fieldName name of the DataSource field
     *
     * @return value
     */
    Object execute(Object record, Object value, DataSourceField field, String fieldName);
}
