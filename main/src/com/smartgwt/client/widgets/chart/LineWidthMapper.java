package com.smartgwt.client.widgets.chart;

public interface LineWidthMapper {
	/**
     * Returns a per-facet-value width for chart data lines.  The Framework will use this width
     * to override any default properties that would otherwise determine 
     * {@link com.smartgwt.client.widgets.drawing.DrawItem#setLineWidth lineWidth} 
     * for the <code>DrawItem</code>s representing the data.
     *
     * @param index index of the legend facet value to target
     * @param facetValueId id of the legend facet value to target
     * @param purpose purpose for the requested line width - such as "legend", "line", "area",
     *                "points", etc.
     *
     * @return width in pixels
     * @see com.smartgwt.client.widgets.chart.FacetChart#setDataLineWidth
     */
    public int getWidth(int index, Object facetValueId, String purpose);
}
