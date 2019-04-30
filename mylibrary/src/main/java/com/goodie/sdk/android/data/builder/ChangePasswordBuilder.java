package com.goodie.sdk.android.data.builder;

import android.content.Context;

import com.goodie.sdk.android.data.api.GoodieApis;
import com.goodie.sdk.android.data.listener.SetChangePasswordListener;
import com.goodie.sdk.android.data.response.ChangePasswordResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by goodiemac1 on 30/04/19.
 */
public class ChangePasswordBuilder {

    private String authToken;
    private String deviceUniqueId;
    private String memberId;
    private String merchantId;

    private String password;
    private String confirmPassword;
    private String passwordOld;
    private String username;

    public ChangePasswordBuilder(String authToken, String deviceUniqueId, String memberId, String merchantId, String password,
                                 String confirmPassword, String passwordOld, String username) {


        this.authToken = authToken;
        this.deviceUniqueId = deviceUniqueId;
        this.memberId = memberId;
        this.merchantId = merchantId;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.passwordOld = passwordOld;
        this.username = username;
    }

    public void changePasswordGoodie(Context context, SetChangePasswordListener listener) {

        changePasswordObserv(authToken, deviceUniqueId, memberId, merchantId, password, confirmPassword, passwordOld, username, context)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onError);
    }



    public Observable<ChangePasswordResponse> changePasswordObserv(String authToken, String deviceUniqueId, String memberId, String merchantId, String password,
                                                                   String confirmPassword, String passwordOld, String username, Context context) {

        return GoodieApis.getInstance().doChangePassword(authToken, deviceUniqueId, memberId, merchantId,
                                                        password, confirmPassword, passwordOld, username, context);
    }

}
