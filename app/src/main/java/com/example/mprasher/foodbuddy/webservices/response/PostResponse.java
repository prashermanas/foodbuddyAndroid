
package com.example.mprasher.foodbuddy.webservices.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostResponse {

    @SerializedName("took")
    @Expose
    private Integer took;
    @SerializedName("timed_out")
    @Expose
    private Boolean timedOut;
    @SerializedName("_shards")
    @Expose
    private Shards shards;
    @SerializedName("hits")
    @Expose
    private Hits hits;

    /**
     * 
     * @return
     *     The took
     */
    public Integer getTook() {
        return took;
    }

    /**
     * 
     * @param took
     *     The took
     */
    public void setTook(Integer took) {
        this.took = took;
    }

    /**
     * 
     * @return
     *     The timedOut
     */
    public Boolean getTimedOut() {
        return timedOut;
    }

    /**
     * 
     * @param timedOut
     *     The timed_out
     */
    public void setTimedOut(Boolean timedOut) {
        this.timedOut = timedOut;
    }

    /**
     * 
     * @return
     *     The shards
     */
    public Shards getShards() {
        return shards;
    }

    /**
     * 
     * @param shards
     *     The _shards
     */
    public void setShards(Shards shards) {
        this.shards = shards;
    }

    /**
     * 
     * @return
     *     The hits
     */
    public Hits getHits() {
        return hits;
    }

    /**
     * 
     * @param hits
     *     The hits
     */
    public void setHits(Hits hits) {
        this.hits = hits;
    }

}
