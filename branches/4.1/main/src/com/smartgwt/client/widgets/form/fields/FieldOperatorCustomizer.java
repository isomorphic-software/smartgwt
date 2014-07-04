package com.smartgwt.client.widgets.form.fields;

import java.util.Date;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.widgets.form.FilterBuilder;

/**
 * Customizer that returns the list of OperatorIds applicable to a given field.
 */
public abstract class FieldOperatorCustomizer {
    /**
     * getFieldOperators() should be implemented and return the list of OperatorIds applicable
     * to the passed fieldName
     * @param fieldName the name of the field to return OperatorIds for
     * @param defaultOperators the default list of OperatorIds that would be returned in the absence of this customizer
     * @param filterBuilder the FilterBuilder this customizer is attached to
     * @return array of OperatorIds to apply to the passed fieldName
     */
    public abstract OperatorId[] getFieldOperators(String fieldName, OperatorId[] defaultOperators, FilterBuilder filterBuilder);
}
