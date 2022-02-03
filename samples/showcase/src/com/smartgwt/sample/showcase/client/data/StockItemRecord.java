package com.smartgwt.sample.showcase.client.data;

import java.util.Date;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class StockItemRecord extends ListGridRecord {

    public StockItemRecord() {
    }

    public StockItemRecord(int itemID, String stockCode, String description, float price, int quantity) {
        setItemID(itemID);
        setStockCode(stockCode);
        setDescription(description);
        setPrice(price);
        setQuantity(quantity);
    }

    /**
     * Set the itemID.
     *
     * @param itemID the itemID
     */
    public void setItemID(int itemID) {
        setAttribute("itemID", itemID);
    }

    /**
     * Return the itemID.
     *
     * @return the itemID
     */
    public int getItemID() {
        return getAttributeAsInt("itemID");
    }


    /**
     * Set the stockCode.
     *
     * @param stockCode the stockCode
     */
    public void setStockCode(String stockCode) {
        setAttribute("stockCode", stockCode);
    }

    /**
     * Return the stockCode.
     *
     * @return the stockCode
     */
    public String getStockCode() {
        return getAttribute("stockCode");
    }

    /**
     * Set the description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        setAttribute("description", description);
    }

    /**
     * Return the description.
     *
     * @return the description
     */
    public String getDescription() {
        return getAttribute("description");
    }

    /**
     * Set the price.
     *
     * @param price the price
     */
    public void setPrice(Float price) {
        setAttribute("price", price);
    }

    /**
     * Return the price.
     *
     * @return the price
     */
    public Float getPrice() {
        return getAttributeAsFloat("price");
    }

    /**
     * Set the quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        setAttribute("quantity", quantity);
    }

    /**
     * Return the quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return getAttributeAsInt("quantity");
    }

}
