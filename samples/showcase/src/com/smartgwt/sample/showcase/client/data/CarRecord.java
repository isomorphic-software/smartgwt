package com.smartgwt.sample.showcase.client.data;

import com.smartgwt.client.widgets.tile.TileRecord;

public class CarRecord extends TileRecord {

    public CarRecord() {
    }

    public CarRecord(String name, String price, String picture) {
        this(name, price, picture, null);
    }

    public CarRecord(String name, String price, String picture, String description) {
        setName(name);
        setPrice(price);
        setPicture(picture);
        setDescription(description);
    }

    /**
     * Set the name.
     *
     * @param name the name
     */
    public void setName(String name) {
        setAttribute("name", name);
    }

    /**
     * Return the name.
     *
     * @return the name
     */
    public String getName() {
        return getAttribute("name");
    }

    /**
     * Set the price.
     *
     * @param price the price
     */
    public void setPrice(String price) {
        setAttribute("price", price);
    }

    /**
     * Return the price.
     *
     * @return the price
     */
    public String getPrice() {
        return getAttribute("price");
    }

    /**
     * Set the picture.
     *
     * @param picture the picture
     */
    public void setPicture(String picture) {
        setAttribute("picture", picture);
    }

    /**
     * Return the picture.
     *
     * @return the picture
     */
    public String getPicture() {
        return getAttribute("picture");
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


}
