package com.goodie.sdk.android.data.listener;

import com.goodie.sdk.android.data.response.ListPointTransactionResponse;

/**
 * Created by goodiemac1 on 26/04/19.
 */
public interface SetListPointTransactionListener {

    void onSuccess(ListPointTransactionResponse listPointTransactionResponse);
    void onError(Throwable throwable);

}
