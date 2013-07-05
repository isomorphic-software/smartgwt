package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.widgets.form.validator.FloatPrecisionValidator;
import com.smartgwt.client.widgets.form.validator.FloatRangeValidator;

public class ItemSupplyXmlDS extends DataSource {

    private static ItemSupplyXmlDS instance = null;

    public static ItemSupplyXmlDS getInstance() {
        if (instance == null) {
            instance = new ItemSupplyXmlDS("supplyItemDS");
        }
        return instance;
    }

    public ItemSupplyXmlDS(String id) {

        setID(id);
        setRecordXPath("/List/supplyItem");
        DataSourceIntegerField pkField = new DataSourceIntegerField("itemID");
        pkField.setHidden(true);
        pkField.setPrimaryKey(true);

        DataSourceTextField itemNameField = new DataSourceTextField("itemName", "Item", 128, true);
        DataSourceTextField skuField = new DataSourceTextField("SKU", "SKU", 10, true);

        DataSourceTextField descriptionField = new DataSourceTextField("description", "Description", 2000);
        DataSourceTextField categoryField = new DataSourceTextField("category", "Category", 128, true);
        categoryField.setForeignKey("supplyCategoryDS.categoryName");

        DataSourceEnumField unitsField = new DataSourceEnumField("units", "Units", 5);
        unitsField.setValueMap("Roll", "Ea", "Pkt", "Set", "Tube", "Pad", "Ream", "Tin", "Bag", "Ctn", "Box");

        DataSourceFloatField unitCostField = new DataSourceFloatField("unitCost", "Unit Cost", 5);
        FloatRangeValidator rangeValidator = new FloatRangeValidator();
        rangeValidator.setMin(0);
        rangeValidator.setErrorMessage("Please enter a valid (positive) cost");

        FloatPrecisionValidator precisionValidator = new FloatPrecisionValidator();
        precisionValidator.setPrecision(2);
        precisionValidator.setErrorMessage("The maximum allowed precision is 2");

        unitCostField.setValidators(rangeValidator, precisionValidator);

        DataSourceBooleanField inStockField = new DataSourceBooleanField("inStock", "In Stock");

        DataSourceDateField nextShipmentField = new DataSourceDateField("nextShipment", "Next Shipment");

        setFields(pkField, itemNameField, skuField, descriptionField, categoryField, unitsField,
                  unitCostField, inStockField, nextShipmentField);

        setDataURL("ds/test_data/supplyItem.data.xml");
        setClientOnly(true);        
    }
}