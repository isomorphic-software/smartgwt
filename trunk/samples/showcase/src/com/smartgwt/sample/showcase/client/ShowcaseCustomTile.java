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
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.HoverHTMLCustomizer;

import java.util.Map;
import java.util.HashMap;

public class ShowcaseCustomTile extends SimpleTile {  
    
    private DynamicForm form;
    private String preReleaseVersion = Showcase.getPreReleaseVersion();

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
      betaImage.setSnapTo("TR");
      betaImage.setWidth(119);
      betaImage.setHeight(89);
      betaImage.setHoverStyle("hoverTreeGridCustom");
      betaImage.setShowHover(true);
      betaImage.setCanHover(true);
      betaImage.setHoverHTMLCustomizer(new HoverHTMLCustomizer() {

          @Override
          public String getHoverHTML() {
              String customDiv = "<div style=\"width:200px; " +
                               "margin-top:10px; "+
                               "margin-bottom:10px; "+
                               "margin-left:10px; "+
                               "margin-right:10px;\">";
              return customDiv +
                     (String)form.getValue("description") +
                     "<br><br><span style='color: red;font-size:11px;font-weight: 700;'>BETA</span> : "+
                     "This sample demonstrates features available in the next available version of "+
                     "Smart GWT, " +preReleaseVersion+ ".  To download a " +preReleaseVersion+" SDK, "+
                     "click on \"Pre-release versions\" on the Download page."+
                     "</div>";
          }
			
      });

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
      StaticTextItem descriptionField = new StaticTextItem("description");  
      descriptionField.setVisible(false);
      
      form.setFields(iconField, nameField, descriptionField); 

      addChild(form);
  }

  public void applyRecord() {
      form.setValues(getAttributeAsMap("record")); 
  }
}  
