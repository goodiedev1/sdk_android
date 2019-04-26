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
    private List<IssuingResp> issuing;

    @SerializedName("redeem")
    @Expose
    private List<RedeemResp> redeem;

    public Integer getTrxType() {
        return trxType;
    }

    public void setTrxType(Integer trxType) {
        this.trxType = trxType;
    }

    public List<IssuingResp> getIssuing() {
        return issuing;
    }

    public void setIssuing(List<IssuingResp> issuing) {
        this.issuing = issuing;
    }

    public List<RedeemResp> getRedeem() {
        return redeem;
    }

    public void setRedeem(List<RedeemResp> redeem) {
        this.redeem = redeem;
    }
}
