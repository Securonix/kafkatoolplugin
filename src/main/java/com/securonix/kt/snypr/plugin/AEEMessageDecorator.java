package com.securonix.kt.snypr.plugin;

import com.kafkatool.external.ICustomMessageDecorator;
import java.util.Map;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.reflect.ReflectDatumReader;

/**
 *
 * @author Securonix Inc.
 */
public class AEEMessageDecorator implements ICustomMessageDecorator {

    @Override
    public String getDisplayName() {
        return "AEE";
    }

    private final ReflectDatumReader<AEEMessage> rdr = new ReflectDatumReader<>(AEEMessage.class);

    @Override
    public String decorate(String zookeeperHost, String brokerHost, String topic, long partitionId, long offset, byte[] msg, Map<String, String> reserved) {

        String output;
        try {
            final AEEMessage message = rdr.read(null, DecoderFactory.get().binaryDecoder(msg, null));
            output = EventCompressor.uncompressString(message.getBytes(), "gzip");
        } catch (Exception ex) {
            output = "Error: " + ex.getMessage();
        }

        return output;
    }

}
