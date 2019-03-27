package com.goodie.sdk.android.data.builder;

import android.content.Context;
import com.goodie.sdk.android.data.api.GoodieApis;
import com.goodie.sdk.android.data.listener.SetRewardListListener;
import com.goodie.sdk.android.data.response.RewardListResponse;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RewardListBuilder {


    private String authToken;
    private String deviceUniqId;
    private String keyword;
    private String rewardId;
    private String memberId;
    private String merchantId;
    private int orderBy;
    private int orderType;
    private int nRecords;
    private int page;

    public RewardListBuilder(String authToken, String deviceUniqId, String keyword, String rewardId,
                             String memberId, String merchantId, int orderBy, int orderType, int nRecords, int page){
       this.authToken = authToken;
       this.deviceUniqId = deviceUniqId;
       this.keyword = keyword;
       this.rewardId = rewardId;
       this.memberId = memberId;
       this.merchantId = merchantId;
       this.orderBy = orderBy;
       this.orderType = orderType;
       this.nRecords = nRecords;
       this.page = page;
    }

    public void rewardListGoodie(Context context, SetRewardListListener listener){
        rewardListObserv(authToken, deviceUniqId, keyword, rewardId, memberId,  merchantId, orderBy, orderType, nRecords, page, context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onError);
    }

    public Observable<RewardListResponse> rewardListObserv(String authToken, String deviceUniqId, String keyword, String rewardId,
                                                           String memberId, String merchantId, int orderBy, int orderType,
                                                           int nRecords, int page, Context context){
        return GoodieApis.getInstance().doRewardList(authToken, deviceUniqId, keyword, rewardId, memberId, merchantId,
                                                    orderBy, orderType, nRecords, page, context);
    }


}
