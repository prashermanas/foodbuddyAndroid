
package com.example.mprasher.foodbuddy.webservices.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shards {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("successful")
    @Expose
    private Integer successful;
    @SerializedName("failed")
    @Expose
    private Integer failed;

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
     *     The successful
     */
    public Integer getSuccessful() {
        return successful;
    }

    /**
     * 
     * @param successful
     *     The successful
     */
    public void setSuccessful(Integer successful) {
        this.successful = successful;
    }

    /**
     * 
     * @return
     *     The failed
     */
    public Integer getFailed() {
        return failed;
    }

    /**
     * 
     * @param failed
     *     The failed
     */
    public void setFailed(Integer failed) {
        this.failed = failed;
    }

}
