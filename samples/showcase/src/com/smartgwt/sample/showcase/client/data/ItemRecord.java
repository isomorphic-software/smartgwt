package com.smartgwt.sample.showcase.client.data;

import java.util.Date;

import com.smartgwt.client.widgets.grid.ListGridRecord;

public class ItemRecord extends ListGridRecord {

    public ItemRecord() {
    }

    public ItemRecord(int itemID, String item, String sku, String description, String category, String units, Double unitCost, Boolean inStock, Date nextShipment) {
        setItemID(itemID);
        setItemName(item);
        setSKU(sku);
        setDescription(description);
        setCategory(category);
        setUnits(units);
        setUnitCost(unitCost);
        setInStock(inStock);
        setNextShipment(nextShipment);
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
     * Set the item.
     *
     * @param item the item
     */
    public void setItemName(String item) {
        setAttribute("itemName", item);
    }

    /**
     * Return the item.
     *
     * @return the item
     */
    public String getItemName() {
        return getAttribute("itemName");
    }

    /**
     * Set the SKU.
     *
     * @param SKU the SKU
     */
    public void setSKU(String SKU) {
        setAttribute("SKU", SKU);
    }

    /**
     * Return the SKU.
     *
     * @return the SKU
     */
    public String getSKU() {
        return getAttribute("SKU");
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
     * Set the category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        setAttribute("category", category);
    }

    /**
     * Return the category.
     *
     * @return the category
     */
    public String getCategory() {
        return getAttribute("category");
    }

    /**
     * Set the units.
     *
     * @param units the units
     */
    public void setUnits(String units) {
        setAttribute("units", units);
    }

    /**
     * Return the units.
     *
     * @return the units
     */
    public String getUnits() {
        return getAttribute("units");
    }

    /**
     * Set the unitCost.
     *
     * @param unitCost the unitCost
     */
    public void setUnitCost(Double unitCost) {
        setAttribute("unitCost", unitCost);
    }

    /**
     * Return the unitCost.
     *
     * @return the unitCost
     */
    public Float getUnitCost() {
        return getAttributeAsFloat("unitCost");
    }

    /**
     * Set the inStock.
     *
     * @param inStock the inStock
     */
    public void setInStock(Boolean inStock) {
        setAttribute("inStock", inStock);
    }

    /**
     * Return the inStock.
     *
     * @return the inStock
     */
    public Boolean getInStock() {
        return getAttributeAsBoolean("inStock");
    }

    /**
     * Set the nextShipment.
     *
     * @param nextShipment the nextShipment
     */
    public void setNextShipment(Date nextShipment) {
        setAttribute("nextShipment", nextShipment);
    }

    /**
     * Return the nextShipment.
     *
     * @return the nextShipment
     */
    public Date getNextShipment() {
        return getAttributeAsDate("nextShipment");
    }


}
