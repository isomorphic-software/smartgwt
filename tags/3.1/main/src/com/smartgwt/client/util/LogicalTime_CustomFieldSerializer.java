package com.smartgwt.client.util;

import com.google.gwt.user.client.rpc.CustomFieldSerializer;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

public class LogicalTime_CustomFieldSerializer extends CustomFieldSerializer<LogicalTime> {

    public static void deserialize(SerializationStreamReader streamReader, LogicalTime instance) {
        /*empty*/
    }

    public static LogicalTime instantiate(SerializationStreamReader streamReader) throws SerializationException {
        return new LogicalTime(streamReader.readLong());
    }

    public static void serialize(SerializationStreamWriter streamWriter, LogicalTime instance) throws SerializationException {
        streamWriter.writeLong(instance.getTime());
    }

    @Override
    public void deserializeInstance(SerializationStreamReader streamReader, LogicalTime instance) throws SerializationException {
        deserialize(streamReader, instance);
    }

    @Override
    public final boolean hasCustomInstantiateInstance() {
        return true;
    }

    @Override
    public LogicalTime instantiateInstance(SerializationStreamReader streamReader) throws SerializationException {
        return instantiate(streamReader);
    }

    @Override
    public void serializeInstance(SerializationStreamWriter streamWriter, LogicalTime instance) throws SerializationException {
        serialize(streamWriter, instance);
    }
}
