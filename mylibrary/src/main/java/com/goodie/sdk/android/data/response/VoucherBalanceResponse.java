package com.goodie.sdk.android.data.response;
import com.goodie.sdk.android.data.bean.RecordInfoResp;
import com.goodie.sdk.android.data.bean.VoucherBalanceResp;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VoucherBalanceResponse extends GenericResponse{

    @SerializedName("listVoucherBalance")
    @Expose
    private List<VoucherBalanceResp> listVoucherbalance;


    @SerializedName("recordInfo")
    @Expose
    private RecordInfoResp recordInfo;


    public List<VoucherBalanceResp> getListVoucherbalance() {
        return listVoucherbalance;
    }

    public void setListVoucherbalance(List<VoucherBalanceResp> listVoucherbalance) {
        this.listVoucherbalance = listVoucherbalance;
    }

    public RecordInfoResp getRecordInfo() {
        return recordInfo;
    }

    public void setRecordInfo(RecordInfoResp recordInfo) {
        this.recordInfo = recordInfo;
    }
}
