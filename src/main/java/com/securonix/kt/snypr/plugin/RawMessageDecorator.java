package com.securonix.kt.snypr.plugin;

import com.google.gson.Gson;
import com.kafkatool.external.ICustomMessageDecorator;
import java.util.Map;

public class RawMessageDecorator implements ICustomMessageDecorator {

    @Override
    public String getDisplayName() {
        return "Raw";
    }

    private final CustomAvroDecoder cad = new CustomAvroDecoder();
    private final Gson gson = new Gson();

    @Override
    public String decorate(String zookeeperHost, String brokerHost, String topic, long partitionId, long offset, byte[] msg, Map<String, String> reserved) {

        final RawMessage rm = cad.deserialize(null, msg);
        final RawMessageWrapper rmw = new RawMessageWrapper(rm.getJobId(), rm.getJobStartTime(), rm.getResourcegroupid(), rm.isEncrypted(), rm.isCompressed(), rm.getCompressionType(),
                rm.getExtraInfo(), rm.getTenantId(), rm.getTenantName(), rm.getIngestionNodeId(), rm.getCollectionMethod(), rm.getMediaType(), rm.getCustomField1(), rm.getCustomField2(),
                rm.getCustomField3(), rm.getTenantTz());

        if (rm.isCompressed()) {
            try {
                rmw.setEvents(EventCompressor.uncompress(rm.getMessages(), rm.getCompressionType()));
            } catch (Exception ex) {
                rmw.setError("ERROR UNCOMPRESSING THE MESSAGE! " + ex.getMessage());
            }
        } else {
            rmw.setEvent(rm.getMessage());
        }

        if (rm.getJobId() == 0) {
            rmw.setMessage(rm.getMessage());
        }

        final String output = gson.toJson(rmw);
        return output;
    }

}
