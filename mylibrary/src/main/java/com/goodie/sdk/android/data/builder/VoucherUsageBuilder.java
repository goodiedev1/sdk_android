package com.goodie.sdk.android.data.builder;

import android.content.Context;
import com.goodie.sdk.android.data.api.GoodieApis;
import com.goodie.sdk.android.data.listener.SetVoucherUsageListener;
import com.goodie.sdk.android.data.response.VoucherUsageResponse;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VoucherUsageBuilder {

    private String authToken;
    private String deviceUniqId;
    private String memberId;
    private String merchantId;
    private String storeId;
    private String voucherBalanceId;


    public VoucherUsageBuilder(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                   String voucherBalanceId){
        this.deviceUniqId = deviceUniqId;
        this.authToken = authToken;
        this.memberId = memberId;
        this.merchantId = merchantId;
        this.storeId = storeId;
        this.voucherBalanceId = voucherBalanceId;
    }


    public void voucherRedeemGoodie(Context context, SetVoucherUsageListener listener){
        voucherUsageObserv(authToken, deviceUniqId, memberId, merchantId, storeId, voucherBalanceId, context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onError);
    }


    public Observable<VoucherUsageResponse> voucherUsageObserv(String authToken, String deviceUniqId, String memberId, String merchantId, String storeId,
                                                               String voucherBalanceId, Context context){
        return GoodieApis.getInstance().doVoucherUsage(authToken, deviceUniqId, memberId, merchantId, storeId, voucherBalanceId, context);
    }


}
