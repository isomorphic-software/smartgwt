package com.smartgwt.sample.showcase.client.data;

import java.util.Date;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class CountryRecord extends ListGridRecord {

    public CountryRecord() {
    }

    public CountryRecord(String countryCode, String countryName, String capital, String continent) {
        setCountryCode(countryCode);
        setCountryName(countryName);
        setCapital(capital);
        setContinent(continent);
    }


    public CountryRecord(String countryCode, String countryName, int population) {
        setCountryCode(countryCode);
        setCountryName(countryName);
        setPopulation(population);
    }

    public CountryRecord(String continent, String countryName, String countryCode, int area, int population, double gdp,
                         Date independence, String government, int governmentDesc, String capital, boolean memberG8, String article,
                         String background) {

        setContinent(continent);
        setCountryName(countryName);
        setCountryCode(countryCode);
        setArea(area);
        setPopulation(population);
        setGdp(gdp);
        setIndependence(independence);
        setGovernment(government);
        setGovernmentDesc(governmentDesc);
        setCapital(capital);
        setMemberG8(memberG8);
        setArticle(article);
        setBackground(background);
    }

    public void setContinent(String continent) {
        setAttribute("continent", continent);
    }

    public String getContinent() {
        return getAttributeAsString("continent");
    }

    public void setCountryName(String countryName) {
        setAttribute("countryName", countryName);
    }

    public String getCountryName() {
        return getAttributeAsString("countryName");
    }

    public void setCountryCode(String countryCode) {
        setAttribute("countryCode", countryCode);
    }

    public String getCountryCode() {
        return getAttributeAsString("countryCode");
    }

    public void setArea(int area) {
        setAttribute("area", area);
    }

    public int getArea() {
        return getAttributeAsInt("area");
    }

    public void setPopulation(int population) {
        setAttribute("population", population);
    }

    public int getPopulation() {
        return getAttributeAsInt("population");
    }

    public void setGdp(double gdp) {
        setAttribute("gdp", gdp);
    }

    public double getGdp() {
        return getAttributeAsDouble("gdp");
    }

    public void setIndependence(Date independence) {
        setAttribute("independence", independence);
    }

    public Date getIndependence() {
        return getAttributeAsDate("independence");
    }

    public void setGovernment(String government) {
        setAttribute("government", government);
    }

    public String getGovernment() {
        return getAttributeAsString("government");
    }

    public void setGovernmentDesc(int governmentDesc) {
        setAttribute("government_desc", governmentDesc);
    }

    public int getGovernmentDesc() {
        return getAttributeAsInt("government_desc");
    }

    public void setCapital(String capital) {
        setAttribute("capital", capital);
    }

    public String getCapital() {
        return getAttributeAsString("capital");
    }

    public void setMemberG8(boolean memberG8) {
        setAttribute("member_g8", memberG8);
    }

    public boolean getMemberG8() {
        return getAttributeAsBoolean("member_g8");
    }


    public void setArticle(String article) {
        setAttribute("article", article);
    }

    public String getArticle() {
        return getAttributeAsString("article");
    }

    public void setBackground(String background) {
        setAttribute("background", background);
    }

    public String getBackground() {
        return getAttributeAsString("background");
    }

    public String getFieldValue(String field) {
        return getAttributeAsString(field);
    }
}
