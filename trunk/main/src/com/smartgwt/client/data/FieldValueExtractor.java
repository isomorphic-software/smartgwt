package com.smartgwt.client.data;

public interface FieldValueExtractor {

    Object execute(Object record, Object value, DataSourceField field, String fieldName);
}
