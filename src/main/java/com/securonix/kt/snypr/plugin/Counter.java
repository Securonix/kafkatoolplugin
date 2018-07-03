package com.securonix.kt.snypr.plugin;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public class Counter implements Serializable {

    /**
     * To hold available Ids with the job like resource group Id, job Id, etc.
     */
    private Map<String, String> ids;
    private long count;
    private long stTime;

    public Counter() {

    }

    public Counter(final Map<String, String> ids, final long count) {
        this.ids = ids;
        this.count = count;
    }

    public Map<String, String> getIds() {
        return ids;
    }

    public void setIds(Map<String, String> ids) {
        this.ids = ids;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.ids);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Counter other = (Counter) obj;
        if (!Objects.equals(this.ids, other.ids)) {
            return false;
        }
        return true;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void incrementCount() {
        count++;
    }

    public void incrementCount(final long count) {
        this.count += count;
    }

    public String getUniqueCode() {

        String uCode = "";

        if (ids != null) {
            for (Map.Entry<String, String> entry : ids.entrySet()) {
                uCode += (entry.getKey().hashCode() + entry.getValue().hashCode());
            }
        }

        return uCode;
    }

    public long getStTime() {
        return stTime;
    }

    public void setStTime(long stTime) {
        this.stTime = stTime;
    }
    
}
