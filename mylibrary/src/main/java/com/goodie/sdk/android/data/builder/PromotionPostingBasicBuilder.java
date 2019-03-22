package com.goodie.sdk.android.data.builder;

import android.content.Context;

import com.goodie.sdk.android.data.api.GoodieApis;
import com.goodie.sdk.android.data.listener.SetPromotionInquiryBasicListener;
import com.goodie.sdk.android.data.listener.SetPromotionPostingBasicListener;
import com.goodie.sdk.android.data.response.PromoInqBasicResponse;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PromotionPostingBasicBuilder {

    private String authToken;
    private String deviceUniqId;
    private String memberId;
    private String merchantId;
    private String storeId;
    private String productCode;
    private String refNumber;
    private Double totalTrxAmount;

    public PromotionPostingBasicBuilder(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                        String productCode, String refNumber, Double totalTrxAmount){
        this.authToken = authToken;
        this.deviceUniqId = deviceUniqId;
        this.memberId = memberId;
        this.merchantId = merchantId;
        this.storeId = storeId;
        this.productCode = productCode;
        this.refNumber = refNumber;
        this.totalTrxAmount = totalTrxAmount;
    }

    public void promotionPostingBasicGoodie(Context context, SetPromotionPostingBasicListener listener){
        promoPostBasicObserv(authToken, deviceUniqId, memberId, merchantId, storeId, productCode, refNumber, totalTrxAmount, context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onError);
    }

    public Observable<PromoInqBasicResponse> promoPostBasicObserv(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                 String productCode, String refNumber, Double totalTrxAmount, Context context){
        return GoodieApis.getInstance().doPromoPostingBasic(authToken, deviceUniqId, memberId, merchantId, storeId, productCode, refNumber, totalTrxAmount, context);
    }

}
