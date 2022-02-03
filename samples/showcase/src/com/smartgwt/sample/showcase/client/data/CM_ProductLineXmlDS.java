package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.data.fields.DataSourceBinaryField;

public class CM_ProductLineXmlDS extends DataSource {  
  
    private static CM_ProductLineXmlDS instance = null;  
  
    public static CM_ProductLineXmlDS getInstance() {  
        if (instance == null) {  
            instance = new CM_ProductLineXmlDS("CM_ProductLine");  
        }  
        return instance;  
    }  
  
    public CM_ProductLineXmlDS(String id) {  
    	setID(id);  
        setRecordXPath("/List/Object");  
        DataSourceTextField pkField = new DataSourceTextField("productLine"); 
        pkField.setLength(50); 
        pkField.setHidden(true);  
        pkField.setPrimaryKey(true);  
  
        DataSourceTextField textDescriptionField = new DataSourceTextField("textDescription", "Description", 150); 
        textDescriptionField.setLength(16777216);  
        DataSourceTextField htmlDescriptionField = new DataSourceTextField("htmlDescription", "HTML Description", 150); 
        htmlDescriptionField.setLength(4000);  
        DataSourceBinaryField imageField = new DataSourceBinaryField("image", "Image");
        imageField.setImageWidth(207);
		imageField.setImageHeight(96);

        setFields(pkField, textDescriptionField, htmlDescriptionField, imageField);  
  
        setDataURL("ds/test_data/CM_ProductLine.data.xml");  
        setClientOnly(true);   
    }

}
