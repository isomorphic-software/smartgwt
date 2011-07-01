package com.smartgwt.sample.showcase.client.forms.dependencies;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.FormItemIfFunction;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.sample.showcase.client.PanelFactory;
import com.smartgwt.sample.showcase.client.ShowcasePanel;

public class FormShowHideSample extends ShowcasePanel {

    private static final String DESCRIPTION = "Select \"On order\" to reveal the \"Shipping Date\" field.";

    public static class Factory implements PanelFactory {
        private String id;

        public Canvas create() {
            FormShowHideSample panel = new FormShowHideSample();
            id = panel.getID();
            return panel;
        }

        public String getID() {
            return id;
        }

        public String getDescription() {
            return DESCRIPTION;
        }
    }
      
    public Canvas getViewPanel() {
    	
        final DynamicForm form = new DynamicForm();
        form.setWidth(300);
        
        final DateItem orderDate = new DateItem();
        orderDate.setName("orderDate");
        orderDate.setTitle("Order Placed");
        orderDate.setRequired(true);
        orderDate.setVisible(false);

        CheckboxItem onOrder = new CheckboxItem();
        onOrder.setName("onOrder");
        onOrder.setTitle("Shipment on order");
        onOrder.setRedrawOnChange(true);
        onOrder.setWidth(50);
        onOrder.setValue(false);

        orderDate.setShowIfCondition(new FormItemIfFunction() {
            public boolean execute(FormItem item, Object value, DynamicForm form) {
                return (Boolean)form.getValue("onOrder");
            }
        });
                
        form.setFields(onOrder, orderDate);

        return form;
    }

    public String getIntro() {
        return DESCRIPTION;
    }
}