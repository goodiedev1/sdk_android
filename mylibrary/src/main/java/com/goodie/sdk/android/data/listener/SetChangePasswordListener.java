package com.goodie.sdk.android.data.listener;

import com.goodie.sdk.android.data.response.ChangePasswordResponse;

/**
 * Created by goodiemac1 on 30/04/19.
 */
public interface SetChangePasswordListener {

    void onSuccess(ChangePasswordResponse changePasswordResponse);
    void onError(Throwable throwable);

}
