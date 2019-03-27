package com.goodie.sdk.android.data.bean;

import com.google.gson.annotations.SerializedName;

public class RecordInfoResp {

    @SerializedName("totalRecords")
    private Integer totalRecords;

    @SerializedName("page")
    private Integer page;

    @SerializedName("nRecords")
    private Integer nRecords;

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getnRecords() {
        return nRecords;
    }

    public void setnRecords(Integer nRecords) {
        this.nRecords = nRecords;
    }
}
