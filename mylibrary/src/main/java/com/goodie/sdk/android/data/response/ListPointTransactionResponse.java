package com.goodie.sdk.android.data.response;

import com.goodie.sdk.android.data.bean.IssuingResp;
import com.goodie.sdk.android.data.bean.PointTransaction;
import com.goodie.sdk.android.data.bean.RecordInfoResp;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by goodiemac1 on 26/04/19.
 */
public class ListPointTransactionResponse extends GenericResponse {

    @SerializedName("listPointTransaction")
    @Expose
    private List<PointTransaction> listPointTransaction;

    @SerializedName("recordInfo")
    @Expose
    private RecordInfoResp recordInfo;

    public List<PointTransaction> getListPointTransaction() {
        return listPointTransaction;
    }

    public void setListPointTransaction(List<PointTransaction> listPointTransaction) {
        this.listPointTransaction = listPointTransaction;
    }

    public RecordInfoResp getRecordInfo() {
        return recordInfo;
    }

    public void setRecordInfo(RecordInfoResp recordInfo) {
        this.recordInfo = recordInfo;
    }
}
