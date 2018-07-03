package com.securonix.kt.snypr.plugin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Securonix Inc.
 */
public class RawMessageWrapper {

    private long jobId;
    private long jobStartTime;
    private long resourceGroupId;
    private boolean encrypted;
    private boolean compressed;
    private String compressionType;
    private String extraInfo;

    private long tenantId;
    private String tenantName;
    private String ingestionNodeId;
    private String collectionMethod;
    private String mediaType;
    private String customField1;
    private String customField2;
    private String customField3;

    private String tenantTz;
    private long totalEvents;
    private List<String> events;
    private String error;
    private String message;

    public RawMessageWrapper(long jobId, long jobStartTime, long resourceGroupId, boolean encrypted, boolean compressed, String compressionType, String extraInfo,
            long tenantId, String tenantName, String ingestionNodeId, String collectionMethod, String mediaType, String customField1, String customField2, String customField3,
            String tenantTz) {

        this.jobId = jobId;
        this.jobStartTime = jobStartTime;
        this.resourceGroupId = resourceGroupId;
        this.encrypted = encrypted;
        this.compressed = compressed;
        if (compressed) {
            this.compressionType = compressionType;
        }
        if (!extraInfo.isEmpty()) {
            this.extraInfo = extraInfo;
        }
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        if (!ingestionNodeId.isEmpty()) {
            this.ingestionNodeId = ingestionNodeId;
        }
        if (!collectionMethod.isEmpty()) {
            this.collectionMethod = collectionMethod;
        }
        if (!mediaType.isEmpty()) {
            this.mediaType = mediaType;
        }
        if (!customField1.isEmpty()) {
            this.customField1 = customField1;
        }
        if (!customField2.isEmpty()) {
            this.customField2 = customField2;
        }
        if (!customField3.isEmpty()) {
            this.customField3 = customField3;
        }
        this.tenantTz = tenantTz;
    }

    public long getJobId() {
        return jobId;
    }

    public long getJobStartTime() {
        return jobStartTime;
    }

    public long getResourceGroupId() {
        return resourceGroupId;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public boolean isCompressed() {
        return compressed;
    }

    public String getCompressionType() {
        return compressionType;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public long getTenantId() {
        return tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public String getIngestionNodeId() {
        return ingestionNodeId;
    }

    public String getCollectionMethod() {
        return collectionMethod;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getCustomField1() {
        return customField1;
    }

    public String getCustomField2() {
        return customField2;
    }

    public String getCustomField3() {
        return customField3;
    }

    public String getTenantTz() {
        return tenantTz;
    }

    public List<String> getEvents() {
        return events;
    }

    public long getTotalEvents() {
        return totalEvents;
    }

    public void setEvents(List<String> events) {
        this.events = events;
        this.totalEvents = events.size();
    }

    public void setEvent(final String event) {
        this.events = new ArrayList<String>() {
            {
                if (event != null) {
                    add(event);
                }
            }
        };
        this.totalEvents = events.size();
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
