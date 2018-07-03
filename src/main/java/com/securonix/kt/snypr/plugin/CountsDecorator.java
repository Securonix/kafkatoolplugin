package com.securonix.kt.snypr.plugin;

import com.google.gson.Gson;
import com.kafkatool.external.ICustomMessageDecorator;
import java.util.Map;

public class CountsDecorator implements ICustomMessageDecorator {

    @Override
    public String getDisplayName() {
        return "Counts";
    }

    private final Gson gson = new Gson();
    private final CustomCountStatsDecoder ccsd = new CustomCountStatsDecoder();

    @Override
    public String decorate(String zookeeperHost, String brokerHost, String topic, long partitionId, long offset, byte[] msg, Map<String, String> reserved) {

        final CountStats cs = ccsd.deserialize(null, msg);
        final String output = gson.toJson(cs);
        return output;
    }

}
