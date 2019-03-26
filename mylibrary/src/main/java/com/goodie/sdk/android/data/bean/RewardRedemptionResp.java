package com.goodie.sdk.android.data.bean;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.math.BigDecimal;
import java.util.List;

public class RewardRedemptionResp {

    @SerializedName("detailResponses")
    @Expose
    private List<DetailRewardRedeemResp> detailResponses;

    @SerializedName("totalPointUsed")
    private Integer totalPointUsed;

    @SerializedName("currentBalance")
    private BigDecimal currentBalance;

    @SerializedName("transactionIdReference")
    private String transactionIdReference;

    public List<DetailRewardRedeemResp> getDetailResponses() {
        return detailResponses;
    }

    public void setDetailResponses(List<DetailRewardRedeemResp> detailResponses) {
        this.detailResponses = detailResponses;
    }

    public Integer getTotalPointUsed() {
        return totalPointUsed;
    }

    public void setTotalPointUsed(Integer totalPointUsed) {
        this.totalPointUsed = totalPointUsed;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getTransactionIdReference() {
        return transactionIdReference;
    }

    public void setTransactionIdReference(String transactionIdReference) {
        this.transactionIdReference = transactionIdReference;
    }
}
