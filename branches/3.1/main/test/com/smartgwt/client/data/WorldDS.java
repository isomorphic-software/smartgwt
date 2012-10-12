/*
 * SmartGWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * SmartGWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  SmartGWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */
package com.smartgwt.client.data;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;

public class WorldDS extends DataSource {

    private static WorldDS instance = null;

    public static WorldDS getInstance() {
        if (instance == null) {
            instance = new WorldDS("worldDS");
        }
        return instance;
    }

    public WorldDS(String id) {
        setID(id);
        setRecordXPath("/List/country");
        DataSourceIntegerField pkField = new DataSourceIntegerField("pk");
        pkField.setHidden(true);
        pkField.setPrimaryKey(true);

        DataSourceTextField countryCodeField = new DataSourceTextField("countryCode", "Code");
        countryCodeField.setRequired(true);

        DataSourceTextField countryNameField = new DataSourceTextField("countryName", "Country");
        countryNameField.setRequired(true);

        DataSourceTextField capitalField = new DataSourceTextField("capital", "Capital");
        DataSourceTextField governmentField = new DataSourceTextField("government", "Government", 500);

        DataSourceBooleanField memberG8Field = new DataSourceBooleanField("member_g8", "G8");

        DataSourceTextField continentField = new DataSourceTextField("continent", "Continent");
        continentField.setValueMap("Europe", "Asia", "North America", "Australia/Oceania", "South America", "Africa");

        DataSourceDateField independenceField = new DataSourceDateField("independence", "Nationhood");
        DataSourceFloatField areaField = new DataSourceFloatField("area", "Area (km&sup2;)"); 
        DataSourceIntegerField populationField = new DataSourceIntegerField("population", "Population");
        DataSourceFloatField gdpField = new DataSourceFloatField("gdp", "GDP ($M)");
        DataSourceLinkField articleField = new DataSourceLinkField("article", "Info");

        setFields(pkField, countryCodeField, countryNameField, capitalField, governmentField,
                memberG8Field, continentField, independenceField, areaField, populationField,
                gdpField, articleField);

        setClientOnly(true);
        setTestData(CountryData.getNewRecords());
    }
}