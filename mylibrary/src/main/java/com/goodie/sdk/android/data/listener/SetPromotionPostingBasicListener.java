package com.goodie.sdk.android.data.listener;


import com.goodie.sdk.android.data.response.PromoInqBasicResponse;

public interface SetPromotionPostingBasicListener {
    void onSuccess(PromoInqBasicResponse promoInqBasicResponse);
    void onError(Throwable throwable);
}
