package com.goodie.sdk.android.data.builder;

import android.content.Context;

import com.goodie.sdk.android.data.api.GoodieApis;
import com.goodie.sdk.android.data.bean.RewardsReq;
import com.goodie.sdk.android.data.listener.SetRewardRedeemptionListener;
import com.goodie.sdk.android.data.response.RewardRedemptionResponse;
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RewardRedeemptionBuilder {

    private String authToken;
    private String deviceUniqId;
    private String memberId;
    private String merchantId;
    List<RewardsReq> rewardsReqList;



    public RewardRedeemptionBuilder(String authToken, String deviceUniqId, String memberId, String merchantId, List<RewardsReq> rewardsReqList){

        this.deviceUniqId = deviceUniqId;
        this.authToken = authToken;
        this.memberId = memberId;
        this.merchantId = merchantId;
        this.rewardsReqList = rewardsReqList;
    }


    public void redeemRewardGoodie(Context context, SetRewardRedeemptionListener listener){
        rewardRedeemptionGoodieObserv(authToken, deviceUniqId, memberId, merchantId, rewardsReqList, context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onError);
    }


    public Observable<RewardRedemptionResponse> rewardRedeemptionGoodieObserv(String authToken, String deviceUniqId, String memberId, String merchantId, List<RewardsReq> rewardsReqList, Context context){
        return GoodieApis.getInstance().doRewardRedemtion(authToken, deviceUniqId, memberId, merchantId, rewardsReqList, context);
    }



}
