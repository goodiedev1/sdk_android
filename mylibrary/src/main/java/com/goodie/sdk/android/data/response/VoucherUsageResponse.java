package com.goodie.sdk.android.data.response;

import com.google.gson.annotations.SerializedName;

public class VoucherUsageResponse extends GenericResponse{

    @SerializedName("memberId")
    private String memberId;

    @SerializedName("merchantId")
    private String merchantId;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }
}
