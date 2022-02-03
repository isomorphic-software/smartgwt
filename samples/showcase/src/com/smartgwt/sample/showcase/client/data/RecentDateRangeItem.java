package com.smartgwt.sample.showcase.client.data;

import java.util.LinkedHashMap;

import com.smartgwt.client.bean.BeanFactory;
import com.smartgwt.client.data.AdvancedCriteria;
import com.smartgwt.client.data.Criterion;
import com.smartgwt.client.data.RelativeDate;
import com.smartgwt.client.types.OperatorId;
import com.smartgwt.client.widgets.form.PresetDateRangeItem;
import com.smartgwt.client.widgets.form.fields.RelativeDateItem;

@BeanFactory.Generate
public class RecentDateRangeItem extends PresetDateRangeItem {
	public RecentDateRangeItem() {
		LinkedHashMap<String, Object> options = new LinkedHashMap<String, Object>();

		AdvancedCriteria ac1 = new AdvancedCriteria(OperatorId.AND);
		Criterion c11 = new Criterion("orderDate", OperatorId.GREATER_OR_EQUAL, RelativeDateItem.getAbsoluteDate(new RelativeDate("-1M")));
		ac1.addCriteria(c11);
		Criterion c12 = new Criterion("orderDate", OperatorId.LESS_OR_EQUAL, RelativeDateItem.getAbsoluteDate(new RelativeDate("$today")));
		ac1.addCriteria(c12);
		options.put("Previous Month", ac1.getJsObj());

		AdvancedCriteria ac2 = new AdvancedCriteria(OperatorId.AND);
		Criterion c21 = new Criterion("orderDate", OperatorId.GREATER_OR_EQUAL, RelativeDateItem.getAbsoluteDate(new RelativeDate("-1W")));
		ac2.addCriteria(c21);
		Criterion c22 = new Criterion("orderDate", OperatorId.LESS_OR_EQUAL, RelativeDateItem.getAbsoluteDate(new RelativeDate("$today")));
		ac2.addCriteria(c22);
		options.put("Previous Week", ac2.getJsObj());

		Criterion c31 = new Criterion("orderDate", OperatorId.EQUALS, RelativeDateItem.getAbsoluteDate(new RelativeDate("$yesterday")));
		options.put("Yesterday", c31.getJsObj());
		
		Criterion c41 = new Criterion("orderDate", OperatorId.EQUALS, RelativeDateItem.getAbsoluteDate(new RelativeDate("$today")));
		options.put("Today", c41.getJsObj());

		setOptions(options);
	}
    	
    public void setOperator(String operatorId) {
        setAttribute("operator", operatorId == null ? null : operatorId);
    }
}