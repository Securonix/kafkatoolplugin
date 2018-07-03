package com.securonix.kt.snypr.plugin;

import java.io.Serializable;
import org.apache.avro.reflect.Nullable;

public class RawMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private long jobId;
    private long jobStartTime;
    private long resourcegroupid;
    private String message = "";
    @Nullable
    private CompressedMessage messages = new CompressedMessage();
    private boolean encrypted;
    private boolean compressed;
    private String compressionType = "";
    private String extraInfo = "";

    private long tenantId = 1L;
    private String tenantName = "Securonix";
    private String ingestionNodeId = "0";
    private String collectionMethod = "";
    private String mediaType = "";
    private String customField1 = "";
    private String customField2 = "";
    private String customField3 = "";

    private String tenantTz = "GMT";

    public RawMessage() {
    }

    public RawMessage(long jobId, long jobStartTime, long resourcegroupid, String message) {
        this.jobId = jobId;
        this.jobStartTime = jobStartTime;
        this.resourcegroupid = resourcegroupid;
        this.message = message;
        this.compressionType = "";
    }

    public RawMessage(long jobId, long jobStartTime, long resourcegroupid, String message,
            byte[] messages, boolean encrypted, boolean compressed, String compressionType, String header) {

        this.jobId = jobId;
        this.jobStartTime = jobStartTime;
        this.resourcegroupid = resourcegroupid;
        this.message = message;
        this.messages.bytes = messages;
        this.encrypted = encrypted;
        this.compressed = compressed;
        this.compressionType = compressionType;
    }

    public RawMessage(long jobId, long jobStartTime, long resourcegroupid, String message, byte[] messages, boolean encrypted, boolean compressed,
            String extraInfo, long tenantId, String tenantName, String ingestionNodeId, String collectionMethod, String mediaType,
            String customField1, String customField2, String customField3, String tz) {

        this.jobId = jobId;
        this.jobStartTime = jobStartTime;
        this.resourcegroupid = resourcegroupid;
        this.message = message;
        this.messages.bytes = messages;
        this.encrypted = encrypted;
        this.compressed = compressed;
        this.extraInfo = extraInfo;
        this.tenantId = tenantId;
        this.tenantName = tenantName;
        this.ingestionNodeId = ingestionNodeId;
        this.collectionMethod = collectionMethod;
        this.mediaType = mediaType;
        this.customField1 = customField1;
        this.customField2 = customField2;
        this.customField3 = customField3;

        if (tz != null) {
            this.tenantTz = tz;
        }
    }

    public long getResourcegroupid() {
        return resourcegroupid;
    }

    public void setResourcegroupid(long resourcegroupid) {
        this.resourcegroupid = resourcegroupid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public long getJobStartTime() {
        return jobStartTime;
    }

    public void setJobStartTime(long jobStartTime) {
        this.jobStartTime = jobStartTime;
    }

    public byte[] getMessages() {
        return messages.bytes;
    }

    public void setMessages(byte[] messages) {
        this.messages.bytes = messages;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encrypted) {
        this.encrypted = encrypted;
    }

    public boolean isCompressed() {
        return compressed;
    }

    public void setCompressed(boolean compressed) {
        this.compressed = compressed;
    }

    public String getCompressionType() {
        return compressionType;
    }

    public void setCompressionType(String compressionType) {
        this.compressionType = compressionType;
    }

    public long getTenantId() {
        return tenantId;
    }

    public void setTenantId(long tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getIngestionNodeId() {
        return ingestionNodeId;
    }

    public void setIngestionNodeId(String ingestionNodeId) {
        this.ingestionNodeId = ingestionNodeId;
    }

    public String getCollectionMethod() {
        return collectionMethod;
    }

    public void setCollectionMethod(String collectionMethod) {
        this.collectionMethod = collectionMethod;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getCustomField1() {
        return customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public String getCustomField2() {
        return customField2;
    }

    public void setCustomField2(String customField2) {
        this.customField2 = customField2;
    }

    public String getCustomField3() {
        return customField3;
    }

    public void setCustomField3(String customField3) {
        this.customField3 = customField3;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getTenantTz() {
        return tenantTz;
    }

    public void setTenantTz(String tenantTz) {
        this.tenantTz = tenantTz;
    }

    @Override
    public String toString() {
        return "RawMessage{" + "jobId=" + jobId + ", jobStartTime=" + jobStartTime + ", resourcegroupid=" + resourcegroupid + ", message=" + message + ", messages=" + messages + ", encrypted=" + encrypted + ", compressed=" + compressed + ", compressionType=" + compressionType + ", extraInfo=" + extraInfo + ", tenantId=" + tenantId + ", tenantName=" + tenantName + ", ingestionNodeId=" + ingestionNodeId + ", collectionMethod=" + collectionMethod + ", mediaType=" + mediaType + ", customField1=" + customField1 + ", customField2=" + customField2 + ", customField3=" + customField3 + '}';
    }

    /**
     * To allow external (non-Java) apps to submit events
     */
    public static class CompressedMessage implements Serializable {
        public byte[] bytes = new byte[0];
    }
}