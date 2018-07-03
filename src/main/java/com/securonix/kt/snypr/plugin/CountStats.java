package com.securonix.kt.snypr.plugin;

import java.io.Serializable;
import java.util.Map;

public class CountStats implements Serializable {

    /**
     * Submission time
     */
    private long time;
    /**
     * Source like IEE, EN, INDEXER, etc. (from CountStatsConstants)
     */
    private String source;
    /**
     * Counts map
     */
    private Map<String, Map<String, Counter>> counts;
    /**
     * Job Id, required to map flag to job Id
     */
    private long jobId;
    /**
     * Flag - BOF / ERROR / EOF
     */
    private String flag = "COUNTS";

    /**
     * Saves the connection Type for all jobs
     */
    private String connectiontype;

    /**
     * Saves the connection name for all jobs
     */
    private String connectionname;

    private String tenantId;

    public CountStats() {
    }

    public CountStats(final long time, final String source, final Map<String, Map<String, Counter>> counts) {
        this.time = time;
        this.source = source;
        this.counts = counts;
    }

    public CountStats(long time, String source, Map<String, Map<String, Counter>> counts, long jobId, String connectiontype, String connectionname) {
        this.time = time;
        this.source = source;
        this.counts = counts;
        this.jobId = jobId;
        this.connectiontype = connectiontype;
        this.connectionname = connectionname;
    }

    public CountStats(long time, String source, Map<String, Map<String, Counter>> counts, long jobId, String connectiontype, String connectionname, String tenantId) {
        this.time = time;
        this.source = source;
        this.counts = counts;
        this.jobId = jobId;
        this.connectiontype = connectiontype;
        this.connectionname = connectionname;
        this.tenantId = tenantId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Map<String, Map<String, Counter>> getCounts() {
        return counts;
    }

    public void setCounts(Map<String, Map<String, Counter>> counts) {
        this.counts = counts;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getConnectiontype() {
        return connectiontype;
    }

    public void setConnectiontype(String connectiontype) {
        this.connectiontype = connectiontype;
    }

    public String getConnectionname() {
        return connectionname;
    }

    public void setConnectionname(String connectionname) {
        this.connectionname = connectionname;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

}
