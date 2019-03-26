package com.goodie.sdk.android.data.request;
import com.goodie.sdk.android.data.bean.RewardsReq;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;



public class RewardRedeemRequest {

    @SerializedName("memberId")
    private String memberId;

    @SerializedName("merchantId")
    private String merchantId;

    @SerializedName("rewards")
    @Expose
    private List<RewardsReq> rewards;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public List<RewardsReq> getRewards() {
        return rewards;
    }

    public void setRewards(List<RewardsReq> rewards) {
        this.rewards = rewards;
    }
}
