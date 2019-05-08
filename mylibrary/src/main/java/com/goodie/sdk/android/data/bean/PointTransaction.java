package com.goodie.sdk.android.data.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by goodiemac1 on 26/04/19.
 */
public class PointTransaction {

    @SerializedName("trxType")
    private Integer trxType;

    @SerializedName("issuing")
    @Expose
    private IssuingResp issuing;

    @SerializedName("redeem")
    @Expose
    private RedeemResp redeem;

    public Integer getTrxType() {
        return trxType;
    }

    public void setTrxType(Integer trxType) {
        this.trxType = trxType;
    }

    public IssuingResp getIssuing() {
        return issuing;
    }

    public void setIssuing(IssuingResp issuing) {
        this.issuing = issuing;
    }

    public RedeemResp getRedeem() {
        return redeem;
    }

    public void setRedeem(RedeemResp redeem) {
        this.redeem = redeem;
    }
}
