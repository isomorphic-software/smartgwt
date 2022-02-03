package com.smartgwt.client.widgets.chart;

public interface ColorMapper {
	/**
     * Returns the color to be used for the specified chart data - must return a color in the
     * format of of a leading hash (#) plus 6 hexadecimal digits as mentioned in the docs for
     * {@link com.smartgwt.client.docs.CSSColor}.
     *
     * @param index index of the legend facet value to be rendered
     * @param facetValueId id of the legend facet value to be rendered
     * @param purpose purpose for the requested gradient - such as "legend", "line", "area",
     *                "points", etc.
     * @return color
     * @see com.smartgwt.client.widgets.chart.FacetChart#setDataColorMapper
     * @see com.smartgwt.client.widgets.chart.FacetChart#setDataLineColorMapper
     * @see com.smartgwt.client.widgets.chart.MetricSettings#setDataColorMapper
     * @see com.smartgwt.client.widgets.chart.MetricSettings#setDataLineColorMapper
     */
    public String getColor(int index, Object facetValueId, String purpose);
}
