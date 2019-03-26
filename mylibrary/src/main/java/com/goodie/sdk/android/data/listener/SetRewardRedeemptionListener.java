package com.goodie.sdk.android.data.listener;
import com.goodie.sdk.android.data.response.RewardRedemptionResponse;

public interface SetRewardRedeemptionListener {
    void onSuccess(RewardRedemptionResponse rewardRedemtionResponse);
    void onError(Throwable throwable);
}
