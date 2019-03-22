package com.goodie.sdk.android.data.builder;
import android.content.Context;
import com.goodie.sdk.android.data.api.GoodieApis;
import com.goodie.sdk.android.data.listener.SetMemberPointListener;
import com.goodie.sdk.android.data.response.MemberPointResponse;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Goodie on 13/02/2019.
 */

public class MemberPointBuilder {

    private String authToken;
    private String deviceUniqId;
    private String memberId;
    private String merchantId;


    public MemberPointBuilder(String authToken, String deviceUniqId, String memberId, String merchantId){
        this.authToken = authToken;
        this.deviceUniqId = deviceUniqId;
        this.memberId = memberId;
        this.merchantId = merchantId;
    }

    public void memberPointGoodie(Context context, SetMemberPointListener listener){
        memberPointObserv(authToken, deviceUniqId, memberId, merchantId, context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onError);
    }

    public Observable<MemberPointResponse> memberPointObserv(String authToken, String deviceUniqId, String memberId, String merchantId, Context context){
        return GoodieApis.getInstance().doMemberPoint(authToken, deviceUniqId, memberId, merchantId, context);
    }


}
