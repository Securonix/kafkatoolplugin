package com.securonix.kt.snypr.plugin;

import java.io.IOException;
import java.util.Map;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.reflect.ReflectDatumReader;
import org.apache.kafka.common.serialization.Deserializer;

public class CustomAvroDecoder implements Deserializer<RawMessage> {

    @Override
    public void configure(Map<String, ?> map, boolean bln) {
        
    }

    private final ReflectDatumReader<RawMessage> rdr = new ReflectDatumReader<>(RawMessage.class);

    @Override
    public RawMessage deserialize(String string, byte[] bytes) {

        RawMessage message = null;
        try {
            message = rdr.read(null, DecoderFactory.get().binaryDecoder(bytes, null));
        } catch (IOException ex) {
            // ignore
        }

        return message;
    }

    @Override
    public void close() {
    }

}