package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.FormItemValueFormatter;
import com.smartgwt.client.widgets.form.ValueIconMapper;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;

public class AnimalTile extends DynamicForm {
    
    public AnimalTile() {
        setOverflow(Overflow.HIDDEN);
        setHeight(150);
        setWidth(200);

        StaticTextItem pictureItem = new StaticTextItem("picture");
        pictureItem.setRowSpan(3);
        pictureItem.setShowTitle(false);
        pictureItem.setCanEdit(false);
        pictureItem.setImageURLPrefix("animals/");
        pictureItem.setShowValueIconOnly(true);
        pictureItem.setValueIconHeight(148);
        pictureItem.setValueIconWidth(120);
        pictureItem.setValueIconMapper(new ValueIconMapper() {
            @Override
            public String getValueIcon(Object value) {
                return String.valueOf(value);
            }
        });

        StaticTextItem commonName = new StaticTextItem("commonName");
        commonName.setShowTitle(false);
        StaticTextItem lifeSpan = new StaticTextItem("lifeSpan");
        lifeSpan.setShowTitle(false);
        lifeSpan.setValueFormatter(new FormItemValueFormatter() {
            
            @Override
            public String formatValue(Object value, Record record, DynamicForm form, FormItem item) {
                return value + " years";
            }
        });
        StaticTextItem status = new StaticTextItem("status");
        status.setShowTitle(false);
        status.setHeight("*");
        status.setWrap(false);
        status.setValueFormatter(new FormItemValueFormatter() {
            @Override
            public String formatValue(Object value, Record record, DynamicForm form, FormItem item) {
                String res = null;
                if (value.equals("Endangered")) {
                    res = "endangered";
                } else if (value.equals("Threatened")) {
                    res = "threatened";
                } else if (value.equals("Not Endangered")) {
                    res = "notEndangered";
                }
                return "<span class=" + res + ">" + value + "</span>";
            }
        });
        setFields(pictureItem, commonName, lifeSpan, status);
    }
}
