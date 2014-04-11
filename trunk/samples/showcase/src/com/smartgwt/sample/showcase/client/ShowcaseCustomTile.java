package com.smartgwt.sample.showcase.client;

import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.FormItemValueFormatter;
import com.smartgwt.client.widgets.form.ValueIconMapper;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.tile.SimpleTile;

public class ShowcaseCustomTile extends SimpleTile {  
    
    private DynamicForm form;

    public ShowcaseCustomTile() {  
      setOverflow(Overflow.HIDDEN);  

      form = new DynamicForm();
      form.setOverflow(Overflow.HIDDEN);  
      form.setNumCols(1);
      form.setWidth100();
      form.setHeight100();

      StaticTextItem iconField = new StaticTextItem("thumbnail");  
      iconField.setShowTitle(false);  
      iconField.setCanEdit(false);  
      iconField.setShowValueIconOnly(true);  
      iconField.setValueIconHeight(89);  
      iconField.setAlign(Alignment.CENTER);
      iconField.setValueIconWidth(119); 
      iconField.setCellStyle("thumbnail"); 
      iconField.setValueIconMapper(new ValueIconMapper() {  
          @Override  
          public String getValueIcon(Object value) {  
              return String.valueOf(value);  
          }  
      });  
      final Img betaImage = new Img();
      betaImage.setSrc("beta.png");
      betaImage.setSnapTo("TL");
      betaImage.setWidth(100);
      betaImage.setHeight(85);

      StaticTextItem nameField = new StaticTextItem("nodeTitle");  
      nameField.setShowTitle(false);
      nameField.setTextAlign(Alignment.CENTER);
      nameField.setValueFormatter(new FormItemValueFormatter() {
            @Override
            public String formatValue(Object value, Record record, DynamicForm form, FormItem item) {
                if (String.valueOf(value).contains("BETA")) {
                    addChild(betaImage);
                } else {
                    removeChild(betaImage);
                } 
                String newValue = "<div style='font-size:9px;'>" + ((String)value).replaceAll(" BETA", "") + "</div>";
                return newValue;
            }
      });
      
      form.setFields(iconField, nameField); 

      addChild(form);
  }

  public void applyRecord() {
      form.setValues(getAttributeAsMap("record")); 
  }
}  
