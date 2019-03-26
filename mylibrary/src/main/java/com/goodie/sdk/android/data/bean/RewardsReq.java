package com.goodie.sdk.android.data.bean;
import com.google.gson.annotations.SerializedName;

public class RewardsReq {

    @SerializedName("rewardId")
    private String rewardId;

    @SerializedName("quantity")
    private Integer quantity;

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
