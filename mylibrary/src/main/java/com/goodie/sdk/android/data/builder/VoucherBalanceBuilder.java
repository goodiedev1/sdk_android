package com.goodie.sdk.android.data.builder;

import android.content.Context;
import com.goodie.sdk.android.data.api.GoodieApis;
import com.goodie.sdk.android.data.listener.SetVoucherBalanceListener;
import com.goodie.sdk.android.data.response.VoucherBalanceResponse;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VoucherBalanceBuilder {

    private String authToken;
    private String deviceUniqId;
    private String voucherBalanceId;
    private String memberId;
    private String merchantId;
    private int orderBy;
    private int orderType;
    private int nRecords;
    private int page;

    public VoucherBalanceBuilder(String authToken, String deviceUniqId, String voucherBalanceId,
                             String memberId, String merchantId, int orderBy, int orderType, int nRecords, int page){
        this.authToken = authToken;
        this.deviceUniqId = deviceUniqId;
        this.voucherBalanceId = voucherBalanceId;
        this.memberId = memberId;
        this.merchantId = merchantId;
        this.orderBy = orderBy;
        this.orderType = orderType;
        this.nRecords = nRecords;
        this.page = page;
    }

    public void memberPointGoodie(Context context, SetVoucherBalanceListener listener){
        voucherBalanceObserv(authToken, deviceUniqId, voucherBalanceId, memberId,  merchantId, orderBy, orderType, nRecords, page, context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onError);
    }

    public Observable<VoucherBalanceResponse> voucherBalanceObserv(String authToken, String deviceUniqId, String voucherBalanceId,
                                                               String memberId, String merchantId, int orderBy, int orderType,
                                                               int nRecords, int page, Context context){
        return GoodieApis.getInstance().doVoucherBalance(authToken, deviceUniqId, voucherBalanceId, memberId, merchantId,
                orderBy, orderType, nRecords, page, context);
    }

}
