package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceEnumField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class CM_ProductXmlDS extends DataSource {  
  
    private static CM_ProductXmlDS instance = null;  
  
    public static CM_ProductXmlDS getInstance() {  
        if (instance == null) {  
            instance = new CM_ProductXmlDS("CM_Product");  
        }  
        return instance;  
    }  
  
    public CM_ProductXmlDS(String id) {  
    	setID(id);  
        setRecordXPath("/List/Object");  
        DataSourceTextField pkField = new DataSourceTextField("productCode");  
        pkField.setHidden(true);  
        pkField.setLength(15);
        pkField.setPrimaryKey(true);  
  
        DataSourceTextField productNameField = new DataSourceTextField("productName", "Product Name", 50, true);  
        DataSourceTextField productLineField = new DataSourceTextField("productLine", "Product Line", 50, true);
        productLineField.setForeignKey("CM_ProductLine.productLine");
        
        DataSourceEnumField productScaleField = new DataSourceEnumField("productScale", "Product Scale", 25, true);  
        productScaleField.setValueMap("1:10", "1:12", "1:18", "1:24", "1:32", "1:50", "1:72", "1:700");  
        
        DataSourceTextField productVendorField = new DataSourceTextField("productVendor", "Product Vendor", 200, true); 
        productVendorField.setLength(50);
        DataSourceTextField productDescriptionField = new DataSourceTextField("productDescription", "Description", 200, true); 
        productDescriptionField.setLength(4000);
        DataSourceIntegerField quantityInStockField = new DataSourceIntegerField("quantityInStock", "Quantity", 50, true); 
        DataSourceFloatField buyPriceField = new DataSourceFloatField("buyPrice", "Price", 70, true);
        buyPriceField.setDecimalPad(2);
        buyPriceField.setDecimalPrecision(2);
        DataSourceFloatField msrpField = new DataSourceFloatField("msrp", "MSRP", 70, true);
        msrpField.setDecimalPad(2);
        msrpField.setDecimalPrecision(2);

        setFields(pkField, productNameField, productLineField, productScaleField, productVendorField, productDescriptionField, 
                quantityInStockField, buyPriceField, msrpField);  
  
        setDataURL("ds/test_data/CM_Product.data.xml");  
        setClientOnly(true);  
    }

}
