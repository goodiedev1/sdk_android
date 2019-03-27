package com.goodie.sdk.android.data.listener;


import com.goodie.sdk.android.data.response.VoucherBalanceResponse;

public interface SetVoucherBalanceListener {

    void onSuccess(VoucherBalanceResponse rewardListResponse);
    void onError(Throwable throwable);

}
