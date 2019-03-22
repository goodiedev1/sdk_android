package com.goodie.sdk.android.data.builder;

import android.content.Context;

import com.goodie.sdk.android.data.api.GoodieApis;
import com.goodie.sdk.android.data.listener.SetPromotionInquiryBasicListener;
import com.goodie.sdk.android.data.response.PromoInqBasicResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PromotionPostingCustomIssuingBuilder {

    private String authToken;
    private String deviceUniqId;
    private String memberId;
    private String merchantId;
    private String storeId;
    private String ruleName;
    private int issuing;
    private int amount;
    private String refNumber;

    public PromotionPostingCustomIssuingBuilder(
            String authToken,
            String deviceUniqId,
            String memberId,
            String merchantId,
            String storeId,
            String ruleName,
            int issuing,
            int amount,
            String refNumber){
        this.authToken = authToken;
        this.deviceUniqId = deviceUniqId;
        this.memberId = memberId;
        this.merchantId = merchantId;
        this.storeId = storeId;
        this.ruleName = ruleName;
        this.issuing = issuing;
        this.amount = amount;
        this.refNumber = refNumber;
    }


    public void promotionPostingCustomIssuingGoodie(Context context, SetPromotionInquiryBasicListener listener){
        promoPostCustomIssuingObserv(authToken, deviceUniqId, memberId, merchantId, storeId, ruleName, issuing, amount, refNumber, context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onError);
    }


    public Observable<PromoInqBasicResponse> promoPostCustomIssuingObserv(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                                         String ruleName, int issuing, int amount, String refNumber, Context context){
        return GoodieApis.getInstance().doPromoPostingCustomIssuing(authToken, deviceUniqId, memberId, merchantId, storeId, ruleName, issuing, amount, refNumber, context);
    }



}
