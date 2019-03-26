package com.goodie.sdk.android.data.request;
import com.google.gson.annotations.SerializedName;


public class VoucherUsageRequest {

    @SerializedName("memberId")
    private String memberId;

    @SerializedName("merchantId")
    private String merchantId;

    @SerializedName("voucherBalanceId")
    private String voucherBalanceId;

    @SerializedName("storeId")
    private String storeId;

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

    public String getVoucherBalanceId() {
        return voucherBalanceId;
    }

    public void setVoucherBalanceId(String voucherBalanceId) {
        this.voucherBalanceId = voucherBalanceId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
}
