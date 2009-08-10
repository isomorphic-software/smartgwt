package com.smartgwt.client.data;

import com.smartgwt.client.core.DataClass;

public class SerializationContext extends DataClass {

    /**
     * Set the useFlatFields. Enables flat serialization mode, as described for {@link DSRequest#setUseFlatFields}.
     *
     * @param useFlatFields the useFlatFields
     */
    public void setuseFlatFields(Boolean useFlatFields) {
        setAttribute("useFlatFields", useFlatFields);
    }

    /**
     * Return the useFlatFields.
     *
     * @return the useFlatFields
     */
    public Boolean getuseFlatFields() {
        return getAttributeAsBoolean("useFlatFields");
    }
}
