package com.goodie.sdk.android.data.response;

import com.goodie.sdk.android.data.bean.UpdateMemberProfileResp;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by goodiemac1 on 29/04/19.
 */
public class UpdateMemberProfileResponse extends GenericResponse{

    @SerializedName("member")
    @Expose
    private UpdateMemberProfileResp member;

    public UpdateMemberProfileResp getMember() {
        return member;
    }

    public void setMember(UpdateMemberProfileResp member) {
        this.member = member;
    }
}
