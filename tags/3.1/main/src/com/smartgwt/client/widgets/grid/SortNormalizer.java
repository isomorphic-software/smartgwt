package com.smartgwt.client.widgets.grid;

/**
 * Sort Normalizer
 *
 * @see com.smartgwt.client.widgets.grid.ListGridField#setSortNormalizer(SortNormalizer) 
 */
public interface SortNormalizer {

    /**
     * The normalization function.
     *
     * @param record the record to normalize
     * @param fieldName name of the field on which sorting occurred
     * 
     * @return normalized value for sorting (a java numeric primitive type or String)
     */
    Object normalize(ListGridRecord record, String fieldName);
}
