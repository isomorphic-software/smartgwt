package com.smartgwt.client.widgets.chart;

import com.smartgwt.client.data.Record;

public abstract class ChartPointHoverCustomizer {
    
    private String metricId;
    public String getMetricId () {
        return metricId;
    }
    public void setMetricId (String metricId) {
        this.metricId = metricId;
    }
	
	public abstract String hoverHTML(Float value, Record record);
}
