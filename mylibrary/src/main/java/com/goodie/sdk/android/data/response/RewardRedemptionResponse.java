package com.goodie.sdk.android.data.response;

import com.goodie.sdk.android.data.bean.PromotionNumberIssuedResp;
import com.goodie.sdk.android.data.bean.RewardRedemptionResp;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RewardRedemptionResponse extends AbstractResponse {


    @SerializedName("rewardRedemptionResponse")
    @Expose
    private RewardRedemptionResp rewardRedemptionResponse;

    public RewardRedemptionResp getRewardRedemptionResponse() {
        return rewardRedemptionResponse;
    }

    public void setRewardRedemptionResponse(RewardRedemptionResp rewardRedemptionResponse) {
        this.rewardRedemptionResponse = rewardRedemptionResponse;
    }
}
