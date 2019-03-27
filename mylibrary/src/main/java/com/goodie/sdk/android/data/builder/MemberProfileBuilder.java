package com.goodie.sdk.android.data.builder;

import android.content.Context;

import com.goodie.sdk.android.data.api.GoodieApis;
import com.goodie.sdk.android.data.listener.SetMemberProfileListener;
import com.goodie.sdk.android.data.response.MemberProfileResponse;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MemberProfileBuilder {


    private String authToken;
    private String deviceUniqId;
    private String memberId;
    private String merchantId;


    public MemberProfileBuilder(String authToken, String deviceUniqId, String memberId, String merchantId){
        this.authToken = authToken;
        this.deviceUniqId = deviceUniqId;
        this.memberId = memberId;
        this.merchantId = merchantId;
    }

    public void memberProfileGoodie(Context context, SetMemberProfileListener listener){
        memberProfileObserv(authToken, deviceUniqId, memberId, merchantId, context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onError);
    }

    public Observable<MemberProfileResponse> memberProfileObserv(String authToken, String deviceUniqId, String memberId, String merchantId, Context context){
        return GoodieApis.getInstance().doMemberProfile(authToken, deviceUniqId, memberId, merchantId, context);
    }


}
