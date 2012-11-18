package com.smartgwt.client.util;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public class LogicalDate_CustomFieldSerializer extends CustomFieldSerializer<LogicalDate> {

    public static void deserialize(SerializationStreamReader streamReader, LogicalDate instance) {
        /*empty*/
    }

    public static LogicalDate instantiate(SerializationStreamReader streamReader) throws SerializationException {
        return new LogicalDate(streamReader.readLong());
    }

    public static void serialize(SerializationStreamWriter streamWriter, LogicalDate instance) throws SerializationException {
        streamWriter.writeLong(instance.getTime());
    }

    @Override
    public void deserializeInstance(SerializationStreamReader streamReader, LogicalDate instance) throws SerializationException {
        deserialize(streamReader, instance);
    }

    @Override
    public final boolean hasCustomInstantiateInstance() {
        return true;
    }

    @Override
    public LogicalDate instantiateInstance(SerializationStreamReader streamReader) throws SerializationException {
        return instantiate(streamReader);
    }

    @Override
    public void serializeInstance(SerializationStreamWriter streamWriter, LogicalDate instance) throws SerializationException {
        serialize(streamWriter, instance);
    }
}
