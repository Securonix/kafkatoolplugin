package com.securonix.kt.snypr.plugin;

import java.io.IOException;
import java.util.Map;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumReader;
import org.apache.kafka.common.serialization.Deserializer;

public class CustomCountStatsDecoder implements Deserializer<CountStats> {

    public CustomCountStatsDecoder() {

    }

    private final ReflectDatumReader<CountStats> rdr = new ReflectDatumReader<>(ReflectData.AllowNull.get().getSchema(CountStats.class));

    @Override
    public void configure(Map<String, ?> map, boolean bln) {
    }

    @Override
    public CountStats deserialize(String string, byte[] bytes) {
        
        CountStats message = null;
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
