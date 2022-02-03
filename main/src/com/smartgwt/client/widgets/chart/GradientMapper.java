package com.smartgwt.client.widgets.chart;

public interface GradientMapper {
	/**
     * Returns the gradient identifier to be used for the specified chart data.
     *
     * @param index index of the legend facet value to be rendered
     * @param facetValueId id of the legend facet value to be rendered
     * @param purpose purpose for the requested gradient - such as "legend", "line", "area",
     *                "points", etc.
     * @return gradient id
     * @see com.smartgwt.client.widgets.chart.FacetChart#setDataGradientMapper
     * @see com.smartgwt.client.widgets.chart.MetricSettings#setDataGradientMapper
     */
    public String getGradient(int index, Object facetValueId, String purpose);
}
