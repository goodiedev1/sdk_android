package com.goodie.sdk.android.data.builder;

import android.content.Context;

import com.goodie.sdk.android.data.api.GoodieApis;
import com.goodie.sdk.android.data.listener.SetListPointTransactionListener;
import com.goodie.sdk.android.data.response.ListPointTransactionResponse;

import rx.Observable;

/**
 * Created by goodiemac1 on 26/04/19.
 */
public class ListPointTransactionBuilder {

    private String authToken;
    private String deviceUniqueId;
    private String memberId;
    private String merchantId;
    private int trxType;
    private int orderBy;
    private int orderType;
    private int nRecords;
    private int page;

    public ListPointTransactionBuilder(String authToken, String deviceUniqueId, String memberId, String merchantId,
                                       int trxType, int orderBy, int orderType, int nRecords, int page){


        this.authToken = authToken;
        this.deviceUniqueId = deviceUniqueId;
        this.memberId = memberId;
        this.merchantId = merchantId;
        this.trxType = trxType;
        this.orderBy = orderBy;
        this.orderType = orderType;
        this.nRecords = nRecords;
        this.page = page;

    }

    public void historyPointGoodie(Context context, SetListPointTransactionListener listener) {


    }

    public Observable<ListPointTransactionResponse> historyPointObserv(String authToken, String deviceUniqueId, String memberId, String merchantId,
                                                                       int trxType, int orderBy, int orderType, int nRecords, int page, Context context) {

        return GoodieApis.getInstance().getListPointHistory(authToken, deviceUniqueId, memberId, merchantId,
                                                            trxType, orderBy, orderType, nRecords, page, context);
    }


}
