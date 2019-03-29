package com.goodie.sdk.android.data.response;
import com.goodie.sdk.android.data.bean.RecordInfoResp;
import com.goodie.sdk.android.data.bean.RewardObjResp;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RewardListResponse extends GenericResponse{

    @SerializedName("rewards")
    @Expose
    private List<RewardObjResp> rewardList;

    @SerializedName("recordInfo")
    @Expose
    private RecordInfoResp recordInfo;


    public List<RewardObjResp> getRewardList() {
        return rewardList;
    }

    public void setRewardList(List<RewardObjResp> rewardList) {
        this.rewardList = rewardList;
    }

    public RecordInfoResp getRecordInfo() {
        return recordInfo;
    }

    public void setRecordInfo(RecordInfoResp recordInfo) {
        this.recordInfo = recordInfo;
    }
}
