package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceImageField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class AnimalXmlDS extends DataSource {

    private static AnimalXmlDS instance = null;

    public static AnimalXmlDS getInstance() {
        if (instance == null) {
            instance = new AnimalXmlDS("animalDS");
        }
        return instance;
    }

    public AnimalXmlDS(String id) {

        setID(id);
        setRecordXPath("/List/Object");
        DataSourceTextField commonNameField = new DataSourceTextField("commonName", "Animal");

        DataSourceTextField scientificName = new DataSourceTextField("scientificName", "Scientific Name");
        scientificName.setRequired(true);
        scientificName.setPrimaryKey(true);

        DataSourceIntegerField lifeSpanField = new DataSourceIntegerField("lifeSpan", "Life Span");

        DataSourceTextField statusField = new DataSourceTextField("status", "Endangered Status");
        statusField.setValueMap("Threatened", "Endangered", "Not Endangered", "Not currently listed",
             "May become threatened","Protected");

        DataSourceTextField dietField = new DataSourceTextField("diet", "Diet");

        DataSourceTextField infoField = new DataSourceTextField("information", "Interesting Facts");
        infoField.setLength(1000);

        DataSourceImageField pictureField = new DataSourceImageField("picture", "Picture");
        pictureField.setImageURLPrefix("animals/");

        setFields(commonNameField, scientificName, lifeSpanField, statusField, dietField, infoField, pictureField);

        setDataURL("ds/test_data/animals.data.xml");
        setClientOnly(true);
    }

    /**
     * Override transformRequest. Here for illustration purposes only and this override implementation simply calls
     * super.transformReRequest
     *
     * @param dsRequest the DSRequest being processed
     * @return the transformed request
     */
    @Override
    protected Object transformRequest(DSRequest dsRequest) {
        return super.transformRequest(dsRequest);
    }
}