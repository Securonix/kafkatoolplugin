package com.securonix.kt.snypr.plugin;

import com.kafkatool.external.ICustomMessageDecorator;
import java.util.Map;

/**
 *
 * @author Securonix Inc.
 */
public class EEODecorator implements ICustomMessageDecorator {

    @Override
    public String getDisplayName() {
        return "EEO";
    }

    @Override
    public String decorate(String zookeeperHost, String brokerHost, String topic, long partitionId, long offset, byte[] msg, Map<String, String> reserved) {

        String json = null;
        try {
            json = EventCompressor.uncompressString(msg, "gzip");
        } catch (Exception ex) {
            json = "Error: " + ex.getMessage();
        }
        
        return json;
    }

}
