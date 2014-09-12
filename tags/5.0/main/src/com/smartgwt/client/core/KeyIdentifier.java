package com.smartgwt.client.core;

public class KeyIdentifier extends DataClass {
    /**
     * Set the keyName.
     *
     * @param keyName the keyName
     */
    public void setKeyName(String keyName) {
        setAttribute("keyName", keyName);
    }

    /**
     * Return the keyName.
     * <P>
     * See {@link com.smartgwt.client.docs.KeyName} for an overview of the keyName
     * values returned for each key</smartgwt>
     *
     * @return the keyName
     */
    public String getKeyName() {
        return getAttribute("keyName");
    }

    /**
     * Set the ctrlKey.
     *
     * @param ctrlKey the ctrlKey
     */
    public void setCtrlKey(boolean ctrlKey) {
        setAttribute("ctrlKey", ctrlKey);
    }

    /**
     * Return the ctrlKey.
     *
     * @return the ctrlKey
     */
    public boolean getCtrlKey() {
        return getAttributeAsBoolean("ctrlKey");
    }

    public void setShiftKey(boolean shiftKey) {
        setAttribute("shiftKey", shiftKey);
    }

    public boolean getShiftKey() {
        return getAttributeAsBoolean("shiftKey");
    }

    public void setAltKey(boolean altKey) {
        setAttribute("altKey", altKey);
    }

    public boolean getAltKey() {
        return getAttributeAsBoolean("altKey");
    }

}
