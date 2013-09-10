package com.smartgwt.sample.showcase.client.tiling;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.ValueIconMapper;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;

public class CarTile extends DynamicForm {
    
    public CarTile() {
        setOverflow(Overflow.HIDDEN);
        setHeight(140);
        setWidth(200);
        setNumCols(1);

        StaticTextItem pictureItem = new StaticTextItem("picture");
        pictureItem.setShowTitle(false);
        pictureItem.setCanEdit(false);
        pictureItem.setImageURLPrefix("cars/");
        pictureItem.setShowValueIconOnly(true);
        pictureItem.setValueIconHeight(100);
        pictureItem.setValueIconWidth(155);
        pictureItem.setEndRow(true);
        pictureItem.setValueIconMapper(new ValueIconMapper() {
            @Override
            public String getValueIcon(Object value) {
                return String.valueOf(value);
            }
        });

        StaticTextItem name = new StaticTextItem("name");
        name.setShowTitle(false);
        StaticTextItem price = new StaticTextItem("price");
        price.setShowTitle(false);
        setFields(pictureItem, name, price);
    }
}
