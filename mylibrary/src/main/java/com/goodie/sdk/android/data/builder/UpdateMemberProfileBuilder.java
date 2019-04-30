package com.goodie.sdk.android.data.builder;

import android.content.Context;

import com.goodie.sdk.android.data.api.GoodieApis;
import com.goodie.sdk.android.data.listener.SetUpdateMemberProfileListener;
import com.goodie.sdk.android.data.response.UpdateMemberProfileResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by goodiemac1 on 29/04/19.
 */
public class UpdateMemberProfileBuilder {

    private String authToken;
    private String deviceUniqueId;
    private String memberId;
    private String merchantId;

    private String birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;

    public UpdateMemberProfileBuilder(String authToken, String deviceUniqueId, String memberId, String merchantId,
                                      String birthDate, String firstName, String lastName, String gender, String phoneNumber) {

        this.authToken = authToken;
        this.deviceUniqueId = deviceUniqueId;
        this.memberId = memberId;
        this.merchantId = merchantId;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;

    }

    public void updateMemberProfileGoodie(Context context, SetUpdateMemberProfileListener listener) {

        updateMemberProfileObserv(authToken, deviceUniqueId, memberId, merchantId,
                birthDate, firstName, lastName, gender, phoneNumber, context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onError);



    }

    public Observable<UpdateMemberProfileResponse> updateMemberProfileObserv(String authToken, String deviceUniqueId, String memberId, String merchantId,
                                                                             String birthDate, String firstName, String lastName, String gender, String phoneNumber, Context context) {

        return GoodieApis.getInstance().doUpdateMemberProfile(authToken, deviceUniqueId, memberId, merchantId, birthDate,
                                                            firstName, lastName, gender, phoneNumber, context);
    }

}
