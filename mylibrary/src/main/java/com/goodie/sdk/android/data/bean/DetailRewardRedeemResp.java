package com.goodie.sdk.android.data.bean;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailRewardRedeemResp {

    @SerializedName("detailResponseId")
    private String detailResponseId;

    @SerializedName("detailResponseMessage")
    private String detailResponseMessage;

    @SerializedName("rewardId")
    private String rewardId;

    @SerializedName("rewardCode")
    private String rewardCode;

    @SerializedName("rewardName")
    private String rewardName;

    @SerializedName("pointUsed")
    private Integer pointUsed;

    @SerializedName("productType")
    private String productType;

    @SerializedName("productTypeDescription")
    private String productTypeDescription;

    @SerializedName("voucher")
    @Expose
    private List<VoucherRedeemResp> voucher;

    public String getDetailResponseId() {
        return detailResponseId;
    }

    public void setDetailResponseId(String detailResponseId) {
        this.detailResponseId = detailResponseId;
    }

    public String getDetailResponseMessage() {
        return detailResponseMessage;
    }

    public void setDetailResponseMessage(String detailResponseMessage) {
        this.detailResponseMessage = detailResponseMessage;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getRewardCode() {
        return rewardCode;
    }

    public void setRewardCode(String rewardCode) {
        this.rewardCode = rewardCode;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public Integer getPointUsed() {
        return pointUsed;
    }

    public void setPointUsed(Integer pointUsed) {
        this.pointUsed = pointUsed;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductTypeDescription() {
        return productTypeDescription;
    }

    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
    }

    public List<VoucherRedeemResp> getVoucher() {
        return voucher;
    }

    public void setVoucher(List<VoucherRedeemResp> voucher) {
        this.voucher = voucher;
    }
}
