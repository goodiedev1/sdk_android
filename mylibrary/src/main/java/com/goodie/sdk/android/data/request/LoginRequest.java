package com.goodie.sdk.android.data.request;
import com.google.gson.annotations.SerializedName;

/**
 * Created by asep.surahman on 07/01/2019.
 */

public class LoginRequest {

    @SerializedName("deviceUniqueId")
    private String deviceUniqueId;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("merchantCode")
    private String merchantCode;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceUniqueId() {
        return deviceUniqueId;
    }

    public void setDeviceUniqueId(String deviceUniqueId) {
        this.deviceUniqueId = deviceUniqueId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    @Override
    public String toString(){
        return
                "LoginReq{" +
                        "password = '" + password + '\'' +
                        ",deviceUniqueId = '" + deviceUniqueId + '\'' +
                        ",merchantId = '" + merchantCode + '\'' +
                        ",username = '" + username + '\'' +
                        "}";
    }

    /*
    {
        "deviceUniqueId": "tokentokenan",
            "username" : "macan3@gmail.com",
            "password" : "password",
            "merchantId" : "5F773EA1-1E66-4F9E-B9C8-E1FA8156AD20"
    }*/
}
