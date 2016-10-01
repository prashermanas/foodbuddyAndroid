
package com.example.mprasher.foodbuddy.webservices.response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hits {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("max_score")
    @Expose
    private Integer maxScore;
    @SerializedName("hits")
    @Expose
    private List<Hit> hits = new ArrayList<Hit>();

    /**
     * 
     * @return
     *     The total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 
     * @return
     *     The maxScore
     */
    public Integer getMaxScore() {
        return maxScore;
    }

    /**
     * 
     * @param maxScore
     *     The max_score
     */
    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    /**
     * 
     * @return
     *     The hits
     */
    public List<Hit> getHits() {
        return hits;
    }

    /**
     * 
     * @param hits
     *     The hits
     */
    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

}
