package com.goodie.sdk.android.data.listener;

import com.goodie.sdk.android.data.response.UpdateMemberProfileResponse;

/**
 * Created by goodiemac1 on 29/04/19.
 */
public interface SetUpdateMemberProfileListener {

    void onSuccess(UpdateMemberProfileResponse updateMemberProfileResponse);
    void onError(Throwable throwable);

}
