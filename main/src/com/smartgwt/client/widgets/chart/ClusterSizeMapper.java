package com.smartgwt.client.widgets.chart;

public interface ClusterSizeMapper {
	/**
     * Returns a per-facet-value cluster size.  Follow the setter links below to see how the the
     * size will be used.
     *
     * @param index data label axis index of cluster or bar stack
     * @param facetValueId data label facet value id of cluster or bar stack
     *
     * @return size in pixels
     * @see com.smartgwt.client.widgets.chart.FacetChart#setMinClsuterSizeMapper
     */
    public int getClusterSize(int index, Object facetValueId);
}
