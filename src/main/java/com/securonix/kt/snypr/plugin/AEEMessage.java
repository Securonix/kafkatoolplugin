package com.securonix.kt.snypr.plugin;

import java.io.Serializable;

public class AEEMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private byte[] bytes = new byte[0];
    private long policyId;

    public AEEMessage() {

    }

    public AEEMessage(final long policyId, final byte[] bytes) {
        this.policyId = policyId;
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(long policyId) {
        this.policyId = policyId;
    }

}
