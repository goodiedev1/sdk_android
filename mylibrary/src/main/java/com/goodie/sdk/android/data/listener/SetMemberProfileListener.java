package com.goodie.sdk.android.data.listener;
import com.goodie.sdk.android.data.response.MemberProfileResponse;

public interface SetMemberProfileListener {
    void onSuccess(MemberProfileResponse memberProfileResponse);
    void onError(Throwable throwable);

}
