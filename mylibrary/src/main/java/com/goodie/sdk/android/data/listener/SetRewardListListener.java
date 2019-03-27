package com.goodie.sdk.android.data.listener;

import com.goodie.sdk.android.data.response.RegisterResponse;
import com.goodie.sdk.android.data.response.RewardListResponse;

public interface SetRewardListListener {

    void onSuccess(RewardListResponse rewardListResponse);
    void onError(Throwable throwable);

}
