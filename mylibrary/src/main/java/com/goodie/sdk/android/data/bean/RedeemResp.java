package com.goodie.sdk.android.data.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by goodiemac1 on 26/04/19.
 */
public class RedeemResp {

    @SerializedName("date")
    private String date;

    @SerializedName("rewardName")
    private String rewardName;

    @SerializedName("productName")
    private String productName;

    @SerializedName("quantity")
    private Integer quantity;

    @SerializedName("point")
    private Integer point;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
