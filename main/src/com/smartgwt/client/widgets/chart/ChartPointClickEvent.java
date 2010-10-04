package com.smartgwt.client.widgets.chart;

import com.smartgwt.client.data.Record;

public class ChartPointClickEvent {
	public Float getValue() {
		return value;
	}
	public void setValue(Float value) {
		this.value = value;
	}
	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	private Float value;
	private Record record;
	ChartPointClickEvent(Float value, Record record) {
		this.value = value;
		this.record = record;
	}
}
