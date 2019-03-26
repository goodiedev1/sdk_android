package com.goodie.sdk.android.data.listener;
import com.goodie.sdk.android.data.response.VoucherUsageResponse;

public interface SetVoucherUsageListener {
    void onSuccess(VoucherUsageResponse voucherUsageResponse);
    void onError(Throwable throwable);
}
